package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$ItemReceiver
  extends ResultReceiver
{
  public final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    MediaSessionCompat.d(paramBundle);
    if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("media_item"))) {
      return;
    }
    paramBundle.getParcelable("media_item");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.ItemReceiver
 * JD-Core Version:    0.7.0.1
 */