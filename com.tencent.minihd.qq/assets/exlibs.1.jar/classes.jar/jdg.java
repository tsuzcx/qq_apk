import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public final class jdg
  implements Runnable
{
  public jdg(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        return;
      }
      if ("V 5.9.3.3468".contains("CheckIn"))
      {
        AlertDialog localAlertDialog = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).create();
        localAlertDialog.show();
        Object localObject = localAlertDialog.getWindow();
        ((Window)localObject).setContentView(2130903387);
        ((TextView)((Window)localObject).findViewById(2131298055)).setText("Dump内存信息!");
        ((TextView)((Window)localObject).findViewById(2131298058)).setText("是否dump内存信息？");
        Button localButton = (Button)((Window)localObject).findViewById(2131298061);
        localObject = (Button)((Window)localObject).findViewById(2131298060);
        if (localButton != null)
        {
          localButton.setText(2131365737);
          ((Button)localObject).setText(2131365736);
          localButton.setOnClickListener(new jdh(this, localAlertDialog));
          ((Button)localObject).setOnClickListener(new jdj(this, localAlertDialog));
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("ReportLog", 2, "showDumpDialog exception.", localThrowable);
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdg
 * JD-Core Version:    0.7.0.1
 */