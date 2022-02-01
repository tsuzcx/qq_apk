import NearbyGroup.LBSInfo;
import Wallet.ReqH5Config;
import android.os.Build;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletHomeHandler;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.ipc.PersonalInfoReq;

public class mag
  extends SosoInterface.OnLocationListener
{
  public mag(PersonalInfoReq paramPersonalInfoReq, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject = null;
    if (paramInt == 0) {
      localObject = SosoInterface.a(paramSosoLbsInfo);
    }
    paramSosoLbsInfo = new ReqH5Config();
    paramSosoLbsInfo.lbsInfo = ((LBSInfo)localObject);
    paramSosoLbsInfo.MQVersion = DeviceInfoUtil.a(BaseApplication.getContext());
    paramSosoLbsInfo.MQOS = "Android";
    paramSosoLbsInfo.phoneModel = Build.MODEL;
    localObject = (QWalletHomeHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(34);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq.a);
    ((QWalletHomeHandler)localObject).a(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mag
 * JD-Core Version:    0.7.0.1
 */