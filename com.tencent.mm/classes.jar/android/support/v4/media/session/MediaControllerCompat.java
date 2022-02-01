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
  final b JB;
  private final MediaSessionCompat.Token JC;
  private final HashSet<a> JD = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    this.JC = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.JB = new d(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.JB = new c(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.JB = new MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    this.JB = new e(paramToken);
  }
  
  static class MediaControllerImplApi21
    implements MediaControllerCompat.b
  {
    protected final Object JJ;
    final List<MediaControllerCompat.a> JK = new ArrayList();
    HashMap<MediaControllerCompat.a, a> JL = new HashMap();
    final MediaSessionCompat.Token JM;
    final Object mLock = new Object();
    
    public MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      this.JM = paramToken;
      this.JJ = new MediaController(paramContext, (MediaSession.Token)this.JM.JY);
      if (this.JJ == null) {
        throw new RemoteException();
      }
      if (this.JM.JZ == null)
      {
        paramContext = new ExtraBinderRequestResultReceiver(this);
        ((MediaController)this.JJ).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
      }
    }
    
    public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      return ((MediaController)this.JJ).dispatchMediaButtonEvent(paramKeyEvent);
    }
    
    static class ExtraBinderRequestResultReceiver
      extends ResultReceiver
    {
      private WeakReference<MediaControllerCompat.MediaControllerImplApi21> JN;
      
      ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21)
      {
        super();
        this.JN = new WeakReference(paramMediaControllerImplApi21);
      }
      
      protected void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.JN.get();
        if ((localMediaControllerImplApi21 == null) || (paramBundle == null)) {
          return;
        }
        MediaControllerCompat.a locala;
        MediaControllerCompat.MediaControllerImplApi21.a locala1;
        synchronized (localMediaControllerImplApi21.mLock)
        {
          localMediaControllerImplApi21.JM.JZ = b.a.d(c.c(paramBundle, "android.support.v4.media.session.EXTRA_BINDER"));
          localMediaControllerImplApi21.JM.Ka = paramBundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
          if (localMediaControllerImplApi21.JM.JZ == null) {
            break label177;
          }
          paramBundle = localMediaControllerImplApi21.JK.iterator();
          if (paramBundle.hasNext())
          {
            locala = (MediaControllerCompat.a)paramBundle.next();
            locala1 = new MediaControllerCompat.MediaControllerImplApi21.a(locala);
            localMediaControllerImplApi21.JL.put(locala, locala1);
            locala.JG = locala1;
          }
        }
        localMediaControllerImplApi21.JK.clear();
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
    final Object JE;
    MediaControllerCompat.a.a JF;
    a JG;
    
    public a()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.JE = new c.b(new b(this));
        return;
      }
      c localc = new c(this);
      this.JG = localc;
      this.JE = localc;
    }
    
    final void a(int paramInt, Object paramObject, Bundle paramBundle)
    {
      if (this.JF != null)
      {
        paramObject = this.JF.obtainMessage(paramInt, paramObject);
        paramObject.setData(paramBundle);
        paramObject.sendToTarget();
      }
    }
    
    static final class b
      implements c.a
    {
      private final WeakReference<MediaControllerCompat.a> JI;
      
      b(MediaControllerCompat.a parama)
      {
        this.JI = new WeakReference(parama);
      }
      
      public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        if ((MediaControllerCompat.a)this.JI.get() != null) {
          new MediaControllerCompat.f(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        }
      }
      
      public final void eA()
      {
        this.JI.get();
      }
      
      public final void eB()
      {
        this.JI.get();
      }
      
      public final void ez()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if ((locala != null) && (locala.JG != null)) {
          int i = Build.VERSION.SDK_INT;
        }
      }
      
      public final void onQueueChanged(List<?> paramList)
      {
        if ((MediaControllerCompat.a)this.JI.get() != null) {
          MediaSessionCompat.QueueItem.m(paramList);
        }
      }
      
      public final void onSessionDestroyed()
      {
        this.JI.get();
      }
      
      public final void u(Object paramObject)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if ((locala != null) && (locala.JG == null)) {
          PlaybackStateCompat.y(paramObject);
        }
      }
      
      public final void v(Object paramObject)
      {
        if ((MediaControllerCompat.a)this.JI.get() != null) {
          MediaMetadataCompat.t(paramObject);
        }
      }
    }
    
    static class c
      extends a.a
    {
      private final WeakReference<MediaControllerCompat.a> JI;
      
      c(MediaControllerCompat.a parama)
      {
        this.JI = new WeakReference(parama);
      }
      
      public final void G(boolean paramBoolean) {}
      
      public final void H(boolean paramBoolean)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(11, Boolean.valueOf(paramBoolean), null);
        }
      }
      
      public void a(MediaMetadataCompat paramMediaMetadataCompat)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(3, paramMediaMetadataCompat, null);
        }
      }
      
      public void a(ParcelableVolumeInfo paramParcelableVolumeInfo)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          if (paramParcelableVolumeInfo == null) {
            break label55;
          }
        }
        label55:
        for (paramParcelableVolumeInfo = new MediaControllerCompat.f(paramParcelableVolumeInfo.Kb, paramParcelableVolumeInfo.Kc, paramParcelableVolumeInfo.Kd, paramParcelableVolumeInfo.Ke, paramParcelableVolumeInfo.Kf);; paramParcelableVolumeInfo = null)
        {
          locala.a(4, paramParcelableVolumeInfo, null);
          return;
        }
      }
      
      public final void a(PlaybackStateCompat paramPlaybackStateCompat)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(2, paramPlaybackStateCompat, null);
        }
      }
      
      public final void aA(int paramInt)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(9, Integer.valueOf(paramInt), null);
        }
      }
      
      public final void aB(int paramInt)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(12, Integer.valueOf(paramInt), null);
        }
      }
      
      public final void d(String paramString, Bundle paramBundle)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(1, paramString, paramBundle);
        }
      }
      
      public final void ep()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(13, null, null);
        }
      }
      
      public void onExtrasChanged(Bundle paramBundle)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(7, paramBundle, null);
        }
      }
      
      public void onQueueChanged(List<MediaSessionCompat.QueueItem> paramList)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(5, paramList, null);
        }
      }
      
      public void onQueueTitleChanged(CharSequence paramCharSequence)
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
        if (locala != null) {
          locala.a(6, paramCharSequence, null);
        }
      }
      
      public void onSessionDestroyed()
      {
        MediaControllerCompat.a locala = (MediaControllerCompat.a)this.JI.get();
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
    private b JO;
    
    public e(MediaSessionCompat.Token paramToken)
    {
      this.JO = b.a.d((IBinder)paramToken.JY);
    }
    
    public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent == null) {
        throw new IllegalArgumentException("event may not be null.");
      }
      try
      {
        this.JO.a(paramKeyEvent);
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
    private final int JP;
    private final int JQ;
    private final int JR;
    private final int JS;
    private final int JT;
    
    f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.JP = paramInt1;
      this.JQ = paramInt2;
      this.JR = paramInt3;
      this.JS = paramInt4;
      this.JT = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */