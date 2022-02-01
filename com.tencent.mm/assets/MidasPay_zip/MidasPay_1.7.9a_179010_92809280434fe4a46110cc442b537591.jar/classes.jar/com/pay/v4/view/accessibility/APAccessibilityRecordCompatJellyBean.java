package com.pay.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

public class APAccessibilityRecordCompatJellyBean
{
  public static void setSource(Object paramObject, View paramView, int paramInt)
  {
    ((AccessibilityRecord)paramObject).setSource(paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.accessibility.APAccessibilityRecordCompatJellyBean
 * JD-Core Version:    0.7.0.1
 */