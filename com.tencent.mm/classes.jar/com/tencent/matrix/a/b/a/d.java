package com.tencent.matrix.a.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.c.h;
import com.tencent.matrix.a.c.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d
  extends a
{
  List<h.a> cSI = Collections.emptyList();
  Runnable cSK = new Runnable()
  {
    public final void run()
    {
      if (d.this.cSI.size() >= d.this.cSq.cSe.cRQ) {
        try
        {
          h.K(d.this.cSI);
          return;
        }
        finally {}
      }
    }
  };
  private c cSQ;
  
  public static b Sl()
  {
    b localb = new b();
    try
    {
      localb.cSU = g.a.c.c.r(com.tencent.matrix.a.c.c.Sq());
      return localb;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.DeviceStatusMonitorFeature", localThrowable, "#currentCpuFreq error", new Object[0]);
      localb.cSU = g.a.c.c.r(new int[0]);
    }
    return localb;
  }
  
  public static a aX(Context paramContext)
  {
    a locala = new a();
    locala.cSS = g.a.c.b.b(Integer.valueOf(com.tencent.matrix.a.b.c.aW(paramContext)));
    return locala;
  }
  
  public final void Se()
  {
    super.Se();
    c.c localc = new c.c(com.tencent.matrix.a.c.c.bb(com.tencent.matrix.a.b.c.getContext()));
    try
    {
      this.cSI = new ArrayList();
      this.cSI.add(0, localc);
      this.cSQ.cSW = new android.support.v4.e.c() {};
      this.cSQ.aY(com.tencent.matrix.a.b.c.getContext());
      return;
    }
    finally {}
  }
  
  public final void Sf()
  {
    super.Sf();
    c localc = this.cSQ;
    Context localContext = com.tencent.matrix.a.b.c.getContext();
    if (localc.cSZ) {}
    try
    {
      localContext.unregisterReceiver(localc);
      label25:
      localc.cSZ = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label25;
    }
  }
  
  public final int Sg()
  {
    return 2147483647;
  }
  
  /* Error */
  public final d bd(long paramLong)
  {
    // Byte code:
    //   0: new 183	com/tencent/matrix/a/c/h$a
    //   3: dup
    //   4: invokestatic 137	com/tencent/matrix/a/b/c:getContext	()Landroid/content/Context;
    //   7: invokestatic 140	com/tencent/matrix/a/c/c:bb	(Landroid/content/Context;)I
    //   10: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   13: invokespecial 191	com/tencent/matrix/a/c/h$a:<init>	(Ljava/lang/String;)V
    //   16: astore_3
    //   17: ldc 74
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 45	com/tencent/matrix/a/b/a/d:cSI	Ljava/util/List;
    //   24: getstatic 194	java/util/Collections:EMPTY_LIST	Ljava/util/List;
    //   27: if_acmpeq +14 -> 41
    //   30: aload_0
    //   31: getfield 45	com/tencent/matrix/a/b/a/d:cSI	Ljava/util/List;
    //   34: iconst_0
    //   35: aload_3
    //   36: invokeinterface 152 3 0
    //   41: ldc 74
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 45	com/tencent/matrix/a/b/a/d:cSI	Ljava/util/List;
    //   48: lload_1
    //   49: invokestatic 199	com/tencent/matrix/a/c/h:a	(Ljava/util/List;J)Lcom/tencent/matrix/a/c/h$b;
    //   52: astore_3
    //   53: new 25	com/tencent/matrix/a/b/a/d$d
    //   56: dup
    //   57: invokespecial 200	com/tencent/matrix/a/b/a/d$d:<init>	()V
    //   60: astore 4
    //   62: aload 4
    //   64: aload_3
    //   65: getfield 205	com/tencent/matrix/a/c/h$b:cTq	Z
    //   68: putfield 208	com/tencent/matrix/a/b/a/g$a:cTq	Z
    //   71: aload 4
    //   73: aload_3
    //   74: getfield 212	com/tencent/matrix/a/c/h$b:cUw	J
    //   77: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   80: invokestatic 124	com/tencent/matrix/a/b/a/g$a$c$b:b	(Ljava/lang/Number;)Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   83: putfield 220	com/tencent/matrix/a/b/a/d$d:cSM	Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   86: aload 4
    //   88: aload_3
    //   89: ldc 222
    //   91: invokevirtual 226	com/tencent/matrix/a/c/h$b:ex	(Ljava/lang/String;)I
    //   94: i2l
    //   95: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   98: invokestatic 124	com/tencent/matrix/a/b/a/g$a$c$b:b	(Ljava/lang/Number;)Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   101: putfield 229	com/tencent/matrix/a/b/a/d$d:cTb	Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   104: aload 4
    //   106: aload_3
    //   107: ldc 231
    //   109: invokevirtual 226	com/tencent/matrix/a/c/h$b:ex	(Ljava/lang/String;)I
    //   112: i2l
    //   113: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: invokestatic 124	com/tencent/matrix/a/b/a/g$a$c$b:b	(Ljava/lang/Number;)Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   119: putfield 234	com/tencent/matrix/a/b/a/d$d:cTc	Lcom/tencent/matrix/a/b/a/g$a$c$b;
    //   122: aload 4
    //   124: areturn
    //   125: astore_3
    //   126: ldc 74
    //   128: monitorexit
    //   129: aload_3
    //   130: athrow
    //   131: astore_3
    //   132: ldc 74
    //   134: new 236	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 238
    //   140: invokespecial 239	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_3
    //   144: invokevirtual 243	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: iconst_0
    //   154: anewarray 78	java/lang/Object
    //   157: invokestatic 254	com/tencent/matrix/g/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: new 25	com/tencent/matrix/a/b/a/d$d
    //   163: dup
    //   164: invokespecial 200	com/tencent/matrix/a/b/a/d$d:<init>	()V
    //   167: astore_3
    //   168: aload_3
    //   169: iconst_0
    //   170: putfield 208	com/tencent/matrix/a/b/a/g$a:cTq	Z
    //   173: aload_3
    //   174: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	d
    //   0	175	1	paramLong	long
    //   16	91	3	localObject1	Object
    //   125	5	3	localObject2	Object
    //   131	13	3	localThrowable	Throwable
    //   167	7	3	locald1	d
    //   60	63	4	locald2	d
    // Exception table:
    //   from	to	target	type
    //   20	41	125	finally
    //   41	44	125	finally
    //   126	129	125	finally
    //   0	20	131	java/lang/Throwable
    //   44	122	131	java/lang/Throwable
    //   129	131	131	java/lang/Throwable
  }
  
  public final void d(com.tencent.matrix.a.b.c paramc)
  {
    super.d(paramc);
    this.cSQ = new c();
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if ((!paramBoolean) && (!this.cSQ.cSZ)) {
      this.cSQ.aY(com.tencent.matrix.a.b.c.getContext());
    }
  }
  
  public static final class a
    extends g.a<a>
  {
    public g.a.c.b<Integer> cSS;
  }
  
  public static final class b
    extends g.a<b>
  {
    public g.a.c.c<g.a.c.b<Integer>> cSU;
  }
  
  static final class c
    extends BroadcastReceiver
  {
    android.support.v4.e.c<Integer> cSW = new android.support.v4.e.c() {};
    boolean cSX = false;
    boolean cSY = false;
    boolean cSZ = false;
    
    private void updateStatus()
    {
      int i;
      if (this.cSX) {
        i = 1;
      }
      for (;;)
      {
        this.cSW.accept(Integer.valueOf(i));
        return;
        if (this.cSY) {
          i = 3;
        } else {
          i = 2;
        }
      }
    }
    
    public final boolean aY(Context paramContext)
    {
      if (!this.cSZ) {}
      try
      {
        IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        paramContext.registerReceiver(this, localIntentFilter);
        this.cSZ = true;
        return true;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.DeviceStatusMonitorFeature", localThrowable, "#startListen failed", new Object[0]);
      }
      try
      {
        paramContext.unregisterReceiver(this);
        label61:
        this.cSZ = false;
        return false;
      }
      catch (Throwable paramContext)
      {
        break label61;
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = false;
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if (!paramContext.equals("android.intent.action.BATTERY_CHANGED")) {
          break label58;
        }
        int i = paramIntent.getIntExtra("plugged", -1);
        if ((i == 1) || (i == 2) || (i == 4)) {
          bool = true;
        }
        this.cSX = bool;
        updateStatus();
      }
      label58:
      do
      {
        return;
        if (paramContext.equals("android.intent.action.SCREEN_OFF"))
        {
          this.cSY = true;
          updateStatus();
          return;
        }
      } while (!paramContext.equals("android.intent.action.SCREEN_ON"));
      this.cSY = false;
      updateStatus();
    }
  }
  
  public static final class d
    extends g.a<d>
  {
    public g.a.c.b<Long> cSM = g.a.c.b.b(Long.valueOf(0L));
    public g.a.c.b<Long> cTb = g.a.c.b.b(Long.valueOf(0L));
    public g.a.c.b<Long> cTc = g.a.c.b.b(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */