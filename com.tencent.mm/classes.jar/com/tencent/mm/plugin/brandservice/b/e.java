package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

public final class e
{
  public static bpa bJn()
  {
    AppMethodBeat.i(5569);
    try
    {
      g.agS();
      Object localObject = (String)g.agR().agA().get(67591, null);
      if (localObject != null)
      {
        bpa localbpa = new bpa();
        localObject = ((String)localObject).split(",");
        localbpa.EyK = Integer.valueOf(localObject[0]).intValue();
        localbpa.EyN = Integer.valueOf(localObject[1]).intValue();
        localbpa.Ehu = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localbpa.Eht = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        ac.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localbpa.Ehu), Float.valueOf(localbpa.Eht) });
        AppMethodBeat.o(5569);
        return localbpa;
      }
      ac.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
      AppMethodBeat.o(5569);
      return null;
    }
    catch (Exception localException)
    {
      ac.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(5569);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e
 * JD-Core Version:    0.7.0.1
 */