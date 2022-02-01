import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyNet;
import com.tencent.qqmusicplayerprocess.netspeed.VkeyManager;

public class lqa
  implements Runnable
{
  public lqa(VkeyManager paramVkeyManager) {}
  
  public void run()
  {
    synchronized ()
    {
      if (VkeyManager.access$100(this.a) != null)
      {
        VkeyManager.access$100(this.a).a();
        VkeyManager.access$102(this.a, null);
      }
      VkeyManager.access$200().getVKey();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lqa
 * JD-Core Version:    0.7.0.1
 */