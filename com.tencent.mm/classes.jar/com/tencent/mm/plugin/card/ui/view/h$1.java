package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.protocal.c.lv;

final class h$1
  implements View.OnLongClickListener
{
  h$1(h paramh, b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (paramView.getId() == a.d.code_text)
    {
      p.P(this.ixZ.hxN, this.ixY.azy().code);
      com.tencent.mm.ui.base.h.bC(this.ixZ.hxN, o.getString(a.g.app_copy_ok));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.h.1
 * JD-Core Version:    0.7.0.1
 */