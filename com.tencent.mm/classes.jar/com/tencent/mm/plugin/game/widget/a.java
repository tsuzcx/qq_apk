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
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private boolean IL;
  private TextWatcher ajS = new a.a(this, (byte)0);
  private float lgI;
  private int lgJ;
  float lgK;
  float lgL;
  float lgM;
  boolean lgN;
  TextView lh;
  ArrayList<Object> mListeners;
  private TextPaint mPaint;
  
  a(TextView paramTextView)
  {
    float f = paramTextView.getContext().getResources().getDisplayMetrics().scaledDensity;
    this.lh = paramTextView;
    this.mPaint = new TextPaint();
    setRawTextSize(paramTextView.getTextSize());
    int i = -1;
    TransformationMethod localTransformationMethod = paramTextView.getTransformationMethod();
    if ((localTransformationMethod != null) && ((localTransformationMethod instanceof SingleLineTransformationMethod))) {
      i = 1;
    }
    for (;;)
    {
      this.lgJ = i;
      this.lgK = (8.0F * f);
      this.lgL = this.lgI;
      this.lgM = 0.5F;
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        i = paramTextView.getMaxLines();
      }
    }
  }
  
  private static float a(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, DisplayMetrics paramDisplayMetrics)
  {
    float f1 = paramFloat2;
    paramFloat2 = (f1 + paramFloat3) / 2.0F;
    paramTextPaint.setTextSize(TypedValue.applyDimension(0, paramFloat2, paramDisplayMetrics));
    StaticLayout localStaticLayout;
    if (paramInt != 1) {
      localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, (int)paramFloat1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
    for (int i = localStaticLayout.getLineCount();; i = 1)
    {
      if (i > paramInt) {
        if (paramFloat3 - f1 >= paramFloat4) {}
      }
      float f2;
      float f3;
      while (paramFloat3 - f1 < paramFloat4)
      {
        return f1;
        paramFloat3 = paramFloat2;
        break;
        if (i < paramInt)
        {
          f1 = paramFloat2;
          break;
        }
        f2 = 0.0F;
        if (paramInt != 1) {
          break label143;
        }
        f3 = paramTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
      }
      if (f3 > paramFloat1)
      {
        paramFloat3 = paramFloat2;
        break;
        label143:
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
      if (f3 < paramFloat1)
      {
        f1 = paramFloat2;
        break;
      }
      return paramFloat2;
      localStaticLayout = null;
    }
  }
  
  private void baz()
  {
    if (this.mListeners == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
  }
  
  public final a as(float paramFloat)
  {
    if (this.lgM != paramFloat)
    {
      this.lgM = paramFloat;
      bay();
    }
    return this;
  }
  
  public final void bay()
  {
    float f4 = this.lh.getTextSize();
    this.lgN = true;
    TextView localTextView = this.lh;
    TextPaint localTextPaint = this.mPaint;
    float f3 = this.lgK;
    float f1 = this.lgL;
    int i = this.lgJ;
    float f2 = this.lgM;
    if ((i <= 0) || (i == 2147483647)) {}
    int j;
    do
    {
      this.lgN = false;
      if (this.lh.getTextSize() != f4) {
        baz();
      }
      return;
      j = localTextView.getWidth() - localTextView.getPaddingLeft() - localTextView.getPaddingRight();
    } while (j <= 0);
    Object localObject2 = localTextView.getText();
    Object localObject3 = localTextView.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, localTextView);
    }
    localObject3 = localTextView.getContext();
    localObject2 = Resources.getSystem();
    if (localObject3 != null) {
      localObject2 = ((Context)localObject3).getResources();
    }
    localObject2 = ((Resources)localObject2).getDisplayMetrics();
    localTextPaint.set(localTextView.getPaint());
    localTextPaint.setTextSize(f1);
    if ((i != 1) || (localTextPaint.measureText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length()) <= j))
    {
      float f5 = j;
      localTextPaint.setTextSize(TypedValue.applyDimension(0, f1, (DisplayMetrics)localObject2));
      if (new StaticLayout((CharSequence)localObject1, localTextPaint, (int)f5, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() <= i) {}
    }
    else
    {
      f1 = a((CharSequence)localObject1, localTextPaint, j, i, 0.0F, f1, f2, (DisplayMetrics)localObject2);
    }
    for (;;)
    {
      f2 = f1;
      if (f1 < f3) {
        f2 = f3;
      }
      localTextView.setTextSize(0, f2);
      break;
    }
  }
  
  public final a gC(boolean paramBoolean)
  {
    if (this.IL != paramBoolean)
    {
      this.IL = paramBoolean;
      if (paramBoolean)
      {
        this.lh.addTextChangedListener(this.ajS);
        bay();
      }
    }
    else
    {
      return this;
    }
    this.lh.removeTextChangedListener(this.ajS);
    this.lh.setTextSize(0, this.lgI);
    return this;
  }
  
  public final a k(int paramInt, float paramFloat)
  {
    Context localContext = this.lh.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    paramFloat = TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics());
    if (paramFloat != this.lgK)
    {
      this.lgK = paramFloat;
      bay();
    }
    return this;
  }
  
  final void setRawTextSize(float paramFloat)
  {
    if (this.lgI != paramFloat) {
      this.lgI = paramFloat;
    }
  }
  
  public final a so(int paramInt)
  {
    if (this.lgJ != paramInt)
    {
      this.lgJ = paramInt;
      bay();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.a
 * JD-Core Version:    0.7.0.1
 */