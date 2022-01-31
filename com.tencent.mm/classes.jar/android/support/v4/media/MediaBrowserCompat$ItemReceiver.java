package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$ItemReceiver
  extends ResultReceiver
{
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
    }
    if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("media_item"))) {
      return;
    }
    paramBundle.getParcelable("media_item");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.ItemReceiver
 * JD-Core Version:    0.7.0.1
 */