package com.tencent.mm.plugin.aa.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.y;

final class PaylistAAUI$8
  implements a.a
{
  PaylistAAUI$8(PaylistAAUI paramPaylistAAUI) {}
  
  public final void Vx()
  {
    int i = a.i.urge_aa_confirm_msg;
    if (!s.fn(PaylistAAUI.a(this.eZM))) {
      i = a.i.urge_aa_confirm_msg_single;
    }
    for (;;)
    {
      e.a locala = new e.a(this.eZM);
      locala.aeF(this.eZM.getString(a.i.urge_aa_confirm_msg_title));
      View localView = y.gt(this.eZM).inflate(a.g.urge_aa_dialog_centerview, null);
      ImageView localImageView = (ImageView)localView.findViewById(a.f.image);
      TextView localTextView = (TextView)localView.findViewById(a.f.text);
      localImageView.setImageResource(a.e.paylist_urge_atall_hint);
      localTextView.setText(i);
      locala.ek(localView);
      locala.Iu(a.i.app_send);
      locala.wnw = this.eZM.getString(a.i.app_cancel);
      locala.wny = false;
      locala.a(new PaylistAAUI.8.1(this), new PaylistAAUI.8.2(this));
      locala.show();
      h.nFQ.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(7) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.8
 * JD-Core Version:    0.7.0.1
 */