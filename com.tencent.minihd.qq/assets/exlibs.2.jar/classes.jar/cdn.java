import android.content.Context;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public final class cdn
  extends Thread
{
  public cdn(JSONObject paramJSONObject, String paramString1, Context paramContext, String paramString2, LoadedCallBack paramLoadedCallBack) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "Begin checkUpServerThread:");
    }
    Object localObject3 = "0";
    Object localObject1 = localObject3;
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
        localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.getString("version");
      }
      localObject3 = new HashMap(1);
      ((HashMap)localObject3).put(this.jdField_a_of_type_JavaLangString, localObject1);
      localObject1 = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, (HashMap)localObject3, this.b, 0);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "getUpdateConfig: null");
        }
        this.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a("{\"r\":-2}");
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "end checkUpServerThread:");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = localObject3;
        continue;
        this.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a(localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdn
 * JD-Core Version:    0.7.0.1
 */