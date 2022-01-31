package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MediaControllerCompat$MediaControllerImplApi21
  implements MediaControllerCompat.b
{
  protected final Object CU;
  final List<MediaControllerCompat.a> CV = new ArrayList();
  b CW;
  HashMap<MediaControllerCompat.a, a> CX = new HashMap();
  
  public MediaControllerCompat$MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
  {
    this.CU = new MediaController(paramContext, (MediaSession.Token)paramToken.Dj);
    if (this.CU == null) {
      throw new RemoteException();
    }
    this.CW = paramToken.CW;
    if (this.CW == null)
    {
      paramContext = new MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver(this, new Handler());
      ((MediaController)this.CU).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, paramContext);
    }
  }
  
  public final boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    return ((MediaController)this.CU).dispatchMediaButtonEvent(paramKeyEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21
 * JD-Core Version:    0.7.0.1
 */