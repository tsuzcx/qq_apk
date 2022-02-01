import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;

class fhu
  implements Runnable
{
  fhu(fht paramfht) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.a.a.app.a(19);
    if (localTroopHandler != null) {
      localTroopHandler.l(this.a.a.a.troopuin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhu
 * JD-Core Version:    0.7.0.1
 */