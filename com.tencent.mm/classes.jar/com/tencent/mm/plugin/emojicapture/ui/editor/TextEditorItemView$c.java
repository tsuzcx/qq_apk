package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.graphics.Bitmap;
import android.graphics.Rect;

final class TextEditorItemView$c
  implements Runnable
{
  TextEditorItemView$c(TextEditorItemView paramTextEditorItemView) {}
  
  public final void run()
  {
    if (this.jqJ.getDrawingCache() != null) {
      TextEditorItemView.a(this.jqJ)[TextEditorItemView.b(this.jqJ)] = Bitmap.createBitmap(this.jqJ.getDrawingCache(), TextEditorItemView.c(this.jqJ).left, TextEditorItemView.c(this.jqJ).top, TextEditorItemView.c(this.jqJ).width(), TextEditorItemView.c(this.jqJ).height());
    }
    this.jqJ.destroyDrawingCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView.c
 * JD-Core Version:    0.7.0.1
 */