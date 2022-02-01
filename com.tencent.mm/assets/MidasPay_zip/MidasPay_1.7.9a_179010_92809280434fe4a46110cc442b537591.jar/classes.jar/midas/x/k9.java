package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.paychannel.mcard.APMcardChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.math.BigDecimal;
import java.util.HashMap;

public class k9
  extends j9
  implements View.OnClickListener
{
  public LinearLayout c;
  public AP3PointsLoading d;
  public ImageButton e;
  public LinearLayout f;
  public Button g;
  public TextView h;
  public TextView i;
  public TextView j;
  public TextView k;
  public TextView l;
  public TextView m;
  public TextView n;
  public ImageView o;
  public String p = "";
  public o4 q;
  public int r;
  public LinearLayout s;
  public ImageView t;
  public TextView u;
  public String v = "";
  public View w;
  public Context x;
  public h5 y = new a();
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.a = paramAPRecoChannelActivity;
    this.x = paramContext;
    this.q = p4.p().e();
    this.r = this.q.b.saveType;
    paramAPRecoChannelActivity = LayoutInflater.from(paramContext).inflate(2131165200, null);
    this.w = paramAPRecoChannelActivity;
    try
    {
      c(paramAPRecoChannelActivity);
      c(p4.p().e().f.e);
      i();
      APLog.i("APViewCommon_getContentView", "1");
      return paramAPRecoChannelActivity;
    }
    finally
    {
      paramContext.printStackTrace();
      paramBundle = APDataReportManager.getInstance();
      String str = p4.p().e().f.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APViewCommon_getContentView_");
      localStringBuilder.append(APTools.d(paramContext));
      paramBundle.a("sdk.err.view", str, localStringBuilder.toString());
    }
    return paramAPRecoChannelActivity;
  }
  
  public void a()
  {
    try
    {
      APLog.i("APViewCommon", "onResume");
      final String str1 = p4.p().e().f.e;
      boolean bool = "wechat".equals(str1);
      if (((bool) || ("qqwallet".equals(str1))) && (((!c6.s0().x()) && ("wechat".equals(str1))) || ((!c6.s0().w()) && ("qqwallet".equals(str1)))))
      {
        if (o.m().g(str1)) {
          if ((p4.p().e().f != null) && (!TextUtils.isEmpty(c6.s0().g())) && (!TextUtils.isEmpty(p4.p().e().b())))
          {
            c6.s0().g(true);
            c6.s0().f(true);
            o.m().b();
            g();
            b(this.w);
          }
          else
          {
            g();
            return;
          }
        }
        if ((p4.p().e().f != null) && (!TextUtils.isEmpty(p4.p().e().f.n)))
        {
          e("");
          z1.d().j(new d(str1));
        }
        else
        {
          g();
          return;
        }
      }
      if (o.m().i())
      {
        this.q.f.e = this.p;
        b(this.w);
      }
    }
    finally
    {
      localThrowable.printStackTrace();
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      String str2 = p4.p().e().f.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APViewCommon_onresume_");
      localStringBuilder.append(APTools.d(localThrowable));
      localAPDataReportManager.a("sdk.err.view", str2, localStringBuilder.toString());
    }
    super.a();
  }
  
  public final void a(int paramInt)
  {
    Object localObject1 = (z4)this.q.c;
    localObject1 = APTools.a(paramInt, 2);
    Object localObject2 = (TextView)this.w.findViewById(2131100000);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.x.getString(2131230879));
    localStringBuilder.append((String)localObject1);
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = (TextView)this.w.findViewById(2131100003);
    localObject2 = this.q;
    localObject2 = ((o4)localObject2).c.a(((o4)localObject2).f.f);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.x.getString(2131230879));
    localStringBuilder.append((String)localObject2);
    ((TextView)localObject1).setText(localStringBuilder.toString());
    ((TextView)localObject1).getPaint().setFlags(16);
    ((TextView)localObject1).setVisibility(0);
    ((TextView)this.w.findViewById(2131100007)).setVisibility(0);
  }
  
  public final void a(View paramView)
  {
    if (!p.o().h()) {
      return;
    }
    if (!p.o().f()) {
      return;
    }
    p.o().a(false);
    Object localObject = this.q;
    localObject = ((o4)localObject).c.a(((o4)localObject).f.f);
    p.o().a(true);
    int i1 = APTools.p((String)localObject);
    i1 = p.o().a(i1);
    localObject = (LinearLayout)paramView.findViewById(2131099855);
    ((LinearLayout)localObject).setVisibility(0);
    ((ImageView)paramView.findViewById(2131099854)).setVisibility(0);
    if (i1 <= 0)
    {
      ((TextView)paramView.findViewById(2131099856)).setVisibility(8);
      ((TextView)paramView.findViewById(2131099857)).setText("选择抵扣券 >");
    }
    else
    {
      ((TextView)paramView.findViewById(2131099856)).setVisibility(0);
      paramView = (TextView)paramView.findViewById(2131099857);
      m localm = o.m().a(this.p);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localm.b);
      localStringBuilder.append("已减");
      localStringBuilder.append(APTools.a(i1, 2));
      localStringBuilder.append("元 >");
      paramView.setText(localStringBuilder.toString());
    }
    ((LinearLayout)localObject).setOnClickListener(new c());
  }
  
  public final void a(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.f.setVisibility(0);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void a(String paramString, final boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("context:");
    ((StringBuilder)localObject).append(this.x);
    APLog.e("APViewCommon showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new APAlertDialog.f(this.x);
    ((APAlertDialog.f)localObject).a(paramString);
    ((APAlertDialog.f)localObject).b("我知道了", new f(paramBoolean));
    ((APAlertDialog.f)localObject).b(new g(paramBoolean));
    try
    {
      ((APAlertDialog.f)localObject).b();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    LinearLayout localLinearLayout = this.s;
    ImageView localImageView = this.t;
    TextView localTextView = this.u;
    if (paramBoolean1)
    {
      localLinearLayout.setVisibility(0);
      if (paramString != null) {
        localTextView.setText(paramString);
      }
      if (paramBoolean2)
      {
        localImageView.setImageResource(2131034135);
        localTextView.setTextColor(this.a.getResources().getColor(2130903056));
        return;
      }
      localImageView.setImageResource(2131034150);
      localTextView.setTextColor(this.a.getResources().getColor(2130903073));
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      b(this.w);
      return true;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 101)
      {
        b(this.w);
        return true;
      }
      if (paramInt2 == 102)
      {
        this.a.a(2, 1, null);
        return true;
      }
      if (paramInt2 == 103) {
        this.a.a(2, 2, null);
      }
    }
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (("hfpay".equals(this.p)) && (this.r == 4) && (!TextUtils.isEmpty(this.v))) {
        p4.p().e().f.f = this.v;
      }
      APDataReportManager.getInstance().insertData("sdk.payexpress.change", this.r, p4.p().e().f.k, p4.p().e().f.e, null);
      if (!TextUtils.isEmpty(this.q.f.i))
      {
        if (c6.s0().Q().equals("AndroidPay"))
        {
          APUICommonMethod.f();
          z5.a(2, "");
          return true;
        }
        this.a.finish();
        APUICommonMethod.a(this.a);
        return true;
      }
      if ("wechat".equals(this.p))
      {
        if (c6.s0().Q().equals("AndroidPay"))
        {
          APUICommonMethod.f();
          z5.a(2, "");
          return true;
        }
        this.a.finish();
        APUICommonMethod.a(this.a);
        return true;
      }
      this.a.a(1, 2, null);
    }
    return true;
  }
  
  public final void b(View paramView)
  {
    if (o.m().i()) {
      h();
    } else if (p.o().h()) {
      a(paramView);
    }
    Object localObject1 = r6.j().b(this.p);
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((q6)localObject1).f;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = this.q;
      localObject1 = ((o4)localObject2).c.a(((o4)localObject2).f.f, (String)localObject1);
    }
    else
    {
      localObject1 = this.q;
      localObject1 = ((o4)localObject1).c.a(((o4)localObject1).f.f);
    }
    Object localObject2 = this.k;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.x.getString(2131230879));
    ((StringBuilder)localObject3).append((String)localObject1);
    ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    localObject3 = (TextView)paramView.findViewById(2131100000);
    int i1 = this.r;
    if (i1 == 0)
    {
      localObject2 = localObject1;
      if ("hfpay".equals(this.p))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(APHFChannel.v))
        {
          localObject1 = this.q;
          localObject2 = ((x4)((o4)localObject1).c).b(((o4)localObject1).f.f, APHFChannel.v);
          localObject1 = this.q;
          localObject1 = ((o4)localObject1).c.a(((o4)localObject1).f.f);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.x.getString(2131230879));
          localStringBuilder.append((String)localObject1);
          localObject1 = localStringBuilder.toString();
          this.m.setText((CharSequence)localObject1);
          this.m.getPaint().setFlags(16);
          this.m.setVisibility(0);
          this.n.setVisibility(0);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.x.getString(2131230879));
          ((StringBuilder)localObject1).append((String)localObject2);
          ((TextView)localObject3).setText(((StringBuilder)localObject1).toString());
        }
      }
    }
    else
    {
      localObject2 = localObject1;
      if (i1 == 4)
      {
        localObject2 = localObject1;
        if ("hfpay".equals(this.p))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(APHFChannel.w))
          {
            localObject2 = localObject1;
            if (!"0".equals(APHFChannel.w))
            {
              localObject2 = this.q;
              i1 = APTools.p(((o4)localObject2).c.a(((o4)localObject2).f.f));
              int i2 = Integer.parseInt(APHFChannel.w);
              if (i1 != i2)
              {
                a(i2);
                localObject2 = localObject1;
              }
              else
              {
                localObject2 = this.q.c.a();
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(this.x.getString(2131230879));
                ((StringBuilder)localObject1).append((String)localObject2);
                ((TextView)localObject3).setText(((StringBuilder)localObject1).toString());
              }
            }
          }
        }
      }
    }
    a(paramView, APTools.p((String)localObject2));
  }
  
  public final void b(String paramString)
  {
    Object localObject = paramString;
    if ("mcard".equals(this.p))
    {
      localObject = paramString;
      if (this.q.e.h > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(String.format("(余额%s元)", new Object[] { this.q.e.a() }));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    this.l.setText((CharSequence)localObject);
  }
  
  public final void c()
  {
    if (APRecoChannelActivity.f()) {
      return;
    }
    if (("hfpay".equals(this.p)) && (this.r == 4) && (!TextUtils.isEmpty(this.v))) {
      p4.p().e().f.f = this.v;
    }
    if (c6.s0().Q().equals("AndroidPay"))
    {
      APUICommonMethod.f();
      z5.a(2, "");
      return;
    }
    this.a.finish();
    APUICommonMethod.a(this.a);
  }
  
  public final void c(View paramView)
  {
    this.e = ((ImageButton)paramView.findViewById(2131099702));
    this.e.setOnClickListener(this);
    this.f = ((LinearLayout)paramView.findViewById(2131099910));
    this.g = ((Button)paramView.findViewById(2131099704));
    this.g.setOnClickListener(this);
    this.h = ((TextView)paramView.findViewById(2131100042));
    this.i = ((TextView)paramView.findViewById(2131100002));
    this.j = ((TextView)paramView.findViewById(2131100005));
    this.k = ((TextView)paramView.findViewById(2131100000));
    this.o = ((ImageView)paramView.findViewById(2131100036));
    this.l = ((TextView)paramView.findViewById(2131100040));
    this.m = ((TextView)paramView.findViewById(2131100003));
    this.n = ((TextView)paramView.findViewById(2131100007));
    this.d = ((AP3PointsLoading)paramView.findViewById(2131099895));
    this.c = ((LinearLayout)paramView.findViewById(2131099805));
    this.s = ((LinearLayout)paramView.findViewById(2131100018));
    this.t = ((ImageView)paramView.findViewById(2131100017));
    this.u = ((TextView)paramView.findViewById(2131100019));
    paramView = (ImageView)paramView.findViewById(2131099716);
    if (z5.d())
    {
      if (o.m().i())
      {
        paramView.setVisibility(8);
        return;
      }
      this.f.setOnClickListener(this);
      return;
    }
    if (e5.h().e())
    {
      if (o.m().i())
      {
        paramView.setVisibility(8);
        return;
      }
      this.f.setOnClickListener(this);
      return;
    }
    this.f.setOnClickListener(this);
  }
  
  public final void c(String paramString)
  {
    this.p = paramString;
    if (("hfpay".equals(this.p)) && (this.r == 4))
    {
      this.v = p4.p().e().f.f;
      p4.p().e().f.f = "1";
    }
    q6 localq6 = r6.j().b(this.p);
    this.m.setVisibility(8);
    this.n.setVisibility(8);
    b(this.w);
    this.h.setText(p4.p().e().c.a);
    this.i.setText(this.q.c.b);
    paramString = "";
    Object localObject1;
    if (localq6 == null) {
      localObject1 = "";
    } else {
      localObject1 = localq6.f;
    }
    int i1 = this.r;
    if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      if (i1 != 4)
      {
        if (i1 == 5) {
          if (g6.k().e() == g6.a.a)
          {
            this.i.setVisibility(8);
            paramString = this.q.c.b;
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append(" × ");
            paramString.append(this.q.f.f);
            paramString = paramString.toString();
          }
        }
      }
      else if (g6.k().e() == g6.a.a)
      {
        this.i.setVisibility(8);
        paramString = this.q.c.b;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(this.x.getString(2131230829));
        paramString.append(" ");
        paramString.append(this.q.f.f);
        paramString.append(((z4)this.q.c).h());
        paramString = paramString.toString();
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append(this.x.getString(2131230829));
      paramString.append(this.q.f.f);
      paramString = paramString.toString();
    }
    i1 = this.r;
    Object localObject2;
    if ((i1 != 3) && (i1 != 2))
    {
      if (APUICommonMethod.e())
      {
        paramString = (x4)this.q.c;
        this.j.setText(paramString.h());
      }
      else
      {
        localObject2 = this.j;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(this.q.b.extendInfo.unit);
        ((TextView)localObject2).setText(localStringBuilder.toString());
      }
    }
    else {
      this.j.setText(paramString);
    }
    if (!APAppDataInterface.singleton().n()) {
      this.j.setVisibility(8);
    }
    if (localq6 != null)
    {
      this.o.setBackgroundResource(localq6.c);
      localObject2 = localq6.b;
      paramString = (String)localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramString = (String)localObject2;
        if (!((String)localObject1).trim().equals("100"))
        {
          paramString = (String)localObject2;
          if (!((String)localObject1).trim().equals("10"))
          {
            paramString = p4.p().e();
            i1 = APTools.p(paramString.c.a());
            int i2 = paramString.b.saveType;
            if (((i2 == 3) || (i2 == 2)) && ("qqwallet".equals(this.p)))
            {
              try
              {
                i2 = Integer.valueOf((String)localObject1).intValue();
                paramString = (String)localObject2;
                if (i2 <= 0) {
                  break label839;
                }
                paramString = (String)localObject2;
                if (i2 >= 100) {
                  break label839;
                }
                paramString = new BigDecimal(i2).divide(new BigDecimal(100));
                paramString = new BigDecimal(1).subtract(paramString);
                paramString = APTools.b(new BigDecimal(i1).multiply(paramString).intValue());
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append((String)localObject2);
                ((StringBuilder)localObject1).append(" 已省");
                ((StringBuilder)localObject1).append(paramString);
                ((StringBuilder)localObject1).append("元");
                paramString = ((StringBuilder)localObject1).toString();
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                paramString = (String)localObject2;
              }
            }
            else
            {
              paramString = new StringBuilder();
              paramString.append((String)localObject2);
              paramString.append(" ");
              paramString.append((String)localObject1);
              paramString.append("折");
              paramString = paramString.toString();
            }
          }
        }
      }
      label839:
      b(paramString);
    }
    a(false, false, null);
    paramString = (TextView)this.w.findViewById(2131100041);
    if (!"hfpay".equals(this.p))
    {
      i1 = this.q.b.saveType;
      if ((i1 != 4) && (i1 != 5)) {
        paramString.setVisibility(8);
      } else if (((z4)this.q.c).n.equals("1"))
      {
        if (!APTools.e(this.p))
        {
          paramString.setText("(不支持自动续费)");
          paramString.setVisibility(0);
          paramString.setTextColor(this.w.getResources().getColor(2130903085));
        }
        else
        {
          paramString.setVisibility(8);
        }
      }
      else {
        paramString.setVisibility(8);
      }
    }
    else
    {
      paramString.setVisibility(8);
    }
    paramString = (TextView)this.w.findViewById(2131099842);
    if (localq6 != null)
    {
      if (!TextUtils.isEmpty(localq6.g))
      {
        paramString.setVisibility(0);
        paramString.setText(localq6.g);
      }
      else
      {
        paramString.setVisibility(8);
      }
    }
    else {
      paramString.setVisibility(8);
    }
    this.g.setText("确认支付");
  }
  
  public final void d()
  {
    if (("hfpay".equals(this.p)) && (this.r == 4) && (!TextUtils.isEmpty(this.v))) {
      p4.p().e().f.f = this.v;
    }
    c6.s0().x(true);
    APDataReportManager.getInstance().insertData("sdk.payexpress.change", this.r, p4.p().e().f.k, p4.p().e().f.e, null);
    new Bundle().putBoolean("isFromExpress", true);
    this.a.a(2, 1, null);
  }
  
  public boolean d(String paramString)
  {
    if ("mcard".equals(paramString)) {
      return ((APMcardChannel)e5.a(paramString)).j();
    }
    return false;
  }
  
  public final void e()
  {
    Intent localIntent = new Intent(this.x, APPayProgressActivity.class);
    localIntent.putExtra("channel", 8);
    this.x.startActivity(localIntent);
    ((Activity)this.x).finish();
  }
  
  public final void e(String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams.height = this.c.getMeasuredHeight();
    this.c.setVisibility(8);
    this.d.setLayoutParams(localLayoutParams);
    this.d.setVisibility(0);
    if ("wechat".equals(paramString)) {
      this.d.setText("正在进入微信支付");
    } else if ("qqwallet".equals(paramString)) {
      this.d.setText("正在进入QQ钱包支付");
    } else {
      this.d.setText("");
    }
    this.d.c();
    a(true);
  }
  
  public final void f()
  {
    String str2 = this.p;
    String str1 = str2;
    if (this.f.getVisibility() == 8)
    {
      str1 = str2;
      if (p.o().h())
      {
        APRecoChannelActivity.h = true;
        str1 = "goldcouponsdeduct";
      }
    }
    if (!"qqcard".equals(str1)) {
      e(str1);
    }
    if (("wechat".equals(str1)) || ("qqwallet".equals(str1)) || (d(str1))) {
      APRecoChannelActivity.h = true;
    }
    ((LinearLayout)this.w.findViewById(2131099855)).setEnabled(false);
    e5.h().a(this.x, str1, null, this.y, null);
  }
  
  public final void g()
  {
    try
    {
      this.d.d();
      this.d.setVisibility(8);
      this.c.setVisibility(0);
      a(false);
      APRecoChannelActivity.h = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void h()
  {
    if (!o.m().i()) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)this.w.findViewById(2131099855);
    if (!o.m().e(this.p)) {
      localLinearLayout.setVisibility(8);
    } else {
      localLinearLayout.setVisibility(0);
    }
    ((TextView)this.w.findViewById(2131099856)).setVisibility(8);
    ((ImageView)this.w.findViewById(2131099854)).setVisibility(8);
    Object localObject1;
    if (o.m().g(this.p))
    {
      localObject1 = (TextView)this.w.findViewById(2131099857);
      Object localObject2 = o.m().a(this.p);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((m)localObject2).b);
      localStringBuilder.append("已减");
      localStringBuilder.append(((m)localObject2).c);
      localStringBuilder.append("元 >");
      ((TextView)localObject1).setText(localStringBuilder.toString());
      ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      localObject1 = this.q;
      localObject1 = ((o4)localObject1).c.b(((o4)localObject1).f.f);
      localObject2 = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.x.getString(2131230879));
      localStringBuilder.append((String)localObject1);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      this.m.getPaint().setFlags(16);
      this.m.setVisibility(0);
      ((TextView)this.w.findViewById(2131100007)).setVisibility(4);
    }
    else
    {
      localObject1 = (TextView)this.w.findViewById(2131099857);
      ((TextView)localObject1).setText("选择抵扣券 >");
      ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      this.m.setVisibility(8);
      ((TextView)this.w.findViewById(2131100007)).setVisibility(8);
    }
    localLinearLayout.setOnClickListener(new b());
  }
  
  public final void i()
  {
    int i1 = this.r;
    w4 localw4;
    Object localObject;
    if (((i1 == 0) || (i1 == 1)) && ("wechat".equals(this.p)))
    {
      localw4 = this.q.c;
      if (2 == localw4.e())
      {
        ((LinearLayout)this.w.findViewById(2131100029)).setVisibility(0);
      }
      else if ((localw4.e() == 0) || (1 == localw4.e()))
      {
        ((LinearLayout)this.w.findViewById(2131100030)).setVisibility(0);
        localObject = (CheckBox)this.w.findViewById(2131100031);
        if (1 == localw4.e())
        {
          ((CheckBox)localObject).setChecked(true);
          this.q.c.c(2);
        }
        else
        {
          ((CheckBox)localObject).setChecked(false);
          this.q.c.c(1);
        }
        ((CheckBox)localObject).setOnCheckedChangeListener(new e());
      }
    }
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("signState", String.valueOf(localw4.e()));
      ((HashMap)localObject).put("userSignChoose", String.valueOf(this.q.c.f()));
      APDataReportManager.getInstance().insertData("sdk.wechat.sign.show", this.r, p4.p().e().f.k, p4.p().e().f.e, z5.a((HashMap)localObject));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == this.e.getId())
    {
      APDataReportManager.getInstance().insertData("sdk.payexpress.close", this.r, p4.p().e().f.k, p4.p().e().f.e, null);
      c();
      return;
    }
    if (paramView.getId() == this.f.getId())
    {
      APDataReportManager.getInstance().insertData("sdk.payexpress.change", this.r, p4.p().e().f.k, p4.p().e().f.e, null);
      d();
      return;
    }
    if (paramView.getId() == this.g.getId())
    {
      APDataReportManager.getInstance().insertData("sdk.payexpress.sure", this.r, p4.p().e().f.k, p4.p().e().f.e, null);
      f();
    }
  }
  
  public class a
    implements h5
  {
    public a() {}
    
    public void a()
    {
      APRecoChannelActivity.h = false;
      ((LinearLayout)k9.a(k9.this).findViewById(2131099855)).setEnabled(true);
      k9.this.d.d();
      k9.this.d.setVisibility(8);
      k9.this.c.setVisibility(0);
    }
    
    public void a(int paramInt)
    {
      ((LinearLayout)k9.a(k9.this).findViewById(2131099855)).setEnabled(true);
      Object localObject;
      if ("wechat".equals(p4.p().e().f.e))
      {
        if (paramInt == 0)
        {
          localObject = p4.p().e().c;
          if (2 == ((w4)localObject).e())
          {
            APRecoChannelActivity.h = false;
            localObject = ((w4)localObject).g();
            z1.d().c((String)localObject, "3", new a());
          }
        }
        if (o.m().i())
        {
          localObject = k9.this;
          k9.a((k9)localObject, k9.a((k9)localObject));
        }
      }
      else if ("qqwallet".equals(p4.p().e().f.e))
      {
        if (o.m().i())
        {
          localObject = k9.this;
          k9.a((k9)localObject, k9.a((k9)localObject));
        }
      }
      else
      {
        APRecoChannelActivity.h = false;
        k9.this.d.d();
        k9.this.d.setVisibility(8);
        k9.this.c.setVisibility(0);
      }
      if (paramInt != 0)
      {
        APRecoChannelActivity.h = false;
        k9.this.d.d();
        k9.this.d.setVisibility(8);
        k9.this.c.setVisibility(0);
      }
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      APRecoChannelActivity.h = false;
      ((LinearLayout)k9.a(k9.this).findViewById(2131099855)).setEnabled(true);
      k9.this.d.d();
      k9.this.d.setVisibility(8);
      k9.this.c.setVisibility(0);
    }
    
    public class a
      implements fc
    {
      public a() {}
      
      public void a(ob paramob)
      {
        paramob = (h2)paramob;
        if (paramob.d() == 0)
        {
          if ((paramob.k() != 2) && (paramob.k() != 3) && (paramob.k() != 4) && (paramob.k() != 5))
          {
            k9.b(k9.this);
            return;
          }
          e5.h();
          e5.a("wechat").a(null);
          return;
        }
        if (!TextUtils.isEmpty(paramob.f()))
        {
          k9.this.a(paramob.f(), true);
          return;
        }
        k9.b(k9.this);
      }
      
      public void b(ob paramob)
      {
        k9.b(k9.this);
      }
      
      public void c(ob paramob)
      {
        k9.b(k9.this);
      }
    }
  }
  
  public class b
    extends w6
  {
    public b() {}
    
    public void a(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.coupons.btn.click", p4.p().e().b.saveType, null, k9.c(k9.this).f.e, null);
      paramView = new Intent();
      if (h8.d(k9.d(k9.this))) {
        paramView.setClass(k9.d(k9.this), APX5WebJSBridgeActivity.class);
      } else {
        paramView.setClass(k9.d(k9.this), APWebJSBridgeActivity.class);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("pageName", y7.y);
      paramView.putExtras(localBundle);
      ((Activity)k9.d(k9.this)).startActivityForResult(paramView, 1);
    }
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      paramView = k9.this;
      APRecoChannelActivity localAPRecoChannelActivity = paramView.a;
      if (localAPRecoChannelActivity != null)
      {
        paramView = new Intent(localAPRecoChannelActivity, APGoldCouponsDeductSelectValueActivity.class);
        k9.this.a.startActivityForResult(paramView, 1001);
        paramView = k9.this.a;
        paramView.overridePendingTransition(z5.a(paramView, "unipay_anim_in_from_right"), z5.a(k9.this.a, "unipay_anim_out_to_left"));
        return;
      }
      if (k9.d(paramView) != null)
      {
        paramView = new Intent(k9.d(k9.this), APGoldCouponsDeductSelectValueActivity.class);
        if ((k9.d(k9.this) instanceof Activity))
        {
          ((Activity)k9.d(k9.this)).startActivityForResult(paramView, 1001);
          ((Activity)k9.d(k9.this)).overridePendingTransition(z5.a(k9.d(k9.this), "unipay_anim_in_from_right"), z5.a(k9.d(k9.this), "unipay_anim_out_to_left"));
          return;
        }
        APLog.e("APChannelView", "initDeductCoupons(): onClick context is not activity!");
        return;
      }
      APLog.e("APChannelView", "initDeductCoupons(): onClick context is null!");
    }
  }
  
  public class d
    implements fc
  {
    public d(String paramString) {}
    
    public void a(ob paramob)
    {
      k9.e(k9.this);
      paramob = (q3)paramob;
      if ((paramob.d() == 0) && (paramob.g() == 1))
      {
        e5.h();
        e5.a(str1).a(null);
      }
    }
    
    public void b(ob paramob)
    {
      k9.e(k9.this);
    }
    
    public void c(ob paramob)
    {
      k9.e(k9.this);
    }
  }
  
  public class e
    implements CompoundButton.OnCheckedChangeListener
  {
    public e() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        k9.c(k9.this).c.c(2);
        return;
      }
      k9.c(k9.this).c.c(1);
    }
  }
  
  public class f
    implements c7
  {
    public f(boolean paramBoolean) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((!paramBoolean) && (a.r().f))
      {
        paramAPAlertDialog.f();
        return;
      }
      paramAPAlertDialog.f();
      APUICommonMethod.f();
      z5.a(-1, "");
    }
  }
  
  public class g
    implements c7
  {
    public g(boolean paramBoolean) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && ((paramBoolean) || (!a.r().f)))
      {
        APUICommonMethod.f();
        z5.a(-1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.k9
 * JD-Core Version:    0.7.0.1
 */