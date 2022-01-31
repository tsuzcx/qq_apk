package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

final class SnsLuckyMoneyPrepareUI$16
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$16(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(this.lTI)), Integer.valueOf(4) });
    if (this.lTI.lTx.bfp() != 0)
    {
      com.tencent.mm.ui.base.s.makeText(this.lTI.mController.uMN, a.i.wallet_balance_save_input_invalid, 0).show();
      return;
    }
    int i = this.lTI.lMm.getInput();
    double d = this.lTI.lTx.getInput();
    long l2 = 0L;
    long l1;
    String str;
    if (SnsLuckyMoneyPrepareUI.a(this.lTI) == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.e.C(d);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(356354, Integer.valueOf(i));
      str = this.lTI.lMo.getInput();
      paramView = str;
      if (bk.bl(str)) {
        paramView = this.lTI.getString(a.i.lucky_money_default_wish);
      }
      str = this.lTI.getIntent().getStringExtra("key_username");
      if ((!SnsLuckyMoneyPrepareUI.e(this.lTI)) || (bk.bl(str))) {
        break label331;
      }
    }
    label331:
    for (paramView = new ae(i, l1, l2, SnsLuckyMoneyPrepareUI.a(this.lTI), paramView, o.bfL(), str, o.gU(str), q.Gj(), q.Gl(), SnsLuckyMoneyPrepareUI.f(this.lTI));; paramView = new ae(i, l1, l2, SnsLuckyMoneyPrepareUI.a(this.lTI), paramView, o.bfL(), null, null, q.Gj(), q.Gl(), SnsLuckyMoneyPrepareUI.f(this.lTI)))
    {
      this.lTI.b(paramView, false);
      if (this.lTI.ftk == null) {
        break label374;
      }
      this.lTI.ftk.show();
      return;
      l1 = com.tencent.mm.wallet_core.ui.e.C(i * d);
      l2 = com.tencent.mm.wallet_core.ui.e.C(d);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(356353, Integer.valueOf(i));
      break;
    }
    label374:
    this.lTI.ftk = com.tencent.mm.wallet_core.ui.g.a(this.lTI.mController.uMN, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if ((SnsLuckyMoneyPrepareUI.16.this.lTI.ftk != null) && (SnsLuckyMoneyPrepareUI.16.this.lTI.ftk.isShowing())) {
          SnsLuckyMoneyPrepareUI.16.this.lTI.ftk.hide();
        }
        if ((SnsLuckyMoneyPrepareUI.g(SnsLuckyMoneyPrepareUI.16.this.lTI).getVisibility() == 8) || (SnsLuckyMoneyPrepareUI.h(SnsLuckyMoneyPrepareUI.16.this.lTI).getVisibility() == 4))
        {
          y.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
          SnsLuckyMoneyPrepareUI.16.this.lTI.finish();
        }
        SnsLuckyMoneyPrepareUI.16.this.lTI.lUq.bfH();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.16
 * JD-Core Version:    0.7.0.1
 */