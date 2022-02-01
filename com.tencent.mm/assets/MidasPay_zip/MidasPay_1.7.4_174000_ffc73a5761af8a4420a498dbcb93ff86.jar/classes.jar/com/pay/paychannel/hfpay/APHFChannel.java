package com.pay.paychannel.hfpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.channel.APHFInputActivity;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import midas.x.by;
import midas.x.dt;
import midas.x.ed;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.ev;
import midas.x.fa;
import midas.x.fb;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fh;
import midas.x.fi;
import midas.x.fk;
import midas.x.fl;
import midas.x.fv;
import midas.x.go;
import midas.x.i;
import midas.x.jd;
import midas.x.lh;
import midas.x.lw;
import midas.x.o;

public class APHFChannel
  extends ff
{
  public static int B = 0;
  public static int C = 1;
  public static int D = 2;
  public static int E = 4;
  public static int F = 8;
  private static HashMap<String, APHFChannel> G = new HashMap();
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public int A;
  protected el z;
  
  public static APHFChannel a(Integer paramInteger, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = (APHFChannel)G.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if (paramInteger.intValue() == C)
    {
      paramInteger = new APHFRequest();
    }
    else if (paramInteger.intValue() == D)
    {
      paramInteger = new APHFWeb(paramString);
    }
    else if (paramInteger.intValue() == E)
    {
      localObject = fh.c(paramString);
      if (localObject == null)
      {
        paramString = new StringBuilder();
        paramString.append("channelType error = ");
        paramString.append(paramInteger);
        APLog.e("getSubChannel", paramString.toString());
        return null;
      }
      paramInteger = (Integer)localObject;
    }
    else
    {
      if (paramInteger.intValue() != F) {
        break label154;
      }
      paramInteger = new APHFSend();
    }
    G.put(paramString, paramInteger);
    return paramInteger;
    label154:
    return null;
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    a(paramActivity, 250001, paramString, this.g);
  }
  
  private void a(Activity paramActivity, ed paramed, fl paramfl)
  {
    this.d = paramActivity;
    String str = paramed.a();
    int i = paramed.T();
    paramed.c();
    paramed = paramed.b();
    if (i == 0)
    {
      if (str.endsWith("succeed"))
      {
        a(null);
        if (paramfl != null) {
          paramfl.a(0, null);
        }
      }
      else if (str.endsWith("failed"))
      {
        a(paramActivity, paramed);
        if (paramfl != null) {
          paramfl.a(0, null);
        }
      }
      else if (((str.equals("delay")) || (str.equals("delayfinal"))) && (paramfl != null))
      {
        paramfl.a(-1, null);
      }
    }
    else
    {
      a(paramActivity, paramed);
      if (paramfl != null) {
        paramfl.a(0, null);
      }
    }
  }
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    fk.a();
    Iterator localIterator1 = fk.b().iterator();
    Object localObject;
    while (localIterator1.hasNext())
    {
      localObject = (fi)localIterator1.next();
      ((fi)localObject).g = "";
      ((fi)localObject).h = "";
    }
    paramString = paramString.split("#");
    int i1 = paramString.length;
    int i = 0;
    while (i < i1)
    {
      localIterator1 = paramString[i];
      localObject = (String)APTools.c(localIterator1).get("channel");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        fk.a();
        Iterator localIterator2 = fk.b().iterator();
        while (localIterator2.hasNext())
        {
          fi localfi = (fi)localIterator2.next();
          if (((String)localObject).equals(localfi.c)) {
            localfi.g = localIterator1;
          }
        }
      }
      i += 1;
    }
  }
  
  public static void f()
  {
    j = "";
    y = "";
    p = "";
  }
  
  public void a(Activity paramActivity)
  {
    a(paramActivity, 9);
  }
  
  public void a(final Activity paramActivity, final fl paramfl)
  {
    String str = em.b().n().e.n;
    by.a().d(str, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        paramAnonymouslh = (ed)paramAnonymouslh;
        APHFChannel.a(APHFChannel.this, paramActivity, paramAnonymouslh, paramfl);
      }
      
      public void b(lh paramAnonymouslh)
      {
        if (paramfl != null) {
          paramfl.a(-1, null);
        }
      }
      
      public void c(lh paramAnonymouslh) {}
    });
  }
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, APPayProgressActivity.class);
    localIntent.putExtra("channel", 9);
    paramContext.startActivity(localIntent);
    ((Activity)paramContext).finish();
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    this.d = paramContext;
    APLog.i("APHFChannel", "gotoRecChannel main");
    int i;
    if (!g())
    {
      em.b().n().e.j = "";
      i = 1;
    }
    else
    {
      i = 2;
    }
    if (jd.c.size() > 0) {
      try
      {
        ((APRecoChannelActivity)paramContext).a(1, i, paramBundle);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localIntent = new Intent(paramContext, APRecoChannelActivity.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
        localIntent.putExtra("to", 1);
        paramContext.startActivity(localIntent);
        return;
      }
    }
    Intent localIntent = new Intent(paramContext, APRecoChannelActivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("to", i);
    paramContext.startActivity(localIntent);
  }
  
  public void b(Context paramContext, dt paramdt)
  {
    this.d = paramContext;
    int i = paramdt.T();
    if (this.g != null) {
      this.g.a(0);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", saveCallBack=");
    ((StringBuilder)localObject).append(this.f);
    APLog.i("APHFChannel", ((StringBuilder)localObject).toString());
    if (i == 0)
    {
      i = paramdt.Q();
      j = paramdt.J();
      q = paramdt.B();
      r = paramdt.C();
      s = paramdt.z();
      t = paramdt.A();
      u = paramdt.D();
      p = paramdt.E();
      v = paramdt.F();
      w = paramdt.G();
      x = paramdt.L();
      y = paramdt.M();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("progressChannelSaveAns ret == 0, hfInterfaceType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", subChannelId = ");
      ((StringBuilder)localObject).append(j);
      APLog.i("APHFChannel", ((StringBuilder)localObject).toString());
      localObject = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hfsubid=");
      localStringBuilder.append(j);
      localStringBuilder.append("&hfinterfacetype=");
      localStringBuilder.append(i);
      ((APDataReportManager)localObject).a("sdk.channel.children", localStringBuilder.toString());
      localObject = a(Integer.valueOf(i), j);
      if (localObject != null)
      {
        ((APHFChannel)localObject).b(paramContext, paramdt);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("progressChannelSaveAns subId=");
      paramContext.append(j);
      paramContext.append(" is not isSupportedChannelId");
      APLog.w("APHFChannel", paramContext.toString());
      if (this.f == null)
      {
        paramContext = new StringBuilder();
        paramContext.append("渠道信息错误，请稍后再试！(107-1001-");
        paramContext.append(j);
        paramContext.append(")");
        a(-99001, paramContext.toString(), false);
        return;
      }
      paramContext = new Bundle();
      paramdt = new StringBuilder();
      paramdt.append("渠道信息错误，请稍后再试！(107-1001-");
      paramdt.append(j);
      paramdt.append(")");
      paramContext.putString("errMsg", paramdt.toString());
      this.f.a(-99001, paramContext);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("progressChannelSaveAns ret == ");
    paramContext.append(i);
    APLog.i("APHFChannel", paramContext.toString());
    if (i != 1023)
    {
      paramContext = new StringBuilder();
      paramContext.append("progressChannelSaveAns saveCallBack=");
      paramContext.append(this.f);
      APLog.d("APHFChanel", paramContext.toString());
      localObject = paramdt.U();
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty(paramdt.P()))
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject);
        paramContext.append("(107-1003-");
        paramContext.append(i);
        paramContext.append(")");
        paramContext = paramContext.toString();
      }
      paramdt = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = new StringBuilder();
        paramContext.append("系统错误，请稍后再试！(107-1002-");
        paramContext.append(i);
        paramContext.append(")");
        paramdt = paramContext.toString();
      }
      if (this.f == null)
      {
        a(i, paramdt, false);
        return;
      }
      paramContext = new Bundle();
      paramContext.putString("errMsg", paramdt);
      this.f.a(i, paramContext);
      return;
    }
    APUICommonMethod.b();
    fv.a(i, "订单失效");
  }
  
  public void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.d = paramContext;
    this.g = paramfe;
    this.f = paramfd;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getString("fromView");
    }
    if ("channelList".equals(paramBundle))
    {
      if (paramfe != null) {
        paramfe.a(0);
      }
      paramBundle = new Intent();
      paramBundle.setClass(paramContext, APHFInputActivity.class);
      paramContext.startActivity(paramBundle);
      return;
    }
    if (!g())
    {
      if (paramfe != null) {
        paramfe.a(0);
      }
      APDataReportManager.getInstance().insertData("sdk.hf.nosupport.dialog.show", this.A, null, null, null);
      a(250003, h(), false);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("entryChannelPay main, subChannelId=");
    paramBundle.append(j);
    APLog.i("APHFChannel", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("entryChannelPay main, recoChannel=");
    paramBundle.append(APRecoChannelActivity.a);
    APLog.i("APHFChannel", paramBundle.toString());
    fb.a().a(paramContext, "hfpay", paramfe, paramfd);
  }
  
  public void d(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.d = paramContext;
    this.f = paramfd;
    this.g = paramfe;
    b(paramContext, paramBundle);
  }
  
  public boolean g()
  {
    label22:
    label340:
    label363:
    try
    {
      i = Integer.valueOf(em.b().n().e.g).intValue();
    }
    catch (Exception localException1)
    {
      label255:
      break label22;
    }
    i = 0;
    i1 = em.b().n().a.saveType;
    if (i1 == 0) {}
    try
    {
      if (!TextUtils.isEmpty(o)) {
        i1 = i.a(o);
      } else {
        i1 = i.a(em.b().n().b.e);
      }
      if (i1 != 0) {
        i1 = i * 100 / i1;
      } else {
        i1 = 0;
      }
      i = i1;
    }
    catch (Exception localException2)
    {
      Object localObject;
      int i2;
      break label255;
    }
    try
    {
      if (!o.a().b()) {
        break label257;
      }
      i = i1;
      if (!o.a().c()) {
        break label257;
      }
      i = i1;
      if (!o.a().o()) {
        break label257;
      }
      i = i1;
      if (!o.a().d()) {
        break label257;
      }
      i = o.a().a(i1);
      i = i1 - i;
    }
    catch (Exception localException3)
    {
      i = i1;
      break label257;
    }
    if (i1 == 1)
    {
      localObject = (ev)em.b().n().b;
      if (((ev)localObject).f.length() != 0)
      {
        i *= Integer.valueOf(((ev)localObject).f).intValue();
      }
      else
      {
        i1 = Integer.valueOf(((ev)localObject).e).intValue();
        i *= i1;
      }
    }
    else if (i1 == 2)
    {
      i *= 10;
    }
    else if (i1 == 3)
    {
      i *= 100;
    }
    else
    {
      if (i1 == 4) {
        break label363;
      }
      if (i1 == 5) {
        return true;
      }
      i = 0;
    }
    label257:
    new StringBuffer();
    i2 = go.a().c().size();
    localObject = new ArrayList();
    ((ArrayList)localObject).clear();
    i1 = 0;
    while (i1 < i2)
    {
      String str = (String)go.a().c().get(i1);
      try
      {
        int i3 = Integer.valueOf(str).intValue() / 100;
        if (i3 != 0) {
          ((ArrayList)localObject).add(Integer.valueOf(i3));
        }
      }
      catch (Exception localException4)
      {
        break label340;
      }
      if (str.equals(String.valueOf(i))) {
        return true;
      }
      i1 += 1;
    }
    return false;
    return true;
  }
  
  public String h()
  {
    Object localObject1 = new StringBuffer();
    int i1 = go.a().c().size();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).clear();
    int i = 0;
    while (i < i1)
    {
      String str = (String)go.a().c().get(i);
      try
      {
        i2 = Integer.valueOf(str).intValue() / 100;
        if (i2 != 0) {
          ((ArrayList)localObject2).add(Integer.valueOf(i2));
        }
      }
      catch (Exception localException)
      {
        int i2;
        label81:
        break label81;
      }
      i += 1;
    }
    Collections.sort((List)localObject2);
    i = 0;
    while (i < ((ArrayList)localObject2).size())
    {
      i2 = ((Integer)((ArrayList)localObject2).get(i)).intValue();
      if (i > 0) {
        i1 = ((Integer)((ArrayList)localObject2).get(i - 1)).intValue();
      } else {
        i1 = 0;
      }
      if (i2 != i1)
      {
        ((StringBuffer)localObject1).append(i2);
        ((StringBuffer)localObject1).append("，");
      }
      i += 1;
    }
    if (((StringBuffer)localObject1).length() > 0) {
      ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
    }
    localObject1 = ((StringBuffer)localObject1).toString();
    if ((localObject1 != null) && (!((String)localObject1).equals("")))
    {
      localObject2 = go.a().d();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("话费支付仅支持以下金额(元):\n");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("。");
        return ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("话费支付仅支持以下金额(元):\n");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("。");
      return ((StringBuilder)localObject2).toString();
    }
    return "当前金额暂时不支持话费支付";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFChannel
 * JD-Core Version:    0.7.0.1
 */