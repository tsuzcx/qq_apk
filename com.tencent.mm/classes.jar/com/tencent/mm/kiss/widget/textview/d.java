package com.tencent.mm.kiss.widget.textview;

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
  private static e mGI;
  private static final SpannableString mGJ;
  TextPaint bbb = null;
  Layout.Alignment bbd = Layout.Alignment.ALIGN_NORMAL;
  TextUtils.TruncateAt bbe = null;
  int bbf = -1;
  int bbl = -1;
  public int fl = 51;
  CharSequence mGK = null;
  CharSequence mGL = null;
  int mGM = 0;
  int mGN = 0;
  TextDirectionHeuristic mGO = null;
  float mGP = 0.0F;
  float mGQ = 1.1F;
  boolean mGR = false;
  InputFilter.LengthFilter mGS = null;
  int maxLength = -1;
  int maxLines = 2147483647;
  int width = 0;
  
  static
  {
    AppMethodBeat.i(141031);
    mGI = new e();
    mGJ = new SpannableString("");
    AppMethodBeat.o(141031);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233786);
    if (paramInt2 >= 0) {
      paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, this.mGM, this.mGN, this.bbb, this.width).setAlignment(this.bbd).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.mGP, this.mGQ).setIncludePad(this.mGR).setEllipsize(this.bbe).setEllipsizedWidth(paramInt1).setBreakStrategy(paramInt2).setMaxLines(2147483647).build();
    }
    for (;;)
    {
      AppMethodBeat.o(233786);
      return paramCharSequence;
      if (paramBoolean)
      {
        paramCharSequence = new StaticLayout(paramCharSequence, this.mGM, this.mGN, this.bbb, this.width, this.bbd, this.mGQ, this.mGP, this.mGR, this.bbe, paramInt1);
      }
      else if (Build.VERSION.SDK_INT >= 18)
      {
        if (this.mGO == null) {
          this.mGO = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.b(paramCharSequence, this.mGM, this.mGN, this.bbb, this.width, this.bbd, this.mGO, this.mGQ, this.mGP, this.mGR, this.bbe, paramInt1, this.maxLines);
      }
      else
      {
        paramCharSequence = com.tencent.mm.kiss.widget.textview.b.a.a(paramCharSequence, this.mGM, this.mGN, this.bbb, this.width, this.bbd, this.mGQ, this.mGP, this.mGR, this.bbe, paramInt1, this.maxLines);
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
    localObject = bbJ();
    ((d)localObject).mGK = paramCharSequence.toString();
    ((d)localObject).mGL = paramCharSequence;
    ((d)localObject).mGM = 0;
    ((d)localObject).mGN = i;
    ((d)localObject).width = paramInt;
    ((d)localObject).bbb = new TextPaint();
    if (parama.maxLines != -1) {
      ((d)localObject).sF(parama.maxLines);
    }
    if (parama.maxLength != -1)
    {
      paramInt = parama.maxLength;
      if (paramInt >= 0)
      {
        ((d)localObject).maxLength = paramInt;
        ((d)localObject).mGS = new InputFilter.LengthFilter(((d)localObject).maxLength);
      }
    }
    paramCharSequence = parama.bbd;
    if (paramCharSequence != null) {
      ((d)localObject).bbd = paramCharSequence;
    }
    if (parama.bbe != null) {
      ((d)localObject).a(parama.bbe);
    }
    ((d)localObject).fl = parama.fl;
    if (parama.mHo != -1)
    {
      paramInt = parama.mHo;
      if (paramInt >= 0) {
        ((d)localObject).bbf = paramInt;
      }
    }
    if (parama.mGO != null)
    {
      paramCharSequence = parama.mGO;
      if (Build.VERSION.SDK_INT >= 18) {
        ((d)localObject).mGO = paramCharSequence;
      }
    }
    float f1 = parama.mGP;
    float f2 = parama.mGQ;
    ((d)localObject).mGP = f1;
    ((d)localObject).mGQ = f2;
    ((d)localObject).mGR = parama.mGR;
    if (parama.bbO != null)
    {
      if (parama.fontStyle == -1) {
        break label540;
      }
      paramCharSequence = parama.bbO;
      i = parama.fontStyle;
      if (i <= 0) {
        break label512;
      }
      if (paramCharSequence != null) {
        break label492;
      }
      paramCharSequence = Typeface.defaultFromStyle(i);
      ((d)localObject).g(paramCharSequence);
      if (paramCharSequence == null) {
        break label502;
      }
      paramInt = paramCharSequence.getStyle();
      label330:
      paramInt = (paramInt ^ 0xFFFFFFFF) & i;
      paramCharSequence = ((d)localObject).bbb;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      paramCharSequence.setFakeBoldText(bool);
      paramCharSequence = ((d)localObject).bbb;
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
        ((d)localObject).bbb.setTextSize(f1);
      }
      if (parama.textColor != -1)
      {
        paramInt = parama.textColor;
        ((d)localObject).bbb.setColor(paramInt);
      }
      if (parama.linkColor != -1)
      {
        paramInt = parama.linkColor;
        ((d)localObject).bbb.linkColor = paramInt;
      }
      if (parama.dso != null) {
        ((d)localObject).bbb = parama.dso;
      }
      if (parama.bbl >= 0)
      {
        paramInt = parama.bbl;
        if (paramInt >= 0) {
          ((d)localObject).bbl = paramInt;
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
      ((d)localObject).bbb.setFakeBoldText(false);
      ((d)localObject).bbb.setTextSkewX(0.0F);
      ((d)localObject).g(paramCharSequence);
      continue;
      label540:
      ((d)localObject).g(parama.bbO);
    }
  }
  
  public static d a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    AppMethodBeat.i(233766);
    d locald = bbJ();
    locald.mGL = paramCharSequence;
    locald.mGM = 0;
    locald.mGN = paramCharSequence.length();
    locald.bbb = paramTextPaint;
    locald.width = paramInt;
    AppMethodBeat.o(233766);
    return locald;
  }
  
  private static d bbJ()
  {
    AppMethodBeat.i(233771);
    d locald2 = mGI.bbL();
    d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new d();
    }
    AppMethodBeat.o(233771);
    return locald1;
  }
  
  private d g(Typeface paramTypeface)
  {
    AppMethodBeat.i(141028);
    this.bbb.setTypeface(paramTypeface);
    AppMethodBeat.o(141028);
    return this;
  }
  
  public final d M(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(233797);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(233797);
      return this;
    }
    this.mGL = paramCharSequence;
    this.mGM = 0;
    this.mGN = paramCharSequence.length();
    AppMethodBeat.o(233797);
    return this;
  }
  
  public final d a(TextUtils.TruncateAt paramTruncateAt)
  {
    if (paramTruncateAt != null) {
      this.bbe = paramTruncateAt;
    }
    return this;
  }
  
  public final f bbK()
  {
    AppMethodBeat.i(141029);
    int j;
    Object localObject1;
    if ((this.bbe == null) || (this.bbf <= 0))
    {
      j = this.width;
      if ((this.bbe == null) && (this.maxLines == 1)) {
        this.bbe = TextUtils.TruncateAt.END;
      }
      if ((this.maxLength > 0) && (this.mGS != null))
      {
        localObject1 = this.mGS.filter(this.mGL, 0, this.mGL.length(), mGJ, 0, 0);
        if (localObject1 != null)
        {
          this.mGL = ((CharSequence)localObject1);
          if (this.mGN > this.mGL.length()) {
            this.mGN = this.mGL.length();
          }
        }
      }
      if (h.DEBUG) {
        Log.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.mGL + " " + this.width);
      }
      if (this.bbd == Layout.Alignment.ALIGN_NORMAL) {}
      switch (this.fl & 0x800007)
      {
      default: 
        this.bbd = Layout.Alignment.ALIGN_NORMAL;
        label251:
        this.bbb.setAntiAlias(true);
        localObject1 = null;
        if (((this.mGO != null) && ((!com.tencent.mm.compatible.util.d.rb(18)) || (this.mGO != TextDirectionHeuristics.FIRSTSTRONG_LTR))) || ((this.maxLines != 2147483647) && (this.maxLines != -1))) {
          break;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      try
      {
        localObject3 = a(this.mGL, bool, j, this.bbl);
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
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.mGL);
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
                this.mGL = localSpannableStringBuilder;
                k = i;
                localObject4 = localObject1;
                localObject1 = a(this.mGL, bool, j, this.bbl);
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
        this.mGL = this.mGL.toString();
        localObject3 = a(this.mGL, bool, j, this.bbl);
      }
      localObject1 = new f((StaticLayout)localObject3);
      ((f)localObject1).mGV = this.mGK;
      ((f)localObject1).bba = this.mGL;
      ((f)localObject1).maxLength = this.maxLength;
      ((f)localObject1).maxLines = this.maxLines;
      ((f)localObject1).bbd = this.bbd;
      ((f)localObject1).bbe = this.bbe;
      ((f)localObject1).dso = this.bbb;
      ((f)localObject1).fl = this.fl;
      ((f)localObject1).bbl = this.bbl;
      mGI.a(this);
      AppMethodBeat.o(141029);
      return localObject1;
      j = this.bbf;
      break;
      this.bbd = Layout.Alignment.ALIGN_NORMAL;
      break label251;
      this.bbd = Layout.Alignment.ALIGN_OPPOSITE;
      break label251;
      this.bbd = Layout.Alignment.ALIGN_CENTER;
      break label251;
    }
  }
  
  public final d sF(int paramInt)
  {
    if (paramInt >= 0) {
      this.maxLines = paramInt;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.d
 * JD-Core Version:    0.7.0.1
 */