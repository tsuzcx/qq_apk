import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.config.NearbyBannerManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class hxm
  implements Runnable
{
  public hxm(NearbyBannerManager paramNearbyBannerManager, List paramList1, List paramList2) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder("removeAllBanners | ");
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder1.append((String)((Iterator)localObject).next()).append(",");
        }
        QLog.d("NearbyBanner.Manager", 2, localException.toString());
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyBanner.Manager", 2, "removeAllBanners' runnable", localException);
      }
      return;
    }
    String str = NearbyBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager).getString("key_expired_banner", "");
    Object localObject = str.split("\\|");
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i;
    if (localObject.length > 20)
    {
      i = localObject.length - 20;
      while (i < localObject.length)
      {
        localStringBuilder2.append(localObject[i]).append("|");
        i += 1;
      }
    }
    localStringBuilder2.append(str);
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localStringBuilder2.append((String)this.jdField_a_of_type_JavaUtilList.get(i)).append((String)this.b.get(i)).append("|");
        i += 1;
      }
      else
      {
        NearbyBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager).edit().putString("key_expired_banner", localStringBuilder2.toString()).commit();
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hxm
 * JD-Core Version:    0.7.0.1
 */