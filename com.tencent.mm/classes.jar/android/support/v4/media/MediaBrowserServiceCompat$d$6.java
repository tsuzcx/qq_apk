package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.e.a;

final class MediaBrowserServiceCompat$d$6
  implements Runnable
{
  MediaBrowserServiceCompat$d$6(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame, Bundle paramBundle) {}
  
  public final void run()
  {
    IBinder localIBinder = this.Ck.asBinder();
    this.Co.BY.BS.remove(localIBinder);
    MediaBrowserServiceCompat.b localb = new MediaBrowserServiceCompat.b(this.Co.BY);
    localb.Cc = this.Ck;
    localb.Cb = this.Cm;
    this.Co.BY.BS.put(localIBinder, localb);
    try
    {
      localIBinder.linkToDeath(localb, 0);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.6
 * JD-Core Version:    0.7.0.1
 */