import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.open.business.base.appreport.AppReport.FullReportCallback;
import com.tencent.open.business.base.appreport.AppUpdate;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class lfc
  implements Runnable
{
  public lfc(Context paramContext, String paramString1, WebView paramWebView, String paramString2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Thread.sleep(60000L);
        LogUtility.b("AppReport", "<AppReport> begin doFullReport ...");
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          LogUtility.e("AppReport", "<AppReport> fullReport context is null !");
          return;
        }
        if (AppReport.a)
        {
          if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
          {
            boolean bool = AppReport.a;
            if (bool)
            {
              try
              {
                LogUtility.c("AppReport", "<AppReport>Wait 100 milliseconds for another full report finished,before getUpdateAppRequest");
                Thread.sleep(new Random().nextInt(50) + 50L);
              }
              catch (InterruptedException localInterruptedException)
              {
                LogUtility.e("AppReport", "<AppReport> fullReport context is null !");
              }
              continue;
            }
            if (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false))
            {
              AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, true, this.b);
              return;
            }
            AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, false, this.b);
            return;
          }
          LogUtility.c("AppReport", "<AppReport>Another full report running, fullReport will not continue !!!");
          return;
        }
        AppReport.a = true;
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
        {
          LogUtility.c("AppReport", "<AppReport> onResult get app update list without full report");
          if ((!AppReport.a()) || (!AppReport.a(this.jdField_a_of_type_AndroidContentContext)))
          {
            LogUtility.c("AppReport", "doFullReport get app update list without full report, because : full report switch off, or Over max full report times a day");
            AppReport.a = false;
            AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, false, this.b);
            return;
          }
          if (!AppUtil.a(this.jdField_a_of_type_AndroidContentContext))
          {
            LogUtility.c("AppReport", "<AppReport> doFullReport get app update list without full report, because : packageScan is not allowed");
            AppReport.a = false;
            AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, true, this.b);
          }
        }
        else if (!AppUtil.a(this.jdField_a_of_type_AndroidContentContext))
        {
          LogUtility.c("AppReport", "<AppReport> doFullReport will not continue , because : packageScan is not allowed");
          AppReport.a = false;
          return;
        }
        Object localObject2 = AppUtil.a(this.jdField_a_of_type_AndroidContentContext);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          Object localObject1 = new HashMap();
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject2).next();
            if ((localPackageInfo.applicationInfo.flags & 0x1) != 0) {
              break label653;
            }
            if ((localPackageInfo.applicationInfo.flags & 0x80) != 0)
            {
              break label653;
              ((Map)localObject1).put(localPackageInfo.packageName, AppReport.a(localPackageInfo.packageName, localPackageInfo.versionCode, localPackageInfo.versionName, i, AppUtil.a(this.jdField_a_of_type_AndroidContentContext, localPackageInfo.packageName)));
            }
          }
          else
          {
            localObject1 = AppReport.a(this.jdField_a_of_type_AndroidContentContext, (Map)localObject1, "ALL", this.b);
            LogUtility.b("AppReport", "<AppReport> incremental report params : " + ((Bundle)localObject1).toString());
            if ((!APNUtil.b(this.jdField_a_of_type_AndroidContentContext)) || (((Bundle)localObject1).getString("sid").equals("")))
            {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0).edit();
              ((SharedPreferences.Editor)localObject1).putBoolean("is_app_last_fullReport_success", false);
              ((SharedPreferences.Editor)localObject1).commit();
              LogUtility.b("AppReport", "<AppReport> full report stoped !!! because network is unavaliable or get sid error");
              AppReport.a = false;
              return;
            }
            LogUtility.b("AppReport", "<AppReport> do full report to server !!!");
            new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new AppReport.FullReportCallback(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentSmttSdkWebView)).execute(new Bundle[] { localObject1 });
          }
        }
        else
        {
          if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentSmttSdkWebView == null)) {
            continue;
          }
          AppUpdate.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, true, this.b);
          AppReport.a = false;
          return;
        }
        i = 0;
        continue;
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label653:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lfc
 * JD-Core Version:    0.7.0.1
 */