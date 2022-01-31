package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.e.d;

final class g$8
  implements View.OnClickListener
{
  g$8(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22158);
    this.nTF.dismiss();
    paramView = new Intent();
    paramView.putExtra("IPCallShareCouponCardUI_KFrom", 2);
    paramView.setClass(g.i(this.nTF), IPCallShareCouponCardUI.class);
    g.i(this.nTF).startActivity(paramView);
    d.a(1, -1, g.h(this.nTF), g.b(this.nTF, g.h(this.nTF)), 1, 1, -1, g.e(this.nTF), g.f(this.nTF));
    AppMethodBeat.o(22158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.8
 * JD-Core Version:    0.7.0.1
 */