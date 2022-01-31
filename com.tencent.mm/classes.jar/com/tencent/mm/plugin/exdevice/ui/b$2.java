package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = this.jFh.qz(i);
    b.a(this.jFh).BS(paramView.jHR.field_username);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b.2
 * JD-Core Version:    0.7.0.1
 */