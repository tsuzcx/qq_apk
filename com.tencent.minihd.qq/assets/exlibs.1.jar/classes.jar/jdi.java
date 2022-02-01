import android.app.ProgressDialog;
import com.tencent.mobileqq.memoryleak.DumpMemInfoHandler;
import java.util.TimerTask;

class jdi
  extends TimerTask
{
  jdi(jdh paramjdh, ProgressDialog paramProgressDialog) {}
  
  public void run()
  {
    DumpMemInfoHandler.a(this.jdField_a_of_type_Jdh.a.a);
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdi
 * JD-Core Version:    0.7.0.1
 */