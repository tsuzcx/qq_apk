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
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  private static e kgk;
  private static final SpannableString kgl;
  public int ek = 51;
  CharSequence kgm = null;
  CharSequence kgn = null;
  int kgo = 0;
  int kgp = 0;
  TextPaint kgq = null;
  Layout.Alignment kgr = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt kgs = null;
  int kgt = -1;
  TextDirectionHeuristic kgu = null;
  float kgv = 0.0F;
  float kgw = 1.0F;
  boolean kgx = false;
  int kgy = -1;
  InputFilter.LengthFilter kgz = null;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  static
  {
    AppMethodBeat.i(141031);
    kgk = new e();
    kgl = new SpannableString("");
    AppMethodBeat.o(141031);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237885);
    if (paramInt2 >= 0) {
      paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, this.kgo, this.kgp, this.kgq, this.width).setAlignment(this.kgr).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.kgv, this.kgw).setIncludePad(this.kgx).setEllipsize(this.kgs).setEllipsizedWidth(paramInt1).setBreakStrategy(paramInt2).setMaxLines(2147483647).build();
    }
    for (;;)
    {
      AppMethodBeat.o(237885);
      return paramCharSequence;
      if (paramBoolean)
      {
        paramCharSequence = new StaticLayout(paramCharSequence, this.kgo, this.kgp, this.kgq, this.width, this.kgr, this.kgw, this.kgv, this.kgx, this.kgs, paramInt1);
      }
      else if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.kgu == null) {
          this.kgu = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.b(paramCharSequence, this.kgo, this.kgp, this.kgq, this.width, this.kgr, this.kgu, this.kgw, this.kgv, this.kgx, this.kgs, paramInt1, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.kgo, this.kgp, this.kgq, this.width, this.kgr, this.kgw, this.kgv, this.kgx, this.kgs, paramInt1, this.maxLines);
      }
    }
  }
  
  public static d a(CharSequence paramCharSequence, int paramInt, com.tencent.mm.kiss.widget.textview.a.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(141027);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    int i = ((CharSequence)localObject).length();
    paramCharSequence = (CharSequence)localObject;
    if (localObject == null) {
      paramCharSequence = "";
    }
    localObject = aIN();
    ((d)localObject).kgm = paramCharSequence.toString();
    ((d)localObject).kgn = paramCharSequence;
    ((d)localObject).kgo = 0;
    ((d)localObject).kgp = i;
    ((d)localObject).width = paramInt;
    ((d)localObject).kgq = new TextPaint();
    if (parama.maxLines != -1) {
      ((d)localObject).sI(parama.maxLines);
    }
    if (parama.maxLength != -1)
    {
      paramInt = parama.maxLength;
      if (paramInt >= 0)
      {
        ((d)localObject).maxLength = paramInt;
        ((d)localObject).kgz = new InputFilter.LengthFilter(((d)localObject).maxLength);
      }
    }
    paramCharSequence = parama.kgr;
    if (paramCharSequence != null) {
      ((d)localObject).kgr = paramCharSequence;
    }
    if (parama.kgs != null) {
      ((d)localObject).a(parama.kgs);
    }
    ((d)localObject).ek = parama.ek;
    if (parama.kgV != -1)
    {
      paramInt = parama.kgV;
      if (paramInt >= 0) {
        ((d)localObject).kgt = paramInt;
      }
    }
    if (parama.kgu != null)
    {
      paramCharSequence = parama.kgu;
      if (Build.VERSION.SDK_INT >= 18) {
        ((d)localObject).kgu = paramCharSequence;
      }
    }
    float f1 = parama.kgv;
    float f2 = parama.kgw;
    ((d)localObject).kgv = f1;
    ((d)localObject).kgw = f2;
    ((d)localObject).kgx = parama.kgx;
    if (parama.bGp != null)
    {
      if (parama.fontStyle == -1) {
        break label540;
      }
      paramCharSequence = parama.bGp;
      i = parama.fontStyle;
      if (i <= 0) {
        break label512;
      }
      if (paramCharSequence != null) {
        break label492;
      }
      paramCharSequence = Typeface.defaultFromStyle(i);
      ((d)localObject).d(paramCharSequence);
      if (paramCharSequence == null) {
        break label502;
      }
      paramInt = paramCharSequence.getStyle();
      label330:
      paramInt = (paramInt ^ 0xFFFFFFFF) & i;
      paramCharSequence = ((d)localObject).kgq;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      paramCharSequence.setFakeBoldText(bool);
      paramCharSequence = ((d)localObject).kgq;
      if ((paramInt & 0x2) == 0) {
        break label507;
      }
      f1 = -0.25F;
      label373:
      paramCharSequence.setTextSkewX(f1);
    }
    for (;;)
    {
      if (parama.textSize != -1.0F)
      {
        f1 = parama.textSize;
        ((d)localObject).kgq.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        ((d)localObject).kgq.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        ((d)localObject).kgq.linkColor = paramInt;
      }
      if (parama.bzo != null) {
        ((d)localObject).kgq = parama.bzo;
      }
      if (parama.kgy >= 0)
      {
        paramInt = parama.kgy;
        if (paramInt >= 0) {
          ((d)localObject).kgy = paramInt;
        }
      }
      AppMethodBeat.o(141027);
      return localObject;
      label492:
      paramCharSequence = Typeface.create(paramCharSequence, i);
      break;
      label502:
      paramInt = 0;
      break label330;
      label507:
      f1 = 0.0F;
      break label373;
      label512:
      ((d)localObject).kgq.setFakeBoldText(false);
      ((d)localObject).kgq.setTextSkewX(0.0F);
      ((d)localObject).d(paramCharSequence);
      continue;
      label540:
      ((d)localObject).d(parama.bGp);
    }
  }
  
  public static d a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    AppMethodBeat.i(237867);
    d locald = aIN();
    locald.kgn = paramCharSequence;
    locald.kgo = 0;
    locald.kgp = paramCharSequence.length();
    locald.kgq = paramTextPaint;
    locald.width = paramInt;
    AppMethodBeat.o(237867);
    return locald;
  }
  
  private static d aIN()
  {
    AppMethodBeat.i(237869);
    d locald2 = kgk.aIP();
    d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new d();
    }
    AppMethodBeat.o(237869);
    return locald1;
  }
  
  private d d(Typeface paramTypeface)
  {
    AppMethodBeat.i(141028);
    this.kgq.setTypeface(paramTypeface);
    AppMethodBeat.o(141028);
    return this;
  }
  
  public final d I(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(237873);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(237873);
      return this;
    }
    this.kgn = paramCharSequence;
    this.kgo = 0;
    this.kgp = paramCharSequence.length();
    AppMethodBeat.o(237873);
    return this;
  }
  
  public final d a(TextUtils.TruncateAt paramTruncateAt)
  {
    if (paramTruncateAt != null) {
      this.kgs = paramTruncateAt;
    }
    return this;
  }
  
  @TargetApi(18)
  public final f aIO()
  {
    AppMethodBeat.i(141029);
    int j;
    Object localObject1;
    if ((this.kgs == null) || (this.kgt <= 0))
    {
      j = this.width;
      if ((this.kgs == null) && (this.maxLines == 1)) {
        this.kgs = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.kgz != null))
      {
        localObject1 = this.kgz.filter(this.kgn, 0, this.kgn.length(), kgl, 0, 0);
        if (localObject1 != null)
        {
          this.kgn = ((CharSequence)localObject1);
          if (this.kgp > this.kgn.length()) {
            this.kgp = this.kgn.length();
          }
        }
      }
      if (h.DEBUG) {
        Log.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.kgn + " " + this.width);
      }
      if (this.kgr == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.ek & 0x800007)
      {
      default: 
        this.kgr = Layout.Alignment.ALIGN_NORMAL;
        label251:
        this.kgq.setAntiAlias(true);
        localObject1 = null;
        if (((this.kgu != null) && ((!com.tencent.mm.compatible.util.d.qV(18)) || (this.kgu != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.kgn, bool, j, this.kgy);
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          Log.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", new Object[] { localException2.getMessage() });
          int i = 0;
          if (i < 3)
          {
            int k = i;
            Object localObject4 = localObject1;
            try
            {
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.kgn);
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
                this.kgn = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.kgn, bool, j, this.kgy);
                k = i;
                localObject4 = localObject1;
                Log.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", new Object[] { Integer.valueOf(i) });
                break;
                i = 100;
              }
            }
            catch (Exception localException1)
            {
              Log.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", new Object[] { localException1.getMessage(), Integer.valueOf(k) });
              i = k;
              Object localObject2 = localObject4;
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        this.kgn = this.kgn.toString();
        localObject3 = a(this.kgn, bool, j, this.kgy);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).kgC = this.kgm;
      ((f)localObject1).LV = this.kgn;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).kgr = this.kgr;
      ((f)localObject1).kgs = this.kgs;
      ((f)localObject1).bzo = this.kgq;
      ((f)localObject1).ek = this.ek;
      ((f)localObject1).kgy = this.kgy;
      kgk.a(this);
      AppMethodBeat.o(141029);
      return localObject1;
      j = this.kgt;
      break;
      this.kgr = Layout.Alignment.ALIGN_NORMAL;
      break label251;
      this.kgr = Layout.Alignment.ALIGN_OPPOSITE;
      break label251;
      this.kgr = Layout.Alignment.ALIGN_CENTER;
      break label251;
    }
  }
  
  public final d sI(int paramInt)
  {
    if (paramInt >= 0) {
      this.maxLines = paramInt;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */