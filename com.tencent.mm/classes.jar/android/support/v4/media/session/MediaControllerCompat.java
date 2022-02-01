package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.c;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class MediaControllerCompat
{
  final b Mw;
  private final MediaSessionCompat.Token Mx;
  private final HashSet<MediaControllerCompat.a> My = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null) {
      throw new IllegalArgumentException("sessionToken must not be null");
    }
    this.Mx = paramToken;
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.Mw = new d(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.Mw = new c(paramContext, paramToken);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.Mw = new MediaControllerImplApi21(paramContext, paramToken);
      return;
    }
    this.Mw = new e(paramToken);
  }
  
  static class MediaControllerImplApi21
    implements MediaControllerCompat.b
  {
    protected final Object MG;
    final List<MediaControllerCompat.a> MH = new ArrayList();
    HashMap<MediaControllerCompat.a, MediaControllerCompat.MediaControllerImplApi21.a> MI = new HashMap();
    final MediaSessionCompat.Token MJ;
    final Object mLock = new Object();
    
    public MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
    {
      this.MJ = paramToken;
      this.MG = new MediaController(paramContext, (MediaSession.Token)this.MJ.MV);
      if (this.MG == null) {
        throw new RemoteException();
      }
      if (this.MJ.MW == null)
      {
        paramContext = new ExtraBinderRequestResultReceiver(this);
        ((MediaController)this.MG).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
      }
    }
    
    public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      return ((MediaController)this.MG).dispatchMediaButtonEvent(paramKeyEvent);
    }
    
    static class ExtraBinderRequestResultReceiver
      extends ResultReceiver
    {
      private WeakReference<MediaControllerCompat.MediaControllerImplApi21> MK;
      
      ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21)
      {
        super();
        this.MK = new WeakReference(paramMediaControllerImplApi21);
      }
      
      protected void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.MK.get();
        if ((localMediaControllerImplApi21 == null) || (paramBundle == null)) {
          return;
        }
        MediaControllerCompat.a locala;
        MediaControllerCompat.MediaControllerImplApi21.a locala1;
        synchronized (localMediaControllerImplApi21.mLock)
        {
          localMediaControllerImplApi21.MJ.MW = b.a.d(c.b(paramBundle, "android.support.v4.media.session.EXTRA_BINDER"));
          localMediaControllerImplApi21.MJ.MX = paramBundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
          if (localMediaControllerImplApi21.MJ.MW == null) {
            break label177;
          }
          paramBundle = localMediaControllerImplApi21.MH.iterator();
          if (paramBundle.hasNext())
          {
            locala = (MediaControllerCompat.a)paramBundle.next();
            locala1 = new MediaControllerCompat.MediaControllerImplApi21.a(locala);
            localMediaControllerImplApi21.MI.put(locala, locala1);
            locala.MC = locala1;
          }
        }
        localMediaControllerImplApi21.MH.clear();
        label177:
      }
    }
  }
  
  final class a$a
    extends Handler
  {
    boolean MD;
    
    public final void handleMessage(Message paramMessage)
    {
      if (!this.MD) {
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
    private b ML;
    
    public e(MediaSessionCompat.Token paramToken)
    {
      this.ML = b.a.d((IBinder)paramToken.MV);
    }
    
    public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent == null) {
        throw new IllegalArgumentException("event may not be null.");
      }
      try
      {
        this.ML.a(paramKeyEvent);
        label25:
        return false;
      }
      catch (RemoteException paramKeyEvent)
      {
        break label25;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat
 * JD-Core Version:    0.7.0.1
 */