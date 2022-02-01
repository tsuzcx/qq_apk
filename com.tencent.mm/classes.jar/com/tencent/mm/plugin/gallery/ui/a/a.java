package com.tencent.mm.plugin.gallery.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class a
  extends com.tencent.mm.ui.tools.b.a
{
  private a CeU;
  public long aKk = 104857600L;
  private String cJT;
  
  public a(String paramString)
  {
    this.cJT = paramString;
  }
  
  public final int bNF()
  {
    int i = 10485760;
    AppMethodBeat.i(111735);
    if (Util.isNullOrNil(this.cJT)) {
      Log.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
    }
    boolean bool1 = NetStatusUtil.is2G(MMApplicationContext.getContext());
    boolean bool2 = c.ZZ(this.cJT);
    label58:
    double d;
    if (bool2)
    {
      String str = this.cJT;
      if (bool1)
      {
        if (!bool1) {
          break label206;
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
        i = (int)this.aKk;
        break label58;
        label206:
        d = this.aKk;
        break label67;
        int j = (int)u.bBQ(this.cJT);
        if (bool1) {}
        for (i = 10485760;; i = 26214400)
        {
          if (j <= i) {
            break label250;
          }
          i = -1;
          break;
        }
        label250:
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
  
  public final void euX()
  {
    AppMethodBeat.i(111736);
    if (this.CeU == null)
    {
      Log.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
      AppMethodBeat.o(111736);
      return;
    }
    bNF();
    AppMethodBeat.o(111736);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.a
 * JD-Core Version:    0.7.0.1
 */