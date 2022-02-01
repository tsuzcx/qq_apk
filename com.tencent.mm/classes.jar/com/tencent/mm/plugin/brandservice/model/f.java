package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public final class f
{
  public static dhb dch()
  {
    AppMethodBeat.i(5569);
    try
    {
      h.baF();
      Object localObject = (String)h.baE().ban().d(67591, null);
      if (localObject != null)
      {
        dhb localdhb = new dhb();
        localObject = ((String)localObject).split(",");
        localdhb.Zyl = Integer.valueOf(localObject[0]).intValue();
        localdhb.Zyo = Integer.valueOf(localObject[1]).intValue();
        localdhb.ZaH = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localdhb.ZaG = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localdhb.ZaH), Float.valueOf(localdhb.ZaG) });
        AppMethodBeat.o(5569);
        return localdhb;
      }
      Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(5569);
      return null;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(5569);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.f
 * JD-Core Version:    0.7.0.1
 */