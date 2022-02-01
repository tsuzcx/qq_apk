package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import java.util.List;

class a$d<T extends a.c>
  extends MediaBrowser.SubscriptionCallback
{
  protected final T Iy;
  
  public a$d(T paramT)
  {
    this.Iy = paramT;
  }
  
  public void onChildrenLoaded(String paramString, List<MediaBrowser.MediaItem> paramList)
  {
    this.Iy.k(paramList);
  }
  
  public void onError(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.a.d
 * JD-Core Version:    0.7.0.1
 */