package android.support.v4.media;

import android.app.Service;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.e.a;
import android.support.v4.e.k;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
  final a<IBinder, b> Lm = new a();
  b Ln;
  final g Lo = new g();
  MediaSessionCompat.Token Lp;
  
  static List<MediaBrowserCompat.MediaItem> eJ()
  {
    return null;
  }
  
  final void a(final String paramString, final b paramb, IBinder paramIBinder, final Bundle paramBundle)
  {
    Object localObject = (List)paramb.LA.get(paramString);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if ((paramIBinder == localk.first) && (c.a(paramBundle, (Bundle)localk.second))) {
          return;
        }
      }
      ((List)localObject).add(new k(paramIBinder, paramBundle));
      paramb.LA.put(paramString, localObject);
      paramIBinder = new c(paramString) {};
      this.Ln = paramb;
      if (paramBundle != null) {
        paramIBinder.FL = 1;
      }
      this.Ln = null;
      if (!paramIBinder.isDone()) {
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + paramb.Lw + " id=" + paramString);
      }
      this.Ln = paramb;
      this.Ln = null;
      return;
    }
  }
  
  final boolean a(String paramString, b paramb, IBinder paramIBinder)
  {
    boolean bool = false;
    if (paramIBinder == null) {}
    try
    {
      paramString = paramb.LA.remove(paramString);
      if (paramString != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      List localList = (List)paramb.LA.get(paramString);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        bool = false;
        while (localIterator.hasNext()) {
          if (paramIBinder == ((k)localIterator.next()).first)
          {
            localIterator.remove();
            bool = true;
          }
        }
        if (localList.size() == 0) {
          paramb.LA.remove(paramString);
        }
      }
      return bool;
    }
    finally
    {
      this.Ln = paramb;
      this.Ln = null;
    }
  }
  
  public abstract a eI();
  
  public static final class a
  {
    final String KZ;
    final Bundle mExtras;
  }
  
  final class b
    implements IBinder.DeathRecipient
  {
    public final HashMap<String, List<k<IBinder, Bundle>>> LA = new HashMap();
    public MediaBrowserServiceCompat.a LB;
    public final String Lw;
    public final d.a Lx;
    public final Bundle Ly;
    public final MediaBrowserServiceCompat.e Lz;
    public final int pid;
    public final int uid;
    
    b(String paramString, int paramInt1, int paramInt2, Bundle paramBundle, MediaBrowserServiceCompat.e parame)
    {
      this.Lw = paramString;
      this.pid = paramInt1;
      this.uid = paramInt2;
      this.Lx = new d.a(paramString, paramInt1, paramInt2);
      this.Ly = paramBundle;
      this.Lz = parame;
    }
    
    public final void binderDied()
    {
      MediaBrowserServiceCompat.this.Lo.post(new Runnable()
      {
        public final void run()
        {
          MediaBrowserServiceCompat.this.Lm.remove(MediaBrowserServiceCompat.b.this.Lz.asBinder());
        }
      });
    }
  }
  
  public static class c<T>
  {
    int FL;
    final Object LD;
    private boolean LE;
    boolean LF;
    boolean LG;
    
    c(Object paramObject)
    {
      this.LD = paramObject;
    }
    
    void eK() {}
    
    void eL()
    {
      throw new UnsupportedOperationException("It is not supported to send an error for " + this.LD);
    }
    
    public final void eM()
    {
      if ((this.LF) || (this.LG)) {
        throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.LD);
      }
      this.LF = true;
      eK();
    }
    
    final boolean isDone()
    {
      return (this.LE) || (this.LF) || (this.LG);
    }
  }
  
  final class d
  {
    d() {}
  }
  
  static abstract interface e
  {
    public abstract void a(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
    
    public abstract void a(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2);
    
    public abstract IBinder asBinder();
    
    public abstract void eN();
  }
  
  static final class f
    implements MediaBrowserServiceCompat.e
  {
    final Messenger LQ;
    
    f(Messenger paramMessenger)
    {
      this.LQ = paramMessenger;
    }
    
    private void c(int paramInt, Bundle paramBundle)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 2;
      localMessage.setData(paramBundle);
      this.LQ.send(localMessage);
    }
    
    public final void a(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("extra_service_version", 2);
      paramBundle = new Bundle();
      paramBundle.putString("data_media_item_id", paramString);
      paramBundle.putParcelable("data_media_session_token", paramToken);
      paramBundle.putBundle("data_root_hints", localBundle);
      c(1, paramBundle);
    }
    
    public final void a(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      paramList = new Bundle();
      paramList.putString("data_media_item_id", paramString);
      paramList.putBundle("data_options", paramBundle1);
      paramList.putBundle("data_notify_children_changed_options", paramBundle2);
      c(3, paramList);
    }
    
    public final IBinder asBinder()
    {
      return this.LQ.getBinder();
    }
    
    public final void eN()
    {
      c(2, null);
    }
  }
  
  final class g
    extends Handler
  {
    private final MediaBrowserServiceCompat.d LR = new MediaBrowserServiceCompat.d(MediaBrowserServiceCompat.this);
    
    g() {}
    
    private void g(Runnable paramRunnable)
    {
      if (Thread.currentThread() == getLooper().getThread())
      {
        paramRunnable.run();
        return;
      }
      post(paramRunnable);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int k = 0;
      Object localObject1 = paramMessage.getData();
      switch (paramMessage.what)
      {
      default: 
        new StringBuilder("Unhandled message: ").append(paramMessage).append("\n  Service version: 2\n  Client version: ").append(paramMessage.arg1);
      }
      Object localObject2;
      Object localObject3;
      String str;
      do
      {
        do
        {
          do
          {
            return;
            localObject2 = ((Bundle)localObject1).getBundle("data_root_hints");
            MediaSessionCompat.d((Bundle)localObject2);
            localObject3 = this.LR;
            str = ((Bundle)localObject1).getString("data_package_name");
            int m = ((Bundle)localObject1).getInt("data_calling_pid");
            int n = ((Bundle)localObject1).getInt("data_calling_uid");
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
            localObject1 = ((MediaBrowserServiceCompat.d)localObject3).Lu;
            j = k;
            int i1;
            if (str != null)
            {
              localObject1 = ((MediaBrowserServiceCompat)localObject1).getPackageManager().getPackagesForUid(n);
              i1 = localObject1.length;
              i = 0;
            }
            for (;;)
            {
              j = k;
              if (i < i1)
              {
                if (localObject1[i].equals(str)) {
                  j = 1;
                }
              }
              else
              {
                if (j != 0) {
                  break;
                }
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + n + " package=" + str);
              }
              i += 1;
            }
            ((MediaBrowserServiceCompat.d)localObject3).Lu.Lo.g(new MediaBrowserServiceCompat.d.1((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, m, n, (Bundle)localObject2));
            return;
            localObject1 = this.LR;
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
            ((MediaBrowserServiceCompat.d)localObject1).Lu.Lo.g(new MediaBrowserServiceCompat.d.2((MediaBrowserServiceCompat.d)localObject1, paramMessage));
            return;
            localObject2 = ((Bundle)localObject1).getBundle("data_options");
            MediaSessionCompat.d((Bundle)localObject2);
            localObject3 = this.LR;
            str = ((Bundle)localObject1).getString("data_media_item_id");
            localObject1 = android.support.v4.app.c.b((Bundle)localObject1, "data_callback_token");
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
            ((MediaBrowserServiceCompat.d)localObject3).Lu.Lo.g(new MediaBrowserServiceCompat.d.3((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (IBinder)localObject1, (Bundle)localObject2));
            return;
            localObject2 = this.LR;
            localObject3 = ((Bundle)localObject1).getString("data_media_item_id");
            localObject1 = android.support.v4.app.c.b((Bundle)localObject1, "data_callback_token");
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
            ((MediaBrowserServiceCompat.d)localObject2).Lu.Lo.g(new MediaBrowserServiceCompat.d.4((MediaBrowserServiceCompat.d)localObject2, paramMessage, (String)localObject3, (IBinder)localObject1));
            return;
            localObject2 = this.LR;
            localObject3 = ((Bundle)localObject1).getString("data_media_item_id");
            localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
          } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (localObject1 == null));
          ((MediaBrowserServiceCompat.d)localObject2).Lu.Lo.g(new MediaBrowserServiceCompat.d.5((MediaBrowserServiceCompat.d)localObject2, paramMessage, (String)localObject3, (ResultReceiver)localObject1));
          return;
          localObject2 = ((Bundle)localObject1).getBundle("data_root_hints");
          MediaSessionCompat.d((Bundle)localObject2);
          localObject3 = this.LR;
          paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
          str = ((Bundle)localObject1).getString("data_package_name");
          int i = ((Bundle)localObject1).getInt("data_calling_pid");
          int j = ((Bundle)localObject1).getInt("data_calling_uid");
          ((MediaBrowserServiceCompat.d)localObject3).Lu.Lo.g(new MediaBrowserServiceCompat.d.6((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, i, j, (Bundle)localObject2));
          return;
          localObject1 = this.LR;
          paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
          ((MediaBrowserServiceCompat.d)localObject1).Lu.Lo.g(new MediaBrowserServiceCompat.d.7((MediaBrowserServiceCompat.d)localObject1, paramMessage));
          return;
          localObject2 = ((Bundle)localObject1).getBundle("data_search_extras");
          MediaSessionCompat.d((Bundle)localObject2);
          localObject3 = this.LR;
          str = ((Bundle)localObject1).getString("data_search_query");
          localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
          paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        } while ((TextUtils.isEmpty(str)) || (localObject1 == null));
        ((MediaBrowserServiceCompat.d)localObject3).Lu.Lo.g(new MediaBrowserServiceCompat.d.8((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
        return;
        localObject2 = ((Bundle)localObject1).getBundle("data_custom_action_extras");
        MediaSessionCompat.d((Bundle)localObject2);
        localObject3 = this.LR;
        str = ((Bundle)localObject1).getString("data_custom_action");
        localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
      } while ((TextUtils.isEmpty(str)) || (localObject1 == null));
      ((MediaBrowserServiceCompat.d)localObject3).Lu.Lo.g(new MediaBrowserServiceCompat.d.9((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
    }
    
    public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      localBundle.putInt("data_calling_pid", Binder.getCallingPid());
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat
 * JD-Core Version:    0.7.0.1
 */