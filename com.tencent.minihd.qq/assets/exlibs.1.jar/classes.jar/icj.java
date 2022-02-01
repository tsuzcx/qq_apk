import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;

public class icj
  implements View.OnClickListener
{
  public icj(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public void onClick(View paramView)
  {
    if (DatingUserCenterActivity.d(this.a)[DatingUserCenterActivity.a(this.a)] != 0) {}
    do
    {
      return;
      DatingUserCenterActivity.a(this.a, true, true);
      DatingUserCenterActivity.d(this.a)[DatingUserCenterActivity.a(this.a)] = 1;
      if (DatingUserCenterActivity.a(this.a) == 1)
      {
        i = DatingUserCenterActivity.a(this.a, "server_stamp_of_joined");
        int j = DatingUserCenterActivity.a(this.a)[1];
        this.a.a(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(20), Integer.valueOf(4099) });
        return;
      }
    } while (DatingUserCenterActivity.a(this.a) != 0);
    int i = DatingUserCenterActivity.a(this.a, "server_stamp_of_published");
    DatingUserCenterActivity.a(this.a).a(i, DatingUserCenterActivity.a(this.a)[0], 20, 0, 4099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icj
 * JD-Core Version:    0.7.0.1
 */