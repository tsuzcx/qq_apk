package android.support.v4.media.session;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.b;
import android.support.v4.media.MediaBrowserCompat.d;
import android.view.KeyEvent;

final class MediaButtonReceiver$a
  extends MediaBrowserCompat.b
{
  private final BroadcastReceiver.PendingResult CJ;
  MediaBrowserCompat CK;
  private final Context mContext;
  private final Intent mIntent;
  
  MediaButtonReceiver$a(Context paramContext, Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
  {
    this.mContext = paramContext;
    this.mIntent = paramIntent;
    this.CJ = paramPendingResult;
  }
  
  private void finish()
  {
    this.CK.disconnect();
    this.CJ.finish();
  }
  
  public final void onConnected()
  {
    KeyEvent localKeyEvent;
    try
    {
      MediaControllerCompat localMediaControllerCompat = new MediaControllerCompat(this.mContext, this.CK.Bo.cZ());
      localKeyEvent = (KeyEvent)this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
      if (localKeyEvent == null) {
        throw new IllegalArgumentException("KeyEvent may not be null");
      }
    }
    catch (RemoteException localRemoteException) {}
    for (;;)
    {
      finish();
      return;
      localRemoteException.CL.dispatchMediaButtonEvent(localKeyEvent);
    }
  }
  
  public final void onConnectionFailed()
  {
    finish();
  }
  
  public final void onConnectionSuspended()
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.session.MediaButtonReceiver.a
 * JD-Core Version:    0.7.0.1
 */