package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.paychannel.mcard.APMcardChannel;
import com.pay.ui.channel.APGoldCouponsDeductActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class e5
{
  public static volatile e5 e;
  public ArrayList<i5.a0> a = null;
  public HashMap<String, i5> b = null;
  public Context c;
  public ExecutorService d = Executors.newCachedThreadPool();
  
  public static i5 a(String paramString)
  {
    if (h().b == null) {
      e.b = new HashMap();
    }
    i5 locali5 = (i5)e.b.get(paramString);
    if (locali5 == null)
    {
      int j = 0;
      int k;
      for (int i = 0; j < e.a.size(); i = k)
      {
        k = i;
        if (((i5.a0)e.a.get(j)).a.equals(paramString))
        {
          int m = 1;
          int n = 1;
          int i1 = 1;
          k = 1;
          StringBuilder localStringBuilder;
          try
          {
            Object localObject = Class.forName(((i5.a0)e.a.get(j)).b);
            try
            {
              localObject = (i5)((Class)localObject).newInstance();
              ((i5)localObject).b(paramString);
              e.b.put(paramString, localObject);
              return localObject;
            }
            catch (Exception localException1)
            {
              i = k;
            }
            catch (ClassNotFoundException localClassNotFoundException1)
            {
              i = m;
            }
            catch (IllegalAccessException localIllegalAccessException1)
            {
              i = n;
            }
            catch (InstantiationException localInstantiationException1)
            {
              i = i1;
            }
            localStringBuilder = new StringBuilder();
          }
          catch (Exception localException2)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(((i5.a0)e.a.get(j)).b);
            localStringBuilder.append(" Exception:");
            localStringBuilder.append(localException2.toString());
            APLog.e("APPayManager", localStringBuilder.toString());
          }
          catch (ClassNotFoundException localClassNotFoundException2)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(((i5.a0)e.a.get(j)).b);
            localStringBuilder.append(" IllegalAccessException");
            localStringBuilder.append(localClassNotFoundException2.toString());
            APLog.e("APPayManager", localStringBuilder.toString());
          }
          catch (IllegalAccessException localIllegalAccessException2)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(((i5.a0)e.a.get(j)).b);
            localStringBuilder.append(" IllegalAccessException");
            localStringBuilder.append(localIllegalAccessException2.toString());
            APLog.e("APPayManager", localStringBuilder.toString());
          }
          catch (InstantiationException localInstantiationException2) {}
          localStringBuilder.append(((i5.a0)e.a.get(j)).b);
          localStringBuilder.append(" InstantiationException");
          localStringBuilder.append(localInstantiationException2.toString());
          APLog.e("APPayManager", localStringBuilder.toString());
          k = i;
        }
        j += 1;
      }
      if (i == 0) {
        APLog.w("creatChannel", "local jars not support this channel");
      }
    }
    return locali5;
  }
  
  public static void g()
  {
    if (e == null) {
      return;
    }
    if (e.b != null) {
      e.b.clear();
    }
    if (e.a != null)
    {
      e.a.clear();
      e.a = null;
    }
    if ((e.d != null) && (!e.d.isShutdown())) {
      e.d.shutdownNow();
    }
    e = null;
  }
  
  public static e5 h()
  {
    if (e == null) {
      try
      {
        if (e == null)
        {
          e = new e5();
          e.b = new HashMap();
          e.c();
        }
      }
      finally {}
    }
    return e;
  }
  
  public void a()
  {
    if (j9.b.size() > 0) {}
    try
    {
      ((APRecoChannelActivity)this.c).a(3, 1, null);
      return;
    }
    catch (Exception localException)
    {
      label23:
      Intent localIntent;
      break label23;
    }
    localIntent = new Intent(this.c, APRecoChannelActivity.class);
    localIntent.putExtra("to", 1);
    this.c.startActivity(localIntent);
    return;
    localIntent = new Intent(this.c, APRecoChannelActivity.class);
    localIntent.putExtra("to", 1);
    this.c.startActivity(localIntent);
  }
  
  public void a(Activity paramActivity, APBaseRequest paramAPBaseRequest)
  {
    this.c = paramActivity;
    p4.p().e().d.c(paramActivity, paramAPBaseRequest);
  }
  
  public void a(Activity paramActivity, o5 paramo5)
  {
    ((APHFChannel)a("hfpay")).a(paramActivity, paramo5);
  }
  
  public void a(Activity paramActivity, p5 paramp5)
  {
    ((APMcardChannel)a("mcard")).a(paramActivity, paramp5);
  }
  
  public void a(Context paramContext, String paramString, ob paramob, h5 paramh5, g5 paramg5)
  {
    paramob = new Bundle();
    if ((!v0.g()) && (("bank".equals(paramString)) || ("cft".equals(paramString))))
    {
      p4.p().e().f.i = "";
      a(paramContext, "channelList", null);
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      b(paramContext, paramString, paramob, paramh5, paramg5);
      return;
    }
    a(paramContext, "channelList", null);
  }
  
  public void a(final Context paramContext, final h5 paramh5, final g5 paramg5)
  {
    this.c = paramContext;
    z1.d().a(new a(paramContext, paramh5, paramg5, paramContext));
  }
  
  public final void a(Context paramContext, ob paramob, h5 paramh5, g5 paramg5)
  {
    Object localObject = (j2)paramob;
    int i = ((ob)localObject).d();
    String str = p4.p().e().f.i;
    APHFChannel.c(((j2)localObject).g());
    if ((i != 0) && (paramh5 != null)) {
      paramh5.a(i);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("progressGetChannelAns ret:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" express:");
    ((StringBuilder)localObject).append(str);
    APLog.i("APPayManager", ((StringBuilder)localObject).toString());
    if (i != 0)
    {
      if (i != 1018)
      {
        if (i != 1023)
        {
          if ((i != 1094) && (i != 1099))
          {
            p4.p().e().f.i = "";
            a(paramContext, "channelList", null);
          }
        }
        else
        {
          APUICommonMethod.f();
          z5.a(i, "订单超时失效，请重新支付");
        }
      }
      else {
        a.a("登录过期，请重新登录", paramContext);
      }
    }
    else {
      a(paramContext, str, paramob, paramh5, paramg5);
    }
  }
  
  public void a(Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    p.o().a(true);
    q6 localq6 = (q6)r6.j().b().get(0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gotoOneChannel channelId:");
    ((StringBuilder)localObject).append(localq6.a);
    APLog.e("APPayManager", ((StringBuilder)localObject).toString());
    localObject = a(localq6.a);
    if (localObject != null)
    {
      p4.p().e().f.e = localq6.a;
      ((i5)localObject).b(this.c, paramBundle, paramh5, paramg5);
    }
  }
  
  public boolean a(Context paramContext, String paramString, Bundle paramBundle)
  {
    return b(paramContext, paramString, paramBundle, null, null);
  }
  
  public boolean a(Context paramContext, String paramString, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.c = paramContext;
    i5 locali5 = a(paramString);
    if (locali5 != null)
    {
      if (!"goldcouponsdeduct".equals(paramString)) {
        p4.p().e().f.e = paramString;
      }
      locali5.b(paramContext, paramBundle, paramh5, paramg5);
      return true;
    }
    APLog.e("APPayManager", "toPay channel object is null");
    if (paramh5 != null) {
      paramh5.a(-1);
    }
    return false;
  }
  
  public boolean a(Context paramContext, String paramString, h5 paramh5, g5 paramg5)
  {
    this.c = paramContext;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doPayWithChannel channelId:");
    ((StringBuilder)localObject).append(paramString);
    APLog.e("APPayManager", ((StringBuilder)localObject).toString());
    localObject = a(paramString);
    if (localObject != null)
    {
      if ((paramString != null) && (paramString.equals("hfpay"))) {
        new Thread(new c(paramContext, (i5)localObject, paramh5, paramg5)).start();
      } else {
        ((i5)localObject).a(paramContext, paramh5, paramg5);
      }
      return true;
    }
    if (paramh5 != null) {
      paramh5.a(-1);
    }
    APLog.e("APPayManager", "toPay channel object is null");
    return false;
  }
  
  public final boolean b()
  {
    int i = p4.p().e().b.saveType;
    Object localObject;
    if ((i != 3) && (i != 2)) {
      localObject = r6.j().b();
    } else {
      localObject = r6.j().a();
    }
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if ("hfpay".equals(((q6)((Iterator)localObject).next()).a)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean b(Context paramContext, String paramString, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.c = paramContext;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gotoRecChannelView channelId:");
    ((StringBuilder)localObject).append(paramString);
    APLog.e("APPayManager", ((StringBuilder)localObject).toString());
    boolean bool;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("fromCoupons", false);
    } else {
      bool = false;
    }
    p.o().a(true);
    int i;
    if ((p.o().h()) && (p.o().f()) && (p.o().a(paramString))) {
      i = 1;
    } else {
      i = 0;
    }
    if (h().d())
    {
      if ((!bool) && (i != 0))
      {
        APUICommonMethod.b();
        paramContext.startActivity(new Intent(paramContext, APGoldCouponsDeductActivity.class));
        return true;
      }
      APUICommonMethod.b(paramContext, null);
      h().a(null, null, null);
      return true;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new Intent(paramContext, APRecoChannelActivity.class);
      paramString.putExtra("to", 3);
      paramContext.startActivity(paramString);
      return true;
    }
    if (TextUtils.isEmpty(paramString)) {}
    while ((!"bank".equals(paramString)) && (!"cft".equals(paramString)))
    {
      j = 0;
      break;
    }
    int j = 1;
    if ((!bool) && (i != 0) && (j != 0))
    {
      APUICommonMethod.b();
      paramContext.startActivity(new Intent(paramContext, APGoldCouponsDeductActivity.class));
      return true;
    }
    if ("channelList".equals(paramString))
    {
      f();
      a();
      return true;
    }
    f();
    localObject = a(paramString);
    if (localObject != null)
    {
      if (("qqwallet".equals(paramString)) && ((!q5.b()) || (!q5.a())))
      {
        APDataReportManager.getInstance().insertData("sdk.express.qqwallet.nosupport", p4.p().e().b.saveType, null, paramString, null);
        APLog.e("APPayManager", "QQWALLET is not support");
        p4.p().e().f.i = "";
        a();
        return true;
      }
      p4.p().e().f.e = paramString;
      if ((paramh5 == null) && (paramg5 == null))
      {
        ((i5)localObject).b(paramContext, paramBundle);
        return true;
      }
      ((i5)localObject).d(paramContext, paramBundle, paramh5, paramg5);
      return true;
    }
    APLog.e("APPayManager", "toPay channel object is null");
    a();
    return false;
  }
  
  public void c()
  {
    this.a = new ArrayList();
    this.a.add(new i5.a0("qdqb", "com.pay.paychannel.qdqb.APQDQBChannel", ""));
    this.a.add(new i5.a0("qbqd", "com.pay.paychannel.qdqb.APQDQBChannel", ""));
    this.a.add(new i5.a0("cft", "com.pay.paychannel.tenpay.APTenpayChannel", ""));
    this.a.add(new i5.a0("bank", "com.pay.paychannel.tenpay.APTenpayChannel", ""));
    this.a.add(new i5.a0("wechat", "com.pay.paychannel.wx.APWechatChannel", ""));
    this.a.add(new i5.a0("qqwallet", "com.pay.paychannel.qqwallet.APQQWalletChannel", ""));
    this.a.add(new i5.a0("qqcard", "com.pay.paychannel.qqcard.APQQCardChannel", ""));
    this.a.add(new i5.a0("hfpay", "com.pay.paychannel.hfpay.APHFChannel", ""));
    this.a.add(new i5.a0("mcard", "com.pay.paychannel.mcard.APMcardChannel", ""));
    this.a.add(new i5.a0("gold_coupons", "com.pay.paychannel.goldcoupons.APGoldCouponsChannel", ""));
    this.a.add(new i5.a0("yb", "com.pay.paychannel.yuanbao.APYBChannel", ""));
    this.a.add(new i5.a0("friendpay", "com.pay.paychannel.friend.APFriendChannel", ""));
    this.a.add(new i5.a0("goldcouponsdeduct", "com.pay.paychannel.goldcouponsdeduct.APGoldCouponsDeductChannel", ""));
    this.a.add(new i5.a0("wechat_quickpass", "com.pay.paychannel.unionpay.APUnionPayChannel", ""));
    this.a.add(new i5.a0("wechat_payscore", "com.pay.paychannel.payscore.APPayScoreChannel", ""));
  }
  
  public boolean d()
  {
    return (e()) && (!o.m().i());
  }
  
  public boolean e()
  {
    if (r6.j().b().size() == 1)
    {
      q6 localq6 = (q6)r6.j().b().get(0);
      if (("wechat".equals(localq6.a)) || ("qqwallet".equals(localq6.a))) {
        return true;
      }
    }
    return false;
  }
  
  public void f()
  {
    if (TextUtils.isEmpty(APHFChannel.u))
    {
      APLog.i("APPayManager", "preQuery() operatorCode == nulll");
      return;
    }
    if (!b())
    {
      APLog.i("APPayManager", "preQuery() not have HFChannel");
      return;
    }
    if (!((APHFChannel)a("hfpay")).i())
    {
      APLog.i("APPayManager", "preQuery() is not SupportAmount");
      return;
    }
    if (!c6.s0().i0())
    {
      APLog.i("APPayManager", "preQuery() is not need HFPreQuery");
      return;
    }
    Object localObject1 = n5.c(APHFChannel.u);
    if (localObject1 == null)
    {
      APLog.i("APPayManager", "preQuery() company == nulll");
      return;
    }
    if (!((m5)localObject1).d)
    {
      APLog.i("APPayManager", "preQuery() company is not isPlugin");
      return;
    }
    if (!((m5)localObject1).b())
    {
      APLog.i("APPayManager", "preQuery() company is not Installed");
      return;
    }
    Object localObject2;
    if (!((m5)localObject1).a())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preQuery() company is not valid: ");
      ((StringBuilder)localObject2).append(((m5)localObject1).b);
      APLog.i("APPayManager", ((StringBuilder)localObject2).toString());
      return;
    }
    try
    {
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = n5.b(APHFChannel.u).iterator();
      while (localIterator.hasNext())
      {
        l5 locall5 = (l5)localIterator.next();
        if ((!TextUtils.isEmpty(locall5.f)) && (locall5.a()))
        {
          k5 localk5 = (k5)APHFChannel.a(Integer.valueOf(APHFChannel.I), locall5.b);
          if (localk5 != null)
          {
            ((ArrayList)localObject2).add(localk5);
            ((ArrayList)localObject1).add(locall5);
          }
        }
      }
      if (((ArrayList)localObject1).size() <= 0)
      {
        APLog.i("APPayManager", "preQuery() channels size == 0");
        return;
      }
      APLog.i("APPayManager", "preQuery() is begin");
      k5.P = new CountDownLatch(((ArrayList)localObject1).size());
      k5.Q = System.currentTimeMillis();
      int i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        this.d.execute(new d((k5)((ArrayList)localObject2).get(i), ((l5)((ArrayList)localObject1).get(i)).f));
        i += 1;
      }
      ((ArrayList)localObject1).clear();
      ((ArrayList)localObject2).clear();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public class a
    implements fc
  {
    public a(Context paramContext1, h5 paramh5, g5 paramg5, Context paramContext2) {}
    
    public void a(ob paramob)
    {
      e5.a(e5.this, paramContext, paramob, paramh5, paramg5);
    }
    
    public void b(ob paramob)
    {
      p4.p().e().f.i = "";
      h5 localh5 = paramh5;
      if (localh5 != null) {
        localh5.a(paramob.d(), "", paramob.f());
      }
      e5.this.a(paramContext, "channelList", null);
    }
    
    public void c(ob paramob)
    {
      p4.p().e().f.i = "";
      e5.this.a(paramContext, "channelList", null);
      paramob = paramh5;
      if (paramob != null) {
        paramob.a();
      }
    }
  }
  
  public static class b
    implements Runnable
  {
    public final WeakReference<Context> a;
    public final WeakReference<i5> b;
    public final WeakReference<h5> c;
    public final WeakReference<g5> d;
    
    public b(Context paramContext, i5 parami5, h5 paramh5, g5 paramg5)
    {
      this.a = new WeakReference(paramContext);
      this.b = new WeakReference(parami5);
      this.c = new WeakReference(paramh5);
      this.d = new WeakReference(paramg5);
    }
    
    public void run()
    {
      Context localContext = (Context)this.a.get();
      i5 locali5 = (i5)this.b.get();
      Object localObject = (h5)this.c.get();
      g5 localg5 = (g5)this.d.get();
      if ((localContext != null) && (locali5 != null))
      {
        APLog.d("APPayManager", "DoPayRunnable() doPay");
        locali5.a(localContext, (h5)localObject, localg5);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DoPayRunnable() doPay failed: context = ");
      ((StringBuilder)localObject).append(localContext);
      ((StringBuilder)localObject).append(", payChannel=");
      ((StringBuilder)localObject).append(locali5);
      APLog.d("APPayManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public static class c
    implements Runnable
  {
    public final WeakReference<Context> a;
    public final WeakReference<i5> b;
    public final WeakReference<h5> c;
    public final WeakReference<g5> d;
    
    public c(Context paramContext, i5 parami5, h5 paramh5, g5 paramg5)
    {
      this.a = new WeakReference(paramContext);
      this.b = new WeakReference(parami5);
      this.c = new WeakReference(paramh5);
      this.d = new WeakReference(paramg5);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	midas/x/e5$c:a	Ljava/lang/ref/WeakReference;
      //   4: invokevirtual 45	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   7: checkcast 47	android/content/Context
      //   10: astore 14
      //   12: aload_0
      //   13: getfield 31	midas/x/e5$c:b	Ljava/lang/ref/WeakReference;
      //   16: invokevirtual 45	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   19: checkcast 49	midas/x/i5
      //   22: astore 10
      //   24: aload_0
      //   25: getfield 33	midas/x/e5$c:c	Ljava/lang/ref/WeakReference;
      //   28: invokevirtual 45	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   31: checkcast 51	midas/x/h5
      //   34: astore 11
      //   36: aload_0
      //   37: getfield 35	midas/x/e5$c:d	Ljava/lang/ref/WeakReference;
      //   40: invokevirtual 45	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   43: checkcast 53	midas/x/g5
      //   46: astore 13
      //   48: aload 14
      //   50: ifnull +1519 -> 1569
      //   53: aload 10
      //   55: ifnull +1514 -> 1569
      //   58: invokestatic 59	midas/x/c6:s0	()Lmidas/x/c6;
      //   61: invokevirtual 63	midas/x/c6:F	()J
      //   64: lstore_1
      //   65: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   68: lstore_3
      //   69: ldc 70
      //   71: ldc 72
      //   73: invokestatic 77	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   76: getstatic 83	midas/x/k5:P	Ljava/util/concurrent/CountDownLatch;
      //   79: ifnull +24 -> 103
      //   82: getstatic 83	midas/x/k5:P	Ljava/util/concurrent/CountDownLatch;
      //   85: lload_1
      //   86: getstatic 89	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   89: invokevirtual 95	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
      //   92: istore 9
      //   94: iconst_1
      //   95: iload 9
      //   97: ixor
      //   98: istore 9
      //   100: goto +6 -> 106
      //   103: iconst_0
      //   104: istore 9
      //   106: new 97	java/lang/StringBuilder
      //   109: dup
      //   110: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   113: astore 12
      //   115: aload 12
      //   117: ldc 100
      //   119: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   122: pop
      //   123: aload 12
      //   125: iload 9
      //   127: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   130: pop
      //   131: ldc 70
      //   133: aload 12
      //   135: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   138: invokestatic 77	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   141: getstatic 115	midas/x/k5:Q	J
      //   144: lconst_0
      //   145: lcmp
      //   146: ifle +264 -> 410
      //   149: new 97	java/lang/StringBuilder
      //   152: dup
      //   153: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   156: astore 12
      //   158: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   161: lstore 5
      //   163: getstatic 115	midas/x/k5:Q	J
      //   166: lstore 7
      //   168: new 97	java/lang/StringBuilder
      //   171: dup
      //   172: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   175: astore 15
      //   177: aload 15
      //   179: ldc 117
      //   181: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   184: pop
      //   185: aload 15
      //   187: lload 5
      //   189: lload 7
      //   191: lsub
      //   192: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   195: pop
      //   196: aload 12
      //   198: aload 15
      //   200: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   203: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   206: pop
      //   207: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   210: lstore 5
      //   212: new 97	java/lang/StringBuilder
      //   215: dup
      //   216: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   219: astore 15
      //   221: aload 15
      //   223: ldc 122
      //   225: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: pop
      //   229: aload 15
      //   231: lload 5
      //   233: lload_3
      //   234: lsub
      //   235: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   238: pop
      //   239: aload 12
      //   241: aload 15
      //   243: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   246: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   249: pop
      //   250: aload 12
      //   252: ldc 124
      //   254: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   257: pop
      //   258: new 97	java/lang/StringBuilder
      //   261: dup
      //   262: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   265: astore 15
      //   267: aload 15
      //   269: ldc 126
      //   271: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   274: pop
      //   275: aload 15
      //   277: lload_1
      //   278: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   281: pop
      //   282: aload 12
      //   284: aload 15
      //   286: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   289: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   292: pop
      //   293: aload 12
      //   295: ldc 124
      //   297: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   300: pop
      //   301: new 97	java/lang/StringBuilder
      //   304: dup
      //   305: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   308: astore 15
      //   310: aload 15
      //   312: ldc 128
      //   314: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   317: pop
      //   318: aload 15
      //   320: iconst_0
      //   321: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   324: pop
      //   325: aload 12
      //   327: aload 15
      //   329: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   332: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   335: pop
      //   336: aload 12
      //   338: ldc 124
      //   340: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   343: pop
      //   344: new 97	java/lang/StringBuilder
      //   347: dup
      //   348: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   351: astore 15
      //   353: aload 15
      //   355: ldc 130
      //   357: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   360: pop
      //   361: aload 15
      //   363: iload 9
      //   365: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   368: pop
      //   369: aload 12
      //   371: aload 15
      //   373: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   376: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   379: pop
      //   380: invokestatic 136	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
      //   383: ldc 138
      //   385: invokestatic 144	midas/x/p4:p	()Lmidas/x/p4;
      //   388: invokevirtual 148	midas/x/p4:e	()Lmidas/x/o4;
      //   391: getfield 153	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
      //   394: getfield 159	com/pay/api/request/APBaseRequest:saveType	I
      //   397: aconst_null
      //   398: aconst_null
      //   399: aload 12
      //   401: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   404: invokevirtual 163	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   407: goto +3 -> 410
      //   410: aload 14
      //   412: ifnull +47 -> 459
      //   415: aload 14
      //   417: instanceof 165
      //   420: ifeq +39 -> 459
      //   423: aload 14
      //   425: checkcast 165	android/app/Activity
      //   428: astore 12
      //   430: new 167	midas/x/e5$b
      //   433: dup
      //   434: aload 14
      //   436: aload 10
      //   438: aload 11
      //   440: aload 13
      //   442: invokespecial 169	midas/x/e5$b:<init>	(Landroid/content/Context;Lmidas/x/i5;Lmidas/x/h5;Lmidas/x/g5;)V
      //   445: astore 11
      //   447: aload 12
      //   449: astore 10
      //   451: aload 10
      //   453: aload 11
      //   455: invokevirtual 173	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   458: return
      //   459: aload 10
      //   461: aload 14
      //   463: aload 11
      //   465: aload 13
      //   467: invokevirtual 176	midas/x/i5:a	(Landroid/content/Context;Lmidas/x/h5;Lmidas/x/g5;)V
      //   470: return
      //   471: astore 12
      //   473: iconst_0
      //   474: istore 9
      //   476: goto +737 -> 1213
      //   479: astore 12
      //   481: aload 12
      //   483: invokevirtual 179	java/lang/Exception:printStackTrace	()V
      //   486: new 97	java/lang/StringBuilder
      //   489: dup
      //   490: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   493: astore 12
      //   495: aload 12
      //   497: ldc 100
      //   499: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   502: pop
      //   503: aload 12
      //   505: iconst_0
      //   506: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   509: pop
      //   510: ldc 70
      //   512: aload 12
      //   514: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   517: invokestatic 77	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   520: getstatic 115	midas/x/k5:Q	J
      //   523: lconst_0
      //   524: lcmp
      //   525: ifle +263 -> 788
      //   528: new 97	java/lang/StringBuilder
      //   531: dup
      //   532: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   535: astore 12
      //   537: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   540: lstore 5
      //   542: getstatic 115	midas/x/k5:Q	J
      //   545: lstore 7
      //   547: new 97	java/lang/StringBuilder
      //   550: dup
      //   551: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   554: astore 15
      //   556: aload 15
      //   558: ldc 117
      //   560: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   563: pop
      //   564: aload 15
      //   566: lload 5
      //   568: lload 7
      //   570: lsub
      //   571: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   574: pop
      //   575: aload 12
      //   577: aload 15
      //   579: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   582: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   585: pop
      //   586: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   589: lstore 5
      //   591: new 97	java/lang/StringBuilder
      //   594: dup
      //   595: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   598: astore 15
      //   600: aload 15
      //   602: ldc 122
      //   604: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   607: pop
      //   608: aload 15
      //   610: lload 5
      //   612: lload_3
      //   613: lsub
      //   614: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   617: pop
      //   618: aload 12
      //   620: aload 15
      //   622: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   625: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   628: pop
      //   629: aload 12
      //   631: ldc 124
      //   633: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   636: pop
      //   637: new 97	java/lang/StringBuilder
      //   640: dup
      //   641: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   644: astore 15
      //   646: aload 15
      //   648: ldc 126
      //   650: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   653: pop
      //   654: aload 15
      //   656: lload_1
      //   657: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   660: pop
      //   661: aload 12
      //   663: aload 15
      //   665: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   668: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   671: pop
      //   672: aload 12
      //   674: ldc 124
      //   676: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   679: pop
      //   680: new 97	java/lang/StringBuilder
      //   683: dup
      //   684: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   687: astore 15
      //   689: aload 15
      //   691: ldc 128
      //   693: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   696: pop
      //   697: aload 15
      //   699: iconst_0
      //   700: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   703: pop
      //   704: aload 12
      //   706: aload 15
      //   708: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   711: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   714: pop
      //   715: aload 12
      //   717: ldc 124
      //   719: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   722: pop
      //   723: new 97	java/lang/StringBuilder
      //   726: dup
      //   727: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   730: astore 15
      //   732: aload 15
      //   734: ldc 130
      //   736: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   739: pop
      //   740: aload 15
      //   742: iconst_0
      //   743: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   746: pop
      //   747: aload 12
      //   749: aload 15
      //   751: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   754: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   757: pop
      //   758: invokestatic 136	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
      //   761: ldc 138
      //   763: invokestatic 144	midas/x/p4:p	()Lmidas/x/p4;
      //   766: invokevirtual 148	midas/x/p4:e	()Lmidas/x/o4;
      //   769: getfield 153	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
      //   772: getfield 159	com/pay/api/request/APBaseRequest:saveType	I
      //   775: aconst_null
      //   776: aconst_null
      //   777: aload 12
      //   779: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   782: invokevirtual 163	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   785: goto +3 -> 788
      //   788: aload 14
      //   790: ifnull +42 -> 832
      //   793: aload 14
      //   795: instanceof 165
      //   798: ifeq +34 -> 832
      //   801: aload 14
      //   803: checkcast 165	android/app/Activity
      //   806: astore 12
      //   808: new 167	midas/x/e5$b
      //   811: dup
      //   812: aload 14
      //   814: aload 10
      //   816: aload 11
      //   818: aload 13
      //   820: invokespecial 169	midas/x/e5$b:<init>	(Landroid/content/Context;Lmidas/x/i5;Lmidas/x/h5;Lmidas/x/g5;)V
      //   823: astore 11
      //   825: aload 12
      //   827: astore 10
      //   829: goto -378 -> 451
      //   832: goto -373 -> 459
      //   835: astore 12
      //   837: iconst_0
      //   838: istore 9
      //   840: goto +373 -> 1213
      //   843: astore 12
      //   845: aload 12
      //   847: invokevirtual 180	java/lang/InterruptedException:printStackTrace	()V
      //   850: new 97	java/lang/StringBuilder
      //   853: dup
      //   854: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   857: astore 12
      //   859: aload 12
      //   861: ldc 100
      //   863: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   866: pop
      //   867: aload 12
      //   869: iconst_0
      //   870: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   873: pop
      //   874: ldc 70
      //   876: aload 12
      //   878: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   881: invokestatic 77	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   884: getstatic 115	midas/x/k5:Q	J
      //   887: lconst_0
      //   888: lcmp
      //   889: ifle +263 -> 1152
      //   892: new 97	java/lang/StringBuilder
      //   895: dup
      //   896: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   899: astore 12
      //   901: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   904: lstore 5
      //   906: getstatic 115	midas/x/k5:Q	J
      //   909: lstore 7
      //   911: new 97	java/lang/StringBuilder
      //   914: dup
      //   915: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   918: astore 15
      //   920: aload 15
      //   922: ldc 117
      //   924: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   927: pop
      //   928: aload 15
      //   930: lload 5
      //   932: lload 7
      //   934: lsub
      //   935: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   938: pop
      //   939: aload 12
      //   941: aload 15
      //   943: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   946: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   949: pop
      //   950: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   953: lstore 5
      //   955: new 97	java/lang/StringBuilder
      //   958: dup
      //   959: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   962: astore 15
      //   964: aload 15
      //   966: ldc 122
      //   968: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   971: pop
      //   972: aload 15
      //   974: lload 5
      //   976: lload_3
      //   977: lsub
      //   978: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   981: pop
      //   982: aload 12
      //   984: aload 15
      //   986: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   989: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   992: pop
      //   993: aload 12
      //   995: ldc 124
      //   997: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1000: pop
      //   1001: new 97	java/lang/StringBuilder
      //   1004: dup
      //   1005: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1008: astore 15
      //   1010: aload 15
      //   1012: ldc 126
      //   1014: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1017: pop
      //   1018: aload 15
      //   1020: lload_1
      //   1021: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1024: pop
      //   1025: aload 12
      //   1027: aload 15
      //   1029: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1032: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1035: pop
      //   1036: aload 12
      //   1038: ldc 124
      //   1040: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1043: pop
      //   1044: new 97	java/lang/StringBuilder
      //   1047: dup
      //   1048: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1051: astore 15
      //   1053: aload 15
      //   1055: ldc 128
      //   1057: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1060: pop
      //   1061: aload 15
      //   1063: iconst_1
      //   1064: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1067: pop
      //   1068: aload 12
      //   1070: aload 15
      //   1072: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1075: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1078: pop
      //   1079: aload 12
      //   1081: ldc 124
      //   1083: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1086: pop
      //   1087: new 97	java/lang/StringBuilder
      //   1090: dup
      //   1091: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1094: astore 15
      //   1096: aload 15
      //   1098: ldc 130
      //   1100: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1103: pop
      //   1104: aload 15
      //   1106: iconst_0
      //   1107: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1110: pop
      //   1111: aload 12
      //   1113: aload 15
      //   1115: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1118: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1121: pop
      //   1122: invokestatic 136	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
      //   1125: ldc 138
      //   1127: invokestatic 144	midas/x/p4:p	()Lmidas/x/p4;
      //   1130: invokevirtual 148	midas/x/p4:e	()Lmidas/x/o4;
      //   1133: getfield 153	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
      //   1136: getfield 159	com/pay/api/request/APBaseRequest:saveType	I
      //   1139: aconst_null
      //   1140: aconst_null
      //   1141: aload 12
      //   1143: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1146: invokevirtual 163	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   1149: goto +3 -> 1152
      //   1152: aload 10
      //   1154: astore 12
      //   1156: aload 14
      //   1158: ifnull +38 -> 1196
      //   1161: aload 14
      //   1163: instanceof 165
      //   1166: ifeq +30 -> 1196
      //   1169: aload 14
      //   1171: checkcast 165	android/app/Activity
      //   1174: astore 10
      //   1176: new 167	midas/x/e5$b
      //   1179: dup
      //   1180: aload 14
      //   1182: aload 12
      //   1184: aload 11
      //   1186: aload 13
      //   1188: invokespecial 169	midas/x/e5$b:<init>	(Landroid/content/Context;Lmidas/x/i5;Lmidas/x/h5;Lmidas/x/g5;)V
      //   1191: astore 11
      //   1193: goto -742 -> 451
      //   1196: aload 12
      //   1198: aload 14
      //   1200: aload 11
      //   1202: aload 13
      //   1204: invokevirtual 176	midas/x/i5:a	(Landroid/content/Context;Lmidas/x/h5;Lmidas/x/g5;)V
      //   1207: return
      //   1208: astore 12
      //   1210: iconst_1
      //   1211: istore 9
      //   1213: new 97	java/lang/StringBuilder
      //   1216: dup
      //   1217: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1220: astore 15
      //   1222: aload 15
      //   1224: ldc 100
      //   1226: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1229: pop
      //   1230: aload 15
      //   1232: iconst_0
      //   1233: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1236: pop
      //   1237: ldc 70
      //   1239: aload 15
      //   1241: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1244: invokestatic 77	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   1247: getstatic 115	midas/x/k5:Q	J
      //   1250: lconst_0
      //   1251: lcmp
      //   1252: ifle +264 -> 1516
      //   1255: new 97	java/lang/StringBuilder
      //   1258: dup
      //   1259: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1262: astore 15
      //   1264: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   1267: lstore 5
      //   1269: getstatic 115	midas/x/k5:Q	J
      //   1272: lstore 7
      //   1274: new 97	java/lang/StringBuilder
      //   1277: dup
      //   1278: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1281: astore 16
      //   1283: aload 16
      //   1285: ldc 117
      //   1287: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1290: pop
      //   1291: aload 16
      //   1293: lload 5
      //   1295: lload 7
      //   1297: lsub
      //   1298: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1301: pop
      //   1302: aload 15
      //   1304: aload 16
      //   1306: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1309: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1312: pop
      //   1313: invokestatic 68	java/lang/System:currentTimeMillis	()J
      //   1316: lstore 5
      //   1318: new 97	java/lang/StringBuilder
      //   1321: dup
      //   1322: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1325: astore 16
      //   1327: aload 16
      //   1329: ldc 122
      //   1331: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1334: pop
      //   1335: aload 16
      //   1337: lload 5
      //   1339: lload_3
      //   1340: lsub
      //   1341: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1344: pop
      //   1345: aload 15
      //   1347: aload 16
      //   1349: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1352: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1355: pop
      //   1356: aload 15
      //   1358: ldc 124
      //   1360: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1363: pop
      //   1364: new 97	java/lang/StringBuilder
      //   1367: dup
      //   1368: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1371: astore 16
      //   1373: aload 16
      //   1375: ldc 126
      //   1377: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1380: pop
      //   1381: aload 16
      //   1383: lload_1
      //   1384: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1387: pop
      //   1388: aload 15
      //   1390: aload 16
      //   1392: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1395: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1398: pop
      //   1399: aload 15
      //   1401: ldc 124
      //   1403: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1406: pop
      //   1407: new 97	java/lang/StringBuilder
      //   1410: dup
      //   1411: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1414: astore 16
      //   1416: aload 16
      //   1418: ldc 128
      //   1420: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1423: pop
      //   1424: aload 16
      //   1426: iload 9
      //   1428: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1431: pop
      //   1432: aload 15
      //   1434: aload 16
      //   1436: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1439: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1442: pop
      //   1443: aload 15
      //   1445: ldc 124
      //   1447: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1450: pop
      //   1451: new 97	java/lang/StringBuilder
      //   1454: dup
      //   1455: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1458: astore 16
      //   1460: aload 16
      //   1462: ldc 130
      //   1464: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1467: pop
      //   1468: aload 16
      //   1470: iconst_0
      //   1471: invokevirtual 107	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1474: pop
      //   1475: aload 15
      //   1477: aload 16
      //   1479: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1482: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1485: pop
      //   1486: invokestatic 136	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
      //   1489: ldc 138
      //   1491: invokestatic 144	midas/x/p4:p	()Lmidas/x/p4;
      //   1494: invokevirtual 148	midas/x/p4:e	()Lmidas/x/o4;
      //   1497: getfield 153	midas/x/o4:b	Lcom/pay/api/request/APBaseRequest;
      //   1500: getfield 159	com/pay/api/request/APBaseRequest:saveType	I
      //   1503: aconst_null
      //   1504: aconst_null
      //   1505: aload 15
      //   1507: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1510: invokevirtual 163	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   1513: goto +3 -> 1516
      //   1516: aload 14
      //   1518: ifnull +37 -> 1555
      //   1521: aload 14
      //   1523: instanceof 165
      //   1526: ifeq +29 -> 1555
      //   1529: aload 14
      //   1531: checkcast 165	android/app/Activity
      //   1534: new 167	midas/x/e5$b
      //   1537: dup
      //   1538: aload 14
      //   1540: aload 10
      //   1542: aload 11
      //   1544: aload 13
      //   1546: invokespecial 169	midas/x/e5$b:<init>	(Landroid/content/Context;Lmidas/x/i5;Lmidas/x/h5;Lmidas/x/g5;)V
      //   1549: invokevirtual 173	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   1552: goto +14 -> 1566
      //   1555: aload 10
      //   1557: aload 14
      //   1559: aload 11
      //   1561: aload 13
      //   1563: invokevirtual 176	midas/x/i5:a	(Landroid/content/Context;Lmidas/x/h5;Lmidas/x/g5;)V
      //   1566: aload 12
      //   1568: athrow
      //   1569: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1570	0	this	c
      //   64	1320	1	l1	long
      //   68	1272	3	l2	long
      //   161	1177	5	l3	long
      //   166	1130	7	l4	long
      //   92	1335	9	bool	boolean
      //   22	1534	10	localObject1	Object
      //   34	1526	11	localObject2	Object
      //   113	335	12	localObject3	Object
      //   471	1	12	localObject4	Object
      //   479	3	12	localException	Exception
      //   493	333	12	localObject5	Object
      //   835	1	12	localObject6	Object
      //   843	3	12	localInterruptedException	java.lang.InterruptedException
      //   857	340	12	localObject7	Object
      //   1208	359	12	localObject8	Object
      //   46	1516	13	localg5	g5
      //   10	1548	14	localContext	Context
      //   175	1331	15	localStringBuilder1	StringBuilder
      //   1281	197	16	localStringBuilder2	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   76	94	471	finally
      //   76	94	479	java/lang/Exception
      //   481	486	835	finally
      //   76	94	843	java/lang/InterruptedException
      //   845	850	1208	finally
    }
  }
  
  public static class d
    implements Runnable
  {
    public final WeakReference<k5> a;
    public final String b;
    
    public d(k5 paramk5, String paramString)
    {
      this.a = new WeakReference(paramk5);
      this.b = paramString;
    }
    
    public void run()
    {
      k5 localk5 = (k5)this.a.get();
      if (localk5 != null) {
        localk5.d(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.e5
 * JD-Core Version:    0.7.0.1
 */