package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class e
{
  public static buh bOD()
  {
    AppMethodBeat.i(5569);
    try
    {
      g.ajS();
      Object localObject = (String)g.ajR().ajA().get(67591, null);
      if (localObject != null)
      {
        buh localbuh = new buh();
        localObject = ((String)localObject).split(",");
        localbuh.Gzf = Integer.valueOf(localObject[0]).intValue();
        localbuh.Gzi = Integer.valueOf(localObject[1]).intValue();
        localbuh.Gha = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localbuh.GgZ = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ae.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localbuh.Gha), Float.valueOf(localbuh.GgZ) });
        AppMethodBeat.o(5569);
        return localbuh;
      }
      ae.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(5569);
      return null;
    }
    catch (Exception localException)
    {
      ae.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(5569);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e
 * JD-Core Version:    0.7.0.1
 */