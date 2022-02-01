import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.SubAccountObserver;

class fcx
  extends SubAccountObserver
{
  fcx(fcw paramfcw, SimpleAccount paramSimpleAccount) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Fcw.a.app.a(), "actSBDLoginGetkey", false, 0L, 0L, paramString1, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack: key is empty? why? shit");
      }
      this.jdField_a_of_type_Fcw.a.runOnUiThread(new fcy(this));
    }
    do
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Fcw.a.app.a(), "actSBDLoginGetkey", true, 0L, 0L, paramString1, "");
      paramString1 = (SubAccountProtocManager)this.jdField_a_of_type_Fcw.a.app.getManager(27);
      if (paramString1 != null) {
        paramString1.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), paramString3, this.jdField_a_of_type_Fcw.a.a);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack:getA2 subAccount = " + paramString2 + ".....subA2 = " + paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fcx
 * JD-Core Version:    0.7.0.1
 */