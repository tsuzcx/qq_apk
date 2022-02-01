package com.tencent.midas.qrcode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import midas.x.bs;
import midas.x.dx;
import midas.x.dy;
import midas.x.ec;
import midas.x.ed;
import midas.x.ek;
import midas.x.el;
import midas.x.em;
import midas.x.en;
import midas.x.fm;
import midas.x.fs;
import midas.x.jw;
import midas.x.kl;

@SuppressLint({"Registered"})
public class APQRCodeActivity
  extends APActivity
  implements View.OnClickListener, kl
{
  private static int s = 900;
  private TextView a;
  private TextView b;
  private ImageView c;
  private Bitmap d;
  private final int e = 1000;
  private int q = 0;
  private final Handler r = new Handler(Looper.getMainLooper());
  private View t;
  private View u;
  private ResultReceiver v;
  private int w = 0;
  private final Runnable x = new Runnable()
  {
    public void run()
    {
      APQRCodeActivity.b(APQRCodeActivity.this).postDelayed(APQRCodeActivity.a(APQRCodeActivity.this), 1000L);
      APQRCodeActivity.c(APQRCodeActivity.this);
      if (APQRCodeActivity.d(APQRCodeActivity.this) % 600 == 0)
      {
        APLog.d("QRCodePay-Activity", "Timer catch long connect validity! Close connect and restart!");
        APQRCodeActivity.e(APQRCodeActivity.this);
        bs.a().m(APQRCodeActivity.this);
        return;
      }
      if (APQRCodeActivity.d(APQRCodeActivity.this) >= APQRCodeActivity.a())
      {
        APLog.d("QRCodePay-Activity", "Timer catch token validity! Close activity and connection! restart!");
        APQRCodeActivity.e(APQRCodeActivity.this);
        APQRCodeActivity.b(APQRCodeActivity.this).removeCallbacks(APQRCodeActivity.a(APQRCodeActivity.this));
        APQRCodeActivity.this.finish();
        APUICommonMethod.b();
        if (ed.b().k())
        {
          fm.a(4, "道具（游戏侧下单）刷新二维码重新支付");
          return;
        }
        if (APQRCodeActivity.f(APQRCodeActivity.this) != null) {
          APQRCodeActivity.f(APQRCodeActivity.this).send(1, new Bundle());
        }
        APQRCodeActivity.e(APQRCodeActivity.this);
        APQRCodeActivity.this.finish();
        Toast.makeText(APQRCodeActivity.this, "页面已过期，请重新扫码支付!", 1).show();
      }
    }
  };
  
  private void b()
  {
    View localView = LayoutInflater.from(this).inflate(2131165274, null);
    if (localView != null)
    {
      Object localObject = localView.findViewById(2131099927);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      } else {
        APLog.e("APQRCodeActvity", "success == null!");
      }
      localObject = localView.findViewById(2131099926);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      } else {
        APLog.e("APQRCodeActvity", "unknow == null!");
      }
      localObject = Toast.makeText(getApplicationContext(), "", 1);
      ((Toast)localObject).setGravity(23, 0, 0);
      ((Toast)localObject).setDuration(1);
      ((Toast)localObject).setView(localView);
      ((Toast)localObject).show();
      return;
    }
    APLog.e("APQRCodeActvity", "myToast == null!");
  }
  
  private void c()
  {
    View localView = LayoutInflater.from(this).inflate(2131165274, null);
    if (localView != null)
    {
      Object localObject = localView.findViewById(2131099927);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      } else {
        APLog.e("APQRCodeActvity", "success == null!");
      }
      localObject = localView.findViewById(2131099926);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      } else {
        APLog.e("APQRCodeActvity", "unknow == null!");
      }
      localObject = Toast.makeText(getApplicationContext(), "", 1);
      ((Toast)localObject).setGravity(23, 0, 0);
      ((Toast)localObject).setDuration(1);
      ((Toast)localObject).setView(localView);
      ((Toast)localObject).show();
      return;
    }
    APLog.e("APQRCodeActvity", "myToast == null!");
  }
  
  private void d()
  {
    this.c = ((ImageView)findViewById(2131099959));
    this.a = ((TextView)findViewById(2131099957));
    this.b = ((TextView)findViewById(2131099958));
    this.t = findViewById(2131099929);
    this.u = findViewById(2131099955);
    ((Button)findViewById(2131099961)).setOnClickListener(this);
    Button localButton = (Button)findViewById(2131099960);
    localButton.setOnClickListener(this);
    localButton.requestFocus();
  }
  
  private void h()
  {
    Object localObject2 = ed.b().n();
    if (localObject2 == null)
    {
      APLog.e("QRCodePay-Activity", "Cannot finish initValue while orderInfo is null!");
      return;
    }
    try
    {
      Object localObject1 = getIntent();
      if (localObject1 == null)
      {
        APLog.e("QRCodePay-Activity", "Cannot finish initValue while intent is null!");
        return;
      }
      localObject1 = ((Intent)localObject1).getByteArrayExtra("qrcode");
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.d = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, null);
        if (this.d == null)
        {
          APLog.e("QRCodePay-Activity", "Cannot decode qrcode bitmap");
          APUICommonMethod.a(this, "系统繁忙，请稍后再试！");
          APUICommonMethod.b();
          fm.a(-1, "系统繁忙，请稍后再试！");
          this.r.removeCallbacks(this.x);
          i();
          finish();
          return;
        }
        this.c.setImageBitmap(this.d);
        int i = ed.b().g();
        if ((i == 5) && (fs.a().g())) {
          localObject1 = "1";
        } else {
          localObject1 = ed.b().d();
        }
        Object localObject3 = ((ec)localObject2).b;
        if (localObject3 == null)
        {
          APLog.e("QRCodePay-Activity", "Cannot finish initValue while buyInfo is null!");
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ek)localObject3).b);
        localStringBuilder.append(" x ");
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        this.a.setText((CharSequence)localObject1);
        localObject1 = "";
        localObject3 = ed.b().d();
        if (i != 5)
        {
          switch (i)
          {
          default: 
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Error save type = ");
            ((StringBuilder)localObject2).append(i);
            APLog.e("QRCodePay-Activity", ((StringBuilder)localObject2).toString());
            break;
          case 1: 
            localObject1 = ((em)((ec)localObject2).b).a((String)localObject3);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Buy goods info get cost = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" ,saveValue = ");
            ((StringBuilder)localObject2).append((String)localObject3);
            APLog.d("QRCodePay-Activity", ((StringBuilder)localObject2).toString());
            break;
          case 0: 
            localObject1 = ((el)((ec)localObject2).b).a((String)localObject3);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Buy game info get cost = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" ,saveValue = ");
            ((StringBuilder)localObject2).append((String)localObject3);
            APLog.d("QRCodePay-Activity", ((StringBuilder)localObject2).toString());
            break;
          }
        }
        else
        {
          localObject1 = ((en)((ec)localObject2).b).a((String)localObject3);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Buy month info get cost = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" ,saveValue = ");
          ((StringBuilder)localObject2).append((String)localObject3);
          APLog.d("QRCodePay-Activity", ((StringBuilder)localObject2).toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getString(2131230906));
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        this.b.setText((CharSequence)localObject1);
        return;
      }
      APLog.e("QRCodePay-Activity", "Cannot finish initValue，intent has no qrcode!");
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Init value error exception = ");
      ((StringBuilder)localObject2).append(localException);
      APLog.e("QRCodePay-Activity", ((StringBuilder)localObject2).toString());
      APUICommonMethod.a(this, "系统繁忙，请稍后再试！");
      APUICommonMethod.b();
      fm.a(-1, "系统繁忙，请稍后再试！");
      this.r.removeCallbacks(this.x);
      i();
      finish();
    }
  }
  
  private void i()
  {
    bs.a().b(dy.class.getSimpleName());
  }
  
  public void a(jw paramjw)
  {
    APLog.d("QRCodePay-Activity", "GetPayResult success!");
    int i = ((dx)paramjw).a();
    if (i != 1000)
    {
      switch (i)
      {
      default: 
        paramjw = new StringBuilder();
        paramjw.append("getPayResult return error result code = ");
        paramjw.append(i);
        APLog.e("QRCodePay-Activity", paramjw.toString());
        return;
      case 1: 
        this.u.setVisibility(8);
        this.t.setVisibility(0);
        bs.a().m(this);
        return;
      }
      bs.a().m(this);
      return;
    }
    this.r.removeCallbacks(this.x);
    i();
    finish();
    APUICommonMethod.b();
    c();
    fm.a(0, 0, 0);
  }
  
  public void b(jw paramjw)
  {
    if (paramjw == null)
    {
      APLog.e("QRCodePay-Activity", "GetPayResult fail");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetPayResult fail ");
      localStringBuilder.append(paramjw.T());
      APLog.e("QRCodePay-Activity", localStringBuilder.toString());
    }
    if (this.w < 3)
    {
      bs.a().m(this);
      this.w += 1;
    }
  }
  
  public void c(jw paramjw)
  {
    paramjw = new StringBuilder();
    paramjw.append("GetPayResult stop! ");
    paramjw.append(this);
    APLog.e("QRCodePay-Activity", paramjw.toString());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131099961)
    {
      this.r.removeCallbacks(this.x);
      APUICommonMethod.b();
      if (ed.b().k()) {
        fm.a(4, "道具（游戏侧下单）刷新二维码重新支付");
      } else if (this.v != null) {
        this.v.send(1, new Bundle());
      }
      i();
      finish();
      return;
    }
    if (paramView.getId() == 2131099960)
    {
      this.r.removeCallbacks(this.x);
      APUICommonMethod.b();
      fm.a(5, "");
      b();
      i();
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165272);
    d();
    h();
    int i = getIntent().getIntExtra("tokenValidTime", -1);
    paramBundle = new StringBuilder();
    paramBundle.append("tokenValidTime from intent = ");
    paramBundle.append(i);
    paramBundle.append(" ");
    paramBundle.append(this);
    APLog.d("QRCodePay-Activity", paramBundle.toString());
    if (i != -1) {
      s = i;
    }
    this.v = ((ResultReceiver)getIntent().getParcelableExtra("Receiver"));
    this.r.postDelayed(this.x, 1000L);
    bs.a().m(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.d != null)
    {
      this.d.recycle();
      this.d = null;
    }
    this.r.removeCallbacks(this.x);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on key down! Code = ");
    localStringBuilder.append(paramInt);
    APLog.d("QRCodePay-Activity", localStringBuilder.toString());
    if (paramInt == 4)
    {
      this.r.removeCallbacks(this.x);
      i();
      finish();
      APUICommonMethod.b();
      b();
      fm.a(5, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.tencent.midas.qrcode.APQRCodeActivity
 * JD-Core Version:    0.7.0.1
 */