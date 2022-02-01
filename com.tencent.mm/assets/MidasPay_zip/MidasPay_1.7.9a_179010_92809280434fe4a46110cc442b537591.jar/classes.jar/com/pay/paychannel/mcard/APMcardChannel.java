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
import midas.x.c5;
import midas.x.c6;
import midas.x.d5;
import midas.x.fc;
import midas.x.g5;
import midas.x.h2;
import midas.x.h5;
import midas.x.i;
import midas.x.i5;
import midas.x.j9;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.p5;
import midas.x.w3;
import midas.x.w4;
import midas.x.w7;
import midas.x.y7;
import midas.x.z1;
import midas.x.z5;

public class APMcardChannel
  extends i5
{
  public static String o = "";
  public static String p = "";
  public static String q = "";
  public static String r = "";
  public static String s = "";
  
  public final void a(Activity paramActivity)
  {
    a(paramActivity, 240000, "", this.f);
    paramActivity.finish();
    APUICommonMethod.a(paramActivity);
  }
  
  public final void a(Activity paramActivity, String paramString, h2 paramh2, p5 paramp5)
  {
    this.c = paramActivity;
    if ((!paramString.equals("1006")) && (!paramString.equals("2")))
    {
      if ((!paramString.equals("1101")) && (!paramString.equals("1102")))
      {
        if (paramString.equals("1103"))
        {
          if (paramp5 != null) {
            paramp5.a(0, null);
          }
          p4.p().e().e.h = paramh2.g();
          paramString = new Intent();
          paramString.putExtra("channel", 5);
          paramString.putExtra("mcardAccountBalance", paramh2.g());
          paramString.putExtra("mcardNeedDeposit", paramh2.j());
          paramString.putExtra("mcardAmt", paramh2.h());
          paramString.setClass(paramActivity, APMCardAccountSaveSuccActivity.class);
          paramActivity.startActivity(paramString);
          paramActivity.finish();
          APUICommonMethod.a(paramActivity);
          return;
        }
        if ((!paramString.equals("1001")) && (!paramString.equals("1002")) && (!paramString.equals("1004")) && (!paramString.equals("1010")) && (!paramString.equals("1013")) && (!paramString.equals("1015")) && (!paramString.equals("1")) && (!paramString.equals("-1")) && (!paramString.equals("999")))
        {
          a(paramActivity);
          if (paramp5 != null) {
            paramp5.a(0, null);
          }
        }
        else if (paramp5 != null)
        {
          paramp5.a(-1, null);
        }
      }
      else
      {
        paramString = new Bundle();
        if (paramh2.i() > 0)
        {
          paramString.putString("pageName", y7.t);
          paramString.putInt("mcardDepositBalance", paramh2.i());
        }
        if (paramp5 != null) {
          paramp5.a(0, null);
        }
        a(paramString);
        paramActivity.finish();
        APUICommonMethod.a(paramActivity);
      }
    }
    else
    {
      if (paramp5 != null) {
        paramp5.a(0, null);
      }
      a(null);
      paramActivity.finish();
      APUICommonMethod.a(paramActivity);
    }
  }
  
  public void a(final Activity paramActivity, final p5 paramp5)
  {
    String str = p4.p().e().f.m;
    z1.d().g(str, new a(paramActivity, paramp5));
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (j9.b.size() > 0) {
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
  
  public void a(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    if (c6.s0().U())
    {
      if (i())
      {
        a(paramContext, paramh5, paramg5);
        return;
      }
      paramh5.a(0);
      paramBundle = new Intent();
      paramBundle.setClass(paramContext, APMCardAccountSaveActivity.class);
      paramContext.startActivity(paramBundle);
      return;
    }
    paramh5.a(0);
    paramBundle = new Intent();
    paramBundle.setClass(paramContext, APMCardAccountSaveActivity.class);
    paramContext.startActivity(paramBundle);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    int i = paramw3.d();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret:");
    ((StringBuilder)localObject).append(i);
    APLog.i("APMcardChannel", ((StringBuilder)localObject).toString());
    if (i != 1413)
    {
      o = "";
      p = "";
      q = "";
    }
    if (i != 0)
    {
      if (i != 1023)
      {
        if (i != 1413)
        {
          if (p4.p().e().b.saveType == 1)
          {
            a(i, paramw3.f(), true);
          }
          else
          {
            boolean bool2 = false;
            APLog.i("APMcardChannel", "");
            boolean bool1 = bool2;
            if ((paramContext instanceof APMCardAccountSaveSuccActivity))
            {
              APLog.i("APMcardChannel", "context instanceof APMCardAccountSaveSuccActivity");
              localObject = paramw3.f();
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
            a(i, paramw3.f(), bool1);
          }
          if ((paramContext instanceof APMCardSelectValueActivity))
          {
            APLog.i("APMcardChannel", "progressChannelSaveAns context is APMCardSelectValueActivity");
            if (i == 100007)
            {
              paramContext = (Activity)paramContext;
              paramContext.finish();
              APUICommonMethod.a(paramContext);
            }
          }
        }
        else
        {
          paramw3 = new Intent();
          paramw3.setClass(paramContext, APMCardSelectValueActivity.class);
          paramContext.startActivity(paramw3);
        }
      }
      else
      {
        APUICommonMethod.f();
        z5.a(i, "订单失效");
      }
    }
    else {
      a(paramw3);
    }
  }
  
  public final void a(w3 paramw3)
  {
    if ("APVmallBuyActivity".equals(c6.s0().Q())) {
      w7.a();
    }
    if ("mcard".endsWith(paramw3.w()))
    {
      paramw3 = paramw3.x();
      p4.p().e().f.m = paramw3;
      h();
      return;
    }
    paramw3 = new Bundle();
    int i = p4.p().e().e.h;
    if (i >= 0) {
      paramw3.putString("mcardAccountBalance", APTools.b(i));
    }
    a(paramw3);
  }
  
  public void b(Activity paramActivity)
  {
    a(paramActivity, 5);
    paramActivity.finish();
    APUICommonMethod.a(paramActivity);
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public final void h()
  {
    Intent localIntent = new Intent(this.c, APPayProgressActivity.class);
    localIntent.putExtra("channel", 5);
    this.c.startActivity(localIntent);
    ((Activity)this.c).finish();
    APUICommonMethod.a((Activity)this.c);
  }
  
  public final boolean i()
  {
    o4 localo4 = p4.p().e();
    int i = APTools.p(localo4.c.a());
    return localo4.e.h >= i;
  }
  
  public boolean j()
  {
    if (c6.s0().U()) {
      return i();
    }
    return false;
  }
  
  public class a
    implements fc
  {
    public a(Activity paramActivity, p5 paramp5) {}
    
    public void a(ob paramob)
    {
      h2 localh2 = (h2)paramob;
      if (localh2.d() == 0) {
        paramob = i.a(localh2.k());
      } else {
        paramob = "-1";
      }
      APMcardChannel.a(APMcardChannel.this, paramActivity, paramob, localh2, paramp5);
    }
    
    public void b(ob paramob)
    {
      paramob = paramp5;
      if (paramob != null) {
        paramob.a(-1, null);
      }
    }
    
    public void c(ob paramob) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.mcard.APMcardChannel
 * JD-Core Version:    0.7.0.1
 */