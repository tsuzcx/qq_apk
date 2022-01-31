package android.support.v4.media;

import android.content.Context;
import android.content.Intent;

final class MediaBrowserCompat$h$1
  implements Runnable
{
  MediaBrowserCompat$h$1(MediaBrowserCompat.h paramh) {}
  
  public final void run()
  {
    if (this.BH.mState == 0) {}
    do
    {
      return;
      this.BH.mState = 2;
      if ((MediaBrowserCompat.DEBUG) && (this.BH.BF != null)) {
        throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.BH.BF);
      }
      if (this.BH.BA != null) {
        throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.BH.BA);
      }
      if (this.BH.BB != null) {
        throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.BH.BB);
      }
      Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
      localIntent.setComponent(this.BH.BD);
      this.BH.BF = new MediaBrowserCompat.h.a(this.BH);
      int i = 0;
      try
      {
        boolean bool = this.BH.mContext.bindService(localIntent, this.BH.BF, 1);
        i = bool;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          new StringBuilder("Failed binding to service ").append(this.BH.BD);
        }
      }
      if (i == 0)
      {
        this.BH.da();
        this.BH.BE.onConnectionFailed();
      }
    } while (!MediaBrowserCompat.DEBUG);
    this.BH.dump();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h.1
 * JD-Core Version:    0.7.0.1
 */