package android.support.v4.media;

import android.app.Service;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.e;
import android.support.v4.f.a;
import android.support.v4.f.j;
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
  final a<IBinder, MediaBrowserServiceCompat.b> Bg = new a();
  MediaBrowserServiceCompat.b Bh;
  final g Bi = new g();
  MediaSessionCompat.Token Bj;
  
  static boolean a(String paramString, MediaBrowserServiceCompat.b paramb, IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return paramb.Bs.remove(paramString) != null;
    }
    List localList = (List)paramb.Bs.get(paramString);
    boolean bool1;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      bool1 = false;
      while (localIterator.hasNext()) {
        if (paramIBinder == ((j)localIterator.next()).first)
        {
          localIterator.remove();
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (localList.size() == 0) {
        paramb.Bs.remove(paramString);
      }
    }
    for (boolean bool2 = bool1;; bool2 = false) {
      return bool2;
    }
  }
  
  static List<MediaBrowserCompat.MediaItem> cz()
  {
    return null;
  }
  
  final void a(String paramString, MediaBrowserServiceCompat.b paramb, IBinder paramIBinder, Bundle paramBundle)
  {
    Object localObject = (List)paramb.Bs.get(paramString);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject).iterator();
      j localj;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localj = (j)localIterator.next();
      } while ((paramIBinder != localj.first) || (!c.a(paramBundle, (Bundle)localj.second)));
      do
      {
        return;
        ((List)localObject).add(new j(paramIBinder, paramBundle));
        paramb.Bs.put(paramString, localObject);
        paramIBinder = new MediaBrowserServiceCompat.1(this, paramString, paramb, paramString, paramBundle);
        this.Bh = paramb;
        if (paramBundle != null) {
          paramIBinder.wg = 1;
        }
        this.Bh = null;
      } while (paramIBinder.isDone());
      throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + paramb.Bo + " id=" + paramString);
    }
  }
  
  public abstract MediaBrowserServiceCompat.a cy();
  
  private final class g
    extends Handler
  {
    private final MediaBrowserServiceCompat.d BK = new MediaBrowserServiceCompat.d(MediaBrowserServiceCompat.this);
    
    g() {}
    
    private void e(Runnable paramRunnable)
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
      MediaBrowserServiceCompat.d locald;
      String str;
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return;
            locald = this.BK;
            str = ((Bundle)localObject1).getString("data_package_name");
            int m = ((Bundle)localObject1).getInt("data_calling_uid");
            localObject1 = ((Bundle)localObject1).getBundle("data_root_hints");
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
            localObject2 = locald.Bm;
            int j = k;
            int n;
            int i;
            if (str != null)
            {
              localObject2 = ((MediaBrowserServiceCompat)localObject2).getPackageManager().getPackagesForUid(m);
              n = localObject2.length;
              i = 0;
            }
            for (;;)
            {
              j = k;
              if (i < n)
              {
                if (localObject2[i].equals(str)) {
                  j = 1;
                }
              }
              else
              {
                if (j != 0) {
                  break;
                }
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + m + " package=" + str);
              }
              i += 1;
            }
            locald.Bm.Bi.e(new MediaBrowserServiceCompat.d.1(locald, paramMessage, str, (Bundle)localObject1, m));
            return;
            localObject1 = this.BK;
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
            ((MediaBrowserServiceCompat.d)localObject1).Bm.Bi.e(new MediaBrowserServiceCompat.d.2((MediaBrowserServiceCompat.d)localObject1, paramMessage));
            return;
            locald = this.BK;
            str = ((Bundle)localObject1).getString("data_media_item_id");
            localObject2 = e.c((Bundle)localObject1, "data_callback_token");
            localObject1 = ((Bundle)localObject1).getBundle("data_options");
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
            locald.Bm.Bi.e(new MediaBrowserServiceCompat.d.3(locald, paramMessage, str, (IBinder)localObject2, (Bundle)localObject1));
            return;
            locald = this.BK;
            str = ((Bundle)localObject1).getString("data_media_item_id");
            localObject1 = e.c((Bundle)localObject1, "data_callback_token");
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
            locald.Bm.Bi.e(new MediaBrowserServiceCompat.d.4(locald, paramMessage, str, (IBinder)localObject1));
            return;
            locald = this.BK;
            str = ((Bundle)localObject1).getString("data_media_item_id");
            localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
            paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
          } while ((TextUtils.isEmpty(str)) || (localObject1 == null));
          locald.Bm.Bi.e(new MediaBrowserServiceCompat.d.5(locald, paramMessage, str, (ResultReceiver)localObject1));
          return;
          locald = this.BK;
          paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
          localObject1 = ((Bundle)localObject1).getBundle("data_root_hints");
          locald.Bm.Bi.e(new MediaBrowserServiceCompat.d.6(locald, paramMessage, (Bundle)localObject1));
          return;
          localObject1 = this.BK;
          paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
          ((MediaBrowserServiceCompat.d)localObject1).Bm.Bi.e(new MediaBrowserServiceCompat.d.7((MediaBrowserServiceCompat.d)localObject1, paramMessage));
          return;
          locald = this.BK;
          str = ((Bundle)localObject1).getString("data_search_query");
          localObject2 = ((Bundle)localObject1).getBundle("data_search_extras");
          localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
          paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        } while ((TextUtils.isEmpty(str)) || (localObject1 == null));
        locald.Bm.Bi.e(new MediaBrowserServiceCompat.d.8(locald, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
        return;
        locald = this.BK;
        str = ((Bundle)localObject1).getString("data_custom_action");
        localObject2 = ((Bundle)localObject1).getBundle("data_custom_action_extras");
        localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
      } while ((TextUtils.isEmpty(str)) || (localObject1 == null));
      locald.Bm.Bi.e(new MediaBrowserServiceCompat.d.9(locald, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
    }
    
    public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat
 * JD-Core Version:    0.7.0.1
 */