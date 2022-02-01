import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import mqq.app.AppRuntime;

public class hkx
  extends hkd
{
  protected void a(String paramString)
  {
    GuardManager localGuardManager = this.a;
    if ("com.tencent.minihd.qq".equals(paramString)) {}
    for (int i = 2;; i = 3)
    {
      localGuardManager.a(i, paramString);
      return;
    }
  }
  
  protected void b()
  {
    this.a.a(6, "fake_p_msg");
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    this.a.f();
    this.a.b(true);
    BaseApplicationImpl.a.a().onGuardEvent(4, hjz.a().a, 0L);
    CoreService.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hkx
 * JD-Core Version:    0.7.0.1
 */