package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bza;
import bzb;
import bzc;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.session.QavSession;
import com.tencent.qav.session.QavSession.SessionStatus;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenService
  extends BaseSmallScreenService
  implements SmallScreenRelativeLayout.FloatListener
{
  static final String b = "SmallScreenService";
  public static boolean g;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bza(this);
  WindowManager jdField_a_of_type_AndroidViewWindowManager = null;
  public bzc a;
  SmallScreenVideoController jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = null;
  QavAppInterface jdField_a_of_type_ComTencentQavAppQavAppInterface;
  QavBussinessCtrl jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
  Runnable c;
  boolean h;
  
  static
  {
    jdField_g_of_type_Boolean = false;
  }
  
  public SmallScreenService()
  {
    this.jdField_h_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Bzc = null;
  }
  
  int a()
  {
    int j = 1000;
    int i = j;
    if (this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a() != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a().jdField_a_of_type_Int == 1) {
        i = 0;
      }
    }
    return i;
  }
  
  void a(int paramInt)
  {
    this.m = paramInt;
    a(0L);
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "doPhoneStateChange, state[" + paramInt + "], incomingNumber[" + paramString + "], mIsInCall[" + this.jdField_h_of_type_Boolean + "], seq[" + 0L + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(0L);
      return;
      this.jdField_h_of_type_Boolean = false;
      continue;
      this.jdField_h_of_type_Boolean = true;
      continue;
      this.jdField_h_of_type_Boolean = true;
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject1;
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
      if (localObject1 != null) {}
    }
    else
    {
      return;
    }
    boolean bool1;
    label45:
    boolean bool2;
    label68:
    boolean bool4;
    label131:
    boolean bool5;
    label146:
    int i;
    label167:
    boolean bool6;
    label184:
    Object localObject2;
    int j;
    boolean bool7;
    label226:
    Object localObject3;
    if ((this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() == 0) && (this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a()))
    {
      bool1 = true;
      if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 0) || (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a())) {
        break label1076;
      }
      bool2 = true;
      boolean bool3 = false;
      if (this.jdField_a_of_type_ComTencentQavAppQavAppInterface != null) {
        bool3 = SmallScreenUtils.a(this.jdField_a_of_type_ComTencentQavAppQavAppInterface.a());
      }
      this.jdField_f_of_type_Boolean = SmallScreenUtils.d(this.jdField_a_of_type_ComTencentQavAppQavAppInterface.a());
      if ((((QavSession)localObject1).jdField_c_of_type_Boolean) || ((!((QavSession)localObject1).jdField_h_of_type_Boolean) && (!((QavSession)localObject1).jdField_f_of_type_Boolean))) {
        break label1082;
      }
      bool4 = true;
      if ((bool4) || (!this.jdField_f_of_type_Boolean)) {
        break label1088;
      }
      bool5 = true;
      if ((this.jdField_h_of_type_Boolean) || (!bool3) || (this.jdField_c_of_type_Boolean)) {
        break label1094;
      }
      i = 1;
      if ((i == 0) || ((!bool4) && (!bool5))) {
        break label1099;
      }
      bool6 = true;
      localObject2 = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
      i = ((QavSession)localObject2).jdField_a_of_type_Int;
      j = ((QavSession)localObject2).jdField_c_of_type_Int;
      localObject2 = ((QavSession)localObject2).jdField_a_of_type_JavaLangString;
      if ((i != 1) && (i != 2)) {
        break label1105;
      }
      bool7 = true;
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenService", 1, "showHideToast, mIsInCall[" + this.jdField_h_of_type_Boolean + "], isOpEnable[" + bool3 + "], isVideoVisible[" + bool1 + "], isAudioVisible[" + bool2 + "], isVideoToastCanShow[" + bool4 + "], isAudioToastCanShow[" + bool5 + "], isToastShow[" + bool6 + "], mIsLock[" + this.jdField_c_of_type_Boolean + "], mIsInit[" + this.jdField_a_of_type_Boolean + "], mIsAppOnForeground[" + this.jdField_f_of_type_Boolean + "], SessionType[" + i + "], relationType[" + j + "], isC2c[" + bool7 + "], mSmallScreenStateBroadcast[" + this.o + "], seq[" + paramLong + "]");
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (!this.jdField_f_of_type_Boolean) {
        break label1111;
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130838949);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.jdField_g_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject2).topMargin = this.jdField_h_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.k;
      if (QLog.isDevelopLevel()) {
        QLog.w("SmallScreenService", 1, "showHideToast, show mTitleView, seq[" + paramLong + "]");
      }
      label549:
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
      if (((!bool4) || (!bool6)) && (bool1)) {
        this.n = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
      }
      if (((!bool5) || (!bool6) || (this.jdField_a_of_type_Boolean)) && (bool2)) {
        this.n = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
      }
      if ((!bool4) || (!bool6)) {
        break label1271;
      }
      if (!this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b())
      {
        localObject2 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
        if (this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getRotation() % 2 != 0) {
          break label1212;
        }
        ((WindowManager.LayoutParams)localObject2).width = this.jdField_a_of_type_Int;
        ((WindowManager.LayoutParams)localObject2).height = this.jdField_b_of_type_Int;
        label719:
        localObject3 = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(this.n);
        ((WindowManager.LayoutParams)localObject2).x = ((Point)localObject3).x;
        ((WindowManager.LayoutParams)localObject2).y = ((Point)localObject3).y;
        a();
      }
      if (bool1) {
        break label1519;
      }
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
      if ((!((QavSession)localObject1).d()) || (((QavSession)localObject1).d())) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a.b(((QavSession)localObject1).jdField_h_of_type_Boolean, ((QavSession)localObject1).jdField_f_of_type_Boolean);
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("SmallScreenService", 1, "showHideToast, show mVideoToastView, seq[" + paramLong + "]");
      }
      if (!bool2) {
        break label1528;
      }
      if (!bool7) {
        break label1233;
      }
      localObject1 = "0X8005A4A";
      localObject2 = "0X80057E6";
    }
    for (;;)
    {
      label872:
      if ((bool5) && (bool6) && (!this.jdField_a_of_type_Boolean))
      {
        if (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) {
          b();
        }
        if (bool2) {
          break label1408;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        if (QLog.isDevelopLevel()) {
          QLog.w("SmallScreenService", 1, "showHideToast, show mAudioToastView, seq[" + paramLong + "]");
        }
        if (!bool1) {
          break label1408;
        }
        if (bool7)
        {
          localObject1 = "0X8005A4D";
          if (!bool6) {
            break label1411;
          }
          if (this.o != 3) {
            a(paramLong, 3);
          }
        }
      }
      for (;;)
      {
        label978:
        if (localObject2 != null) {
          ReportController.b(null, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
        }
        if (localObject1 == null) {
          break;
        }
        ReportController.b(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        return;
        bool1 = false;
        break label45;
        label1076:
        bool2 = false;
        break label68;
        label1082:
        bool4 = false;
        break label131;
        label1088:
        bool5 = false;
        break label146;
        label1094:
        i = 0;
        break label167;
        label1099:
        bool6 = false;
        break label184;
        label1105:
        bool7 = false;
        break label226;
        label1111:
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130838950);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.i;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = this.j;
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = this.l;
        if (!QLog.isDevelopLevel()) {
          break label549;
        }
        QLog.w("SmallScreenService", 1, "showHideToast, hide mTitleView, seq[" + paramLong + "]");
        break label549;
        label1212:
        ((WindowManager.LayoutParams)localObject2).width = this.jdField_b_of_type_Int;
        ((WindowManager.LayoutParams)localObject2).height = this.jdField_a_of_type_Int;
        break label719;
        label1233:
        if (j == 1)
        {
          localObject1 = "0X8005A4C";
          localObject2 = "0X80057E6";
          break label872;
        }
        if (j != 2) {
          break label1528;
        }
        localObject1 = "0X8005A4B";
        localObject2 = "0X80057E6";
        break label872;
        label1271:
        if (!bool1) {
          break label1519;
        }
        this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
        if (QLog.isDevelopLevel()) {
          QLog.w("SmallScreenService", 1, "showHideToast, hide mVideoToastView, seq[" + paramLong + "]");
        }
        localObject2 = "0X80057E5";
        localObject1 = null;
        break label872;
        if (j == 1)
        {
          localObject1 = "0X8005A4F";
          break label978;
        }
        if (j == 2)
        {
          localObject1 = "0X8005A4E";
          break label978;
          if (bool2)
          {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
            if (QLog.isDevelopLevel()) {
              QLog.w("SmallScreenService", 1, "showHideToast, hide mAudioToastView, seq[" + paramLong + "]");
            }
          }
        }
        label1408:
        break label978;
        label1411:
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && (this.o != 2)) {
          if (this.o == 1)
          {
            if ((this.jdField_a_of_type_ComTencentQavAppQavAppInterface != null) && (a() != null))
            {
              if (this.jdField_c_of_type_JavaLangRunnable == null) {
                this.jdField_c_of_type_JavaLangRunnable = new bzb(this, paramLong);
              }
              a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
              jdField_g_of_type_Boolean = true;
              a().postDelayed(this.jdField_c_of_type_JavaLangRunnable, a());
            }
          }
          else {
            a(paramLong, 2);
          }
        }
      }
      label1519:
      localObject1 = null;
      localObject2 = null;
      continue;
      label1528:
      localObject1 = null;
      localObject2 = "0X80057E6";
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    jdField_g_of_type_Boolean = false;
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (SmallScreenUtils.a(paramLong, this.jdField_a_of_type_ComTencentQavAppQavAppInterface, paramInt)) {
      this.o = paramInt;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.h();
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.g();
    return true;
  }
  
  void e()
  {
    a(0L);
    if (this.jdField_e_of_type_Boolean)
    {
      str = "0X80057D9";
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.m > 0) {
        if (!this.jdField_e_of_type_Boolean) {
          break label100;
        }
      }
    }
    label100:
    for (String str = "0X80057DA";; str = "0X80057DC")
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      return;
      str = "0X80057DB";
      break;
    }
  }
  
  void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "doInitRunnable, start, seq[" + 0L + "]");
    }
    QavSession localQavSession;
    if (this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl != null)
    {
      localQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
      if (localQavSession != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 1, "InitRunnable, SessionType[" + localQavSession.jdField_a_of_type_Int + "]");
        }
        if (localQavSession.jdField_a_of_type_Int != 1) {
          break label156;
        }
        this.jdField_a_of_type_Boolean = false;
        a(0L);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenService", 1, "doInitRunnable, end, seq[" + 0L + "]");
      }
      return;
      label156:
      if ((localQavSession.jdField_a_of_type_Int == 0) && (localQavSession.jdField_b_of_type_Boolean) && ((localQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.INVITING) || (localQavSession.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.BE_INVITING)))
      {
        int i = localQavSession.jdField_a_of_type_Int;
        if ((i == 1) || (i == 2))
        {
          QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo.BeginSessionType,[" + i + "]");
          this.jdField_a_of_type_Boolean = false;
          a(0L);
          continue;
          if (QLog.isColorLevel()) {
            QLog.w("SmallScreenService", 1, "doInitRunnable, VideoController为空, seq[" + 0L + "]");
          }
        }
      }
    }
  }
  
  public void onCreate()
  {
    long l = AudioHelper.a();
    QLog.w("SmallScreenService", 1, "avideo onCreate start, seq[" + l + "]");
    super.onCreate();
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = ((QavAppInterface)this.app);
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = QavBussinessCtrl.a();
    Object localObject = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
    a(0L, 1);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentQavAppQavAppInterface.a());
    if (localObject != null)
    {
      this.n = ((QavSession)localObject).jdField_b_of_type_Int;
      ((QavSession)localObject).jdField_b_of_type_Int = this.n;
      this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(this.n);
      if (this.jdField_a_of_type_Bzc == null)
      {
        this.jdField_a_of_type_Bzc = new bzc(this);
        this.jdField_a_of_type_Bzc.a = l;
      }
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.NEW_OUTGOING_CALL");
      ((IntentFilter)localObject).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = new SmallScreenVideoController(this);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a(this.app);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.b();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.c();
      a(l);
      QLog.d("SmallScreenService", 1, "onCreate end");
      return;
    }
    stopSelf();
  }
  
  public void onDestroy()
  {
    QavSession localQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
    if (localQavSession != null)
    {
      if (this.m <= 0) {
        break label181;
      }
      localQavSession.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    }
    for (;;)
    {
      super.onDestroy();
      a(0L, 0);
      this.jdField_c_of_type_JavaLangRunnable = null;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.d();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.e();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a(0L);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = null;
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
      try
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        if (this.jdField_a_of_type_Bzc != null)
        {
          a().removeCallbacks(this.jdField_a_of_type_Bzc);
          this.jdField_a_of_type_Bzc = null;
        }
        if (this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast != null)
        {
          this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b();
          this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
        }
        if (this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null)
        {
          this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
          this.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
        }
        this.jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenService", 2, "onDestroy end");
        }
        return;
        label181:
        localQavSession.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AVLog.e("SmallScreenService", "onDestroy unregister receiver fail.", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */