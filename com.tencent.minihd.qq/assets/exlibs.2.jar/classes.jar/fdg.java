import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SubAccountInfoListActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.List;

public class fdg
  extends FriendListObserver
{
  public fdg(SubAccountInfoListActivity paramSubAccountInfoListActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    label235:
    for (;;)
    {
      return;
      if (SubAccountInfoListActivity.a(this.a) != null) {}
      for (int i = SubAccountInfoListActivity.a(this.a).getChildCount();; i = 0)
      {
        if (SubAccountInfoListActivity.a(this.a) == null) {
          break label235;
        }
        while (j < SubAccountInfoListActivity.a(this.a).size())
        {
          if ((i > j) && (SubAccountInfoListActivity.a(this.a).get(j) != null) && (paramString.equals(((SubAccountInfo)SubAccountInfoListActivity.a(this.a).get(j)).subuin)))
          {
            TextView localTextView1 = (TextView)SubAccountInfoListActivity.a(this.a).getChildAt(j).findViewById(2131298410);
            TextView localTextView2 = (TextView)SubAccountInfoListActivity.a(this.a).getChildAt(j).findViewById(2131302249);
            localTextView1.setText(ContactUtils.g(this.a.app, paramString));
            localTextView2.setText(this.a.app.b(paramString));
            paramString = this.a.app.b(paramString);
            ((ImageView)SubAccountInfoListActivity.a(this.a).getChildAt(j).findViewById(2131296574)).setImageDrawable(paramString);
            return;
          }
          j += 1;
        }
        break;
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (SubAccountInfoListActivity.a(this.a) != null) {
        i = SubAccountInfoListActivity.a(this.a).getChildCount();
      }
      while (j < SubAccountInfoListActivity.a(this.a).size())
      {
        if ((i > j) && (SubAccountInfoListActivity.a(this.a).get(j) != null) && (paramString.equals(((SubAccountInfo)SubAccountInfoListActivity.a(this.a).get(j)).subuin)))
        {
          paramString = this.a.app.b(paramString);
          ((ImageView)SubAccountInfoListActivity.a(this.a).getChildAt(j).findViewById(2131296574)).setImageDrawable(paramString);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdg
 * JD-Core Version:    0.7.0.1
 */