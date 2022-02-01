package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class ae
  extends as
{
  public final String getTag()
  {
    return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
  }
  
  public final boolean rT(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt != 0)
    {
      i = 1;
      if (paramInt >= 637927936) {
        break label25;
      }
    }
    label25:
    for (paramInt = j;; paramInt = 0)
    {
      return paramInt & i;
      i = 0;
      break;
    }
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(44648);
    if (rT(paramInt))
    {
      ar.a locala = ar.a.NYq;
      g.aAh().azQ().set(locala, Boolean.FALSE);
    }
    AppMethodBeat.o(44648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ae
 * JD-Core Version:    0.7.0.1
 */