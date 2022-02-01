package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import org.json.JSONException;
import org.json.JSONObject;

class ThemeDIYActivity$SwitchThemeTask
  extends AsyncTask
{
  int THEME_OPTION_ERROR = -1;
  int THEME_OPTION_SUCCESS = 0;
  public QQAppInterface app;
  Context ctx;
  
  public ThemeDIYActivity$SwitchThemeTask(ThemeDIYActivity paramThemeDIYActivity, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.ctx = paramContext;
    this.app = paramQQAppInterface;
  }
  
  /* Error */
  protected JSONObject doInBackground(java.lang.Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 40	java/lang/String
    //   6: astore_2
    //   7: aload_1
    //   8: iconst_1
    //   9: aaload
    //   10: checkcast 40	java/lang/String
    //   13: astore_3
    //   14: new 42	org/json/JSONObject
    //   17: dup
    //   18: invokespecial 43	org/json/JSONObject:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc 45
    //   25: aload_2
    //   26: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_1
    //   31: ldc 51
    //   33: aload_3
    //   34: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   37: pop
    //   38: aload_1
    //   39: ldc 53
    //   41: aload_0
    //   42: getfield 22	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$SwitchThemeTask:THEME_OPTION_ERROR	I
    //   45: invokevirtual 56	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload_1
    //   50: ldc 58
    //   52: ldc 60
    //   54: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload_0
    //   59: getfield 26	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$SwitchThemeTask:ctx	Landroid/content/Context;
    //   62: aload_2
    //   63: aload_3
    //   64: invokestatic 66	com/tencent/mobileqq/theme/ThemeUtil:getThemeResourcePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   67: astore 4
    //   69: new 68	java/io/File
    //   72: dup
    //   73: aload 4
    //   75: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 75	java/io/File:exists	()Z
    //   81: ifne +14 -> 95
    //   84: aload_0
    //   85: getfield 26	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$SwitchThemeTask:ctx	Landroid/content/Context;
    //   88: ldc 77
    //   90: aload 4
    //   92: invokestatic 83	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   95: ldc2_w 84
    //   98: invokestatic 91	java/lang/Thread:sleep	(J)V
    //   101: new 93	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo
    //   104: dup
    //   105: invokespecial 94	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: ldc2_w 95
    //   115: putfield 100	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   118: aload 5
    //   120: ldc2_w 95
    //   123: putfield 103	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   126: aload 5
    //   128: aload_2
    //   129: putfield 106	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:themeId	Ljava/lang/String;
    //   132: aload 5
    //   134: aload_3
    //   135: putfield 108	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:version	Ljava/lang/String;
    //   138: aload 5
    //   140: ldc 110
    //   142: putfield 113	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   145: aload 5
    //   147: iconst_0
    //   148: putfield 117	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:isVoiceTheme	Z
    //   151: aload_0
    //   152: getfield 26	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$SwitchThemeTask:ctx	Landroid/content/Context;
    //   155: aload 5
    //   157: invokestatic 121	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   160: pop
    //   161: aload_1
    //   162: ldc 53
    //   164: aload_0
    //   165: getfield 24	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   168: invokevirtual 56	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload_1
    //   173: ldc 123
    //   175: aload 4
    //   177: invokevirtual 49	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   180: pop
    //   181: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +31 -> 215
    //   187: ldc 130
    //   189: iconst_2
    //   190: new 132	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   197: ldc 135
    //   199: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokevirtual 143	org/json/JSONObject:toString	()Ljava/lang/String;
    //   206: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_1
    //   216: areturn
    //   217: astore_2
    //   218: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +31 -> 252
    //   224: ldc 130
    //   226: iconst_2
    //   227: new 132	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   234: ldc 150
    //   236: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 153	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aload_2
    //   253: invokevirtual 156	org/json/JSONException:printStackTrace	()V
    //   256: goto -75 -> 181
    //   259: astore_2
    //   260: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +31 -> 294
    //   266: ldc 130
    //   268: iconst_2
    //   269: new 132	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   276: ldc 158
    //   278: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_2
    //   282: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   285: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 148	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_2
    //   295: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   298: goto -117 -> 181
    //   301: astore 5
    //   303: goto -202 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	SwitchThemeTask
    //   0	306	1	paramVarArgs	java.lang.Object[]
    //   6	123	2	str1	String
    //   217	36	2	localJSONException	JSONException
    //   259	36	2	localException1	java.lang.Exception
    //   13	122	3	str2	String
    //   67	109	4	str3	String
    //   108	48	5	localThemeInfo	com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo
    //   301	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	95	217	org/json/JSONException
    //   95	101	217	org/json/JSONException
    //   101	181	217	org/json/JSONException
    //   22	95	259	java/lang/Exception
    //   101	181	259	java/lang/Exception
    //   95	101	301	java/lang/Exception
  }
  
  protected void onPostExecute(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.getInt("ret");
      String str1 = paramJSONObject.getString("themeId");
      String str2 = paramJSONObject.getString("version");
      if (i == this.THEME_OPTION_SUCCESS)
      {
        if (str1.equals("1000")) {}
        for (paramJSONObject = null; SkinEngine.getInstances().setSkinRootPath(this.ctx, paramJSONObject) == true; paramJSONObject = paramJSONObject.getString("themeResPath"))
        {
          ThemeUtil.setCurrentThemeIdVersion(this.app, str1, str2);
          ThemeDIYActivity.themeStatus = 2;
          ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy_stock", 0, 1, "", "", this.this$0.reportType, "");
          return;
        }
        ThemeDIYActivity.themeStatus = -1;
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeDIYActivity", 2, "ThemeJsHandler switchThemeTask JSONException:" + paramJSONObject.getMessage());
      }
      ThemeDIYActivity.themeStatus = -1;
      return;
    }
    ThemeDIYActivity.themeStatus = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.SwitchThemeTask
 * JD-Core Version:    0.7.0.1
 */