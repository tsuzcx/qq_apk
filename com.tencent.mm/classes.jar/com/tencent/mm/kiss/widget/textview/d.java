package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  private static e ggE;
  private static final SpannableString ggF;
  CharSequence ggG = null;
  CharSequence ggH = null;
  int ggI = 0;
  int ggJ = 0;
  TextPaint ggK = null;
  Layout.Alignment ggL = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt ggM = null;
  int ggN = -1;
  TextDirectionHeuristic ggO = null;
  float ggP = 0.0F;
  float ggQ = 1.0F;
  boolean ggR = false;
  InputFilter.LengthFilter ggS = null;
  int gravity = 51;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  static
  {
    AppMethodBeat.i(141031);
    ggE = new e();
    ggF = new SpannableString("");
    AppMethodBeat.o(141031);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(141030);
    if (paramBoolean) {
      paramCharSequence = new StaticLayout(paramCharSequence, this.ggI, this.ggJ, this.ggK, this.width, this.ggL, this.ggQ, this.ggP, this.ggR, this.ggM, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(141030);
      return paramCharSequence;
      if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.ggO == null) {
          this.ggO = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.ggI, this.ggJ, this.ggK, this.width, this.ggL, this.ggO, this.ggQ, this.ggP, this.ggR, this.ggM, paramInt, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.ggI, this.ggJ, this.ggK, this.width, this.ggL, this.ggQ, this.ggP, this.ggR, this.ggM, paramInt, this.maxLines);
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
    localObject1 = ggE.agE();
    paramCharSequence = (CharSequence)localObject1;
    if (localObject1 == null) {
      paramCharSequence = new d();
    }
    paramCharSequence.ggG = ((CharSequence)localObject2).toString();
    paramCharSequence.ggH = ((CharSequence)localObject2);
    paramCharSequence.ggI = 0;
    paramCharSequence.ggJ = i;
    paramCharSequence.width = paramInt;
    paramCharSequence.ggK = new TextPaint();
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
        paramCharSequence.ggS = new InputFilter.LengthFilter(paramCharSequence.maxLength);
      }
    }
    localObject1 = parama.ggL;
    if (localObject1 != null) {
      paramCharSequence.ggL = ((Layout.Alignment)localObject1);
    }
    if (parama.ggM != null)
    {
      localObject1 = parama.ggM;
      if (localObject1 != null) {
        paramCharSequence.ggM = ((TextUtils.TruncateAt)localObject1);
      }
    }
    paramCharSequence.gravity = parama.gravity;
    if (parama.ghn != -1)
    {
      paramInt = parama.ghn;
      if (paramInt >= 0) {
        paramCharSequence.ggN = paramInt;
      }
    }
    if (parama.ggO != null)
    {
      localObject1 = parama.ggO;
      if (Build.VERSION.SDK_INT >= 18) {
        paramCharSequence.ggO = ((TextDirectionHeuristic)localObject1);
      }
    }
    float f1 = parama.ggP;
    float f2 = parama.ggQ;
    paramCharSequence.ggP = f1;
    paramCharSequence.ggQ = f2;
    paramCharSequence.ggR = parama.ggR;
    if (parama.pC != null)
    {
      if (parama.fontStyle == -1) {
        break label543;
      }
      localObject1 = parama.pC;
      i = parama.fontStyle;
      if (i <= 0) {
        break label517;
      }
      if (localObject1 != null) {
        break label495;
      }
      localObject1 = Typeface.defaultFromStyle(i);
      paramCharSequence.c((Typeface)localObject1);
      if (localObject1 == null) {
        break label507;
      }
      paramInt = ((Typeface)localObject1).getStyle();
      label358:
      paramInt = (paramInt ^ 0xFFFFFFFF) & i;
      localObject1 = paramCharSequence.ggK;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      ((TextPaint)localObject1).setFakeBoldText(bool);
      localObject1 = paramCharSequence.ggK;
      if ((paramInt & 0x2) == 0) {
        break label512;
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
        paramCharSequence.ggK.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        paramCharSequence.ggK.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        paramCharSequence.ggK.linkColor = paramInt;
      }
      if (parama.ga != null) {
        paramCharSequence.ggK = parama.ga;
      }
      AppMethodBeat.o(141027);
      return paramCharSequence;
      label495:
      localObject1 = Typeface.create((Typeface)localObject1, i);
      break;
      label507:
      paramInt = 0;
      break label358;
      label512:
      f1 = 0.0F;
      break label402;
      label517:
      paramCharSequence.ggK.setFakeBoldText(false);
      paramCharSequence.ggK.setTextSkewX(0.0F);
      paramCharSequence.c((Typeface)localObject1);
      continue;
      label543:
      paramCharSequence.c(parama.pC);
    }
  }
  
  private d c(Typeface paramTypeface)
  {
    AppMethodBeat.i(141028);
    this.ggK.setTypeface(paramTypeface);
    AppMethodBeat.o(141028);
    return this;
  }
  
  @TargetApi(18)
  public final f agD()
  {
    AppMethodBeat.i(141029);
    int j;
    Object localObject1;
    if ((this.ggM == null) || (this.ggN <= 0))
    {
      j = this.width;
      if ((this.ggM == null) && (this.maxLines == 1)) {
        this.ggM = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.ggS != null))
      {
        localObject1 = this.ggS.filter(this.ggH, 0, this.ggH.length(), ggF, 0, 0);
        if (localObject1 != null)
        {
          this.ggH = ((CharSequence)localObject1);
          if (this.ggJ > this.ggH.length()) {
            this.ggJ = this.ggH.length();
          }
        }
      }
      if (h.DEBUG) {
        ad.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.ggH + " " + this.width);
      }
      if (this.ggL == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.gravity & 0x800007)
      {
      default: 
        this.ggL = Layout.Alignment.ALIGN_NORMAL;
        label247:
        this.ggK.setAntiAlias(true);
        localObject1 = null;
        if (((this.ggO != null) && ((!com.tencent.mm.compatible.util.d.lf(18)) || (this.ggO != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.ggH, bool, j);
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
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.ggH);
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
                this.ggH = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.ggH, bool, j);
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
        this.ggH = this.ggH.toString();
        localObject3 = a(this.ggH, bool, j);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).ggV = this.ggG;
      ((f)localObject1).text = this.ggH;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).ggL = this.ggL;
      ((f)localObject1).ggM = this.ggM;
      ((f)localObject1).ga = this.ggK;
      ((f)localObject1).gravity = this.gravity;
      ggE.a(this);
      AppMethodBeat.o(141029);
      return localObject1;
      j = this.ggN;
      break;
      this.ggL = Layout.Alignment.ALIGN_NORMAL;
      break label247;
      this.ggL = Layout.Alignment.ALIGN_OPPOSITE;
      break label247;
      this.ggL = Layout.Alignment.ALIGN_CENTER;
      break label247;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */