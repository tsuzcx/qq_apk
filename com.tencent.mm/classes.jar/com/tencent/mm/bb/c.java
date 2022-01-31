package com.tencent.mm.bb;

import android.graphics.Bitmap;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.ae.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class c
{
  private static c exB;
  private av exC = null;
  
  public static c PO()
  {
    if (exB == null) {
      exB = new c();
    }
    return exB;
  }
  
  public static String mK(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return h.b(a.bvR(), "remark_", g.o((paramString + "ZnVjaw==").getBytes()), ".png", 1);
  }
  
  public static boolean mL(String paramString)
  {
    String str = mK(paramString);
    y.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    return new File(str).exists();
  }
  
  public static boolean mM(String paramString)
  {
    String str = mK(paramString);
    y.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", new Object[] { paramString, str });
    return e.deleteFile(str);
  }
  
  public static Bitmap mN(String paramString)
  {
    int j = 0;
    paramString = com.tencent.mm.sdk.platformtools.c.ak(mK(paramString), 0, 0);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (!paramString.isRecycled()) {
        i = 1;
      }
    }
    if (i != 0) {
      return paramString;
    }
    return null;
  }
  
  public final void a(String paramString1, String paramString2, c.a parama)
  {
    if ((!bk.bl(paramString2)) && (!mL(paramString1)))
    {
      if ((this.exC == null) || (this.exC.crx())) {
        this.exC = new av(1, "download-remark-img", 1);
      }
      this.exC.c(new c.b(this, paramString1, paramString2, parama));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.c
 * JD-Core Version:    0.7.0.1
 */