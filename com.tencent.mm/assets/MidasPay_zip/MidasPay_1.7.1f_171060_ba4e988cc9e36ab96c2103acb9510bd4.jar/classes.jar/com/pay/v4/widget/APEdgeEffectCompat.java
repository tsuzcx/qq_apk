package com.pay.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class APEdgeEffectCompat
{
  private static final EdgeEffectImpl IMPL = new BaseEdgeEffectImpl();
  private Object mEdgeEffect;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new EdgeEffectIcsImpl();
      return;
    }
  }
  
  public APEdgeEffectCompat(Context paramContext)
  {
    this.mEdgeEffect = IMPL.newEdgeEffect(paramContext);
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    return IMPL.draw(this.mEdgeEffect, paramCanvas);
  }
  
  public void finish()
  {
    IMPL.finish(this.mEdgeEffect);
  }
  
  public boolean isFinished()
  {
    return IMPL.isFinished(this.mEdgeEffect);
  }
  
  public boolean onAbsorb(int paramInt)
  {
    return IMPL.onAbsorb(this.mEdgeEffect, paramInt);
  }
  
  public boolean onPull(float paramFloat)
  {
    return IMPL.onPull(this.mEdgeEffect, paramFloat);
  }
  
  public boolean onRelease()
  {
    return IMPL.onRelease(this.mEdgeEffect);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    IMPL.setSize(this.mEdgeEffect, paramInt1, paramInt2);
  }
  
  static class BaseEdgeEffectImpl
    implements APEdgeEffectCompat.EdgeEffectImpl
  {
    public boolean draw(Object paramObject, Canvas paramCanvas)
    {
      return false;
    }
    
    public void finish(Object paramObject) {}
    
    public boolean isFinished(Object paramObject)
    {
      return true;
    }
    
    public Object newEdgeEffect(Context paramContext)
    {
      return null;
    }
    
    public boolean onAbsorb(Object paramObject, int paramInt)
    {
      return false;
    }
    
    public boolean onPull(Object paramObject, float paramFloat)
    {
      return false;
    }
    
    public boolean onRelease(Object paramObject)
    {
      return false;
    }
    
    public void setSize(Object paramObject, int paramInt1, int paramInt2) {}
  }
  
  static class EdgeEffectIcsImpl
    implements APEdgeEffectCompat.EdgeEffectImpl
  {
    public boolean draw(Object paramObject, Canvas paramCanvas)
    {
      return APEdgeEffectCompatIcs.draw(paramObject, paramCanvas);
    }
    
    public void finish(Object paramObject)
    {
      APEdgeEffectCompatIcs.finish(paramObject);
    }
    
    public boolean isFinished(Object paramObject)
    {
      return APEdgeEffectCompatIcs.isFinished(paramObject);
    }
    
    public Object newEdgeEffect(Context paramContext)
    {
      return APEdgeEffectCompatIcs.newEdgeEffect(paramContext);
    }
    
    public boolean onAbsorb(Object paramObject, int paramInt)
    {
      return APEdgeEffectCompatIcs.onAbsorb(paramObject, paramInt);
    }
    
    public boolean onPull(Object paramObject, float paramFloat)
    {
      return APEdgeEffectCompatIcs.onPull(paramObject, paramFloat);
    }
    
    public boolean onRelease(Object paramObject)
    {
      return APEdgeEffectCompatIcs.onRelease(paramObject);
    }
    
    public void setSize(Object paramObject, int paramInt1, int paramInt2)
    {
      APEdgeEffectCompatIcs.setSize(paramObject, paramInt1, paramInt2);
    }
  }
  
  static abstract interface EdgeEffectImpl
  {
    public abstract boolean draw(Object paramObject, Canvas paramCanvas);
    
    public abstract void finish(Object paramObject);
    
    public abstract boolean isFinished(Object paramObject);
    
    public abstract Object newEdgeEffect(Context paramContext);
    
    public abstract boolean onAbsorb(Object paramObject, int paramInt);
    
    public abstract boolean onPull(Object paramObject, float paramFloat);
    
    public abstract boolean onRelease(Object paramObject);
    
    public abstract void setSize(Object paramObject, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.v4.widget.APEdgeEffectCompat
 * JD-Core Version:    0.7.0.1
 */