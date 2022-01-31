package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class c$7$1
  implements Runnable
{
  c$7$1(c.7 param7, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(16476);
    ao.b.a locala2 = (ao.b.a)this.fDa.fCU.fCM.remove(this.cat);
    if (bo.isNullOrNil(this.fCY)) {}
    for (ao.b.a locala1 = null;; locala1 = (ao.b.a)this.fDa.fCU.fCM.remove(this.fCY))
    {
      if (locala2 != null) {
        locala2.p(this.cat, this.fCZ);
      }
      if ((locala1 != null) && (!bo.isNullOrNil(this.fCY))) {
        locala1.p(this.fCY, this.fCZ);
      }
      AppMethodBeat.o(16476);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ar.c.7.1
 * JD-Core Version:    0.7.0.1
 */