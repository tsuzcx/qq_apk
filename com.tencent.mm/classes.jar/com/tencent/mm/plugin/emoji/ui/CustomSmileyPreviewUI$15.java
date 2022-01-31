package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.sdk.platformtools.ab;

final class CustomSmileyPreviewUI$15
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$15(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138345);
    if ((CustomSmileyPreviewUI.h(this.lkP) != null) && (CustomSmileyPreviewUI.h(this.lkP).xbf != null))
    {
      paramView = new Intent();
      paramView.setClass(this.lkP.getContext(), EmojiStoreV2DesignerUI.class);
      paramView.putExtra("uin", CustomSmileyPreviewUI.h(this.lkP).xbf.DesignerUin);
      paramView.putExtra("name", CustomSmileyPreviewUI.h(this.lkP).xbf.Name);
      paramView.putExtra("headurl", CustomSmileyPreviewUI.h(this.lkP).xbf.HeadUrl);
      paramView.putExtra("extra_scence", 9);
      this.lkP.getContext().startActivity(paramView);
      AppMethodBeat.o(138345);
      return;
    }
    ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
    AppMethodBeat.o(138345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.15
 * JD-Core Version:    0.7.0.1
 */