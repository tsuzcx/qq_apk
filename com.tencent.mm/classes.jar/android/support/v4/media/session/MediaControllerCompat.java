package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.view.KeyEvent;
import androidx.core.app.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class MediaControllerCompat
{
  public final b dp;
  private final MediaSessionCompat.Token dq;
  private final HashSet<a> dr = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    this.dq = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.dp = new d(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.dp = new c(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.dp = new MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    this.dp = new e(paramToken);
  }
  
  static class MediaControllerImplApi21
    implements MediaControllerCompat.b
  {
    protected final Object dw;
    final List<MediaControllerCompat.a> dx = new ArrayList();
    HashMap<MediaControllerCompat.a, a> dy = new HashMap();
    final MediaSessionCompat.Token dz;
    final Object mLock = new Object();
    
    public MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      this.dz = paramToken;
      this.dw = new MediaController(paramContext, (MediaSession.Token)this.dz.dL);
      if (this.dw == null) {
        throw new RemoteException();
      }
      if (this.dz.dM == null)
      {
        paramContext = new ExtraBinderRequestResultReceiver(this);
        ((MediaController)this.dw).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
      }
    }
    
    public final boolean b(KeyEvent paramKeyEvent)
    {
      return ((MediaController)this.dw).dispatchMediaButtonEvent(paramKeyEvent);
    }
    
    static class ExtraBinderRequestResultReceiver
      extends ResultReceiver
    {
      private WeakReference<MediaControllerCompat.MediaControllerImplApi21> dA;
      
      ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21)
      {
        super();
        this.dA = new WeakReference(paramMediaControllerImplApi21);
      }
      
      protected void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.dA.get();
        if ((localMediaControllerImplApi21 == null) || (paramBundle == null)) {
          return;
        }
        MediaControllerCompat.a locala;
        MediaControllerCompat.MediaControllerImplApi21.a locala1;
        synchronized (localMediaControllerImplApi21.mLock)
        {
          localMediaControllerImplApi21.dz.dM = b.a.d(c.b(paramBundle, "android.support.v4.media.session.EXTRA_BINDER"));
          localMediaControllerImplApi21.dz.dN = paramBundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
          if (localMediaControllerImplApi21.dz.dM == null) {
            break label177;
          }
          paramBundle = localMediaControllerImplApi21.dx.iterator();
          if (paramBundle.hasNext())
          {
            locala = (MediaControllerCompat.a)paramBundle.next();
            locala1 = new MediaControllerCompat.MediaControllerImplApi21.a(locala);
            localMediaControllerImplApi21.dy.put(locala, locala1);
            locala.du = locala1;
          }
        }
        localMediaControllerImplApi21.dx.clear();
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
    final Object ds;
    MediaControllerCompat.a.a dt;
    a du;
    
    public a()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.ds = new c.b(new b(this));
        return;
      }
      c localc = new c(this);
      this.du = localc;
      this.ds = localc;
    }
    
    final void a(int paramInt, Object paramObject, Bundle paramBundle)
    {
      if (this.dt != null)
      {
        paramObject = this.dt.obtainMessage(paramInt, paramObject);
        paramObject.setData(paramBundle);
        paramObject.sendToTarget();
      }
    }
    
    static final class b
      implements c.a
    {
      private final WeakReference<MediaControllerCompat.a> dv;
      
      b(MediaControllerCompat.a parama)
      {
        this.dv = new WeakReference(parama);
      }
      
      public final void bi()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if ((locala != null) && (locala.du != null)) {
          int i = Build.VERSION.SDK_INT;
        }
      }
      
      public final void bj()
      {
        this.dv.get();
      }
      
      public final void bk()
      {
        this.dv.get();
      }
      
      public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        if ((MediaControllerCompat.a)this.dv.get() != null) {
          new MediaControllerCompat.f(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        }
      }
      
      public final void f(Object paramObject)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if ((locala != null) && (locala.du == null)) {
          PlaybackStateCompat.j(paramObject);
        }
      }
      
      public final void g(Object paramObject)
      {
        if ((MediaControllerCompat.a)this.dv.get() != null) {
          MediaMetadataCompat.e(paramObject);
        }
      }
      
      public final void onQueueChanged(List<?> paramList)
      {
        if ((MediaControllerCompat.a)this.dv.get() != null) {
          MediaSessionCompat.QueueItem.h(paramList);
        }
      }
      
      public final void onSessionDestroyed()
      {
        this.dv.get();
      }
    }
    
    static class c
      extends a.a
    {
      private final WeakReference<MediaControllerCompat.a> dv;
      
      c(MediaControllerCompat.a parama)
      {
        this.dv = new WeakReference(parama);
      }
      
      public final void H(int paramInt)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(12, Integer.valueOf(paramInt), null);
        }
      }
      
      public void a(MediaMetadataCompat paramMediaMetadataCompat)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(3, paramMediaMetadataCompat, null);
        }
      }
      
      public void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          if (paramParcelableVolumeInfo == null) {
            break label55;
          }
        }
        label55:
        for (paramParcelableVolumeInfo = new MediaControllerCompat.f(paramParcelableVolumeInfo.dO, paramParcelableVolumeInfo.dP, paramParcelableVolumeInfo.dQ, paramParcelableVolumeInfo.dR, paramParcelableVolumeInfo.dS);; paramParcelableVolumeInfo = null)
        {
          locala.a(4, paramParcelableVolumeInfo, null);
          return;
        }
      }
      
      public final void a(PlaybackStateCompat paramPlaybackStateCompat)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(2, paramPlaybackStateCompat, null);
        }
      }
      
      public final void aR()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(13, null, null);
        }
      }
      
      public final void d(String paramString, Bundle paramBundle)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(1, paramString, paramBundle);
        }
      }
      
      public void onExtrasChanged(Bundle paramBundle)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(7, paramBundle, null);
        }
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(5, paramList, null);
        }
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(6, paramCharSequence, null);
        }
      }
      
      public final void onRepeatModeChanged(int paramInt)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(9, Integer.valueOf(paramInt), null);
        }
      }
      
      public void onSessionDestroyed()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(8, null, null);
        }
      }
      
      public final void r(boolean paramBoolean) {}
      
      public final void s(boolean paramBoolean)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.dv.get();
        if (locala != null) {
          locala.a(11, Boolean.valueOf(paramBoolean), null);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean b(KeyEvent paramKeyEvent);
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
    private b dB;
    
    public e(MediaSessionCompat.Token paramToken)
    {
      this.dB = b.a.d((IBinder)paramToken.dL);
    }
    
    public final boolean b(KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent == null) {
        throw new IllegalArgumentException("event may not be null.");
      }
      try
      {
        this.dB.a(paramKeyEvent);
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
    private final int dC;
    private final int dD;
    private final int dE;
    private final int dF;
    private final int dG;
    
    f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.dC = paramInt1;
      this.dD = paramInt2;
      this.dE = paramInt3;
      this.dF = paramInt4;
      this.dG = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */