package com.tencent.open.agent;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lab;
import lac;
import lad;
import lae;
import lag;
import lah;
import laj;
import lak;
import lal;
import laq;
import lar;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.cryptor;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorityActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  public static String A;
  protected static final String C = AppConstants.aG + "coupon/";
  public static final String D = "agent_login";
  public static final String E = "agent_query_authority";
  protected static final int F = 2;
  public static final String F = "agent_authority";
  protected static final int a = 1;
  public static final long a = 16L;
  protected static final String a = "AuthorityActivity";
  protected static boolean a = false;
  public static final int b = 110002;
  public static final String b = "Authority_Report";
  public static final int c = 110405;
  public static final String c = "Authority_TimeCost";
  public static final int d = 1105030;
  protected static final String d = "AuthorityActivity";
  public static final int e = 110507;
  public static final String e = "isLogin";
  public static final int f = 110401;
  public static final String f = "accList";
  public static final int g = 1;
  public static final String g = "last_account";
  public static final int h = 2;
  public static final String h = "uin";
  protected static final int i = 0;
  public static final String i = "nick";
  protected static final int j = 1;
  public static final String j = "skey";
  protected static final int k = 2;
  public static final String k = "st_temp";
  protected static final int l = 3;
  public static final String l = "st_temp_key";
  protected static final int m = 4;
  protected static final int n = 5;
  public static final String n = "param_uin";
  protected static final int o = 6;
  public static final String o = "firstlogin";
  protected static final int p = 7;
  public static final String p = AppConstants.aG + "qqconnect/";
  protected static final int q = 3000;
  protected static final String q = "ConnAuthSvr.get_auth_api_list";
  protected static final int r = 3001;
  protected static final String r = "ConnAuthSvr.sdk_auth_api";
  protected static final int s = 3002;
  protected static final String s = "ConnAuthSvr.get_app_info";
  protected static final int t = 3003;
  protected static final String t = "ConnAuthSvr.get_auth_api_list_emp";
  protected static final int u = 3004;
  protected static final String u = "ConnAuthSvr.sdk_auth_api_emp";
  protected static final int v = 3005;
  protected static final String v = "ConnAuthSvr.get_app_info_emp";
  protected static final int w = 3007;
  public static final String w = "result_data";
  protected static final int x = 1002;
  protected static final int z = 100;
  public int A;
  public int B;
  protected String B;
  public int C;
  public int D;
  public int E;
  protected String G = "";
  protected float a;
  protected SharedPreferences a;
  protected Bundle a;
  public Handler a;
  public Button a;
  protected TextView a;
  public QQProgressDialog a;
  public AuthorityActivity.AccountInfo a;
  public CardContainer a;
  public SdkAuthorize.AuthorizeResponse a;
  public OpenSDKAppInterface a;
  public Runnable a;
  ArrayList a;
  protected List a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  public long b;
  protected SharedPreferences b;
  public Runnable b;
  public boolean b;
  public long c;
  protected SharedPreferences c;
  protected boolean c;
  protected long d;
  public boolean d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h = false;
  public long i;
  public boolean i;
  public long j;
  public boolean j;
  public boolean k;
  public String m = null;
  public String x;
  public int y;
  public String y;
  protected String z;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public AuthorityActivity()
  {
    this.jdField_y_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_B_of_type_JavaLangString = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_A_of_type_Int = 6;
    this.jdField_B_of_type_Int = 0;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new lab(this);
    this.jdField_a_of_type_JavaLangRunnable = new lah(this);
    this.jdField_a_of_type_AndroidOsHandler = new lal(this);
    this.jdField_b_of_type_JavaLangRunnable = new lad(this);
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = paramString.getInputStream();
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      paramString.close();
      return localBitmap;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    String str3 = "http://face" + (Long.parseLong(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString) % 10L + 1L) + ".qun.qq.com/cgi/svr/face/getface?cache=0&type=1&f=100&uin=" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.z != null))
    {
      String str2 = this.z;
      String str1 = str2;
      if (this.z != null)
      {
        str1 = str2;
        if (this.z.length() > 12) {
          str1 = this.z.substring(0, 12) + "...";
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getResources().getString(2131368092), new Object[] { str1 }));
    }
    c(str3);
  }
  
  public void a(int paramInt, String paramString)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 6;
    localMessage.arg1 = 3004;
    localMessage.obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    paramString3 = new Bundle();
    paramString3.putInt("error", paramInt);
    paramString3.putString("response", paramString1.toString());
    paramString3.putString("msg", null);
    paramString3.putString("detail", null);
    paramString2.setData(paramString3);
    paramString2.what = 7;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString2, 1000L);
    paramString1 = "0";
    if (paramInt != 0) {
      paramString1 = "1";
    }
    try
    {
      ReportCenter.a().a(this.m, "", jdField_A_of_type_JavaLangString, "1", "3", paramString1, true);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void a(long paramLong)
  {
    Object localObject2 = new GetAppInfoProto.GetAppinfoRequest();
    this.jdField_y_of_type_Int = 2;
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).client_id.set(paramLong);
    ((GetAppInfoProto.GetAppinfoRequest)localObject2).sdkp.set("android");
    if (Build.VERSION.RELEASE == null) {}
    for (Object localObject1 = "";; localObject1 = Build.VERSION.RELEASE)
    {
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).os.set((String)localObject1);
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).qqv.set(CommonDataAdapter.a().c());
      ((GetAppInfoProto.GetAppinfoRequest)localObject2).setHasFlag(true);
      NewIntent localNewIntent = new NewIntent(this, OpensdkServlet.class);
      localNewIntent.setWithouLogin(true);
      localNewIntent.putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
      byte[] arrayOfByte = ((GetAppInfoProto.GetAppinfoRequest)localObject2).toByteArray();
      localObject2 = "ConnAuthSvr.get_app_info";
      localObject1 = arrayOfByte;
      if (!this.i)
      {
        localObject1 = a(arrayOfByte);
        localObject2 = "ConnAuthSvr.get_app_info_emp";
      }
      localNewIntent.putExtra("data", (byte[])localObject1);
      localNewIntent.putExtra("cmd", (String)localObject2);
      localNewIntent.setObserver(new laj(this));
      super.getAppRuntime().startServlet(localNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {}
    do
    {
      return;
      paramString = ImageUtil.a(paramString);
    } while (paramString == null);
    paramString = new FileOutputStream(paramString);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramString);
    paramString.flush();
    paramString.close();
  }
  
  public void a(SdkAuthorize.GetAuthApiListRequest paramGetAuthApiListRequest)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    }
    this.i = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((SimpleAccount)((Iterator)localObject).next()).getUin().equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString)) {
          this.i = true;
        }
      }
    }
    NewIntent localNewIntent = new NewIntent(this, OpensdkServlet.class);
    localNewIntent.setWithouLogin(true);
    localNewIntent.putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    byte[] arrayOfByte = paramGetAuthApiListRequest.toByteArray();
    String str = "ConnAuthSvr.get_auth_api_list";
    Object localObject = "g_a_a_l";
    paramGetAuthApiListRequest = arrayOfByte;
    if (!this.i)
    {
      if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte.length == 0))
      {
        paramGetAuthApiListRequest = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramGetAuthApiListRequest.what = 6;
        paramGetAuthApiListRequest.arg1 = 3000;
        paramGetAuthApiListRequest.obj = getResources().getString(2131368096);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramGetAuthApiListRequest);
        return;
      }
      paramGetAuthApiListRequest = a(arrayOfByte);
      str = "ConnAuthSvr.get_auth_api_list_emp";
      localObject = "g_a_a_l_emp";
    }
    localNewIntent.putExtra("data", paramGetAuthApiListRequest);
    localNewIntent.putExtra("cmd", str);
    this.jdField_y_of_type_Int = 0;
    localNewIntent.setObserver(new lag(this));
    super.getAppRuntime().startServlet(localNewIntent);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject + " | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
  }
  
  protected void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    this.m = Long.toString(((WloginSimpleInfo)localObject)._uin);
    paramString = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (paramString != null)
    {
      localObject = AuthorityUtil.a(this, paramString, 80, 80);
      paramString.recycle();
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.m, str, (Bitmap)localObject, false);
      return;
    }
    ThreadManager.b(new lae(this, str));
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramString = DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(super.getString(2131366755)).setPositiveButton(17039370, paramOnClickListener);
    if (!super.isFinishing()) {
      paramString.show();
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LogUtility.c("AuthorityActivity", "-->onTaskCompleted identifier = " + paramString + " - b = " + paramBitmap);
    if ((this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) && (paramString.equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.c)) && (paramBitmap != null))
    {
      paramString = AuthorityUtil.a(this, paramBitmap, 80, 80);
      if (paramString == null) {}
    }
    try
    {
      a(paramString, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
      runOnUiThread(new laq(this, paramString));
      return;
    }
    catch (IOException paramBitmap)
    {
      for (;;)
      {
        LogUtility.c("AuthorityActivity", "-->onTaskCompleted error", paramBitmap);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      SharedPreferences.Editor localEditor = this.jdField_c_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putString(paramString1, paramString2);
      localEditor.commit();
    }
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 718	java/io/File
    //   6: dup
    //   7: getstatic 154	com/tencent/open/agent/AuthorityActivity:p	Ljava/lang/String;
    //   10: invokespecial 719	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 9
    //   15: aload 9
    //   17: invokevirtual 722	java/io/File:exists	()Z
    //   20: ifne +118 -> 138
    //   23: aload 9
    //   25: invokevirtual 725	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: new 134	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   36: aload_1
    //   37: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 727
    //   43: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 730	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: new 718	java/io/File
    //   60: dup
    //   61: aload 9
    //   63: aload_2
    //   64: invokespecial 733	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 722	java/io/File:exists	()Z
    //   72: ifeq +8 -> 80
    //   75: aload_1
    //   76: invokevirtual 736	java/io/File:delete	()Z
    //   79: pop
    //   80: invokestatic 742	java/lang/System:currentTimeMillis	()J
    //   83: ldc2_w 368
    //   86: ldiv
    //   87: lstore 6
    //   89: new 744	java/io/DataOutputStream
    //   92: dup
    //   93: new 498	java/io/FileOutputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 501	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: invokespecial 747	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore_1
    //   105: aload_1
    //   106: lload 6
    //   108: lload_3
    //   109: ladd
    //   110: invokevirtual 750	java/io/DataOutputStream:writeLong	(J)V
    //   113: aload_1
    //   114: aload 5
    //   116: aload_2
    //   117: ldc_w 752
    //   120: invokevirtual 756	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   123: invokestatic 761	com/tencent/util/ThreeDes:a	([B[B)[B
    //   126: invokevirtual 764	java/io/DataOutputStream:write	([B)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 765	java/io/DataOutputStream:close	()V
    //   137: return
    //   138: aload 9
    //   140: invokevirtual 768	java/io/File:isFile	()Z
    //   143: ifeq -114 -> 29
    //   146: aload 9
    //   148: invokevirtual 736	java/io/File:delete	()Z
    //   151: pop
    //   152: aload 9
    //   154: invokevirtual 725	java/io/File:mkdirs	()Z
    //   157: pop
    //   158: goto -129 -> 29
    //   161: astore_1
    //   162: aload 8
    //   164: astore_1
    //   165: aload_1
    //   166: ifnull -29 -> 137
    //   169: aload_1
    //   170: invokevirtual 765	java/io/DataOutputStream:close	()V
    //   173: return
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   179: return
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   185: return
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 765	java/io/DataOutputStream:close	()V
    //   197: aload_2
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: astore_2
    //   208: goto -19 -> 189
    //   211: astore_2
    //   212: goto -47 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	AuthorityActivity
    //   0	215	1	paramString1	String
    //   0	215	2	paramString2	String
    //   0	215	3	paramLong	long
    //   0	215	5	paramArrayOfByte	byte[]
    //   87	20	6	l1	long
    //   1	162	8	localObject	Object
    //   13	140	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   3	29	161	java/io/IOException
    //   29	80	161	java/io/IOException
    //   80	105	161	java/io/IOException
    //   138	158	161	java/io/IOException
    //   169	173	174	java/io/IOException
    //   133	137	180	java/io/IOException
    //   3	29	186	finally
    //   29	80	186	finally
    //   80	105	186	finally
    //   138	158	186	finally
    //   193	197	199	java/io/IOException
    //   105	129	207	finally
    //   105	129	211	java/io/IOException
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    AuthorityActivity.AccountInfo localAccountInfo = new AuthorityActivity.AccountInfo(this);
    localAccountInfo.jdField_a_of_type_JavaLangString = paramString1;
    localAccountInfo.jdField_b_of_type_JavaLangString = paramString2;
    if (paramBundle != null)
    {
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramBundle.getByteArray("st_temp_key");
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = localAccountInfo;
    this.m = paramString1;
    i();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i1 = this.jdField_a_of_type_JavaUtilList.size() + 0;; i1 = 0)
    {
      int i2 = i1;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        i2 = i1 + this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      Intent localIntent2;
      Intent localIntent1;
      if (i2 > 1)
      {
        localIntent2 = new Intent(this, SwitchAccountActivity.class);
        localIntent2.putExtra("key_req_src", 1);
        localIntent1 = localIntent2;
        if (this.m != null)
        {
          localIntent2.putExtra("param_uin", this.m);
          localIntent1 = localIntent2;
        }
      }
      for (;;)
      {
        super.startActivityForResult(localIntent1, 1);
        overridePendingTransition(2130968634, 0);
        return;
        localIntent2 = new Intent(this, Login.class);
        localIntent2.putExtra("key_req_src", 1);
        localIntent1 = localIntent2;
        if (paramBoolean)
        {
          localIntent2.putExtra("is_first_login", true);
          localIntent1 = localIntent2;
        }
      }
    }
  }
  
  protected boolean a(Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent.getStringExtra("result_data");
    }
    try
    {
      localObject = HttpBaseUtil.a((String)localObject);
      AuthorityActivity.AccountInfo localAccountInfo = new AuthorityActivity.AccountInfo(this);
      localAccountInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("uin");
      localAccountInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("skey");
      localAccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp");
      localAccountInfo.jdField_b_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("st_temp_key");
      if ((localAccountInfo.jdField_a_of_type_JavaLangString != null) && (localAccountInfo.jdField_b_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo = localAccountInfo;
      }
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
        return true;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        a(3005, paramIntent.getMessage());
      }
    }
    return false;
  }
  
  /* Error */
  public byte[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 134	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   10: aload_1
    //   11: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 727
    //   17: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_2
    //   21: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 730	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_2
    //   31: new 718	java/io/File
    //   34: dup
    //   35: new 134	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   42: getstatic 154	com/tencent/open/agent/AuthorityActivity:p	Ljava/lang/String;
    //   45: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_2
    //   49: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 719	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 722	java/io/File:exists	()Z
    //   63: istore 4
    //   65: iload 4
    //   67: ifne +27 -> 94
    //   70: aload 5
    //   72: astore_2
    //   73: iconst_0
    //   74: ifeq +11 -> 85
    //   77: new 854	java/lang/NullPointerException
    //   80: dup
    //   81: invokespecial 855	java/lang/NullPointerException:<init>	()V
    //   84: athrow
    //   85: aload_2
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 856	java/lang/Exception:printStackTrace	()V
    //   92: aconst_null
    //   93: areturn
    //   94: new 858	java/io/DataInputStream
    //   97: dup
    //   98: new 860	java/io/FileInputStream
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 861	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: invokespecial 864	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 867	java/io/DataInputStream:readLong	()J
    //   114: invokestatic 742	java/lang/System:currentTimeMillis	()J
    //   117: ldc2_w 368
    //   120: ldiv
    //   121: lcmp
    //   122: ifle +66 -> 188
    //   125: aload_1
    //   126: invokevirtual 870	java/io/DataInputStream:available	()I
    //   129: istore_3
    //   130: iload_3
    //   131: ifle +57 -> 188
    //   134: iload_3
    //   135: newarray byte
    //   137: astore 6
    //   139: aload_1
    //   140: aload 6
    //   142: invokevirtual 874	java/io/DataInputStream:read	([B)I
    //   145: pop
    //   146: aload_1
    //   147: invokevirtual 875	java/io/DataInputStream:close	()V
    //   150: aload 6
    //   152: aload_2
    //   153: ldc_w 752
    //   156: invokevirtual 756	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   159: invokestatic 877	com/tencent/util/ThreeDes:b	([B[B)[B
    //   162: astore_2
    //   163: aload_2
    //   164: astore 5
    //   166: aload 5
    //   168: astore_2
    //   169: aload_1
    //   170: ifnull -85 -> 85
    //   173: aload_1
    //   174: invokevirtual 875	java/io/DataInputStream:close	()V
    //   177: aload 5
    //   179: areturn
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 856	java/lang/Exception:printStackTrace	()V
    //   185: aload 5
    //   187: areturn
    //   188: aload 5
    //   190: astore_2
    //   191: aload_1
    //   192: ifnull -107 -> 85
    //   195: aload_1
    //   196: invokevirtual 875	java/io/DataInputStream:close	()V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 856	java/lang/Exception:printStackTrace	()V
    //   206: aconst_null
    //   207: areturn
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_1
    //   211: aload 5
    //   213: astore_2
    //   214: aload_1
    //   215: ifnull -130 -> 85
    //   218: aload_1
    //   219: invokevirtual 875	java/io/DataInputStream:close	()V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 856	java/lang/Exception:printStackTrace	()V
    //   229: aconst_null
    //   230: areturn
    //   231: astore_2
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 875	java/io/DataInputStream:close	()V
    //   242: aload_2
    //   243: athrow
    //   244: astore_1
    //   245: aload_1
    //   246: invokevirtual 856	java/lang/Exception:printStackTrace	()V
    //   249: goto -7 -> 242
    //   252: astore_2
    //   253: goto -19 -> 234
    //   256: astore_2
    //   257: goto -46 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	AuthorityActivity
    //   0	260	1	paramString1	String
    //   0	260	2	paramString2	String
    //   129	6	3	i1	int
    //   63	3	4	bool	boolean
    //   1	211	5	str	String
    //   137	14	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   77	85	87	java/lang/Exception
    //   173	177	180	java/lang/Exception
    //   195	199	201	java/lang/Exception
    //   3	65	208	java/io/IOException
    //   94	110	208	java/io/IOException
    //   218	222	224	java/lang/Exception
    //   3	65	231	finally
    //   94	110	231	finally
    //   238	242	244	java/lang/Exception
    //   110	130	252	finally
    //   134	163	252	finally
    //   110	130	256	java/io/IOException
    //   134	163	256	java/io/IOException
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte;
    byte[] arrayOfByte2 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte;
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte2);
    arrayOfByte2 = new byte[arrayOfByte1.length + 4 + paramArrayOfByte.length];
    byte[] arrayOfByte3 = new byte[4];
    arrayOfByte3[0] = ((byte)(arrayOfByte1.length >> 24));
    arrayOfByte3[1] = ((byte)(arrayOfByte1.length >> 16));
    arrayOfByte3[2] = ((byte)(arrayOfByte1.length >> 8));
    arrayOfByte3[3] = ((byte)(arrayOfByte1.length >> 0));
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, arrayOfByte3.length, arrayOfByte1.length);
    int i1 = arrayOfByte3.length;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length + i1, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  public void b()
  {
    int i4 = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        i2 = localObject1.length;
        i1 = 0;
        while (i1 < i2)
        {
          Object localObject2 = localObject1[i1];
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          i1 += 1;
        }
      }
      while (this.jdField_a_of_type_JavaUtilList.contains("")) {
        this.jdField_a_of_type_JavaUtilList.remove("");
      }
      this.jdField_a_of_type_JavaUtilArrayList = MsfSdkUtils.getLoginedAccountList();
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (!((SimpleAccount)localObject1).isLogined())
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
          i2 = i1 - 1;
          i1 = i2 + 1;
        }
        else
        {
          int i3 = 0;
          for (;;)
          {
            i2 = i1;
            if (i3 >= this.jdField_a_of_type_JavaUtilList.size()) {
              break;
            }
            if (((String)this.jdField_a_of_type_JavaUtilList.get(i3)).equals(((SimpleAccount)localObject1).getUin())) {
              this.jdField_a_of_type_JavaUtilList.remove(i3);
            }
            i3 += 1;
          }
        }
      }
      i1 = i4;
      if (this.jdField_a_of_type_JavaUtilList != null) {
        i1 = 0 + this.jdField_a_of_type_JavaUtilList.size();
      }
      int i2 = i1;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        i2 = i1 + this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if ((i2 > 0) && (this.m == null)) {
        this.m = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_account", null);
      }
      return;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (TextUtils.isEmpty(paramString)) {
      a(String.format(super.getString(2131368094), new Object[] { Integer.valueOf(paramInt) }), new lar(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131368096);
    d(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString2);
    localIntent.putExtra("key_error_detail", paramString3);
    localIntent.putExtra("key_response", paramString1);
    super.setResult(-1, localIntent);
    super.finish();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (paramInt != 0)
    {
      paramString1 = new HashMap();
      paramString1.put("appid", jdField_A_of_type_JavaLangString);
      paramString1.put("errorcode", paramInt + "");
      paramString1.put("errormsg", paramString2);
      paramString1.put("errordetail", paramString3);
      paramString2 = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramString2 != null)
      {
        if (paramString2.getType() != 1) {
          break label195;
        }
        paramString1.put("network", "wifi");
      }
    }
    for (;;)
    {
      StatisticCollector.a(this).a(this.m, "connect_sso_authfail", false, 0L, 0L, paramString1, "");
      return;
      label195:
      if (paramString2.getType() == 0) {
        switch (paramString2.getSubtype())
        {
        case 7: 
        default: 
          paramString1.put("network", "2G");
          break;
        case 1: 
        case 2: 
        case 4: 
          paramString1.put("network", "2G");
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
          paramString1.put("network", "3G");
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_b_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString(paramString, this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(jdField_A_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    localEditor.putString(jdField_A_of_type_JavaLangString + ":" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
  
  public void b(String paramString1, String paramString2)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, paramString1, jdField_A_of_type_JavaLangString + "|" + paramString2 + "|" + this.G);
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte;
    return cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte);
  }
  
  protected void c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", jdField_A_of_type_JavaLangString);
    if (this.jdField_d_of_type_Boolean)
    {
      str = "notlogged";
      localHashMap.put("p1", str);
      if (!this.jdField_e_of_type_Boolean) {
        break label87;
      }
    }
    label87:
    for (String str = "auth";; str = "uauth")
    {
      localHashMap.put("p2", str);
      StatisticCollector.a(this).a(this.m, "connect_sso_backto3rd", false, 0L, 0L, localHashMap, "");
      return;
      str = "logged";
      break;
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ret", paramInt);
    localJSONObject.put("msg", paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = String.format(super.getString(2131368094), new Object[] { Integer.valueOf(paramInt) });; paramString = String.format(super.getString(2131368099), new Object[] { paramString, Integer.valueOf(paramInt) }))
    {
      a(paramString, new lac(this, paramInt, localJSONObject));
      return;
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (localObject != null)
    {
      paramString = AuthorityUtil.a(this, (Bitmap)localObject, 80, 80);
      ((Bitmap)localObject).recycle();
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a("", "", paramString, false);
      }
    }
    while ((paramString == null) || (paramString.equals(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.c))) {
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.c = paramString;
    Bundle localBundle = new Bundle();
    for (localObject = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString; ((String)localObject).length() < 10; localObject = "0" + (String)localObject) {}
    localObject = "o" + (String)localObject;
    localBundle.putString("Cookie", "uin=" + (String)localObject + "; skey=" + this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
    new HttpImageDownloadAsyncTask(paramString, MsfSdkUtils.insertMtype("yingyongbao", paramString), localBundle, "GET", this).execute(new Void[0]);
  }
  
  protected void d()
  {
    this.leftView.setText(2131368091);
    super.setTitle(2131368088);
    this.leftView.setOnClickListener(this);
    setRightButton(2131368086, this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298234));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.x = ((String)super.getText(2131368083));
    this.jdField_y_of_type_JavaLangString = ((String)super.getText(2131368089));
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131298233));
  }
  
  public void d(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", jdField_A_of_type_JavaLangString);
    localHashMap.put("errorcode", paramInt + "");
    localHashMap.put("errormsg", paramString);
    paramString = ((ConnectivityManager)super.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramString != null)
    {
      if (paramString.getType() != 1) {
        break label113;
      }
      localHashMap.put("network", "wifi");
    }
    for (;;)
    {
      StatisticCollector.a(this).a(this.m, "connect_sso_authfail", false, 0L, 0L, localHashMap, "");
      return;
      label113:
      if (paramString.getType() == 0) {
        switch (paramString.getSubtype())
        {
        case 7: 
        default: 
          localHashMap.put("network", "2G");
          break;
        case 1: 
        case 2: 
        case 4: 
          localHashMap.put("network", "2G");
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
          localHashMap.put("network", "3G");
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void e()
  {
    if (!a(null)) {
      g();
    }
  }
  
  protected void e(String paramString)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          ((ArrayList)localObject2).add(localObject1[i1]);
          i1 += 1;
        }
      }
      while (((ArrayList)localObject2).contains("")) {
        ((ArrayList)localObject2).remove("");
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        for (paramString = ""; ((Iterator)localObject1).hasNext(); paramString = paramString + "," + (String)localObject2) {
          localObject2 = (String)((Iterator)localObject1).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      localEditor.putString("accList", paramString);
      localEditor.commit();
      return;
    }
  }
  
  public void f()
  {
    this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      a(false);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin())
    {
      h();
      return;
    }
    String str = super.getAppRuntime().getAccount();
    if (this.jdField_B_of_type_JavaLangString != null) {
      str = this.jdField_B_of_type_JavaLangString;
    }
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(str, 16))
    {
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(str));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131368098));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, str));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorityActivity", 2, "-->login(), mProgress.show();", localException);
          }
        }
      }
    }
    h();
  }
  
  protected void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("firstlogin", true)) && (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount() == null))
    {
      a(true);
      ((SharedPreferences.Editor)localObject).putBoolean("firstlogin", false);
      ((SharedPreferences.Editor)localObject).commit();
      localObject = new HashMap();
      ((HashMap)localObject).put("appid", jdField_A_of_type_JavaLangString);
      ((HashMap)localObject).put("p1", "notlogged");
      ((HashMap)localObject).put("p2", "uauth");
      StatisticCollector.a(this).a(this.m, "connect_sso_pageview", false, System.currentTimeMillis() - this.jdField_b_of_type_Long, 0L, (HashMap)localObject, "");
      return;
    }
    b();
    f();
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131368095));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      if (this.m != null) {
        if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.m, 16))
        {
          d(this.m);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "-->login(), mProgress.show();", localException);
        }
      }
      QLog.d("AuthorityActivity", 1, "send | cmd: g_t_n_p | uin :*" + AuthorityUtil.a(this.m));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.m, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.m));
      return;
    }
    a(true);
    this.jdField_d_of_type_Boolean = true;
    b("wtl_notlogged", "0");
  }
  
  public void i()
  {
    this.jdField_g_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    SdkAuthorize.GetAuthApiListRequest localGetAuthApiListRequest = new SdkAuthorize.GetAuthApiListRequest();
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("client_id") + "";
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong((String)localObject);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label104:
      String str;
      break label104;
    }
    localGetAuthApiListRequest.client_id.set(l1);
    if (Build.VERSION.RELEASE == null)
    {
      localObject = "";
      localGetAuthApiListRequest.os.set((String)localObject);
      localGetAuthApiListRequest.qqv.set(CommonDataAdapter.a().c());
      str = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.pf.set((String)localObject);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("scope");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localGetAuthApiListRequest.scope.set((String)localObject);
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label390;
      }
      localGetAuthApiListRequest.sdkp.set("android");
      label248:
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label403;
      }
      localGetAuthApiListRequest.sdkv.set("1.5.9");
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localGetAuthApiListRequest.sign.set((String)localObject);
        localObject = this.jdField_a_of_type_AndroidOsBundle.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          l1 = Long.parseLong((String)localObject);
          localGetAuthApiListRequest.time.set(l1);
        }
      }
      localGetAuthApiListRequest.need_pay.set(1);
      if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
        localGetAuthApiListRequest.skey.set(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
      }
      a(localGetAuthApiListRequest);
      return;
      localObject = Build.VERSION.RELEASE;
      break;
      label390:
      localGetAuthApiListRequest.sdkp.set((String)localObject);
      break label248;
      label403:
      localGetAuthApiListRequest.sdkv.set((String)localObject);
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "doAuthorize");
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a();
    this.jdField_a_of_type_AndroidOsBundle.putString("openapi", "");
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("doAuthorize", true);
    this.jdField_a_of_type_AndroidOsBundle.putString("need_pay", "1");
    this.jdField_a_of_type_AndroidOsBundle.putString("appid_for_getting_config", this.jdField_a_of_type_AndroidOsBundle.getString("client_id") + "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131368095));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    long l1 = Long.parseLong(jdField_A_of_type_JavaLangString);
    Object localObject3 = new SdkAuthorize.AuthorizeRequest();
    ((SdkAuthorize.AuthorizeRequest)localObject3).client_id.set(l1);
    ((SdkAuthorize.AuthorizeRequest)localObject3).need_pay.set(1);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CardContainer.Permission)((Iterator)localObject1).next();
      if (((CardContainer.Permission)localObject2).a > 0) {
        ((SdkAuthorize.AuthorizeRequest)localObject3).openapi.add(Integer.valueOf(((CardContainer.Permission)localObject2).b));
      }
    }
    if (Build.VERSION.RELEASE == null)
    {
      localObject1 = "";
      ((SdkAuthorize.AuthorizeRequest)localObject3).os.set((String)localObject1);
      ((SdkAuthorize.AuthorizeRequest)localObject3).qqv.set(CommonDataAdapter.a().c());
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "openmobile_android";
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).pf.set((String)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkp");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label592;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set("android");
      label327:
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label604;
      }
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set("1.5.9");
      label356:
      ((SdkAuthorize.AuthorizeRequest)localObject3).response_type.set("token");
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("sign");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((SdkAuthorize.AuthorizeRequest)localObject3).sign.set((String)localObject1);
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("time");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l1 = Long.parseLong((String)localObject1);
          ((SdkAuthorize.AuthorizeRequest)localObject3).time.set(l1);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.keySet();
      ((Set)localObject1).remove("sdkp");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("sdkv");
      ((Set)localObject1).remove("sign");
      ((Set)localObject1).remove("time");
      localObject2 = new StringBuffer();
      localObject4 = ((Set)localObject1).iterator();
      label501:
      if (!((Iterator)localObject4).hasNext()) {
        break label622;
      }
      localObject5 = (String)((Iterator)localObject4).next();
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.get((String)localObject5);
      if (localObject1 == null) {
        break label616;
      }
    }
    label592:
    label604:
    label616:
    for (localObject1 = localObject1.toString();; localObject1 = "")
    {
      ((StringBuffer)localObject2).append((String)localObject5 + "=" + URLEncoder.encode((String)localObject1) + "&");
      break label501;
      localObject1 = Build.VERSION.RELEASE;
      break;
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkp.set((String)localObject1);
      break label327;
      ((SdkAuthorize.AuthorizeRequest)localObject3).sdkv.set((String)localObject1);
      break label356;
    }
    label622:
    if (((StringBuffer)localObject2).length() > 0)
    {
      ((StringBuffer)localObject2).delete(((StringBuffer)localObject2).length() - 1, ((StringBuffer)localObject2).length());
      ((SdkAuthorize.AuthorizeRequest)localObject3).passData.set(((StringBuffer)localObject2).toString());
    }
    ((SdkAuthorize.AuthorizeRequest)localObject3).skey.set(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_JavaLangString);
    this.jdField_y_of_type_Int = 1;
    Object localObject5 = new NewIntent(this, OpensdkServlet.class);
    ((NewIntent)localObject5).setWithouLogin(true);
    ((NewIntent)localObject5).putExtra("uin", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString);
    Object localObject4 = ((SdkAuthorize.AuthorizeRequest)localObject3).toByteArray();
    localObject3 = "ConnAuthSvr.sdk_auth_api";
    Object localObject2 = "s_a_a";
    localObject1 = localObject4;
    if (!this.i)
    {
      localObject1 = a((byte[])localObject4);
      localObject3 = "ConnAuthSvr.sdk_auth_api_emp";
      localObject2 = "s_a_a_emp";
    }
    ((NewIntent)localObject5).putExtra("data", (byte[])localObject1);
    ((NewIntent)localObject5).putExtra("cmd", (String)localObject3);
    ((NewIntent)localObject5).setObserver(new lak(this));
    super.getAppRuntime().startServlet((NewIntent)localObject5);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    QLog.d("AuthorityActivity", 1, "send | cmd: " + (String)localObject2 + " | uin : *" + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AuthorSwitch_AGENT:" + SystemClock.elapsedRealtime());
    }
  }
  
  public void k()
  {
    this.h = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "--onActivityResult, requestCode: " + paramInt1 + " | resultCode:" + paramInt2 + " | data: " + paramIntent);
    }
    if (paramInt1 == 100) {
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          this.jdField_B_of_type_JavaLangString = paramIntent.getStringExtra("uin");
        }
        e();
      }
    }
    do
    {
      do
      {
        return;
        super.setResult(0);
        super.finish();
        c();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        if (paramInt2 == 0)
        {
          if (TextUtils.isEmpty(this.m))
          {
            super.setResult(0, paramIntent);
            super.finish();
            c();
          }
          this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
          LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_f_of_type_Long - this.jdField_e_of_type_Long));
          return;
        }
      } while (-1 != paramInt2);
      this.jdField_f_of_type_Long = SystemClock.elapsedRealtime();
      LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.jdField_f_of_type_Long - this.jdField_e_of_type_Long));
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      this.jdField_b_of_type_Boolean = a(paramIntent);
    } while (!jdField_a_of_type_Boolean);
    this.m = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null)
    {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.m, (WloginSimpleInfo)localObject);
      new String(((WloginSimpleInfo)localObject)._nick);
      this.m = Long.toString(((WloginSimpleInfo)localObject)._uin);
    }
    for (;;)
    {
      a(this.m);
      if (bool) {
        e(this.m);
      }
      localObject = paramIntent.getBundleExtra("ssobundle");
      if (localObject != null)
      {
        paramIntent = ((Bundle)localObject).getByteArray("st_temp");
        localObject = ((Bundle)localObject).getByteArray("st_temp_key");
        if ((paramIntent != null) && (localObject != null))
        {
          this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_ArrayOfByte = paramIntent;
          this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_b_of_type_ArrayOfByte = ((byte[])localObject);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      i();
      return;
      paramIntent.getStringExtra("nick");
    }
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null)) {}
    super.setResult(0);
    super.finish();
    c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.leftView)
    {
      super.setResult(0);
      super.finish();
      c();
    }
    do
    {
      return;
      if (paramView == this.rightViewText)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        if (this.h)
        {
          this.h = false;
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.x);
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("appid", jdField_A_of_type_JavaLangString);
        localHashMap.put("p1", "logged");
        localHashMap.put("p2", "uauth");
        paramView = "0";
        if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo != null) {
          paramView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.jdField_a_of_type_JavaLangString + "";
        }
        StatisticCollector.a(this).a(paramView, "connect_sso_change", false, 0L, 0L, localHashMap, "");
        ReportController.b(null, "CliOper", "", "", "0X80060D8", "0X80060D8", 0, 0, "", "", this.m, "");
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "0X80060D8: account = " + this.m);
        }
        a(false);
        this.k = true;
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "<user:>authorize btn is clicked.");
    }
    long l1 = System.currentTimeMillis();
    try
    {
      if (l1 - this.jdField_d_of_type_Long < 500L) {
        return;
      }
    }
    finally {}
    this.jdField_d_of_type_Long = l1;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if ((this.j) || (this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo == null))
    {
      f();
      return;
    }
    if (this.jdField_y_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131368098));
      if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      i();
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetButton.getText().equals(super.getString(2131368096)))
    {
      f();
      return;
    }
    if (this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "ClickAuthButton: " + SystemClock.elapsedRealtime());
      }
      paramView = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      paramView.what = 1;
      paramView.obj = this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramView);
      this.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
    }
    for (;;)
    {
      ReportCenter.a().a(this.m, "", jdField_A_of_type_JavaLangString, "1", "2", "0", false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "ClickAuthButton -- doAuthorize(): " + SystemClock.elapsedRealtime());
      }
      j();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onCreate--");
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.setContentView(2130903435);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    jdField_A_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("client_id");
    d();
    this.z = this.jdField_a_of_type_AndroidOsBundle.getString("oauth_app_name");
    this.G = this.jdField_a_of_type_AndroidOsBundle.getString("sdkv");
    this.jdField_b_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(this, "uin_openid_store");
    this.jdField_c_of_type_AndroidContentSharedPreferences = OpensdkPreference.a(this, "openid_encrytoken");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      if (this.z != null) {
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.z, null);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", 0);
      String str = super.getIntent().getStringExtra("key_action");
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      if (!"action_login".equals(str)) {
        break label305;
      }
      jdField_a_of_type_Boolean = true;
      str = super.getAppRuntime().getAccount();
      if ((GesturePWDUtils.getJumpLock(this, str)) && (!GesturePWDUtils.getAppForground(this)))
      {
        this.jdField_B_of_type_JavaLangString = str;
        paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
        paramBundle.putExtra("key_gesture_from_authority", true);
        super.startActivityForResult(paramBundle, 100);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorityActivity", 2, "-->mProgress.show()", localException);
        }
      }
    }
    if (paramBundle == null) {
      e();
    }
    for (;;)
    {
      label305:
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(1);
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityActivity", 2, "0X80060D6: account = " + this.m);
      }
      ReportController.b(null, "CliOper", "", "", "0X80060D6", "0X80060D6", 0, 0, "", "", this.m, "");
      ReportCenter.a().a(this.m, "", jdField_A_of_type_JavaLangString, "1", "1", "0", false);
      return;
      b();
      if (!TextUtils.isEmpty(this.m)) {
        a("" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.m));
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->onDestroy--");
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_Long = 0L;
    this.i = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.k = false;
    if (QLog.isColorLevel())
    {
      QLog.d("AuthorityActivity", 2, "-->onResume--");
      QLog.d("SDKQQAgentPref", 2, "FirstLaunch_AGENT:" + SystemClock.elapsedRealtime());
    }
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity
 * JD-Core Version:    0.7.0.1
 */