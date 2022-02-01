package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

final class b$b<T extends b.a>
  extends a.d<T>
{
  b$b(T paramT)
  {
    super(paramT);
  }
  
  public final void onChildrenLoaded(String paramString, List<MediaBrowser.MediaItem> paramList, Bundle paramBundle)
  {
    MediaSessionCompat.e(paramBundle);
    ((b.a)this.cX).g(paramList);
  }
  
  public final void onError(String paramString, Bundle paramBundle)
  {
    MediaSessionCompat.e(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.b.b
 * JD-Core Version:    0.7.0.1
 */