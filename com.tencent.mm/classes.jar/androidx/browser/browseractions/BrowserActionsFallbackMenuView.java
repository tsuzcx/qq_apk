package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import androidx.browser.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BrowserActionsFallbackMenuView
  extends LinearLayout
{
  private final int zj;
  private final int zk;
  
  public BrowserActionsFallbackMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192931);
    this.zj = getResources().getDimensionPixelOffset(a.a.browser_actions_context_menu_min_padding);
    this.zk = getResources().getDimensionPixelOffset(a.a.browser_actions_context_menu_max_width);
    AppMethodBeat.o(192931);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192941);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - this.zj * 2, this.zk), 1073741824), paramInt2);
    AppMethodBeat.o(192941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.browser.browseractions.BrowserActionsFallbackMenuView
 * JD-Core Version:    0.7.0.1
 */