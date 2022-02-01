package com.weiyun.sdk.util;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.weiyun.sdk.IWyFileSystem.ThumbnailType;

public class ThumbnailUtils
{
  private static final String THUMBNAIL_NAME_LARGE = "large";
  private static final String THUMBNAIL_NAME_MICRO = "micro";
  private static final String THUMBNAIL_NAME_MIDDLE = "middle";
  private static final String THUMBNAIL_NAME_MINI = "mini";
  private static final String THUMBNAIL_NAME_SCREEN = "screen";
  private static final String THUMBNAIL_NAME_SMALL = "small";
  private static final String THUMBNAIL_NAME_XLARGE = "xlarge";
  private static final String THUMBNAIL_SPEC_LARGE = "320*320";
  private static final String THUMBNAIL_SPEC_MICRO = "16*16";
  private static final String THUMBNAIL_SPEC_MIDDLE = "128*128";
  private static final String THUMBNAIL_SPEC_MINI = "32*32";
  private static final String THUMBNAIL_SPEC_SCREEN = "1024*10240";
  private static final String THUMBNAIL_SPEC_SMALL = "64*64";
  private static final String THUMBNAIL_SPEC_XLARGE = "640*640";
  
  public static String getScreenThumbnailSpec(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      paramContext.getSize(localPoint);
      return localPoint.x + "*" + localPoint.y;
    }
    return paramContext.getWidth() + "*" + paramContext.getHeight();
  }
  
  public static String getThumbnailName(IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    switch (1.$SwitchMap$com$weiyun$sdk$IWyFileSystem$ThumbnailType[paramThumbnailType.ordinal()])
    {
    default: 
      return "small";
    case 1: 
      return "micro";
    case 2: 
      return "mini";
    case 3: 
      return "small";
    case 4: 
      return "middle";
    case 5: 
      return "large";
    case 6: 
      return "xlarge";
    }
    return "screen";
  }
  
  public static String getThumbnailSpec(IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    switch (1.$SwitchMap$com$weiyun$sdk$IWyFileSystem$ThumbnailType[paramThumbnailType.ordinal()])
    {
    default: 
      return "64*64";
    case 1: 
      return "16*16";
    case 2: 
      return "32*32";
    case 3: 
      return "64*64";
    case 4: 
      return "128*128";
    case 5: 
      return "320*320";
    case 6: 
      return "640*640";
    }
    return "1024*10240";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.ThumbnailUtils
 * JD-Core Version:    0.7.0.1
 */