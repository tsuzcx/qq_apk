import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;

public class hwi
  implements ConditionSearchManager.IConfigListener
{
  public hwi(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean)) {
      this.a.d = true;
    }
    if ((this.a.h == 1) || (this.a.h == 2)) {
      if (!paramBoolean) {
        this.a.b();
      }
    }
    while ((!this.a.c) || (paramInt != 2) || (!paramBoolean))
    {
      QQToast.a(this.a, 2131369486, 0).b(this.a.getTitleBarHeight());
      do
      {
        return;
      } while (paramInt != 2);
      this.a.b();
      this.a.a(this.a.h);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hwi
 * JD-Core Version:    0.7.0.1
 */