import android.os.Handler;

public class ibz
  implements Runnable
{
  private static final int c = 19600;
  protected int a;
  public Handler a;
  protected String a;
  protected int b;
  
  public ibz(int paramInt1, Handler paramHandler, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 20	ibz:jdField_a_of_type_Int	I
    //   9: tableswitch	default:+23 -> 32, 2:+67->76, 3:+67->76
    //   33: getfield 22	ibz:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +37 -> 75
    //   41: invokestatic 40	android/os/Message:obtain	()Landroid/os/Message;
    //   44: astore 5
    //   46: aload 5
    //   48: iconst_0
    //   49: putfield 43	android/os/Message:what	I
    //   52: aload 5
    //   54: aload_0
    //   55: getfield 20	ibz:jdField_a_of_type_Int	I
    //   58: putfield 46	android/os/Message:arg1	I
    //   61: aload 5
    //   63: aload 4
    //   65: putfield 50	android/os/Message:obj	Ljava/lang/Object;
    //   68: aload_3
    //   69: aload 5
    //   71: invokevirtual 56	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   74: pop
    //   75: return
    //   76: aload_0
    //   77: getfield 24	ibz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifne +60 -> 143
    //   86: invokestatic 68	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   89: ifeq +181 -> 270
    //   92: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   95: lstore_1
    //   96: aload_0
    //   97: getfield 24	ibz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   100: iconst_m1
    //   101: sipush 19600
    //   104: invokestatic 79	com/tencent/mobileqq/utils/ImageUtil:b	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   107: astore_3
    //   108: invokestatic 68	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   111: ifeq +32 -> 143
    //   114: ldc 81
    //   116: iconst_4
    //   117: new 83	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   124: ldc 86
    //   126: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   132: lload_1
    //   133: lsub
    //   134: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 101	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_3
    //   144: astore 4
    //   146: aload_3
    //   147: ifnonnull -115 -> 32
    //   150: invokestatic 107	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   153: invokevirtual 113	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   156: aload_0
    //   157: getfield 26	ibz:b	I
    //   160: invokestatic 119	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   163: astore 4
    //   165: goto -133 -> 32
    //   168: astore 4
    //   170: aconst_null
    //   171: astore_3
    //   172: aload 4
    //   174: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   177: goto -34 -> 143
    //   180: astore 4
    //   182: aconst_null
    //   183: astore_3
    //   184: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +14 -> 201
    //   190: ldc 127
    //   192: iconst_2
    //   193: aload 4
    //   195: invokevirtual 128	java/lang/Throwable:toString	()Ljava/lang/String;
    //   198: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: goto -58 -> 143
    //   204: astore 5
    //   206: aload_3
    //   207: astore 4
    //   209: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq -180 -> 32
    //   215: ldc 127
    //   217: iconst_2
    //   218: aload 5
    //   220: invokevirtual 132	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   223: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_3
    //   227: astore 4
    //   229: goto -197 -> 32
    //   232: astore 5
    //   234: aload_3
    //   235: astore 4
    //   237: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq -208 -> 32
    //   243: ldc 127
    //   245: iconst_2
    //   246: aload 5
    //   248: invokevirtual 128	java/lang/Throwable:toString	()Ljava/lang/String;
    //   251: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_3
    //   255: astore 4
    //   257: goto -225 -> 32
    //   260: astore 4
    //   262: goto -78 -> 184
    //   265: astore 4
    //   267: goto -95 -> 172
    //   270: lconst_0
    //   271: lstore_1
    //   272: goto -176 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	ibz
    //   95	177	1	l	long
    //   1	254	3	localObject1	Object
    //   3	161	4	localObject2	Object
    //   168	5	4	localException1	java.lang.Exception
    //   180	14	4	localThrowable1	java.lang.Throwable
    //   207	49	4	localObject3	Object
    //   260	1	4	localThrowable2	java.lang.Throwable
    //   265	1	4	localException2	java.lang.Exception
    //   44	26	5	localMessage	android.os.Message
    //   204	15	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   232	15	5	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   86	96	168	java/lang/Exception
    //   96	108	168	java/lang/Exception
    //   86	96	180	java/lang/Throwable
    //   96	108	180	java/lang/Throwable
    //   150	165	204	java/lang/OutOfMemoryError
    //   150	165	232	java/lang/Throwable
    //   108	143	260	java/lang/Throwable
    //   108	143	265	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibz
 * JD-Core Version:    0.7.0.1
 */