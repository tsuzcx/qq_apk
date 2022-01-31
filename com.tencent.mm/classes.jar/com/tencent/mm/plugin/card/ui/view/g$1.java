package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.ui.base.h;

final class g$1
  implements View.OnLongClickListener
{
  g$1(g paramg) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (paramView.getId() == a.d.code_text)
    {
      p.P(this.ixW.hxN, this.ixW.ikk.azy().code);
      h.bC(this.ixW.hxN, this.ixW.getString(a.g.app_copy_ok));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.g.1
 * JD-Core Version:    0.7.0.1
 */