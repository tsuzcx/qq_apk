package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "text", "", "switchFont", "fontPath", "", "Companion", "plugin-emojicapture_release"})
public abstract interface c
{
  public static final c.a qeQ = c.a.qeS;
  
  public abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean);
  
  public abstract void adi(String paramString);
  
  public abstract void refresh();
  
  public abstract void setText(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.c
 * JD-Core Version:    0.7.0.1
 */