import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

class cjw
  extends SosoInterface.OnLocationListener
{
  cjw(cjv paramcjv, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0) {}
    try
    {
      double d1 = Double.valueOf(paramSosoLbsInfo.a.a * 1000000.0D).intValue();
      double d2 = Double.valueOf(paramSosoLbsInfo.a.b * 1000000.0D).intValue();
      this.jdField_a_of_type_Cjv.a.a(this.jdField_a_of_type_Cjv.a.a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Cjv.a.u, this.jdField_a_of_type_Cjv.a.v, true, d1, d2, (BusinessObserver)PublicAccountManager.a(this.jdField_a_of_type_Cjv.a).get());
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
      this.jdField_a_of_type_Cjv.a.a(this.jdField_a_of_type_Cjv.a.a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Cjv.a.u, this.jdField_a_of_type_Cjv.a.v, false, 0.0D, 0.0D, (BusinessObserver)PublicAccountManager.a(this.jdField_a_of_type_Cjv.a).get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjw
 * JD-Core Version:    0.7.0.1
 */