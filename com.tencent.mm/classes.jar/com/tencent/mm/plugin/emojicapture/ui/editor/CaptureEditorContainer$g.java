package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.b.g;
import com.tencent.mm.plugin.emojicapture.c.b.a;

public final class CaptureEditorContainer$g
  implements EditorChangeTextView.a
{
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
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
          g.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      this.jpF.getPresenter().b((String)localObject, paramInt1, paramInt2, true);
      CaptureEditorContainer.c(this.jpF).setVisibility(8);
      return;
    }
  }
  
  public final void onCancel()
  {
    this.jpF.getPresenter().b(null, 0, 0, false);
    CaptureEditorContainer.c(this.jpF).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.g
 * JD-Core Version:    0.7.0.1
 */