package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class EmojiStoreV2RewardUI$7
  implements i
{
  EmojiStoreV2RewardUI$7(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI, String paramString1, String paramString2) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    if ((!bk.bl(paramString)) && (paramString.equalsIgnoreCase(this.jhL)))
    {
      paramString = new Message();
      paramString.what = 1001;
      paramString.obj = this.dlh;
      EmojiStoreV2RewardUI.j(this.jhK).sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.7
 * JD-Core Version:    0.7.0.1
 */