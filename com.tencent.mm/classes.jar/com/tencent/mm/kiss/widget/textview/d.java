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
  private static e hup;
  private static final SpannableString huq;
  int breakStrategy = -1;
  public int gravity = 51;
  float huA = 0.0F;
  float huB = 1.0F;
  boolean huC = false;
  InputFilter.LengthFilter huD = null;
  CharSequence hur = null;
  CharSequence hus = null;
  int hut = 0;
  int huu = 0;
  TextPaint huv = null;
  Layout.Alignment huw = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt hux = null;
  int huy = -1;
  TextDirectionHeuristic huz = null;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  static
  {
    AppMethodBeat.i(141031);
    hup = new e();
    huq = new SpannableString("");
    AppMethodBeat.o(141031);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196223);
    if (paramInt2 >= 0) {
      paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, this.hut, this.huu, this.huv, this.width).setAlignment(this.huw).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.huA, this.huB).setIncludePad(this.huC).setEllipsize(this.hux).setEllipsizedWidth(paramInt1).setBreakStrategy(paramInt2).setMaxLines(2147483647).build();
    }
    for (;;)
    {
      AppMethodBeat.o(196223);
      return paramCharSequence;
      if (paramBoolean)
      {
        paramCharSequence = new StaticLayout(paramCharSequence, this.hut, this.huu, this.huv, this.width, this.huw, this.huB, this.huA, this.huC, this.hux, paramInt1);
      }
      else if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.huz == null) {
          this.huz = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.b(paramCharSequence, this.hut, this.huu, this.huv, this.width, this.huw, this.huz, this.huB, this.huA, this.huC, this.hux, paramInt1, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.hut, this.huu, this.huv, this.width, this.huw, this.huB, this.huA, this.huC, this.hux, paramInt1, this.maxLines);
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
    localObject = aBk();
    ((d)localObject).hur = paramCharSequence.toString();
    ((d)localObject).hus = paramCharSequence;
    ((d)localObject).hut = 0;
    ((d)localObject).huu = i;
    ((d)localObject).width = paramInt;
    ((d)localObject).huv = new TextPaint();
    if (parama.maxLines != -1) {
      ((d)localObject).qi(parama.maxLines);
    }
    if (parama.maxLength != -1)
    {
      paramInt = parama.maxLength;
      if (paramInt >= 0)
      {
        ((d)localObject).maxLength = paramInt;
        ((d)localObject).huD = new InputFilter.LengthFilter(((d)localObject).maxLength);
      }
    }
    paramCharSequence = parama.huw;
    if (paramCharSequence != null) {
      ((d)localObject).huw = paramCharSequence;
    }
    if (parama.hux != null) {
      ((d)localObject).a(parama.hux);
    }
    ((d)localObject).gravity = parama.gravity;
    if (parama.huY != -1)
    {
      paramInt = parama.huY;
      if (paramInt >= 0) {
        ((d)localObject).huy = paramInt;
      }
    }
    if (parama.huz != null)
    {
      paramCharSequence = parama.huz;
      if (Build.VERSION.SDK_INT >= 18) {
        ((d)localObject).huz = paramCharSequence;
      }
    }
    float f1 = parama.huA;
    float f2 = parama.huB;
    ((d)localObject).huA = f1;
    ((d)localObject).huB = f2;
    ((d)localObject).huC = parama.huC;
    if (parama.sB != null)
    {
      if (parama.fontStyle == -1) {
        break label540;
      }
      paramCharSequence = parama.sB;
      i = parama.fontStyle;
      if (i <= 0) {
        break label512;
      }
      if (paramCharSequence != null) {
        break label492;
      }
      paramCharSequence = Typeface.defaultFromStyle(i);
      ((d)localObject).c(paramCharSequence);
      if (paramCharSequence == null) {
        break label502;
      }
      paramInt = paramCharSequence.getStyle();
      label330:
      paramInt = (paramInt ^ 0xFFFFFFFF) & i;
      paramCharSequence = ((d)localObject).huv;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      paramCharSequence.setFakeBoldText(bool);
      paramCharSequence = ((d)localObject).huv;
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
        ((d)localObject).huv.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        ((d)localObject).huv.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        ((d)localObject).huv.linkColor = paramInt;
      }
      if (parama.iW != null) {
        ((d)localObject).huv = parama.iW;
      }
      if (parama.breakStrategy >= 0)
      {
        paramInt = parama.breakStrategy;
        if (paramInt >= 0) {
          ((d)localObject).breakStrategy = paramInt;
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
      ((d)localObject).huv.setFakeBoldText(false);
      ((d)localObject).huv.setTextSkewX(0.0F);
      ((d)localObject).c(paramCharSequence);
      continue;
      label540:
      ((d)localObject).c(parama.sB);
    }
  }
  
  public static d a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    AppMethodBeat.i(196220);
    d locald = aBk();
    locald.hus = paramCharSequence;
    locald.hut = 0;
    locald.huu = paramCharSequence.length();
    locald.huv = paramTextPaint;
    locald.width = paramInt;
    AppMethodBeat.o(196220);
    return locald;
  }
  
  private static d aBk()
  {
    AppMethodBeat.i(196221);
    d locald2 = hup.aBm();
    d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new d();
    }
    AppMethodBeat.o(196221);
    return locald1;
  }
  
  private d c(Typeface paramTypeface)
  {
    AppMethodBeat.i(141028);
    this.huv.setTypeface(paramTypeface);
    AppMethodBeat.o(141028);
    return this;
  }
  
  public final d C(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(196222);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(196222);
      return this;
    }
    this.hus = paramCharSequence;
    this.hut = 0;
    this.huu = paramCharSequence.length();
    AppMethodBeat.o(196222);
    return this;
  }
  
  public final d a(TextUtils.TruncateAt paramTruncateAt)
  {
    if (paramTruncateAt != null) {
      this.hux = paramTruncateAt;
    }
    return this;
  }
  
  @TargetApi(18)
  public final f aBl()
  {
    AppMethodBeat.i(141029);
    int j;
    Object localObject1;
    if ((this.hux == null) || (this.huy <= 0))
    {
      j = this.width;
      if ((this.hux == null) && (this.maxLines == 1)) {
        this.hux = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.huD != null))
      {
        localObject1 = this.huD.filter(this.hus, 0, this.hus.length(), huq, 0, 0);
        if (localObject1 != null)
        {
          this.hus = ((CharSequence)localObject1);
          if (this.huu > this.hus.length()) {
            this.huu = this.hus.length();
          }
        }
      }
      if (h.DEBUG) {
        Log.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.hus + " " + this.width);
      }
      if (this.huw == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.gravity & 0x800007)
      {
      default: 
        this.huw = Layout.Alignment.ALIGN_NORMAL;
        label251:
        this.huv.setAntiAlias(true);
        localObject1 = null;
        if (((this.huz != null) && ((!com.tencent.mm.compatible.util.d.oD(18)) || (this.huz != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.hus, bool, j, this.breakStrategy);
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
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.hus);
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
                this.hus = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.hus, bool, j, this.breakStrategy);
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
        this.hus = this.hus.toString();
        localObject3 = a(this.hus, bool, j, this.breakStrategy);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).huG = this.hur;
      ((f)localObject1).text = this.hus;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).huw = this.huw;
      ((f)localObject1).hux = this.hux;
      ((f)localObject1).iW = this.huv;
      ((f)localObject1).gravity = this.gravity;
      ((f)localObject1).breakStrategy = this.breakStrategy;
      hup.a(this);
      AppMethodBeat.o(141029);
      return localObject1;
      j = this.huy;
      break;
      this.huw = Layout.Alignment.ALIGN_NORMAL;
      break label251;
      this.huw = Layout.Alignment.ALIGN_OPPOSITE;
      break label251;
      this.huw = Layout.Alignment.ALIGN_CENTER;
      break label251;
    }
  }
  
  public final d qi(int paramInt)
  {
    if (paramInt >= 0) {
      this.maxLines = paramInt;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */