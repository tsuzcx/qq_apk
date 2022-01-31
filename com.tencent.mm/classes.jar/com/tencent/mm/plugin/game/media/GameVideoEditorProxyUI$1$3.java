package com.tencent.mm.plugin.game.media;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class GameVideoEditorProxyUI$1$3
  implements n.d
{
  GameVideoEditorProxyUI$1$3(GameVideoEditorProxyUI.1 param1, Bundle paramBundle, CaptureDataManager.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(151870);
    ab.i("MicroMsg.GameVideoEditorProxyUI", "hy: user selected: %d", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
    paramMenuItem = (GameShareOption)GameVideoEditorProxyUI.b(this.nlP.nlN).get(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.hmS.putInt("key_selected_item", paramMenuItem.id);
      this.nlQ.cgo();
      AppMethodBeat.o(151870);
      return;
    }
    ab.e("MicroMsg.GameVideoEditorProxyUI", "hy: non option!!");
    AppMethodBeat.o(151870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.1.3
 * JD-Core Version:    0.7.0.1
 */