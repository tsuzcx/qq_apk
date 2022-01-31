package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.sdk.platformtools.ab;

final class EmojiStoreDetailUI$8
  implements DialogInterface.OnClickListener
{
  EmojiStoreDetailUI$8(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(53427);
    if (com.tencent.mm.plugin.emoji.h.a.Lj(EmojiStoreDetailUI.a(this.lnA)))
    {
      ab.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
      com.tencent.mm.plugin.emoji.f.a.blw().bly();
      if (!TextUtils.isEmpty(EmojiStoreDetailUI.t(this.lnA)))
      {
        f.afO().sJ(EmojiStoreDetailUI.t(this.lnA));
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", new Object[] { EmojiStoreDetailUI.t(this.lnA) });
      }
      if ((!e.ea(EmojiStoreDetailUI.b(this.lnA).PackFlag, 1)) && (!e.uo(EmojiStoreDetailUI.b(this.lnA).PackType))) {
        break label262;
      }
      EmojiStoreDetailUI.a(this.lnA, 3);
    }
    for (;;)
    {
      i.blu().g(EmojiStoreDetailUI.a(this.lnA), EmojiStoreDetailUI.u(this.lnA), 0, EmojiStoreDetailUI.t(this.lnA));
      EmojiStoreDetailUI.i(this.lnA).setVisibility(8);
      EmojiStoreDetailUI.l(this.lnA).setProgress(0);
      EmojiStoreDetailUI.j(this.lnA).setVisibility(4);
      EmojiStoreDetailUI.h(this.lnA).setVisibility(0);
      EmojiStoreDetailUI.v(this.lnA);
      EmojiStoreDetailUI.g(this.lnA);
      paramDialogInterface = new q(EmojiStoreDetailUI.a(this.lnA), 2);
      g.RK().eHt.a(paramDialogInterface, 0);
      AppMethodBeat.o(53427);
      return;
      g.RK().eHt.a(EmojiStoreDetailUI.s(this.lnA));
      break;
      label262:
      EmojiStoreDetailUI.a(this.lnA, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.8
 * JD-Core Version:    0.7.0.1
 */