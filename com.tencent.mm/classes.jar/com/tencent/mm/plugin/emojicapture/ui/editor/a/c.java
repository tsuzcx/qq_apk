package com.tencent.mm.plugin.emojicapture.ui.editor.a;

import a.l;
import android.graphics.Canvas;
import android.graphics.Paint;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "text", "", "switchFont", "fontPath", "", "Companion", "plugin-emojicapture_release"})
public abstract interface c
{
  public static final c.a lAC = c.a.lAE;
  
  public abstract void Lq(String paramString);
  
  public abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean);
  
  public abstract void refresh();
  
  public abstract void setText(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.a.c
 * JD-Core Version:    0.7.0.1
 */