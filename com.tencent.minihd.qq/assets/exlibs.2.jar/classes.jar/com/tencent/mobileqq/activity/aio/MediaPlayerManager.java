package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.flaotaio.FloatChatAdapter;
import com.tencent.mobileqq.activity.flaotaio.FloatItemBuilderFactory;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import fpc;
import fpd;
import fpe;
import fpf;
import java.lang.reflect.Method;
import mqq.manager.Manager;

public class MediaPlayerManager
  extends BroadcastReceiver
  implements SensorEventListener, AudioPlayer.AudioPlayerListener, Manager
{
  private static final String jdField_a_of_type_JavaLangString = MediaPlayerManager.class.getSimpleName();
  public float a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new fpc(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private MediaPlayerManager.Listener jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private fpf jdField_a_of_type_Fpf;
  public boolean a;
  public float b;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  boolean jdField_b_of_type_Boolean = true;
  public float c;
  boolean c = false;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = false;
  private boolean g;
  
  public MediaPlayerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(localBaseApplication, this);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)localBaseApplication.getSystemService("sensor"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    if (Build.VERSION.SDK_INT >= 11) {
      localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    }
    localBaseApplication.registerReceiver(this, localIntentFilter);
    a(paramQQAppInterface);
  }
  
  private float a(Sensor paramSensor)
  {
    String str = Build.MODEL;
    float f1;
    if ((str.equals("ZTE U880s")) || (str.equals("ZTE U807"))) {
      f1 = 97.0F;
    }
    do
    {
      return f1;
      if ((str.equals("Coolpad 5890")) || (str.equals("Coolpad 5891")) || (str.equals("Coolpad 8720L")) || (str.equals("Coolpad 5879")) || (str.equals("Coolpad 5891Q"))) {
        return 5.0F;
      }
      if ((str.equals("HUAWEI Y320-T00")) || (str.equals("Lenovo A658t")) || (str.equals("Lenovo A788t"))) {
        return 10.0F;
      }
      if (str.equals("ME860")) {
        return 99.0F;
      }
      if ((str.equals("ZTE U930HD")) || (str.equals("ZTE-T U960s"))) {
        return 100.0F;
      }
      f1 = 0.0F;
    } while (paramSensor == null);
    return paramSensor.getMaximumRange();
  }
  
  private int a()
  {
    int i = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    if (i >= 0)
    {
      View localView = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.m() + i);
      a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, i, localView, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    return i;
  }
  
  private int a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    int i = 0;
    while (i < paramBaseAdapter.getCount())
    {
      ChatMessage localChatMessage = (ChatMessage)paramBaseAdapter.getItem(i);
      if ((localChatMessage.getClass() == paramChatMessage.getClass()) && (localChatMessage.uniseq == paramChatMessage.uniseq)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private MediaPlayerManager.Callback a(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof ChatAdapter1)) {
      return (MediaPlayerManager.Callback)((ChatAdapter1)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a.a(paramChatMessage, this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    }
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof FloatChatAdapter)) {
      return (MediaPlayerManager.Callback)((FloatChatAdapter)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a.a(paramChatMessage);
    }
    return null;
  }
  
  public static MediaPlayerManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (MediaPlayerManager)paramQQAppInterface.getManager(23);
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "$bindApp, app = " + paramQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static boolean a()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      boolean bool = Boolean.parseBoolean(paramContext.getClass().getMethod("isWiredHeadsetOn", new Class[0]).invoke(paramContext, (Object[])null).toString());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null)) {
        a();
      }
    }
    for (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;; this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null)
    {
      do
      {
        return true;
      } while ((this.jdField_a_of_type_AndroidWidgetBaseAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
      if (!a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      a();
    }
    return false;
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null))
    {
      int j = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_AndroidWidgetBaseAdapter);
      int m = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount();
      if (j <= m)
      {
        View localView2 = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.m() + j);
        int i = j;
        View localView1 = localView2;
        if (j >= 0)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, j, localView2, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          localView1 = localView2;
          i = j;
        }
        while (i < m - 1)
        {
          int k = i + 1;
          ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItem(k);
          i = k;
          if ((localChatMessage instanceof MediaPlayerManager.Media))
          {
            if ((this.g) && (localView1 != null)) {}
            for (j = 1;; j = 0) {
              for (;;)
              {
                localView2 = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, k);
                MediaPlayerManager.Callback localCallback = a(localChatMessage);
                try
                {
                  PttInfoCollector.b(localChatMessage.uniseq, localChatMessage.frienduin);
                  i = k;
                  localView1 = localView2;
                  if (!localCallback.a(this.jdField_a_of_type_ComTencentWidgetXListView, k, localView2, localChatMessage)) {
                    break;
                  }
                  i = k;
                  localView1 = localView2;
                  if (!localCallback.a(this.jdField_a_of_type_ComTencentWidgetXListView, k, localView2, localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer)) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = localChatMessage;
                  if (j != 0) {
                    this.jdField_a_of_type_ComTencentWidgetXListView.d(k);
                  }
                  return true;
                }
                catch (Exception localException)
                {
                  i = k;
                  localView1 = localView2;
                }
              }
            }
            if (QLog.isColorLevel())
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "playNext", localException);
              i = k;
              localView1 = localView2;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    return false;
  }
  
  private void d()
  {
    float f2 = 0.0F;
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qq_audio_play.name(), null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "MediaPlayerManager.initSensors | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {}
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        boolean bool = "1".equals(localObject[0]);
        if (!bool) {
          i = 1;
        }
        int j;
        int i = 1;
      }
      catch (Exception localException2)
      {
        try
        {
          f1 = Float.parseFloat(localObject[1]);
          localObject = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.qq_audio_play_fix.name(), null);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "DPC config to UIN | dpcConfig = " + (String)localObject);
          }
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).length() <= 1)) {
            break label408;
          }
        }
        catch (Exception localException4)
        {
          j = i;
          continue;
          continue;
          j = i;
          continue;
        }
        try
        {
          localObject = ((String)localObject).split("\\|");
          if (!"-1".equals(localObject[4]))
          {
            f2 = Float.parseFloat(localObject[4]);
            f1 = f2;
          }
        }
        catch (Exception localException2)
        {
          try
          {
            bool = "1".equals(localObject[5]);
            if (!bool)
            {
              i = 1;
              j = i;
              if (j != 0)
              {
                this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
                this.jdField_a_of_type_Fpf = new fpf(this);
              }
              this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
              if (f1 <= 0.5F) {
                continue;
              }
              this.jdField_d_of_type_Float = f1;
              this.f = true;
              return;
              i = 0;
              continue;
              localException1 = localException1;
              j = 1;
              f1 = f2;
              i = j;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "parse dpc error", localException1);
              f1 = f2;
              i = j;
              continue;
            }
            i = 0;
            continue;
            localException2 = localException2;
            f2 = f1;
          }
          catch (Exception localException3)
          {
            f2 = f1;
            continue;
          }
          j = i;
          f1 = f2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "DPC config to UIN error.", localException2);
          j = i;
          f1 = f2;
          continue;
          if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
            continue;
          }
          this.jdField_d_of_type_Float = a(this.jdField_a_of_type_AndroidHardwareSensor);
          continue;
        }
      }
      label408:
      float f1 = f2;
    }
  }
  
  public ChatMessage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public void a()
  {
    try
    {
      a(true);
      a(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "$unBindApp");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "", localException);
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    AudioUtil.a(2131165187, 1, this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.b(paramInt);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new fpd(this, paramAudioPlayer, paramInt));
  }
  
  public void a(XListView paramXListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "unBindUI");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView == paramXListView))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_AndroidWidgetBaseAdapter = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = null;
    }
  }
  
  public void a(XListView paramXListView, BaseAdapter paramBaseAdapter, MediaPlayerManager.Listener paramListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "bindUI, mListView = " + this.jdField_a_of_type_ComTencentWidgetXListView + " ,listView = " + paramXListView + " ,adapter = " + paramBaseAdapter + ", listener = " + paramListener);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != paramXListView)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
      this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = paramListener;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a(paramBoolean)) {
      c();
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (!this.f) {
      d();
    }
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) && (paramChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      if (a(false))
      {
        int i = a(paramChatMessage, this.jdField_a_of_type_AndroidWidgetBaseAdapter);
        View localView = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.m() + i);
        MediaPlayerManager.Callback localCallback = a(paramChatMessage);
        if (AIOUtils.b()) {}
        for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v())
        {
          boolean bool1 = a(BaseApplicationImpl.getContext());
          boolean bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool2);
          if (!localCallback.a(this.jdField_a_of_type_ComTencentWidgetXListView, i, localView, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          this.g = true;
          this.c = false;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.L();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(bool1, bool2, this.jdField_d_of_type_Boolean);
          }
          this.e = false;
          if ((this.jdField_b_of_type_AndroidHardwareSensor != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null))
          {
            this.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Fpf, this.jdField_b_of_type_AndroidHardwareSensor, 3);
          }
          if (this.jdField_a_of_type_AndroidHardwareSensor != null) {
            this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 3);
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "$requestPlay| mAccelerationSensro=" + this.jdField_b_of_type_AndroidHardwareSensor + " | mProximitySensor = " + this.jdField_a_of_type_AndroidHardwareSensor);
          }
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "builder play failed.");
        }
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doStop failed.");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "request play failed, mAdapter = " + this.jdField_a_of_type_AndroidWidgetBaseAdapter + ", msg = " + paramChatMessage + ", app = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
    if ((bool != this.jdField_d_of_type_Boolean) && (b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null) || (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "$updateSpeakPhone| speakerOn=" + bool);
      }
    }
    this.jdField_d_of_type_Boolean = bool;
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.c(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (b())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.g = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "$onStop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.M();
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Fpf);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new fpe(this, paramInt));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onDestroy()
  {
    a();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    String str = paramIntent.getAction();
    if ((str != null) && (str.equals("android.intent.action.HEADSET_PLUG")) && (b())) {
      if (paramIntent.hasExtra("state"))
      {
        if (paramIntent.getIntExtra("state", 0) != 1) {
          break label101;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(bool1, AudioHelper.a(BaseApplicationImpl.getContext()), this.jdField_d_of_type_Boolean);
        }
      }
    }
    label101:
    int i;
    label206:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            bool1 = false;
            break;
            if (!"android.media.RINGER_MODE_CHANGED".equals(str)) {
              break label206;
            }
          } while (((AudioManager)paramContext.getSystemService("audio")).getRingerMode() == 2);
          this.jdField_d_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(this.jdField_d_of_type_Boolean);
          }
        } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(this.e, this.jdField_d_of_type_Boolean);
        return;
        if ("android.intent.action.SCREEN_OFF".equals(str))
        {
          a(false);
          return;
        }
      } while ((!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str)) || (!b()));
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
    } while ((i != 2) && (i != 0));
    if (i == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool1);
      return;
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool1;
    if (paramSensorEvent.values[0] < this.jdField_d_of_type_Float)
    {
      bool1 = true;
      if ((AudioHelper.a()) || (!bool1) || (this.jdField_a_of_type_Boolean)) {
        break label39;
      }
    }
    label39:
    label209:
    label254:
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool2;
            boolean bool3;
            do
            {
              do
              {
                return;
                bool1 = false;
                break;
              } while ((this.e == bool1) || (!b()));
              bool2 = a(BaseApplicationImpl.getContext());
              bool3 = AudioHelper.a(BaseApplicationImpl.getContext());
              this.e = bool1;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "ProximityEventListener$onSensorChanged | currentSpeaker = " + this.jdField_d_of_type_Boolean + " | mNearToEar = " + this.e + " | wiredHeadsetConnected = " + bool2 + " | btHeadsetConnect = " + bool3);
              }
            } while ((bool2) || (bool3));
            if ((!this.e) || (!this.jdField_d_of_type_Boolean)) {
              break label209;
            }
            this.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean);
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(this.e, this.jdField_d_of_type_Boolean);
          return;
          if (!this.e) {
            break label254;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean, true);
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(this.e, this.jdField_d_of_type_Boolean);
        return;
      } while ((this.e) || (this.jdField_d_of_type_Boolean));
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(this.e, this.jdField_d_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */