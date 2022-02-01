package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class ThemeSwitchManager$SwitchThemeTask
  extends AsyncTask
{
  private int THEME_OPTION_ERROR = -1;
  private int THEME_OPTION_PKG_NOT_EXISTS = 1;
  private int THEME_OPTION_PKG_UNZIP_ERROR = 2;
  private int THEME_OPTION_SAVE_THEMEINFO_ERROR = 3;
  private int THEME_OPTION_SUCCESS = 0;
  private AppRuntime mRuntime;
  
  public ThemeSwitchManager$SwitchThemeTask(ThemeSwitchManager paramThemeSwitchManager, AppRuntime paramAppRuntime)
  {
    this.mRuntime = paramAppRuntime;
  }
  
  public void clearChatBackground()
  {
    SharedPreferences localSharedPreferences = this.mRuntime.getApplication().getSharedPreferences("chat_background_path_" + ((QQAppInterface)this.mRuntime).a(), 0);
    String str2 = localSharedPreferences.getString("chat_uniform_bg", "null");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.trim().length() != 0) {}
    }
    else
    {
      str1 = "null";
    }
    localSharedPreferences.edit().clear().commit();
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "oldPicPath is:" + str1 + ",newPicPath is:" + "null");
    }
    if (!str1.equals("null")) {
      ((ChatBackgroundManager)((QQAppInterface)this.mRuntime).getManager(61)).a(this.mRuntime.getApplication(), ((QQAppInterface)this.mRuntime).a());
    }
  }
  
  public void clearImageCache()
  {
    if (BaseApplicationImpl.a != null) {
      BaseApplicationImpl.a.evictAll();
    }
  }
  
  public void delOldResDir(String paramString1, String paramString2)
  {
    int i = 0;
    if (paramString1 != null) {
      try
      {
        if ((paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
        {
          paramString2 = paramString2.substring(0, paramString2.lastIndexOf(File.separator));
          File[] arrayOfFile = new File(paramString2).listFiles();
          if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
            while (i < arrayOfFile.length)
            {
              String str = arrayOfFile[i].getName();
              if (str.startsWith(paramString1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeSwitch", 2, "delete old theme res dir,themeId=" + paramString1 + ",dirName=" + str);
                }
                FileUtils.a(paramString2 + File.separator + str);
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  /* Error */
  protected org.json.JSONObject doInBackground(java.lang.Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: checkcast 77	java/lang/String
    //   6: astore_3
    //   7: aload_1
    //   8: iconst_1
    //   9: aaload
    //   10: checkcast 77	java/lang/String
    //   13: astore 6
    //   15: new 190	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 191	org/json/JSONObject:<init>	()V
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 193
    //   26: aload_3
    //   27: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_1
    //   32: ldc 199
    //   34: aload 6
    //   36: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_1
    //   41: ldc 201
    //   43: aload_0
    //   44: getfield 23	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_ERROR	I
    //   47: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   50: pop
    //   51: aload_1
    //   52: ldc 206
    //   54: ldc 208
    //   56: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_3
    //   61: ifnull +12 -> 73
    //   64: aload_3
    //   65: ldc 210
    //   67: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +119 -> 189
    //   73: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +38 -> 114
    //   79: ldc 104
    //   81: iconst_2
    //   82: new 43	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   89: ldc 212
    //   91: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_3
    //   95: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 214
    //   100: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 6
    //   105: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_3
    //   115: ifnonnull +12 -> 127
    //   118: aload_1
    //   119: ldc 193
    //   121: ldc 210
    //   123: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: ldc2_w 218
    //   130: invokestatic 225	java/lang/Thread:sleep	(J)V
    //   133: aload_1
    //   134: ldc 201
    //   136: aload_0
    //   137: getfield 25	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   140: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_1
    //   145: ldc 206
    //   147: ldc 227
    //   149: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   152: pop
    //   153: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +31 -> 187
    //   159: ldc 104
    //   161: iconst_2
    //   162: new 43	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   169: ldc 229
    //   171: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_1
    //   175: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
    //   178: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_1
    //   188: areturn
    //   189: aload_0
    //   190: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   193: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   196: aload_3
    //   197: invokestatic 236	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   200: astore 5
    //   202: aload_0
    //   203: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   206: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   209: aload_3
    //   210: aload 6
    //   212: invokestatic 240	com/tencent/mobileqq/theme/ThemeUtil:getThemeResourcePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 4
    //   217: aload_0
    //   218: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   221: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   224: aload_3
    //   225: aload 6
    //   227: invokestatic 243	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 6
    //   232: new 142	java/io/File
    //   235: dup
    //   236: aload 6
    //   238: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   241: astore 7
    //   243: aload 5
    //   245: ifnull +140 -> 385
    //   248: aload 5
    //   250: getfield 248	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   253: ldc 250
    //   255: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +127 -> 385
    //   261: new 142	java/io/File
    //   264: dup
    //   265: aload 4
    //   267: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   270: invokevirtual 253	java/io/File:exists	()Z
    //   273: istore_2
    //   274: iload_2
    //   275: ifeq +77 -> 352
    //   278: ldc2_w 218
    //   281: invokestatic 225	java/lang/Thread:sleep	(J)V
    //   284: aload_1
    //   285: ldc 201
    //   287: aload_0
    //   288: getfield 25	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   291: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload_1
    //   296: ldc 255
    //   298: aload 4
    //   300: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload_1
    //   305: ldc 206
    //   307: ldc_w 257
    //   310: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   313: pop
    //   314: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +583 -> 900
    //   320: ldc 104
    //   322: iconst_2
    //   323: new 43	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 259
    //   333: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_1
    //   337: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
    //   340: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: goto +551 -> 900
    //   352: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +30 -> 385
    //   358: ldc 104
    //   360: iconst_2
    //   361: new 43	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   368: ldc_w 261
    //   371: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload 4
    //   376: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aload 5
    //   387: ifnull +336 -> 723
    //   390: aload 7
    //   392: invokevirtual 253	java/io/File:exists	()Z
    //   395: ifeq +328 -> 723
    //   398: aload 7
    //   400: invokevirtual 264	java/io/File:length	()J
    //   403: aload 5
    //   405: getfield 268	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   408: lcmp
    //   409: ifne +314 -> 723
    //   412: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +44 -> 459
    //   418: ldc 104
    //   420: iconst_2
    //   421: new 43	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 270
    //   431: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 7
    //   436: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: ldc_w 275
    //   442: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 5
    //   447: getfield 248	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   450: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: aload_0
    //   460: aload_3
    //   461: aload 4
    //   463: invokevirtual 277	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:delOldResDir	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload 6
    //   468: aload 4
    //   470: iconst_0
    //   471: invokestatic 280	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   474: new 142	java/io/File
    //   477: dup
    //   478: aload 4
    //   480: invokespecial 157	java/io/File:<init>	(Ljava/lang/String;)V
    //   483: invokevirtual 253	java/io/File:exists	()Z
    //   486: ifeq +207 -> 693
    //   489: aload 5
    //   491: ldc 250
    //   493: putfield 248	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   496: aload_0
    //   497: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   500: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   503: aload 5
    //   505: invokestatic 284	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   508: invokevirtual 289	java/lang/Boolean:booleanValue	()Z
    //   511: iconst_1
    //   512: if_icmpne +114 -> 626
    //   515: aload_1
    //   516: ldc 201
    //   518: aload_0
    //   519: getfield 25	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   522: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   525: pop
    //   526: aload_1
    //   527: ldc 255
    //   529: aload 4
    //   531: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload_1
    //   536: ldc 206
    //   538: ldc_w 291
    //   541: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   544: pop
    //   545: goto -392 -> 153
    //   548: astore_3
    //   549: aload_1
    //   550: ldc 206
    //   552: ldc_w 293
    //   555: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   558: pop
    //   559: aload_1
    //   560: ldc 201
    //   562: aload_0
    //   563: getfield 29	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   566: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   569: pop
    //   570: aload 6
    //   572: invokestatic 295	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   575: pop
    //   576: aload_3
    //   577: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   580: goto -427 -> 153
    //   583: astore_3
    //   584: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +32 -> 619
    //   590: ldc 104
    //   592: iconst_2
    //   593: new 43	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 298
    //   603: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_3
    //   607: invokevirtual 301	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   610: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload_3
    //   620: invokevirtual 302	org/json/JSONException:printStackTrace	()V
    //   623: goto -470 -> 153
    //   626: aload_1
    //   627: ldc 206
    //   629: ldc_w 304
    //   632: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   635: pop
    //   636: aload_1
    //   637: ldc 201
    //   639: aload_0
    //   640: getfield 31	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SAVE_THEMEINFO_ERROR	I
    //   643: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   646: pop
    //   647: goto -494 -> 153
    //   650: astore_3
    //   651: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq +32 -> 686
    //   657: ldc 104
    //   659: iconst_2
    //   660: new 43	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   667: ldc_w 306
    //   670: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_3
    //   674: invokevirtual 307	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   677: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: aload_3
    //   687: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   690: goto -537 -> 153
    //   693: aload_1
    //   694: ldc 206
    //   696: ldc_w 309
    //   699: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   702: pop
    //   703: aload_1
    //   704: ldc 201
    //   706: aload_0
    //   707: getfield 29	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   710: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 6
    //   716: invokestatic 295	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   719: pop
    //   720: goto -567 -> 153
    //   723: aload 5
    //   725: ifnonnull +27 -> 752
    //   728: aload_1
    //   729: ldc 206
    //   731: ldc_w 311
    //   734: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   737: pop
    //   738: aload_1
    //   739: ldc 201
    //   741: aload_0
    //   742: getfield 27	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_PKG_NOT_EXISTS	I
    //   745: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   748: pop
    //   749: goto -596 -> 153
    //   752: aload 7
    //   754: invokevirtual 253	java/io/File:exists	()Z
    //   757: ifne +62 -> 819
    //   760: aload 5
    //   762: ifnull +44 -> 806
    //   765: aload 5
    //   767: getfield 248	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   770: ldc_w 313
    //   773: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   776: ifne +30 -> 806
    //   779: aload 5
    //   781: ldc_w 313
    //   784: putfield 248	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   787: aload 5
    //   789: lconst_0
    //   790: putfield 316	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   793: aload_0
    //   794: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   797: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   800: aload 5
    //   802: invokestatic 284	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   805: pop
    //   806: aload_1
    //   807: ldc 206
    //   809: ldc_w 318
    //   812: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   815: pop
    //   816: goto -78 -> 738
    //   819: aload 7
    //   821: invokevirtual 264	java/io/File:length	()J
    //   824: aload 5
    //   826: getfield 268	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   829: lcmp
    //   830: ifeq -92 -> 738
    //   833: aload 5
    //   835: ifnull +44 -> 879
    //   838: aload 5
    //   840: getfield 248	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   843: ldc_w 320
    //   846: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   849: ifne +30 -> 879
    //   852: aload 5
    //   854: ldc_w 320
    //   857: putfield 248	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   860: aload 5
    //   862: lconst_0
    //   863: putfield 316	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   866: aload_0
    //   867: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   870: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   873: aload 5
    //   875: invokestatic 284	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   878: pop
    //   879: aload_1
    //   880: ldc 206
    //   882: ldc_w 322
    //   885: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   888: pop
    //   889: goto -151 -> 738
    //   892: astore_3
    //   893: goto -760 -> 133
    //   896: astore_3
    //   897: goto -613 -> 284
    //   900: aload_1
    //   901: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	902	0	this	SwitchThemeTask
    //   0	902	1	paramVarArgs	java.lang.Object[]
    //   273	2	2	bool	boolean
    //   6	455	3	str1	String
    //   548	29	3	localIOException	java.io.IOException
    //   583	37	3	localJSONException	org.json.JSONException
    //   650	37	3	localException1	Exception
    //   892	1	3	localException2	Exception
    //   896	1	3	localException3	Exception
    //   215	315	4	str2	String
    //   200	674	5	localThemeInfo	ThemeUtil.ThemeInfo
    //   13	702	6	str3	String
    //   241	579	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   459	545	548	java/io/IOException
    //   626	647	548	java/io/IOException
    //   693	720	548	java/io/IOException
    //   23	60	583	org/json/JSONException
    //   64	73	583	org/json/JSONException
    //   73	114	583	org/json/JSONException
    //   118	127	583	org/json/JSONException
    //   127	133	583	org/json/JSONException
    //   133	153	583	org/json/JSONException
    //   189	243	583	org/json/JSONException
    //   248	274	583	org/json/JSONException
    //   278	284	583	org/json/JSONException
    //   284	349	583	org/json/JSONException
    //   352	385	583	org/json/JSONException
    //   390	459	583	org/json/JSONException
    //   459	545	583	org/json/JSONException
    //   549	580	583	org/json/JSONException
    //   626	647	583	org/json/JSONException
    //   693	720	583	org/json/JSONException
    //   728	738	583	org/json/JSONException
    //   738	749	583	org/json/JSONException
    //   752	760	583	org/json/JSONException
    //   765	806	583	org/json/JSONException
    //   806	816	583	org/json/JSONException
    //   819	833	583	org/json/JSONException
    //   838	879	583	org/json/JSONException
    //   879	889	583	org/json/JSONException
    //   23	60	650	java/lang/Exception
    //   64	73	650	java/lang/Exception
    //   73	114	650	java/lang/Exception
    //   118	127	650	java/lang/Exception
    //   133	153	650	java/lang/Exception
    //   189	243	650	java/lang/Exception
    //   248	274	650	java/lang/Exception
    //   284	349	650	java/lang/Exception
    //   352	385	650	java/lang/Exception
    //   390	459	650	java/lang/Exception
    //   459	545	650	java/lang/Exception
    //   549	580	650	java/lang/Exception
    //   626	647	650	java/lang/Exception
    //   693	720	650	java/lang/Exception
    //   728	738	650	java/lang/Exception
    //   738	749	650	java/lang/Exception
    //   752	760	650	java/lang/Exception
    //   765	806	650	java/lang/Exception
    //   806	816	650	java/lang/Exception
    //   819	833	650	java/lang/Exception
    //   838	879	650	java/lang/Exception
    //   879	889	650	java/lang/Exception
    //   127	133	892	java/lang/Exception
    //   278	284	896	java/lang/Exception
  }
  
  /* Error */
  protected void onPostExecute(java.lang.Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 104
    //   8: iconst_2
    //   9: new 43	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 326
    //   19: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 329	java/lang/Object:toString	()Ljava/lang/String;
    //   26: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: new 331	android/os/Bundle
    //   38: dup
    //   39: invokespecial 332	android/os/Bundle:<init>	()V
    //   42: astore_3
    //   43: aload_1
    //   44: instanceof 190
    //   47: ifeq +618 -> 665
    //   50: aload_1
    //   51: checkcast 190	org/json/JSONObject
    //   54: astore_1
    //   55: aload_1
    //   56: ldc 201
    //   58: invokevirtual 335	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   61: istore_2
    //   62: aload_1
    //   63: ldc 206
    //   65: invokevirtual 338	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: pop
    //   69: aload_1
    //   70: ldc 193
    //   72: invokevirtual 338	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 4
    //   77: aload_1
    //   78: ldc 199
    //   80: invokevirtual 338	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: iload_2
    //   86: aload_0
    //   87: getfield 25	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   90: if_icmpne +502 -> 592
    //   93: aload 4
    //   95: ldc 210
    //   97: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifeq +295 -> 395
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   109: invokevirtual 343	com/tencent/mobileqq/theme/ThemeSwitchManager:doScreenShot	()V
    //   112: invokestatic 347	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeInfo	()Landroid/os/Bundle;
    //   115: astore 6
    //   117: invokestatic 353	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   120: aload_0
    //   121: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   124: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   127: aload_1
    //   128: invokevirtual 357	com/tencent/theme/SkinEngine:setSkinRootPath	(Landroid/content/Context;Ljava/lang/String;)Z
    //   131: iconst_1
    //   132: if_icmpne +273 -> 405
    //   135: aload_0
    //   136: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   139: checkcast 52	com/tencent/mobileqq/app/QQAppInterface
    //   142: bipush 61
    //   144: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   147: checkcast 122	com/tencent/mobileqq/model/ChatBackgroundManager
    //   150: aload_0
    //   151: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   154: checkcast 52	com/tencent/mobileqq/app/QQAppInterface
    //   157: invokevirtual 360	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   160: aconst_null
    //   161: ldc 69
    //   163: invokevirtual 363	com/tencent/mobileqq/model/ChatBackgroundManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_0
    //   167: invokevirtual 365	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:clearImageCache	()V
    //   170: aload 6
    //   172: ldc 193
    //   174: invokevirtual 366	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_1
    //   178: aload 6
    //   180: ldc 199
    //   182: invokevirtual 366	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: astore 6
    //   187: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +40 -> 230
    //   193: ldc 104
    //   195: iconst_2
    //   196: new 43	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 368
    //   206: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 370
    //   216: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 6
    //   221: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_1
    //   231: ldc_w 372
    //   234: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifne +17 -> 254
    //   240: aload_0
    //   241: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   244: checkcast 52	com/tencent/mobileqq/app/QQAppInterface
    //   247: aload_1
    //   248: aload 6
    //   250: invokestatic 378	com/tencent/mobileqq/theme/ThemeSwitchUtil:setPreviousThemeIdVersion	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;
    //   253: pop
    //   254: aload_0
    //   255: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   258: checkcast 52	com/tencent/mobileqq/app/QQAppInterface
    //   261: aload 4
    //   263: aload 5
    //   265: invokestatic 382	com/tencent/mobileqq/theme/ThemeUtil:setCurrentThemeIdVersion	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;
    //   268: pop
    //   269: aload_3
    //   270: ldc_w 384
    //   273: iconst_2
    //   274: invokevirtual 388	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   277: iconst_0
    //   278: putstatic 392	com/tencent/mobileqq/theme/ThemeSwitchManager:isSwitchTheme	Z
    //   281: aload_0
    //   282: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   285: iconst_1
    //   286: iconst_0
    //   287: aload_3
    //   288: invokevirtual 396	com/tencent/mobileqq/theme/ThemeSwitchManager:notifyCallbacks	(ZZLandroid/os/Bundle;)V
    //   291: aload_0
    //   292: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   295: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   298: aload 4
    //   300: invokestatic 400	com/tencent/mobileqq/theme/ThemeUtil:getErrorThemeId	(Landroid/content/Context;Ljava/lang/String;)I
    //   303: istore_2
    //   304: iload_2
    //   305: ifle +58 -> 363
    //   308: ldc2_w 401
    //   311: invokestatic 225	java/lang/Thread:sleep	(J)V
    //   314: iload_2
    //   315: ldc_w 403
    //   318: idiv
    //   319: ldc_w 405
    //   322: invokestatic 410	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   325: if_icmpne +16 -> 341
    //   328: aload_0
    //   329: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   332: invokevirtual 41	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   335: aload 4
    //   337: iconst_1
    //   338: invokestatic 414	com/tencent/mobileqq/theme/ThemeUtil:setErrorThemeId	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   341: aload_0
    //   342: getfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   345: checkcast 52	com/tencent/mobileqq/app/QQAppInterface
    //   348: bipush 13
    //   350: invokevirtual 417	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   353: checkcast 419	com/tencent/mobileqq/app/ThemeHandler
    //   356: aload 4
    //   358: aload 5
    //   360: invokevirtual 421	com/tencent/mobileqq/app/ThemeHandler:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload_3
    //   364: ldc_w 384
    //   367: iconst_m1
    //   368: invokevirtual 424	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   371: sipush 512
    //   374: iand
    //   375: sipush 512
    //   378: if_icmpne +11 -> 389
    //   381: aload_0
    //   382: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   385: aload_3
    //   386: invokevirtual 428	com/tencent/mobileqq/theme/ThemeSwitchManager:failAlert	(Landroid/os/Bundle;)V
    //   389: aload_0
    //   390: aconst_null
    //   391: putfield 33	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:mRuntime	Lmqq/app/AppRuntime;
    //   394: return
    //   395: aload_1
    //   396: ldc 255
    //   398: invokevirtual 338	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: astore_1
    //   402: goto -297 -> 105
    //   405: aload_3
    //   406: ldc_w 384
    //   409: sipush 512
    //   412: invokevirtual 388	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   415: aload_3
    //   416: ldc_w 430
    //   419: ldc_w 432
    //   422: invokevirtual 436	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   425: aload_0
    //   426: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   429: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   432: ifnull +34 -> 466
    //   435: aload_0
    //   436: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   439: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   442: invokevirtual 445	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   445: ifeq +21 -> 466
    //   448: aload_0
    //   449: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   452: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   455: invokevirtual 448	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   458: aload_0
    //   459: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   462: aconst_null
    //   463: putfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   466: aload_0
    //   467: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   470: astore_1
    //   471: iconst_0
    //   472: putstatic 392	com/tencent/mobileqq/theme/ThemeSwitchManager:isSwitchTheme	Z
    //   475: goto -112 -> 363
    //   478: astore_1
    //   479: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +32 -> 514
    //   485: ldc 104
    //   487: iconst_2
    //   488: new 43	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 298
    //   498: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_1
    //   502: invokevirtual 301	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   505: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: aload_3
    //   515: ldc_w 384
    //   518: sipush 512
    //   521: invokevirtual 388	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   524: aload_3
    //   525: ldc_w 430
    //   528: ldc_w 432
    //   531: invokevirtual 436	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   534: aload_0
    //   535: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   538: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   541: ifnull +34 -> 575
    //   544: aload_0
    //   545: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   548: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   551: invokevirtual 445	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   554: ifeq +21 -> 575
    //   557: aload_0
    //   558: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   561: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   564: invokevirtual 448	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   567: aload_0
    //   568: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   571: aconst_null
    //   572: putfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   575: aload_0
    //   576: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   579: astore 4
    //   581: iconst_0
    //   582: putstatic 392	com/tencent/mobileqq/theme/ThemeSwitchManager:isSwitchTheme	Z
    //   585: aload_1
    //   586: invokevirtual 302	org/json/JSONException:printStackTrace	()V
    //   589: goto -226 -> 363
    //   592: aload_3
    //   593: ldc_w 384
    //   596: sipush 512
    //   599: invokevirtual 388	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   602: aload_3
    //   603: ldc_w 430
    //   606: ldc_w 432
    //   609: invokevirtual 436	android/os/Bundle:putCharSequence	(Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   612: aload_0
    //   613: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   616: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   619: ifnull +34 -> 653
    //   622: aload_0
    //   623: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   626: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   629: invokevirtual 445	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   632: ifeq +21 -> 653
    //   635: aload_0
    //   636: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   639: getfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   642: invokevirtual 448	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   645: aload_0
    //   646: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   649: aconst_null
    //   650: putfield 440	com/tencent/mobileqq/theme/ThemeSwitchManager:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   653: aload_0
    //   654: getfield 18	com/tencent/mobileqq/theme/ThemeSwitchManager$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/theme/ThemeSwitchManager;
    //   657: astore_1
    //   658: iconst_0
    //   659: putstatic 392	com/tencent/mobileqq/theme/ThemeSwitchManager:isSwitchTheme	Z
    //   662: goto -299 -> 363
    //   665: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq -305 -> 363
    //   671: ldc 104
    //   673: iconst_2
    //   674: ldc_w 450
    //   677: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   680: goto -317 -> 363
    //   683: astore_1
    //   684: goto -370 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	687	0	this	SwitchThemeTask
    //   0	687	1	paramObject	java.lang.Object
    //   61	258	2	i	int
    //   42	561	3	localBundle	android.os.Bundle
    //   75	505	4	localObject1	java.lang.Object
    //   83	276	5	str	String
    //   115	134	6	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   55	103	478	org/json/JSONException
    //   105	230	478	org/json/JSONException
    //   230	254	478	org/json/JSONException
    //   254	304	478	org/json/JSONException
    //   308	314	478	org/json/JSONException
    //   314	341	478	org/json/JSONException
    //   341	363	478	org/json/JSONException
    //   395	402	478	org/json/JSONException
    //   405	466	478	org/json/JSONException
    //   466	475	478	org/json/JSONException
    //   592	653	478	org/json/JSONException
    //   653	662	478	org/json/JSONException
    //   308	314	683	java/lang/Exception
  }
  
  protected void onPreExecute()
  {
    Activity localActivity = null;
    if (this.this$0.currActivityRef != null) {
      localActivity = (Activity)this.this$0.currActivityRef.get();
    }
    if (localActivity != null)
    {
      ThemeSwitchManager localThemeSwitchManager = this.this$0;
      ThemeSwitchManager.isSwitchTheme = true;
      this.this$0.themeSwitchDialog = new QQProgressDialog(localActivity, ((BaseActivity)localActivity).getTitleBarHeight());
      this.this$0.themeSwitchDialog.setCancelable(false);
      this.this$0.themeSwitchDialog.b(2131366714);
      this.this$0.themeSwitchDialog.show();
    }
    for (;;)
    {
      super.onPreExecute();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "activity is not TitleBarActivity");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.SwitchThemeTask
 * JD-Core Version:    0.7.0.1
 */