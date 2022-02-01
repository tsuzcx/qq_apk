package com.pay.ui.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;

public class AP3PointsLoading
  extends RelativeLayout
{
  Handler a;
  ImageView b;
  ImageView c;
  ImageView d;
  TextView e;
  Context f;
  long g = 500L;
  long h = 1500L;
  float i = 0.8F;
  float j = 0.1F;
  boolean k = false;
  
  public AP3PointsLoading(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AP3PointsLoading(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.f = paramContext;
    paramContext = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131165191, this);
    this.a = new a(Looper.getMainLooper(), this);
    this.b = ((ImageView)findViewById(2131099652));
    this.c = ((ImageView)findViewById(2131099653));
    this.d = ((ImageView)findViewById(2131099654));
    this.e = ((TextView)findViewById(2131100037));
  }
  
  private Animation getPointsAnimation()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(this.i, this.j);
    localAlphaAnimation.setDuration(this.h);
    localAlphaAnimation.setRepeatCount(0);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setFillBefore(false);
    return localAlphaAnimation;
  }
  
  public void a()
  {
    if ((this.b != null) && (this.c != null) && (this.d != null))
    {
      this.a.removeCallbacksAndMessages(null);
      this.a.sendEmptyMessage(-1);
    }
    this.k = false;
  }
  
  public boolean b()
  {
    this.k = true;
    this.a.sendEmptyMessage(0);
    return true;
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public boolean d()
  {
    if ((this.b != null) && (this.c != null) && (this.d != null))
    {
      this.a.removeCallbacksAndMessages(null);
      this.a.sendEmptyMessage(-1);
    }
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    APLog.e("AP3PointsLoading", "onKeyDown");
    if (this.k) {
      a();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setText(String paramString)
  {
    this.e.setText(paramString);
    this.e.setVisibility(0);
  }
  
  static class a
    extends Handler
  {
    private final WeakReference<AP3PointsLoading> a;
    
    public a(Looper paramLooper, AP3PointsLoading paramAP3PointsLoading)
    {
      super();
      this.a = new WeakReference(paramAP3PointsLoading);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AP3PointsLoading localAP3PointsLoading = (AP3PointsLoading)this.a.get();
      if (localAP3PointsLoading != null)
      {
        int i = paramMessage.what % 3;
        int j = i + 1;
        switch (i)
        {
        default: 
          break;
        case 2: 
          localAP3PointsLoading.d.startAnimation(AP3PointsLoading.a(localAP3PointsLoading));
          localAP3PointsLoading.d.setVisibility(0);
          localAP3PointsLoading.a.sendEmptyMessageDelayed(j, localAP3PointsLoading.g);
          break;
        case 1: 
          localAP3PointsLoading.c.startAnimation(AP3PointsLoading.a(localAP3PointsLoading));
          localAP3PointsLoading.c.setVisibility(0);
          localAP3PointsLoading.a.sendEmptyMessageDelayed(j, localAP3PointsLoading.g);
          break;
        case 0: 
          localAP3PointsLoading.b.startAnimation(AP3PointsLoading.a(localAP3PointsLoading));
          localAP3PointsLoading.b.setVisibility(0);
          localAP3PointsLoading.a.sendEmptyMessageDelayed(j, localAP3PointsLoading.g);
          break;
        case -1: 
          localAP3PointsLoading.b.setVisibility(8);
          localAP3PointsLoading.c.setVisibility(8);
          localAP3PointsLoading.d.setVisibility(8);
        }
      }
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.AP3PointsLoading
 * JD-Core Version:    0.7.0.1
 */