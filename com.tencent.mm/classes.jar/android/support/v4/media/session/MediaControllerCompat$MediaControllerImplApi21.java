package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.os.Handler;
import android.os.RemoteException;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21
  implements MediaControllerCompat.b
{
  protected final Object Cl;
  final List<MediaControllerCompat.a> Cm = new ArrayList();
  b Cn;
  HashMap<MediaControllerCompat.a, MediaControllerCompat.MediaControllerImplApi21.a> Co = new HashMap();
  
  public MediaControllerCompat$MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    this.Cl = new MediaController(paramContext, (MediaSession.Token)paramToken.CA);
    if (this.Cl == null) {
      throw new RemoteException();
    }
    this.Cn = paramToken.Cn;
    if (this.Cn == null)
    {
      paramContext = new MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver(this, new Handler());
      ((MediaController)this.Cl).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
    }
  }
  
  public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    return ((MediaController)this.Cl).dispatchMediaButtonEvent(paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21
 * JD-Core Version:    0.7.0.1
 */