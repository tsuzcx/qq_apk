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
import androidx.b.a;
import androidx.core.app.b;
import androidx.core.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat
  extends Service
{
  static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
  final a<IBinder, b> abO = new a();
  b abP;
  final g abQ = new g();
  MediaSessionCompat.Token abR;
  
  static List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
  {
    return null;
  }
  
  final void a(final String paramString, final b paramb, IBinder paramIBinder, final Bundle paramBundle)
  {
    Object localObject = (List)paramb.acc.get(paramString);
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if ((paramIBinder == locale.Mx) && (d.a(paramBundle, (Bundle)locale.My))) {
          return;
        }
      }
      ((List)localObject).add(new e(paramIBinder, paramBundle));
      paramb.acc.put(paramString, localObject);
      paramIBinder = new c(paramString) {};
      this.abP = paramb;
      if (paramBundle != null) {
        paramIBinder.cN = 1;
      }
      this.abP = null;
      if (!paramIBinder.isDone()) {
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + paramb.abY + " id=" + paramString);
      }
      this.abP = paramb;
      this.abP = null;
      return;
    }
  }
  
  final boolean a(String paramString, b paramb, IBinder paramIBinder)
  {
    boolean bool = false;
    if (paramIBinder == null) {}
    try
    {
      paramString = paramb.acc.remove(paramString);
      if (paramString != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      List localList = (List)paramb.acc.get(paramString);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        bool = false;
        while (localIterator.hasNext()) {
          if (paramIBinder == ((e)localIterator.next()).Mx)
          {
            localIterator.remove();
            bool = true;
          }
        }
        if (localList.size() == 0) {
          paramb.acc.remove(paramString);
        }
      }
      return bool;
    }
    finally
    {
      this.abP = paramb;
      this.abP = null;
    }
  }
  
  public abstract a jr();
  
  public static final class a {}
  
  final class b
    implements IBinder.DeathRecipient
  {
    public final String abY;
    public final e.a abZ;
    public final Bundle aca;
    public final MediaBrowserServiceCompat.e acb;
    public final HashMap<String, List<e<IBinder, Bundle>>> acc;
    public MediaBrowserServiceCompat.a acd;
    public final int pid;
    public final int uid;
    
    b(String paramString, int paramInt1, int paramInt2, Bundle paramBundle, MediaBrowserServiceCompat.e parame)
    {
      AppMethodBeat.i(242755);
      this.acc = new HashMap();
      this.abY = paramString;
      this.pid = paramInt1;
      this.uid = paramInt2;
      this.abZ = new e.a(paramString, paramInt1, paramInt2);
      this.aca = paramBundle;
      this.acb = parame;
      AppMethodBeat.o(242755);
    }
    
    public final void binderDied()
    {
      AppMethodBeat.i(242757);
      MediaBrowserServiceCompat.this.abQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(242754);
          MediaBrowserServiceCompat.this.abO.remove(MediaBrowserServiceCompat.b.this.acb.asBinder());
          AppMethodBeat.o(242754);
        }
      });
      AppMethodBeat.o(242757);
    }
  }
  
  public static class c<T>
  {
    final Object acf;
    private boolean acg;
    boolean ach;
    boolean aci;
    int cN;
    
    c(Object paramObject)
    {
      this.acf = paramObject;
    }
    
    final boolean isDone()
    {
      return (this.acg) || (this.ach) || (this.aci);
    }
    
    void js() {}
    
    void jt()
    {
      AppMethodBeat.i(242762);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("It is not supported to send an error for " + this.acf);
      AppMethodBeat.o(242762);
      throw localUnsupportedOperationException;
    }
    
    public final void ju()
    {
      AppMethodBeat.i(242761);
      if ((this.ach) || (this.aci))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.acf);
        AppMethodBeat.o(242761);
        throw localIllegalStateException;
      }
      this.ach = true;
      js();
      AppMethodBeat.o(242761);
    }
  }
  
  final class d
  {
    d() {}
  }
  
  static abstract interface e
  {
    public abstract void a(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2);
    
    public abstract IBinder asBinder();
    
    public abstract void jv();
  }
  
  static final class f
    implements MediaBrowserServiceCompat.e
  {
    final Messenger acs;
    
    f(Messenger paramMessenger)
    {
      this.acs = paramMessenger;
    }
    
    private void d(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(242806);
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 2;
      localMessage.setData(paramBundle);
      this.acs.send(localMessage);
      AppMethodBeat.o(242806);
    }
    
    public final void a(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      AppMethodBeat.i(242805);
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
        AppMethodBeat.o(242805);
        return;
      }
    }
    
    public final IBinder asBinder()
    {
      AppMethodBeat.i(242803);
      IBinder localIBinder = this.acs.getBinder();
      AppMethodBeat.o(242803);
      return localIBinder;
    }
    
    public final void jv()
    {
      AppMethodBeat.i(242804);
      d(2, null);
      AppMethodBeat.o(242804);
    }
  }
  
  final class g
    extends Handler
  {
    private final MediaBrowserServiceCompat.d act;
    
    g()
    {
      AppMethodBeat.i(242807);
      this.act = new MediaBrowserServiceCompat.d(MediaBrowserServiceCompat.this);
      AppMethodBeat.o(242807);
    }
    
    private void e(Runnable paramRunnable)
    {
      AppMethodBeat.i(242813);
      if (Thread.currentThread() == getLooper().getThread())
      {
        paramRunnable.run();
        AppMethodBeat.o(242813);
        return;
      }
      post(paramRunnable);
      AppMethodBeat.o(242813);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int k = 0;
      AppMethodBeat.i(242810);
      Object localObject1 = paramMessage.getData();
      int j;
      int i;
      switch (paramMessage.what)
      {
      default: 
        new StringBuilder("Unhandled message: ").append(paramMessage).append("\n  Service version: 2\n  Client version: ").append(paramMessage.arg1);
        AppMethodBeat.o(242810);
        return;
      case 1: 
        localObject2 = ((Bundle)localObject1).getBundle("data_root_hints");
        MediaSessionCompat.d((Bundle)localObject2);
        localObject3 = this.act;
        str = ((Bundle)localObject1).getString("data_package_name");
        int m = ((Bundle)localObject1).getInt("data_calling_pid");
        int n = ((Bundle)localObject1).getInt("data_calling_uid");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        localObject1 = ((MediaBrowserServiceCompat.d)localObject3).abW;
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
            AppMethodBeat.o(242810);
            throw paramMessage;
          }
          i += 1;
        }
        ((MediaBrowserServiceCompat.d)localObject3).abW.abQ.e(new MediaBrowserServiceCompat.d.1((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, m, n, (Bundle)localObject2));
        AppMethodBeat.o(242810);
        return;
      case 2: 
        localObject1 = this.act;
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        ((MediaBrowserServiceCompat.d)localObject1).abW.abQ.e(new MediaBrowserServiceCompat.d.2((MediaBrowserServiceCompat.d)localObject1, paramMessage));
        AppMethodBeat.o(242810);
        return;
      case 3: 
        localObject2 = ((Bundle)localObject1).getBundle("data_options");
        MediaSessionCompat.d((Bundle)localObject2);
        localObject3 = this.act;
        str = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = b.b((Bundle)localObject1, "data_callback_token");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        ((MediaBrowserServiceCompat.d)localObject3).abW.abQ.e(new MediaBrowserServiceCompat.d.3((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (IBinder)localObject1, (Bundle)localObject2));
        AppMethodBeat.o(242810);
        return;
      case 4: 
        localObject2 = this.act;
        localObject3 = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = b.b((Bundle)localObject1, "data_callback_token");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        ((MediaBrowserServiceCompat.d)localObject2).abW.abQ.e(new MediaBrowserServiceCompat.d.4((MediaBrowserServiceCompat.d)localObject2, paramMessage, (String)localObject3, (IBinder)localObject1));
        AppMethodBeat.o(242810);
        return;
      case 5: 
        localObject2 = this.act;
        localObject3 = ((Bundle)localObject1).getString("data_media_item_id");
        localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (localObject1 == null))
        {
          AppMethodBeat.o(242810);
          return;
        }
        ((MediaBrowserServiceCompat.d)localObject2).abW.abQ.e(new MediaBrowserServiceCompat.d.5((MediaBrowserServiceCompat.d)localObject2, paramMessage, (String)localObject3, (ResultReceiver)localObject1));
        AppMethodBeat.o(242810);
        return;
      case 6: 
        localObject2 = ((Bundle)localObject1).getBundle("data_root_hints");
        MediaSessionCompat.d((Bundle)localObject2);
        localObject3 = this.act;
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        str = ((Bundle)localObject1).getString("data_package_name");
        i = ((Bundle)localObject1).getInt("data_calling_pid");
        j = ((Bundle)localObject1).getInt("data_calling_uid");
        ((MediaBrowserServiceCompat.d)localObject3).abW.abQ.e(new MediaBrowserServiceCompat.d.6((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, i, j, (Bundle)localObject2));
        AppMethodBeat.o(242810);
        return;
      case 7: 
        localObject1 = this.act;
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        ((MediaBrowserServiceCompat.d)localObject1).abW.abQ.e(new MediaBrowserServiceCompat.d.7((MediaBrowserServiceCompat.d)localObject1, paramMessage));
        AppMethodBeat.o(242810);
        return;
      case 8: 
        localObject2 = ((Bundle)localObject1).getBundle("data_search_extras");
        MediaSessionCompat.d((Bundle)localObject2);
        localObject3 = this.act;
        str = ((Bundle)localObject1).getString("data_search_query");
        localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
        paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
        if ((TextUtils.isEmpty(str)) || (localObject1 == null))
        {
          AppMethodBeat.o(242810);
          return;
        }
        ((MediaBrowserServiceCompat.d)localObject3).abW.abQ.e(new MediaBrowserServiceCompat.d.8((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
        AppMethodBeat.o(242810);
        return;
      }
      Object localObject2 = ((Bundle)localObject1).getBundle("data_custom_action_extras");
      MediaSessionCompat.d((Bundle)localObject2);
      Object localObject3 = this.act;
      String str = ((Bundle)localObject1).getString("data_custom_action");
      localObject1 = (ResultReceiver)((Bundle)localObject1).getParcelable("data_result_receiver");
      paramMessage = new MediaBrowserServiceCompat.f(paramMessage.replyTo);
      if ((TextUtils.isEmpty(str)) || (localObject1 == null))
      {
        AppMethodBeat.o(242810);
        return;
      }
      ((MediaBrowserServiceCompat.d)localObject3).abW.abQ.e(new MediaBrowserServiceCompat.d.9((MediaBrowserServiceCompat.d)localObject3, paramMessage, str, (Bundle)localObject2, (ResultReceiver)localObject1));
      AppMethodBeat.o(242810);
    }
    
    public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      AppMethodBeat.i(242812);
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      localBundle.putInt("data_calling_pid", Binder.getCallingPid());
      boolean bool = super.sendMessageAtTime(paramMessage, paramLong);
      AppMethodBeat.o(242812);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.MediaBrowserServiceCompat
 * JD-Core Version:    0.7.0.1
 */