import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.statistics.ReportController;

class ghr
  implements Runnable
{
  ghr(ghp paramghp) {}
  
  public void run()
  {
    SystemMsgListView.a(this.a.a.app);
    ReportController.b(this.a.a.app, "CliOper", "", "", "frd_recommend", "clean_apply", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ghr
 * JD-Core Version:    0.7.0.1
 */