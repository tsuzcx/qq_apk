import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.TroopObserver;

public class fgu
  extends TroopObserver
{
  public fgu(TroopGagActivity paramTroopGagActivity) {}
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fgu
 * JD-Core Version:    0.7.0.1
 */