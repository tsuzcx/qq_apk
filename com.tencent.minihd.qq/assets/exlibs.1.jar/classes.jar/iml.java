import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class iml
  implements DialogInterface.OnCancelListener
{
  public iml(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QfileBaseCloudFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iml
 * JD-Core Version:    0.7.0.1
 */