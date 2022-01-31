package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import a.v;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorItemContainer$d
  implements Runnable
{
  EditorItemContainer$d(EditorItemContainer paramEditorItemContainer) {}
  
  public final void run()
  {
    AppMethodBeat.i(3074);
    if (EditorItemContainer.a(this.lzL) != null)
    {
      Object localObject = EditorItemContainer.a(this.lzL);
      if (localObject == null) {
        j.ebi();
      }
      if (!((a)localObject).bpe())
      {
        localObject = EditorItemContainer.c(this.lzL);
        a locala = EditorItemContainer.a(this.lzL);
        if (locala == null)
        {
          localObject = new v("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(3074);
          throw ((Throwable)localObject);
        }
        ((ViewGroup)localObject).removeView((View)locala);
      }
    }
    EditorItemContainer.b(this.lzL);
    EditorItemContainer.e(this.lzL);
    AppMethodBeat.o(3074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer.d
 * JD-Core Version:    0.7.0.1
 */