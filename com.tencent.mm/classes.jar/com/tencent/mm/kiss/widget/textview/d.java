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
import com.tencent.mm.sdk.platformtools.ac;

public final class d
{
  private static e glk;
  private static final SpannableString gll;
  CharSequence glm = null;
  CharSequence gln = null;
  int glo = 0;
  int glp = 0;
  TextPaint glq = null;
  Layout.Alignment glr = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt gls = null;
  int glt = -1;
  TextDirectionHeuristic glu = null;
  float glv = 0.0F;
  float glw = 1.0F;
  boolean glx = false;
  InputFilter.LengthFilter gly = null;
  int gravity = 51;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  static
  {
    AppMethodBeat.i(141031);
    glk = new e();
    gll = new SpannableString("");
    AppMethodBeat.o(141031);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(141030);
    if (paramBoolean) {
      paramCharSequence = new StaticLayout(paramCharSequence, this.glo, this.glp, this.glq, this.width, this.glr, this.glw, this.glv, this.glx, this.gls, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(141030);
      return paramCharSequence;
      if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.glu == null) {
          this.glu = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.glo, this.glp, this.glq, this.width, this.glr, this.glu, this.glw, this.glv, this.glx, this.gls, paramInt, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.glo, this.glp, this.glq, this.width, this.glr, this.glw, this.glv, this.glx, this.gls, paramInt, this.maxLines);
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
    localObject1 = glk.ahV();
    paramCharSequence = (CharSequence)localObject1;
    if (localObject1 == null) {
      paramCharSequence = new d();
    }
    paramCharSequence.glm = ((CharSequence)localObject2).toString();
    paramCharSequence.gln = ((CharSequence)localObject2);
    paramCharSequence.glo = 0;
    paramCharSequence.glp = i;
    paramCharSequence.width = paramInt;
    paramCharSequence.glq = new TextPaint();
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
        paramCharSequence.gly = new InputFilter.LengthFilter(paramCharSequence.maxLength);
      }
    }
    localObject1 = parama.glr;
    if (localObject1 != null) {
      paramCharSequence.glr = ((Layout.Alignment)localObject1);
    }
    if (parama.gls != null)
    {
      localObject1 = parama.gls;
      if (localObject1 != null) {
        paramCharSequence.gls = ((TextUtils.TruncateAt)localObject1);
      }
    }
    paramCharSequence.gravity = parama.gravity;
    if (parama.glT != -1)
    {
      paramInt = parama.glT;
      if (paramInt >= 0) {
        paramCharSequence.glt = paramInt;
      }
    }
    if (parama.glu != null)
    {
      localObject1 = parama.glu;
      if (Build.VERSION.SDK_INT >= 18) {
        paramCharSequence.glu = ((TextDirectionHeuristic)localObject1);
      }
    }
    float f1 = parama.glv;
    float f2 = parama.glw;
    paramCharSequence.glv = f1;
    paramCharSequence.glw = f2;
    paramCharSequence.glx = parama.glx;
    if (parama.qC != null)
    {
      if (parama.fontStyle == -1) {
        break label543;
      }
      localObject1 = parama.qC;
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
      localObject1 = paramCharSequence.glq;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      ((TextPaint)localObject1).setFakeBoldText(bool);
      localObject1 = paramCharSequence.glq;
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
        paramCharSequence.glq.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        paramCharSequence.glq.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        paramCharSequence.glq.linkColor = paramInt;
      }
      if (parama.gZ != null) {
        paramCharSequence.glq = parama.gZ;
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
      paramCharSequence.glq.setFakeBoldText(false);
      paramCharSequence.glq.setTextSkewX(0.0F);
      paramCharSequence.c((Typeface)localObject1);
      continue;
      label543:
      paramCharSequence.c(parama.qC);
    }
  }
  
  private d c(Typeface paramTypeface)
  {
    AppMethodBeat.i(141028);
    this.glq.setTypeface(paramTypeface);
    AppMethodBeat.o(141028);
    return this;
  }
  
  @TargetApi(18)
  public final f ahU()
  {
    AppMethodBeat.i(141029);
    int j;
    Object localObject1;
    if ((this.gls == null) || (this.glt <= 0))
    {
      j = this.width;
      if ((this.gls == null) && (this.maxLines == 1)) {
        this.gls = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.gly != null))
      {
        localObject1 = this.gly.filter(this.gln, 0, this.gln.length(), gll, 0, 0);
        if (localObject1 != null)
        {
          this.gln = ((CharSequence)localObject1);
          if (this.glp > this.gln.length()) {
            this.glp = this.gln.length();
          }
        }
      }
      if (h.DEBUG) {
        ac.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.gln + " " + this.width);
      }
      if (this.glr == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.gravity & 0x800007)
      {
      default: 
        this.glr = Layout.Alignment.ALIGN_NORMAL;
        label247:
        this.glq.setAntiAlias(true);
        localObject1 = null;
        if (((this.glu != null) && ((!com.tencent.mm.compatible.util.d.kZ(18)) || (this.glu != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.gln, bool, j);
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          ac.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", new Object[] { localException2.getMessage() });
          int i = 0;
          if (i < 3)
          {
            int k = i;
            Object localObject4 = localObject1;
            try
            {
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.gln);
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
                this.gln = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.gln, bool, j);
                k = i;
                localObject4 = localObject1;
                ac.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", new Object[] { Integer.valueOf(i) });
                break;
                i = 100;
              }
            }
            catch (Exception localException1)
            {
              ac.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", new Object[] { localException1.getMessage(), Integer.valueOf(k) });
              i = k;
              Object localObject2 = localObject4;
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        this.gln = this.gln.toString();
        localObject3 = a(this.gln, bool, j);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).glB = this.glm;
      ((f)localObject1).text = this.gln;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).glr = this.glr;
      ((f)localObject1).gls = this.gls;
      ((f)localObject1).gZ = this.glq;
      ((f)localObject1).gravity = this.gravity;
      glk.a(this);
      AppMethodBeat.o(141029);
      return localObject1;
      j = this.glt;
      break;
      this.glr = Layout.Alignment.ALIGN_NORMAL;
      break label247;
      this.glr = Layout.Alignment.ALIGN_OPPOSITE;
      break label247;
      this.glr = Layout.Alignment.ALIGN_CENTER;
      break label247;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */