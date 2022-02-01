package com.tencent.biz.pubaccount;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import cjh;

public class publicAccountText
{
  public static void a(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.getViewTreeObserver().addOnGlobalLayoutListener(new cjh(paramTextView, paramString, 1));
  }
  
  public static void a(TextView paramTextView, String paramString, int paramInt)
  {
    paramTextView.setText(paramString);
    paramTextView.getViewTreeObserver().addOnGlobalLayoutListener(new cjh(paramTextView, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.publicAccountText
 * JD-Core Version:    0.7.0.1
 */