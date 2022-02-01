import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.OnTroopListClickListener;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.TroopListItem;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.TroopListViewItemTag;

public class hfr
  implements View.OnClickListener
{
  public hfr(ShowExternalTroopListAdapter paramShowExternalTroopListAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof ShowExternalTroopListAdapter.TroopListViewItemTag)) {}
    do
    {
      return;
      paramView = (ShowExternalTroopListAdapter.TroopListViewItemTag)paramView;
    } while ((paramView.a == null) || (paramView.a.a == null));
    this.a.a.a(paramView.a.a, paramView.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hfr
 * JD-Core Version:    0.7.0.1
 */