package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean Ql = false;
  boolean Qm = false;
  private final Runnable Qn = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.Ql = false;
      ContentLoadingProgressBar.this.mStartTime = -1L;
      ContentLoadingProgressBar.this.setVisibility(8);
    }
  };
  private final Runnable Qo = new Runnable()
  {
    public final void run()
    {
      ContentLoadingProgressBar.this.Qm = false;
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
  
  private void fm()
  {
    removeCallbacks(this.Qn);
    removeCallbacks(this.Qo);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    fm();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    fm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */