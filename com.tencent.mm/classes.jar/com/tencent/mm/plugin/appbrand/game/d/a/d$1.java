package com.tencent.mm.plugin.appbrand.game.d.a;

import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.q;

final class d$1
  implements Runnable
{
  d$1(d paramd, p paramp) {}
  
  public final void run()
  {
    Object localObject = this.gbW.E(q.class);
    if (localObject == null) {}
    do
    {
      return;
      localObject = a.bQ(((q)localObject).getContentView());
    } while (localObject == null);
    ((a)localObject).hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a.d.1
 * JD-Core Version:    0.7.0.1
 */