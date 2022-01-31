package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.ui.base.o;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getId() == a.d.popupwd_qrcode_iv) || (paramView.getId() == a.d.popupwd_barcode_iv))
    {
      if ((this.iwJ.fvf != null) && (this.iwJ.fvf.isShowing())) {
        this.iwJ.fvf.dismiss();
      }
      if (!this.iwJ.ikk.azh()) {
        this.iwJ.aCf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.j.1
 * JD-Core Version:    0.7.0.1
 */