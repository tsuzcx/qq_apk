package android.support.v4.media;

import android.os.Build.VERSION;

public class MediaBrowserCompat$b
{
  final Object AF;
  a AG;
  
  public MediaBrowserCompat$b()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.AF = new a.b(new MediaBrowserCompat.b.b(this));
      return;
    }
    this.AF = null;
  }
  
  public void onConnected() {}
  
  public void onConnectionFailed() {}
  
  public void onConnectionSuspended() {}
  
  static abstract interface a
  {
    public abstract void onConnected();
    
    public abstract void onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.b
 * JD-Core Version:    0.7.0.1
 */