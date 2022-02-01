import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;

class dvp
  implements View.OnClickListener
{
  dvp(dvo paramdvo) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, DiscussionMemberActivity.class);
    paramView.putExtra("uin", DiscussionInfoCardActivity.a(this.a.a));
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvp
 * JD-Core Version:    0.7.0.1
 */