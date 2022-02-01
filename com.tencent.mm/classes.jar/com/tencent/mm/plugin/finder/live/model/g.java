package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;", "(Landroid/graphics/drawable/Drawable;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "italicStr", "spanStr", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "drawBackgroung", "drawText", "normalTextStart", "normalTextEnd", "italicTextStart", "italicTextEnd", "setBgColor", "serverColorStr", "setSpanContent", "Companion", "plugin-finder_release"})
public final class g
  extends ImageSpan
{
  private static final int uiI;
  private static final int uiJ;
  public static final a uiK;
  private final String TAG;
  private String uiF;
  private String uiG;
  private final n uiH;
  
  static
  {
    AppMethodBeat.i(246110);
    uiK = new a((byte)0);
    int i = d.e(MMApplicationContext.getContext(), 2.0F);
    uiI = i;
    uiJ = i * 2;
    AppMethodBeat.o(246110);
  }
  
  public g(Drawable paramDrawable, n paramn)
  {
    super(paramDrawable);
    AppMethodBeat.i(246109);
    this.uiH = paramn;
    this.TAG = "FinderLiveItalicImageSpan";
    this.uiF = "";
    this.uiG = "";
    AppMethodBeat.o(246109);
  }
  
  public final void ag(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(246106);
    p.h(paramString1, "text");
    p.h(paramString2, "spanStr");
    p.h(paramString3, "italicStr");
    n localn = this.uiH;
    paramString1 = (CharSequence)paramString1;
    p.h(paramString1, "<set-?>");
    localn.text = paramString1;
    this.uiF = paramString2;
    this.uiG = paramString3;
    AppMethodBeat.o(246106);
  }
  
  public final void atC(String paramString)
  {
    AppMethodBeat.i(246107);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label95;
      }
      try
      {
        this.uiH.bgColor = Color.parseColor(paramString);
        AppMethodBeat.o(246107);
        return;
      }
      catch (Exception localException)
      {
        f.a.a(c.vVc, "liveInvalidBadgeInfoColor", false, false, null, 28);
        Log.e(this.TAG, localException + ",serverColor:" + paramString);
      }
    }
    label95:
    AppMethodBeat.o(246107);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(246108);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    for (;;)
    {
      try
      {
        j = paramPaint.getColor();
        f1 = paramPaint.getTextSize();
        localTypeface = paramPaint.getTypeface();
        paramInt1 = kotlin.n.n.a(this.uiH.text, this.uiF, 0, false, 6);
        paramInt4 = paramInt1;
        if (paramInt1 < 0) {
          paramInt4 = 0;
        }
        m = this.uiF.length();
        i = paramInt4 + m;
        paramInt1 = this.uiH.text.length();
        paramInt2 = i;
        if (i >= paramInt1) {
          paramInt2 = paramInt1;
        }
        paramCharSequence = this.uiH.text;
        paramPaint.setColor(this.uiH.bgColor);
        paramPaint.setTextSize(this.uiH.textSize);
        f2 = this.uiH.kcc / 2.0F;
        float f3 = (paramInt5 - paramInt3) / 2.0F;
        paramCanvas.drawRoundRect(new RectF(paramFloat, f3 - f2, paramPaint.measureText(paramCharSequence, paramInt4, paramInt2) + this.uiH.ujl + this.uiH.ujm + paramFloat + uiJ, f3 + f2), f2, f2, paramPaint);
        k = this.uiG.length();
        i = paramInt4 + (m - k);
        paramInt2 = i;
        if (i > paramInt4) {
          break label543;
        }
        paramInt2 = paramInt4 + 1;
      }
      catch (Exception paramCanvas)
      {
        int j;
        float f1;
        Typeface localTypeface;
        int m;
        float f2;
        int k;
        f.a.a(c.vVc, "liveInvalidBadgeTag", false, false, null, 28);
        paramCharSequence = y.vXH;
        y.a(paramCanvas, this.TAG + ".draw");
        AppMethodBeat.o(246108);
        return;
      }
      paramCharSequence = this.uiH.text;
      if (paramCharSequence != null)
      {
        paramCharSequence = Integer.valueOf(kotlin.n.n.a(paramCharSequence, this.uiG, 0, false, 6));
        m = paramCharSequence.intValue();
        paramInt2 = m + k;
        if (paramInt2 >= paramInt1)
        {
          paramCharSequence = this.uiH.text;
          paramPaint.setColor(this.uiH.textColor);
          f2 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F + (paramInt5 - paramInt3) / 2 + 1.0F;
          paramCanvas.drawText(this.uiH.text, paramInt4, i, paramFloat + this.uiH.ujl, f2, paramPaint);
          paramPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
          paramCanvas.drawText(this.uiH.text, m, paramInt1, paramFloat + ((int)paramPaint.measureText(paramCharSequence, paramInt4, i) + this.uiH.ujl + uiI), f2, paramPaint);
          paramPaint.setColor(j);
          paramPaint.setTextSize(f1);
          paramPaint.setTypeface(localTypeface);
          AppMethodBeat.o(246108);
        }
      }
      else
      {
        paramCharSequence = null;
        continue;
      }
      paramInt1 = paramInt2;
      continue;
      label543:
      int i = paramInt2;
      if (paramInt2 >= paramInt1) {
        i = paramInt1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan$Companion;", "", "()V", "DOUBLE_ITALIC_PADDING", "", "getDOUBLE_ITALIC_PADDING", "()I", "ITALIC_PADDING", "getITALIC_PADDING", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "spanStr", "", "textSize", "", "textPading", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.g
 * JD-Core Version:    0.7.0.1
 */