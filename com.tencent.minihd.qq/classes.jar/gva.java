import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

public class gva
  implements View.OnClickListener
{
  public gva(RecentAdapter paramRecentAdapter) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    int i;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          i = paramView.getId();
        } while ((i < 0) || (i >= this.a.getCount()));
        localObject1 = this.a.getItem(i);
      } while ((localObject1 == null) || (!(localObject1 instanceof RecentBaseData)));
      Object localObject2 = null;
      localObject1 = localObject2;
      if ((paramView instanceof TextView))
      {
        paramView = ((TextView)paramView).getText();
        localObject1 = localObject2;
        if (paramView != null) {
          localObject1 = paramView.toString();
        }
      }
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    this.a.a(i, (String)localObject1, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gva
 * JD-Core Version:    0.7.0.1
 */