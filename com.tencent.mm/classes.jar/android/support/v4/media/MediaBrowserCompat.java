package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.v4.e.a;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
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
  public final d IQ;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.IQ = new g(paramContext, paramComponentName, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.IQ = new f(paramContext, paramComponentName, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.IQ = new e(paramContext, paramComponentName, paramb);
      return;
    }
    this.IQ = new h(paramContext, paramComponentName, paramb);
  }
  
  public final void disconnect()
  {
    this.IQ.disconnect();
  }
  
  static class CustomActionResultReceiver
    extends ResultReceiver
  {
    private final MediaBrowserCompat.c IW;
    private final Bundle mExtras;
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (this.IW == null) {
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
  
  public static class MediaItem
    implements Parcelable
  {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator() {};
    private final int DU;
    private final MediaDescriptionCompat Jn;
    
    MediaItem(Parcel paramParcel)
    {
      this.DU = paramParcel.readInt();
      this.Jn = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    }
    
    private MediaItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if (paramMediaDescriptionCompat == null) {
        throw new IllegalArgumentException("description cannot be null");
      }
      if (TextUtils.isEmpty(paramMediaDescriptionCompat.Kc)) {
        throw new IllegalArgumentException("description must have a non-empty media id");
      }
      this.DU = paramInt;
      this.Jn = paramMediaDescriptionCompat;
    }
    
    public static List<MediaItem> i(List<?> paramList)
    {
      if ((paramList == null) || (Build.VERSION.SDK_INT < 21)) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        paramList = localIterator.next();
        if ((paramList == null) || (Build.VERSION.SDK_INT < 21)) {}
        int i;
        for (paramList = null;; paramList = new MediaItem(MediaDescriptionCompat.u(((MediaBrowser.MediaItem)paramList).getDescription()), i))
        {
          localArrayList.add(paramList);
          break;
          i = ((MediaBrowser.MediaItem)paramList).getFlags();
        }
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MediaItem{");
      localStringBuilder.append("mFlags=").append(this.DU);
      localStringBuilder.append(", mDescription=").append(this.Jn);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.DU);
      this.Jn.writeToParcel(paramParcel, paramInt);
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
    private final WeakReference<MediaBrowserCompat.i> IR;
    private WeakReference<Messenger> IS;
    
    a(MediaBrowserCompat.i parami)
    {
      this.IR = new WeakReference(parami);
    }
    
    final void a(Messenger paramMessenger)
    {
      this.IS = new WeakReference(paramMessenger);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if ((this.IS == null) || (this.IS.get() == null) || (this.IR.get() == null)) {
        return;
      }
      Bundle localBundle1 = paramMessage.getData();
      MediaSessionCompat.d(localBundle1);
      MediaBrowserCompat.i locali = (MediaBrowserCompat.i)this.IR.get();
      Messenger localMessenger = (Messenger)this.IS.get();
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
    final Object IT;
    a IU;
    
    public b()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.IT = new a.b(new b());
        return;
      }
      this.IT = null;
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
        if (MediaBrowserCompat.b.this.IU != null) {
          MediaBrowserCompat.b.this.IU.onConnected();
        }
        MediaBrowserCompat.b.this.onConnected();
      }
      
      public final void onConnectionFailed()
      {
        MediaBrowserCompat.b.this.onConnectionFailed();
      }
      
      public final void onConnectionSuspended()
      {
        if (MediaBrowserCompat.b.this.IU != null) {
          MediaBrowserCompat.b.this.IU.onConnectionSuspended();
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
    
    public abstract MediaSessionCompat.Token ep();
  }
  
  static class e
    implements MediaBrowserCompat.b.a, MediaBrowserCompat.d, MediaBrowserCompat.i
  {
    protected final Object IX;
    protected final Bundle IY;
    protected final MediaBrowserCompat.a IZ = new MediaBrowserCompat.a(this);
    private final a<String, MediaBrowserCompat.k> Ja = new a();
    protected int Jb;
    protected MediaBrowserCompat.j Jc;
    protected Messenger Jd;
    private MediaSessionCompat.Token Je;
    private Bundle Jf;
    final Context mContext;
    
    e(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
    {
      this.mContext = paramContext;
      this.IY = new Bundle();
      this.IY.putInt("extra_client_version", 1);
      paramb.IU = this;
      paramb = paramb.IT;
      Bundle localBundle = this.IY;
      this.IX = new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramb, localBundle);
    }
    
    public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
    
    public final void a(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (this.Jd != paramMessenger) {}
      do
      {
        do
        {
          do
          {
            return;
            paramMessenger = (MediaBrowserCompat.k)this.Ja.get(paramString);
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
        this.Jf = paramBundle2;
        this.Jf = null;
        return;
      } while (paramList == null);
      this.Jf = paramBundle2;
      this.Jf = null;
    }
    
    public final void b(Messenger paramMessenger) {}
    
    public final void connect()
    {
      ((MediaBrowser)this.IX).connect();
    }
    
    public final void disconnect()
    {
      if ((this.Jc != null) && (this.Jd != null)) {}
      try
      {
        this.Jc.a(7, null, this.Jd);
        label28:
        ((MediaBrowser)this.IX).disconnect();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        break label28;
      }
    }
    
    public final MediaSessionCompat.Token ep()
    {
      if (this.Je == null) {
        this.Je = MediaSessionCompat.Token.y(((MediaBrowser)this.IX).getSessionToken());
      }
      return this.Je;
    }
    
    public final void onConnected()
    {
      Object localObject1 = ((MediaBrowser)this.IX).getExtras();
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        this.Jb = ((Bundle)localObject1).getInt("extra_service_version", 0);
        Object localObject2 = android.support.v4.app.c.c((Bundle)localObject1, "extra_messenger");
        if (localObject2 != null)
        {
          this.Jc = new MediaBrowserCompat.j((IBinder)localObject2, this.IY);
          this.Jd = new Messenger(this.IZ);
          this.IZ.a(this.Jd);
        }
        try
        {
          localObject2 = this.Jc;
          Context localContext = this.mContext;
          Messenger localMessenger = this.Jd;
          Bundle localBundle = new Bundle();
          localBundle.putString("data_package_name", localContext.getPackageName());
          localBundle.putBundle("data_root_hints", ((MediaBrowserCompat.j)localObject2).IY);
          ((MediaBrowserCompat.j)localObject2).a(6, localBundle, localMessenger);
          label137:
          localObject1 = android.support.v4.media.session.b.a.d(android.support.v4.app.c.c((Bundle)localObject1, "extra_session_binder"));
          if (localObject1 == null) {
            continue;
          }
          this.Je = MediaSessionCompat.Token.a(((MediaBrowser)this.IX).getSessionToken(), (b)localObject1);
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
      this.Jc = null;
      this.Jd = null;
      this.Je = null;
      this.IZ.a(null);
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
    final Bundle IY;
    final MediaBrowserCompat.a IZ = new MediaBrowserCompat.a(this);
    private final a<String, MediaBrowserCompat.k> Ja = new a();
    MediaBrowserCompat.j Jc;
    Messenger Jd;
    private MediaSessionCompat.Token Je;
    private Bundle Jf;
    final ComponentName Jg;
    final MediaBrowserCompat.b Jh;
    a Ji;
    private String Jj;
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
      this.Jg = paramComponentName;
      this.Jh = paramb;
      this.IY = null;
    }
    
    private boolean a(Messenger paramMessenger, String paramString)
    {
      boolean bool = true;
      if ((this.Jd != paramMessenger) || (this.mState == 0) || (this.mState == 1))
      {
        if ((this.mState != 0) && (this.mState != 1)) {
          new StringBuilder().append(paramString).append(" for ").append(this.Jg).append(" with mCallbacksMessenger=").append(this.Jd).append(" this=").append(this);
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
        this.Jj = paramString;
        this.Je = paramToken;
        this.mExtras = paramBundle;
        this.mState = 3;
        if (MediaBrowserCompat.DEBUG) {
          dump();
        }
        this.Jh.onConnected();
        try
        {
          paramMessenger = this.Ja.entrySet().iterator();
          while (paramMessenger.hasNext())
          {
            paramToken = (Map.Entry)paramMessenger.next();
            paramString = (String)paramToken.getKey();
            paramBundle = (MediaBrowserCompat.k)paramToken.getValue();
            paramToken = paramBundle.Jp;
            paramBundle = paramBundle.Jq;
            int i = 0;
            while (i < paramToken.size())
            {
              MediaBrowserCompat.j localj = this.Jc;
              IBinder localIBinder = ((MediaBrowserCompat.l)paramToken.get(i)).Cm;
              Bundle localBundle1 = (Bundle)paramBundle.get(i);
              Messenger localMessenger = this.Jd;
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
              new StringBuilder("onLoadChildren for ").append(this.Jg).append(" id=").append(paramString);
            }
            paramMessenger = (MediaBrowserCompat.k)this.Ja.get(paramString);
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
        this.Jf = paramBundle2;
        this.Jf = null;
        return;
      } while (paramList == null);
      this.Jf = paramBundle2;
      this.Jf = null;
    }
    
    public final void b(Messenger paramMessenger)
    {
      new StringBuilder("onConnectFailed for ").append(this.Jg);
      if (!a(paramMessenger, "onConnectFailed")) {
        return;
      }
      if (this.mState != 2)
      {
        new StringBuilder("onConnect from service while mState=").append(az(this.mState)).append("... ignoring");
        return;
      }
      eq();
      this.Jh.onConnectionFailed();
    }
    
    public final void connect()
    {
      if ((this.mState != 0) && (this.mState != 1)) {
        throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + az(this.mState) + ")");
      }
      this.mState = 2;
      this.IZ.post(new Runnable()
      {
        public final void run()
        {
          if (MediaBrowserCompat.h.this.mState == 0) {}
          do
          {
            return;
            MediaBrowserCompat.h.this.mState = 2;
            if ((MediaBrowserCompat.DEBUG) && (MediaBrowserCompat.h.this.Ji != null)) {
              throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserCompat.h.this.Ji);
            }
            if (MediaBrowserCompat.h.this.Jc != null) {
              throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserCompat.h.this.Jc);
            }
            if (MediaBrowserCompat.h.this.Jd != null) {
              throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserCompat.h.this.Jd);
            }
            Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
            localIntent.setComponent(MediaBrowserCompat.h.this.Jg);
            MediaBrowserCompat.h.this.Ji = new MediaBrowserCompat.h.a(MediaBrowserCompat.h.this);
            int i = 0;
            try
            {
              boolean bool = MediaBrowserCompat.h.this.mContext.bindService(localIntent, MediaBrowserCompat.h.this.Ji, 1);
              i = bool;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                new StringBuilder("Failed binding to service ").append(MediaBrowserCompat.h.this.Jg);
              }
            }
            if (i == 0)
            {
              MediaBrowserCompat.h.this.eq();
              MediaBrowserCompat.h.this.Jh.onConnectionFailed();
            }
          } while (!MediaBrowserCompat.DEBUG);
          MediaBrowserCompat.h.this.dump();
        }
      });
    }
    
    public final void disconnect()
    {
      this.mState = 0;
      this.IZ.post(new Runnable()
      {
        public final void run()
        {
          if (MediaBrowserCompat.h.this.Jd != null) {}
          try
          {
            MediaBrowserCompat.h.this.Jc.a(2, null, MediaBrowserCompat.h.this.Jd);
            int i = MediaBrowserCompat.h.this.mState;
            MediaBrowserCompat.h.this.eq();
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
              new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.Jg);
            }
          }
        }
      });
    }
    
    final void dump()
    {
      new StringBuilder("  mServiceComponent=").append(this.Jg);
      new StringBuilder("  mCallback=").append(this.Jh);
      new StringBuilder("  mRootHints=").append(this.IY);
      new StringBuilder("  mState=").append(az(this.mState));
      new StringBuilder("  mServiceConnection=").append(this.Ji);
      new StringBuilder("  mServiceBinderWrapper=").append(this.Jc);
      new StringBuilder("  mCallbacksMessenger=").append(this.Jd);
      new StringBuilder("  mRootId=").append(this.Jj);
      new StringBuilder("  mMediaSessionToken=").append(this.Je);
    }
    
    public final MediaSessionCompat.Token ep()
    {
      if (this.mState == 3) {}
      for (int i = 1; i == 0; i = 0) {
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
      }
      return this.Je;
    }
    
    final void eq()
    {
      if (this.Ji != null) {
        this.mContext.unbindService(this.Ji);
      }
      this.mState = 1;
      this.Ji = null;
      this.Jc = null;
      this.Jd = null;
      this.IZ.a(null);
      this.Jj = null;
      this.Je = null;
    }
    
    final class a
      implements ServiceConnection
    {
      a() {}
      
      private void g(Runnable paramRunnable)
      {
        if (Thread.currentThread() == MediaBrowserCompat.h.this.IZ.getLooper().getThread())
        {
          paramRunnable.run();
          return;
        }
        MediaBrowserCompat.h.this.IZ.post(paramRunnable);
      }
      
      final boolean A(String paramString)
      {
        boolean bool = true;
        if ((MediaBrowserCompat.h.this.Ji != this) || (MediaBrowserCompat.h.this.mState == 0) || (MediaBrowserCompat.h.this.mState == 1))
        {
          if ((MediaBrowserCompat.h.this.mState != 0) && (MediaBrowserCompat.h.this.mState != 1)) {
            new StringBuilder().append(paramString).append(" for ").append(MediaBrowserCompat.h.this.Jg).append(" with mServiceConnection=").append(MediaBrowserCompat.h.this.Ji).append(" this=").append(this);
          }
          bool = false;
        }
        return bool;
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
            if (!MediaBrowserCompat.h.a.this.A("onServiceConnected")) {}
            do
            {
              return;
              MediaBrowserCompat.h.this.Jc = new MediaBrowserCompat.j(paramIBinder, MediaBrowserCompat.h.this.IY);
              MediaBrowserCompat.h.this.Jd = new Messenger(MediaBrowserCompat.h.this.IZ);
              MediaBrowserCompat.h.this.IZ.a(MediaBrowserCompat.h.this.Jd);
              MediaBrowserCompat.h.this.mState = 2;
              try
              {
                if (MediaBrowserCompat.DEBUG) {
                  MediaBrowserCompat.h.this.dump();
                }
                MediaBrowserCompat.j localj = MediaBrowserCompat.h.this.Jc;
                Context localContext = MediaBrowserCompat.h.this.mContext;
                Messenger localMessenger = MediaBrowserCompat.h.this.Jd;
                Bundle localBundle = new Bundle();
                localBundle.putString("data_package_name", localContext.getPackageName());
                localBundle.putBundle("data_root_hints", localj.IY);
                localj.a(1, localBundle, localMessenger);
                return;
              }
              catch (RemoteException localRemoteException)
              {
                new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.Jg);
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
              new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(paramComponentName).append(" this=").append(this).append(" mServiceConnection=").append(MediaBrowserCompat.h.this.Ji);
              MediaBrowserCompat.h.this.dump();
            }
            if (!MediaBrowserCompat.h.a.this.A("onServiceDisconnected")) {
              return;
            }
            MediaBrowserCompat.h.this.Jc = null;
            MediaBrowserCompat.h.this.Jd = null;
            MediaBrowserCompat.h.this.IZ.a(null);
            MediaBrowserCompat.h.this.mState = 4;
            MediaBrowserCompat.h.this.Jh.onConnectionSuspended();
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
    Bundle IY;
    private Messenger Jo;
    
    public j(IBinder paramIBinder, Bundle paramBundle)
    {
      this.Jo = new Messenger(paramIBinder);
      this.IY = paramBundle;
    }
    
    final void a(int paramInt, Bundle paramBundle, Messenger paramMessenger)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.setData(paramBundle);
      localMessage.replyTo = paramMessenger;
      this.Jo.send(localMessage);
    }
  }
  
  static final class k
  {
    final List<MediaBrowserCompat.l> Jp = new ArrayList();
    final List<Bundle> Jq = new ArrayList();
    
    public final MediaBrowserCompat.l c(Bundle paramBundle)
    {
      int i = 0;
      while (i < this.Jq.size())
      {
        if (c.a((Bundle)this.Jq.get(i), paramBundle)) {
          return (MediaBrowserCompat.l)this.Jp.get(i);
        }
        i += 1;
      }
      return null;
    }
  }
  
  public static abstract class l
  {
    final IBinder Cm = new Binder();
    final Object Jr;
    WeakReference<MediaBrowserCompat.k> Js;
    
    public l()
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.Jr = new b.b(new b());
        return;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.Jr = new a.d(new a());
        return;
      }
      this.Jr = null;
    }
    
    class a
      implements a.c
    {
      a() {}
      
      public final void j(List<?> paramList)
      {
        if (MediaBrowserCompat.l.this.Js == null) {}
        for (Object localObject = null; localObject == null; localObject = (MediaBrowserCompat.k)MediaBrowserCompat.l.this.Js.get())
        {
          MediaBrowserCompat.MediaItem.i(paramList);
          return;
        }
        paramList = MediaBrowserCompat.MediaItem.i(paramList);
        List localList = ((MediaBrowserCompat.k)localObject).Jp;
        localObject = ((MediaBrowserCompat.k)localObject).Jq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat
 * JD-Core Version:    0.7.0.1
 */