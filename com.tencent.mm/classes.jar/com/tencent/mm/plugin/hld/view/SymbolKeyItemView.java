package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.hld.a.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/SymbolKeyItemView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "v", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textPaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setTextSizeDp", "dp", "setTextSizePixel", "size", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SymbolKeyItemView
  extends View
{
  public static final a JAq;
  private static Integer Jzy;
  private final Paint dZu;
  private String text;
  
  static
  {
    AppMethodBeat.i(312658);
    JAq = new a((byte)0);
    AppMethodBeat.o(312658);
  }
  
  public SymbolKeyItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(312648);
    paramContext = new Paint();
    paramAttributeSet = getContext();
    s.s(paramAttributeSet, "context");
    paramContext.setColor(a.iE(paramAttributeSet));
    paramContext.setAntiAlias(true);
    paramContext.setTextAlign(Paint.Align.CENTER);
    paramAttributeSet = ah.aiuX;
    this.dZu = paramContext;
    this.text = "";
    AppMethodBeat.o(312648);
  }
  
  public SymbolKeyItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(312652);
    paramContext = new Paint();
    paramAttributeSet = getContext();
    s.s(paramAttributeSet, "context");
    paramContext.setColor(a.iE(paramAttributeSet));
    paramContext.setAntiAlias(true);
    paramContext.setTextAlign(Paint.Align.CENTER);
    paramAttributeSet = ah.aiuX;
    this.dZu = paramContext;
    this.text = "";
    AppMethodBeat.o(312652);
  }
  
  public final String getText()
  {
    return this.text;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(312661);
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    float f3 = this.dZu.getTextSize() / 2.0F;
    if (paramCanvas != null) {
      paramCanvas.drawText(this.text, f1, f2 + f3, this.dZu);
    }
    AppMethodBeat.o(312661);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(312666);
    s.u(paramString, "v");
    this.text = paramString;
    invalidate();
    AppMethodBeat.o(312666);
  }
  
  public final void setTextSizeDp(int paramInt)
  {
    AppMethodBeat.i(312668);
    this.dZu.setTextSize(a.fromDPToPix(getContext(), paramInt));
    invalidate();
    AppMethodBeat.o(312668);
  }
  
  public final void setTextSizePixel(int paramInt)
  {
    AppMethodBeat.i(312671);
    this.dZu.setTextSize(paramInt);
    invalidate();
    AppMethodBeat.o(312671);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/SymbolKeyItemView$Companion;", "", "()V", "textColor", "", "Ljava/lang/Integer;", "getTextColor", "context", "Landroid/content/Context;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static int iE(Context paramContext)
    {
      AppMethodBeat.i(312463);
      Integer localInteger = SymbolKeyItemView.fPt();
      if (localInteger == null)
      {
        i = a.w(paramContext, a.c.ime_key_text_color);
        paramContext = SymbolKeyItemView.JAq;
        SymbolKeyItemView.y(Integer.valueOf(i));
        AppMethodBeat.o(312463);
        return i;
      }
      int i = localInteger.intValue();
      AppMethodBeat.o(312463);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.SymbolKeyItemView
 * JD-Core Version:    0.7.0.1
 */