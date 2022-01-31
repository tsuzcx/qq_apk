package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShareDialogFeature
  implements DialogFeature
{
  private int minVersion;
  
  static
  {
    AppMethodBeat.i(97242);
    SHARE_DIALOG = new ShareDialogFeature("SHARE_DIALOG", 0, 20130618);
    PHOTOS = new ShareDialogFeature("PHOTOS", 1, 20140204);
    VIDEO = new ShareDialogFeature("VIDEO", 2, 20141028);
    MULTIMEDIA = new ShareDialogFeature("MULTIMEDIA", 3, 20160327);
    HASHTAG = new ShareDialogFeature("HASHTAG", 4, 20160327);
    LINK_SHARE_QUOTES = new ShareDialogFeature("LINK_SHARE_QUOTES", 5, 20160327);
    $VALUES = new ShareDialogFeature[] { SHARE_DIALOG, PHOTOS, VIDEO, MULTIMEDIA, HASHTAG, LINK_SHARE_QUOTES };
    AppMethodBeat.o(97242);
  }
  
  private ShareDialogFeature(int paramInt)
  {
    this.minVersion = paramInt;
  }
  
  public final String getAction()
  {
    return "com.facebook.platform.action.request.FEED_DIALOG";
  }
  
  public final int getMinVersion()
  {
    return this.minVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.internal.ShareDialogFeature
 * JD-Core Version:    0.7.0.1
 */