package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.m.k.c;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class k
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  private k.c hTS;
  private boolean hTW = false;
  private boolean hTX = false;
  
  public k(k.c paramc)
  {
    this.hTS = paramc;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(108076);
    ab.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null", null));
      ab.e("MicroMsg.JsApiOperateSocketTask", "data is null");
      AppMethodBeat.o(108076);
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      paramc.h(paramInt, j("fail:taskId is null or nil", null));
      AppMethodBeat.o(108076);
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (bo.isNullOrNil(str2))
    {
      ab.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      paramc.h(paramInt, j("fail:operationType is null or nil", null));
      AppMethodBeat.o(108076);
      return;
    }
    d locald = l.aIp().DZ(paramc.getAppId());
    if (locald == null)
    {
      paramc.h(paramInt, j("fail:no task", null));
      ab.w("MicroMsg.JsApiOperateSocketTask", "client is null");
      AppMethodBeat.o(108076);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = locald.CX(str1);
    if (locale == null)
    {
      paramc.h(paramInt, j("fail:taskID not exist", null));
      ab.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
      AppMethodBeat.o(108076);
      return;
    }
    if (str2.equals("close"))
    {
      int i = paramJSONObject.optInt("code", 1000);
      if ((i != 1000) && ((i < 3000) || (i >= 5000)))
      {
        paramc.h(paramInt, j("fail:The code must be either 1000, or between 3000 and 4999", null));
        AppMethodBeat.o(108076);
        return;
      }
      paramJSONObject = paramJSONObject.optString("reason", "");
      locald.a(locale, i, paramJSONObject);
      paramc.h(paramInt, j("ok", null));
      ab.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", new Object[] { str1, Integer.valueOf(i), paramJSONObject });
      AppMethodBeat.o(108076);
      return;
    }
    if (str2.equals("send"))
    {
      if (!locald.b(locale))
      {
        paramc.h(paramInt, j("fail", null));
        ab.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[] { str1 });
        AppMethodBeat.o(108076);
        return;
      }
      paramJSONObject = paramJSONObject.opt("data");
      if (paramJSONObject != null) {
        try
        {
          if ((paramJSONObject instanceof ByteBuffer))
          {
            ab.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[] { paramJSONObject });
            locald.a(locale, (ByteBuffer)paramJSONObject);
            ((com.tencent.mm.plugin.appbrand.o.a)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          for (;;)
          {
            paramc.h(paramInt, j("ok", null));
            AppMethodBeat.o(108076);
            return;
            if (!(paramJSONObject instanceof String)) {
              break;
            }
            ab.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
            locald.a(locale, (String)paramJSONObject);
            ((com.tencent.mm.plugin.appbrand.o.a)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 4L, 1L, false);
          }
          paramc.h(paramInt, j("fail:message is null or nil", null));
        }
        catch (Exception paramJSONObject)
        {
          paramc.h(paramInt, j("fail:" + paramJSONObject.getMessage(), null));
          if ((this.hTW) || (this.hTX))
          {
            ((com.tencent.mm.plugin.appbrand.o.a)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 6L, 1L, false);
            AppMethodBeat.o(108076);
            return;
            ab.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
            paramc.h(paramInt, j("fail:unknown data", null));
            AppMethodBeat.o(108076);
            return;
          }
          ((com.tencent.mm.plugin.appbrand.o.a)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(972L, 5L, 1L, false);
          AppMethodBeat.o(108076);
          return;
        }
      }
      ab.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      AppMethodBeat.o(108076);
      return;
    }
    paramc.h(paramInt, j("fail:unknown operationType", null));
    ab.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
    AppMethodBeat.o(108076);
  }
  
  public final void g(c paramc)
  {
    AppMethodBeat.i(108077);
    if (this.hTS != null)
    {
      this.hTW = this.hTS.yi(paramc.getAppId());
      this.hTX = this.hTS.auq();
    }
    AppMethodBeat.o(108077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.k
 * JD-Core Version:    0.7.0.1
 */