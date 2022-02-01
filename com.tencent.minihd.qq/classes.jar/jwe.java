import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public final class jwe
  implements View.OnClickListener
{
  public jwe(String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "CliOper", "", "", "0X80060C2", "0X80060C2", 0, 0, this.a, "", this.b, "");
    if (QLog.isColorLevel()) {
      QLog.d("splash", 2, "0X80060C2: md5 = " + this.b);
    }
    BaseApplicationImpl.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwe
 * JD-Core Version:    0.7.0.1
 */