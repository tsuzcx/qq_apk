import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.ResourceUpdater;
import com.tencent.open.appcommon.ResourceUpdater.CheckUpdateCallback;
import com.tencent.open.appcommon.TaskThread;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.MD5Utils;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public class ldn
  implements Runnable
{
  public ldn(ResourceUpdater.CheckUpdateCallback paramCheckUpdateCallback, JSONObject paramJSONObject) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_OrgJsonJSONObject.optInt("code", -6);
    long l = this.jdField_a_of_type_OrgJsonJSONObject.optLong("maxage", 0L);
    Common.a(l, System.currentTimeMillis());
    if (i == 0) {
      switch (this.jdField_a_of_type_OrgJsonJSONObject.optInt("situation", 0))
      {
      default: 
        if (!TextUtils.isEmpty(ResourceUpdater.e)) {
          Common.a(ResourceUpdater.e);
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAppcommonResourceUpdater$CheckUpdateCallback.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      LogUtility.b(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> Resource update check end !!!");
      return;
      ResourceUpdater.e = this.jdField_a_of_type_ComTencentOpenAppcommonResourceUpdater$CheckUpdateCallback.jdField_a_of_type_JavaLangString;
      LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> Direc MD5 not change. Do not need update.");
      break;
      LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> Direc MD5 changed, but zip MD5 is newest. unzip local zip file.");
      if (ResourceUpdater.a())
      {
        ResourceUpdater.e = MD5Utils.c(Common.i());
        LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "send UPDATED_SYSTEM_FILE msg");
      }
      for (;;)
      {
        TaskThread.a().a();
        break;
        LogUtility.e(ResourceUpdater.jdField_a_of_type_JavaLangString, "unZipFile error ");
      }
      String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("cdn_url", "");
      LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> Direct MD5 and zip MD5 not match. Do full update. url = " + str1 + " maxAge = " + l);
      if ((!TextUtils.isEmpty(str1)) && (ResourceUpdater.a(str1)))
      {
        ResourceUpdater.e = MD5Utils.c(Common.i());
        LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "send UPDATED_SYSTEM_FILE msg");
      }
      for (;;)
      {
        TaskThread.a().a();
        break;
        LogUtility.e(ResourceUpdater.jdField_a_of_type_JavaLangString, "Full update failed. ");
      }
      str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("cdn_url", "");
      String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("latest_zip_md5", "");
      LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> Direct MD5 changed and zip MD5 is old. Do incremental update.url = " + str1 + " maxAge = " + l);
      if ((!TextUtils.isEmpty(str1)) && (ResourceUpdater.a(MsfSdkUtils.insertMtype("yingyongbao", str1), str2)))
      {
        ResourceUpdater.e = MD5Utils.c(Common.i());
        LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "send UPDATED_SYSTEM_FILE msg");
      }
      for (;;)
      {
        TaskThread.a().a();
        break;
        LogUtility.e(ResourceUpdater.jdField_a_of_type_JavaLangString, "Incremental update failed. ");
      }
      LogUtility.c(ResourceUpdater.jdField_a_of_type_JavaLangString, "<checkUpdate> update failed, ret=" + i + ", msg=" + this.jdField_a_of_type_OrgJsonJSONObject.optString("msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ldn
 * JD-Core Version:    0.7.0.1
 */