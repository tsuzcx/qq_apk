import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.widget.UpScrollHideView.onViewHideListener;

public class gdv
  implements UpScrollHideView.onViewHideListener
{
  public gdv(TroopAssistTipsBar paramTroopAssistTipsBar) {}
  
  public void a()
  {
    if (this.a.a()) {
      TroopAssistantManager.a().a(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdv
 * JD-Core Version:    0.7.0.1
 */