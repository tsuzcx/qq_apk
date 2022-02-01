import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;

public class hrg
  extends ResourcePluginListener
{
  private hrg(GetConfig paramGetConfig) {}
  
  public void a(byte paramByte)
  {
    if (GetConfig.a(this.a) == 40)
    {
      if ((paramByte != 2) && (paramByte == 3)) {}
      GetConfig.a(this.a).a.c(GetConfig.a(this.a));
      this.a.a(7);
    }
  }
  
  public void b(byte paramByte)
  {
    if ((paramByte != 2) && (paramByte == 3)) {}
    GetConfig.b(this.a).a.d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hrg
 * JD-Core Version:    0.7.0.1
 */