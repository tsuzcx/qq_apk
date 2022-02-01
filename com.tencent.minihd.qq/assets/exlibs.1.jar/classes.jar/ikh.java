import android.os.Handler;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;

class ikh
  implements Runnable
{
  ikh(ikg paramikg) {}
  
  public void run()
  {
    if (this.a.a.e)
    {
      this.a.a.d();
      return;
    }
    this.a.a.e();
    this.a.a.d();
    new Handler().postDelayed(new iki(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ikh
 * JD-Core Version:    0.7.0.1
 */