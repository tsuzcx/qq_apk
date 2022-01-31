package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver
  extends ResultReceiver
{
  private WeakReference<MediaControllerCompat.MediaControllerImplApi21> Cp;
  
  public MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21, Handler paramHandler)
  {
    super(paramHandler);
    this.Cp = new WeakReference(paramMediaControllerImplApi21);
  }
  
  protected void onReceiveResult(int paramInt, Bundle arg2)
  {
    MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)this.Cp.get();
    if ((localMediaControllerImplApi21 == null) || (??? == null)) {}
    do
    {
      return;
      localMediaControllerImplApi21.Cn = b.a.c(e.c(???, "android.support.v4.media.session.EXTRA_BINDER"));
    } while (localMediaControllerImplApi21.Cn == null);
    synchronized (localMediaControllerImplApi21.Cm)
    {
      Iterator localIterator = localMediaControllerImplApi21.Cm.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          MediaControllerCompat.a locala = (MediaControllerCompat.a)localIterator.next();
          MediaControllerCompat.MediaControllerImplApi21.a locala1 = new MediaControllerCompat.MediaControllerImplApi21.a(locala);
          localMediaControllerImplApi21.Co.put(locala, locala1);
          locala.Ci = true;
          try
          {
            localMediaControllerImplApi21.Cn.a(locala1);
          }
          catch (RemoteException localRemoteException) {}
        }
      }
      localMediaControllerImplApi21.Cm.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver
 * JD-Core Version:    0.7.0.1
 */