package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.f.a;

final class MediaBrowserServiceCompat$d$1
  implements Runnable
{
  MediaBrowserServiceCompat$d$1(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame, String paramString, Bundle paramBundle, int paramInt) {}
  
  public final void run()
  {
    IBinder localIBinder = this.By.asBinder();
    this.BC.Bm.Bg.remove(localIBinder);
    MediaBrowserServiceCompat.b localb = new MediaBrowserServiceCompat.b(this.BC.Bm);
    localb.Bo = this.Bz;
    localb.Bp = this.BA;
    localb.Bq = this.By;
    localb.Br = this.BC.Bm.cy();
    if (localb.Br == null) {
      new StringBuilder("No root for client ").append(this.Bz).append(" from service ").append(getClass().getName());
    }
    for (;;)
    {
      try
      {
        this.By.cD();
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.Bz);
        return;
      }
      try
      {
        this.BC.Bm.Bg.put(localRemoteException1, localb);
        localRemoteException1.linkToDeath(localb, 0);
        if (this.BC.Bm.Bj != null)
        {
          this.By.a(localb.Br.AU, this.BC.Bm.Bj, localb.Br.mExtras);
          return;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.Bz);
        this.BC.Bm.Bg.remove(localRemoteException1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.1
 * JD-Core Version:    0.7.0.1
 */