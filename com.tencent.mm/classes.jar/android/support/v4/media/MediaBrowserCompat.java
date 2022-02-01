package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.e.a;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class MediaBrowserCompat
{
  static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
  public final d KQ;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.KQ = new g(paramContext, paramComponentName, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.KQ = new f(paramContext, paramComponentName, paramb, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.KQ = new e(paramContext, paramComponentName, paramb, null);
      return;
    }
    this.KQ = new h(paramContext, paramComponentName, paramb);
  }
  
  public final void disconnect()
  {
    this.KQ.disconnect();
  }
  
  static class CustomActionResultReceiver
    extends ResultReceiver
  {
    private final MediaBrowserCompat.c KW;
    private final Bundle mExtras;
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (this.KW == null) {
        return;
      }
      MediaSessionCompat.d(paramBundle);
      switch (paramInt)
      {
      }
      new StringBuilder("Unknown result code: ").append(paramInt).append(" (extras=").append(this.mExtras).append(", resultData=").append(paramBundle).append(")");
    }
  }
  
  static class ItemReceiver
    extends ResultReceiver
  {
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      MediaSessionCompat.d(paramBundle);
      if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("media_item"))) {
        return;
      }
      paramBundle.getParcelable("media_item");
    }
  }
  
  static class SearchResultReceiver
    extends ResultReceiver
  {
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      MediaSessionCompat.d(paramBundle);
      if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("search_results"))) {}
      for (;;)
      {
        return;
        paramBundle = paramBundle.getParcelableArray("search_results");
        if (paramBundle != null)
        {
          ArrayList localArrayList = new ArrayList();
          int i = paramBundle.length;
          paramInt = 0;
          while (paramInt < i)
          {
            localArrayList.add((MediaBrowserCompat.MediaItem)paramBundle[paramInt]);
            paramInt += 1;
          }
        }
      }
    }
  }
  
  static final class a
    extends Handler
  {
    private final WeakReference<MediaBrowserCompat.i> KR;
    private WeakReference<Messenger> KS;
    
    a(MediaBrowserCompat.i parami)
    {
      this.KR = new WeakReference(parami);
    }
    
    final void a(Messenger paramMessenger)
    {
      this.KS = new WeakReference(paramMessenger);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if ((this.KS == null) || (this.KS.get() == null) || (this.KR.get() == null)) {
        return;
      }
      Bundle localBundle1 = paramMessage.getData();
      MediaSessionCompat.d(localBundle1);
      MediaBrowserCompat.i locali = (MediaBrowserCompat.i)this.KR.get();
      Messenger localMessenger = (Messenger)this.KS.get();
      for (;;)
      {
        try
        {
          switch (paramMessage.what)
          {
          case 1: 
            new StringBuilder("Unhandled message: ").append(paramMessage).append("\n  Client version: 1\n  Service version: ").append(paramMessage.arg1);
            return;
          }
        }
        catch (BadParcelableException localBadParcelableException) {}
        if (paramMessage.what != 1) {
          break;
        }
        locali.b(localMessenger);
        return;
        Bundle localBundle2 = localBadParcelableException.getBundle("data_root_hints");
        MediaSessionCompat.d(localBundle2);
        locali.a(localMessenger, localBadParcelableException.getString("data_media_item_id"), (MediaSessionCompat.Token)localBadParcelableException.getParcelable("data_media_session_token"), localBundle2);
        return;
        locali.b(localMessenger);
        return;
        localBundle2 = localBadParcelableException.getBundle("data_options");
        MediaSessionCompat.d(localBundle2);
        Bundle localBundle3 = localBadParcelableException.getBundle("data_notify_children_changed_options");
        MediaSessionCompat.d(localBundle3);
        locali.a(localMessenger, localBadParcelableException.getString("data_media_item_id"), localBadParcelableException.getParcelableArrayList("data_media_item_list"), localBundle2, localBundle3);
        return;
      }
    }
  }
  
  public static class b
  {
    final Object KT;
    a KU;
    
    public b()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.KT = new a.b(new b());
        return;
      }
      this.KT = null;
    }
    
    public void onConnected() {}
    
    public void onConnectionFailed() {}
    
    public void onConnectionSuspended() {}
    
    static abstract interface a
    {
      public abstract void onConnected();
      
      public abstract void onConnectionSuspended();
    }
    
    final class b
      implements a.a
    {
      b() {}
      
      public final void onConnected()
      {
        if (MediaBrowserCompat.b.this.KU != null) {
          MediaBrowserCompat.b.this.KU.onConnected();
        }
        MediaBrowserCompat.b.this.onConnected();
      }
      
      public final void onConnectionFailed()
      {
        MediaBrowserCompat.b.this.onConnectionFailed();
      }
      
      public final void onConnectionSuspended()
      {
        if (MediaBrowserCompat.b.this.KU != null) {
          MediaBrowserCompat.b.this.KU.onConnectionSuspended();
        }
        MediaBrowserCompat.b.this.onConnectionSuspended();
      }
    }
  }
  
  public static abstract class c {}
  
  public static abstract interface d
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    public abstract MediaSessionCompat.Token eK();
  }
  
  static class e
    implements MediaBrowserCompat.b.a, MediaBrowserCompat.d, MediaBrowserCompat.i
  {
    protected final Object KX;
    protected final Bundle KY;
    protected final MediaBrowserCompat.a KZ = new MediaBrowserCompat.a(this);
    private final a<String, MediaBrowserCompat.k> La = new a();
    protected int Lb;
    protected MediaBrowserCompat.j Lc;
    protected Messenger Ld;
    private MediaSessionCompat.Token Le;
    private Bundle Lf;
    final Context mContext;
    
    e(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb, Bundle paramBundle)
    {
      this.mContext = paramContext;
      if (paramBundle != null) {}
      for (paramBundle = new Bundle(paramBundle);; paramBundle = new Bundle())
      {
        this.KY = paramBundle;
        this.KY.putInt("extra_client_version", 1);
        paramb.KU = this;
        paramb = paramb.KT;
        paramBundle = this.KY;
        this.KX = new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramb, paramBundle);
        return;
      }
    }
    
    public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
    
    public final void a(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (this.Ld != paramMessenger) {}
      do
      {
        do
        {
          do
          {
            return;
            paramMessenger = (MediaBrowserCompat.k)this.La.get(paramString);
            if (paramMessenger == null)
            {
              boolean bool = MediaBrowserCompat.DEBUG;
              return;
            }
          } while (paramMessenger.c(paramBundle1) == null);
          if (paramBundle1 != null) {
            break;
          }
        } while (paramList == null);
        this.Lf = paramBundle2;
        this.Lf = null;
        return;
      } while (paramList == null);
      this.Lf = paramBundle2;
      this.Lf = null;
    }
    
    public final void b(Messenger paramMessenger) {}
    
    public final void connect()
    {
      ((MediaBrowser)this.KX).connect();
    }
    
    public final void disconnect()
    {
      if ((this.Lc != null) && (this.Ld != null)) {}
      try
      {
        this.Lc.a(7, null, this.Ld);
        label28:
        ((MediaBrowser)this.KX).disconnect();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        break label28;
      }
    }
    
    public final MediaSessionCompat.Token eK()
    {
      if (this.Le == null) {
        this.Le = MediaSessionCompat.Token.z(((MediaBrowser)this.KX).getSessionToken());
      }
      return this.Le;
    }
    
    public final void onConnected()
    {
      Object localObject1 = ((MediaBrowser)this.KX).getExtras();
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        this.Lb = ((Bundle)localObject1).getInt("extra_service_version", 0);
        Object localObject2 = android.support.v4.app.c.b((Bundle)localObject1, "extra_messenger");
        if (localObject2 != null)
        {
          this.Lc = new MediaBrowserCompat.j((IBinder)localObject2, this.KY);
          this.Ld = new Messenger(this.KZ);
          this.KZ.a(this.Ld);
        }
        try
        {
          localObject2 = this.Lc;
          Context localContext = this.mContext;
          Messenger localMessenger = this.Ld;
          Bundle localBundle = new Bundle();
          localBundle.putString("data_package_name", localContext.getPackageName());
          localBundle.putBundle("data_root_hints", ((MediaBrowserCompat.j)localObject2).KY);
          ((MediaBrowserCompat.j)localObject2).a(6, localBundle, localMessenger);
          label137:
          localObject1 = android.support.v4.media.session.b.a.d(android.support.v4.app.c.b((Bundle)localObject1, "extra_session_binder"));
          if (localObject1 == null) {
            continue;
          }
          this.Le = MediaSessionCompat.Token.a(((MediaBrowser)this.KX).getSessionToken(), (b)localObject1);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          break label137;
        }
      }
    }
    
    public final void onConnectionSuspended()
    {
      this.Lc = null;
      this.Ld = null;
      this.Le = null;
      this.KZ.a(null);
    }
  }
  
  static class f
    extends MediaBrowserCompat.e
  {
    f(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb, Bundle paramBundle)
    {
      super(paramComponentName, paramb, null);
    }
  }
  
  static final class g
    extends MediaBrowserCompat.f
  {
    g(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
    {
      super(paramComponentName, paramb, null);
    }
  }
  
  static final class h
    implements MediaBrowserCompat.d, MediaBrowserCompat.i
  {
    final Bundle KY;
    final MediaBrowserCompat.a KZ = new MediaBrowserCompat.a(this);
    private final a<String, MediaBrowserCompat.k> La = new a();
    MediaBrowserCompat.j Lc;
    Messenger Ld;
    private MediaSessionCompat.Token Le;
    private Bundle Lf;
    final ComponentName Lg;
    final MediaBrowserCompat.b Lh;
    a Li;
    private String Lj;
    final Context mContext;
    private Bundle mExtras;
    int mState = 1;
    
    public h(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
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
      this.Lg = paramComponentName;
      this.Lh = paramb;
      this.KY = null;
    }
    
    private boolean a(Messenger paramMessenger, String paramString)
    {
      boolean bool = true;
      if ((this.Ld != paramMessenger) || (this.mState == 0) || (this.mState == 1))
      {
        if ((this.mState != 0) && (this.mState != 1)) {
          new StringBuilder().append(paramString).append(" for ").append(this.Lg).append(" with mCallbacksMessenger=").append(this.Ld).append(" this=").append(this);
        }
        bool = false;
      }
      return bool;
    }
    
    private static String az(int paramInt)
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
    
    public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      if (!a(paramMessenger, "onConnect")) {}
      for (;;)
      {
        return;
        if (this.mState != 2)
        {
          new StringBuilder("onConnect from service while mState=").append(az(this.mState)).append("... ignoring");
          return;
        }
        this.Lj = paramString;
        this.Le = paramToken;
        this.mExtras = paramBundle;
        this.mState = 3;
        if (MediaBrowserCompat.DEBUG) {
          dump();
        }
        this.Lh.onConnected();
        try
        {
          paramMessenger = this.La.entrySet().iterator();
          while (paramMessenger.hasNext())
          {
            paramToken = (Map.Entry)paramMessenger.next();
            paramString = (String)paramToken.getKey();
            paramBundle = (MediaBrowserCompat.k)paramToken.getValue();
            paramToken = paramBundle.Lp;
            paramBundle = paramBundle.Lq;
            int i = 0;
            while (i < paramToken.size())
            {
              MediaBrowserCompat.j localj = this.Lc;
              IBinder localIBinder = ((MediaBrowserCompat.l)paramToken.get(i)).En;
              Bundle localBundle1 = (Bundle)paramBundle.get(i);
              Messenger localMessenger = this.Ld;
              Bundle localBundle2 = new Bundle();
              localBundle2.putString("data_media_item_id", paramString);
              android.support.v4.app.c.a(localBundle2, "data_callback_token", localIBinder);
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
    
    public final void a(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (!a(paramMessenger, "onLoadChildren")) {}
      do
      {
        do
        {
          do
          {
            return;
            if (MediaBrowserCompat.DEBUG) {
              new StringBuilder("onLoadChildren for ").append(this.Lg).append(" id=").append(paramString);
            }
            paramMessenger = (MediaBrowserCompat.k)this.La.get(paramString);
            if (paramMessenger == null)
            {
              boolean bool = MediaBrowserCompat.DEBUG;
              return;
            }
          } while (paramMessenger.c(paramBundle1) == null);
          if (paramBundle1 != null) {
            break;
          }
        } while (paramList == null);
        this.Lf = paramBundle2;
        this.Lf = null;
        return;
      } while (paramList == null);
      this.Lf = paramBundle2;
      this.Lf = null;
    }
    
    public final void b(Messenger paramMessenger)
    {
      new StringBuilder("onConnectFailed for ").append(this.Lg);
      if (!a(paramMessenger, "onConnectFailed")) {
        return;
      }
      if (this.mState != 2)
      {
        new StringBuilder("onConnect from service while mState=").append(az(this.mState)).append("... ignoring");
        return;
      }
      eL();
      this.Lh.onConnectionFailed();
    }
    
    public final void connect()
    {
      if ((this.mState != 0) && (this.mState != 1)) {
        throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + az(this.mState) + ")");
      }
      this.mState = 2;
      this.KZ.post(new Runnable()
      {
        public final void run()
        {
          if (MediaBrowserCompat.h.this.mState == 0) {}
          do
          {
            return;
            MediaBrowserCompat.h.this.mState = 2;
            if ((MediaBrowserCompat.DEBUG) && (MediaBrowserCompat.h.this.Li != null)) {
              throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserCompat.h.this.Li);
            }
            if (MediaBrowserCompat.h.this.Lc != null) {
              throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserCompat.h.this.Lc);
            }
            if (MediaBrowserCompat.h.this.Ld != null) {
              throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserCompat.h.this.Ld);
            }
            Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
            localIntent.setComponent(MediaBrowserCompat.h.this.Lg);
            MediaBrowserCompat.h.this.Li = new MediaBrowserCompat.h.a(MediaBrowserCompat.h.this);
            int i = 0;
            try
            {
              boolean bool = MediaBrowserCompat.h.this.mContext.bindService(localIntent, MediaBrowserCompat.h.this.Li, 1);
              i = bool;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                new StringBuilder("Failed binding to service ").append(MediaBrowserCompat.h.this.Lg);
              }
            }
            if (i == 0)
            {
              MediaBrowserCompat.h.this.eL();
              MediaBrowserCompat.h.this.Lh.onConnectionFailed();
            }
          } while (!MediaBrowserCompat.DEBUG);
          MediaBrowserCompat.h.this.dump();
        }
      });
    }
    
    public final void disconnect()
    {
      this.mState = 0;
      this.KZ.post(new Runnable()
      {
        public final void run()
        {
          if (MediaBrowserCompat.h.this.Ld != null) {}
          try
          {
            MediaBrowserCompat.h.this.Lc.a(2, null, MediaBrowserCompat.h.this.Ld);
            int i = MediaBrowserCompat.h.this.mState;
            MediaBrowserCompat.h.this.eL();
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
              new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.Lg);
            }
          }
        }
      });
    }
    
    final void dump()
    {
      new StringBuilder("  mServiceComponent=").append(this.Lg);
      new StringBuilder("  mCallback=").append(this.Lh);
      new StringBuilder("  mRootHints=").append(this.KY);
      new StringBuilder("  mState=").append(az(this.mState));
      new StringBuilder("  mServiceConnection=").append(this.Li);
      new StringBuilder("  mServiceBinderWrapper=").append(this.Lc);
      new StringBuilder("  mCallbacksMessenger=").append(this.Ld);
      new StringBuilder("  mRootId=").append(this.Lj);
      new StringBuilder("  mMediaSessionToken=").append(this.Le);
    }
    
    public final MediaSessionCompat.Token eK()
    {
      if (this.mState == 3) {}
      for (int i = 1; i == 0; i = 0) {
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
      }
      return this.Le;
    }
    
    final void eL()
    {
      if (this.Li != null) {
        this.mContext.unbindService(this.Li);
      }
      this.mState = 1;
      this.Li = null;
      this.Lc = null;
      this.Ld = null;
      this.KZ.a(null);
      this.Lj = null;
      this.Le = null;
    }
    
    final class a
      implements ServiceConnection
    {
      a() {}
      
      private void f(Runnable paramRunnable)
      {
        if (Thread.currentThread() == MediaBrowserCompat.h.this.KZ.getLooper().getThread())
        {
          paramRunnable.run();
          return;
        }
        MediaBrowserCompat.h.this.KZ.post(paramRunnable);
      }
      
      final boolean A(String paramString)
      {
        boolean bool = true;
        if ((MediaBrowserCompat.h.this.Li != this) || (MediaBrowserCompat.h.this.mState == 0) || (MediaBrowserCompat.h.this.mState == 1))
        {
          if ((MediaBrowserCompat.h.this.mState != 0) && (MediaBrowserCompat.h.this.mState != 1)) {
            new StringBuilder().append(paramString).append(" for ").append(MediaBrowserCompat.h.this.Lg).append(" with mServiceConnection=").append(MediaBrowserCompat.h.this.Li).append(" this=").append(this);
          }
          bool = false;
        }
        return bool;
      }
      
      public final void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
      {
        f(new Runnable()
        {
          public final void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              new StringBuilder("MediaServiceConnection.onServiceConnected name=").append(paramComponentName).append(" binder=").append(paramIBinder);
              MediaBrowserCompat.h.this.dump();
            }
            if (!MediaBrowserCompat.h.a.this.A("onServiceConnected")) {}
            do
            {
              return;
              MediaBrowserCompat.h.this.Lc = new MediaBrowserCompat.j(paramIBinder, MediaBrowserCompat.h.this.KY);
              MediaBrowserCompat.h.this.Ld = new Messenger(MediaBrowserCompat.h.this.KZ);
              MediaBrowserCompat.h.this.KZ.a(MediaBrowserCompat.h.this.Ld);
              MediaBrowserCompat.h.this.mState = 2;
              try
              {
                if (MediaBrowserCompat.DEBUG) {
                  MediaBrowserCompat.h.this.dump();
                }
                MediaBrowserCompat.j localj = MediaBrowserCompat.h.this.Lc;
                Context localContext = MediaBrowserCompat.h.this.mContext;
                Messenger localMessenger = MediaBrowserCompat.h.this.Ld;
                Bundle localBundle = new Bundle();
                localBundle.putString("data_package_name", localContext.getPackageName());
                localBundle.putBundle("data_root_hints", localj.KY);
                localj.a(1, localBundle, localMessenger);
                return;
              }
              catch (RemoteException localRemoteException)
              {
                new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.Lg);
              }
            } while (!MediaBrowserCompat.DEBUG);
            MediaBrowserCompat.h.this.dump();
          }
        });
      }
      
      public final void onServiceDisconnected(final ComponentName paramComponentName)
      {
        f(new Runnable()
        {
          public final void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(paramComponentName).append(" this=").append(this).append(" mServiceConnection=").append(MediaBrowserCompat.h.this.Li);
              MediaBrowserCompat.h.this.dump();
            }
            if (!MediaBrowserCompat.h.a.this.A("onServiceDisconnected")) {
              return;
            }
            MediaBrowserCompat.h.this.Lc = null;
            MediaBrowserCompat.h.this.Ld = null;
            MediaBrowserCompat.h.this.KZ.a(null);
            MediaBrowserCompat.h.this.mState = 4;
            MediaBrowserCompat.h.this.Lh.onConnectionSuspended();
          }
        });
      }
    }
  }
  
  static abstract interface i
  {
    public abstract void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
    
    public abstract void a(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2);
    
    public abstract void b(Messenger paramMessenger);
  }
  
  static final class j
  {
    Bundle KY;
    private Messenger Lo;
    
    public j(IBinder paramIBinder, Bundle paramBundle)
    {
      this.Lo = new Messenger(paramIBinder);
      this.KY = paramBundle;
    }
    
    final void a(int paramInt, Bundle paramBundle, Messenger paramMessenger)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.setData(paramBundle);
      localMessage.replyTo = paramMessenger;
      this.Lo.send(localMessage);
    }
  }
  
  static final class k
  {
    final List<MediaBrowserCompat.l> Lp = new ArrayList();
    final List<Bundle> Lq = new ArrayList();
    
    public final MediaBrowserCompat.l c(Bundle paramBundle)
    {
      int i = 0;
      while (i < this.Lq.size())
      {
        if (c.a((Bundle)this.Lq.get(i), paramBundle)) {
          return (MediaBrowserCompat.l)this.Lp.get(i);
        }
        i += 1;
      }
      return null;
    }
  }
  
  public static abstract class l
  {
    final IBinder En = new Binder();
    final Object Lr;
    WeakReference<MediaBrowserCompat.k> Ls;
    
    public l()
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.Lr = new b.b(new b());
        return;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.Lr = new a.d(new a());
        return;
      }
      this.Lr = null;
    }
    
    class a
      implements a.c
    {
      a() {}
      
      public final void j(List<?> paramList)
      {
        if (MediaBrowserCompat.l.this.Ls == null) {}
        for (Object localObject = null; localObject == null; localObject = (MediaBrowserCompat.k)MediaBrowserCompat.l.this.Ls.get())
        {
          MediaBrowserCompat.MediaItem.i(paramList);
          return;
        }
        paramList = MediaBrowserCompat.MediaItem.i(paramList);
        List localList = ((MediaBrowserCompat.k)localObject).Lp;
        localObject = ((MediaBrowserCompat.k)localObject).Lq;
        int i = 0;
        label63:
        int j;
        int m;
        int k;
        if (i < localList.size())
        {
          Bundle localBundle = (Bundle)((List)localObject).get(i);
          if ((localBundle != null) && (paramList != null))
          {
            j = localBundle.getInt("android.media.browse.extra.PAGE", -1);
            int n = localBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
            if ((j != -1) || (n != -1))
            {
              m = n * j;
              k = m + n;
              if ((j >= 0) && (n > 0) && (m < paramList.size())) {
                break label170;
              }
              Collections.emptyList();
            }
          }
        }
        for (;;)
        {
          i += 1;
          break label63;
          break;
          label170:
          j = k;
          if (k > paramList.size()) {
            j = paramList.size();
          }
          paramList.subList(m, j);
        }
      }
    }
    
    final class b
      extends MediaBrowserCompat.l.a
      implements b.a
    {
      b()
      {
        super();
      }
      
      public final void k(List<?> paramList)
      {
        MediaBrowserCompat.MediaItem.i(paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat
 * JD-Core Version:    0.7.0.1
 */