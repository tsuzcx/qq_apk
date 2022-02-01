import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;

class exz
  implements View.OnClickListener
{
  exz(exy paramexy) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)this.a.a.getSystemService("clipboard")).setText(RegisterQQNumberActivity.a(this.a.a) + "");
      return;
    }
    ((android.content.ClipboardManager)this.a.a.getSystemService("clipboard")).setText(RegisterQQNumberActivity.a(this.a.a) + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     exz
 * JD-Core Version:    0.7.0.1
 */