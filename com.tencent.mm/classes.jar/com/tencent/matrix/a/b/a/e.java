package com.tencent.matrix.a.b.a;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.g.d;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a
{
  public final int Sg()
  {
    return 2147483647;
  }
  
  public final b Sm()
  {
    c localc = new c();
    localc.pid = Process.myPid();
    if (com.tencent.matrix.b.isInstalled()) {}
    for (String str = d.getProcessName(com.tencent.matrix.b.RG().application);; str = "default")
    {
      localc.name = str;
      localc.cTk = e.c.a.in(localc.pid);
      localc.cTi = SystemClock.uptimeMillis();
      localc.time = System.currentTimeMillis();
      return b.a(localc, this.cSq.cSe.cRW, this.cSq);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ce(int paramInt1, int paramInt2);
  }
  
  public static final class b
    extends g.a<b>
  {
    public g.a.c.b<Long> cTd;
    public g.a.c.c<a> cTe;
    public String name;
    public int pid;
    
    public static b a(e.c paramc, boolean paramBoolean, e.a parama)
    {
      b localb = new b();
      localb.pid = paramc.pid;
      localb.name = paramc.name;
      long l2 = 0L;
      long l1 = l2;
      boolean bool = paramBoolean;
      if (paramBoolean) {}
      try
      {
        localObject = com.tencent.matrix.a.c.e.io(paramc.pid);
        if (localObject == null) {
          break label190;
        }
        paramc.name = ((com.tencent.matrix.a.c.e.a)localObject).cUd;
        paramc.cTj = ((com.tencent.matrix.a.c.e.a)localObject).Sr();
        l1 = paramc.cTj;
        bool = paramBoolean;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Object localObject;
          e.c.a locala;
          com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.JiffiesMonitorFeature", localIOException, "parseProcJiffies fail", new Object[0]);
          localb.cTq = false;
          if (parama != null) {
            parama.ce(paramc.pid, 0);
          }
          bool = false;
          l1 = l2;
          continue;
          localb.cTq = false;
          if (parama != null) {
            parama.ce(locala.pid, locala.tid);
          }
        }
        paramc = localIOException;
      }
      localObject = Collections.emptyList();
      if (paramc.cTk.size() > 0)
      {
        localObject = new ArrayList(paramc.cTk.size());
        paramc = paramc.cTk.iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            locala = (e.c.a)paramc.next();
            a locala1 = a.a(locala);
            if (locala1 != null)
            {
              ((List)localObject).add(locala1);
              if (bool) {
                continue;
              }
              l1 = ((Long)locala1.cTz).longValue() + l1;
              continue;
              label190:
              throw new IOException("parse fail: " + com.tencent.matrix.a.c.c.eu(new StringBuilder("/proc/").append(paramc.pid).append("/stat").toString()));
            }
          }
        }
      }
      for (;;)
      {
        localb.cTd = g.a.c.b.b(Long.valueOf(l1));
        localb.cTe = g.a.c.c.J(paramc);
        return localb;
        paramc = localIOException;
      }
    }
    
    public static final class a
      extends g.a.c.b<Long>
    {
      public boolean cTh;
      public String name;
      public int tid;
      
      public a(Long paramLong)
      {
        super();
      }
      
      public static a a(e.c.a parama)
      {
        try
        {
          Object localObject = com.tencent.matrix.a.c.e.cf(parama.pid, parama.tid);
          if (localObject != null)
          {
            parama.name = ((com.tencent.matrix.a.c.e.a)localObject).cUd;
            parama.cTj = ((com.tencent.matrix.a.c.e.a)localObject).Sr();
            localObject = new a(Long.valueOf(parama.cTj));
            ((a)localObject).name = parama.name;
            ((a)localObject).tid = parama.tid;
            ((a)localObject).cTh = true;
            return localObject;
          }
          throw new IOException("parse fail: " + com.tencent.matrix.a.c.c.eu(new StringBuilder("/proc/").append(parama.pid).append("/task/").append(parama.tid).append("/stat").toString()));
        }
        catch (IOException parama)
        {
          com.tencent.matrix.g.c.printErrStackTrace("Matrix.battery.JiffiesMonitorFeature", parama, "parseThreadJiffies fail", new Object[0]);
        }
        return null;
      }
    }
  }
  
  public static final class c
  {
    long cTi;
    public long cTj;
    List<a> cTk = Collections.emptyList();
    String name;
    int pid;
    long time;
    
    public final String toString()
    {
      return "process:" + this.name + "(" + this.pid + ") thread size:" + this.cTk.size();
    }
    
    public static final class a
    {
      public long cTj;
      public String name;
      public int pid;
      public int tid;
      
      static List<a> in(int paramInt)
      {
        Object localObject = new File("/proc/" + paramInt + "/task/");
        File[] arrayOfFile;
        ArrayList localArrayList;
        int j;
        int i;
        if (((File)localObject).isDirectory())
        {
          arrayOfFile = ((File)localObject).listFiles();
          if (arrayOfFile == null)
          {
            localObject = Collections.emptyList();
            return localObject;
          }
          localArrayList = new ArrayList(arrayOfFile.length);
          j = arrayOfFile.length;
          i = 0;
        }
        for (;;)
        {
          localObject = localArrayList;
          if (i >= j) {
            break;
          }
          localObject = arrayOfFile[i];
          if (((File)localObject).isDirectory()) {}
          try
          {
            a locala = new a();
            locala.pid = paramInt;
            locala.tid = Integer.parseInt(((File)localObject).getName());
            localArrayList.add(locala);
            label128:
            i += 1;
            continue;
            return Collections.emptyList();
          }
          catch (Exception localException)
          {
            break label128;
          }
        }
      }
      
      public final String toString()
      {
        return "thread:" + this.name + "(" + this.tid + ") " + this.cTj;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */