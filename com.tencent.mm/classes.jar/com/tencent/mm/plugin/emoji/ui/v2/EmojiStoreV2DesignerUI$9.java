package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;

final class EmojiStoreV2DesignerUI$9
  implements az.b.a
{
  EmojiStoreV2DesignerUI$9(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void getContactCallBack(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109149);
    Log.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      EmojiStoreV2DesignerUI.a(this.xWy, ((n)h.ax(n.class)).bzA().JE(paramString));
      EmojiStoreV2DesignerUI.a(this.xWy);
    }
    AppMethodBeat.o(109149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.9
 * JD-Core Version:    0.7.0.1
 */