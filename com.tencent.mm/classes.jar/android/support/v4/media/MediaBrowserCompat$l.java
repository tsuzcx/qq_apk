package android.support.v4.media;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class MediaBrowserCompat$l
{
  private final Object Bb;
  WeakReference<MediaBrowserCompat.k> Bc;
  final IBinder tZ = new Binder();
  
  public MediaBrowserCompat$l()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.Bb = new b.b(new b());
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.Bb = new a.d(new MediaBrowserCompat.l.a(this));
      return;
    }
    this.Bb = null;
  }
  
  private final class b
    extends MediaBrowserCompat.l.a
    implements b.a
  {
    b()
    {
      super();
    }
    
    public final void l(List<?> paramList)
    {
      MediaBrowserCompat.MediaItem.j(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.l
 * JD-Core Version:    0.7.0.1
 */