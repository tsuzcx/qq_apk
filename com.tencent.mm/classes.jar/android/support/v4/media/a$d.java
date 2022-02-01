package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import java.util.List;

class a$d<T extends a.c>
  extends MediaBrowser.SubscriptionCallback
{
  protected final T Jv;
  
  public a$d(T paramT)
  {
    this.Jv = paramT;
  }
  
  public void onChildrenLoaded(String paramString, List<MediaBrowser.MediaItem> paramList)
  {
    this.Jv.j(paramList);
  }
  
  public void onError(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.a.d
 * JD-Core Version:    0.7.0.1
 */