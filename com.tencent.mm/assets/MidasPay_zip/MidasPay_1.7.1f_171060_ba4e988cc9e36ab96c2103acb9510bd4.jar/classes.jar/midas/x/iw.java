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

public class iw
  extends is
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
  fj o;
  fk p;
  ContentResolver q;
  Button r;
  View s;
  Context t;
  boolean u = false;
  String v;
  boolean w;
  dr x;
  private LinearLayout y;
  private ImageView z;
  
  private void a(Context paramContext, View paramView, Bundle paramBundle)
  {
    ec localec = ed.b().n();
    final int i1 = localec.a.saveType;
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
        if ((!TextUtils.isEmpty(iw.this.l)) && (iw.this.u)) {
          APDataReportManager.getInstance().insertData("sdk.smm.close", ed.b().n().a.saveType, ed.b().n().e.l, ed.b().n().e.f, null);
        } else {
          APDataReportManager.getInstance().insertData("sdk.payexpress.close", i1, ed.b().n().e.l, ed.b().n().e.f, null);
        }
        iw.a(iw.this);
      }
    });
    this.r = ((Button)paramView.findViewById(2131099724));
    this.r.setEnabled(true);
    this.r.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        iw.b(iw.this);
        APDataReportManager.getInstance().insertData("sdk.payexpress.sure", i1, ed.b().n().e.l, ed.b().n().e.f, null);
        if ((!TextUtils.isEmpty(iw.this.l)) && (iw.this.u))
        {
          APDataReportManager.getInstance().insertData("sdk.smm.ok", i1, ed.b().n().e.l, ed.b().n().e.f, null);
          paramAnonymousView = iw.this.a.getText().toString().trim();
          if (TextUtils.isEmpty(paramAnonymousView))
          {
            iw.a(iw.this, true, false, "请输入验证码");
            return;
          }
          APLog.i("vercodeEdit", "被调用*****");
          APQDQBChannel.k = "2";
          APQDQBChannel.j = paramAnonymousView;
          iw.this.u = false;
        }
        iw.a(iw.this, true);
      }
    });
    ((LinearLayout)paramView.findViewById(2131099909)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        fp.a().e(true);
        APDataReportManager.getInstance().insertData("sdk.payexpress.change", i1, ed.b().n().e.l, ed.b().n().e.f, null);
        iw.c(iw.this);
        iw.this.c();
        iw.b(iw.this);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putBoolean("isFromExpress", true);
        iw.this.d.a(2, 1, paramAnonymousView);
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
        if ("qdqb".equals(localec.e.f))
        {
          localObject3 = paramContext.getString(2131230869);
          str = ed.b().n().d.a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("(余额");
          localStringBuilder.append(str);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(")");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(paramContext.getString(2131230857));
          localStringBuilder.append(str);
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
        else
        {
          localObject3 = paramContext.getString(2131230862);
          str = ed.b().n().d.b();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("(余额");
          localStringBuilder.append(str);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(")");
          str = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(paramContext.getString(2131230857));
          localStringBuilder.append(str);
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
      }
    }
    else if ("qdqb".equals(localec.e.f))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramContext.getString(2131230869));
      ((StringBuilder)localObject3).append(paramContext.getString(2131230857));
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramContext.getString(2131230862));
      ((StringBuilder)localObject3).append(paramContext.getString(2131230857));
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    }
    localObject2 = (TextView)paramView.findViewById(2131100041);
    if ((localec.a.saveType != 4) && (localec.a.saveType != 5)) {
      ((TextView)localObject2).setVisibility(8);
    } else if (((en)localec.b).n.equals("1"))
    {
      if (!APTools.o(localec.e.f))
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
    localObject2 = gd.a().d(localec.e.f);
    Object localObject3 = (TextView)paramView.findViewById(2131099842);
    if (localObject2 != null)
    {
      if (!TextUtils.isEmpty(((gc)localObject2).g))
      {
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(((gc)localObject2).g);
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
    ((TextView)localObject2).setText(localec.b.b);
    switch (i1)
    {
    default: 
      paramContext = (Context)localObject1;
      break;
    case 5: 
      if (fs.a().f() == fs.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        paramContext = localec.b.b;
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(" × ");
        paramContext.append(localec.e.g);
        paramContext = paramContext.toString();
      }
      break;
    case 4: 
      if (fs.a().f() == fs.a.a)
      {
        ((TextView)localObject2).setVisibility(8);
        paramContext = localec.b.b;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext.getString(2131230828));
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(localec.e.g);
        ((StringBuilder)localObject1).append(((en)localec.b).h());
        paramContext = ((StringBuilder)localObject1).toString();
      }
      break;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getString(2131230828));
      ((StringBuilder)localObject1).append(localec.e.g);
      paramContext = ((StringBuilder)localObject1).toString();
    }
    localObject1 = (TextView)paramView.findViewById(2131100005);
    if (APUICommonMethod.h())
    {
      ((TextView)localObject1).setText(((el)localec.b).h());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(localec.a.extendInfo.unit);
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    }
    if (!APAppDataInterface.singleton().h()) {
      ((TextView)localObject1).setVisibility(8);
    }
    a(paramView);
    this.b.setText(ed.b().n().b.a);
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
    APDataReportManager.getInstance().insertData("sdk.smm.show", 0, ed.b().n().e.l, ed.b().n().e.f, null);
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
    this.a.setHint(this.t.getString(2131230756));
    this.a.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        iw.a(iw.this, false, false, null);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.m = new Handler();
    this.n = new a(null);
    this.p = new fk(this);
    this.q = this.t.getContentResolver();
    this.h.setEnabled(true);
    this.h.requestFocus();
    this.h.setFocusable(true);
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APDataReportManager.getInstance().insertData("sdk.smm.getsmmcode", 0, ed.b().n().e.l, ed.b().n().e.f, null);
        fu.a = System.currentTimeMillis();
        paramAnonymousView = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("click time=");
        localStringBuilder.append(fu.a);
        paramAnonymousView.println(localStringBuilder.toString());
        iw.this.r.setEnabled(true);
        bs.a().g(iw.this.l, new kl()
        {
          public void a(jw paramAnonymous2jw)
          {
            iw.a(iw.this, paramAnonymous2jw);
          }
          
          public void b(jw paramAnonymous2jw) {}
          
          public void c(jw paramAnonymous2jw) {}
        });
        iw.this.h.setEnabled(false);
        iw.this.m.post(iw.this.n);
      }
    });
    this.i = ((TextView)this.s.findViewById(2131099827));
    this.i.setVisibility(0);
    if (this.w)
    {
      this.i.setText(this.t.getString(2131230740));
      APDataReportManager.getInstance().insertData("sdk.smm.shensu", 0, ed.b().n().e.l, ed.b().n().e.f, null);
    }
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (hs.b(iw.this.t)) {
          paramAnonymousView = new Intent(iw.this.t, APSafeCenterX5WebActivity.class);
        } else {
          paramAnonymousView = new Intent(iw.this.t, APSafeCenterWebActivity.class);
        }
        paramAnonymousView.putExtra("requesturl", iw.this.v);
        ((Activity)iw.this.t).startActivityForResult(paramAnonymousView, 100002);
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
    if ("qdqb".equals(ed.b().n().e.f))
    {
      str = ed.b().n().b.c();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" Q点");
      localTextView.setText(localStringBuilder.toString());
      i1 = APTools.h(str);
    }
    else
    {
      str = ed.b().n().b.d();
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
  
  private void a(jw paramjw)
  {
    if (paramjw == null) {
      return;
    }
    this.x = ((dr)paramjw);
    int i1 = this.x.R();
    if (i1 != 0)
    {
      if ((i1 != 1094) && (i1 != 1099))
      {
        this.j = 0;
        this.h.setText("获取验证码");
        this.h.setVisibility(0);
        a(true, true, this.t.getString(2131230880));
      }
    }
    else
    {
      paramjw = this.x.a();
      String str = this.x.b();
      if (!TextUtils.isEmpty(paramjw))
      {
        EditText localEditText = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("手机");
        localStringBuilder.append(paramjw);
        localStringBuilder.append("验证码");
        localEditText.setHint(localStringBuilder.toString());
      }
      this.k = Integer.valueOf(str).intValue();
      if ((APPermissionActivity.a(this.t, "android.permission.READ_SMS")) && (this.o == null))
      {
        this.o = new fj(this.q, this.p);
        this.q.registerContentObserver(Uri.parse("content://sms/"), true, this.o);
      }
      if (this.k == 0)
      {
        this.h.setText(this.t.getString(2131230920));
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
      Object localObject = ed.b().n().b.a(ed.b().n().e.g);
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
          if (iw.this.d != null)
          {
            paramAnonymousView = new Intent(iw.this.d, APGoldCouponsDeductSelectValueActivity.class);
            iw.this.d.startActivityForResult(paramAnonymousView, 1001);
            iw.this.d.overridePendingTransition(fm.a(iw.this.d, "unipay_anim_in_from_right"), fm.a(iw.this.d, "unipay_anim_out_to_left"));
            return;
          }
          if (iw.this.t != null)
          {
            paramAnonymousView = new Intent(iw.this.t, APGoldCouponsDeductSelectValueActivity.class);
            if ((iw.this.t instanceof Activity))
            {
              ((Activity)iw.this.t).startActivityForResult(paramAnonymousView, 1001);
              ((Activity)iw.this.t).overridePendingTransition(fm.a(iw.this.t, "unipay_anim_in_from_right"), fm.a(iw.this.t, "unipay_anim_out_to_left"));
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
    String str2 = ed.b().n().e.f;
    String str1 = str2;
    if (((LinearLayout)this.s.findViewById(2131099909)).getVisibility() == 8)
    {
      str1 = str2;
      if (o.a().b()) {
        str1 = "goldcouponsdeduct";
      }
    }
    es.a().a(this.t, str1, null, new ev()new eu
    {
      public void a()
      {
        APRecoChannelActivity.b = false;
        ((LinearLayout)iw.this.s.findViewById(2131099855)).setEnabled(true);
        iw.this.f.a();
        iw.this.e.setVisibility(0);
        iw.this.f.setVisibility(8);
      }
      
      public void a(int paramAnonymousInt)
      {
        if (paramAnonymousInt == -999)
        {
          iw.e(iw.this);
          return;
        }
        ((LinearLayout)iw.this.s.findViewById(2131099855)).setEnabled(true);
        if (paramAnonymousInt == 0)
        {
          APRecoChannelActivity.b = true;
          iw.this.f.a();
          return;
        }
        APRecoChannelActivity.b = false;
        iw.this.f.a();
        iw.this.e.setVisibility(0);
        iw.this.f.setVisibility(8);
      }
      
      public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        APRecoChannelActivity.b = false;
        ((LinearLayout)iw.this.s.findViewById(2131099855)).setEnabled(true);
        iw.this.f.a();
        iw.this.e.setVisibility(0);
        iw.this.f.setVisibility(8);
      }
    }, new eu()
    {
      public void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt != 1125)
        {
          if (paramAnonymousInt != 10001)
          {
            iw.c(iw.this);
            return;
          }
          iw.a(iw.this, paramAnonymousBundle);
          return;
        }
        iw.this.u = true;
        if (paramAnonymousBundle != null)
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("errMsg");
          iw.a(iw.this, true, true, paramAnonymousBundle);
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
    int i1 = ed.b().n().a.saveType;
    if (fp.a().g().equals("AndroidPay"))
    {
      APUICommonMethod.b();
      fm.a(2, "");
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
    if (n.a().c(ed.b().n().e.f))
    {
      int i1 = APTools.g(ed.b().n().b.b(ed.b().n().e.g));
      if ("qdqb".equals(ed.b().n().e.f))
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
      localStringBuilder.append(n.a().g(ed.b().n().e.f));
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
    localLinearLayout.setOnClickListener(new gh()
    {
      public void a(View paramAnonymousView)
      {
        paramAnonymousView = new Intent();
        if (hs.b(iw.this.t)) {
          paramAnonymousView.setClass(iw.this.t, APX5WebJSBridgeActivity.class);
        } else {
          paramAnonymousView.setClass(iw.this.t, APWebJSBridgeActivity.class);
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("pageName", hj.B);
        paramAnonymousView.putExtras(localBundle);
        ((Activity)iw.this.t).startActivityForResult(paramAnonymousView, 1);
      }
    });
  }
  
  private void f()
  {
    if (a.a().j()) {
      boolean bool = ed.b().n().d.e;
    }
  }
  
  private void g()
  {
    TextView localTextView = (TextView)this.s.findViewById(2131099831);
    Object localObject1;
    if ("qdqb".equals(ed.b().n().e.f))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.t.getString(2131230869));
      ((StringBuilder)localObject1).append(this.t.getString(2131230857));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.t.getString(2131230862));
      ((StringBuilder)localObject1).append(this.t.getString(2131230857));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (a.a().j())
    {
      Object localObject2;
      if (ed.b().n().d.e)
      {
        if ((fs.a().i()) && (fp.a().x()))
        {
          str = fs.a().j();
          localObject2 = "uin";
        }
        else
        {
          str = ed.b().n().d.k;
          localObject2 = ed.b().n().d.l;
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
      if ((!ed.b().n().e.k.equals("qdqb")) && (!ed.b().n().e.k.equals("qbqd")))
      {
        localTextView.setText((CharSequence)localObject1);
        return;
      }
      String str = ed.b().n().e.a;
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
            fp.a().d(true);
            iw.a(iw.this, false);
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
    this.a.setHint(this.t.getString(2131230756));
    this.a.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        iw.a(iw.this, false, false, null);
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
        APDataReportManager.getInstance().insertData("sdk.smm.getsmmcode", 0, ed.b().n().e.l, ed.b().n().e.f, null);
        fu.a = System.currentTimeMillis();
        paramAnonymousView = System.out;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click time=");
        ((StringBuilder)localObject).append(fu.a);
        paramAnonymousView.println(((StringBuilder)localObject).toString());
        iw.this.r.setEnabled(true);
        paramAnonymousView = iw.this.t;
        localObject = new ResultReceiver(new Handler(Looper.getMainLooper()))
        {
          protected void onReceiveResult(int paramAnonymous2Int, Bundle paramAnonymous2Bundle)
          {
            iw.d(iw.this);
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
      APDataReportManager.getInstance().insertData("sdk.smm.shensu", 0, ed.b().n().e.l, ed.b().n().e.f, null);
    }
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (hs.b(iw.this.t)) {
          paramAnonymousView = new Intent(iw.this.t, APSafeCenterX5WebActivity.class);
        } else {
          paramAnonymousView = new Intent(iw.this.t, APSafeCenterWebActivity.class);
        }
        paramAnonymousView.putExtra("requesturl", iw.this.v);
        ((Activity)iw.this.t).startActivityForResult(paramAnonymousView, 100002);
      }
    });
    if (this.p == null) {
      this.p = new fk(this);
    }
    if (this.q == null) {
      this.q = this.t.getContentResolver();
    }
    a(this.x);
  }
  
  private void i()
  {
    bs.a().g(this.l, new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        iw.a(iw.this, paramAnonymousjw);
      }
      
      public void b(jw paramAnonymousjw) {}
      
      public void c(jw paramAnonymousjw) {}
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
    APQDQBChannel.k = "";
    APQDQBChannel.j = "";
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
    localObject = LayoutInflater.from(paramContext).inflate(2131165249, null);
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
      paramBundle = ed.b().n().e.f;
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
        localObject = (fu.a)paramIntent.getSerializableExtra("channel");
        paramIntent = paramIntent.getStringExtra("sig");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult sig.size=");
        localStringBuilder.append(paramIntent.length());
        localStringBuilder.append(" channel=");
        localStringBuilder.append(localObject);
        APLog.i("APViewQDQB", localStringBuilder.toString());
        if (paramIntent.length() > 15) {
          APQDQBChannel.j = paramIntent;
        } else {
          APQDQBChannel.j = "";
        }
        if (localObject == fu.a.a) {
          APQDQBChannel.k = "2";
        } else {
          APQDQBChannel.k = "";
        }
        if (!APQDQBChannel.j.equals(""))
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
      APDataReportManager.getInstance().insertData("sdk.smm.keyback", ed.b().n().a.saveType, ed.b().n().e.l, ed.b().n().e.f, null);
    } else {
      APDataReportManager.getInstance().insertData("sdk.payexpress.keyback", ed.b().n().a.saveType, ed.b().n().e.l, ed.b().n().e.f, null);
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
      if (iw.this.j == 0)
      {
        iw.this.h.setTextSize(14.0F);
        if ((iw.this.k <= 0) && (iw.this.k >= 0))
        {
          iw.this.h.setText(iw.this.t.getString(2131230920));
          iw.this.h.setEnabled(false);
        }
        else
        {
          iw.this.h.setText(iw.this.t.getString(2131230918));
          iw.this.h.setEnabled(true);
        }
        iw.this.j = 60;
        iw.this.m.removeCallbacksAndMessages(null);
        return;
      }
      iw.this.r.setEnabled(true);
      iw.this.h.setEnabled(false);
      iw.this.m.removeCallbacksAndMessages(null);
      iw.this.h.setTextSize(12.0F);
      Object localObject = iw.this.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(iw.this.j));
      localStringBuilder.append(iw.this.t.getString(2131230916));
      ((Button)localObject).setText(localStringBuilder.toString());
      localObject = iw.this;
      ((iw)localObject).j -= 1;
      iw.this.m.postDelayed(iw.this.n, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.iw
 * JD-Core Version:    0.7.0.1
 */