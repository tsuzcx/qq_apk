package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import java.util.List;

final class a
{
  static final class b<T extends a.a>
    extends MediaBrowser.ConnectionCallback
  {
    protected final T BQ;
    
    public b(T paramT)
    {
      this.BQ = paramT;
    }
    
    public final void onConnected()
    {
      this.BQ.onConnected();
    }
    
    public final void onConnectionFailed()
    {
      this.BQ.onConnectionFailed();
    }
    
    public final void onConnectionSuspended()
    {
      this.BQ.onConnectionSuspended();
    }
  }
  
  static class d<T extends a.c>
    extends MediaBrowser.SubscriptionCallback
  {
    protected final T BR;
    
    public d(T paramT)
    {
      this.BR = paramT;
    }
    
    public void onChildrenLoaded(String paramString, List<MediaBrowser.MediaItem> paramList)
    {
      this.BR.k(paramList);
    }
    
    public void onError(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.a
 * JD-Core Version:    0.7.0.1
 */