package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.t.j.c;
import com.tencent.mm.plugin.appbrand.t.k;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class h
  extends c
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  private j.c sjC;
  private boolean sjG;
  private boolean sjH;
  private final AtomicBoolean sjI;
  
  public h(j.c paramc)
  {
    AppMethodBeat.i(144243);
    this.sjG = false;
    this.sjH = false;
    this.sjI = new AtomicBoolean(false);
    this.sjC = paramc;
    AppMethodBeat.o(144243);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144244);
    Log.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if ((!this.sjI.getAndSet(true)) && (this.sjC != null))
    {
      this.sjG = this.sjC.UG(paramf.getAppId());
      localObject = this.sjC;
      paramf.getAppId();
      this.sjH = ((j.c)localObject).cdI();
    }
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data is null"));
      Log.e("MicroMsg.JsApiOperateSocketTask", "data is null");
      AppMethodBeat.o(144244);
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      paramf.callback(paramInt, ZP("fail:taskId is null or nil"));
      AppMethodBeat.o(144244);
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      paramf.callback(paramInt, ZP("fail:operationType is null or nil"));
      AppMethodBeat.o(144244);
      return;
    }
    Object localObject = k.cCp().aeh(paramf.getAppId());
    if (localObject == null)
    {
      paramf.callback(paramInt, ZP("fail:no task"));
      Log.w("MicroMsg.JsApiOperateSocketTask", "client is null");
      AppMethodBeat.o(144244);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = ((d)localObject).act(str1);
    if (locale == null)
    {
      paramf.callback(paramInt, ZP("fail:taskID not exist"));
      Log.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("close"))
    {
      int i = paramJSONObject.optInt("code", 1000);
      if ((i != 1000) && ((i < 3000) || (i >= 5000)))
      {
        paramf.callback(paramInt, ZP("fail:The code must be either 1000, or between 3000 and 4999"));
        AppMethodBeat.o(144244);
        return;
      }
      paramJSONObject = paramJSONObject.optString("reason", "");
      ((d)localObject).a(locale, i, paramJSONObject);
      paramf.callback(paramInt, ZP("ok"));
      Log.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", new Object[] { str1, Integer.valueOf(i), paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("send"))
    {
      if (!((d)localObject).b(locale))
      {
        paramf.callback(paramInt, ZP("fail:don't send before socket connected"));
        Log.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[] { str1 });
        AppMethodBeat.o(144244);
        return;
      }
      paramJSONObject = paramJSONObject.opt("data");
      if (paramJSONObject != null) {
        try
        {
          if ((paramJSONObject instanceof ByteBuffer))
          {
            Log.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[] { paramJSONObject });
            ((d)localObject).a(locale, (ByteBuffer)paramJSONObject);
            ((a)com.tencent.luggage.a.e.U(a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          for (;;)
          {
            paramf.callback(paramInt, ZP("ok"));
            AppMethodBeat.o(144244);
            return;
            if (!(paramJSONObject instanceof String)) {
              break;
            }
            Log.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
            ((d)localObject).a(locale, (String)paramJSONObject);
            ((a)com.tencent.luggage.a.e.U(a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          paramf.callback(paramInt, ZP("fail:message is null or nil"));
        }
        catch (Exception paramJSONObject)
        {
          paramf.callback(paramInt, ZP("fail:" + paramJSONObject.getMessage()));
          if ((this.sjG) || (this.sjH))
          {
            ((a)com.tencent.luggage.a.e.U(a.class)).idkeyStat(972L, 6L, 1L, false);
            AppMethodBeat.o(144244);
            return;
            Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
            paramf.callback(paramInt, ZP("fail:unknown data"));
            AppMethodBeat.o(144244);
            return;
          }
          ((a)com.tencent.luggage.a.e.U(a.class)).idkeyStat(972L, 5L, 1L, false);
          AppMethodBeat.o(144244);
          return;
        }
      }
      Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    paramf.callback(paramInt, ZP("fail:unknown operationType"));
    Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
    AppMethodBeat.o(144244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.h
 * JD-Core Version:    0.7.0.1
 */