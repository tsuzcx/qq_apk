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
  final b Kw;
  private final MediaSessionCompat.Token Kx;
  private final HashSet<a> Ky = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    this.Kx = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.Kw = new d(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.Kw = new c(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.Kw = new MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    this.Kw = new e(paramToken);
  }
  
  static class MediaControllerImplApi21
    implements MediaControllerCompat.b
  {
    protected final Object KE;
    final List<MediaControllerCompat.a> KF = new ArrayList();
    HashMap<MediaControllerCompat.a, a> KG = new HashMap();
    final MediaSessionCompat.Token KH;
    final Object mLock = new Object();
    
    public MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      this.KH = paramToken;
      this.KE = new MediaController(paramContext, (MediaSession.Token)this.KH.KT);
      if (this.KE == null) {
        throw new RemoteException();
      }
      if (this.KH.KU == null)
      {
        paramContext = new ExtraBinderRequestResultReceiver(this);
        ((MediaController)this.KE).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
      }
    }
    
    public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      return ((MediaController)this.KE).dispatchMediaButtonEvent(paramKeyEvent);
    }
    
    static class ExtraBinderRequestResultReceiver
      extends ResultReceiver
    {
      private WeakReference<MediaControllerCompat.MediaControllerImplApi21> KI;
      
      ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21)
      {
        super();
        this.KI = new WeakReference(paramMediaControllerImplApi21);
      }
      
      protected void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.KI.get();
        if ((localMediaControllerImplApi21 == null) || (paramBundle == null)) {
          return;
        }
        MediaControllerCompat.a locala;
        MediaControllerCompat.MediaControllerImplApi21.a locala1;
        synchronized (localMediaControllerImplApi21.mLock)
        {
          localMediaControllerImplApi21.KH.KU = b.a.d(c.c(paramBundle, "android.support.v4.media.session.EXTRA_BINDER"));
          localMediaControllerImplApi21.KH.KV = paramBundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
          if (localMediaControllerImplApi21.KH.KU == null) {
            break label177;
          }
          paramBundle = localMediaControllerImplApi21.KF.iterator();
          if (paramBundle.hasNext())
          {
            locala = (MediaControllerCompat.a)paramBundle.next();
            locala1 = new MediaControllerCompat.MediaControllerImplApi21.a(locala);
            localMediaControllerImplApi21.KG.put(locala, locala1);
            locala.KB = locala1;
          }
        }
        localMediaControllerImplApi21.KF.clear();
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
    a KA;
    a KB;
    final Object Kz;
    
    public a()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.Kz = new c.b(new b(this));
        return;
      }
      c localc = new c(this);
      this.KB = localc;
      this.Kz = localc;
    }
    
    final void a(int paramInt, Object paramObject, Bundle paramBundle)
    {
      if (this.KA != null)
      {
        paramObject = this.KA.obtainMessage(paramInt, paramObject);
        paramObject.setData(paramBundle);
        paramObject.sendToTarget();
      }
    }
    
    final class a
      extends Handler
    {
      boolean KC;
      
      public final void handleMessage(Message paramMessage)
      {
        if (!this.KC) {
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
      private final WeakReference<MediaControllerCompat.a> KD;
      
      b(MediaControllerCompat.a parama)
      {
        this.KD = new WeakReference(parama);
      }
      
      public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        if ((MediaControllerCompat.a)this.KD.get() != null) {
          new MediaControllerCompat.f(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        }
      }
      
      public final void eH()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if ((locala != null) && (locala.KB != null)) {
          int i = Build.VERSION.SDK_INT;
        }
      }
      
      public final void eI()
      {
        this.KD.get();
      }
      
      public final void eJ()
      {
        this.KD.get();
      }
      
      public final void onQueueChanged(List<?> paramList)
      {
        if ((MediaControllerCompat.a)this.KD.get() != null) {
          MediaSessionCompat.QueueItem.l(paramList);
        }
      }
      
      public final void onSessionDestroyed()
      {
        this.KD.get();
      }
      
      public final void w(Object paramObject)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if ((locala != null) && (locala.KB == null)) {
          PlaybackStateCompat.A(paramObject);
        }
      }
      
      public final void x(Object paramObject)
      {
        if ((MediaControllerCompat.a)this.KD.get() != null) {
          MediaMetadataCompat.v(paramObject);
        }
      }
    }
    
    static class c
      extends a.a
    {
      private final WeakReference<MediaControllerCompat.a> KD;
      
      c(MediaControllerCompat.a parama)
      {
        this.KD = new WeakReference(parama);
      }
      
      public final void G(boolean paramBoolean) {}
      
      public final void H(boolean paramBoolean)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(11, Boolean.valueOf(paramBoolean), null);
        }
      }
      
      public void a(MediaMetadataCompat paramMediaMetadataCompat)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(3, paramMediaMetadataCompat, null);
        }
      }
      
      public void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          if (paramParcelableVolumeInfo == null) {
            break label55;
          }
        }
        label55:
        for (paramParcelableVolumeInfo = new MediaControllerCompat.f(paramParcelableVolumeInfo.KW, paramParcelableVolumeInfo.KX, paramParcelableVolumeInfo.KY, paramParcelableVolumeInfo.KZ, paramParcelableVolumeInfo.La);; paramParcelableVolumeInfo = null)
        {
          locala.a(4, paramParcelableVolumeInfo, null);
          return;
        }
      }
      
      public final void a(PlaybackStateCompat paramPlaybackStateCompat)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(2, paramPlaybackStateCompat, null);
        }
      }
      
      public final void aA(int paramInt)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(9, Integer.valueOf(paramInt), null);
        }
      }
      
      public final void aB(int paramInt)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(12, Integer.valueOf(paramInt), null);
        }
      }
      
      public final void d(String paramString, Bundle paramBundle)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(1, paramString, paramBundle);
        }
      }
      
      public final void ex()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(13, null, null);
        }
      }
      
      public void onExtrasChanged(Bundle paramBundle)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(7, paramBundle, null);
        }
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(5, paramList, null);
        }
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
        if (locala != null) {
          locala.a(6, paramCharSequence, null);
        }
      }
      
      public void onSessionDestroyed()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.KD.get();
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
    private b KJ;
    
    public e(MediaSessionCompat.Token paramToken)
    {
      this.KJ = b.a.d((IBinder)paramToken.KT);
    }
    
    public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent == null) {
        throw new IllegalArgumentException("event may not be null.");
      }
      try
      {
        this.KJ.a(paramKeyEvent);
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
    private final int KK;
    private final int KL;
    private final int KM;
    private final int KN;
    private final int KO;
    
    f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.KK = paramInt1;
      this.KL = paramInt2;
      this.KM = paramInt3;
      this.KN = paramInt4;
      this.KO = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */