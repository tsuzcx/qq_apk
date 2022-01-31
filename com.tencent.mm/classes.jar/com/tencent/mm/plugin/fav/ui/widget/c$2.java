package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class c$2
  implements View.OnClickListener
{
  c$2(c paramc) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.FavHeaderView", "click retry item");
    paramView = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQz();
    if ((paramView == null) || (paramView.isEmpty())) {
      return;
    }
    paramView = paramView.iterator();
    while (paramView.hasNext())
    {
      com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)paramView.next();
      if (!localg.aQa()) {
        y.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[] { Integer.valueOf(localg.field_id) });
      } else {
        b.l(localg);
      }
    }
    c.c(this.kjA).setVisibility(8);
    c.d(this.kjA).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c.2
 * JD-Core Version:    0.7.0.1
 */