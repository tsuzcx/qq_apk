package com.tencent.mobileqq.bubble;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import hvd;
import hve;
import hvf;
import hvg;
import hvj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@SuppressLint({"NewApi"})
public class QQAnimationDrawable
  extends Drawable
  implements Animatable, Runnable
{
  private static volatile hvg jdField_a_of_type_Hvg = new hvg(null);
  private static final String jdField_a_of_type_JavaLangString = QQAnimationDrawable.class.getSimpleName();
  public static final Executor a;
  private static final int jdField_f_of_type_Int = 0;
  private static final int jdField_g_of_type_Int = 2;
  private static final int h = 1;
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  public Bitmap a;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private QQAnimationDrawable.QQAnimationListener jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener;
  public final hvf a;
  private hvj jdField_a_of_type_Hvj;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private FutureTask jdField_a_of_type_JavaUtilConcurrentFutureTask;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int = 160;
  public Bitmap b;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private int i = 2;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newSingleThreadExecutor(new hvd());
  }
  
  public QQAnimationDrawable(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQAnimationDrawable(Context paramContext, QQAnimationDrawable.QQAnimationListener paramQQAnimationListener)
  {
    this.jdField_a_of_type_Int = -1;
    this.f = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.g = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Hvf = new hvf(this);
    this.jdField_b_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
    if (this.jdField_b_of_type_Int == 0) {}
    for (;;)
    {
      this.jdField_b_of_type_Int = m;
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener = paramQQAnimationListener;
      d();
      return;
      m = this.jdField_b_of_type_Int;
    }
  }
  
  /* Error */
  private Bitmap a(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 175	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   9: ifnull +198 -> 207
    //   12: aload_3
    //   13: astore 6
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 175	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   20: arraylength
    //   21: if_icmpge +186 -> 207
    //   24: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   27: lstore 4
    //   29: aload_0
    //   30: getfield 175	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   33: iload_2
    //   34: aaload
    //   35: astore 8
    //   37: aload_3
    //   38: astore 6
    //   40: aload 8
    //   42: ifnull +165 -> 207
    //   45: aload_0
    //   46: getfield 114	com/tencent/mobileqq/bubble/QQAnimationDrawable:f	Z
    //   49: ifeq +187 -> 236
    //   52: aload_0
    //   53: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   56: aload 8
    //   58: invokevirtual 185	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 187	java/lang/ref/SoftReference
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +24 -> 92
    //   71: aload 6
    //   73: invokevirtual 190	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   76: ifnull +16 -> 92
    //   79: aload 6
    //   81: invokevirtual 190	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   84: checkcast 192	android/graphics/Bitmap
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: aload_0
    //   93: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   96: iconst_0
    //   97: putfield 195	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   100: aload_0
    //   101: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   104: iconst_1
    //   105: putfield 198	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   108: aload_0
    //   109: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   112: sipush 320
    //   115: putfield 201	android/graphics/BitmapFactory$Options:inDensity	I
    //   118: aload_0
    //   119: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   122: aload_0
    //   123: getfield 105	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_Int	I
    //   126: putfield 204	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   129: aload 8
    //   131: ldc 206
    //   133: invokevirtual 212	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   136: ifeq +77 -> 213
    //   139: aload 8
    //   141: ldc 214
    //   143: invokevirtual 218	java/lang/String:length	()I
    //   146: invokevirtual 222	java/lang/String:substring	(I)Ljava/lang/String;
    //   149: astore 6
    //   151: aload_0
    //   152: getfield 137	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   155: invokevirtual 226	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   158: aload 6
    //   160: invokevirtual 232	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   163: astore 7
    //   165: aload 7
    //   167: new 234	android/graphics/Rect
    //   170: dup
    //   171: invokespecial 235	android/graphics/Rect:<init>	()V
    //   174: aload_0
    //   175: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   178: invokestatic 241	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   181: astore 7
    //   183: aload 7
    //   185: astore_3
    //   186: aload_0
    //   187: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   190: aload 6
    //   192: new 187	java/lang/ref/SoftReference
    //   195: dup
    //   196: aload_3
    //   197: invokespecial 244	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   200: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: aload_3
    //   205: astore 6
    //   207: aload 6
    //   209: astore_3
    //   210: goto -122 -> 88
    //   213: new 250	java/io/FileInputStream
    //   216: dup
    //   217: aload 8
    //   219: invokespecial 253	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   222: astore 7
    //   224: aload 8
    //   226: astore 6
    //   228: goto -63 -> 165
    //   231: astore 6
    //   233: goto -29 -> 204
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 255	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   241: lload 4
    //   243: aload 8
    //   245: invokespecial 258	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Landroid/graphics/Bitmap;JLjava/lang/String;)V
    //   248: aload_0
    //   249: getfield 255	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   252: astore 6
    //   254: goto -47 -> 207
    //   257: astore_3
    //   258: aload_0
    //   259: monitorexit
    //   260: aload_3
    //   261: athrow
    //   262: astore 6
    //   264: goto -60 -> 204
    //   267: astore 6
    //   269: goto -65 -> 204
    //   272: astore 6
    //   274: goto -70 -> 204
    //   277: astore 6
    //   279: goto -75 -> 204
    //   282: astore 6
    //   284: goto -80 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	QQAnimationDrawable
    //   0	287	1	paramBoolean	boolean
    //   0	287	2	paramInt	int
    //   0	287	3	paramBitmap	Bitmap
    //   27	215	4	l	long
    //   3	224	6	localObject1	Object
    //   231	1	6	localOutOfMemoryError1	OutOfMemoryError
    //   252	1	6	localBitmap	Bitmap
    //   262	1	6	localIOException1	java.io.IOException
    //   267	1	6	localIOException2	java.io.IOException
    //   272	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   277	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   282	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   163	60	7	localObject2	Object
    //   35	209	8	str	String
    // Exception table:
    //   from	to	target	type
    //   92	165	231	java/lang/OutOfMemoryError
    //   165	183	231	java/lang/OutOfMemoryError
    //   213	224	231	java/lang/OutOfMemoryError
    //   5	12	257	finally
    //   15	37	257	finally
    //   45	66	257	finally
    //   71	88	257	finally
    //   92	165	257	finally
    //   165	183	257	finally
    //   186	204	257	finally
    //   213	224	257	finally
    //   236	254	257	finally
    //   92	165	262	java/io/IOException
    //   165	183	262	java/io/IOException
    //   213	224	262	java/io/IOException
    //   186	204	267	java/io/IOException
    //   92	165	272	java/io/FileNotFoundException
    //   165	183	272	java/io/FileNotFoundException
    //   213	224	272	java/io/FileNotFoundException
    //   186	204	277	java/io/FileNotFoundException
    //   186	204	282	java/lang/OutOfMemoryError
  }
  
  private void a(Bitmap paramBitmap, long paramLong, int paramInt)
  {
    if (paramBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile OOM");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    if (QLog.isDevelopLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
    }
  }
  
  private void a(Bitmap paramBitmap, long paramLong, String paramString)
  {
    if (paramBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile " + paramString + " " + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth + "——" + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight);
      }
      Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight, Bitmap.Config.ARGB_8888);
      return;
    }
    catch (Exception paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, paramBitmap.getMessage());
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (!QLog.isDevelopLevel()) {
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile OOM");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inJustDecodeBounds = false;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = this.jdField_b_of_type_Int;
    BitmapFactory.decodeFile(paramString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    if (QLog.isDevelopLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "getBitmapFromFile " + (System.currentTimeMillis() - paramLong));
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int m = this.jdField_a_of_type_Int + 1;
    if (m >= this.jdField_c_of_type_Int) {
      m = 0;
    }
    for (;;)
    {
      if (paramBoolean2) {
        unscheduleSelf(this);
      }
      int n;
      if (((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Int <= 0)) && (m >= this.jdField_c_of_type_Int - 1))
      {
        n = 1;
        if ((n == 0) && (this.jdField_e_of_type_Boolean) && (paramBoolean3))
        {
          this.jdField_e_of_type_Boolean = false;
          if (!paramBoolean1) {
            break label158;
          }
        }
      }
      label158:
      for (long l = 0L;; l = SystemClock.uptimeMillis() + this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Hvj = new hvj(this, m, l);
        this.jdField_a_of_type_JavaUtilConcurrentFutureTask = new FutureTask(this.jdField_a_of_type_Hvj);
        jdField_a_of_type_Hvg.execute(this.jdField_a_of_type_JavaUtilConcurrentFutureTask);
        if (n != 0)
        {
          stop();
          if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener.a();
          }
        }
        return;
        n = 0;
        break;
      }
    }
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: aload_0
    //   4: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7: invokevirtual 369	java/util/ArrayList:size	()I
    //   10: if_icmpge +26 -> 36
    //   13: aload_0
    //   14: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: iload_2
    //   18: invokevirtual 372	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   21: checkcast 192	android/graphics/Bitmap
    //   24: astore 9
    //   26: aload 9
    //   28: ifnull +8 -> 36
    //   31: aload_0
    //   32: monitorexit
    //   33: aload 9
    //   35: areturn
    //   36: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   39: lstore 7
    //   41: aload_0
    //   42: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   45: iconst_1
    //   46: putfield 195	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_0
    //   50: getfield 374	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   53: aload_0
    //   54: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   57: invokestatic 324	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload_0
    //   62: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   65: getfield 268	android/graphics/BitmapFactory$Options:outWidth	I
    //   68: i2f
    //   69: aload_0
    //   70: getfield 376	com/tencent/mobileqq/bubble/QQAnimationDrawable:j	I
    //   73: i2f
    //   74: fconst_1
    //   75: fmul
    //   76: fdiv
    //   77: f2i
    //   78: istore 5
    //   80: aload_0
    //   81: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   84: getfield 271	android/graphics/BitmapFactory$Options:outHeight	I
    //   87: i2f
    //   88: aload_0
    //   89: getfield 378	com/tencent/mobileqq/bubble/QQAnimationDrawable:k	I
    //   92: i2f
    //   93: fconst_1
    //   94: fmul
    //   95: fdiv
    //   96: f2i
    //   97: istore 6
    //   99: aload_0
    //   100: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   103: iconst_0
    //   104: putfield 195	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   107: aload_0
    //   108: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   111: sipush 320
    //   114: putfield 201	android/graphics/BitmapFactory$Options:inDensity	I
    //   117: aload_0
    //   118: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   121: aload_0
    //   122: getfield 105	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_Int	I
    //   125: putfield 204	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   128: aload_0
    //   129: getfield 374	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   132: aload_0
    //   133: getfield 110	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmapFactory$Options	Landroid/graphics/BitmapFactory$Options;
    //   136: invokestatic 324	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   139: astore 9
    //   141: iconst_0
    //   142: istore_3
    //   143: iload_3
    //   144: aload_0
    //   145: getfield 378	com/tencent/mobileqq/bubble/QQAnimationDrawable:k	I
    //   148: if_icmpge +94 -> 242
    //   151: iconst_0
    //   152: istore 4
    //   154: iload 4
    //   156: aload_0
    //   157: getfield 376	com/tencent/mobileqq/bubble/QQAnimationDrawable:j	I
    //   160: if_icmpge +225 -> 385
    //   163: aload 9
    //   165: iload 4
    //   167: iload 5
    //   169: imul
    //   170: iload_3
    //   171: iload 6
    //   173: imul
    //   174: iload 5
    //   176: iload 6
    //   178: aconst_null
    //   179: iconst_1
    //   180: invokestatic 381	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   183: astore 10
    //   185: aload 10
    //   187: ifnull +189 -> 376
    //   190: invokestatic 295	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +36 -> 229
    //   196: getstatic 54	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   199: iconst_4
    //   200: new 297	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 383
    //   210: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload_3
    //   214: bipush 8
    //   216: imul
    //   217: iload 4
    //   219: iadd
    //   220: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 313	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   233: aload 10
    //   235: invokevirtual 387	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   238: pop
    //   239: goto +137 -> 376
    //   242: aload 9
    //   244: ifnull +16 -> 260
    //   247: aload 9
    //   249: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   252: ifne +8 -> 260
    //   255: aload 9
    //   257: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   265: invokevirtual 369	java/util/ArrayList:size	()I
    //   268: putfield 91	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_Int	I
    //   271: invokestatic 295	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   274: ifeq +35 -> 309
    //   277: getstatic 54	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   280: iconst_4
    //   281: new 297	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 395
    //   291: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   297: lload 7
    //   299: lsub
    //   300: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   303: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 313	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_0
    //   310: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   313: iload_2
    //   314: invokevirtual 372	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   317: checkcast 192	android/graphics/Bitmap
    //   320: astore 9
    //   322: goto -291 -> 31
    //   325: astore 9
    //   327: invokestatic 295	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   330: ifeq -21 -> 309
    //   333: getstatic 54	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   336: iconst_4
    //   337: aload 9
    //   339: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: goto -36 -> 309
    //   348: astore 9
    //   350: aload_0
    //   351: monitorexit
    //   352: aload 9
    //   354: athrow
    //   355: astore 9
    //   357: invokestatic 295	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   360: ifeq -51 -> 309
    //   363: getstatic 54	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   366: iconst_4
    //   367: ldc_w 320
    //   370: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: goto -64 -> 309
    //   376: iload 4
    //   378: iconst_1
    //   379: iadd
    //   380: istore 4
    //   382: goto -228 -> 154
    //   385: iload_3
    //   386: iconst_1
    //   387: iadd
    //   388: istore_3
    //   389: goto -246 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	QQAnimationDrawable
    //   0	392	1	paramBoolean	boolean
    //   0	392	2	paramInt	int
    //   142	247	3	m	int
    //   152	229	4	n	int
    //   78	97	5	i1	int
    //   97	80	6	i2	int
    //   39	259	7	l	long
    //   24	297	9	localBitmap1	Bitmap
    //   325	13	9	localException	Exception
    //   348	5	9	localObject	Object
    //   355	1	9	localOutOfMemoryError	OutOfMemoryError
    //   183	51	10	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   36	141	325	java/lang/Exception
    //   143	151	325	java/lang/Exception
    //   154	185	325	java/lang/Exception
    //   190	229	325	java/lang/Exception
    //   229	239	325	java/lang/Exception
    //   247	260	325	java/lang/Exception
    //   260	309	325	java/lang/Exception
    //   2	26	348	finally
    //   36	141	348	finally
    //   143	151	348	finally
    //   154	185	348	finally
    //   190	229	348	finally
    //   229	239	348	finally
    //   247	260	348	finally
    //   260	309	348	finally
    //   309	322	348	finally
    //   327	345	348	finally
    //   357	373	348	finally
    //   36	141	355	java/lang/OutOfMemoryError
    //   143	151	355	java/lang/OutOfMemoryError
    //   154	185	355	java/lang/OutOfMemoryError
    //   190	229	355	java/lang/OutOfMemoryError
    //   229	239	355	java/lang/OutOfMemoryError
    //   247	260	355	java/lang/OutOfMemoryError
    //   260	309	355	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private Bitmap b(boolean paramBoolean, int paramInt, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 397	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   9: ifnull +122 -> 131
    //   12: aload_3
    //   13: astore 6
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 397	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   20: arraylength
    //   21: if_icmpge +110 -> 131
    //   24: invokestatic 181	java/lang/System:currentTimeMillis	()J
    //   27: lstore 4
    //   29: aload_0
    //   30: getfield 397	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_ArrayOfInt	[I
    //   33: iload_2
    //   34: iaload
    //   35: istore_2
    //   36: aload_3
    //   37: astore 6
    //   39: iload_2
    //   40: ifle +91 -> 131
    //   43: aload_0
    //   44: getfield 114	com/tencent/mobileqq/bubble/QQAnimationDrawable:f	Z
    //   47: ifeq +90 -> 137
    //   50: aload_0
    //   51: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   54: iload_2
    //   55: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 185	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 187	java/lang/ref/SoftReference
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +24 -> 92
    //   71: aload 6
    //   73: invokevirtual 190	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   76: ifnull +16 -> 92
    //   79: aload 6
    //   81: invokevirtual 190	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   84: checkcast 192	android/graphics/Bitmap
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: areturn
    //   92: aload_0
    //   93: getfield 137	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   96: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   99: iload_2
    //   100: invokestatic 406	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   103: astore 6
    //   105: aload 6
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: iload_2
    //   113: invokestatic 408	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   116: new 187	java/lang/ref/SoftReference
    //   119: dup
    //   120: aload_3
    //   121: invokespecial 244	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   124: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_3
    //   129: astore 6
    //   131: aload 6
    //   133: astore_3
    //   134: goto -46 -> 88
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 255	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   142: lload 4
    //   144: iload_2
    //   145: invokespecial 410	com/tencent/mobileqq/bubble/QQAnimationDrawable:a	(Landroid/graphics/Bitmap;JI)V
    //   148: aload_0
    //   149: getfield 255	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   152: astore 6
    //   154: goto -23 -> 131
    //   157: astore_3
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_3
    //   161: athrow
    //   162: astore 6
    //   164: goto -36 -> 128
    //   167: astore 6
    //   169: goto -41 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	QQAnimationDrawable
    //   0	172	1	paramBoolean	boolean
    //   0	172	2	paramInt	int
    //   0	172	3	paramBitmap	Bitmap
    //   27	116	4	l	long
    //   3	150	6	localObject	Object
    //   162	1	6	localOutOfMemoryError1	OutOfMemoryError
    //   167	1	6	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   5	12	157	finally
    //   15	36	157	finally
    //   43	66	157	finally
    //   71	88	157	finally
    //   92	105	157	finally
    //   108	128	157	finally
    //   137	154	157	finally
    //   92	105	162	java/lang/OutOfMemoryError
    //   108	128	167	java/lang/OutOfMemoryError
  }
  
  private void d()
  {
    jdField_a_of_type_Hvg.execute(new hve(this));
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Bitmap a(boolean paramBoolean, int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (this.i == 0) {
      localBitmap1 = a(paramBoolean, paramInt, null);
    }
    for (;;)
    {
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null) {
        localBitmap2 = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
      return localBitmap2;
      if (this.i == 2) {
        localBitmap1 = b(paramBoolean, paramInt, null);
      } else if (this.i == 1) {
        localBitmap1 = b(paramBoolean, paramInt);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, " reset");
    }
    this.jdField_d_of_type_Int = 1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_d_of_type_Int > 1) {
      b(false);
    }
    for (;;)
    {
      start();
      return;
      if (this.jdField_d_of_type_Int == 1) {
        b(true);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    c();
    b(1);
    this.jdField_b_of_type_JavaLangString = paramString;
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = true;
    b(paramBoolean);
    start();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramBoolean);
      return;
    }
    a(paramInt);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    b(2);
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfInt, paramArrayOfInt))
    {
      c();
      this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    }
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ArrayOfInt.length;
      return;
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(String[] paramArrayOfString)
  {
    b(0);
    if (!Arrays.equals(this.jdField_a_of_type_ArrayOfJavaLangString, paramArrayOfString))
    {
      c();
      this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      return;
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void b()
  {
    if (jdField_a_of_type_Hvg != null) {
      jdField_a_of_type_Hvg.b();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentFutureTask != null) {
      this.jdField_a_of_type_JavaUtilConcurrentFutureTask.cancel(true);
    }
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 460	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 460	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   13: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   16: ifne +10 -> 26
    //   19: aload_0
    //   20: getfield 460	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   23: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   26: aload_0
    //   27: getfield 423	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   30: ifnull +29 -> 59
    //   33: aload_0
    //   34: getfield 423	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   37: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   40: ifne +19 -> 59
    //   43: aload_0
    //   44: getfield 135	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_1
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 423	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_c_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   54: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 255	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   63: ifnull +20 -> 83
    //   66: aload_0
    //   67: getfield 255	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   70: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   73: ifne +10 -> 83
    //   76: aload_0
    //   77: getfield 255	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   80: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   83: aload_0
    //   84: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   87: ifnull +65 -> 152
    //   90: aload_0
    //   91: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   94: invokevirtual 464	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   97: astore_1
    //   98: aload_1
    //   99: invokeinterface 469 1 0
    //   104: ifeq +41 -> 145
    //   107: aload_1
    //   108: invokeinterface 472 1 0
    //   113: checkcast 192	android/graphics/Bitmap
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull -20 -> 98
    //   121: aload_2
    //   122: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   125: ifne -27 -> 98
    //   128: aload_2
    //   129: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   132: goto -34 -> 98
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: aload_0
    //   146: getfield 119	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   149: invokevirtual 475	java/util/ArrayList:clear	()V
    //   152: aload_0
    //   153: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   156: ifnull +84 -> 240
    //   159: aload_0
    //   160: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   163: invokevirtual 479	java/util/HashMap:keySet	()Ljava/util/Set;
    //   166: invokeinterface 482 1 0
    //   171: astore_1
    //   172: aload_1
    //   173: invokeinterface 469 1 0
    //   178: ifeq +55 -> 233
    //   181: aload_1
    //   182: invokeinterface 472 1 0
    //   187: checkcast 208	java/lang/String
    //   190: astore_2
    //   191: aload_0
    //   192: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   195: aload_2
    //   196: invokevirtual 185	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: checkcast 187	java/lang/ref/SoftReference
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull -32 -> 172
    //   207: aload_2
    //   208: invokevirtual 190	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   211: checkcast 192	android/graphics/Bitmap
    //   214: astore_2
    //   215: aload_2
    //   216: ifnull -44 -> 172
    //   219: aload_2
    //   220: invokevirtual 390	android/graphics/Bitmap:isRecycled	()Z
    //   223: ifne -51 -> 172
    //   226: aload_2
    //   227: invokevirtual 393	android/graphics/Bitmap:recycle	()V
    //   230: goto -58 -> 172
    //   233: aload_0
    //   234: getfield 124	com/tencent/mobileqq/bubble/QQAnimationDrawable:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   237: invokevirtual 483	java/util/HashMap:clear	()V
    //   240: aload_0
    //   241: monitorexit
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QQAnimationDrawable
    //   135	7	1	localObject2	Object
    //   171	11	1	localIterator	java.util.Iterator
    //   116	13	2	localBitmap	Bitmap
    //   140	4	2	localObject3	Object
    //   190	37	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	135	finally
    //   26	50	135	finally
    //   59	83	135	finally
    //   83	98	135	finally
    //   98	117	135	finally
    //   121	132	135	finally
    //   143	145	135	finally
    //   145	152	135	finally
    //   152	172	135	finally
    //   172	203	135	finally
    //   207	215	135	finally
    //   219	230	135	finally
    //   233	240	135	finally
    //   50	59	140	finally
    //   141	143	140	finally
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
        paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        a(false, false, true);
        return;
      }
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledHeight(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledWidth(this.jdField_b_of_type_Int);
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Int > -1;
  }
  
  public void run()
  {
    if (!this.g) {
      return;
    }
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Int == a() - 1)) {
      this.jdField_d_of_type_Int -= 1;
    }
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    }
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable$QQAnimationListener.b();
    }
    this.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
    invalidateSelf();
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if ((bool) || (paramBoolean2)) {
        d();
      }
      return bool;
    }
    unscheduleSelf(this);
    return bool;
  }
  
  public void start()
  {
    this.g = true;
    if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_a_of_type_Long <= 0L)) {}
    while (isRunning()) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    a(true, false, true);
  }
  
  public void stop()
  {
    this.g = false;
    if (isRunning()) {
      unscheduleSelf(this);
    }
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Int = 1;
    }
    a();
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Int = -1;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */