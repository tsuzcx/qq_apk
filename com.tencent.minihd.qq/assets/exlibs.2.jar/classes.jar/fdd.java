import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountInfoListActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;

public class fdd
  implements Runnable
{
  public fdd(SubAccountInfoListActivity paramSubAccountInfoListActivity) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.a, SubAccountUgActivity.class);
    localIntent.putExtra("fromWhere", this.a.a);
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdd
 * JD-Core Version:    0.7.0.1
 */