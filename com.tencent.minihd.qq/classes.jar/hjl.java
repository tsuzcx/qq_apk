import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class hjl
  implements Runnable
{
  public hjl(EmoticonManagerImp paramEmoticonManagerImp, String paramString) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a.a(EmoticonKeyword.class, EmoticonKeyword.class.getSimpleName(), false, "epId=?", new String[] { this.jdField_a_of_type_JavaLangString }, null, null, null, null);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          EmoticonKeyword localEmoticonKeyword = (EmoticonKeyword)((Iterator)localObject).next();
          try
          {
            Thread.sleep(300L);
            this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a.b(localEmoticonKeyword);
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
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, "asyncRemoveEmotionKeyword,epId=" + this.jdField_a_of_type_JavaLangString);
    }
    EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp);
    this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjl
 * JD-Core Version:    0.7.0.1
 */