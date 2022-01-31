package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.support.v4.f.j;
import java.util.HashMap;
import java.util.List;

final class MediaBrowserServiceCompat$b
  implements IBinder.DeathRecipient
{
  String Bo;
  Bundle Bp;
  MediaBrowserServiceCompat.e Bq;
  MediaBrowserServiceCompat.a Br;
  HashMap<String, List<j<IBinder, Bundle>>> Bs = new HashMap();
  
  MediaBrowserServiceCompat$b(MediaBrowserServiceCompat paramMediaBrowserServiceCompat) {}
  
  public final void binderDied()
  {
    this.Bm.Bi.post(new MediaBrowserServiceCompat.b.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.b
 * JD-Core Version:    0.7.0.1
 */