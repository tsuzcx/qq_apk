import com.tencent.mobileqq.dating.DetailModel;
import com.tencent.mobileqq.dating.widget.CustomTabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;

public class icy
  implements CustomTabBarView.OnTabChangeListener
{
  public icy(DetailModel paramDetailModel) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("Q.dating.detail", 4, "innerTabBar ontabchanged index is: " + paramInt);
    }
    DetailModel.a(this.a, paramInt, true, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icy
 * JD-Core Version:    0.7.0.1
 */