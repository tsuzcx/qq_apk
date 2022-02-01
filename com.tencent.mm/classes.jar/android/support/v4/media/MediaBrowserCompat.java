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
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.c;
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
  public final d cp;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, b paramb)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.cp = new g(paramContext, paramComponentName, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.cp = new f(paramContext, paramComponentName, paramb, null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.cp = new e(paramContext, paramComponentName, paramb, null);
      return;
    }
    this.cp = new h(paramContext, paramComponentName, paramb);
  }
  
  public final void disconnect()
  {
    this.cp.disconnect();
  }
  
  static class CustomActionResultReceiver
    extends ResultReceiver
  {
    private final MediaBrowserCompat.c cw;
    private final Bundle mExtras;
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (this.cw == null) {
        return;
      }
      MediaSessionCompat.e(paramBundle);
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
      MediaSessionCompat.e(paramBundle);
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
    private final int cN;
    private final MediaDescriptionCompat cO;
    
    MediaItem(Parcel paramParcel)
    {
      this.cN = paramParcel.readInt();
      this.cO = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    }
    
    private MediaItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if (paramMediaDescriptionCompat == null) {
        throw new IllegalArgumentException("description cannot be null");
      }
      if (TextUtils.isEmpty(paramMediaDescriptionCompat.cY)) {
        throw new IllegalArgumentException("description must have a non-empty media id");
      }
      this.cN = paramInt;
      this.cO = paramMediaDescriptionCompat;
    }
    
    public static List<MediaItem> e(List<?> paramList)
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
        for (paramList = null;; paramList = new MediaItem(MediaDescriptionCompat.d(((MediaBrowser.MediaItem)paramList).getDescription()), i))
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
      localStringBuilder.append("mFlags=").append(this.cN);
      localStringBuilder.append(", mDescription=").append(this.cO);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.cN);
      this.cO.writeToParcel(paramParcel, paramInt);
    }
  }
  
  static class SearchResultReceiver
    extends ResultReceiver
  {
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      MediaSessionCompat.e(paramBundle);
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
    private final WeakReference<MediaBrowserCompat.i> cq;
    private WeakReference<Messenger> cs;
    
    a(MediaBrowserCompat.i parami)
    {
      this.cq = new WeakReference(parami);
    }
    
    final void a(Messenger paramMessenger)
    {
      this.cs = new WeakReference(paramMessenger);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if ((this.cs == null) || (this.cs.get() == null) || (this.cq.get() == null)) {
        return;
      }
      Bundle localBundle1 = paramMessage.getData();
      MediaSessionCompat.e(localBundle1);
      MediaBrowserCompat.i locali = (MediaBrowserCompat.i)this.cq.get();
      Messenger localMessenger = (Messenger)this.cs.get();
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
        MediaSessionCompat.e(localBundle2);
        locali.a(localMessenger, localBadParcelableException.getString("data_media_item_id"), (MediaSessionCompat.Token)localBadParcelableException.getParcelable("data_media_session_token"), localBundle2);
        return;
        locali.b(localMessenger);
        return;
        localBundle2 = localBadParcelableException.getBundle("data_options");
        MediaSessionCompat.e(localBundle2);
        Bundle localBundle3 = localBadParcelableException.getBundle("data_notify_children_changed_options");
        MediaSessionCompat.e(localBundle3);
        locali.a(localMessenger, localBadParcelableException.getString("data_media_item_id"), localBadParcelableException.getParcelableArrayList("data_media_item_list"), localBundle2, localBundle3);
        return;
      }
    }
  }
  
  public static class b
  {
    final Object ct;
    a cu;
    
    public b()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.ct = new a.b(new b());
        return;
      }
      this.ct = null;
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
        if (MediaBrowserCompat.b.this.cu != null) {
          MediaBrowserCompat.b.this.cu.onConnected();
        }
        MediaBrowserCompat.b.this.onConnected();
      }
      
      public final void onConnectionFailed()
      {
        MediaBrowserCompat.b.this.onConnectionFailed();
      }
      
      public final void onConnectionSuspended()
      {
        if (MediaBrowserCompat.b.this.cu != null) {
          MediaBrowserCompat.b.this.cu.onConnectionSuspended();
        }
        MediaBrowserCompat.b.this.onConnectionSuspended();
      }
    }
  }
  
  public static abstract class c {}
  
  public static abstract interface d
  {
    public abstract MediaSessionCompat.Token aO();
    
    public abstract void connect();
    
    public abstract void disconnect();
  }
  
  static class e
    implements MediaBrowserCompat.b.a, MediaBrowserCompat.d, MediaBrowserCompat.i
  {
    private final androidx.b.a<String, MediaBrowserCompat.k> cA = new androidx.b.a();
    protected int cB;
    protected MediaBrowserCompat.j cC;
    protected Messenger cD;
    private MediaSessionCompat.Token cE;
    private Bundle cF;
    protected final Object cx;
    protected final Bundle cy;
    protected final MediaBrowserCompat.a cz = new MediaBrowserCompat.a(this);
    final Context mContext;
    
    e(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb, Bundle paramBundle)
    {
      this.mContext = paramContext;
      if (paramBundle != null) {}
      for (paramBundle = new Bundle(paramBundle);; paramBundle = new Bundle())
      {
        this.cy = paramBundle;
        this.cy.putInt("extra_client_version", 1);
        paramb.cu = this;
        paramb = paramb.ct;
        paramBundle = this.cy;
        this.cx = new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramb, paramBundle);
        return;
      }
    }
    
    public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
    
    public final void a(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (this.cD != paramMessenger) {}
      do
      {
        do
        {
          do
          {
            return;
            paramMessenger = (MediaBrowserCompat.k)this.cA.get(paramString);
            if (paramMessenger == null)
            {
              boolean bool = MediaBrowserCompat.DEBUG;
              return;
            }
          } while (paramMessenger.d(paramBundle1) == null);
          if (paramBundle1 != null) {
            break;
          }
        } while (paramList == null);
        this.cF = paramBundle2;
        this.cF = null;
        return;
      } while (paramList == null);
      this.cF = paramBundle2;
      this.cF = null;
    }
    
    public final MediaSessionCompat.Token aO()
    {
      if (this.cE == null) {
        this.cE = MediaSessionCompat.Token.h(((MediaBrowser)this.cx).getSessionToken());
      }
      return this.cE;
    }
    
    public final void b(Messenger paramMessenger) {}
    
    public final void connect()
    {
      ((MediaBrowser)this.cx).connect();
    }
    
    public final void disconnect()
    {
      if ((this.cC != null) && (this.cD != null)) {}
      try
      {
        this.cC.a(7, null, this.cD);
        label28:
        ((MediaBrowser)this.cx).disconnect();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        break label28;
      }
    }
    
    public final void onConnected()
    {
      Object localObject1 = ((MediaBrowser)this.cx).getExtras();
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        this.cB = ((Bundle)localObject1).getInt("extra_service_version", 0);
        Object localObject2 = c.b((Bundle)localObject1, "extra_messenger");
        if (localObject2 != null)
        {
          this.cC = new MediaBrowserCompat.j((IBinder)localObject2, this.cy);
          this.cD = new Messenger(this.cz);
          this.cz.a(this.cD);
        }
        try
        {
          localObject2 = this.cC;
          Context localContext = this.mContext;
          Messenger localMessenger = this.cD;
          Bundle localBundle = new Bundle();
          localBundle.putString("data_package_name", localContext.getPackageName());
          localBundle.putBundle("data_root_hints", ((MediaBrowserCompat.j)localObject2).cy);
          ((MediaBrowserCompat.j)localObject2).a(6, localBundle, localMessenger);
          label137:
          localObject1 = android.support.v4.media.session.b.a.d(c.b((Bundle)localObject1, "extra_session_binder"));
          if (localObject1 == null) {
            continue;
          }
          this.cE = MediaSessionCompat.Token.a(((MediaBrowser)this.cx).getSessionToken(), (b)localObject1);
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
      this.cC = null;
      this.cD = null;
      this.cE = null;
      this.cz.a(null);
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
    private final androidx.b.a<String, MediaBrowserCompat.k> cA = new androidx.b.a();
    MediaBrowserCompat.j cC;
    Messenger cD;
    private MediaSessionCompat.Token cE;
    private Bundle cF;
    final ComponentName cG;
    final MediaBrowserCompat.b cH;
    a cI;
    private String cJ;
    final Bundle cy;
    final MediaBrowserCompat.a cz = new MediaBrowserCompat.a(this);
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
      this.cG = paramComponentName;
      this.cH = paramb;
      this.cy = null;
    }
    
    private static String G(int paramInt)
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
    
    private boolean a(Messenger paramMessenger, String paramString)
    {
      boolean bool = true;
      if ((this.cD != paramMessenger) || (this.mState == 0) || (this.mState == 1))
      {
        if ((this.mState != 0) && (this.mState != 1)) {
          new StringBuilder().append(paramString).append(" for ").append(this.cG).append(" with mCallbacksMessenger=").append(this.cD).append(" this=").append(this);
        }
        bool = false;
      }
      return bool;
    }
    
    public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      if (!a(paramMessenger, "onConnect")) {}
      for (;;)
      {
        return;
        if (this.mState != 2)
        {
          new StringBuilder("onConnect from service while mState=").append(G(this.mState)).append("... ignoring");
          return;
        }
        this.cJ = paramString;
        this.cE = paramToken;
        this.mExtras = paramBundle;
        this.mState = 3;
        if (MediaBrowserCompat.DEBUG) {
          aQ();
        }
        this.cH.onConnected();
        try
        {
          paramMessenger = this.cA.entrySet().iterator();
          while (paramMessenger.hasNext())
          {
            paramToken = (Map.Entry)paramMessenger.next();
            paramString = (String)paramToken.getKey();
            paramBundle = (MediaBrowserCompat.k)paramToken.getValue();
            paramToken = paramBundle.cQ;
            paramBundle = paramBundle.cR;
            int i = 0;
            while (i < paramToken.size())
            {
              MediaBrowserCompat.j localj = this.cC;
              IBinder localIBinder = ((MediaBrowserCompat.l)paramToken.get(i)).cT;
              Bundle localBundle1 = (Bundle)paramBundle.get(i);
              Messenger localMessenger = this.cD;
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
              new StringBuilder("onLoadChildren for ").append(this.cG).append(" id=").append(paramString);
            }
            paramMessenger = (MediaBrowserCompat.k)this.cA.get(paramString);
            if (paramMessenger == null)
            {
              boolean bool = MediaBrowserCompat.DEBUG;
              return;
            }
          } while (paramMessenger.d(paramBundle1) == null);
          if (paramBundle1 != null) {
            break;
          }
        } while (paramList == null);
        this.cF = paramBundle2;
        this.cF = null;
        return;
      } while (paramList == null);
      this.cF = paramBundle2;
      this.cF = null;
    }
    
    public final MediaSessionCompat.Token aO()
    {
      if (this.mState == 3) {}
      for (int i = 1; i == 0; i = 0) {
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
      }
      return this.cE;
    }
    
    final void aP()
    {
      if (this.cI != null) {
        this.mContext.unbindService(this.cI);
      }
      this.mState = 1;
      this.cI = null;
      this.cC = null;
      this.cD = null;
      this.cz.a(null);
      this.cJ = null;
      this.cE = null;
    }
    
    final void aQ()
    {
      new StringBuilder("  mServiceComponent=").append(this.cG);
      new StringBuilder("  mCallback=").append(this.cH);
      new StringBuilder("  mRootHints=").append(this.cy);
      new StringBuilder("  mState=").append(G(this.mState));
      new StringBuilder("  mServiceConnection=").append(this.cI);
      new StringBuilder("  mServiceBinderWrapper=").append(this.cC);
      new StringBuilder("  mCallbacksMessenger=").append(this.cD);
      new StringBuilder("  mRootId=").append(this.cJ);
      new StringBuilder("  mMediaSessionToken=").append(this.cE);
    }
    
    public final void b(Messenger paramMessenger)
    {
      new StringBuilder("onConnectFailed for ").append(this.cG);
      if (!a(paramMessenger, "onConnectFailed")) {
        return;
      }
      if (this.mState != 2)
      {
        new StringBuilder("onConnect from service while mState=").append(G(this.mState)).append("... ignoring");
        return;
      }
      aP();
      this.cH.onConnectionFailed();
    }
    
    public final void connect()
    {
      if ((this.mState != 0) && (this.mState != 1)) {
        throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + G(this.mState) + ")");
      }
      this.mState = 2;
      this.cz.post(new Runnable()
      {
        public final void run()
        {
          if (MediaBrowserCompat.h.this.mState == 0) {}
          do
          {
            return;
            MediaBrowserCompat.h.this.mState = 2;
            if ((MediaBrowserCompat.DEBUG) && (MediaBrowserCompat.h.this.cI != null)) {
              throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserCompat.h.this.cI);
            }
            if (MediaBrowserCompat.h.this.cC != null) {
              throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserCompat.h.this.cC);
            }
            if (MediaBrowserCompat.h.this.cD != null) {
              throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserCompat.h.this.cD);
            }
            Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
            localIntent.setComponent(MediaBrowserCompat.h.this.cG);
            MediaBrowserCompat.h.this.cI = new MediaBrowserCompat.h.a(MediaBrowserCompat.h.this);
            int i = 0;
            try
            {
              boolean bool = MediaBrowserCompat.h.this.mContext.bindService(localIntent, MediaBrowserCompat.h.this.cI, 1);
              i = bool;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                new StringBuilder("Failed binding to service ").append(MediaBrowserCompat.h.this.cG);
              }
            }
            if (i == 0)
            {
              MediaBrowserCompat.h.this.aP();
              MediaBrowserCompat.h.this.cH.onConnectionFailed();
            }
          } while (!MediaBrowserCompat.DEBUG);
          MediaBrowserCompat.h.this.aQ();
        }
      });
    }
    
    public final void disconnect()
    {
      this.mState = 0;
      this.cz.post(new Runnable()
      {
        public final void run()
        {
          if (MediaBrowserCompat.h.this.cD != null) {}
          try
          {
            MediaBrowserCompat.h.this.cC.a(2, null, MediaBrowserCompat.h.this.cD);
            int i = MediaBrowserCompat.h.this.mState;
            MediaBrowserCompat.h.this.aP();
            if (i != 0) {
              MediaBrowserCompat.h.this.mState = i;
            }
            if (MediaBrowserCompat.DEBUG) {
              MediaBrowserCompat.h.this.aQ();
            }
            return;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.cG);
            }
          }
        }
      });
    }
    
    final class a
      implements ServiceConnection
    {
      a() {}
      
      private void e(Runnable paramRunnable)
      {
        if (Thread.currentThread() == MediaBrowserCompat.h.this.cz.getLooper().getThread())
        {
          paramRunnable.run();
          return;
        }
        MediaBrowserCompat.h.this.cz.post(paramRunnable);
      }
      
      final boolean o(String paramString)
      {
        boolean bool = true;
        if ((MediaBrowserCompat.h.this.cI != this) || (MediaBrowserCompat.h.this.mState == 0) || (MediaBrowserCompat.h.this.mState == 1))
        {
          if ((MediaBrowserCompat.h.this.mState != 0) && (MediaBrowserCompat.h.this.mState != 1)) {
            new StringBuilder().append(paramString).append(" for ").append(MediaBrowserCompat.h.this.cG).append(" with mServiceConnection=").append(MediaBrowserCompat.h.this.cI).append(" this=").append(this);
          }
          bool = false;
        }
        return bool;
      }
      
      public final void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
      {
        e(new Runnable()
        {
          public final void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              new StringBuilder("MediaServiceConnection.onServiceConnected name=").append(paramComponentName).append(" binder=").append(paramIBinder);
              MediaBrowserCompat.h.this.aQ();
            }
            if (!MediaBrowserCompat.h.a.this.o("onServiceConnected")) {}
            do
            {
              return;
              MediaBrowserCompat.h.this.cC = new MediaBrowserCompat.j(paramIBinder, MediaBrowserCompat.h.this.cy);
              MediaBrowserCompat.h.this.cD = new Messenger(MediaBrowserCompat.h.this.cz);
              MediaBrowserCompat.h.this.cz.a(MediaBrowserCompat.h.this.cD);
              MediaBrowserCompat.h.this.mState = 2;
              try
              {
                if (MediaBrowserCompat.DEBUG) {
                  MediaBrowserCompat.h.this.aQ();
                }
                MediaBrowserCompat.j localj = MediaBrowserCompat.h.this.cC;
                Context localContext = MediaBrowserCompat.h.this.mContext;
                Messenger localMessenger = MediaBrowserCompat.h.this.cD;
                Bundle localBundle = new Bundle();
                localBundle.putString("data_package_name", localContext.getPackageName());
                localBundle.putBundle("data_root_hints", localj.cy);
                localj.a(1, localBundle, localMessenger);
                return;
              }
              catch (RemoteException localRemoteException)
              {
                new StringBuilder("RemoteException during connect for ").append(MediaBrowserCompat.h.this.cG);
              }
            } while (!MediaBrowserCompat.DEBUG);
            MediaBrowserCompat.h.this.aQ();
          }
        });
      }
      
      public final void onServiceDisconnected(final ComponentName paramComponentName)
      {
        e(new Runnable()
        {
          public final void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              new StringBuilder("MediaServiceConnection.onServiceDisconnected name=").append(paramComponentName).append(" this=").append(this).append(" mServiceConnection=").append(MediaBrowserCompat.h.this.cI);
              MediaBrowserCompat.h.this.aQ();
            }
            if (!MediaBrowserCompat.h.a.this.o("onServiceDisconnected")) {
              return;
            }
            MediaBrowserCompat.h.this.cC = null;
            MediaBrowserCompat.h.this.cD = null;
            MediaBrowserCompat.h.this.cz.a(null);
            MediaBrowserCompat.h.this.mState = 4;
            MediaBrowserCompat.h.this.cH.onConnectionSuspended();
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
    private Messenger cP;
    Bundle cy;
    
    public j(IBinder paramIBinder, Bundle paramBundle)
    {
      this.cP = new Messenger(paramIBinder);
      this.cy = paramBundle;
    }
    
    final void a(int paramInt, Bundle paramBundle, Messenger paramMessenger)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.setData(paramBundle);
      localMessage.replyTo = paramMessenger;
      this.cP.send(localMessage);
    }
  }
  
  static final class k
  {
    final List<MediaBrowserCompat.l> cQ = new ArrayList();
    final List<Bundle> cR = new ArrayList();
    
    public final MediaBrowserCompat.l d(Bundle paramBundle)
    {
      int i = 0;
      while (i < this.cR.size())
      {
        if (androidx.media.a.b((Bundle)this.cR.get(i), paramBundle)) {
          return (MediaBrowserCompat.l)this.cQ.get(i);
        }
        i += 1;
      }
      return null;
    }
  }
  
  public static abstract class l
  {
    final Object cS;
    final IBinder cT = new Binder();
    WeakReference<MediaBrowserCompat.k> cU;
    
    public l()
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.cS = new b.b(new b());
        return;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.cS = new a.d(new a());
        return;
      }
      this.cS = null;
    }
    
    class a
      implements a.c
    {
      a() {}
      
      public final void f(List<?> paramList)
      {
        if (MediaBrowserCompat.l.this.cU == null) {}
        for (Object localObject = null; localObject == null; localObject = (MediaBrowserCompat.k)MediaBrowserCompat.l.this.cU.get())
        {
          MediaBrowserCompat.MediaItem.e(paramList);
          return;
        }
        paramList = MediaBrowserCompat.MediaItem.e(paramList);
        List localList = ((MediaBrowserCompat.k)localObject).cQ;
        localObject = ((MediaBrowserCompat.k)localObject).cR;
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
      
      public final void g(List<?> paramList)
      {
        MediaBrowserCompat.MediaItem.e(paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat
 * JD-Core Version:    0.7.0.1
 */