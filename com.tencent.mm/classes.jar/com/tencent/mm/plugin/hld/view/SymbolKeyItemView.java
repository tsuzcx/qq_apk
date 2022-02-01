package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.hld.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/SymbolKeyItemView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "v", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textPaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setTextSizeDp", "dp", "setTextSizePixel", "size", "Companion", "plugin-hld_release"})
public final class SymbolKeyItemView
  extends View
{
  private static Integer DIu;
  public static final a DJo;
  private final Paint ciV;
  private String text;
  
  static
  {
    AppMethodBeat.i(215381);
    DJo = new a((byte)0);
    AppMethodBeat.o(215381);
  }
  
  public SymbolKeyItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(215378);
    paramContext = new Paint();
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    paramContext.setColor(a.hj(paramAttributeSet));
    paramContext.setAntiAlias(true);
    paramContext.setTextAlign(Paint.Align.CENTER);
    this.ciV = paramContext;
    this.text = "";
    AppMethodBeat.o(215378);
  }
  
  public SymbolKeyItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(215380);
    paramContext = new Paint();
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    paramContext.setColor(a.hj(paramAttributeSet));
    paramContext.setAntiAlias(true);
    paramContext.setTextAlign(Paint.Align.CENTER);
    this.ciV = paramContext;
    this.text = "";
    AppMethodBeat.o(215380);
  }
  
  public final String getText()
  {
    return this.text;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(215373);
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    float f3 = this.ciV.getTextSize() / 2.0F;
    if (paramCanvas != null)
    {
      paramCanvas.drawText(this.text, f1, f2 + f3, this.ciV);
      AppMethodBeat.o(215373);
      return;
    }
    AppMethodBeat.o(215373);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(215375);
    p.k(paramString, "v");
    this.text = paramString;
    invalidate();
    AppMethodBeat.o(215375);
  }
  
  public final void setTextSizeDp(int paramInt)
  {
    AppMethodBeat.i(215376);
    this.ciV.setTextSize(a.fromDPToPix(getContext(), paramInt));
    invalidate();
    AppMethodBeat.o(215376);
  }
  
  public final void setTextSizePixel(int paramInt)
  {
    AppMethodBeat.i(215377);
    this.ciV.setTextSize(paramInt);
    invalidate();
    AppMethodBeat.o(215377);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/SymbolKeyItemView$Companion;", "", "()V", "textColor", "", "Ljava/lang/Integer;", "getTextColor", "context", "Landroid/content/Context;", "plugin-hld_release"})
  public static final class a
  {
    static int hj(Context paramContext)
    {
      AppMethodBeat.i(209138);
      Integer localInteger = SymbolKeyItemView.eHH();
      if (localInteger != null)
      {
        i = localInteger.intValue();
        AppMethodBeat.o(209138);
        return i;
      }
      int i = a.w(paramContext, a.c.ime_key_text_color);
      SymbolKeyItemView.r(Integer.valueOf(i));
      AppMethodBeat.o(209138);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.SymbolKeyItemView
 * JD-Core Version:    0.7.0.1
 */