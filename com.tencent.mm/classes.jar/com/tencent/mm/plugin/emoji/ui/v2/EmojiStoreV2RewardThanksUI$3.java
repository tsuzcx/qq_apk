package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

final class EmojiStoreV2RewardThanksUI$3
  implements k
{
  EmojiStoreV2RewardThanksUI$3(EmojiStoreV2RewardThanksUI paramEmojiStoreV2RewardThanksUI, String paramString1, String paramString2) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(109265);
    if ((!bs.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase(this.pki)))
    {
      paramString = new Message();
      paramString.what = 1001;
      paramString.obj = this.val$path;
      EmojiStoreV2RewardThanksUI.c(this.pkh).sendMessage(paramString);
    }
    AppMethodBeat.o(109265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI.3
 * JD-Core Version:    0.7.0.1
 */