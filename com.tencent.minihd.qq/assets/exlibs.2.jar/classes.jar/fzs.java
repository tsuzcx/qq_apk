import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.List;

public class fzs
  extends EnterpriseQQObserver
{
  public fzs(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.b = EnterpriseQQManager.a(this.a.a).a(this.a.a, this.a.a());
      BusinessCmrTmpChatPie.a(this.a, this.a.b);
      if ((this.a.b != null) && (!this.a.b.isEmpty())) {
        BusinessCmrTmpChatPie.a(this.a, false);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fzs
 * JD-Core Version:    0.7.0.1
 */