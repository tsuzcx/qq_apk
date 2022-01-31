package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class EmojiStoreV2RewardUI$5
  implements i
{
  EmojiStoreV2RewardUI$5(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(53699);
    if ((!bo.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase(EmojiStoreV2RewardUI.i(this.lqH))))
    {
      paramString = new Message();
      paramString.what = 1001;
      paramString.obj = EmojiStoreV2RewardUI.j(this.lqH);
      EmojiStoreV2RewardUI.k(this.lqH).sendMessage(paramString);
    }
    AppMethodBeat.o(53699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.5
 * JD-Core Version:    0.7.0.1
 */