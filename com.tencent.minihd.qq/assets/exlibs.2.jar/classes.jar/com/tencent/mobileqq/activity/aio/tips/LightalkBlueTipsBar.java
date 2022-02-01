package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import gdm;
import gdn;
import gdo;
import java.io.File;

public class LightalkBlueTipsBar
  implements View.OnClickListener, TipsBarTask
{
  public static int a = 0;
  public static final String a = "LightalkBlueTipsBar";
  private long jdField_a_of_type_Long = 0L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
  private View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = true;
  public String b;
  public String c;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public LightalkBlueTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, SessionInfo paramSessionInfo, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ThreadManager.b(new gdm(this));
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (LightalkBlueTipsBarData.a() != null) {
      bool = true;
    }
    return bool;
  }
  
  public int a()
  {
    return 12;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903078, null);
      paramVarArgs = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296711);
      if (this.b != null)
      {
        paramVarArgs.setText(this.b);
        paramVarArgs.setContentDescription(this.b + "点击进入");
        paramVarArgs.setOnClickListener(this);
        paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296710);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          break label142;
        }
        paramVarArgs.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        paramVarArgs = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296712);
        paramVarArgs.setContentDescription("关闭");
        paramVarArgs.setOnClickListener(this);
      }
    }
    for (;;)
    {
      for (;;)
      {
        return this.jdField_a_of_type_AndroidViewView;
        return null;
        label142:
        File localFile = new File(LightalkBlueTipsBarData.d);
        if ((localFile != null) && (localFile.exists())) {}
        try
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources(), BitmapManager.a(LightalkBlueTipsBarData.d));
          if (QLog.isDevelopLevel()) {
            QLog.i("LightalkBlueTipsBar", 4, "load icon to bitmap ");
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            break;
          }
          paramVarArgs.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("LightalkBlueTipsBar", 2, "decodeFile Failed!", localThrowable);
            }
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840075));
            localThrowable.printStackTrace();
          }
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    label7:
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            do
            {
              break label7;
              break label7;
              break label7;
              do
              {
                return;
              } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) || (this.b == null) || (this.c == null));
              if (jdField_a_of_type_Int < 3) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====> showTime = " + jdField_a_of_type_Int);
            return;
            paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          } while (!paramVarArgs.getBoolean("lightalk_tip_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false));
          str = paramVarArgs.getString("Lightalk_tips_frdUin", null);
        } while ((str == null) || (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
        paramInt = paramVarArgs.getInt("LT_tip_show_times" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====> tipsum = " + paramInt);
        }
        if (paramInt >= 3)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() instanceof LightalkBlueTipsBar)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
          }
          jdField_a_of_type_Int = paramInt;
          return;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "" + (paramInt + 1), "", "", "");
    } while (!this.jdField_a_of_type_Boolean);
    ThreadManager.b().post(new gdn(this));
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 45;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      ThreadManager.b().post(new gdo(this));
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long < 200L);
      this.jdField_a_of_type_Long = l;
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("url", this.c);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005111", "0X8005111", 0, 0, "", "", "", "");
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005110", "0X8005110", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar
 * JD-Core Version:    0.7.0.1
 */