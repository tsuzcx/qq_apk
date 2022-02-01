import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.qphone.base.util.QLog;

public class hse
  implements Runnable
{
  public hse(LbsInfoMgr paramLbsInfoMgr) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    long l = System.currentTimeMillis();
    LbsInfoMgr.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    LbsInfoMgr.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.i("LbsInfoMgr", 2, "上报操作完成，耗时: " + (System.currentTimeMillis() - l));
    }
    if (QLog.isColorLevel()) {
      QLog.i("LbsInfoMgr", 2, "reportLbsInfoToServer: time = " + this.a.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hse
 * JD-Core Version:    0.7.0.1
 */