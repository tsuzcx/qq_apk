package com.tencent.biz.lebsearch.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SearchViewBuilder
{
  public static final String KEY_ACTIVE_SEARCH_IMG_RUL = "pic_url";
  public static final String KEY_ACTIVE_SEARCH_ITEM_NAME = "name";
  public static final String KEY_ACTIVE_SEARCH_KEY = "keyword";
  public static final String KEY_CLICKABLE = "clickable";
  public static final String KEY_SEARCH_ITEM_JUMP_URL = "jump_url";
  public static final int VIEW_TYPE_APP = 1;
  public static final int VIEW_TYPE_COUPON = 4;
  public static final int VIEW_TYPE_MOVIE = 16;
  public static final int VIEW_TYPE_READ = 8;
  public static final int VIEW_TYPE_SHOPPING = 2;
  public static final int VIEW_TYPE_TRIBAR = 32;
  
  public static SpannableString getHighLightText(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 == null) {
      return new SpannableString(paramString1);
    }
    int i = paramString1.indexOf(paramString2);
    if (i != -1)
    {
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), i, paramString2.length() + i, 34);
      return paramString1;
    }
    return new SpannableString(paramString1);
  }
  
  public static View getView(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 16: 
      return new MovieView(paramContext);
    case 1: 
      return new AppView(paramContext);
    case 4: 
      return new CouponView(paramContext);
    case 8: 
      return new BookView(paramContext);
    case 2: 
      return new ShoppingView(paramContext);
    }
    return new TriBarView(paramContext);
  }
  
  public static void setStars(LinearLayout paramLinearLayout, double paramDouble)
  {
    int j;
    int i;
    if ((paramDouble <= paramLinearLayout.getChildCount()) && (paramDouble >= 0.0D))
    {
      j = (int)paramDouble;
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        if (paramDouble * 10.0D % 10.0D != 0.0D) {
          ((ImageView)paramLinearLayout.getChildAt(i)).setImageResource(2130837505);
        }
        return;
      }
      ((ImageView)paramLinearLayout.getChildAt(i)).setImageResource(2130837507);
      i += 1;
    }
  }
  
  public static void version() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.widget.SearchViewBuilder
 * JD-Core Version:    0.7.0.1
 */