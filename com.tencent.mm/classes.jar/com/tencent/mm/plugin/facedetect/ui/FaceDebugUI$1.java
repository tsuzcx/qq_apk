package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceDebugUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FaceDebugUI$1(FaceDebugUI paramFaceDebugUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(356);
    this.mkx.finish();
    AppMethodBeat.o(356);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDebugUI.1
 * JD-Core Version:    0.7.0.1
 */