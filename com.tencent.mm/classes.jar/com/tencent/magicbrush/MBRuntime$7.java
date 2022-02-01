package com.tencent.magicbrush;

import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MBRuntime$7
  implements Runnable
{
  MBRuntime$7(MBRuntime paramMBRuntime, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(175885);
    MagicBrushView localMagicBrushView = this.cwy.Hl().findOrNull(this.cwG);
    if (localMagicBrushView != null) {
      if (this.cwH) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      localMagicBrushView.setOpaque(bool);
      AppMethodBeat.o(175885);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime.7
 * JD-Core Version:    0.7.0.1
 */