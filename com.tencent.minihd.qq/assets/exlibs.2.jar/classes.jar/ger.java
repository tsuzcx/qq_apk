import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class ger
  extends BroadcastReceiver
{
  public ger(SearchResultDialog paramSearchResultDialog) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Log.i("app2", "searchBroadcastReceiver action=" + paramContext);
    if ("receiver_text".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("text");
      SearchResultDialog.a(this.a).setText(paramContext);
    }
    do
    {
      return;
      if ("refresh_text".equals(paramContext))
      {
        SearchResultDialog.a(this.a);
        return;
      }
    } while (!"do_search_text".equals(paramContext));
    paramContext = paramIntent.getStringExtra("keyword");
    SearchResultDialog.a(this.a).a(paramContext, false);
    SearchResultDialog.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ger
 * JD-Core Version:    0.7.0.1
 */