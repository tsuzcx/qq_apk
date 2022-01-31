package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class CollectMainUI$13
  implements View.OnClickListener
{
  CollectMainUI$13(CollectMainUI paramCollectMainUI, bda parambda) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41267);
    if (this.kSE.type == 1) {
      if (this.kSE.url.equals("wxpay://f2f/f2fdetail"))
      {
        paramView = new Intent(this.kSz.getContext(), CollectBillUI.class);
        paramView.putExtra("key_from_scene", 0);
        this.kSz.startActivityForResult(paramView, 4097);
        h.qsU.e(13944, new Object[] { Integer.valueOf(1) });
        h.qsU.e(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(1), this.kSE.cyA, "", "", "", Integer.valueOf(2) });
        if (this.kSE.xte == 1) {
          h.qsU.e(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(1), this.kSE.cyA, "", "", "", Integer.valueOf(2) });
        }
      }
    }
    for (;;)
    {
      this.kSz.kSn.setVisibility(4);
      this.kSz.kSo.setVisibility(8);
      AppMethodBeat.o(41267);
      return;
      if (this.kSE.type == 2)
      {
        if (bo.isNullOrNil(this.kSE.url))
        {
          ab.w("MicroMsg.CollectMainUI", "empty bottom h5 url");
          AppMethodBeat.o(41267);
          return;
        }
        e.m(this.kSz.getContext(), this.kSE.url, false);
        h.qsU.e(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.kSE.cyA, "", "", this.kSE.url, Integer.valueOf(2) });
        if (this.kSE.xte == 1) {
          h.qsU.e(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.kSE.cyA, "", "", this.kSE.url, Integer.valueOf(2) });
        }
      }
      else if (this.kSE.type == 3)
      {
        paramView = new so();
        paramView.cIQ.userName = this.kSE.xtb;
        paramView.cIQ.cIS = bo.bf(this.kSE.xtc, "");
        paramView.cIQ.scene = 1072;
        paramView.cIQ.cIT = 0;
        a.ymk.l(paramView);
        h.qsU.e(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(3), this.kSE.cyA, this.kSE.xtb, this.kSE.xtc, "", Integer.valueOf(2) });
        if (this.kSE.xte == 1) {
          h.qsU.e(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(3), this.kSE.cyA, this.kSE.xtb, this.kSE.xtc, "", Integer.valueOf(2) });
        }
      }
      else
      {
        paramView = new Intent(this.kSz.getContext(), CollectBillUI.class);
        paramView.putExtra("key_from_scene", 0);
        this.kSz.startActivityForResult(paramView, 4097);
        h.qsU.e(13944, new Object[] { Integer.valueOf(1) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.13
 * JD-Core Version:    0.7.0.1
 */