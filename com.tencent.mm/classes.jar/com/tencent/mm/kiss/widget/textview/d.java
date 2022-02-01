package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  private static e gEU;
  private static final SpannableString gEV;
  int breakStrategy = -1;
  CharSequence gEW = null;
  CharSequence gEX = null;
  int gEY = 0;
  int gEZ = 0;
  TextPaint gFa = null;
  Layout.Alignment gFb = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt gFc = null;
  int gFd = -1;
  TextDirectionHeuristic gFe = null;
  float gFf = 0.0F;
  float gFg = 1.0F;
  boolean gFh = false;
  InputFilter.LengthFilter gFi = null;
  int gravity = 51;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  static
  {
    AppMethodBeat.i(141031);
    gEU = new e();
    gEV = new SpannableString("");
    AppMethodBeat.o(141031);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186428);
    if (paramInt2 >= 0) {
      paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, this.gEY, this.gEZ, this.gFa, this.width).setAlignment(this.gFb).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.gFf, this.gFg).setIncludePad(this.gFh).setEllipsize(this.gFc).setEllipsizedWidth(paramInt1).setBreakStrategy(paramInt2).setMaxLines(2147483647).build();
    }
    for (;;)
    {
      AppMethodBeat.o(186428);
      return paramCharSequence;
      if (paramBoolean)
      {
        paramCharSequence = new StaticLayout(paramCharSequence, this.gEY, this.gEZ, this.gFa, this.width, this.gFb, this.gFg, this.gFf, this.gFh, this.gFc, paramInt1);
      }
      else if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.gFe == null) {
          this.gFe = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.gEY, this.gEZ, this.gFa, this.width, this.gFb, this.gFe, this.gFg, this.gFf, this.gFh, this.gFc, paramInt1, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.gEY, this.gEZ, this.gFa, this.width, this.gFb, this.gFg, this.gFf, this.gFh, this.gFc, paramInt1, this.maxLines);
      }
    }
  }
  
  public static d a(CharSequence paramCharSequence, int paramInt, com.tencent.mm.kiss.widget.textview.a.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(141027);
    Object localObject1 = paramCharSequence;
    if (paramCharSequence == null) {
      localObject1 = "";
    }
    int i = ((CharSequence)localObject1).length();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = gEU.akG();
    paramCharSequence = (CharSequence)localObject1;
    if (localObject1 == null) {
      paramCharSequence = new d();
    }
    paramCharSequence.gEW = ((CharSequence)localObject2).toString();
    paramCharSequence.gEX = ((CharSequence)localObject2);
    paramCharSequence.gEY = 0;
    paramCharSequence.gEZ = i;
    paramCharSequence.width = paramInt;
    paramCharSequence.gFa = new TextPaint();
    if (parama.maxLines != -1)
    {
      paramInt = parama.maxLines;
      if (paramInt >= 0) {
        paramCharSequence.maxLines = paramInt;
      }
    }
    if (parama.maxLength != -1)
    {
      paramInt = parama.maxLength;
      if (paramInt >= 0)
      {
        paramCharSequence.maxLength = paramInt;
        paramCharSequence.gFi = new InputFilter.LengthFilter(paramCharSequence.maxLength);
      }
    }
    localObject1 = parama.gFb;
    if (localObject1 != null) {
      paramCharSequence.gFb = ((Layout.Alignment)localObject1);
    }
    if (parama.gFc != null)
    {
      localObject1 = parama.gFc;
      if (localObject1 != null) {
        paramCharSequence.gFc = ((TextUtils.TruncateAt)localObject1);
      }
    }
    paramCharSequence.gravity = parama.gravity;
    if (parama.gFD != -1)
    {
      paramInt = parama.gFD;
      if (paramInt >= 0) {
        paramCharSequence.gFd = paramInt;
      }
    }
    if (parama.gFe != null)
    {
      localObject1 = parama.gFe;
      if (Build.VERSION.SDK_INT >= 18) {
        paramCharSequence.gFe = ((TextDirectionHeuristic)localObject1);
      }
    }
    float f1 = parama.gFf;
    float f2 = parama.gFg;
    paramCharSequence.gFf = f1;
    paramCharSequence.gFg = f2;
    paramCharSequence.gFh = parama.gFh;
    if (parama.sx != null)
    {
      if (parama.fontStyle == -1) {
        break label564;
      }
      localObject1 = parama.sx;
      i = parama.fontStyle;
      if (i <= 0) {
        break label538;
      }
      if (localObject1 != null) {
        break label516;
      }
      localObject1 = Typeface.defaultFromStyle(i);
      paramCharSequence.c((Typeface)localObject1);
      if (localObject1 == null) {
        break label528;
      }
      paramInt = ((Typeface)localObject1).getStyle();
      label358:
      paramInt = (paramInt ^ 0xFFFFFFFF) & i;
      localObject1 = paramCharSequence.gFa;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      ((TextPaint)localObject1).setFakeBoldText(bool);
      localObject1 = paramCharSequence.gFa;
      if ((paramInt & 0x2) == 0) {
        break label533;
      }
      f1 = -0.25F;
      label402:
      ((TextPaint)localObject1).setTextSkewX(f1);
    }
    for (;;)
    {
      if (parama.textSize != -1.0F)
      {
        f1 = parama.textSize;
        paramCharSequence.gFa.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        paramCharSequence.gFa.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        paramCharSequence.gFa.linkColor = paramInt;
      }
      if (parama.iU != null) {
        paramCharSequence.gFa = parama.iU;
      }
      if (parama.breakStrategy >= 0)
      {
        paramInt = parama.breakStrategy;
        if (paramInt >= 0) {
          paramCharSequence.breakStrategy = paramInt;
        }
      }
      AppMethodBeat.o(141027);
      return paramCharSequence;
      label516:
      localObject1 = Typeface.create((Typeface)localObject1, i);
      break;
      label528:
      paramInt = 0;
      break label358;
      label533:
      f1 = 0.0F;
      break label402;
      label538:
      paramCharSequence.gFa.setFakeBoldText(false);
      paramCharSequence.gFa.setTextSkewX(0.0F);
      paramCharSequence.c((Typeface)localObject1);
      continue;
      label564:
      paramCharSequence.c(parama.sx);
    }
  }
  
  private d c(Typeface paramTypeface)
  {
    AppMethodBeat.i(141028);
    this.gFa.setTypeface(paramTypeface);
    AppMethodBeat.o(141028);
    return this;
  }
  
  @TargetApi(18)
  public final f akF()
  {
    AppMethodBeat.i(141029);
    int j;
    Object localObject1;
    if ((this.gFc == null) || (this.gFd <= 0))
    {
      j = this.width;
      if ((this.gFc == null) && (this.maxLines == 1)) {
        this.gFc = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.gFi != null))
      {
        localObject1 = this.gFi.filter(this.gEX, 0, this.gEX.length(), gEV, 0, 0);
        if (localObject1 != null)
        {
          this.gEX = ((CharSequence)localObject1);
          if (this.gEZ > this.gEX.length()) {
            this.gEZ = this.gEX.length();
          }
        }
      }
      if (h.DEBUG) {
        ad.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.gEX + " " + this.width);
      }
      if (this.gFb == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.gravity & 0x800007)
      {
      default: 
        this.gFb = Layout.Alignment.ALIGN_NORMAL;
        label251:
        this.gFa.setAntiAlias(true);
        localObject1 = null;
        if (((this.gFe != null) && ((!com.tencent.mm.compatible.util.d.ly(18)) || (this.gFe != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.gEX, bool, j, this.breakStrategy);
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          ad.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", new Object[] { localException2.getMessage() });
          int i = 0;
          if (i < 3)
          {
            int k = i;
            Object localObject4 = localObject1;
            try
            {
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.gEX);
              k = i;
              localObject4 = localObject1;
              MetricAffectingSpan[] arrayOfMetricAffectingSpan = (MetricAffectingSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MetricAffectingSpan.class);
              if (arrayOfMetricAffectingSpan != null)
              {
                k = i;
                localObject4 = localObject1;
                if (arrayOfMetricAffectingSpan.length > 0)
                {
                  k = i;
                  localObject4 = localObject1;
                  localSpannableStringBuilder.insert(localSpannableStringBuilder.getSpanStart(arrayOfMetricAffectingSpan[0]) - 1, " ");
                  i += 1;
                }
              }
              for (;;)
              {
                k = i;
                localObject4 = localObject1;
                this.gEX = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.gEX, bool, j, this.breakStrategy);
                k = i;
                localObject4 = localObject1;
                ad.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", new Object[] { Integer.valueOf(i) });
                break;
                i = 100;
              }
            }
            catch (Exception localException1)
            {
              ad.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", new Object[] { localException1.getMessage(), Integer.valueOf(k) });
              i = k;
              Object localObject2 = localObject4;
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        this.gEX = this.gEX.toString();
        localObject3 = a(this.gEX, bool, j, this.breakStrategy);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).gFl = this.gEW;
      ((f)localObject1).text = this.gEX;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).gFb = this.gFb;
      ((f)localObject1).gFc = this.gFc;
      ((f)localObject1).iU = this.gFa;
      ((f)localObject1).gravity = this.gravity;
      ((f)localObject1).breakStrategy = this.breakStrategy;
      gEU.a(this);
      AppMethodBeat.o(141029);
      return localObject1;
      j = this.gFd;
      break;
      this.gFb = Layout.Alignment.ALIGN_NORMAL;
      break label251;
      this.gFb = Layout.Alignment.ALIGN_OPPOSITE;
      break label251;
      this.gFb = Layout.Alignment.ALIGN_CENTER;
      break label251;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */