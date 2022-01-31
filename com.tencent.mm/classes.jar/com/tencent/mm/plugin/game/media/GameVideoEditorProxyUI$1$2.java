package com.tencent.mm.plugin.game.media;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class GameVideoEditorProxyUI$1$2
  implements n.c
{
  GameVideoEditorProxyUI$1$2(GameVideoEditorProxyUI.1 param1) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(151869);
    paraml.clear();
    int i = 0;
    while (i < GameVideoEditorProxyUI.b(this.nlP.nlN).size())
    {
      GameShareOption localGameShareOption = (GameShareOption)GameVideoEditorProxyUI.b(this.nlP.nlN).valueAt(i);
      paraml.e(localGameShareOption.id, localGameShareOption.title);
      i += 1;
    }
    AppMethodBeat.o(151869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.1.2
 * JD-Core Version:    0.7.0.1
 */