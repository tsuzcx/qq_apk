import android.os.Bundle;
import com.tencent.biz.helper.TroopInfoActivityHelper;
import com.tencent.biz.helper.TroopInfoActivityHelper.IGetSameCityCheckTypeInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class cgj
  implements BusinessObserver
{
  public cgj(QQAppInterface paramQQAppInterface, TroopInfoActivityHelper.IGetSameCityCheckTypeInfo paramIGetSameCityCheckTypeInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$IGetSameCityCheckTypeInfo);
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
    }
    this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$IGetSameCityCheckTypeInfo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgj
 * JD-Core Version:    0.7.0.1
 */