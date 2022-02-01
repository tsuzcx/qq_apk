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
import java.util.Hashtable;
import midas.x.a;
import midas.x.bw;
import midas.x.by;
import midas.x.dv;
import midas.x.eg;
import midas.x.eh;
import midas.x.em;
import midas.x.fb;
import midas.x.fd;
import midas.x.fe;
import midas.x.ff;
import midas.x.fv;
import midas.x.fy;
import midas.x.lh;
import midas.x.lw;
import midas.x.ni;
import midas.x.nm;
import midas.x.nu;

public class APChannelQRCodeActivity
  extends APActivity
{
  private boolean A = false;
  private long a = 840L;
  private long b = this.a;
  private int c = 0;
  private String d = "";
  private int e = 256;
  private int q = 2131034157;
  private ImageView r;
  private TextView s;
  private ImageView t;
  private View u;
  private RelativeLayout v;
  private ImageButton w;
  private TextView x;
  private TextView y;
  private CountDownTimer z = null;
  
  private void a()
  {
    APLog.d("APChannelQRCodeActivity", "onNetworkStop()");
    d();
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNetworkError() ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelQRCodeActivity", ((StringBuilder)localObject).toString());
    if (this.z != null) {
      this.z.cancel();
    }
    localObject = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("网络错误，请稍后再试(");
      paramString.append(bw.a(paramInt));
      paramString.append(")");
      localObject = paramString.toString();
    }
    paramString = APDataReportManager.getInstance();
    int i = em.b().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("payChannel=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("&ret=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&msg=");
    localStringBuilder.append((String)localObject);
    paramString.insertData("sdk.qr.error", i, null, "", localStringBuilder.toString());
    this.r.setVisibility(8);
    this.s.setText((CharSequence)localObject);
    this.v.setVisibility(0);
    this.w.setBackgroundResource(2131034158);
    this.x.setText("请重试");
    this.y.setVisibility(4);
    k();
    this.v.setEnabled(true);
    this.v.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APChannelQRCodeActivity.g(APChannelQRCodeActivity.this);
      }
    });
  }
  
  private void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initUI() ");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelQRCodeActivity", ((StringBuilder)localObject).toString());
    this.r = ((ImageView)findViewById(2131099662));
    this.s = ((TextView)findViewById(2131099661));
    this.t = ((ImageView)findViewById(2131099659));
    this.u = findViewById(2131099660);
    this.v = ((RelativeLayout)findViewById(2131099656));
    this.w = ((ImageButton)findViewById(2131099657));
    this.x = ((TextView)findViewById(2131099658));
    this.y = ((TextView)findViewById(2131099663));
    localObject = (TextView)findViewById(2131099848);
    ((TextView)localObject).setText("扫码支付");
    ((TextView)localObject).setVisibility(0);
    ((ImageButton)findViewById(2131099832)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = APDataReportManager.getInstance();
        int i = em.b().g();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("payChannel=");
        localStringBuilder.append(APChannelQRCodeActivity.a(APChannelQRCodeActivity.this));
        paramAnonymousView.insertData("sdk.qr.back", i, null, "", localStringBuilder.toString());
        APChannelQRCodeActivity.b(APChannelQRCodeActivity.this);
      }
    });
    localObject = BitmapFactory.decodeResource(getResources(), 2131034155);
    this.t.setImageBitmap((Bitmap)localObject);
    int i;
    if ("wechat".equals(this.d)) {
      i = 2130903044;
    } else {
      i = 2130903043;
    }
    this.u.setBackgroundResource(i);
    d(paramString);
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQRCode() ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelQRCodeActivity", ((StringBuilder)localObject).toString());
    localObject = new Hashtable();
    ((Hashtable)localObject).put(ni.b, "UTF-8");
    ((Hashtable)localObject).put(ni.a, nu.a);
    ((Hashtable)localObject).put(ni.f, Integer.valueOf(1));
    localObject = nm.a(paramString, this.e, this.e, -16777216, -1, (Hashtable)localObject);
    this.r.setVisibility(0);
    this.r.setImageResource(this.q);
    TextView localTextView = this.s;
    if ("wechat".equals(this.d)) {
      paramString = "微信";
    } else {
      paramString = "QQ";
    }
    localTextView.setText(String.format("打开%s扫一扫完成支付", new Object[] { paramString }));
    this.t.setImageBitmap((Bitmap)localObject);
    this.v.setVisibility(8);
    k();
    this.y.setVisibility(4);
    paramString = APDataReportManager.getInstance();
    int i = em.b().g();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("payChannel=");
    ((StringBuilder)localObject).append(this.d);
    paramString.insertData("sdk.qr.display", i, null, "", ((StringBuilder)localObject).toString());
    if (this.z == null)
    {
      paramLong *= 1000L;
      this.z = new CountDownTimer(paramLong, paramLong)
      {
        public void onFinish()
        {
          if ((APChannelQRCodeActivity.h(APChannelQRCodeActivity.this).isShown()) && (APChannelQRCodeActivity.h(APChannelQRCodeActivity.this).getText().toString().trim().equals("返回二维码")))
          {
            APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, null);
            return;
          }
          APChannelQRCodeActivity.d(APChannelQRCodeActivity.this);
        }
        
        public void onTick(long paramAnonymousLong) {}
      };
    }
    else
    {
      this.z.cancel();
    }
    this.z.start();
    this.c = 0;
    b();
  }
  
  private void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onListenning(), retryCount = ");
    localStringBuilder.append(this.c);
    APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
    this.c += 1;
    by.a().m(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        int j = ((eg)paramAnonymouslh).a();
        paramAnonymouslh = new StringBuilder();
        paramAnonymouslh.append("mPayResult = ");
        paramAnonymouslh.append(j);
        APLog.d("APChannelQRCodeActivity", paramAnonymouslh.toString());
        int i = j;
        if (j >= 300)
        {
          i = j;
          if (j <= 400) {
            i = 300;
          }
        }
        if (i != 300)
        {
          if (i != 1000)
          {
            switch (i)
            {
            default: 
              paramAnonymouslh = new StringBuilder();
              paramAnonymouslh.append("onListenning() onSuccess() error code = ");
              paramAnonymouslh.append(i);
              APLog.e("APChannelQRCodeActivity", paramAnonymouslh.toString());
              APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, i, "");
              return;
            case 1: 
              APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, 0);
              APChannelQRCodeActivity.l(APChannelQRCodeActivity.this);
              APChannelQRCodeActivity.k(APChannelQRCodeActivity.this);
              return;
            }
            if (APChannelQRCodeActivity.i(APChannelQRCodeActivity.this) >= 3)
            {
              APChannelQRCodeActivity.j(APChannelQRCodeActivity.this);
              APChannelQRCodeActivity.d(APChannelQRCodeActivity.this);
              return;
            }
            APChannelQRCodeActivity.k(APChannelQRCodeActivity.this);
            return;
          }
          APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, 0);
          APChannelQRCodeActivity.n(APChannelQRCodeActivity.this);
          return;
        }
        APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, 0);
        APChannelQRCodeActivity.m(APChannelQRCodeActivity.this);
        APChannelQRCodeActivity.k(APChannelQRCodeActivity.this);
      }
      
      public void b(lh paramAnonymouslh)
      {
        APLog.d("APChannelQRCodeActivity", "onListenning() onFailure()");
        APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramAnonymouslh.T(), paramAnonymouslh.V());
      }
      
      public void c(lh paramAnonymouslh)
      {
        APLog.d("APChannelQRCodeActivity", "onListenning() onStop()");
      }
    });
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("obtainUrl() ");
    localStringBuilder.append(paramString);
    APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      this.A = false;
      fb.a();
      fb.a(this.d).a(this, new fe()new fd
      {
        public void a()
        {
          APLog.d("APChannelQRCodeActivity", "doPay.onStop()");
          if (!APChannelQRCodeActivity.c(APChannelQRCodeActivity.this)) {
            APChannelQRCodeActivity.d(APChannelQRCodeActivity.this);
          }
        }
        
        public void a(int paramAnonymousInt)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doPay.onFinish() resultCode=");
          localStringBuilder.append(paramAnonymousInt);
          APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
          if (!APChannelQRCodeActivity.c(APChannelQRCodeActivity.this)) {
            APChannelQRCodeActivity.d(APChannelQRCodeActivity.this);
          }
        }
        
        public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          paramAnonymousString1 = new StringBuilder();
          paramAnonymousString1.append("doPay.onError() resultCode=");
          paramAnonymousString1.append(paramAnonymousInt);
          APLog.d("APChannelQRCodeActivity", paramAnonymousString1.toString());
          if (!APChannelQRCodeActivity.c(APChannelQRCodeActivity.this)) {
            APChannelQRCodeActivity.d(APChannelQRCodeActivity.this);
          }
        }
      }, new fd()
      {
        public void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("IAPSaveCallBack.callBack() resultCode=");
          localStringBuilder.append(paramAnonymousInt);
          localStringBuilder.append(", bundle=");
          localStringBuilder.append(paramAnonymousBundle.toString());
          APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
          APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, true);
          if (paramAnonymousInt != 0)
          {
            paramAnonymousBundle = paramAnonymousBundle.getString("errMsg");
            APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramAnonymousInt, paramAnonymousBundle);
            return;
          }
          paramAnonymousBundle = paramAnonymousBundle.getString("payUrl");
          APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramAnonymousBundle);
        }
      });
      return;
    }
    c(paramString);
  }
  
  private void c()
  {
    APLog.d("APChannelQRCodeActivity", "disconnectListenning()");
    by.a().b(eh.class.getSimpleName());
  }
  
  private void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shortenUrl() ");
    localStringBuilder.append(paramString);
    APLog.d("APChannelQRCodeActivity", localStringBuilder.toString());
    if ("wechat".equals(this.d))
    {
      this.b = this.a;
      a(paramString, this.b);
      return;
    }
    if ("qqwallet".equals(this.d)) {
      by.a().c(paramString, "get_short_url", new lw()
      {
        public void a(lh paramAnonymouslh)
        {
          paramAnonymouslh = (dv)paramAnonymouslh;
          int i = paramAnonymouslh.T();
          if (i == 0)
          {
            long l = paramAnonymouslh.a();
            String str = paramAnonymouslh.b();
            paramAnonymouslh = new StringBuilder();
            paramAnonymouslh.append("shortenUrl resultUrl= ");
            paramAnonymouslh.append(str);
            APLog.d("APChannelQRCodeActivity", paramAnonymouslh.toString());
            paramAnonymouslh = str;
            if (!str.startsWith("http://"))
            {
              paramAnonymouslh = new StringBuilder();
              paramAnonymouslh.append("http://");
              paramAnonymouslh.append(str);
              paramAnonymouslh = paramAnonymouslh.toString();
            }
            APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, l);
            APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramAnonymouslh, APChannelQRCodeActivity.e(APChannelQRCodeActivity.this));
            return;
          }
          APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, i, paramAnonymouslh.V());
        }
        
        public void b(lh paramAnonymouslh)
        {
          APChannelQRCodeActivity.a(APChannelQRCodeActivity.this, paramAnonymouslh.T(), paramAnonymouslh.V());
        }
        
        public void c(lh paramAnonymouslh)
        {
          APChannelQRCodeActivity.f(APChannelQRCodeActivity.this);
        }
      });
    }
  }
  
  private void d()
  {
    APLog.d("APChannelQRCodeActivity", "onTimeout()");
    if (this.z != null) {
      this.z.cancel();
    }
    c();
    k();
    Object localObject1 = APDataReportManager.getInstance();
    int i = em.b().g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("payChannel=");
    ((StringBuilder)localObject2).append(this.d);
    ((APDataReportManager)localObject1).insertData("sdk.qr.timeout", i, null, "", ((StringBuilder)localObject2).toString());
    this.r.setVisibility(8);
    this.s.setText("二维码已失效");
    this.v.setVisibility(0);
    final boolean bool = em.b().k();
    this.w.setBackgroundResource(2131034158);
    localObject2 = this.x;
    if (bool) {
      localObject1 = "点击关闭，然后重新拉起支付";
    } else {
      localObject1 = "点击重新获取";
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    this.y.setVisibility(4);
    this.v.setEnabled(true);
    this.v.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (bool)
        {
          APUICommonMethod.b();
          fv.a(2, "支付二维码过期，请重新拉起支付");
          return;
        }
        APChannelQRCodeActivity.g(APChannelQRCodeActivity.this);
      }
    });
  }
  
  private void d(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoading() ");
    ((StringBuilder)localObject).append(paramString);
    APLog.d("APChannelQRCodeActivity", ((StringBuilder)localObject).toString());
    this.r.setVisibility(8);
    this.s.setText("正在获取二维码");
    this.v.setVisibility(0);
    this.v.setEnabled(false);
    this.w.setBackgroundResource(2131034158);
    this.x.setText("加载中...");
    this.y.setVisibility(4);
    localObject = AnimationUtils.loadAnimation(this, 2130771973);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    ((Animation)localObject).setRepeatMode(1);
    this.w.startAnimation((Animation)localObject);
    localObject = APDataReportManager.getInstance();
    int i = em.b().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("payChannel=");
    localStringBuilder.append(this.d);
    ((APDataReportManager)localObject).insertData("sdk.qr.refresh", i, null, "", localStringBuilder.toString());
    b(paramString);
  }
  
  private void h()
  {
    d(null);
  }
  
  private void i()
  {
    APLog.d("APChannelQRCodeActivity", "onScanning()");
    Object localObject1 = APDataReportManager.getInstance();
    int i = em.b().g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("payChannel=");
    ((StringBuilder)localObject2).append(this.d);
    ((APDataReportManager)localObject1).insertData("sdk.qr.scanning", i, null, "", ((StringBuilder)localObject2).toString());
    this.r.setVisibility(8);
    localObject2 = this.s;
    if ("wechat".equals(this.d)) {
      localObject1 = "微信";
    } else {
      localObject1 = "QQ";
    }
    ((TextView)localObject2).setText(String.format("打开%s扫一扫完成支付", new Object[] { localObject1 }));
    this.v.setVisibility(0);
    this.w.setBackgroundResource(2131034154);
    this.x.setText("扫描完成");
    this.y.setVisibility(0);
    this.y.setText("返回二维码");
    this.y.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APChannelQRCodeActivity.h(APChannelQRCodeActivity.this).setVisibility(4);
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this).setImageResource(APChannelQRCodeActivity.o(APChannelQRCodeActivity.this));
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this).setVisibility(0);
        APChannelQRCodeActivity.q(APChannelQRCodeActivity.this).setVisibility(8);
        if (APChannelQRCodeActivity.r(APChannelQRCodeActivity.this) == null) {
          APChannelQRCodeActivity.d(APChannelQRCodeActivity.this);
        }
      }
    });
  }
  
  private void j()
  {
    APLog.d("APChannelQRCodeActivity", "onPaying()");
    this.r.setVisibility(8);
    Object localObject2 = this.s;
    if ("wechat".equals(this.d)) {
      localObject1 = "微信";
    } else {
      localObject1 = "QQ";
    }
    ((TextView)localObject2).setText(String.format("请在%s上完成支付", new Object[] { localObject1 }));
    this.v.setVisibility(0);
    this.w.setBackgroundResource(2131034154);
    this.x.setText("正在支付");
    Object localObject1 = APDataReportManager.getInstance();
    int i = em.b().g();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("payChannel=");
    ((StringBuilder)localObject2).append(this.d);
    ((APDataReportManager)localObject1).insertData("sdk.qr.paying", i, null, "", ((StringBuilder)localObject2).toString());
    this.y.setVisibility(0);
    this.y.setText("返回二维码");
    this.y.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        APChannelQRCodeActivity.h(APChannelQRCodeActivity.this).setVisibility(4);
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this).setImageResource(APChannelQRCodeActivity.o(APChannelQRCodeActivity.this));
        APChannelQRCodeActivity.p(APChannelQRCodeActivity.this).setVisibility(0);
        TextView localTextView = APChannelQRCodeActivity.s(APChannelQRCodeActivity.this);
        if ("wechat".equals(APChannelQRCodeActivity.a(APChannelQRCodeActivity.this))) {
          paramAnonymousView = "微信";
        } else {
          paramAnonymousView = "QQ";
        }
        localTextView.setText(String.format("打开%s扫一扫完成支付", new Object[] { paramAnonymousView }));
        APChannelQRCodeActivity.q(APChannelQRCodeActivity.this).setVisibility(8);
        if (APChannelQRCodeActivity.r(APChannelQRCodeActivity.this) == null) {
          APChannelQRCodeActivity.d(APChannelQRCodeActivity.this);
        }
      }
    });
  }
  
  private void k()
  {
    APLog.d("APChannelQRCodeActivity", "closeLoading()");
    this.w.clearAnimation();
  }
  
  private void l()
  {
    finish();
    APUICommonMethod.b(this);
    fb.a(this.d).a(this, new fe()
    {
      public void a() {}
      
      public void a(int paramAnonymousInt) {}
      
      public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2) {}
    });
  }
  
  private void m()
  {
    APLog.d("APChannelQRCodeActivity", "toSuccessResult()");
    finish();
    APUICommonMethod.b(this);
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i = em.b().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("payChannel=");
    localStringBuilder.append(this.d);
    localAPDataReportManager.insertData("sdk.qr.success", i, null, "", localStringBuilder.toString());
    fb.a();
    fb.a(this.d).a(null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    APLog.d("APChannelQRCodeActivity", "onCreate()");
    if ((fy.a().f()) && (a.a().d != null))
    {
      setContentView(2131165187);
      this.e = APUICommonMethod.a(this, 180.0F);
      this.d = getIntent().getStringExtra("payChannel");
      paramBundle = getIntent().getStringExtra("payUrl");
      int i;
      if ("wechat".equals(this.d)) {
        i = 2131034157;
      } else {
        i = 2131034156;
      }
      this.q = i;
      a(paramBundle);
      return;
    }
    finish();
    APUICommonMethod.b(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.z != null) {
      this.z.cancel();
    }
    k();
    c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = APDataReportManager.getInstance();
      paramInt = em.b().g();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("payChannel=");
      localStringBuilder.append(this.d);
      paramKeyEvent.insertData("sdk.qr.keyback", paramInt, null, "", localStringBuilder.toString());
      l();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    int i = em.b().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("payChannel=");
    localStringBuilder.append(this.d);
    localAPDataReportManager.insertData("sdk.qr.show", i, null, "", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.channel.APChannelQRCodeActivity
 * JD-Core Version:    0.7.0.1
 */