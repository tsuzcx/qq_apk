import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class jir
  implements URLDrawable.DownloadListener
{
  long jdField_a_of_type_Long;
  
  public jir(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actNearbyPeoplePicDownload", false, l1 - l2, 0L, localHashMap, "");
  }
  
  public void onFileDownloadStarted()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actNearbyPeoplePicDownload", true, l1 - l2, paramLong, null, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jir
 * JD-Core Version:    0.7.0.1
 */