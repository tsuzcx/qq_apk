package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.e;
import android.support.v4.f.a;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.b;
import android.support.v4.media.session.b.a;

class MediaBrowserCompat$e
  implements MediaBrowserCompat.b.a, MediaBrowserCompat.d, MediaBrowserCompat.i
{
  protected final Object AJ;
  protected final Bundle AK;
  protected final MediaBrowserCompat.a AL = new MediaBrowserCompat.a(this);
  private final a<String, MediaBrowserCompat.k> AM = new a();
  protected int AN;
  protected MediaBrowserCompat.j AO;
  protected Messenger AP;
  private MediaSessionCompat.Token AQ;
  final Context mContext;
  
  MediaBrowserCompat$e(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
  {
    this.mContext = paramContext;
    Bundle localBundle = new Bundle();
    localBundle.putInt("extra_client_version", 1);
    this.AK = new Bundle(localBundle);
    paramb.AG = this;
    paramb = paramb.AF;
    localBundle = this.AK;
    this.AJ = new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramb, localBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, Bundle paramBundle)
  {
    if (this.AP != paramMessenger) {
      return;
    }
    paramMessenger = (MediaBrowserCompat.k)this.AM.get(paramString);
    if (paramMessenger == null)
    {
      boolean bool = MediaBrowserCompat.DEBUG;
      return;
    }
    paramMessenger.c(this.mContext, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
  
  public final void b(Messenger paramMessenger) {}
  
  public final void connect()
  {
    ((MediaBrowser)this.AJ).connect();
  }
  
  public final MediaSessionCompat.Token cw()
  {
    if (this.AQ == null) {
      this.AQ = MediaSessionCompat.Token.x(((MediaBrowser)this.AJ).getSessionToken());
    }
    return this.AQ;
  }
  
  public final void disconnect()
  {
    if ((this.AO != null) && (this.AP != null)) {}
    try
    {
      this.AO.a(7, null, this.AP);
      label28:
      ((MediaBrowser)this.AJ).disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label28;
    }
  }
  
  public final void onConnected()
  {
    Object localObject1 = ((MediaBrowser)this.AJ).getExtras();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      this.AN = ((Bundle)localObject1).getInt("extra_service_version", 0);
      Object localObject2 = e.c((Bundle)localObject1, "extra_messenger");
      if (localObject2 != null)
      {
        this.AO = new MediaBrowserCompat.j((IBinder)localObject2, this.AK);
        this.AP = new Messenger(this.AL);
        this.AL.a(this.AP);
      }
      try
      {
        localObject2 = this.AO;
        Messenger localMessenger = this.AP;
        Bundle localBundle = new Bundle();
        localBundle.putBundle("data_root_hints", ((MediaBrowserCompat.j)localObject2).AK);
        ((MediaBrowserCompat.j)localObject2).a(6, localBundle, localMessenger);
        label119:
        localObject1 = b.a.c(e.c((Bundle)localObject1, "extra_session_binder"));
        if (localObject1 == null) {
          continue;
        }
        this.AQ = MediaSessionCompat.Token.a(((MediaBrowser)this.AJ).getSessionToken(), (b)localObject1);
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
    this.AO = null;
    this.AP = null;
    this.AQ = null;
    this.AL.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.e
 * JD-Core Version:    0.7.0.1
 */