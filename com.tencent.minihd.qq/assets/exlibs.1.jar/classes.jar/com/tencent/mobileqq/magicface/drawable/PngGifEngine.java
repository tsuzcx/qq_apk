package com.tencent.mobileqq.magicface.drawable;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import jdv;
import jdw;

public class PngGifEngine
  implements IMessageHandler
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = PngGifEngine.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable = new jdv(this);
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(10);
  private jdw jdField_a_of_type_Jdw;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = -1;
  
  public PngGifEngine()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func PngGifEngine 【Constructor】");
    }
    this.jdField_a_of_type_AndroidOsHandler = PngFrameManager.a(this);
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 77	android/graphics/BitmapFactory$Options
    //   5: dup
    //   6: invokespecial 78	android/graphics/BitmapFactory$Options:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: sipush 320
    //   14: putfield 81	android/graphics/BitmapFactory$Options:inDensity	I
    //   17: aload_2
    //   18: invokestatic 86	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 90	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   24: invokevirtual 96	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   27: getfield 101	android/util/DisplayMetrics:densityDpi	I
    //   30: putfield 104	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   33: aload_2
    //   34: getfield 81	android/graphics/BitmapFactory$Options:inDensity	I
    //   37: aload_2
    //   38: getfield 104	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   41: if_icmpge +11 -> 52
    //   44: aload_2
    //   45: aload_2
    //   46: getfield 104	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   49: putfield 81	android/graphics/BitmapFactory$Options:inDensity	I
    //   52: new 106	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: aconst_null
    //   65: aload_2
    //   66: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   69: astore_2
    //   70: aload_2
    //   71: astore_0
    //   72: aload_1
    //   73: ifnull +9 -> 82
    //   76: aload_1
    //   77: invokevirtual 120	java/io/InputStream:close	()V
    //   80: aload_2
    //   81: astore_0
    //   82: aload_0
    //   83: areturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   89: aload_2
    //   90: areturn
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: astore_0
    //   96: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +16 -> 115
    //   102: aload_1
    //   103: astore_0
    //   104: getstatic 26	com/tencent/mobileqq/magicface/drawable/PngGifEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   107: iconst_2
    //   108: aload_2
    //   109: invokevirtual 126	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   112: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_3
    //   116: astore_0
    //   117: aload_1
    //   118: ifnull -36 -> 82
    //   121: aload_1
    //   122: invokevirtual 120	java/io/InputStream:close	()V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: astore_0
    //   139: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +16 -> 158
    //   145: aload_1
    //   146: astore_0
    //   147: getstatic 26	com/tencent/mobileqq/magicface/drawable/PngGifEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   150: iconst_2
    //   151: aload_2
    //   152: invokevirtual 127	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   155: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_3
    //   159: astore_0
    //   160: aload_1
    //   161: ifnull -79 -> 82
    //   164: aload_1
    //   165: invokevirtual 120	java/io/InputStream:close	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 120	java/io/InputStream:close	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   195: goto -7 -> 188
    //   198: astore_1
    //   199: goto -19 -> 180
    //   202: astore_2
    //   203: goto -66 -> 137
    //   206: astore_2
    //   207: goto -113 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString	String
    //   60	105	1	localFileInputStream	java.io.FileInputStream
    //   177	12	1	localObject1	Object
    //   198	1	1	localObject2	Object
    //   9	81	2	localObject3	Object
    //   91	18	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   134	18	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   202	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   206	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	158	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   76	80	84	java/io/IOException
    //   52	61	91	java/io/FileNotFoundException
    //   121	125	127	java/io/IOException
    //   52	61	134	java/lang/OutOfMemoryError
    //   164	168	170	java/io/IOException
    //   52	61	177	finally
    //   184	188	190	java/io/IOException
    //   63	70	198	finally
    //   96	102	198	finally
    //   104	115	198	finally
    //   139	145	198	finally
    //   147	158	198	finally
    //   63	70	202	java/lang/OutOfMemoryError
    //   63	70	206	java/io/FileNotFoundException
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return "";
    }
    if (this.jdField_a_of_type_Jdw.jdField_a_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Jdw.jdField_a_of_type_JavaLangString;
    }
    int i = this.b + 1;
    if (i >= this.jdField_a_of_type_Jdw.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      jdw localjdw = this.jdField_a_of_type_Jdw;
      localjdw.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_Jdw.jdField_a_of_type_Int <= 0)
      {
        this.jdField_a_of_type_Boolean = true;
        return this.jdField_a_of_type_Jdw.jdField_a_of_type_JavaLangString;
      }
      this.b = -1;
      i = this.b;
      return this.jdField_a_of_type_Jdw.jdField_a_of_type_ArrayOfJavaLangString[(i + 1)];
    }
    return this.jdField_a_of_type_Jdw.jdField_a_of_type_ArrayOfJavaLangString[i];
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func PngGifEngine 【onDestroy】");
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Jdw = null;
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Jdw.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify != null) {
      this.jdField_a_of_type_Jdw.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify.a((Bitmap)paramMessage.obj);
    }
    this.b += 1;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Jdw != null) {
      this.jdField_a_of_type_Jdw.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(jdw paramjdw)
  {
    this.jdField_a_of_type_Jdw = paramjdw;
  }
  
  public boolean a()
  {
    return this.b > -1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func start.");
    }
    if (this.jdField_a_of_type_Jdw == null) {
      throw new IllegalArgumentException("【PngGifEngine】 task is null.");
    }
    if (!a()) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngGifEngine
 * JD-Core Version:    0.7.0.1
 */