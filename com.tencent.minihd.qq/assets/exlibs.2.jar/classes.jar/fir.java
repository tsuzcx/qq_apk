import com.tencent.mobileqq.activity.TroopMemberGagActivity;
import com.tencent.mobileqq.activity.TroopMemberGagActivity.GagItemListener;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagItem;

public class fir
  implements TroopMemberGagActivity.GagItemListener
{
  public fir(TroopMemberGagActivity paramTroopMemberGagActivity) {}
  
  public void a(TroopGagMgr.GagItem paramGagItem)
  {
    if (paramGagItem.a > 0) {
      this.a.a = paramGagItem.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fir
 * JD-Core Version:    0.7.0.1
 */