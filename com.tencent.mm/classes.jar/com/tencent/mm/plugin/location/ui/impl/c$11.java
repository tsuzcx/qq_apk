package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.y;

final class c$11
  implements View.OnClickListener
{
  c$11(c paramc) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[] { Double.valueOf(c.g(this.lJp)), Double.valueOf(c.h(this.lJp)) });
    if ((c.g(this.lJp) == -85.0D) || (c.h(this.lJp) == -1000.0D))
    {
      y.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
      return;
    }
    this.lJp.lFy.getIController().animateTo(c.g(this.lJp), c.h(this.lJp));
    c.a(this.lJp, c.g(this.lJp));
    c.b(this.lJp, c.h(this.lJp));
    c.k(this.lJp).j(c.i(this.lJp), c.j(this.lJp));
    c.l(this.lJp).setBackgroundResource(a.d.location_my_current);
    c.l(this.lJp).setEnabled(true);
    c.m(this.lJp);
    c.n(this.lJp);
    c.o(this.lJp).lJl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.11
 * JD-Core Version:    0.7.0.1
 */