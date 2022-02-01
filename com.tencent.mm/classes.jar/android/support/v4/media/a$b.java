package android.support.v4.media;

import android.media.browse.MediaBrowser.ConnectionCallback;

final class a$b<T extends a.a>
  extends MediaBrowser.ConnectionCallback
{
  protected final T Lu;
  
  public a$b(T paramT)
  {
    this.Lu = paramT;
  }
  
  public final void onConnected()
  {
    this.Lu.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.Lu.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    this.Lu.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.a.b
 * JD-Core Version:    0.7.0.1
 */