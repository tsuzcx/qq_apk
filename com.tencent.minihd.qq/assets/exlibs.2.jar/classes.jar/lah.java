import android.content.res.Resources;
import android.widget.Button;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.AuthorityActivity;

public class lah
  implements Runnable
{
  public lah(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.a.y == 0) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131368096);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.a.a(this.a.getResources().getString(2131368093), new lai(this));
      return;
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.x);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lah
 * JD-Core Version:    0.7.0.1
 */