import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.log.ReportLogHelper;
import java.util.Timer;

class jdh
  implements View.OnClickListener
{
  jdh(jdg paramjdg, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    paramView = ReportLogHelper.a(this.jdField_a_of_type_Jdg.a, 2131367583);
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    paramView.show();
    new Timer().schedule(new jdi(this, paramView), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdh
 * JD-Core Version:    0.7.0.1
 */