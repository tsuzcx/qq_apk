package com.tencent.mobileqq.activity.flaotaio;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import glw;
import glx;
import gly;
import gma;
import gmb;
import gmc;
import java.util.ArrayList;

public class FloatHbCircle
{
  public static final String a = "circle_hb_opend";
  float jdField_a_of_type_Float;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new glx(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FloatHbCircle.HbCircleCallBack jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle$HbCircleCallBack;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b;
  
  public FloatHbCircle(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    e();
  }
  
  private QQMessageFacade.Message a(String paramString)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localMessage.hbMsg.a != null) && (localMessage.hbMsg.a.mQQWalletRedPacketMsg != null) && (localMessage.hbMsg.a.mQQWalletRedPacketMsg.elem != null) && (paramString.equals(localMessage.hbMsg.a.mQQWalletRedPacketMsg.elem.nativeAndroid))) {
        return localMessage;
      }
      i += 1;
    }
    return null;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new glw(this);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter("circle_hb_opend");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903322, null);
    this.jdField_a_of_type_AndroidViewView = localView;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new gma(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131297710));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297711));
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      c();
    }
    QQMessageFacade.Message localMessage;
    do
    {
      return;
      localMessage = (QQMessageFacade.Message)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages((int)localMessage.uniseq);
      b(localMessage);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle$HbCircleCallBack == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle$HbCircleCallBack.a(localMessage);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      c();
      return;
    }
    b();
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 99) {}
    for (String str = "99";; str = this.jdField_a_of_type_JavaUtilArrayList.size() + "")
    {
      localTextView.setText(str);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new gly(this));
  }
  
  public void a(FloatHbCircle.HbCircleCallBack paramHbCircleCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbCircle$HbCircleCallBack = paramHbCircleCallBack;
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramMessage);
    this.jdField_a_of_type_AndroidOsHandler.post(new gmb(this));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed((int)paramMessage.uniseq, 60000L);
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      i = (int)(60.0F * this.jdField_a_of_type_Float + 0.5F);
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetFrameLayout, "translationX", new float[] { i, 0.0F });
        localObjectAnimator.setDuration(250L);
        localObjectAnimator.start();
      }
    }
    else
    {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetFrameLayout, "translationX", new float[] { 0.0F, i });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.start();
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (!this.b)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        h();
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationX(0.0F);
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null)
      {
        f();
        this.b = true;
        localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
        localLayoutParams = new WindowManager.LayoutParams();
        localLayoutParams.flags = 40;
        localLayoutParams.format = -3;
        localLayoutParams.gravity = 53;
        localLayoutParams.x = 0;
        localLayoutParams.y = ((int)(130.0F * this.jdField_a_of_type_Float));
        localLayoutParams.width = -2;
        localLayoutParams.height = -2;
        localLayoutParams.type = 2002;
        localLayoutParams.windowAnimations = 2131558950;
      }
    }
    try
    {
      localWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramMessage);
    this.jdField_a_of_type_AndroidOsHandler.post(new gmc(this));
  }
  
  public void c()
  {
    if ((this.b) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.b = false;
      g();
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
        ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatHbCircle
 * JD-Core Version:    0.7.0.1
 */