package com.tencent.mm.model;

import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$b
  implements Runnable
{
  String bWQ;
  String dUr;
  
  public c$b(String paramString1, String paramString2)
  {
    this.bWQ = paramString1;
    this.dUr = paramString2;
  }
  
  public final void run()
  {
    if ((bk.bl(this.bWQ)) || (bk.bl(this.dUr))) {}
    do
    {
      return;
      y.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.bWQ + " to :" + this.dUr);
    } while ((!f.zF()) || (!this.dUr.substring(0, com.tencent.mm.compatible.util.e.bkH.length()).equals(com.tencent.mm.compatible.util.e.bkH)));
    com.tencent.mm.vfs.e.gD(this.bWQ + "image/", this.dUr + "image/");
    com.tencent.mm.vfs.e.gD(this.bWQ + "image2/", this.dUr + "image2/");
    com.tencent.mm.vfs.e.gD(this.bWQ + "video/", this.dUr + "video/");
    com.tencent.mm.vfs.e.gD(this.bWQ + "voice/", this.dUr + "voice/");
    com.tencent.mm.vfs.e.gD(this.bWQ + "voice2/", this.dUr + "voice2/");
    com.tencent.mm.vfs.e.gD(this.bWQ + "package/", this.dUr + "package/");
    com.tencent.mm.vfs.e.gD(this.bWQ + "emoji/", this.dUr + "emoji/");
    com.tencent.mm.vfs.e.gD(this.bWQ + "mailapp/", this.dUr + "mailapp/");
    com.tencent.mm.vfs.e.gD(this.bWQ + "brandicon/", this.dUr + "brandicon/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */