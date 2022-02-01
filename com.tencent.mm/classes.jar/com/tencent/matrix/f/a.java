package com.tencent.matrix.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import android.util.LongSparseArray;
import com.tencent.matrix.g.c;
import com.tencent.matrix.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
  extends com.tencent.matrix.e.b
{
  private static long[] dan = new long[0];
  private static int dao = 0;
  private a dal;
  private List<List<d>> dam;
  private long dap;
  private long daq;
  private long dar;
  private int das;
  private final b dat;
  private Handler handler;
  private long lastReportTime;
  
  public static List<d> To()
  {
    Object localObject = a(new c()new b
    {
      public final void a(a.e paramAnonymouse)
      {
        a.e locale = (a.e)this.dav.get(paramAnonymouse.tid);
        if (locale != null)
        {
          paramAnonymouse.name = (locale.name.replaceAll("-?[0-9]\\d*", "?") + "J");
          paramAnonymouse.daz = locale.daz;
          paramAnonymouse.day = locale.day;
          paramAnonymouse.daA = locale.daA;
          paramAnonymouse.daB = true;
          return;
        }
        paramAnonymouse.name = paramAnonymouse.name.replaceAll("-?[0-9]\\d*", "?");
      }
    }, new b()
    {
      public final boolean b(a.e paramAnonymouse)
      {
        return false;
      }
    });
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      d locald = (d)localHashMap.get(locale.name);
      localObject = locald;
      if (locald == null)
      {
        localObject = new d(locale.name);
        localHashMap.put(locale.name, localObject);
      }
      ((d)localObject).list.add(locale);
    }
    localObject = new LinkedList(localHashMap.values());
    Collections.sort((List)localObject, new Comparator() {});
    return localObject;
  }
  
  private static LongSparseArray<e> a(b paramb)
  {
    LongSparseArray localLongSparseArray = new LongSparseArray();
    Iterator localIterator = Thread.getAllStackTraces().keySet().iterator();
    while (localIterator.hasNext())
    {
      Thread localThread = (Thread)localIterator.next();
      e locale = new e();
      locale.name = localThread.getName();
      if (((paramb == null) || (!paramb.b(locale))) && ((localThread instanceof HandlerThread)))
      {
        locale.tid = ((HandlerThread)localThread).getThreadId();
        localLongSparseArray.put(locale.tid, locale);
        locale.day = true;
      }
    }
    return localLongSparseArray;
  }
  
  private static List<e> a(c paramc, b paramb)
  {
    LinkedList localLinkedList = new LinkedList();
    String str = String.format("/proc/%s/task/", new Object[] { Integer.valueOf(Process.myPid()) });
    Object localObject1 = new File(str);
    if (((File)localObject1).isDirectory())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label253;
        }
        Object localObject2 = localObject1[i];
        try
        {
          localObject2 = getStringFromFile(str + ((File)localObject2).getName() + "/stat");
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll("\n", "").split(" ");
            e locale = new e();
            locale.tid = Long.parseLong(localObject2[0]);
            locale.name = localObject2[1].replace("(", "").replace(")", "");
            locale.state = localObject2[2].replace("'", "");
            if ((paramb != null) && (!paramb.b(locale)))
            {
              localLinkedList.add(locale);
              if (paramc != null) {
                paramc.a(locale);
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            c.e("Matrix.ThreadMonitor", d.g(localException), new Object[0]);
          }
        }
        i += 1;
      }
    }
    label253:
    return localLinkedList;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label59;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label59:
    throw paramInputStream;
    localBufferedReader.close();
    return localStringBuilder.toString();
  }
  
  public static int getProcessThreadCount()
  {
    Object localObject1 = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    for (;;)
    {
      int i;
      try
      {
        localObject1 = getStringFromFile((String)localObject1).trim().split("\n");
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (((String)localObject2).startsWith("Threads"))
          {
            localObject2 = Pattern.compile("\\d+").matcher((CharSequence)localObject2);
            if (((Matcher)localObject2).find()) {
              return Integer.parseInt(((Matcher)localObject2).group());
            }
          }
        }
        else
        {
          c.w("Matrix.ThreadMonitor", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
          i = Integer.parseInt(localObject1[24].trim());
          return i;
        }
      }
      catch (Exception localException)
      {
        return 0;
      }
      i += 1;
    }
  }
  
  private static String getStringFromFile(String paramString)
  {
    paramString = new File(paramString);
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null) {
        break label40;
      }
    }
    finally
    {
      try
      {
        paramString = convertStreamToString(localFileInputStream);
        localFileInputStream.close();
        return paramString;
      }
      finally {}
      paramString = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label40:
    throw paramString;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    this.handler.removeCallbacksAndMessages(null);
    if (this.dal != null)
    {
      if (paramBoolean) {
        this.handler.postDelayed(this.dal, this.dap);
      }
    }
    else {
      return;
    }
    this.handler.postDelayed(this.dal, this.daq);
  }
  
  public void start()
  {
    super.start();
    c.i("Matrix.ThreadMonitor", "start!", new Object[0]);
    dan = new long[6666];
    dao = 6666;
    com.tencent.matrix.trace.core.AppMethodBeat.sMethodEnterListener = new AppMethodBeat.b()
    {
      public final void t(int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((paramAnonymousLong < a.Tp()) && (a.Tq()[((int)paramAnonymousLong)] == 0L))
        {
          long l1 = Process.myTid();
          long l2 = paramAnonymousInt;
          a.Tq()[((int)paramAnonymousLong)] = (l1 << 32 | l2);
        }
      }
    };
    com.tencent.matrix.g.b.TO().post(new Runnable()
    {
      public final void run()
      {
        a.b(a.this).post(a.a(a.this));
      }
    });
  }
  
  public void stop()
  {
    super.stop();
    c.i("Matrix.ThreadMonitor", "stop!", new Object[0]);
    this.handler.removeCallbacks(this.dal);
    com.tencent.matrix.trace.core.AppMethodBeat.sMethodEnterListener = null;
    dan = new long[0];
  }
  
  final class a
    implements Runnable
  {
    private final long daw;
    
    public final void run()
    {
      int i = a.getProcessThreadCount();
      c.i("Matrix.ThreadMonitor", "[DumpThreadJiffiesTask] run...[%s] limit:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(a.c(this.dau)) });
      if (a.c(this.dau) >= i) {
        return;
      }
      Object localObject1 = a.b(new a.c()new a.b
      {
        public final void a(a.e paramAnonymouse)
        {
          a.e locale = (a.e)this.dav.get(paramAnonymouse.tid);
          if (locale != null)
          {
            if (paramAnonymouse.tid == a.a.a(a.a.this)) {}
            for (paramAnonymouse.name = "main";; paramAnonymouse.name = (locale.name.replaceAll("-?[0-9]\\d*", "?") + "J"))
            {
              paramAnonymouse.daz = locale.daz;
              paramAnonymouse.day = locale.day;
              paramAnonymouse.daA = locale.daA;
              paramAnonymouse.daB = true;
              return;
            }
          }
          paramAnonymouse.name = paramAnonymouse.name.replaceAll("-?[0-9]\\d*", "?");
        }
      }, new a.b()
      {
        public final boolean b(a.e paramAnonymouse)
        {
          return a.d(a.a.this.dau).b(paramAnonymouse);
        }
      });
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject1).iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        a.e locale = (a.e)localIterator.next();
        localObject2 = (a.d)localHashMap.get(locale.name);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a.d(locale.name);
          localHashMap.put(locale.name, localObject1);
        }
        ((a.d)localObject1).list.add(locale);
      }
      localObject1 = new LinkedList(localHashMap.values());
      Collections.sort((List)localObject1, new Comparator() {});
      long l = SystemClock.uptimeMillis();
      if ((this.dau.isForeground()) && (l - a.e(this.dau) > a.f(this.dau)))
      {
        localObject1 = a.g(this.dau).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (List)((Iterator)localObject1).next();
          a.a(this.dau, (List)localObject2);
        }
        a.a(this.dau, l);
        a.g(this.dau).clear();
        localObject1 = a.b(this.dau);
        if (!com.tencent.matrix.a.cPA.cPB) {
          break label399;
        }
      }
      label399:
      for (l = a.h(this.dau);; l = a.i(this.dau))
      {
        ((Handler)localObject1).postDelayed(this, l);
        return;
        if (a.g(this.dau).size() >= 10) {
          a.g(this.dau).remove(0);
        }
        a.g(this.dau).add(localObject1);
        break;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean b(a.e parame);
  }
  
  static abstract interface c
  {
    public abstract void a(a.e parame);
  }
  
  public static final class d
  {
    List<a.e> list = new LinkedList();
    public String name;
    
    d(String paramString)
    {
      this.name = paramString;
    }
    
    public final boolean Tr()
    {
      boolean bool = false;
      if (this.list.size() > 0) {
        bool = ((a.e)this.list.get(0)).daB;
      }
      return bool;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a.e))
      {
        paramObject = (a.e)paramObject;
        return this.name.equals(paramObject.name);
      }
      return false;
    }
    
    public final int getSize()
    {
      return this.list.size();
    }
    
    public final int hashCode()
    {
      return this.name.hashCode();
    }
    
    public final String toString()
    {
      return this.name + "=" + getSize();
    }
  }
  
  public static final class e
  {
    String daA;
    boolean daB;
    boolean day;
    int daz;
    String name;
    String state;
    long tid;
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        bool1 = bool2;
        if (this.tid == paramObject.tid) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public final int hashCode()
    {
      return (int)this.tid;
    }
    
    public final String toString()
    {
      return String.format("name=%s tid=%s state=%s isHandlerThread=%s isJavaThread=%s", new Object[] { this.name, Long.valueOf(this.tid), this.state, Boolean.valueOf(this.day), Boolean.valueOf(this.daB) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.f.a
 * JD-Core Version:    0.7.0.1
 */