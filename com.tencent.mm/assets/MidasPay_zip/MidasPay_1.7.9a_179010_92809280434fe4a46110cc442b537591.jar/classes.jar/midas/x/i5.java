package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.APPayResponse;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APGoodsRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i5
  implements Cloneable
{
  public static final String m = i5.class.getSimpleName();
  public static ArrayList<Long> n = new ArrayList();
  public final Handler a = new Handler();
  public Bundle b;
  public Context c;
  public String d;
  public g5 e;
  public h5 f;
  public ResultReceiver g = new k(new Handler());
  public l1 h = new r();
  public int i = 0;
  public ArrayList<Long> j = n;
  public ArrayList<Long> k = new ArrayList();
  public ArrayList<Integer> l = new ArrayList();
  
  static
  {
    n.add(Long.valueOf(0L));
    n.add(Long.valueOf(5L));
    n.add(Long.valueOf(10L));
    n.add(Long.valueOf(15L));
    n.add(Long.valueOf(20L));
    n.add(Long.valueOf(40L));
    n.add(Long.valueOf(60L));
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = new APAlertDialog.f(paramContext);
    paramContext.a(paramString);
    paramContext.b("返回", new q());
    try
    {
      paramContext.b();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public long a(long paramLong)
  {
    int i1 = this.i;
    while (i1 < this.j.size() - 2)
    {
      long l1 = ((Long)this.j.get(this.i)).longValue() + paramLong;
      if (l1 >= ((Long)this.j.get(i1)).longValue())
      {
        ArrayList localArrayList = this.j;
        int i2 = i1 + 1;
        if (l1 < ((Long)localArrayList.get(i2)).longValue())
        {
          this.i = i2;
          return ((Long)this.j.get(i2)).longValue() - l1;
        }
      }
      i1 += 1;
    }
    return -1L;
  }
  
  public String a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", paramInt);
      Object localObject1 = new JSONArray();
      paramInt = 0;
      while (paramInt < this.k.size())
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("inter", this.k.get(paramInt));
        ((JSONObject)localObject2).put("code", this.l.get(paramInt));
        ((JSONArray)localObject1).put(localObject2);
        paramInt += 1;
      }
      localJSONObject.put("plist", localObject1);
      localObject1 = m;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("receipt query:");
      ((StringBuilder)localObject2).append(localJSONObject.toString());
      APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public void a(int paramInt, Bundle paramBundle) {}
  
  public void a(final int paramInt, String paramString, final boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("context:");
    ((StringBuilder)localObject).append(this.c);
    APLog.e("APBasePayChannel showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("message:");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APBasePayChannel showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new APAlertDialog.f(this.c);
    String str = p4.p().e().f.e;
    if ("hfpay".equals(str))
    {
      if (!TextUtils.isEmpty(paramString)) {
        ((APAlertDialog.f)localObject).a(paramString);
      } else {
        ((APAlertDialog.f)localObject).a(this.c.getString(2131230796));
      }
    }
    else if ("mcard".equals(str))
    {
      if (!TextUtils.isEmpty(paramString)) {
        ((APAlertDialog.f)localObject).a(paramString);
      } else {
        ((APAlertDialog.f)localObject).a(this.c.getString(2131230813));
      }
    }
    else {
      ((APAlertDialog.f)localObject).a(paramString);
    }
    ((APAlertDialog.f)localObject).b("我知道了", new c(paramBoolean, paramInt));
    ((APAlertDialog.f)localObject).b(new d(paramBoolean, paramInt));
    try
    {
      ((APAlertDialog.f)localObject).b();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(long paramLong, final z paramz)
  {
    APLog.i(m, "queryReceiptAgain start to queryReceiptAgain");
    u localu = new u(paramz);
    long l1 = ((Long)this.j.get(this.i)).longValue();
    Object localObject = this.j;
    if (l1 + paramLong >= ((Long)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).longValue())
    {
      APLog.i(m, "queryReceiptAgain Timeout exit");
      this.a.removeCallbacks(localu);
      paramz.a(4, "");
      return;
    }
    paramLong = a(paramLong);
    localObject = m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryReceiptAgain mStartPos:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("  next:");
    localStringBuilder.append(paramLong);
    APLog.i((String)localObject, localStringBuilder.toString());
    if (paramLong != -1L)
    {
      this.a.postDelayed(localu, paramLong * 1000L);
      return;
    }
    this.a.removeCallbacks(localu);
    paramz.a(4, "");
  }
  
  public void a(Activity paramActivity, l1 paraml1)
  {
    APPluginActivity localAPPluginActivity = (APPluginActivity)paramActivity;
    m1.d().a(paramActivity, localAPPluginActivity.mActivity, c6.s0().a(), paraml1);
  }
  
  public void a(Context paramContext, final int paramInt)
  {
    APLog.i("APBasePayChannel", "toUnkownResult");
    Object localObject = this.f;
    if (localObject != null) {
      ((h5)localObject).a();
    }
    localObject = new APAlertDialog.f(paramContext);
    ((APAlertDialog.f)localObject).b("提示");
    String str = p4.p().e().f.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelId:");
    localStringBuilder.append(str);
    APLog.i("APBasePayChannel", localStringBuilder.toString());
    if ("hfpay".equals(str)) {
      ((APAlertDialog.f)localObject).a(paramContext.getString(2131230796));
    } else if ("mcard".equals(str)) {
      ((APAlertDialog.f)localObject).a(paramContext.getString(2131230813));
    } else if ((r1.i()) && ((paramInt == 13) || (paramInt == 8)) && (!r1.h())) {
      ((APAlertDialog.f)localObject).a(paramContext.getString(2131230751));
    }
    ((APAlertDialog.f)localObject).b("我知道了", new x(paramInt));
    ((APAlertDialog.f)localObject).b(new y());
    try
    {
      ((APAlertDialog.f)localObject).b();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public final void a(final Context paramContext, final int paramInt, final String paramString)
  {
    APUICommonMethod.c(paramContext);
    a.r().a(new b(paramContext, paramInt, paramString));
  }
  
  public void a(Context paramContext, int paramInt, String paramString, h5 paramh5)
  {
    if (paramh5 != null) {
      paramh5.a();
    }
    APLog.i("APBasePayChannel", "toFailResult");
    if (o.m().g(p4.p().e().f.e))
    {
      a(paramContext, paramh5);
      return;
    }
    if ((p.o().h()) && (p.o().j()) && (p.o().i()))
    {
      if ("mcard".equals(p4.p().e().f.e))
      {
        a(paramInt, paramString, true);
        return;
      }
      a(paramContext, -1, paramString);
      return;
    }
    a(paramInt, paramString, true);
  }
  
  public final void a(final Context paramContext, final int paramInt, final String paramString, final boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("context:");
    ((StringBuilder)localObject).append(paramContext);
    APLog.e("APBasePayChannel showRiskControlAlert", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("message:");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APBasePayChannel showRiskControlAlert", ((StringBuilder)localObject).toString());
    final int i1 = p4.p().e().b.saveType;
    if (paramBoolean) {
      localObject = "我知道了";
    } else {
      localObject = "取消";
    }
    String str;
    if (paramBoolean) {
      str = "";
    } else {
      str = "继续支付";
    }
    if (p4.p().j())
    {
      paramBoolean = true;
      localObject = "我知道了";
      str = "";
    }
    APAlertDialog.f localf = new APAlertDialog.f(paramContext);
    localf.a(paramString);
    localf.a((String)localObject, new e(i1, paramBoolean, paramString, paramInt));
    if (!TextUtils.isEmpty(str)) {
      localf.b(str, new f(i1, paramContext));
    }
    localf.b(new g(i1, paramBoolean, paramString, paramInt));
    try
    {
      localf.b();
      APDataReportManager.getInstance().insertData("sdk.rc.dialog.show", i1, null, this.d, c6.s0().O());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = this.f;
      if (paramContext != null) {
        paramContext.a(paramInt);
      }
    }
  }
  
  public abstract void a(Context paramContext, Bundle paramBundle);
  
  public abstract void a(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5);
  
  public void a(Context paramContext, String paramString)
  {
    paramContext = new APAlertDialog.f(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    final int i1 = p4.p().e().b.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i1, null, this.d, null);
    paramContext.b("确定", new n(i1));
    paramContext.b(new o(i1));
    try
    {
      paramContext.b();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.c = paramContext;
    a(-1, paramString, paramBoolean);
  }
  
  public void a(final Context paramContext, final h5 paramh5)
  {
    o.m();
    if (!o.l()) {
      return;
    }
    APUICommonMethod.c(paramContext);
    z1.d().h(this.d, new a(paramh5, paramContext));
  }
  
  public void a(Context paramContext, h5 paramh5, g5 paramg5)
  {
    this.c = paramContext;
    this.f = paramh5;
    this.e = paramg5;
    b();
    a(paramContext, null);
  }
  
  public abstract void a(Context paramContext, w3 paramw3);
  
  public void a(final Context paramContext, final x3.a parama)
  {
    if (parama != null) {
      APUICommonMethod.c(paramContext);
    }
    z1.d().a(this.d, new m(parama, paramContext), parama);
  }
  
  public void a(Context paramContext, x3.a parama, ob paramob, String paramString)
  {
    if (parama != null) {
      APUICommonMethod.a(paramContext);
    }
    parama = this.f;
    if (parama != null) {
      parama.a(paramob.d(), paramob.f(), paramob.f());
    }
    boolean bool = false;
    parama = this.b;
    if (parama != null) {
      bool = parama.getBoolean("isFromChannelList");
    }
    if (((!"cft".equals(paramString)) && (!"bank".equals(paramString))) || (bool))
    {
      parama = new StringBuilder();
      parama.append("系统繁忙:");
      parama.append(x1.a(paramob.d()));
      APUICommonMethod.a(paramContext, parama.toString());
    }
    if (!a.r().f)
    {
      APUICommonMethod.f();
      paramContext = new StringBuilder();
      paramContext.append("网络错误:");
      paramContext.append(paramob.d());
      z5.a(-1, paramContext.toString());
      return;
    }
    if (paramob.d() == 20101)
    {
      APUICommonMethod.f();
      paramContext = new StringBuilder();
      paramContext.append("网络错误:");
      paramContext.append(paramob.d());
      z5.a(5, paramContext.toString());
    }
  }
  
  public void a(final Context paramContext, final x3.a parama, final w3 paramw3, final String paramString)
  {
    z1.d().a(1, new p(parama, paramContext, paramw3, paramString));
  }
  
  public void a(final Bundle paramBundle)
  {
    if ((c6.s0().M()) && ((a.r().g == null) || (a.r().g.b.saveType == p4.p().e().b.saveType) || ((p4.p().e().b.saveType != 3) && (p4.p().e().b.saveType != 2))))
    {
      this.k.clear();
      this.l.clear();
      final APAlertDialog.f localf = new APAlertDialog.f(this.c);
      APAlertDialog.f.b(1);
      localf.a(false);
      localf.b();
      a(true, new w(localf, paramBundle));
      return;
    }
    if (c6.s0().P().equals("0"))
    {
      APUICommonMethod.f();
      z5.a(r6.e(p4.p().e().f.e), 0, 0);
      return;
    }
    b(paramBundle);
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("BasePayChannel", "Cannot save again with empty rcs msg!");
      return;
    }
    paramString = x3.a.a(paramString);
    if (!TextUtils.isEmpty(paramString.a))
    {
      APLog.d("BasePayChannel", "save again!");
      a(this.c, paramString);
      return;
    }
    APLog.e("BasePayChannel", "Cannot save again without token!");
  }
  
  public void a(String paramString, final fc paramfc)
  {
    z1.d().j(new s(paramfc));
  }
  
  public void a(boolean paramBoolean, z paramz)
  {
    APLog.i(m, "start to queryReceipt");
    final long l1 = System.currentTimeMillis();
    String str = m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryReceipt mStartPos:");
    localStringBuilder.append(this.i);
    localStringBuilder.append("  start:");
    localStringBuilder.append(l1);
    APLog.i(str, localStringBuilder.toString());
    z1.d().c(new v(l1, paramz), "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public final void b(int paramInt)
  {
    APAlertDialog.f localf = new APAlertDialog.f(this.c);
    localf.b("温馨提示");
    localf.a("取消", new h());
    if (paramInt == 10017)
    {
      localf.a("继续当前支付，成功购买后将取消原有话费支付关系。");
      localf.b("确定", new i());
    }
    else
    {
      localf.a("继续当前支付，成功购买的服务将在手机话费支付关闭后生效。");
      localf.b("确定", new j());
    }
    localf.b(new l());
    try
    {
      localf.b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    this.c = paramContext;
    a(paramContext, paramBundle);
  }
  
  public void b(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.c = paramContext;
    this.f = paramh5;
    this.e = paramg5;
    this.b = paramBundle;
    if ((r1.i()) && (r1.d(this.d)))
    {
      u1.c().a(paramContext, this, paramBundle, paramh5, paramg5);
      return;
    }
    a(paramContext, paramBundle, paramh5, paramg5);
  }
  
  public void b(Context paramContext, h5 paramh5)
  {
    APLog.i("APBasePayChannel", "toCancelResult");
    if (paramh5 != null) {
      paramh5.a();
    }
    if (o.m().g(p4.p().e().f.e)) {
      a(paramContext, paramh5);
    } else if ((p.o().h()) && (p.o().j()) && (p.o().i())) {
      a(paramContext, 0, "");
    } else {
      c();
    }
    if ((c6.s0().k0()) && ((paramContext instanceof Activity)))
    {
      paramContext = (Activity)paramContext;
      paramContext.finish();
      APUICommonMethod.a(paramContext);
    }
  }
  
  public void b(Context paramContext, w3 paramw3)
  {
    this.c = paramContext;
    APUICommonMethod.b();
    APLog.d("BasePayChannel", "progressSaveAns");
    int i1 = paramw3.d();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("progressSaveAns, ret = ");
    ((StringBuilder)localObject1).append(i1);
    APLog.d("BasePayChannel", ((StringBuilder)localObject1).toString());
    if (i1 != 1018)
    {
      boolean bool = true;
      if (i1 != 1138)
      {
        if (i1 != 1159)
        {
          if (i1 != 2022)
          {
            switch (i1)
            {
            default: 
              a(paramContext, paramw3);
              return;
            }
            b(i1);
            return;
          }
          APLog.d("BasePayChannel", "progressSaveAns, ret = risk control soft");
          localObject1 = new Intent();
          Object localObject2 = new Bundle();
          ((Bundle)localObject2).putString("pageName", y7.B);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          paramw3.f0.e = new t(new Handler(Looper.getMainLooper()));
          ((Intent)localObject1).putExtra("RiskControlSoftParam", paramw3.f0);
          ((Intent)localObject1).setExtrasClassLoader(paramw3.f0.getClass().getClassLoader());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("send rcsParam to rcs h5 page = ");
          ((StringBuilder)localObject2).append(paramw3.f0.toString());
          APLog.d("BasePayChannel", ((StringBuilder)localObject2).toString());
          if (h8.d(paramContext.getApplicationContext())) {
            ((Intent)localObject1).setClass(paramContext, APX5WebJSBridgeActivity.class);
          } else {
            ((Intent)localObject1).setClass(paramContext, APWebJSBridgeActivity.class);
          }
          paramContext.startActivity((Intent)localObject1);
          return;
        }
        a(i1, paramw3.f(), true);
        return;
      }
      localObject1 = APTools.a(paramw3.L(), 1);
      if (paramw3.M() != 1) {
        bool = false;
      }
      a(paramContext, i1, (String)localObject1, bool);
      return;
    }
    a.a("登录过期，请重新登录", paramContext);
  }
  
  public final void b(Bundle paramBundle)
  {
    if (this.c == null)
    {
      APUICommonMethod.f();
      z5.a(r6.e(p4.p().e().f.e), 0, 0);
      return;
    }
    try
    {
      localObject = new Intent();
      if (h8.d(this.c)) {
        ((Intent)localObject).setClass(this.c, APX5WebJSBridgeActivity.class);
      } else {
        ((Intent)localObject).setClass(this.c, APWebJSBridgeActivity.class);
      }
      if (paramBundle == null)
      {
        paramBundle = new Bundle();
        paramBundle.putString("pageName", y7.t);
        ((Intent)localObject).putExtras(paramBundle);
      }
      else
      {
        paramBundle.putString("pageName", y7.t);
        ((Intent)localObject).putExtras(paramBundle);
      }
      this.c.startActivity((Intent)localObject);
      return;
    }
    finally
    {
      paramBundle.printStackTrace();
      APUICommonMethod.f();
      Object localObject = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APBasePayChannel_toWebStore_");
      localStringBuilder.append(APTools.d(paramBundle));
      ((APDataReportManager)localObject).a("sdk.err.view", localStringBuilder.toString());
      z5.a(r6.e(p4.p().e().f.e), 0, 0);
    }
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public final void c()
  {
    if ((p4.p().e().f.e.equals(p4.p().e().b.mpInfo.payChannel)) && (!o.m().i()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from assign pay channel");
      APUICommonMethod.f();
      z5.a(2, "");
      return;
    }
    if ((e5.h().d()) && (!p4.p().e().b.isCanChange) && (!o.m().i()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from assign pay channel");
      APUICommonMethod.f();
      z5.a(2, "");
      return;
    }
    if ((!a.r().f) && (!c6.s0().A()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from anroidpay");
      APUICommonMethod.f();
      z5.a(2, "");
    }
  }
  
  public abstract void c(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5);
  
  public void c(Context paramContext, w3 paramw3)
  {
    if (!u1.c().a(paramContext, paramw3, this.d))
    {
      b(paramContext, paramw3);
      a();
    }
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public final void d()
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("resource", "backOrError");
    ((Intent)localObject).setClass(this.c, APGoldCouponsDeductSelectValueActivity.class);
    ((Activity)this.c).startActivityForResult((Intent)localObject, 1001);
    localObject = this.c;
    ((Activity)localObject).overridePendingTransition(z5.a((Context)localObject, "unipay_anim_in_from_right"), z5.a(this.c, "unipay_anim_out_to_left"));
  }
  
  public void d(Context paramContext, Bundle paramBundle, h5 paramh5, g5 paramg5)
  {
    this.c = paramContext;
    c(paramContext, paramBundle, paramh5, paramg5);
  }
  
  public void e()
  {
    a((Activity)this.c, this.h);
  }
  
  public void f()
  {
    if (j9.b.size() > 0) {}
    try
    {
      ((APRecoChannelActivity)this.c).a(2, 1, null);
      return;
    }
    catch (Exception localException)
    {
      label23:
      Intent localIntent;
      break label23;
    }
    localIntent = new Intent(this.c, APRecoChannelActivity.class);
    this.c.startActivity(localIntent);
    return;
    localIntent = new Intent(this.c, APRecoChannelActivity.class);
    this.c.startActivity(localIntent);
  }
  
  public class a
    implements fc
  {
    public a(h5 paramh5, Context paramContext) {}
    
    public void a(ob paramob)
    {
      if (paramob.d() != 0)
      {
        o.m().b();
        paramob = paramh5;
        if (paramob != null) {
          paramob.a(-100);
        }
      }
      APUICommonMethod.a(paramContext);
    }
    
    public void b(ob paramob)
    {
      o.m().b();
      APUICommonMethod.a(paramContext);
      paramob = paramh5;
      if (paramob != null) {
        paramob.a(-100);
      }
    }
    
    public void c(ob paramob)
    {
      o.m().b();
      APUICommonMethod.a(paramContext);
      paramob = paramh5;
      if (paramob != null) {
        paramob.a(-100);
      }
    }
  }
  
  public static class a0
  {
    public String a;
    public String b;
    
    public a0(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
  
  public class b
    implements fc
  {
    public b(Context paramContext, int paramInt, String paramString) {}
    
    public void a(ob paramob)
    {
      APUICommonMethod.a(paramContext);
      paramob = (w2)paramob;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("goldAns.getResultCode():");
      localStringBuilder.append(paramob.d());
      APLog.i("APTenpayActivity", localStringBuilder.toString());
      if (paramob.d() != 0)
      {
        APLog.i("APTenpayActivity", "goldAns.getResultCode()!=0");
        i5.e(i5.this);
        return;
      }
      int i = paramInt;
      if (-1 == i)
      {
        i5.this.a(paramob.d(), paramString, true);
        return;
      }
      if (i == 0) {
        i5.f(i5.this);
      }
    }
    
    public void b(ob paramob)
    {
      APUICommonMethod.a(paramContext);
      i5.e(i5.this);
    }
    
    public void c(ob paramob) {}
  }
  
  public class c
    implements c7
  {
    public c(boolean paramBoolean, int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((!paramBoolean) && (a.r().f))
      {
        paramAPAlertDialog.f();
        return;
      }
      paramAPAlertDialog.f();
      APUICommonMethod.f();
      z5.a(paramInt, "");
    }
  }
  
  public class d
    implements c7
  {
    public d(boolean paramBoolean, int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && ((paramBoolean) || (!a.r().f)))
      {
        APUICommonMethod.f();
        z5.a(paramInt, "");
      }
    }
  }
  
  public class e
    implements c7
  {
    public e(int paramInt1, boolean paramBoolean, String paramString, int paramInt2) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.rc.dialog.hide", i1, null, i5.this.d, c6.s0().O());
      if ((!paramBoolean) && (a.r().f))
      {
        paramAPAlertDialog.f();
        paramAPAlertDialog = i5.this.f;
        if (paramAPAlertDialog != null) {
          paramAPAlertDialog.a(paramInt);
        }
      }
      else
      {
        paramAPAlertDialog.f();
        APUICommonMethod.f();
        paramAPAlertDialog = new StringBuilder();
        paramAPAlertDialog.append("resultCode=1138&msg=");
        paramAPAlertDialog.append(paramString);
        z5.a(-1, paramAPAlertDialog.toString());
      }
    }
  }
  
  public class f
    implements c7
  {
    public f(int paramInt, Context paramContext) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      APDataReportManager.getInstance().insertData("sdk.rc.dialog.resave", i1, null, i5.this.d, c6.s0().O());
      i5.this.a(paramContext, null);
    }
  }
  
  public class g
    implements c7
  {
    public g(int paramInt1, boolean paramBoolean, String paramString, int paramInt2) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.rc.dialog.back", i1, null, i5.this.d, c6.s0().O());
        if ((!paramBoolean) && (a.r().f))
        {
          paramAPAlertDialog.f();
          paramAPAlertDialog = i5.this.f;
          if (paramAPAlertDialog != null) {
            paramAPAlertDialog.a(paramInt);
          }
        }
        else
        {
          paramAPAlertDialog.f();
          APUICommonMethod.f();
          paramAPAlertDialog = new StringBuilder();
          paramAPAlertDialog.append("resultCode=1138&msg=");
          paramAPAlertDialog.append(paramString);
          z5.a(-1, paramAPAlertDialog.toString());
        }
      }
    }
  }
  
  public class h
    implements c7
  {
    public h() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      c6.s0().a(0);
      if (!a.r().f)
      {
        paramAPAlertDialog.f();
        APUICommonMethod.f();
        z5.a(-1, "");
        return;
      }
      paramAPAlertDialog.f();
    }
  }
  
  public class i
    implements c7
  {
    public i() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      c6.s0().a(1);
      paramAPAlertDialog.f();
      paramAPAlertDialog = i5.this;
      paramAPAlertDialog.a(paramAPAlertDialog.c, paramAPAlertDialog.f, paramAPAlertDialog.e);
    }
  }
  
  public class j
    implements c7
  {
    public j() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      c6.s0().a(2);
      paramAPAlertDialog.f();
      paramAPAlertDialog = i5.this;
      paramAPAlertDialog.a(paramAPAlertDialog.c, paramAPAlertDialog.f, paramAPAlertDialog.e);
    }
  }
  
  public class k
    extends ResultReceiver
  {
    public k(Handler paramHandler)
    {
      super();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channelCallbackReceiver resultCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" resultData = ");
      localStringBuilder.append(paramBundle);
      APLog.i("APBasePayChannel", localStringBuilder.toString());
      if ((r1.g()) && (r1.d(i5.this.d)))
      {
        t1.b().a(i5.this.d, 0, paramInt, paramBundle);
        return;
      }
      i5.this.a(paramInt, paramBundle);
    }
  }
  
  public class l
    implements c7
  {
    public l() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        c6.s0().a(0);
        if (!a.r().f)
        {
          paramAPAlertDialog.f();
          APUICommonMethod.f();
          z5.a(-1, "");
          return;
        }
        paramAPAlertDialog.f();
      }
    }
  }
  
  public class m
    implements fc
  {
    public m(x3.a parama, Context paramContext) {}
    
    public void a(ob paramob)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveReq() onSuccess() ans.getResultCode = ");
      localStringBuilder.append(paramob.d());
      APLog.d("BasePayChannel", localStringBuilder.toString());
      if (parama != null) {
        APUICommonMethod.a(paramContext);
      }
      i5.this.c(paramContext, (w3)paramob);
      if ((i5.this.f != null) && (paramob.d() != 1138)) {
        i5.this.f.a(paramob.d());
      }
    }
    
    public void b(ob paramob)
    {
      String str = p4.p().e().f.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveReq() onFailure() ans.getResultCode = ");
      localStringBuilder.append(paramob.d());
      APLog.d("BasePayChannel", localStringBuilder.toString());
      if ((("qdqb".equals(str)) || ("qbqd".equals(str)) || ("qqcard".equals(str))) && (paramob.d() == 20002))
      {
        i5.this.a(paramContext, parama, (w3)paramob, str);
        return;
      }
      i5.this.a(paramContext, parama, paramob, str);
    }
    
    public void c(ob paramob)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveReq() onStop() ans.getResultCode = ");
      localStringBuilder.append(paramob.d());
      APLog.d("BasePayChannel", localStringBuilder.toString());
      if (parama != null) {
        APUICommonMethod.a(paramContext);
      }
      paramob = i5.this.f;
      if (paramob != null) {
        paramob.a();
      }
    }
  }
  
  public class n
    implements c7
  {
    public n(int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      APDataReportManager.getInstance().insertData("sdk.notenough.sure", i1, null, i5.this.d, null);
      paramAPAlertDialog.f();
    }
  }
  
  public class o
    implements c7
  {
    public o(int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i1, null, i5.this.d, null);
        paramAPAlertDialog.f();
      }
    }
  }
  
  public class p
    implements fc
  {
    public p(x3.a parama, Context paramContext, w3 paramw3, String paramString) {}
    
    public void a(ob paramob)
    {
      q3 localq3 = (q3)paramob;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryPayResult() onSuccess() ans.getResultCode=");
      localStringBuilder.append(paramob.d());
      localStringBuilder.append(", ans.getProvideResult = ");
      localStringBuilder.append(localq3.g());
      APLog.d("BasePayChannel", localStringBuilder.toString());
      if ((localq3.d() == 0) && (localq3.g() == 1))
      {
        if (parama != null) {
          APUICommonMethod.a(paramContext);
        }
        paramob = i5.this.f;
        if (paramob != null) {
          paramob.a(0);
        }
        i5.this.a(null);
        return;
      }
      i5.this.a(paramContext, parama, paramw3, paramString);
    }
    
    public void b(ob paramob)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryPayResult() onFailure() ans.getResultCode=");
      localStringBuilder.append(paramob.d());
      APLog.d("BasePayChannel", localStringBuilder.toString());
      i5.this.a(paramContext, parama, paramw3, paramString);
    }
    
    public void c(ob paramob)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryPayResult() onStop() ans.getResultCode=");
      localStringBuilder.append(paramob.d());
      APLog.d("BasePayChannel", localStringBuilder.toString());
      i5.this.a(paramContext, parama, paramw3, paramString);
    }
  }
  
  public static final class q
    implements c7
  {
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
    }
  }
  
  public class r
    extends l1
  {
    public r() {}
    
    public void a(String paramString1, String paramString2, String paramString3)
    {
      g6.k().a(true);
      paramString1 = i5.this;
      paramString1.a(paramString1.c, paramString1.f, paramString1.e);
    }
    
    public void c()
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loginCallBack onLoginFail stateCallback:");
      ((StringBuilder)localObject).append(i5.this.f);
      APLog.i("APBasePayChannel", ((StringBuilder)localObject).toString());
      localObject = i5.this.f;
      if (localObject != null) {
        ((h5)localObject).a();
      }
    }
    
    public void d()
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loginCallBack onLoginFail stateCallback:");
      ((StringBuilder)localObject).append(i5.this.f);
      APLog.i("APBasePayChannel", ((StringBuilder)localObject).toString());
      localObject = i5.this.f;
      if (localObject != null) {
        ((h5)localObject).a();
      }
      i5.b(i5.this.c, "您购买业务未提供QQ授权信息，暂时无法使用Q币支付，请咨询客服或更换其他支付渠道。（错误码：-6）");
    }
  }
  
  public class s
    implements fc
  {
    public s(fc paramfc) {}
    
    public void a(ob paramob)
    {
      paramfc.a(paramob);
    }
    
    public void b(ob paramob)
    {
      paramfc.b(paramob);
    }
    
    public void c(ob paramob)
    {
      paramfc.c(paramob);
    }
  }
  
  public class t
    extends ResultReceiver
  {
    public t(Handler paramHandler)
    {
      super();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      super.onReceiveResult(paramInt, paramBundle);
      if (paramInt == 0)
      {
        paramBundle = paramBundle.getString("rcs_msg");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Got rcs_msg from rcs h5 page = ");
        localStringBuilder.append(paramBundle);
        APLog.d("BasePayChannel", localStringBuilder.toString());
        i5.a(i5.this, paramBundle);
        return;
      }
      if (paramInt == -1)
      {
        paramBundle = i5.this;
        if ((paramBundle.f != null) && ("hfpay".equals(paramBundle.d))) {
          i5.this.f.a(-10077, "", "");
        }
      }
    }
  }
  
  public class u
    implements Runnable
  {
    public u(i5.z paramz) {}
    
    public void run()
    {
      i5.this.a(false, paramz);
    }
  }
  
  public class v
    implements fc
  {
    public v(long paramLong, i5.z paramz) {}
    
    public void a(ob paramob)
    {
      long l = System.currentTimeMillis();
      Object localObject1 = i5.g();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("queryReceipt mStartPos:");
      ((StringBuilder)localObject2).append(i5.a(i5.this));
      ((StringBuilder)localObject2).append("  end:");
      ((StringBuilder)localObject2).append(l);
      APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
      l = (l - l1) / 1000L;
      localObject1 = i5.g();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("queryReceipt mStartPos:");
      ((StringBuilder)localObject2).append(i5.a(i5.this));
      ((StringBuilder)localObject2).append("  interval:");
      ((StringBuilder)localObject2).append(l);
      APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject2 = (s3)paramob;
      i5.b(i5.this).add(Long.valueOf(l));
      i5.c(i5.this).add(Integer.valueOf(paramob.d()));
      if (paramob.d() == 0)
      {
        if (i5.d(i5.this) == i5.n)
        {
          i5.a(i5.this, ((s3)localObject2).g());
          paramob = i5.g();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mStartPos:");
          ((StringBuilder)localObject1).append(i5.a(i5.this));
          ((StringBuilder)localObject1).append("  QueryPeriod:");
          ((StringBuilder)localObject1).append(i5.d(i5.this).toString());
          APLog.i(paramob, ((StringBuilder)localObject1).toString());
        }
        paramob = null;
        try
        {
          localObject1 = new JSONArray(((s3)localObject2).g);
          paramob = (ob)localObject1;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        if ((paramob != null) && (paramob.length() != 0))
        {
          this.b.a(0, ((s3)localObject2).g);
          return;
        }
        i5.this.a(l, this.b);
        return;
      }
      i5.this.a(l, this.b);
    }
    
    public void b(ob paramob)
    {
      this.b.a(1, "");
    }
    
    public void c(ob paramob)
    {
      this.b.a(5, "");
    }
  }
  
  public class w
    implements i5.z
  {
    public w(APAlertDialog.f paramf, Bundle paramBundle) {}
    
    public void a(int paramInt, String paramString)
    {
      localf.a();
      if (paramInt == 0)
      {
        try
        {
          paramString = new JSONArray(paramString);
          if (paramString.length() != 0)
          {
            a.r().e.mAPPurchase = new APPurchase(paramString.getJSONObject(0).toString());
            if (p4.p().e().b != null) {
              a.r().e.mAPPurchase.mSku = ((APGoodsRequest)p4.p().e().b).prodcutId;
            }
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        if (c6.s0().P().equals("0"))
        {
          APUICommonMethod.f();
          z5.a(r6.e(p4.p().e().f.e), 0, 0);
        }
        else
        {
          i5.a(i5.this, paramBundle);
        }
        paramString = APDataReportManager.getInstance();
        locali5 = i5.this;
        paramString.insertData("sdk.result.receipt.success", 1, null, locali5.d, locali5.a(0));
        return;
      }
      paramString = APDataReportManager.getInstance();
      i5 locali5 = i5.this;
      paramString.insertData("sdk.result.receipt.failed", 1, null, locali5.d, locali5.a(paramInt));
      APUICommonMethod.f();
      z5.a(101, -1, "未查询到支付结果，请稍后重试");
    }
  }
  
  public class x
    implements c7
  {
    public x(int paramInt) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      APUICommonMethod.f();
      z5.a(paramInt, -1, -1);
    }
  }
  
  public class y
    implements c7
  {
    public y() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        APUICommonMethod.f();
        z5.a(-1, "");
      }
    }
  }
  
  public static abstract interface z
  {
    public abstract void a(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.i5
 * JD-Core Version:    0.7.0.1
 */