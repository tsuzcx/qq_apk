package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CustomSmileyPreviewUI$13
  implements View.OnClickListener
{
  CustomSmileyPreviewUI$13(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    if ((CustomSmileyPreviewUI.j(this.jcf) != null) && (CustomSmileyPreviewUI.j(this.jcf).tcO != null))
    {
      paramView = new Intent();
      paramView.setClass(this.jcf.mController.uMN, EmojiStoreV2DesignerUI.class);
      paramView.putExtra("uin", CustomSmileyPreviewUI.j(this.jcf).tcO.tcH);
      paramView.putExtra("name", CustomSmileyPreviewUI.j(this.jcf).tcO.kRZ);
      paramView.putExtra("headurl", CustomSmileyPreviewUI.j(this.jcf).tcO.sSy);
      paramView.putExtra("extra_scence", 9);
      this.jcf.mController.uMN.startActivity(paramView);
      return;
    }
    y.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.13
 * JD-Core Version:    0.7.0.1
 */