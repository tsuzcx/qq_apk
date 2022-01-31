package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;

final class EmojiStoreDetailUI$17
  implements View.OnClickListener
{
  EmojiStoreDetailUI$17(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53434);
    paramView = new Intent();
    paramView.setClass(this.lnA, EmojiStoreV2RewardUI.class);
    paramView.putExtra("extra_id", EmojiStoreDetailUI.a(this.lnA));
    paramView.putExtra("extra_name", EmojiStoreDetailUI.b(this.lnA).PackName);
    if ((EmojiStoreDetailUI.b(this.lnA) != null) && (EmojiStoreDetailUI.b(this.lnA).PersonalDesigner != null)) {
      paramView.putExtra("name", EmojiStoreDetailUI.b(this.lnA).PersonalDesigner.Name);
    }
    paramView.putExtra("scene", EmojiStoreDetailUI.c(this.lnA));
    paramView.putExtra("pageType", 1);
    paramView.putExtra("searchID", EmojiStoreDetailUI.d(this.lnA));
    this.lnA.startActivity(paramView);
    h.qsU.e(12738, new Object[] { EmojiStoreDetailUI.a(this.lnA), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(this.lnA)), Integer.valueOf(0) });
    AppMethodBeat.o(53434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.17
 * JD-Core Version:    0.7.0.1
 */