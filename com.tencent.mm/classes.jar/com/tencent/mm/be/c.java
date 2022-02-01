package com.tencent.mm.be;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.x.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class c
{
  private static c ikd;
  private be ike = null;
  
  public static String Gd(String paramString)
  {
    AppMethodBeat.i(90695);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90695);
      return null;
    }
    paramString = m.d(a.dIA(), "remark_", com.tencent.mm.b.g.getMessageDigest((paramString + "ZnVjaw==").getBytes()), ".png", 1);
    AppMethodBeat.o(90695);
    return paramString;
  }
  
  public static boolean Ge(String paramString)
  {
    AppMethodBeat.i(90696);
    String str = Gd(paramString);
    ad.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = new e(str).exists();
    AppMethodBeat.o(90696);
    return bool;
  }
  
  public static boolean Gf(String paramString)
  {
    AppMethodBeat.i(90697);
    String str = Gd(paramString);
    ad.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = i.deleteFile(str);
    AppMethodBeat.o(90697);
    return bool;
  }
  
  public static Bitmap Gg(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(90698);
    paramString = com.tencent.mm.sdk.platformtools.g.aM(Gd(paramString), 0, 0);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (!paramString.isRecycled()) {
        i = 1;
      }
    }
    if (i != 0)
    {
      AppMethodBeat.o(90698);
      return paramString;
    }
    AppMethodBeat.o(90698);
    return null;
  }
  
  public static c aKd()
  {
    AppMethodBeat.i(90694);
    if (ikd == null) {
      ikd = new c();
    }
    c localc = ikd;
    AppMethodBeat.o(90694);
    return localc;
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(90699);
    if ((!bt.isNullOrNil(paramString2)) && (!Ge(paramString1)))
    {
      if ((this.ike == null) || (this.ike.flo())) {
        this.ike = new be(1, "download-remark-img", 1);
      }
      this.ike.c(new c.b(this, paramString1, paramString2, parama));
    }
    AppMethodBeat.o(90699);
  }
  
  public static abstract interface a
  {
    public abstract void eP(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.be.c
 * JD-Core Version:    0.7.0.1
 */