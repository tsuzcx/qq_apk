package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class GameVideoEditorProxyUI$1
  implements CaptureDataManager.b
{
  GameVideoEditorProxyUI$1(GameVideoEditorProxyUI paramGameVideoEditorProxyUI) {}
  
  public final void a(Context paramContext, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(151871);
    a.post(new GameVideoEditorProxyUI.1.1(this, paramContext, paramCaptureVideoNormalModel, paramBundle));
    AppMethodBeat.o(151871);
  }
  
  public final boolean a(Context paramContext, Bundle paramBundle, CaptureDataManager.a parama)
  {
    AppMethodBeat.i(151872);
    if ((GameVideoEditorProxyUI.a(this.nlN) == 2) && (GameVideoEditorProxyUI.b(this.nlN) != null) && (GameVideoEditorProxyUI.b(this.nlN).size() > 1))
    {
      ab.i("MicroMsg.GameVideoEditorProxyUI", "hy: more than 1 share options and need to show actionsheet");
      if (GameVideoEditorProxyUI.c(this.nlN) != null) {
        GameVideoEditorProxyUI.c(this.nlN).cre();
      }
      GameVideoEditorProxyUI.a(this.nlN, new d(paramContext, 1, false));
      GameVideoEditorProxyUI.c(this.nlN).sao = new GameVideoEditorProxyUI.1.2(this);
      GameVideoEditorProxyUI.c(this.nlN).sap = new GameVideoEditorProxyUI.1.3(this, paramBundle, parama);
      GameVideoEditorProxyUI.c(this.nlN).crd();
      AppMethodBeat.o(151872);
      return true;
    }
    AppMethodBeat.o(151872);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoEditorProxyUI.1
 * JD-Core Version:    0.7.0.1
 */