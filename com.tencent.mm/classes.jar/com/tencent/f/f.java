package com.tencent.f;

import com.tencent.f.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class f
{
  private static f MjT;
  private HashMap<String, g> MjU;
  HashMap<String, Object> MjV;
  private Object MjW;
  Object MjX;
  private a MjY;
  
  public f()
  {
    AppMethodBeat.i(62799);
    this.MjU = new HashMap();
    this.MjV = new HashMap();
    this.MjW = new Object();
    this.MjX = new Object();
    this.MjY = new a();
    AppMethodBeat.o(62799);
  }
  
  public static com.tencent.f.b.b a(d paramd)
  {
    AppMethodBeat.i(62802);
    paramd = fYP().b(paramd);
    AppMethodBeat.o(62802);
    return paramd;
  }
  
  public static Object aZU(String paramString)
  {
    AppMethodBeat.i(62801);
    paramString = fYP().aZV(paramString);
    AppMethodBeat.o(62801);
    return paramString;
  }
  
  private Object aZV(String paramString)
  {
    AppMethodBeat.i(62803);
    if (paramString == null)
    {
      paramString = new h("TpfServiceCenter|getService|service name should not be null");
      AppMethodBeat.o(62803);
      throw paramString;
    }
    synchronized (this.MjX)
    {
      ??? = this.MjV.get(paramString);
      if (??? != null) {}
    }
    label187:
    for (;;)
    {
      g localg;
      synchronized (this.MjW)
      {
        localg = (g)this.MjU.get(paramString);
        if (localg == null) {
          break label187;
        }
        if (localg.Mkc.Mkn)
        {
          paramString = c(localg);
          AppMethodBeat.o(62803);
          return paramString;
          paramString = finally;
          AppMethodBeat.o(62803);
          throw paramString;
        }
      }
      if (4 == localg.mState) {}
      try
      {
        a(localg);
        synchronized (this.MjX)
        {
          paramString = this.MjV.get(paramString);
        }
        paramString = ???;
      }
      catch (com.tencent.f.b.c paramString)
      {
        com.tencent.pb.common.c.b.w("service", new Object[] { paramString });
        AppMethodBeat.o(62803);
        return null;
      }
    }
  }
  
  private boolean ae(String[] paramArrayOfString)
  {
    AppMethodBeat.i(62806);
    int i;
    Object localObject2;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      i = 0;
      if (i < j)
      {
        localObject2 = paramArrayOfString[i];
        if (localObject2 == null) {}
      }
    }
    for (;;)
    {
      boolean bool;
      synchronized (this.MjW)
      {
        localObject2 = (g)this.MjU.get(localObject2);
        if (localObject2 == null)
        {
          bool = false;
          AppMethodBeat.o(62806);
          return bool;
        }
      }
      a((g)localObject2);
      if (((g)localObject2).mState != 32)
      {
        bool = false;
      }
      else
      {
        ((g)localObject2).mReferenceCount += 1;
        com.tencent.pb.common.c.b.d("reference_count", new Object[] { "addReferenceCount|", ((g)localObject2).Mkc.Mkl, "|refcount=", Integer.valueOf(((g)localObject2).mReferenceCount) });
        i += 1;
        break;
        bool = true;
      }
    }
  }
  
  private com.tencent.f.b.b b(d paramd)
  {
    int j = 1;
    AppMethodBeat.i(62804);
    if ((paramd == null) || (paramd.Mkl == null))
    {
      AppMethodBeat.o(62804);
      return null;
    }
    String str = paramd.Mkl;
    this.MjY.mT("install_", str);
    for (;;)
    {
      try
      {
        synchronized (this.MjW)
        {
          g localg = (g)this.MjU.get(str);
          if (localg == null)
          {
            localg = new g(this, paramd);
            localg.mState = 2;
            com.tencent.pb.common.c.b.d("service", new Object[] { "service [", str, "] installed!" });
            this.MjU.put(str, localg);
            i = 1;
            if (i != 0)
            {
              if (paramd.Mkk == null) {
                break label290;
              }
              i = j;
              if (i != 0)
              {
                localg.mState = 4;
                com.tencent.pb.common.c.b.d("service", new Object[] { "service [", str, "] resolved!" });
              }
            }
            else
            {
              return localg;
            }
          }
          else
          {
            com.tencent.pb.common.c.b.d("service", new Object[] { "service [", str, "] had been installed!" });
            i = 0;
          }
        }
        paramd = new com.tencent.f.b.c("resolve service [" + str + "] failed.");
      }
      finally
      {
        this.MjY.mU("install_", str);
        AppMethodBeat.o(62804);
      }
      AppMethodBeat.o(62804);
      throw paramd;
      label290:
      int i = 0;
    }
  }
  
  private static boolean b(g paramg)
  {
    AppMethodBeat.i(62807);
    if (!paramg.Mkc.Mkn) {}
    for (;;)
    {
      try
      {
        b localb = (b)Class.forName(paramg.Mkc.Mkk).newInstance();
        paramg.Mkd = localb;
        a locala = new a(paramg);
        paramg.Mke = locala;
        localb.a(locala);
        bool = true;
        AppMethodBeat.o(62807);
        return bool;
      }
      catch (Exception paramg)
      {
        com.tencent.pb.common.c.b.w("service", new Object[] { paramg });
      }
      boolean bool = false;
    }
  }
  
  private static Object c(g paramg)
  {
    AppMethodBeat.i(62808);
    try
    {
      c localc = (c)Class.forName(paramg.Mkc.Mkk).newInstance();
      paramg.Mke = new a(paramg);
      paramg.mState = 32;
      paramg = localc.fYK();
      AppMethodBeat.o(62808);
      return paramg;
    }
    catch (Exception paramg)
    {
      com.tencent.pb.common.c.b.w("service", new Object[] { paramg });
      AppMethodBeat.o(62808);
    }
    return null;
  }
  
  static f fYP()
  {
    AppMethodBeat.i(62800);
    if (MjT == null) {}
    try
    {
      if (MjT == null) {
        MjT = new f();
      }
      f localf = MjT;
      AppMethodBeat.o(62800);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(62800);
    }
  }
  
  final boolean a(g paramg)
  {
    int j = 0;
    AppMethodBeat.i(62805);
    d locald = paramg.Mkc;
    String str = locald.Mkl;
    this.MjY.mT("service_", str);
    try
    {
      int i = paramg.mState;
      if (i == 32) {
        i = 1;
      }
      for (;;)
      {
        this.MjY.mU("service_", str);
        if (i != 0) {
          break;
        }
        paramg = new com.tencent.f.b.c("startService [" + str + "] failed");
        AppMethodBeat.o(62805);
        throw paramg;
        i = j;
        if (paramg.mState == 4)
        {
          paramg.mState = 8;
          com.tencent.pb.common.c.b.d("service", new Object[] { "service [", str, "] starting..." });
          if (locald.Mkm != null) {
            ae(locald.Mkm);
          }
          i = j;
          if (b(paramg))
          {
            paramg.mState = 32;
            com.tencent.pb.common.c.b.d("service", new Object[] { "service [", str, "] active..." });
            i = 1;
          }
        }
      }
      AppMethodBeat.o(62805);
    }
    finally
    {
      this.MjY.mU("service_", str);
      AppMethodBeat.o(62805);
    }
    return true;
  }
  
  final class a
  {
    private final HashMap<String, Object> MjZ;
    private final Object mLock;
    
    a()
    {
      AppMethodBeat.i(62795);
      this.mLock = new Object();
      this.MjZ = new HashMap();
      AppMethodBeat.o(62795);
    }
    
    final void mT(String arg1, String paramString2)
    {
      AppMethodBeat.i(62796);
      String str = ??? + paramString2;
      synchronized (this.mLock)
      {
        for (;;)
        {
          Object localObject = this.MjZ.get(str);
          if (localObject != null) {
            try
            {
              this.mLock.wait();
            }
            catch (InterruptedException paramString2)
            {
              paramString2 = new com.tencent.f.b.c("install fail,lock interrupted!");
              AppMethodBeat.o(62796);
              throw paramString2;
            }
          }
        }
      }
      this.MjZ.put(str, paramString2);
      AppMethodBeat.o(62796);
    }
    
    final void mU(String arg1, String paramString2)
    {
      AppMethodBeat.i(62797);
      paramString2 = ??? + paramString2;
      synchronized (this.mLock)
      {
        this.MjZ.remove(paramString2);
        this.mLock.notifyAll();
        AppMethodBeat.o(62797);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.f.f
 * JD-Core Version:    0.7.0.1
 */