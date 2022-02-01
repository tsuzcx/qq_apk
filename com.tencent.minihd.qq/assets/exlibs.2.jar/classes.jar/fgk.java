import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack;

public class fgk
  implements Runnable
{
  public fgk(TroopClassChoiceActivity.GetClassChoiceCallBack paramGetClassChoiceCallBack) {}
  
  public void run()
  {
    TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fgk
 * JD-Core Version:    0.7.0.1
 */