import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBarData;

public class gdm
  implements Runnable
{
  public gdm(LightalkBlueTipsBar paramLightalkBlueTipsBar) {}
  
  public void run()
  {
    LightalkBlueTipsBarData localLightalkBlueTipsBarData = LightalkBlueTipsBarData.a();
    if (localLightalkBlueTipsBarData != null)
    {
      this.a.b = localLightalkBlueTipsBarData.e;
      this.a.c = localLightalkBlueTipsBarData.f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdm
 * JD-Core Version:    0.7.0.1
 */