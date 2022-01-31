package android.support.v4.media;

import android.os.RemoteException;

final class MediaBrowserCompat$h$2
  implements Runnable
{
  MediaBrowserCompat$h$2(MediaBrowserCompat.h paramh) {}
  
  public final void run()
  {
    if (this.AV.AP != null) {}
    try
    {
      this.AV.AO.a(2, null, this.AV.AP);
      int i = this.AV.mState;
      this.AV.cx();
      if (i != 0) {
        this.AV.mState = i;
      }
      if (MediaBrowserCompat.DEBUG) {
        this.AV.dump();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        new StringBuilder("RemoteException during connect for ").append(this.AV.AR);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h.2
 * JD-Core Version:    0.7.0.1
 */