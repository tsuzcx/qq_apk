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
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APPayProgressActivity;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.math.BigDecimal;
import java.util.HashMap;

public class it
  extends is
  implements View.OnClickListener
{
  public final int a = 1;
  protected LinearLayout b;
  protected AP3PointsLoading e;
  ev f = new ev()
  {
    public void a()
    {
      APRecoChannelActivity.b = false;
      ((LinearLayout)it.a(it.this).findViewById(2131099855)).setEnabled(true);
      it.this.e.a();
      it.this.e.setVisibility(8);
      it.this.b.setVisibility(0);
    }
    
    public void a(int paramAnonymousInt)
    {
      ((LinearLayout)it.a(it.this).findViewById(2131099855)).setEnabled(true);
      if ("wechat".equals(ed.b().n().e.f))
      {
        if (paramAnonymousInt == 0)
        {
          Object localObject = ed.b().n().b;
          if (2 == ((ek)localObject).e())
          {
            APRecoChannelActivity.b = false;
            localObject = ((ek)localObject).g();
            bs.a().a((String)localObject, "3", new kl()
            {
              public void a(jw paramAnonymous2jw)
              {
                paramAnonymous2jw = (ca)paramAnonymous2jw;
                if (paramAnonymous2jw.R() == 0)
                {
                  if ((paramAnonymous2jw.a() != 2) && (paramAnonymous2jw.a() != 3) && (paramAnonymous2jw.a() != 4) && (paramAnonymous2jw.a() != 5))
                  {
                    it.b(it.this);
                    return;
                  }
                  es.a();
                  es.a("wechat").a(null);
                  return;
                }
                if (!TextUtils.isEmpty(paramAnonymous2jw.S()))
                {
                  it.this.a(paramAnonymous2jw.S(), true);
                  return;
                }
                it.b(it.this);
              }
              
              public void b(jw paramAnonymous2jw)
              {
                it.b(it.this);
              }
              
              public void c(jw paramAnonymous2jw)
              {
                it.b(it.this);
              }
            });
          }
        }
        if (n.a().h()) {
          it.a(it.this, it.a(it.this));
        }
      }
      else if ("qqwallet".equals(ed.b().n().e.f))
      {
        if (n.a().h()) {
          it.a(it.this, it.a(it.this));
        }
      }
      else
      {
        APRecoChannelActivity.b = false;
        it.this.e.a();
        it.this.e.setVisibility(8);
        it.this.b.setVisibility(0);
      }
      if (paramAnonymousInt != 0)
      {
        APRecoChannelActivity.b = false;
        it.this.e.a();
        it.this.e.setVisibility(8);
        it.this.b.setVisibility(0);
      }
    }
    
    public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      APRecoChannelActivity.b = false;
      ((LinearLayout)it.a(it.this).findViewById(2131099855)).setEnabled(true);
      it.this.e.a();
      it.this.e.setVisibility(8);
      it.this.b.setVisibility(0);
    }
  };
  private ImageButton g;
  private LinearLayout h;
  private Button i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private ImageView q;
  private String r = "";
  private ec s;
  private int t;
  private LinearLayout u;
  private ImageView v;
  private TextView w;
  private String x = "";
  private View y;
  private Context z;
  
  private void a(int paramInt)
  {
    Object localObject1 = (en)this.s.b;
    localObject1 = APTools.a(paramInt, 2);
    Object localObject2 = (TextView)this.y.findViewById(2131100000);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.z.getString(2131230878));
    localStringBuilder.append((String)localObject1);
    ((TextView)localObject2).setText(localStringBuilder.toString());
    localObject1 = (TextView)this.y.findViewById(2131100003);
    localObject2 = this.s.b.a(this.s.e.g);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.z.getString(2131230878));
    localStringBuilder.append((String)localObject2);
    ((TextView)localObject1).setText(localStringBuilder.toString());
    ((TextView)localObject1).getPaint().setFlags(16);
    ((TextView)localObject1).setVisibility(0);
    ((TextView)this.y.findViewById(2131100007)).setVisibility(0);
  }
  
  private void a(View paramView)
  {
    this.g = ((ImageButton)paramView.findViewById(2131099702));
    this.g.setOnClickListener(this);
    this.h = ((LinearLayout)paramView.findViewById(2131099910));
    this.i = ((Button)paramView.findViewById(2131099704));
    this.i.setOnClickListener(this);
    this.j = ((TextView)paramView.findViewById(2131100042));
    this.k = ((TextView)paramView.findViewById(2131100002));
    this.l = ((TextView)paramView.findViewById(2131100005));
    this.m = ((TextView)paramView.findViewById(2131100000));
    this.q = ((ImageView)paramView.findViewById(2131100036));
    this.n = ((TextView)paramView.findViewById(2131100040));
    this.o = ((TextView)paramView.findViewById(2131100003));
    this.p = ((TextView)paramView.findViewById(2131100007));
    this.e = ((AP3PointsLoading)paramView.findViewById(2131099895));
    this.b = ((LinearLayout)paramView.findViewById(2131099805));
    this.u = ((LinearLayout)paramView.findViewById(2131100018));
    this.v = ((ImageView)paramView.findViewById(2131100017));
    this.w = ((TextView)paramView.findViewById(2131100019));
    paramView = (ImageView)paramView.findViewById(2131099716);
    if (fm.f())
    {
      if (n.a().h())
      {
        paramView.setVisibility(8);
        return;
      }
      this.h.setOnClickListener(this);
      return;
    }
    if (es.a().g())
    {
      if (n.a().h())
      {
        paramView.setVisibility(8);
        return;
      }
      this.h.setOnClickListener(this);
      return;
    }
    this.h.setOnClickListener(this);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(8);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    LinearLayout localLinearLayout = this.u;
    ImageView localImageView = this.v;
    TextView localTextView = this.w;
    if (paramBoolean1)
    {
      localLinearLayout.setVisibility(0);
      if (paramString != null) {
        localTextView.setText(paramString);
      }
      if (paramBoolean2)
      {
        localImageView.setImageResource(2131034135);
        localTextView.setTextColor(this.d.getResources().getColor(2130903056));
        return;
      }
      localImageView.setImageResource(2131034150);
      localTextView.setTextColor(this.d.getResources().getColor(2130903073));
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  private void b(View paramView)
  {
    if (n.a().h()) {
      c();
    } else if (o.a().b()) {
      c(paramView);
    }
    Object localObject1 = gd.a().d(this.r);
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((gc)localObject1).f;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = this.s.b.a(this.s.e.g, (String)localObject1);
    } else {
      localObject1 = this.s.b.a(this.s.e.g);
    }
    Object localObject2 = this.m;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.z.getString(2131230878));
    ((StringBuilder)localObject3).append((String)localObject1);
    ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    localObject3 = (TextView)paramView.findViewById(2131100000);
    if (this.t == 0)
    {
      localObject2 = localObject1;
      if ("hfpay".equals(this.r))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(APHFChannel.n))
        {
          localObject2 = ((el)this.s.b).b(this.s.e.g, APHFChannel.n);
          localObject1 = this.s.b.a(this.s.e.g);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.z.getString(2131230878));
          localStringBuilder.append((String)localObject1);
          localObject1 = localStringBuilder.toString();
          this.o.setText((CharSequence)localObject1);
          this.o.getPaint().setFlags(16);
          this.o.setVisibility(0);
          this.p.setVisibility(0);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.z.getString(2131230878));
          ((StringBuilder)localObject1).append((String)localObject2);
          ((TextView)localObject3).setText(((StringBuilder)localObject1).toString());
        }
      }
    }
    else
    {
      localObject2 = localObject1;
      if (this.t == 4)
      {
        localObject2 = localObject1;
        if ("hfpay".equals(this.r))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(APHFChannel.o))
          {
            localObject2 = localObject1;
            if (!"0".equals(APHFChannel.o))
            {
              int i1 = APTools.g(this.s.b.a(this.s.e.g));
              int i2 = Integer.parseInt(APHFChannel.o);
              if (i1 != i2)
              {
                a(i2);
                localObject2 = localObject1;
              }
              else
              {
                localObject2 = this.s.b.a();
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(this.z.getString(2131230878));
                ((StringBuilder)localObject1).append((String)localObject2);
                ((TextView)localObject3).setText(((StringBuilder)localObject1).toString());
              }
            }
          }
        }
      }
    }
    a(paramView, APTools.g((String)localObject2));
  }
  
  private void c()
  {
    if (!n.a().h()) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)this.y.findViewById(2131099855);
    if (!n.a().j(this.r)) {
      localLinearLayout.setVisibility(8);
    } else {
      localLinearLayout.setVisibility(0);
    }
    ((TextView)this.y.findViewById(2131099856)).setVisibility(8);
    ((ImageView)this.y.findViewById(2131099854)).setVisibility(8);
    Object localObject1;
    if (n.a().c(this.r))
    {
      localObject1 = (TextView)this.y.findViewById(2131099857);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("券已减");
      ((StringBuilder)localObject2).append(n.a().g(this.r));
      ((StringBuilder)localObject2).append("元");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      localObject1 = this.s.b.b(this.s.e.g);
      localObject2 = this.o;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.z.getString(2131230878));
      localStringBuilder.append((String)localObject1);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      this.o.getPaint().setFlags(16);
      this.o.setVisibility(0);
      ((TextView)this.y.findViewById(2131100007)).setVisibility(4);
    }
    else
    {
      localObject1 = (TextView)this.y.findViewById(2131099857);
      ((TextView)localObject1).setText("选择抵扣券");
      ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      this.o.setVisibility(8);
      ((TextView)this.y.findViewById(2131100007)).setVisibility(8);
    }
    localLinearLayout.setOnClickListener(new gh()
    {
      public void a(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.coupons.btn.click", ed.b().n().a.saveType, null, it.c(it.this).e.f, null);
        paramAnonymousView = new Intent();
        if (hs.b(it.d(it.this))) {
          paramAnonymousView.setClass(it.d(it.this), APX5WebJSBridgeActivity.class);
        } else {
          paramAnonymousView.setClass(it.d(it.this), APWebJSBridgeActivity.class);
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("pageName", hj.B);
        paramAnonymousView.putExtras(localBundle);
        ((Activity)it.d(it.this)).startActivityForResult(paramAnonymousView, 1);
      }
    });
  }
  
  private void c(View paramView)
  {
    if (!o.a().b()) {
      return;
    }
    if (!o.a().c()) {
      return;
    }
    o.a().a(false);
    Object localObject = this.s.b.a(this.s.e.g);
    o.a().a(true);
    int i1 = APTools.g((String)localObject);
    i1 = o.a().c(i1);
    localObject = (LinearLayout)paramView.findViewById(2131099855);
    ((LinearLayout)localObject).setVisibility(0);
    ((ImageView)paramView.findViewById(2131099854)).setVisibility(0);
    if (i1 <= 0)
    {
      ((TextView)paramView.findViewById(2131099856)).setVisibility(8);
      ((TextView)paramView.findViewById(2131099857)).setText("选择抵扣券");
    }
    else
    {
      ((TextView)paramView.findViewById(2131099856)).setVisibility(0);
      paramView = (TextView)paramView.findViewById(2131099857);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(o.a().k());
      localStringBuilder.append(" 已减");
      localStringBuilder.append(APTools.a(i1, 2));
      localStringBuilder.append("元");
      paramView.setText(localStringBuilder.toString());
    }
    ((LinearLayout)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (it.this.d != null)
        {
          paramAnonymousView = new Intent(it.this.d, APGoldCouponsDeductSelectValueActivity.class);
          it.this.d.startActivityForResult(paramAnonymousView, 1001);
          it.this.d.overridePendingTransition(fm.a(it.this.d, "unipay_anim_in_from_right"), fm.a(it.this.d, "unipay_anim_out_to_left"));
          return;
        }
        if (it.d(it.this) != null)
        {
          paramAnonymousView = new Intent(it.d(it.this), APGoldCouponsDeductSelectValueActivity.class);
          if ((it.d(it.this) instanceof Activity))
          {
            ((Activity)it.d(it.this)).startActivityForResult(paramAnonymousView, 1001);
            ((Activity)it.d(it.this)).overridePendingTransition(fm.a(it.d(it.this), "unipay_anim_in_from_right"), fm.a(it.d(it.this), "unipay_anim_out_to_left"));
            return;
          }
          APLog.e("APChannelView", "initDeductCoupons(): onClick context is not activity!");
          return;
        }
        APLog.e("APChannelView", "initDeductCoupons(): onClick context is null!");
      }
    });
  }
  
  private void c(String paramString)
  {
    this.r = paramString;
    if (("hfpay".equals(this.r)) && (this.t == 4))
    {
      this.x = ed.b().n().e.g;
      ed.b().n().e.g = "1";
    }
    gc localgc = gd.a().d(this.r);
    this.o.setVisibility(8);
    this.p.setVisibility(8);
    b(this.y);
    this.j.setText(ed.b().n().b.a);
    paramString = "";
    this.k.setText(this.s.b.b);
    Object localObject1;
    if (localgc == null) {
      localObject1 = "";
    } else {
      localObject1 = localgc.f;
    }
    switch (this.t)
    {
    default: 
      break;
    case 5: 
      if (fs.a().f() == fs.a.a)
      {
        this.k.setVisibility(8);
        paramString = this.s.b.b;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(" × ");
        paramString.append(this.s.e.g);
        paramString = paramString.toString();
      }
      break;
    case 4: 
      if (fs.a().f() == fs.a.a)
      {
        this.k.setVisibility(8);
        paramString = this.s.b.b;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(this.z.getString(2131230828));
        paramString.append(" ");
        paramString.append(this.s.e.g);
        paramString.append(((en)this.s.b).h());
        paramString = paramString.toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      paramString = new StringBuilder();
      paramString.append(this.z.getString(2131230828));
      paramString.append(this.s.e.g);
      paramString = paramString.toString();
    }
    Object localObject2;
    if ((this.t != 3) && (this.t != 2))
    {
      if (APUICommonMethod.h())
      {
        paramString = (el)this.s.b;
        this.l.setText(paramString.h());
      }
      else
      {
        localObject2 = this.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(this.s.a.extendInfo.unit);
        ((TextView)localObject2).setText(localStringBuilder.toString());
      }
    }
    else {
      this.l.setText(paramString);
    }
    if (!APAppDataInterface.singleton().h()) {
      this.l.setVisibility(8);
    }
    if (localgc != null)
    {
      this.q.setBackgroundResource(localgc.c);
      localObject2 = localgc.b;
      paramString = (String)localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramString = (String)localObject2;
        if (!((String)localObject1).trim().equals("100"))
        {
          paramString = (String)localObject2;
          if (!((String)localObject1).trim().equals("10"))
          {
            paramString = ed.b().n();
            int i1 = APTools.g(paramString.b.a());
            if (((paramString.a.saveType == 3) || (paramString.a.saveType == 2)) && ("qqwallet".equals(this.r)))
            {
              try
              {
                int i2 = Integer.valueOf((String)localObject1).intValue();
                paramString = (String)localObject2;
                if (i2 <= 0) {
                  break label855;
                }
                paramString = (String)localObject2;
                if (i2 >= 100) {
                  break label855;
                }
                paramString = new BigDecimal(i2).divide(new BigDecimal(100));
                paramString = new BigDecimal(1).subtract(paramString);
                paramString = APTools.a(new BigDecimal(i1).multiply(paramString).intValue());
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
      label855:
      d(paramString);
    }
    a(false, false, null);
    paramString = (TextView)this.y.findViewById(2131100041);
    if (!"hfpay".equals(this.r))
    {
      if ((this.s.a.saveType != 4) && (this.s.a.saveType != 5)) {
        paramString.setVisibility(8);
      } else if (((en)this.s.b).n.equals("1"))
      {
        if (!APTools.o(this.r))
        {
          paramString.setText("(不支持自动续费)");
          paramString.setVisibility(0);
          paramString.setTextColor(this.y.getResources().getColor(2130903085));
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
    else {
      paramString.setVisibility(8);
    }
    paramString = (TextView)this.y.findViewById(2131099842);
    if (localgc != null)
    {
      if (!TextUtils.isEmpty(localgc.g))
      {
        paramString.setVisibility(0);
        paramString.setText(localgc.g);
      }
      else
      {
        paramString.setVisibility(8);
      }
    }
    else {
      paramString.setVisibility(8);
    }
    this.i.setText("确认支付");
  }
  
  private void d()
  {
    String str2 = this.r;
    String str1 = str2;
    if (this.h.getVisibility() == 8)
    {
      str1 = str2;
      if (o.a().b())
      {
        str1 = "goldcouponsdeduct";
        APRecoChannelActivity.b = true;
      }
    }
    if (!"qqcard".equals(str1)) {
      e(str1);
    }
    if (("wechat".equals(str1)) || ("qqwallet".equals(str1)) || (a(str1))) {
      APRecoChannelActivity.b = true;
    }
    ((LinearLayout)this.y.findViewById(2131099855)).setEnabled(false);
    es.a().a(this.z, str1, null, this.f, null);
  }
  
  private void d(String paramString)
  {
    Object localObject = paramString;
    if ("mcard".equals(this.r))
    {
      localObject = paramString;
      if (this.s.d.h > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(String.format("(余额%s元)", new Object[] { this.s.d.c() }));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    this.n.setText((CharSequence)localObject);
  }
  
  private void e()
  {
    if (("hfpay".equals(this.r)) && (this.t == 4) && (!TextUtils.isEmpty(this.x))) {
      ed.b().n().e.g = this.x;
    }
    fp.a().e(true);
    APDataReportManager.getInstance().insertData("sdk.payexpress.change", this.t, ed.b().n().e.l, ed.b().n().e.f, null);
    new Bundle().putBoolean("isFromExpress", true);
    this.d.a(2, 1, null);
  }
  
  private void e(String paramString)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    localLayoutParams.height = this.b.getMeasuredHeight();
    this.b.setVisibility(8);
    this.e.setLayoutParams(localLayoutParams);
    this.e.setVisibility(0);
    if ("wechat".equals(paramString)) {
      this.e.setText("正在进入微信支付");
    } else if ("qqwallet".equals(paramString)) {
      this.e.setText("正在进入QQ钱包支付");
    } else {
      this.e.setText("");
    }
    this.e.b();
    a(true);
  }
  
  private void f()
  {
    if (APRecoChannelActivity.a()) {
      return;
    }
    if (("hfpay".equals(this.r)) && (this.t == 4) && (!TextUtils.isEmpty(this.x))) {
      ed.b().n().e.g = this.x;
    }
    if (fp.a().g().equals("AndroidPay"))
    {
      APUICommonMethod.b();
      fm.a(2, "");
      return;
    }
    this.d.finish();
    APUICommonMethod.b(this.d);
  }
  
  private void g()
  {
    ek localek;
    Object localObject;
    if (((this.t == 0) || (this.t == 1)) && ("wechat".equals(this.r)))
    {
      localek = this.s.b;
      if (2 == localek.e())
      {
        ((LinearLayout)this.y.findViewById(2131100029)).setVisibility(0);
      }
      else if ((localek.e() == 0) || (1 == localek.e()))
      {
        ((LinearLayout)this.y.findViewById(2131100030)).setVisibility(0);
        localObject = (CheckBox)this.y.findViewById(2131100031);
        if (1 == localek.e())
        {
          ((CheckBox)localObject).setChecked(true);
          this.s.b.c(2);
        }
        else
        {
          ((CheckBox)localObject).setChecked(false);
          this.s.b.c(1);
        }
        ((CheckBox)localObject).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              it.c(it.this).b.c(2);
              return;
            }
            it.c(it.this).b.c(1);
          }
        });
      }
    }
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("signState", String.valueOf(localek.e()));
      ((HashMap)localObject).put("userSignChoose", String.valueOf(this.s.b.f()));
      APDataReportManager.getInstance().insertData("sdk.wechat.sign.show", this.t, ed.b().n().e.l, ed.b().n().e.f, fm.a((HashMap)localObject));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h()
  {
    Intent localIntent = new Intent(this.z, APPayProgressActivity.class);
    localIntent.putExtra("channel", 8);
    this.z.startActivity(localIntent);
    ((Activity)this.z).finish();
  }
  
  private void i()
  {
    try
    {
      this.e.a();
      this.e.setVisibility(8);
      this.b.setVisibility(0);
      a(false);
      APRecoChannelActivity.b = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    this.d = paramAPRecoChannelActivity;
    this.z = paramContext;
    this.s = ed.b().n();
    this.t = this.s.a.saveType;
    paramAPRecoChannelActivity = LayoutInflater.from(paramContext).inflate(2131165199, null);
    this.y = paramAPRecoChannelActivity;
    try
    {
      a(paramAPRecoChannelActivity);
      c(ed.b().n().e.f);
      g();
      APLog.i("APViewCommon_getContentView", "1");
      return paramAPRecoChannelActivity;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      paramBundle = APDataReportManager.getInstance();
      String str = ed.b().n().e.f;
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
      final String str1 = ed.b().n().e.f;
      if ((("wechat".equals(str1)) || ("qqwallet".equals(str1))) && (((!fp.a().W()) && ("wechat".equals(str1))) || ((!fp.a().X()) && ("qqwallet".equals(str1)))))
      {
        if (n.a().c(str1)) {
          if ((ed.b().n().e != null) && (!TextUtils.isEmpty(fp.a().D())) && (!TextUtils.isEmpty(ed.b().n().b())))
          {
            fp.a().p(true);
            fp.a().q(true);
            n.a().j();
            i();
            b(this.y);
          }
          else
          {
            i();
            return;
          }
        }
        if ((ed.b().n().e != null) && (!TextUtils.isEmpty(ed.b().n().e.p)))
        {
          e("");
          bs.a().h(new kl()
          {
            public void a(jw paramAnonymousjw)
            {
              it.e(it.this);
              paramAnonymousjw = (df)paramAnonymousjw;
              if ((paramAnonymousjw.R() == 0) && (paramAnonymousjw.a() == 1))
              {
                es.a();
                es.a(str1).a(null);
              }
            }
            
            public void b(jw paramAnonymousjw)
            {
              it.e(it.this);
            }
            
            public void c(jw paramAnonymousjw)
            {
              it.e(it.this);
            }
          });
        }
        else
        {
          i();
          return;
        }
      }
      if (n.a().h())
      {
        this.s.e.f = this.r;
        b(this.y);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      String str2 = ed.b().n().e.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APViewCommon_onresume_");
      localStringBuilder.append(APTools.d(localThrowable));
      localAPDataReportManager.a("sdk.err.view", str2, localStringBuilder.toString());
    }
    super.a();
  }
  
  public void a(String paramString, final boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("context:");
    ((StringBuilder)localObject).append(this.z);
    APLog.e("APViewCommon showMessageAlert", ((StringBuilder)localObject).toString());
    localObject = new APAlertDialog.a(this.z);
    ((APAlertDialog.a)localObject).a(paramString);
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
        fm.a(-1, "");
      }
    });
    ((APAlertDialog.a)localObject).b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0) && ((paramBoolean) || (!a.a().f)))
        {
          APUICommonMethod.b();
          fm.a(-1, "");
        }
      }
    });
    try
    {
      ((APAlertDialog.a)localObject).c();
      return;
    }
    catch (Exception paramString) {}
  }
  
  protected boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      b(this.y);
      return true;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 101)
      {
        b(this.y);
        return true;
      }
      if (paramInt2 == 102)
      {
        this.d.a(2, 1, null);
        return true;
      }
      if (paramInt2 == 103) {
        this.d.a(2, 2, null);
      }
    }
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (("hfpay".equals(this.r)) && (this.t == 4) && (!TextUtils.isEmpty(this.x))) {
        ed.b().n().e.g = this.x;
      }
      APDataReportManager.getInstance().insertData("sdk.payexpress.change", this.t, ed.b().n().e.l, ed.b().n().e.f, null);
      if (!TextUtils.isEmpty(this.s.e.j))
      {
        if (fp.a().g().equals("AndroidPay"))
        {
          APUICommonMethod.b();
          fm.a(2, "");
          return true;
        }
        this.d.finish();
        APUICommonMethod.b(this.d);
        return true;
      }
      if ("wechat".equals(this.r))
      {
        if (fp.a().g().equals("AndroidPay"))
        {
          APUICommonMethod.b();
          fm.a(2, "");
          return true;
        }
        this.d.finish();
        APUICommonMethod.b(this.d);
        return true;
      }
      this.d.a(1, 2, null);
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ("mcard".equals(paramString)) {
      return ((APMcardChannel)es.a(paramString)).f();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == this.g.getId())
    {
      APDataReportManager.getInstance().insertData("sdk.payexpress.close", this.t, ed.b().n().e.l, ed.b().n().e.f, null);
      f();
      return;
    }
    if (paramView.getId() == this.h.getId())
    {
      APDataReportManager.getInstance().insertData("sdk.payexpress.change", this.t, ed.b().n().e.l, ed.b().n().e.f, null);
      e();
      return;
    }
    if (paramView.getId() == this.i.getId())
    {
      APDataReportManager.getInstance().insertData("sdk.payexpress.sure", this.t, ed.b().n().e.l, ed.b().n().e.f, null);
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.it
 * JD-Core Version:    0.7.0.1
 */