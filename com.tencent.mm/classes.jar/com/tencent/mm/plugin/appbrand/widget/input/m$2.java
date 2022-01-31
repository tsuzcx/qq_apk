package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class m$2
  implements Runnable
{
  m$2(m paramm) {}
  
  public final void run()
  {
    int i = 0;
    y.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[] { Integer.valueOf(m.d(this.htZ).size()) });
    if (m.d(this.htZ).size() <= 0) {}
    for (;;)
    {
      return;
      m.a[] arrayOfa = new m.a[m.d(this.htZ).size()];
      m.d(this.htZ).toArray(arrayOfa);
      int j = arrayOfa.length;
      while (i < j)
      {
        arrayOfa[i].ajU();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.m.2
 * JD-Core Version:    0.7.0.1
 */