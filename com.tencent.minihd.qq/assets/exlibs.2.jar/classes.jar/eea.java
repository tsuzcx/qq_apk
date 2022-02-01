import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.qphone.base.util.QLog;

public class eea
  implements View.OnClickListener
{
  public eea(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onClick(View paramView)
  {
    if (HongbaoShowerActivity.a(this.a) == 0)
    {
      HongbaoShowerActivity.b(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HongbaoShowerActivity", 2, "showHongbao empty|over " + HongbaoShowerActivity.a(this.a));
    }
    this.a.setResult(-1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eea
 * JD-Core Version:    0.7.0.1
 */