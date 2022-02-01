package com.tencent.mobileqq.activity.aio;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Handler;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.mobileqq.utils.AudioUtil;
import for;

public class AudioPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  private static final float jdField_a_of_type_Float = 0.1F;
  public static final int a = -1;
  private static final long jdField_a_of_type_Long = 200L;
  public static final String a;
  public static final int b = -2;
  public static final int c = -3;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 0;
  public static final int g = 1;
  private static final int i = 1000;
  private static final int j = 1000;
  private Application jdField_a_of_type_AndroidAppApplication;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler = new for(this);
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener;
  private volatile AudioHelper.AudioPlayerParameter jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  private boolean jdField_a_of_type_Boolean = false;
  AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private volatile int h;
  
  static
  {
    jdField_a_of_type_JavaLangString = AudioPlayer.class.getSimpleName();
  }
  
  public AudioPlayer(Context paramContext, AudioPlayer.AudioPlayerListener paramAudioPlayerListener)
  {
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = paramAudioPlayerListener;
  }
  
  private AudioHelper.AudioPlayerParameter a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = AudioHelper.a();
    }
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3];
    }
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2];
    }
    AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
    if (this.c) {}
    for (int k = 0;; k = 1) {
      return arrayOfAudioPlayerParameter[k];
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      a(this.jdField_b_of_type_JavaLangString, paramInt);
    }
  }
  
  /* Error */
  private boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: putfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   14: ifnull +39 -> 53
    //   17: aload_0
    //   18: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 126	android/media/MediaPlayer:isPlaying	()Z
    //   24: ifeq +10 -> 34
    //   27: aload_0
    //   28: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   31: invokevirtual 129	android/media/MediaPlayer:stop	()V
    //   34: aload_0
    //   35: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   38: invokevirtual 132	android/media/MediaPlayer:reset	()V
    //   41: aload_0
    //   42: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   45: invokevirtual 135	android/media/MediaPlayer:release	()V
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   53: aload_0
    //   54: getfield 78	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidAppApplication	Landroid/app/Application;
    //   57: iconst_1
    //   58: invokestatic 140	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   61: pop
    //   62: aload_0
    //   63: aload_0
    //   64: invokespecial 142	com/tencent/mobileqq/activity/aio/AudioPlayer:a	()Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   67: putfield 108	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter	Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   70: aload_0
    //   71: getfield 88	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   74: aload_0
    //   75: getfield 108	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter	Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   78: getfield 146	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:jdField_a_of_type_Int	I
    //   81: invokevirtual 149	android/media/AudioManager:setMode	(I)V
    //   84: aload_0
    //   85: getfield 88	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   88: aload_0
    //   89: getfield 108	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter	Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   92: getfield 150	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:jdField_a_of_type_Boolean	Z
    //   95: invokevirtual 154	android/media/AudioManager:setSpeakerphoneOn	(Z)V
    //   98: aload_0
    //   99: new 122	android/media/MediaPlayer
    //   102: dup
    //   103: invokespecial 155	android/media/MediaPlayer:<init>	()V
    //   106: putfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   109: aload_0
    //   110: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   113: aload_0
    //   114: getfield 108	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter	Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   117: getfield 157	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:b	I
    //   120: invokevirtual 160	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   123: aload_0
    //   124: getfield 90	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   127: ifnull +20 -> 147
    //   130: aload_0
    //   131: getfield 90	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 108	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter	Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   139: getfield 157	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:b	I
    //   142: invokeinterface 165 3 0
    //   147: aload_1
    //   148: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   151: ifne +94 -> 245
    //   154: new 116	java/io/FileNotFoundException
    //   157: dup
    //   158: new 172	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   165: ldc 175
    //   167: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_1
    //   171: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokespecial 185	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   180: athrow
    //   181: astore 6
    //   183: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +29 -> 215
    //   189: getstatic 50	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   192: iconst_2
    //   193: new 172	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   200: ldc 192
    //   202: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 195	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_0
    //   216: invokevirtual 197	com/tencent/mobileqq/activity/aio/AudioPlayer:a	()V
    //   219: aload_0
    //   220: getfield 90	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   223: ifnull +14 -> 237
    //   226: aload_0
    //   227: getfield 90	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   230: aload_0
    //   231: iconst_m1
    //   232: invokeinterface 199 3 0
    //   237: iconst_0
    //   238: istore 4
    //   240: aload_0
    //   241: monitorexit
    //   242: iload 4
    //   244: ireturn
    //   245: aload_0
    //   246: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   249: aload_1
    //   250: invokevirtual 202	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   253: aload_0
    //   254: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   257: invokevirtual 205	android/media/MediaPlayer:prepare	()V
    //   260: aload_0
    //   261: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   264: invokevirtual 208	android/media/MediaPlayer:start	()V
    //   267: iload_2
    //   268: sipush 1000
    //   271: isub
    //   272: istore_2
    //   273: iload_2
    //   274: ifle +11 -> 285
    //   277: aload_0
    //   278: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   281: iload_2
    //   282: invokevirtual 211	android/media/MediaPlayer:seekTo	(I)V
    //   285: aload_0
    //   286: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   289: aload_0
    //   290: invokevirtual 215	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   293: aload_0
    //   294: getfield 120	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   297: aload_0
    //   298: invokevirtual 219	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   301: aload_0
    //   302: getfield 88	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   305: aload_0
    //   306: getfield 108	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter	Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   309: getfield 157	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:b	I
    //   312: invokevirtual 223	android/media/AudioManager:getStreamVolume	(I)I
    //   315: istore_2
    //   316: aload_0
    //   317: getfield 88	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   320: aload_0
    //   321: getfield 108	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter	Lcom/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter;
    //   324: getfield 157	com/tencent/mobileqq/utils/AudioHelper$AudioPlayerParameter:b	I
    //   327: invokevirtual 226	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   330: istore_3
    //   331: iload_2
    //   332: i2f
    //   333: iload_3
    //   334: i2f
    //   335: fdiv
    //   336: ldc 11
    //   338: fcmpg
    //   339: ifge +85 -> 424
    //   342: aload_0
    //   343: iconst_0
    //   344: putfield 93	com/tencent/mobileqq/activity/aio/AudioPlayer:h	I
    //   347: aload_0
    //   348: getfield 68	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   351: sipush 1000
    //   354: ldc2_w 15
    //   357: invokevirtual 232	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   360: pop
    //   361: iload 5
    //   363: istore 4
    //   365: aload_0
    //   366: getfield 90	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   369: ifnull -129 -> 240
    //   372: aload_0
    //   373: getfield 90	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 93	com/tencent/mobileqq/activity/aio/AudioPlayer:h	I
    //   381: invokeinterface 234 3 0
    //   386: iload 5
    //   388: istore 4
    //   390: goto -150 -> 240
    //   393: astore_1
    //   394: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +13 -> 410
    //   400: getstatic 50	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   403: iconst_2
    //   404: ldc 236
    //   406: aload_1
    //   407: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   410: aload_0
    //   411: aconst_null
    //   412: iconst_0
    //   413: iconst_0
    //   414: invokevirtual 243	com/tencent/mobileqq/activity/aio/AudioPlayer:onError	(Landroid/media/MediaPlayer;II)Z
    //   417: pop
    //   418: iconst_0
    //   419: istore 4
    //   421: goto -181 -> 240
    //   424: aload_0
    //   425: iconst_1
    //   426: putfield 93	com/tencent/mobileqq/activity/aio/AudioPlayer:h	I
    //   429: aload_0
    //   430: getfield 68	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   433: sipush 1000
    //   436: invokevirtual 246	android/os/Handler:removeMessages	(I)V
    //   439: goto -78 -> 361
    //   442: astore_1
    //   443: aload_0
    //   444: monitorexit
    //   445: aload_1
    //   446: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	this	AudioPlayer
    //   0	447	1	paramString	String
    //   0	447	2	paramInt	int
    //   330	4	3	k	int
    //   238	182	4	bool1	boolean
    //   1	386	5	bool2	boolean
    //   181	1	6	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   62	147	181	java/io/FileNotFoundException
    //   147	181	181	java/io/FileNotFoundException
    //   245	267	181	java/io/FileNotFoundException
    //   277	285	181	java/io/FileNotFoundException
    //   285	361	181	java/io/FileNotFoundException
    //   365	386	181	java/io/FileNotFoundException
    //   424	439	181	java/io/FileNotFoundException
    //   62	147	393	java/lang/Exception
    //   147	181	393	java/lang/Exception
    //   245	267	393	java/lang/Exception
    //   277	285	393	java/lang/Exception
    //   285	361	393	java/lang/Exception
    //   365	386	393	java/lang/Exception
    //   424	439	393	java/lang/Exception
    //   5	34	442	finally
    //   34	53	442	finally
    //   53	62	442	finally
    //   62	147	442	finally
    //   147	181	442	finally
    //   183	215	442	finally
    //   215	237	442	finally
    //   245	267	442	finally
    //   277	285	442	finally
    //   285	361	442	finally
    //   365	386	442	finally
    //   394	410	442	finally
    //   410	418	442	finally
    //   424	439	442	finally
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        this.jdField_b_of_type_JavaLangString = null;
        AudioUtil.a(this.jdField_a_of_type_AndroidAppApplication, false);
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
        this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (a()) {
      a(this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying());
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (!this.jdField_b_of_type_Boolean) {
        if (paramBoolean1 == this.c)
        {
          bool1 = bool2;
          if (!paramBoolean2) {}
        }
        else
        {
          this.c = paramBoolean1;
          if (a()) {
            a(0);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (a()) {
      a(this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this, -2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */