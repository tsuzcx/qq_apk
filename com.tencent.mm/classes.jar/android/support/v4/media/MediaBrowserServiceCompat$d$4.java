package android.support.v4.media;

import android.os.IBinder;
import android.support.v4.f.a;

final class MediaBrowserServiceCompat$d$4
  implements Runnable
{
  MediaBrowserServiceCompat$d$4(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame, String paramString, IBinder paramIBinder) {}
  
  public final void run()
  {
    Object localObject = this.By.asBinder();
    localObject = (MediaBrowserServiceCompat.b)this.BC.Bm.Bg.get(localObject);
    if (localObject == null) {
      new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.BD);
    }
    while (MediaBrowserServiceCompat.a(this.BD, (MediaBrowserServiceCompat.b)localObject, this.BE)) {
      return;
    }
    new StringBuilder("removeSubscription called for ").append(this.BD).append(" which is not subscribed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.4
 * JD-Core Version:    0.7.0.1
 */