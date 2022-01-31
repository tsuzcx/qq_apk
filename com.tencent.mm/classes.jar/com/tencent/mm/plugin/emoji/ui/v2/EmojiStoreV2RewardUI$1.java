package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Message;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class EmojiStoreV2RewardUI$1
  extends ak
{
  EmojiStoreV2RewardUI$1(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53695);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53695);
      return;
      paramMessage = (String)paramMessage.obj;
      if ((!bo.isNullOrNil(paramMessage)) && (e.cN(paramMessage)))
      {
        EmojiStoreV2RewardUI.a(this.lqH).setImageFilePath(paramMessage);
        EmojiStoreV2RewardUI.a(this.lqH).setScaleType(ImageView.ScaleType.FIT_XY);
        if ((EmojiStoreV2RewardUI.b(this.lqH) != null) && (EmojiStoreV2RewardUI.b(this.lqH).isRunning()))
        {
          EmojiStoreV2RewardUI.b(this.lqH).stop();
          AppMethodBeat.o(53695);
        }
      }
      else
      {
        ab.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
        AppMethodBeat.o(53695);
        return;
        EmojiStoreV2RewardUI.c(this.lqH);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.1
 * JD-Core Version:    0.7.0.1
 */