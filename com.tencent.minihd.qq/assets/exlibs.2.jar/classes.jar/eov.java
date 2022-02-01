import android.app.Dialog;
import com.tencent.mobileqq.activity.OpenidToUinActivity;
import com.tencent.mobileqq.utils.sso.SsosvrrObserver;
import com.tencent.mobileqq.utils.sso.SsosvrrObserver.SsosvrrData;
import com.tencent.qphone.base.util.QLog;

public class eov
  extends SsosvrrObserver
{
  public eov(OpenidToUinActivity paramOpenidToUinActivity) {}
  
  protected void a(boolean paramBoolean, SsosvrrObserver.SsosvrrData paramSsosvrrData)
  {
    OpenidToUinActivity.a(this.a, System.currentTimeMillis() - OpenidToUinActivity.a(this.a));
    OpenidToUinActivity.a(this.a, OpenidToUinActivity.a(this.a), 1);
    if (QLog.isColorLevel()) {
      QLog.d("OpenidToUinActivity", 2, "Is connected to sso server" + String.valueOf(paramBoolean));
    }
    if ((OpenidToUinActivity.a(this.a) != null) && (OpenidToUinActivity.a(this.a).isShowing())) {
      OpenidToUinActivity.a(this.a).dismiss();
    }
    if (!paramBoolean)
    {
      OpenidToUinActivity.a(this.a);
      return;
    }
    if (paramSsosvrrData.d == 0)
    {
      OpenidToUinActivity.a(this.a, OpenidToUinActivity.a(this.a, paramSsosvrrData.c));
      return;
    }
    OpenidToUinActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eov
 * JD-Core Version:    0.7.0.1
 */