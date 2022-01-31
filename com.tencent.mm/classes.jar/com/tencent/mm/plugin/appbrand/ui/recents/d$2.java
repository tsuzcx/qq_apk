package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class d$2
  implements Runnable
{
  d$2(d paramd) {}
  
  public final void run()
  {
    List localList = this.hgW.apM();
    if (bk.dk(localList)) {
      return;
    }
    d.a(this.hgW, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d.2
 * JD-Core Version:    0.7.0.1
 */