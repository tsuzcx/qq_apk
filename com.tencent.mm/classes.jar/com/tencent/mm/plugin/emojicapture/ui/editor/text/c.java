package com.tencent.mm.plugin.emojicapture.ui.editor.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer;", "", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "lineStart", "", "lineEnd", "x", "", "y", "paint", "Landroid/graphics/Paint;", "withEllipsis", "", "refresh", "setText", "text", "", "switchFont", "fontPath", "", "Companion", "plugin-emojicapture_release"})
public abstract interface c
{
  public static final a vbs = a.vbu;
  
  public abstract void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint, boolean paramBoolean);
  
  public abstract void avq(String paramString);
  
  public abstract void bfU();
  
  public abstract void setText(CharSequence paramCharSequence);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/text/TextDrawer$Companion;", "", "()V", "ellipsisText", "", "getEllipsisText", "()Ljava/lang/String;", "plugin-emojicapture_release"})
  public static final class a
  {
    private static final String vbt = "...";
    
    static
    {
      AppMethodBeat.i(827);
      vbu = new a();
      vbt = "...";
      AppMethodBeat.o(827);
    }
    
    public static String cYC()
    {
      return vbt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.text.c
 * JD-Core Version:    0.7.0.1
 */