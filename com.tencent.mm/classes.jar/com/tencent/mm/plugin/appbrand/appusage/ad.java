package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class ad
  extends ai
{
  public final String getTag()
  {
    return "MicroMsg.AppBrand.DuplicateUsageUsernameSetFlagDataTransfer";
  }
  
  public final boolean kv(int paramInt)
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
    AppMethodBeat.i(129715);
    if (kv(paramInt))
    {
      ac.a locala = ac.a.yDm;
      g.RL().Ru().set(locala, Boolean.FALSE);
    }
    AppMethodBeat.o(129715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ad
 * JD-Core Version:    0.7.0.1
 */