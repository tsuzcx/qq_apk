package com.pay.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.ArrayList;
import java.util.Arrays;
import midas.x.p4;

public class APPermissionActivity
  extends APActivity
{
  public ResultReceiver d;
  public ArrayList<String> e = new ArrayList();
  public ArrayList<String> f = new ArrayList();
  public ArrayList<String> g = new ArrayList();
  public ArrayList<String> h = new ArrayList();
  public ArrayList<String> i = new ArrayList();
  public Activity j;
  
  public static void a(Context paramContext, String[] paramArrayOfString, ResultReceiver paramResultReceiver)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = new ArrayList();
    int m = paramArrayOfString.length;
    int k = 0;
    while (k < m)
    {
      String str = paramArrayOfString[k];
      if (c(paramContext, str)) {
        localArrayList1.add(str);
      } else {
        localArrayList2.add(str);
      }
      k += 1;
    }
    paramContext = new StringBuilder();
    paramContext.append("notifyDirectResponse() mResultReceiver=");
    paramContext.append(paramResultReceiver);
    paramContext.append(", mGrantedList=");
    paramContext.append(localArrayList1.toString());
    paramContext.append(", mRationaleList=");
    paramContext.append(((ArrayList)localObject).toString());
    paramContext.append(", mRejectedList=");
    paramContext.append(localArrayList2.toString());
    APLog.d("APPermissionActivity", paramContext.toString());
    if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0))
    {
      paramContext = new Bundle();
      paramContext.putStringArrayList("receiver_key_grant", localArrayList1);
      paramContext.putStringArrayList("receiver_key_reject", localArrayList2);
      paramContext.putStringArrayList("receiver_key_rationale", (ArrayList)localObject);
      paramArrayOfString = APDataReportManager.getInstance();
      k = p4.p().g();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("grantedList=");
      ((StringBuilder)localObject).append(localArrayList1.toString());
      ((StringBuilder)localObject).append("&rejectedList=");
      ((StringBuilder)localObject).append(localArrayList2.toString());
      paramArrayOfString.insertData("sdk.permission.response.direct", k, "", "", ((StringBuilder)localObject).toString());
      paramResultReceiver.send(0, paramContext);
    }
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, ResultReceiver paramResultReceiver)
  {
    Object localObject1 = APDataReportManager.getInstance();
    int k = p4.p().g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("permissions=");
    ((StringBuilder)localObject2).append(paramArrayOfString1.toString());
    ((APDataReportManager)localObject1).insertData("sdk.permission.request", k, "", "", ((StringBuilder)localObject2).toString());
    localObject1 = new ArrayList();
    int m = paramArrayOfString1.length;
    k = 0;
    while (k < m)
    {
      localObject2 = paramArrayOfString1[k];
      if (a(paramContext, (String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
      k += 1;
    }
    if (((ArrayList)localObject1).size() <= 0)
    {
      APLog.i("APPermissionActivity", "request() canRequestList.size=0: Low SDK_INT<6.0 or No Manifest Permission");
      a(paramContext, paramArrayOfString1, paramResultReceiver);
      return;
    }
    localObject2 = new Intent(paramContext, APPermissionActivity.class);
    ((Intent)localObject2).putExtra("permissions", paramArrayOfString1);
    if (paramArrayOfString2 != null)
    {
      localObject1 = paramArrayOfString2;
      if (paramArrayOfString2.length >= paramArrayOfString1.length) {}
    }
    else
    {
      localObject1 = new String[paramArrayOfString1.length];
    }
    ((Intent)localObject2).putExtra("descriptions", (String[])localObject1);
    ((Intent)localObject2).putExtra("resultreceiver", paramResultReceiver);
    paramContext.startActivity((Intent)localObject2);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    if (!b(paramContext, paramString)) {
      return false;
    }
    return paramContext.checkSelfPermission(paramString) != 0;
  }
  
  public static void b(Context paramContext, String[] paramArrayOfString, ResultReceiver paramResultReceiver)
  {
    a(paramContext, paramArrayOfString, new String[paramArrayOfString.length], paramResultReceiver);
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    int k = 0;
    boolean bool1;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getApplicationContext().getPackageName(), 4096).requestedPermissions;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        try
        {
          if (k >= paramContext.length) {
            break label76;
          }
          bool2 = paramContext[k].equals(paramString);
          if (bool2) {
            bool1 = true;
          }
          k += 1;
        }
        catch (Exception paramContext) {}
      }
      APLog.w("permission compare error", paramContext.toString());
    }
    catch (Exception paramContext)
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    label76:
    return bool2;
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return b(paramContext, paramString);
    }
    return paramContext.checkSelfPermission(paramString) == 0;
  }
  
  public final void a(ArrayList<Pair<String, String>> paramArrayList)
  {
    g();
  }
  
  public final void f()
  {
    ArrayList localArrayList = this.e;
    if (localArrayList == null) {
      this.e = new ArrayList();
    } else {
      localArrayList.clear();
    }
    localArrayList = this.f;
    if (localArrayList == null) {
      this.f = new ArrayList();
    } else {
      localArrayList.clear();
    }
    localArrayList = this.g;
    if (localArrayList == null) {
      this.g = new ArrayList();
    } else {
      localArrayList.clear();
    }
    localArrayList = this.i;
    if (localArrayList == null) {
      this.i = new ArrayList();
    } else {
      localArrayList.clear();
    }
    localArrayList = this.h;
    if (localArrayList == null)
    {
      this.h = new ArrayList();
      return;
    }
    localArrayList.clear();
  }
  
  public final void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyIndirectResponse() mResultReceiver=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", mGrantedList=");
    ((StringBuilder)localObject).append(this.g.toString());
    ((StringBuilder)localObject).append(", mRationaleList=");
    ((StringBuilder)localObject).append(this.i.toString());
    ((StringBuilder)localObject).append(", mRejectedList=");
    ((StringBuilder)localObject).append(this.h.toString());
    APLog.d("APPermissionActivity", ((StringBuilder)localObject).toString());
    if ((this.d != null) && ((this.g.size() > 0) || (this.i.size() > 0) || (this.h.size() > 0)))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("receiver_key_grant", this.g);
      ((Bundle)localObject).putStringArrayList("receiver_key_reject", this.h);
      ((Bundle)localObject).putStringArrayList("receiver_key_rationale", this.i);
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      int k = p4.p().g();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mGrantedList=");
      localStringBuilder.append(this.g.toString());
      localStringBuilder.append("&mRationaleList=");
      localStringBuilder.append(this.i.toString());
      localStringBuilder.append("&mRejectedList=");
      localStringBuilder.append(this.h.toString());
      localAPDataReportManager.insertData("sdk.permission.response.indirect", k, "", "", localStringBuilder.toString());
      this.d.send(0, (Bundle)localObject);
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = APDataReportManager.getInstance();
    int k = p4.p().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savedInstanceState=");
    localStringBuilder.append(paramBundle);
    ((APDataReportManager)localObject).insertData("sdk.permission.create", k, "", "", localStringBuilder.toString());
    localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).alpha = 0.0F;
    getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    localObject = this.mProxyActivity;
    if (localObject == null) {
      this.j = this;
    } else {
      this.j = ((Activity)localObject);
    }
    if (paramBundle == null)
    {
      f();
      if (!getIntent().hasExtra("permissions"))
      {
        g();
        return;
      }
      paramBundle = getIntent().getStringArrayExtra("permissions");
      this.e.addAll(Arrays.asList(paramBundle));
      localObject = getIntent().getStringArrayExtra("descriptions");
      this.f.addAll(Arrays.asList((Object[])localObject));
      this.d = ((ResultReceiver)getIntent().getParcelableExtra("resultreceiver"));
      boolean bool = this.mIsRunInPlugin;
      int n = 0;
      int m = 0;
      int i1 = 1;
      k = i1;
      if (bool) {
        try
        {
          Class.forName("com.tencent.midas.api.APBuildFeature").getDeclaredField("FEATURE_PERMISSION");
          k = i1;
        }
        catch (Exception localException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCreate() e=");
          localStringBuilder.append(localException.toString());
          APLog.w("APPermissionActivity", localStringBuilder.toString());
          k = 0;
        }
      }
      String str;
      if (k == 0)
      {
        APLog.d("APPermissionActivity", "onCreate() isPluginSupportPermission false");
        n = paramBundle.length;
        k = m;
        while (k < n)
        {
          str = paramBundle[k];
          if (c(this, str)) {
            this.g.add(str);
          } else {
            this.h.add(str);
          }
          k += 1;
        }
        g();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.j.requestPermissions(paramBundle, 1000);
        return;
      }
      m = paramBundle.length;
      k = n;
      while (k < m)
      {
        str = paramBundle[k];
        if (c(this, str)) {
          this.g.add(str);
        } else {
          this.h.add(str);
        }
        k += 1;
      }
      g();
    }
  }
  
  public void onDestroy()
  {
    APLog.i("APPermissionActivity", "onDestroy()");
    super.onDestroy();
  }
  
  public void onPause()
  {
    APLog.i("APPermissionActivity", "onPause()");
    super.onPause();
  }
  
  @TargetApi(23)
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 1000) {
      return;
    }
    Object localObject = APDataReportManager.getInstance();
    paramInt = p4.p().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("permissions=");
    localStringBuilder.append(paramArrayOfString.toString());
    localStringBuilder.append("&grantResults=");
    localStringBuilder.append(paramArrayOfInt.toString());
    ((APDataReportManager)localObject).insertData("sdk.permission.result", paramInt, "", "", localStringBuilder.toString());
    localObject = new boolean[paramArrayOfString.length];
    int k = 0;
    paramInt = 0;
    while (paramInt < paramArrayOfString.length)
    {
      localObject[paramInt] = this.j.shouldShowRequestPermissionRationale(paramArrayOfString[paramInt]);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < paramArrayOfString.length)
    {
      if (paramArrayOfInt[paramInt] != 0)
      {
        if (localObject[paramInt] != 0) {
          this.i.add(paramArrayOfString[paramInt]);
        } else {
          this.h.add(paramArrayOfString[paramInt]);
        }
      }
      else {
        this.g.add(paramArrayOfString[paramInt]);
      }
      paramInt += 1;
    }
    paramArrayOfString = new ArrayList();
    paramInt = k;
    while (paramInt < this.e.size())
    {
      paramArrayOfInt = (String)this.e.get(paramInt);
      localObject = (String)this.f.get(paramInt);
      if ((this.h.contains(paramArrayOfInt)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        paramArrayOfString.add(new Pair(paramArrayOfInt, localObject));
      }
      paramInt += 1;
    }
    if (paramArrayOfString.size() > 0)
    {
      a(paramArrayOfString);
      return;
    }
    g();
  }
  
  public void onRestart()
  {
    APLog.i("APPermissionActivity", "onRestart()");
    super.onRestart();
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRestoreInstanceState() savedInstanceState=");
    localStringBuilder.append(paramBundle);
    APLog.i("APPermissionActivity", localStringBuilder.toString());
    super.onRestoreInstanceState(paramBundle);
    this.e = paramBundle.getStringArrayList("mRequestList");
    this.f = paramBundle.getStringArrayList("mDescriptionList");
    this.g = paramBundle.getStringArrayList("mGrantedList");
    this.h = paramBundle.getStringArrayList("mRejectedList");
    this.i = paramBundle.getStringArrayList("mRationaleList");
    this.d = ((ResultReceiver)paramBundle.getParcelable("mResultReceiver"));
  }
  
  public void onResume()
  {
    APLog.i("APPermissionActivity", "onResume()");
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveInstanceState() outState=");
    localStringBuilder.append(paramBundle);
    APLog.i("APPermissionActivity", localStringBuilder.toString());
    paramBundle.putStringArrayList("mRequestList", this.e);
    paramBundle.putStringArrayList("mDescriptionList", this.f);
    paramBundle.putStringArrayList("mGrantedList", this.g);
    paramBundle.putStringArrayList("mRejectedList", this.h);
    paramBundle.putStringArrayList("mRationaleList", this.i);
    paramBundle.putParcelable("mResultReceiver", this.d);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    APLog.i("APPermissionActivity", "onStart()");
    super.onStart();
  }
  
  public void onStop()
  {
    APLog.i("APPermissionActivity", "onStop()");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.permission.APPermissionActivity
 * JD-Core Version:    0.7.0.1
 */