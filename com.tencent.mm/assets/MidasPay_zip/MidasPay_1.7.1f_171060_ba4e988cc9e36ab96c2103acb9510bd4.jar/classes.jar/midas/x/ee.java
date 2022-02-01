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
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.APFriendsPayActivity;
import com.pay.ui.payWeb.APX5FriendsPayActivity;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.realname.APRealnameRegistActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginUtils;
import java.util.ArrayList;

public abstract class ee
  implements Cloneable
{
  protected int a;
  protected long b;
  protected long c;
  protected Context d;
  protected APBaseRequest e;
  private long f = 0L;
  
  private ArrayList<ap> a(ArrayList<ap> paramArrayList)
  {
    return new au().a(paramArrayList);
  }
  
  private void a(int paramInt)
  {
    ar localar = new ar(this.d);
    new ax(this.d, 2, localar, new ba()
    {
      public void a()
      {
        APDataReportManager.getInstance().insertData("sdk.update.force.sucess", -1);
        fm.a(2, "");
      }
      
      public void a(int paramAnonymousInt) {}
      
      public void b()
      {
        APUICommonMethod.a(ee.this.d, "系统内存不足，请清理后再试");
        fm.a(2, "");
      }
      
      public void b(int paramAnonymousInt)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("errone=");
        localStringBuilder.append(aq.a().m());
        localStringBuffer.append(localStringBuilder.toString());
        localStringBuffer.append("&");
        localStringBuffer.append("errtwo=checkfail");
        APDataReportManager.getInstance().insertData("sdk.update.force.fail", -3, null, null, localStringBuffer.toString());
        APUICommonMethod.a(ee.this.d, "安全性校验失败，请退出重试");
        fm.a(2, "\t取消");
      }
    }).a(paramInt);
  }
  
  private void a(final int paramInt, final String paramString)
  {
    APAlertDialog.a locala = new APAlertDialog.a(this.d);
    locala.b("提示");
    locala.a("当前设备系统时间不正确，请在系统设置中更改。");
    locala.a("现在设置", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        try
        {
          paramAnonymousAPAlertDialog = new Intent("android.settings.DATE_SETTINGS");
          ee.this.d.startActivity(paramAnonymousAPAlertDialog);
          APDataReportManager.getInstance().insertData("sdk.https.timeinvalid.sure", ed.b().n().a.saveType);
          return;
        }
        catch (Exception paramAnonymousAPAlertDialog) {}
      }
    });
    locala.b("返回", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
        APUICommonMethod.b();
        fm.a(paramInt, paramString);
        APDataReportManager.getInstance().insertData("sdk.https.timeinvalid.back", ed.b().n().a.saveType);
      }
    });
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APUICommonMethod.b();
          fm.a(paramInt, paramString);
          APDataReportManager.getInstance().insertData("sdk.https.timeinvalid.keyback", ed.b().n().a.saveType);
        }
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(int paramInt1, jw paramjw, int paramInt2, ArrayList<ap> paramArrayList, final int paramInt3)
  {
    APUICommonMethod.g();
    paramjw = new ar(this.d);
    ax localax = new ax(this.d, paramInt2, paramjw, new ba()
    {
      public void a()
      {
        ee.a(ee.this, paramInt3);
      }
      
      public void a(int paramAnonymousInt) {}
      
      public void b()
      {
        APUICommonMethod.a(ee.this.d, "系统内存不足，请清理后再试");
        fm.a(2, "");
      }
      
      public void b(int paramAnonymousInt)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("errone=");
        localStringBuilder.append(aq.a().m());
        localStringBuffer.append(localStringBuilder.toString());
        localStringBuffer.append("&");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("errThree=");
        localStringBuilder.append(aq.a().o());
        localStringBuffer.append(localStringBuilder.toString());
        APDataReportManager.getInstance().insertData("sdk.update.force.fail", -1, null, null, localStringBuffer.toString());
        APUICommonMethod.a(ee.this.d, "网络异常，请重试");
        fm.a(2, "取消");
      }
    });
    localax.a(paramArrayList);
    paramjw.b(paramArrayList, 2);
    localax.a(paramArrayList, 2);
  }
  
  private void a(final int paramInt1, final jw paramjw, final ArrayList<ap> paramArrayList, final int paramInt2)
  {
    if (APAppDataInterface.singleton().i() == 1000)
    {
      a(paramInt1, paramjw, 1, paramArrayList, paramInt2);
      return;
    }
    APUICommonMethod.g();
    new ax(this.d, paramArrayList, new bb()
    {
      public void a(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 1)
        {
          ee.a(ee.this, paramInt1, paramjw, 3, paramArrayList, paramInt2);
          return;
        }
        fm.a(2, "");
      }
    }).b(paramArrayList);
  }
  
  private void a(Context paramContext)
  {
    if (lv.a(paramContext))
    {
      lv.b(paramContext);
      return;
    }
    b(paramContext, this.e);
  }
  
  private void a(jw paramjw)
  {
    l.a().a(this.d);
    int j = 0;
    int i;
    try
    {
      String str1 = this.d.getApplicationContext().getPackageName();
      String str2 = APTools.b();
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
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      i = j;
    }
    if (i != 0)
    {
      e(paramjw);
      return;
    }
    if (c())
    {
      APUICommonMethod.g();
      APUICommonMethod.a(this.d, "未正式发布的版本，请联系米大师");
      fm.a(7, "未正式发布的版本，请联系米大师");
      return;
    }
    if (aq.a().f())
    {
      APUICommonMethod.g();
      new au().e();
      APUICommonMethod.a(this.d, "腾讯充值加载失败，请重新拉起");
      fm.a(7, "腾讯充值加载失败，请重新拉起");
      return;
    }
    ArrayList localArrayList = aq.a().b();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      if ((aq.a().d()) && (!aq.a().g()))
      {
        a(paramjw, localArrayList);
        return;
      }
      if ((aq.a().e()) || (APAppDataInterface.singleton().i() == 1000)) {
        d();
      }
      e(paramjw);
      return;
    }
    e(paramjw);
  }
  
  private void a(final jw paramjw, ArrayList<ap> paramArrayList)
  {
    ArrayList localArrayList = a(paramArrayList);
    if ((localArrayList != null) && ((localArrayList == null) || (localArrayList.size() >= 1)))
    {
      if (localArrayList.size() < paramArrayList.size())
      {
        APLog.i("APBUypage", "resultData=强制升级部分走网络下载路径");
        paramArrayList = aq.a().k();
        a(this.a, paramjw, paramArrayList, 1);
        return;
      }
      if (localArrayList.size() == paramArrayList.size())
      {
        APLog.i("APBUypage", "resultData=强制升级全部走sdcrad路径");
        APUICommonMethod.g();
        new ax(this.d, 2, null, new ba()
        {
          public void a()
          {
            APDataReportManager.getInstance().insertData("sdk.update.force.sucess", -1);
            fm.a(2, "");
          }
          
          public void a(int paramAnonymousInt) {}
          
          public void b()
          {
            APUICommonMethod.a(ee.this.d, "系统内存不足，请清理后再试");
            fm.a(2, "");
          }
          
          public void b(int paramAnonymousInt)
          {
            APLog.i("APBUypage", "resultData=强制升级全部走sdcrad不成功，sdcrad文件是不完整的.然后走网络下载路径");
            ArrayList localArrayList = aq.a().j();
            if ((localArrayList != null) && (localArrayList.size() > 0)) {
              ee.a(ee.this, ee.this.a, paramjw, localArrayList, 0);
            }
          }
        }).c(localArrayList);
      }
    }
    else
    {
      a(this.a, paramjw, paramArrayList, 0);
      APLog.i("APBUypage", "resultData=强制升级全部走网络下载路径");
    }
  }
  
  private void b()
  {
    APUICommonMethod.g();
    fp.a().b(true);
    Intent localIntent = new Intent();
    fp.a().b("AndroidPay");
    if (hs.b(this.d)) {
      localIntent.setClass(this.d, APX5FriendsPayActivity.class);
    } else {
      localIntent.setClass(this.d, APFriendsPayActivity.class);
    }
    this.d.startActivity(localIntent);
  }
  
  private void b(final int paramInt, final String paramString)
  {
    APAlertDialog.a locala = new APAlertDialog.a(this.d);
    locala.b("提示");
    locala.a(paramString);
    locala.a("确定", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        try
        {
          paramAnonymousAPAlertDialog.a();
          APUICommonMethod.b();
          fm.a(paramInt, paramString);
          return;
        }
        catch (Exception paramAnonymousAPAlertDialog) {}
      }
    });
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APUICommonMethod.b();
          fm.a(paramInt, paramString);
        }
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private boolean c()
  {
    Object localObject = aq.a().c();
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
        APUICommonMethod.g();
        localObject = new au(this.d);
        if (!((au)localObject).d())
        {
          APLog.i("APbuypage", "resultData data plugins checkResult false");
          Toast.makeText(this.d.getApplicationContext(), "腾讯充值加载失败，请重新拉起", 0).show();
          APUICommonMethod.b();
          fm.a(8, "腾讯充值拉起失败，请重新拉起");
          ((au)localObject).e();
          ((au)localObject).f();
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  private void d()
  {
    APDataReportManager.getInstance().a("sdk.update.advise.wifi.enter", "totalnumber");
    new av(this.d).a();
  }
  
  private void d(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    String str = APAppDataInterface.singleton().e();
    if ((!str.equals("test")) && (!str.equals("testing")) && (!str.equals("dev")))
    {
      APUICommonMethod.a(paramContext, paramContext.getString(2131230802), true);
      if (a.a().i.equals("1"))
      {
        b();
        return;
      }
      a(paramContext);
      return;
    }
    e(paramContext, paramAPBaseRequest);
  }
  
  private void e(final Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    if (fp.a().u())
    {
      paramAPBaseRequest = new APAlertDialog.a(paramContext);
      paramAPBaseRequest.b(2131230934);
      paramAPBaseRequest.a("您正在进入测试环境，任何充值将无法在真实环境中使用。若您不是测试人员，请勿充值。");
      paramAPBaseRequest.a(paramContext.getString(2131230889), new gn()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          try
          {
            if (!"com.tencent.unipay".equals(paramContext.getApplicationContext().getPackageName()))
            {
              paramAnonymousKeyEvent = APTools.k(paramContext.getApplicationContext());
              String str = APTools.j(paramContext.getApplicationContext());
              if ((!TextUtils.isEmpty(paramAnonymousKeyEvent)) || (!TextUtils.isEmpty(str)))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("需注册以下Activity和权限，但未按要求注册");
                localStringBuilder.append(paramAnonymousKeyEvent);
                localStringBuilder.append("\n");
                localStringBuilder.append(str);
                paramAnonymousKeyEvent = localStringBuilder.toString();
                Toast.makeText(paramContext.getApplicationContext(), paramAnonymousKeyEvent, 1).show();
              }
            }
            fp.a().c(false);
            paramAnonymousKeyEvent = new StringBuilder();
            paramAnonymousKeyEvent.append("正在进入沙箱支付环境\n版本号:");
            paramAnonymousKeyEvent.append(fm.c());
            paramAnonymousKeyEvent = paramAnonymousKeyEvent.toString();
            APUICommonMethod.a(paramContext, paramAnonymousKeyEvent, true);
            paramAnonymousAPAlertDialog.a();
            if (a.a().i.equals("1"))
            {
              ee.a(ee.this);
              return;
            }
            ee.a(ee.this, paramContext);
            return;
          }
          catch (Exception paramAnonymousAPAlertDialog)
          {
            paramAnonymousAPAlertDialog.printStackTrace();
          }
        }
      });
      paramAPBaseRequest.b(new gn()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            APUICommonMethod.b();
            fm.a(2, "");
          }
        }
      });
      try
      {
        paramAPBaseRequest.c();
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
    paramAPBaseRequest.append(fm.c());
    APUICommonMethod.a(paramContext, paramAPBaseRequest.toString(), true);
    if (a.a().i.equals("1"))
    {
      b();
      return;
    }
    a(paramContext);
  }
  
  protected abstract void a(Context paramContext, APBaseRequest paramAPBaseRequest);
  
  public void a(String paramString)
  {
    APUICommonMethod.g();
    APUICommonMethod.a(this.d, paramString);
    APUICommonMethod.b();
    fm.a(3, paramString);
  }
  
  protected boolean a()
  {
    if (fm.f())
    {
      String str = ed.b().n().a.mpInfo.payChannel;
      if (n.a().h())
      {
        APUICommonMethod.g();
        fp.a().b("AndroidPay");
        es.a().a(this.d, str, null);
      }
      else
      {
        es.a().a(this.d, str, null, null, null);
      }
      return true;
    }
    return false;
  }
  
  public void b(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    this.f = System.currentTimeMillis();
    a(paramContext, paramAPBaseRequest);
  }
  
  public void c(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    this.d = paramContext;
    this.a = paramAPBaseRequest.saveType;
    this.e = paramAPBaseRequest;
    a.a().a(paramContext);
    long l = APPluginReportParams.getInstance().b();
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
  
  protected abstract void d(jw paramjw);
  
  public void e(jw paramjw)
  {
    int i = (int)(System.currentTimeMillis() - this.f);
    APPluginReportParams.getInstance().b(i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time:");
    localStringBuilder.append(i);
    APLog.i("beforeBuyInfoSucc", localStringBuilder.toString());
    d(paramjw);
  }
  
  protected void f(jw paramjw)
  {
    APUICommonMethod.g();
    APUICommonMethod.a(this.d, paramjw.T());
    APUICommonMethod.b();
    fm.a(-1, paramjw.R(), paramjw.S());
    this.b = System.currentTimeMillis();
    long l1 = this.b;
    long l2 = this.c;
    APDataReportManager.getInstance().insertData("sdk.cgi.mobilebuygoods.failure", 0, null, null, String.valueOf(l1 - l2));
  }
  
  protected void g(jw paramjw)
  {
    this.b = System.currentTimeMillis();
    long l1 = this.b;
    long l2 = this.c;
    APDataReportManager.getInstance().insertData("sdk.cgi.mobilebuypage.sucess", 0, null, null, String.valueOf(l1 - l2));
    if ((paramjw != null) && ((paramjw instanceof bw)) && (((bw)paramjw).a))
    {
      APLog.d("APBaseBuyPage", "buypage return need change h5!");
      APUICommonMethod.g();
      APUICommonMethod.b();
      fm.a(-100011, "needChangeH5");
      if (APTools.s(this.d))
      {
        APLog.d("APBaseBuyPage", "buypage return need change h5! Is new process, clear cache!");
        APPluginUtils.release();
        APPluginUtils.updateLibExtendNum();
        return;
      }
      APLog.d("APBaseBuyPage", "buypage return need change h5! Not new process, no need to clear cache!");
      return;
    }
    int i = paramjw.R();
    if (i != 0)
    {
      if (i != 1018)
      {
        if (i != 1159)
        {
          if (i != 1246)
          {
            switch (i)
            {
            default: 
              switch (i)
              {
              default: 
                APUICommonMethod.g();
                paramjw = paramjw.S();
                APUICommonMethod.a(this.d, paramjw);
                APUICommonMethod.b();
                fm.a(i, paramjw);
                return;
              case 20101: 
                APLog.i("APBaseBuyPage", "toH5Pay");
                APDataReportManager.getInstance().insertData("sdk.httpserror.jumph5", ed.b().n().a.saveType);
                fp.a().b(true);
                paramjw = new Intent();
                if (hs.b(this.d)) {
                  paramjw.setClass(this.d, APX5WebJSBridgeActivity.class);
                } else {
                  paramjw.setClass(this.d, APWebJSBridgeActivity.class);
                }
                Bundle localBundle = new Bundle();
                localBundle.putString("pageName", hj.A);
                paramjw.putExtras(localBundle);
                this.d.startActivity(paramjw);
                return;
              }
              a(paramjw.R(), paramjw.T());
              return;
            case 1320: 
              APUICommonMethod.g();
              fp.a().b(true);
              paramjw = new Intent();
              fp.a().b("AndroidPay");
              paramjw.setClass(this.d, APRealnameRegistActivity.class);
              this.d.startActivity(paramjw);
              return;
            }
            APUICommonMethod.g();
            APUICommonMethod.b();
            fm.a(i, paramjw.S());
            return;
          }
          APDataReportManager.getInstance().insertData("sdk.buypage.appsign.invalid", ed.b().n().a.saveType);
          b(i, "应用签名校验失败，请联系米大师");
          return;
        }
        b(i, paramjw.S());
        return;
      }
      APUICommonMethod.g();
      a.a("登录过期，请重新登录", this.d);
      return;
    }
    fp.a().b(true);
    a(paramjw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ee
 * JD-Core Version:    0.7.0.1
 */