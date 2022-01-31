package android.support.v4.media;

final class MediaBrowserCompat$b$b
  implements a.a
{
  MediaBrowserCompat$b$b(MediaBrowserCompat.b paramb) {}
  
  public final void onConnected()
  {
    if (this.Bt.Bs != null) {
      this.Bt.Bs.onConnected();
    }
    this.Bt.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.Bt.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    if (this.Bt.Bs != null) {
      this.Bt.Bs.onConnectionSuspended();
    }
    this.Bt.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.b.b
 * JD-Core Version:    0.7.0.1
 */