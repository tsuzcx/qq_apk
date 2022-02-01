package com.tencent.mm.plugin.gallery.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class a
  extends com.tencent.mm.ui.tools.b.a
{
  private String cvr;
  public int mSize = 104857600;
  private a ubk;
  
  private a(String paramString)
  {
    this.cvr = paramString;
  }
  
  public static a amc(String paramString)
  {
    AppMethodBeat.i(111734);
    paramString = new a(paramString);
    AppMethodBeat.o(111734);
    return paramString;
  }
  
  public final int bgQ()
  {
    int i = 10485760;
    AppMethodBeat.i(111735);
    if (bu.isNullOrNil(this.cvr)) {
      ae.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
    }
    boolean bool1 = az.is2G(ak.getContext());
    boolean bool2 = c.Jz(this.cvr);
    label58:
    double d;
    if (bool2)
    {
      String str = this.cvr;
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
      ae.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2) });
      switch (i)
      {
      default: 
        ae.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(111735);
        return 1;
        i = this.mSize;
        break label58;
        label205:
        d = this.mSize;
        break label67;
        int j = (int)o.aZR(this.cvr);
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
  
  public final void cYX()
  {
    AppMethodBeat.i(111736);
    if (this.ubk == null)
    {
      ae.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(111736);
      return;
    }
    bgQ();
    AppMethodBeat.o(111736);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.a
 * JD-Core Version:    0.7.0.1
 */