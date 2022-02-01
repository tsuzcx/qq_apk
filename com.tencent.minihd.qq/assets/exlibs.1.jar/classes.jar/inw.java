import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class inw
  implements DialogInterface.OnCancelListener
{
  public inw(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    QfileBaseLocalFileTabView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     inw
 * JD-Core Version:    0.7.0.1
 */