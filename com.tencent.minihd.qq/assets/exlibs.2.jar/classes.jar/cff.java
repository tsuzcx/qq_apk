import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.eqq.EnterpriseDetailActivity;

public class cff
  implements DialogInterface.OnDismissListener
{
  public cff(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    EnterpriseDetailActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cff
 * JD-Core Version:    0.7.0.1
 */