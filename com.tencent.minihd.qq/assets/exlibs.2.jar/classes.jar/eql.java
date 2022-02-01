import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import java.util.List;

class eql
  implements View.OnClickListener
{
  eql(eqk parameqk) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof eqj))
    {
      paramView = (eqj)paramView;
      if ((paramView.a >= 0) && (paramView.a < this.a.a.a.size()))
      {
        paramView = (ProfileLabelInfo)this.a.a.a.remove(paramView.a);
        this.a.a.a(this.a.a.a.size());
        this.a.notifyDataSetChanged();
        eqk.a(this.a, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eql
 * JD-Core Version:    0.7.0.1
 */