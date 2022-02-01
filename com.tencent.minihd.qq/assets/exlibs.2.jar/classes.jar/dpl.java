import android.content.Intent;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.widget.QQProgressDialog;

class dpl
  implements Runnable
{
  dpl(dpk paramdpk) {}
  
  public void run()
  {
    if ((this.a.a.a != null) && (this.a.a.a.isShowing()) && (!this.a.a.isFinishing())) {
      this.a.a.a.dismiss();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.a.setResult(-1, localIntent);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpl
 * JD-Core Version:    0.7.0.1
 */