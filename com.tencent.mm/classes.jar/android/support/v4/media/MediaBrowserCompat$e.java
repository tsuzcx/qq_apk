package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.c;
import android.support.v4.e.a;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.b;
import android.support.v4.media.session.b.a;

class MediaBrowserCompat$e
  implements MediaBrowserCompat.b.a, MediaBrowserCompat.d, MediaBrowserCompat.i
{
  protected MediaBrowserCompat.j BA;
  protected Messenger BB;
  private MediaSessionCompat.Token BC;
  protected final Object Bv;
  protected final Bundle Bw;
  protected final MediaBrowserCompat.a Bx = new MediaBrowserCompat.a(this);
  private final a<String, MediaBrowserCompat.k> By = new a();
  protected int Bz;
  final Context mContext;
  
  MediaBrowserCompat$e(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
  {
    this.mContext = paramContext;
    Bundle localBundle = new Bundle();
    localBundle.putInt("extra_client_version", 1);
    this.Bw = new Bundle(localBundle);
    paramb.Bs = this;
    paramb = paramb.Br;
    localBundle = this.Bw;
    this.Bv = new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramb, localBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, Bundle paramBundle)
  {
    if (this.BB != paramMessenger) {
      return;
    }
    paramMessenger = (MediaBrowserCompat.k)this.By.get(paramString);
    if (paramMessenger == null)
    {
      boolean bool = MediaBrowserCompat.DEBUG;
      return;
    }
    paramMessenger.d(this.mContext, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
  
  public final void b(Messenger paramMessenger) {}
  
  public final MediaSessionCompat.Token cZ()
  {
    if (this.BC == null) {
      this.BC = MediaSessionCompat.Token.x(((MediaBrowser)this.Bv).getSessionToken());
    }
    return this.BC;
  }
  
  public final void connect()
  {
    ((MediaBrowser)this.Bv).connect();
  }
  
  public final void disconnect()
  {
    if ((this.BA != null) && (this.BB != null)) {}
    try
    {
      this.BA.a(7, null, this.BB);
      label28:
      ((MediaBrowser)this.Bv).disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label28;
    }
  }
  
  public final void onConnected()
  {
    Object localObject1 = ((MediaBrowser)this.Bv).getExtras();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      this.Bz = ((Bundle)localObject1).getInt("extra_service_version", 0);
      Object localObject2 = c.c((Bundle)localObject1, "extra_messenger");
      if (localObject2 != null)
      {
        this.BA = new MediaBrowserCompat.j((IBinder)localObject2, this.Bw);
        this.BB = new Messenger(this.Bx);
        this.Bx.a(this.BB);
      }
      try
      {
        localObject2 = this.BA;
        Messenger localMessenger = this.BB;
        Bundle localBundle = new Bundle();
        localBundle.putBundle("data_root_hints", ((MediaBrowserCompat.j)localObject2).Bw);
        ((MediaBrowserCompat.j)localObject2).a(6, localBundle, localMessenger);
        label119:
        localObject1 = b.a.d(c.c((Bundle)localObject1, "extra_session_binder"));
        if (localObject1 == null) {
          continue;
        }
        this.BC = MediaSessionCompat.Token.a(((MediaBrowser)this.Bv).getSessionToken(), (b)localObject1);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        break label119;
      }
    }
  }
  
  public final void onConnectionSuspended()
  {
    this.BA = null;
    this.BB = null;
    this.BC = null;
    this.Bx.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.e
 * JD-Core Version:    0.7.0.1
 */