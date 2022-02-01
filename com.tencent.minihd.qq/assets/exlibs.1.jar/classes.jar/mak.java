import NearbyGroup.LBSInfo;
import Wallet.ReqApplication;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletHomeHandler;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.ipc.RecommendReq;

public class mak
  extends SosoInterface.OnLocationListener
{
  public mak(RecommendReq paramRecommendReq, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject = new LBSInfo();
    if (paramInt == 0) {
      localObject = SosoInterface.a(paramSosoLbsInfo);
    }
    paramSosoLbsInfo = new ReqApplication();
    paramSosoLbsInfo.lbsInfo = ((LBSInfo)localObject);
    paramSosoLbsInfo.MQVersion = DeviceInfoUtil.a(BaseApplication.getContext());
    paramSosoLbsInfo.MQOS = "Android";
    paramSosoLbsInfo.phoneModel = Build.MODEL;
    paramSosoLbsInfo.extraInfo = "0";
    paramSosoLbsInfo.backInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject = BaseApplication.getContext();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getResources().getDisplayMetrics();
      if (localObject != null)
      {
        paramSosoLbsInfo.screenHeigth = ((DisplayMetrics)localObject).heightPixels;
        paramSosoLbsInfo.screenWidth = ((DisplayMetrics)localObject).widthPixels;
      }
    }
    localObject = (QWalletHomeHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(34);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_CooperationQwalletPluginIpcRecommendReq.a);
    ((QWalletHomeHandler)localObject).a(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mak
 * JD-Core Version:    0.7.0.1
 */