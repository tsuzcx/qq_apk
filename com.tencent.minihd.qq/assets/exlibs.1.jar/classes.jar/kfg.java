import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.QLifeCommentActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

public class kfg
  extends BroadcastReceiver
{
  private kfg(QLifeCommentActivity paramQLifeCommentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("qlifeShopSelect"))) {
        break label43;
      }
    }
    label43:
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QLifeCommentActivity", 2, "onReceive:" + paramContext);
        }
        try
        {
          paramContext = new JSONObject(paramContext);
          paramIntent = paramContext.optString("selectTitle");
          String str1 = paramContext.optString("selectContent");
          String str2 = paramContext.optString("shopID");
          if (!TextUtils.isEmpty(paramIntent)) {
            this.a.d.setText(paramIntent);
          }
          if (!TextUtils.isEmpty(str1)) {
            this.a.e.setText(str1);
          }
          if (!TextUtils.isEmpty(str2))
          {
            QLifeCommentActivity.a(this.a, str2);
            QLifeCommentActivity.b(this.a, paramContext.optString("sp"));
            QLifeCommentActivity.c(this.a, paramContext.optString("idType"));
            QLifeCommentActivity.d(this.a, paramContext.optString("source"));
            if (this.a.a != null) {
              this.a.a.a = true;
            }
            TroopBarUtils.a.clear();
            this.a.S = ("https://cgi.qlife.qq.com/cgi-bin/social/binary_upload.fcg?sid=" + QLifeCommentActivity.b(this.a) + "&sp=" + QLifeCommentActivity.c(this.a) + "&shopid=" + QLifeCommentActivity.d(this.a));
            return;
          }
        }
        catch (JSONException paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QLifeCommentActivity", 2, "onReceive JSONException : " + paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kfg
 * JD-Core Version:    0.7.0.1
 */