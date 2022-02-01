package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.qphone.base.util.QLog;
import fsg;
import fsh;
import fsi;
import fsk;
import fsl;
import fsm;
import fsn;
import fso;
import fsp;
import fsq;
import fsr;
import fss;
import fst;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class PressToSpeakPanel
  extends RelativeLayout
  implements View.OnTouchListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener
{
  private static final int jdField_b_of_type_Int = 150;
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 0;
  private static final int jdField_e_of_type_Int = 1;
  private static final int jdField_f_of_type_Int = 2;
  private static final int g = 3;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private MoveDistIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private VolumeIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  private Rect jdField_b_of_type_AndroidGraphicsRect = null;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private MoveDistIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
  private VolumeIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private ViewGroup jdField_e_of_type_AndroidViewViewGroup;
  private ViewGroup jdField_f_of_type_AndroidViewViewGroup;
  private int h = 0;
  
  public PressToSpeakPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PressToSpeakPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private double a(int paramInt1, int paramInt2, View paramView)
  {
    double d1 = paramView.getWidth();
    double d3 = paramView.getHeight();
    if ((paramView == null) || (paramView.getVisibility() != 0)) {
      return -1.0D;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    d1 /= 2.0D;
    double d2 = arrayOfInt[0];
    d3 /= 2.0D;
    double d4 = arrayOfInt[1];
    return Math.sqrt(Math.pow(paramInt1 - (d1 + d2), 2.0D) + Math.pow(paramInt2 - (d3 + d4), 2.0D));
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() != 0) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_AndroidGraphicsRect.left == this.jdField_a_of_type_AndroidGraphicsRect.right))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen(arrayOfInt);
      this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
      this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      int i = localRect.right;
      localRect.right = (arrayOfInt[0] + i);
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      i = localRect.bottom;
      localRect.bottom = (arrayOfInt[1] + i);
    }
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() != 0) {
      return false;
    }
    if ((this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect.left == this.jdField_b_of_type_AndroidGraphicsRect.right))
    {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getDrawingRect(this.jdField_b_of_type_AndroidGraphicsRect);
      int[] arrayOfInt = new int[2];
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getLocationOnScreen(arrayOfInt);
      this.jdField_b_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
      this.jdField_b_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
      Rect localRect = this.jdField_b_of_type_AndroidGraphicsRect;
      int i = localRect.right;
      localRect.right = (arrayOfInt[0] + i);
      localRect = this.jdField_b_of_type_AndroidGraphicsRect;
      i = localRect.bottom;
      localRect.bottom = (arrayOfInt[1] + i);
    }
    return this.jdField_b_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new fsn(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new fsp(this, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.f = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup3;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299764));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299767));
    this.c = ((ViewGroup)findViewById(2131298548));
    this.d = ((ViewGroup)findViewById(2131298538));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131298539));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131298541));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298540));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299768));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131299765));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView = ((MoveDistIndicateView)findViewById(2131299766));
    this.e = ((ViewGroup)findViewById(2131299763));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    paramQQAppInterface = paramBaseChatPie.a().getResources();
    paramBaseChatPie = SkinUtils.a(paramQQAppInterface.getDrawable(2130841703));
    paramViewGroup1 = SkinUtils.a(paramQQAppInterface.getDrawable(2130841704));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramBaseChatPie, 3);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramViewGroup1, 4);
    paramAudioPanel = SkinUtils.a(paramQQAppInterface.getDrawable(2130841684));
    paramViewGroup2 = SkinUtils.a(paramQQAppInterface.getDrawable(2130841682));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setScaleBitmap(paramAudioPanel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setAfterBitmap(paramViewGroup2);
    paramViewGroup3 = SkinUtils.a(paramQQAppInterface.getDrawable(2130841684));
    Bitmap localBitmap = SkinUtils.a(paramQQAppInterface.getDrawable(2130841682));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setScaleBitmap(paramViewGroup3);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setAfterBitmap(localBitmap);
    if (QLog.isColorLevel())
    {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.init() is called");
      QLog.d("AIOAudioPanel", 2, "volumeFillLeftBmp is:" + paramBaseChatPie + ",volumeFillRightBmp is:" + paramViewGroup1 + ",listenIndicateMoveDist is:" + paramAudioPanel + ",listenIndicateEnter is:" + paramViewGroup2 + ",delIndicateMoveDist is:" + paramViewGroup3 + ",delIndicateEnter is:" + localBitmap);
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      paramBaseChatPie = new Rect();
      getWindowVisibleDisplayFrame(paramBaseChatPie);
      int i = paramBaseChatPie.right / 2;
      int j = AIOUtils.a(75.0F, paramQQAppInterface);
      this.jdField_a_of_type_Int = (i - j);
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "rect is:" + paramBaseChatPie + "entirePanelWidth is:" + i + ",listenRight is:" + j + ",mBasicDistance is:" + this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderPrepare() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new fsm(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderError() is called,path is:" + paramString1 + ",errorCode is:" + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString1);
    this.jdField_a_of_type_AndroidOsHandler.post(new fsq(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, double paramDouble)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new fso(this, paramInt, paramDouble));
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    int m = (int)paramMotionEvent.getRawY();
    int n = (int)paramMotionEvent.getRawX();
    if ((k == 0) || (k == 2))
    {
      this.h = 3;
      double d1;
      double d2;
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        d1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth() / 2.0D;
        d2 = a(n, m, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView);
        if ((d2 >= 0.0D) && (d2 <= this.jdField_a_of_type_Int + d1))
        {
          if (d2 <= d1) {
            this.h = 1;
          }
          i = (int)(100.0D - (d2 - d1) / this.jdField_a_of_type_Int * 100.0D);
          if (this.h != 1) {
            break label380;
          }
          i = 100;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
          j = i;
          if (i > 100) {
            j = 100;
          }
          paramMotionEvent.setLevel(j);
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getVisibility() == 0)
      {
        d1 = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.getWidth() / 2.0D;
        d2 = a(n, m, this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView);
        if ((d2 >= 0.0D) && (d2 <= this.jdField_a_of_type_Int + d1))
        {
          if (d2 <= d1) {
            this.h = 2;
          }
          i = (int)(100.0D - (d2 - d1) / this.jdField_a_of_type_Int * 100.0D);
          if (this.h != 2) {
            break label399;
          }
          i = 100;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
          label302:
          paramMotionEvent = this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView;
          j = i;
          if (i > 100) {
            j = 100;
          }
          paramMotionEvent.setLevel(j);
        }
      }
    }
    if (k == 0)
    {
      paramMotionEvent = (PowerManager)getContext().getSystemService("power");
      if (paramMotionEvent != null)
      {
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = paramMotionEvent.newWakeLock(26, "PressToSpeakPanel");
        if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) {
          this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
        }
      }
    }
    label380:
    while ((k == 2) || ((k != 1) && (k != 3)))
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
      break label302;
    }
    label399:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    int i = 0;
    if (this.h == 1) {
      i = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(i);
      if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
      break;
      if (this.h == 2) {
        i = 1;
      } else if (this.h == 3) {
        i = 0;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.N();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i(paramInt);
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484C", "0X800484C", 0, 0, "", "", "", "");
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    int i = StreamDataManager.a(paramString);
    if (i < 512)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(paramString);
      this.jdField_a_of_type_AndroidOsHandler.post(new fsr(this));
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "time is:" + i + ",fateOfRecorder is:" + j);
    }
    if (j == 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new fss(this, paramString));
      return;
    }
    if (j == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, 1, (int)(this.jdField_a_of_type_Double / 1000.0D));
      this.jdField_a_of_type_AndroidOsHandler.post(new fst(this, paramString));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramString, 1);
    this.jdField_a_of_type_AndroidOsHandler.post(new fsh(this, paramString));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitSuccess() is called");
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(paramInt);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onInitFailed() is called");
    }
  }
  
  public void e()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(2);
    }
  }
  
  public void f()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(1);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().isFinishing()) {}
    for (;;)
    {
      return;
      this.e.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130841696);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(1);
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {}
      try
      {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
        if (this.jdField_a_of_type_AndroidViewView == null) {
          continue;
        }
        if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView = null;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          }
        }
      }
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
    }
    AIOUtils.h = true;
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(0);
    this.d.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, " PressToSpeakPanel.startRecord() is called, time is " + System.currentTimeMillis());
    }
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelMoveDistIndicateView.setLevel(0);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setDuration(150L);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.86F, 1.0F, 0.86F, 1.0F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setAnimationListener(new fsg(this));
    this.e.startAnimation(localAnimationSet);
  }
  
  public void j()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(0L);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localScaleAnimation = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(200L);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new fsl(this));
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    SplashActivity localSplashActivity = (SplashActivity)SplashActivity.a();
    if ((!localSplashActivity.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!localSplashActivity.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
    {
      localSplashActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 400), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 100) }).requests(new fsi(this, localSplashActivity));
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onTouch() is called,action is:" + i);
    }
    if (paramView.getId() == 2131299768)
    {
      if (i == 0)
      {
        paramView = new fsk(this, paramMotionEvent);
        paramView = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramView);
        paramView.what = 1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 150L);
      }
      for (;;)
      {
        return true;
        if (i == 2)
        {
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h())) {
            a(paramMotionEvent);
          }
        }
        else if ((i == 3) || (i == 1)) {
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h()) {
              a(paramMotionEvent);
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel
 * JD-Core Version:    0.7.0.1
 */