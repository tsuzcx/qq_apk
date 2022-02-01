import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class fgg
  implements View.OnClickListener
{
  public fgg(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.b = false;
    if (TroopAssistantActivity.a(this.a) != null)
    {
      TroopAssistantActivity.a(this.a).a(4);
      this.a.f();
      this.a.e();
    }
    if (TroopAssistantManager.a().c()) {
      TroopAssistantManager.a().f(this.a.app);
    }
    TroopAssistantActivity.a(this.a, paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fgg
 * JD-Core Version:    0.7.0.1
 */