package com.tencent.mm.plugin.editor;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.adapter.a;

final class EditorUI$a
  extends a
{
  EditorUI$a(EditorUI paramEditorUI) {}
  
  public final void cCV()
  {
    AppMethodBeat.i(181547);
    EditorUI.m(this.qNX);
    AppMethodBeat.o(181547);
  }
  
  public final void cCW()
  {
    AppMethodBeat.i(181548);
    this.qNX.showActionbarLine();
    EditorUI.m(this.qNX);
    AppMethodBeat.o(181548);
  }
  
  public final void cCX()
  {
    AppMethodBeat.i(181549);
    this.qNX.hideActionbarLine();
    AppMethodBeat.o(181549);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(181550);
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    AppMethodBeat.o(181550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.EditorUI.a
 * JD-Core Version:    0.7.0.1
 */