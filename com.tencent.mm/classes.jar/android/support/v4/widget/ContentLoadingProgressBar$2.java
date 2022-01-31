package android.support.v4.widget;

final class ContentLoadingProgressBar$2
  implements Runnable
{
  ContentLoadingProgressBar$2(ContentLoadingProgressBar paramContentLoadingProgressBar) {}
  
  public final void run()
  {
    this.Jp.Jm = false;
    if (!this.Jp.mDismissed)
    {
      this.Jp.mStartTime = System.currentTimeMillis();
      this.Jp.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar.2
 * JD-Core Version:    0.7.0.1
 */