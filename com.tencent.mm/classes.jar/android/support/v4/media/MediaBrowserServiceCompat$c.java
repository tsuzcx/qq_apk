package android.support.v4.media;

public class MediaBrowserServiceCompat$c<T>
{
  final Object Bu;
  private boolean Bv;
  boolean Bw;
  boolean Bx;
  int wg;
  
  MediaBrowserServiceCompat$c(Object paramObject)
  {
    this.Bu = paramObject;
  }
  
  void cA() {}
  
  void cB()
  {
    throw new UnsupportedOperationException("It is not supported to send an error for " + this.Bu);
  }
  
  public final void cC()
  {
    if ((this.Bw) || (this.Bx)) {
      throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.Bu);
    }
    this.Bw = true;
    cA();
  }
  
  final boolean isDone()
  {
    return (this.Bv) || (this.Bw) || (this.Bx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.c
 * JD-Core Version:    0.7.0.1
 */