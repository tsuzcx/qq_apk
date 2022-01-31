package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.c.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$7", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView$AddTextCallback;", "onCancel", "", "onConfirm", "text", "", "color", "", "plugin-emojicapture_release"})
public final class CaptureEditorContainer$7
  implements EditorChangeTextView.a
{
  public final void i(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(3031);
    if (paramCharSequence != null) {}
    for (paramCharSequence = paramCharSequence.toString();; paramCharSequence = null)
    {
      Object localObject = paramCharSequence;
      if (paramCharSequence != null)
      {
        localObject = paramCharSequence;
        if (paramCharSequence.length() > 50)
        {
          localObject = paramCharSequence.substring(0, 50);
          j.p(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      paramCharSequence = this.lzm.getPresenter();
      if (paramCharSequence != null) {
        paramCharSequence.n((String)localObject, paramInt, true);
      }
      CaptureEditorContainer.l(this.lzm).setShow(false);
      AppMethodBeat.o(3031);
      return;
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(3032);
    b.a locala = this.lzm.getPresenter();
    if (locala != null) {
      locala.n(null, 0, false);
    }
    CaptureEditorContainer.l(this.lzm).setShow(false);
    AppMethodBeat.o(3032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.7
 * JD-Core Version:    0.7.0.1
 */