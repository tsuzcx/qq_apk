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
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private static e dNQ = new e();
  private static final SpannableString dNR = new SpannableString("");
  CharSequence dNS = null;
  CharSequence dNT = null;
  int dNU = 0;
  int dNV = 0;
  TextPaint dNW = null;
  Layout.Alignment dNX = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt dNY = null;
  int dNZ = -1;
  TextDirectionHeuristic dOa = null;
  float dOb = 0.0F;
  float dOc = 1.0F;
  boolean dOd = false;
  InputFilter.LengthFilter dOe = null;
  int gravity = 51;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      return new StaticLayout(paramCharSequence, this.dNU, this.dNV, this.dNW, this.width, this.dNX, this.dOc, this.dOb, this.dOd, this.dNY, paramInt);
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      if (this.dOa == null) {
        this.dOa = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      }
      return com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.dNU, this.dNV, this.dNW, this.width, this.dNX, this.dOa, this.dOc, this.dOb, this.dOd, this.dNY, paramInt, this.maxLines);
    }
    return com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.dNU, this.dNV, this.dNW, this.width, this.dNX, this.dOc, this.dOb, this.dOd, this.dNY, paramInt, this.maxLines);
  }
  
  public static d a(CharSequence paramCharSequence, int paramInt, com.tencent.mm.kiss.widget.textview.a.a parama)
  {
    boolean bool = false;
    Object localObject1 = paramCharSequence;
    if (paramCharSequence == null) {
      localObject1 = "";
    }
    int i = ((CharSequence)localObject1).length();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = dNQ.EG();
    paramCharSequence = (CharSequence)localObject1;
    if (localObject1 == null) {
      paramCharSequence = new d();
    }
    paramCharSequence.dNS = ((CharSequence)localObject2).toString();
    paramCharSequence.dNT = ((CharSequence)localObject2);
    paramCharSequence.dNU = 0;
    paramCharSequence.dNV = i;
    paramCharSequence.width = paramInt;
    paramCharSequence.dNW = new TextPaint();
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
        paramCharSequence.dOe = new InputFilter.LengthFilter(paramCharSequence.maxLength);
      }
    }
    localObject1 = parama.dNX;
    if (localObject1 != null) {
      paramCharSequence.dNX = ((Layout.Alignment)localObject1);
    }
    if (parama.dNY != null)
    {
      localObject1 = parama.dNY;
      if (localObject1 != null) {
        paramCharSequence.dNY = ((TextUtils.TruncateAt)localObject1);
      }
    }
    paramCharSequence.gravity = parama.gravity;
    if (parama.dOA != -1)
    {
      paramInt = parama.dOA;
      if (paramInt >= 0) {
        paramCharSequence.dNZ = paramInt;
      }
    }
    if (parama.dOa != null)
    {
      localObject1 = parama.dOa;
      if (Build.VERSION.SDK_INT >= 18) {
        paramCharSequence.dOa = ((TextDirectionHeuristic)localObject1);
      }
    }
    float f1 = parama.dOb;
    float f2 = parama.dOc;
    paramCharSequence.dOb = f1;
    paramCharSequence.dOc = f2;
    paramCharSequence.dOd = parama.dOd;
    if (parama.blk != null)
    {
      if (parama.fontStyle == -1) {
        break label533;
      }
      localObject1 = parama.blk;
      i = parama.fontStyle;
      if (i <= 0) {
        break label507;
      }
      if (localObject1 != null) {
        break label485;
      }
      localObject1 = Typeface.defaultFromStyle(i);
      paramCharSequence.c((Typeface)localObject1);
      if (localObject1 == null) {
        break label497;
      }
      paramInt = ((Typeface)localObject1).getStyle();
      label353:
      paramInt = (paramInt ^ 0xFFFFFFFF) & i;
      localObject1 = paramCharSequence.dNW;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      ((TextPaint)localObject1).setFakeBoldText(bool);
      localObject1 = paramCharSequence.dNW;
      if ((paramInt & 0x2) == 0) {
        break label502;
      }
      f1 = -0.25F;
      label397:
      ((TextPaint)localObject1).setTextSkewX(f1);
    }
    for (;;)
    {
      if (parama.dOB != -1.0F)
      {
        f1 = parama.dOB;
        paramCharSequence.dNW.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        paramCharSequence.dNW.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        paramCharSequence.dNW.linkColor = paramInt;
      }
      if (parama.dOi != null) {
        paramCharSequence.dNW = parama.dOi;
      }
      return paramCharSequence;
      label485:
      localObject1 = Typeface.create((Typeface)localObject1, i);
      break;
      label497:
      paramInt = 0;
      break label353;
      label502:
      f1 = 0.0F;
      break label397;
      label507:
      paramCharSequence.dNW.setFakeBoldText(false);
      paramCharSequence.dNW.setTextSkewX(0.0F);
      paramCharSequence.c((Typeface)localObject1);
      continue;
      label533:
      paramCharSequence.c(parama.blk);
    }
  }
  
  private d c(Typeface paramTypeface)
  {
    this.dNW.setTypeface(paramTypeface);
    return this;
  }
  
  @TargetApi(18)
  public final f EF()
  {
    int j;
    Object localObject1;
    if ((this.dNY == null) || (this.dNZ <= 0))
    {
      j = this.width;
      if ((this.dNY == null) && (this.maxLines == 1)) {
        this.dNY = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.dOe != null))
      {
        localObject1 = this.dOe.filter(this.dNT, 0, this.dNT.length(), dNR, 0, 0);
        if (localObject1 != null)
        {
          this.dNT = ((CharSequence)localObject1);
          if (this.dNV > this.dNT.length()) {
            this.dNV = this.dNT.length();
          }
        }
      }
      if (h.DEBUG) {
        y.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.dNT + " " + this.width);
      }
      if (this.dNX == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.gravity & 0x800007)
      {
      default: 
        this.dNX = Layout.Alignment.ALIGN_NORMAL;
        label239:
        this.dNW.setAntiAlias(true);
        localObject1 = null;
        if (((this.dOa != null) && ((!com.tencent.mm.compatible.util.d.gF(18)) || (this.dOa != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.dNT, bool, j);
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          y.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", new Object[] { localException2.getMessage() });
          int i = 0;
          if (i < 3)
          {
            int k = i;
            Object localObject4 = localObject1;
            try
            {
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.dNT);
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
                this.dNT = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.dNT, bool, j);
                k = i;
                localObject4 = localObject1;
                y.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", new Object[] { Integer.valueOf(i) });
                break;
                i = 100;
              }
            }
            catch (Exception localException1)
            {
              y.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", new Object[] { localException1.getMessage(), Integer.valueOf(k) });
              i = k;
              Object localObject2 = localObject4;
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        this.dNT = this.dNT.toString();
        localObject3 = a(this.dNT, bool, j);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).dOh = this.dNS;
      ((f)localObject1).text = this.dNT;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).dNX = this.dNX;
      ((f)localObject1).dNY = this.dNY;
      ((f)localObject1).dOi = this.dNW;
      ((f)localObject1).gravity = this.gravity;
      dNQ.a(this);
      return localObject1;
      j = this.dNZ;
      break;
      this.dNX = Layout.Alignment.ALIGN_NORMAL;
      break label239;
      this.dNX = Layout.Alignment.ALIGN_OPPOSITE;
      break label239;
      this.dNX = Layout.Alignment.ALIGN_CENTER;
      break label239;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */