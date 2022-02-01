import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ere
  implements Runnable
{
  public ere(QQBrowserActivity paramQQBrowserActivity, String paramString) {}
  
  public void run()
  {
    Object localObject2;
    if (QQBrowserActivity.b == null)
    {
      QQBrowserActivity.b = new ArrayList(4);
      try
      {
        Object localObject1 = new File(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext().getFilesDir(), ClubContentJsonTask.b.jdField_a_of_type_JavaLangString);
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          localObject1 = new JSONObject(FileUtils.a((File)localObject1)).getJSONObject("data").getJSONArray("webviewStepReport");
          if (localObject1 != null)
          {
            i = 0;
            int j = ((JSONArray)localObject1).length();
            while (i < j)
            {
              localObject2 = ((JSONArray)localObject1).getJSONObject(i);
              if (((JSONObject)localObject2).has("webviewStepReport"))
              {
                localObject2 = ((JSONObject)localObject2).getString("webviewStepReport");
                if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                  QQBrowserActivity.b.add(localObject2);
                }
              }
              i += 1;
            }
          }
        }
        if (QQBrowserActivity.b == null) {
          break label169;
        }
      }
      catch (Exception localException) {}
    }
    else
    {
      if ((QQBrowserActivity.b.size() != 0) && (QQBrowserActivity.b.contains(this.jdField_a_of_type_JavaLangString))) {
        break label170;
      }
    }
    label169:
    label170:
    do
    {
      return;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M)) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQBrowser_report", 2, "mUrl is null, get url from webview:" + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.getUrl());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.getUrl();
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M));
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M.indexOf("?");
    String str;
    if (i != -1)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M.substring(0, i);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.F == -1) {
        break label468;
      }
      str = str + "?type=" + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.F;
    }
    label468:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser_report", 2, "try report web status,url:" + str);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.Z)) {}
      for (localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.Z;; localObject2 = "unknown")
      {
        ReportController.b(null, "P_CliOper", "WebStatusReport", "", (String)localObject2, this.jdField_a_of_type_JavaLangString, 0, 1, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.E, str, Build.VERSION.RELEASE, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.h - this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.g), String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.g));
        return;
        str = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ere
 * JD-Core Version:    0.7.0.1
 */