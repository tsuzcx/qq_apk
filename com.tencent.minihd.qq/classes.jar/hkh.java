import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class hkh
  implements DialogInterface.OnClickListener
{
  public hkh(QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    HotChatListActivity.a();
    ReportController.b(this.a, "CliOper", "", "", "0X8004C6B", "0X8004C6B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hkh
 * JD-Core Version:    0.7.0.1
 */