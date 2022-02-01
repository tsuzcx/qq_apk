package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class EmojiStoreV2DesignerUI$16
  implements MenuItem.OnMenuItemClickListener
{
  EmojiStoreV2DesignerUI$16(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(270802);
    Log.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
    EmojiStoreV2DesignerUI.k(this.xWy);
    AppMethodBeat.o(270802);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.16
 * JD-Core Version:    0.7.0.1
 */