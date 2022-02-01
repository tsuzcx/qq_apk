package com.tencent.mm.bd;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.x.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;

public final class c
{
  private static c imW;
  private bf imX = null;
  
  public static String GF(String paramString)
  {
    AppMethodBeat.i(90695);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90695);
      return null;
    }
    paramString = n.d(a.dLR(), "remark_", g.getMessageDigest((paramString + "ZnVjaw==").getBytes()), ".png", 1);
    AppMethodBeat.o(90695);
    return paramString;
  }
  
  public static boolean GG(String paramString)
  {
    AppMethodBeat.i(90696);
    String str = GF(paramString);
    ae.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = new k(str).exists();
    AppMethodBeat.o(90696);
    return bool;
  }
  
  public static boolean GH(String paramString)
  {
    AppMethodBeat.i(90697);
    String str = GF(paramString);
    ae.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = o.deleteFile(str);
    AppMethodBeat.o(90697);
    return bool;
  }
  
  public static Bitmap GI(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(90698);
    paramString = h.aO(GF(paramString), 0, 0);
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
  
  public static c aKw()
  {
    AppMethodBeat.i(90694);
    if (imW == null) {
      imW = new c();
    }
    c localc = imW;
    AppMethodBeat.o(90694);
    return localc;
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(90699);
    if ((!bu.isNullOrNil(paramString2)) && (!GG(paramString1)))
    {
      if ((this.imX == null) || (this.imX.fpj())) {
        this.imX = new bf(1, "download-remark-img", 1);
      }
      this.imX.c(new c.b(this, paramString1, paramString2, parama));
    }
    AppMethodBeat.o(90699);
  }
  
  public static abstract interface a
  {
    public abstract void eS(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bd.c
 * JD-Core Version:    0.7.0.1
 */