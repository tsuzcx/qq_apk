package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class a$2
  implements View.OnLongClickListener
{
  a$2(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (paramView.getId() == a.d.code_text)
    {
      p.P(this.ipt.hxN, this.ipt.ikk.azy().code);
      h.bC(this.ipt.hxN, this.ipt.hxN.getString(a.g.app_copy_ok));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a.2
 * JD-Core Version:    0.7.0.1
 */