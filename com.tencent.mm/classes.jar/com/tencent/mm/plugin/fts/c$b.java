package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$b
  implements Runnable
{
  private String bTY;
  private String fWw;
  private int height;
  private boolean ktK;
  private c.c ktL;
  private String url;
  private int width;
  
  public c$b(c paramc, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, c.c paramc1)
  {
    this.fWw = paramString1;
    this.url = paramString2;
    this.bTY = paramString3;
    this.ktL = paramc1;
    this.ktK = paramBoolean;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final void run()
  {
    y.d("MicroMsg.FTS.FTSImageLoader", "Start to run load bitmap job %s", new Object[] { this.fWw });
    if (bk.bl(this.bTY)) {
      this.bTY = c.DH(this.fWw);
    }
    long l2 = System.currentTimeMillis();
    Bitmap localBitmap = c.Q(this.bTY, this.width, this.height);
    long l1 = System.currentTimeMillis();
    if (localBitmap != null)
    {
      y.d("MicroMsg.FTS.FTSImageLoader", "Found image in local %s | localPath %s | use time %d", new Object[] { this.url, this.bTY, Long.valueOf(l1 - l2) });
      c.a(this.ktI, this.fWw, this.bTY, localBitmap);
      this.ktL.aC(this.fWw, true);
      return;
    }
    localBitmap = c.a(this.ktI, this.url, this.ktK, this.width, this.height);
    l2 = System.currentTimeMillis();
    y.d("MicroMsg.FTS.FTSImageLoader", "Get image from net %s | localPath %s | use time %d", new Object[] { this.url, this.bTY, Long.valueOf(l2 - l1) });
    if (localBitmap != null)
    {
      c.a(this.ktI, this.fWw, this.bTY, localBitmap);
      this.ktL.aC(this.fWw, true);
      return;
    }
    this.ktL.aC(this.fWw, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.b
 * JD-Core Version:    0.7.0.1
 */