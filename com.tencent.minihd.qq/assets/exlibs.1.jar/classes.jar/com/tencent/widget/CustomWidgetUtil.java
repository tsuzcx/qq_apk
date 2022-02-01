package com.tencent.widget;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;

public class CustomWidgetUtil
{
  public static final int a = 99;
  public static final int b = 99;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramTextView, paramInt1, paramInt2, paramInt3, 99, null);
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      paramString = "";
      paramInt2 = 0;
      paramInt1 = 0;
    }
    while ((TextUtils.isEmpty(paramString)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramTextView.setVisibility(8);
      return;
      if (paramInt3 > 0)
      {
        paramString = "";
        paramInt1 = paramInt3;
        paramInt2 = 0;
      }
      else
      {
        paramString = "";
        paramInt1 = 2130841952;
        paramInt2 = 0;
        continue;
        if (paramInt3 > 0) {}
        for (paramInt2 = paramInt3;; paramInt2 = 2130841956)
        {
          paramString = "NEW";
          paramInt1 = 0;
          break;
        }
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= paramInt4) {
            break label167;
          }
          paramString = String.valueOf(paramInt4) + "+";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130841956;
        }
        label167:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        continue;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= 99) {
            break label207;
          }
          paramString = "";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130841956;
        }
        label207:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        continue;
        if (paramInt3 > 0) {}
        for (paramInt2 = paramInt3;; paramInt2 = 2130841956)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label249;
          }
          paramString = "";
          paramInt1 = 0;
          break;
        }
        label249:
        paramInt1 = 0;
      }
    }
    Object localObject = paramTextView.getTag(2131301984);
    if (((localObject == null) && (paramInt1 == 0)) || (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == paramInt1))) {}
    for (;;)
    {
      paramTextView.setBackgroundResource(paramInt2);
      if (!Utils.a(paramTextView.getText().toString(), paramString))
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        paramTextView.setText(paramString);
      }
      paramTextView.setVisibility(0);
      return;
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, 0, 0, 0);
      paramTextView.setTag(2131301984, Integer.valueOf(paramInt1));
      paramTextView.setText(paramString);
      paramTextView.setPadding(0, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.CustomWidgetUtil
 * JD-Core Version:    0.7.0.1
 */