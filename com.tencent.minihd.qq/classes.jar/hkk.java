import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class hkk
  implements DialogInterface.OnClickListener
{
  public hkk(QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HotChatManager.a(this.a);
    HotChatManager.b(this.a, true);
    ReportController.b(this.a, "CliOper", "", "", "0X8004D2B", "0X8004D2B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hkk
 * JD-Core Version:    0.7.0.1
 */