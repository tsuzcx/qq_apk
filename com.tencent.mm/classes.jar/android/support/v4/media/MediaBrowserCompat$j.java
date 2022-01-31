package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

final class MediaBrowserCompat$j
{
  private Messenger BL;
  Bundle Bw;
  
  public MediaBrowserCompat$j(IBinder paramIBinder, Bundle paramBundle)
  {
    this.BL = new Messenger(paramIBinder);
    this.Bw = paramBundle;
  }
  
  final void a(int paramInt, Bundle paramBundle, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.arg1 = 1;
    localMessage.setData(paramBundle);
    localMessage.replyTo = paramMessenger;
    this.BL.send(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.j
 * JD-Core Version:    0.7.0.1
 */