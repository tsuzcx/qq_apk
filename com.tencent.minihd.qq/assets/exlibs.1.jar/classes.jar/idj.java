import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import java.util.Iterator;
import java.util.List;

public class idj
  extends FriendListObserver
{
  public idj(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!MsgBoxListActivity.a(this.a)) {
      MsgBoxListActivity.a(this.a, true);
    }
    while ((!paramBoolean) || (MsgBoxListActivity.a(this.a) == null)) {
      return;
    }
    MsgBoxListActivity.a(this.a).a(paramString, MsgBoxListActivity.a(this.a));
  }
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!MsgBoxListActivity.a(this.a)) {}
    RecentBaseData localRecentBaseData;
    do
    {
      Iterator localIterator;
      do
      {
        MsgBoxListActivity.a(this.a, true);
        return;
        while ((!paramBoolean) || (MsgBoxListActivity.a(this.a) == null) || (MsgBoxListActivity.a(this.a) == null)) {}
        localIterator = MsgBoxListActivity.a(this.a).iterator();
      } while (!localIterator.hasNext());
      localRecentBaseData = (RecentBaseData)localIterator.next();
    } while (!localRecentBaseData.a().equals(paramString1));
    localRecentBaseData.a = paramString2;
    MsgBoxListActivity.a(this.a).a(paramString1, MsgBoxListActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idj
 * JD-Core Version:    0.7.0.1
 */