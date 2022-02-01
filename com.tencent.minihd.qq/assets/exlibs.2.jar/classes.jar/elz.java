import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.config.NearbyBannerManager.INearbyBannerListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class elz
  implements NearbyBannerManager.INearbyBannerListener
{
  public elz(NearbyActivity paramNearbyActivity) {}
  
  public void a(boolean paramBoolean, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "onUpdateConfig isSuccess : " + paramBoolean + "|banner size:" + paramList.size());
    }
    if (paramBoolean)
    {
      NearbyActivity.b(this.a).clear();
      NearbyActivity.b(this.a).addAll(paramList);
      if (NearbyActivity.a(this.a) != null) {
        this.a.b(NearbyActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elz
 * JD-Core Version:    0.7.0.1
 */