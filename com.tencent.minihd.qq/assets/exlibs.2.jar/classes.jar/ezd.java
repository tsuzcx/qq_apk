import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.SearchTroopListActivity;

public class ezd
  implements DialogInterface.OnCancelListener
{
  public ezd(SearchTroopListActivity paramSearchTroopListActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ezd
 * JD-Core Version:    0.7.0.1
 */