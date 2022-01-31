package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class b
{
  public static atp Jx()
  {
    try
    {
      g.DQ();
      Object localObject = (String)g.DP().Dz().get(67591, null);
      if (localObject != null)
      {
        atp localatp = new atp();
        localObject = ((String)localObject).split(",");
        localatp.sUn = Integer.valueOf(localObject[0]).intValue();
        localatp.sUq = Integer.valueOf(localObject[1]).intValue();
        localatp.sGK = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localatp.sGJ = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        y.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localatp.sGK), Float.valueOf(localatp.sGJ) });
        return localatp;
      }
      y.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
      return null;
    }
    catch (Exception localException)
    {
      y.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b
 * JD-Core Version:    0.7.0.1
 */