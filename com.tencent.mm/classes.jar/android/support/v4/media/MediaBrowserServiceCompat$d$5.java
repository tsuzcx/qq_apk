package android.support.v4.media;

import android.support.v4.f.a;
import android.support.v4.os.ResultReceiver;

final class MediaBrowserServiceCompat$d$5
  implements Runnable
{
  MediaBrowserServiceCompat$d$5(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame, String paramString, ResultReceiver paramResultReceiver) {}
  
  public final void run()
  {
    Object localObject = this.By.asBinder();
    localObject = (MediaBrowserServiceCompat.b)this.BC.Bm.Bg.get(localObject);
    if (localObject == null) {
      new StringBuilder("getMediaItem for callback that isn't registered id=").append(this.BF);
    }
    String str;
    MediaBrowserServiceCompat.2 local2;
    do
    {
      return;
      MediaBrowserServiceCompat localMediaBrowserServiceCompat = this.BC.Bm;
      str = this.BF;
      local2 = new MediaBrowserServiceCompat.2(localMediaBrowserServiceCompat, str, this.Bn);
      localMediaBrowserServiceCompat.Bh = ((MediaBrowserServiceCompat.b)localObject);
      local2.wg = 2;
      local2.cC();
      localMediaBrowserServiceCompat.Bh = null;
    } while (local2.isDone());
    throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.5
 * JD-Core Version:    0.7.0.1
 */