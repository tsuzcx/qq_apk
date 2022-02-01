package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Editable;
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

public class a
{
  float IYA;
  float IYB;
  boolean IYC;
  float IYz;
  private TextPaint bsk;
  private boolean mEnabled;
  private ArrayList<b> mListeners;
  TextView sQ;
  private TextWatcher vU;
  private int vYT;
  private float xBL;
  
  private a(TextView paramTextView)
  {
    AppMethodBeat.i(42581);
    this.vU = new a((byte)0);
    float f = paramTextView.getContext().getResources().getDisplayMetrics().scaledDensity;
    this.sQ = paramTextView;
    this.bsk = new TextPaint();
    setRawTextSize(paramTextView.getTextSize());
    int i = -1;
    TransformationMethod localTransformationMethod = paramTextView.getTransformationMethod();
    if ((localTransformationMethod != null) && ((localTransformationMethod instanceof SingleLineTransformationMethod))) {
      i = 1;
    }
    for (;;)
    {
      this.vYT = i;
      this.IYz = (8.0F * f);
      this.IYA = this.xBL;
      this.IYB = 0.5F;
      AppMethodBeat.o(42581);
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        i = paramTextView.getMaxLines();
      }
    }
  }
  
  private static float a(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4, DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(42580);
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
          AppMethodBeat.o(42580);
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
          AppMethodBeat.o(42580);
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
      AppMethodBeat.o(42580);
      return paramFloat2;
      localStaticLayout = null;
    }
  }
  
  public static a a(TextView paramTextView, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(42578);
    paramTextView = new a(paramTextView);
    if (paramAttributeSet != null)
    {
      int i = (int)paramTextView.IYz;
      float f = paramTextView.IYB;
      paramTextView.v(0, i).cu(f);
    }
    paramTextView.wA(true);
    AppMethodBeat.o(42578);
    return paramTextView;
  }
  
  private static void a(TextView paramTextView, TextPaint paramTextPaint, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    AppMethodBeat.i(42579);
    if ((paramInt <= 0) || (paramInt == 2147483647))
    {
      AppMethodBeat.o(42579);
      return;
    }
    int i = paramTextView.getWidth() - paramTextView.getPaddingLeft() - paramTextView.getPaddingRight();
    if (i <= 0)
    {
      AppMethodBeat.o(42579);
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
        AppMethodBeat.o(42579);
        return;
        paramFloat1 = paramFloat2;
      }
    }
  }
  
  private void cv(float paramFloat)
  {
    AppMethodBeat.i(42585);
    if (paramFloat != this.IYz)
    {
      this.IYz = paramFloat;
      fId();
    }
    AppMethodBeat.o(42585);
  }
  
  private void fIe()
  {
    AppMethodBeat.i(42589);
    if (this.mListeners == null)
    {
      AppMethodBeat.o(42589);
      return;
    }
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    AppMethodBeat.o(42589);
  }
  
  public final a XS(int paramInt)
  {
    AppMethodBeat.i(42586);
    if (this.vYT != paramInt)
    {
      this.vYT = paramInt;
      fId();
    }
    AppMethodBeat.o(42586);
    return this;
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(42582);
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramb);
    AppMethodBeat.o(42582);
    return this;
  }
  
  public final a cu(float paramFloat)
  {
    AppMethodBeat.i(42583);
    if (this.IYB != paramFloat)
    {
      this.IYB = paramFloat;
      fId();
    }
    AppMethodBeat.o(42583);
    return this;
  }
  
  public final void fId()
  {
    AppMethodBeat.i(42588);
    float f = this.sQ.getTextSize();
    this.IYC = true;
    a(this.sQ, this.bsk, this.IYz, this.IYA, this.vYT, this.IYB);
    this.IYC = false;
    if (this.sQ.getTextSize() != f) {
      fIe();
    }
    AppMethodBeat.o(42588);
  }
  
  final void setRawTextSize(float paramFloat)
  {
    if (this.xBL != paramFloat) {
      this.xBL = paramFloat;
    }
  }
  
  public final a v(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(42584);
    Context localContext = this.sQ.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    cv(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
    AppMethodBeat.o(42584);
    return this;
  }
  
  public final a wA(boolean paramBoolean)
  {
    AppMethodBeat.i(42587);
    if (this.mEnabled != paramBoolean)
    {
      this.mEnabled = paramBoolean;
      if (!paramBoolean) {
        break label44;
      }
      this.sQ.addTextChangedListener(this.vU);
      fId();
    }
    for (;;)
    {
      AppMethodBeat.o(42587);
      return this;
      label44:
      this.sQ.removeTextChangedListener(this.vU);
      this.sQ.setTextSize(0, this.xBL);
    }
  }
  
  final class a
    implements TextWatcher
  {
    private a() {}
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(42577);
      a.this.fId();
      AppMethodBeat.o(42577);
    }
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.a
 * JD-Core Version:    0.7.0.1
 */