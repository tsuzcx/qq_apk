package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Message;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class EmojiStoreV2RewardThanksUI$1
  extends ah
{
  EmojiStoreV2RewardThanksUI$1(EmojiStoreV2RewardThanksUI paramEmojiStoreV2RewardThanksUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (String)paramMessage.obj;
      if ((bk.bl(paramMessage)) || (!e.bK(paramMessage))) {
        break;
      }
      EmojiStoreV2RewardThanksUI.a(this.jht).setImageFilePath(paramMessage);
      EmojiStoreV2RewardThanksUI.a(this.jht).setScaleType(ImageView.ScaleType.FIT_XY);
    } while ((EmojiStoreV2RewardThanksUI.b(this.jht) == null) || (!EmojiStoreV2RewardThanksUI.b(this.jht).isRunning()));
    EmojiStoreV2RewardThanksUI.b(this.jht).stop();
    return;
    y.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI.1
 * JD-Core Version:    0.7.0.1
 */