package com.tencent.map.lib.models;

import android.graphics.Rect;

public abstract class AccessibleTouchItem
  implements Comparable<AccessibleTouchItem>
{
  public static final String MAP_DEFAULT_CONTENT_DESCRIPTION = "地图";
  public static final int MIN_TOUCH_RADIUS = 20;
  public static final String MY_LOCATION_PREFIX = "我的位置";
  
  public int compareTo(AccessibleTouchItem paramAccessibleTouchItem)
  {
    Rect localRect = getBounds();
    paramAccessibleTouchItem = paramAccessibleTouchItem.getBounds();
    if (localRect.top != paramAccessibleTouchItem.top) {
      return localRect.top - paramAccessibleTouchItem.top;
    }
    return localRect.left - paramAccessibleTouchItem.left;
  }
  
  public abstract Rect getBounds();
  
  public abstract String getContentDescription();
  
  public abstract void onClick();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.models.AccessibleTouchItem
 * JD-Core Version:    0.7.0.1
 */