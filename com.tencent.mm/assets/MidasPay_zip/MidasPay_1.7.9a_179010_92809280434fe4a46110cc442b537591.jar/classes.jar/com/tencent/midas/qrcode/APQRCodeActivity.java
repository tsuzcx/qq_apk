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
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.fc;
import midas.x.g6;
import midas.x.j4;
import midas.x.k4;
import midas.x.o4;
import midas.x.ob;
import midas.x.p4;
import midas.x.w4;
import midas.x.x4;
import midas.x.y4;
import midas.x.z1;
import midas.x.z4;
import midas.x.z5;

@SuppressLint({"Registered"})
public class APQRCodeActivity
  extends APActivity
  implements fc, View.OnClickListener
{
  public static int o = 900;
  public TextView d;
  public TextView e;
  public ImageView f;
  public Bitmap g;
  public int h = 0;
  public final Handler i = new Handler(Looper.getMainLooper());
  public View j;
  public View k;
  public ResultReceiver l;
  public int m = 0;
  public final Runnable n = new a();
  
  public void a(ob paramob)
  {
    APLog.d("QRCodePay-Activity", "GetPayResult success!");
    int i1 = ((j4)paramob).g();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 1000)
        {
          paramob = new StringBuilder();
          paramob.append("getPayResult return error result code = ");
          paramob.append(i1);
          APLog.e("QRCodePay-Activity", paramob.toString());
          return;
        }
        this.i.removeCallbacks(this.n);
        f();
        finish();
        APUICommonMethod.f();
        i();
        z5.a(0, 0, 0);
        return;
      }
      this.k.setVisibility(8);
      this.j.setVisibility(0);
      z1.d().c(this);
      return;
    }
    z1.d().c(this);
  }
  
  public void b(ob paramob)
  {
    if (paramob == null)
    {
      APLog.e("QRCodePay-Activity", "GetPayResult fail");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetPayResult fail ");
      localStringBuilder.append(paramob.c());
      APLog.e("QRCodePay-Activity", localStringBuilder.toString());
    }
    if (this.m < 3)
    {
      z1.d().c(this);
      this.m += 1;
    }
  }
  
  public void c(ob paramob)
  {
    paramob = new StringBuilder();
    paramob.append("GetPayResult stop! ");
    paramob.append(this);
    APLog.e("QRCodePay-Activity", paramob.toString());
  }
  
  public final void f()
  {
    z1.d().a(k4.class.getSimpleName());
  }
  
  public final void g()
  {
    this.f = ((ImageView)findViewById(2131099959));
    this.d = ((TextView)findViewById(2131099957));
    this.e = ((TextView)findViewById(2131099958));
    this.j = findViewById(2131099929);
    this.k = findViewById(2131099955);
    ((Button)findViewById(2131099961)).setOnClickListener(this);
    Button localButton = (Button)findViewById(2131099960);
    localButton.setOnClickListener(this);
    localButton.requestFocus();
  }
  
  public final void h()
  {
    Object localObject2 = p4.p().e();
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
        this.g = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, null);
        if (this.g == null)
        {
          APLog.e("QRCodePay-Activity", "Cannot decode qrcode bitmap");
          APUICommonMethod.a(this, "系统繁忙，请稍后再试！");
          APUICommonMethod.f();
          z5.a(-1, "系统繁忙，请稍后再试！");
          this.i.removeCallbacks(this.n);
          f();
          finish();
          return;
        }
        this.f.setImageBitmap(this.g);
        int i1 = p4.p().g();
        if ((i1 == 5) && (g6.k().i())) {
          localObject1 = "1";
        } else {
          localObject1 = p4.p().h();
        }
        Object localObject3 = ((o4)localObject2).c;
        if (localObject3 == null)
        {
          APLog.e("QRCodePay-Activity", "Cannot finish initValue while buyInfo is null!");
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((w4)localObject3).b);
        localStringBuilder.append(" x ");
        localStringBuilder.append((String)localObject1);
        localObject1 = localStringBuilder.toString();
        this.d.setText((CharSequence)localObject1);
        localObject3 = p4.p().h();
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (i1 != 5)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Error save type = ");
              ((StringBuilder)localObject1).append(i1);
              APLog.e("QRCodePay-Activity", ((StringBuilder)localObject1).toString());
              localObject1 = "";
            }
            else
            {
              localObject1 = ((z4)((o4)localObject2).c).a((String)localObject3);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Buy month info get cost = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(" ,saveValue = ");
              ((StringBuilder)localObject2).append((String)localObject3);
              APLog.d("QRCodePay-Activity", ((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            localObject1 = ((y4)((o4)localObject2).c).a((String)localObject3);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Buy goods info get cost = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" ,saveValue = ");
            ((StringBuilder)localObject2).append((String)localObject3);
            APLog.d("QRCodePay-Activity", ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject1 = ((x4)((o4)localObject2).c).a((String)localObject3);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Buy game info get cost = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" ,saveValue = ");
          ((StringBuilder)localObject2).append((String)localObject3);
          APLog.d("QRCodePay-Activity", ((StringBuilder)localObject2).toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getString(2131230907));
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        this.e.setText((CharSequence)localObject1);
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
      APUICommonMethod.f();
      z5.a(-1, "系统繁忙，请稍后再试！");
      this.i.removeCallbacks(this.n);
      f();
      finish();
    }
  }
  
  public final void i()
  {
    View localView = LayoutInflater.from(this).inflate(2131165275, null);
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
  
  public final void j()
  {
    View localView = LayoutInflater.from(this).inflate(2131165275, null);
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
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131099961)
    {
      this.i.removeCallbacks(this.n);
      APUICommonMethod.f();
      if (p4.p().j())
      {
        z5.a(4, "道具（游戏侧下单）刷新二维码重新支付");
      }
      else
      {
        paramView = this.l;
        if (paramView != null) {
          paramView.send(1, new Bundle());
        }
      }
      f();
      finish();
      return;
    }
    if (paramView.getId() == 2131099960)
    {
      this.i.removeCallbacks(this.n);
      APUICommonMethod.f();
      z5.a(5, "");
      j();
      f();
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165273);
    g();
    h();
    int i1 = getIntent().getIntExtra("tokenValidTime", -1);
    paramBundle = new StringBuilder();
    paramBundle.append("tokenValidTime from intent = ");
    paramBundle.append(i1);
    paramBundle.append(" ");
    paramBundle.append(this);
    APLog.d("QRCodePay-Activity", paramBundle.toString());
    if (i1 != -1) {
      o = i1;
    }
    this.l = ((ResultReceiver)getIntent().getParcelableExtra("Receiver"));
    this.i.postDelayed(this.n, 1000L);
    z1.d().c(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Bitmap localBitmap = this.g;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.g = null;
    }
    this.i.removeCallbacks(this.n);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on key down! Code = ");
    localStringBuilder.append(paramInt);
    APLog.d("QRCodePay-Activity", localStringBuilder.toString());
    if (paramInt == 4)
    {
      this.i.removeCallbacks(this.n);
      f();
      finish();
      APUICommonMethod.f();
      j();
      z5.a(5, "");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      APQRCodeActivity.b(APQRCodeActivity.this).postDelayed(APQRCodeActivity.a(APQRCodeActivity.this), 1000L);
      APQRCodeActivity.d(APQRCodeActivity.this);
      if (APQRCodeActivity.c(APQRCodeActivity.this) % 600 == 0)
      {
        APLog.d("QRCodePay-Activity", "Timer catch long connect validity! Close connect and restart!");
        APQRCodeActivity.e(APQRCodeActivity.this);
        z1.d().c(APQRCodeActivity.this);
        return;
      }
      if (APQRCodeActivity.c(APQRCodeActivity.this) >= APQRCodeActivity.k())
      {
        APLog.d("QRCodePay-Activity", "Timer catch token validity! Close activity and connection! restart!");
        APQRCodeActivity.e(APQRCodeActivity.this);
        APQRCodeActivity.b(APQRCodeActivity.this).removeCallbacks(APQRCodeActivity.a(APQRCodeActivity.this));
        APQRCodeActivity.this.finish();
        APUICommonMethod.f();
        if (p4.p().j())
        {
          z5.a(4, "道具（游戏侧下单）刷新二维码重新支付");
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.tencent.midas.qrcode.APQRCodeActivity
 * JD-Core Version:    0.7.0.1
 */