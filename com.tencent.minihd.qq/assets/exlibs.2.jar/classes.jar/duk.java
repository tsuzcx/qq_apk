import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.widget.QQToast;

public class duk
  implements ConditionSearchManager.IConfigListener
{
  public duk(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.a.u == 1) || (this.a.u == 2))
    {
      if (paramBoolean) {
        break label55;
      }
      this.a.b();
      QQToast.a(this.a, 2131369486, 0).b(this.a.getTitleBarHeight());
    }
    label55:
    while (paramInt != 2) {
      return;
    }
    this.a.b();
    this.a.b(this.a.u);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     duk
 * JD-Core Version:    0.7.0.1
 */