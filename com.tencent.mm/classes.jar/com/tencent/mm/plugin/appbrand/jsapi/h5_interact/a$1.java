package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class a$1
  implements MMToClientEvent.c
{
  public final void aG(Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramObject instanceof SendDataToMiniProgramFromH5Event))
    {
      localObject1 = (SendDataToMiniProgramFromH5Event)paramObject;
      localObject2 = ((SendDataToMiniProgramFromH5Event)localObject1).gqV;
      paramObject = ((SendDataToMiniProgramFromH5Event)localObject1).data;
      i = ((SendDataToMiniProgramFromH5Event)localObject1).gqW;
      if (!bk.bl((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.appbrand.a.qn((String)localObject2);
        if ((localObject1 != null) && (((i)localObject1).dNk)) {
          break label54;
        }
      }
    }
    return;
    try
    {
      label54:
      paramObject = new JSONObject().put("data", paramObject).put("webviewId", String.valueOf(i));
      localObject2 = new a();
      ((a)localObject2).d(((n)localObject1).aae()).tL(paramObject.toString());
      ((a)localObject2).dispatch();
      return;
    }
    catch (Exception paramObject)
    {
      y.e("MicroMsg.AppBrand.EventOnH5Data", "dispatch ex = %s", new Object[] { paramObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.1
 * JD-Core Version:    0.7.0.1
 */