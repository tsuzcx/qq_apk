import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopLocationActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;

public class kib
  implements View.OnClickListener
{
  public kib(TroopLocationActivity paramTroopLocationActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopCreateLogic)this.a.app.getManager(31);
    if (paramView != null) {
      paramView.a(this.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kib
 * JD-Core Version:    0.7.0.1
 */