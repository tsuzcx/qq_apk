import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.app.QQServiceEntry.Tag;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class hfl
  implements View.OnLongClickListener
{
  public hfl(ForwardRecentListAdapter paramForwardRecentListAdapter) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = (QQServiceEntry.Tag)paramView.getTag();
    if ((Long.valueOf(paramView.jdField_a_of_type_JavaLangString).longValue() > 10000L) && (paramView.jdField_a_of_type_Int == 0)) {
      this.a.a(paramView.b, paramView.jdField_a_of_type_JavaLangString).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hfl
 * JD-Core Version:    0.7.0.1
 */