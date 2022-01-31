package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.sdk.platformtools.ak;

final class EmojiStoreV2DesignerUI$9
  extends ak
{
  EmojiStoreV2DesignerUI$9(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53587);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53587);
      return;
      EmojiStoreV2DesignerUI.b(this.lpI);
      AppMethodBeat.o(53587);
      return;
      this.lpI.gM(false);
      AppMethodBeat.o(53587);
      return;
      EmojiStoreV2DesignerUI.c(this.lpI);
      AppMethodBeat.o(53587);
      return;
      if ((EmojiStoreV2DesignerUI.d(this.lpI) == null) || (paramMessage.getData() == null))
      {
        AppMethodBeat.o(53587);
        return;
      }
      String str = paramMessage.getData().getString("product_id");
      if (str == null)
      {
        AppMethodBeat.o(53587);
        return;
      }
      int i = paramMessage.getData().getInt("progress");
      EmojiStoreV2DesignerUI.d(this.lpI).bY(str, i);
      AppMethodBeat.o(53587);
      return;
      if ((EmojiStoreV2DesignerUI.d(this.lpI) == null) || (paramMessage.getData() == null))
      {
        AppMethodBeat.o(53587);
        return;
      }
      str = paramMessage.getData().getString("product_id");
      if (str == null)
      {
        AppMethodBeat.o(53587);
        return;
      }
      i = paramMessage.getData().getInt("status");
      EmojiStoreV2DesignerUI.d(this.lpI).bX(str, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.9
 * JD-Core Version:    0.7.0.1
 */