package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Message;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class EmojiStoreV2RewardThanksUI$1
  extends ak
{
  EmojiStoreV2RewardThanksUI$1(EmojiStoreV2RewardThanksUI paramEmojiStoreV2RewardThanksUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53688);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53688);
      return;
      paramMessage = (String)paramMessage.obj;
      if ((!bo.isNullOrNil(paramMessage)) && (e.cN(paramMessage)))
      {
        EmojiStoreV2RewardThanksUI.a(this.lqn).setImageFilePath(paramMessage);
        EmojiStoreV2RewardThanksUI.a(this.lqn).setScaleType(ImageView.ScaleType.FIT_XY);
        if ((EmojiStoreV2RewardThanksUI.b(this.lqn) != null) && (EmojiStoreV2RewardThanksUI.b(this.lqn).isRunning()))
        {
          EmojiStoreV2RewardThanksUI.b(this.lqn).stop();
          AppMethodBeat.o(53688);
        }
      }
      else
      {
        ab.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI.1
 * JD-Core Version:    0.7.0.1
 */