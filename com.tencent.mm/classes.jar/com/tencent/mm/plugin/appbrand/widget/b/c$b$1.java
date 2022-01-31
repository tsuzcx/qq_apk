package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.protocal.c.bna;

final class c$b$1
  implements View.OnClickListener
{
  c$b$1(c.b paramb, bna parambna, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    if (this.fYb.tGf == 2)
    {
      this.fYc.setImageResource(y.i.login_auth_state_not_selected);
      this.fYb.tGf = 1;
    }
    while (this.fYb.tGf != 1) {
      return;
    }
    this.fYc.setImageResource(y.i.login_auth_state_default_select);
    this.fYb.tGf = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c.b.1
 * JD-Core Version:    0.7.0.1
 */