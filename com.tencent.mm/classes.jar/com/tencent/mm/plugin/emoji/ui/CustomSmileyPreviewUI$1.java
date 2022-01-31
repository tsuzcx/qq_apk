package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class CustomSmileyPreviewUI$1
  extends ah
{
  CustomSmileyPreviewUI$1(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while (CustomSmileyPreviewUI.a(this.jcf) == null);
        CustomSmileyPreviewUI.a(this.jcf).setText(((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(CustomSmileyPreviewUI.b(this.jcf).Wv()));
        return;
        CustomSmileyPreviewUI.a(this.jcf, CustomSmileyPreviewUI.c(this.jcf), CustomSmileyPreviewUI.b(this.jcf));
        return;
        i = paramMessage.getData().getInt("progress");
        paramMessage = paramMessage.getData().getString("product_id");
        if (bk.bl(paramMessage))
        {
          y.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
          return;
        }
      } while ((CustomSmileyPreviewUI.d(this.jcf) == null) || (CustomSmileyPreviewUI.d(this.jcf).iVI == null));
      CustomSmileyPreviewUI.d(this.jcf).bu(paramMessage, i);
      CustomSmileyPreviewUI.d(this.jcf).aqU();
      return;
      i = paramMessage.getData().getInt("status");
      paramMessage = paramMessage.getData().getString("product_id");
      if (bk.bl(paramMessage))
      {
        y.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
        return;
      }
    } while ((CustomSmileyPreviewUI.d(this.jcf) == null) || (CustomSmileyPreviewUI.d(this.jcf).iVI == null));
    CustomSmileyPreviewUI.d(this.jcf).bt(paramMessage, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.1
 * JD-Core Version:    0.7.0.1
 */