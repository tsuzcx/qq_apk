package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class EmojiStoreV2SingleProductUI$1
  extends ak
{
  EmojiStoreV2SingleProductUI$1(EmojiStoreV2SingleProductUI paramEmojiStoreV2SingleProductUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53744);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53744);
      return;
      if (EmojiStoreV2SingleProductUI.a(this.lrz) != null)
      {
        EmojiStoreV2SingleProductUI.a(this.lrz).setVisibility(8);
        AppMethodBeat.o(53744);
        return;
        if (EmojiStoreV2SingleProductUI.a(this.lrz) != null) {
          EmojiStoreV2SingleProductUI.a(this.lrz).setVisibility(0);
        }
        sendEmptyMessage(1003);
        AppMethodBeat.o(53744);
        return;
        EmojiStoreV2SingleProductUI.b(this.lrz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.1
 * JD-Core Version:    0.7.0.1
 */