package com.pay.ui.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.data.report.APPluginReportParams;
import com.pay.permission.APPermissionActivity;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import midas.x.a;
import midas.x.ec;
import midas.x.ed;
import midas.x.eq;
import midas.x.er;
import midas.x.fm;
import midas.x.fp;
import midas.x.gf;
import midas.x.gg;
import midas.x.gj;

public class APUICommonMethod
{
  private static Stack<Activity> a;
  private static HashMap<ProgressDialog, Context> b;
  private static gf c;
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static BitmapDrawable a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return new BitmapDrawable(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length));
  }
  
  public static String a(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getClass().toString();
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      APLog.i("getClassName", paramActivity.toString());
    }
    return "";
  }
  
  public static gg a(Context paramContext)
  {
    String str = ed.b().n().d.a;
    APLog.i("getResCurrDiamondInfo", str);
    if (!TextUtils.isEmpty(str))
    {
      gg localgg = new gg();
      if (str.equals("huangzuan"))
      {
        localgg.b = "黄钻";
        localgg.a = 2131034297;
        return localgg;
      }
      if (str.equals("lanzuan"))
      {
        localgg.b = "蓝钻";
        localgg.a = 2131034261;
        return localgg;
      }
      if (str.equals("huiyuan"))
      {
        localgg.b = "会员";
        localgg.a = 2131034268;
        return localgg;
      }
      if (str.equals("mozuan"))
      {
        localgg.b = "魔钻";
        localgg.a = 2131034277;
        return localgg;
      }
      if (str.equals("fenzuan"))
      {
        localgg.b = "粉钻";
        localgg.a = 2131034266;
        return localgg;
      }
      paramContext = localgg;
      if (str.equals("lvzuan"))
      {
        localgg.b = "绿钻";
        localgg.a = 2131034267;
        return localgg;
      }
    }
    else
    {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static void a()
  {
    if ((a != null) && (a.size() >= 1))
    {
      Activity localActivity = (Activity)a.peek();
      WindowManager.LayoutParams localLayoutParams = localActivity.getWindow().getAttributes();
      localLayoutParams.alpha = 0.0F;
      localActivity.getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return;
      }
      View localView = LayoutInflater.from(paramContext).inflate(2131165261, null);
      ((TextView)localView.findViewById(2131099800)).setText(paramString);
      paramContext = Toast.makeText(paramContext.getApplicationContext(), paramString, 1);
      paramContext.setGravity(17, 0, 0);
      paramContext.setDuration(0);
      paramContext.setView(localView);
      paramContext.show();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return;
      }
      View localView1 = LayoutInflater.from(paramContext).inflate(2131165261, null);
      ((TextView)localView1.findViewById(2131099800)).setText(paramString);
      View localView2 = localView1.findViewById(2131099799);
      if (paramDrawable != null) {
        localView2.setBackgroundDrawable(paramDrawable);
      } else {
        localView2.setVisibility(8);
      }
      paramContext = Toast.makeText(paramContext.getApplicationContext(), paramString, 1);
      if (paramBoolean) {
        paramContext.setGravity(49, 0, 0);
      } else {
        paramContext.setGravity(17, 0, 0);
      }
      paramContext.setDuration(0);
      paramContext.setView(localView1);
      paramContext.show();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int j = 0;
    try
    {
      if (b == null) {
        b = new HashMap();
      }
      Object localObject = b.entrySet().iterator();
      ProgressDialog localProgressDialog;
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localProgressDialog = (ProgressDialog)((Map.Entry)((Iterator)localObject).next()).getKey();
      } while (!localProgressDialog.isShowing());
      ((gj)localProgressDialog).b(true);
      int i = 1;
      if (i == 0)
      {
        localObject = new gj(paramContext);
        if ((paramString != null) && (paramString.length() != 0)) {
          ((ProgressDialog)localObject).setMessage(paramString);
        }
        b.put(localObject, paramContext);
        ((ProgressDialog)localObject).setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            if (!a.a().f)
            {
              APLog.i("APCommonMethod", "progressdialog onCancel");
              fm.a(2, "");
            }
          }
        });
        ((gj)localObject).a(paramBoolean);
        ((ProgressDialog)localObject).show();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(ImageView paramImageView)
  {
    int i = ed.b().n().a.resId;
    byte[] arrayOfByte = ed.b().n().a.resData;
    if (arrayOfByte != null)
    {
      paramImageView.setBackgroundDrawable(a(arrayOfByte));
      return;
    }
    paramImageView.setBackgroundDrawable(a(fm.a(i)));
  }
  
  public static void a(String paramString)
  {
    APLog.i("showFirstPageInsertDB showName", paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(fp.a().H());
    APLog.i("showFirstPageInsertDB isShowFirstPage", ((StringBuilder)localObject).toString());
    if ((!fp.a().H()) && (!paramString.contains("APMidasDistributeActivity")))
    {
      int i = ed.b().n().a.saveType;
      if ((i != 2) && (i != 3))
      {
        localObject = i();
        APDataReportManager.getInstance().insertData("sdk.apk.time", ed.b().n().a.saveType, "", paramString, (String)localObject);
        fp.a().k(true);
      }
    }
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static void b()
  {
    for (;;)
    {
      int i;
      try
      {
        if (a != null) {
          break label56;
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        e();
        return;
      }
      if (i < a.size())
      {
        if (a.get(i) != null) {
          ((Activity)a.get(i)).finish();
        }
        i += 1;
      }
      else
      {
        label56:
        i = 0;
      }
    }
  }
  
  public static void b(Activity paramActivity)
  {
    if (a == null) {
      return;
    }
    a.remove(paramActivity);
    if (a.size() >= 1)
    {
      paramActivity = (Activity)a.peek();
      try
      {
        localObject = paramActivity.getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject).alpha = 1.0F;
        paramActivity.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
        return;
      }
      catch (Exception paramActivity)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delActivity() e=");
        ((StringBuilder)localObject).append(paramActivity.toString());
        APLog.w("APUICommonMethod", ((StringBuilder)localObject).toString());
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (c == null)
      {
        c = new gf(paramContext);
        c.a(false);
      }
      c.show();
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showWaitDialogNotAllowCancel error:");
      localStringBuilder.append(paramContext.toString());
      APLog.w("APUICommonMethod", localStringBuilder.toString());
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, false);
  }
  
  public static Activity c()
  {
    try
    {
      if (a == null) {
        return null;
      }
      Activity localActivity = (Activity)a.peek();
      return localActivity;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static void c(Activity paramActivity)
  {
    if (paramActivity == null) {}
    try
    {
      b();
      return;
    }
    catch (Exception paramActivity) {}
    int j = a.size();
    int i = j - 1;
    while (i < j)
    {
      Activity localActivity = (Activity)a.get(i);
      if (localActivity != null)
      {
        if (localActivity.equals(paramActivity)) {
          return;
        }
        localActivity.finish();
        a.remove(i);
      }
      i -= 1;
    }
    return;
  }
  
  public static void c(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      if (((Activity)paramContext).isFinishing())
      {
        c = null;
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      APLog.i("showWaitDialogNotAllowCancel (Activity) context", paramContext.toString());
      try
      {
        if ((c != null) && (c.isShowing()))
        {
          c.dismiss();
          c = null;
          return;
        }
      }
      catch (Exception paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dismissWaitDialogNotAllowCancel error:");
        localStringBuilder.append(paramContext.toString());
        APLog.w("APUICommonMethod", localStringBuilder.toString());
      }
    }
  }
  
  public static void d()
  {
    localObject2 = null;
    for (Object localObject1 = null;; localObject1 = localObject3)
    {
      try
      {
        if (a != null) {
          break label150;
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3 = localObject2;
          continue;
          int i = 0;
        }
      }
      localObject3 = localObject1;
      localObject2 = localObject1;
      if (i >= a.size()) {
        break;
      }
      localObject3 = localObject1;
      localObject2 = localObject1;
      if (a.get(i) != null)
      {
        localObject2 = localObject1;
        if ("com.tencent.midas.pay.APMidasDistributeActivity".equals(((Activity)a.get(i)).getClass().getName()))
        {
          localObject2 = localObject1;
          localObject3 = (Activity)a.get(i);
        }
        else
        {
          localObject2 = localObject1;
          APLog.i("activityStack", ((Activity)a.get(i)).getClass().getName());
          localObject2 = localObject1;
          ((Activity)a.get(i)).finish();
          localObject3 = localObject1;
        }
      }
      i += 1;
    }
    e();
    if (localObject3 != null) {
      pushActivity((Activity)localObject3);
    }
  }
  
  public static void e()
  {
    if (a != null) {
      a.clear();
    }
    a = null;
  }
  
  public static void f()
  {
    if (b != null) {
      b.clear();
    }
    b = null;
  }
  
  public static void g()
  {
    if (b == null) {
      return;
    }
    try
    {
      Iterator localIterator = b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ProgressDialog localProgressDialog = (ProgressDialog)((Map.Entry)localIterator.next()).getKey();
        if (localProgressDialog.isShowing())
        {
          localProgressDialog.dismiss();
          localIterator.remove();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean h()
  {
    String str = ed.b().n().a.extendInfo.unit;
    int i = ed.b().n().a.saveType;
    return (str.contains("specialUnit")) && (i == 0);
  }
  
  private static String i()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("name=");
    localStringBuffer.append("sdk.firstpage");
    localStringBuffer.append("&");
    long l = APPluginReportParams.getInstance().b();
    int i = (int)(System.currentTimeMillis() - l);
    localStringBuffer.append("times=");
    localStringBuffer.append(i);
    localStringBuffer.append("&");
    localStringBuffer.append("plugintimes=");
    localStringBuffer.append(APPluginReportParams.getInstance().d());
    localStringBuffer.append("&");
    localStringBuffer.append("network=");
    localStringBuffer.append(APAppDataInterface.singleton().i());
    localStringBuffer.append("&");
    localStringBuffer.append("networktimes=");
    localStringBuffer.append(APPluginReportParams.getInstance().e());
    localStringBuffer.append("&");
    localStringBuffer.append("isexpress=");
    localStringBuffer.append(ed.b().n().e.j);
    localStringBuffer.append("&");
    if (TextUtils.isEmpty(ed.b().n().a.saveValue)) {
      localObject = "list";
    } else {
      localObject = "input";
    }
    localStringBuffer.append("isstorelist=");
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("&");
    localStringBuffer.append("intervaltime=");
    localStringBuffer.append(APPluginReportParams.getInstance().f());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("all:");
    ((StringBuilder)localObject).append(localStringBuffer.toString());
    APLog.i("showFirstPageInsertDB=====", ((StringBuilder)localObject).toString());
    return localStringBuffer.toString();
  }
  
  public static void pushActivity(Activity paramActivity)
  {
    try
    {
      if (a == null) {
        a = new Stack();
      }
      a.push(paramActivity);
      if ((a.size() > 1) && (!(paramActivity instanceof APPermissionActivity)))
      {
        localObject = (Activity)a.get(a.size() - 2);
        WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
        localLayoutParams.alpha = 0.0F;
        ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
      }
      if (a.size() == 1) {
        a(a(paramActivity));
      }
    }
    catch (Exception paramActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pushActivity fail:");
      ((StringBuilder)localObject).append(paramActivity.toString());
      APLog.i("APUICommonMethod", ((StringBuilder)localObject).toString());
    }
    paramActivity = new StringBuilder();
    paramActivity.append("activityStack.size:");
    paramActivity.append(a.size());
    APLog.i("pushActivity stack size", paramActivity.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.APUICommonMethod
 * JD-Core Version:    0.7.0.1
 */