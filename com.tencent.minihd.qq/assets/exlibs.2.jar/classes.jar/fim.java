import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;

public class fim
  implements View.OnClickListener
{
  public fim(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.c()) {
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    TroopMemberCardActivity.a(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fim
 * JD-Core Version:    0.7.0.1
 */