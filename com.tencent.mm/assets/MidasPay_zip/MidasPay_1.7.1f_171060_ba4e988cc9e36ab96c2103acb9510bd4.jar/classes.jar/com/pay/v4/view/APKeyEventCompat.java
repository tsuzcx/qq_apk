package com.pay.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

public class APKeyEventCompat
{
  static final KeyEventVersionImpl IMPL = new BaseKeyEventVersionImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new HoneycombKeyEventVersionImpl();
      return;
    }
  }
  
  public static boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
  {
    return IMPL.dispatch(paramKeyEvent, paramCallback, paramObject1, paramObject2);
  }
  
  public static Object getKeyDispatcherState(View paramView)
  {
    return IMPL.getKeyDispatcherState(paramView);
  }
  
  public static boolean hasModifiers(KeyEvent paramKeyEvent, int paramInt)
  {
    return IMPL.metaStateHasModifiers(paramKeyEvent.getMetaState(), paramInt);
  }
  
  public static boolean hasNoModifiers(KeyEvent paramKeyEvent)
  {
    return IMPL.metaStateHasNoModifiers(paramKeyEvent.getMetaState());
  }
  
  public static boolean isTracking(KeyEvent paramKeyEvent)
  {
    return IMPL.isTracking(paramKeyEvent);
  }
  
  public static boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    return IMPL.metaStateHasModifiers(paramInt1, paramInt2);
  }
  
  public static boolean metaStateHasNoModifiers(int paramInt)
  {
    return IMPL.metaStateHasNoModifiers(paramInt);
  }
  
  public static int normalizeMetaState(int paramInt)
  {
    return IMPL.normalizeMetaState(paramInt);
  }
  
  public static void startTracking(KeyEvent paramKeyEvent)
  {
    IMPL.startTracking(paramKeyEvent);
  }
  
  static class BaseKeyEventVersionImpl
    implements APKeyEventCompat.KeyEventVersionImpl
  {
    private static final int META_ALL_MASK = 247;
    private static final int META_MODIFIER_MASK = 247;
    
    private static int metaStateFilterDirectionalModifiers(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      int j = 0;
      int i;
      if ((paramInt2 & paramInt3) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      paramInt5 = paramInt4 | paramInt5;
      paramInt4 = j;
      if ((paramInt2 & paramInt5) != 0) {
        paramInt4 = 1;
      }
      if (i != 0)
      {
        if (paramInt4 == 0) {
          return paramInt1 & (paramInt5 ^ 0xFFFFFFFF);
        }
        throw new IllegalArgumentException("bad arguments");
      }
      if (paramInt4 != 0) {
        return paramInt1 & (paramInt3 ^ 0xFFFFFFFF);
      }
      return paramInt1;
    }
    
    public boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
    {
      return paramKeyEvent.dispatch(paramCallback);
    }
    
    public Object getKeyDispatcherState(View paramView)
    {
      return null;
    }
    
    public boolean isTracking(KeyEvent paramKeyEvent)
    {
      return false;
    }
    
    public boolean metaStateHasModifiers(int paramInt1, int paramInt2)
    {
      return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(paramInt1) & 0xF7, paramInt2, 1, 64, 128), paramInt2, 2, 16, 32) == paramInt2;
    }
    
    public boolean metaStateHasNoModifiers(int paramInt)
    {
      return (normalizeMetaState(paramInt) & 0xF7) == 0;
    }
    
    public int normalizeMetaState(int paramInt)
    {
      int i = paramInt;
      if ((paramInt & 0xC0) != 0) {
        i = paramInt | 0x1;
      }
      paramInt = i;
      if ((i & 0x30) != 0) {
        paramInt = i | 0x2;
      }
      return paramInt & 0xF7;
    }
    
    public void startTracking(KeyEvent paramKeyEvent) {}
  }
  
  static class EclairKeyEventVersionImpl
    extends APKeyEventCompat.BaseKeyEventVersionImpl
  {
    public boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
    {
      return APKeyEventCompatEclair.dispatch(paramKeyEvent, paramCallback, paramObject1, paramObject2);
    }
    
    public Object getKeyDispatcherState(View paramView)
    {
      return APKeyEventCompatEclair.getKeyDispatcherState(paramView);
    }
    
    public boolean isTracking(KeyEvent paramKeyEvent)
    {
      return APKeyEventCompatEclair.isTracking(paramKeyEvent);
    }
    
    public void startTracking(KeyEvent paramKeyEvent)
    {
      APKeyEventCompatEclair.startTracking(paramKeyEvent);
    }
  }
  
  static class HoneycombKeyEventVersionImpl
    extends APKeyEventCompat.EclairKeyEventVersionImpl
  {
    public boolean metaStateHasModifiers(int paramInt1, int paramInt2)
    {
      return APKeyEventCompatHoneycomb.metaStateHasModifiers(paramInt1, paramInt2);
    }
    
    public boolean metaStateHasNoModifiers(int paramInt)
    {
      return APKeyEventCompatHoneycomb.metaStateHasNoModifiers(paramInt);
    }
    
    public int normalizeMetaState(int paramInt)
    {
      return APKeyEventCompatHoneycomb.normalizeMetaState(paramInt);
    }
  }
  
  static abstract interface KeyEventVersionImpl
  {
    public abstract boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2);
    
    public abstract Object getKeyDispatcherState(View paramView);
    
    public abstract boolean isTracking(KeyEvent paramKeyEvent);
    
    public abstract boolean metaStateHasModifiers(int paramInt1, int paramInt2);
    
    public abstract boolean metaStateHasNoModifiers(int paramInt);
    
    public abstract int normalizeMetaState(int paramInt);
    
    public abstract void startTracking(KeyEvent paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.APKeyEventCompat
 * JD-Core Version:    0.7.0.1
 */