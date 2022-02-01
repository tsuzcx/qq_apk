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
import midas.x.bs;
import midas.x.dl;
import midas.x.dv;
import midas.x.ec;
import midas.x.ed;
import midas.x.ek;
import midas.x.em;
import midas.x.er;
import midas.x.es;
import midas.x.eu;
import midas.x.ev;
import midas.x.ew;
import midas.x.ey;
import midas.x.ez;
import midas.x.fb;
import midas.x.fc;
import midas.x.fm;
import midas.x.ge;
import midas.x.i;
import midas.x.is;
import midas.x.jw;
import midas.x.kl;
import midas.x.o;

public class APHFChannel
  extends ew
{
  private static HashMap<String, APHFChannel> B = new HashMap();
  public static String i;
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
  protected ec z;
  
  private void a(Activity paramActivity, String paramString)
  {
    a(paramActivity, 250001, paramString, this.g);
  }
  
  private void a(Activity paramActivity, dv paramdv, fc paramfc)
  {
    this.d = paramActivity;
    String str = paramdv.a();
    int i1 = paramdv.R();
    paramdv.c();
    paramdv = paramdv.b();
    if (i1 == 0)
    {
      if (str.endsWith("succeed"))
      {
        a(null);
        if (paramfc != null) {
          paramfc.a(0, null);
        }
      }
      else if (str.endsWith("failed"))
      {
        a(paramActivity, paramdv);
        if (paramfc != null) {
          paramfc.a(0, null);
        }
      }
      else if (((str.equals("delay")) || (str.equals("delayfinal"))) && (paramfc != null))
      {
        paramfc.a(-1, null);
      }
    }
    else
    {
      a(paramActivity, paramdv);
      if (paramfc != null) {
        paramfc.a(0, null);
      }
    }
  }
  
  public static APHFChannel b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = (APHFChannel)B.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if (fb.f(paramString))
    {
      localObject = new APHFSend();
    }
    else if (fb.g(paramString))
    {
      localObject = new APHFRequest();
    }
    else if (fb.h(paramString))
    {
      localObject = new APHFWeb(paramString);
    }
    else if (fb.i(paramString))
    {
      localObject = new APHFWeb(paramString);
    }
    else
    {
      ey localey = ey.d(paramString);
      localObject = localey;
      if (localey == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("subChannelId error = ");
        ((StringBuilder)localObject).append(paramString);
        APLog.e("getSubChannel", ((StringBuilder)localObject).toString());
        return null;
      }
    }
    B.put(paramString, localObject);
    return localObject;
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    fb.a();
    Iterator localIterator1 = fb.b().iterator();
    Object localObject;
    while (localIterator1.hasNext())
    {
      localObject = (ez)localIterator1.next();
      ((ez)localObject).g = "";
      ((ez)localObject).h = "";
    }
    paramString = paramString.split("#");
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localIterator1 = paramString[i1];
      localObject = (String)APTools.c(localIterator1).get("channel");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        fb.a();
        Iterator localIterator2 = fb.b().iterator();
        while (localIterator2.hasNext())
        {
          ez localez = (ez)localIterator2.next();
          if (((String)localObject).equals(localez.c)) {
            localez.g = localIterator1;
          }
        }
      }
      i1 += 1;
    }
  }
  
  public static void f()
  {
    i = "";
    y = "";
    o = "";
  }
  
  public void a(Activity paramActivity)
  {
    a(paramActivity, 9);
  }
  
  public void a(final Activity paramActivity, final fc paramfc)
  {
    String str = ed.b().n().e.n;
    bs.a().d(str, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        paramAnonymousjw = (dv)paramAnonymousjw;
        APHFChannel.a(APHFChannel.this, paramActivity, paramAnonymousjw, paramfc);
      }
      
      public void b(jw paramAnonymousjw)
      {
        if (paramfc != null) {
          paramfc.a(-1, null);
        }
      }
      
      public void c(jw paramAnonymousjw) {}
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
    int i1;
    if (!g())
    {
      ed.b().n().e.j = "";
      i1 = 1;
    }
    else
    {
      i1 = 2;
    }
    if (is.c.size() > 0) {
      try
      {
        ((APRecoChannelActivity)paramContext).a(1, i1, paramBundle);
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
    localIntent.putExtra("to", i1);
    paramContext.startActivity(localIntent);
  }
  
  public void b(Context paramContext, dl paramdl)
  {
    this.d = paramContext;
    int i1 = paramdl.R();
    if (this.g != null) {
      this.g.a(0);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("progressChannelSaveAns ret=");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append(", saveCallBack=");
    ((StringBuilder)localObject1).append(this.f);
    APLog.i("APHFChannel", ((StringBuilder)localObject1).toString());
    if (i1 == 0)
    {
      if (paramdl.L() == 1) {
        localObject1 = "0020";
      } else {
        localObject1 = paramdl.I();
      }
      Object localObject2 = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hfsubid=");
      localStringBuilder.append((String)localObject1);
      ((APDataReportManager)localObject2).a("sdk.channel.children", localStringBuilder.toString());
      if (!fb.c((String)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("progressChannelSaveAns subId=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" is not isIdentifiedChannelId");
        APLog.w("APHFChannel", ((StringBuilder)localObject2).toString());
        localObject2 = "0010";
      }
      else
      {
        localObject2 = localObject1;
        if (!fb.d((String)localObject1))
        {
          paramContext = new StringBuilder();
          paramContext.append("progressChannelSaveAns subId=");
          paramContext.append((String)localObject1);
          paramContext.append(" is not isSupportedChannelId");
          APLog.w("APHFChannel", paramContext.toString());
          if (this.f == null)
          {
            paramContext = new StringBuilder();
            paramContext.append("渠道信息错误，请稍后再试！(107-1001-");
            paramContext.append((String)localObject1);
            paramContext.append(")");
            a(-99001, paramContext.toString(), false);
            return;
          }
          paramContext = new Bundle();
          paramdl = new StringBuilder();
          paramdl.append("渠道信息错误，请稍后再试！(107-1001-");
          paramdl.append((String)localObject1);
          paramdl.append(")");
          paramContext.putString("errMsg", paramdl.toString());
          this.f.a(-99001, paramContext);
          return;
        }
      }
      i = (String)localObject2;
      p = paramdl.z();
      q = paramdl.A();
      r = paramdl.x();
      s = paramdl.y();
      t = paramdl.B();
      o = paramdl.C();
      u = paramdl.D();
      v = paramdl.E();
      w = paramdl.F();
      x = paramdl.K();
      y = paramdl.M();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("progressChannelSaveAns ret == 0, subChannelId = ");
      ((StringBuilder)localObject1).append(i);
      APLog.i("APHFChannel", ((StringBuilder)localObject1).toString());
      b(i).b(paramContext, paramdl);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("progressChannelSaveAns ret == ");
    paramContext.append(i1);
    APLog.i("APHFChannel", paramContext.toString());
    i = "";
    if (i1 != 1023)
    {
      paramContext = new StringBuilder();
      paramContext.append("progressChannelSaveAns saveCallBack=");
      paramContext.append(this.f);
      APLog.d("APHFChanel", paramContext.toString());
      localObject1 = paramdl.S();
      paramContext = (Context)localObject1;
      if (TextUtils.isEmpty(paramdl.P()))
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject1);
        paramContext.append("(107-1003-");
        paramContext.append(i1);
        paramContext.append(")");
        paramContext = paramContext.toString();
      }
      paramdl = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = new StringBuilder();
        paramContext.append("系统错误，请稍后再试！(107-1002-");
        paramContext.append(i1);
        paramContext.append(")");
        paramdl = paramContext.toString();
      }
      if (this.f == null)
      {
        a(i1, paramdl, false);
        return;
      }
      paramContext = new Bundle();
      paramContext.putString("errMsg", paramdl);
      this.f.a(i1, paramContext);
      return;
    }
    APUICommonMethod.b();
    fm.a(i1, "订单失效");
  }
  
  public void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.d = paramContext;
    this.g = paramev;
    this.f = parameu;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getString("fromView");
    }
    if ("channelList".equals(paramBundle))
    {
      if (paramev != null) {
        paramev.a(0);
      }
      paramBundle = new Intent();
      paramBundle.setClass(paramContext, APHFInputActivity.class);
      paramContext.startActivity(paramBundle);
      return;
    }
    if (!g())
    {
      if (paramev != null) {
        paramev.a(0);
      }
      APDataReportManager.getInstance().insertData("sdk.hf.nosupport.dialog.show", this.A, null, null, null);
      a(250003, h(), false);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("entryChannelPay main, subChannelId=");
    paramBundle.append(i);
    APLog.i("APHFChannel", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("entryChannelPay main, recoChannel=");
    paramBundle.append(APRecoChannelActivity.a);
    APLog.i("APHFChannel", paramBundle.toString());
    es.a().a(paramContext, "hfpay", paramev, parameu);
  }
  
  public void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.d = paramContext;
    this.f = parameu;
    this.g = paramev;
    b(paramContext, paramBundle);
  }
  
  public boolean g()
  {
    label22:
    label340:
    label363:
    try
    {
      i1 = Integer.valueOf(ed.b().n().e.g).intValue();
    }
    catch (Exception localException1)
    {
      label255:
      break label22;
    }
    i1 = 0;
    i2 = ed.b().n().a.saveType;
    if (i2 == 0) {}
    try
    {
      if (!TextUtils.isEmpty(n)) {
        i2 = i.a(n);
      } else {
        i2 = i.a(ed.b().n().b.e);
      }
      if (i2 != 0) {
        i2 = i1 * 100 / i2;
      } else {
        i2 = 0;
      }
      i1 = i2;
    }
    catch (Exception localException2)
    {
      Object localObject;
      int i3;
      break label255;
    }
    try
    {
      if (!o.a().b()) {
        break label257;
      }
      i1 = i2;
      if (!o.a().c()) {
        break label257;
      }
      i1 = i2;
      if (!o.a().o()) {
        break label257;
      }
      i1 = i2;
      if (!o.a().d()) {
        break label257;
      }
      i1 = o.a().a(i2);
      i1 = i2 - i1;
    }
    catch (Exception localException3)
    {
      i1 = i2;
      break label257;
    }
    if (i2 == 1)
    {
      localObject = (em)ed.b().n().b;
      if (((em)localObject).f.length() != 0)
      {
        i1 *= Integer.valueOf(((em)localObject).f).intValue();
      }
      else
      {
        i2 = Integer.valueOf(((em)localObject).e).intValue();
        i1 *= i2;
      }
    }
    else if (i2 == 2)
    {
      i1 *= 10;
    }
    else if (i2 == 3)
    {
      i1 *= 100;
    }
    else
    {
      if (i2 == 4) {
        break label363;
      }
      if (i2 == 5) {
        return true;
      }
      i1 = 0;
    }
    label257:
    new StringBuffer();
    i3 = ge.a().c().size();
    localObject = new ArrayList();
    ((ArrayList)localObject).clear();
    i2 = 0;
    while (i2 < i3)
    {
      String str = (String)ge.a().c().get(i2);
      try
      {
        int i4 = Integer.valueOf(str).intValue() / 100;
        if (i4 != 0) {
          ((ArrayList)localObject).add(Integer.valueOf(i4));
        }
      }
      catch (Exception localException4)
      {
        break label340;
      }
      if (str.equals(String.valueOf(i1))) {
        return true;
      }
      i2 += 1;
    }
    return false;
    return true;
  }
  
  public String h()
  {
    Object localObject1 = new StringBuffer();
    int i2 = ge.a().c().size();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).clear();
    int i1 = 0;
    while (i1 < i2)
    {
      String str = (String)ge.a().c().get(i1);
      try
      {
        i3 = Integer.valueOf(str).intValue() / 100;
        if (i3 != 0) {
          ((ArrayList)localObject2).add(Integer.valueOf(i3));
        }
      }
      catch (Exception localException)
      {
        int i3;
        label81:
        break label81;
      }
      i1 += 1;
    }
    Collections.sort((List)localObject2);
    i1 = 0;
    while (i1 < ((ArrayList)localObject2).size())
    {
      i3 = ((Integer)((ArrayList)localObject2).get(i1)).intValue();
      if (i1 > 0) {
        i2 = ((Integer)((ArrayList)localObject2).get(i1 - 1)).intValue();
      } else {
        i2 = 0;
      }
      if (i3 != i2)
      {
        ((StringBuffer)localObject1).append(i3);
        ((StringBuffer)localObject1).append("，");
      }
      i1 += 1;
    }
    if (((StringBuffer)localObject1).length() > 0) {
      ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
    }
    localObject1 = ((StringBuffer)localObject1).toString();
    if ((localObject1 != null) && (!((String)localObject1).equals("")))
    {
      localObject2 = ge.a().d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFChannel
 * JD-Core Version:    0.7.0.1
 */