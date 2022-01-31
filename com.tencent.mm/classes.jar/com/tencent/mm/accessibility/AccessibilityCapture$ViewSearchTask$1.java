package com.tencent.mm.accessibility;

import android.view.View;
import java.lang.reflect.Field;

class AccessibilityCapture$ViewSearchTask$1
  implements ViewSearchTool.Matcher
{
  AccessibilityCapture$ViewSearchTask$1(AccessibilityCapture.ViewSearchTask paramViewSearchTask, int paramInt) {}
  
  public boolean match(View paramView)
  {
    try
    {
      int i = ((Integer)AccessibilityCapture.access$900().get(paramView)).intValue();
      int j = this.val$id;
      return i == j;
    }
    catch (IllegalAccessException paramView) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture.ViewSearchTask.1
 * JD-Core Version:    0.7.0.1
 */