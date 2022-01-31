package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.ak.f;
import com.tencent.mm.plugin.downloader.f.a;

final class j$1
  implements Runnable
{
  j$1(j paramj, long paramLong) {}
  
  public final void run()
  {
    a locala = c.dk(this.iPa);
    if (locala == null) {}
    do
    {
      return;
      f.Nd().lM(locala.field_downloadUrl);
    } while (locala.field_status == 5);
    c.j(locala.field_downloadId, 5);
    this.iPU.iPn.dg(this.iPa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.j.1
 * JD-Core Version:    0.7.0.1
 */