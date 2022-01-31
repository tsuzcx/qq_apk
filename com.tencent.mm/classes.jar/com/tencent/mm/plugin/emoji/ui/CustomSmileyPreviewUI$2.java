package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.bel;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class CustomSmileyPreviewUI$2
  implements Runnable
{
  CustomSmileyPreviewUI$2(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void run()
  {
    if ((CustomSmileyPreviewUI.k(this.jcf) != null) && (CustomSmileyPreviewUI.k(this.jcf).tcR != null))
    {
      CustomSmileyPreviewUI.l(this.jcf).setVisibility(0);
      CustomSmileyPreviewUI.m(this.jcf).setText(CustomSmileyPreviewUI.k(this.jcf).tcR.kRZ);
      if (bk.bl(CustomSmileyPreviewUI.k(this.jcf).tcR.kSy)) {
        CustomSmileyPreviewUI.n(this.jcf).setVisibility(8);
      }
      for (;;)
      {
        CustomSmileyPreviewUI.o(this.jcf).setText(f.h.emoji_activity_detail);
        CustomSmileyPreviewUI.l(this.jcf).setOnClickListener(new CustomSmileyPreviewUI.2.1(this));
        CustomSmileyPreviewUI.p(this.jcf).setVisibility(8);
        return;
        CustomSmileyPreviewUI.n(this.jcf).setVisibility(0);
        o.ON().a(CustomSmileyPreviewUI.k(this.jcf).tcR.kSy, CustomSmileyPreviewUI.n(this.jcf), e.cL(CustomSmileyPreviewUI.b(this.jcf).field_groupId, CustomSmileyPreviewUI.k(this.jcf).tcR.kSy));
      }
    }
    if ((CustomSmileyPreviewUI.j(this.jcf) != null) && (CustomSmileyPreviewUI.j(this.jcf).tcO != null))
    {
      CustomSmileyPreviewUI.l(this.jcf).setVisibility(0);
      CustomSmileyPreviewUI.m(this.jcf).setText(CustomSmileyPreviewUI.j(this.jcf).tcO.kRZ);
      o.ON().a(CustomSmileyPreviewUI.j(this.jcf).tcO.sSy, CustomSmileyPreviewUI.n(this.jcf), e.cK(CustomSmileyPreviewUI.b(this.jcf).field_groupId, CustomSmileyPreviewUI.j(this.jcf).tcO.sSy));
      CustomSmileyPreviewUI.p(this.jcf).setVisibility(8);
      return;
    }
    CustomSmileyPreviewUI.l(this.jcf).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */