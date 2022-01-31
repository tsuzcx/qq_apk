package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import java.util.List;

final class MediaControllerCompat$a$b
  implements c.a
{
  private final WeakReference<MediaControllerCompat.a> CT;
  
  MediaControllerCompat$a$b(MediaControllerCompat.a parama)
  {
    this.CT = new WeakReference(parama);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((MediaControllerCompat.a)this.CT.get() != null) {
      new MediaControllerCompat.f(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  public final void dr()
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if ((locala != null) && (locala.CR)) {
      int i = Build.VERSION.SDK_INT;
    }
  }
  
  public final void ds()
  {
    this.CT.get();
  }
  
  public final void dt()
  {
    this.CT.get();
  }
  
  public final void onQueueChanged(List<?> paramList)
  {
    if ((MediaControllerCompat.a)this.CT.get() != null) {
      MediaSessionCompat.QueueItem.m(paramList);
    }
  }
  
  public final void onSessionDestroyed()
  {
    this.CT.get();
  }
  
  public final void v(Object paramObject)
  {
    MediaControllerCompat.a locala = (MediaControllerCompat.a)this.CT.get();
    if ((locala != null) && (!locala.CR)) {
      PlaybackStateCompat.z(paramObject);
    }
  }
  
  public final void w(Object paramObject)
  {
    if ((MediaControllerCompat.a)this.CT.get() != null) {
      MediaMetadataCompat.u(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.a.b
 * JD-Core Version:    0.7.0.1
 */