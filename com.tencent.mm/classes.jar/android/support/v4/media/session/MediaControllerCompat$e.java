package android.support.v4.media.session;

import android.os.IBinder;
import android.os.RemoteException;
import android.view.KeyEvent;

final class MediaControllerCompat$e
  implements MediaControllerCompat.b
{
  private b CZ;
  
  public MediaControllerCompat$e(MediaSessionCompat.Token paramToken)
  {
    this.CZ = b.a.d((IBinder)paramToken.Dj);
  }
  
  public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent == null) {
      throw new IllegalArgumentException("event may not be null.");
    }
    try
    {
      this.CZ.a(paramKeyEvent);
      label25:
      return false;
    }
    catch (RemoteException paramKeyEvent)
    {
      break label25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.e
 * JD-Core Version:    0.7.0.1
 */