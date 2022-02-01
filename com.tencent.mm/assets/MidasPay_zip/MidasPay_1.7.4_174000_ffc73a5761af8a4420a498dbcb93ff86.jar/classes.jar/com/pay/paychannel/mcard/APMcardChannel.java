package com.pay.paychannel.mcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.pay.ui.channel.APMCardAccountSaveActivity;
import com.pay.ui.channel.APMCardAccountSaveSuccActivity;
import com.pay.ui.channel.APMCardSelectValueActivity;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import midas.x.by;
import midas.x.cg;
import midas.x.dt;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.ez;
import midas.x.fa;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fm;
import midas.x.fv;
import midas.x.fy;
import midas.x.hs;
import midas.x.hu;
import midas.x.i;
import midas.x.jd;
import midas.x.lh;
import midas.x.lw;

public class APMcardChannel
  extends ff
{
  public static String j = "";
  public static String k = "";
  public static String l = "";
  public static String m = "";
  public static String n = "";
  private final String A = "-1";
  private final String B = "999";
  private final String o = "1006";
  private final String p = "2";
  private final String q = "1101";
  private final String r = "1102";
  private final String s = "1103";
  private final String t = "1001";
  private final String u = "1002";
  private final String v = "1004";
  private final String w = "1010";
  private final String x = "1013";
  private final String y = "1015";
  private final String z = "1";
  
  private void a(Activity paramActivity, String paramString, cg paramcg, fm paramfm)
  {
    this.d = paramActivity;
    if ((!paramString.equals("1006")) && (!paramString.equals("2")))
    {
      if ((!paramString.equals("1101")) && (!paramString.equals("1102")))
      {
        if (paramString.equals("1103"))
        {
          if (paramfm != null) {
            paramfm.a(0, null);
          }
          em.b().n().d.h = paramcg.b();
          paramString = new Intent();
          paramString.putExtra("channel", 5);
          paramString.putExtra("mcardAccountBalance", paramcg.b());
          paramString.putExtra("mcardNeedDeposit", paramcg.e());
          paramString.putExtra("mcardAmt", paramcg.d());
          paramString.setClass(paramActivity, APMCardAccountSaveSuccActivity.class);
          paramActivity.startActivity(paramString);
          paramActivity.finish();
          APUICommonMethod.b(paramActivity);
          return;
        }
        if ((!paramString.equals("1001")) && (!paramString.equals("1002")) && (!paramString.equals("1004")) && (!paramString.equals("1010")) && (!paramString.equals("1013")) && (!paramString.equals("1015")) && (!paramString.equals("1")) && (!paramString.equals("-1")) && (!paramString.equals("999")))
        {
          b(paramActivity);
          if (paramfm != null) {
            paramfm.a(0, null);
          }
        }
        else if (paramfm != null)
        {
          paramfm.a(-1, null);
        }
      }
      else
      {
        paramString = new Bundle();
        if (paramcg.c() > 0)
        {
          paramString.putString("pageName", hu.v);
          paramString.putInt("mcardDepositBalance", paramcg.c());
        }
        if (paramfm != null) {
          paramfm.a(0, null);
        }
        a(paramString);
        paramActivity.finish();
        APUICommonMethod.b(paramActivity);
      }
    }
    else
    {
      if (paramfm != null) {
        paramfm.a(0, null);
      }
      a(null);
      paramActivity.finish();
      APUICommonMethod.b(paramActivity);
    }
  }
  
  private void a(dt paramdt)
  {
    if ("APVmallBuyActivity".equals(fy.a().g())) {
      hs.a();
    }
    if ("mcard".endsWith(paramdt.K()))
    {
      paramdt = paramdt.f();
      em.b().n().e.n = paramdt;
      h();
      return;
    }
    paramdt = new Bundle();
    int i = em.b().n().d.h;
    if (i >= 0) {
      paramdt.putString("mcardAccountBalance", APTools.a(i));
    }
    a(paramdt);
  }
  
  private void b(Activity paramActivity)
  {
    a(paramActivity, 240000, "", this.g);
    paramActivity.finish();
    APUICommonMethod.b(paramActivity);
  }
  
  private boolean g()
  {
    el localel = em.b().n();
    int i = APTools.g(localel.b.a());
    return localel.d.h >= i;
  }
  
  private void h()
  {
    Intent localIntent = new Intent(this.d, APPayProgressActivity.class);
    localIntent.putExtra("channel", 5);
    this.d.startActivity(localIntent);
    ((Activity)this.d).finish();
    APUICommonMethod.b((Activity)this.d);
  }
  
  public void a(Activity paramActivity)
  {
    a(paramActivity, 5);
    paramActivity.finish();
    APUICommonMethod.b(paramActivity);
  }
  
  public void a(final Activity paramActivity, final fm paramfm)
  {
    String str = em.b().n().e.n;
    by.a().c(str, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        cg localcg = (cg)paramAnonymouslh;
        if (localcg.T() == 0) {
          paramAnonymouslh = i.a(localcg.a());
        } else {
          paramAnonymouslh = "-1";
        }
        APMcardChannel.a(APMcardChannel.this, paramActivity, paramAnonymouslh, localcg, paramfm);
      }
      
      public void b(lh paramAnonymouslh)
      {
        if (paramfm != null) {
          paramfm.a(-1, null);
        }
      }
      
      public void c(lh paramAnonymouslh) {}
    });
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    if (jd.c.size() > 0) {
      try
      {
        ((APRecoChannelActivity)paramContext).a(1, 2, paramBundle);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localIntent = new Intent(paramContext, APRecoChannelActivity.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
        paramContext.startActivity(localIntent);
        return;
      }
    }
    Intent localIntent = new Intent(paramContext, APRecoChannelActivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void b(Context paramContext, dt paramdt)
  {
    int i = paramdt.T();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APMcardChannel", ((StringBuilder)localObject).toString());
    if (i != 1413)
    {
      j = "";
      k = "";
      l = "";
    }
    if (i != 0)
    {
      if (i != 1023)
      {
        if (i != 1413)
        {
          if (em.b().n().a.saveType == 1)
          {
            a(i, paramdt.U(), true);
          }
          else
          {
            boolean bool2 = false;
            APLog.i("APMcardChannel", "");
            boolean bool1 = bool2;
            if ((paramContext instanceof APMCardAccountSaveSuccActivity))
            {
              APLog.i("APMcardChannel", "context instanceof APMCardAccountSaveSuccActivity");
              localObject = paramdt.U();
              APLog.i("APMcardChannel", (String)localObject);
              bool1 = bool2;
              if (localObject != null)
              {
                localObject = ((String)localObject).substring(((String)localObject).indexOf("(") + 1, ((String)localObject).indexOf(")"));
                APLog.i("APMcardChannel", (String)localObject);
                bool1 = bool2;
                if ("1003-7112-35105".equals(localObject)) {
                  bool1 = true;
                }
              }
            }
            a(i, paramdt.U(), bool1);
          }
          if ((paramContext instanceof APMCardSelectValueActivity))
          {
            APLog.i("APMcardChannel", "progressChannelSaveAns context is APMCardSelectValueActivity");
            if (i == 100007)
            {
              paramContext = (Activity)paramContext;
              paramContext.finish();
              APUICommonMethod.b(paramContext);
            }
          }
        }
        else
        {
          paramdt = new Intent();
          paramdt.setClass(paramContext, APMCardSelectValueActivity.class);
          paramContext.startActivity(paramdt);
        }
      }
      else
      {
        APUICommonMethod.b();
        fv.a(i, "订单失效");
      }
    }
    else {
      a(paramdt);
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.f = paramfd;
    this.g = paramfe;
    if (fy.a().A())
    {
      if (g())
      {
        a(paramContext, paramfe, paramfd);
        return;
      }
      paramfe.a(0);
      paramBundle = new Intent();
      paramBundle.setClass(paramContext, APMCardAccountSaveActivity.class);
      paramContext.startActivity(paramBundle);
      return;
    }
    paramfe.a(0);
    paramBundle = new Intent();
    paramBundle.setClass(paramContext, APMCardAccountSaveActivity.class);
    paramContext.startActivity(paramBundle);
  }
  
  public void d(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.f = paramfd;
    this.g = paramfe;
    b(paramContext, paramBundle);
  }
  
  public boolean f()
  {
    if (fy.a().A()) {
      return g();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.mcard.APMcardChannel
 * JD-Core Version:    0.7.0.1
 */