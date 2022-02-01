import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.SigTlpGridViewAdapter;
import com.tencent.mobileqq.vas.SigTlpGridViewAdapter.Holder;

public class kvo
  implements View.OnClickListener
{
  public kvo(SigTlpGridViewAdapter paramSigTlpGridViewAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = (SigTlpGridViewAdapter.Holder)paramView.getTag();
    Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.a);
    this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "set_clk_activity", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvo
 * JD-Core Version:    0.7.0.1
 */