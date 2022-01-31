package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;

final class h$e$1
  implements View.OnClickListener
{
  h$e$1(h.e parame, as paramas, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42898);
    h.qsU.e(11701, new Object[] { Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.ovF.opO) });
    if (this.ovM.ovE != null) {
      g.gK(this.ovM.ovE.ovK, 1);
    }
    if ((this.ovM.ovE != null) && (this.ovM.ovE.ovJ)) {
      h.qsU.e(13051, new Object[] { Integer.valueOf(this.ovM.ovE.ovK), Integer.valueOf(2), "", "", "", this.ovF.content, this.ovF.type, "", "", Integer.valueOf(this.ovM.ovE.resourceId) });
    }
    h localh;
    String str;
    if (this.ovF.type.equals("Native"))
    {
      ab.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + this.ovF.content);
      if ("weixin://festival/gotoshake".equalsIgnoreCase(this.ovF.content)) {
        ab.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
      }
      localh = h.qsU;
      str = this.ovF.content;
      if (this.ovM.ovE.ovL == null) {
        break label370;
      }
    }
    label370:
    for (paramView = this.ovM.ovE.ovL.xjL;; paramView = "")
    {
      localh.e(16589, new Object[] { Integer.valueOf(2), str, paramView });
      AppMethodBeat.o(42898);
      return;
      e.m(this.val$context, this.ovF.content, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h.e.1
 * JD-Core Version:    0.7.0.1
 */