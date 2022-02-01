import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;

public class gsp
  implements Runnable
{
  public gsp(PhotoListActivity paramPhotoListActivity) {}
  
  public void run()
  {
    if (this.a.a == null)
    {
      this.a.a = new gsx(this.a, null);
      this.a.a.execute(new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsp
 * JD-Core Version:    0.7.0.1
 */