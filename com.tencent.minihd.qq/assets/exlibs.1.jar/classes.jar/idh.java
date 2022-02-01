import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import java.util.List;

public class idh
  extends LBSObserver
{
  public idh(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (paramList == null) {}
    for (String str = "null";; str = String.valueOf(paramList.size()))
    {
      DatingUtil.a("DatingMsgListActivity", new Object[] { "onGetEntrance", Boolean.valueOf(paramBoolean), str });
      if ((paramBoolean) && (MsgBoxListActivity.a(this.a) != null))
      {
        MsgBoxListActivity.a(this.a).a(paramList, 0);
        this.a.runOnUiThread(new idi(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idh
 * JD-Core Version:    0.7.0.1
 */