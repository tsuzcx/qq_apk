import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class fcv
  implements Runnable
{
  public fcv(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.a.getBaseContext(), SubLoginActivity.class);
    localIntent.putExtra("fromWhere", this.a.a);
    this.a.finish();
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fcv
 * JD-Core Version:    0.7.0.1
 */