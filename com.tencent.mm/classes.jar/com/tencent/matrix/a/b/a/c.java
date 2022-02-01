package com.tencent.matrix.a.b.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.c.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  int cSF = 1024;
  int cSG = 1024;
  int cSH = 100;
  List<c> cSI = Collections.emptyList();
  List<h.a> cSJ = Collections.emptyList();
  Runnable cSK = new Runnable()
  {
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/tencent/matrix/a/b/a/c$1:cSL	Lcom/tencent/matrix/a/b/a/c;
      //   4: getfield 23	com/tencent/matrix/a/b/a/c:cSI	Ljava/util/List;
      //   7: invokeinterface 29 1 0
      //   12: aload_0
      //   13: getfield 14	com/tencent/matrix/a/b/a/c$1:cSL	Lcom/tencent/matrix/a/b/a/c;
      //   16: getfield 33	com/tencent/matrix/a/b/a/c:cSq	Lcom/tencent/matrix/a/b/c;
      //   19: getfield 39	com/tencent/matrix/a/b/c:cSe	Lcom/tencent/matrix/a/b/b;
      //   22: getfield 45	com/tencent/matrix/a/b/b:cRQ	I
      //   25: if_icmplt +19 -> 44
      //   28: ldc 47
      //   30: monitorenter
      //   31: aload_0
      //   32: getfield 14	com/tencent/matrix/a/b/a/c$1:cSL	Lcom/tencent/matrix/a/b/a/c;
      //   35: getfield 23	com/tencent/matrix/a/b/a/c:cSI	Ljava/util/List;
      //   38: invokestatic 53	com/tencent/matrix/a/c/h:K	(Ljava/util/List;)V
      //   41: ldc 47
      //   43: monitorexit
      //   44: aload_0
      //   45: getfield 14	com/tencent/matrix/a/b/a/c$1:cSL	Lcom/tencent/matrix/a/b/a/c;
      //   48: getfield 56	com/tencent/matrix/a/b/a/c:cSJ	Ljava/util/List;
      //   51: invokeinterface 29 1 0
      //   56: aload_0
      //   57: getfield 14	com/tencent/matrix/a/b/a/c$1:cSL	Lcom/tencent/matrix/a/b/a/c;
      //   60: getfield 33	com/tencent/matrix/a/b/a/c:cSq	Lcom/tencent/matrix/a/b/c;
      //   63: getfield 39	com/tencent/matrix/a/b/c:cSe	Lcom/tencent/matrix/a/b/b;
      //   66: getfield 45	com/tencent/matrix/a/b/b:cRQ	I
      //   69: if_icmplt +19 -> 88
      //   72: ldc 47
      //   74: monitorenter
      //   75: aload_0
      //   76: getfield 14	com/tencent/matrix/a/b/a/c$1:cSL	Lcom/tencent/matrix/a/b/a/c;
      //   79: getfield 56	com/tencent/matrix/a/b/a/c:cSJ	Ljava/util/List;
      //   82: invokestatic 53	com/tencent/matrix/a/c/h:K	(Ljava/util/List;)V
      //   85: ldc 47
      //   87: monitorexit
      //   88: return
      //   89: astore_1
      //   90: ldc 47
      //   92: monitorexit
      //   93: aload_1
      //   94: athrow
      //   95: astore_1
      //   96: ldc 47
      //   98: monitorexit
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	1
      //   89	5	1	localObject1	Object
      //   95	5	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   31	44	89	finally
      //   90	93	89	finally
      //   75	88	95	finally
      //   96	99	95	finally
    }
  };
  
  private void Sj()
  {
    this.cSq.mHandler.removeCallbacks(this.cSK);
    this.cSq.mHandler.postDelayed(this.cSK, 1000L);
  }
  
  private void Sk()
  {
    if ((this.cSF <= this.cSH) && (this.cSG <= this.cSH)) {
      return;
    }
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        Context localContext = com.tencent.matrix.a.b.c.getContext();
        String str = localContext.getPackageName();
        if (str.contains(":")) {
          str = str.substring(0, str.indexOf(":"));
        }
        for (;;)
        {
          Object localObject = (ActivityManager)localContext.getSystemService("activity");
          if (localObject == null) {}
          for (;;)
          {
            return;
            localObject = ((ActivityManager)localObject).getRunningAppProcesses();
            if (localObject != null)
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
                if (localRunningAppProcessInfo.processName.startsWith(str))
                {
                  if (c.this.cSG > localRunningAppProcessInfo.importance)
                  {
                    com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "update global importance: " + c.this.cSG + " > " + localRunningAppProcessInfo.importance + ", reason = " + localRunningAppProcessInfo.importanceReasonComponent, new Object[0]);
                    c.this.cSG = localRunningAppProcessInfo.importance;
                  }
                  if ((localRunningAppProcessInfo.processName.equals(localContext.getPackageName())) && (c.this.cSF > localRunningAppProcessInfo.importance))
                  {
                    com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "update app importance: " + c.this.cSF + " > " + localRunningAppProcessInfo.importance + ", reason = " + localRunningAppProcessInfo.importanceReasonComponent, new Object[0]);
                    c.this.cSF = localRunningAppProcessInfo.importance;
                  }
                }
              }
            }
          }
        }
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.cSq.mHandler.post(local2);
      return;
    }
    local2.run();
  }
  
  public final void Se()
  {
    super.Se();
    c localc = new c(1);
    h.a locala = new h.a(this.cSq.getScene());
    try
    {
      this.cSI = new ArrayList();
      this.cSI.add(0, localc);
      this.cSJ = new ArrayList();
      this.cSJ.add(0, locala);
      return;
    }
    finally {}
  }
  
  public final void Sf()
  {
    super.Sf();
    try
    {
      this.cSI.clear();
      this.cSJ.clear();
      return;
    }
    finally {}
  }
  
  public final int Sg()
  {
    return 2147483647;
  }
  
  public final void ba(long paramLong)
  {
    super.ba(paramLong);
    com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "#onBackgroundCheck, during = ".concat(String.valueOf(paramLong)), new Object[0]);
    Context localContext;
    Object localObject;
    if ((this.cSG > this.cSH) || (this.cSF > this.cSH))
    {
      localContext = com.tencent.matrix.a.b.c.getContext();
      localObject = (ActivityManager)localContext.getSystemService("activity");
      if (localObject != null) {
        break label66;
      }
    }
    for (;;)
    {
      return;
      label66:
      localObject = ((ActivityManager)localObject).getRunningServices(2147483647);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localRunningServiceInfo.process)) && (localRunningServiceInfo.process.startsWith(localContext.getPackageName())) && (localRunningServiceInfo.foreground))
          {
            com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "checkForegroundService whether app importance is low, during = ".concat(String.valueOf(paramLong)), new Object[0]);
            if (this.cSG > this.cSH)
            {
              com.tencent.matrix.g.c.w("Matrix.battery.AppStatMonitorFeature", "foreground service detected with low global importance: " + this.cSF + ", " + this.cSG + ", " + localRunningServiceInfo.service, new Object[0]);
              this.cSq.a(false, this.cSF, this.cSG, localRunningServiceInfo.service, paramLong);
            }
            if ((this.cSF > this.cSH) && (localRunningServiceInfo.process.equals(localContext.getPackageName())))
            {
              com.tencent.matrix.g.c.w("Matrix.battery.AppStatMonitorFeature", "foreground service detected with low app importance: " + this.cSF + ", " + this.cSG + ", " + localRunningServiceInfo.service, new Object[0]);
              this.cSq.a(true, this.cSF, this.cSG, localRunningServiceInfo.service, paramLong);
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public final b bb(long paramLong)
  {
    // Byte code:
    //   0: new 16	com/tencent/matrix/a/b/a/c$c
    //   3: dup
    //   4: invokestatic 160	com/tencent/matrix/a/b/c:getContext	()Landroid/content/Context;
    //   7: aload_0
    //   8: getfield 59	com/tencent/matrix/a/b/a/c:cSq	Lcom/tencent/matrix/a/b/c;
    //   11: getfield 256	com/tencent/matrix/a/b/c:cSh	Z
    //   14: invokestatic 262	com/tencent/matrix/a/c/c:k	(Landroid/content/Context;Z)I
    //   17: invokespecial 103	com/tencent/matrix/a/b/a/c$c:<init>	(I)V
    //   20: astore_3
    //   21: ldc 114
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 46	com/tencent/matrix/a/b/a/c:cSI	Ljava/util/List;
    //   28: getstatic 265	java/util/Collections:EMPTY_LIST	Ljava/util/List;
    //   31: if_acmpeq +14 -> 45
    //   34: aload_0
    //   35: getfield 46	com/tencent/matrix/a/b/a/c:cSI	Ljava/util/List;
    //   38: iconst_0
    //   39: aload_3
    //   40: invokeinterface 123 3 0
    //   45: ldc 114
    //   47: monitorexit
    //   48: aload_0
    //   49: getfield 46	com/tencent/matrix/a/b/a/c:cSI	Ljava/util/List;
    //   52: lload_1
    //   53: invokestatic 270	com/tencent/matrix/a/c/h:a	(Ljava/util/List;J)Lcom/tencent/matrix/a/c/h$b;
    //   56: astore_3
    //   57: new 13	com/tencent/matrix/a/b/a/c$b
    //   60: dup
    //   61: invokespecial 271	com/tencent/matrix/a/b/a/c$b:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: aload_3
    //   69: getfield 276	com/tencent/matrix/a/c/h$b:cTq	Z
    //   72: putfield 279	com/tencent/matrix/a/b/a/g$a:cTq	Z
    //   75: aload 4
    //   77: aload_3
    //   78: getfield 283	com/tencent/matrix/a/c/h$b:cUw	J
    //   81: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: invokestatic 293	com/tencent/matrix/a/b/a/g$a$c$b:b	(Ljava/lang/Number;)Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   87: putfield 297	com/tencent/matrix/a/b/a/c$b:cSM	Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   90: aload 4
    //   92: aload_3
    //   93: ldc_w 299
    //   96: invokevirtual 303	com/tencent/matrix/a/c/h$b:ex	(Ljava/lang/String;)I
    //   99: i2l
    //   100: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: invokestatic 293	com/tencent/matrix/a/b/a/g$a$c$b:b	(Ljava/lang/Number;)Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   106: putfield 306	com/tencent/matrix/a/b/a/c$b:cSN	Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   109: aload 4
    //   111: aload_3
    //   112: ldc_w 308
    //   115: invokevirtual 303	com/tencent/matrix/a/c/h$b:ex	(Ljava/lang/String;)I
    //   118: i2l
    //   119: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: invokestatic 293	com/tencent/matrix/a/b/a/g$a$c$b:b	(Ljava/lang/Number;)Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   125: putfield 311	com/tencent/matrix/a/b/a/c$b:cSO	Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   128: aload 4
    //   130: aload_3
    //   131: ldc_w 313
    //   134: invokevirtual 303	com/tencent/matrix/a/c/h$b:ex	(Ljava/lang/String;)I
    //   137: i2l
    //   138: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: invokestatic 293	com/tencent/matrix/a/b/a/g$a$c$b:b	(Ljava/lang/Number;)Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   144: putfield 316	com/tencent/matrix/a/b/a/c$b:cSP	Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   147: aload 4
    //   149: areturn
    //   150: astore_3
    //   151: ldc 114
    //   153: monitorexit
    //   154: aload_3
    //   155: athrow
    //   156: astore_3
    //   157: ldc 114
    //   159: new 215	java/lang/StringBuilder
    //   162: dup
    //   163: ldc_w 318
    //   166: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload_3
    //   170: invokevirtual 321	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: iconst_0
    //   180: anewarray 150	java/lang/Object
    //   183: invokestatic 240	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: new 13	com/tencent/matrix/a/b/a/c$b
    //   189: dup
    //   190: invokespecial 271	com/tencent/matrix/a/b/a/c$b:<init>	()V
    //   193: astore_3
    //   194: aload_3
    //   195: iconst_0
    //   196: putfield 279	com/tencent/matrix/a/b/a/g$a:cTq	Z
    //   199: aload_3
    //   200: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	c
    //   0	201	1	paramLong	long
    //   20	111	3	localObject1	Object
    //   150	5	3	localObject2	Object
    //   156	14	3	localThrowable	java.lang.Throwable
    //   193	7	3	localb1	b
    //   64	84	4	localb2	b
    // Exception table:
    //   from	to	target	type
    //   24	45	150	finally
    //   45	48	150	finally
    //   151	154	150	finally
    //   0	24	156	java/lang/Throwable
    //   48	147	156	java/lang/Throwable
    //   154	156	156	java/lang/Throwable
  }
  
  /* Error */
  public final com.tencent.matrix.a.c.h.b bc(long paramLong)
  {
    // Byte code:
    //   0: new 105	com/tencent/matrix/a/c/h$a
    //   3: dup
    //   4: aload_0
    //   5: getfield 59	com/tencent/matrix/a/b/a/c:cSq	Lcom/tencent/matrix/a/b/c;
    //   8: invokevirtual 109	com/tencent/matrix/a/b/c:getScene	()Ljava/lang/String;
    //   11: invokespecial 112	com/tencent/matrix/a/c/h$a:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: ldc 114
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 48	com/tencent/matrix/a/b/a/c:cSJ	Ljava/util/List;
    //   22: getstatic 265	java/util/Collections:EMPTY_LIST	Ljava/util/List;
    //   25: if_acmpeq +14 -> 39
    //   28: aload_0
    //   29: getfield 48	com/tencent/matrix/a/b/a/c:cSJ	Ljava/util/List;
    //   32: iconst_0
    //   33: aload_3
    //   34: invokeinterface 123 3 0
    //   39: ldc 114
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 48	com/tencent/matrix/a/b/a/c:cSJ	Ljava/util/List;
    //   46: lload_1
    //   47: invokestatic 270	com/tencent/matrix/a/c/h:a	(Ljava/util/List;J)Lcom/tencent/matrix/a/c/h$b;
    //   50: astore_3
    //   51: aload_3
    //   52: areturn
    //   53: astore_3
    //   54: ldc 114
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    //   59: astore_3
    //   60: ldc 114
    //   62: new 215	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 325
    //   69: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_3
    //   73: invokevirtual 321	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   76: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: iconst_0
    //   83: anewarray 150	java/lang/Object
    //   86: invokestatic 240	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: new 273	com/tencent/matrix/a/c/h$b
    //   92: dup
    //   93: invokespecial 326	com/tencent/matrix/a/c/h$b:<init>	()V
    //   96: astore_3
    //   97: aload_3
    //   98: iconst_0
    //   99: putfield 276	com/tencent/matrix/a/c/h$b:cTq	Z
    //   102: aload_3
    //   103: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	c
    //   0	104	1	paramLong	long
    //   14	38	3	localObject1	Object
    //   53	5	3	localObject2	Object
    //   59	14	3	localThrowable	java.lang.Throwable
    //   96	7	3	localb	com.tencent.matrix.a.c.h.b
    // Exception table:
    //   from	to	target	type
    //   18	39	53	finally
    //   39	42	53	finally
    //   54	57	53	finally
    //   0	18	59	java/lang/Throwable
    //   42	51	59	java/lang/Throwable
    //   57	59	59	java/lang/Throwable
  }
  
  public final void d(com.tencent.matrix.a.b.c paramc)
  {
    super.d(paramc);
    this.cSH = Math.max(paramc.cSe.cRR, 100);
  }
  
  public final void eq(String paramString)
  {
    try
    {
      if (this.cSJ != Collections.EMPTY_LIST)
      {
        this.cSJ.add(0, new h.a(paramString));
        Sj();
      }
      com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", "updateAppImportance when launch: ".concat(String.valueOf(paramString)), new Object[0]);
      Sk();
      return;
    }
    finally {}
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    int i = com.tencent.matrix.a.c.c.k(com.tencent.matrix.a.b.c.getContext(), paramBoolean);
    for (;;)
    {
      try
      {
        if (this.cSI != Collections.EMPTY_LIST)
        {
          this.cSI.add(0, new c(i));
          Sj();
        }
        StringBuilder localStringBuilder = new StringBuilder("updateAppImportance when app ");
        if (paramBoolean)
        {
          String str1 = "foreground";
          com.tencent.matrix.g.c.i("Matrix.battery.AppStatMonitorFeature", str1, new Object[0]);
          Sk();
          return;
        }
      }
      finally {}
      String str2 = "background";
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, ComponentName paramComponentName, long paramLong);
  }
  
  public static final class b
    extends g.a<b>
  {
    public g.a.c.b<Long> cSM = g.a.c.b.b(Long.valueOf(0L));
    public g.a.c.b<Long> cSN = g.a.c.b.b(Long.valueOf(0L));
    public g.a.c.b<Long> cSO = g.a.c.b.b(Long.valueOf(0L));
    public g.a.c.b<Long> cSP = g.a.c.b.b(Long.valueOf(0L));
  }
  
  static final class c
    extends h.a
  {
    public c(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */