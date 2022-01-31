package android.support.v4.widget;

final class ContentLoadingProgressBar$2
  implements Runnable
{
  ContentLoadingProgressBar$2(ContentLoadingProgressBar paramContentLoadingProgressBar) {}
  
  public final void run()
  {
    this.JJ.JG = false;
    if (!this.JJ.mDismissed)
    {
      this.JJ.mStartTime = System.currentTimeMillis();
      this.JJ.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar.2
 * JD-Core Version:    0.7.0.1
 */