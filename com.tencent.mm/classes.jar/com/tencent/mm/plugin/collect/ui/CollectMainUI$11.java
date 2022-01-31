package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class CollectMainUI$11
  implements View.OnClickListener
{
  CollectMainUI$11(CollectMainUI paramCollectMainUI, awl paramawl) {}
  
  public final void onClick(View paramView)
  {
    if (this.iLT.type == 1) {
      if (this.iLT.url.equals("wxpay://f2f/f2fdetail"))
      {
        paramView = new Intent(this.iLP.mController.uMN, CollectBillUI.class);
        paramView.putExtra("key_from_scene", 0);
        this.iLP.startActivityForResult(paramView, 4097);
        h.nFQ.f(13944, new Object[] { Integer.valueOf(1) });
        h.nFQ.f(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(1), this.iLT.bQZ, "", "", "", Integer.valueOf(2) });
        if (this.iLT.tte == 1) {
          h.nFQ.f(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(1), this.iLT.bQZ, "", "", "", Integer.valueOf(2) });
        }
      }
    }
    for (;;)
    {
      this.iLP.iLE.setVisibility(4);
      this.iLP.iLF.setVisibility(8);
      return;
      if (this.iLT.type == 2)
      {
        if (bk.bl(this.iLT.url))
        {
          y.w("MicroMsg.CollectMainUI", "empty bottom h5 url");
          return;
        }
        e.l(this.iLP.mController.uMN, this.iLT.url, false);
        h.nFQ.f(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.iLT.bQZ, "", "", this.iLT.url, Integer.valueOf(2) });
        if (this.iLT.tte == 1) {
          h.nFQ.f(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.iLT.bQZ, "", "", this.iLT.url, Integer.valueOf(2) });
        }
      }
      else if (this.iLT.type == 3)
      {
        paramView = new rc();
        paramView.caq.userName = this.iLT.ttb;
        paramView.caq.cas = bk.aM(this.iLT.ttc, "");
        paramView.caq.scene = 1072;
        paramView.caq.cat = 0;
        a.udP.m(paramView);
        h.nFQ.f(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(3), this.iLT.bQZ, this.iLT.ttb, this.iLT.ttc, "", Integer.valueOf(2) });
        if (this.iLT.tte == 1) {
          h.nFQ.f(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(3), this.iLT.bQZ, this.iLT.ttb, this.iLT.ttc, "", Integer.valueOf(2) });
        }
      }
      else
      {
        paramView = new Intent(this.iLP.mController.uMN, CollectBillUI.class);
        paramView.putExtra("key_from_scene", 0);
        this.iLP.startActivityForResult(paramView, 4097);
        h.nFQ.f(13944, new Object[] { Integer.valueOf(1) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.11
 * JD-Core Version:    0.7.0.1
 */