package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class EmojiStoreV2RewardThanksUI$3
  implements i
{
  EmojiStoreV2RewardThanksUI$3(EmojiStoreV2RewardThanksUI paramEmojiStoreV2RewardThanksUI, String paramString1, String paramString2) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(53690);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase(this.lqo)))
    {
      paramString = new Message();
      paramString.what = 1001;
      paramString.obj = this.val$path;
      EmojiStoreV2RewardThanksUI.c(this.lqn).sendMessage(paramString);
    }
    AppMethodBeat.o(53690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI.3
 * JD-Core Version:    0.7.0.1
 */