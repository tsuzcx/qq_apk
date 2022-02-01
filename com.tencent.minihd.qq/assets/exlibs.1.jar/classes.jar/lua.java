import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.widget.pulltorefresh.library.OverscrollHelper;
import com.tencent.widget.pulltorefresh.library.PullToRefreshListView;
import com.tencent.widget.pulltorefresh.library.PullToRefreshListView.InternalListView;

@TargetApi(9)
public final class lua
  extends PullToRefreshListView.InternalListView
{
  public lua(PullToRefreshListView paramPullToRefreshListView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramPullToRefreshListView, paramContext, paramAttributeSet);
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    OverscrollHelper.a(this.b, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lua
 * JD-Core Version:    0.7.0.1
 */