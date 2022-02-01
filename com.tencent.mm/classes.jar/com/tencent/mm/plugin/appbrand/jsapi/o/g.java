package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.s.k.c;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  private k.c mgf;
  private boolean mgj;
  private boolean mgk;
  private final AtomicBoolean mgl;
  
  public g(k.c paramc)
  {
    AppMethodBeat.i(144243);
    this.mgj = false;
    this.mgk = false;
    this.mgl = new AtomicBoolean(false);
    this.mgf = paramc;
    AppMethodBeat.o(144243);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144244);
    Log.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if ((!this.mgl.getAndSet(true)) && (this.mgf != null))
    {
      this.mgj = this.mgf.Uw(paramf.getAppId());
      localObject = this.mgf;
      paramf.getAppId();
      this.mgk = ((k.c)localObject).btz();
    }
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiOperateSocketTask", "data is null");
      AppMethodBeat.o(144244);
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      paramf.i(paramInt, h("fail:taskId is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      paramf.i(paramInt, h("fail:operationType is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    Object localObject = l.bPF().adh(paramf.getAppId());
    if (localObject == null)
    {
      paramf.i(paramInt, h("fail:no task", null));
      Log.w("MicroMsg.JsApiOperateSocketTask", "client is null");
      AppMethodBeat.o(144244);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)localObject).aby(str1);
    if (locale == null)
    {
      paramf.i(paramInt, h("fail:taskID not exist", null));
      Log.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("close"))
    {
      int i = paramJSONObject.optInt("code", 1000);
      if ((i != 1000) && ((i < 3000) || (i >= 5000)))
      {
        paramf.i(paramInt, h("fail:The code must be either 1000, or between 3000 and 4999", null));
        AppMethodBeat.o(144244);
        return;
      }
      paramJSONObject = paramJSONObject.optString("reason", "");
      ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)localObject).a(locale, i, paramJSONObject);
      paramf.i(paramInt, h("ok", null));
      Log.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", new Object[] { str1, Integer.valueOf(i), paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("send"))
    {
      if (!((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)localObject).b(locale))
      {
        paramf.i(paramInt, h("fail:don't send before socket connected", null));
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
            ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)localObject).a(locale, (ByteBuffer)paramJSONObject);
            ((a)com.tencent.luggage.a.e.N(a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          for (;;)
          {
            paramf.i(paramInt, h("ok", null));
            AppMethodBeat.o(144244);
            return;
            if (!(paramJSONObject instanceof String)) {
              break;
            }
            Log.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
            ((com.tencent.mm.plugin.appbrand.jsapi.websocket.d)localObject).a(locale, (String)paramJSONObject);
            ((a)com.tencent.luggage.a.e.N(a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          paramf.i(paramInt, h("fail:message is null or nil", null));
        }
        catch (Exception paramJSONObject)
        {
          paramf.i(paramInt, h("fail:" + paramJSONObject.getMessage(), null));
          if ((this.mgj) || (this.mgk))
          {
            ((a)com.tencent.luggage.a.e.N(a.class)).idkeyStat(972L, 6L, 1L, false);
            AppMethodBeat.o(144244);
            return;
            Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
            paramf.i(paramInt, h("fail:unknown data", null));
            AppMethodBeat.o(144244);
            return;
          }
          ((a)com.tencent.luggage.a.e.N(a.class)).idkeyStat(972L, 5L, 1L, false);
          AppMethodBeat.o(144244);
          return;
        }
      }
      Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    paramf.i(paramInt, h("fail:unknown operationType", null));
    Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
    AppMethodBeat.o(144244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.g
 * JD-Core Version:    0.7.0.1
 */