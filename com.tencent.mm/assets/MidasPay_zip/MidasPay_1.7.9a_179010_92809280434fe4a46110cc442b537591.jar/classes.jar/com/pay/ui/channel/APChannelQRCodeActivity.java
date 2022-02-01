package com.pay.ui.channel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.Hashtable;
import midas.x.a;
import midas.x.c6;
import midas.x.de;
import midas.x.e5;
import midas.x.fc;
import midas.x.g5;
import midas.x.h5;
import midas.x.i5;
import midas.x.j4;
import midas.x.k4;
import midas.x.le;
import midas.x.ob;
import midas.x.p4;
import midas.x.x1;
import midas.x.y3;
import midas.x.z1;
import midas.x.z5;
import midas.x.zd;

public class APChannelQRCodeActivity
  extends APActivity
{
  public long d = 840L;
  public long e = this.d;
  public int f = 0;
  public String g = "";
  public int h = 256;
  public int i = 2131034157;
  public ImageView j;
  public TextView k;
  public ImageView l;
  public View m;
  public RelativeLayout n;
  public ImageButton o;
  public TextView p;
  public TextView q;
  public CountDownTimer r = null;
  public boolean s = false;
  
  public final void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNetworkError() ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelQRCodeActivity", ((StringBuilder)localObject).toString());
    localObject = this.r;
    if (localObject != null) {
      ((CountDownTimer)localObject).cancel();
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("网络错误，请稍后再试(");
      paramString.append(x1.a(paramInt));
      paramString.append(")");
      localObject = paramString.toString();
    }
    paramString = APDataReportManager.getInstance();
    int i1 = p4.p().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("payChannel=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("&ret=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&msg=");
    localStringBuilder.append((String)localObject);
    paramString.insertData("sdk.qr.error", i1, null, "", localStringBuilder.toString());
    this.j.setVisibility(8);
    this.k.setText((CharSequence)localObject);
    this.n.setVisibility(0);
    this.o.setBackgroundResource(2131034158);
    this.p.setText("请重试");
    this.q.setVisibility(4);
    g();
    this.n.setEnabled(true);
    this.n.setOnClickListener(new g());
  }
  
  public final void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initUI() ");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelQRCodeActivity", ((StringBuilder)localObject).toString());
    this.j = ((ImageView)findViewById(2131099662));
    this.k = ((TextView)findViewById(2131099661));
    this.l = ((ImageView)findViewById(2131099659));
    this.m = findViewById(2131099660);
    this.n = ((RelativeLayout)findViewById(2131099656));
    this.o = ((ImageButton)findViewById(2131099657));
    this.p = ((TextView)findViewById(2131099658));
    this.q = ((TextView)findViewById(2131099663));
    localObject = (TextView)findViewById(2131099848);
    ((TextView)localObject).setText("扫码支付");
    ((TextView)localObject).setVisibility(0);
    ((ImageButton)findViewById(2131099832)).setOnClickListener(new c());
    localObject = BitmapFactory.decodeResource(getResources(), 2131034155);
    this.l.setImageBitmap((Bitmap)localObject);
    int i1;
    if ("wechat".equals(this.g)) {
      i1 = 2130903044;
    } else {
      i1 = 2130903043;
    }
    this.m.setBackgroundResource(i1);
    c(paramString);
  }
  
  public final void a(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQRCode() ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelQRCodeActivity", ((StringBuilder)localObject).toString());
    localObject = new Hashtable();
    ((Hashtable)localObject).put(zd.b, "UTF-8");
    ((Hashtable)localObject).put(zd.a, le.b);
    ((Hashtable)localObject).put(zd.f, Integer.valueOf(1));
    int i1 = this.h;
    localObject = de.a(paramString, i1, i1, -16777216, -1, (Hashtable)localObject);
    this.j.setVisibility(0);
    this.j.setImageResource(this.i);
    TextView localTextView = this.k;
    if ("wechat".equals(this.g)) {
      paramString = "微信";
    } else {
      paramString = "QQ";
    }
    localTextView.setText(String.format("打开%s扫一扫完成支付", new Object[] { paramString }));
    this.l.setImageBitmap((Bitmap)localObject);
    this.n.setVisibility(8);
    g();
    this.q.setVisibility(4);
    paramString = APDataReportManager.getInstance();
    i1 = p4.p().g();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("payChannel=");
    ((StringBuilder)localObject).append(this.g);
    paramString.insertData("sdk.qr.display", i1, null, "", ((StringBuilder)localObject).toString());
    paramString = this.r;
    if (paramString == null)
    {
      paramLong *= 1000L;
      this.r = new h(paramLong, paramLong);
    }
    else
    {
      paramString.cancel();
    }
    this.r.start();
    this.f = 0;
    i();
  }
  
  public final void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("obtainUrl() ");
    localStringBuilder.append(paramString);
    APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      this.s = false;
      e5.h();
      e5.a(this.g).a(this, new d(), new e());
      return;
    }
    d(paramString);
  }
  
  public final void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoading() ");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelQRCodeActivity", ((StringBuilder)localObject).toString());
    this.j.setVisibility(8);
    this.k.setText("正在获取二维码");
    this.n.setVisibility(0);
    this.n.setEnabled(false);
    this.o.setBackgroundResource(2131034158);
    this.p.setText("加载中...");
    this.q.setVisibility(4);
    localObject = AnimationUtils.loadAnimation(this, 2130771973);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    ((Animation)localObject).setRepeatMode(1);
    this.o.startAnimation((Animation)localObject);
    localObject = APDataReportManager.getInstance();
    int i1 = p4.p().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("payChannel=");
    localStringBuilder.append(this.g);
    ((APDataReportManager)localObject).insertData("sdk.qr.refresh", i1, null, "", localStringBuilder.toString());
    b(paramString);
  }
  
  public final void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shortenUrl() ");
    localStringBuilder.append(paramString);
    APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
    if ("wechat".equals(this.g))
    {
      this.e = this.d;
      a(paramString, this.e);
      return;
    }
    if ("qqwallet".equals(this.g)) {
      z1.d().a(paramString, "get_short_url", new f());
    }
  }
  
  public final void f()
  {
    finish();
    APUICommonMethod.a(this);
    e5.a(this.g).b(this, new b());
  }
  
  public final void g()
  {
    APLog.d("APChannelQRCodeActivity", "closeLoading()");
    this.o.clearAnimation();
  }
  
  public final void h()
  {
    APLog.d("APChannelQRCodeActivity", "disconnectListenning()");
    z1.d().a(k4.class.getSimpleName());
  }
  
  public final void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onListenning(), retryCount = ");
    localStringBuilder.append(this.f);
    APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
    this.f += 1;
    z1.d().c(new i());
  }
  
  public final void j()
  {
    c(null);
  }
  
  public final void k()
  {
    APLog.d("APChannelQRCodeActivity", "onNetworkStop()");
    n();
  }
  
  public final void l()
  {
    APLog.d("APChannelQRCodeActivity", "onPaying()");
    this.j.setVisibility(8);
    Object localObject2 = this.k;
    if ("wechat".equals(this.g)) {
      localObject1 = "微信";
    } else {
      localObject1 = "QQ";
    }
    ((TextView)localObject2).setText(String.format("请在%s上完成支付", new Object[] { localObject1 }));
    this.n.setVisibility(0);
    this.o.setBackgroundResource(2131034154);
    this.p.setText("正在支付");
    Object localObject1 = APDataReportManager.getInstance();
    int i1 = p4.p().g();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("payChannel=");
    ((StringBuilder)localObject2).append(this.g);
    ((APDataReportManager)localObject1).insertData("sdk.qr.paying", i1, null, "", ((StringBuilder)localObject2).toString());
    this.q.setVisibility(0);
    this.q.setText("返回二维码");
    this.q.setOnClickListener(new a());
  }
  
  public final void m()
  {
    APLog.d("APChannelQRCodeActivity", "onScanning()");
    Object localObject1 = APDataReportManager.getInstance();
    int i1 = p4.p().g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("payChannel=");
    ((StringBuilder)localObject2).append(this.g);
    ((APDataReportManager)localObject1).insertData("sdk.qr.scanning", i1, null, "", ((StringBuilder)localObject2).toString());
    this.j.setVisibility(8);
    localObject2 = this.k;
    if ("wechat".equals(this.g)) {
      localObject1 = "微信";
    } else {
      localObject1 = "QQ";
    }
    ((TextView)localObject2).setText(String.format("打开%s扫一扫完成支付", new Object[] { localObject1 }));
    this.n.setVisibility(0);
    this.o.setBackgroundResource(2131034154);
    this.p.setText("扫描完成");
    this.q.setVisibility(0);
    this.q.setText("返回二维码");
    this.q.setOnClickListener(new k());
  }
  
  public final void n()
  {
    APLog.d("APChannelQRCodeActivity", "onTimeout()");
    Object localObject1 = this.r;
    if (localObject1 != null) {
      ((CountDownTimer)localObject1).cancel();
    }
    h();
    g();
    localObject1 = APDataReportManager.getInstance();
    int i1 = p4.p().g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("payChannel=");
    ((StringBuilder)localObject2).append(this.g);
    ((APDataReportManager)localObject1).insertData("sdk.qr.timeout", i1, null, "", ((StringBuilder)localObject2).toString());
    this.j.setVisibility(8);
    this.k.setText("二维码已失效");
    this.n.setVisibility(0);
    final boolean bool = p4.p().j();
    this.o.setBackgroundResource(2131034158);
    localObject2 = this.p;
    if (bool) {
      localObject1 = "点击关闭，然后重新拉起支付";
    } else {
      localObject1 = "点击重新获取";
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    this.q.setVisibility(4);
    this.n.setEnabled(true);
    this.n.setOnClickListener(new j(bool));
  }
  
  public final void o()
  {
    APLog.d("APChannelQRCodeActivity", "toSuccessResult()");
    finish();
    APUICommonMethod.a(this);
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i1 = p4.p().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("payChannel=");
    localStringBuilder.append(this.g);
    localAPDataReportManager.insertData("sdk.qr.success", i1, null, "", localStringBuilder.toString());
    e5.h();
    e5.a(this.g).a(null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    APLog.d("APChannelQRCodeActivity", "onCreate()");
    if ((c6.s0().i()) && (a.r().d != null))
    {
      setContentView(2131165187);
      this.h = APUICommonMethod.a(this, 180.0F);
      this.g = getIntent().getStringExtra("payChannel");
      paramBundle = getIntent().getStringExtra("payUrl");
      int i1;
      if ("wechat".equals(this.g)) {
        i1 = 2131034157;
      } else {
        i1 = 2131034156;
      }
      this.i = i1;
      a(paramBundle);
      return;
    }
    finish();
    APUICommonMethod.a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    CountDownTimer localCountDownTimer = this.r;
    if (localCountDownTimer != null) {
      localCountDownTimer.cancel();
    }
    g();
    h();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = APDataReportManager.getInstance();
      paramInt = p4.p().g();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("payChannel=");
      localStringBuilder.append(this.g);
      paramKeyEvent.insertData("sdk.qr.keyback", paramInt, null, "", localStringBuilder.toString());
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i1 = p4.p().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("payChannel=");
    localStringBuilder.append(this.g);
    localAPDataReportManager.insertData("sdk.qr.show", i1, null, "", localStringBuilder.toString());
  }
  
  public class a
    implements View.OnClickListener
  {
    public a() {}
    
    public void onClick(View paramView)
    {
      APChannelQRCodeActivity.c(APChannelQRCodeActivity.this).setVisibility(4);
      APChannelQRCodeActivity.l(APChannelQRCodeActivity.this).setImageResource(APChannelQRCodeActivity.k(APChannelQRCodeActivity.this));
      APChannelQRCodeActivity.l(APChannelQRCodeActivity.this).setVisibility(0);
      TextView localTextView = APChannelQRCodeActivity.o(APChannelQRCodeActivity.this);
      if ("wechat".equals(APChannelQRCodeActivity.a(APChannelQRCodeActivity.this))) {
        paramView = "微信";
      } else {
        paramView = "QQ";
      }
      localTextView.setText(String.format("打开%s扫一扫完成支付", new Object[] { paramView }));
      APChannelQRCodeActivity.n(APChannelQRCodeActivity.this).setVisibility(8);
      if (APChannelQRCodeActivity.d(APChannelQRCodeActivity.this) == null) {
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this);
      }
    }
  }
  
  public class b
    implements h5
  {
    public b() {}
    
    public void a() {}
    
    public void a(int paramInt) {}
    
    public void a(int paramInt, String paramString1, String paramString2) {}
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      paramView = APDataReportManager.getInstance();
      int i = p4.p().g();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("payChannel=");
      localStringBuilder.append(APChannelQRCodeActivity.a(APChannelQRCodeActivity.this));
      paramView.insertData("sdk.qr.back", i, null, "", localStringBuilder.toString());
      APChannelQRCodeActivity.b(APChannelQRCodeActivity.this);
    }
  }
  
  public class d
    implements h5
  {
    public d() {}
    
    public void a()
    {
      APLog.d("APChannelQRCodeActivity", "doPay.onStop()");
      if (!APChannelQRCodeActivity.m(APChannelQRCodeActivity.this)) {
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this);
      }
    }
    
    public void a(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPay.onFinish() resultCode=");
      localStringBuilder.append(paramInt);
      APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
      if (!APChannelQRCodeActivity.m(APChannelQRCodeActivity.this)) {
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this);
      }
    }
    
    public void a(int paramInt, String paramString1, String paramString2)
    {
      paramString1 = new StringBuilder();
      paramString1.append("doPay.onError() resultCode=");
      paramString1.append(paramInt);
      APLog.d("APChannelQRCodeActivity", paramString1.toString());
      if (!APChannelQRCodeActivity.m(APChannelQRCodeActivity.this)) {
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this);
      }
    }
  }
  
  public class e
    implements g5
  {
    public e() {}
    
    public void a(int paramInt, Bundle paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IAPSaveCallBack.callBack() resultCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", bundle=");
      localStringBuilder.append(paramBundle.toString());
      APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
      APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, true);
      if (paramInt != 0)
      {
        paramBundle = paramBundle.getString("errMsg");
        APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramInt, paramBundle);
        return;
      }
      paramBundle = paramBundle.getString("payUrl");
      APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramBundle);
    }
  }
  
  public class f
    implements fc
  {
    public f() {}
    
    public void a(ob paramob)
    {
      paramob = (y3)paramob;
      int i = paramob.d();
      if (i == 0)
      {
        long l = paramob.h();
        Object localObject = paramob.g();
        paramob = new StringBuilder();
        paramob.append("shortenUrl resultUrl= ");
        paramob.append((String)localObject);
        APLog.d("APChannelQRCodeActivity", paramob.toString());
        paramob = (ob)localObject;
        if (!((String)localObject).startsWith("http://"))
        {
          paramob = new StringBuilder();
          paramob.append("http://");
          paramob.append((String)localObject);
          paramob = paramob.toString();
        }
        APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, l);
        localObject = APChannelQRCodeActivity.this;
        APChannelQRCodeActivity.a((APChannelQRCodeActivity)localObject, paramob, APChannelQRCodeActivity.q((APChannelQRCodeActivity)localObject));
        return;
      }
      APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, i, paramob.c());
    }
    
    public void b(ob paramob)
    {
      APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramob.d(), paramob.c());
    }
    
    public void c(ob paramob)
    {
      APChannelQRCodeActivity.r(APChannelQRCodeActivity.this);
    }
  }
  
  public class g
    implements View.OnClickListener
  {
    public g() {}
    
    public void onClick(View paramView)
    {
      APChannelQRCodeActivity.s(APChannelQRCodeActivity.this);
    }
  }
  
  public class h
    extends CountDownTimer
  {
    public h(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      if ((APChannelQRCodeActivity.c(APChannelQRCodeActivity.this).isShown()) && (APChannelQRCodeActivity.c(APChannelQRCodeActivity.this).getText().toString().trim().equals("返回二维码")))
      {
        APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, null);
        return;
      }
      APChannelQRCodeActivity.p(APChannelQRCodeActivity.this);
    }
    
    public void onTick(long paramLong) {}
  }
  
  public class i
    implements fc
  {
    public i() {}
    
    public void a(ob paramob)
    {
      int j = ((j4)paramob).g();
      paramob = new StringBuilder();
      paramob.append("mPayResult = ");
      paramob.append(j);
      APLog.d("APChannelQRCodeActivity", paramob.toString());
      int i = j;
      if (j >= 300)
      {
        i = j;
        if (j <= 400) {
          i = 300;
        }
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 300)
          {
            if (i != 1000)
            {
              paramob = new StringBuilder();
              paramob.append("onListenning() onSuccess() error code = ");
              paramob.append(i);
              APLog.e("APChannelQRCodeActivity", paramob.toString());
              APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, i, "");
              return;
            }
            APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, 0);
            APChannelQRCodeActivity.j(APChannelQRCodeActivity.this);
            return;
          }
          APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, 0);
          APChannelQRCodeActivity.i(APChannelQRCodeActivity.this);
          APChannelQRCodeActivity.g(APChannelQRCodeActivity.this);
          return;
        }
        APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, 0);
        APChannelQRCodeActivity.h(APChannelQRCodeActivity.this);
        APChannelQRCodeActivity.g(APChannelQRCodeActivity.this);
        return;
      }
      if (APChannelQRCodeActivity.e(APChannelQRCodeActivity.this) >= 3)
      {
        APChannelQRCodeActivity.f(APChannelQRCodeActivity.this);
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this);
        return;
      }
      APChannelQRCodeActivity.g(APChannelQRCodeActivity.this);
    }
    
    public void b(ob paramob)
    {
      APLog.d("APChannelQRCodeActivity", "onListenning() onFailure()");
      APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramob.d(), paramob.c());
    }
    
    public void c(ob paramob)
    {
      APLog.d("APChannelQRCodeActivity", "onListenning() onStop()");
    }
  }
  
  public class j
    implements View.OnClickListener
  {
    public j(boolean paramBoolean) {}
    
    public void onClick(View paramView)
    {
      if (bool)
      {
        APUICommonMethod.f();
        z5.a(2, "支付二维码过期，请重新拉起支付");
        return;
      }
      APChannelQRCodeActivity.s(APChannelQRCodeActivity.this);
    }
  }
  
  public class k
    implements View.OnClickListener
  {
    public k() {}
    
    public void onClick(View paramView)
    {
      APChannelQRCodeActivity.c(APChannelQRCodeActivity.this).setVisibility(4);
      APChannelQRCodeActivity.l(APChannelQRCodeActivity.this).setImageResource(APChannelQRCodeActivity.k(APChannelQRCodeActivity.this));
      APChannelQRCodeActivity.l(APChannelQRCodeActivity.this).setVisibility(0);
      APChannelQRCodeActivity.n(APChannelQRCodeActivity.this).setVisibility(8);
      if (APChannelQRCodeActivity.d(APChannelQRCodeActivity.this) == null) {
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APChannelQRCodeActivity
 * JD-Core Version:    0.7.0.1
 */