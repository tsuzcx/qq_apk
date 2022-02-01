import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import com.tencent.widget.pulltorefresh.library.PullToRefreshExpandableListView;
import com.tencent.widget.pulltorefresh.library.internal.EmptyViewMethodAccessor;

public class ltu
  extends ExpandableListView
  implements EmptyViewMethodAccessor
{
  public ltu(PullToRefreshExpandableListView paramPullToRefreshExpandableListView, Context paramContext, AttributeSet paramAttributeSet)
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
 * Qualified Name:     ltu
 * JD-Core Version:    0.7.0.1
 */