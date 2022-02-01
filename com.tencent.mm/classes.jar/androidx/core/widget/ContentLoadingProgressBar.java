package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  boolean bws;
  boolean bwt;
  private final Runnable bwu;
  private final Runnable bwv;
  boolean mDismissed;
  long mStartTime;
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(195369);
    this.mStartTime = -1L;
    this.bws = false;
    this.bwt = false;
    this.mDismissed = false;
    this.bwu = new ContentLoadingProgressBar..ExternalSyntheticLambda0(this);
    this.bwv = new ContentLoadingProgressBar..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(195369);
  }
  
  private void Fg()
  {
    AppMethodBeat.i(195374);
    removeCallbacks(this.bwu);
    removeCallbacks(this.bwv);
    AppMethodBeat.o(195374);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(195408);
    super.onAttachedToWindow();
    Fg();
    AppMethodBeat.o(195408);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(195414);
    super.onDetachedFromWindow();
    Fg();
    AppMethodBeat.o(195414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.core.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */