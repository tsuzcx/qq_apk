import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;

public class fid
  extends Handler
{
  public fid(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (this.a.s != 1)
    {
      paramMessage = new Intent();
      paramMessage.putExtra("finish_chat_setting", true);
      this.a.a.setResult(-1, paramMessage);
    }
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fid
 * JD-Core Version:    0.7.0.1
 */