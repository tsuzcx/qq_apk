package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.e.a;

final class MediaBrowserServiceCompat$d$1
  implements Runnable
{
  MediaBrowserServiceCompat$d$1(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame, String paramString, Bundle paramBundle, int paramInt) {}
  
  public final void run()
  {
    IBinder localIBinder = this.Ck.asBinder();
    this.Co.BY.BS.remove(localIBinder);
    MediaBrowserServiceCompat.b localb = new MediaBrowserServiceCompat.b(this.Co.BY);
    localb.Ca = this.Cl;
    localb.Cb = this.Cm;
    localb.Cc = this.Ck;
    localb.Cd = this.Co.BY.db();
    if (localb.Cd == null) {
      new StringBuilder("No root for client ").append(this.Cl).append(" from service ").append(getClass().getName());
    }
    for (;;)
    {
      try
      {
        this.Ck.dg();
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.Cl);
        return;
      }
      try
      {
        this.Co.BY.BS.put(localRemoteException1, localb);
        localRemoteException1.linkToDeath(localb, 0);
        if (this.Co.BY.BV != null)
        {
          this.Ck.a(localb.Cd.BG, this.Co.BY.BV, localb.Cd.mExtras);
          return;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.Cl);
        this.Co.BY.BS.remove(localRemoteException1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.1
 * JD-Core Version:    0.7.0.1
 */