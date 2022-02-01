import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;

public class dno
  implements DialogInterface.OnClickListener
{
  public dno(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new dnp(this).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dno
 * JD-Core Version:    0.7.0.1
 */