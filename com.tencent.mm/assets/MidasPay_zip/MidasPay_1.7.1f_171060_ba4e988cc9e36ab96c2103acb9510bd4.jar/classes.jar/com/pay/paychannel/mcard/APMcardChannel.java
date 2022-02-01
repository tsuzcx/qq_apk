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
import midas.x.bs;
import midas.x.ca;
import midas.x.dl;
import midas.x.ec;
import midas.x.ed;
import midas.x.ek;
import midas.x.eq;
import midas.x.er;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.fd;
import midas.x.fm;
import midas.x.fp;
import midas.x.hh;
import midas.x.hj;
import midas.x.i;
import midas.x.is;
import midas.x.jw;
import midas.x.kl;

public class APMcardChannel
  extends ew
{
  public static String i = "";
  public static String j = "";
  public static String k = "";
  public static String l = "";
  public static String m = "";
  private final String A = "999";
  private final String n = "1006";
  private final String o = "2";
  private final String p = "1101";
  private final String q = "1102";
  private final String r = "1103";
  private final String s = "1001";
  private final String t = "1002";
  private final String u = "1004";
  private final String v = "1010";
  private final String w = "1013";
  private final String x = "1015";
  private final String y = "1";
  private final String z = "-1";
  
  private void a(Activity paramActivity, String paramString, ca paramca, fd paramfd)
  {
    this.d = paramActivity;
    if ((!paramString.equals("1006")) && (!paramString.equals("2")))
    {
      if ((!paramString.equals("1101")) && (!paramString.equals("1102")))
      {
        if (paramString.equals("1103"))
        {
          if (paramfd != null) {
            paramfd.a(0, null);
          }
          ed.b().n().d.h = paramca.b();
          paramString = new Intent();
          paramString.putExtra("channel", 5);
          paramString.putExtra("mcardAccountBalance", paramca.b());
          paramString.putExtra("mcardNeedDeposit", paramca.e());
          paramString.putExtra("mcardAmt", paramca.d());
          paramString.setClass(paramActivity, APMCardAccountSaveSuccActivity.class);
          paramActivity.startActivity(paramString);
          paramActivity.finish();
          APUICommonMethod.b(paramActivity);
          return;
        }
        if ((!paramString.equals("1001")) && (!paramString.equals("1002")) && (!paramString.equals("1004")) && (!paramString.equals("1010")) && (!paramString.equals("1013")) && (!paramString.equals("1015")) && (!paramString.equals("1")) && (!paramString.equals("-1")) && (!paramString.equals("999")))
        {
          b(paramActivity);
          if (paramfd != null) {
            paramfd.a(0, null);
          }
        }
        else if (paramfd != null)
        {
          paramfd.a(-1, null);
        }
      }
      else
      {
        paramString = new Bundle();
        if (paramca.c() > 0)
        {
          paramString.putString("pageName", hj.v);
          paramString.putInt("mcardDepositBalance", paramca.c());
        }
        if (paramfd != null) {
          paramfd.a(0, null);
        }
        a(paramString);
        paramActivity.finish();
        APUICommonMethod.b(paramActivity);
      }
    }
    else
    {
      if (paramfd != null) {
        paramfd.a(0, null);
      }
      a(null);
      paramActivity.finish();
      APUICommonMethod.b(paramActivity);
    }
  }
  
  private void a(dl paramdl)
  {
    if ("APVmallBuyActivity".equals(fp.a().g())) {
      hh.a();
    }
    if ("mcard".endsWith(paramdl.J()))
    {
      paramdl = paramdl.d();
      ed.b().n().e.n = paramdl;
      h();
      return;
    }
    paramdl = new Bundle();
    int i1 = ed.b().n().d.h;
    if (i1 >= 0) {
      paramdl.putString("mcardAccountBalance", APTools.a(i1));
    }
    a(paramdl);
  }
  
  private void b(Activity paramActivity)
  {
    a(paramActivity, 240000, "", this.g);
    paramActivity.finish();
    APUICommonMethod.b(paramActivity);
  }
  
  private boolean g()
  {
    ec localec = ed.b().n();
    int i1 = APTools.g(localec.b.a());
    return localec.d.h >= i1;
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
  
  public void a(final Activity paramActivity, final fd paramfd)
  {
    String str = ed.b().n().e.n;
    bs.a().c(str, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        ca localca = (ca)paramAnonymousjw;
        if (localca.R() == 0) {
          paramAnonymousjw = i.a(localca.a());
        } else {
          paramAnonymousjw = "-1";
        }
        APMcardChannel.a(APMcardChannel.this, paramActivity, paramAnonymousjw, localca, paramfd);
      }
      
      public void b(jw paramAnonymousjw)
      {
        if (paramfd != null) {
          paramfd.a(-1, null);
        }
      }
      
      public void c(jw paramAnonymousjw) {}
    });
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    if (is.c.size() > 0) {
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
  
  public void b(Context paramContext, dl paramdl)
  {
    int i1 = paramdl.R();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i1);
    APLog.i("APMcardChannel", ((StringBuilder)localObject).toString());
    if (i1 != 1413)
    {
      i = "";
      j = "";
      k = "";
    }
    if (i1 != 0)
    {
      if (i1 != 1023)
      {
        if (i1 != 1413)
        {
          if (ed.b().n().a.saveType == 1)
          {
            a(i1, paramdl.S(), true);
          }
          else
          {
            boolean bool2 = false;
            APLog.i("APMcardChannel", "");
            boolean bool1 = bool2;
            if ((paramContext instanceof APMCardAccountSaveSuccActivity))
            {
              APLog.i("APMcardChannel", "context instanceof APMCardAccountSaveSuccActivity");
              localObject = paramdl.S();
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
            a(i1, paramdl.S(), bool1);
          }
          if ((paramContext instanceof APMCardSelectValueActivity))
          {
            APLog.i("APMcardChannel", "progressChannelSaveAns context is APMCardSelectValueActivity");
            if (i1 == 100007)
            {
              paramContext = (Activity)paramContext;
              paramContext.finish();
              APUICommonMethod.b(paramContext);
            }
          }
        }
        else
        {
          paramdl = new Intent();
          paramdl.setClass(paramContext, APMCardSelectValueActivity.class);
          paramContext.startActivity(paramdl);
        }
      }
      else
      {
        APUICommonMethod.b();
        fm.a(i1, "订单失效");
      }
    }
    else {
      a(paramdl);
    }
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    if (fp.a().A())
    {
      if (g())
      {
        a(paramContext, paramev, parameu);
        return;
      }
      paramev.a(0);
      paramBundle = new Intent();
      paramBundle.setClass(paramContext, APMCardAccountSaveActivity.class);
      paramContext.startActivity(paramBundle);
      return;
    }
    paramev.a(0);
    paramBundle = new Intent();
    paramBundle.setClass(paramContext, APMCardAccountSaveActivity.class);
    paramContext.startActivity(paramBundle);
  }
  
  public void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.f = parameu;
    this.g = paramev;
    b(paramContext, paramBundle);
  }
  
  public boolean f()
  {
    if (fp.a().A()) {
      return g();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.mcard.APMcardChannel
 * JD-Core Version:    0.7.0.1
 */