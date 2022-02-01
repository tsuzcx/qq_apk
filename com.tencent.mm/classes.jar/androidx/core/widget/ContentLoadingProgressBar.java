package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean Qa;
  boolean Qb;
  private final Runnable Qc;
  private final Runnable Qd;
  boolean mDismissed;
  long mStartTime;
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(252383);
    this.mStartTime = -1L;
    this.Qa = false;
    this.Qb = false;
    this.mDismissed = false;
    this.Qc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252363);
        ContentLoadingProgressBar.this.Qa = false;
        ContentLoadingProgressBar.this.mStartTime = -1L;
        ContentLoadingProgressBar.this.setVisibility(8);
        AppMethodBeat.o(252363);
      }
    };
    this.Qd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252368);
        ContentLoadingProgressBar.this.Qb = false;
        if (!ContentLoadingProgressBar.this.mDismissed)
        {
          ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
          ContentLoadingProgressBar.this.setVisibility(0);
        }
        AppMethodBeat.o(252368);
      }
    };
    AppMethodBeat.o(252383);
  }
  
  private void hC()
  {
    AppMethodBeat.i(252389);
    removeCallbacks(this.Qc);
    removeCallbacks(this.Qd);
    AppMethodBeat.o(252389);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(252385);
    super.onAttachedToWindow();
    hC();
    AppMethodBeat.o(252385);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(252387);
    super.onDetachedFromWindow();
    hC();
    AppMethodBeat.o(252387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */