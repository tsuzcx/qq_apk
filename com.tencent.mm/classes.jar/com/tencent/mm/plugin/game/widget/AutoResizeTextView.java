package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.ArrayList;

public class AutoResizeTextView
  extends TextView
{
  private a lgE;
  
  public AutoResizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e(paramAttributeSet);
  }
  
  public AutoResizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e(paramAttributeSet);
  }
  
  private void e(AttributeSet paramAttributeSet)
  {
    a locala = new a(this);
    if (paramAttributeSet != null)
    {
      int i = (int)locala.lgK;
      float f = locala.lgM;
      locala.k(0, i).as(f);
    }
    locala.gC(true);
    if (locala.mListeners == null) {
      locala.mListeners = new ArrayList();
    }
    locala.mListeners.add(this);
    this.lgE = locala;
  }
  
  public a getAutofitHelper()
  {
    return this.lgE;
  }
  
  public float getMaxTextSize()
  {
    return this.lgE.lgL;
  }
  
  public float getMinTextSize()
  {
    return this.lgE.lgK;
  }
  
  public float getPrecision()
  {
    return this.lgE.lgM;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.lgE != null) {
      this.lgE.bay();
    }
  }
  
  public void setLines(int paramInt)
  {
    super.setLines(paramInt);
    if (this.lgE != null) {
      this.lgE.so(paramInt);
    }
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    if (this.lgE != null) {
      this.lgE.so(paramInt);
    }
  }
  
  public void setMaxTextSize(float paramFloat)
  {
    a locala = this.lgE;
    Context localContext = locala.lh.getContext();
    Resources localResources = Resources.getSystem();
    if (localContext != null) {
      localResources = localContext.getResources();
    }
    paramFloat = TypedValue.applyDimension(2, paramFloat, localResources.getDisplayMetrics());
    if (paramFloat != locala.lgL)
    {
      locala.lgL = paramFloat;
      locala.bay();
    }
  }
  
  public void setMinTextSize(int paramInt)
  {
    this.lgE.k(2, paramInt);
  }
  
  public void setPrecision(float paramFloat)
  {
    this.lgE.as(paramFloat);
  }
  
  public void setSizeToFit(boolean paramBoolean)
  {
    this.lgE.gC(paramBoolean);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    if (this.lgE != null)
    {
      a locala = this.lgE;
      if (!locala.lgN)
      {
        Context localContext = locala.lh.getContext();
        Resources localResources = Resources.getSystem();
        if (localContext != null) {
          localResources = localContext.getResources();
        }
        locala.setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoResizeTextView
 * JD-Core Version:    0.7.0.1
 */