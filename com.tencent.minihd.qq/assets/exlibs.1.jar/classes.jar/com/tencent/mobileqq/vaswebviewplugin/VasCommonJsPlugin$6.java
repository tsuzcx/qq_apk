package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class VasCommonJsPlugin$6
  implements Runnable
{
  VasCommonJsPlugin$6(VasCommonJsPlugin paramVasCommonJsPlugin, String paramString) {}
  
  public void run()
  {
    if (this.this$0.mRuntime == null) {}
    for (;;)
    {
      return;
      int i;
      synchronized (this.this$0.mJDUpdateConfig)
      {
        boolean bool = this.this$0.mIsJDUpdateConfigInit;
        if (!bool) {
          try
          {
            Object localObject1 = new File(this.this$0.mRuntime.a().getApplicationContext().getFilesDir(), ClubContentJsonTask.b.a);
            if ((localObject1 != null) && (((File)localObject1).exists()))
            {
              localObject1 = new JSONObject(FileUtils.a((File)localObject1)).getJSONObject("data").getJSONArray("jdUploadLog");
              if (localObject1 != null)
              {
                int j = ((JSONArray)localObject1).length();
                i = 0;
                while (i < j)
                {
                  Object localObject3 = ((JSONArray)localObject1).getJSONObject(i);
                  if (((JSONObject)localObject3).has("jdUploadLog"))
                  {
                    localObject3 = ((JSONObject)localObject3).getString("jdUploadLog");
                    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                      this.this$0.mJDUpdateConfig.add(localObject3);
                    }
                  }
                  i += 1;
                }
              }
            }
          }
          catch (Exception localException2)
          {
            this.this$0.mIsJDUpdateConfigInit = true;
          }
        }
        if (this.this$0.mJDUpdateConfig.size() == 0) {
          continue;
        }
      }
      try
      {
        i = NetworkUtil.a(this.this$0.mRuntime.a().getApplicationContext());
        if (i == 0) {
          continue;
        }
        ??? = null;
        switch (i)
        {
        default: 
          if ((TextUtils.isEmpty(???)) || (!this.this$0.mJDUpdateConfig.contains(???)) || ((!this.val$url.contains("jd.com")) && (!this.val$url.contains("wanggou.com")) && (!this.val$url.contains("paipai.com")))) {
            continue;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("jd").append("|").append(this.val$url).append("|").append(???).append("|").append("android").append("|").append("5.9.3").append("|").append("|").append("|").append("|").append("|").append("|").append("|");
          ReportController.a("dc00454", localStringBuilder.toString());
          return;
          localObject2 = finally;
          throw localObject2;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          i = 0;
          continue;
          String str = "2G";
          continue;
          str = "3G";
          continue;
          str = "4G";
          continue;
          str = "wifi";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */