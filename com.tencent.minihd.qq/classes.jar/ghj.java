import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.contact.newfriend.CircleGroupListView;
import com.tencent.mobileqq.data.CircleGroup;
import java.util.ArrayList;

public class ghj
  extends BaseAdapter
{
  private ghj(CircleGroupListView paramCircleGroupListView) {}
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.a.a();
    }
    this.a.a(paramViewGroup, (CircleGroup)this.a.a.get(paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ghj
 * JD-Core Version:    0.7.0.1
 */