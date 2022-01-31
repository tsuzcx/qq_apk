package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class n$1
  implements View.OnClickListener
{
  n$1(n paramn, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    paramView = (Button)this.iyj.findViewById(a.d.code_button);
    View localView = this.iyj.findViewById(a.d.code_qr_disable_layout);
    if ((paramView.getVisibility() == 0) && (localView.getVisibility() == 0)) {
      return;
    }
    if (localView.getVisibility() == 0)
    {
      if (!l.isNetworkAvailable(this.iyk.hxN.mController.uMN))
      {
        d.a(this.iyk.hxN, this.iyk.hxN.getString(a.g.card_get_code_network_connet_failure), false);
        return;
      }
      localView.setVisibility(8);
      this.iyj.findViewById(a.d.code_qr_area).setVisibility(0);
    }
    this.iyk.ixX.d(c.iyU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.n.1
 * JD-Core Version:    0.7.0.1
 */