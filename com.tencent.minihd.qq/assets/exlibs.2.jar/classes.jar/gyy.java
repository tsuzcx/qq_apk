import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class gyy
  implements Runnable
{
  public gyy(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "mStartHidingRunnable run");
    }
    ShortVideoPlayActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gyy
 * JD-Core Version:    0.7.0.1
 */