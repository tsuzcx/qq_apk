package android.support.v4.media;

import android.os.IBinder;
import android.support.v4.e.a;

final class MediaBrowserServiceCompat$d$7
  implements Runnable
{
  MediaBrowserServiceCompat$d$7(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame) {}
  
  public final void run()
  {
    IBinder localIBinder = this.Ck.asBinder();
    MediaBrowserServiceCompat.b localb = (MediaBrowserServiceCompat.b)this.Co.BY.BS.remove(localIBinder);
    if (localb != null) {
      localIBinder.unlinkToDeath(localb, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.7
 * JD-Core Version:    0.7.0.1
 */