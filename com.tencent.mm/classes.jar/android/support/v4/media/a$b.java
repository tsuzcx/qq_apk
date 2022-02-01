package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;

final class a$b<T extends a.a>
  extends MediaBrowser.ConnectionCallback
{
  protected final T cW;
  
  public a$b(T paramT)
  {
    this.cW = paramT;
  }
  
  public final void onConnected()
  {
    this.cW.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.cW.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    this.cW.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.a.b
 * JD-Core Version:    0.7.0.1
 */