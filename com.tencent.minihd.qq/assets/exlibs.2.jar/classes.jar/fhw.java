import android.text.TextUtils;
import com.tencent.biz.common.util.CommUtils.IHttpGetString;
import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class fhw
  implements CommUtils.IHttpGetString
{
  public fhw(TroopManageActivity paramTroopManageActivity) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.troopmanage", 4, "get group statics ok:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      if ((((JSONObject)localObject).has("title")) && (((JSONObject)localObject).has("url")))
      {
        paramString = ((JSONObject)localObject).getString("title");
        localObject = ((JSONObject)localObject).getString("url");
        SharePreferenceUtils.a(this.a.app.getApplication(), this.a.app.a() + "_" + "GoupStatisticsTitle", paramString);
        SharePreferenceUtils.a(this.a.app.getApplication(), this.a.app.a() + "_" + "GoupStatisticsUrl", (String)localObject);
        if (this.a.isFinishing()) {
          return;
        }
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          TroopManageActivity.a(this.a, paramString, (String)localObject);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.troopmanage", 2, paramString.toString());
        return;
        TroopManageActivity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhw
 * JD-Core Version:    0.7.0.1
 */