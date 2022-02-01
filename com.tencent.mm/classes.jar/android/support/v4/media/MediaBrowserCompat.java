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
  public final d HS;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.HS = new g(paramContext, paramComponentName, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.HS = new f(paramContext, paramComponentName, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.HS = new e(paramContext, paramComponentName, paramb);
      return;
    }
    this.HS = new h(paramContext, paramComponentName, paramb);
  }
  
  public final void disconnect()
  {
    this.HS.disconnect();
  }
  
  static final class a
    extends Handler
  {
    private final WeakReference<MediaBrowserCompat.i> HT;
    private WeakReference<Messenger> HU;
    
    a(MediaBrowserCompat.i parami)
    {
      this.HT = new WeakReference(parami);
    }
    
    final void a(Messenger paramMessenger)
    {
      this.HU = new WeakReference(paramMessenger);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if ((this.HU == null) || (this.HU.get() == null) || (this.HT.get() == null)) {
        return;
      }
      Bundle localBundle1 = paramMessage.getData();
      MediaSessionCompat.d(localBundle1);
      MediaBrowserCompat.i locali = (MediaBrowserCompat.i)this.HT.get();
      Messenger localMessenger = (Messenger)this.HU.get();
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
    final Object HV;
    a HW;
    
    public b()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.HV = new a.b(new b());
        return;
      }
      this.HV = null;
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
        if (MediaBrowserCompat.b.this.HW != null) {
          MediaBrowserCompat.b.this.HW.onConnected();
        }
        MediaBrowserCompat.b.this.onConnected();
      }
      
      public final void onConnectionFailed()
      {
        MediaBrowserCompat.b.this.onConnectionFailed();
      }
      
      public final void onConnectionSuspended()
      {
        if (MediaBrowserCompat.b.this.HW != null) {
          MediaBrowserCompat.b.this.HW.onConnectionSuspended();
        }
        MediaBrowserCompat.b.this.onConnectionSuspended();
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    public abstract MediaSessionCompat.Token eh();
  }
  
  static class e
    implements MediaBrowserCompat.b.a, MediaBrowserCompat.d, MediaBrowserCompat.i
  {
    protected final Object HZ;
    protected final Bundle Ia;
    protected final MediaBrowserCompat.a Ib = new MediaBrowserCompat.a(this);
    private final a<String, MediaBrowserCompat.k> Ic = new a();
    protected int Ie;
    protected MediaBrowserCompat.j If;
    protected Messenger Ig;
    private MediaSessionCompat.Token Ih;
    private Bundle Ii;
    final Context mContext;
    
    e(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
    {
      this.mContext = paramContext;
      this.Ia = new Bundle();
      this.Ia.putInt("extra_client_version", 1);
      paramb.HW = this;
      paramb = paramb.HV;
      Bundle localBundle = this.Ia;
      this.HZ = new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramb, localBundle);
    }
    
    public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
    
    public final void a(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (this.Ig != paramMessenger) {}
      do
      {
        do
        {
          do
          {
            return;
            paramMessenger = (MediaBrowserCompat.k)this.Ic.get(paramString);
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
        this.Ii = paramBundle2;
        this.Ii = null;
        return;
      } while (paramList == null);
      this.Ii = paramBundle2;
      this.Ii = null;
    }
    
    public final void b(Messenger paramMessenger) {}
    
    public final void connect()
    {
      ((MediaBrowser)this.HZ).connect();
    }
    
    public final void disconnect()
    {
      if ((this.If != null) && (this.Ig != null)) {}
      try
      {
        this.If.a(7, null, this.Ig);
        label28:
        ((MediaBrowser)this.HZ).disconnect();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        break label28;
      }
    }
    
    public final MediaSessionCompat.Token eh()
    {
      if (this.Ih == null) {
        this.Ih = MediaSessionCompat.Token.w(((MediaBrowser)this.HZ).getSessionToken());
      }
      return this.Ih;
    }
    
    public final void onConnected()
    {
      Object localObject1 = ((MediaBrowser)this.HZ).getExtras();
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        this.Ie = ((Bundle)localObject1).getInt("extra_service_version", 0);
        Object localObject2 = android.support.v4.app.c.c((Bundle)localObject1, "extra_messenger");
        if (localObject2 != null)
        {
          this.If = new MediaBrowserCompat.j((IBinder)localObject2, this.Ia);
          this.Ig = new Messenger(this.Ib);
          this.Ib.a(this.Ig);
        }
        try
        {
          localObject2 = this.If;
          Context localContext = this.mContext;
          Messenger localMessenger = this.Ig;
          Bundle localBundle = new Bundle();
          localBundle.putString("data_package_name", localContext.getPackageName());
          localBundle.putBundle("data_root_hints", ((MediaBrowserCompat.j)localObject2).Ia);
          ((MediaBrowserCompat.j)localObject2).a(6, localBundle, localMessenger);
          label137:
          localObject1 = android.support.v4.media.session.b.a.d(android.support.v4.app.c.c((Bundle)localObject1, "extra_session_binder"));
          if (localObject1 == null) {
            continue;
          }
          this.Ih = MediaSessionCompat.Token.a(((MediaBrowser)this.HZ).getSessionToken(), (b)localObject1);
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
      this.If = null;
      this.Ig = null;
      this.Ih = null;
      this.Ib.a(null);
    }
  }
  
  static class f
    extends MediaBrowserCompat.e
  {
    f(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
    {
      super(paramComponentName, paramb);
    }
  }
  
  static final class g
    extends MediaBrowserCompat.f
  {
    g(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
    {
      super(paramComponentName, paramb);
    }
  }
  
  static final class h
    implements MediaBrowserCompat.d, MediaBrowserCompat.i
  {
    final Bundle Ia;
    final MediaBrowserCompat.a Ib = new MediaBrowserCompat.a(this);
    private final a<String, MediaBrowserCompat.k> Ic = new a();
    MediaBrowserCompat.j If;
    Messenger Ig;
    private MediaSessionCompat.Token Ih;
    private Bundle Ii;
    final ComponentName Ij;
    final MediaBrowserCompat.b Ik;
    a Il;
    private String Im;
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
      this.Ij = paramComponentName;
      this.Ik = paramb;
      this.Ia = null;
    }
    
    private boolean a(Messenger paramMessenger, String paramString)
    {
      boolean bool = true;
      if ((this.Ig != paramMessenger) || (this.mState == 0) || (this.mState == 1))
      {
        if ((this.mState != 0) && (this.mState != 1)) {
          new StringBuilder().append(paramString).append(" for ").append(this.Ij).append(" with mCallbacksMessenger=").append(this.Ig).append(" this=").append(this);
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
        this.Im = paramString;
        this.Ih = paramToken;
        this.mExtras = paramBundle;
        this.mState = 3;
        if (MediaBrowserCompat.DEBUG) {
          dump();
        }
        this.Ik.onConnected();
        try
        {
          paramMessenger = this.Ic.entrySet().iterator();
          while (paramMessenger.hasNext())
          {
            paramToken = (Map.Entry)paramMessenger.next();
            paramString = (String)paramToken.getKey();
            paramBundle = (MediaBrowserCompat.k)paramToken.getValue();
            paramToken = paramBundle.Is;
            paramBundle = paramBundle.It;
            int i = 0;
            while (i < paramToken.size())
            {
              MediaBrowserCompat.j localj = this.If;
              IBinder localIBinder = ((MediaBrowserCompat.l)paramToken.get(i)).Bo;
              Bundle localBundle1 = (Bundle)paramBundle.get(i);
              Messenger localMessenger = this.Ig;
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
              new StringBuilder("onLoadChildren for ").append(this.Ij).append(" id=").append(paramString);
            }
            paramMessenger = (MediaBrowserCompat.k)this.Ic.get(paramString);
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
        this.Ii = paramBundle2;
        this.Ii = null;
        return;
      } while (paramList == null);
      this.Ii = paramBundle2;
      this.Ii = null;
    }
    
    public final void b(Messenger paramMessenger)
    {
      new StringBuilder("onConnectFailed for ").append(this.Ij);
      if (!a(paramMessenger, "onConnectFailed")) {
        return;
      }
      if (this.mState != 2)
      {
        new StringBuilder("onConnect from service while mState=").append(az(this.mState)).append("... ignoring");
        return;
      }
      ei();
      this.Ik.onConnectionFailed();
    }
    
    public final void connect()
    {
      if ((this.mState != 0) && (this.mState != 1)) {
        throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + az(this.mState) + ")");
      }
      this.mState = 2;
      this.Ib.post(new Runnable()
      {
        public final void run()
        {
          if (MediaBrowserCompat.h.this.mState == 0) {}
          do
          {
            return;
            MediaBrowserCompat.h.this.mState = 2;
            if ((MediaBrowserCompat.DEBUG) && (MediaBrowserCompat.h.this.Il != null)) {
              throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserCompat.h.this.Il);
            }
            if (MediaBrowserCompat.h.this.If != null) {
              throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserCompat.h.this.If);
            }
            if (MediaBrowserCompat.h.this.Ig != null) {
              throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserCompat.h.this.Ig);
            }
            Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
            localIntent.setComponent(MediaBrowserCompat.h.this.Ij);
            MediaBrowserCompat.h.this.Il = new MediaBrowserCompat.h.a(MediaBrowserCompat.h.this);
            int i = 0;
            try
            {
              boolean bool = MediaBrowserCompat.h.this.mContext.bindService(localIntent, MediaBrowserCompat.h.this.Il, 1);
              i = bool;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                new StringBuilder("Failed binding to service ").append(MediaBrowserCompat.h.this.Ij);
              }
            }
            if (i == 0)
            {
              MediaBrowserCompat.h.this.ei();
              MediaBrowserCompat.h.this.Ik.onConnectionFailed();
            }
          } while (!MediaBrowserCompat.DEBUG);
          MediaBrowserCompat.h.this.dump();
        }
      });
    }
    
    public final void disconnect()
    {
      this.mState = 0;
      this.Ib.post(new Runnable()
      {
        public final void run()
        {
          if (MediaBrowserCompat.h.this.Ig != null) {}
          try
          {
            MediaBrowserCompat.h.this.If.a(2, null, MediaBrowserCompat.h.this.Ig);
            int i = MediaBrowserCompat.h.this.mState;
            MediaBrowserCompat.h.this.ei();
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
              new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.Ij);
            }
          }
        }
      });
    }
    
    final void dump()
    {
      new StringBuilder("  mServiceComponent=").append(this.Ij);
      new StringBuilder("  mCallback=").append(this.Ik);
      new StringBuilder("  mRootHints=").append(this.Ia);
      new StringBuilder("  mState=").append(az(this.mState));
      new StringBuilder("  mServiceConnection=").append(this.Il);
      new StringBuilder("  mServiceBinderWrapper=").append(this.If);
      new StringBuilder("  mCallbacksMessenger=").append(this.Ig);
      new StringBuilder("  mRootId=").append(this.Im);
      new StringBuilder("  mMediaSessionToken=").append(this.Ih);
    }
    
    public final MediaSessionCompat.Token eh()
    {
      if (this.mState == 3) {}
      for (int i = 1; i == 0; i = 0) {
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
      }
      return this.Ih;
    }
    
    final void ei()
    {
      if (this.Il != null) {
        this.mContext.unbindService(this.Il);
      }
      this.mState = 1;
      this.Il = null;
      this.If = null;
      this.Ig = null;
      this.Ib.a(null);
      this.Im = null;
      this.Ih = null;
    }
    
    final class a
      implements ServiceConnection
    {
      a() {}
      
      private void g(Runnable paramRunnable)
      {
        if (Thread.currentThread() == MediaBrowserCompat.h.this.Ib.getLooper().getThread())
        {
          paramRunnable.run();
          return;
        }
        MediaBrowserCompat.h.this.Ib.post(paramRunnable);
      }
      
      public final void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
      {
        g(new Runnable()
        {
          public final void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              new StringBuilder("MediaServiceConnection.onServiceConnected name=").append(paramComponentName).append(" binder=").append(paramIBinder);
              MediaBrowserCompat.h.this.dump();
            }
            if (!MediaBrowserCompat.h.a.this.y("onServiceConnected")) {}
            do
            {
              return;
              MediaBrowserCompat.h.this.If = new MediaBrowserCompat.j(paramIBinder, MediaBrowserCompat.h.this.Ia);
              MediaBrowserCompat.h.this.Ig = new Messenger(MediaBrowserCompat.h.this.Ib);
              MediaBrowserCompat.h.this.Ib.a(MediaBrowserCompat.h.this.Ig);
              MediaBrowserCompat.h.this.mState = 2;
              try
              {
                if (MediaBrowserCompat.DEBUG) {
                  MediaBrowserCompat.h.this.dump();
                }
                MediaBrowserCompat.j localj = MediaBrowserCompat.h.this.If;
                Context localContext = MediaBrowserCompat.h.this.mContext;
                Messenger localMessenger = MediaBrowserCompat.h.this.Ig;
                Bundle localBundle = new Bundle();
                localBundle.putString("data_package_name", localContext.getPackageName());
                localBundle.putBundle("data_root_hints", localj.Ia);
                localj.a(1, localBundle, localMessenger);
                return;
              }
              catch (RemoteException localRemoteException)
              {
                new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.Ij);
              }
            } while (!MediaBrowserCompat.DEBUG);
            MediaBrowserCompat.h.this.dump();
          }
        });
      }
      
      public final void onServiceDisconnected(final ComponentName paramComponentName)
      {
        g(new Runnable()
        {
          public final void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(paramComponentName).append(" this=").append(this).append(" mServiceConnection=").append(MediaBrowserCompat.h.this.Il);
              MediaBrowserCompat.h.this.dump();
            }
            if (!MediaBrowserCompat.h.a.this.y("onServiceDisconnected")) {
              return;
            }
            MediaBrowserCompat.h.this.If = null;
            MediaBrowserCompat.h.this.Ig = null;
            MediaBrowserCompat.h.this.Ib.a(null);
            MediaBrowserCompat.h.this.mState = 4;
            MediaBrowserCompat.h.this.Ik.onConnectionSuspended();
          }
        });
      }
      
      final boolean y(String paramString)
      {
        boolean bool = true;
        if ((MediaBrowserCompat.h.this.Il != this) || (MediaBrowserCompat.h.this.mState == 0) || (MediaBrowserCompat.h.this.mState == 1))
        {
          if ((MediaBrowserCompat.h.this.mState != 0) && (MediaBrowserCompat.h.this.mState != 1)) {
            new StringBuilder().append(paramString).append(" for ").append(MediaBrowserCompat.h.this.Ij).append(" with mServiceConnection=").append(MediaBrowserCompat.h.this.Il).append(" this=").append(this);
          }
          bool = false;
        }
        return bool;
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
    Bundle Ia;
    private Messenger Ir;
    
    public j(IBinder paramIBinder, Bundle paramBundle)
    {
      this.Ir = new Messenger(paramIBinder);
      this.Ia = paramBundle;
    }
    
    final void a(int paramInt, Bundle paramBundle, Messenger paramMessenger)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.setData(paramBundle);
      localMessage.replyTo = paramMessenger;
      this.Ir.send(localMessage);
    }
  }
  
  static final class k
  {
    final List<MediaBrowserCompat.l> Is = new ArrayList();
    final List<Bundle> It = new ArrayList();
    
    public final MediaBrowserCompat.l c(Bundle paramBundle)
    {
      int i = 0;
      while (i < this.It.size())
      {
        if (c.a((Bundle)this.It.get(i), paramBundle)) {
          return (MediaBrowserCompat.l)this.Is.get(i);
        }
        i += 1;
      }
      return null;
    }
  }
  
  public static abstract class l
  {
    final IBinder Bo = new Binder();
    final Object Iu;
    WeakReference<MediaBrowserCompat.k> Iv;
    
    public l()
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.Iu = new b.b(new b());
        return;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.Iu = new a.d(new a());
        return;
      }
      this.Iu = null;
    }
    
    class a
      implements a.c
    {
      a() {}
      
      public final void k(List<?> paramList)
      {
        if (MediaBrowserCompat.l.this.Iv == null) {}
        for (Object localObject = null; localObject == null; localObject = (MediaBrowserCompat.k)MediaBrowserCompat.l.this.Iv.get())
        {
          MediaBrowserCompat.MediaItem.j(paramList);
          return;
        }
        paramList = MediaBrowserCompat.MediaItem.j(paramList);
        List localList = ((MediaBrowserCompat.k)localObject).Is;
        localObject = ((MediaBrowserCompat.k)localObject).It;
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
      
      public final void l(List<?> paramList)
      {
        MediaBrowserCompat.MediaItem.j(paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat
 * JD-Core Version:    0.7.0.1
 */