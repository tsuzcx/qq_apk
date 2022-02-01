package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import jmp;
import jmq;
import jms;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileCardWebviewPlugin
  extends VasWebviewJsPlugin
{
  public static final byte a = 1;
  public static final String a = "ProfileCardWebviewPlugin";
  public static final byte b = 1;
  public static final String b = "callback";
  public static final byte c = 2;
  public static final String c = "result";
  public static final String d = "message";
  public static final String e = "image_url";
  public static final String f = "data";
  public static final String g = "currentId";
  public static final String h = "styleId";
  public static final String i = "bgId";
  public static final String j = "op_name";
  public static final String k = "ext1";
  public static final String l = "ext2";
  public static final String m = "ext3";
  public static final String n = "vip_info";
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jmp(this);
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  public List a;
  public AtomicInteger a;
  private boolean jdField_a_of_type_Boolean = false;
  private final int b;
  public AtomicInteger b;
  private final int c = 1;
  
  public ProfileCardWebviewPlugin()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_Int = 0;
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return -1;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 0)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        return 0;
      }
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 0))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
      return -2;
    }
    int i1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + 1;
    while (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i1);
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).g == VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger) {
        return 0;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.closeWeb");
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify2", null);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      d();
      c();
      return;
    }
    e();
    c();
  }
  
  private void b()
  {
    c();
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this.mRuntime.a());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(this.mRuntime.a().getResources().getString(2131368538));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(this.mRuntime.a().getResources().getString(2131368536));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(this.mRuntime.a().getResources().getString(2131365736));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new jms(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setCanceledOnTouchOutside(true);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void b(String paramString1, String paramString2)
  {
    ThreadManager.a(new jmq(this, paramString1));
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 92	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   11: invokevirtual 212	com/tencent/widget/ActionSheet:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 92	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   21: invokevirtual 215	com/tencent/widget/ActionSheet:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 92	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 92	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 92	com/tencent/mobileqq/profile/ProfileCardWebviewPlugin:jdField_a_of_type_ComTencentWidgetActionSheet	Lcom/tencent/widget/ActionSheet;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ProfileCardWebviewPlugin
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this.mRuntime.a(), VipProfileCardPhotoHandlerActivity.class);
    localIntent.putExtra("action", "select_photo");
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this.mRuntime.a(), VipProfileCardPhotoHandlerActivity.class);
    localIntent.putExtra("action", "take_photo");
    this.mRuntime.a().startActivity(localIntent);
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
    for (;;)
    {
      return;
      try
      {
        if (a() == 0)
        {
          b(((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangString, ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_b_of_type_JavaLangString);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardWebviewPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("card"))) {
      return false;
    }
    JSONObject localJSONObject;
    Object localObject;
    long l1;
    try
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      if (paramString1 == null) {
        return false;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCardWebviewPlugin", 2, "Failed to parse json str,json=" + null);
        }
        paramString1 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCardWebviewPlugin", 2, "method:" + paramString3 + ", json:" + paramString1.toString());
      }
      paramJsBridgeListener = "callback";
      localJSONObject = new JSONObject();
      paramVarArgs = new JSONObject();
      localObject = this.mRuntime.a().getApplicationContext();
      try
      {
        paramString2 = paramString1.getString("callback");
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("getInfo"))
        {
          paramJsBridgeListener = paramString2;
          sendRemoteReq(DataFactory.makeIPCRequestPacket("card_getinfo", paramString2, this.mOnRemoteResp.key, new Bundle()), false, false);
        }
        else
        {
          paramJsBridgeListener = paramString2;
          if (paramString3.equals("setSummaryCard"))
          {
            paramJsBridgeListener = paramString2;
            paramString3 = DataFactory.makeIPCRequestPacket("card_setSummaryCard", paramString2, this.mOnRemoteResp.key, new Bundle());
            paramJsBridgeListener = paramString2;
            paramString3.putInt("styleId", paramString1.getInt("styleId"));
            paramJsBridgeListener = paramString2;
            paramString3.putInt("bgId", paramString1.getInt("bgId"));
            paramJsBridgeListener = paramString2;
            sendRemoteReq(paramString3, false, false);
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        try
        {
          paramVarArgs.put("result", -1);
          paramVarArgs.put("message", "ProfileCardWebviewPlugin Exception");
          a(paramJsBridgeListener, paramVarArgs.toString());
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("download"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = paramString1.getString("image_url");
          paramJsBridgeListener = paramString2;
          if (ProfileCardUtil.a((Context)localObject, paramString3))
          {
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", 0);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "local has");
            paramJsBridgeListener = paramString2;
            a(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          if (!NetworkUtil.e(this.mRuntime.a().getApplicationContext()))
          {
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -2);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "no network");
            paramJsBridgeListener = paramString2;
            a(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          l1 = ProfileCardUtil.b();
          if (l1 < 102400)
          {
            paramJsBridgeListener = paramString2;
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = paramString2;
              QLog.d("ProfileCardWebviewPlugin", 2, "Insufficient SDCard space, reserved:" + 102400 + "|available:" + l1);
            }
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("result", -3);
            paramJsBridgeListener = paramString2;
            paramVarArgs.put("message", "Insufficient SDCard space.");
            paramJsBridgeListener = paramString2;
            a(paramString2, paramVarArgs.toString());
            return true;
          }
          paramJsBridgeListener = paramString2;
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
          {
            paramJsBridgeListener = paramString2;
            if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g == VipProfileCardDownLoadInfo.d)
            {
              paramJsBridgeListener = paramString2;
              if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3))
              {
                paramJsBridgeListener = paramString2;
                if (paramString1.getLong("id") == ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_a_of_type_JavaLangLong.longValue())
                {
                  paramJsBridgeListener = paramString2;
                  ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).g = VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger;
                  paramJsBridgeListener = paramString2;
                  ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())).jdField_b_of_type_JavaLangString = paramString2;
                  return true;
                }
              }
            }
          }
          paramJsBridgeListener = paramString2;
          localObject = new VipProfileCardDownLoadInfo();
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramString1.getLong("id"));
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject).jdField_a_of_type_JavaLangString = paramString3;
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject).jdField_b_of_type_JavaLangString = paramString2;
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject).e = Integer.valueOf(0);
          paramJsBridgeListener = paramString2;
          ((VipProfileCardDownLoadInfo)localObject).g = VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger;
          paramJsBridgeListener = paramString2;
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          paramJsBridgeListener = paramString2;
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
            break label2535;
          }
          paramJsBridgeListener = paramString2;
          a();
          break label2535;
        }
        paramJsBridgeListener = paramString2;
        if (!paramString3.equals("queryDownloadInfo")) {
          break label1454;
        }
      }
      paramJsBridgeListener = paramString2;
      paramString3 = paramString1.getString("image_url");
      paramJsBridgeListener = paramString2;
      if (true != ProfileCardUtil.a((Context)localObject, paramString3)) {
        break label932;
      }
    }
    paramJsBridgeListener = paramString2;
    localJSONObject.put("status", 3);
    paramJsBridgeListener = paramString2;
    localJSONObject.put("progress", 100);
    paramJsBridgeListener = paramString2;
    paramVarArgs.put("result", 0);
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("data", localJSONObject);
      paramJsBridgeListener = paramString2;
      a(paramString2, paramVarArgs.toString());
      break label2535;
      label932:
      paramJsBridgeListener = paramString2;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0) {
        break;
      }
      paramJsBridgeListener = paramString2;
      localJSONObject.put("status", 1);
      paramJsBridgeListener = paramString2;
      localJSONObject.put("progress", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
    }
    paramJsBridgeListener = paramString2;
    int i1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    paramJsBridgeListener = paramString2;
    if (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramJsBridgeListener = paramString2;
      if (!((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3)) {
        break label2537;
      }
      paramJsBridgeListener = paramString2;
      if (paramString1.getLong("id") != ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaLangLong.longValue()) {
        break label2537;
      }
      paramJsBridgeListener = paramString2;
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).g == VipProfileCardDownLoadInfo.d) {
        break label2537;
      }
      paramJsBridgeListener = paramString2;
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = paramString2;
        QLog.i("ProfileCardWebviewPlugin", 2, "mIndex:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",id:" + ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaLangLong + "status:" + ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).g);
      }
      paramJsBridgeListener = paramString2;
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).g != VipProfileCardDownLoadInfo.jdField_a_of_type_JavaLangInteger)
      {
        paramJsBridgeListener = paramString2;
        if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).g != VipProfileCardDownLoadInfo.jdField_b_of_type_JavaLangInteger) {
          break label1359;
        }
      }
      paramJsBridgeListener = paramString2;
      localJSONObject.put("status", 2);
      paramJsBridgeListener = paramString2;
      localJSONObject.put("progress", ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).e);
    }
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).f);
      paramJsBridgeListener = paramString2;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      paramJsBridgeListener = paramString2;
      localJSONObject.put("status", 1);
      paramJsBridgeListener = paramString2;
      localJSONObject.put("progress", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
      break;
      label1359:
      paramJsBridgeListener = paramString2;
      if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).g == VipProfileCardDownLoadInfo.c)
      {
        paramJsBridgeListener = paramString2;
        localJSONObject.put("status", 1);
        paramJsBridgeListener = paramString2;
        localJSONObject.put("progress", ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).e);
      }
      else
      {
        paramJsBridgeListener = paramString2;
        localJSONObject.put("status", 1);
        paramJsBridgeListener = paramString2;
        localJSONObject.put("progress", 0);
      }
    }
    label1454:
    paramJsBridgeListener = paramString2;
    if (paramString3.equals("preview"))
    {
      paramJsBridgeListener = paramString2;
      paramString3 = new Intent(this.mRuntime.a(), VipProfileCardPreviewActivity.class);
      paramJsBridgeListener = paramString2;
      paramString3.putExtra("preview", paramString1.toString());
      paramJsBridgeListener = paramString2;
      super.startActivityForResult(paramString3, (byte)1);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("result", 0);
      paramJsBridgeListener = paramString2;
      paramVarArgs.put("message", "ok");
      paramJsBridgeListener = paramString2;
      a(paramString2, paramVarArgs.toString());
    }
    else
    {
      paramJsBridgeListener = paramString2;
      if (paramString3.equals("getTime"))
      {
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("data", NetConnInfoCenter.getServerTimeMillis());
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("result", 0);
        paramJsBridgeListener = paramString2;
        paramVarArgs.put("message", "");
        paramJsBridgeListener = paramString2;
        a(paramString2, paramVarArgs.toString());
      }
      else
      {
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("cancelDownload"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = paramString1.getString("image_url");
          paramJsBridgeListener = paramString2;
          l1 = paramString1.getLong("id");
          paramJsBridgeListener = paramString2;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == -1)
          {
            paramJsBridgeListener = paramString2;
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          }
          paramJsBridgeListener = paramString2;
          i1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        }
      }
    }
    for (;;)
    {
      paramJsBridgeListener = paramString2;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramJsBridgeListener = paramString2;
        if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaLangLong.longValue() == l1)
        {
          paramJsBridgeListener = paramString2;
          if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString3))
          {
            paramJsBridgeListener = paramString2;
            if (((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).g != VipProfileCardDownLoadInfo.d)
            {
              paramJsBridgeListener = paramString2;
              ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).g = VipProfileCardDownLoadInfo.d;
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("result", 0);
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("message", "ok");
            }
          }
        }
      }
      else
      {
        paramJsBridgeListener = paramString2;
        if (i1 == this.jdField_a_of_type_JavaUtilList.size())
        {
          paramJsBridgeListener = paramString2;
          paramVarArgs.put("result", -2);
          paramJsBridgeListener = paramString2;
          paramVarArgs.put("message", "cancel download fail， bgId:" + l1);
        }
        paramJsBridgeListener = paramString2;
        a(paramString2, paramVarArgs.toString());
        paramJsBridgeListener = paramString2;
        paramString1 = new JSONObject();
        paramJsBridgeListener = paramString2;
        try
        {
          paramString1.put("result", -1);
          paramJsBridgeListener = paramString2;
          paramString1.put("message", "cancel download bgUrl:" + ((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_a_of_type_JavaLangString);
          paramJsBridgeListener = paramString2;
          a(((VipProfileCardDownLoadInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).jdField_b_of_type_JavaLangString, paramString1.toString());
        }
        catch (JSONException paramString1)
        {
          paramJsBridgeListener = paramString2;
          paramString1.printStackTrace();
        }
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("report"))
        {
          paramJsBridgeListener = paramString2;
          paramString3 = DataFactory.makeIPCRequestPacket("card_getVipInfo", paramString2, this.mOnRemoteResp.key, new Bundle());
          paramJsBridgeListener = paramString2;
          paramString3.putString("op_name", paramString1.getString("op_name"));
          paramJsBridgeListener = paramString2;
          paramString3.putString("ext1", paramString1.getString("ext1"));
          paramJsBridgeListener = paramString2;
          paramString3.putString("ext2", paramString1.getString("ext2"));
          paramJsBridgeListener = paramString2;
          paramString3.putString("ext3", paramString1.getString("ext3"));
          paramJsBridgeListener = paramString2;
          sendRemoteReq(paramString3, false, false);
        }
        else
        {
          paramJsBridgeListener = paramString2;
          if (paramString3.equals("openView"))
          {
            paramJsBridgeListener = paramString2;
            paramString1 = paramString1.getString("ADTAG");
            paramJsBridgeListener = paramString2;
            paramString3 = this.mRuntime.a();
            if (paramString3 != null)
            {
              paramJsBridgeListener = paramString2;
              localObject = new Intent(paramString3, QQBrowserActivity.class);
              paramJsBridgeListener = paramString2;
              ((Intent)localObject).putExtra("uin", this.mRuntime.a().getAccount());
              paramJsBridgeListener = paramString2;
              ((Intent)localObject).putExtra("isShowAd", false);
              paramJsBridgeListener = paramString2;
              ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
              paramJsBridgeListener = paramString2;
              ((Intent)localObject).putExtra("url", String.format("https://imgcache.qq.com/club/client/card/rel/mall_v54.html?_bid=238&closeSpecialLogic=1&ADTAG=%1$s&sid=%2$s&isCache=%3$s&entryId=%4$s&tabId=%5$s&_wv=5123", new Object[] { paramString1, this.mRuntime.a().getSid(), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) }));
              paramJsBridgeListener = paramString2;
              paramString3.startActivity((Intent)localObject);
            }
          }
          else
          {
            paramJsBridgeListener = paramString2;
            if (paramString3.equals("clickPhotoWall"))
            {
              paramJsBridgeListener = paramString2;
              i1 = WebViewPluginEngine.a(this);
              paramJsBridgeListener = paramString2;
              paramString1 = this.mRuntime.a();
              paramJsBridgeListener = paramString2;
              if ((paramString1 instanceof QQBrowserActivity))
              {
                paramJsBridgeListener = paramString2;
                paramString1 = ((QQBrowserActivity)paramString1).M;
                paramJsBridgeListener = paramString2;
                if (TextUtils.isEmpty(paramString1)) {
                  break label2465;
                }
                paramJsBridgeListener = paramString2;
                if (!paramString1.contains("entryId")) {
                  break label2465;
                }
                paramJsBridgeListener = paramString2;
              }
              for (this.jdField_a_of_type_Int = URLUtil.a(URLUtil.a(paramString1), "entryId", 2);; this.jdField_a_of_type_Int = 2)
              {
                paramJsBridgeListener = paramString2;
                paramString1 = this.mRuntime.a().getAccount();
                paramJsBridgeListener = paramString2;
                paramString3 = new Intent();
                paramJsBridgeListener = paramString2;
                QzonePluginProxyActivity.a(paramString3, "com.qzone.cover.ui.activity.QzoneCoverPhotoWallActivity");
                paramJsBridgeListener = paramString2;
                paramString3.putExtra("cover_uin", Long.parseLong(paramString1));
                paramJsBridgeListener = paramString2;
                paramString3.putExtra("set_source", 1);
                paramJsBridgeListener = paramString2;
                QzonePluginProxyActivity.a(this.mRuntime.a(), paramString1, paramString3, i1 * 1000 + 10000 + 2);
                break;
                label2465:
                paramJsBridgeListener = paramString2;
              }
            }
            paramJsBridgeListener = paramString2;
            if (paramString3.equals("uploadBackground"))
            {
              paramJsBridgeListener = paramString2;
              b();
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("result", 0);
              paramJsBridgeListener = paramString2;
              paramVarArgs.put("message", "ok");
              paramJsBridgeListener = paramString2;
              a(paramString2, paramVarArgs.toString());
            }
            else
            {
              return false;
            }
          }
        }
        label2535:
        return true;
        label2537:
        i1 += 1;
        break;
      }
      i1 += 1;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardWebviewPlugin", 2, "ProfileCardWebviewPlugin onActivityResult,requestCode = " + paramByte + ", resultCode = " + paramInt + ", data = " + paramIntent);
    }
    if (paramInt != -1) {}
    while (paramIntent == null) {
      return;
    }
    if ((paramByte == 1) || (paramByte == 2)) {}
    try
    {
      if (this.jdField_a_of_type_Int != 0)
      {
        Object localObject2 = paramIntent.getStringExtra("uin");
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.mRuntime.a().a();
        }
        localObject2 = new Intent(this.mRuntime.a(), FriendProfileCardActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", new ProfileActivity.AllInOne((String)localObject1, 0));
        this.mRuntime.a().startActivity((Intent)localObject2);
      }
      paramIntent.putExtra("closeSpecialLogic", true);
      this.mRuntime.a().setResult(-1, paramIntent);
      this.mRuntime.a().finish();
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.onDestroy();
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ProfileCardWebviewPlugin", 2, "unregister receiver exception:" + localException.toString());
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {
      for (;;)
      {
        JSONObject localJSONObject1;
        String str2;
        String str1;
        Bundle localBundle;
        try
        {
          if (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            break;
          }
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject1 = new JSONObject();
          str2 = paramBundle.getString("cmd");
          str1 = paramBundle.getString("callbackid");
          localBundle = paramBundle.getBundle("response");
          if (str2 == null) {
            break;
          }
          if ("card_getinfo".equals(str2))
          {
            long l1 = localBundle.getLong("currentId");
            long l2 = localBundle.getLong("styleId");
            int i2 = localBundle.getInt("result");
            i1 = 0;
            if ((l2 == ProfileCardTemplate.e) || (l2 == ProfileCardTemplate.a) || (l2 == ProfileCardTemplate.g)) {
              break label387;
            }
            localJSONObject2.put("currentId", l1);
            localJSONObject2.put("styleId", l2);
            localJSONObject2.put("isPhotoWall", i1);
            localJSONObject1.put("data", localJSONObject2);
            localJSONObject1.put("result", i2);
            a(str1, localJSONObject1.toString());
            return;
          }
          if ("card_setSummaryCard".equals(str2))
          {
            i1 = localBundle.getInt("result");
            paramBundle = localBundle.getString("message");
            localJSONObject1.put("result", i1);
            localJSONObject1.put("message", paramBundle);
            a(str1, localJSONObject1.toString());
            return;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        if ("card_getVipInfo".equals(str2))
        {
          ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", paramBundle.getString("op_name"), paramBundle.getString("op_name"), 0, 0, paramBundle.getString("ext1"), paramBundle.getString("ext2"), paramBundle.getString("ext3"), localBundle.getString("vip_info"));
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", "ok");
          a(str1, localJSONObject1.toString());
          return;
        }
        if ("selectPhoto".equals(str2)) {
          break;
        }
        boolean bool = "takePhoto".equals(str2);
        if (!bool) {
          break;
        }
        return;
        label387:
        int i1 = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */