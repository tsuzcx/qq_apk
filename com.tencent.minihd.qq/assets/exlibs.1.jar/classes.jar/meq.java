import CardPay.LBSInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.thirdpay.ThirdPayManager;

public final class meq
  extends SosoInterface.OnLocationListener
{
  public meq(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramSosoLbsInfo == null)
      {
        str = "soso lbs info null.";
        QLog.i("ThirdPayManager", 2, str);
      }
    }
    else {
      if (paramInt != 0) {
        break label106;
      }
    }
    label106:
    for (paramSosoLbsInfo = new LBSInfo(paramSosoLbsInfo.a.jdField_a_of_type_Double, paramSosoLbsInfo.a.b, paramSosoLbsInfo.a.c, paramSosoLbsInfo.a.jdField_a_of_type_Float, paramSosoLbsInfo.a.d, paramSosoLbsInfo.a.e, paramSosoLbsInfo.a.f, paramSosoLbsInfo.a.g);; paramSosoLbsInfo = new LBSInfo())
    {
      ThirdPayManager.a(this.a, paramSosoLbsInfo);
      return;
      str = paramSosoLbsInfo.toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     meq
 * JD-Core Version:    0.7.0.1
 */