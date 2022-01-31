package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o.k;
import com.tencent.mm.plugin.appbrand.o.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 347;
  public static final String NAME = "operateSocketTask";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null", null));
      y.e("MicroMsg.JsApiOperateSocketTask", "data is null");
      return;
    }
    String str1 = paramJSONObject.optString("socketTaskId");
    if (bk.bl(str1))
    {
      y.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
      paramc.C(paramInt, h("fail:taskId is null or nil", null));
      return;
    }
    String str2 = paramJSONObject.optString("operationType");
    if (bk.bl(str2))
    {
      y.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
      paramc.C(paramInt, h("fail:operationType is null or nil", null));
      return;
    }
    k localk = l.amK().vC(paramc.getAppId());
    if (localk == null)
    {
      paramc.C(paramInt, h("fail:no task", null));
      y.w("MicroMsg.JsApiOperateSocketTask", "client is null");
      return;
    }
    com.tencent.mm.plugin.appbrand.w.a.a locala = localk.vB(str1);
    if (locala == null)
    {
      paramc.C(paramInt, h("fail:taskID not exist", null));
      y.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
      return;
    }
    if (str2.equals("close"))
    {
      int i = paramJSONObject.optInt("code", 1000);
      if ((i != 1000) && ((i < 3000) || (i >= 5000)))
      {
        paramc.C(paramInt, h("fail:The code must be either 1000, or between 3000 and 4999", null));
        return;
      }
      paramJSONObject = paramJSONObject.optString("reason", "");
      if (locala != null) {}
      try
      {
        y.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
        if (locala.hmI != null) {
          locala.S(i, paramJSONObject);
        }
        localk.b(locala);
        paramc.C(paramInt, h("ok", null));
        y.d("MicroMsg.JsApiOperateSocketTask", "closeSocket code %d, reason %s", new Object[] { Integer.valueOf(i), paramJSONObject });
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + localException.toString());
        }
      }
    }
    if (str2.equals("send"))
    {
      if (locala != null) {}
      for (boolean bool = locala.hmD.isOpen(); !bool; bool = false)
      {
        paramc.C(paramInt, h("fail", null));
        y.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[] { localException });
        return;
      }
      paramJSONObject = paramJSONObject.opt("data");
      if (paramJSONObject != null)
      {
        for (;;)
        {
          try
          {
            if ((paramJSONObject instanceof ByteBuffer))
            {
              y.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[] { paramJSONObject });
              locala.q((ByteBuffer)paramJSONObject);
              paramc.C(paramInt, h("ok", null));
              return;
            }
          }
          catch (Exception paramJSONObject)
          {
            paramc.C(paramInt, h("fail:" + paramJSONObject.getMessage(), null));
            return;
          }
          if (!(paramJSONObject instanceof String)) {
            break;
          }
          y.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
          paramJSONObject = (String)paramJSONObject;
          if (locala != null) {
            locala.wO(paramJSONObject);
          }
        }
        y.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
        paramc.C(paramInt, h("fail:unknown data", null));
        return;
      }
      paramc.C(paramInt, h("fail:message is null or nil", null));
      y.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[] { paramJSONObject });
      return;
    }
    paramc.C(paramInt, h("fail:unknown operationType", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.j
 * JD-Core Version:    0.7.0.1
 */