import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;

class jyx
  implements DialogInterface.OnClickListener
{
  jyx(jyw paramjyw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ShareAppLogActivity.a(this.a.a).a(false);
    ShareAppLogActivity.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jyx
 * JD-Core Version:    0.7.0.1
 */