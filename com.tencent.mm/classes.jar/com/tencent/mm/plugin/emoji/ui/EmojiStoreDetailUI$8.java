package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiStoreDetailUI$8
  implements DialogInterface.OnClickListener
{
  EmojiStoreDetailUI$8(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (a.Bh(EmojiStoreDetailUI.a(this.jeK)))
    {
      y.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
      com.tencent.mm.plugin.emoji.f.b.aHY().aIa();
      if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(this.jeK)))
      {
        f.Nd().lM(EmojiStoreDetailUI.t(this.jeK));
        y.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(this.jeK) });
      }
      if ((!com.tencent.mm.plugin.emoji.a.a.e.cC(EmojiStoreDetailUI.b(this.jeK).sSh, 1)) && (!com.tencent.mm.plugin.emoji.a.a.e.pU(EmojiStoreDetailUI.b(this.jeK).sSg))) {
        break label252;
      }
      EmojiStoreDetailUI.a(this.jeK, 3);
    }
    for (;;)
    {
      i.aHU().g(EmojiStoreDetailUI.a(this.jeK), EmojiStoreDetailUI.u(this.jeK), 0, EmojiStoreDetailUI.t(this.jeK));
      EmojiStoreDetailUI.i(this.jeK).setVisibility(8);
      EmojiStoreDetailUI.l(this.jeK).setProgress(0);
      EmojiStoreDetailUI.j(this.jeK).setVisibility(4);
      EmojiStoreDetailUI.h(this.jeK).setVisibility(0);
      EmojiStoreDetailUI.v(this.jeK);
      EmojiStoreDetailUI.g(this.jeK);
      paramDialogInterface = new r(EmojiStoreDetailUI.a(this.jeK), 2);
      g.DO().dJT.a(paramDialogInterface, 0);
      return;
      g.DO().dJT.c(EmojiStoreDetailUI.s(this.jeK));
      break;
      label252:
      EmojiStoreDetailUI.a(this.jeK, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.8
 * JD-Core Version:    0.7.0.1
 */