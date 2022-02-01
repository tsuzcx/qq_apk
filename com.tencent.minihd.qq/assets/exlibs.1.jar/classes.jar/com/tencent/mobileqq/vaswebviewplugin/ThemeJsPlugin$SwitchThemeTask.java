package com.tencent.mobileqq.vaswebviewplugin;

import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ThemeJsPlugin$SwitchThemeTask
  extends AsyncTask
{
  private int THEME_OPTION_ERROR = -1;
  private int THEME_OPTION_PKG_NOT_EXISTS = 1;
  private int THEME_OPTION_PKG_UNZIP_ERROR = 2;
  private int THEME_OPTION_SAVE_THEMEINFO_ERROR = 3;
  private int THEME_OPTION_SUCCESS = 0;
  public String callbackId;
  public boolean showDlgTip;
  
  public ThemeJsPlugin$SwitchThemeTask(ThemeJsPlugin paramThemeJsPlugin, String paramString, boolean paramBoolean)
  {
    this.callbackId = paramString;
    this.showDlgTip = paramBoolean;
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
                  QLog.d("ThemeJsPlugin", 2, "delete old theme res dir,themeId=" + paramString1 + ",dirName=" + str);
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
    //   3: checkcast 56	java/lang/String
    //   6: astore_3
    //   7: aload_1
    //   8: iconst_1
    //   9: aaload
    //   10: checkcast 56	java/lang/String
    //   13: astore 6
    //   15: new 132	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 133	org/json/JSONObject:<init>	()V
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 135
    //   26: aload_3
    //   27: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_1
    //   32: ldc 141
    //   34: aload 6
    //   36: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_1
    //   41: ldc 143
    //   43: aload_0
    //   44: getfield 25	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_ERROR	I
    //   47: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   50: pop
    //   51: aload_1
    //   52: ldc 148
    //   54: ldc 150
    //   56: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_3
    //   61: ifnull +12 -> 73
    //   64: aload_3
    //   65: ldc 152
    //   67: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +119 -> 189
    //   73: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +38 -> 114
    //   79: ldc 96
    //   81: iconst_2
    //   82: new 98	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   89: ldc 158
    //   91: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_3
    //   95: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc 160
    //   100: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 6
    //   105: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_3
    //   115: ifnonnull +12 -> 127
    //   118: aload_1
    //   119: ldc 135
    //   121: ldc 152
    //   123: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   126: pop
    //   127: ldc2_w 164
    //   130: invokestatic 171	java/lang/Thread:sleep	(J)V
    //   133: aload_1
    //   134: ldc 143
    //   136: aload_0
    //   137: getfield 27	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   140: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload_1
    //   145: ldc 148
    //   147: ldc 173
    //   149: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   152: pop
    //   153: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +31 -> 187
    //   159: ldc 96
    //   161: iconst_2
    //   162: new 98	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   169: ldc 175
    //   171: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_1
    //   175: invokevirtual 176	org/json/JSONObject:toString	()Ljava/lang/String;
    //   178: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_1
    //   188: areturn
    //   189: aload_0
    //   190: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   193: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   196: aload_3
    //   197: invokestatic 188	com/tencent/mobileqq/theme/ThemeUtil:getThemeInfo	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;
    //   200: astore 5
    //   202: aload 5
    //   204: ifnull +45 -> 249
    //   207: aload 5
    //   209: getfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   212: ldc 195
    //   214: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifeq +32 -> 249
    //   220: aload_0
    //   221: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   224: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   227: aload_3
    //   228: invokestatic 199	com/tencent/mobileqq/theme/ThemeUtil:getErrorThemeId	(Landroid/content/Context;Ljava/lang/String;)I
    //   231: ldc 200
    //   233: idiv
    //   234: ldc 202
    //   236: invokestatic 207	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   239: if_icmpne +10 -> 249
    //   242: aload 5
    //   244: ldc 202
    //   246: putfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   249: aload_0
    //   250: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   253: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   256: aload_3
    //   257: aload 6
    //   259: invokestatic 211	com/tencent/mobileqq/theme/ThemeUtil:getThemeResourcePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 4
    //   264: aload_0
    //   265: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   268: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   271: aload_3
    //   272: aload 6
    //   274: invokestatic 214	com/tencent/mobileqq/theme/ThemeUtil:getThemeDownloadFilePath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   277: astore 6
    //   279: new 62	java/io/File
    //   282: dup
    //   283: aload 6
    //   285: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   288: astore 7
    //   290: aload 5
    //   292: ifnull +137 -> 429
    //   295: aload 5
    //   297: getfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   300: ldc 195
    //   302: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   305: ifeq +124 -> 429
    //   308: new 62	java/io/File
    //   311: dup
    //   312: aload 4
    //   314: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   317: invokevirtual 217	java/io/File:exists	()Z
    //   320: istore_2
    //   321: iload_2
    //   322: ifeq +75 -> 397
    //   325: ldc2_w 164
    //   328: invokestatic 171	java/lang/Thread:sleep	(J)V
    //   331: aload_1
    //   332: ldc 143
    //   334: aload_0
    //   335: getfield 27	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   338: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   341: pop
    //   342: aload_1
    //   343: ldc 219
    //   345: aload 4
    //   347: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   350: pop
    //   351: aload_1
    //   352: ldc 148
    //   354: ldc 221
    //   356: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   359: pop
    //   360: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +578 -> 941
    //   366: ldc 96
    //   368: iconst_2
    //   369: new 98	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   376: ldc 223
    //   378: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_1
    //   382: invokevirtual 176	org/json/JSONObject:toString	()Ljava/lang/String;
    //   385: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: goto +547 -> 941
    //   397: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +29 -> 429
    //   403: ldc 96
    //   405: iconst_2
    //   406: new 98	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   413: ldc 225
    //   415: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 4
    //   420: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 5
    //   431: ifnull +333 -> 764
    //   434: aload 7
    //   436: invokevirtual 217	java/io/File:exists	()Z
    //   439: ifeq +325 -> 764
    //   442: aload 7
    //   444: invokevirtual 228	java/io/File:length	()J
    //   447: aload 5
    //   449: getfield 232	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   452: lcmp
    //   453: ifne +311 -> 764
    //   456: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +42 -> 501
    //   462: ldc 96
    //   464: iconst_2
    //   465: new 98	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   472: ldc 234
    //   474: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 7
    //   479: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   482: ldc 239
    //   484: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 5
    //   489: getfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   492: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   501: aload_0
    //   502: aload_3
    //   503: aload 4
    //   505: invokevirtual 241	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:delOldResDir	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload 6
    //   510: aload 4
    //   512: iconst_0
    //   513: invokestatic 244	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   516: new 62	java/io/File
    //   519: dup
    //   520: aload 4
    //   522: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   525: invokevirtual 217	java/io/File:exists	()Z
    //   528: ifeq +206 -> 734
    //   531: aload 5
    //   533: ldc 195
    //   535: putfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   538: aload_0
    //   539: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   542: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   545: aload 5
    //   547: invokestatic 248	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   550: invokevirtual 253	java/lang/Boolean:booleanValue	()Z
    //   553: iconst_1
    //   554: if_icmpne +113 -> 667
    //   557: aload_1
    //   558: ldc 143
    //   560: aload_0
    //   561: getfield 27	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   564: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   567: pop
    //   568: aload_1
    //   569: ldc 219
    //   571: aload 4
    //   573: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   576: pop
    //   577: aload_1
    //   578: ldc 148
    //   580: ldc 255
    //   582: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   585: pop
    //   586: goto -433 -> 153
    //   589: astore_3
    //   590: aload_1
    //   591: ldc 148
    //   593: ldc_w 257
    //   596: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   599: pop
    //   600: aload_1
    //   601: ldc 143
    //   603: aload_0
    //   604: getfield 31	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   607: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   610: pop
    //   611: aload 6
    //   613: invokestatic 259	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   616: pop
    //   617: aload_3
    //   618: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   621: goto -468 -> 153
    //   624: astore_3
    //   625: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +32 -> 660
    //   631: ldc 96
    //   633: iconst_2
    //   634: new 98	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   641: ldc_w 262
    //   644: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload_3
    //   648: invokevirtual 265	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   651: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: aload_3
    //   661: invokevirtual 266	org/json/JSONException:printStackTrace	()V
    //   664: goto -511 -> 153
    //   667: aload_1
    //   668: ldc 148
    //   670: ldc_w 268
    //   673: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   676: pop
    //   677: aload_1
    //   678: ldc 143
    //   680: aload_0
    //   681: getfield 33	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SAVE_THEMEINFO_ERROR	I
    //   684: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   687: pop
    //   688: goto -535 -> 153
    //   691: astore_3
    //   692: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   695: ifeq +32 -> 727
    //   698: ldc 96
    //   700: iconst_2
    //   701: new 98	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   708: ldc_w 270
    //   711: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload_3
    //   715: invokevirtual 271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   718: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: aload_3
    //   728: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   731: goto -578 -> 153
    //   734: aload_1
    //   735: ldc 148
    //   737: ldc_w 273
    //   740: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   743: pop
    //   744: aload_1
    //   745: ldc 143
    //   747: aload_0
    //   748: getfield 31	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_PKG_UNZIP_ERROR	I
    //   751: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   754: pop
    //   755: aload 6
    //   757: invokestatic 259	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   760: pop
    //   761: goto -608 -> 153
    //   764: aload 5
    //   766: ifnonnull +27 -> 793
    //   769: aload_1
    //   770: ldc 148
    //   772: ldc_w 275
    //   775: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   778: pop
    //   779: aload_1
    //   780: ldc 143
    //   782: aload_0
    //   783: getfield 29	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_PKG_NOT_EXISTS	I
    //   786: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   789: pop
    //   790: goto -637 -> 153
    //   793: aload 7
    //   795: invokevirtual 217	java/io/File:exists	()Z
    //   798: ifne +62 -> 860
    //   801: aload 5
    //   803: ifnull +44 -> 847
    //   806: aload 5
    //   808: getfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   811: ldc_w 277
    //   814: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   817: ifne +30 -> 847
    //   820: aload 5
    //   822: ldc_w 277
    //   825: putfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   828: aload 5
    //   830: lconst_0
    //   831: putfield 280	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   834: aload_0
    //   835: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   838: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   841: aload 5
    //   843: invokestatic 248	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   846: pop
    //   847: aload_1
    //   848: ldc 148
    //   850: ldc_w 282
    //   853: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   856: pop
    //   857: goto -78 -> 779
    //   860: aload 7
    //   862: invokevirtual 228	java/io/File:length	()J
    //   865: aload 5
    //   867: getfield 232	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:size	J
    //   870: lcmp
    //   871: ifeq -92 -> 779
    //   874: aload 5
    //   876: ifnull +44 -> 920
    //   879: aload 5
    //   881: getfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   884: ldc_w 284
    //   887: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   890: ifne +30 -> 920
    //   893: aload 5
    //   895: ldc_w 284
    //   898: putfield 193	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:status	Ljava/lang/String;
    //   901: aload 5
    //   903: lconst_0
    //   904: putfield 280	com/tencent/mobileqq/theme/ThemeUtil$ThemeInfo:downsize	J
    //   907: aload_0
    //   908: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   911: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   914: aload 5
    //   916: invokestatic 248	com/tencent/mobileqq/theme/ThemeUtil:setThemeInfo	(Landroid/content/Context;Lcom/tencent/mobileqq/theme/ThemeUtil$ThemeInfo;)Ljava/lang/Boolean;
    //   919: pop
    //   920: aload_1
    //   921: ldc 148
    //   923: ldc_w 286
    //   926: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   929: pop
    //   930: goto -151 -> 779
    //   933: astore_3
    //   934: goto -801 -> 133
    //   937: astore_3
    //   938: goto -607 -> 331
    //   941: aload_1
    //   942: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	943	0	this	SwitchThemeTask
    //   0	943	1	paramVarArgs	java.lang.Object[]
    //   320	2	2	bool	boolean
    //   6	497	3	str1	String
    //   589	29	3	localIOException	java.io.IOException
    //   624	37	3	localJSONException	org.json.JSONException
    //   691	37	3	localException1	Exception
    //   933	1	3	localException2	Exception
    //   937	1	3	localException3	Exception
    //   262	310	4	str2	String
    //   200	715	5	localThemeInfo	com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo
    //   13	743	6	str3	String
    //   288	573	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   501	586	589	java/io/IOException
    //   667	688	589	java/io/IOException
    //   734	761	589	java/io/IOException
    //   23	60	624	org/json/JSONException
    //   64	73	624	org/json/JSONException
    //   73	114	624	org/json/JSONException
    //   118	127	624	org/json/JSONException
    //   127	133	624	org/json/JSONException
    //   133	153	624	org/json/JSONException
    //   189	202	624	org/json/JSONException
    //   207	249	624	org/json/JSONException
    //   249	290	624	org/json/JSONException
    //   295	321	624	org/json/JSONException
    //   325	331	624	org/json/JSONException
    //   331	394	624	org/json/JSONException
    //   397	429	624	org/json/JSONException
    //   434	501	624	org/json/JSONException
    //   501	586	624	org/json/JSONException
    //   590	621	624	org/json/JSONException
    //   667	688	624	org/json/JSONException
    //   734	761	624	org/json/JSONException
    //   769	779	624	org/json/JSONException
    //   779	790	624	org/json/JSONException
    //   793	801	624	org/json/JSONException
    //   806	847	624	org/json/JSONException
    //   847	857	624	org/json/JSONException
    //   860	874	624	org/json/JSONException
    //   879	920	624	org/json/JSONException
    //   920	930	624	org/json/JSONException
    //   23	60	691	java/lang/Exception
    //   64	73	691	java/lang/Exception
    //   73	114	691	java/lang/Exception
    //   118	127	691	java/lang/Exception
    //   133	153	691	java/lang/Exception
    //   189	202	691	java/lang/Exception
    //   207	249	691	java/lang/Exception
    //   249	290	691	java/lang/Exception
    //   295	321	691	java/lang/Exception
    //   331	394	691	java/lang/Exception
    //   397	429	691	java/lang/Exception
    //   434	501	691	java/lang/Exception
    //   501	586	691	java/lang/Exception
    //   590	621	691	java/lang/Exception
    //   667	688	691	java/lang/Exception
    //   734	761	691	java/lang/Exception
    //   769	779	691	java/lang/Exception
    //   779	790	691	java/lang/Exception
    //   793	801	691	java/lang/Exception
    //   806	847	691	java/lang/Exception
    //   847	857	691	java/lang/Exception
    //   860	874	691	java/lang/Exception
    //   879	920	691	java/lang/Exception
    //   920	930	691	java/lang/Exception
    //   127	133	933	java/lang/Exception
    //   325	331	937	java/lang/Exception
  }
  
  /* Error */
  protected void onPostExecute(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +32 -> 37
    //   8: ldc 96
    //   10: iconst_2
    //   11: new 98	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 293
    //   21: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 176	org/json/JSONObject:toString	()Ljava/lang/String;
    //   28: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_1
    //   38: ldc 143
    //   40: invokevirtual 296	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   43: istore_2
    //   44: aload_1
    //   45: ldc 148
    //   47: invokevirtual 300	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 7
    //   52: aload_1
    //   53: ldc 135
    //   55: invokevirtual 300	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 4
    //   60: aload_1
    //   61: ldc 141
    //   63: invokevirtual 300	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 6
    //   68: new 132	org/json/JSONObject
    //   71: dup
    //   72: invokespecial 133	org/json/JSONObject:<init>	()V
    //   75: astore 5
    //   77: aload 5
    //   79: ldc_w 302
    //   82: iload_2
    //   83: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload 5
    //   89: ldc_w 304
    //   92: aload 7
    //   94: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: iload_2
    //   99: aload_0
    //   100: getfield 27	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:THEME_OPTION_SUCCESS	I
    //   103: if_icmpne +360 -> 463
    //   106: aload 4
    //   108: ldc 152
    //   110: invokevirtual 156	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifeq +269 -> 382
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_0
    //   119: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   122: invokevirtual 307	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:doScreenShot	()V
    //   125: invokestatic 313	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   128: aload_0
    //   129: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   132: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   135: aload_1
    //   136: invokevirtual 317	com/tencent/theme/SkinEngine:setSkinRootPath	(Landroid/content/Context;Ljava/lang/String;)Z
    //   139: iconst_1
    //   140: if_icmpne +252 -> 392
    //   143: aload_0
    //   144: invokevirtual 319	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:clearImageCache	()V
    //   147: aload_0
    //   148: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   151: invokestatic 323	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$100	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   154: aload 4
    //   156: aload 6
    //   158: invokestatic 327	com/tencent/mobileqq/theme/ThemeUtil:setCurrentThemeIdVersion	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;
    //   161: pop
    //   162: new 329	android/os/Bundle
    //   165: dup
    //   166: invokespecial 330	android/os/Bundle:<init>	()V
    //   169: astore_1
    //   170: aload_1
    //   171: ldc 135
    //   173: aload 4
    //   175: invokevirtual 333	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: ldc_w 335
    //   181: ldc_w 337
    //   184: aload_0
    //   185: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   188: getfield 341	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   191: getfield 346	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   194: aload_1
    //   195: invokestatic 352	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   198: astore_1
    //   199: aload_0
    //   200: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   203: aload_1
    //   204: iconst_0
    //   205: iconst_1
    //   206: invokevirtual 356	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   209: aload_0
    //   210: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   213: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   216: aload 4
    //   218: invokestatic 199	com/tencent/mobileqq/theme/ThemeUtil:getErrorThemeId	(Landroid/content/Context;Ljava/lang/String;)I
    //   221: istore_2
    //   222: iload_2
    //   223: ifle +366 -> 589
    //   226: ldc2_w 357
    //   229: invokestatic 171	java/lang/Thread:sleep	(J)V
    //   232: iload_2
    //   233: ldc 200
    //   235: idiv
    //   236: ldc 202
    //   238: invokestatic 207	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: if_icmpne +16 -> 257
    //   244: aload_0
    //   245: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   248: invokestatic 182	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$000	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;)Landroid/content/Context;
    //   251: aload 4
    //   253: iconst_1
    //   254: invokestatic 362	com/tencent/mobileqq/theme/ThemeUtil:setErrorThemeId	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   257: new 329	android/os/Bundle
    //   260: dup
    //   261: invokespecial 330	android/os/Bundle:<init>	()V
    //   264: astore_1
    //   265: aload_1
    //   266: ldc 135
    //   268: aload 4
    //   270: invokevirtual 333	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_1
    //   274: ldc 141
    //   276: aload 6
    //   278: invokevirtual 333	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: ldc_w 364
    //   284: ldc_w 337
    //   287: aload_0
    //   288: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   291: getfield 341	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   294: getfield 346	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   297: aload_1
    //   298: invokestatic 352	com/tencent/mobileqq/emosm/DataFactory:makeIPCRequestPacket	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   301: astore_1
    //   302: aload_0
    //   303: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   306: aload_1
    //   307: iconst_0
    //   308: iconst_1
    //   309: invokevirtual 356	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   312: goto +277 -> 589
    //   315: aload_0
    //   316: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   319: new 98	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   326: aload_0
    //   327: getfield 35	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:callbackId	Ljava/lang/String;
    //   330: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 366
    //   336: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 5
    //   341: invokevirtual 176	org/json/JSONObject:toString	()Ljava/lang/String;
    //   344: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 368
    //   350: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokevirtual 371	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJs	(Ljava/lang/String;)V
    //   359: aload_0
    //   360: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   363: astore_1
    //   364: iload_2
    //   365: ifeq +5 -> 370
    //   368: iconst_0
    //   369: istore_3
    //   370: aload_1
    //   371: ldc_w 373
    //   374: iload_3
    //   375: aload 4
    //   377: lconst_0
    //   378: invokestatic 377	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:access$200	(Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;Ljava/lang/String;ILjava/lang/String;J)V
    //   381: return
    //   382: aload_1
    //   383: ldc 219
    //   385: invokevirtual 300	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   388: astore_1
    //   389: goto -271 -> 118
    //   392: aload 5
    //   394: ldc_w 302
    //   397: iconst_m1
    //   398: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   401: pop
    //   402: aload 5
    //   404: ldc_w 304
    //   407: ldc_w 379
    //   410: invokevirtual 139	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload_0
    //   415: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   418: getfield 383	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   421: ifnull +26 -> 447
    //   424: aload_0
    //   425: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   428: getfield 383	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   431: invokevirtual 388	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   434: ifeq +13 -> 447
    //   437: aload_0
    //   438: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   441: getfield 383	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   444: invokevirtual 391	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   447: aload_0
    //   448: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   451: iconst_0
    //   452: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   455: putfield 399	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isSwitchTheme	Ljava/lang/Boolean;
    //   458: iconst_0
    //   459: istore_2
    //   460: goto +131 -> 591
    //   463: aload_0
    //   464: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   467: getfield 383	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   470: ifnull +26 -> 496
    //   473: aload_0
    //   474: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   477: getfield 383	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   480: invokevirtual 388	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   483: ifeq +13 -> 496
    //   486: aload_0
    //   487: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   490: getfield 383	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   493: invokevirtual 391	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   496: aload_0
    //   497: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   500: iconst_0
    //   501: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   504: putfield 399	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isSwitchTheme	Ljava/lang/Boolean;
    //   507: iconst_0
    //   508: istore_2
    //   509: goto -194 -> 315
    //   512: astore_1
    //   513: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq +32 -> 548
    //   519: ldc 96
    //   521: iconst_2
    //   522: new 98	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 262
    //   532: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload_1
    //   536: invokevirtual 265	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   539: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: aload_0
    //   549: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   552: getfield 383	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:themeSwitchDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   555: invokevirtual 391	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   558: aload_0
    //   559: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   562: iconst_0
    //   563: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   566: putfield 399	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:isSwitchTheme	Ljava/lang/Boolean;
    //   569: aload_0
    //   570: getfield 20	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:this$0	Lcom/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin;
    //   573: aload_0
    //   574: getfield 35	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin$SwitchThemeTask:callbackId	Ljava/lang/String;
    //   577: aload_1
    //   578: invokevirtual 265	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   581: invokevirtual 402	com/tencent/mobileqq/vaswebviewplugin/ThemeJsPlugin:callJsOnError	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: return
    //   585: astore_1
    //   586: goto -354 -> 232
    //   589: iconst_1
    //   590: istore_2
    //   591: goto -276 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	SwitchThemeTask
    //   0	594	1	paramJSONObject	org.json.JSONObject
    //   43	548	2	i	int
    //   1	374	3	j	int
    //   58	318	4	str1	String
    //   75	328	5	localJSONObject	org.json.JSONObject
    //   66	211	6	str2	String
    //   50	43	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   37	116	512	org/json/JSONException
    //   118	222	512	org/json/JSONException
    //   226	232	512	org/json/JSONException
    //   232	257	512	org/json/JSONException
    //   257	312	512	org/json/JSONException
    //   315	364	512	org/json/JSONException
    //   370	381	512	org/json/JSONException
    //   382	389	512	org/json/JSONException
    //   392	447	512	org/json/JSONException
    //   447	458	512	org/json/JSONException
    //   463	496	512	org/json/JSONException
    //   496	507	512	org/json/JSONException
    //   226	232	585	java/lang/Exception
  }
  
  protected void onPreExecute()
  {
    if ((this.this$0.mRuntime.a() != null) && ((this.this$0.mRuntime.a() instanceof IphoneTitleBarActivity)))
    {
      this.this$0.isSwitchTheme = Boolean.valueOf(true);
      this.this$0.themeSwitchDialog = new QQProgressDialog(this.this$0.mRuntime.a(), ((IphoneTitleBarActivity)this.this$0.mRuntime.a()).getTitleBarHeight());
      this.this$0.themeSwitchDialog.setCancelable(false);
      this.this$0.themeSwitchDialog.b(2131366714);
      if (!this.showDlgTip) {
        this.this$0.themeSwitchDialog.c(false);
      }
      this.this$0.themeSwitchDialog.show();
    }
    for (;;)
    {
      super.onPreExecute();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeJsPlugin", 2, "activity is not TitleBarActivity");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.SwitchThemeTask
 * JD-Core Version:    0.7.0.1
 */