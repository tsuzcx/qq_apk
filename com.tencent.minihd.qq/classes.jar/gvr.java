import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecommendAdapter;

public class gvr
  implements View.OnClickListener
{
  public gvr(RecommendAdapter paramRecommendAdapter) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (RecommendAdapter.a(this.a) != null) {
      RecommendAdapter.a(this.a).a(paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvr
 * JD-Core Version:    0.7.0.1
 */