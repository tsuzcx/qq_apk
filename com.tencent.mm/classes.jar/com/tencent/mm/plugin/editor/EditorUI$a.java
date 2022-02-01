package com.tencent.mm.plugin.editor;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.adapter.a;

final class EditorUI$a
  extends a
{
  EditorUI$a(EditorUI paramEditorUI) {}
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(181550);
    super.b(paramRecyclerView, paramInt);
    AppMethodBeat.o(181550);
  }
  
  public final void bZm()
  {
    AppMethodBeat.i(181547);
    EditorUI.m(this.oOs);
    AppMethodBeat.o(181547);
  }
  
  public final void bZn()
  {
    AppMethodBeat.i(181548);
    this.oOs.showActionbarLine();
    EditorUI.m(this.oOs);
    AppMethodBeat.o(181548);
  }
  
  public final void bZo()
  {
    AppMethodBeat.i(181549);
    this.oOs.hideActionbarLine();
    AppMethodBeat.o(181549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.a
 * JD-Core Version:    0.7.0.1
 */