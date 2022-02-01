package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.p.k.c;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  private k.c kBa;
  private boolean kBe;
  private boolean kBf;
  private final AtomicBoolean kBg;
  
  public i(k.c paramc)
  {
    AppMethodBeat.i(144243);
    this.kBe = false;
    this.kBf = false;
    this.kBg = new AtomicBoolean(false);
    this.kBa = paramc;
    AppMethodBeat.o(144243);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144244);
    ac.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if ((!this.kBg.getAndSet(true)) && (this.kBa != null))
    {
      this.kBe = this.kBa.HA(paramc.getAppId());
      this.kBf = this.kBa.aUH();
    }
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null", null));
      ac.e("MicroMsg.JsApiOperateSocketTask", "data is null");
      AppMethodBeat.o(144244);
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (bs.isNullOrNil(str1))
    {
      ac.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      paramc.h(paramInt, e("fail:taskId is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (bs.isNullOrNil(str2))
    {
      ac.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      paramc.h(paramInt, e("fail:operationType is null or nil", null));
      AppMethodBeat.o(144244);
      return;
    }
    d locald = l.bpo().Pq(paramc.getAppId());
    if (locald == null)
    {
      paramc.h(paramInt, e("fail:no task", null));
      ac.w("MicroMsg.JsApiOperateSocketTask", "client is null");
      AppMethodBeat.o(144244);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = locald.NL(str1);
    if (locale == null)
    {
      paramc.h(paramInt, e("fail:taskID not exist", null));
      ac.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
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
      ac.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", new Object[] { str1, Integer.valueOf(i), paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    if (str2.equals("send"))
    {
      if (!locald.b(locale))
      {
        paramc.h(paramInt, e("fail:don't send before socket connected", null));
        ac.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[] { str1 });
        AppMethodBeat.o(144244);
        return;
      }
      paramJSONObject = paramJSONObject.opt("data");
      if (paramJSONObject != null) {
        try
        {
          if ((paramJSONObject instanceof ByteBuffer))
          {
            ac.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[] { paramJSONObject });
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
            ac.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
            locald.a(locale, (String)paramJSONObject);
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          paramc.h(paramInt, e("fail:message is null or nil", null));
        }
        catch (Exception paramJSONObject)
        {
          paramc.h(paramInt, e("fail:" + paramJSONObject.getMessage(), null));
          if ((this.kBe) || (this.kBf))
          {
            ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 6L, 1L, false);
            AppMethodBeat.o(144244);
            return;
            ac.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
            paramc.h(paramInt, e("fail:unknown data", null));
            AppMethodBeat.o(144244);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(972L, 5L, 1L, false);
          AppMethodBeat.o(144244);
          return;
        }
      }
      ac.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(144244);
      return;
    }
    paramc.h(paramInt, e("fail:unknown operationType", null));
    ac.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
    AppMethodBeat.o(144244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.i
 * JD-Core Version:    0.7.0.1
 */