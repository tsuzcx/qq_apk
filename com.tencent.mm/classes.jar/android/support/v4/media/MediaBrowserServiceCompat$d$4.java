package android.support.v4.media;

import android.os.IBinder;
import android.support.v4.e.a;

final class MediaBrowserServiceCompat$d$4
  implements Runnable
{
  MediaBrowserServiceCompat$d$4(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame, String paramString, IBinder paramIBinder) {}
  
  public final void run()
  {
    Object localObject = this.Ck.asBinder();
    localObject = (MediaBrowserServiceCompat.b)this.Co.BY.BS.get(localObject);
    if (localObject == null) {
      new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.val$id);
    }
    while (MediaBrowserServiceCompat.a(this.val$id, (MediaBrowserServiceCompat.b)localObject, this.Cp)) {
      return;
    }
    new StringBuilder("removeSubscription called for ").append(this.val$id).append(" which is not subscribed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.4
 * JD-Core Version:    0.7.0.1
 */