package com.tencent.matrix.hook.memory;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.e.c;
import com.tencent.matrix.hook.HookManager.b;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class GCSemiSpaceTrimmer
{
  public static final GCSemiSpaceTrimmer eUR = new GCSemiSpaceTrimmer();
  private static final Pattern eUS = Pattern.compile("[^0-9]");
  private static final long eUT = TimeUnit.MINUTES.toMillis(3L);
  public HookManager.b eUQ = null;
  private float eUU = 0.0F;
  private long eUV = eUT;
  private HandlerThread eUW = null;
  private Handler eUX = null;
  private boolean eUY = false;
  private final Runnable eUZ = new Runnable()
  {
    public final void run()
    {
      long l = GCSemiSpaceTrimmer.access$000();
      if (l < 0L)
      {
        c.e("Matrix.GCSemiSpaceTrimmer", "Fail to read vss size, skip checking this time.", new Object[0]);
        GCSemiSpaceTrimmer.b(GCSemiSpaceTrimmer.this).postDelayed(this, GCSemiSpaceTrimmer.a(GCSemiSpaceTrimmer.this));
        return;
      }
      if ((float)l > 4.294967E+009F * GCSemiSpaceTrimmer.c(GCSemiSpaceTrimmer.this))
      {
        c.i("Matrix.GCSemiSpaceTrimmer", "VmSize usage reaches above critical level, trigger native install. vmsize: %s, critical_ratio: %s", new Object[] { Long.valueOf(l), Float.valueOf(GCSemiSpaceTrimmer.c(GCSemiSpaceTrimmer.this)) });
        if (GCSemiSpaceTrimmer.d(GCSemiSpaceTrimmer.this))
        {
          c.i("Matrix.GCSemiSpaceTrimmer", "nativeInstall triggered successfully.", new Object[0]);
          return;
        }
        c.i("Matrix.GCSemiSpaceTrimmer", "Fail to trigger nativeInstall.", new Object[0]);
        return;
      }
      c.i("Matrix.GCSemiSpaceTrimmer", "VmSize usage is under critical level, check next time. vmsize: %s, critical_ratio: %s", new Object[] { Long.valueOf(l), Float.valueOf(GCSemiSpaceTrimmer.c(GCSemiSpaceTrimmer.this)) });
      GCSemiSpaceTrimmer.b(GCSemiSpaceTrimmer.this).postDelayed(this, GCSemiSpaceTrimmer.a(GCSemiSpaceTrimmer.this));
    }
  };
  private boolean mInstalled = false;
  
  private boolean axL()
  {
    for (;;)
    {
      try
      {
        if (this.eUY) {
          return true;
        }
      }
      finally {}
      try
      {
        if (this.eUQ == null) {
          break label61;
        }
        this.eUQ.loadLibrary("matrix-hookcommon");
        this.eUQ.loadLibrary("matrix-memoryhook");
        this.eUY = true;
      }
      finally
      {
        com.tencent.mm.hellhoundlib.b.a locala;
        Object localObject2;
        c.printErrStackTrace("Matrix.GCSemiSpaceTrimmer", localThrowable, "Fail to load native library.", new Object[0]);
        this.eUY = false;
        continue;
      }
      boolean bool = this.eUY;
      return bool;
      label61:
      locala = new com.tencent.mm.hellhoundlib.b.a().cG("matrix-hookcommon");
      localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, locala.aYi(), "com/tencent/matrix/hook/memory/GCSemiSpaceTrimmer", "ensureNativeLibLoaded", "()Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/matrix/hook/memory/GCSemiSpaceTrimmer", "ensureNativeLibLoaded", "()Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      locala = new com.tencent.mm.hellhoundlib.b.a().cG("matrix-memoryhook");
      localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, locala.aYi(), "com/tencent/matrix/hook/memory/GCSemiSpaceTrimmer", "ensureNativeLibLoaded", "()Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/matrix/hook/memory/GCSemiSpaceTrimmer", "ensureNativeLibLoaded", "()Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    }
  }
  
  /* Error */
  private static long axN()
  {
    // Byte code:
    //   0: new 147	java/io/BufferedReader
    //   3: dup
    //   4: new 149	java/io/InputStreamReader
    //   7: dup
    //   8: new 151	java/io/FileInputStream
    //   11: dup
    //   12: ldc 153
    //   14: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 158	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_2
    //   24: aload_2
    //   25: invokevirtual 165	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +103 -> 133
    //   33: aload_3
    //   34: invokevirtual 168	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   37: astore_3
    //   38: aload_3
    //   39: ldc 170
    //   41: invokevirtual 174	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: ifeq -20 -> 24
    //   47: getstatic 43	com/tencent/matrix/hook/memory/GCSemiSpaceTrimmer:eUS	Ljava/util/regex/Pattern;
    //   50: aload_3
    //   51: invokevirtual 178	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   54: ldc 180
    //   56: invokevirtual 186	java/util/regex/Matcher:replaceAll	(Ljava/lang/String;)Ljava/lang/String;
    //   59: invokevirtual 189	java/lang/String:trim	()Ljava/lang/String;
    //   62: invokestatic 195	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   65: lstore_0
    //   66: lload_0
    //   67: ldc2_w 196
    //   70: lmul
    //   71: lstore_0
    //   72: aload_2
    //   73: invokevirtual 200	java/io/BufferedReader:close	()V
    //   76: lload_0
    //   77: lreturn
    //   78: astore_3
    //   79: aload_3
    //   80: athrow
    //   81: astore 4
    //   83: aload_3
    //   84: ifnull +38 -> 122
    //   87: aload_2
    //   88: invokevirtual 200	java/io/BufferedReader:close	()V
    //   91: aload 4
    //   93: athrow
    //   94: astore_2
    //   95: ldc2_w 201
    //   98: lstore_0
    //   99: ldc 137
    //   101: aload_2
    //   102: ldc 204
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 145	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: lload_0
    //   112: lreturn
    //   113: astore_2
    //   114: aload_3
    //   115: aload_2
    //   116: invokevirtual 210	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   119: goto -28 -> 91
    //   122: aload_2
    //   123: invokevirtual 200	java/io/BufferedReader:close	()V
    //   126: goto -35 -> 91
    //   129: astore_2
    //   130: goto -31 -> 99
    //   133: ldc2_w 201
    //   136: lstore_0
    //   137: goto -65 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   65	72	0	l	long
    //   23	65	2	localBufferedReader	java.io.BufferedReader
    //   94	8	2	localThrowable1	Throwable
    //   113	10	2	localThrowable2	Throwable
    //   129	1	2	localObject1	Object
    //   28	23	3	str	String
    //   78	37	3	localObject2	Object
    //   81	11	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   24	29	78	finally
    //   33	66	78	finally
    //   79	81	81	finally
    //   0	24	94	finally
    //   91	94	94	finally
    //   114	119	94	finally
    //   122	126	94	finally
    //   87	91	113	finally
    //   72	76	129	finally
  }
  
  private native boolean nativeInstall();
  
  private native boolean nativeIsCompatible();
  
  public final boolean axM()
  {
    try
    {
      if (!axL()) {
        return false;
      }
      boolean bool = nativeIsCompatible();
      return bool;
    }
    finally {}
  }
  
  public final boolean dJ(long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.mInstalled)
        {
          c.e("Matrix.GCSemiSpaceTrimmer", "Already installed.", new Object[0]);
          return true;
        }
        if (!axL())
        {
          c.e("Matrix.GCSemiSpaceTrimmer", "Fail to load native library.", new Object[0]);
          return false;
        }
        this.eUU = 0.8F;
        if (paramLong > 0L)
        {
          this.eUV = paramLong;
          this.eUW = new HandlerThread("Matrix.GCSST");
          this.eUW.start();
          this.eUX = new Handler(this.eUW.getLooper());
          this.eUX.postDelayed(this.eUZ, this.eUV);
          c.i("Matrix.GCSemiSpaceTrimmer", "Installed, critcal_vmsize_ratio: %s, vmsize_sample_interval: %s", new Object[] { Float.valueOf(0.8F), Long.valueOf(paramLong) });
          return true;
        }
      }
      finally {}
      if (paramLong != 0L) {
        break;
      }
      this.eUV = eUT;
    }
    c.e("Matrix.GCSemiSpaceTrimmer", "vmsizeSampleInterval cannot less than zero. (value: " + paramLong + ")", new Object[0]);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.hook.memory.GCSemiSpaceTrimmer
 * JD-Core Version:    0.7.0.1
 */