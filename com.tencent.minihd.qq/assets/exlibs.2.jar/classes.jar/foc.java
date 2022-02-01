import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;

public class foc
  implements View.OnClickListener
{
  public foc(ActivateFriendGrid paramActivateFriendGrid) {}
  
  public void onClick(View paramView)
  {
    paramView = (ActivateFriendGridItem)paramView;
    if (paramView.a)
    {
      ActivateFriendGrid.a(this.a);
      if (paramView.a) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      if (ActivateFriendGrid.a(this.a) != null) {
        ActivateFriendGrid.a(this.a).a(ActivateFriendGrid.c(this.a));
      }
      return;
      ActivateFriendGrid.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     foc
 * JD-Core Version:    0.7.0.1
 */