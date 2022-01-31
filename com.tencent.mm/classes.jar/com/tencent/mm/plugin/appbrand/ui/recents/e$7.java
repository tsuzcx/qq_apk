package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.appusage.w.c;
import java.util.ArrayList;

final class e$7
  implements Runnable
{
  e$7(e parame, long paramLong) {}
  
  public final void run()
  {
    ArrayList localArrayList = e.l(this.hhH).n(com.tencent.mm.plugin.appbrand.app.e.aaZ().fJw.cu(this.hhJ));
    this.hhH.runOnUiThread(new e.7.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.7
 * JD-Core Version:    0.7.0.1
 */