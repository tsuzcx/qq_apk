import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EPRecommendTask;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class iet
  implements Runnable
{
  public iet(EPRecommendTask paramEPRecommendTask) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(EPRecommendTask.a(), 2, "url:" + this.a.jdField_a_of_type_JavaLangString + ",type:" + this.a.b);
    }
    try
    {
      if (this.a.b == null) {
        return;
      }
      localObject1 = new File(AppConstants.bk + "tab" + this.a.b + ".tmp");
      if ((this.a.b == null) || (!"3".equals(this.a.b))) {
        break label538;
      }
      localObject1 = new File(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + "/magic_promotion_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + ".json");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        int i;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.emoji.EmoDown", 2, localException.getMessage());
          continue;
          if ((this.a.b != null) && ("3".equals(this.a.b)))
          {
            this.a.a(localException);
          }
          else
          {
            localObject4 = new String(localException, "utf-8");
            if (localObject4 != null)
            {
              Object localObject3 = EmoticonUtils.a((String)localObject4);
              if (localObject3 != null)
              {
                this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0).edit().putString("emosm_recommend_tab_json", (String)localObject4).commit();
                localObject4 = (EmojiManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
                localObject3 = ((List)localObject3).iterator();
                while (((Iterator)localObject3).hasNext()) {
                  ((EmojiManager)localObject4).a((EmoticonPackage)((Iterator)localObject3).next());
                }
              }
            }
          }
        }
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label289;
    }
    localObject4 = new DownloadTask(this.a.jdField_a_of_type_JavaLangString, (File)localObject1);
    ((DownloadTask)localObject4).h = true;
    i = DownloaderFactory.a((DownloadTask)localObject4, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i == 0)
    {
      localObject4 = null;
      try
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (localObject1 != null) {
          if ((this.a.b != null) && ("2".equals(this.a.b)))
          {
            EmoticonUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1);
            label289:
            long l2 = System.currentTimeMillis();
            if (!QLog.isColorLevel()) {
              break label541;
            }
            QLog.d(EPRecommendTask.a(), 2, "costTime:" + (l2 - l1) + ",type:" + this.a.b);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          localOutOfMemoryError1.printStackTrace();
          Object localObject2 = localObject4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iet
 * JD-Core Version:    0.7.0.1
 */