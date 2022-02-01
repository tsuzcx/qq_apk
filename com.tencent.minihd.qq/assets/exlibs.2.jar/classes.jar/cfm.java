import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.eqq.IvrAlertDialogWithInput;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class cfm
  implements View.OnClickListener
{
  public cfm(IvrAlertDialogWithInput paramIvrAlertDialogWithInput, Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    paramView = IvrAlertDialogWithInput.a(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput).getText().toString();
    Object localObject;
    if (IvrAlertDialogWithInput.a(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput) != null)
    {
      localObject = IvrAlertDialogWithInput.a(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput).iterator();
      while (((Iterator)localObject).hasNext())
      {
        HashMap localHashMap = (HashMap)((Iterator)localObject).next();
        String str = (String)localHashMap.get("regular");
        if ((!TextUtils.isEmpty(str)) && (!paramView.matches(str)))
        {
          IvrAlertDialogWithInput.a(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput).setText((CharSequence)localHashMap.get("errorText"));
          IvrAlertDialogWithInput.a(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput).setTextColor(-65536);
          IvrAlertDialogWithInput.a(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput).startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject = new Intent(IvrAlertDialogWithInput.a(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput));
        ((Intent)localObject).putExtra("result", paramView);
        ((Intent)localObject).putExtra("seq", IvrAlertDialogWithInput.a(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput));
        this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput.setResult(-1, (Intent)localObject);
        IvrAlertDialogWithInput.b(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentBizEqqIvrAlertDialogWithInput.app, "CliOper", "", "", "0X8004657", "0X8004657", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cfm
 * JD-Core Version:    0.7.0.1
 */