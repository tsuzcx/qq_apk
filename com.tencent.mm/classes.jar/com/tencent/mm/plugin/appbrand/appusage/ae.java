package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.at;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class ae
  extends at
{
  public final String getTag()
  {
    return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(44648);
    if (uQ(paramInt))
    {
      ar.a locala = ar.a.Vmq;
      h.aHG().aHp().set(locala, Boolean.FALSE);
    }
    AppMethodBeat.o(44648);
  }
  
  public final boolean uQ(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ae
 * JD-Core Version:    0.7.0.1
 */