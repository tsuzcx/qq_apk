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

public abstract class ff
  implements Cloneable
{
  public static ArrayList<Long> a = new ArrayList();
  private static final String j = "ff";
  final Handler b = new Handler();
  public Bundle c;
  public Context d;
  public String e;
  public fd f;
  public fe g;
  protected ResultReceiver h = new ResultReceiver(new Handler())
  {
    public void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      super.onReceiveResult(paramAnonymousInt, paramAnonymousBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("channelCallbackReceiver resultCode = ");
      localStringBuilder.append(paramAnonymousInt);
      localStringBuilder.append(" resultData = ");
      localStringBuilder.append(paramAnonymousBundle);
      APLog.i("APBasePayChannel", localStringBuilder.toString());
      if ((bq.d()) && (bq.b(ff.this.e)))
      {
        bs.a().a(ff.this.e, 0, paramAnonymousInt, paramAnonymousBundle);
        return;
      }
      ff.this.a(paramAnonymousInt, paramAnonymousBundle);
    }
  };
  bk i = new bk()
  {
    public void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
    {
      gc.a().a(true);
      ff.this.a(ff.this.d, ff.this.g, ff.this.f);
    }
    
    public void c()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loginCallBack onLoginFail stateCallback:");
      localStringBuilder.append(ff.this.g);
      APLog.i("APBasePayChannel", localStringBuilder.toString());
      if (ff.this.g != null) {
        ff.this.g.a();
      }
    }
  };
  private final int k = 0;
  private final int l = -1;
  private int m = 0;
  private ArrayList<Long> n = a;
  private ArrayList<Long> o = new ArrayList();
  private ArrayList<Integer> p = new ArrayList();
  
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
    a.a().a(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        APUICommonMethod.c(paramContext);
        paramAnonymouslh = (cv)paramAnonymouslh;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("goldAns.getResultCode():");
        localStringBuilder.append(paramAnonymouslh.T());
        APLog.i("APTenpayActivity", localStringBuilder.toString());
        if (paramAnonymouslh.T() != 0)
        {
          APLog.i("APTenpayActivity", "goldAns.getResultCode()!=0");
          ff.e(ff.this);
          return;
        }
        if (-1 == paramInt)
        {
          ff.this.a(paramAnonymouslh.T(), paramString, true);
          return;
        }
        if (paramInt == 0) {
          ff.f(ff.this);
        }
      }
      
      public void b(lh paramAnonymouslh)
      {
        APUICommonMethod.c(paramContext);
        ff.e(ff.this);
      }
      
      public void c(lh paramAnonymouslh) {}
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
    final int i1 = em.b().n().a.saveType;
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
    if (em.b().k())
    {
      localObject = "我知道了";
      str = "";
      paramBoolean = true;
    }
    APAlertDialog.a locala = new APAlertDialog.a(paramContext);
    locala.a(paramString);
    locala.b((String)localObject, new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.rc.dialog.hide", i1, null, ff.this.e, fy.a().aa());
        if ((!paramBoolean) && (a.a().f))
        {
          paramAnonymousAPAlertDialog.a();
          if (ff.this.g != null) {
            ff.this.g.a(paramInt);
          }
        }
        else
        {
          paramAnonymousAPAlertDialog.a();
          APUICommonMethod.b();
          paramAnonymousAPAlertDialog = new StringBuilder();
          paramAnonymousAPAlertDialog.append("resultCode=1138&msg=");
          paramAnonymousAPAlertDialog.append(paramString);
          fv.a(-1, paramAnonymousAPAlertDialog.toString());
        }
      }
    });
    if (!TextUtils.isEmpty(str)) {
      locala.a(str, new gy()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          paramAnonymousAPAlertDialog.a();
          APDataReportManager.getInstance().insertData("sdk.rc.dialog.resave", i1, null, ff.this.e, fy.a().aa());
          ff.this.a(paramContext, null);
        }
      });
    }
    locala.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.rc.dialog.back", i1, null, ff.this.e, fy.a().aa());
          if ((!paramBoolean) && (a.a().f))
          {
            paramAnonymousAPAlertDialog.a();
            if (ff.this.g != null) {
              ff.this.g.a(paramInt);
            }
          }
          else
          {
            paramAnonymousAPAlertDialog.a();
            APUICommonMethod.b();
            paramAnonymousAPAlertDialog = new StringBuilder();
            paramAnonymousAPAlertDialog.append("resultCode=1138&msg=");
            paramAnonymousAPAlertDialog.append(paramString);
            fv.a(-1, paramAnonymousAPAlertDialog.toString());
          }
        }
      }
    });
    try
    {
      locala.c();
      APDataReportManager.getInstance().insertData("sdk.rc.dialog.show", i1, null, this.e, fy.a().aa());
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
    locala.b("取消", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        fy.a().b(0);
        if (!a.a().f)
        {
          paramAnonymousAPAlertDialog.a();
          APUICommonMethod.b();
          fv.a(-1, "");
          return;
        }
        paramAnonymousAPAlertDialog.a();
      }
    });
    if (paramInt == 10017)
    {
      locala.a("继续当前支付，成功购买后将取消原有话费支付关系。");
      locala.a("确定", new gy()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          fy.a().b(1);
          paramAnonymousAPAlertDialog.a();
          ff.this.a(ff.this.d, ff.this.g, ff.this.f);
        }
      });
    }
    else
    {
      locala.a("继续当前支付，成功购买的服务将在手机话费支付关闭后生效。");
      locala.a("确定", new gy()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          fy.a().b(2);
          paramAnonymousAPAlertDialog.a();
          ff.this.a(ff.this.d, ff.this.g, ff.this.f);
        }
      });
    }
    locala.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          fy.a().b(0);
          if (!a.a().f)
          {
            paramAnonymousAPAlertDialog.a();
            APUICommonMethod.b();
            fv.a(-1, "");
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
      fv.a(gn.a(em.b().n().e.f), 0, 0);
      return;
    }
    try
    {
      localObject = new Intent();
      if (id.b(this.d)) {
        ((Intent)localObject).setClass(this.d, APX5WebJSBridgeActivity.class);
      } else {
        ((Intent)localObject).setClass(this.d, APWebJSBridgeActivity.class);
      }
      if (paramBundle == null)
      {
        paramBundle = new Bundle();
        paramBundle.putString("pageName", hu.v);
        ((Intent)localObject).putExtras(paramBundle);
      }
      else
      {
        paramBundle.putString("pageName", hu.v);
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
      fv.a(gn.a(em.b().n().e.f), 0, 0);
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("BasePayChannel", "Cannot save again with empty rcs msg!");
      return;
    }
    paramString = du.a.b(paramString);
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
    if ((em.b().n().e.f.equals(em.b().n().a.mpInfo.payChannel)) && (!n.a().h()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from assign pay channel");
      APUICommonMethod.b();
      fv.a(2, "");
      return;
    }
    if ((fb.a().f()) && (!em.b().n().a.isCanChange) && (!n.a().h()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from assign pay channel");
      APUICommonMethod.b();
      fv.a(2, "");
      return;
    }
    if ((!a.a().f) && (!fy.a().J()))
    {
      APLog.i("APBasePayChannel", "toCancelResult from anroidpay");
      APUICommonMethod.b();
      fv.a(2, "");
    }
  }
  
  private void g()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("resource", "backOrError");
    localIntent.setClass(this.d, APGoldCouponsDeductSelectValueActivity.class);
    ((Activity)this.d).startActivityForResult(localIntent, 1001);
    ((Activity)this.d).overridePendingTransition(fv.a(this.d, "unipay_anim_in_from_right"), fv.a(this.d, "unipay_anim_out_to_left"));
  }
  
  public long a(long paramLong)
  {
    int i1 = this.m;
    while (i1 < this.n.size() - 2)
    {
      long l1 = ((Long)this.n.get(this.m)).longValue() + paramLong;
      if (l1 >= ((Long)this.n.get(i1)).longValue())
      {
        ArrayList localArrayList = this.n;
        int i2 = i1 + 1;
        if (l1 < ((Long)localArrayList.get(i2)).longValue())
        {
          this.m = i2;
          return ((Long)this.n.get(i2)).longValue() - l1;
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
      while (paramInt < this.o.size())
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("inter", this.o.get(paramInt));
        ((JSONObject)localObject2).put("code", this.p.get(paramInt));
        ((JSONArray)localObject1).put(localObject2);
        paramInt += 1;
      }
      localJSONObject.put("plist", localObject1);
      localObject1 = j;
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
    ((StringBuilder)localObject).append(this.d);
    APLog.e("APBasePayChannel showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("message:");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APBasePayChannel showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new APAlertDialog.a(this.d);
    String str = em.b().n().e.f;
    if ("hfpay".equals(str))
    {
      if (!TextUtils.isEmpty(paramString)) {
        ((APAlertDialog.a)localObject).a(paramString);
      } else {
        ((APAlertDialog.a)localObject).a(this.d.getString(2131230796));
      }
    }
    else if ("mcard".equals(str))
    {
      if (!TextUtils.isEmpty(paramString)) {
        ((APAlertDialog.a)localObject).a(paramString);
      } else {
        ((APAlertDialog.a)localObject).a(this.d.getString(2131230813));
      }
    }
    else {
      ((APAlertDialog.a)localObject).a(paramString);
    }
    ((APAlertDialog.a)localObject).a("我知道了", new gy()
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
        fv.a(paramInt, "");
      }
    });
    ((APAlertDialog.a)localObject).b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0) && ((paramBoolean) || (!a.a().f)))
        {
          APUICommonMethod.b();
          fv.a(paramInt, "");
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
    APLog.i(j, "queryReceiptAgain start to queryReceiptAgain");
    Runnable local20 = new Runnable()
    {
      public void run()
      {
        ff.this.a(false, parama);
      }
    };
    if (((Long)this.n.get(this.m)).longValue() + paramLong >= ((Long)this.n.get(this.n.size() - 1)).longValue())
    {
      APLog.i(j, "queryReceiptAgain Timeout exit");
      this.b.removeCallbacks(local20);
      parama.a(4, "");
      return;
    }
    paramLong = a(paramLong);
    String str = j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryReceiptAgain mStartPos:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("  next:");
    localStringBuilder.append(paramLong);
    APLog.i(str, localStringBuilder.toString());
    if (paramLong != -1L)
    {
      this.b.postDelayed(local20, paramLong * 1000L);
      return;
    }
    this.b.removeCallbacks(local20);
    parama.a(4, "");
  }
  
  public void a(Activity paramActivity, bk parambk)
  {
    APPluginActivity localAPPluginActivity = (APPluginActivity)paramActivity;
    bl.a().a(paramActivity, localAPPluginActivity.mActivity, fy.a().ab(), parambk);
  }
  
  public void a(Context paramContext, final int paramInt)
  {
    APLog.i("APBasePayChannel", "toUnkownResult");
    if (this.g != null) {
      this.g.a();
    }
    APAlertDialog.a locala = new APAlertDialog.a(paramContext);
    locala.b("提示");
    String str = em.b().n().e.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelId:");
    localStringBuilder.append(str);
    APLog.i("APBasePayChannel", localStringBuilder.toString());
    if ("hfpay".equals(str)) {
      locala.a(paramContext.getString(2131230796));
    } else if ("mcard".equals(str)) {
      locala.a(paramContext.getString(2131230813));
    } else if ((bq.c()) && ((paramInt == 13) || (paramInt == 8))) {
      locala.a(paramContext.getString(2131230751));
    }
    locala.a("我知道了", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
        APUICommonMethod.b();
        fv.a(paramInt, -1, -1);
      }
    });
    locala.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APUICommonMethod.b();
          fv.a(-1, "");
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
  
  public void a(Context paramContext, int paramInt, String paramString, fe paramfe)
  {
    if (paramfe != null) {
      paramfe.a();
    }
    APLog.i("APBasePayChannel", "toFailResult");
    if (n.a().c(em.b().n().e.f))
    {
      b(paramContext, paramfe);
      return;
    }
    if ((o.a().b()) && (o.a().o()) && (o.a().d()))
    {
      if ("mcard".equals(em.b().n().e.f))
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
  
  public void a(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.d = paramContext;
    this.g = paramfe;
    this.f = paramfd;
    this.c = paramBundle;
    if ((bq.c()) && (bq.b(this.e)))
    {
      bt.a().a(paramContext, this, paramBundle, paramfe, paramfd);
      return;
    }
    c(paramContext, paramBundle, paramfe, paramfd);
  }
  
  protected void a(Context paramContext, String paramString)
  {
    paramContext = new APAlertDialog.a(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    final int i1 = em.b().n().a.saveType;
    APDataReportManager.getInstance().insertData("sdk.notenough.show", i1, null, this.e, null);
    paramContext.a("确定", new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        APDataReportManager.getInstance().insertData("sdk.notenough.sure", i1, null, ff.this.e, null);
        paramAnonymousAPAlertDialog.a();
      }
    });
    paramContext.b(new gy()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          APDataReportManager.getInstance().insertData("sdk.notenough.keyback", i1, null, ff.this.e, null);
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
  
  protected void a(Context paramContext, dt paramdt)
  {
    if (!bt.a().a(paramContext, paramdt, this.e))
    {
      c(paramContext, paramdt);
      b();
    }
  }
  
  protected void a(final Context paramContext, final du.a parama)
  {
    if (parama != null) {
      APUICommonMethod.b(paramContext);
    }
    by.a().a(this.e, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveReq() onSuccess() ans.getResultCode = ");
        localStringBuilder.append(paramAnonymouslh.T());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        if (parama != null) {
          APUICommonMethod.c(paramContext);
        }
        ff.this.a(paramContext, (dt)paramAnonymouslh);
        if ((ff.this.g != null) && (paramAnonymouslh.T() != 1138)) {
          ff.this.g.a(paramAnonymouslh.T());
        }
      }
      
      public void b(lh paramAnonymouslh)
      {
        String str = em.b().n().e.f;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveReq() onFailure() ans.getResultCode = ");
        localStringBuilder.append(paramAnonymouslh.T());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        if ((("qdqb".equals(str)) || ("qbqd".equals(str)) || ("qqcard".equals(str))) && (paramAnonymouslh.T() == 20002))
        {
          ff.this.a(paramContext, parama, (dt)paramAnonymouslh, str);
          return;
        }
        ff.this.a(paramContext, parama, paramAnonymouslh, str);
      }
      
      public void c(lh paramAnonymouslh)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveReq() onStop() ans.getResultCode = ");
        localStringBuilder.append(paramAnonymouslh.T());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        if (parama != null) {
          APUICommonMethod.c(paramContext);
        }
        if (ff.this.g != null) {
          ff.this.g.a();
        }
      }
    }, parama);
  }
  
  public void a(final Context paramContext, final du.a parama, final dt paramdt, final String paramString)
  {
    by.a().a(1, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        dn localdn = (dn)paramAnonymouslh;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryPayResult() onSuccess() ans.getResultCode=");
        localStringBuilder.append(paramAnonymouslh.T());
        localStringBuilder.append(", ans.getProvideResult = ");
        localStringBuilder.append(localdn.a());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        if ((localdn.T() == 0) && (localdn.a() == 1))
        {
          if (parama != null) {
            APUICommonMethod.c(paramContext);
          }
          if (ff.this.g != null) {
            ff.this.g.a(0);
          }
          ff.this.a(null);
          return;
        }
        ff.this.a(paramContext, parama, paramdt, paramString);
      }
      
      public void b(lh paramAnonymouslh)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryPayResult() onFailure() ans.getResultCode=");
        localStringBuilder.append(paramAnonymouslh.T());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        ff.this.a(paramContext, parama, paramdt, paramString);
      }
      
      public void c(lh paramAnonymouslh)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryPayResult() onStop() ans.getResultCode=");
        localStringBuilder.append(paramAnonymouslh.T());
        APLog.d("BasePayChannel", localStringBuilder.toString());
        ff.this.a(paramContext, parama, paramdt, paramString);
      }
    });
  }
  
  protected void a(Context paramContext, du.a parama, lh paramlh, String paramString)
  {
    if (parama != null) {
      APUICommonMethod.c(paramContext);
    }
    if (this.g != null) {
      this.g.a(paramlh.T(), paramlh.U(), paramlh.U());
    }
    boolean bool = false;
    if (this.c != null) {
      bool = this.c.getBoolean("isFromChannelList");
    }
    if (((!"cft".equals(paramString)) && (!"bank".equals(paramString))) || (bool))
    {
      parama = new StringBuilder();
      parama.append("系统繁忙:");
      parama.append(bw.a(paramlh.T()));
      APUICommonMethod.a(paramContext, parama.toString());
    }
    if (!a.a().f)
    {
      APUICommonMethod.b();
      paramContext = new StringBuilder();
      paramContext.append("网络错误:");
      paramContext.append(paramlh.T());
      fv.a(-1, paramContext.toString());
    }
  }
  
  public void a(Context paramContext, fe paramfe)
  {
    APLog.i("APBasePayChannel", "toCancelResult");
    if (paramfe != null) {
      paramfe.a();
    }
    if (n.a().c(em.b().n().e.f)) {
      b(paramContext, paramfe);
    } else if ((o.a().b()) && (o.a().o()) && (o.a().d())) {
      a(paramContext, 0, "");
    } else {
      f();
    }
    if ((fy.a().ad()) && ((paramContext instanceof Activity)))
    {
      paramContext = (Activity)paramContext;
      paramContext.finish();
      APUICommonMethod.b(paramContext);
    }
  }
  
  public void a(Context paramContext, fe paramfe, fd paramfd)
  {
    this.d = paramContext;
    this.g = paramfe;
    this.f = paramfd;
    a();
    a(paramContext, null);
  }
  
  public void a(final Bundle paramBundle)
  {
    if ((fy.a().S()) && ((a.a().g == null) || (a.a().g.a.saveType == em.b().n().a.saveType) || ((em.b().n().a.saveType != 3) && (em.b().n().a.saveType != 2))))
    {
      this.o.clear();
      this.p.clear();
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
                if (em.b().n().a != null) {
                  a.a().e.mAPPurchase.mSku = ((APGoodsRequest)em.b().n().a).prodcutId;
                }
              }
            }
            catch (Exception paramAnonymousString)
            {
              paramAnonymousString.printStackTrace();
            }
            if (fy.a().G().equals("0"))
            {
              APUICommonMethod.b();
              fv.a(gn.a(em.b().n().e.f), 0, 0);
            }
            else
            {
              ff.a(ff.this, paramBundle);
            }
            APDataReportManager.getInstance().insertData("sdk.result.receipt.success", 1, null, ff.this.e, ff.this.a(0));
            return;
          }
          APDataReportManager.getInstance().insertData("sdk.result.receipt.failed", 1, null, ff.this.e, ff.this.a(paramAnonymousInt));
          APUICommonMethod.b();
          fv.a(101, -1, "未查询到支付结果，请稍后重试");
        }
      });
      return;
    }
    if (fy.a().G().equals("0"))
    {
      APUICommonMethod.b();
      fv.a(gn.a(em.b().n().e.f), 0, 0);
      return;
    }
    b(paramBundle);
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(String paramString, final lw paramlw)
  {
    by.a().h(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        paramlw.a(paramAnonymouslh);
      }
      
      public void b(lh paramAnonymouslh)
      {
        paramlw.b(paramAnonymouslh);
      }
      
      public void c(lh paramAnonymouslh)
      {
        paramlw.c(paramAnonymouslh);
      }
    });
  }
  
  public void a(boolean paramBoolean, a parama)
  {
    APLog.i(j, "start to queryReceipt");
    final long l1 = System.currentTimeMillis();
    String str = j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryReceipt mStartPos:");
    localStringBuilder.append(this.m);
    localStringBuilder.append("  start:");
    localStringBuilder.append(l1);
    APLog.i(str, localStringBuilder.toString());
    by.a().a(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        long l = System.currentTimeMillis();
        Object localObject1 = ff.e();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryReceipt mStartPos:");
        ((StringBuilder)localObject2).append(ff.a(ff.this));
        ((StringBuilder)localObject2).append("  end:");
        ((StringBuilder)localObject2).append(l);
        APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
        l = (l - l1) / 1000L;
        localObject1 = ff.e();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryReceipt mStartPos:");
        ((StringBuilder)localObject2).append(ff.a(ff.this));
        ((StringBuilder)localObject2).append("  interval:");
        ((StringBuilder)localObject2).append(l);
        APLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
        localObject2 = (dp)paramAnonymouslh;
        ff.b(ff.this).add(Long.valueOf(l));
        ff.c(ff.this).add(Integer.valueOf(paramAnonymouslh.T()));
        if (paramAnonymouslh.T() == 0)
        {
          if (ff.d(ff.this) == ff.a)
          {
            ff.a(ff.this, ((dp)localObject2).a());
            paramAnonymouslh = ff.e();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("mStartPos:");
            ((StringBuilder)localObject1).append(ff.a(ff.this));
            ((StringBuilder)localObject1).append("  QueryPeriod:");
            ((StringBuilder)localObject1).append(ff.d(ff.this).toString());
            APLog.i(paramAnonymouslh, ((StringBuilder)localObject1).toString());
          }
          paramAnonymouslh = null;
          try
          {
            localObject1 = new JSONArray(((dp)localObject2).a);
            paramAnonymouslh = (lh)localObject1;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          if ((paramAnonymouslh != null) && (paramAnonymouslh.length() != 0))
          {
            this.b.a(0, ((dp)localObject2).a);
            return;
          }
          ff.this.a(l, this.b);
          return;
        }
        ff.this.a(l, this.b);
      }
      
      public void b(lh paramAnonymouslh)
      {
        this.b.a(1, "");
      }
      
      public void c(lh paramAnonymouslh)
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
  
  public void b(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd)
  {
    this.d = paramContext;
    d(paramContext, paramBundle, paramfe, paramfd);
  }
  
  public abstract void b(Context paramContext, dt paramdt);
  
  public void b(final Context paramContext, final fe paramfe)
  {
    n.a();
    if (!n.l()) {
      return;
    }
    APUICommonMethod.b(paramContext);
    by.a().h(this.e, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        if (paramAnonymouslh.T() != 0)
        {
          n.a().j();
          if (paramfe != null) {
            paramfe.a(-100);
          }
        }
        APUICommonMethod.c(paramContext);
      }
      
      public void b(lh paramAnonymouslh)
      {
        n.a().j();
        APUICommonMethod.c(paramContext);
        if (paramfe != null) {
          paramfe.a(-100);
        }
      }
      
      public void c(lh paramAnonymouslh)
      {
        n.a().j();
        APUICommonMethod.c(paramContext);
        if (paramfe != null) {
          paramfe.a(-100);
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
    a((Activity)this.d, this.i);
  }
  
  public abstract void c(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd);
  
  public void c(Context paramContext, dt paramdt)
  {
    this.d = paramContext;
    APUICommonMethod.g();
    APLog.d("BasePayChannel", "progressSaveAns");
    int i1 = paramdt.T();
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
              b(paramContext, paramdt);
              return;
            }
            b(i1);
            return;
          }
          APLog.d("BasePayChannel", "progressSaveAns, ret = risk control soft");
          localObject1 = new Intent();
          Object localObject2 = new Bundle();
          ((Bundle)localObject2).putString("pageName", hu.E);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          paramdt.b.e = new ResultReceiver(new Handler(Looper.getMainLooper()))
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
                ff.a(ff.this, paramAnonymousBundle);
                return;
              }
              if ((paramAnonymousInt == -1) && (ff.this.g != null) && ("hfpay".equals(ff.this.e))) {
                ff.this.g.a(-10077, "", "");
              }
            }
          };
          ((Intent)localObject1).putExtra("RiskControlSoftParam", paramdt.b);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("send rcsParam to rcs h5 page = ");
          ((StringBuilder)localObject2).append(paramdt.b.toString());
          APLog.d("BasePayChannel", ((StringBuilder)localObject2).toString());
          if (id.b(paramContext.getApplicationContext())) {
            ((Intent)localObject1).setClass(paramContext, APX5WebJSBridgeActivity.class);
          } else {
            ((Intent)localObject1).setClass(paramContext, APWebJSBridgeActivity.class);
          }
          paramContext.startActivity((Intent)localObject1);
          return;
        }
        a(i1, paramdt.U(), true);
        return;
      }
      localObject1 = APTools.b(paramdt.N(), 1);
      if (paramdt.O() != 1) {
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
    if (jd.c.size() > 0) {}
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
  
  public abstract void d(Context paramContext, Bundle paramBundle, fe paramfe, fd paramfd);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ff
 * JD-Core Version:    0.7.0.1
 */