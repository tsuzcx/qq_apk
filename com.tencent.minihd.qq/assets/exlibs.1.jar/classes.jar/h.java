import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLRouterActivity;
import com.dataline.activities.RouterAdvanceActivity;

public class h
  implements View.OnClickListener
{
  public h(DLRouterActivity paramDLRouterActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, RouterAdvanceActivity.class);
    paramView.putExtra("guid_flag", DLRouterActivity.a(this.a));
    paramView.putExtra("uin", DLRouterActivity.b(this.a));
    this.a.startActivityForResult(paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     h
 * JD-Core Version:    0.7.0.1
 */