package c.t.m.g;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

public final class ar
{
  public static int a = -1;
  public static int b = -1;
  
  public static Socket a(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ax.a("ParallelResolver", "getFastSocketByDnsAndDefault start. domain:" + paramString + ",ports:" + paramArrayOfInt + ",timeout:" + paramInt1 + ",parallelNum:" + paramInt2 + ",defaultTryList:" + paramArrayList1.size());
    paramString = new b(paramString, paramArrayOfInt, paramInt1, paramInt2);
    as.a().a(paramString);
    long l = System.currentTimeMillis();
    paramArrayOfInt = new d(paramArrayList1, paramInt1);
    as.a().a(paramArrayOfInt);
    paramInt1 = 0;
    while ((!paramString.d) || (!paramArrayOfInt.d))
    {
      int i = paramInt1;
      if (paramString.d)
      {
        i = paramInt1;
        if (paramString.b)
        {
          i = paramInt1;
          if (paramString.a != null)
          {
            paramInt2 = paramInt1;
            if (paramInt1 == 0)
            {
              paramArrayList2.addAll(paramString.a);
              paramInt2 = 1;
            }
            i = paramInt2;
            if (paramString.c != null)
            {
              i = paramInt2;
              if (paramString.c.isConnected())
              {
                i = paramInt2;
                if (!paramString.c.isClosed())
                {
                  paramString = paramString.c;
                  b = (int)(System.currentTimeMillis() - l);
                  return paramString;
                }
              }
            }
          }
        }
      }
      paramInt1 = i;
      if (paramArrayOfInt.d)
      {
        paramInt1 = i;
        if (paramArrayOfInt.a != null)
        {
          paramInt1 = i;
          if (paramArrayOfInt.a.isConnected())
          {
            paramInt1 = i;
            if (!paramArrayOfInt.a.isClosed())
            {
              a = 0;
              b = (int)(System.currentTimeMillis() - l);
              return paramArrayOfInt.a;
            }
          }
        }
      }
    }
    if ((paramString.d) && (paramString.b) && (paramString.a != null))
    {
      paramArrayList2.addAll(paramString.a);
      if ((paramString.c != null) && (paramString.c.isConnected()) && (!paramString.c.isClosed())) {
        return paramString.c;
      }
    }
    if ((paramArrayOfInt.d) && (paramArrayOfInt.a != null) && (paramArrayOfInt.a.isConnected()) && (!paramArrayOfInt.a.isClosed())) {
      return paramArrayOfInt.a;
    }
    return null;
  }
  
  public static Socket a(ArrayList paramArrayList, int paramInt)
  {
    int j = 0;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    int k = paramArrayList.size();
    a[] arrayOfa = new a[k];
    int i = 0;
    while (i < k)
    {
      arrayOfa[i] = new a((r)paramArrayList.get(i), paramInt);
      as.a().a(arrayOfa[i]);
      i += 1;
    }
    ArrayList localArrayList1 = null;
    paramInt = 0;
    if (paramInt == 0)
    {
      paramInt = 1;
      i = 0;
      paramArrayList = localArrayList1;
      if (i < k)
      {
        if ((arrayOfa[i].d) && (arrayOfa[i].a != null) && (arrayOfa[i].a.isConnected()) && (!arrayOfa[i].a.isClosed())) {
          paramArrayList = arrayOfa[i].a;
        }
      }
      else
      {
        if (paramArrayList == null) {
          break label262;
        }
        paramInt = j;
        label156:
        if (paramInt >= k) {
          break label239;
        }
        if (paramInt != i)
        {
          arrayOfa[paramInt].b = true;
          if ((!arrayOfa[paramInt].d) || (arrayOfa[paramInt].a == null)) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          arrayOfa[paramInt].a.close();
          arrayOfa[paramInt].a = null;
          paramInt += 1;
          break label156;
          if (!arrayOfa[i].d) {
            paramInt = 0;
          }
          i += 1;
          break;
          label239:
          ax.a("ParallelResolver", "getFastSocket end. socket:" + paramArrayList);
          return paramArrayList;
          try
          {
            label262:
            Thread.sleep(50L);
            localArrayList1 = paramArrayList;
          }
          catch (Exception localException1)
          {
            ArrayList localArrayList2 = paramArrayList;
          }
        }
      }
      catch (Exception localException2)
      {
        continue;
      }
      paramArrayList = localException2;
    }
  }
  
