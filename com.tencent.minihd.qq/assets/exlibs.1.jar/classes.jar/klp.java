import android.os.Handler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class klp
  implements Runnable
{
  public klp(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void run()
  {
    if (VideoPlayLogic.a(this.a) != null) {
      VideoPlayLogic.c(this.a);
    }
    this.a.b.removeCallbacks(VideoPlayLogic.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     klp
 * JD-Core Version:    0.7.0.1
 */