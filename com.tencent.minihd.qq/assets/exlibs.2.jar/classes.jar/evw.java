import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.RecentSaidActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class evw
  implements AdapterView.OnItemClickListener
{
  public evw(RecentSaidActivity paramRecentSaidActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramAdapterView.a();
    if (paramAdapterView.a().getItemViewType(paramInt) == 0)
    {
      paramAdapterView = (ewc)((Adapter)localObject).getItem(paramInt);
      localObject = this.a;
      Intent localIntent = new Intent((Context)localObject, ChatHistory.class);
      localIntent.putExtra("uin", this.a.d);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("troop_uin", this.a.d);
      localIntent.putExtra("leftViewText", ((Context)localObject).getString(2131366374));
      localIntent.putExtra("from_RecentSaidActivity", true);
      localIntent.putExtra("target_shmsgseq", paramAdapterView.b);
      ((Context)localObject).startActivity(localIntent);
      paramView.clearFocus();
      this.a.a("Clk_abs");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evw
 * JD-Core Version:    0.7.0.1
 */