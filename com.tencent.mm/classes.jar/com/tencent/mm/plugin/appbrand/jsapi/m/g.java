package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.o.k.c;
import com.tencent.mm.plugin.appbrand.o.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  private k.c laQ;
  private boolean laU;
  private boolean laV;
  private final AtomicBoolean laW;
  
  public g(k.c paramc)
  {
    AppMethodBeat.i(144243);
    this.laU = false;
    this.laV = false;
    this.laW = new AtomicBoolean(false);
    this.laQ = paramc;
    AppMethodBeat.o(144243);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144244);
    ae.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if ((!this.laW.getAndSet(true)) && (this.laQ != null))
    {
      this.laU = this.laQ.Ln(paramc.getAppId());
      this.laV = this.laQ.aYm();
    }
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ae.e("MicroMsg.JsApiOperateSocketTask", "data is null");
      AppMethodBeat.o(144244);
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (bu.isNullOrNil(str1))
    {
      ae.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      paramc.h(paramInt, e("fail:taskId is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (bu.isNullOrNil(str2))
    {
      ae.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      paramc.h(paramInt, e("fail:operationType is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    d locald = l.btY().TC(paramc.getAppId());
    if (locald == null)
    {
      paramc.h(paramInt, e("fail:no task", null));
      ae.w("MicroMsg.JsApiOperateSocketTask", "client is null");
      AppMethodBeat.o(144244);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = locald.RT(str1);
    if (locale == null)
    {
      paramc.h(paramInt, e("fail:taskID not exist", null));
      ae.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("close"))
    {
      int i = paramJSONObject.optInt("code", 1000);
      if ((i != 1000) && ((i < 3000) || (i >= 5000)))
      {
        paramc.h(paramInt, e("fail:The code must be either 1000, or between 3000 and 4999", null));
        AppMethodBeat.o(144244);
        return;
      }
      paramJSONObject = paramJSONObject.optString("reason", "");
      locald.a(locale, i, paramJSONObject);
      paramc.h(paramInt, e("ok", null));
      ae.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", new Object[] { str1, Integer.valueOf(i), paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("send"))
    {
      if (!locald.b(locale))
      {
        paramc.h(paramInt, e("fail:don't send before socket connected", null));
        ae.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[] { str1 });
        AppMethodBeat.o(144244);
        return;
      }
      paramJSONObject = paramJSONObject.opt("data");
      if (paramJSONObject != null) {
        try
        {
          if ((paramJSONObject instanceof ByteBuffer))
          {
            ae.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[] { paramJSONObject });
            locald.a(locale, (ByteBuffer)paramJSONObject);
            ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          for (;;)
          {
            paramc.h(paramInt, e("ok", null));
            AppMethodBeat.o(144244);
            return;
            if (!(paramJSONObject instanceof String)) {
              break;
            }
            ae.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
            locald.a(locale, (String)paramJSONObject);
            ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          paramc.h(paramInt, e("fail:message is null or nil", null));
        }
        catch (Exception paramJSONObject)
        {
          paramc.h(paramInt, e("fail:" + paramJSONObject.getMessage(), null));
          if ((this.laU) || (this.laV))
          {
            ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 6L, 1L, false);
            AppMethodBeat.o(144244);
            return;
            ae.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
            paramc.h(paramInt, e("fail:unknown data", null));
            AppMethodBeat.o(144244);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(972L, 5L, 1L, false);
          AppMethodBeat.o(144244);
          return;
        }
      }
      ae.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    paramc.h(paramInt, e("fail:unknown operationType", null));
    ae.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
    AppMethodBeat.o(144244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.g
 * JD-Core Version:    0.7.0.1
 */