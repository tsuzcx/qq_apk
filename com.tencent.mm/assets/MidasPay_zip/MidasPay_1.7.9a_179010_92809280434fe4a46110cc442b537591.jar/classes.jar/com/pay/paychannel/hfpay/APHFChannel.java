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
import midas.x.d5;
import midas.x.e5;
import midas.x.fc;
import midas.x.g4;
import midas.x.g5;
import midas.x.h5;
import midas.x.i;
import midas.x.i5;
import midas.x.j9;
import midas.x.k5;
import midas.x.l5;
import midas.x.n5;
import midas.x.o4;
import midas.x.o5;
import midas.x.ob;
import midas.x.p;
import midas.x.p4;
import midas.x.s6;
import midas.x.w3;
import midas.x.w4;
import midas.x.y4;
import midas.x.z1;
import midas.x.z5;

public class APHFChannel
  extends i5
{
  public static String A;
  public static String B;
  public static String C;
  public static String D;
  public static String E;
  public static HashMap<String, APHFChannel> F = new HashMap();
  public static int G = 1;
  public static int H = 2;
  public static int I = 4;
  public static int J = 8;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  public o4 o;
  public int p;
  
  public static APHFChannel a(Integer paramInteger, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = (APHFChannel)F.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if (paramInteger.intValue() == G)
    {
      paramInteger = new APHFRequest();
    }
    else if (paramInteger.intValue() == H)
    {
      paramInteger = new APHFWeb(paramString);
    }
    else if (paramInteger.intValue() == I)
    {
      localObject = k5.e(paramString);
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
      if (paramInteger.intValue() != J) {
        break label154;
      }
      paramInteger = new APHFSend();
    }
    F.put(paramString, paramInteger);
    return paramInteger;
    label154:
    return null;
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    n5.d();
    Iterator localIterator1 = n5.b().iterator();
    Object localObject;
    while (localIterator1.hasNext())
    {
      localObject = (l5)localIterator1.next();
      ((l5)localObject).f = "";
      ((l5)localObject).g = "";
    }
    paramString = paramString.split("#");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localIterator1 = paramString[i];
      localObject = (String)APTools.i(localIterator1).get("channel");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        n5.d();
        Iterator localIterator2 = n5.b().iterator();
        while (localIterator2.hasNext())
        {
          l5 locall5 = (l5)localIterator2.next();
          if (((String)localObject).equals(locall5.b)) {
            locall5.f = localIterator1;
          }
        }
      }
      i += 1;
    }
  }
  
  public static void j()
  {
    q = "";
    E = "";
    w = "";
  }
  
  public void a(Activity paramActivity)
  {
    a(paramActivity, 9);
  }
  
  public final void a(Activity paramActivity, String paramString)
  {
    a(paramActivity, 250001, paramString, this.f);
  }
  
  public final void a(Activity paramActivity, g4 paramg4, o5 paramo5)
  {
    this.c = paramActivity;
    String str = paramg4.i();
    int i = paramg4.d();
    paramg4.g();
    paramg4 = paramg4.h();
    if (i == 0)
    {
      if (str.endsWith("succeed"))
      {
        a(null);
        if (paramo5 != null) {
          paramo5.a(0, null);
        }
      }
      else if (str.endsWith("failed"))
      {
        a(paramActivity, paramg4);
        if (paramo5 != null) {
          paramo5.a(0, null);
        }
      }
      else if (((str.equals("delay")) || (str.equals("delayfinal"))) && (paramo5 != null))
      {
        paramo5.a(-1, null);
      }
    }
    else
    {
      a(paramActivity, paramg4);
      if (paramo5 != null) {
        paramo5.a(0, null);
      }
    }
  }
  
  public void a(final Activity paramActivity, final o5 paramo5)
  {
    String str = p4.p().e().f.m;
    z1.d().f(str, new a(paramActivity, paramo5));
  }
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, APPayProgressActivity.class);
    localIntent.putExtra("channel", 9);
    paramContext.startActivity(localIntent);
    ((Activity)paramContext).finish();
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    this.c = paramContext;
    APLog.i("APHFChannel", "gotoRecChannel main");
    int i;
    if (!i())
    {
      p4.p().e().f.i = "";
      i = 1;
    }
    else
    {
      i = 2;
    }
    if (j9.b.size() > 0) {
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
  
  public void a(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.c = paramContext;
    this.f = paramh5;
    this.e = paramg5;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getString("fromView");
    }
    if ("channelList".equals(paramBundle))
    {
      if (paramh5 != null) {
        paramh5.a(0);
      }
      paramBundle = new Intent();
      paramBundle.setClass(paramContext, APHFInputActivity.class);
      paramContext.startActivity(paramBundle);
      return;
    }
    if (!i())
    {
      if (paramh5 != null) {
        paramh5.a(0);
      }
      APDataReportManager.getInstance().insertData("sdk.hf.nosupport.dialog.show", this.p, null, null, null);
      a(250003, h(), false);
      return;
    }
    paramBundle = new StringBuilder();
    paramBundle.append("entryChannelPay main, subChannelId=");
    paramBundle.append(q);
    APLog.i("APHFChannel", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("entryChannelPay main, recoChannel=");
    paramBundle.append(APRecoChannelActivity.g);
    APLog.i("APHFChannel", paramBundle.toString());
    e5.h().a(paramContext, "hfpay", paramh5, paramg5);
  }
  
  public void a(Context paramContext, w3 paramw3)
  {
    this.c = paramContext;
    int i = paramw3.d();
    Object localObject = this.f;
    if (localObject != null) {
      ((h5)localObject).a(0);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressChannelSaveAns ret=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", saveCallBack=");
    ((StringBuilder)localObject).append(this.e);
    APLog.i("APHFChannel", ((StringBuilder)localObject).toString());
    if (i == 0)
    {
      i = paramw3.p();
      q = paramw3.o();
      x = paramw3.m();
      y = paramw3.l();
      z = paramw3.q();
      A = paramw3.n();
      B = paramw3.s();
      w = paramw3.r();
      paramw3.k();
      C = paramw3.j();
      D = paramw3.t();
      E = paramw3.y();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("progressChannelSaveAns ret == 0, hfInterfaceType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", subChannelId = ");
      ((StringBuilder)localObject).append(q);
      APLog.i("APHFChannel", ((StringBuilder)localObject).toString());
      localObject = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hfsubid=");
      localStringBuilder.append(q);
      localStringBuilder.append("&hfinterfacetype=");
      localStringBuilder.append(i);
      ((APDataReportManager)localObject).a("sdk.channel.children", localStringBuilder.toString());
      localObject = a(Integer.valueOf(i), q);
      if (localObject != null)
      {
        ((APHFChannel)localObject).a(paramContext, paramw3);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("progressChannelSaveAns subId=");
      paramContext.append(q);
      paramContext.append(" is not isSupportedChannelId");
      APLog.w("APHFChannel", paramContext.toString());
      if (this.e == null)
      {
        paramContext = new StringBuilder();
        paramContext.append("渠道信息错误，请稍后再试！(107-1001-");
        paramContext.append(q);
        paramContext.append(")");
        a(-99001, paramContext.toString(), false);
        return;
      }
      paramContext = new Bundle();
      paramw3 = new StringBuilder();
      paramw3.append("渠道信息错误，请稍后再试！(107-1001-");
      paramw3.append(q);
      paramw3.append(")");
      paramContext.putString("errMsg", paramw3.toString());
      this.e.a(-99001, paramContext);
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
      paramContext.append(this.e);
      APLog.d("APHFChanel", paramContext.toString());
      localObject = paramw3.f();
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty(paramw3.i()))
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject);
        paramContext.append("(107-1003-");
        paramContext.append(i);
        paramContext.append(")");
        paramContext = paramContext.toString();
      }
      paramw3 = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = new StringBuilder();
        paramContext.append("系统错误，请稍后再试！(107-1002-");
        paramContext.append(i);
        paramContext.append(")");
        paramw3 = paramContext.toString();
      }
      if (this.e == null)
      {
        a(i, paramw3, false);
        return;
      }
      paramContext = new Bundle();
      paramContext.putString("errMsg", paramw3);
      this.e.a(i, paramContext);
      return;
    }
    APUICommonMethod.f();
    z5.a(i, "订单失效");
  }
  
  public void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.c = paramContext;
    this.e = paramg5;
    this.f = paramh5;
    a(paramContext, paramBundle);
  }
  
  public String h()
  {
    Object localObject1 = new StringBuffer();
    int j = s6.d().b().size();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).clear();
    int i = 0;
    while (i < j)
    {
      String str = (String)s6.d().b().get(i);
      try
      {
        k = Integer.valueOf(str).intValue() / 100;
        if (k != 0) {
          ((ArrayList)localObject2).add(Integer.valueOf(k));
        }
      }
      catch (Exception localException)
      {
        int k;
        label81:
        break label81;
      }
      i += 1;
    }
    Collections.sort((List)localObject2);
    i = 0;
    while (i < ((ArrayList)localObject2).size())
    {
      k = ((Integer)((ArrayList)localObject2).get(i)).intValue();
      if (i > 0) {
        j = ((Integer)((ArrayList)localObject2).get(i - 1)).intValue();
      } else {
        j = 0;
      }
      if (k != j)
      {
        ((StringBuffer)localObject1).append(k);
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
      localObject2 = s6.d().c();
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
  
  public boolean i()
  {
    label22:
    label333:
    label356:
    try
    {
      i = Integer.valueOf(p4.p().e().f.f).intValue();
    }
    catch (Exception localException1)
    {
      label253:
      label255:
      break label22;
    }
    i = 0;
    j = p4.p().e().b.saveType;
    if (j == 0) {}
    try
    {
      if (!TextUtils.isEmpty(v)) {
        j = i.b(v);
      } else {
        j = i.b(p4.p().e().c.c);
      }
      if (j != 0) {
        j = i * 100 / j;
      } else {
        j = 0;
      }
      i = j;
    }
    catch (Exception localException2)
    {
      Object localObject;
      int k;
      break label253;
    }
    try
    {
      if (!p.o().h()) {
        break label255;
      }
      i = j;
      if (!p.o().f()) {
        break label255;
      }
      i = j;
      if (!p.o().j()) {
        break label255;
      }
      i = j;
      if (!p.o().i()) {
        break label255;
      }
      i = p.o().b(j);
      i = j - i;
    }
    catch (Exception localException3)
    {
      i = j;
      break label255;
    }
    if (j == 1)
    {
      localObject = (y4)p4.p().e().c;
      if (((w4)localObject).d.length() != 0) {
        j = Integer.valueOf(((w4)localObject).d).intValue();
      } else {
        j = Integer.valueOf(((w4)localObject).c).intValue();
      }
      i *= j;
    }
    else if (j == 2)
    {
      i *= 10;
    }
    else if (j == 3)
    {
      i *= 100;
    }
    else
    {
      if (j == 4) {
        break label356;
      }
      if (j == 5) {
        return true;
      }
      i = 0;
    }
    k = s6.d().b().size();
    localObject = new ArrayList();
    ((ArrayList)localObject).clear();
    j = 0;
    while (j < k)
    {
      String str = (String)s6.d().b().get(j);
      try
      {
        int m = Integer.valueOf(str).intValue() / 100;
        if (m != 0) {
          ((ArrayList)localObject).add(Integer.valueOf(m));
        }
      }
      catch (Exception localException4)
      {
        break label333;
      }
      if (str.equals(String.valueOf(i))) {
        return true;
      }
      j += 1;
    }
    return false;
    return true;
  }
  
  public class a
    implements fc
  {
    public a(Activity paramActivity, o5 paramo5) {}
    
    public void a(ob paramob)
    {
      paramob = (g4)paramob;
      APHFChannel.a(APHFChannel.this, paramActivity, paramob, paramo5);
    }
    
    public void b(ob paramob)
    {
      paramob = paramo5;
      if (paramob != null) {
        paramob.a(-1, null);
      }
    }
    
    public void c(ob paramob) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.hfpay.APHFChannel
 * JD-Core Version:    0.7.0.1
 */