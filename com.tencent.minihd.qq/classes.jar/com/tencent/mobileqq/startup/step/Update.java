package com.tencent.mobileqq.startup.step;

import android.app.Activity;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.InstallActivity;
import com.tencent.mobileqq.startup.director.StartupDirector;
import mqq.app.AppActivity;

public class Update
  extends Step
  implements Handler.Callback
{
  private static final int E = 2;
  private static final int F = 3;
  private static final int G = 4;
  private static final int jdField_a_of_type_Int = 1;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 5, 23, 24, 26 };
  private int H;
  private int I = 6000;
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  private int a()
  {
    double d2 = (System.currentTimeMillis() - this.jdField_a_of_type_Long) * 1.0D / this.I * (this.H - 10);
    double d1;
    if (d2 < this.jdField_a_of_type_Double)
    {
      d1 = this.jdField_a_of_type_Double;
      this.jdField_a_of_type_Double = d1;
      if (this.jdField_a_of_type_Double >= 0.0D) {
        break label106;
      }
      this.jdField_a_of_type_Double = 0.0D;
    }
    for (;;)
    {
      return (int)this.jdField_a_of_type_Double;
      d1 = d2;
      if (d2 <= this.H - 10) {
        break;
      }
      d1 = this.jdField_a_of_type_Double + (this.H - this.jdField_a_of_type_Double) * 1.0D / 5.0D;
      break;
      label106:
      if (this.jdField_a_of_type_Double > 100.0D) {
        this.jdField_a_of_type_Double = 100.0D;
      }
    }
  }
  
  protected boolean a()
  {
    if (!BaseApplicationImpl.b) {
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    String str = System.getProperty("java.vm.version");
    if ((str != null) && (!str.startsWith("1"))) {
      this.I = 30000;
    }
    try
    {
      Thread.sleep(2000L);
      boolean bool = Step.AmStepFactory.b(0, this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector, jdField_a_of_type_ArrayOfInt).c();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      int i;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return true;
            localObject = this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a;
          } while (!(localObject instanceof InstallActivity));
          paramMessage = ((Activity)localObject).findViewById(2131297935);
          localObject = (ViewGroup)((Activity)localObject).findViewById(2131297934);
        } while ((paramMessage == null) || (localObject == null));
        paramMessage.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a.getApplicationContext(), 2130904438, null));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302180));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302182));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302183));
        this.jdField_a_of_type_AndroidWidgetTextView.setText("0%");
        ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Double = 0.0D;
        this.H = 90;
        return true;
        i = a();
        if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidWidgetProgressBar.getProgress() > i);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a.getString(2131368981), new Object[] { Integer.valueOf(i) }));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(this.jdField_a_of_type_AndroidWidgetProgressBar.getWidth() * i / 100.0F);
      }
      if (i < 99)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 100L);
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
      return true;
    case 3: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_Double = 90.0D;
      this.H = 100;
      this.I = 6000;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, this.I);
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Update
 * JD-Core Version:    0.7.0.1
 */