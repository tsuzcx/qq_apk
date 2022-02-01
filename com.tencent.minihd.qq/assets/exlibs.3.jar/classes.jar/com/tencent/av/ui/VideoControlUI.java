package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import bzs;
import bzt;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.utils.UITools1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class VideoControlUI
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 0;
  private static String jdField_a_of_type_JavaLangString = "VideoControlUI";
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 2;
  static final int d = 3;
  static final int e = 4;
  static final int f = 5;
  static final int g = 6;
  public long a;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  QavPanel jdField_a_of_type_ComTencentAvUiQavPanel = null;
  public VideoControlUI.ConnectInfo a;
  QavAppInterface jdField_a_of_type_ComTencentQavAppQavAppInterface;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  boolean jdField_b_of_type_Boolean = false;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  int h = 0;
  
  public VideoControlUI(QavAppInterface paramQavAppInterface, BaseActivity paramBaseActivity, ViewGroup paramViewGroup, VideoControlUI.ConnectInfo paramConnectInfo)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = paramQavAppInterface;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo = paramConnectInfo;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramQavAppInterface = a();
    if (paramQavAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "VideoControlUI-->can not get AVActivity");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidContentResResources = paramQavAppInterface.getResources();
    } while (this.jdField_a_of_type_AndroidContentResResources != null);
    AVLog.d(jdField_a_of_type_JavaLangString, "mRes is null. exit video progress");
    paramBaseActivity = paramQavAppInterface.getString(2131362814) + " 0x08";
    Toast.makeText(paramQavAppInterface.getApplicationContext(), paramBaseActivity, 0).show();
    paramQavAppInterface.finish();
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (!VideoController.a(paramContext)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c(int paramInt)
  {
    QavChatActivity localQavChatActivity = a();
    if (localQavChatActivity != null) {
      localQavChatActivity.getLayoutInflater().inflate(paramInt, this.jdField_a_of_type_AndroidViewViewGroup);
    }
  }
  
  protected abstract int a();
  
  public QavChatActivity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof QavChatActivity)) {
      return null;
    }
    return (QavChatActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  String a(String paramString)
  {
    return paramString;
  }
  
  public void a()
  {
    this.h = 1;
  }
  
  void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131298310, this.jdField_a_of_type_AndroidContentResResources.getString(2131362905));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131298310, true);
  }
  
  public void a(long paramLong)
  {
    this.h = 3;
    QavSession localQavSession = QavBussinessCtrl.a().a();
    if ((localQavSession != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (localQavSession.d())) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveEnable(false);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (paramInt > 0)
    {
      a(paramLong, this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
      return;
    }
    a(paramLong, null);
  }
  
  public abstract void a(long paramLong, View paramView);
  
  void a(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "setConnectInfo, str[" + paramString + "], seq[" + paramLong + "]");
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (b()) {
      return;
    }
    QavChatActivity localQavChatActivity = a();
    paramString1 = DialogUtil.a(localQavChatActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131365736, new bzt(this, paramLong));
    if (UITools1.a(localQavChatActivity)) {}
    for (int i = 2131363219;; i = 2131363220)
    {
      paramString1.setPositiveButton(i, new bzs(this, paramLong)).show();
      return;
    }
  }
  
  public void a(Intent paramIntent) {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    TextView localTextView;
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "setChatTime, time[" + paramString + "]");
        }
        localTextView = (TextView)this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131298437);
      } while (localTextView == null);
      localTextView.setText(paramString);
    } while (!UITools1.a);
    if (TextUtils.isEmpty(paramString))
    {
      UITools1.a(localTextView, "");
      return;
    }
    UITools1.a(localTextView, UITools1.a(paramString));
  }
  
  public boolean a()
  {
    return false;
  }
  
  boolean a(long paramLong, String paramString, View paramView)
  {
    paramView = a();
    if (paramView == null) {
      return false;
    }
    if (paramView.checkSelfPermission(paramString) == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label93;
      }
      if (a(paramView)) {
        break;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkSelfPermission, fail, permission[" + paramString + "], seq[" + paramLong + "]");
      b(paramLong, paramString);
      return false;
    }
    label93:
    return true;
  }
  
  public void b() {}
  
  void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131298310, this.jdField_a_of_type_AndroidContentResResources.getString(2131362904));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131298310, false);
  }
  
  public void b(long paramLong)
  {
    this.h = 5;
  }
  
  abstract void b(long paramLong, View paramView);
  
  void b(long paramLong, String paramString)
  {
    QavChatActivity localQavChatActivity = a();
    if (localQavChatActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString)) {
      str = localQavChatActivity.getString(2131363166);
    }
    for (paramString = localQavChatActivity.getString(2131363217);; paramString = localQavChatActivity.getString(2131363218))
    {
      a(paramLong, str, paramString);
      return;
      if (!"android.permission.RECORD_AUDIO".equals(paramString)) {
        break;
      }
      str = localQavChatActivity.getString(2131363167);
    }
  }
  
  public boolean b()
  {
    return this.h == 6;
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    c(a());
  }
  
  public void c(long paramLong)
  {
    this.h = 6;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo = null;
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
  }
  
  abstract void c(long paramLong, View paramView);
  
  public void d() {}
  
  public void d(long paramLong)
  {
    this.h = 2;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveEnable(false);
    }
  }
  
  public void e(long paramLong)
  {
    this.h = 4;
  }
  
  public void onClick(View paramView)
  {
    a(0L, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI
 * JD-Core Version:    0.7.0.1
 */