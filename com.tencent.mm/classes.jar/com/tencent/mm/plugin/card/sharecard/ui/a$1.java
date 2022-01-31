package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.card.a.d;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == a.d.notify_checkbox)
    {
      if (!this.ipt.ipm.isChecked()) {
        break label47;
      }
      if (this.ipt.ipq != null) {
        this.ipt.ipq.oT(1);
      }
    }
    label47:
    while (this.ipt.ipq == null) {
      return;
    }
    this.ipt.ipq.oT(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.a.1
 * JD-Core Version:    0.7.0.1
 */