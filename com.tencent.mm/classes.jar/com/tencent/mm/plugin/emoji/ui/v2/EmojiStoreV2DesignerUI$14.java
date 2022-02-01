package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class EmojiStoreV2DesignerUI$14
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2DesignerUI$14(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(109155);
    Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
    EmojiStoreV2DesignerUI.j(this.uNO);
    AppMethodBeat.o(109155);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.14
 * JD-Core Version:    0.7.0.1
 */