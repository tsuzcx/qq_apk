package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.c;
import android.support.v4.e.a;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class MediaBrowserCompat$h
  implements MediaBrowserCompat.d, MediaBrowserCompat.i
{
  MediaBrowserCompat.j BA;
  Messenger BB;
  private MediaSessionCompat.Token BC;
  final ComponentName BD;
  final MediaBrowserCompat.b BE;
  MediaBrowserCompat.h.a BF;
  private String BG;
  final Bundle Bw;
  final MediaBrowserCompat.a Bx = new MediaBrowserCompat.a(this);
  private final a<String, MediaBrowserCompat.k> By = new a();
  final Context mContext;
  private Bundle mExtras;
  int mState = 1;
  
  public MediaBrowserCompat$h(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context must not be null");
    }
    if (paramComponentName == null) {
      throw new IllegalArgumentException("service component must not be null");
    }
    if (paramb == null) {
      throw new IllegalArgumentException("connection callback must not be null");
    }
    this.mContext = paramContext;
    this.BD = paramComponentName;
    this.BE = paramb;
    this.Bw = null;
  }
  
  private boolean a(Messenger paramMessenger, String paramString)
  {
    boolean bool = true;
    if ((this.BB != paramMessenger) || (this.mState == 0) || (this.mState == 1))
    {
      if ((this.mState != 0) && (this.mState != 1)) {
        new StringBuilder().append(paramString).append(" for ").append(this.BD).append(" with mCallbacksMessenger=").append(this.BB).append(" this=").append(this);
      }
      bool = false;
    }
    return bool;
  }
  
  private static String ah(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN/".concat(String.valueOf(paramInt));
    case 0: 
      return "CONNECT_STATE_DISCONNECTING";
    case 1: 
      return "CONNECT_STATE_DISCONNECTED";
    case 2: 
      return "CONNECT_STATE_CONNECTING";
    case 3: 
      return "CONNECT_STATE_CONNECTED";
    }
    return "CONNECT_STATE_SUSPENDED";
  }
  
  public final void a(Messenger paramMessenger, String paramString, Bundle paramBundle)
  {
    if (!a(paramMessenger, "onLoadChildren")) {
      return;
    }
    if (MediaBrowserCompat.DEBUG) {
      new StringBuilder("onLoadChildren for ").append(this.BD).append(" id=").append(paramString);
    }
    paramMessenger = (MediaBrowserCompat.k)this.By.get(paramString);
    if (paramMessenger == null)
    {
      boolean bool = MediaBrowserCompat.DEBUG;
      return;
    }
    paramMessenger.d(this.mContext, paramBundle);
  }
  
  public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
  {
    if (!a(paramMessenger, "onConnect")) {}
    for (;;)
    {
      return;
      if (this.mState != 2)
      {
        new StringBuilder("onConnect from service while mState=").append(ah(this.mState)).append("... ignoring");
        return;
      }
      this.BG = paramString;
      this.BC = paramToken;
      this.mExtras = paramBundle;
      this.mState = 3;
      if (MediaBrowserCompat.DEBUG) {
        dump();
      }
      this.BE.onConnected();
      try
      {
        paramMessenger = this.By.entrySet().iterator();
        while (paramMessenger.hasNext())
        {
          paramToken = (Map.Entry)paramMessenger.next();
          paramString = (String)paramToken.getKey();
          paramBundle = (MediaBrowserCompat.k)paramToken.getValue();
          paramToken = paramBundle.fT;
          paramBundle = paramBundle.BM;
          int i = 0;
          while (i < paramToken.size())
          {
            MediaBrowserCompat.j localj = this.BA;
            IBinder localIBinder = ((MediaBrowserCompat.l)paramToken.get(i)).va;
            Bundle localBundle1 = (Bundle)paramBundle.get(i);
            Messenger localMessenger = this.BB;
            Bundle localBundle2 = new Bundle();
            localBundle2.putString("data_media_item_id", paramString);
            c.a(localBundle2, "data_callback_token", localIBinder);
            localBundle2.putBundle("data_options", localBundle1);
            localj.a(3, localBundle2, localMessenger);
            i += 1;
          }
        }
        return;
      }
      catch (RemoteException paramMessenger) {}
    }
  }
  
  public final void b(Messenger paramMessenger)
  {
    new StringBuilder("onConnectFailed for ").append(this.BD);
    if (!a(paramMessenger, "onConnectFailed")) {
      return;
    }
    if (this.mState != 2)
    {
      new StringBuilder("onConnect from service while mState=").append(ah(this.mState)).append("... ignoring");
      return;
    }
    da();
    this.BE.onConnectionFailed();
  }
  
  public final MediaSessionCompat.Token cZ()
  {
    if (this.mState == 3) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
    }
    return this.BC;
  }
  
  public final void connect()
  {
    if ((this.mState != 0) && (this.mState != 1)) {
      throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + ah(this.mState) + ")");
    }
    this.mState = 2;
    this.Bx.post(new MediaBrowserCompat.h.1(this));
  }
  
  final void da()
  {
    if (this.BF != null) {
      this.mContext.unbindService(this.BF);
    }
    this.mState = 1;
    this.BF = null;
    this.BA = null;
    this.BB = null;
    this.Bx.a(null);
    this.BG = null;
    this.BC = null;
  }
  
  public final void disconnect()
  {
    this.mState = 0;
    this.Bx.post(new Runnable()
    {
      public final void run()
      {
        if (MediaBrowserCompat.h.this.BB != null) {}
        try
        {
          MediaBrowserCompat.h.this.BA.a(2, null, MediaBrowserCompat.h.this.BB);
          int i = MediaBrowserCompat.h.this.mState;
          MediaBrowserCompat.h.this.da();
          if (i != 0) {
            MediaBrowserCompat.h.this.mState = i;
          }
          if (MediaBrowserCompat.DEBUG) {
            MediaBrowserCompat.h.this.dump();
          }
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.BD);
          }
        }
      }
    });
  }
  
  final void dump()
  {
    new StringBuilder("  mServiceComponent=").append(this.BD);
    new StringBuilder("  mCallback=").append(this.BE);
    new StringBuilder("  mRootHints=").append(this.Bw);
    new StringBuilder("  mState=").append(ah(this.mState));
    new StringBuilder("  mServiceConnection=").append(this.BF);
    new StringBuilder("  mServiceBinderWrapper=").append(this.BA);
    new StringBuilder("  mCallbacksMessenger=").append(this.BB);
    new StringBuilder("  mRootId=").append(this.BG);
    new StringBuilder("  mMediaSessionToken=").append(this.BC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h
 * JD-Core Version:    0.7.0.1
 */