import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class elh
  implements ConditionSearchManager.IConfigListener
{
  public elh(NearPeopleFilterActivity paramNearPeopleFilterActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.c();
    if (!paramBoolean) {
      QQToast.a(BaseApplication.getContext(), 2131369486, 0).b(this.a.getTitleBarHeight());
    }
    while (paramInt != 2) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elh
 * JD-Core Version:    0.7.0.1
 */