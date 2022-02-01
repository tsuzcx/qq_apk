import android.app.Activity;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import org.json.JSONObject;

public final class hdc
  implements Runnable
{
  public hdc(HashMap paramHashMap, String paramString1, String paramString2, String paramString3, AppInterface paramAppInterface, Activity paramActivity, String paramString4, JSONObject paramJSONObject, String paramString5, String paramString6, String paramString7) {}
  
  public void run()
  {
    Object localObject = HttpUtil.a(this.jdField_a_of_type_JavaUtilHashMap);
    String str1 = (String)((HashMap)localObject).get("share_url");
    if (str1 == null) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      String str2 = (String)((HashMap)localObject).get("image_url");
      if (str2 == null) {
        str2 = this.b;
      }
      for (;;)
      {
        String str3 = (String)((HashMap)localObject).get("flash_url");
        localObject = str3;
        if (str3 == null) {
          localObject = this.c;
        }
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(new hdd(this, str1, str2, (String)localObject));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdc
 * JD-Core Version:    0.7.0.1
 */