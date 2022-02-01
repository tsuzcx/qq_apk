package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.s.k.c;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class g
  extends c
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  private k.c pem;
  private boolean peq;
  private boolean per;
  private final AtomicBoolean pes;
  
  public g(k.c paramc)
  {
    AppMethodBeat.i(144243);
    this.peq = false;
    this.per = false;
    this.pes = new AtomicBoolean(false);
    this.pem = paramc;
    AppMethodBeat.o(144243);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144244);
    Log.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if ((!this.pes.getAndSet(true)) && (this.pem != null))
    {
      this.peq = this.pem.acg(parame.getAppId());
      localObject = this.pem;
      parame.getAppId();
      this.per = ((k.c)localObject).bEw();
    }
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.JsApiOperateSocketTask", "data is null");
      AppMethodBeat.o(144244);
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      parame.j(paramInt, h("fail:taskId is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      parame.j(paramInt, h("fail:operationType is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    Object localObject = l.cbW().ala(parame.getAppId());
    if (localObject == null)
    {
      parame.j(paramInt, h("fail:no task", null));
      Log.w("MicroMsg.JsApiOperateSocketTask", "client is null");
      AppMethodBeat.o(144244);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = ((d)localObject).ajs(str1);
    if (locale == null)
    {
      parame.j(paramInt, h("fail:taskID not exist", null));
      Log.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("close"))
    {
      int i = paramJSONObject.optInt("code", 1000);
      if ((i != 1000) && ((i < 3000) || (i >= 5000)))
      {
        parame.j(paramInt, h("fail:The code must be either 1000, or between 3000 and 4999", null));
        AppMethodBeat.o(144244);
        return;
      }
      paramJSONObject = paramJSONObject.optString("reason", "");
      ((d)localObject).a(locale, i, paramJSONObject);
      parame.j(paramInt, h("ok", null));
      Log.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", new Object[] { str1, Integer.valueOf(i), paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("send"))
    {
      if (!((d)localObject).b(locale))
      {
        parame.j(paramInt, h("fail:don't send before socket connected", null));
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
            ((a)com.tencent.luggage.a.e.L(a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          for (;;)
          {
            parame.j(paramInt, h("ok", null));
            AppMethodBeat.o(144244);
            return;
            if (!(paramJSONObject instanceof String)) {
              break;
            }
            Log.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
            ((d)localObject).a(locale, (String)paramJSONObject);
            ((a)com.tencent.luggage.a.e.L(a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          parame.j(paramInt, h("fail:message is null or nil", null));
        }
        catch (Exception paramJSONObject)
        {
          parame.j(paramInt, h("fail:" + paramJSONObject.getMessage(), null));
          if ((this.peq) || (this.per))
          {
            ((a)com.tencent.luggage.a.e.L(a.class)).idkeyStat(972L, 6L, 1L, false);
            AppMethodBeat.o(144244);
            return;
            Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
            parame.j(paramInt, h("fail:unknown data", null));
            AppMethodBeat.o(144244);
            return;
          }
          ((a)com.tencent.luggage.a.e.L(a.class)).idkeyStat(972L, 5L, 1L, false);
          AppMethodBeat.o(144244);
          return;
        }
      }
      Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    parame.j(paramInt, h("fail:unknown operationType", null));
    Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
    AppMethodBeat.o(144244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.g
 * JD-Core Version:    0.7.0.1
 */