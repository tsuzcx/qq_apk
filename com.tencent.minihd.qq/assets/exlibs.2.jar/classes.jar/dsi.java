import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class dsi
  extends BizTroopObserver
{
  public dsi(Conversation paramConversation) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean)
    {
      TroopAssistantManager.a().b(paramString1, this.a.app);
      this.a.a(8, AppConstants.aa, 5000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsi
 * JD-Core Version:    0.7.0.1
 */