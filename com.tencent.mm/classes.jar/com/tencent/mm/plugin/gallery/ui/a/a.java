package com.tencent.mm.plugin.gallery.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class a
  extends com.tencent.mm.ui.tools.b.a
{
  private String cJp;
  public int mSize = 104857600;
  private a xsy;
  
  private a(String paramString)
  {
    this.cJp = paramString;
  }
  
  public static a azf(String paramString)
  {
    AppMethodBeat.i(111734);
    paramString = new a(paramString);
    AppMethodBeat.o(111734);
    return paramString;
  }
  
  public final int bCj()
  {
    int i = 10485760;
    AppMethodBeat.i(111735);
    if (Util.isNullOrNil(this.cJp)) {
      Log.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
    }
    boolean bool1 = NetStatusUtil.is2G(MMApplicationContext.getContext());
    boolean bool2 = c.Sx(this.cJp);
    label58:
    double d;
    if (bool2)
    {
      String str = this.cJp;
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
      Log.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2) });
      switch (i)
      {
      default: 
        Log.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(111735);
        return 1;
        i = this.mSize;
        break label58;
        label205:
        d = this.mSize;
        break label67;
        int j = (int)s.boW(this.cJp);
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
  
  public final int dSv()
  {
    AppMethodBeat.i(257761);
    int i = bCj();
    AppMethodBeat.o(257761);
    return i;
  }
  
  public final void dSw()
  {
    AppMethodBeat.i(111736);
    if (this.xsy == null)
    {
      Log.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(111736);
      return;
    }
    bCj();
    AppMethodBeat.o(111736);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.a
 * JD-Core Version:    0.7.0.1
 */