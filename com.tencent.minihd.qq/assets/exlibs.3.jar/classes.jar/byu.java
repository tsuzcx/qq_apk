import android.os.Handler;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.AppInterface;

public class byu
  implements Runnable
{
  public byu(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void run()
  {
    if (!this.a.d)
    {
      boolean bool = SmallScreenUtils.a(((AppInterface)BaseSmallScreenService.a(this.a)).a());
      if (bool != this.a.e)
      {
        this.a.e = bool;
        this.a.e();
      }
      bool = SmallScreenUtils.g();
      if (bool != this.a.b)
      {
        this.a.b = bool;
        this.a.d();
      }
      bool = SmallScreenUtils.b(((AppInterface)BaseSmallScreenService.b(this.a)).a());
      if (bool != this.a.c)
      {
        this.a.c = bool;
        this.a.c();
      }
      bool = this.a.a();
      if (bool != this.a.f)
      {
        this.a.f = bool;
        this.a.a(0L);
      }
      this.a.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     byu
 * JD-Core Version:    0.7.0.1
 */