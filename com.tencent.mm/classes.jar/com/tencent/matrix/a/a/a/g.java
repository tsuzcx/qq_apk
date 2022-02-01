package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.a.a.d.b;
import com.tencent.matrix.a.b.h;
import com.tencent.matrix.a.b.h.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class g
  extends a
{
  private final d cVL = new d();
  private final d cVM = new d();
  
  public final int Wh()
  {
    return 2147483647;
  }
  
  public final b Wr()
  {
    c localc = new c();
    localc.pid = Process.myPid();
    if (com.tencent.matrix.b.Vt()) {}
    for (String str = com.tencent.matrix.e.d.getProcessName(com.tencent.matrix.b.Vu().application);; str = "default")
    {
      localc.name = str;
      localc.cVY = g.c.a.ju(localc.pid);
      localc.cVW = SystemClock.uptimeMillis();
      localc.time = System.currentTimeMillis();
      return b.a(localc, this.cSI.cUb.cTO);
    }
  }
  
  public final void d(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.cVL.cx(paramInt1, paramInt2);
      return;
    }
    this.cVM.cx(paramInt1, paramInt2);
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.JiffiesMonitorFeature";
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if (paramBoolean)
    {
      this.cVL.start();
      this.cVM.stop();
      return;
    }
    this.cVM.start();
    this.cVL.stop();
  }
  
  public static abstract interface a
  {
    public abstract void a(j.a.c.c<? extends g.b.a> paramc);
  }
  
  public static final class b
    extends j.a<b>
  {
    public j.a.c.b<Long> cVP;
    public j.a.c.c<b> cVQ;
    public j.a.c.b<Integer> cVR;
    public String name;
    public int pid;
    
    public static b a(g.c paramc, boolean paramBoolean)
    {
      int i = 0;
      b localb = new b();
      localb.pid = paramc.pid;
      localb.name = paramc.name;
      long l2 = 0L;
      long l1 = l2;
      boolean bool = paramBoolean;
      if (paramBoolean) {}
      try
      {
        localObject = h.jA(paramc.pid);
        if (localObject == null) {
          break label198;
        }
        paramc.name = ((h.c)localObject).cXB;
        paramc.cVX = ((h.c)localObject).WF();
        l1 = paramc.cVX;
        bool = paramBoolean;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Object localObject;
          label198:
          com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.JiffiesMonitorFeature", localIOException, "parseProcJiffies fail", new Object[0]);
          localb.cWl = false;
          bool = false;
          l1 = l2;
          continue;
          localb.cWl = false;
        }
        paramc = localIOException;
      }
      localObject = Collections.emptyList();
      if (paramc.cVY.size() > 0)
      {
        i = paramc.cVY.size();
        localObject = new ArrayList(paramc.cVY.size());
        paramc = paramc.cVY.iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            b localb1 = b.a((g.c.a)paramc.next());
            if (localb1 != null)
            {
              ((List)localObject).add(localb1);
              if (bool) {
                continue;
              }
              l1 = ((Long)localb1.cWu).longValue() + l1;
              continue;
              throw new IOException("parse fail: " + com.tencent.matrix.a.b.b.fa(new StringBuilder("/proc/").append(paramc.pid).append("/stat").toString()));
            }
          }
        }
      }
      for (;;)
      {
        localb.cVP = j.a.c.b.c(Long.valueOf(l1));
        localb.cVQ = j.a.c.c.H(paramc);
        localb.cVR = j.a.c.b.c(Integer.valueOf(i));
        return localb;
        paramc = localIOException;
      }
    }
    
    public final j.a.a<b> a(b paramb)
    {
      new j.a.a(paramb, this) {};
    }
    
    public static class a
      extends j.a.c.b<Long>
    {
      public boolean cVU;
      public String cVV;
      public String name;
      public int tid;
      
      public a(Long paramLong)
      {
        super();
      }
    }
    
    @Deprecated
    public static final class b
      extends g.b.a
    {
      public b(Long paramLong)
      {
        super();
      }
      
      public static b a(g.c.a parama)
      {
        try
        {
          Object localObject = h.cy(parama.pid, parama.tid);
          if ((localObject != null) && (!TextUtils.isEmpty(((h.c)localObject).cXB)))
          {
            parama.name = ((h.c)localObject).cXB;
            parama.cVV = ((h.c)localObject).cVV;
            parama.cVX = ((h.c)localObject).WF();
            localObject = new b(Long.valueOf(parama.cVX));
            ((b)localObject).name = parama.name;
            ((b)localObject).cVV = parama.cVV;
            ((b)localObject).tid = parama.tid;
            ((b)localObject).cVU = true;
            return localObject;
          }
          throw new IOException("parse fail: " + com.tencent.matrix.a.b.b.fa(new StringBuilder("/proc/").append(parama.pid).append("/task/").append(parama.tid).append("/stat").toString()));
        }
        catch (IOException parama)
        {
          com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.JiffiesMonitorFeature", parama, "parseThreadJiffies fail", new Object[0]);
        }
        return null;
      }
    }
  }
  
  public static final class c
  {
    long cVW;
    public long cVX;
    List<a> cVY = Collections.emptyList();
    String name;
    int pid;
    long time;
    
    public final String toString()
    {
      return "process:" + this.name + "(" + this.pid + ") thread size:" + this.cVY.size();
    }
    
    public static final class a
    {
      public String cVV;
      public long cVX;
      public String name;
      public int pid;
      public int tid;
      
      static a cw(int paramInt1, int paramInt2)
      {
        a locala = new a();
        locala.pid = paramInt1;
        locala.tid = paramInt2;
        return locala;
      }
      
      /* Error */
      static List<a> ju(int paramInt)
      {
        // Byte code:
        //   0: new 36	java/io/File
        //   3: dup
        //   4: new 38	java/lang/StringBuilder
        //   7: dup
        //   8: ldc 40
        //   10: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   13: iload_0
        //   14: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   17: ldc 49
        //   19: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   22: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   25: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
        //   28: astore 4
        //   30: aload 4
        //   32: invokevirtual 61	java/io/File:isDirectory	()Z
        //   35: ifeq +140 -> 175
        //   38: aload 4
        //   40: invokevirtual 65	java/io/File:listFiles	()[Ljava/io/File;
        //   43: astore 6
        //   45: aload 6
        //   47: ifnonnull +7 -> 54
        //   50: invokestatic 71	java/util/Collections:emptyList	()Ljava/util/List;
        //   53: areturn
        //   54: new 73	java/util/ArrayList
        //   57: dup
        //   58: aload 6
        //   60: arraylength
        //   61: invokespecial 76	java/util/ArrayList:<init>	(I)V
        //   64: astore 5
        //   66: aload 6
        //   68: arraylength
        //   69: istore_2
        //   70: iconst_0
        //   71: istore_1
        //   72: aload 5
        //   74: astore 4
        //   76: iload_1
        //   77: iload_2
        //   78: if_icmpge +102 -> 180
        //   81: aload 6
        //   83: iload_1
        //   84: aaload
        //   85: astore 4
        //   87: aload 4
        //   89: invokevirtual 61	java/io/File:isDirectory	()Z
        //   92: istore_3
        //   93: iload_3
        //   94: ifeq +23 -> 117
        //   97: aload 5
        //   99: iload_0
        //   100: aload 4
        //   102: invokevirtual 79	java/io/File:getName	()Ljava/lang/String;
        //   105: invokestatic 85	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   108: invokestatic 87	com/tencent/matrix/a/a/a/g$c$a:cw	(II)Lcom/tencent/matrix/a/a/a/g$c$a;
        //   111: invokeinterface 93 2 0
        //   116: pop
        //   117: iload_1
        //   118: iconst_1
        //   119: iadd
        //   120: istore_1
        //   121: goto -49 -> 72
        //   124: astore 7
        //   126: ldc 95
        //   128: aload 7
        //   130: new 38	java/lang/StringBuilder
        //   133: dup
        //   134: ldc 97
        //   136: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   139: aload 4
        //   141: invokevirtual 79	java/io/File:getName	()Ljava/lang/String;
        //   144: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   147: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   150: iconst_0
        //   151: anewarray 4	java/lang/Object
        //   154: invokestatic 103	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   157: goto -40 -> 117
        //   160: astore 4
        //   162: ldc 95
        //   164: aload 4
        //   166: ldc 105
        //   168: iconst_0
        //   169: anewarray 4	java/lang/Object
        //   172: invokestatic 103	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   175: invokestatic 71	java/util/Collections:emptyList	()Ljava/util/List;
        //   178: astore 4
        //   180: aload 4
        //   182: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	183	0	paramInt	int
        //   71	50	1	i	int
        //   69	10	2	j	int
        //   92	2	3	bool	boolean
        //   28	112	4	localObject	Object
        //   160	5	4	localException1	java.lang.Exception
        //   178	3	4	localList	List
        //   64	34	5	localArrayList	ArrayList
        //   43	39	6	arrayOfFile	java.io.File[]
        //   124	5	7	localException2	java.lang.Exception
        // Exception table:
        //   from	to	target	type
        //   97	117	124	java/lang/Exception
        //   30	45	160	java/lang/Exception
        //   50	54	160	java/lang/Exception
        //   54	70	160	java/lang/Exception
        //   87	93	160	java/lang/Exception
        //   126	157	160	java/lang/Exception
      }
      
      public final String toString()
      {
        return "thread:" + this.name + "(" + this.tid + ") " + this.cVX;
      }
    }
  }
  
  final class d
    implements Runnable
  {
    private long cSL;
    private final List<g.c.a> cVZ = new ArrayList();
    
    d() {}
    
    private long bk(long paramLong)
    {
      this.cSL += paramLong;
      return paramLong;
    }
    
    final void cx(int paramInt1, int paramInt2)
    {
      synchronized (this.cVZ)
      {
        Iterator localIterator = this.cVZ.iterator();
        while (localIterator.hasNext())
        {
          g.c.a locala = (g.c.a)localIterator.next();
          if ((locala.pid == paramInt1) && (locala.tid == paramInt2)) {
            return;
          }
        }
        this.cVZ.add(g.c.a.cw(paramInt1, paramInt2));
        return;
      }
    }
    
    public final void run()
    {
      com.tencent.matrix.e.c.i("Matrix.battery.JiffiesMonitorFeature", "threadWatchDog start, size = " + this.cVZ.size() + ", delayMillis = " + this.cSL, new Object[0]);
      ArrayList localArrayList = new ArrayList();
      synchronized (this.cVZ)
      {
        Iterator localIterator = this.cVZ.iterator();
        while (localIterator.hasNext())
        {
          g.b.b localb = g.b.b.a((g.c.a)localIterator.next());
          if (localb != null)
          {
            localb.cVU = false;
            localArrayList.add(localb);
          }
        }
      }
      if (!localList.isEmpty())
      {
        ??? = j.a.c.c.H(localList);
        g.this.cSI.cUb.cTz.a((j.a.c.c)???);
      }
      if (this.cSL <= 300000L)
      {
        g.this.cSI.mHandler.postDelayed(this, bk(300000L));
        return;
      }
      if (this.cSL <= 600000L)
      {
        g.this.cSI.mHandler.postDelayed(this, bk(600000L));
        return;
      }
      synchronized (this.cVZ)
      {
        this.cVZ.clear();
        return;
      }
    }
    
    final void start()
    {
      synchronized (this.cVZ)
      {
        com.tencent.matrix.e.c.i("Matrix.battery.JiffiesMonitorFeature", "ThreadWatchDog start watching, count = " + this.cVZ.size(), new Object[0]);
        if (!this.cVZ.isEmpty())
        {
          Handler localHandler = g.this.cSI.mHandler;
          this.cSL = 0L;
          bk(300000L);
          localHandler.postDelayed(this, this.cSL);
        }
        return;
      }
    }
    
    final void stop()
    {
      g.this.cSI.mHandler.removeCallbacks(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */