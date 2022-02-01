package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.c;
import android.support.v4.media.MediaMetadataCompat;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class MediaControllerCompat
{
  final b Mm;
  private final MediaSessionCompat.Token Mn;
  private final HashSet<a> Mo = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    this.Mn = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.Mm = new d(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.Mm = new c(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.Mm = new MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    this.Mm = new e(paramToken);
  }
  
  static class MediaControllerImplApi21
    implements MediaControllerCompat.b
  {
    protected final Object Mu;
    final List<MediaControllerCompat.a> Mv = new ArrayList();
    HashMap<MediaControllerCompat.a, a> Mw = new HashMap();
    final MediaSessionCompat.Token Mx;
    final Object mLock = new Object();
    
    public MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      this.Mx = paramToken;
      this.Mu = new MediaController(paramContext, (MediaSession.Token)this.Mx.ML);
      if (this.Mu == null) {
        throw new RemoteException();
      }
      if (this.Mx.MM == null)
      {
        paramContext = new ExtraBinderRequestResultReceiver(this);
        ((MediaController)this.Mu).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
      }
    }
    
    public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      return ((MediaController)this.Mu).dispatchMediaButtonEvent(paramKeyEvent);
    }
    
    static class ExtraBinderRequestResultReceiver
      extends ResultReceiver
    {
      private WeakReference<MediaControllerCompat.MediaControllerImplApi21> My;
      
      ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21)
      {
        super();
        this.My = new WeakReference(paramMediaControllerImplApi21);
      }
      
      protected void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.My.get();
        if ((localMediaControllerImplApi21 == null) || (paramBundle == null)) {
          return;
        }
        MediaControllerCompat.a locala;
        MediaControllerCompat.MediaControllerImplApi21.a locala1;
        synchronized (localMediaControllerImplApi21.mLock)
        {
          localMediaControllerImplApi21.Mx.MM = b.a.d(c.b(paramBundle, "android.support.v4.media.session.EXTRA_BINDER"));
          localMediaControllerImplApi21.Mx.MN = paramBundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
          if (localMediaControllerImplApi21.Mx.MM == null) {
            break label177;
          }
          paramBundle = localMediaControllerImplApi21.Mv.iterator();
          if (paramBundle.hasNext())
          {
            locala = (MediaControllerCompat.a)paramBundle.next();
            locala1 = new MediaControllerCompat.MediaControllerImplApi21.a(locala);
            localMediaControllerImplApi21.Mw.put(locala, locala1);
            locala.Mr = locala1;
          }
        }
        localMediaControllerImplApi21.Mv.clear();
        label177:
      }
    }
    
    static final class a
      extends MediaControllerCompat.a.c
    {
      a(MediaControllerCompat.a parama)
      {
        super();
      }
      
      public final void a(MediaMetadataCompat paramMediaMetadataCompat)
      {
        throw new AssertionError();
      }
      
      public final void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
      {
        throw new AssertionError();
      }
      
      public final void onExtrasChanged(Bundle paramBundle)
      {
        throw new AssertionError();
      }
      
      public final void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
      {
        throw new AssertionError();
      }
      
      public final void onQueueTitleChanged(CharSequence paramCharSequence)
      {
        throw new AssertionError();
      }
      
      public final void onSessionDestroyed()
      {
        throw new AssertionError();
      }
    }
  }
  
  public static abstract class a
    implements IBinder.DeathRecipient
  {
    final Object Mp;
    a Mq;
    a Mr;
    
    public a()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.Mp = new c.b(new b(this));
        return;
      }
      c localc = new c(this);
      this.Mr = localc;
      this.Mp = localc;
    }
    
    final void a(int paramInt, Object paramObject, Bundle paramBundle)
    {
      if (this.Mq != null)
      {
        paramObject = this.Mq.obtainMessage(paramInt, paramObject);
        paramObject.setData(paramBundle);
        paramObject.sendToTarget();
      }
    }
    
    final class a
      extends Handler
    {
      boolean Ms;
      
      public final void handleMessage(Message paramMessage)
      {
        if (!this.Ms) {
          return;
        }
        switch (paramMessage.what)
        {
        case 8: 
        case 10: 
        default: 
          return;
        case 1: 
          MediaSessionCompat.d(paramMessage.getData());
          paramMessage = paramMessage.obj;
          return;
        case 2: 
          paramMessage = paramMessage.obj;
          return;
        case 3: 
          paramMessage = paramMessage.obj;
          return;
        case 5: 
          paramMessage = paramMessage.obj;
          return;
        case 6: 
          paramMessage = paramMessage.obj;
          return;
        case 11: 
          ((Boolean)paramMessage.obj).booleanValue();
          return;
        case 9: 
          ((Integer)paramMessage.obj).intValue();
          return;
        case 12: 
          ((Integer)paramMessage.obj).intValue();
          return;
        case 7: 
          MediaSessionCompat.d((Bundle)paramMessage.obj);
          return;
        }
        paramMessage = paramMessage.obj;
      }
    }
    
    static final class b
      implements c.a
    {
      private final WeakReference<MediaControllerCompat.a> Mt;
      
      b(MediaControllerCompat.a parama)
      {
        this.Mt = new WeakReference(parama);
      }
      
      public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        if ((MediaControllerCompat.a)this.Mt.get() != null) {
          new MediaControllerCompat.f(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        }
      }
      
      public final void eY()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if ((locala != null) && (locala.Mr != null)) {
          int i = Build.VERSION.SDK_INT;
        }
      }
      
      public final void eZ()
      {
        this.Mt.get();
      }
      
      public final void fa()
      {
        this.Mt.get();
      }
      
      public final void onQueueChanged(List<?> paramList)
      {
        if ((MediaControllerCompat.a)this.Mt.get() != null) {
          MediaSessionCompat.QueueItem.l(paramList);
        }
      }
      
      public final void onSessionDestroyed()
      {
        this.Mt.get();
      }
      
      public final void x(Object paramObject)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if ((locala != null) && (locala.Mr == null)) {
          PlaybackStateCompat.B(paramObject);
        }
      }
      
      public final void y(Object paramObject)
      {
        if ((MediaControllerCompat.a)this.Mt.get() != null) {
          MediaMetadataCompat.w(paramObject);
        }
      }
    }
    
    static class c
      extends a.a
    {
      private final WeakReference<MediaControllerCompat.a> Mt;
      
      c(MediaControllerCompat.a parama)
      {
        this.Mt = new WeakReference(parama);
      }
      
      public final void G(boolean paramBoolean) {}
      
      public final void H(boolean paramBoolean)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(11, Boolean.valueOf(paramBoolean), null);
        }
      }
      
      public void a(MediaMetadataCompat paramMediaMetadataCompat)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(3, paramMediaMetadataCompat, null);
        }
      }
      
      public void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          if (paramParcelableVolumeInfo == null) {
            break label55;
          }
        }
        label55:
        for (paramParcelableVolumeInfo = new MediaControllerCompat.f(paramParcelableVolumeInfo.MO, paramParcelableVolumeInfo.MP, paramParcelableVolumeInfo.MQ, paramParcelableVolumeInfo.MR, paramParcelableVolumeInfo.MS);; paramParcelableVolumeInfo = null)
        {
          locala.a(4, paramParcelableVolumeInfo, null);
          return;
        }
      }
      
      public final void a(PlaybackStateCompat paramPlaybackStateCompat)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(2, paramPlaybackStateCompat, null);
        }
      }
      
      public final void aA(int paramInt)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(9, Integer.valueOf(paramInt), null);
        }
      }
      
      public final void aB(int paramInt)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(12, Integer.valueOf(paramInt), null);
        }
      }
      
      public final void d(String paramString, Bundle paramBundle)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(1, paramString, paramBundle);
        }
      }
      
      public final void eO()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(13, null, null);
        }
      }
      
      public void onExtrasChanged(Bundle paramBundle)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(7, paramBundle, null);
        }
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(5, paramList, null);
        }
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(6, paramCharSequence, null);
        }
      }
      
      public void onSessionDestroyed()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.Mt.get();
        if (locala != null) {
          locala.a(8, null, null);
        }
      }
    }
  }
  
  static abstract interface b
  {
    public abstract boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent);
  }
  
  static class c
    extends MediaControllerCompat.MediaControllerImplApi21
  {
    public c(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      super(paramToken);
    }
  }
  
  static final class d
    extends MediaControllerCompat.c
  {
    public d(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      super(paramToken);
    }
  }
  
  static final class e
    implements MediaControllerCompat.b
  {
    private b Mz;
    
    public e(MediaSessionCompat.Token paramToken)
    {
      this.Mz = b.a.d((IBinder)paramToken.ML);
    }
    
    public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent == null) {
        throw new IllegalArgumentException("event may not be null.");
      }
      try
      {
        this.Mz.a(paramKeyEvent);
        label25:
        return false;
      }
      catch (RemoteException paramKeyEvent)
      {
        break label25;
      }
    }
  }
  
  public static final class f
  {
    private final int MA;
    private final int MC;
    private final int MD;
    private final int MF;
    private final int MG;
    
    f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.MA = paramInt1;
      this.MC = paramInt2;
      this.MD = paramInt3;
      this.MF = paramInt4;
      this.MG = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */