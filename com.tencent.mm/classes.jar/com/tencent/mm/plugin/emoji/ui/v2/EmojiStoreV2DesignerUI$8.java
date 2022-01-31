package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;

final class EmojiStoreV2DesignerUI$8
  implements ao.b.a
{
  EmojiStoreV2DesignerUI$8(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(53586);
    ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      EmojiStoreV2DesignerUI.a(this.lpI, ((j)g.E(j.class)).YA().arw(paramString));
      EmojiStoreV2DesignerUI.a(this.lpI);
    }
    AppMethodBeat.o(53586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.8
 * JD-Core Version:    0.7.0.1
 */