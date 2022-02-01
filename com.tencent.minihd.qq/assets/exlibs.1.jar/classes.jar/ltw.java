import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.widget.pulltorefresh.library.PullToRefreshGridView;
import com.tencent.widget.pulltorefresh.library.internal.EmptyViewMethodAccessor;

public class ltw
  extends GridView
  implements EmptyViewMethodAccessor
{
  public ltw(PullToRefreshGridView paramPullToRefreshGridView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setEmptyView(View paramView)
  {
    this.a.setEmptyView(paramView);
  }
  
  public void setEmptyViewInternal(View paramView)
  {
    super.setEmptyView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ltw
 * JD-Core Version:    0.7.0.1
 */