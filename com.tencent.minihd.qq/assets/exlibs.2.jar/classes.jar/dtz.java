import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class dtz
  implements Runnable
{
  public dtz(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(49)).b(this.a.app.a());
    this.a.app.runOnUiThread(new dua(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtz
 * JD-Core Version:    0.7.0.1
 */