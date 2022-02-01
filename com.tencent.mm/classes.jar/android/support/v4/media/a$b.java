package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;

final class a$b<T extends a.a>
  extends MediaBrowser.ConnectionCallback
{
  protected final T Lk;
  
  public a$b(T paramT)
  {
    this.Lk = paramT;
  }
  
  public final void onConnected()
  {
    this.Lk.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.Lk.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    this.Lk.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.a.b
 * JD-Core Version:    0.7.0.1
 */