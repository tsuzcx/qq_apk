import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;

public class jzn
  implements Runnable
{
  public jzn(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void run()
  {
    switch (this.a.aO)
    {
    default: 
      return;
    case 0: 
      this.a.c("<BDH_LOG> sendFileNotBlockCallThread() BUT current status is INIT");
      return;
    case 2: 
      this.a.c("<BDH_LOG> sendFileNotBlockCallThread() resume HTTP channel");
      this.a.s();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      this.a.c("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().resumeTransactionTask(this.a.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    this.a.c("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel, but trans == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jzn
 * JD-Core Version:    0.7.0.1
 */