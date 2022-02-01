import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.tencent.widget.pulltorefresh.library.OverscrollHelper;
import com.tencent.widget.pulltorefresh.library.PullToRefreshHorizontalScrollView;

@TargetApi(9)
public final class lty
  extends HorizontalScrollView
{
  public lty(PullToRefreshHorizontalScrollView paramPullToRefreshHorizontalScrollView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a()
  {
    int i = 0;
    if (getChildCount() > 0) {
      i = Math.max(0, getChildAt(0).getWidth() - (getWidth() - getPaddingLeft() - getPaddingRight()));
    }
    return i;
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    OverscrollHelper.a(this.a, paramInt1, paramInt3, paramInt2, paramInt4, a(), paramBoolean);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lty
 * JD-Core Version:    0.7.0.1
 */