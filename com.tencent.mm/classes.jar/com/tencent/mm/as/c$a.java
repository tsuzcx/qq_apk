package com.tencent.mm.as;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class c$a
  implements Runnable
{
  private HashMap<String, c.c> enb;
  private Bitmap enc;
  private String url;
  
  public c$a(String paramString, Bitmap paramBitmap, HashMap<String, c.c> paramHashMap)
  {
    this.url = paramString;
    this.enc = paramBitmap;
    this.enb = paramHashMap;
  }
  
  public final void run()
  {
    o.OI();
    c.g(this.url, this.enc);
    if (this.enb != null)
    {
      localObject = (c.c)this.enb.remove(this.url);
      if (localObject != null) {
        ((c.c)localObject).t(this.enc);
      }
    }
    if (this.url == null) {}
    for (Object localObject = "null";; localObject = this.url)
    {
      y.i("MicroMsg.CdnImageService", "finish download post job, url[%s]", new Object[] { localObject });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.c.a
 * JD-Core Version:    0.7.0.1
 */