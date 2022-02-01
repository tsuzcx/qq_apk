package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;

final class a$b<T extends a.a>
  extends MediaBrowser.ConnectionCallback
{
  protected final T Ju;
  
  public a$b(T paramT)
  {
    this.Ju = paramT;
  }
  
  public final void onConnected()
  {
    this.Ju.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.Ju.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    this.Ju.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.a.b
 * JD-Core Version:    0.7.0.1
 */