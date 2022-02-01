package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;

final class a$b<T extends a.a>
  extends MediaBrowser.ConnectionCallback
{
  protected final T Ix;
  
  public a$b(T paramT)
  {
    this.Ix = paramT;
  }
  
  public final void onConnected()
  {
    this.Ix.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.Ix.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    this.Ix.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.a.b
 * JD-Core Version:    0.7.0.1
 */