package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class ThemeJsPlugin$2
  implements Runnable
{
  ThemeJsPlugin$2(ThemeJsPlugin paramThemeJsPlugin, String paramString) {}
  
  public void run()
  {
    String str1 = ThemeJsPlugin.access$000(this.this$0).getSharedPreferences("userThemeSharedPreferences", 4).getString("userDownloadTheme", "");
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler queryLocal userThemeStr=" + str1);
    }
    String str3 = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      JSONObject localJSONObject2;
      JSONObject localJSONObject3;
      Object localObject;
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject3 = new JSONObject();
        if ((str1 == null) || (str1.length() <= 0)) {
          break label455;
        }
        JSONObject localJSONObject4 = new JSONObject(str1);
        Iterator localIterator = localJSONObject4.keys();
        if (!localIterator.hasNext()) {
          break label455;
        }
        String str4 = String.valueOf(localIterator.next());
        JSONObject localJSONObject5 = localJSONObject4.getJSONObject(str4);
        i = localJSONObject5.getInt("downsize");
        int j = localJSONObject5.getInt("size");
        str1 = localJSONObject5.getString("status");
        if (j > 0)
        {
          i = (int)Math.floor(i * 1.0D / j * 100.0D);
          i = Math.min(100, i);
          if ((ThemeJsPlugin.access$300(this.this$0).containsKey(str4)) || (!str1.equals("2"))) {
            break label610;
          }
          localObject = ThemeUtil.getThemeInfo(ThemeJsPlugin.access$000(this.this$0), str4);
          if (localObject == null) {
            break label613;
          }
          if (!ThemeJsPlugin.access$400(this.this$0, ((ThemeUtil.ThemeInfo)localObject).themeId, ((ThemeUtil.ThemeInfo)localObject).version, ((ThemeUtil.ThemeInfo)localObject).size)) {
            break label442;
          }
          ((ThemeUtil.ThemeInfo)localObject).status = "3";
          ((ThemeUtil.ThemeInfo)localObject).downsize = ((ThemeUtil.ThemeInfo)localObject).size;
          i = 100;
          str1 = "3";
          if (QLog.isColorLevel()) {
            QLog.d("ThemeJsPlugin", 2, "queryLocal, modify theme download status to " + ((ThemeUtil.ThemeInfo)localObject).status);
          }
          ThemeUtil.setThemeInfo(ThemeJsPlugin.access$000(this.this$0), (ThemeUtil.ThemeInfo)localObject);
          localObject = str1;
          if (str1.equals("5")) {
            localObject = "3";
          }
          localJSONObject5.put("progress", i);
          localJSONObject5.put("status", localObject);
          localJSONObject5.remove("downsize");
          localJSONObject5.remove("size");
          localJSONObject3.put(str4, localJSONObject5);
          continue;
        }
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        this.this$0.callJsOnError(this.val$callbackId, localThrowable.getMessage());
        if (QLog.isColorLevel()) {
          QLog.e("ThemeJsPlugin", 2, localThrowable.getMessage());
        }
        return;
      }
      continue;
      label442:
      ((ThemeUtil.ThemeInfo)localObject).status = "4";
      String str2 = "4";
      continue;
      label455:
      int i = ThemeJsPlugin.access$100(this.this$0).getPreferences().getInt("stripUserTheme", 0);
      if (i != 0) {
        ThemeJsPlugin.access$100(this.this$0).getPreferences().edit().remove("stripUserTheme").commit();
      }
      localJSONObject2.put("localInfo", localJSONObject3);
      localJSONObject2.put("currentId", str3);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "ok");
      localJSONObject1.put("data", localJSONObject2);
      localJSONObject1.put("authResult", i);
      this.this$0.callJs(this.val$callbackId + "(" + localJSONObject1.toString() + ");");
      return;
      label610:
      continue;
      label613:
      str2 = "4";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */