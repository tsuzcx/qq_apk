import android.view.View;
import com.dataline.activities.DLRouterActivity;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;

public class i
  implements OverScrollViewListener
{
  public i(DLRouterActivity paramDLRouterActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (RouterHandler)this.a.app.a(50);
    paramInt = paramView.a(DLRouterActivity.b(this.a), 10);
    if (paramInt > 0)
    {
      paramView.a.a();
      this.a.a.setSelectionFromBottom(paramInt, 0);
      paramView.a.notifyDataSetChanged();
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     i
 * JD-Core Version:    0.7.0.1
 */