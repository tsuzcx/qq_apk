package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.f.a;
import com.tencent.mm.plugin.emojicapture.f.a.a;

final class CaptureEditorContainer$a
  implements View.OnClickListener
{
  CaptureEditorContainer$a(CaptureEditorContainer paramCaptureEditorContainer) {}
  
  public final void onClick(View paramView)
  {
    paramView = a.jnW;
    a.a.a(10, 0L, 0L, 0L);
    CaptureEditorContainer.a(this.jpF).setActivated(this.jpF.getPresenter().aJQ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.a
 * JD-Core Version:    0.7.0.1
 */