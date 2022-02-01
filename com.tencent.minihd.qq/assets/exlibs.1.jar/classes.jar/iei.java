import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.data.PublishDatingOption;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.dating.PublishDatingHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class iei
  extends BroadcastReceiver
{
  public iei(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("event");
    if ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals("appointment"))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.dating", 2, "Web onReceiver return -- Event:" + paramContext);
      }
    }
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("data");
      if (QLog.isColorLevel()) {
        QLog.d("Q.dating", 2, "event:" + paramContext + "  JSONStr:" + paramIntent);
      }
      paramContext = null;
    } while (TextUtils.isEmpty(paramIntent));
    try
    {
      paramIntent = new JSONObject(paramIntent);
      paramContext = paramIntent;
    }
    catch (JSONException paramIntent)
    {
      StringBuffer localStringBuffer;
      for (;;)
      {
        int i;
        paramIntent.printStackTrace();
      }
      PublicDatingActivity.a(this.a).shopInfo.shopZone = localStringBuffer.toString();
    }
    if (paramContext != null)
    {
      i = paramContext.optInt("shopid", -1);
      if (i != -1) {
        PublicDatingActivity.a(this.a).shopInfo.shopId = String.valueOf(i);
      }
      PublicDatingActivity.a(this.a).shopInfo.shopSp = paramContext.optInt("sp", -1);
      PublicDatingActivity.a(this.a).shopInfo.poi = paramContext.optInt("poi", -1);
      PublicDatingActivity.a(this.a).shopInfo.shopName = paramContext.optString("name");
      paramIntent = paramContext.optJSONArray("regions");
      if (paramIntent == null) {
        break label376;
      }
      localStringBuffer = new StringBuffer();
      i = 0;
      while (i < paramIntent.length())
      {
        String str = paramIntent.optString(i);
        if (!TextUtils.isEmpty(str)) {
          localStringBuffer.append(str);
        }
        i += 1;
      }
    }
    for (;;)
    {
      PublicDatingActivity.a(this.a).shopInfo.shopAddr = paramContext.optString("address");
      PublicDatingActivity.a(this.a).shopInfo.shopUrl = paramContext.optString("href");
      PublicDatingActivity.a(this.a).shopInfo.shopPicUrl = paramContext.optString("photo_url");
      PublicDatingActivity.a(this.a).b(PublicDatingActivity.a(this.a));
      return;
      label376:
      PublicDatingActivity.a(this.a).shopInfo.shopZone = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iei
 * JD-Core Version:    0.7.0.1
 */