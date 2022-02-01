package com.pay.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public class APAccessibilityEventCompat
{
  public static final AccessibilityEventVersionImpl IMPL = new AccessibilityEventStubImpl();
  public static final int TYPES_ALL_MASK = -1;
  public static final int TYPE_ANNOUNCEMENT = 16384;
  public static final int TYPE_GESTURE_DETECTION_END = 524288;
  public static final int TYPE_GESTURE_DETECTION_START = 262144;
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
  public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
  public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
  public static final int TYPE_VIEW_HOVER_ENTER = 128;
  public static final int TYPE_VIEW_HOVER_EXIT = 256;
  public static final int TYPE_VIEW_SCROLLED = 4096;
  public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
  public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
  public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityEventIcsImpl();
      return;
    }
  }
  
  public static void appendRecord(AccessibilityEvent paramAccessibilityEvent, APAccessibilityRecordCompat paramAPAccessibilityRecordCompat)
  {
    IMPL.appendRecord(paramAccessibilityEvent, paramAPAccessibilityRecordCompat.getImpl());
  }
  
  public static APAccessibilityRecordCompat asRecord(AccessibilityEvent paramAccessibilityEvent)
  {
    return new APAccessibilityRecordCompat(paramAccessibilityEvent);
  }
  
  public static APAccessibilityRecordCompat getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    return new APAccessibilityRecordCompat(IMPL.getRecord(paramAccessibilityEvent, paramInt));
  }
  
  public static int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
  {
    return IMPL.getRecordCount(paramAccessibilityEvent);
  }
  
  public static class AccessibilityEventIcsImpl
    extends APAccessibilityEventCompat.AccessibilityEventStubImpl
  {
    public void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject)
    {
      APAccessibilityEventCompatIcs.appendRecord(paramAccessibilityEvent, paramObject);
    }
    
    public Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
    {
      return APAccessibilityEventCompatIcs.getRecord(paramAccessibilityEvent, paramInt);
    }
    
    public int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
    {
      return APAccessibilityEventCompatIcs.getRecordCount(paramAccessibilityEvent);
    }
  }
  
  public static class AccessibilityEventStubImpl
    implements APAccessibilityEventCompat.AccessibilityEventVersionImpl
  {
    public void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject) {}
    
    public Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
    {
      return null;
    }
    
    public int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
    {
      return 0;
    }
  }
  
  public static abstract interface AccessibilityEventVersionImpl
  {
    public abstract void appendRecord(AccessibilityEvent paramAccessibilityEvent, Object paramObject);
    
    public abstract Object getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt);
    
    public abstract int getRecordCount(AccessibilityEvent paramAccessibilityEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.accessibility.APAccessibilityEventCompat
 * JD-Core Version:    0.7.0.1
 */