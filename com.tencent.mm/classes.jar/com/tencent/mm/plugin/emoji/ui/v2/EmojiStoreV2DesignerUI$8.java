package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;

final class EmojiStoreV2DesignerUI$8
  implements am.b.a
{
  EmojiStoreV2DesignerUI$8(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      EmojiStoreV2DesignerUI.a(this.jgP, ((j)g.r(j.class)).Fw().abl(paramString));
      EmojiStoreV2DesignerUI.a(this.jgP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.8
 * JD-Core Version:    0.7.0.1
 */