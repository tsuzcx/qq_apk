package com.tencent.mm.plugin.gallery.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class a
  extends com.tencent.mm.ui.tools.b.a
{
  private String cko;
  public int mSize = 104857600;
  private a sTU;
  
  private a(String paramString)
  {
    this.cko = paramString;
  }
  
  public static a agH(String paramString)
  {
    AppMethodBeat.i(111734);
    paramString = new a(paramString);
    AppMethodBeat.o(111734);
    return paramString;
  }
  
  public final int bcE()
  {
    int i = 10485760;
    AppMethodBeat.i(111735);
    if (bs.isNullOrNil(this.cko)) {
      ac.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
    }
    boolean bool1 = ax.is2G(ai.getContext());
    boolean bool2 = c.FL(this.cko);
    label58:
    double d;
    if (bool2)
    {
      String str = this.cko;
      if (bool1)
      {
        if (!bool1) {
          break label205;
        }
        d = 60000.0D;
        label67:
        i = SightVideoJNI.shouldRemuxingVFS(str, 660, 500, i, d, 1000000);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2) });
      switch (i)
      {
      default: 
        ac.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(111735);
        return 1;
        i = this.mSize;
        break label58;
        label205:
        d = this.mSize;
        break label67;
        int j = (int)i.aSp(this.cko);
        if (bool1) {}
        for (i = 10485760;; i = 26214400)
        {
          if (j <= i) {
            break label249;
          }
          i = -1;
          break;
        }
        label249:
        i = 1;
      }
    }
    AppMethodBeat.o(111735);
    return 0;
    AppMethodBeat.o(111735);
    return 2;
    AppMethodBeat.o(111735);
    return 1;
  }
  
  public final void cNZ()
  {
    AppMethodBeat.i(111736);
    if (this.sTU == null)
    {
      ac.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(111736);
      return;
    }
    bcE();
    AppMethodBeat.o(111736);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.a
 * JD-Core Version:    0.7.0.1
 */