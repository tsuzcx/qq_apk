package com.tencent.mqq.shared_file_accessor.a;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
{
  private static final String a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/sp";
  private static volatile a b = null;
  private StringBuilder c = new StringBuilder(32768);
  private HandlerThread d = null;
  private Handler e = null;
  private String f = null;
  private FileWriter g = null;
  
  private a()
  {
    this.d.start();
    this.e = new b(this, this.d.getLooper());
    Object localObject = new Date();
    localObject = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format((Date)localObject);
    this.f = ("sp_rw_" + (String)localObject);
    try
    {
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      this.g = new FileWriter(a + "/" + this.f + ".csv");
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static a a()
  {
    if (b != null) {
      return b;
    }
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  public final void a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: arraylength
    //   6: istore_3
    //   7: iload_2
    //   8: iload_3
    //   9: iconst_1
    //   10: isub
    //   11: if_icmplt +89 -> 100
    //   14: aload_0
    //   15: getfield 67	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: aload_1
    //   20: arraylength
    //   21: iconst_1
    //   22: isub
    //   23: aaload
    //   24: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: bipush 10
    //   29: invokevirtual 134	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_0
    //   34: getfield 67	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   37: invokevirtual 138	java/lang/StringBuilder:length	()I
    //   40: ldc 62
    //   42: if_icmple +81 -> 123
    //   45: aload_0
    //   46: getfield 67	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   49: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 71	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   57: iconst_1
    //   58: invokevirtual 144	android/os/Handler:hasMessages	(I)Z
    //   61: ifeq +11 -> 72
    //   64: aload_0
    //   65: getfield 71	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   68: iconst_1
    //   69: invokevirtual 147	android/os/Handler:removeMessages	(I)V
    //   72: aload_0
    //   73: getfield 71	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   76: aload_0
    //   77: getfield 71	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   80: iconst_0
    //   81: aload_1
    //   82: invokestatic 153	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   85: invokevirtual 157	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   88: pop
    //   89: aload_0
    //   90: getfield 67	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   93: iconst_0
    //   94: invokevirtual 160	java/lang/StringBuilder:setLength	(I)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: aload_0
    //   101: getfield 67	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: iload_2
    //   106: aaload
    //   107: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: bipush 9
    //   112: invokevirtual 134	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: iload_2
    //   117: iconst_1
    //   118: iadd
    //   119: istore_2
    //   120: goto -113 -> 7
    //   123: aload_0
    //   124: getfield 71	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   127: iconst_1
    //   128: invokevirtual 144	android/os/Handler:hasMessages	(I)Z
    //   131: ifne -34 -> 97
    //   134: aload_0
    //   135: getfield 71	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   138: iconst_1
    //   139: ldc2_w 161
    //   142: invokevirtual 166	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   145: pop
    //   146: goto -49 -> 97
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	a
    //   0	154	1	paramArrayOfString	String[]
    //   1	119	2	i	int
    //   6	5	3	j	int
    // Exception table:
    //   from	to	target	type
    //   4	7	149	finally
    //   14	72	149	finally
    //   72	97	149	finally
    //   100	116	149	finally
    //   123	146	149	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.a.a
 * JD-Core Version:    0.7.0.1
 */