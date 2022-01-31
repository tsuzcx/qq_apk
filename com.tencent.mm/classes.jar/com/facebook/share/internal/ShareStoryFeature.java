package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShareStoryFeature
  implements DialogFeature
{
  private int minVersion;
  
  static
  {
    AppMethodBeat.i(97310);
    SHARE_STORY_ASSET = new ShareStoryFeature("SHARE_STORY_ASSET", 0, 20170417);
    $VALUES = new ShareStoryFeature[] { SHARE_STORY_ASSET };
    AppMethodBeat.o(97310);
  }
  
  private ShareStoryFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public final String getAction()
  {
    return "com.facebook.platform.action.request.SHARE_STORY";
  }
  
  public final int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.ShareStoryFeature
 * JD-Core Version:    0.7.0.1
 */