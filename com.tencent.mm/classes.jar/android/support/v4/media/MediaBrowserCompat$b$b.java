package android.support.v4.media;

final class MediaBrowserCompat$b$b
  implements a.a
{
  MediaBrowserCompat$b$b(MediaBrowserCompat.b paramb) {}
  
  public final void onConnected()
  {
    if (this.AH.AG != null) {
      this.AH.AG.onConnected();
    }
    this.AH.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.AH.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    if (this.AH.AG != null) {
      this.AH.AG.onConnectionSuspended();
    }
    this.AH.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.b.b
 * JD-Core Version:    0.7.0.1
 */