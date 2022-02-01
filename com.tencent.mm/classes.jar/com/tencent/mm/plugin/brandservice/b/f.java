package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cqh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class f
{
  public static cqh czn()
  {
    AppMethodBeat.i(5569);
    try
    {
      h.aHH();
      Object localObject = (String)h.aHG().aHp().b(67591, null);
      if (localObject != null)
      {
        cqh localcqh = new cqh();
        localObject = ((String)localObject).split(",");
        localcqh.Sxt = Integer.valueOf(localObject[0]).intValue();
        localcqh.Sxw = Integer.valueOf(localObject[1]).intValue();
        localcqh.ScP = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localcqh.ScO = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        Log.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localcqh.ScP), Float.valueOf(localcqh.ScO) });
        AppMethodBeat.o(5569);
        return localcqh;
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
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.f
 * JD-Core Version:    0.7.0.1
 */