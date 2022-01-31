package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.sdk.platformtools.ah;

final class EmojiStoreV2DesignerUI$9
  extends ah
{
  EmojiStoreV2DesignerUI$9(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            EmojiStoreV2DesignerUI.b(this.jgP);
            return;
            this.jgP.fl(false);
            return;
            EmojiStoreV2DesignerUI.c(this.jgP);
            return;
          } while ((EmojiStoreV2DesignerUI.d(this.jgP) == null) || (paramMessage.getData() == null));
          str = paramMessage.getData().getString("product_id");
        } while (str == null);
        i = paramMessage.getData().getInt("progress");
        EmojiStoreV2DesignerUI.d(this.jgP).bu(str, i);
        return;
      } while ((EmojiStoreV2DesignerUI.d(this.jgP) == null) || (paramMessage.getData() == null));
      str = paramMessage.getData().getString("product_id");
    } while (str == null);
    int i = paramMessage.getData().getInt("status");
    EmojiStoreV2DesignerUI.d(this.jgP).bt(str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.9
 * JD-Core Version:    0.7.0.1
 */