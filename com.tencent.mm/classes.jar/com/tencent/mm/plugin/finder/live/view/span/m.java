package com.tencent.mm.plugin.finder.live.view.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan;", "Landroid/text/style/ImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "params", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$ImageSpanParams;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$ImageSpanParams;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$ImageSpanParams;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "Builder", "Companion", "ImageSpanParams", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends ImageSpan
{
  public static final b akfI;
  public c akfJ;
  
  static
  {
    AppMethodBeat.i(371538);
    akfI = new b((byte)0);
    AppMethodBeat.o(371538);
  }
  
  public m(Drawable paramDrawable)
  {
    super(paramDrawable);
    AppMethodBeat.i(371537);
    this.akfJ = new c((byte)0);
    AppMethodBeat.o(371537);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(371540);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    paramCanvas.save();
    paramCharSequence = paramPaint.getFontMetricsInt();
    paramInt2 = paramCharSequence.descent;
    paramInt3 = paramCharSequence.ascent;
    paramInt1 = paramCharSequence.descent;
    paramInt2 = (paramInt2 - paramInt3) / 2;
    paramInt3 = (getDrawable().getBounds().bottom - getDrawable().getBounds().top) / 2;
    paramCanvas.translate(this.akfJ.bmt + paramFloat, paramInt1 + paramInt4 - paramInt2 - paramInt3);
    paramInt1 = paramPaint.getAlpha();
    paramInt2 = getDrawable().getAlpha();
    if ((paramInt1 == 0) && (paramInt2 != paramInt1)) {
      getDrawable().setAlpha(paramInt1);
    }
    getDrawable().draw(paramCanvas);
    getDrawable().setAlpha(paramInt2);
    paramCanvas.restore();
    AppMethodBeat.o(371540);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(371539);
    s.u(paramPaint, "paint");
    paramCharSequence = getDrawable().getBounds();
    s.s(paramCharSequence, "drawable.bounds");
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      paramInt2 = paramPaint.descent;
      i = paramPaint.ascent;
      paramInt1 = paramCharSequence.bottom - paramCharSequence.top;
      paramInt2 = paramPaint.ascent + (paramInt2 - i) / 2;
      paramFontMetricsInt.ascent = (paramInt2 - paramInt1 / 2);
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = (paramInt2 + paramInt1 / 2);
      paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
    }
    paramInt1 = paramCharSequence.right;
    paramInt2 = this.akfJ.bmt;
    int i = this.akfJ.bmu;
    AppMethodBeat.o(371539);
    return paramInt1 + paramInt2 + i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$Builder;", "", "()V", "params", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$ImageSpanParams;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$ImageSpanParams;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$ImageSpanParams;)V", "build", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan;", "setDrawable", "drawable", "Landroid/graphics/drawable/BitmapDrawable;", "setLeftMargin", "leftMargin", "", "setRightMargin", "rightMargin", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public m.c akfJ;
    
    public a()
    {
      AppMethodBeat.i(371541);
      this.akfJ = new m.c((byte)0);
      AppMethodBeat.o(371541);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$Companion;", "", "()V", "TAG", "", "createBuilder", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$Builder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveImageSpan$ImageSpanParams;", "", "bitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "leftMargin", "", "rightMargin", "(Landroid/graphics/drawable/BitmapDrawable;II)V", "getBitmapDrawable", "()Landroid/graphics/drawable/BitmapDrawable;", "setBitmapDrawable", "(Landroid/graphics/drawable/BitmapDrawable;)V", "getLeftMargin", "()I", "setLeftMargin", "(I)V", "getRightMargin", "setRightMargin", "spanWidth", "getSpanWidth", "setSpanWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public BitmapDrawable akfK = null;
    int bmt = 0;
    public int bmu = 0;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(371544);
      if (this == paramObject)
      {
        AppMethodBeat.o(371544);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(371544);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.akfK, paramObject.akfK))
      {
        AppMethodBeat.o(371544);
        return false;
      }
      if (this.bmt != paramObject.bmt)
      {
        AppMethodBeat.o(371544);
        return false;
      }
      if (this.bmu != paramObject.bmu)
      {
        AppMethodBeat.o(371544);
        return false;
      }
      AppMethodBeat.o(371544);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(371543);
      if (this.akfK == null) {}
      for (int i = 0;; i = this.akfK.hashCode())
      {
        int j = this.bmt;
        int k = this.bmu;
        AppMethodBeat.o(371543);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(371542);
      String str = "ImageSpanParams(bitmapDrawable=" + this.akfK + ", leftMargin=" + this.bmt + ", rightMargin=" + this.bmu + ')';
      AppMethodBeat.o(371542);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.m
 * JD-Core Version:    0.7.0.1
 */