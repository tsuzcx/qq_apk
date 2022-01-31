package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean Jl = false;
  boolean Jm = false;
  private final Runnable Jn = new ContentLoadingProgressBar.1(this);
  private final Runnable Jo = new ContentLoadingProgressBar.2(this);
  boolean mDismissed = false;
  long mStartTime = -1L;
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void dU()
  {
    removeCallbacks(this.Jn);
    removeCallbacks(this.Jo);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    dU();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */