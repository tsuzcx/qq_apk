package com.tencent.qav.bussiness;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Vibrator;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.PhoneStatusTools;

public class RingtoneHelper
{
  private static int jdField_a_of_type_Int = 0;
  private static MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
  private static MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private static final String jdField_a_of_type_JavaLangString = "RingtoneHelper";
  private static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 1500L, 1500L, 1500L, 1500L };
  
  public static void a()
  {
    try
    {
      AVLog.d("RingtoneHelper", "stopRing");
      c();
      jdField_a_of_type_Int = 0;
      jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext = (Vibrator)paramContext.getSystemService("vibrator");
      if (paramContext != null) {
        paramContext.cancel();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +35 -> 39
    //   7: aload_0
    //   8: invokestatic 63	com/tencent/qav/bussiness/RingtoneHelper:a	(Landroid/content/Context;)Z
    //   11: ifeq +28 -> 39
    //   14: aload_0
    //   15: ldc 48
    //   17: invokevirtual 54	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 56	android/os/Vibrator
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull +14 -> 39
    //   28: iload_1
    //   29: ifeq +14 -> 43
    //   32: aload_0
    //   33: ldc2_w 64
    //   36: invokevirtual 69	android/os/Vibrator:vibrate	(J)V
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: getstatic 21	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_ArrayOfLong	[J
    //   47: iconst_1
    //   48: invokevirtual 72	android/os/Vibrator:vibrate	([JI)V
    //   51: goto -12 -> 39
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramContext	Context
    //   0	60	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   7	24	54	finally
    //   32	39	54	finally
    //   43	51	54	finally
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = true;
    if ((AudioUtil.a() == 0) || (PhoneStatusTools.e(paramContext))) {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: ldc 12
    //   8: ldc 86
    //   10: iconst_3
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: iload_1
    //   17: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: iload_2
    //   24: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: aload_3
    //   31: aastore
    //   32: invokestatic 98	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokestatic 42	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: ifnull +242 -> 281
    //   42: aload_0
    //   43: invokestatic 101	com/tencent/qav/bussiness/RingtoneHelper:b	(Landroid/content/Context;)Z
    //   46: istore 5
    //   48: iload 5
    //   50: ifeq +231 -> 281
    //   53: aconst_null
    //   54: astore 6
    //   56: iload_2
    //   57: putstatic 28	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_Int	I
    //   60: aload_3
    //   61: putstatic 31	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener	Landroid/media/MediaPlayer$OnCompletionListener;
    //   64: aload_0
    //   65: invokevirtual 105	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   68: iload_1
    //   69: invokevirtual 111	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   72: astore_3
    //   73: iload_2
    //   74: ifge +103 -> 177
    //   77: iconst_1
    //   78: istore 4
    //   80: getstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   83: ifnonnull +39 -> 122
    //   86: new 113	android/media/MediaPlayer
    //   89: dup
    //   90: invokespecial 114	android/media/MediaPlayer:<init>	()V
    //   93: putstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   96: getstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   99: new 116	ljb
    //   102: dup
    //   103: invokespecial 117	ljb:<init>	()V
    //   106: invokevirtual 121	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   109: getstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   112: new 123	ljc
    //   115: dup
    //   116: invokespecial 124	ljc:<init>	()V
    //   119: invokevirtual 128	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   122: getstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   125: aload_3
    //   126: invokevirtual 134	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   129: aload_3
    //   130: invokevirtual 138	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   133: aload_3
    //   134: invokevirtual 141	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   137: invokevirtual 145	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   140: getstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   143: invokevirtual 148	android/media/MediaPlayer:prepare	()V
    //   146: getstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   149: iload 4
    //   151: invokevirtual 152	android/media/MediaPlayer:setLooping	(Z)V
    //   154: getstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   157: invokevirtual 155	android/media/MediaPlayer:start	()V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 158	android/content/res/AssetFileDescriptor:close	()V
    //   168: iconst_1
    //   169: istore 4
    //   171: ldc 2
    //   173: monitorexit
    //   174: iload 4
    //   176: ireturn
    //   177: iconst_0
    //   178: istore 4
    //   180: goto -100 -> 80
    //   183: astore_0
    //   184: ldc 12
    //   186: ldc 160
    //   188: aload_0
    //   189: invokestatic 163	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: goto -24 -> 168
    //   195: astore_0
    //   196: ldc 2
    //   198: monitorexit
    //   199: aload_0
    //   200: athrow
    //   201: astore_3
    //   202: aload 6
    //   204: astore_0
    //   205: ldc 12
    //   207: ldc 160
    //   209: aload_3
    //   210: invokestatic 163	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: getstatic 31	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener	Landroid/media/MediaPlayer$OnCompletionListener;
    //   216: ifnull +17 -> 233
    //   219: invokestatic 45	com/tencent/qav/bussiness/RingtoneHelper:c	()V
    //   222: getstatic 31	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener	Landroid/media/MediaPlayer$OnCompletionListener;
    //   225: getstatic 34	com/tencent/qav/bussiness/RingtoneHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   228: invokeinterface 169 2 0
    //   233: aload_0
    //   234: ifnull -66 -> 168
    //   237: aload_0
    //   238: invokevirtual 158	android/content/res/AssetFileDescriptor:close	()V
    //   241: goto -73 -> 168
    //   244: astore_0
    //   245: ldc 12
    //   247: ldc 160
    //   249: aload_0
    //   250: invokestatic 163	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: goto -85 -> 168
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_3
    //   259: aload_3
    //   260: ifnull +7 -> 267
    //   263: aload_3
    //   264: invokevirtual 158	android/content/res/AssetFileDescriptor:close	()V
    //   267: aload_0
    //   268: athrow
    //   269: astore_3
    //   270: ldc 12
    //   272: ldc 160
    //   274: aload_3
    //   275: invokestatic 163	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: goto -11 -> 267
    //   281: ldc 12
    //   283: ldc 171
    //   285: invokestatic 173	com/tencent/qav/log/AVLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -117 -> 171
    //   291: astore_0
    //   292: goto -33 -> 259
    //   295: astore 6
    //   297: aload_0
    //   298: astore_3
    //   299: aload 6
    //   301: astore_0
    //   302: goto -43 -> 259
    //   305: astore 6
    //   307: aload_3
    //   308: astore_0
    //   309: aload 6
    //   311: astore_3
    //   312: goto -107 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramContext	Context
    //   0	315	1	paramInt1	int
    //   0	315	2	paramInt2	int
    //   0	315	3	paramOnCompletionListener	MediaPlayer.OnCompletionListener
    //   1	178	4	bool1	boolean
    //   46	3	5	bool2	boolean
    //   54	149	6	localObject1	Object
    //   295	5	6	localObject2	Object
    //   305	5	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   164	168	183	java/lang/Exception
    //   6	38	195	finally
    //   42	48	195	finally
    //   164	168	195	finally
    //   184	192	195	finally
    //   237	241	195	finally
    //   245	253	195	finally
    //   263	267	195	finally
    //   267	269	195	finally
    //   270	278	195	finally
    //   281	288	195	finally
    //   56	73	201	java/lang/Exception
    //   237	241	244	java/lang/Exception
    //   56	73	256	finally
    //   263	267	269	java/lang/Exception
    //   80	122	291	finally
    //   122	160	291	finally
    //   205	233	295	finally
    //   80	122	305	java/lang/Exception
    //   122	160	305	java/lang/Exception
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool = true;
    int i = AudioUtil.a();
    if ((i == 0) || (i == 1) || (PhoneStatusTools.d(paramContext)) || (PhoneStatusTools.e(paramContext))) {
      bool = false;
    }
    return bool;
  }
  
  private static void c()
  {
    if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.bussiness.RingtoneHelper
 * JD-Core Version:    0.7.0.1
 */