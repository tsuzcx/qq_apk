package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kij;
import kik;
import kil;
import kim;
import kin;
import kio;
import kip;

public class VideoRecordActivity
  extends BaseActivity
  implements SurfaceHolder.Callback, View.OnClickListener, Comparator
{
  public static final int a = -1;
  public static final String a = "VideoRecordActivity";
  public static final int b = 0;
  public static final String b = "output_path";
  public static final int c = 1;
  public static final String c = "duration_limit";
  public static final int d = 0;
  public static final String d = "size_limit";
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  public static final int n = 480;
  public static final int o = 640;
  public static final int p = 2000000;
  static final int q = 76800;
  static final int r = 921600;
  private int A = 90;
  private long jdField_a_of_type_Long;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private Chronometer jdField_a_of_type_AndroidWidgetChronometer;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = false;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = false;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private String jdField_e_of_type_JavaLangString;
  private int s = -1;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 640;
  private int x = 480;
  private int y;
  private int z = 2000000;
  
  @TargetApi(9)
  public static int a(Activity paramActivity, int paramInt)
  {
    int i1 = 0;
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    paramInt = i1;
    switch (paramActivity.getWindowManager().getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = i1;
    }
    while (localCameraInfo.facing == 1)
    {
      return (360 - (paramInt + localCameraInfo.orientation) % 360) % 360;
      paramInt = 90;
      continue;
      paramInt = 180;
      continue;
      paramInt = 270;
    }
    return (localCameraInfo.orientation - paramInt + 360) % 360;
  }
  
  @TargetApi(11)
  private Point a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    paramCamera = paramCamera.getParameters();
    Camera.Size localSize1 = paramCamera.getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
    {
      localObject = new Point(localSize1.width, localSize1.height);
      return localObject;
    }
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramCamera = paramCamera.getSupportedVideoSizes(); paramCamera == null; paramCamera = paramCamera.getSupportedPreviewSizes()) {
      return new Point(localSize1.width, localSize1.height);
    }
    Object localObject = new ArrayList(paramCamera);
    Collections.sort((List)localObject, this);
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    label136:
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize2 = (Camera.Size)((Iterator)localObject).next();
      int i1 = localSize2.width;
      int i2 = localSize2.height;
      int i3 = i1 * i2;
      if ((i3 >= 76800) && (i3 <= 921600) && ((i1 != 900) || (i2 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i1 == 1184) && (i2 == 666)) || ((i1 != 704) || (i2 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        if (paramInt1 > paramInt2)
        {
          i3 = 1;
          if (i1 >= i2) {
            break label359;
          }
          i4 = 1;
          label314:
          if (i3 != i4) {
            break label365;
          }
          i3 = i1;
        }
        for (int i4 = i2;; i4 = i1)
        {
          if ((i4 != paramInt1) || (i3 != paramInt2)) {
            break label376;
          }
          return new Point(i1, i2);
          i3 = 0;
          break;
          label359:
          i4 = 0;
          break label314;
          label365:
          i3 = i2;
        }
        label376:
        if ((i4 >= paramInt1 >> 1) && (i4 >> 1 <= paramInt1) && (i3 >= paramInt2 >> 1) && (i3 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i4 / i3 - f3);
          if (f2 >= f1) {
            break label475;
          }
          paramCamera = new Point(i1, i2);
          f1 = f2;
        }
      }
    }
    label475:
    for (;;)
    {
      break label136;
      localObject = paramCamera;
      if (paramCamera != null) {
        break;
      }
      return new Point(localSize1.width, localSize1.height);
    }
  }
  
  private void a()
  {
    if (SizeMeasure.a(this))
    {
      setRequestedOrientation(0);
      return;
    }
    setRequestedOrientation(1);
  }
  
  private boolean a(Intent paramIntent)
  {
    this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("output_path");
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      QQToast.a(this, 1, 2131364094, 0).a();
      return false;
    }
    this.y = paramIntent.getIntExtra("duration_limit", 2147483647);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("size_limit", 9223372036854775807L);
    return true;
  }
  
  private void b()
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      if (this.u == 1) {
        j();
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
    }
  }
  
  private boolean b()
  {
    if (Build.VERSION.SDK_INT <= 8)
    {
      QQToast.a(this, 1, 2131364092, 0).a();
      return false;
    }
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      QQToast.a(this, 1, 2131364093, 0).a();
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.reset();
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
      this.jdField_a_of_type_AndroidHardwareCamera.lock();
    }
  }
  
  private boolean c()
  {
    super.requestWindowFeature(1);
    super.setContentView(2130903689);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299324));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299325));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299326));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298164));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299323));
    this.jdField_a_of_type_AndroidWidgetChronometer = ((Chronometer)findViewById(2131299320));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299319));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299318));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = ((SurfaceView)findViewById(2131299322)).getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setKeepScreenOn(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    if (Build.VERSION.SDK_INT < 11) {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
    }
    return true;
  }
  
  @TargetApi(9)
  private void d()
  {
    this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
    this.jdField_a_of_type_AndroidMediaMediaRecorder.reset();
    this.jdField_a_of_type_AndroidHardwareCamera.unlock();
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(5);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSource(1);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(2);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(0);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncoder(3);
    this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoEncodingBitRate(this.z);
    if (this.s == 1) {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(this.A + 180);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSize(this.w, this.x);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxFileSize(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxDuration(this.y);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnInfoListener(new kil(this));
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface());
      return;
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(this.A);
    }
  }
  
  private boolean d()
  {
    i();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetChronometer.setBase(SystemClock.elapsedRealtime());
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.t = 0;
    this.v = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageLevel(this.t);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_a_of_type_AndroidHardwareCamera == null)
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = a(this.s);
        this.jdField_a_of_type_AndroidHardwareCamera = ((Camera)localObject);
        if ((localObject == null) || (!a())) {
          return false;
        }
      }
      Object localObject = ((WindowManager)getSystemService("window")).getDefaultDisplay();
      int i1 = ((Display)localObject).getWidth();
      ((Display)localObject).getHeight();
      int i2 = this.w * i1 / this.x;
      this.jdField_a_of_type_AndroidViewSurfaceHolder.setFixedSize(i1, i2);
    }
    return true;
  }
  
  @TargetApi(11)
  private void e()
  {
    this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
    CamcorderProfile localCamcorderProfile;
    if (CamcorderProfile.hasProfile(this.s, 4)) {
      localCamcorderProfile = CamcorderProfile.get(4);
    }
    for (;;)
    {
      localCamcorderProfile.videoFrameWidth = this.w;
      localCamcorderProfile.videoFrameHeight = this.x;
      localCamcorderProfile.videoBitRate = this.z;
      localParameters.setPreviewSize(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight);
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
        label86:
        this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
        this.jdField_a_of_type_AndroidHardwareCamera.unlock();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setCamera(this.jdField_a_of_type_AndroidHardwareCamera);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(5);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setVideoSource(1);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setProfile(localCamcorderProfile);
        if (this.s == 1) {
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(this.A + 180);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(this.jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxFileSize(this.jdField_a_of_type_Long);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setMaxDuration(this.y);
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnInfoListener(new kim(this));
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface());
          return;
          localCamcorderProfile = CamcorderProfile.get(1);
          break;
          this.jdField_a_of_type_AndroidMediaMediaRecorder.setOrientationHint(this.A);
        }
      }
      catch (IOException localIOException)
      {
        break label86;
      }
    }
  }
  
  private void f()
  {
    if (this.t == 0) {
      try
      {
        e();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.start();
        if ((Build.VERSION.SDK_INT <= 10) && (!KapalaiAdapterUtil.a().a(this.jdField_a_of_type_AndroidHardwareCamera.getParameters(), this))) {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        this.v = 0;
        this.t = 1;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageLevel(this.t);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetChronometer.setBase(SystemClock.elapsedRealtime());
        this.jdField_a_of_type_AndroidWidgetChronometer.start();
        return;
      }
      catch (Exception localException)
      {
        QQToast.a(this, 1, 2131364098, 0).a();
        c();
        return;
      }
    }
    QQToast.a(this, 1, 2131364099, 0).a();
  }
  
  private void g()
  {
    if (this.t == 1) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
      c();
      b();
      this.jdField_a_of_type_AndroidWidgetChronometer.stop();
      this.t = 2;
      this.v = 1;
      if (new File(this.jdField_e_of_type_JavaLangString).length() == 0L) {
        a("zero_file_size", "troop_bar_video_shoot", "API version:" + Build.VERSION.SDK_INT, Build.MANUFACTURER, Build.MODEL, null);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageLevel(this.t);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        new File(this.jdField_e_of_type_JavaLangString).delete();
      }
    }
  }
  
  private void h()
  {
    if (this.app.d()) {}
    do
    {
      QQToast.a(this, 0, 2131369561, 0).a();
      do
      {
        return;
      } while (this.v != 1);
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(this.jdField_a_of_type_AndroidViewSurfaceHolder);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new kin(this));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new kio(this));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new kip(this));
        return;
      }
      catch (Exception localException) {}
    } while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    this.v = 1;
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetChronometer != null) {
      this.jdField_a_of_type_AndroidWidgetChronometer.stop();
    }
    if (this.v == 2)
    {
      this.v = 1;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
      }
    }
  }
  
  private void j()
  {
    Camera.Parameters localParameters;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      if (KapalaiAdapterUtil.a().a(localParameters, this)) {}
    }
    else
    {
      return;
    }
    if ("off".equals(localParameters.getFlashMode())) {
      localParameters.setFlashMode(KapalaiAdapterUtil.a().a(localParameters));
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
        if (this.u != 1) {
          break label111;
        }
        i1 = 0;
        this.u = i1;
        this.jdField_d_of_type_AndroidWidgetImageView.setImageLevel(this.u);
        return;
      }
      catch (Exception localException)
      {
        QQToast.a(this, 1, 2131364100, 0).a();
        return;
      }
      localException.setFlashMode("off");
      continue;
      label111:
      int i1 = 1;
    }
  }
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i1 = paramSize1.height * paramSize1.width;
    int i2 = paramSize2.height * paramSize2.width;
    if (i2 < i1) {
      return 1;
    }
    if (i2 > i1) {
      return -1;
    }
    return 0;
  }
  
  @TargetApi(9)
  public Camera a(int paramInt)
  {
    Object localObject2 = null;
    Camera localCamera = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        switch (Camera.getNumberOfCameras())
        {
        case 0: 
          localObject1 = localObject2;
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
          switch (paramInt)
          {
          case -1: 
            localObject1 = localObject2;
            if (this.s == 1)
            {
              localObject1 = localObject2;
              localCamera = KapalaiAdapterUtil.a().a();
              if (localCamera != null) {
                return localCamera;
              }
            }
            localObject1 = localCamera;
            return Camera.open(this.s);
          }
          break;
        }
      }
      catch (Exception localException)
      {
        QQToast.a(this, 1, 2131364095, 0).a();
        super.finish();
        return localObject1;
      }
      localObject1 = localObject2;
      throw new RuntimeException();
      localObject1 = localObject2;
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      localObject1 = localObject2;
      this.s = 0;
      localObject1 = localObject2;
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      localObject1 = localObject2;
      Camera.getCameraInfo(0, localCameraInfo);
      localObject1 = localObject2;
      if (localCameraInfo.facing == 1)
      {
        localObject1 = localObject2;
        this.s = 1;
        continue;
        localObject1 = localObject2;
        this.s = 0;
        continue;
        localObject1 = localObject2;
        this.s = 1;
        continue;
      }
    }
    return localException;
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.a(null, "P_CliOper", "BizTechReport", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  /* Error */
  @TargetApi(14)
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 681
    //   7: getstatic 154	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   10: invokevirtual 160	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   13: ifeq +159 -> 172
    //   16: getstatic 165	android/os/Build:MODEL	Ljava/lang/String;
    //   19: invokevirtual 684	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   22: ldc_w 686
    //   25: invokevirtual 689	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   28: ifeq +144 -> 172
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 293	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   36: sipush 800
    //   39: sipush 480
    //   42: invokespecial 691	com/tencent/mobileqq/troop/activity/VideoRecordActivity:a	(Landroid/hardware/Camera;II)Landroid/graphics/Point;
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 293	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   50: invokevirtual 141	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   53: astore_3
    //   54: getstatic 183	android/os/Build$VERSION:SDK_INT	I
    //   57: bipush 14
    //   59: if_icmplt +8 -> 67
    //   62: aload_3
    //   63: iconst_1
    //   64: invokevirtual 694	android/hardware/Camera$Parameters:setRecordingHint	(Z)V
    //   67: aload_0
    //   68: aload_2
    //   69: getfield 695	android/graphics/Point:x	I
    //   72: putfield 83	com/tencent/mobileqq/troop/activity/VideoRecordActivity:w	I
    //   75: aload_0
    //   76: aload_2
    //   77: getfield 696	android/graphics/Point:y	I
    //   80: putfield 85	com/tencent/mobileqq/troop/activity/VideoRecordActivity:x	I
    //   83: aload_3
    //   84: aload_0
    //   85: getfield 83	com/tencent/mobileqq/troop/activity/VideoRecordActivity:w	I
    //   88: aload_0
    //   89: getfield 85	com/tencent/mobileqq/troop/activity/VideoRecordActivity:x	I
    //   92: invokevirtual 515	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   95: aload_0
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 73	com/tencent/mobileqq/troop/activity/VideoRecordActivity:s	I
    //   101: invokestatic 698	com/tencent/mobileqq/troop/activity/VideoRecordActivity:a	(Landroid/app/Activity;I)I
    //   104: putfield 95	com/tencent/mobileqq/troop/activity/VideoRecordActivity:A	I
    //   107: aload_0
    //   108: getfield 293	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   111: aload_0
    //   112: getfield 95	com/tencent/mobileqq/troop/activity/VideoRecordActivity:A	I
    //   115: invokevirtual 701	android/hardware/Camera:setDisplayOrientation	(I)V
    //   118: invokestatic 544	com/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil:a	()Lcom/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil;
    //   121: aload_3
    //   122: aload_0
    //   123: invokevirtual 547	com/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil:a	(Landroid/hardware/Camera$Parameters;Landroid/content/Context;)Z
    //   126: ifeq +64 -> 190
    //   129: aload_0
    //   130: getfield 366	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   133: iconst_0
    //   134: invokevirtual 458	android/widget/ImageView:setVisibility	(I)V
    //   137: aload_0
    //   138: getfield 293	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   141: aload_3
    //   142: invokevirtual 519	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   145: aload_0
    //   146: getfield 293	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   149: aload_0
    //   150: getfield 383	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   153: invokevirtual 522	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   156: aload_0
    //   157: getfield 293	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   160: invokevirtual 704	android/hardware/Camera:startPreview	()V
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 91	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_c_of_type_Boolean	Z
    //   168: aload_0
    //   169: monitorexit
    //   170: iload_1
    //   171: ireturn
    //   172: aload_0
    //   173: aload_0
    //   174: getfield 293	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   177: sipush 640
    //   180: sipush 480
    //   183: invokespecial 691	com/tencent/mobileqq/troop/activity/VideoRecordActivity:a	(Landroid/hardware/Camera;II)Landroid/graphics/Point;
    //   186: astore_2
    //   187: goto -141 -> 46
    //   190: aload_0
    //   191: getfield 366	com/tencent/mobileqq/troop/activity/VideoRecordActivity:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   194: iconst_4
    //   195: invokevirtual 458	android/widget/ImageView:setVisibility	(I)V
    //   198: goto -61 -> 137
    //   201: astore_2
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_2
    //   205: athrow
    //   206: astore_2
    //   207: aload_0
    //   208: invokespecial 559	com/tencent/mobileqq/troop/activity/VideoRecordActivity:b	()V
    //   211: aload_0
    //   212: iconst_1
    //   213: ldc_w 667
    //   216: iconst_0
    //   217: invokestatic 273	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   220: invokevirtual 276	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   223: pop
    //   224: aload_0
    //   225: invokespecial 304	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   228: iconst_0
    //   229: istore_1
    //   230: goto -62 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	VideoRecordActivity
    //   1	229	1	bool	boolean
    //   45	142	2	localPoint	Point
    //   201	4	2	localObject	Object
    //   206	1	2	localException	Exception
    //   53	89	3	localParameters	Camera.Parameters
    // Exception table:
    //   from	to	target	type
    //   4	46	201	finally
    //   46	67	201	finally
    //   67	137	201	finally
    //   137	168	201	finally
    //   172	187	201	finally
    //   190	198	201	finally
    //   207	228	201	finally
    //   137	168	206	java/lang/Exception
  }
  
  public void doOnBackPressed()
  {
    this.jdField_a_of_type_Boolean = true;
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    if ((!b()) || (!a(getIntent())) || (!c())) {
      super.finish();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Boolean) {
      new File(this.jdField_e_of_type_JavaLangString).delete();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.t == 1) {
      g();
    }
    b();
    i();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.t == 2)
    {
      this.v = 1;
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
      return;
    }
    d();
  }
  
  public void onClick(View paramView)
  {
    int i1 = 1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299324: 
      switch (this.t)
      {
      default: 
        return;
      case 0: 
        f();
        return;
      }
      g();
      return;
    case 2131299325: 
      new File(this.jdField_e_of_type_JavaLangString).delete();
      d();
      return;
    case 2131299326: 
      long l1 = new File(this.jdField_e_of_type_JavaLangString).length();
      if (l1 <= 0L)
      {
        DialogUtil.a(this, super.getString(2131364101), 2131365736, 2131365737, new DialogUtil.DialogOnClickAdapter(), null).show();
        return;
      }
      DialogUtil.a(this, 232, null, getString(2131364106, new Object[] { String.format("%.2fMB", new Object[] { Double.valueOf(l1 / 1024.0D / 1024.0D) }) }), new kij(this), new kik(this)).show();
      return;
    case 2131298164: 
      this.jdField_a_of_type_Boolean = true;
      super.finish();
      return;
    case 2131299319: 
      j();
      return;
    case 2131299318: 
      b();
      if (this.s == 0) {}
      for (;;)
      {
        this.s = i1;
        d();
        return;
        i1 = 0;
      }
    }
    h();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramSurfaceHolder.getSurface() == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
      } while (!this.jdField_d_of_type_Boolean);
      if (!this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidHardwareCamera = a(this.s);
      }
    } while (this.jdField_a_of_type_AndroidHardwareCamera == null);
    this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    a();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.VideoRecordActivity
 * JD-Core Version:    0.7.0.1
 */