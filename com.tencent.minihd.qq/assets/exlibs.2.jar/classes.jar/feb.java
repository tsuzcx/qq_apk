import android.view.View;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class feb
  implements OverScrollViewListener
{
  public feb(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (SubAccountMessageActivity.c(this.a))
    {
      SubAccountMessageActivity.a(this.a).a();
      return;
    }
    SubAccountMessageActivity.a(this.a).c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (SubAccountMessageActivity.c(this.a)) {
      return true;
    }
    SubAccountMessageActivity.a(this.a).a(0L);
    SubAccountMessageActivity.d(this.a, true);
    SubAccountMessageActivity.a(this.a, SubAccountMessageActivity.a(this.a).subuin, false);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (SubAccountMessageActivity.c(this.a)) {
      return;
    }
    SubAccountMessageActivity.a(this.a).b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     feb
 * JD-Core Version:    0.7.0.1
 */