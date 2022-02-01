package midas.x;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.qdqb.APQDQBChannel;
import com.pay.permission.APPermissionActivity;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity;
import com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity;
import com.pay.ui.qdsafe.APSafeCenterWebActivity;
import com.pay.ui.qdsafe.APSafeCenterX5WebActivity;
import com.pay.ui.recoChannel.APRecoChannelActivity;
import com.tencent.midas.comm.APLog;
import java.io.PrintStream;

public class jh
  extends jd
{
  private TextView A;
  public EditText a;
  protected TextView b;
  protected LinearLayout e;
  protected AP3PointsLoading f;
  protected LinearLayout g;
  protected Button h;
  protected TextView i;
  int j = 60;
  int k;
  String l;
  Handler m;
  a n;
  fs o;
  ft p;
  ContentResolver q;
  Button r;
  View s;
  Context t;
  boolean u = false;
  String v;
  boolean w;
  dz x;
  private LinearLayout y;
  private ImageView z;
  
  private void a(Context paramContext, View paramView, Bundle paramBundle)
  {
    el localel = em.b().n();
    final int i1 = localel.a.saveType;
    this.f = ((AP3PointsLoading)paramView.findViewById(2131099895));
    this.g = ((LinearLayout)paramView.findViewById(2131100016));
    this.e = ((LinearLayout)paramView.findViewById(2131099805));
    this.y = ((LinearLayout)paramView.findViewById(2131100018));
    this.z = ((ImageView)paramView.findViewById(2131100017));
    this.A = ((TextView)paramView.findViewById(2131100019));
    Object localObject1 = null;
    a(false, false, null);
    ((ImageButton)paramView.findViewById(2131099702)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((!TextUtils.isEmpty(jh.this.l)) && (jh.this.u)) {
          APDataReportManager.getInstance().insertData("sdk.smm.close", em.b().n().a.saveType, em.b().n().e.l, em.b().n().e.f, null);
        } else {
          APDataReportManager.getInstance().insertData("sdk.payexpress.close", i1, em.b().n().e.l, em.b().n().e.f, null);
        }
        jh.a(jh.this);
      }
    });
    this.r = ((Button)paramView.findViewById(2131099724));
    this.r.setEnabled(true);
    this.r.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        jh.b(jh.this);
        APDataReportManager.getInstance().insertData("sdk.payexpress.sure", i1, em.b().n().e.l, em.b().n().e.f, null);
        if ((!TextUtils.isEmpty(jh.this.l)) && (jh.this.u))
        {
          APDataReportManager.getInstance().insertData("sdk.smm.ok", i1, em.b().n().e.l, em.b().n().e.f, null);
          paramAnonymousView = jh.this.a.getText().toString().trim();
          if (TextUtils.isEmpty(paramAnonymousView))
          {
            jh.a(jh.this, true, false, "请输入验证码");
            return;
          }
          APLog.i("vercodeEdit", "被调用*****");
          APQDQBChannel.l = "2";
          APQDQBChannel.k = paramAnonymousView;
          jh.this.u = false;
        }
        jh.a(jh.this, true);
      }
    });
    ((LinearLayout)paramView.findViewById(2131099909)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        fy.a().e(true);
        APDataReportManager.getInstance().insertData("sdk.payexpress.change", i1, em.b().n().e.l, em.b().n().e.f, null);
        jh.c(jh.this);
        jh.this.c();
        jh.b(jh.this);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putBoolean("isFromExpress", true);
        jh.this.d.a(2, 1, paramAnonymousView);
      }
    });
    Object localObject2 = (TextView)paramView.findViewById(2131099831);
    if ((!d.a()) && (!d.b()))
    {
      if (a.a().j())
      {
        g();
      }
      else
      {
        String str;
        StringBuilder localStringBuilder;
        if ("qdqb".equals(localel.e.f))
        {
          localObject3 = paramContext.getString(2131230870);
          str = em.b().n().d.a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("(余额");
          localStringBuilder.append(str);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(")");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(paramContext.getString(2131230858));
          localStringBuilder.append(str);
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
        else
        {
          localObject3 = paramContext.getString(2131230863);
          str = em.b().n().d.b();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("(余额");
          localStringBuilder.append(str);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(")");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(paramContext.getString(2131230858));
          localStringBuilder.append(str);
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
      }
    }
    else if ("qdqb".equals(localel.e.f))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramContext.getString(2131230870));
      ((StringBuilder)localObject3).append(paramContext.getString(2131230858));
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramContext.getString(2131230863));
      ((StringBuilder)localObject3).append(paramContext.getString(2131230858));
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    }
    localObject2 = (TextView)paramView.findViewById(2131100041);
    if ((localel.a.saveType != 4) && (localel.a.saveType != 5)) {
      ((TextView)localObject2).setVisibility(8);
    } else if (((ew)localel.b).n.equals("1"))
    {
      if (!APTools.o(localel.e.f))
      {
        ((TextView)localObject2).setText("(不支持自动续费)");
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setTextColor(paramView.getResources().getColor(2130903085));
      }
      else
      {
        ((TextView)localObject2).setVisibility(8);
      }
    }
    else {
      ((TextView)localObject2).setVisibility(8);
    }
    localObject2 = gn.a().d(localel.e.f);
    Object localObject3 = (TextView)paramView.findViewById(2131099842);
    if (localObject2 != null)
    {
      if (!TextUtils.isEmpty(((gm)localObject2).g))
      {
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(((gm)localObject2).g);
      }
      else
      {
        ((TextView)localObject3).setVisibility(8);
      }
    }
    else {
      ((TextView)localObject3).setVisibility(8);
    }
    this.b = ((TextView)paramView.findViewById(2131100042));
    localObject2 = (TextView)paramView.findViewById(2131100002);
    ((TextView)localObject2).setText(localel.b.b);
    switch (i1)
    {
    default: 
      paramContext = (Context)localObject1;
      break;
    case 5: 
      if (gc.a().f() == gc.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        paramContext = localel.b.b;
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(" × ");
        paramContext.append(localel.e.g);
        paramContext = paramContext.toString();
      }
      break;
    case 4: 
      if (gc.a().f() == gc.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        paramContext = localel.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext.getString(2131230829));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(localel.e.g);
        ((StringBuilder)localObject1).append(((ew)localel.b).h());
        paramContext = ((StringBuilder)localObject1).toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getString(2131230829));
      ((StringBuilder)localObject1).append(localel.e.g);
      paramContext = ((StringBuilder)localObject1).toString();
    }
    localObject1 = (TextView)paramView.findViewById(2131100005);
    if (APUICommonMethod.h())
    {
      ((TextView)localObject1).setText(((eu)localel.b).h());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(localel.a.extendInfo.unit);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    if (!APAppDataInterface.singleton().h()) {
      ((TextView)localObject1).setVisibility(8);
    }
    a(paramView);
    this.b.setText(em.b().n().b.a);
    this.h = ((Button)paramView.findViewById(2131099863));
    this.a = ((EditText)paramView.findViewById(2131100015));
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getString("mbUrl"))))
    {
      a(paramBundle);
      return;
    }
    if ((!TextUtils.isEmpty(this.l)) && (this.u)) {
      h();
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.u = true;
    this.r.setEnabled(false);
    this.g.setVisibility(0);
    this.b.setText("请输入验证码");
    this.v = paramBundle.getString("mbUrl");
    this.k = paramBundle.getInt("smsRemain", -1);
    this.l = paramBundle.getString("mbSmsInfo");
    this.w = paramBundle.getBoolean("smsMbOnly", false);
    APDataReportManager.getInstance().insertData("sdk.smm.show", 0, em.b().n().e.l, em.b().n().e.f, null);
    paramBundle = new StringBuilder();
    paramBundle.append("processVC smsInfo:");
    paramBundle.append(this.l);
    APLog.i("APPayQDQBActivity", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("processVC count:");
    paramBundle.append(this.k);
    APLog.i("APPayQDQBActivity", paramBundle.toString());
    paramBundle = new StringBuilder();
    paramBundle.append("processVC h5Url:");
    paramBundle.append(this.v);
    APLog.i("APPayQDQBActivity", paramBundle.toString());
    this.a.setText("");
    this.a.setFilters(new InputFilter[] { new InputFilter.LengthFilter(8) });
    this.a.setSelectAllOnFocus(false);
    this.a.requestFocus();
    this.a.setFocusable(true);
    this.a.setHint(this.t.getString(2131230757));
    this.a.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        jh.a(jh.this, false, false, null);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.m = new Handler();
    this.n = new a(null);
    this.p = new ft(this);
    this.q = this.t.getContentResolver();
    this.h.setEnabled(true);
    this.h.requestFocus();
    this.h.setFocusable(true);
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.smm.getsmmcode", 0, em.b().n().e.l, em.b().n().e.f, null);
        ge.a = System.currentTimeMillis();
        paramAnonymousView = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("click time=");
        localStringBuilder.append(ge.a);
        paramAnonymousView.println(localStringBuilder.toString());
        jh.this.r.setEnabled(true);
        by.a().g(jh.this.l, new lw()
        {
          public void a(lh paramAnonymous2lh)
          {
            jh.a(jh.this, paramAnonymous2lh);
          }
          
          public void b(lh paramAnonymous2lh) {}
          
          public void c(lh paramAnonymous2lh) {}
        });
        jh.this.h.setEnabled(false);
        jh.this.m.post(jh.this.n);
      }
    });
    this.i = ((TextView)this.s.findViewById(2131099827));
    this.i.setVisibility(0);
    if (this.w)
    {
      this.i.setText(this.t.getString(2131230740));
      APDataReportManager.getInstance().insertData("sdk.smm.shensu", 0, em.b().n().e.l, em.b().n().e.f, null);
    }
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (id.b(jh.this.t)) {
          paramAnonymousView = new Intent(jh.this.t, APSafeCenterX5WebActivity.class);
        } else {
          paramAnonymousView = new Intent(jh.this.t, APSafeCenterWebActivity.class);
        }
        paramAnonymousView.putExtra("requesturl", jh.this.v);
        ((Activity)jh.this.t).startActivityForResult(paramAnonymousView, 100002);
      }
    });
  }
  
  private void a(View paramView)
  {
    if (n.a().h()) {
      e();
    } else if (o.a().b()) {
      b(paramView);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131100000);
    String str;
    StringBuilder localStringBuilder;
    int i1;
    if ("qdqb".equals(em.b().n().e.f))
    {
      str = em.b().n().b.c();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" Q点");
      localTextView.setText(localStringBuilder.toString());
      i1 = APTools.h(str);
    }
    else
    {
      str = em.b().n().b.d();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" Q币");
      localTextView.setText(localStringBuilder.toString());
      i1 = APTools.g(str);
    }
    a(paramView, i1);
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject = this.t.getResources().getConfiguration();
    if (((Configuration)localObject).orientation == 1)
    {
      paramView = (LinearLayout)paramView.findViewById(2131099909);
      if (paramInt != 0)
      {
        paramView.setVisibility(0);
        return;
      }
      paramView.setVisibility(8);
      return;
    }
    if (((Configuration)localObject).orientation == 2)
    {
      localObject = (LinearLayout)paramView.findViewById(2131099909);
      paramView = (Button)paramView.findViewById(2131099704);
      if (paramInt != 0)
      {
        ((LinearLayout)localObject).setVisibility(0);
        return;
      }
      ((LinearLayout)localObject).setVisibility(8);
    }
  }
  
  private void a(lh paramlh)
  {
    if (paramlh == null) {
      return;
    }
    this.x = ((dz)paramlh);
    int i1 = this.x.T();
    if (i1 != 0)
    {
      if ((i1 != 1094) && (i1 != 1099))
      {
        this.j = 0;
        this.h.setText("获取验证码");
        this.h.setVisibility(0);
        a(true, true, this.t.getString(2131230881));
      }
    }
    else
    {
      paramlh = this.x.a();
      String str = this.x.b();
      if (!TextUtils.isEmpty(paramlh))
      {
        EditText localEditText = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("手机");
        localStringBuilder.append(paramlh);
        localStringBuilder.append("验证码");
        localEditText.setHint(localStringBuilder.toString());
      }
      this.k = Integer.valueOf(str).intValue();
      if ((APPermissionActivity.a(this.t, "android.permission.READ_SMS")) && (this.o == null))
      {
        this.o = new fs(this.q, this.p);
        this.q.registerContentObserver(Uri.parse("content://sms/"), true, this.o);
      }
      if (this.k == 0)
      {
        this.h.setText(this.t.getString(2131230921));
        this.h.setEnabled(false);
        if (this.m != null) {
          this.m.removeCallbacksAndMessages(null);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    LinearLayout localLinearLayout = this.y;
    ImageView localImageView = this.z;
    TextView localTextView = this.A;
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
    if (o.a().b())
    {
      if (!o.a().o()) {
        return;
      }
      if (!o.a().c()) {
        return;
      }
      o.a().a(false);
      Object localObject = em.b().n().b.a(em.b().n().e.g);
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
          if (jh.this.d != null)
          {
            paramAnonymousView = new Intent(jh.this.d, APGoldCouponsDeductSelectValueActivity.class);
            jh.this.d.startActivityForResult(paramAnonymousView, 1001);
            jh.this.d.overridePendingTransition(fv.a(jh.this.d, "unipay_anim_in_from_right"), fv.a(jh.this.d, "unipay_anim_out_to_left"));
            return;
          }
          if (jh.this.t != null)
          {
            paramAnonymousView = new Intent(jh.this.t, APGoldCouponsDeductSelectValueActivity.class);
            if ((jh.this.t instanceof Activity))
            {
              ((Activity)jh.this.t).startActivityForResult(paramAnonymousView, 1001);
              ((Activity)jh.this.t).overridePendingTransition(fv.a(jh.this.t, "unipay_anim_in_from_right"), fv.a(jh.this.t, "unipay_anim_out_to_left"));
              return;
            }
            APLog.e("APChannelView", "initDeductCoupons(): onClick context is not activity!");
            return;
          }
          APLog.e("APChannelView", "initDeductCoupons(): onClick context is null!");
        }
      });
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    APRecoChannelActivity.b = true;
    ((LinearLayout)this.s.findViewById(2131099855)).setEnabled(false);
    j();
    String str2 = em.b().n().e.f;
    String str1 = str2;
    if (((LinearLayout)this.s.findViewById(2131099909)).getVisibility() == 8)
    {
      str1 = str2;
      if (o.a().b()) {
        str1 = "goldcouponsdeduct";
      }
    }
    fb.a().a(this.t, str1, null, new fe()new fd
    {
      public void a()
      {
        APRecoChannelActivity.b = false;
        ((LinearLayout)jh.this.s.findViewById(2131099855)).setEnabled(true);
        jh.this.f.a();
        jh.this.e.setVisibility(0);
        jh.this.f.setVisibility(8);
      }
      
      public void a(int paramAnonymousInt)
      {
        if (paramAnonymousInt == -999)
        {
          jh.e(jh.this);
          return;
        }
        ((LinearLayout)jh.this.s.findViewById(2131099855)).setEnabled(true);
        if (paramAnonymousInt == 0)
        {
          APRecoChannelActivity.b = true;
          jh.this.f.a();
          return;
        }
        APRecoChannelActivity.b = false;
        jh.this.f.a();
        jh.this.e.setVisibility(0);
        jh.this.f.setVisibility(8);
      }
      
      public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        APRecoChannelActivity.b = false;
        ((LinearLayout)jh.this.s.findViewById(2131099855)).setEnabled(true);
        jh.this.f.a();
        jh.this.e.setVisibility(0);
        jh.this.f.setVisibility(8);
      }
    }, new fd()
    {
      public void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt != 1125)
        {
          if (paramAnonymousInt != 10001)
          {
            jh.c(jh.this);
            return;
          }
          jh.a(jh.this, paramAnonymousBundle);
          return;
        }
        jh.this.u = true;
        if (paramAnonymousBundle != null)
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("errMsg");
          jh.a(jh.this, true, true, paramAnonymousBundle);
        }
      }
    });
  }
  
  private void d()
  {
    if (APRecoChannelActivity.b) {
      return;
    }
    k();
    f();
    int i1 = em.b().n().a.saveType;
    if (fy.a().g().equals("AndroidPay"))
    {
      APUICommonMethod.b();
      fv.a(2, "");
      return;
    }
    this.d.finish();
    APUICommonMethod.b(this.d);
  }
  
  private void e()
  {
    if (!n.a().h()) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)this.s.findViewById(2131099855);
    localLinearLayout.setVisibility(0);
    ((TextView)this.s.findViewById(2131099856)).setVisibility(8);
    ((ImageView)this.s.findViewById(2131099854)).setVisibility(8);
    Object localObject1;
    if (n.a().c(em.b().n().e.f))
    {
      int i1 = APTools.g(em.b().n().b.b(em.b().n().e.g));
      if ("qdqb".equals(em.b().n().e.f))
      {
        localObject1 = APTools.b(i1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(localObject1));
        ((StringBuilder)localObject2).append(" Q点");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = APTools.a(i1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(localObject1));
        ((StringBuilder)localObject2).append(" Q币");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      Object localObject2 = (TextView)this.s.findViewById(2131099857);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("券已减");
      localStringBuilder.append(n.a().g(em.b().n().e.f));
      localStringBuilder.append("元");
      ((TextView)localObject2).setText(localStringBuilder.toString());
      ((TextView)localObject2).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      localObject2 = (TextView)this.s.findViewById(2131100003);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).getPaint().setFlags(16);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)this.s.findViewById(2131100007)).setVisibility(4);
    }
    else
    {
      localObject1 = (TextView)this.s.findViewById(2131099857);
      ((TextView)localObject1).setText("选择抵扣券");
      ((TextView)localObject1).setTextColor(Color.parseColor("#338aec".toUpperCase()));
      ((TextView)this.s.findViewById(2131100003)).setVisibility(8);
      ((TextView)this.s.findViewById(2131100007)).setVisibility(8);
    }
    localLinearLayout.setOnClickListener(new gs()
    {
      public void a(View paramAnonymousView)
      {
        paramAnonymousView = new Intent();
        if (id.b(jh.this.t)) {
          paramAnonymousView.setClass(jh.this.t, APX5WebJSBridgeActivity.class);
        } else {
          paramAnonymousView.setClass(jh.this.t, APWebJSBridgeActivity.class);
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("pageName", hu.B);
        paramAnonymousView.putExtras(localBundle);
        ((Activity)jh.this.t).startActivityForResult(paramAnonymousView, 1);
      }
    });
  }
  
  private void f()
  {
    if (a.a().j()) {
      boolean bool = em.b().n().d.e;
    }
  }
  
  private void g()
  {
    TextView localTextView = (TextView)this.s.findViewById(2131099831);
    Object localObject1;
    if ("qdqb".equals(em.b().n().e.f))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.t.getString(2131230870));
      ((StringBuilder)localObject1).append(this.t.getString(2131230858));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.t.getString(2131230863));
      ((StringBuilder)localObject1).append(this.t.getString(2131230858));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (a.a().j())
    {
      Object localObject2;
      if (em.b().n().d.e)
      {
        if ((gc.a().i()) && (fy.a().x()))
        {
          str = gc.a().j();
          localObject2 = "uin";
        }
        else
        {
          str = em.b().n().d.k;
          localObject2 = em.b().n().d.l;
        }
        if ((!TextUtils.isEmpty(str)) && ("uin".equals(localObject2)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(str.charAt(0));
          ((StringBuilder)localObject2).append("***");
          ((StringBuilder)localObject2).append(str.substring(str.length() - 3, str.length()));
          str = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("(QQ:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(")");
          localTextView.setText(((StringBuilder)localObject2).toString());
          return;
        }
        localTextView.setText((CharSequence)localObject1);
        return;
      }
      if ((!em.b().n().e.k.equals("qdqb")) && (!em.b().n().e.k.equals("qbqd")))
      {
        localTextView.setText((CharSequence)localObject1);
        return;
      }
      String str = em.b().n().e.a;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str.charAt(0));
        ((StringBuilder)localObject2).append("***");
        ((StringBuilder)localObject2).append(str.substring(str.length() - 3, str.length()));
        str = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("(QQ:");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(")");
        localTextView.setText(((StringBuilder)localObject2).toString());
        localObject1 = (TextView)this.s.findViewById(2131099828);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            fy.a().d(true);
            jh.a(jh.this, false);
          }
        });
        return;
      }
      localTextView.setText((CharSequence)localObject1);
    }
  }
  
  private void h()
  {
    this.r = ((Button)this.s.findViewById(2131099724));
    this.r.setEnabled(true);
    this.g = ((LinearLayout)this.s.findViewById(2131100016));
    this.g.setVisibility(0);
    this.b = ((TextView)this.s.findViewById(2131100042));
    this.b.setText("请输入验证码");
    this.a = ((EditText)this.s.findViewById(2131100015));
    this.a.setText("");
    this.a.setFilters(new InputFilter[] { new InputFilter.LengthFilter(8) });
    this.a.setSelectAllOnFocus(false);
    this.a.requestFocus();
    this.a.setFocusable(true);
    this.a.setHint(this.t.getString(2131230757));
    this.a.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        jh.a(jh.this, false, false, null);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (this.m == null) {
      this.m = new Handler();
    }
    if (this.n == null) {
      this.n = new a(null);
    }
    this.h = ((Button)this.s.findViewById(2131099863));
    this.h.setEnabled(true);
    this.h.requestFocus();
    this.h.setFocusable(true);
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.smm.getsmmcode", 0, em.b().n().e.l, em.b().n().e.f, null);
        ge.a = System.currentTimeMillis();
        paramAnonymousView = System.out;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click time=");
        ((StringBuilder)localObject).append(ge.a);
        paramAnonymousView.println(((StringBuilder)localObject).toString());
        jh.this.r.setEnabled(true);
        paramAnonymousView = jh.this.t;
        localObject = new ResultReceiver(new Handler(Looper.getMainLooper()))
        {
          protected void onReceiveResult(int paramAnonymous2Int, Bundle paramAnonymous2Bundle)
          {
            jh.d(jh.this);
          }
        };
        APPermissionActivity.a(paramAnonymousView, new String[] { "android.permission.READ_SMS" }, (ResultReceiver)localObject);
      }
    });
    this.i = ((TextView)this.s.findViewById(2131099827));
    this.i.setVisibility(0);
    if (this.w)
    {
      this.i.setText(this.t.getString(2131230740));
      APDataReportManager.getInstance().insertData("sdk.smm.shensu", 0, em.b().n().e.l, em.b().n().e.f, null);
    }
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (id.b(jh.this.t)) {
          paramAnonymousView = new Intent(jh.this.t, APSafeCenterX5WebActivity.class);
        } else {
          paramAnonymousView = new Intent(jh.this.t, APSafeCenterWebActivity.class);
        }
        paramAnonymousView.putExtra("requesturl", jh.this.v);
        ((Activity)jh.this.t).startActivityForResult(paramAnonymousView, 100002);
      }
    });
    if (this.p == null) {
      this.p = new ft(this);
    }
    if (this.q == null) {
      this.q = this.t.getContentResolver();
    }
    a(this.x);
  }
  
  private void i()
  {
    by.a().g(this.l, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        jh.a(jh.this, paramAnonymouslh);
      }
      
      public void b(lh paramAnonymouslh) {}
      
      public void c(lh paramAnonymouslh) {}
    });
    this.h.setEnabled(false);
    this.m.post(this.n);
  }
  
  private void j()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.height = this.e.getMeasuredHeight();
    this.e.setVisibility(8);
    this.f.setLayoutParams(localLayoutParams);
    this.f.setVisibility(0);
    this.f.b();
  }
  
  private void k()
  {
    this.j = 0;
    if (this.h != null)
    {
      this.h.setText("获取验证码");
      this.h.setVisibility(0);
    }
    else
    {
      APLog.w("APViewQDQB", "resetState() getVerCodeButton==Null");
    }
    this.r.setEnabled(true);
    this.h.setEnabled(true);
    if (this.a != null) {
      this.a.setText("");
    } else {
      APLog.w("APViewQDQB", "resetState() vercodeEdit==Null");
    }
    this.l = "";
    APQDQBChannel.l = "";
    APQDQBChannel.k = "";
    APRecoChannelActivity.b = false;
    this.u = false;
  }
  
  public View a(APRecoChannelActivity paramAPRecoChannelActivity, Context paramContext, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getContentView activity:");
    ((StringBuilder)localObject).append(paramAPRecoChannelActivity);
    APLog.i("APViewQDQB", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getContentView context:");
    ((StringBuilder)localObject).append(paramContext);
    APLog.i("APViewQDQB", ((StringBuilder)localObject).toString());
    localObject = LayoutInflater.from(paramContext).inflate(2131165250, null);
    this.s = ((View)localObject);
    this.t = paramContext;
    this.d = paramAPRecoChannelActivity;
    try
    {
      a(paramContext, (View)localObject, paramBundle);
      return localObject;
    }
    catch (Throwable paramAPRecoChannelActivity)
    {
      paramAPRecoChannelActivity.printStackTrace();
      paramContext = APDataReportManager.getInstance();
      paramBundle = em.b().n().e.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APViewQDQB_getContentView_");
      localStringBuilder.append(APTools.d(paramAPRecoChannelActivity));
      paramContext.a("sdk.err.view", paramBundle, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onActivityResult resultCode=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" requestCode=");
    ((StringBuilder)localObject).append(paramInt1);
    APLog.i("APViewQDQB", ((StringBuilder)localObject).toString());
    if ((paramInt1 == 100002) && (paramInt2 == 10))
    {
      if (paramIntent != null)
      {
        localObject = (ge.a)paramIntent.getSerializableExtra("channel");
        paramIntent = paramIntent.getStringExtra("sig");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult sig.size=");
        localStringBuilder.append(paramIntent.length());
        localStringBuilder.append(" channel=");
        localStringBuilder.append(localObject);
        APLog.i("APViewQDQB", localStringBuilder.toString());
        if (paramIntent.length() > 15) {
          APQDQBChannel.k = paramIntent;
        } else {
          APQDQBChannel.k = "";
        }
        if (localObject == ge.a.a) {
          APQDQBChannel.l = "2";
        } else {
          APQDQBChannel.l = "";
        }
        if (!APQDQBChannel.k.equals(""))
        {
          b(false);
          return true;
        }
      }
    }
    else if (paramInt1 == 1)
    {
      if (paramInt2 == 101)
      {
        a(this.s);
        return true;
      }
      if (paramInt2 == 102)
      {
        this.d.a(2, 1, null);
        return true;
      }
      if (paramInt2 == 103)
      {
        this.d.a(2, 2, null);
        return true;
      }
    }
    else
    {
      a(this.s);
    }
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!TextUtils.isEmpty(this.l)) && (this.u)) {
      APDataReportManager.getInstance().insertData("sdk.smm.keyback", em.b().n().a.saveType, em.b().n().e.l, em.b().n().e.f, null);
    } else {
      APDataReportManager.getInstance().insertData("sdk.payexpress.keyback", em.b().n().a.saveType, em.b().n().e.l, em.b().n().e.f, null);
    }
    d();
    return true;
  }
  
  public void c()
  {
    ((InputMethodManager)this.d.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
  }
  
  class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      if (jh.this.j == 0)
      {
        jh.this.h.setTextSize(14.0F);
        if ((jh.this.k <= 0) && (jh.this.k >= 0))
        {
          jh.this.h.setText(jh.this.t.getString(2131230921));
          jh.this.h.setEnabled(false);
        }
        else
        {
          jh.this.h.setText(jh.this.t.getString(2131230919));
          jh.this.h.setEnabled(true);
        }
        jh.this.j = 60;
        jh.this.m.removeCallbacksAndMessages(null);
        return;
      }
      jh.this.r.setEnabled(true);
      jh.this.h.setEnabled(false);
      jh.this.m.removeCallbacksAndMessages(null);
      jh.this.h.setTextSize(12.0F);
      Object localObject = jh.this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(jh.this.j));
      localStringBuilder.append(jh.this.t.getString(2131230917));
      ((Button)localObject).setText(localStringBuilder.toString());
      localObject = jh.this;
      ((jh)localObject).j -= 1;
      jh.this.m.postDelayed(jh.this.n, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jh
 * JD-Core Version:    0.7.0.1
 */