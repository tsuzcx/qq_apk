package android.support.v4.media;

public class MediaBrowserServiceCompat$c<T>
{
  final Object Cg;
  private boolean Ch;
  boolean Ci;
  boolean Cj;
  int wy;
  
  MediaBrowserServiceCompat$c(Object paramObject)
  {
    this.Cg = paramObject;
  }
  
  void dd() {}
  
  void de()
  {
    throw new UnsupportedOperationException("It is not supported to send an error for " + this.Cg);
  }
  
  public final void df()
  {
    if ((this.Ci) || (this.Cj)) {
      throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.Cg);
    }
    this.Ci = true;
    dd();
  }
  
  final boolean isDone()
  {
    return (this.Ch) || (this.Ci) || (this.Cj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.c
 * JD-Core Version:    0.7.0.1
 */