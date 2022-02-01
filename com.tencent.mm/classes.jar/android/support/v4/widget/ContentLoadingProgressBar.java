package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean SV = false;
  boolean SW = false;
  private final Runnable SX = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.SV = false;
      ContentLoadingProgressBar.this.mStartTime = -1L;
      ContentLoadingProgressBar.this.setVisibility(8);
    }
  };
  private final Runnable SY = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.SW = false;
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
  
  private void fL()
  {
    removeCallbacks(this.SX);
    removeCallbacks(this.SY);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    fL();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    fL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */