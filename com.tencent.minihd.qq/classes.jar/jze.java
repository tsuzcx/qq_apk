import android.app.ProgressDialog;
import com.tencent.mobileqq.memoryleak.DumpMemInfoHandler;
import com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class jze
  extends TimerTask
{
  public jze(ShareDumpMemoryActivity paramShareDumpMemoryActivity, ProgressDialog paramProgressDialog) {}
  
  public void run()
  {
    Object[] arrayOfObject = DumpMemInfoHandler.a("mobileqq_leak");
    if (((Boolean)arrayOfObject[0]).booleanValue())
    {
      ShareDumpMemoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity, (String)arrayOfObject[1]);
      if (QLog.isColorLevel()) {
        QLog.d("LeakInspector", 2, "leakFlag=true,ZipFile=true,leakName=" + ShareDumpMemoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity) + ",dumpPath=" + ShareDumpMemoryActivity.b(this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTestassisterActivityShareDumpMemoryActivity.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LeakInspector", 2, "failed dump qq memory");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jze
 * JD-Core Version:    0.7.0.1
 */