import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.MsgBoxListActivity;

public class idk
  implements Runnable
{
  public idk(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void run()
  {
    if (MsgBoxListActivity.a(this.a) != null)
    {
      MsgBoxListActivity.a(this.a).a("msglist_carrier");
      this.a.runOnUiThread(new idl(this));
      LBSHandler localLBSHandler = (LBSHandler)this.a.app.a(3);
      if (localLBSHandler != null) {
        localLBSHandler.a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idk
 * JD-Core Version:    0.7.0.1
 */