package c.t.m.g;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class at
{
  public int a = 1;
  public int b = 1;
  public int c = 20000;
  public ArrayList d = null;
  public ArrayList e = null;
  public boolean f = false;
  public String g = "dispatcher.3g.qq.com";
  public Socket h = null;
  public int i = 0;
  public int j = -1;
  public int k = -1;
  public r l;
  private int m = 3;
  private int n = 0;
  private boolean o = false;
  private boolean p = false;
  private int q = 0;
  private boolean r = false;
  private boolean s = false;
  private ArrayList t = new ArrayList();
  private int u = 0;
  private boolean v = false;
  private boolean w = false;
  private int[] x = c.a;
  private int y = 0;
  
  private static ArrayList a(ArrayList paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (paramInt1 >= paramArrayList.size())) {}
    do
    {
      return null;
      paramInt2 = Math.min(paramInt2, paramArrayList.size() - paramInt1);
    } while (paramInt2 <= 0);
    ArrayList localArrayList = new ArrayList(paramInt2);
    paramArrayList = paramArrayList.subList(paramInt1, paramInt1 + paramInt2);
    if (paramBoolean)
    {
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        r localr = (r)paramArrayList.get(paramInt1);
        localArrayList.add(new r(localr.a, localr.b));
        paramInt1 += 1;
      }
    }
    localArrayList.addAll(paramArrayList);
    return localArrayList;
  }
  
  private boolean b()
  {
    if (!this.v)
    {
      long l1;
      if (!this.w)
      {
        l1 = System.currentTimeMillis();
        this.t = ar.a(this.g, this.x, this.c);
        this.j = ((int)(System.currentTimeMillis() - l1));
        this.w = true;
      }
      if ((this.t != null) && (this.t.size() > 0) && (this.u < this.t.size()))
      {
        ArrayList localArrayList = a(this.t, this.u, this.b, false);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          this.u += localArrayList.size();
          if (this.u < this.t.size()) {}
        }
        else
        {
          this.v = true;
        }
        l1 = System.currentTimeMillis();
        this.h = ar.a(localArrayList, this.c);
        this.k += (int)(System.currentTimeMillis() - l1);
        return true;
      }
      this.v = true;
      this.k = 0;
    }
    return false;
  }
  
  private boolean c()
  {
    if (!this.r)
    {
      if ((this.e != null) && (this.e.size() > 0) && (this.q < this.e.size()))
      {
        ArrayList localArrayList = a(this.e, this.q, this.b, true);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          this.q += localArrayList.size();
          if (this.q < this.e.size()) {}
        }
        else
        {
          this.r = true;
        }
        long l1 = System.currentTimeMillis();
        this.h = ar.a(localArrayList, this.c);
        this.k += (int)(System.currentTimeMillis() - l1);
        return true;
      }
      this.r = true;
    }
    return false;
  }
  
  public final void a()
  {
    if ((this.d == null) || (this.d.size() <= 0))
    {
      bool = true;
      this.o = bool;
      if ((this.d == null) || (this.d.size() <= 0)) {
        break label325;
      }
      bool = true;
      label43:
      this.p = bool;
      if (this.e != null) {
        break label330;
      }
      bool = true;
      label57:
      this.r = bool;
      if ((this.p) || (!this.f)) {
        break label335;
      }
    }
    long l1;
    Object localObject1;
    label325:
    label330:
    label335:
    for (boolean bool = true;; bool = false)
    {
      this.s = bool;
      ax.a("SocketConnectorImpl", "doConnect...");
      if (((!this.o) || (!this.r) || (!this.v)) && (this.y <= this.m))
      {
        this.y += 1;
        if (this.o) {
          break label340;
        }
        l1 = System.currentTimeMillis();
        localObject1 = a(this.d, this.n, this.a, true);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.n += ((ArrayList)localObject1).size();
          if (this.n < this.d.size()) {}
        }
        else
        {
          this.o = true;
        }
        this.h = ar.a((ArrayList)localObject1, this.c);
        this.j = 0;
        this.k = ((int)(System.currentTimeMillis() - l1));
        ax.a("SocketConnectorImpl", "use IpList, dnsTime: 0 ,connectTime：" + this.k);
        if ((this.h == null) || (!this.h.isConnected()) || (this.h.isClosed())) {
          break label934;
        }
        this.l = new r(this.h.getInetAddress().getHostAddress(), this.h.getPort());
        this.i = 0;
      }
      return;
      bool = false;
      break;
      bool = false;
      break label43;
      bool = false;
      break label57;
    }
    label340:
    if (!this.s)
    {
      if (aw.c() == 1) {
        if ((b()) || (c())) {}
      }
      for (;;)
      {
        ax.a("SocketConnectorImpl", "use IpList DNS series , dnsTime:" + this.j + ",connectTime：" + this.k);
        break;
        if (!c()) {
          b();
        }
      }
    }
    Object localObject2 = new ArrayList();
    if (!this.r)
    {
      localObject1 = localObject2;
      if (this.e != null)
      {
        localObject1 = localObject2;
        if (this.e.size() > 0)
        {
          localObject1 = localObject2;
          if (this.q < this.e.size())
          {
            localObject1 = a(this.e, this.q, this.b, true);
            if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
              break label681;
            }
            this.q += ((ArrayList)localObject1).size();
            if (this.q < this.e.size()) {
              break label963;
            }
          }
        }
      }
      this.r = true;
    }
    for (;;)
    {
      label545:
      if (!this.w)
      {
        this.h = ar.a(this.g, this.x, this.c, this.b, (ArrayList)localObject1, this.t);
        this.j = ar.a;
        this.k = ar.b;
        this.w = true;
        this.u += Math.min(this.b, this.t.size());
        if (this.u >= this.t.size()) {
          this.v = true;
        }
      }
      for (;;)
      {
        ax.a("SocketConnectorImpl", "use IpList DNS parallel , dnsTime:" + this.j + ",connectTime：" + this.k);
        break;
        label681:
        this.r = true;
        break label545;
        ArrayList localArrayList = new ArrayList();
        localObject2 = localArrayList;
        if (!this.v)
        {
          localObject2 = localArrayList;
          if (this.t != null)
          {
            localObject2 = localArrayList;
            if (this.t.size() > 0)
            {
              localObject2 = localArrayList;
              if (this.u < this.t.size())
              {
                localArrayList = a(this.t, this.u, this.b, false);
                if ((localArrayList == null) || (localArrayList.size() <= 0)) {
                  break label909;
                }
                this.u += localArrayList.size();
                localObject2 = localArrayList;
                if (this.u < this.t.size()) {
                  break label824;
                }
                localObject2 = localArrayList;
              }
            }
          }
          this.v = true;
        }
        for (;;)
        {
          label824:
          if (((ArrayList)localObject2).size() + ((ArrayList)localObject1).size() <= 0) {
            break label921;
          }
          localArrayList = new ArrayList(((ArrayList)localObject2).size() + ((ArrayList)localObject1).size());
          localArrayList.addAll((Collection)localObject2);
          localArrayList.addAll((Collection)localObject1);
          this.j = 0;
          l1 = System.currentTimeMillis();
          this.h = ar.a(localArrayList, this.c);
          this.k = ((int)(System.currentTimeMillis() - l1));
          break;
          label909:
          this.v = true;
          localObject2 = localArrayList;
        }
        label921:
        this.v = true;
        this.r = true;
      }
      label934:
      if (aw.e()) {}
      for (this.i = -3;; this.i = -4)
      {
        this.h = null;
        break;
      }
      label963:
      continue;
      localObject1 = localObject2;
    }
  }
  
  public final void a(int[] paramArrayOfInt)
  {
    this.x = ((int[])paramArrayOfInt.clone());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.at
 * JD-Core Version:    0.7.0.1
 */