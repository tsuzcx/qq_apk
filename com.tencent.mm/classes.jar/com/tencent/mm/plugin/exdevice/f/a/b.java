package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.IOException;

public final class b
{
  public static String Bw(String paramString)
  {
    if ((bk.bl(paramString)) || ("#".equals(paramString))) {
      return "";
    }
    Object localObject = ad.bB(paramString);
    localObject = new com.tencent.mm.vfs.b(d.aLY(), (String)localObject);
    if (((com.tencent.mm.vfs.b)localObject).exists()) {
      return j.n(((com.tencent.mm.vfs.b)localObject).cLr());
    }
    try
    {
      ((com.tencent.mm.vfs.b)localObject).createNewFile();
      au.DS().O(new a(paramString, (com.tencent.mm.vfs.b)localObject));
      return "";
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[] { localIOException.toString() });
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    private com.tencent.mm.vfs.b jxG;
    private String url;
    
    a(String paramString, com.tencent.mm.vfs.b paramb)
    {
      this.url = paramString;
      this.jxG = paramb;
    }
    
    public final void run()
    {
      byte[] arrayOfByte = bk.ZV(this.url);
      if (arrayOfByte != null) {
        e.b(j.n(this.jxG.mUri), arrayOfByte, arrayOfByte.length);
      }
    }
    
    public final String toString()
    {
      return super.toString() + "|DownloadRunnable";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.b
 * JD-Core Version:    0.7.0.1
 */