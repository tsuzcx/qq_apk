package com.tencent.matrix.trace.tracer;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.app.Application;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.e.d;
import com.tencent.matrix.trace.a.b;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class SignalAnrTracer
  extends g
{
  private static String euL;
  public static boolean fgA;
  private static long fgB;
  private static String fgC;
  private static String fgD;
  private static String fgE;
  private static long fgF;
  private static long fgG;
  private static boolean fgv = false;
  private static String fgw = "";
  private static String fgx = "";
  private static a fgy;
  private static Application fgz;
  private static boolean hasInit = false;
  
  static
  {
    fgA = false;
    fgB = 0L;
    fgC = "";
    fgD = "";
    euL = "";
    fgE = "";
    fgF = 0L;
    fgG = 0L;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("trace-canary");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/trace/tracer/SignalAnrTracer", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/trace/tracer/SignalAnrTracer", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
  }
  
  public SignalAnrTracer(Application paramApplication, String paramString1, String paramString2)
  {
    fgA = true;
    fgw = paramString1;
    fgx = paramString2;
    fgz = paramApplication;
  }
  
  public SignalAnrTracer(b paramb)
  {
    fgA = true;
    fgw = paramb.fdQ;
    fgx = paramb.fdR;
  }
  
  public static void a(a parama)
  {
    fgy = parama;
  }
  
  /* Error */
  private static String azW()
  {
    // Byte code:
    //   0: new 124	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   7: astore_0
    //   8: new 127	java/io/BufferedReader
    //   11: dup
    //   12: new 129	java/io/InputStreamReader
    //   15: dup
    //   16: new 131	java/io/FileInputStream
    //   19: dup
    //   20: ldc 133
    //   22: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 138	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   28: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +37 -> 75
    //   41: aload_0
    //   42: aload_2
    //   43: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 150
    //   48: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: goto -20 -> 32
    //   55: astore_2
    //   56: aload_2
    //   57: athrow
    //   58: astore_3
    //   59: aload_2
    //   60: ifnull +31 -> 91
    //   63: aload_1
    //   64: invokevirtual 153	java/io/BufferedReader:close	()V
    //   67: aload_3
    //   68: athrow
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: areturn
    //   75: aload_1
    //   76: invokevirtual 153	java/io/BufferedReader:close	()V
    //   79: goto -9 -> 70
    //   82: astore_1
    //   83: aload_2
    //   84: aload_1
    //   85: invokevirtual 162	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   88: goto -21 -> 67
    //   91: aload_1
    //   92: invokevirtual 153	java/io/BufferedReader:close	()V
    //   95: goto -28 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	64	0	localStringBuilder	java.lang.StringBuilder
    //   31	33	1	localBufferedReader	java.io.BufferedReader
    //   69	7	1	localObject1	Object
    //   82	10	1	localThrowable	Throwable
    //   36	7	2	str	String
    //   55	29	2	localObject2	Object
    //   58	10	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	37	55	finally
    //   41	52	55	finally
    //   56	58	58	finally
    //   8	32	69	finally
    //   67	69	69	finally
    //   75	79	69	finally
    //   83	88	69	finally
    //   91	95	69	finally
    //   63	67	82	finally
  }
  
  private static boolean azX()
  {
    long l1;
    long l2;
    try
    {
      Object localObject = Looper.getMainLooper().getQueue();
      Field localField = localObject.getClass().getDeclaredField("mMessages");
      localField.setAccessible(true);
      localObject = (Message)localField.get(localObject);
      if (localObject != null)
      {
        fgC = ((Message)localObject).toString();
        com.tencent.matrix.e.c.i("SignalAnrTracer", "anrMessageString = " + fgC, new Object[0]);
        l1 = ((Message)localObject).getWhen();
        if (l1 == 0L) {
          return false;
        }
        l2 = l1 - SystemClock.uptimeMillis();
        fgB = l2;
        l1 = -10000L;
        if (fgv) {
          l1 = -2000L;
        }
      }
      else
      {
        com.tencent.matrix.e.c.i("SignalAnrTracer", "mMessage is null", new Object[0]);
        return false;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return l2 < l1;
  }
  
  private static boolean azY()
  {
    try
    {
      com.tencent.matrix.e.c.i("SignalAnrTracer", "[checkErrorState] start", new Object[0]);
      if (fgz == null) {}
      for (Object localObject1 = com.tencent.matrix.c.avW().application;; localObject1 = fgz)
      {
        localObject1 = ((ActivityManager)((Application)localObject1).getSystemService("activity")).getProcessesInErrorState();
        if (localObject1 != null) {
          break;
        }
        com.tencent.matrix.e.c.i("SignalAnrTracer", "[checkErrorState] procs == null", new Object[0]);
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject1).next();
        com.tencent.matrix.e.c.i("SignalAnrTracer", "[checkErrorState] found Error State proccessName = %s, proc.condition = %d", new Object[] { localProcessErrorStateInfo.processName, Integer.valueOf(localProcessErrorStateInfo.condition) });
        if ((localProcessErrorStateInfo.uid != Process.myUid()) && (localProcessErrorStateInfo.condition == 2))
        {
          com.tencent.matrix.e.c.i("SignalAnrTracer", "maybe received other apps ANR signal", new Object[0]);
          return false;
        }
        if ((localProcessErrorStateInfo.pid == Process.myPid()) && (localProcessErrorStateInfo.condition == 2))
        {
          com.tencent.matrix.e.c.i("SignalAnrTracer", "error sate longMsg = %s", new Object[] { localProcessErrorStateInfo.longMsg });
          return true;
        }
      }
      return false;
    }
    finally
    {
      com.tencent.matrix.e.c.e("SignalAnrTracer", "[checkErrorState] error : %s", new Object[] { localObject2.getMessage() });
    }
    return false;
  }
  
  public static void azZ()
  {
    if (!fgA)
    {
      com.tencent.matrix.e.c.e("SignalAnrTracer", "SignalAnrTracer has not been initialize", new Object[0]);
      return;
    }
    if (fgx.equals(""))
    {
      com.tencent.matrix.e.c.e("SignalAnrTracer", "PrintTraceFilePath has not been set", new Object[0]);
      return;
    }
    nativePrintTrace();
  }
  
  private static void dM(boolean paramBoolean)
  {
    com.tencent.matrix.e.c.i("SignalAnrTracer", "confirmRealAnr, isSigQuit = ".concat(String.valueOf(paramBoolean)), new Object[0]);
    if (azX())
    {
      q(false, paramBoolean);
      return;
    }
    new Thread(new Runnable()
    {
      public final void run()
      {
        SignalAnrTracer.dN(this.fgH);
      }
    }, "Check-ANR-State-Thread").start();
  }
  
  private static native void nativeFreeSignalAnrDetective();
  
  private static native void nativeInitSignalAnrDetective(String paramString1, String paramString2);
  
  private static native void nativePrintTrace();
  
  private static void onANRDumpTrace()
  {
    try
    {
      d.Y("SignalAnrTracer", fgw);
      return;
    }
    finally
    {
      com.tencent.matrix.e.c.e("SignalAnrTracer", "onANRDumpTrace error: %s", new Object[] { localObject.getMessage() });
    }
  }
  
  private static void onANRDumped()
  {
    try
    {
      fgG = System.currentTimeMillis();
      com.tencent.matrix.e.c.i("SignalAnrTracer", "onANRDumped", new Object[0]);
      euL = com.tencent.matrix.trace.f.c.aAf();
      com.tencent.matrix.e.c.i("SignalAnrTracer", "onANRDumped, stackTrace = %s, duration = %d", new Object[] { euL, Long.valueOf(System.currentTimeMillis() - fgG) });
      fgD = azW();
      com.tencent.matrix.e.c.i("SignalAnrTracer", "onANRDumped, read cgroup duration = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - fgG) });
      fgv = com.tencent.matrix.trace.f.a.aAc();
      com.tencent.matrix.e.c.i("SignalAnrTracer", "onANRDumped, isInterestingToUser duration = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - fgG) });
      dM(true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void onNativeBacktraceDumped()
  {
    com.tencent.matrix.e.c.i("SignalAnrTracer", "happens onNativeBacktraceDumped", new Object[0]);
    if (System.currentTimeMillis() - fgF < 20000L)
    {
      com.tencent.matrix.e.c.i("SignalAnrTracer", "report SIGQUIT recently, just return", new Object[0]);
      return;
    }
    fgE = com.tencent.matrix.trace.f.c.aAf();
    com.tencent.matrix.e.c.i("SignalAnrTracer", "happens onNativeBacktraceDumped, mainThreadStackTrace = " + euL, new Object[0]);
    dM(false);
  }
  
  private static void onPrintTrace()
  {
    try
    {
      d.Y("SignalAnrTracer", fgx);
      return;
    }
    finally
    {
      com.tencent.matrix.e.c.e("SignalAnrTracer", "onPrintTrace error: %s", new Object[] { localObject.getMessage() });
    }
  }
  
  /* Error */
  private static void q(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: getstatic 120	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgy	Lcom/tencent/matrix/trace/tracer/SignalAnrTracer$a;
    //   3: ifnull +80 -> 83
    //   6: iload_1
    //   7: ifeq +31 -> 38
    //   10: getstatic 120	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgy	Lcom/tencent/matrix/trace/tracer/SignalAnrTracer$a;
    //   13: getstatic 50	com/tencent/matrix/trace/tracer/SignalAnrTracer:euL	Ljava/lang/String;
    //   16: getstatic 46	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgC	Ljava/lang/String;
    //   19: getstatic 44	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgB	J
    //   22: iload_0
    //   23: getstatic 48	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgD	Ljava/lang/String;
    //   26: invokeinterface 426 7 0
    //   31: invokestatic 383	java/lang/System:currentTimeMillis	()J
    //   34: putstatic 54	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgF	J
    //   37: return
    //   38: getstatic 120	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgy	Lcom/tencent/matrix/trace/tracer/SignalAnrTracer$a;
    //   41: getstatic 52	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgE	Ljava/lang/String;
    //   44: getstatic 46	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgC	Ljava/lang/String;
    //   47: getstatic 44	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgB	J
    //   50: iload_0
    //   51: invokeinterface 429 6 0
    //   56: goto -25 -> 31
    //   59: astore_2
    //   60: ldc 203
    //   62: ldc_w 431
    //   65: iconst_1
    //   66: anewarray 69	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_2
    //   72: aastore
    //   73: invokestatic 317	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: invokestatic 383	java/lang/System:currentTimeMillis	()J
    //   79: putstatic 54	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgF	J
    //   82: return
    //   83: invokestatic 236	com/tencent/matrix/c:avW	()Lcom/tencent/matrix/c;
    //   86: ldc_w 433
    //   89: invokevirtual 437	com/tencent/matrix/c:ai	(Ljava/lang/Class;)Lcom/tencent/matrix/d/b;
    //   92: checkcast 433	com/tencent/matrix/trace/b
    //   95: astore_2
    //   96: aload_2
    //   97: ifnonnull +10 -> 107
    //   100: invokestatic 383	java/lang/System:currentTimeMillis	()J
    //   103: putstatic 54	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgF	J
    //   106: return
    //   107: getstatic 443	com/tencent/matrix/a:eLw	Lcom/tencent/matrix/a;
    //   110: getfield 446	com/tencent/matrix/a:eLy	Ljava/lang/String;
    //   113: astore 4
    //   115: new 448	org/json/JSONObject
    //   118: dup
    //   119: invokespecial 449	org/json/JSONObject:<init>	()V
    //   122: invokestatic 236	com/tencent/matrix/c:avW	()Lcom/tencent/matrix/c;
    //   125: getfield 239	com/tencent/matrix/c:application	Landroid/app/Application;
    //   128: invokestatic 454	com/tencent/matrix/e/a:a	(Lorg/json/JSONObject;Landroid/app/Application;)Lorg/json/JSONObject;
    //   131: astore_3
    //   132: iload_1
    //   133: ifeq +101 -> 234
    //   136: aload_3
    //   137: ldc_w 456
    //   140: getstatic 462	com/tencent/matrix/trace/b/a$a:fdZ	Lcom/tencent/matrix/trace/b/a$a;
    //   143: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload_3
    //   148: ldc_w 468
    //   151: getstatic 50	com/tencent/matrix/trace/tracer/SignalAnrTracer:euL	Ljava/lang/String;
    //   154: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload_3
    //   159: ldc_w 470
    //   162: aload 4
    //   164: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   167: pop
    //   168: aload_3
    //   169: ldc_w 472
    //   172: getstatic 32	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgv	Z
    //   175: invokevirtual 475	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   178: pop
    //   179: new 477	com/tencent/matrix/report/g
    //   182: dup
    //   183: invokespecial 478	com/tencent/matrix/report/g:<init>	()V
    //   186: astore 4
    //   188: aload 4
    //   190: ldc_w 480
    //   193: putfield 483	com/tencent/matrix/report/g:tag	Ljava/lang/String;
    //   196: aload 4
    //   198: aload_3
    //   199: putfield 487	com/tencent/matrix/report/g:eYz	Lorg/json/JSONObject;
    //   202: aload_2
    //   203: aload 4
    //   205: invokevirtual 491	com/tencent/matrix/trace/b:onDetectIssue	(Lcom/tencent/matrix/report/g;)V
    //   208: ldc 203
    //   210: ldc_w 493
    //   213: iconst_1
    //   214: anewarray 69	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload_3
    //   220: invokevirtual 494	org/json/JSONObject:toString	()Ljava/lang/String;
    //   223: aastore
    //   224: invokestatic 317	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: invokestatic 383	java/lang/System:currentTimeMillis	()J
    //   230: putstatic 54	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgF	J
    //   233: return
    //   234: aload_3
    //   235: ldc_w 456
    //   238: getstatic 497	com/tencent/matrix/trace/b/a$a:fea	Lcom/tencent/matrix/trace/b/a$a;
    //   241: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload_3
    //   246: ldc_w 468
    //   249: getstatic 52	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgE	Ljava/lang/String;
    //   252: invokevirtual 466	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: goto -98 -> 158
    //   259: astore_2
    //   260: invokestatic 383	java/lang/System:currentTimeMillis	()J
    //   263: putstatic 54	com/tencent/matrix/trace/tracer/SignalAnrTracer:fgF	J
    //   266: aload_2
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramBoolean1	boolean
    //   0	268	1	paramBoolean2	boolean
    //   59	13	2	localJSONException	org.json.JSONException
    //   95	108	2	localb	com.tencent.matrix.trace.b
    //   259	8	2	localObject1	Object
    //   131	115	3	localJSONObject	org.json.JSONObject
    //   113	91	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	59	org/json/JSONException
    //   10	31	59	org/json/JSONException
    //   38	56	59	org/json/JSONException
    //   83	96	59	org/json/JSONException
    //   107	132	59	org/json/JSONException
    //   136	158	59	org/json/JSONException
    //   158	227	59	org/json/JSONException
    //   234	256	59	org/json/JSONException
    //   0	6	259	finally
    //   10	31	259	finally
    //   38	56	259	finally
    //   60	76	259	finally
    //   83	96	259	finally
    //   107	132	259	finally
    //   136	158	259	finally
    //   158	227	259	finally
    //   234	256	259	finally
  }
  
  protected final void onAlive()
  {
    super.onAlive();
    if (!hasInit)
    {
      nativeInitSignalAnrDetective(fgw, fgx);
      com.tencent.matrix.trace.f.a locala = com.tencent.matrix.trace.f.a.fhb;
      if (!locala.isInit) {
        locala.isInit = true;
      }
      hasInit = true;
    }
  }
  
  protected final void onDead()
  {
    super.onDead();
    nativeFreeSignalAnrDetective();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean);
    
    public abstract void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.SignalAnrTracer
 * JD-Core Version:    0.7.0.1
 */