  public static ArrayList a(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    ax.a("ParallelResolver", "getDnsIpList start. domain:" + paramString + ",ports:" + paramArrayOfInt + ",timeout:" + paramInt);
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    as localas = as.a();
    paramString = new c(paramString, paramArrayOfInt);
    localas.a(paramString);
    int i = paramInt / 50;
    paramInt = 0;
    while ((paramInt < i) && (!paramString.d))
    {
      paramInt += 1;
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException paramArrayOfInt)
      {
        paramArrayOfInt.printStackTrace();
      }
    }
    ax.a("ParallelResolver", "getDnsIpList end. _dnsIpList:" + paramString.a);
    if (paramString.a != null) {
      ax.a("ParallelResolver", "getDnsIpList. _dnsIpList size:" + paramString.a.size());
    }
    return paramString.a;
  }
  
  public static ArrayList a(InetAddress[] paramArrayOfInetAddress, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfInetAddress != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInetAddress.length > 0)
      {
        localObject1 = new ArrayList(paramArrayOfInetAddress.length * paramArrayOfInt.length);
        int i = 0;
        while (i < paramArrayOfInetAddress.length)
        {
          int j = 0;
          while (j < paramArrayOfInt.length)
          {
            ((ArrayList)localObject1).add(new r(paramArrayOfInetAddress[i].getHostAddress(), paramArrayOfInt[j]));
            j += 1;
          }
          i += 1;
        }
      }
    }
    return localObject1;
  }
  
  public static final class a
    extends as.a
  {
    public Socket a = null;
    public volatile boolean b = false;
    private r c;
    private int e = 10000;
    
    public a(r paramr, int paramInt)
    {
      this.c = paramr;
      this.e = paramInt;
    }
    
    public final void run()
    {
      ax.c("ConnectIpRunnable", "Thread:" + Thread.currentThread().getName() + " isDaemon:" + Thread.currentThread().isDaemon());
      long l1 = System.currentTimeMillis();
      ax.a("ConnectIpRunnable", "ConnectIpRunnable run start. ip:" + this.c.a + ",port:" + this.c.b);
      InetSocketAddress localInetSocketAddress = new InetSocketAddress(this.c.a, this.c.b);
      Socket localSocket = new Socket();
      try
      {
        localSocket.connect(localInetSocketAddress, this.e);
        if ((localSocket.isConnected()) && (!localSocket.isClosed())) {
          this.a = localSocket;
        }
        if ((!this.b) || (this.a == null)) {}
      }
      catch (Exception localException1)
      {
        try
        {
          this.a.close();
          label172:
          this.a = null;
          this.d = true;
          long l2 = System.currentTimeMillis();
          ax.a("ConnectIpRunnable", "ConnectIpRunnable run end. ip:" + this.c.a + ",port:" + this.c.b + ",_sk:" + this.a + ",cost:" + (l2 - l1));
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          this.a = null;
        }
        catch (Exception localException2)
        {
          break label172;
        }
      }
    }
  }
  
  public static final class b
    extends as.a
  {
    public ArrayList a;
    public boolean b = false;
    public Socket c;
    private int e;
    private String f;
    private int[] g;
    private int h;
    private int i;
    
    public b(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    {
      this.f = new String(paramString);
      this.g = paramArrayOfInt;
      this.h = paramInt1;
      this.i = paramInt2;
    }
    
    public final void run()
    {
      ax.c("DnsIpListRunnable", "Thread:" + Thread.currentThread().getName() + " isDaemon:" + Thread.currentThread().isDaemon());
      ax.a("DnsIpListRunnable", "DnsIpListRunnable run start. _domain:" + this.f + ",_ports" + this.g + ",_timeout" + this.h + ",_parallelNum:" + this.i);
      System.currentTimeMillis();
      this.a = ar.a(this.f, this.g, this.h);
      System.currentTimeMillis();
      if ((this.a == null) || (this.a.size() <= 0))
      {
        this.d = true;
        ax.a("DnsIpListRunnable", "DnsIpListRunnable run. getDnsIpList fail.");
        return;
      }
      this.e = Math.min(this.i, this.a.size());
      ArrayList localArrayList = new ArrayList(this.e);
      localArrayList.addAll(this.a.subList(0, this.e));
      this.b = true;
      long l = System.currentTimeMillis();
      this.c = ar.a(localArrayList, this.h);
      ar.b = (int)(System.currentTimeMillis() - l);
      this.d = true;
      ax.a("DnsIpListRunnable", "DnsIpListRunnable run end. _triedNum:" + this.e + ",_retSk:" + this.c);
    }
  }
  
  public static final class c
    extends as.a
  {
    public ArrayList a = new ArrayList();
    private String b;
    private int[] c;
    
    public c(String paramString, int[] paramArrayOfInt)
    {
      this.b = new String(paramString);
      this.c = paramArrayOfInt;
    }
    
    public final void run()
    {
      ax.c("DnsRunnable", "Thread:" + Thread.currentThread().getName() + " isDaemon:" + Thread.currentThread().isDaemon());
      System.currentTimeMillis();
      try
      {
        InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(this.b);
        System.currentTimeMillis();
        if (arrayOfInetAddress != null) {
          this.a = ar.a(arrayOfInetAddress, this.c);
        }
        this.d = true;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static final class d
    extends as.a
  {
    public Socket a;
    private ArrayList b;
    private int c;
    
    public d(ArrayList paramArrayList, int paramInt)
    {
      this.b = paramArrayList;
      this.c = paramInt;
    }
    
    public final void run()
    {
      ax.c("ParallelResolver", "Thread:" + Thread.currentThread().getName() + " isDaemon:" + Thread.currentThread().isDaemon());
      this.a = ar.a(this.b, this.c);
      this.d = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.ar
 * JD-Core Version:    0.7.0.1
 */