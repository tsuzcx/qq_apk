package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.a.b.l;
import com.tencent.matrix.a.b.l.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class j
  extends a
{
  private final d eRG = new d();
  private final d eRH = new d();
  
  public final int awQ()
  {
    return 2147483647;
  }
  
  public final b axh()
  {
    c localc = new c();
    localc.pid = Process.myPid();
    if (com.tencent.matrix.c.isInstalled()) {}
    for (String str = com.tencent.matrix.e.d.getProcessName(com.tencent.matrix.c.avW().application);; str = "default")
    {
      localc.name = str;
      localc.eRR = j.c.a.mX(localc.pid);
      localc.eRP = SystemClock.uptimeMillis();
      localc.time = System.currentTimeMillis();
      return b.a(localc, this.eNY.ePD.ePq);
    }
  }
  
  public final void d(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      this.eRG.dk(paramInt1, paramInt2);
      return;
    }
    this.eRH.dk(paramInt1, paramInt2);
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
      this.eRG.start();
      this.eRH.stop();
      return;
    }
    this.eRH.start();
    this.eRG.stop();
  }
  
  public static abstract interface a
  {
    public abstract void a(m.a.c.c<? extends j.b.a> paramc);
  }
  
  public static class b
    extends m.a<b>
  {
    public m.a.c.b<Long> eRI;
    public m.a.c.c<b> eRJ;
    public m.a.c.b<Integer> eRK;
    public String name;
    public int pid;
    
    public static b a(j.c paramc, boolean paramBoolean)
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
        localObject = l.ng(paramc.pid);
        if (localObject == null) {
          break label198;
        }
        paramc.name = ((l.d)localObject).eUa;
        paramc.eRQ = ((l.d)localObject).axC();
        l1 = paramc.eRQ;
        bool = paramBoolean;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Object localObject;
          label198:
          com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.JiffiesMonitorFeature", localIOException, "parseProcJiffies fail", new Object[0]);
          localb.eSe = false;
          bool = false;
          l1 = l2;
          continue;
          localb.eSe = false;
        }
        paramc = localIOException;
      }
      localObject = Collections.emptyList();
      if (paramc.eRR.size() > 0)
      {
        i = paramc.eRR.size();
        localObject = new ArrayList(paramc.eRR.size());
        paramc = paramc.eRR.iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            b localb1 = b.a((j.c.a)paramc.next());
            if (localb1 != null)
            {
              ((List)localObject).add(localb1);
              if (bool) {
                continue;
              }
              l1 = ((Long)localb1.eSn).longValue() + l1;
              continue;
              throw new IOException("parse fail: " + com.tencent.matrix.a.b.b.gy(new StringBuilder("/proc/").append(paramc.pid).append("/stat").toString()));
            }
          }
        }
      }
      for (;;)
      {
        localb.eRI = m.a.c.b.c(Long.valueOf(l1));
        localb.eRJ = m.a.c.c.bf(paramc);
        localb.eRK = m.a.c.b.c(Integer.valueOf(i));
        return localb;
        paramc = localIOException;
      }
    }
    
    public static class a
      extends m.a.c.b<Long>
    {
      public boolean eRN;
      public String eRO;
      public String name;
      public int tid;
      
      public a(Long paramLong)
      {
        super();
      }
    }
    
    @Deprecated
    public static final class b
      extends j.b.a
    {
      public b(Long paramLong)
      {
        super();
      }
      
      public static b a(j.c.a parama)
      {
        try
        {
          Object localObject = l.dm(parama.pid, parama.tid);
          if ((localObject != null) && (!TextUtils.isEmpty(((l.d)localObject).eUa)))
          {
            parama.name = ((l.d)localObject).eUa;
            parama.eRO = ((l.d)localObject).eRO;
            parama.eRQ = ((l.d)localObject).axC();
            localObject = new b(Long.valueOf(parama.eRQ));
            ((b)localObject).name = parama.name;
            ((b)localObject).eRO = parama.eRO;
            ((b)localObject).tid = parama.tid;
            ((b)localObject).eRN = true;
            return localObject;
          }
          throw new IOException("parse fail: " + com.tencent.matrix.a.b.b.gy(new StringBuilder("/proc/").append(parama.pid).append("/task/").append(parama.tid).append("/stat").toString()));
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
    long eRP;
    public long eRQ;
    List<a> eRR = Collections.emptyList();
    String name;
    int pid;
    long time;
    
    public final String toString()
    {
      return "process:" + this.name + "(" + this.pid + ") thread size:" + this.eRR.size();
    }
    
    public static final class a
    {
      public String eRO;
      public long eRQ;
      public String name;
      public int pid;
      public int tid;
      
      static a dj(int paramInt1, int paramInt2)
      {
        a locala = new a();
        locala.pid = paramInt1;
        locala.tid = paramInt2;
        return locala;
      }
      
      /* Error */
      static List<a> mX(int paramInt)
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
        //   108: invokestatic 87	com/tencent/matrix/a/a/a/j$c$a:dj	(II)Lcom/tencent/matrix/a/a/a/j$c$a;
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
        return "thread:" + this.name + "(" + this.tid + ") " + this.eRQ;
      }
    }
  }
  
  final class d
    implements Runnable
  {
    private long eOb;
    private final List<j.c.a> eRS = new ArrayList();
    
    d() {}
    
    private long dC(long paramLong)
    {
      this.eOb += paramLong;
      return paramLong;
    }
    
    final void dk(int paramInt1, int paramInt2)
    {
      synchronized (this.eRS)
      {
        Iterator localIterator = this.eRS.iterator();
        while (localIterator.hasNext())
        {
          j.c.a locala = (j.c.a)localIterator.next();
          if ((locala.pid == paramInt1) && (locala.tid == paramInt2)) {
            return;
          }
        }
        this.eRS.add(j.c.a.dj(paramInt1, paramInt2));
        return;
      }
    }
    
    public final void run()
    {
      com.tencent.matrix.e.c.i("Matrix.battery.JiffiesMonitorFeature", "threadWatchDog start, size = " + this.eRS.size() + ", delayMillis = " + this.eOb, new Object[0]);
      ArrayList localArrayList = new ArrayList();
      synchronized (this.eRS)
      {
        Iterator localIterator = this.eRS.iterator();
        while (localIterator.hasNext())
        {
          j.b.b localb = j.b.b.a((j.c.a)localIterator.next());
          if (localb != null)
          {
            localb.eRN = false;
            localArrayList.add(localb);
          }
        }
      }
      if (!localList.isEmpty())
      {
        ??? = m.a.c.c.bf(localList);
        j.this.eNY.ePD.ePb.a((m.a.c.c)???);
      }
      if (this.eOb <= 300000L)
      {
        j.this.eNY.mHandler.postDelayed(this, dC(300000L));
        return;
      }
      if (this.eOb <= 600000L)
      {
        j.this.eNY.mHandler.postDelayed(this, dC(600000L));
        return;
      }
      synchronized (this.eRS)
      {
        this.eRS.clear();
        return;
      }
    }
    
    final void start()
    {
      synchronized (this.eRS)
      {
        com.tencent.matrix.e.c.i("Matrix.battery.JiffiesMonitorFeature", "ThreadWatchDog start watching, count = " + this.eRS.size(), new Object[0]);
        if (!this.eRS.isEmpty())
        {
          Handler localHandler = j.this.eNY.mHandler;
          this.eOb = 0L;
          dC(300000L);
          localHandler.postDelayed(this, this.eOb);
        }
        return;
      }
    }
    
    final void stop()
    {
      j.this.eNY.mHandler.removeCallbacks(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */