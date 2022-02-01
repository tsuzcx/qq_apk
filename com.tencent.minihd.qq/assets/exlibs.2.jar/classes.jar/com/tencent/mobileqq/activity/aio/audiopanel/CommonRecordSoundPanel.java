package com.tencent.mobileqq.activity.aio.audiopanel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import frv;
import frw;
import fry;
import frz;
import fsa;
import fsb;
import fsc;
import fsd;
import fse;
import fsf;
import java.io.File;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class CommonRecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener
{
  public static final int a = 200;
  static final int jdField_b_of_type_Int = 16711686;
  static final int c = 16711687;
  static final int d = 16711688;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  private static final int m = 1;
  private static final int n = 2000;
  public double a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private VolumeIndicateView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private String jdField_a_of_type_JavaLangString = "common record panel";
  private boolean jdField_a_of_type_Boolean = true;
  private Handler jdField_b_of_type_AndroidOsHandler = new frv(this, Looper.getMainLooper());
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView;
  int e = 0;
  private int o;
  private int p = 180000;
  
  public CommonRecordSoundPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonRecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (paramBoolean3) {
      i1 = 2131366525;
    }
    for (;;)
    {
      QQToast.a(paramContext, i1, 0).b(paramContext.getResources().getDimensionPixelSize(2131492923));
      return;
      if (paramBoolean2) {
        i1 = 2131366526;
      } else if (paramBoolean1) {
        i1 = 2131366524;
      } else {
        i1 = 2131366523;
      }
    }
  }
  
  private void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    paramInt1 = StreamDataManager.a(paramString);
    StreamDataManager.a(paramString);
    StreamDataManager.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
    if (paramInt1 >= 512) {}
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    this.jdField_b_of_type_AndroidOsHandler.post(new fsc(this));
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt) {}
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(paramQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298547));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131298548));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131298538));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131298539));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView = ((VolumeIndicateView)findViewById(2131298541));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298551));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298552));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramBaseActivity = paramBaseActivity.getResources();
    paramQQAppInterface = SkinUtils.a(paramBaseActivity.getDrawable(2130841703));
    paramBaseActivity = SkinUtils.a(paramBaseActivity.getDrawable(2130841704));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramQQAppInterface, 3);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setIndicateVolumeBitmap(paramBaseActivity, 4);
    if (QLog.isColorLevel())
    {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.init() is called,time is:" + System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, "volumeFillLeftBmp is:" + paramQQAppInterface + ",volumeFillRightBmp is:" + paramBaseActivity);
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(16711688)) {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711688);
      }
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711687);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
    setRequestedOrientation4Recording(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startRecord() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    String str = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, 2, null);
    if (QLog.isColorLevel()) {
      QLog.i("QQRecorder", 2, "path: " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramOnQQRecorderListener);
    AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(str);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new frz(this));
    a(paramString, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    AudioUtil.b(2131165188, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    AudioUtil.b(2131165188, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + paramString1);
    }
    d(paramString1);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.post(new fse(this));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    StreamDataManager.a(paramString, 0, (int)(System.currentTimeMillis() / 1000L));
    StreamDataManager.a(paramString, "#!AMR\n".getBytes(), "#!AMR\n".getBytes().length, (short)0);
    AudioUtil.b(2131165197, false);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    StreamDataManager.a(paramString, paramArrayOfByte, paramArrayOfByte.length, (short)0);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt, double paramDouble)
  {
    a(paramString, paramArrayOfByte);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new fry(this, paramInt, paramDouble));
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      c(2);
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    j();
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    int i1 = a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i1);
    }
    if (i1 == 2)
    {
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      localMessage.obj = paramString;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    while (i1 != 1)
    {
      Message localMessage;
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new fsf(this, paramString));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.e = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
      {
        Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(16711686);
        this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
      }
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new fsd(this));
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateView.setLevel(paramInt);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new fsa(this));
  }
  
  public void e()
  {
    boolean bool = b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      c(2);
    }
  }
  
  public void e(String paramString)
  {
    setRequestedOrientation4Recording(true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
  }
  
  public void f()
  {
    boolean bool = b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool) {
      c(1);
    }
  }
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new fsb(this));
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840058);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("开始录音");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
        }
      }
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void j()
  {
    this.p -= 200;
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, this.p);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    if (i1 == 2131298552)
    {
      boolean bool = b();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
      }
      if (bool) {
        c(2);
      }
    }
    else
    {
      return;
    }
    paramView = (SplashActivity)SplashActivity.a();
    if (paramView.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new frw(this, paramView));
      return;
    }
    paramView = Environment.getExternalStorageDirectory();
    label167:
    int i2;
    if ((paramView.exists()) && (paramView.canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label265;
      }
      i1 = 1;
      i2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight();
      if (i1 == 0) {
        break label349;
      }
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
        break label331;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
        break label270;
      }
      QQToast.a(BaseApplication.getContext(), 2131366443, 0).a();
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
      return;
      i1 = 0;
      break;
      label265:
      i1 = 0;
      break label167;
      label270:
      if (AudioHelper.b(1))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840057);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("ֹͣ停止录音");
        a(this);
        setFateOfRecorder(2);
        getWindowVisibleDisplayFrame(new Rect());
        continue;
        label331:
        QQToast.a(BaseApplication.getContext(), 2131366130, 0).b(i2);
        continue;
        label349:
        QQToast.a(BaseApplication.getContext(), 2131366129, 0).b(i2);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return b();
  }
  
  public void setFateOfRecorder(int paramInt)
  {
    this.e = paramInt;
  }
  
  @TargetApi(13)
  public void setRequestedOrientation4Recording(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 1;
    if (!paramBoolean)
    {
      this.o = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getRequestedOrientation();
      int i3 = getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.b()) {
        if (i3 == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          i1 = i2;
          if (VersionUtils.c()) {
            i1 = 7;
          }
          ((BaseActivity)localObject).setRequestedOrientation(i1);
        }
      }
      label66:
      do
      {
        do
        {
          do
          {
            break label66;
            do
            {
              return;
            } while (i3 != 2);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
            if (VersionUtils.c()) {}
            for (i1 = 6;; i1 = 0)
            {
              ((BaseActivity)localObject).setRequestedOrientation(i1);
              return;
            }
            if (VersionUtils.f())
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay();
              i2 = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((i2 == 0) || (i2 == 2)) {
                if (localPoint.x > localPoint.y) {
                  if (i2 != 0) {}
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(i1);
                return;
                i1 = 8;
                continue;
                if (i2 == 0)
                {
                  i1 = 1;
                }
                else
                {
                  i1 = 9;
                  continue;
                  if (localPoint.x > localPoint.y)
                  {
                    if (i2 != 1) {
                      i1 = 8;
                    }
                  }
                  else if (i2 == 1) {
                    i1 = 9;
                  } else {
                    i1 = 1;
                  }
                }
              }
            }
            i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getRotation();
            if ((i1 != 0) && (i1 != 1)) {
              break;
            }
            if (i3 == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(1);
              return;
            }
          } while (i3 != 2);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(0);
          return;
        } while ((i1 != 2) && (i1 != 3));
        if (i3 == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(9);
          return;
        }
      } while (i3 != 2);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(this.o);
  }
  
  public void setTimeOutTime(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */