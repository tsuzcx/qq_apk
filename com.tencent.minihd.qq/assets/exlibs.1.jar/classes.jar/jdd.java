import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.log.ReportLog;

public final class jdd
  extends Handler
{
  public jdd(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10000001)
    {
      paramMessage = (ProgressBar)ReportLog.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131296605);
      localDrawable = ReportLog.jdField_a_of_type_AndroidAppProgressDialog.getContext().getResources().getDrawable(2130838252);
      paramMessage.setIndeterminateDrawable(localDrawable);
      paramMessage.setBackgroundDrawable(localDrawable);
      ((TextView)ReportLog.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131296606)).setText(2131367566);
      ReportLog.a().sendEmptyMessageDelayed(10000002, 2000L);
    }
    while ((paramMessage.what != 10000002) || (ReportLog.jdField_a_of_type_AndroidAppProgressDialog == null))
    {
      Drawable localDrawable;
      return;
    }
    try
    {
      ReportLog.jdField_a_of_type_Boolean = false;
      ReportLog.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      return;
    }
    finally
    {
      ReportLog.jdField_a_of_type_AndroidAppProgressDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdd
 * JD-Core Version:    0.7.0.1
 */