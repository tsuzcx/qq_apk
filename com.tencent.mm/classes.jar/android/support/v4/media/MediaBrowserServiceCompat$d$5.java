package android.support.v4.media;

import android.support.v4.e.a;
import android.support.v4.os.ResultReceiver;

final class MediaBrowserServiceCompat$d$5
  implements Runnable
{
  MediaBrowserServiceCompat$d$5(MediaBrowserServiceCompat.d paramd, MediaBrowserServiceCompat.e parame, String paramString, ResultReceiver paramResultReceiver) {}
  
  public final void run()
  {
    Object localObject = this.Ck.asBinder();
    localObject = (MediaBrowserServiceCompat.b)this.Co.BY.BS.get(localObject);
    if (localObject == null) {
      new StringBuilder("getMediaItem for callback that isn't registered id=").append(this.Cq);
    }
    String str;
    MediaBrowserServiceCompat.2 local2;
    do
    {
      return;
      MediaBrowserServiceCompat localMediaBrowserServiceCompat = this.Co.BY;
      str = this.Cq;
      local2 = new MediaBrowserServiceCompat.2(localMediaBrowserServiceCompat, str, this.BZ);
      localMediaBrowserServiceCompat.BT = ((MediaBrowserServiceCompat.b)localObject);
      local2.wy = 2;
      local2.df();
      localMediaBrowserServiceCompat.BT = null;
    } while (local2.isDone());
    throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=".concat(String.valueOf(str)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.d.5
 * JD-Core Version:    0.7.0.1
 */