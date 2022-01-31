package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.d;

final class g$8
  implements View.OnClickListener
{
  g$8(g paramg) {}
  
  public final void onClick(View paramView)
  {
    this.lwq.dismiss();
    paramView = new Intent();
    paramView.putExtra("IPCallShareCouponCardUI_KFrom", 2);
    paramView.setClass(g.i(this.lwq), IPCallShareCouponCardUI.class);
    g.i(this.lwq).startActivity(paramView);
    d.a(1, -1, g.h(this.lwq), g.b(this.lwq, g.h(this.lwq)), 1, 1, -1, g.e(this.lwq), g.f(this.lwq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.8
 * JD-Core Version:    0.7.0.1
 */