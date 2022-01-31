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
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  private static e eLy;
  private static final SpannableString eLz;
  CharSequence eLA = null;
  CharSequence eLB = null;
  int eLC = 0;
  int eLD = 0;
  TextPaint eLE = null;
  Layout.Alignment eLF = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt eLG = null;
  int eLH = -1;
  TextDirectionHeuristic eLI = null;
  float eLJ = 0.0F;
  float eLK = 1.0F;
  boolean eLL = false;
  InputFilter.LengthFilter eLM = null;
  int gravity = 51;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  static
  {
    AppMethodBeat.i(105713);
    eLy = new e();
    eLz = new SpannableString("");
    AppMethodBeat.o(105713);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(105712);
    if (paramBoolean) {
      paramCharSequence = new StaticLayout(paramCharSequence, this.eLC, this.eLD, this.eLE, this.width, this.eLF, this.eLK, this.eLJ, this.eLL, this.eLG, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(105712);
      return paramCharSequence;
      if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.eLI == null) {
          this.eLI = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.eLC, this.eLD, this.eLE, this.width, this.eLF, this.eLI, this.eLK, this.eLJ, this.eLL, this.eLG, paramInt, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.eLC, this.eLD, this.eLE, this.width, this.eLF, this.eLK, this.eLJ, this.eLL, this.eLG, paramInt, this.maxLines);
      }
    }
  }
  
  public static d a(CharSequence paramCharSequence, int paramInt, com.tencent.mm.kiss.widget.textview.a.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(105709);
    Object localObject1 = paramCharSequence;
    if (paramCharSequence == null) {
      localObject1 = "";
    }
    int i = ((CharSequence)localObject1).length();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = eLy.SL();
    paramCharSequence = (CharSequence)localObject1;
    if (localObject1 == null) {
      paramCharSequence = new d();
    }
    paramCharSequence.eLA = ((CharSequence)localObject2).toString();
    paramCharSequence.eLB = ((CharSequence)localObject2);
    paramCharSequence.eLC = 0;
    paramCharSequence.eLD = i;
    paramCharSequence.width = paramInt;
    paramCharSequence.eLE = new TextPaint();
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
        paramCharSequence.eLM = new InputFilter.LengthFilter(paramCharSequence.maxLength);
      }
    }
    localObject1 = parama.eLF;
    if (localObject1 != null) {
      paramCharSequence.eLF = ((Layout.Alignment)localObject1);
    }
    if (parama.eLG != null)
    {
      localObject1 = parama.eLG;
      if (localObject1 != null) {
        paramCharSequence.eLG = ((TextUtils.TruncateAt)localObject1);
      }
    }
    paramCharSequence.gravity = parama.gravity;
    if (parama.eMi != -1)
    {
      paramInt = parama.eMi;
      if (paramInt >= 0) {
        paramCharSequence.eLH = paramInt;
      }
    }
    if (parama.eLI != null)
    {
      localObject1 = parama.eLI;
      if (Build.VERSION.SDK_INT >= 18) {
        paramCharSequence.eLI = ((TextDirectionHeuristic)localObject1);
      }
    }
    float f1 = parama.eLJ;
    float f2 = parama.eLK;
    paramCharSequence.eLJ = f1;
    paramCharSequence.eLK = f2;
    paramCharSequence.eLL = parama.eLL;
    if (parama.bKi != null)
    {
      if (parama.fontStyle == -1) {
        break label543;
      }
      localObject1 = parama.bKi;
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
      localObject1 = paramCharSequence.eLE;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      ((TextPaint)localObject1).setFakeBoldText(bool);
      localObject1 = paramCharSequence.eLE;
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
        paramCharSequence.eLE.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        paramCharSequence.eLE.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        paramCharSequence.eLE.linkColor = paramInt;
      }
      if (parama.eLQ != null) {
        paramCharSequence.eLE = parama.eLQ;
      }
      AppMethodBeat.o(105709);
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
      paramCharSequence.eLE.setFakeBoldText(false);
      paramCharSequence.eLE.setTextSkewX(0.0F);
      paramCharSequence.c((Typeface)localObject1);
      continue;
      label543:
      paramCharSequence.c(parama.bKi);
    }
  }
  
  private d c(Typeface paramTypeface)
  {
    AppMethodBeat.i(105710);
    this.eLE.setTypeface(paramTypeface);
    AppMethodBeat.o(105710);
    return this;
  }
  
  @TargetApi(18)
  public final f SK()
  {
    AppMethodBeat.i(105711);
    int j;
    Object localObject1;
    if ((this.eLG == null) || (this.eLH <= 0))
    {
      j = this.width;
      if ((this.eLG == null) && (this.maxLines == 1)) {
        this.eLG = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.eLM != null))
      {
        localObject1 = this.eLM.filter(this.eLB, 0, this.eLB.length(), eLz, 0, 0);
        if (localObject1 != null)
        {
          this.eLB = ((CharSequence)localObject1);
          if (this.eLD > this.eLB.length()) {
            this.eLD = this.eLB.length();
          }
        }
      }
      if (h.DEBUG) {
        ab.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.eLB + " " + this.width);
      }
      if (this.eLF == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.gravity & 0x800007)
      {
      default: 
        this.eLF = Layout.Alignment.ALIGN_NORMAL;
        label247:
        this.eLE.setAntiAlias(true);
        localObject1 = null;
        if (((this.eLI != null) && ((!com.tencent.mm.compatible.util.d.fv(18)) || (this.eLI != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.eLB, bool, j);
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          ab.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", new Object[] { localException2.getMessage() });
          int i = 0;
          if (i < 3)
          {
            int k = i;
            Object localObject4 = localObject1;
            try
            {
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.eLB);
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
                this.eLB = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.eLB, bool, j);
                k = i;
                localObject4 = localObject1;
                ab.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", new Object[] { Integer.valueOf(i) });
                break;
                i = 100;
              }
            }
            catch (Exception localException1)
            {
              ab.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", new Object[] { localException1.getMessage(), Integer.valueOf(k) });
              i = k;
              Object localObject2 = localObject4;
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        this.eLB = this.eLB.toString();
        localObject3 = a(this.eLB, bool, j);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).eLP = this.eLA;
      ((f)localObject1).text = this.eLB;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).eLF = this.eLF;
      ((f)localObject1).eLG = this.eLG;
      ((f)localObject1).eLQ = this.eLE;
      ((f)localObject1).gravity = this.gravity;
      eLy.a(this);
      AppMethodBeat.o(105711);
      return localObject1;
      j = this.eLH;
      break;
      this.eLF = Layout.Alignment.ALIGN_NORMAL;
      break label247;
      this.eLF = Layout.Alignment.ALIGN_OPPOSITE;
      break label247;
      this.eLF = Layout.Alignment.ALIGN_CENTER;
      break label247;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */