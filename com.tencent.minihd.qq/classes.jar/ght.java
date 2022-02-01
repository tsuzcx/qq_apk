import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class ght
  implements Runnable
{
  ght(ghs paramghs) {}
  
  public void run()
  {
    ((PhoneContactManagerImp)this.a.a.app.getManager(10)).g();
    ReportController.b(this.a.a.app, "CliOper", "", "", "frd_recommend", "clean_offer", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ght
 * JD-Core Version:    0.7.0.1
 */