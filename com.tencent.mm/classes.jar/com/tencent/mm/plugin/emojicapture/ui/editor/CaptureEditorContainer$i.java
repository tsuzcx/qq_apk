package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.b.g;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r.a;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.sdk.platformtools.y;

public final class CaptureEditorContainer$i
  implements r.a
{
  public final void a(j paramj)
  {
    g.k(paramj, "emojiInfo");
    y.i(CaptureEditorContainer.e(this.jpF), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramj });
    this.jpF.getPresenter().c(paramj);
    onHide();
  }
  
  public final void onHide()
  {
    this.jpF.fs(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.i
 * JD-Core Version:    0.7.0.1
 */