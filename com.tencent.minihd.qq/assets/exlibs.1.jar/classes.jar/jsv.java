import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;

public class jsv
  implements View.OnClickListener
{
  public jsv(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (StatusHistoryActivity.ItemViewHolder)paramView.getTag();
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.a);
    this.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsv
 * JD-Core Version:    0.7.0.1
 */