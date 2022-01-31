package com.tencent.g;

import com.tencent.g.b.d;
import java.util.HashMap;

public final class f
{
  private static f xbY;
  private HashMap<String, g> xbZ = new HashMap();
  HashMap<String, Object> xca = new HashMap();
  private Object xcb = new Object();
  Object xcc = new Object();
  private f.a xcd = new f.a(this);
  
  private boolean Q(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramArrayOfString[i];
        if (localObject2 != null)
        {
          synchronized (this.xcb)
          {
            localObject2 = (g)this.xbZ.get(localObject2);
            if (localObject2 == null) {
              return false;
            }
          }
          a((g)localObject2);
          if (((g)localObject2).mState != 32) {
            return false;
          }
          ((g)localObject2).mReferenceCount += 1;
          com.tencent.pb.common.c.c.d("reference_count", new Object[] { "addReferenceCount|", ((g)localObject2).xch.xcq, "|refcount=", Integer.valueOf(((g)localObject2).mReferenceCount) });
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static com.tencent.g.b.b a(d paramd)
  {
    return cRg().b(paramd);
  }
  
  public static Object agr(String paramString)
  {
    return cRg().ags(paramString);
  }
  
  private Object ags(String paramString)
  {
    if (paramString == null) {
      throw new h("TpfServiceCenter|getService|service name should not be null");
    }
    synchronized (this.xcc)
    {
      ??? = this.xca.get(paramString);
      if (??? != null) {
        return ???;
      }
    }
    g localg;
    synchronized (this.xcb)
    {
      localg = (g)this.xbZ.get(paramString);
      if (localg == null) {
        return ???;
      }
      if (localg.xch.xcs)
      {
        return c(localg);
        paramString = finally;
        throw paramString;
      }
    }
    if (4 == localg.mState) {}
    try
    {
      a(localg);
      synchronized (this.xcc)
      {
        paramString = this.xca.get(paramString);
        return paramString;
      }
      return ???;
    }
    catch (com.tencent.g.b.c paramString)
    {
      com.tencent.pb.common.c.c.x("service", new Object[] { paramString });
      return null;
    }
  }
  
  private com.tencent.g.b.b b(d paramd)
  {
    int j = 1;
    if ((paramd == null) || (paramd.xcq == null)) {
      return null;
    }
    String str = paramd.xcq;
    this.xcd.gN("install_", str);
    for (;;)
    {
      try
      {
        synchronized (this.xcb)
        {
          g localg = (g)this.xbZ.get(str);
          if (localg == null)
          {
            localg = new g(this, paramd);
            localg.mState = 2;
            com.tencent.pb.common.c.c.d("service", new Object[] { "service [", str, "] installed!" });
            this.xbZ.put(str, localg);
            i = 1;
            if (i != 0)
            {
              if (paramd.xcp == null) {
                break label258;
              }
              i = j;
              if (i != 0)
              {
                localg.mState = 4;
                com.tencent.pb.common.c.c.d("service", new Object[] { "service [", str, "] resolved!" });
              }
            }
            else
            {
              return localg;
            }
          }
          else
          {
            com.tencent.pb.common.c.c.d("service", new Object[] { "service [", str, "] had been installed!" });
            i = 0;
          }
        }
        throw new com.tencent.g.b.c("resolve service [" + str + "] failed.");
      }
      finally
      {
        this.xcd.gO("install_", str);
      }
      label258:
      int i = 0;
    }
  }
  
  private static boolean b(g paramg)
  {
    if (!paramg.xch.xcs) {
      try
      {
        b localb = (b)Class.forName(paramg.xch.xcp).newInstance();
        paramg.xci = localb;
        a locala = new a(paramg);
        paramg.xcj = locala;
        localb.a(locala);
        return true;
      }
      catch (Exception paramg)
      {
        com.tencent.pb.common.c.c.x("service", new Object[] { paramg });
      }
    }
    return false;
  }
  
  private static Object c(g paramg)
  {
    try
    {
      c localc = (c)Class.forName(paramg.xch.xcp).newInstance();
      paramg.xcj = new a(paramg);
      paramg.mState = 32;
      paramg = localc.cRc();
      return paramg;
    }
    catch (Exception paramg)
    {
      com.tencent.pb.common.c.c.x("service", new Object[] { paramg });
    }
    return null;
  }
  
  static f cRg()
  {
    if (xbY == null) {}
    try
    {
      if (xbY == null) {
        xbY = new f();
      }
      return xbY;
    }
    finally {}
  }
  
  final boolean a(g paramg)
  {
    int j = 0;
    d locald = paramg.xch;
    String str = locald.xcq;
    this.xcd.gN("service_", str);
    try
    {
      int i = paramg.mState;
      if (i == 32) {
        i = 1;
      }
      for (;;)
      {
        this.xcd.gO("service_", str);
        if (i != 0) {
          break;
        }
        throw new com.tencent.g.b.c("startService [" + str + "] failed");
        i = j;
        if (paramg.mState == 4)
        {
          paramg.mState = 8;
          com.tencent.pb.common.c.c.d("service", new Object[] { "service [", str, "] starting..." });
          if (locald.xcr != null) {
            Q(locald.xcr);
          }
          i = j;
          if (b(paramg))
          {
            paramg.mState = 32;
            com.tencent.pb.common.c.c.d("service", new Object[] { "service [", str, "] active..." });
            i = 1;
          }
        }
      }
      return true;
    }
    finally
    {
      this.xcd.gO("service_", str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.g.f
 * JD-Core Version:    0.7.0.1
 */