package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

final class a$1
  implements MMToClientEvent.c
{
  public final void aZ(Object paramObject)
  {
    AppMethodBeat.i(131085);
    if ((paramObject instanceof SendDataToMiniProgramFromH5Event))
    {
      Object localObject1 = (SendDataToMiniProgramFromH5Event)paramObject;
      Object localObject2 = ((SendDataToMiniProgramFromH5Event)localObject1).hMk;
      paramObject = ((SendDataToMiniProgramFromH5Event)localObject1).data;
      int i = ((SendDataToMiniProgramFromH5Event)localObject1).hMl;
      if (!bo.isNullOrNil((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.appbrand.a.xL((String)localObject2);
        if ((localObject1 == null) || (!((i)localObject1).mInitialized))
        {
          AppMethodBeat.o(131085);
          return;
        }
        try
        {
          paramObject = new JSONObject().put("data", paramObject).put("webviewId", String.valueOf(i));
          localObject2 = new a();
          ((a)localObject2).i(((o)localObject1).atU()).BM(paramObject.toString());
          ((a)localObject2).aBz();
          AppMethodBeat.o(131085);
          return;
        }
        catch (Exception paramObject)
        {
          ab.e("MicroMsg.AppBrand.EventOnH5Data", "dispatch ex = %s", new Object[] { paramObject });
        }
      }
    }
    AppMethodBeat.o(131085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.1
 * JD-Core Version:    0.7.0.1
 */