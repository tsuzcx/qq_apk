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
      new StringBuilder("MediaServiceConnection.onServiceConnected name=").append(this.val$name).append(" binder=").append(this.BI);
      this.BJ.BH.dump();
    }
    if (!this.BJ.M("onServiceConnected")) {}
    do
    {
      return;
      this.BJ.BH.BA = new MediaBrowserCompat.j(this.BI, this.BJ.BH.Bw);
      this.BJ.BH.BB = new Messenger(this.BJ.BH.Bx);
      this.BJ.BH.Bx.a(this.BJ.BH.BB);
      this.BJ.BH.mState = 2;
      try
      {
        if (MediaBrowserCompat.DEBUG) {
          this.BJ.BH.dump();
        }
        MediaBrowserCompat.j localj = this.BJ.BH.BA;
        Context localContext = this.BJ.BH.mContext;
        Messenger localMessenger = this.BJ.BH.BB;
        Bundle localBundle = new Bundle();
        localBundle.putString("data_package_name", localContext.getPackageName());
        localBundle.putBundle("data_root_hints", localj.Bw);
        localj.a(1, localBundle, localMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        new StringBuilder("RemoteException during connect for ").append(this.BJ.BH.BD);
      }
    } while (!MediaBrowserCompat.DEBUG);
    this.BJ.BH.dump();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h.a.1
 * JD-Core Version:    0.7.0.1
 */