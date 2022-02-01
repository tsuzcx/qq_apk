package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.SparseArray;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cpr;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class HbEventPlugin
  extends WebViewPlugin
{
  private static int jdField_a_of_type_Int = 1;
  public static final String a = "PortalManager.HbEventPlugin";
  public static final String b = "redEnvelope";
  public static final String c = "switcher";
  public static final String d = "openSwitcher";
  public static final String e = "querySwitcher";
  public static final String f = "share";
  public static final String g = "queryState";
  public static final String h = "getConfig";
  public static final String i = "requestPack";
  public static final String j = "queryPackList";
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = null;
  
  private static int a()
  {
    int k = jdField_a_of_type_Int;
    jdField_a_of_type_Int = k + 1;
    return k;
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("portal_type_key", paramInt1);
    paramString1.putExtra("portal_agrs", paramString2);
    if (a(paramInt2, paramInt1)) {
      paramString1.putExtra("bc_seq", paramInt2);
    }
    this.mRuntime.a().sendBroadcast(paramString1, "com.tencent.msg.permission.pushnotify2");
  }
  
  int a(String paramString)
  {
    if ("queryState".endsWith(paramString)) {
      return 1004;
    }
    if ("requestPack".endsWith(paramString)) {
      return 1006;
    }
    if ("getConfig".endsWith(paramString)) {
      return 1005;
    }
    if ("queryPackList".endsWith(paramString)) {
      return 1007;
    }
    if ("openSwitcher".endsWith(paramString)) {
      return 1001;
    }
    if ("querySwitcher".endsWith(paramString)) {
      return 1002;
    }
    if ("switcher".endsWith(paramString)) {
      return 1000;
    }
    return -1;
  }
  
  cpr a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(12);
    }
    WeakReference localWeakReference = new WeakReference(new cpr(this, null));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localWeakReference);
    return (cpr)localWeakReference.get();
  }
  
  void a(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    paramString = new IntentFilter(paramString);
    this.mRuntime.a().registerReceiver(paramBroadcastReceiver, paramString, "com.tencent.msg.permission.pushnotify2", null);
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    callJs(paramString, paramVarArgs);
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return false;
    }
    Object localObject = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null) {
      return false;
    }
    localObject = (cpr)((WeakReference)localObject).get();
    if (localObject == null) {
      return false;
    }
    try
    {
      this.mRuntime.a().unregisterReceiver((BroadcastReceiver)localObject);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HbEventPlugin", 2, "checkSequence | " + paramInt2 + "sep = " + paramInt1);
      }
      return false;
    }
    return true;
  }
  
  cpr b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return null;
    }
    WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localWeakReference == null) {
      return null;
    }
    return (cpr)localWeakReference.get();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HbEventPlugin", 2, "handleJsRequest: " + paramString3 + "," + paramVarArgs);
    }
    boolean bool1 = bool2;
    int k;
    if ("redEnvelope".endsWith(paramString2)) {
      if ((!"queryState".endsWith(paramString3)) && (!"getConfig".endsWith(paramString3)) && (!"requestPack".endsWith(paramString3)) && (!"queryPackList".endsWith(paramString3)) && (!"switcher".endsWith(paramString3)) && (!"openSwitcher".endsWith(paramString3)))
      {
        bool1 = bool2;
        if (!"querySwitcher".endsWith(paramString3)) {}
      }
      else
      {
        k = a();
        paramJsBridgeListener = a(k);
        a(paramJsBridgeListener, "com.tencent.portal.resp.action");
        if (paramVarArgs == null) {}
      }
    }
    try
    {
      if (paramVarArgs.length > 0)
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener.a = paramString1.getString("callback");
        paramJsBridgeListener.b = paramString1.getJSONObject("params").toString();
      }
      a("com.tencent.portal.req.action", a(paramString3), k, paramJsBridgeListener.b);
      bool1 = true;
      return bool1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HbEventPlugin
 * JD-Core Version:    0.7.0.1
 */