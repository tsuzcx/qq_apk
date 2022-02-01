package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;
import com.pay.api.APAndroidPayAPI;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.data.report.APPluginReportParams;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.APFriendsPayActivity;
import com.pay.ui.payWeb.APX5FriendsPayActivity;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.realname.APRealnameRegistActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginUtils;
import java.util.ArrayList;

public abstract class q4
  implements Cloneable
{
  public int a;
  public long b;
  public long c;
  public Context d;
  public APBaseRequest e;
  public long f = 0L;
  
  public final ArrayList<q0> a(ArrayList<q0> paramArrayList)
  {
    return new v0().b(paramArrayList);
  }
  
  public final void a(int paramInt)
  {
    s0 locals0 = new s0(this.d);
    new y0(this.d, 2, locals0, new k()).a(paramInt);
  }
  
  public final void a(final int paramInt, final String paramString)
  {
    APAlertDialog.f localf = new APAlertDialog.f(this.d);
    localf.b("提示");
    localf.a(paramString);
    localf.b("确定", new d(paramInt, paramString));
    localf.b(new e(paramInt, paramString));
    try
    {
      localf.b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void a(int paramInt1, ob paramob, int paramInt2, ArrayList<q0> paramArrayList, final int paramInt3)
  {
    APUICommonMethod.b();
    paramob = new s0(this.d);
    y0 localy0 = new y0(this.d, paramInt2, paramob, new j(paramInt3));
    localy0.b(paramArrayList);
    paramob.a(paramArrayList, 2);
    localy0.b(paramArrayList, 2);
  }
  
  public final void a(final int paramInt1, final ob paramob, final ArrayList<q0> paramArrayList, final int paramInt2)
  {
    if (APAppDataInterface.singleton().s() == 1000)
    {
      a(paramInt1, paramob, 1, paramArrayList, paramInt2);
      return;
    }
    APUICommonMethod.b();
    new y0(this.d, paramArrayList, new i(paramInt1, paramob, paramArrayList, paramInt2)).c(paramArrayList);
  }
  
  public final void a(Context paramContext)
  {
    if (xd.f(paramContext))
    {
      xd.e(paramContext);
      return;
    }
    a(paramContext, this.e);
  }
  
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    this.f = System.currentTimeMillis();
    b(paramContext, paramAPBaseRequest);
  }
  
  public void a(String paramString)
  {
    APUICommonMethod.b();
    APUICommonMethod.a(this.d, paramString);
    APUICommonMethod.f();
    z5.a(3, paramString);
  }
  
  public final void a(final ob paramob, ArrayList<q0> paramArrayList)
  {
    ArrayList localArrayList = a(paramArrayList);
    if ((localArrayList != null) && ((localArrayList == null) || (localArrayList.size() >= 1)))
    {
      if (localArrayList.size() < paramArrayList.size())
      {
        APLog.i("APBUypage", "resultData=强制升级部分走网络下载路径");
        paramArrayList = r0.p().f();
        a(this.a, paramob, paramArrayList, 1);
        return;
      }
      if (localArrayList.size() == paramArrayList.size())
      {
        APLog.i("APBUypage", "resultData=强制升级全部走sdcrad路径");
        APUICommonMethod.b();
        new y0(this.d, 2, null, new h(paramob)).a(localArrayList);
      }
    }
    else
    {
      a(this.a, paramob, paramArrayList, 0);
      APLog.i("APBUypage", "resultData=强制升级全部走网络下载路径");
    }
  }
  
  public final boolean a()
  {
    Object localObject = r0.p().a();
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() <= 0) {
        return true;
      }
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resultData checlistsize:");
        localStringBuilder.append(((ArrayList)localObject).size());
        APLog.i("APbuypage", localStringBuilder.toString());
        APUICommonMethod.b();
        localObject = new v0(this.d);
        if (!((v0)localObject).b())
        {
          APLog.i("APbuypage", "resultData data plugins checkResult false");
          Toast.makeText(this.d.getApplicationContext(), "腾讯充值加载失败，请重新拉起", 0).show();
          APUICommonMethod.f();
          z5.a(8, "腾讯充值拉起失败，请重新拉起");
          ((v0)localObject).c();
          ((v0)localObject).d();
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public final void b()
  {
    APDataReportManager.getInstance().a("sdk.update.advise.wifi.enter", "totalnumber");
    new w0(this.d).e();
  }
  
  public final void b(final int paramInt, final String paramString)
  {
    APAlertDialog.f localf = new APAlertDialog.f(this.d);
    localf.b("提示");
    localf.a("当前设备系统时间不正确，请在系统设置中更改。");
    localf.b("现在设置", new a());
    localf.a("返回", new b(paramInt, paramString));
    localf.b(new c(paramInt, paramString));
    try
    {
      localf.b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public abstract void b(Context paramContext, APBaseRequest paramAPBaseRequest);
  
  public final void c()
  {
    APUICommonMethod.b();
    c6.s0().c(true);
    Intent localIntent = new Intent();
    c6.s0().A("AndroidPay");
    if (h8.d(this.d)) {
      localIntent.setClass(this.d, APX5FriendsPayActivity.class);
    } else {
      localIntent.setClass(this.d, APFriendsPayActivity.class);
    }
    this.d.startActivity(localIntent);
  }
  
  public void c(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    this.d = paramContext;
    this.a = paramAPBaseRequest.saveType;
    this.e = paramAPBaseRequest;
    a.r().a(paramContext);
    long l = APPluginReportParams.getInstance().f();
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchPayTimeCount=");
    localStringBuilder.append(APAndroidPayAPI.launchPayTimeCount);
    localAPDataReportManager.a("sdk.launchPayBeforeNet.totaltime", l, localStringBuilder.toString());
    d(paramContext, paramAPBaseRequest);
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public final void d(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    String str = APAppDataInterface.singleton().h();
    if ((!str.equals("test")) && (!str.equals("testing")) && (!str.equals("dev")))
    {
      APUICommonMethod.a(paramContext, paramContext.getString(2131230803), true);
      if (a.r().m.equals("1"))
      {
        c();
        return;
      }
      a(paramContext);
      return;
    }
    e(paramContext, paramAPBaseRequest);
  }
  
  public void d(ob paramob)
  {
    int i = (int)(System.currentTimeMillis() - this.f);
    APPluginReportParams.getInstance().b(i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time:");
    localStringBuilder.append(i);
    APLog.i("beforeBuyInfoSucc", localStringBuilder.toString());
    e(paramob);
  }
  
  public boolean d()
  {
    if (z5.d())
    {
      String str = p4.p().e().b.mpInfo.payChannel;
      if (o.m().i())
      {
        APUICommonMethod.b();
        c6.s0().A("AndroidPay");
        e5.h().a(this.d, str, null);
      }
      else
      {
        e5.h().a(this.d, str, null, null, null);
      }
      return true;
    }
    return false;
  }
  
  public final void e(final Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (c6.s0().m0())
    {
      paramAPBaseRequest = new APAlertDialog.f(paramContext);
      paramAPBaseRequest.a(2131230935);
      paramAPBaseRequest.a("您正在进入测试环境，任何充值将无法在真实环境中使用。若您不是测试人员，请勿充值。");
      paramAPBaseRequest.b(paramContext.getString(2131230890), new f(paramContext));
      paramAPBaseRequest.b(new g());
      try
      {
        paramAPBaseRequest.b();
        return;
      }
      catch (Exception paramContext)
      {
        paramAPBaseRequest = new StringBuilder();
        paramAPBaseRequest.append("");
        paramAPBaseRequest.append(paramContext.getMessage());
        APLog.i("", paramAPBaseRequest.toString());
        return;
      }
    }
    paramAPBaseRequest = new StringBuilder();
    paramAPBaseRequest.append("正在进入沙箱支付环境\n版本号:");
    paramAPBaseRequest.append(z5.c());
    APUICommonMethod.a(paramContext, paramAPBaseRequest.toString(), true);
    if (a.r().m.equals("1"))
    {
      c();
      return;
    }
    a(paramContext);
  }
  
  public abstract void e(ob paramob);
  
  public void f(ob paramob)
  {
    APUICommonMethod.b();
    APUICommonMethod.a(this.d, paramob.c());
    APUICommonMethod.f();
    z5.a(-1, paramob.d(), paramob.f());
    this.b = System.currentTimeMillis();
    long l1 = this.b;
    long l2 = this.c;
    APDataReportManager.getInstance().insertData("sdk.cgi.mobilebuygoods.failure", 0, null, null, String.valueOf(l1 - l2));
  }
  
  public void g(ob paramob)
  {
    this.b = System.currentTimeMillis();
    long l1 = this.b;
    long l2 = this.c;
    APDataReportManager.getInstance().insertData("sdk.cgi.mobilebuypage.sucess", 0, null, null, String.valueOf(l1 - l2));
    if ((paramob != null) && ((paramob instanceof d2)) && (((d2)paramob).g))
    {
      APLog.d("APBaseBuyPage", "buypage return need change h5!");
      APUICommonMethod.b();
      APUICommonMethod.f();
      z5.a(-100011, "needChangeH5");
      if (APTools.u(this.d))
      {
        APLog.d("APBaseBuyPage", "buypage return need change h5! Is new process, clear cache!");
        APPluginUtils.release();
        APPluginUtils.updateLibExtendNum();
        return;
      }
      APLog.d("APBaseBuyPage", "buypage return need change h5! Not new process, no need to clear cache!");
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramob != null)
    {
      bool1 = bool2;
      if ((paramob instanceof d2))
      {
        bool1 = bool2;
        if (((d2)paramob).h) {
          bool1 = true;
        }
      }
    }
    w1.b().a(bool1);
    int i = paramob.d();
    if (i != 0)
    {
      if (i != 1018)
      {
        if (i != 1159)
        {
          if (i != 1246)
          {
            if (i != 1319)
            {
              if (i != 1320)
              {
                if (i != 20100)
                {
                  if (i != 20101)
                  {
                    APUICommonMethod.b();
                    paramob = paramob.f();
                    APUICommonMethod.a(this.d, paramob);
                    APUICommonMethod.f();
                    z5.a(i, paramob);
                    return;
                  }
                  APLog.i("APBaseBuyPage", "toH5Pay");
                  APDataReportManager.getInstance().insertData("sdk.httpserror.jumph5", p4.p().e().b.saveType);
                  c6.s0().c(true);
                  paramob = new Intent();
                  if (h8.d(this.d)) {
                    paramob.setClass(this.d, APX5WebJSBridgeActivity.class);
                  } else {
                    paramob.setClass(this.d, APWebJSBridgeActivity.class);
                  }
                  Bundle localBundle = new Bundle();
                  localBundle.putString("pageName", y7.x);
                  paramob.putExtras(localBundle);
                  this.d.startActivity(paramob);
                  return;
                }
                b(paramob.d(), paramob.c());
                return;
              }
              APUICommonMethod.b();
              c6.s0().c(true);
              paramob = new Intent();
              c6.s0().A("AndroidPay");
              paramob.setClass(this.d, APRealnameRegistActivity.class);
              this.d.startActivity(paramob);
              return;
            }
            APUICommonMethod.b();
            APUICommonMethod.f();
            z5.a(i, paramob.f());
            return;
          }
          APDataReportManager.getInstance().insertData("sdk.buypage.appsign.invalid", p4.p().e().b.saveType);
          a(i, "应用签名校验失败，请联系米大师");
          return;
        }
        a(i, paramob.f());
        return;
      }
      APUICommonMethod.b();
      a.a("登录过期，请重新登录", this.d);
      return;
    }
    c6.s0().c(true);
    h(paramob);
  }
  
  public final void h(ob paramob)
  {
    l.a().c(this.d);
    int j = 0;
    int i;
    try
    {
      String str1 = this.d.getApplicationContext().getPackageName();
      String str2 = APTools.d();
      i = j;
      if ("com.tencent.midas.sample".equals(str1))
      {
        i = j;
        if (!TextUtils.isEmpty(str2)) {
          if (!str2.endsWith("-midas-single"))
          {
            boolean bool = str2.endsWith("-midas-multi");
            i = j;
            if (!bool) {}
          }
          else
          {
            i = 1;
          }
        }
      }
    }
    finally
    {
      localObject.printStackTrace();
      i = j;
    }
    if (i != 0)
    {
      d(paramob);
      return;
    }
    if (a())
    {
      APUICommonMethod.b();
      APUICommonMethod.a(this.d, "未正式发布的版本，请联系米大师");
      z5.a(7, "未正式发布的版本，请联系米大师");
      return;
    }
    if (r0.p().k())
    {
      APUICommonMethod.b();
      new v0().c();
      APUICommonMethod.a(this.d, "腾讯充值加载失败，请重新拉起");
      z5.a(7, "腾讯充值加载失败，请重新拉起");
      return;
    }
    ArrayList localArrayList = r0.p().b();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      if ((r0.p().i()) && (!r0.p().n()))
      {
        a(paramob, localArrayList);
        return;
      }
      if ((r0.p().o()) || (APAppDataInterface.singleton().s() == 1000)) {
        b();
      }
      d(paramob);
      return;
    }
    d(paramob);
  }
  
  public class a
    implements c7
  {
    public a() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      try
      {
        paramAPAlertDialog = new Intent("android.settings.DATE_SETTINGS");
        q4.this.d.startActivity(paramAPAlertDialog);
        APDataReportManager.getInstance().insertData("sdk.https.timeinvalid.sure", p4.p().e().b.saveType);
        return;
      }
      catch (Exception paramAPAlertDialog) {}
    }
  }
  
  public class b
    implements c7
  {
    public b(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      APUICommonMethod.f();
      z5.a(paramInt, paramString);
      APDataReportManager.getInstance().insertData("sdk.https.timeinvalid.back", p4.p().e().b.saveType);
    }
  }
  
  public class c
    implements c7
  {
    public c(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APUICommonMethod.f();
        z5.a(paramInt, paramString);
        APDataReportManager.getInstance().insertData("sdk.https.timeinvalid.keyback", p4.p().e().b.saveType);
      }
    }
  }
  
  public class d
    implements c7
  {
    public d(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      try
      {
        paramAPAlertDialog.f();
        APUICommonMethod.f();
        z5.a(paramInt, paramString);
        return;
      }
      catch (Exception paramAPAlertDialog) {}
    }
  }
  
  public class e
    implements c7
  {
    public e(int paramInt, String paramString) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APUICommonMethod.f();
        z5.a(paramInt, paramString);
      }
    }
  }
  
  public class f
    implements c7
  {
    public f(Context paramContext) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      try
      {
        if (!"com.tencent.unipay".equals(paramContext.getApplicationContext().getPackageName()))
        {
          paramKeyEvent = APTools.a(paramContext.getApplicationContext());
          String str = APTools.d(paramContext.getApplicationContext());
          if ((!TextUtils.isEmpty(paramKeyEvent)) || (!TextUtils.isEmpty(str)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("需注册以下Activity和权限，但未按要求注册");
            localStringBuilder.append(paramKeyEvent);
            localStringBuilder.append("\n");
            localStringBuilder.append(str);
            paramKeyEvent = localStringBuilder.toString();
            Toast.makeText(paramContext.getApplicationContext(), paramKeyEvent, 1).show();
          }
        }
        c6.s0().p(false);
        paramKeyEvent = new StringBuilder();
        paramKeyEvent.append("正在进入沙箱支付环境\n版本号:");
        paramKeyEvent.append(z5.c());
        paramKeyEvent = paramKeyEvent.toString();
        APUICommonMethod.a(paramContext, paramKeyEvent, true);
        paramAPAlertDialog.f();
        if (a.r().m.equals("1"))
        {
          q4.a(q4.this);
          return;
        }
        q4.a(q4.this, paramContext);
        return;
      }
      catch (Exception paramAPAlertDialog)
      {
        paramAPAlertDialog.printStackTrace();
      }
    }
  }
  
  public class g
    implements c7
  {
    public g() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APUICommonMethod.f();
        z5.a(2, "");
      }
    }
  }
  
  public class h
    implements b1
  {
    public h(ob paramob) {}
    
    public void a()
    {
      APDataReportManager.getInstance().insertData("sdk.update.force.sucess", -1);
      z5.a(2, "");
    }
    
    public void a(int paramInt) {}
    
    public void b()
    {
      APUICommonMethod.a(q4.this.d, "系统内存不足，请清理后再试");
      z5.a(2, "");
    }
    
    public void b(int paramInt)
    {
      APLog.i("APBUypage", "resultData=强制升级全部走sdcrad不成功，sdcrad文件是不完整的.然后走网络下载路径");
      ArrayList localArrayList = r0.p().g();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        q4 localq4 = q4.this;
        q4.a(localq4, localq4.a, paramob, localArrayList, 0);
      }
    }
  }
  
  public class i
    implements c1
  {
    public i(int paramInt1, ob paramob, ArrayList paramArrayList, int paramInt2) {}
    
    public void a(int paramInt)
    {
      if (paramInt == 1)
      {
        q4.a(q4.this, paramInt1, paramob, 3, paramArrayList, paramInt2);
        return;
      }
      z5.a(2, "");
    }
  }
  
  public class j
    implements b1
  {
    public j(int paramInt) {}
    
    public void a()
    {
      q4.a(q4.this, paramInt3);
    }
    
    public void a(int paramInt) {}
    
    public void b()
    {
      APUICommonMethod.a(q4.this.d, "系统内存不足，请清理后再试");
      z5.a(2, "");
    }
    
    public void b(int paramInt)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errone=");
      localStringBuilder.append(r0.p().c());
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append("&");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errThree=");
      localStringBuilder.append(r0.p().d());
      localStringBuffer.append(localStringBuilder.toString());
      APDataReportManager.getInstance().insertData("sdk.update.force.fail", -1, null, null, localStringBuffer.toString());
      APUICommonMethod.a(q4.this.d, "网络异常，请重试");
      z5.a(2, "取消");
    }
  }
  
  public class k
    implements b1
  {
    public k() {}
    
    public void a()
    {
      APDataReportManager.getInstance().insertData("sdk.update.force.sucess", -1);
      z5.a(2, "");
    }
    
    public void a(int paramInt) {}
    
    public void b()
    {
      APUICommonMethod.a(q4.this.d, "系统内存不足，请清理后再试");
      z5.a(2, "");
    }
    
    public void b(int paramInt)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errone=");
      localStringBuilder.append(r0.p().c());
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append("&");
      localStringBuffer.append("errtwo=checkfail");
      APDataReportManager.getInstance().insertData("sdk.update.force.fail", -3, null, null, localStringBuffer.toString());
      APUICommonMethod.a(q4.this.d, "安全性校验失败，请退出重试");
      z5.a(2, "\t取消");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q4
 * JD-Core Version:    0.7.0.1
 */