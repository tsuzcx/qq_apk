package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider.SosoSrvAddrType;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.pb.websafe.WebSafe.CheckURLReq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import cqq;
import cqr;
import cqs;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mqq.app.NewIntent;

public class SosoPlugin
  extends WebViewPlugin
{
  public static final int a = 0;
  public static final String a = "key_isReadModeEnabled";
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { "https://htdata.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080", "https://htdata2.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080" };
  public static final int b = 1;
  public static final String b = "https://htdata.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080";
  public static final String c = "https://htdata2.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080";
  private static boolean jdField_c_of_type_Boolean = false;
  public static final String d = "/cgi-bin/httpconn?htcmd=0x6ff0080";
  private static boolean jdField_d_of_type_Boolean = false;
  public static final String e = "#__SOSO_RAW_URL___";
  private static final String f = "1004";
  private static final String g = "domain_white_list.txt";
  private static final String h = "https://pub.idqqimg.com/qqmobile/client/android/forbidden.html";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  SosoSrvAddrProvider jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider;
  public WebView a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  protected boolean a;
  boolean b = true;
  private int jdField_c_of_type_Int = 1;
  private int jdField_d_of_type_Int = this.jdField_c_of_type_Int;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = false;
  
  public SosoPlugin()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new cqq(this);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "registerReceiver soso receiver");
      }
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.receiver.soso"));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, "registerReceiver soso receiver error", localException);
    }
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: getfield 68	com/tencent/biz/webviewplugin/SosoPlugin:TAG	Ljava/lang/String;
    //   13: iconst_2
    //   14: ldc 119
    //   16: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: new 121	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 122	java/util/ArrayList:<init>	()V
    //   27: putfield 124	com/tencent/biz/webviewplugin/SosoPlugin:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   30: new 126	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: new 129	java/io/FileInputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 132	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_3
    //   48: new 134	java/io/BufferedReader
    //   51: dup
    //   52: new 136	java/io/InputStreamReader
    //   55: dup
    //   56: aload_3
    //   57: invokespecial 139	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   60: invokespecial 142	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore_2
    //   64: aload_2
    //   65: invokevirtual 146	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +57 -> 127
    //   73: aload_0
    //   74: getfield 124	com/tencent/biz/webviewplugin/SosoPlugin:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   77: aload_1
    //   78: invokevirtual 150	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: goto -18 -> 64
    //   85: astore 4
    //   87: aload_3
    //   88: astore_1
    //   89: aload 4
    //   91: astore_3
    //   92: invokestatic 153	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   95: ifeq +15 -> 110
    //   98: aload_0
    //   99: getfield 68	com/tencent/biz/webviewplugin/SosoPlugin:TAG	Ljava/lang/String;
    //   102: iconst_4
    //   103: aload_3
    //   104: invokestatic 157	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   107: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 160	java/io/BufferedReader:close	()V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 163	java/io/InputStream:close	()V
    //   126: return
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 160	java/io/BufferedReader:close	()V
    //   135: aload_3
    //   136: ifnull -10 -> 126
    //   139: aload_3
    //   140: invokevirtual 163	java/io/InputStream:close	()V
    //   143: return
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   149: return
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   155: goto -20 -> 135
    //   158: astore_2
    //   159: aload_2
    //   160: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   163: goto -45 -> 118
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   171: return
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_3
    //   177: aload_2
    //   178: ifnull +7 -> 185
    //   181: aload_2
    //   182: invokevirtual 160	java/io/BufferedReader:close	()V
    //   185: aload_3
    //   186: ifnull +7 -> 193
    //   189: aload_3
    //   190: invokevirtual 163	java/io/InputStream:close	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_2
    //   196: aload_2
    //   197: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   200: goto -15 -> 185
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   208: goto -15 -> 193
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_2
    //   214: goto -37 -> 177
    //   217: astore_1
    //   218: goto -41 -> 177
    //   221: astore 4
    //   223: aload_1
    //   224: astore_3
    //   225: aload 4
    //   227: astore_1
    //   228: goto -51 -> 177
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_2
    //   234: aload 4
    //   236: astore_1
    //   237: goto -145 -> 92
    //   240: astore 4
    //   242: aconst_null
    //   243: astore_2
    //   244: aload_3
    //   245: astore_1
    //   246: aload 4
    //   248: astore_3
    //   249: goto -157 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	SosoPlugin
    //   0	252	1	paramString	String
    //   63	69	2	localBufferedReader	java.io.BufferedReader
    //   158	2	2	localIOException1	java.io.IOException
    //   174	8	2	localObject1	Object
    //   195	2	2	localIOException2	java.io.IOException
    //   203	2	2	localIOException3	java.io.IOException
    //   213	31	2	localObject2	Object
    //   47	178	3	localObject3	Object
    //   231	14	3	localIOException4	java.io.IOException
    //   248	1	3	localIOException5	java.io.IOException
    //   1	1	4	localObject4	Object
    //   85	5	4	localIOException6	java.io.IOException
    //   221	14	4	localObject5	Object
    //   240	7	4	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   64	69	85	java/io/IOException
    //   73	82	85	java/io/IOException
    //   139	143	144	java/io/IOException
    //   131	135	150	java/io/IOException
    //   114	118	158	java/io/IOException
    //   122	126	166	java/io/IOException
    //   39	48	172	finally
    //   181	185	195	java/io/IOException
    //   189	193	203	java/io/IOException
    //   48	64	211	finally
    //   64	69	217	finally
    //   73	82	217	finally
    //   92	110	221	finally
    //   39	48	231	java/io/IOException
    //   48	64	240	java/io/IOException
  }
  
  private String b(String paramString)
  {
    String str;
    if (this.jdField_c_of_type_Int == 1)
    {
      str = paramString;
      if (this.b) {
        str = a(this.mRuntime.a().getIntent(), paramString, SosoSrvAddrProvider.a());
      }
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"));
      str = paramString;
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "VIEW_MODE_SYSTEM_BROWSER_MODE! url is not original!");
    return paramString;
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = 0;
      return;
    }
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = 1;
  }
  
  String a(Intent paramIntent, String paramString, SosoSrvAddrProvider paramSosoSrvAddrProvider)
  {
    if ((paramString.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) || (paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      return paramString;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = jdField_a_of_type_ArrayOfJavaLangString[new java.util.Random().nextInt(2)];
        String str = paramSosoSrvAddrProvider.a(SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV);
        paramSosoSrvAddrProvider = (SosoSrvAddrProvider)localObject;
        if (str != null)
        {
          paramSosoSrvAddrProvider = (SosoSrvAddrProvider)localObject;
          if (str.length() > 0)
          {
            localObject = ((String)localObject).replaceFirst("http://[^/\\s]*/", str);
            paramSosoSrvAddrProvider = (SosoSrvAddrProvider)localObject;
            if (QLog.isColorLevel())
            {
              QLog.d(this.TAG, 2, "replaceDomainWithIp: " + (String)localObject);
              paramSosoSrvAddrProvider = (SosoSrvAddrProvider)localObject;
            }
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramSosoSrvAddrProvider);
        ((StringBuilder)localObject).append("&u=");
        ((StringBuilder)localObject).append(URLEncoder.encode(paramString, "UTF-8"));
        ((StringBuilder)localObject).append("&wap=3");
        switch (paramIntent.getExtras().getInt("curtype"))
        {
        case 0: 
          ((StringBuilder)localObject).append("&qq-pf-to=mqq.temporaryc2c");
          paramSosoSrvAddrProvider = paramIntent.getStringExtra("uin");
          if (!TextUtils.isEmpty(paramSosoSrvAddrProvider)) {
            ((StringBuilder)localObject).append("&uin=").append(paramSosoSrvAddrProvider);
          }
          paramIntent = paramIntent.getStringExtra("friendUin");
          if (!TextUtils.isEmpty(paramIntent)) {
            ((StringBuilder)localObject).append("&originuin=").append(paramIntent);
          }
          return ((StringBuilder)localObject).toString();
        }
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        paramIntent.printStackTrace();
        return paramString;
      }
      ((StringBuilder)localObject).append("&qq-pf-to=mqq.c2c");
      continue;
      ((StringBuilder)localObject).append("&qq-pf-to=mqq.group");
      continue;
      ((StringBuilder)localObject).append("&qq-pf-to=mqq.discussion");
    }
  }
  
  String a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return paramString;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      String str;
      if (paramString.indexOf("#__SOSO_RAW_URL___") == -1) {
        str = b(paramString);
      }
      for (;;)
      {
        paramString = str;
        if (this.jdField_d_of_type_Int != 0) {
          break;
        }
        this.jdField_e_of_type_Int = -1;
        return str;
        this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = 0;
        this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
        str = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d(this.TAG, 2, "anchorIndex org " + this.jdField_e_of_type_Int);
          str = paramString;
        }
      }
    }
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = 0;
    return paramString;
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    int i = 1;
    if (paramInt == 12)
    {
      paramInt = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
      if (this.jdField_e_of_type_Int == paramInt - 1)
      {
        b();
        this.jdField_e_of_type_Int = paramInt;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "anchorIndex back " + this.jdField_e_of_type_Int);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if (paramInt != 1) {
              break;
            }
            this.b = true;
            if (paramString.contains("https://pub.idqqimg.com/qqmobile/client/android/forbidden.html"))
            {
              this.jdField_a_of_type_ComTencentSmttSdkWebView.clearHistory();
              return false;
            }
          } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http")));
          if (this.jdField_e_of_type_Boolean) {}
          for (paramInt = i;; paramInt = 0)
          {
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web_safe", "url_safe_check", 0, paramInt, "", "", "", "");
            return false;
          }
          if (paramInt == 2)
          {
            this.b = true;
            SosoSrvAddrProvider.a().a(SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV, paramString);
            return false;
          }
          if (paramInt == 0)
          {
            this.b = false;
            return false;
          }
        } while (paramInt != 13);
        paramInt = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
      } while (this.jdField_e_of_type_Int != paramInt + 1);
      b();
      this.jdField_e_of_type_Int = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "anchorIndex forward " + this.jdField_e_of_type_Int);
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    Object localObject1;
    int j;
    Object localObject2;
    if (("http".equals(paramString2)) || ("https".equals(paramString2)))
    {
      if ((paramString1.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) || (paramString1.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) || (!this.jdField_a_of_type_Boolean)) {
        return false;
      }
      if (jdField_d_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "check url safety with old solution (<5.3)");
        }
        paramString2 = a(paramString1);
        if (!paramString1.equalsIgnoreCase(paramString2))
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString2);
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "check url safety with new solution (>= 5.3)");
        }
        if (!jdField_c_of_type_Boolean)
        {
          if (HtmlOffline.g("1004"))
          {
            boolean bool = HtmlOffline.a("1004", "http://domain_white_list.txt");
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "verify offline file " + bool);
            }
          }
          if (HttpUtil.a() == 1) {
            HtmlOffline.b(this.mRuntime.a(), "1004", this.mRuntime.a().getAccount(), true, new cqr(this));
          }
          jdField_c_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
        {
          paramString2 = HtmlOffline.a("1004") + "1004" + File.separator + "domain_white_list.txt";
          if (FileUtils.a(paramString2)) {
            a(paramString2);
          }
        }
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramString2 = Uri.parse(paramString1).getHost();
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          int i = 0;
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break label408;
          }
          if (!AuthorizeConfig.b((String)((Iterator)localObject1).next(), paramString2)) {
            break label779;
          }
          localObject2 = a(paramString1);
          if (!paramString1.equalsIgnoreCase((String)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "current url is in the format white list, check it with the old solution");
            }
            this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl((String)localObject2);
            return true;
          }
          i = 1;
        }
      }
    }
    label779:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "after trying to read the offline format white list into the memory, mFormatWhiteList is still null, so check current url with new solution");
      }
      jdField_c_of_type_Boolean = false;
      j = 0;
      label408:
      if ((this.mRuntime != null) && (j == 0))
      {
        paramString2 = new WebSafe.CheckURLReq();
        paramString2.url.set(paramString1);
        if (this.mRuntime.a() != null)
        {
          localObject2 = this.mRuntime.a().getIntent();
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("wap=3");
            switch (((Intent)localObject2).getExtras().getInt("curtype"))
            {
            default: 
              ((StringBuilder)localObject1).append("&qq-pf-to=mqq.temporaryc2c");
            }
          }
        }
      }
      for (;;)
      {
        String str = ((Intent)localObject2).getStringExtra("uin");
        if (!TextUtils.isEmpty(str)) {
          ((StringBuilder)localObject1).append("&uin=").append(str);
        }
        localObject2 = ((Intent)localObject2).getStringExtra("friendUin");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((StringBuilder)localObject1).append("&originuin=").append((String)localObject2);
        }
        paramString2.gdt_data.set(((StringBuilder)localObject1).toString());
        localObject1 = new NewIntent(this.mRuntime.a(), ProtoServlet.class);
        ((NewIntent)localObject1).setWithouLogin(true);
        ((NewIntent)localObject1).putExtra("cmd", "SafeSvr.check_url");
        ((NewIntent)localObject1).putExtra("data", paramString2.toByteArray());
        ((NewIntent)localObject1).setObserver(new cqs(this, paramString1));
        if (this.mRuntime.a() != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "sending SSO request, SafeSvr.check_url, url : " + Util.a(paramString1, new String[0]));
          }
          this.mRuntime.a().startServlet((NewIntent)localObject1);
          this.jdField_e_of_type_Boolean = false;
        }
        return false;
        ((StringBuilder)localObject1).append("&qq-pf-to=mqq.c2c");
        continue;
        ((StringBuilder)localObject1).append("&qq-pf-to=mqq.group");
        continue;
        ((StringBuilder)localObject1).append("&qq-pf-to=mqq.discussion");
      }
    }
  }
  
  protected void onCreate()
  {
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
    this.jdField_a_of_type_Boolean = this.mRuntime.a().getIntent().getBooleanExtra("key_isReadModeEnabled", false);
    a();
    SosoSrvAddrProvider.a().c();
    jdField_d_of_type_Boolean = AuthorizeConfig.a().a("enable_check_url_old", Boolean.valueOf(false)).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "enable_check_url_old : " + jdField_d_of_type_Boolean);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "unregisterReceiver sosoReceiver");
      }
      this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SosoPlugin
 * JD-Core Version:    0.7.0.1
 */