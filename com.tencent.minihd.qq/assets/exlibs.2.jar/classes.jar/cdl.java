import android.content.Context;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

public final class cdl
  extends Thread
{
  public cdl(int paramInt, String paramString1, Context paramContext, String paramString2, AsyncBack paramAsyncBack, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "start checkUpThread. delay:" + this.jdField_a_of_type_Int + ", businessId:" + this.jdField_a_of_type_JavaLangString);
    }
    cdq localcdq = new cdq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Int > 0) {}
    try
    {
      Thread.sleep(this.jdField_a_of_type_Int * 1000);
      localcdq.a();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdl
 * JD-Core Version:    0.7.0.1
 */