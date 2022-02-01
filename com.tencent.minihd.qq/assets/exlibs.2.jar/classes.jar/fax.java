import android.content.Intent;
import com.tencent.mobileqq.activity.SoftInputActivity;
import com.tencent.mobileqq.widget.BackKeyEditText.EditCallBack;

public class fax
  implements BackKeyEditText.EditCallBack
{
  public fax(SoftInputActivity paramSoftInputActivity) {}
  
  public void a()
  {
    Intent localIntent = new Intent("refresh_text");
    this.a.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fax
 * JD-Core Version:    0.7.0.1
 */