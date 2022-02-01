package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

public final class f
{
  public static ble bCk()
  {
    AppMethodBeat.i(5569);
    try
    {
      g.afC();
      Object localObject = (String)g.afB().afk().get(67591, null);
      if (localObject != null)
      {
        ble localble = new ble();
        localObject = ((String)localObject).split(",");
        localble.DfE = Integer.valueOf(localObject[0]).intValue();
        localble.DfH = Integer.valueOf(localObject[1]).intValue();
        localble.COJ = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localble.COI = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ad.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localble.COJ), Float.valueOf(localble.COI) });
        AppMethodBeat.o(5569);
        return localble;
      }
      ad.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(5569);
      return null;
    }
    catch (Exception localException)
    {
      ad.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(5569);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.f
 * JD-Core Version:    0.7.0.1
 */