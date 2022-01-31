package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.wxawidget.b.d;
import com.tencent.mm.protocal.c.bna;

final class b$b$1
  implements View.OnClickListener
{
  b$b$1(b.b paramb, bna parambna, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    if (this.fYb.tGf == 2)
    {
      this.fYc.setImageResource(b.d.login_auth_state_not_selected);
      this.fYb.tGf = 1;
    }
    while (this.fYb.tGf != 1) {
      return;
    }
    this.fYc.setImageResource(b.d.login_auth_state_default_select);
    this.fYb.tGf = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.b.1
 * JD-Core Version:    0.7.0.1
 */