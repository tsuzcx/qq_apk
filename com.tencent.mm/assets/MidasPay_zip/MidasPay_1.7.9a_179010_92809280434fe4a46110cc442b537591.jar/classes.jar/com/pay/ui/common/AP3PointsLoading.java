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
  public Handler a;
  public ImageView b;
  public ImageView c;
  public ImageView d;
  public TextView e;
  public long f = 500L;
  public long g = 1500L;
  public float h = 0.8F;
  public float i = 0.1F;
  public boolean j = false;
  
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
  
  private Animation getPointsAnimation()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(this.h, this.i);
    localAlphaAnimation.setDuration(this.g);
    localAlphaAnimation.setRepeatCount(0);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setFillBefore(false);
    return localAlphaAnimation;
  }
  
  public final void a(Context paramContext)
  {
    paramContext = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131165192, this);
    this.a = new a(Looper.getMainLooper(), this);
    this.b = ((ImageView)findViewById(2131099652));
    this.c = ((ImageView)findViewById(2131099653));
    this.d = ((ImageView)findViewById(2131099654));
    this.e = ((TextView)findViewById(2131100037));
  }
  
  public boolean a()
  {
    if ((this.b != null) && (this.c != null) && (this.d != null))
    {
      this.a.removeCallbacksAndMessages(null);
      this.a.sendEmptyMessage(-1);
    }
    return true;
  }
  
  public boolean b()
  {
    return this.j;
  }
  
  public boolean c()
  {
    this.j = true;
    this.a.sendEmptyMessage(0);
    return true;
  }
  
  public void d()
  {
    if ((this.b != null) && (this.c != null) && (this.d != null))
    {
      this.a.removeCallbacksAndMessages(null);
      this.a.sendEmptyMessage(-1);
    }
    this.j = false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    APLog.e("AP3PointsLoading", "onKeyDown");
    if (this.j) {
      d();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setText(String paramString)
  {
    this.e.setText(paramString);
    this.e.setVisibility(0);
  }
  
  public static class a
    extends Handler
  {
    public final WeakReference<AP3PointsLoading> a;
    
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
        if (i != -1)
        {
          if (i != 0)
          {
            if (i != 1)
            {
              if (i == 2)
              {
                localAP3PointsLoading.d.startAnimation(AP3PointsLoading.a(localAP3PointsLoading));
                localAP3PointsLoading.d.setVisibility(0);
                localAP3PointsLoading.a.sendEmptyMessageDelayed(j, localAP3PointsLoading.f);
              }
            }
            else
            {
              localAP3PointsLoading.c.startAnimation(AP3PointsLoading.a(localAP3PointsLoading));
              localAP3PointsLoading.c.setVisibility(0);
              localAP3PointsLoading.a.sendEmptyMessageDelayed(j, localAP3PointsLoading.f);
            }
          }
          else
          {
            localAP3PointsLoading.b.startAnimation(AP3PointsLoading.a(localAP3PointsLoading));
            localAP3PointsLoading.b.setVisibility(0);
            localAP3PointsLoading.a.sendEmptyMessageDelayed(j, localAP3PointsLoading.f);
          }
        }
        else
        {
          localAP3PointsLoading.b.setVisibility(8);
          localAP3PointsLoading.c.setVisibility(8);
          localAP3PointsLoading.d.setVisibility(8);
        }
      }
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.common.AP3PointsLoading
 * JD-Core Version:    0.7.0.1
 */