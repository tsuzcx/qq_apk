package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class MediaInfo
{
  public static final int ITEM_TYPE_AUDIO = 2;
  public static final int ITEM_TYPE_MUSIC = 1;
  public static final int ITEM_TYPE_NONE = 0;
  public static final int ITEM_TYPE_PIC = 4;
  public static final int ITEM_TYPE_VIDEO = 3;
  protected static final String TAG = "publish_mediaInfo";
  
  public abstract String getJsonText();
  
  public abstract View getView(Context paramContext, View.OnClickListener paramOnClickListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.MediaInfo
 * JD-Core Version:    0.7.0.1
 */