import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkSendTipsActivity;
import java.util.ArrayList;

public class lyf
  implements View.OnClickListener
{
  public lyf(QlinkSendTipsActivity paramQlinkSendTipsActivity) {}
  
  public void onClick(View paramView)
  {
    QlinkSendTipsActivity.a(this.a, true);
    if (QlinkSendTipsActivity.a(this.a))
    {
      paramView = new Intent();
      paramView.putExtra("_FILE_PATH_", QlinkSendTipsActivity.a(this.a));
      this.a.setResult(10, paramView);
    }
    for (;;)
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
      paramView = new Bundle();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(QlinkSendTipsActivity.a(this.a));
      paramView.putStringArrayList("string_filepaths", localArrayList);
      QQProxyForQlink.a(this.a, 6, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyf
 * JD-Core Version:    0.7.0.1
 */