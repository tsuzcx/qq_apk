package com.tencent.mm.plugin.exdevice.f.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class d
{
  private static final String jxI = e.dzL + "uploaded_photos/";
  private static final String jxJ = e.dzL + "temp/";
  
  public static String Bx(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (String str = "";; str = j.n(new b(aLY(), str).cLr()))
    {
      c.c(paramString, 640, 640, Bitmap.CompressFormat.JPEG, 100, str);
      System.currentTimeMillis();
      return str;
      str = ad.bB(paramString);
      str = str + "_t";
    }
  }
  
  public static b aLY()
  {
    b localb = new b(jxI);
    if ((!localb.exists()) || (!localb.isDirectory())) {
      localb.mkdirs();
    }
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.d
 * JD-Core Version:    0.7.0.1
 */