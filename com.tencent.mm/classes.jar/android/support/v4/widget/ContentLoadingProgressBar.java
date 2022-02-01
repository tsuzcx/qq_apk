package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean Th = false;
  boolean Ti = false;
  private final Runnable Tj = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.Th = false;
      ContentLoadingProgressBar.this.mStartTime = -1L;
      ContentLoadingProgressBar.this.setVisibility(8);
    }
  };
  private final Runnable Tk = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.Ti = false;
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
  
  private void fS()
  {
    removeCallbacks(this.Tj);
    removeCallbacks(this.Tk);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    fS();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    fS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */