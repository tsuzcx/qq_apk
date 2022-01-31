package android.support.v4.media;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.support.v4.e.a;

final class MediaBrowserServiceCompat$d$2
  implements Runnable
{
  MediaBrowserServiceCompat$d$2(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame) {}
  
  public final void run()
  {
    Object localObject = this.Ck.asBinder();
    localObject = (MediaBrowserServiceCompat.b)this.Co.BY.BS.remove(localObject);
    if (localObject != null) {
      ((MediaBrowserServiceCompat.b)localObject).Cc.asBinder().unlinkToDeath((IBinder.DeathRecipient)localObject, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.2
 * JD-Core Version:    0.7.0.1
 */