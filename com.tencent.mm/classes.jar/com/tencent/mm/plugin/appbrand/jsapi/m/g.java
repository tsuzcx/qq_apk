package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.o.k.c;
import com.tencent.mm.plugin.appbrand.o.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  private k.c kXh;
  private boolean kXl;
  private boolean kXm;
  private final AtomicBoolean kXn;
  
  public g(k.c paramc)
  {
    AppMethodBeat.i(144243);
    this.kXl = false;
    this.kXm = false;
    this.kXn = new AtomicBoolean(false);
    this.kXh = paramc;
    AppMethodBeat.o(144243);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144244);
    ad.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if ((!this.kXn.getAndSet(true)) && (this.kXh != null))
    {
      this.kXl = this.kXh.KN(paramc.getAppId());
      this.kXm = this.kXh.aXT();
    }
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ad.e("MicroMsg.JsApiOperateSocketTask", "data is null");
      AppMethodBeat.o(144244);
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      paramc.h(paramInt, e("fail:taskId is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (bt.isNullOrNil(str2))
    {
      ad.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      paramc.h(paramInt, e("fail:operationType is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    d locald = l.btn().ST(paramc.getAppId());
    if (locald == null)
    {
      paramc.h(paramInt, e("fail:no task", null));
      ad.w("MicroMsg.JsApiOperateSocketTask", "client is null");
      AppMethodBeat.o(144244);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = locald.Rk(str1);
    if (locale == null)
    {
      paramc.h(paramInt, e("fail:taskID not exist", null));
      ad.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
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
      ad.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", new Object[] { str1, Integer.valueOf(i), paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("send"))
    {
      if (!locald.b(locale))
      {
        paramc.h(paramInt, e("fail:don't send before socket connected", null));
        ad.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[] { str1 });
        AppMethodBeat.o(144244);
        return;
      }
      paramJSONObject = paramJSONObject.opt("data");
      if (paramJSONObject != null) {
        try
        {
          if ((paramJSONObject instanceof ByteBuffer))
          {
            ad.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[] { paramJSONObject });
            locald.a(locale, (ByteBuffer)paramJSONObject);
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          for (;;)
          {
            paramc.h(paramInt, e("ok", null));
            AppMethodBeat.o(144244);
            return;
            if (!(paramJSONObject instanceof String)) {
              break;
            }
            ad.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
            locald.a(locale, (String)paramJSONObject);
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          paramc.h(paramInt, e("fail:message is null or nil", null));
        }
        catch (Exception paramJSONObject)
        {
          paramc.h(paramInt, e("fail:" + paramJSONObject.getMessage(), null));
          if ((this.kXl) || (this.kXm))
          {
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 6L, 1L, false);
            AppMethodBeat.o(144244);
            return;
            ad.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
            paramc.h(paramInt, e("fail:unknown data", null));
            AppMethodBeat.o(144244);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 5L, 1L, false);
          AppMethodBeat.o(144244);
          return;
        }
      }
      ad.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    paramc.h(paramInt, e("fail:unknown operationType", null));
    ad.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
    AppMethodBeat.o(144244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.g
 * JD-Core Version:    0.7.0.1
 */