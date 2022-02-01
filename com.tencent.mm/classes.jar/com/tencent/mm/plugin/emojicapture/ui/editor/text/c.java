package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "text", "", "switchFont", "fontPath", "", "Companion", "plugin-emojicapture_release"})
public abstract interface c
{
  public static final a puG = a.puI;
  
  public abstract void YL(String paramString);
  
  public abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean);
  
  public abstract void refresh();
  
  public abstract void setText(CharSequence paramCharSequence);
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer$Companion;", "", "()V", "ellipsisText", "", "getEllipsisText", "()Ljava/lang/String;", "plugin-emojicapture_release"})
  public static final class a
  {
    private static final String puH = "...";
    
    static
    {
      AppMethodBeat.i(827);
      puI = new a();
      puH = "...";
      AppMethodBeat.o(827);
    }
    
    public static String cfW()
    {
      return puH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.c
 * JD-Core Version:    0.7.0.1
 */