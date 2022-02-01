import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.NearbyTransitActivity;

public class ids
  implements View.OnClickListener
{
  public ids(NearbyTransitActivity paramNearbyTransitActivity) {}
  
  public void onClick(View paramView)
  {
    if ((NearbyTransitActivity.a(this.a) != null) && (NearbyTransitActivity.a(this.a).isShowing())) {
      NearbyTransitActivity.a(this.a).dismiss();
    }
    NearbyTransitActivity.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ids
 * JD-Core Version:    0.7.0.1
 */