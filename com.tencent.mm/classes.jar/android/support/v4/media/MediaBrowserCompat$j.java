package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

final class MediaBrowserCompat$j
{
  Bundle AK;
  private Messenger AZ;
  
  public MediaBrowserCompat$j(IBinder paramIBinder, Bundle paramBundle)
  {
    this.AZ = new Messenger(paramIBinder);
    this.AK = paramBundle;
  }
  
  final void a(int paramInt, Bundle paramBundle, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    localMessage.arg1 = 1;
    localMessage.setData(paramBundle);
    localMessage.replyTo = paramMessenger;
    this.AZ.send(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.j
 * JD-Core Version:    0.7.0.1
 */