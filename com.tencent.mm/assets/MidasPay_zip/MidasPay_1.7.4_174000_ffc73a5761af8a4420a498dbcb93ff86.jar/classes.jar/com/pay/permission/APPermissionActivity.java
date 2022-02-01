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
import java.util.ArrayList;
import java.util.Arrays;
import midas.x.em;

public class APPermissionActivity
  extends APActivity
{
  private ResultReceiver a;
  private ArrayList<String> b = new ArrayList();
  private ArrayList<String> c = new ArrayList();
  private ArrayList<String> d = new ArrayList();
  private ArrayList<String> e = new ArrayList();
  private ArrayList<String> q = new ArrayList();
  private Activity r;
  
  private void a()
  {
    if (this.b == null) {
      this.b = new ArrayList();
    } else {
      this.b.clear();
    }
    if (this.c == null) {
      this.c = new ArrayList();
    } else {
      this.c.clear();
    }
    if (this.d == null) {
      this.d = new ArrayList();
    } else {
      this.d.clear();
    }
    if (this.q == null) {
      this.q = new ArrayList();
    } else {
      this.q.clear();
    }
    if (this.e == null)
    {
      this.e = new ArrayList();
      return;
    }
    this.e.clear();
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString, ResultReceiver paramResultReceiver)
  {
    a(paramContext, paramArrayOfString, new String[paramArrayOfString.length], paramResultReceiver);
  }
  
  private static void a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, ResultReceiver paramResultReceiver)
  {
    Object localObject1 = APDataReportManager.getInstance();
    int i = em.b().g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("permissions=");
    ((StringBuilder)localObject2).append(paramArrayOfString1.toString());
    ((APDataReportManager)localObject1).insertData("sdk.permission.request", i, "", "", ((StringBuilder)localObject2).toString());
    localObject1 = new ArrayList();
    int j = paramArrayOfString1.length;
    i = 0;
    while (i < j)
    {
      localObject2 = paramArrayOfString1[i];
      if (c(paramContext, (String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
      i += 1;
    }
    if (((ArrayList)localObject1).size() <= 0)
    {
      APLog.i("APPermissionActivity", "request() canRequestList.size=0: Low SDK_INT<6.0 or No Manifest Permission");
      b(paramContext, paramArrayOfString1, paramResultReceiver);
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
  
  private void a(ArrayList<Pair<String, String>> paramArrayList)
  {
    b();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return b(paramContext, paramString);
    }
    return paramContext.checkSelfPermission(paramString) == 0;
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyIndirectResponse() mResultReceiver=");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", mGrantedList=");
    ((StringBuilder)localObject).append(this.d.toString());
    ((StringBuilder)localObject).append(", mRationaleList=");
    ((StringBuilder)localObject).append(this.q.toString());
    ((StringBuilder)localObject).append(", mRejectedList=");
    ((StringBuilder)localObject).append(this.e.toString());
    APLog.d("APPermissionActivity", ((StringBuilder)localObject).toString());
    if ((this.a != null) && ((this.d.size() > 0) || (this.q.size() > 0) || (this.e.size() > 0)))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("receiver_key_grant", this.d);
      ((Bundle)localObject).putStringArrayList("receiver_key_reject", this.e);
      ((Bundle)localObject).putStringArrayList("receiver_key_rationale", this.q);
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      int i = em.b().g();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mGrantedList=");
      localStringBuilder.append(this.d.toString());
      localStringBuilder.append("&mRationaleList=");
      localStringBuilder.append(this.q.toString());
      localStringBuilder.append("&mRejectedList=");
      localStringBuilder.append(this.e.toString());
      localAPDataReportManager.insertData("sdk.permission.response.indirect", i, "", "", localStringBuilder.toString());
      this.a.send(0, (Bundle)localObject);
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  private static void b(Context paramContext, String[] paramArrayOfString, ResultReceiver paramResultReceiver)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (a(paramContext, str)) {
        localArrayList1.add(str);
      } else {
        localArrayList2.add(str);
      }
      i += 1;
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
      i = em.b().g();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("grantedList=");
      ((StringBuilder)localObject).append(localArrayList1.toString());
      ((StringBuilder)localObject).append("&rejectedList=");
      ((StringBuilder)localObject).append(localArrayList2.toString());
      paramArrayOfString.insertData("sdk.permission.response.direct", i, "", "", ((StringBuilder)localObject).toString());
      paramResultReceiver.send(0, paramContext);
    }
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    int i = 0;
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
          if (i >= paramContext.length) {
            break label76;
          }
          bool2 = paramContext[i].equals(paramString);
          if (bool2) {
            bool1 = true;
          }
          i += 1;
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
  
  private static boolean c(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    if (!b(paramContext, paramString)) {
      return false;
    }
    return paramContext.checkSelfPermission(paramString) != 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = APDataReportManager.getInstance();
    int i = em.b().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savedInstanceState=");
    localStringBuilder.append(paramBundle);
    ((APDataReportManager)localObject).insertData("sdk.permission.create", i, "", "", localStringBuilder.toString());
    localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).alpha = 0.0F;
    getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    if (this.mProxyActivity == null) {
      this.r = this;
    } else {
      this.r = this.mProxyActivity;
    }
    if (paramBundle == null)
    {
      a();
      if (!getIntent().hasExtra("permissions"))
      {
        b();
        return;
      }
      paramBundle = getIntent().getStringArrayExtra("permissions");
      this.b.addAll(Arrays.asList(paramBundle));
      localObject = getIntent().getStringArrayExtra("descriptions");
      this.c.addAll(Arrays.asList((Object[])localObject));
      this.a = ((ResultReceiver)getIntent().getParcelableExtra("resultreceiver"));
      boolean bool = this.mIsRunInPlugin;
      int k = 0;
      int j = 0;
      int m = 1;
      i = m;
      if (bool) {
        try
        {
          Class.forName("com.tencent.midas.api.APBuildFeature").getDeclaredField("FEATURE_PERMISSION");
          i = m;
        }
        catch (Exception localException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCreate() e=");
          localStringBuilder.append(localException.toString());
          APLog.w("APPermissionActivity", localStringBuilder.toString());
          i = 0;
        }
      }
      String str;
      if (i == 0)
      {
        APLog.d("APPermissionActivity", "onCreate() isPluginSupportPermission false");
        k = paramBundle.length;
        i = j;
        while (i < k)
        {
          str = paramBundle[i];
          if (a(this, str)) {
            this.d.add(str);
          } else {
            this.e.add(str);
          }
          i += 1;
        }
        b();
        return;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.r.requestPermissions(paramBundle, 1000);
        return;
      }
      j = paramBundle.length;
      i = k;
      while (i < j)
      {
        str = paramBundle[i];
        if (a(this, str)) {
          this.d.add(str);
        } else {
          this.e.add(str);
        }
        i += 1;
      }
      b();
      return;
    }
  }
  
  public void onDestroy()
  {
    APLog.i("APPermissionActivity", "onDestroy()");
    super.onDestroy();
  }
  
  protected void onPause()
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
    paramInt = em.b().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("permissions=");
    localStringBuilder.append(paramArrayOfString.toString());
    localStringBuilder.append("&grantResults=");
    localStringBuilder.append(paramArrayOfInt.toString());
    ((APDataReportManager)localObject).insertData("sdk.permission.result", paramInt, "", "", localStringBuilder.toString());
    localObject = new boolean[paramArrayOfString.length];
    int i = 0;
    paramInt = 0;
    while (paramInt < paramArrayOfString.length)
    {
      localObject[paramInt] = this.r.shouldShowRequestPermissionRationale(paramArrayOfString[paramInt]);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < paramArrayOfString.length)
    {
      if (paramArrayOfInt[paramInt] != 0)
      {
        if (localObject[paramInt] != 0) {
          this.q.add(paramArrayOfString[paramInt]);
        } else {
          this.e.add(paramArrayOfString[paramInt]);
        }
      }
      else {
        this.d.add(paramArrayOfString[paramInt]);
      }
      paramInt += 1;
    }
    paramArrayOfString = new ArrayList();
    paramInt = i;
    while (paramInt < this.b.size())
    {
      paramArrayOfInt = (String)this.b.get(paramInt);
      localObject = (String)this.c.get(paramInt);
      if ((this.e.contains(paramArrayOfInt)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        paramArrayOfString.add(new Pair(paramArrayOfInt, localObject));
      }
      paramInt += 1;
    }
    if (paramArrayOfString.size() > 0)
    {
      a(paramArrayOfString);
      return;
    }
    b();
  }
  
  protected void onRestart()
  {
    APLog.i("APPermissionActivity", "onRestart()");
    super.onRestart();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRestoreInstanceState() savedInstanceState=");
    localStringBuilder.append(paramBundle);
    APLog.i("APPermissionActivity", localStringBuilder.toString());
    super.onRestoreInstanceState(paramBundle);
    this.b = paramBundle.getStringArrayList("mRequestList");
    this.c = paramBundle.getStringArrayList("mDescriptionList");
    this.d = paramBundle.getStringArrayList("mGrantedList");
    this.e = paramBundle.getStringArrayList("mRejectedList");
    this.q = paramBundle.getStringArrayList("mRationaleList");
    this.a = ((ResultReceiver)paramBundle.getParcelable("mResultReceiver"));
  }
  
  public void onResume()
  {
    APLog.i("APPermissionActivity", "onResume()");
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveInstanceState() outState=");
    localStringBuilder.append(paramBundle);
    APLog.i("APPermissionActivity", localStringBuilder.toString());
    paramBundle.putStringArrayList("mRequestList", this.b);
    paramBundle.putStringArrayList("mDescriptionList", this.c);
    paramBundle.putStringArrayList("mGrantedList", this.d);
    paramBundle.putStringArrayList("mRejectedList", this.e);
    paramBundle.putStringArrayList("mRationaleList", this.q);
    paramBundle.putParcelable("mResultReceiver", this.a);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.permission.APPermissionActivity
 * JD-Core Version:    0.7.0.1
 */