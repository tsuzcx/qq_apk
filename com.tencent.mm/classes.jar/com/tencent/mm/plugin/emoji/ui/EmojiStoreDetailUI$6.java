package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;

final class EmojiStoreDetailUI$6
  implements View.OnClickListener
{
  EmojiStoreDetailUI$6(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53425);
    paramView = new Intent();
    paramView.setClass(this.lnA.getContext(), EmojiStoreV2DesignerUI.class);
    paramView.putExtra("uin", EmojiStoreDetailUI.b(this.lnA).PersonalDesigner.DesignerUin);
    paramView.putExtra("name", EmojiStoreDetailUI.b(this.lnA).PersonalDesigner.Name);
    paramView.putExtra("headurl", EmojiStoreDetailUI.b(this.lnA).PersonalDesigner.HeadUrl);
    paramView.putExtra("rediret_url", EmojiStoreDetailUI.b(this.lnA).OldRedirectUrl);
    paramView.putExtra("searchID", EmojiStoreDetailUI.d(this.lnA));
    paramView.putExtra("extra_scence", 26);
    this.lnA.getContext().startActivity(paramView);
    AppMethodBeat.o(53425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.6
 * JD-Core Version:    0.7.0.1
 */