package com.tencent.mm.plugin.cdndownloader.d;

import com.tencent.mm.plugin.cdndownloader.e.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class a$1
  implements b
{
  a$1(a parama) {}
  
  public final void aDy()
  {
    y.i("MicroMsg.CDNDownloadClient", "notify add");
    a.a(this.iAG);
    a.b(this.iAG);
  }
  
  public final void clear()
  {
    y.i("MicroMsg.CDNDownloadClient", "notify clear");
    a.d(this.iAG);
    a.e(this.iAG);
  }
  
  public final void remove()
  {
    y.i("MicroMsg.CDNDownloadClient", "notify remove");
    if (a.c(this.iAG).size() == 0)
    {
      a.d(this.iAG);
      a.e(this.iAG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.1
 * JD-Core Version:    0.7.0.1
 */