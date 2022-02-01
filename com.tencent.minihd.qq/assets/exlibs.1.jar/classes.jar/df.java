import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.DLRouterSessionInfoRequestTask;
import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.litetransfersdk.ProgressInfo;

public class df
  implements View.OnClickListener
{
  public df(DLRouterSessionListAdapter paramDLRouterSessionListAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = (ProgressInfo)paramView.getTag();
    if (paramView != null)
    {
      paramView.SetStatus(1);
      this.a.a.a(paramView.uint64_sessionid, 12);
      DLRouterSessionListAdapter.a(this.a, 32);
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     df
 * JD-Core Version:    0.7.0.1
 */