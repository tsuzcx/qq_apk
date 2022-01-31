package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private TextWatcher ami;
  private int kja;
  private boolean mEnabled;
  private ArrayList<b> mListeners;
  private TextPaint mPaint;
  TextView md;
  private float nEC;
  float nED;
  float nEE;
  float nEF;
  boolean nEG;
  
  private a(TextView paramTextView)
  {
    AppMethodBeat.i(112375);
    this.ami = new a.a(this, (byte)0);
    float f = paramTextView.getContext().getResources().getDisplayMetrics().scaledDensity;
    this.md = paramTextView;
    this.mPaint = new TextPaint();
    setRawTextSize(paramTextView.getTextSize());
    int i = -1;
    TransformationMethod localTransformationMethod = paramTextView.getTransformationMethod();
    if ((localTransformationMethod != null) && ((localTransformationMethod instanceof SingleLineTransformationMethod))) {
      i = 1;
    }
    for (;;)
    {
      this.kja = i;
      this.nED = (8.0F * f);
      this.nEE = this.nEC;
      this.nEF = 0.5F;
      AppMethodBeat.o(112375);
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        i = paramTextView.getMaxLines();
      }
    }
  }
  
  private static float a(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(112374);
    float f1 = paramFloat2;
    paramFloat2 = (f1 + paramFloat3) / 2.0F;
    paramTextPaint.setTextSize(TypedValue.applyDimension(0, paramFloat2, paramDisplayMetrics));
    StaticLayout localStaticLayout;
    if (paramInt != 1) {
      localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, (int)paramFloat1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
    for (int i = localStaticLayout.getLineCount();; i = 1)
    {
      if (i > paramInt)
      {
        if (paramFloat3 - f1 < paramFloat4)
        {
          AppMethodBeat.o(112374);
          return f1;
        }
        paramFloat3 = paramFloat2;
        break;
      }
      if (i < paramInt)
      {
        f1 = paramFloat2;
        break;
      }
      float f2 = 0.0F;
      float f3;
      if (paramInt == 1)
      {
        f3 = paramTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
        if (paramFloat3 - f1 < paramFloat4)
        {
          AppMethodBeat.o(112374);
          return f1;
        }
      }
      else
      {
        int j = 0;
        for (;;)
        {
          f3 = f2;
          if (j >= i) {
            break;
          }
          f3 = f2;
          if (localStaticLayout.getLineWidth(j) > f2) {
            f3 = localStaticLayout.getLineWidth(j);
          }
          j += 1;
          f2 = f3;
        }
      }
      if (f3 > paramFloat1)
      {
        paramFloat3 = paramFloat2;
        break;
      }
      if (f3 < paramFloat1)
      {
        f1 = paramFloat2;
        break;
      }
      AppMethodBeat.o(112374);
      return paramFloat2;
      localStaticLayout = null;
    }
  }
  
  public static a a(TextView paramTextView, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(112372);
    paramTextView = new a(paramTextView);
    if (paramAttributeSet != null)
    {
      int i = (int)paramTextView.nED;
      float f = paramTextView.nEF;
      paramTextView.m(0, i).aK(f);
    }
    paramTextView.in(true);
    AppMethodBeat.o(112372);
    return paramTextView;
  }
  
  private static void a(TextView paramTextView, TextPaint paramTextPaint, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    AppMethodBeat.i(112373);
    if ((paramInt <= 0) || (paramInt == 2147483647))
    {
      AppMethodBeat.o(112373);
      return;
    }
    int i = paramTextView.getWidth() - paramTextView.getPaddingLeft() - paramTextView.getPaddingRight();
    if (i <= 0)
    {
      AppMethodBeat.o(112373);
      return;
    }
    Object localObject2 = paramTextView.getText();
    Object localObject3 = paramTextView.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, paramTextView);
    }
    localObject3 = paramTextView.getContext();
    localObject2 = Resources.getSystem();
    if (localObject3 != null) {
      localObject2 = ((Context)localObject3).getResources();
    }
    localObject2 = ((Resources)localObject2).getDisplayMetrics();
    paramTextPaint.set(paramTextView.getPaint());
    paramTextPaint.setTextSize(paramFloat2);
    if ((paramInt != 1) || (paramTextPaint.measureText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length()) <= i))
    {
      float f = i;
      paramTextPaint.setTextSize(TypedValue.applyDimension(0, paramFloat2, (DisplayMetrics)localObject2));
      if (new StaticLayout((CharSequence)localObject1, paramTextPaint, (int)f, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= paramInt) {}
    }
    else
    {
      paramFloat2 = a((CharSequence)localObject1, paramTextPaint, i, paramInt, 0.0F, paramFloat2, paramFloat3, (DisplayMetrics)localObject2);
    }
    for (;;)
    {
      if (paramFloat2 < paramFloat1) {}
      for (;;)
      {
        paramTextView.setTextSize(0, paramFloat1);
        AppMethodBeat.o(112373);
        return;
        paramFloat1 = paramFloat2;
      }
    }
  }
  
  private void aL(float paramFloat)
  {
    AppMethodBeat.i(112379);
    if (paramFloat != this.nED)
    {
      this.nED = paramFloat;
      bHG();
    }
    AppMethodBeat.o(112379);
  }
  
  private void bHH()
  {
    AppMethodBeat.i(112383);
    if (this.mListeners == null)
    {
      AppMethodBeat.o(112383);
      return;
    }
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(112383);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(112376);
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramb);
    AppMethodBeat.o(112376);
    return this;
  }
  
  public final a aK(float paramFloat)
  {
    AppMethodBeat.i(112377);
    if (this.nEF != paramFloat)
    {
      this.nEF = paramFloat;
      bHG();
    }
    AppMethodBeat.o(112377);
    return this;
  }
  
  public final void bHG()
  {
    AppMethodBeat.i(112382);
    float f = this.md.getTextSize();
    this.nEG = true;
    a(this.md, this.mPaint, this.nED, this.nEE, this.kja, this.nEF);
    this.nEG = false;
    if (this.md.getTextSize() != f) {
      bHH();
    }
    AppMethodBeat.o(112382);
  }
  
  public final a in(boolean paramBoolean)
  {
    AppMethodBeat.i(112381);
    if (this.mEnabled != paramBoolean)
    {
      this.mEnabled = paramBoolean;
      if (!paramBoolean) {
        break label44;
      }
      this.md.addTextChangedListener(this.ami);
      bHG();
    }
    for (;;)
    {
      AppMethodBeat.o(112381);
      return this;
      label44:
      this.md.removeTextChangedListener(this.ami);
      this.md.setTextSize(0, this.nEC);
    }
  }
  
  public final a m(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(112378);
    Context localContext = this.md.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    aL(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
    AppMethodBeat.o(112378);
    return this;
  }
  
  final void setRawTextSize(float paramFloat)
  {
    if (this.nEC != paramFloat) {
      this.nEC = paramFloat;
    }
  }
  
  public final a xo(int paramInt)
  {
    AppMethodBeat.i(112380);
    if (this.kja != paramInt)
    {
      this.kja = paramInt;
      bHG();
    }
    AppMethodBeat.o(112380);
    return this;
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.a
 * JD-Core Version:    0.7.0.1
 */