package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emojicapture.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class CustomSmileyPreviewUI$4
  implements n.d
{
  CustomSmileyPreviewUI$4(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 0: 
      Object localObject;
      do
      {
        return;
        paramMenuItem = this.jcf;
        localObject = paramMenuItem.getIntent().getStringExtra("custom_smiley_preview_md5");
        localObject = i.getEmojiStorageMgr().uBb.acC((String)localObject);
        if (localObject == null)
        {
          y.w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
          return;
        }
      } while (((EmojiInfo)localObject).field_catalog == EmojiInfo.uCV);
      if (((EmojiInfo)localObject).field_catalog == EmojiInfo.uCZ)
      {
        com.tencent.mm.ui.base.h.bC(paramMenuItem, paramMenuItem.getString(f.h.app_added));
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(12789, new Object[] { Integer.valueOf(3), ((EmojiInfo)localObject).Wv(), Integer.valueOf(1), ((EmojiInfo)localObject).field_designerID, ((EmojiInfo)localObject).field_groupId, "", "", "", "", "", ((EmojiInfo)localObject).field_activityid });
      i.aHP().a(paramMenuItem.mController.uMN, (EmojiInfo)localObject, 4, paramMenuItem.jcb);
      return;
    case 1: 
      CustomSmileyPreviewUI.q(this.jcf);
      return;
    case 3: 
      CustomSmileyPreviewUI.r(this.jcf);
      return;
    }
    b.ae(this.jcf, CustomSmileyPreviewUI.b(this.jcf).Wv());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */