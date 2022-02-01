package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$CustomActionResultReceiver
  extends ResultReceiver
{
  private final MediaBrowserCompat.c HY;
  private final Bundle mExtras;
  
  public final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.HY == null) {
      return;
    }
    MediaSessionCompat.d(paramBundle);
    switch (paramInt)
    {
    }
    new StringBuilder("Unknown result code: ").append(paramInt).append(" (extras=").append(this.mExtras).append(", resultData=").append(paramBundle).append(")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.CustomActionResultReceiver
 * JD-Core Version:    0.7.0.1
 */