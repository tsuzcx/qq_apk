package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;

final class MediaBrowserCompat$h$a$1
  implements Runnable
{
  MediaBrowserCompat$h$a$1(MediaBrowserCompat.h.a parama, ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void run()
  {
    if (MediaBrowserCompat.DEBUG)
    {
      new StringBuilder("MediaServiceConnection.onServiceConnected name=").append(this.val$name).append(" binder=").append(this.AW);
      this.AX.AV.dump();
    }
    if (!this.AX.L("onServiceConnected")) {}
    do
    {
      return;
      this.AX.AV.AO = new MediaBrowserCompat.j(this.AW, this.AX.AV.AK);
      this.AX.AV.AP = new Messenger(this.AX.AV.AL);
      this.AX.AV.AL.a(this.AX.AV.AP);
      this.AX.AV.mState = 2;
      try
      {
        if (MediaBrowserCompat.DEBUG) {
          this.AX.AV.dump();
        }
        MediaBrowserCompat.j localj = this.AX.AV.AO;
        Context localContext = this.AX.AV.mContext;
        Messenger localMessenger = this.AX.AV.AP;
        Bundle localBundle = new Bundle();
        localBundle.putString("data_package_name", localContext.getPackageName());
        localBundle.putBundle("data_root_hints", localj.AK);
        localj.a(1, localBundle, localMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        new StringBuilder("RemoteException during connect for ").append(this.AX.AV.AR);
      }
    } while (!MediaBrowserCompat.DEBUG);
    this.AX.AV.dump();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h.a.1
 * JD-Core Version:    0.7.0.1
 */