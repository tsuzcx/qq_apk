package com.pay.v4.view.accessibility;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

public class APAccessibilityNodeInfoCompatJellyBean
{
  public static void addChild(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).addChild(paramView, paramInt);
  }
  
  public static Object findFocus(Object paramObject, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).findFocus(paramInt);
  }
  
  public static Object focusSearch(Object paramObject, int paramInt)
  {
    return ((AccessibilityNodeInfo)paramObject).focusSearch(paramInt);
  }
  
  public static int getMovementGranularities(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getMovementGranularities();
  }
  
  public static boolean isAccessibilityFocused(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isAccessibilityFocused();
  }
  
  public static boolean isVisibleToUser(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isVisibleToUser();
  }
  
  public static Object obtain(View paramView, int paramInt)
  {
    return AccessibilityNodeInfo.obtain(paramView, paramInt);
  }
  
  public static boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
  {
    return ((AccessibilityNodeInfo)paramObject).performAction(paramInt, paramBundle);
  }
  
  public static void setAccesibilityFocused(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setAccessibilityFocused(paramBoolean);
  }
  
  public static void setMovementGranularities(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setMovementGranularities(paramInt);
  }
  
  public static void setParent(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setParent(paramView, paramInt);
  }
  
  public static void setSource(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).setSource(paramView, paramInt);
  }
  
  public static void setVisibleToUser(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setVisibleToUser(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.accessibility.APAccessibilityNodeInfoCompatJellyBean
 * JD-Core Version:    0.7.0.1
 */