package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Message;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class EmojiStoreV2RewardUI$1
  extends ah
{
  EmojiStoreV2RewardUI$1(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1001: 
      do
      {
        return;
        paramMessage = (String)paramMessage.obj;
        if ((bk.bl(paramMessage)) || (!e.bK(paramMessage))) {
          break;
        }
        EmojiStoreV2RewardUI.a(this.jhK).setImageFilePath(paramMessage);
        EmojiStoreV2RewardUI.a(this.jhK).setScaleType(ImageView.ScaleType.FIT_XY);
      } while ((EmojiStoreV2RewardUI.b(this.jhK) == null) || (!EmojiStoreV2RewardUI.b(this.jhK).isRunning()));
      EmojiStoreV2RewardUI.b(this.jhK).stop();
      return;
      y.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
      return;
    }
    EmojiStoreV2RewardUI.c(this.jhK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.1
 * JD-Core Version:    0.7.0.1
 */