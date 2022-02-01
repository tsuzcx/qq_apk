import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchActivity;

public class cgo
  extends BroadcastReceiver
{
  public cgo(SearchActivity paramSearchActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Log.i("app2", "searchBroadcastReceiver action=" + paramContext);
    if ("receiver_text".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("text");
      SearchActivity.a(this.a).setText(paramContext);
    }
    do
    {
      return;
      if ("refresh_text".equals(paramContext))
      {
        SearchActivity.b(this.a);
        return;
      }
    } while (!"do_search_text".equals(paramContext));
    paramContext = paramIntent.getStringExtra("keyword");
    SearchActivity.a(this.a).setText(paramContext);
    if (!TextUtils.isEmpty(SearchActivity.a(this.a).getText())) {
      SearchActivity.a(this.a, 2);
    }
    for (;;)
    {
      paramContext = SearchActivity.a(this.a).getText().toString();
      this.a.a(paramContext);
      SearchActivity.a(this.a).setSelection(paramContext.length());
      SearchActivity.a(this.a, false);
      SearchActivity.b(this.a);
      return;
      if (!TextUtils.isEmpty(SearchActivity.a(this.a).getHint())) {
        SearchActivity.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgo
 * JD-Core Version:    0.7.0.1
 */