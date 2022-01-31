package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean JF = false;
  boolean JG = false;
  private final Runnable JH = new ContentLoadingProgressBar.1(this);
  private final Runnable JI = new ContentLoadingProgressBar.2(this);
  boolean mDismissed = false;
  long mStartTime = -1L;
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void dD()
  {
    removeCallbacks(this.JH);
    removeCallbacks(this.JI);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    dD();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */