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
import com.pay.ui.common.APAlertDialog.a;
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

public abstract class ew
  implements Cloneable
{
  public static ArrayList<Long> a = new ArrayList();
  private static final String i = "ew";
  final Handler b = new Handler();
  public Bundle c;
  public Context d;
  public String e;
  public eu f;
  public ev g;
  bk h = new bk()
  {
    public void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
    {
      fs.a().a(true);
      ew.this.a(ew.this.d, ew.this.g, ew.this.f);
    }
    
    public void c()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loginCallBack onLoginFail stateCallback:");
      localStringBuilder.append(ew.this.g);
      APLog.i("APBasePayChannel", localStringBuilder.toString());
      if (ew.this.g != null) {
        ew.this.g.a();
      }
    }
  };
  private final int j = 0;
  private final int k = -1;
  private int l = 0;
  private ArrayList<Long> m = a;
  private ArrayList<Long> n = new ArrayList();
  private ArrayList<Integer> o = new ArrayList();
  
  static
  {
    a.add(Long.valueOf(0L));
    a.add(Long.valueOf(5L));
    a.add(Long.valueOf(10L));
    a.add(Long.valueOf(15L));
    a.add(Long.valueOf(20L));
    a.add(Long.valueOf(40L));
    a.add(Long.valueOf(60L));
  }
  
  private void a(final Context paramContext, final int paramInt, final String paramString)
  {
    APUICommonMethod.b(paramContext);
    a.a().a(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        APUICommonMethod.c(paramContext);
        paramAnonymousjw = (cp)paramAnonymousjw;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("goldAns.getResultCode():");
        localStringBuilder.append(paramAnonymousjw.R());
        APLog.i("APTenpayActivity", localStringBuilder.toString());
        if (paramAnonymousjw.R() != 0)
        {
          APLog.i("APTenpayActivity", "goldAns.getResultCode()!=0");
          ew.e(ew.this);
          return;
        }
        if (-1 == paramInt)
        {
          ew.this.a(paramAnonymousjw.R(), paramString, true);
          return;
        }
        if (paramInt == 0) {
          ew.f(ew.this);
        }
      }
      
      public void b(jw paramAnonymousjw)
      {
        APUICommonMethod.c(paramContext);
        ew.e(ew.this);
      }
      
      public void c(jw paramAnonymousjw) {}
    });
  }
  
  private void a(final Context paramContext, final int paramInt, final String paramString, final boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("context:");
    ((StringBuilder)localObject).append(paramContext);
    APLog.e("APBasePayChannel showRiskControlAlert", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("message:");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APBasePayChannel showRiskControlAlert", ((StringBuilder)localObject).toString());
    final int i1 = ed.b().n().a.saveType;
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
    if (ed.b().k())
    {
      localObject = "我知道了";
      str = "";
      paramBoolean = true;
    }
    APAlertDialog.a locala = new APAlertDialog.a(paramContext);
    locala.a(paramString);
    locala.b((String)localObject, new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.rc.dialog.hide", i1, null, ew.this.e, fp.a().aa());
        if ((!paramBoolean) && (a.a().f))
        {
          paramAnonymousAPAlertDialog.a();
          if (ew.this.g != null) {
            ew.this.g.a(paramInt);
          }
        }
        else
        {
          paramAnonymousAPAlertDialog.a();
          APUICommonMethod.b();
          paramAnonymousAPAlertDialog = new StringBuilder();
          paramAnonymousAPAlertDialog.append("resultCode=1138&msg=");
          paramAnonymousAPAlertDialog.append(paramString);
          fm.a(-1, paramAnonymousAPAlertDialog.toString());
        }
      }
    });
    if (!TextUtils.isEmpty(str)) {
      locala.a(str, new gn()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          paramAnonymousAPAlertDialog.a();
          APDataReportManager.getInstance().insertData("sdk.rc.dialog.resave", i1, null, ew.this.e, fp.a().aa());
          ew.this.a(paramContext, null);
        }
      });
    }
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.rc.dialog.back", i1, null, ew.this.e, fp.a().aa());
          if ((!paramBoolean) && (a.a().f))
          {
            paramAnonymousAPAlertDialog.a();
            if (ew.this.g != null) {
              ew.this.g.a(paramInt);
            }
          }
          else
          {
            paramAnonymousAPAlertDialog.a();
            APUICommonMethod.b();
            paramAnonymousAPAlertDialog = new StringBuilder();
            paramAnonymousAPAlertDialog.append("resultCode=1138&msg=");
            paramAnonymousAPAlertDialog.append(paramString);
            fm.a(-1, paramAnonymousAPAlertDialog.toString());
          }
        }
      }
    });
    try
    {
      locala.c();
      APDataReportManager.getInstance().insertData("sdk.rc.dialog.show", i1, null, this.e, fp.a().aa());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      if (this.g != null) {
        this.g.a(paramInt);
      }
    }
  }
  
  private void b(int paramInt)
  {
    APAlertDialog.a locala = new APAlertDialog.a(this.d);
    locala.b("温馨提示");
    locala.b("取消", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        fp.a().b(0);
        if (!a.a().f)
        {
          paramAnonymousAPAlertDialog.a();
          APUICommonMethod.b();
          fm.a(-1, "");
          return;
        }
        paramAnonymousAPAlertDialog.a();
      }
    });
    if (paramInt == 10017)
    {
      locala.a("继续当前支付，成功购买后将取消原有话费支付关系。");
      locala.a("确定", new gn()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          fp.a().b(1);
          paramAnonymousAPAlertDialog.a();
          ew.this.a(ew.this.d, ew.this.g, ew.this.f);
        }
      });
    }
    else
    {
      locala.a("继续当前支付，成功购买的服务将在手机话费支付关闭后生效。");
      locala.a("确定", new gn()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          fp.a().b(2);
          paramAnonymousAPAlertDialog.a();
          ew.this.a(ew.this.d, ew.this.g, ew.this.f);
        }
      });
    }
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          fp.a().b(0);
          if (!a.a().f)
          {
            paramAnonymousAPAlertDialog.a();
            APUICommonMethod.b();
            fm.a(-1, "");
            return;
          }
          paramAnonymousAPAlertDialog.a();
        }
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void b(Bundle paramBundle)
  {
    if (this.d == null)
    {
      APUICommonMethod.b();
      fm.a(gd.a(ed.b().n().e.f), 0, 0);
      return;
    }
    try
    {
      localObject = new Intent();
      if (hs.b(this.d)) {
        ((Intent)localObject).setClass(this.d, APX5WebJSBridgeActivity.class);
      } else {
        ((Intent)localObject).setClass(this.d, APWebJSBridgeActivity.class);
      }
      if (paramBundle == null)
      {
        paramBundle = new Bundle();
        paramBundle.putString("pageName", hj.v);
        ((Intent)localObject).putExtras(paramBundle);
      }
      else
      {
        paramBundle.putString("pageName", hj.v);
        ((Intent)localObject).putExtras(paramBundle);
      }
      this.d.startActivity((Intent)localObject);
      return;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      APUICommonMethod.b();
      Object localObject = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APBasePayChannel_toWebStore_");
      localStringBuilder.append(APTools.d(paramBundle));
      ((APDataReportManager)localObject).a("sdk.err.view", localStringBuilder.toString());
      fm.a(gd.a(ed.b().n().e.f), 0, 0);
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("BasePayChannel", "Cannot save again with empty rcs msg!");
      return;
    }
    paramString = dm.a.b(paramString);
    if (!TextUtils.isEmpty(paramString.a))
    {
      APLog.d("BasePayChannel", "save again!");
      a(this.d, paramString);
      return;
    }
    APLog.e("BasePayChannel", "Cannot save again without token!");
  }
  
  private void f()
  {
    if ((ed.b().n().e.f.equals(ed.b().n().a.mpInfo.payChannel)) && (!n.a().h()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from assign pay channel");
      APUICommonMethod.b();
      fm.a(2, "");
      return;
    }
    if ((es.a().f()) && (!ed.b().n().a.isCanChange) && (!n.a().h()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from assign pay channel");
      APUICommonMethod.b();
      fm.a(2, "");
      return;
    }
    if ((!a.a().f) && (!fp.a().J()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from anroidpay");
      APUICommonMethod.b();
      fm.a(2, "");
    }
  }
  
  private void g()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("resource", "backOrError");
    localIntent.setClass(this.d, APGoldCouponsDeductSelectValueActivity.class);
    ((Activity)this.d).startActivityForResult(localIntent, 1001);
    ((Activity)this.d).overridePendingTransition(fm.a(this.d, "unipay_anim_in_from_right"), fm.a(this.d, "unipay_anim_out_to_left"));
  }
  
  public long a(long paramLong)
  {
    int i1 = this.l;
    while (i1 < this.m.size() - 2)
    {
      long l1 = ((Long)this.m.get(this.l)).longValue() + paramLong;
      if (l1 >= ((Long)this.m.get(i1)).longValue())
      {
        ArrayList localArrayList = this.m;
        int i2 = i1 + 1;
        if (l1 < ((Long)localArrayList.get(i2)).longValue())
        {
          this.l = i2;
          return ((Long)this.m.get(i2)).longValue() - l1;
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
      while (paramInt < this.n.size())
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("inter", this.n.get(paramInt));
        ((JSONObject)localObject2).put("code", this.o.get(paramInt));
        ((JSONArray)localObject1).put(localObject2);
        paramInt += 1;
      }
      localJSONObject.put("plist", localObject1);
      localObject1 = i;
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
  
  public void a(final int paramInt, String paramString, final boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("context:");
    ((StringBuilder)localObject).append(this.d);
    APLog.e("APBasePayChannel showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("message:");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APBasePayChannel showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new APAlertDialog.a(this.d);
    String str = ed.b().n().e.f;
    if ("hfpay".equals(str))
    {
      if (!TextUtils.isEmpty(paramString)) {
        ((APAlertDialog.a)localObject).a(paramString);
      } else {
        ((APAlertDialog.a)localObject).a(this.d.getString(2131230795));
      }
    }
    else if ("mcard".equals(str))
    {
      if (!TextUtils.isEmpty(paramString)) {
        ((APAlertDialog.a)localObject).a(paramString);
      } else {
        ((APAlertDialog.a)localObject).a(this.d.getString(2131230812));
      }
    }
    else {
      ((APAlertDialog.a)localObject).a(paramString);
    }
    ((APAlertDialog.a)localObject).a("我知道了", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((!paramBoolean) && (a.a().f))
        {
          paramAnonymousAPAlertDialog.a();
          return;
        }
        paramAnonymousAPAlertDialog.a();
        APUICommonMethod.b();
        fm.a(paramInt, "");
      }
    });
    ((APAlertDialog.a)localObject).b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0) && ((paramBoolean) || (!a.a().f)))
        {
          APUICommonMethod.b();
          fm.a(paramInt, "");
        }
      }
    });
    try
    {
      ((APAlertDialog.a)localObject).c();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(long paramLong, final a parama)
  {
    APLog.i(i, "queryReceiptAgain start to queryReceiptAgain");
    Runnable local16 = new Runnable()
    {
      public void run()
      {
        ew.this.a(false, parama);
      }
    };
    if (((Long)this.m.get(this.l)).longValue() + paramLong >= ((Long)this.m.get(this.m.size() - 1)).longValue())
    {
      APLog.i(i, "queryReceiptAgain Timeout exit");
      this.b.removeCallbacks(local16);
      parama.a(4, "");
      return;
    }
    paramLong = a(paramLong);
    String str = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryReceiptAgain mStartPos:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("  next:");
    localStringBuilder.append(paramLong);
    APLog.i(str, localStringBuilder.toString());
    if (paramLong != -1L)
    {
      this.b.postDelayed(local16, paramLong * 1000L);
      return;
    }
    this.b.removeCallbacks(local16);
    parama.a(4, "");
  }
  
  public void a(Activity paramActivity, bk parambk)
  {
    APPluginActivity localAPPluginActivity = (APPluginActivity)paramActivity;
    bl.a().a(paramActivity, localAPPluginActivity.mActivity, fp.a().ab(), parambk);
  }
  
  protected void a(Context paramContext, final int paramInt)
  {
    APLog.i("APBasePayChannel", "toUnkownResult");
    if (this.g != null) {
      this.g.a();
    }
    APAlertDialog.a locala = new APAlertDialog.a(paramContext);
    locala.b("提示");
    String str = ed.b().n().e.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelId:");
    localStringBuilder.append(str);
    APLog.i("APBasePayChannel", localStringBuilder.toString());
    if ("hfpay".equals(str)) {
      locala.a(paramContext.getString(2131230795));
    } else if ("mcard".equals(str)) {
      locala.a(paramContext.getString(2131230812));
    }
    locala.a("我知道了", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
        APUICommonMethod.b();
        fm.a(paramInt, -1, -1);
      }
    });
    locala.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APUICommonMethod.b();
          fm.a(-1, "");
        }
      }
    });
    try
    {
      locala.c();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected void a(Context paramContext, int paramInt, String paramString, ev paramev)
  {
    if (paramev != null) {
      paramev.a();
    }
    APLog.i("APBasePayChannel", "toFailResult");
    if (n.a().c(ed.b().n().e.f))
    {
      b(paramContext, paramev);
      return;
    }
    if ((o.a().b()) && (o.a().o()) && (o.a().d()))
    {
      if ("mcard".equals(ed.b().n().e.f))
      {
        a(paramInt, paramString, true);
        return;
      }
      a(paramContext, -1, paramString);
      return;
    }
    a(paramInt, paramString, true);
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    this.d = paramContext;
    b(paramContext, paramBundle);
  }
  
  public void a(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.d = paramContext;
    this.g = paramev;
    this.f = parameu;
    c(paramContext, paramBundle, paramev, parameu);
  }
  
  protected void a(Context paramContext, String paramString)
  {
    paramContext = new APAlertDialog.a(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    final int i1 = ed.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i1, null, this.e, null);
    paramContext.a("确定", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.sure", i1, null, ew.this.e, null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    paramContext.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i1, null, ew.this.e, null);
          paramAnonymousAPAlertDialog.a();
        }
      }
    });
    try
    {
      paramContext.c();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.d = paramContext;
    a(-1, paramString, paramBoolean);
  }
  
  protected void a(Context paramContext, dl paramdl)
  {
    c(paramContext, paramdl);
    b();
  }
  
  protected void a(final Context paramContext, final dm.a parama)
  {
    if (parama != null) {
      APUICommonMethod.b(paramContext);
    }
    bs.a().a(this.e, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveReq() onSuccess() ans.getResultCode = ");
        localStringBuilder.append(paramAnonymousjw.R());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        if (parama != null) {
          APUICommonMethod.c(paramContext);
        }
        ew.this.a(paramContext, (dl)paramAnonymousjw);
        if ((ew.this.g != null) && (paramAnonymousjw.R() != 1138)) {
          ew.this.g.a(paramAnonymousjw.R());
        }
      }
      
      public void b(jw paramAnonymousjw)
      {
        String str = ed.b().n().e.f;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveReq() onFailure() ans.getResultCode = ");
        localStringBuilder.append(paramAnonymousjw.R());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        if ((("qdqb".equals(str)) || ("qbqd".equals(str)) || ("qqcard".equals(str))) && (paramAnonymousjw.R() == 20002))
        {
          ew.this.a(paramContext, parama, (dl)paramAnonymousjw, str);
          return;
        }
        ew.this.a(paramContext, parama, paramAnonymousjw, str);
      }
      
      public void c(jw paramAnonymousjw)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveReq() onStop() ans.getResultCode = ");
        localStringBuilder.append(paramAnonymousjw.R());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        if (parama != null) {
          APUICommonMethod.c(paramContext);
        }
        if (ew.this.g != null) {
          ew.this.g.a();
        }
      }
    }, parama);
  }
  
  public void a(final Context paramContext, final dm.a parama, final dl paramdl, final String paramString)
  {
    bs.a().a(1, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        df localdf = (df)paramAnonymousjw;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryPayResult() onSuccess() ans.getResultCode=");
        localStringBuilder.append(paramAnonymousjw.R());
        localStringBuilder.append(", ans.getProvideResult = ");
        localStringBuilder.append(localdf.a());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        if ((localdf.R() == 0) && (localdf.a() == 1))
        {
          if (parama != null) {
            APUICommonMethod.c(paramContext);
          }
          if (ew.this.g != null) {
            ew.this.g.a(0);
          }
          ew.this.a(null);
          return;
        }
        ew.this.a(paramContext, parama, paramdl, paramString);
      }
      
      public void b(jw paramAnonymousjw)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryPayResult() onFailure() ans.getResultCode=");
        localStringBuilder.append(paramAnonymousjw.R());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        ew.this.a(paramContext, parama, paramdl, paramString);
      }
      
      public void c(jw paramAnonymousjw)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryPayResult() onStop() ans.getResultCode=");
        localStringBuilder.append(paramAnonymousjw.R());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        ew.this.a(paramContext, parama, paramdl, paramString);
      }
    });
  }
  
  protected void a(Context paramContext, dm.a parama, jw paramjw, String paramString)
  {
    if (parama != null) {
      APUICommonMethod.c(paramContext);
    }
    if (this.g != null) {
      this.g.a(paramjw.R(), paramjw.S(), paramjw.S());
    }
    boolean bool = false;
    if (this.c != null) {
      bool = this.c.getBoolean("isFromChannelList");
    }
    if (((!"cft".equals(paramString)) && (!"bank".equals(paramString))) || (bool))
    {
      parama = new StringBuilder();
      parama.append("系统繁忙:");
      parama.append(bq.a(paramjw.R()));
      APUICommonMethod.a(paramContext, parama.toString());
    }
    if (!a.a().f)
    {
      APUICommonMethod.b();
      paramContext = new StringBuilder();
      paramContext.append("网络错误:");
      paramContext.append(paramjw.R());
      fm.a(-1, paramContext.toString());
    }
  }
  
  public void a(Context paramContext, ev paramev)
  {
    APLog.i("APBasePayChannel", "toCancelResult");
    if (paramev != null) {
      paramev.a();
    }
    if (n.a().c(ed.b().n().e.f)) {
      b(paramContext, paramev);
    } else if ((o.a().b()) && (o.a().o()) && (o.a().d())) {
      a(paramContext, 0, "");
    } else {
      f();
    }
    if ((fp.a().ad()) && ((paramContext instanceof Activity)))
    {
      paramContext = (Activity)paramContext;
      paramContext.finish();
      APUICommonMethod.b(paramContext);
    }
  }
  
  public void a(Context paramContext, ev paramev, eu parameu)
  {
    this.d = paramContext;
    this.g = paramev;
    this.f = parameu;
    a();
    a(paramContext, null);
  }
  
  public void a(final Bundle paramBundle)
  {
    if ((fp.a().S()) && ((a.a().g == null) || (a.a().g.a.saveType == ed.b().n().a.saveType) || ((ed.b().n().a.saveType != 3) && (ed.b().n().a.saveType != 2))))
    {
      this.n.clear();
      this.o.clear();
      final APAlertDialog.a locala = new APAlertDialog.a(this.d);
      APAlertDialog.a.a(1);
      locala.a(false);
      locala.c();
      a(true, new a()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString)
        {
          locala.d();
          if (paramAnonymousInt == 0)
          {
            try
            {
              paramAnonymousString = new JSONArray(paramAnonymousString);
              if (paramAnonymousString.length() != 0)
              {
                a.a().e.mAPPurchase = new APPurchase(paramAnonymousString.getJSONObject(0).toString());
                if (ed.b().n().a != null) {
                  a.a().e.mAPPurchase.mSku = ((APGoodsRequest)ed.b().n().a).prodcutId;
                }
              }
            }
            catch (Exception paramAnonymousString)
            {
              paramAnonymousString.printStackTrace();
            }
            if (fp.a().G().equals("0"))
            {
              APUICommonMethod.b();
              fm.a(gd.a(ed.b().n().e.f), 0, 0);
            }
            else
            {
              ew.a(ew.this, paramBundle);
            }
            APDataReportManager.getInstance().insertData("sdk.result.receipt.success", 1, null, ew.this.e, ew.this.a(0));
            return;
          }
          APDataReportManager.getInstance().insertData("sdk.result.receipt.failed", 1, null, ew.this.e, ew.this.a(paramAnonymousInt));
          APUICommonMethod.b();
          fm.a(101, -1, "未查询到支付结果，请稍后重试");
        }
      });
      return;
    }
    if (fp.a().G().equals("0"))
    {
      APUICommonMethod.b();
      fm.a(gd.a(ed.b().n().e.f), 0, 0);
      return;
    }
    b(paramBundle);
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean, a parama)
  {
    APLog.i(i, "start to queryReceipt");
    final long l1 = System.currentTimeMillis();
    String str = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryReceipt mStartPos:");
    localStringBuilder.append(this.l);
    localStringBuilder.append("  start:");
    localStringBuilder.append(l1);
    APLog.i(str, localStringBuilder.toString());
    bs.a().a(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        long l = System.currentTimeMillis();
        Object localObject1 = ew.e();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryReceipt mStartPos:");
        ((StringBuilder)localObject2).append(ew.a(ew.this));
        ((StringBuilder)localObject2).append("  end:");
        ((StringBuilder)localObject2).append(l);
        APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
        l = (l - l1) / 1000L;
        localObject1 = ew.e();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryReceipt mStartPos:");
        ((StringBuilder)localObject2).append(ew.a(ew.this));
        ((StringBuilder)localObject2).append("  interval:");
        ((StringBuilder)localObject2).append(l);
        APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
        localObject2 = (dh)paramAnonymousjw;
        ew.b(ew.this).add(Long.valueOf(l));
        ew.c(ew.this).add(Integer.valueOf(paramAnonymousjw.R()));
        if (paramAnonymousjw.R() == 0)
        {
          if (ew.d(ew.this) == ew.a)
          {
            ew.a(ew.this, ((dh)localObject2).a());
            paramAnonymousjw = ew.e();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("mStartPos:");
            ((StringBuilder)localObject1).append(ew.a(ew.this));
            ((StringBuilder)localObject1).append("  QueryPeriod:");
            ((StringBuilder)localObject1).append(ew.d(ew.this).toString());
            APLog.i(paramAnonymousjw, ((StringBuilder)localObject1).toString());
          }
          paramAnonymousjw = null;
          try
          {
            localObject1 = new JSONArray(((dh)localObject2).a);
            paramAnonymousjw = (jw)localObject1;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          if ((paramAnonymousjw != null) && (paramAnonymousjw.length() != 0))
          {
            this.b.a(0, ((dh)localObject2).a);
            return;
          }
          ew.this.a(l, this.b);
          return;
        }
        ew.this.a(l, this.b);
      }
      
      public void b(jw paramAnonymousjw)
      {
        this.b.a(1, "");
      }
      
      public void c(jw paramAnonymousjw)
      {
        this.b.a(5, "");
      }
    }, "");
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public abstract void b(Context paramContext, Bundle paramBundle);
  
  public void b(Context paramContext, Bundle paramBundle, ev paramev, eu parameu)
  {
    this.d = paramContext;
    d(paramContext, paramBundle, paramev, parameu);
  }
  
  public abstract void b(Context paramContext, dl paramdl);
  
  public void b(final Context paramContext, final ev paramev)
  {
    n.a();
    if (!n.l()) {
      return;
    }
    APUICommonMethod.b(paramContext);
    bs.a().h(this.e, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        if (paramAnonymousjw.R() != 0)
        {
          n.a().j();
          if (paramev != null) {
            paramev.a(-100);
          }
        }
        APUICommonMethod.c(paramContext);
      }
      
      public void b(jw paramAnonymousjw)
      {
        n.a().j();
        APUICommonMethod.c(paramContext);
        if (paramev != null) {
          paramev.a(-100);
        }
      }
      
      public void c(jw paramAnonymousjw)
      {
        n.a().j();
        APUICommonMethod.c(paramContext);
        if (paramev != null) {
          paramev.a(-100);
        }
      }
    });
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void c()
  {
    a((Activity)this.d, this.h);
  }
  
  public abstract void c(Context paramContext, Bundle paramBundle, ev paramev, eu parameu);
  
  public void c(Context paramContext, dl paramdl)
  {
    APUICommonMethod.g();
    APLog.d("BasePayChannel", "progressSaveAns");
    int i1 = paramdl.R();
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
              b(paramContext, paramdl);
              return;
            }
            b(i1);
            return;
          }
          APLog.d("BasePayChannel", "progressSaveAns, ret = risk control soft");
          localObject1 = new Intent();
          Object localObject2 = new Bundle();
          ((Bundle)localObject2).putString("pageName", hj.F);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          paramdl.b.e = new ResultReceiver(new Handler(Looper.getMainLooper()))
          {
            protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
            {
              super.onReceiveResult(paramAnonymousInt, paramAnonymousBundle);
              if (paramAnonymousInt == 0)
              {
                paramAnonymousBundle = paramAnonymousBundle.getString("rcs_msg");
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Got rcs_msg from rcs h5 page = ");
                localStringBuilder.append(paramAnonymousBundle);
                APLog.d("BasePayChannel", localStringBuilder.toString());
                ew.a(ew.this, paramAnonymousBundle);
                return;
              }
              if ((paramAnonymousInt == -1) && (ew.this.g != null) && ("hfpay".equals(ew.this.e))) {
                ew.this.g.a(-10077, "", "");
              }
            }
          };
          ((Intent)localObject1).putExtra("RiskControlSoftParam", paramdl.b);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("send rcsParam to rcs h5 page = ");
          ((StringBuilder)localObject2).append(paramdl.b.toString());
          APLog.d("BasePayChannel", ((StringBuilder)localObject2).toString());
          if (hs.b(paramContext.getApplicationContext())) {
            ((Intent)localObject1).setClass(paramContext, APX5WebJSBridgeActivity.class);
          } else {
            ((Intent)localObject1).setClass(paramContext, APWebJSBridgeActivity.class);
          }
          paramContext.startActivity((Intent)localObject1);
          return;
        }
        a(i1, paramdl.S(), true);
        return;
      }
      localObject1 = APTools.b(paramdl.N(), 1);
      if (paramdl.O() != 1) {
        bool = false;
      }
      a(paramContext, i1, (String)localObject1, bool);
      return;
    }
    a.a("登录过期，请重新登录", paramContext);
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  protected void d()
  {
    if (is.c.size() > 0) {}
    try
    {
      ((APRecoChannelActivity)this.d).a(2, 1, null);
      return;
    }
    catch (Exception localException)
    {
      label23:
      Intent localIntent;
      break label23;
    }
    localIntent = new Intent(this.d, APRecoChannelActivity.class);
    this.d.startActivity(localIntent);
    return;
    localIntent = new Intent(this.d, APRecoChannelActivity.class);
    this.d.startActivity(localIntent);
  }
  
  public abstract void d(Context paramContext, Bundle paramBundle, ev paramev, eu parameu);
  
  static abstract interface a
  {
    public abstract void a(int paramInt, String paramString);
  }
  
  public static class b
  {
    public String a;
    public String b;
    public String c;
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ew
 * JD-Core Version:    0.7.0.1
 */