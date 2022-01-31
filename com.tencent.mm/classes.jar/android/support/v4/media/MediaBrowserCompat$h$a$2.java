package android.support.v4.media;

import android.content.ComponentName;

final class MediaBrowserCompat$h$a$2
  implements Runnable
{
  MediaBrowserCompat$h$a$2(MediaBrowserCompat.h.a parama, ComponentName paramComponentName) {}
  
  public final void run()
  {
    if (MediaBrowserCompat.DEBUG)
    {
      new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(this.val$name).append(" this=").append(this).append(" mServiceConnection=").append(this.BJ.BH.BF);
      this.BJ.BH.dump();
    }
    if (!this.BJ.M("onServiceDisconnected")) {
      return;
    }
    this.BJ.BH.BA = null;
    this.BJ.BH.BB = null;
    this.BJ.BH.Bx.a(null);
    this.BJ.BH.mState = 4;
    this.BJ.BH.BE.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h.a.2
 * JD-Core Version:    0.7.0.1
 */