package com.tencent.mm.flutter.plugins.platform_video_player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;

public class DefaultFlutterPlatformVideoView
  extends VideoView
{
  public DefaultFlutterPlatformVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DefaultFlutterPlatformVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View getView()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.flutter.plugins.platform_video_player.DefaultFlutterPlatformVideoView
 * JD-Core Version:    0.7.0.1
 */