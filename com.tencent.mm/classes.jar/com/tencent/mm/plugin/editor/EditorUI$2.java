package com.tencent.mm.plugin.editor;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class EditorUI$2
  implements Runnable
{
  EditorUI$2(EditorUI paramEditorUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(181518);
    RecyclerView localRecyclerView = EditorUI.h(this.upk);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(this.bFI, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, locala.aFh(), "com/tencent/mm/plugin/editor/EditorUI$11", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    localRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/editor/EditorUI$11", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(181518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.2
 * JD-Core Version:    0.7.0.1
 */