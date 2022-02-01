import android.view.ViewStub;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.qphone.base.util.QLog;

public class ido
  implements Runnable
{
  public ido(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void run()
  {
    if (MsgBoxListActivity.a(this.a) == null)
    {
      MsgBoxListActivity.a(this.a, new RecentAdapter(this.a, this.a.app, MsgBoxListActivity.a(this.a), this.a, 0));
      MsgBoxListActivity.a(this.a).a(MsgBoxListActivity.a(this.a));
      MsgBoxListActivity.a(this.a).setAdapter(MsgBoxListActivity.a(this.a));
    }
    if (MsgBoxListActivity.a(this.a).a() == -1)
    {
      MsgBoxListActivity.a(this.a).b(MsgBoxListActivity.a(this.a));
      MsgBoxListActivity.a(this.a).setVisibility(8);
      if (!MsgBoxListActivity.a(this.a))
      {
        MsgBoxListActivity.b(this.a, true);
        if (MsgBoxListActivity.b(this.a))
        {
          MsgBoxListActivity.a(this.a, false);
          MsgBoxListActivity.a(this.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("DatingMsgListActivity", 2, "init ui cost time : " + (System.currentTimeMillis() - MsgBoxListActivity.a(this.a)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ido
 * JD-Core Version:    0.7.0.1
 */