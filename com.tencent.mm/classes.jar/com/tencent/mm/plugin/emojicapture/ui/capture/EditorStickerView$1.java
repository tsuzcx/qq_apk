package com.tencent.mm.plugin.emojicapture.ui.capture;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.layout.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView$1", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorStickerView$1
  implements c.a
{
  EditorStickerView$1(EditorStickerView paramEditorStickerView) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(629);
    Log.i(EditorStickerView.g(this.ylr), s.X("onPageSelected: ", Integer.valueOf(paramInt)));
    EditorStickerView.a(this.ylr, paramInt);
    AppMethodBeat.o(629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView.1
 * JD-Core Version:    0.7.0.1
 */