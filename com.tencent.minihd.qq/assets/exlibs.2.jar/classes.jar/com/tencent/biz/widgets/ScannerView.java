package com.tencent.biz.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.tencent.minihd.qq.R.styleable;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import cqu;
import cqv;
import cqx;
import cqy;
import cre;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ScannerView
  extends ViewGroup
  implements Camera.PreviewCallback, SensorEventListener, SurfaceHolder.Callback, Comparator
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a;
  static final int jdField_b_of_type_Int = 2;
  static final int jdField_c_of_type_Int = 3;
  static final int jdField_d_of_type_Int = 4;
  static final int jdField_e_of_type_Int = 5;
  static final int jdField_f_of_type_Int = 6;
  static final int jdField_g_of_type_Int = 7;
  static final int h = 8;
  static final int i = 9;
  static final int j = 76800;
  static final int k = 921600;
  static final int l = 250;
  static final int m = 1024;
  private int A = -1;
  private int B = 17;
  private float jdField_a_of_type_Float = 0.0F;
  public long a;
  public Rect a;
  Camera jdField_a_of_type_AndroidHardwareCamera;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler jdField_a_of_type_AndroidOsHandler;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private ScannerView.FileDecodeListener jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener;
  private ScannerView.ScannerListener jdField_a_of_type_ComTencentBizWidgetsScannerView$ScannerListener;
  private cqv jdField_a_of_type_Cqv;
  cqy jdField_a_of_type_Cqy;
  private cre jdField_a_of_type_Cre;
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  public long b;
  public Rect b;
  public Handler b;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float = 0.0F;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_c_of_type_Boolean = false;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  public int n;
  public int o;
  int p;
  int q;
  public int r;
  public int s;
  public int t;
  public int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private int y = 0;
  private int z = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = ScannerView.class.getSimpleName();
  }
  
  public ScannerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.d = false;
    this.e = true;
    this.f = false;
    this.g = true;
    this.jdField_b_of_type_AndroidOsHandler = new cqu(this);
    a(paramContext, null);
  }
  
  public ScannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.d = false;
    this.e = true;
    this.f = false;
    this.g = true;
    this.jdField_b_of_type_AndroidOsHandler = new cqu(this);
    a(paramContext, paramAttributeSet);
  }
  
  private Point a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    paramCamera = paramCamera.getParameters();
    Camera.Size localSize1 = paramCamera.getPreviewSize();
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && ("GT-I9008L".equalsIgnoreCase(Build.MODEL)))
    {
      localObject1 = new Point(localSize1.width, localSize1.height);
      return localObject1;
    }
    paramCamera = paramCamera.getSupportedPreviewSizes();
    if (paramCamera == null) {
      return new Point(localSize1.width, localSize1.height);
    }
    Object localObject1 = new ArrayList(paramCamera);
    Collections.sort((List)localObject1, this);
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      paramCamera = new StringBuilder("manufacturer:").append(Build.MANUFACTURER).append(" model:").append(Build.MODEL).append("\ndefault size:").append(localSize1.width).append(" x ").append(localSize1.height).append("\nsizes:");
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize2 = (Camera.Size)((Iterator)localObject2).next();
        paramCamera.append(localSize2.width).append(" x ").append(localSize2.height).append(" | ");
      }
      QLog.d(jdField_a_of_type_JavaLangString, 4, paramCamera.toString());
    }
    paramCamera = null;
    float f3 = paramInt1 / paramInt2;
    float f1 = (1.0F / 1.0F);
    localObject1 = ((List)localObject1).iterator();
    label258:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject1).next();
      int i1 = ((Camera.Size)localObject2).width;
      int i2 = ((Camera.Size)localObject2).height;
      int i3 = i1 * i2;
      if ((i3 >= 76800) && (i3 <= 921600) && ((i1 != 900) || (i2 != 800) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"GT-I9220".equalsIgnoreCase(Build.MODEL)) && (!"GT-N7000".equalsIgnoreCase(Build.MODEL)))) && (((i1 == 1184) && (i2 == 666)) || ((i1 != 704) || (i2 != 576) || (!"samsung".equalsIgnoreCase(Build.MANUFACTURER)) || (!"GT-I9300".equalsIgnoreCase(Build.MODEL)))))
      {
        if (paramInt1 > paramInt2)
        {
          i3 = 1;
          if (i1 >= i2) {
            break label484;
          }
          i4 = 1;
          label439:
          if (i3 != i4) {
            break label490;
          }
          i3 = i1;
        }
        for (int i4 = i2;; i4 = i1)
        {
          if ((i4 != paramInt1) || (i3 != paramInt2)) {
            break label501;
          }
          return new Point(i1, i2);
          i3 = 0;
          break;
          label484:
          i4 = 0;
          break label439;
          label490:
          i3 = i2;
        }
        label501:
        if ((i4 >= paramInt1 >> 1) && (i4 >> 1 <= paramInt1) && (i3 >= paramInt2 >> 1) && (i3 >> 1 <= paramInt2))
        {
          float f2 = Math.abs(i4 / i3 - f3);
          if (f2 >= f1) {
            break label600;
          }
          paramCamera = new Point(i1, i2);
          f1 = f2;
        }
      }
    }
    label600:
    for (;;)
    {
      break label258;
      localObject1 = paramCamera;
      if (paramCamera != null) {
        break;
      }
      return new Point(localSize1.width, localSize1.height);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i1 = 0;
    setKeepScreenOn(true);
    a(paramContext);
    this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(paramContext, paramAttributeSet);
    addView(this.jdField_a_of_type_AndroidViewSurfaceView);
    Object localObject = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    ((SurfaceHolder)localObject).addCallback(this);
    if (Build.VERSION.SDK_INT < 11) {
      ((SurfaceHolder)localObject).setType(3);
    }
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeBooleanValue(0, true)))
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.P);
      int i2 = ((TypedArray)localObject).getIndexCount();
      if (i1 < i2)
      {
        int i3 = ((TypedArray)localObject).getIndex(i1);
        switch (i3)
        {
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.y = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.y);
          continue;
          this.w = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.w);
          continue;
          this.x = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.x);
          continue;
          this.v = ((TypedArray)localObject).getDimensionPixelOffset(i3, this.v);
          continue;
          this.z = ((TypedArray)localObject).getLayoutDimension(i3, this.z);
          continue;
          this.A = ((TypedArray)localObject).getLayoutDimension(i3, this.A);
          continue;
          this.B = ((TypedArray)localObject).getInt(i3, this.B);
        }
      }
      ((TypedArray)localObject).recycle();
      this.jdField_a_of_type_Cre = new cre(paramContext);
      addView(this.jdField_a_of_type_Cre);
    }
    if (paramAttributeSet != null) {
      this.jdField_a_of_type_Boolean = paramAttributeSet.getAttributeBooleanValue(8, true);
    }
  }
  
  @TargetApi(9)
  private boolean b()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    label337:
    label344:
    label349:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidHardwareCamera != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "camera already opened");
          }
          return true;
        }
        if (Build.VERSION.SDK_INT >= 9)
        {
          i2 = Camera.getNumberOfCameras();
          if (i2 <= 0) {
            break label344;
          }
          Object localObject1 = new Camera.CameraInfo();
          i1 = 0;
          if (i1 < i2)
          {
            Camera.getCameraInfo(i1, (Camera.CameraInfo)localObject1);
            if (((Camera.CameraInfo)localObject1).facing != 0) {}
          }
          else
          {
            if (i1 < i2) {
              break label337;
            }
            Camera.getCameraInfo(0, (Camera.CameraInfo)localObject1);
            i2 = 0;
            i1 = 1;
            this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(i2);
            i3 = ((Camera.CameraInfo)localObject1).orientation;
            i2 = i1;
            i1 = i3;
            break label349;
            if (MobileIssueSettings.a <= 0) {
              continue;
            }
            i3 = MobileIssueSettings.a;
            this.p = i3;
            this.q = i2;
            if (QLog.isColorLevel())
            {
              localObject1 = jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder().append("camera open:");
              if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
                continue;
              }
              bool1 = true;
              QLog.d((String)localObject1, 2, bool1 + " orientation:" + i1 + " facing:" + i2);
            }
            localObject1 = this.jdField_a_of_type_AndroidHardwareCamera;
            bool1 = bool2;
            if (localObject1 != null) {
              bool1 = true;
            }
            return bool1;
          }
          i1 += 1;
          continue;
        }
        else
        {
          this.jdField_a_of_type_AndroidHardwareCamera = Camera.open();
          i2 = 0;
          i1 = 90;
          continue;
        }
        int i3 = i1;
        continue;
        boolean bool1 = false;
        continue;
        i2 = i1;
      }
      catch (RuntimeException localRuntimeException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "camera open failed:" + localRuntimeException.getMessage());
        }
        return false;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      int i1 = 0;
      continue;
      i1 = 90;
      int i2 = 0;
    }
  }
  
  /* Error */
  @TargetApi(8)
  private boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 365	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 375	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 121	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   29: ifeq +34 -> 63
    //   32: aload_0
    //   33: getfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   36: ifnull +20 -> 56
    //   39: aload_0
    //   40: getfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   43: invokevirtual 431	cqv:isAlive	()Z
    //   46: ifeq +10 -> 56
    //   49: aload_0
    //   50: getfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   53: invokevirtual 434	cqv:interrupt	()V
    //   56: aload_0
    //   57: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   60: invokevirtual 437	android/hardware/Camera:stopPreview	()V
    //   63: aload_0
    //   64: invokevirtual 441	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   67: ldc_w 443
    //   70: invokevirtual 447	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   73: checkcast 449	android/view/WindowManager
    //   76: invokeinterface 453 1 0
    //   81: invokevirtual 458	android/view/Display:getOrientation	()I
    //   84: bipush 90
    //   86: imul
    //   87: istore_2
    //   88: aload_0
    //   89: getfield 403	com/tencent/biz/widgets/ScannerView:q	I
    //   92: ifne +369 -> 461
    //   95: aload_0
    //   96: getfield 401	com/tencent/biz/widgets/ScannerView:p	I
    //   99: iload_2
    //   100: isub
    //   101: sipush 360
    //   104: iadd
    //   105: sipush 360
    //   108: irem
    //   109: istore_1
    //   110: aload_0
    //   111: iload_1
    //   112: putfield 460	com/tencent/biz/widgets/ScannerView:t	I
    //   115: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +40 -> 158
    //   121: getstatic 79	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   124: iconst_2
    //   125: new 214	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   132: ldc_w 462
    //   135: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_2
    //   139: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: ldc_w 464
    //   145: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload_1
    //   149: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_0
    //   159: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   162: invokevirtual 154	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   165: astore_3
    //   166: getstatic 306	android/os/Build$VERSION:SDK_INT	I
    //   169: bipush 8
    //   171: if_icmplt +304 -> 475
    //   174: aload_0
    //   175: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   178: iload_1
    //   179: invokevirtual 467	android/hardware/Camera:setDisplayOrientation	(I)V
    //   182: aload_3
    //   183: invokevirtual 470	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   186: ifeq +15 -> 201
    //   189: aload_3
    //   190: iconst_2
    //   191: aload_3
    //   192: invokevirtual 473	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   195: invokestatic 476	java/lang/Math:min	(II)I
    //   198: invokevirtual 479	android/hardware/Camera$Parameters:setZoom	(I)V
    //   201: aload_0
    //   202: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   205: aload_3
    //   206: invokevirtual 483	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   214: aload_0
    //   215: getfield 485	com/tencent/biz/widgets/ScannerView:r	I
    //   218: aload_0
    //   219: getfield 487	com/tencent/biz/widgets/ScannerView:s	I
    //   222: invokespecial 489	com/tencent/biz/widgets/ScannerView:a	(Landroid/hardware/Camera;II)Landroid/graphics/Point;
    //   225: astore_3
    //   226: aload_0
    //   227: aload_3
    //   228: getfield 490	android/graphics/Point:x	I
    //   231: putfield 492	com/tencent/biz/widgets/ScannerView:n	I
    //   234: aload_0
    //   235: aload_3
    //   236: getfield 493	android/graphics/Point:y	I
    //   239: putfield 495	com/tencent/biz/widgets/ScannerView:o	I
    //   242: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +45 -> 290
    //   248: getstatic 79	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   251: iconst_2
    //   252: new 214	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 497
    //   262: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_3
    //   266: getfield 490	android/graphics/Point:x	I
    //   269: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc 232
    //   274: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_3
    //   278: getfield 493	android/graphics/Point:y	I
    //   281: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_0
    //   291: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   294: invokevirtual 154	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   297: astore 4
    //   299: aload 4
    //   301: aload_3
    //   302: getfield 490	android/graphics/Point:x	I
    //   305: aload_3
    //   306: getfield 493	android/graphics/Point:y	I
    //   309: invokevirtual 500	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   312: aload_0
    //   313: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   316: aload 4
    //   318: invokevirtual 483	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   321: aload_0
    //   322: getfield 502	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   325: astore 5
    //   327: aload 5
    //   329: astore_3
    //   330: aload 5
    //   332: ifnonnull +51 -> 383
    //   335: aload_0
    //   336: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   339: invokevirtual 154	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   342: astore 6
    //   344: aload 6
    //   346: invokevirtual 505	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   349: astore 7
    //   351: aload 7
    //   353: ifnonnull +221 -> 574
    //   356: aload 5
    //   358: astore_3
    //   359: aload_3
    //   360: ifnull +289 -> 649
    //   363: aload_3
    //   364: astore 4
    //   366: aload_0
    //   367: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   370: aload 6
    //   372: invokevirtual 483	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   375: aload_3
    //   376: astore 4
    //   378: aload_0
    //   379: aload_3
    //   380: putfield 502	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   383: aload_0
    //   384: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   387: aload_0
    //   388: getfield 287	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidViewSurfaceView	Landroid/view/SurfaceView;
    //   391: invokevirtual 295	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   394: invokevirtual 509	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   397: aload_0
    //   398: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   401: invokevirtual 512	android/hardware/Camera:startPreview	()V
    //   404: aload_0
    //   405: iconst_1
    //   406: putfield 121	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   409: ldc_w 514
    //   412: aload_3
    //   413: invokevirtual 518	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifne +13 -> 429
    //   419: ldc_w 520
    //   422: aload_3
    //   423: invokevirtual 518	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   426: ifeq +26 -> 452
    //   429: aload_0
    //   430: new 428	cqv
    //   433: dup
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   439: invokespecial 523	cqv:<init>	(Lcom/tencent/biz/widgets/ScannerView;Landroid/hardware/Camera;)V
    //   442: putfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   445: aload_0
    //   446: getfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   449: invokevirtual 526	cqv:start	()V
    //   452: aload_0
    //   453: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   456: invokevirtual 375	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   459: iconst_1
    //   460: ireturn
    //   461: aload_0
    //   462: getfield 401	com/tencent/biz/widgets/ScannerView:p	I
    //   465: iload_2
    //   466: iadd
    //   467: sipush 360
    //   470: irem
    //   471: istore_1
    //   472: goto -362 -> 110
    //   475: iload_2
    //   476: sipush 180
    //   479: irem
    //   480: ifne +13 -> 493
    //   483: aload_3
    //   484: ldc_w 527
    //   487: ldc_w 529
    //   490: invokevirtual 533	android/hardware/Camera$Parameters:set	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_3
    //   494: iload_1
    //   495: invokevirtual 536	android/hardware/Camera$Parameters:setRotation	(I)V
    //   498: goto -297 -> 201
    //   501: astore_3
    //   502: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq +13 -> 518
    //   508: getstatic 79	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   511: iconst_2
    //   512: ldc_w 538
    //   515: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload_0
    //   519: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   522: invokevirtual 375	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   525: iconst_0
    //   526: ireturn
    //   527: astore_3
    //   528: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq -210 -> 321
    //   534: getstatic 79	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   537: iconst_2
    //   538: ldc_w 540
    //   541: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: goto -223 -> 321
    //   547: astore_3
    //   548: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   551: ifeq +13 -> 564
    //   554: getstatic 79	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   557: iconst_2
    //   558: ldc_w 538
    //   561: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload_0
    //   565: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   568: invokevirtual 375	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   571: goto -46 -> 525
    //   574: aload 5
    //   576: astore 4
    //   578: aload 7
    //   580: ldc_w 514
    //   583: invokeinterface 543 2 0
    //   588: ifeq +10 -> 598
    //   591: ldc_w 514
    //   594: astore_3
    //   595: goto -236 -> 359
    //   598: aload 5
    //   600: astore 4
    //   602: aload 7
    //   604: ldc_w 520
    //   607: invokeinterface 543 2 0
    //   612: ifeq +10 -> 622
    //   615: ldc_w 520
    //   618: astore_3
    //   619: goto -260 -> 359
    //   622: aload 5
    //   624: astore_3
    //   625: aload 5
    //   627: astore 4
    //   629: aload 7
    //   631: ldc_w 545
    //   634: invokeinterface 543 2 0
    //   639: ifeq -280 -> 359
    //   642: ldc_w 545
    //   645: astore_3
    //   646: goto -287 -> 359
    //   649: aload_3
    //   650: astore 4
    //   652: aload_0
    //   653: ldc_w 547
    //   656: putfield 502	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   659: goto -276 -> 383
    //   662: astore_3
    //   663: aload 4
    //   665: astore_3
    //   666: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq -286 -> 383
    //   672: getstatic 79	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   675: iconst_2
    //   676: new 214	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   683: ldc_w 549
    //   686: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload 4
    //   691: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: ldc_w 551
    //   697: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 257	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   706: aload 4
    //   708: astore_3
    //   709: goto -326 -> 383
    //   712: astore_3
    //   713: aload_0
    //   714: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   717: invokevirtual 375	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   720: aload_3
    //   721: athrow
    //   722: astore_3
    //   723: goto -514 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	ScannerView
    //   109	386	1	i1	int
    //   87	393	2	i2	int
    //   11	483	3	localObject1	Object
    //   501	1	3	localIOException	java.io.IOException
    //   527	1	3	localRuntimeException1	RuntimeException
    //   547	1	3	localRuntimeException2	RuntimeException
    //   594	56	3	localObject2	Object
    //   662	1	3	localRuntimeException3	RuntimeException
    //   665	44	3	localObject3	Object
    //   712	9	3	localObject4	Object
    //   722	1	3	localRuntimeException4	RuntimeException
    //   297	410	4	localObject5	Object
    //   325	301	5	str	String
    //   342	29	6	localParameters	Camera.Parameters
    //   349	281	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   7	12	501	java/io/IOException
    //   25	56	501	java/io/IOException
    //   56	63	501	java/io/IOException
    //   63	110	501	java/io/IOException
    //   110	158	501	java/io/IOException
    //   158	201	501	java/io/IOException
    //   201	209	501	java/io/IOException
    //   209	290	501	java/io/IOException
    //   290	321	501	java/io/IOException
    //   321	327	501	java/io/IOException
    //   335	351	501	java/io/IOException
    //   366	375	501	java/io/IOException
    //   378	383	501	java/io/IOException
    //   383	429	501	java/io/IOException
    //   429	452	501	java/io/IOException
    //   461	472	501	java/io/IOException
    //   483	493	501	java/io/IOException
    //   493	498	501	java/io/IOException
    //   528	544	501	java/io/IOException
    //   578	591	501	java/io/IOException
    //   602	615	501	java/io/IOException
    //   629	642	501	java/io/IOException
    //   652	659	501	java/io/IOException
    //   666	706	501	java/io/IOException
    //   290	321	527	java/lang/RuntimeException
    //   7	12	547	java/lang/RuntimeException
    //   25	56	547	java/lang/RuntimeException
    //   56	63	547	java/lang/RuntimeException
    //   63	110	547	java/lang/RuntimeException
    //   110	158	547	java/lang/RuntimeException
    //   158	201	547	java/lang/RuntimeException
    //   209	290	547	java/lang/RuntimeException
    //   321	327	547	java/lang/RuntimeException
    //   335	351	547	java/lang/RuntimeException
    //   383	429	547	java/lang/RuntimeException
    //   429	452	547	java/lang/RuntimeException
    //   461	472	547	java/lang/RuntimeException
    //   483	493	547	java/lang/RuntimeException
    //   493	498	547	java/lang/RuntimeException
    //   528	544	547	java/lang/RuntimeException
    //   666	706	547	java/lang/RuntimeException
    //   366	375	662	java/lang/RuntimeException
    //   378	383	662	java/lang/RuntimeException
    //   578	591	662	java/lang/RuntimeException
    //   602	615	662	java/lang/RuntimeException
    //   629	642	662	java/lang/RuntimeException
    //   652	659	662	java/lang/RuntimeException
    //   7	12	712	finally
    //   25	56	712	finally
    //   56	63	712	finally
    //   63	110	712	finally
    //   110	158	712	finally
    //   158	201	712	finally
    //   201	209	712	finally
    //   209	290	712	finally
    //   290	321	712	finally
    //   321	327	712	finally
    //   335	351	712	finally
    //   366	375	712	finally
    //   378	383	712	finally
    //   383	429	712	finally
    //   429	452	712	finally
    //   461	472	712	finally
    //   483	493	712	finally
    //   493	498	712	finally
    //   502	518	712	finally
    //   528	544	712	finally
    //   548	564	712	finally
    //   578	591	712	finally
    //   602	615	712	finally
    //   629	642	712	finally
    //   652	659	712	finally
    //   666	706	712	finally
    //   201	209	722	java/lang/RuntimeException
  }
  
  private void e()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new RuntimeException("This method must be called on UI thread");
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 365	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   20: invokevirtual 375	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   23: return
    //   24: aload_0
    //   25: getfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   28: ifnull +25 -> 53
    //   31: aload_0
    //   32: getfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   35: invokevirtual 431	cqv:isAlive	()Z
    //   38: ifeq +15 -> 53
    //   41: aload_0
    //   42: getfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   45: invokevirtual 434	cqv:interrupt	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 426	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Cqv	Lcqv;
    //   53: aload_0
    //   54: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   57: invokevirtual 154	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   60: astore_1
    //   61: aload_1
    //   62: ldc_w 565
    //   65: invokevirtual 568	android/hardware/Camera$Parameters:setFlashMode	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   72: aload_1
    //   73: invokevirtual 483	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 123	com/tencent/biz/widgets/ScannerView:d	Z
    //   81: aload_0
    //   82: getfield 121	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   85: ifeq +15 -> 100
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 121	com/tencent/biz/widgets/ScannerView:jdField_c_of_type_Boolean	Z
    //   93: aload_0
    //   94: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   97: invokevirtual 437	android/hardware/Camera:stopPreview	()V
    //   100: aload_0
    //   101: getfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   104: invokevirtual 571	android/hardware/Camera:release	()V
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 367	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   112: aload_0
    //   113: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   116: invokevirtual 375	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   119: return
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 90	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 375	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: goto -50 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ScannerView
    //   11	62	1	localObject1	Object
    //   120	9	1	localObject2	Object
    //   130	1	1	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   7	12	120	finally
    //   24	53	120	finally
    //   53	81	120	finally
    //   81	100	120	finally
    //   100	112	120	finally
    //   53	81	130	java/lang/RuntimeException
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
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      paramContext = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, paramContext, 2);
    }
  }
  
  public void a(String paramString)
  {
    paramString = Uri.parse("file://" + paramString);
    if (this.jdField_a_of_type_Cqy == null) {}
    try
    {
      if (this.jdField_a_of_type_Cqy == null)
      {
        this.jdField_a_of_type_Cqy = new cqy("ScannerDecodeThread");
        this.jdField_a_of_type_Cqy.start();
        this.jdField_a_of_type_AndroidOsHandler = new cqx(this, this.jdField_a_of_type_Cqy.getLooper());
      }
      if (this.jdField_a_of_type_Cqy.jdField_a_of_type_Boolean) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, paramString).sendToTarget();
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject != null) {
      try
      {
        localObject = ((Camera)localObject).getParameters();
        if (MobileIssueSettings.i)
        {
          if (!MobileIssueSettings.k) {
            return false;
          }
          if ((((Camera.Parameters)localObject).getSupportedFlashModes() == null) || (!getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash")))
          {
            boolean bool = MobileIssueSettings.l;
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
      catch (RuntimeException localRuntimeException) {}
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    boolean bool;
    if (localCamera == null) {
      bool = false;
    }
    do
    {
      return bool;
      bool = paramBoolean;
    } while (this.d == paramBoolean);
    if ((this.jdField_a_of_type_Cqv != null) && (this.jdField_a_of_type_Cqv.isAlive())) {
      this.jdField_a_of_type_Cqv.interrupt();
    }
    for (;;)
    {
      try
      {
        localParameters = localCamera.getParameters();
        str = "torch";
        if (MobileIssueSettings.j) {
          continue;
        }
        str = KapalaiAdapterUtil.a().a(localParameters);
      }
      catch (RuntimeException localRuntimeException)
      {
        Camera.Parameters localParameters;
        String str;
        paramBoolean = false;
        continue;
        if (!paramBoolean) {
          continue;
        }
        continue;
      }
      localParameters.setFlashMode(str);
      localCamera.setParameters(localParameters);
      if ((this.jdField_c_of_type_Boolean) && (("auto".equals(this.jdField_b_of_type_JavaLangString)) || ("macro".equals(this.jdField_b_of_type_JavaLangString))))
      {
        this.jdField_a_of_type_Cqv = new cqv(this, this.jdField_a_of_type_AndroidHardwareCamera);
        this.jdField_a_of_type_Cqv.start();
      }
      this.d = paramBoolean;
      return paramBoolean;
      str = "off";
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((b()) && (c()))
      {
        if (this.jdField_a_of_type_Cre != null) {
          this.jdField_a_of_type_Cre.a();
        }
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_b_of_type_Long = 0L;
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(7);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    f();
    if (this.jdField_a_of_type_Cre != null) {
      this.jdField_a_of_type_Cre.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Cqy == null) {}
    do
    {
      try
      {
        if (this.jdField_a_of_type_Cqy == null)
        {
          this.jdField_a_of_type_Cqy = new cqy("ScannerDecodeThread");
          this.jdField_a_of_type_Cqy.start();
          this.jdField_a_of_type_AndroidOsHandler = new cqx(this, this.jdField_a_of_type_Cqy.getLooper());
        }
        if (this.jdField_a_of_type_Cqy.jdField_a_of_type_Boolean) {
          return;
        }
      }
      finally {}
    } while (!this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock());
    try
    {
      Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
      if (localCamera == null) {
        return;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setOneShotPreviewCallback(this);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
    try
    {
      if ((this.jdField_a_of_type_Cqy != null) && (!this.jdField_a_of_type_Cqy.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Cqy.quit();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
    finally {}
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (this.jdField_a_of_type_Cre != null)
    {
      this.jdField_a_of_type_Cre.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      if (this.z != -1) {
        break label167;
      }
      int i1 = this.w;
      paramInt1 = paramInt3 - paramInt1 - this.x;
      paramInt3 = i1;
      if (this.A != -1) {
        break label249;
      }
      i1 = this.v;
      paramInt2 = paramInt4 - paramInt2 - this.y;
      paramInt4 = i1;
    }
    for (;;)
    {
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.jdField_c_of_type_AndroidGraphicsRect == null) {
        this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
      }
      this.jdField_c_of_type_AndroidGraphicsRect.set(paramInt3, paramInt4, paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidGraphicsRect = this.jdField_c_of_type_AndroidGraphicsRect;
      this.jdField_c_of_type_AndroidGraphicsRect = localRect;
      this.jdField_b_of_type_AndroidGraphicsRect = null;
      this.jdField_a_of_type_Cre.a(paramInt3, paramInt4, paramInt1, paramInt2);
      return;
      label167:
      if ((this.B & 0x3) == 3)
      {
        paramInt3 = this.w;
        paramInt1 = this.z + paramInt3;
        break;
      }
      if ((this.B & 0x5) == 5)
      {
        paramInt1 = paramInt3 - paramInt1 - this.x;
        paramInt3 = paramInt1 - this.z;
        break;
      }
      paramInt3 = paramInt3 - paramInt1 - this.z >> 1;
      paramInt1 = this.z + paramInt3;
      break;
      label249:
      if ((this.B & 0x30) == 48)
      {
        paramInt4 = this.v;
        paramInt2 = this.A + paramInt4;
      }
      else if ((this.B & 0x50) == 80)
      {
        paramInt2 = paramInt4 - paramInt2 - this.y;
        paramInt4 = paramInt2 - this.A;
      }
      else
      {
        paramInt4 = paramInt4 - paramInt2 - this.A >> 1;
        paramInt2 = this.A + paramInt4;
      }
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, this.n, this.o, paramArrayOfByte).sendToTarget();
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera == null) || (!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Cqv == null) || (this.e)) {
      return;
    }
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if (!this.f)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f3;
      this.f = true;
    }
    float f4 = Math.abs(this.jdField_a_of_type_Float - f1);
    float f5 = Math.abs(this.jdField_b_of_type_Float - f2);
    float f6 = Math.abs(this.jdField_c_of_type_Float - f3);
    if (((f4 > 0.5D) || (f5 > 0.5D) || (f6 > 0.5D)) && (this.g)) {}
    try
    {
      this.jdField_a_of_type_Cqv.a();
      label157:
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_c_of_type_Float = f3;
      return;
    }
    catch (RuntimeException paramSensorEvent)
    {
      break label157;
    }
  }
  
  public void setFileDecodeListener(ScannerView.FileDecodeListener paramFileDecodeListener)
  {
    e();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener = paramFileDecodeListener;
  }
  
  public void setScanListener(ScannerView.ScannerListener paramScannerListener)
  {
    e();
    this.jdField_a_of_type_ComTencentBizWidgetsScannerView$ScannerListener = paramScannerListener;
  }
  
  public void setViewFinder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    e();
    this.B = 51;
    this.w = paramInt1;
    this.v = paramInt2;
    this.z = (paramInt3 - paramInt1);
    this.A = (paramInt4 - paramInt2);
    this.x = 0;
    this.y = 0;
    if (this.jdField_a_of_type_Cre == null)
    {
      this.jdField_a_of_type_Cre = new cre(getContext());
      addView(this.jdField_a_of_type_Cre);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_Cre.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.r = paramInt2;
    this.s = paramInt3;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean) {
        break label75;
      }
      if ((!b()) || (!c())) {
        break label64;
      }
      if (this.jdField_a_of_type_Cre != null) {
        this.jdField_a_of_type_Cre.a();
      }
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(7);
    }
    label64:
    label75:
    while (c())
    {
      return;
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
      return;
    }
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView
 * JD-Core Version:    0.7.0.1
 */