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
import com.tencent.mm.sdk.platformtools.ae;

public final class d
{
  private static e gHB;
  private static final SpannableString gHC;
  int breakStrategy = -1;
  CharSequence gHD = null;
  CharSequence gHE = null;
  int gHF = 0;
  int gHG = 0;
  TextPaint gHH = null;
  Layout.Alignment gHI = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt gHJ = null;
  int gHK = -1;
  TextDirectionHeuristic gHL = null;
  float gHM = 0.0F;
  float gHN = 1.0F;
  boolean gHO = false;
  InputFilter.LengthFilter gHP = null;
  int gravity = 51;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  static
  {
    AppMethodBeat.i(141031);
    gHB = new e();
    gHC = new SpannableString("");
    AppMethodBeat.o(141031);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193681);
    if (paramInt2 >= 0) {
      paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, this.gHF, this.gHG, this.gHH, this.width).setAlignment(this.gHI).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.gHM, this.gHN).setIncludePad(this.gHO).setEllipsize(this.gHJ).setEllipsizedWidth(paramInt1).setBreakStrategy(paramInt2).setMaxLines(2147483647).build();
    }
    for (;;)
    {
      AppMethodBeat.o(193681);
      return paramCharSequence;
      if (paramBoolean)
      {
        paramCharSequence = new StaticLayout(paramCharSequence, this.gHF, this.gHG, this.gHH, this.width, this.gHI, this.gHN, this.gHM, this.gHO, this.gHJ, paramInt1);
      }
      else if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.gHL == null) {
          this.gHL = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.gHF, this.gHG, this.gHH, this.width, this.gHI, this.gHL, this.gHN, this.gHM, this.gHO, this.gHJ, paramInt1, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.gHF, this.gHG, this.gHH, this.width, this.gHI, this.gHN, this.gHM, this.gHO, this.gHJ, paramInt1, this.maxLines);
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
    localObject1 = gHB.akV();
    paramCharSequence = (CharSequence)localObject1;
    if (localObject1 == null) {
      paramCharSequence = new d();
    }
    paramCharSequence.gHD = ((CharSequence)localObject2).toString();
    paramCharSequence.gHE = ((CharSequence)localObject2);
    paramCharSequence.gHF = 0;
    paramCharSequence.gHG = i;
    paramCharSequence.width = paramInt;
    paramCharSequence.gHH = new TextPaint();
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
        paramCharSequence.gHP = new InputFilter.LengthFilter(paramCharSequence.maxLength);
      }
    }
    localObject1 = parama.gHI;
    if (localObject1 != null) {
      paramCharSequence.gHI = ((Layout.Alignment)localObject1);
    }
    if (parama.gHJ != null)
    {
      localObject1 = parama.gHJ;
      if (localObject1 != null) {
        paramCharSequence.gHJ = ((TextUtils.TruncateAt)localObject1);
      }
    }
    paramCharSequence.gravity = parama.gravity;
    if (parama.gIk != -1)
    {
      paramInt = parama.gIk;
      if (paramInt >= 0) {
        paramCharSequence.gHK = paramInt;
      }
    }
    if (parama.gHL != null)
    {
      localObject1 = parama.gHL;
      if (Build.VERSION.SDK_INT >= 18) {
        paramCharSequence.gHL = ((TextDirectionHeuristic)localObject1);
      }
    }
    float f1 = parama.gHM;
    float f2 = parama.gHN;
    paramCharSequence.gHM = f1;
    paramCharSequence.gHN = f2;
    paramCharSequence.gHO = parama.gHO;
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
      localObject1 = paramCharSequence.gHH;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      ((TextPaint)localObject1).setFakeBoldText(bool);
      localObject1 = paramCharSequence.gHH;
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
        paramCharSequence.gHH.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        paramCharSequence.gHH.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        paramCharSequence.gHH.linkColor = paramInt;
      }
      if (parama.iU != null) {
        paramCharSequence.gHH = parama.iU;
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
      paramCharSequence.gHH.setFakeBoldText(false);
      paramCharSequence.gHH.setTextSkewX(0.0F);
      paramCharSequence.c((Typeface)localObject1);
      continue;
      label564:
      paramCharSequence.c(parama.sx);
    }
  }
  
  private d c(Typeface paramTypeface)
  {
    AppMethodBeat.i(141028);
    this.gHH.setTypeface(paramTypeface);
    AppMethodBeat.o(141028);
    return this;
  }
  
  @TargetApi(18)
  public final f akU()
  {
    AppMethodBeat.i(141029);
    int j;
    Object localObject1;
    if ((this.gHJ == null) || (this.gHK <= 0))
    {
      j = this.width;
      if ((this.gHJ == null) && (this.maxLines == 1)) {
        this.gHJ = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.gHP != null))
      {
        localObject1 = this.gHP.filter(this.gHE, 0, this.gHE.length(), gHC, 0, 0);
        if (localObject1 != null)
        {
          this.gHE = ((CharSequence)localObject1);
          if (this.gHG > this.gHE.length()) {
            this.gHG = this.gHE.length();
          }
        }
      }
      if (h.DEBUG) {
        ae.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.gHE + " " + this.width);
      }
      if (this.gHI == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.gravity & 0x800007)
      {
      default: 
        this.gHI = Layout.Alignment.ALIGN_NORMAL;
        label251:
        this.gHH.setAntiAlias(true);
        localObject1 = null;
        if (((this.gHL != null) && ((!com.tencent.mm.compatible.util.d.lA(18)) || (this.gHL != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.gHE, bool, j, this.breakStrategy);
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          ae.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", new Object[] { localException2.getMessage() });
          int i = 0;
          if (i < 3)
          {
            int k = i;
            Object localObject4 = localObject1;
            try
            {
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.gHE);
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
                this.gHE = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.gHE, bool, j, this.breakStrategy);
                k = i;
                localObject4 = localObject1;
                ae.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", new Object[] { Integer.valueOf(i) });
                break;
                i = 100;
              }
            }
            catch (Exception localException1)
            {
              ae.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", new Object[] { localException1.getMessage(), Integer.valueOf(k) });
              i = k;
              Object localObject2 = localObject4;
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        this.gHE = this.gHE.toString();
        localObject3 = a(this.gHE, bool, j, this.breakStrategy);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).gHS = this.gHD;
      ((f)localObject1).text = this.gHE;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).gHI = this.gHI;
      ((f)localObject1).gHJ = this.gHJ;
      ((f)localObject1).iU = this.gHH;
      ((f)localObject1).gravity = this.gravity;
      ((f)localObject1).breakStrategy = this.breakStrategy;
      gHB.a(this);
      AppMethodBeat.o(141029);
      return localObject1;
      j = this.gHK;
      break;
      this.gHI = Layout.Alignment.ALIGN_NORMAL;
      break label251;
      this.gHI = Layout.Alignment.ALIGN_OPPOSITE;
      break label251;
      this.gHI = Layout.Alignment.ALIGN_CENTER;
      break label251;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */