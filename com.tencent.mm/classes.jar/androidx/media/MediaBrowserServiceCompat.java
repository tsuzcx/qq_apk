package androidx.media;

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
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.c;
import androidx.core.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
  MediaSessionCompat.Token bJA;
  final androidx.b.a<IBinder, b> bJx = new androidx.b.a();
  b bJy;
  final g bJz = new g();
  
  static List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
  {
    return null;
  }
  
  public abstract a Hv();
  
  final void a(final String paramString, final b paramb, IBinder paramIBinder, final Bundle paramBundle)
  {
    Object localObject = (List)paramb.bJL.get(paramString);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if ((paramIBinder == locald.bsC) && (a.b(paramBundle, (Bundle)locald.bsD))) {
          return;
        }
      }
      ((List)localObject).add(new d(paramIBinder, paramBundle));
      paramb.bJL.put(paramString, localObject);
      paramIBinder = new c(paramString) {};
      this.bJy = paramb;
      if (paramBundle != null) {
        paramIBinder.cN = 1;
      }
      this.bJy = null;
      if (!paramIBinder.isDone()) {
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + paramb.bJH + " id=" + paramString);
      }
      this.bJy = paramb;
      this.bJy = null;
      return;
    }
  }
  
  final boolean a(String paramString, b paramb, IBinder paramIBinder)
  {
    boolean bool = false;
    if (paramIBinder == null) {}
    try
    {
      paramString = paramb.bJL.remove(paramString);
      if (paramString != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      List localList = (List)paramb.bJL.get(paramString);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        bool = false;
        while (localIterator.hasNext()) {
          if (paramIBinder == ((d)localIterator.next()).bsC)
          {
            localIterator.remove();
            bool = true;
          }
        }
        if (localList.size() == 0) {
          paramb.bJL.remove(paramString);
        }
      }
      return bool;
    }
    finally
    {
      this.bJy = paramb;
      this.bJy = null;
    }
  }
  
  public static final class a {}
  
  final class b
    implements IBinder.DeathRecipient
  {
    public final String bJH;
    public final b.a bJI;
    public final Bundle bJJ;
    public final MediaBrowserServiceCompat.e bJK;
    public final HashMap<String, List<d<IBinder, Bundle>>> bJL;
    public MediaBrowserServiceCompat.a bJM;
    public final int pid;
    public final int uid;
    
    b(String paramString, int paramInt1, int paramInt2, Bundle paramBundle, MediaBrowserServiceCompat.e parame)
    {
      AppMethodBeat.i(193090);
      this.bJL = new HashMap();
      this.bJH = paramString;
      this.pid = paramInt1;
      this.uid = paramInt2;
      this.bJI = new b.a(paramString, paramInt1, paramInt2);
      this.bJJ = paramBundle;
      this.bJK = parame;
      AppMethodBeat.o(193090);
    }
    
    public final void binderDied()
    {
      AppMethodBeat.i(193099);
      MediaBrowserServiceCompat.this.bJz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193025);
          MediaBrowserServiceCompat.this.bJx.remove(MediaBrowserServiceCompat.b.this.bJK.asBinder());
          AppMethodBeat.o(193025);
        }
      });
      AppMethodBeat.o(193099);
    }
  }
  
  public static class c<T>
  {
    final Object bJO;
    private boolean bJP;
    boolean bJQ;
    boolean bJR;
    int cN;
    
    c(Object paramObject)
    {
      this.bJO = paramObject;
    }
    
    void Hw() {}
    
    void Hx()
    {
      AppMethodBeat.i(193110);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("It is not supported to send an error for " + this.bJO);
      AppMethodBeat.o(193110);
      throw localUnsupportedOperationException;
    }
    
    public final void Hy()
    {
      AppMethodBeat.i(193092);
      if ((this.bJQ) || (this.bJR))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.bJO);
        AppMethodBeat.o(193092);
        throw localIllegalStateException;
      }
      this.bJQ = true;
      Hw();
      AppMethodBeat.o(193092);
    }
    
    final boolean isDone()
    {
      return (this.bJP) || (this.bJQ) || (this.bJR);
    }
  }
  
  final class d
  {
    d() {}
  }
  
  static abstract interface e
  {
    public abstract void Hz();
    
    public abstract void a(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2);
    
    public abstract IBinder asBinder();
  }
  
  static final class f
    implements MediaBrowserServiceCompat.e
  {
    final Messenger bKb;
    
    f(Messenger paramMessenger)
    {
      this.bKb = paramMessenger;
    }
    
    private void d(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(193101);
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 2;
      localMessage.setData(paramBundle);
      this.bKb.send(localMessage);
      AppMethodBeat.o(193101);
    }
    
    public final void Hz()
    {
      AppMethodBeat.i(193112);
      d(2, null);
      AppMethodBeat.o(193112);
    }
    
    public final void a(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      AppMethodBeat.i(193119);
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putBundle("data_options", paramBundle1);
      localBundle.putBundle("data_notify_children_changed_options", paramBundle2);
      if (paramList != null) {
        if (!(paramList instanceof ArrayList)) {
          break label76;
        }
      }
      label76:
      for (paramString = (ArrayList)paramList;; paramString = new ArrayList(paramList))
      {
        localBundle.putParcelableArrayList("data_media_item_list", paramString);
        d(3, localBundle);
        AppMethodBeat.o(193119);
        return;
      }
    }
    
    public final IBinder asBinder()
    {
      AppMethodBeat.i(193107);
      IBinder localIBinder = this.bKb.getBinder();
      AppMethodBeat.o(193107);
      return localIBinder;
    }
  }
  
  final class g
    extends Handler
  {
    private final MediaBrowserServiceCompat.d bKc;
    
    g()
    {
      AppMethodBeat.i(193100);
      this.bKc = new MediaBrowserServiceCompat.d(MediaBrowserServiceCompat.this);
      AppMethodBeat.o(193100);
    }
    
    private void e(Runnable paramRunnable)
    {
      AppMethodBeat.i(193108);
      if (Thread.currentThread() == getLooper().getThread())
      {
        paramRunnable.run();
        AppMethodBeat.o(193108);
        return;
      }
      post(paramRunnable);
      AppMethodBeat.o(193108);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int k = 0;
      AppMethodBeat.i(193122);
      Object localObject1 = paramMessage.getData();
      int j;
      int i;
      switch (paramMessage.what)
      {
      default: 
        new StringBuilder("Unhandled message: ").append(paramMessage).append("\n  Service version: 2\n  Client version: ").append(paramMessage.arg1);
        AppMethodBeat.o(193122);
        return;
      case 1: 
        localObject2 = ((Bundle)localObject1).getBundle("data_root_hints");
        MediaSessionCompat.e((Bundle)localObject2);
        localObject3 = this.bKc;
        str = ((Bundle)localObject1).getString("data_package_name");
        int m = ((Bundle)localObject1).getInt("data_calling_pid");
        int n = ((Bundle)localObject1).getInt("data_calling_uid");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        localObject1 = ((MediaBrowserServiceCompat.d)localObject3).bJF;
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
            paramMessage = new IllegalArgumentException("Package/uid mismatch: uid=" + n + " package=" + str);
            AppMethodBeat.o(193122);
            throw paramMessage;
          }
          i += 1;
        }
        ((MediaBrowserServiceCompat.d)localObject3).bJF.bJz.e(new MediaBrowserServiceCompat.d.1((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, m, n, (Bundle)localObject2));
        AppMethodBeat.o(193122);
        return;
      case 2: 
        localObject1 = this.bKc;
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        ((MediaBrowserServiceCompat.d)localObject1).bJF.bJz.e(new MediaBrowserServiceCompat.d.2((MediaBrowserServiceCompat.d)localObject1, paramMessage));
        AppMethodBeat.o(193122);
        return;
      case 3: 
        localObject2 = ((Bundle)localObject1).getBundle("data_options");
        MediaSessionCompat.e((Bundle)localObject2);
        localObject3 = this.bKc;
        str = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = c.b((Bundle)localObject1, "data_callback_token");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        ((MediaBrowserServiceCompat.d)localObject3).bJF.bJz.e(new MediaBrowserServiceCompat.d.3((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (IBinder)localObject1, (Bundle)localObject2));
        AppMethodBeat.o(193122);
        return;
      case 4: 
        localObject2 = this.bKc;
        localObject3 = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = c.b((Bundle)localObject1, "data_callback_token");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        ((MediaBrowserServiceCompat.d)localObject2).bJF.bJz.e(new MediaBrowserServiceCompat.d.4((MediaBrowserServiceCompat.d)localObject2, paramMessage, (String)localObject3, (IBinder)localObject1));
        AppMethodBeat.o(193122);
        return;
      case 5: 
        localObject2 = this.bKc;
        localObject3 = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (localObject1 == null))
        {
          AppMethodBeat.o(193122);
          return;
        }
        ((MediaBrowserServiceCompat.d)localObject2).bJF.bJz.e(new MediaBrowserServiceCompat.d.5((MediaBrowserServiceCompat.d)localObject2, paramMessage, (String)localObject3, (ResultReceiver)localObject1));
        AppMethodBeat.o(193122);
        return;
      case 6: 
        localObject2 = ((Bundle)localObject1).getBundle("data_root_hints");
        MediaSessionCompat.e((Bundle)localObject2);
        localObject3 = this.bKc;
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        str = ((Bundle)localObject1).getString("data_package_name");
        i = ((Bundle)localObject1).getInt("data_calling_pid");
        j = ((Bundle)localObject1).getInt("data_calling_uid");
        ((MediaBrowserServiceCompat.d)localObject3).bJF.bJz.e(new MediaBrowserServiceCompat.d.6((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, i, j, (Bundle)localObject2));
        AppMethodBeat.o(193122);
        return;
      case 7: 
        localObject1 = this.bKc;
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        ((MediaBrowserServiceCompat.d)localObject1).bJF.bJz.e(new MediaBrowserServiceCompat.d.7((MediaBrowserServiceCompat.d)localObject1, paramMessage));
        AppMethodBeat.o(193122);
        return;
      case 8: 
        localObject2 = ((Bundle)localObject1).getBundle("data_search_extras");
        MediaSessionCompat.e((Bundle)localObject2);
        localObject3 = this.bKc;
        str = ((Bundle)localObject1).getString("data_search_query");
        localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        if ((TextUtils.isEmpty(str)) || (localObject1 == null))
        {
          AppMethodBeat.o(193122);
          return;
        }
        ((MediaBrowserServiceCompat.d)localObject3).bJF.bJz.e(new MediaBrowserServiceCompat.d.8((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
        AppMethodBeat.o(193122);
        return;
      }
      Object localObject2 = ((Bundle)localObject1).getBundle("data_custom_action_extras");
      MediaSessionCompat.e((Bundle)localObject2);
      Object localObject3 = this.bKc;
      String str = ((Bundle)localObject1).getString("data_custom_action");
      localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
      paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
      if ((TextUtils.isEmpty(str)) || (localObject1 == null))
      {
        AppMethodBeat.o(193122);
        return;
      }
      ((MediaBrowserServiceCompat.d)localObject3).bJF.bJz.e(new MediaBrowserServiceCompat.d.9((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
      AppMethodBeat.o(193122);
    }
    
    public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      AppMethodBeat.i(193130);
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      localBundle.putInt("data_calling_pid", Binder.getCallingPid());
      boolean bool = super.sendMessageAtTime(paramMessage, paramLong);
      AppMethodBeat.o(193130);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.media.MediaBrowserServiceCompat
 * JD-Core Version:    0.7.0.1
 */