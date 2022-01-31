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
      new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(this.val$name).append(" this=").append(this).append(" mServiceConnection=").append(this.AX.AV.AT);
      this.AX.AV.dump();
    }
    if (!this.AX.L("onServiceDisconnected")) {
      return;
    }
    this.AX.AV.AO = null;
    this.AX.AV.AP = null;
    this.AX.AV.AL.a(null);
    this.AX.AV.mState = 4;
    this.AX.AV.AS.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h.a.2
 * JD-Core Version:    0.7.0.1
 */