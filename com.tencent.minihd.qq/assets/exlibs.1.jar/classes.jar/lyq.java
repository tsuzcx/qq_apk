import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.DailogClickInfo;
import cooperation.qlink.QlinkStandardDialogActivity;

public class lyq
  implements DialogInterface.OnClickListener
{
  public lyq(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.a().a("0X8004750", 1);
    this.a.app.a().a(new QlAndQQInterface.DailogClickInfo(9));
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("topAct:");
      if (QlinkStandardDialogActivity.a(this.a) == null) {
        break label139;
      }
    }
    label139:
    for (paramDialogInterface = QlinkStandardDialogActivity.a(this.a).getLocalClassName();; paramDialogInterface = "null")
    {
      QLog.d("QlinkStandardDialogActivity", 2, paramDialogInterface);
      if ((QlinkStandardDialogActivity.a(this.a) == null) || (!(QlinkStandardDialogActivity.a(this.a) instanceof FMActivity)) || (((FMActivity)QlinkStandardDialogActivity.a(this.a)).e() != 0)) {
        break;
      }
      this.a.finish();
      return;
    }
    FileManagerUtil.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyq
 * JD-Core Version:    0.7.0.1
 */