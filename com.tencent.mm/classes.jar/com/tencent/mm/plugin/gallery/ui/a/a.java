package com.tencent.mm.plugin.gallery.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends com.tencent.mm.ui.tools.b.a
{
  private String bHM;
  public int mSize = 104857600;
  private a.a nhq;
  
  private a(String paramString)
  {
    this.bHM = paramString;
  }
  
  public static a PK(String paramString)
  {
    AppMethodBeat.i(150913);
    paramString = new a(paramString);
    AppMethodBeat.o(150913);
    return paramString;
  }
  
  public final int azZ()
  {
    int i = 10485760;
    AppMethodBeat.i(150914);
    if (bo.isNullOrNil(this.bHM)) {
      ab.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
    }
    boolean bool1 = at.is2G(ah.getContext());
    boolean bool2 = c.wE(this.bHM);
    label58:
    double d;
    if (bool2)
    {
      String str = this.bHM;
      if (bool1)
      {
        if (!bool1) {
          break label205;
        }
        d = 60000.0D;
        label67:
        i = SightVideoJNI.shouldRemuxing(str, 660, 500, i, d, 1000000);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2) });
      switch (i)
      {
      default: 
        ab.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(150914);
        return 1;
        i = this.mSize;
        break label58;
        label205:
        d = this.mSize;
        break label67;
        int j = e.cM(this.bHM);
        if (bool1) {}
        for (i = 10485760;; i = 26214400)
        {
          if (j <= i) {
            break label248;
          }
          i = -1;
          break;
        }
        label248:
        i = 1;
      }
    }
    AppMethodBeat.o(150914);
    return 0;
    AppMethodBeat.o(150914);
    return 2;
    AppMethodBeat.o(150914);
    return 1;
  }
  
  public final void bEI()
  {
    AppMethodBeat.i(150915);
    if (this.nhq == null)
    {
      ab.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(150915);
      return;
    }
    azZ();
    AppMethodBeat.o(150915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.a
 * JD-Core Version:    0.7.0.1
 */