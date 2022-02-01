package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;

final class EmojiStoreV2DesignerUI$8
  implements ar.b.a
{
  EmojiStoreV2DesignerUI$8(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109149);
    ac.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      EmojiStoreV2DesignerUI.a(this.pjx, ((k)g.ab(k.class)).awB().aNt(paramString));
      EmojiStoreV2DesignerUI.a(this.pjx);
    }
    AppMethodBeat.o(109149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.8
 * JD-Core Version:    0.7.0.1
 */