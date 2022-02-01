package com.tencent.mm.plugin.editor;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.adapter.a;

final class EditorUI$a
  extends a
{
  EditorUI$a(EditorUI paramEditorUI) {}
  
  public final void cRA()
  {
    AppMethodBeat.i(181547);
    EditorUI.m(this.upk);
    AppMethodBeat.o(181547);
  }
  
  public final void cRB()
  {
    AppMethodBeat.i(181548);
    this.upk.showActionbarLine();
    EditorUI.m(this.upk);
    AppMethodBeat.o(181548);
  }
  
  public final void cRC()
  {
    AppMethodBeat.i(181549);
    this.upk.hideActionbarLine();
    AppMethodBeat.o(181549);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(187589);
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    AppMethodBeat.o(187589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.a
 * JD-Core Version:    0.7.0.1
 */