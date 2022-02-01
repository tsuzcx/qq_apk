import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class imk
  implements DialogInterface.OnDismissListener
{
  public imk(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QfileBaseCloudFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     imk
 * JD-Core Version:    0.7.0.1
 */