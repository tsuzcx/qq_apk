import android.app.Dialog;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ekn
  implements Runnable
{
  ekn(ekm paramekm) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a.a, 230).setTitle(this.a.a.getString(2131367697)).setMessage(String.format(this.a.a.getString(2131367698), new Object[] { this.a.a.b })).setPositiveButton(2131366212, new eko(this));
    localQQCustomDialog.setOnDismissListener(new ekp(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ekn
 * JD-Core Version:    0.7.0.1
 */