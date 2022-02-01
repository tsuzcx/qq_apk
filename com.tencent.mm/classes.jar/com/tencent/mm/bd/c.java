package com.tencent.mm.bd;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;

public final class c
{
  private static c hQP;
  private bd hQQ = null;
  
  public static String CY(String paramString)
  {
    AppMethodBeat.i(90695);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(90695);
      return null;
    }
    paramString = l.d(a.dxi(), "remark_", g.getMessageDigest((paramString + "ZnVjaw==").getBytes()), ".png", 1);
    AppMethodBeat.o(90695);
    return paramString;
  }
  
  public static boolean CZ(String paramString)
  {
    AppMethodBeat.i(90696);
    String str = CY(paramString);
    ac.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = new e(str).exists();
    AppMethodBeat.o(90696);
    return bool;
  }
  
  public static boolean Da(String paramString)
  {
    AppMethodBeat.i(90697);
    String str = CY(paramString);
    ac.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    boolean bool = i.deleteFile(str);
    AppMethodBeat.o(90697);
    return bool;
  }
  
  public static Bitmap Db(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(90698);
    paramString = f.aI(CY(paramString), 0, 0);
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
  
  public static c aGS()
  {
    AppMethodBeat.i(90694);
    if (hQP == null) {
      hQP = new c();
    }
    c localc = hQP;
    AppMethodBeat.o(90694);
    return localc;
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(90699);
    if ((!bs.isNullOrNil(paramString2)) && (!CZ(paramString1)))
    {
      if ((this.hQQ == null) || (this.hQQ.eVH())) {
        this.hQQ = new bd(1, "download-remark-img", 1);
      }
      this.hQQ.c(new c.b(this, paramString1, paramString2, parama));
    }
    AppMethodBeat.o(90699);
  }
  
  public static abstract interface a
  {
    public abstract void eN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bd.c
 * JD-Core Version:    0.7.0.1
 */