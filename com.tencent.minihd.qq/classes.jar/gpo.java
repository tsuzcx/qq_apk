import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.phone.BindNumberBusinessActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class gpo
  extends ContactBindObserver
{
  public gpo(BindNumberBusinessActivity paramBindNumberBusinessActivity) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    super.b(paramBoolean, paramBundle);
    BindNumberBusinessActivity localBindNumberBusinessActivity = this.a;
    if (paramBoolean)
    {
      ((PhoneContactManager)this.a.app.getManager(10)).c();
      this.a.a.sendEmptyMessage(4);
      MyBusinessActivity.c(true);
      if (QLog.isColorLevel()) {
        QLog.d("BindNumberBusinessActivity", 2, "rebind successed");
      }
    }
    for (;;)
    {
      this.a.a();
      this.a.app.unRegistObserver(BindNumberBusinessActivity.a(this.a));
      BindNumberBusinessActivity.a(this.a, null);
      return;
      int i = -1;
      if (paramBundle != null) {
        i = paramBundle.getInt("k_result");
      }
      QQToast.a(localBindNumberBusinessActivity, a(i), 2000).b(localBindNumberBusinessActivity.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d("BindNumberBusinessActivity", 2, "rebind failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gpo
 * JD-Core Version:    0.7.0.1
 */