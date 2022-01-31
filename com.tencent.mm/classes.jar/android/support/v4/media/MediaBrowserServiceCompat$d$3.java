package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.f.a;

final class MediaBrowserServiceCompat$d$3
  implements Runnable
{
  MediaBrowserServiceCompat$d$3(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame, String paramString, IBinder paramIBinder, Bundle paramBundle) {}
  
  public final void run()
  {
    Object localObject = this.By.asBinder();
    localObject = (MediaBrowserServiceCompat.b)this.BC.Bm.Bg.get(localObject);
    if (localObject == null)
    {
      new StringBuilder("addSubscription for callback that isn't registered id=").append(this.BD);
      return;
    }
    this.BC.Bm.a(this.BD, (MediaBrowserServiceCompat.b)localObject, this.BE, this.val$options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.3
 * JD-Core Version:    0.7.0.1
 */