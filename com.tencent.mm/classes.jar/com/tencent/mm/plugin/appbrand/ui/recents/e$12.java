package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.sdk.platformtools.bk;

final class e$12
  implements Runnable
{
  e$12(e parame, l paraml) {}
  
  public final void run()
  {
    if (!bk.dk(e.a(this.hhH)))
    {
      int i = e.a(this.hhH).size();
      e.a(this.hhH).clear();
      e.b(this.hhH).ak(0, i);
    }
    e.a(this.hhH).addAll(this.hhS);
    e.b(this.hhH).aj(0, this.hhS.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.12
 * JD-Core Version:    0.7.0.1
 */