package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean Rg = false;
  boolean Rh = false;
  private final Runnable Ri = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.Rg = false;
      ContentLoadingProgressBar.this.mStartTime = -1L;
      ContentLoadingProgressBar.this.setVisibility(8);
    }
  };
  private final Runnable Rj = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.Rh = false;
      if (!ContentLoadingProgressBar.this.mDismissed)
      {
        ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
        ContentLoadingProgressBar.this.setVisibility(0);
      }
    }
  };
  boolean mDismissed = false;
  long mStartTime = -1L;
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void fu()
  {
    removeCallbacks(this.Ri);
    removeCallbacks(this.Rj);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    fu();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    fu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */