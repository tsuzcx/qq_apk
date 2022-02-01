package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class af
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
  }
  
  public final boolean nP(int paramInt)
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
    if (nP(paramInt))
    {
      ah.a locala = ah.a.GJz;
      g.agR().agA().set(locala, Boolean.FALSE);
    }
    AppMethodBeat.o(44648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.af
 * JD-Core Version:    0.7.0.1
 */