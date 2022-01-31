package com.tencent.h;

import com.tencent.h.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class f
{
  private static f ByE;
  private HashMap<String, g> ByF;
  HashMap<String, Object> ByG;
  private Object ByH;
  Object ByI;
  private f.a ByJ;
  
  public f()
  {
    AppMethodBeat.i(127751);
    this.ByF = new HashMap();
    this.ByG = new HashMap();
    this.ByH = new Object();
    this.ByI = new Object();
    this.ByJ = new f.a(this);
    AppMethodBeat.o(127751);
  }
  
  private boolean Z(String[] paramArrayOfString)
  {
    AppMethodBeat.i(127758);
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
      synchronized (this.ByH)
      {
        localObject2 = (g)this.ByF.get(localObject2);
        if (localObject2 == null)
        {
          bool = false;
          AppMethodBeat.o(127758);
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
        com.tencent.pb.common.c.c.d("reference_count", new Object[] { "addReferenceCount|", ((g)localObject2).ByN.ByW, "|refcount=", Integer.valueOf(((g)localObject2).mReferenceCount) });
        i += 1;
        break;
        bool = true;
      }
    }
  }
  
  public static com.tencent.h.b.b a(d paramd)
  {
    AppMethodBeat.i(127754);
    paramd = dWW().b(paramd);
    AppMethodBeat.o(127754);
    return paramd;
  }
  
  public static Object axi(String paramString)
  {
    AppMethodBeat.i(127753);
    paramString = dWW().axj(paramString);
    AppMethodBeat.o(127753);
    return paramString;
  }
  
  private Object axj(String paramString)
  {
    AppMethodBeat.i(127755);
    if (paramString == null)
    {
      paramString = new h("TpfServiceCenter|getService|service name should not be null");
      AppMethodBeat.o(127755);
      throw paramString;
    }
    synchronized (this.ByI)
    {
      ??? = this.ByG.get(paramString);
      if (??? != null) {}
    }
    label187:
    for (;;)
    {
      g localg;
      synchronized (this.ByH)
      {
        localg = (g)this.ByF.get(paramString);
        if (localg == null) {
          break label187;
        }
        if (localg.ByN.ByY)
        {
          paramString = c(localg);
          AppMethodBeat.o(127755);
          return paramString;
          paramString = finally;
          AppMethodBeat.o(127755);
          throw paramString;
        }
      }
      if (4 == localg.mState) {}
      try
      {
        a(localg);
        synchronized (this.ByI)
        {
          paramString = this.ByG.get(paramString);
        }
        paramString = ???;
      }
      catch (com.tencent.h.b.c paramString)
      {
        com.tencent.pb.common.c.c.w("service", new Object[] { paramString });
        AppMethodBeat.o(127755);
        return null;
      }
    }
  }
  
  private com.tencent.h.b.b b(d paramd)
  {
    int j = 1;
    AppMethodBeat.i(127756);
    if ((paramd == null) || (paramd.ByW == null))
    {
      AppMethodBeat.o(127756);
      return null;
    }
    String str = paramd.ByW;
    this.ByJ.iT("install_", str);
    for (;;)
    {
      try
      {
        synchronized (this.ByH)
        {
          g localg = (g)this.ByF.get(str);
          if (localg == null)
          {
            localg = new g(this, paramd);
            localg.mState = 2;
            com.tencent.pb.common.c.c.d("service", new Object[] { "service [", str, "] installed!" });
            this.ByF.put(str, localg);
            i = 1;
            if (i != 0)
            {
              if (paramd.ByV == null) {
                break label290;
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
        paramd = new com.tencent.h.b.c("resolve service [" + str + "] failed.");
      }
      finally
      {
        this.ByJ.iU("install_", str);
        AppMethodBeat.o(127756);
      }
      AppMethodBeat.o(127756);
      throw paramd;
      label290:
      int i = 0;
    }
  }
  
  private static boolean b(g paramg)
  {
    AppMethodBeat.i(127759);
    if (!paramg.ByN.ByY) {}
    for (;;)
    {
      try
      {
        b localb = (b)Class.forName(paramg.ByN.ByV).newInstance();
        paramg.ByO = localb;
        a locala = new a(paramg);
        paramg.ByP = locala;
        localb.a(locala);
        bool = true;
        AppMethodBeat.o(127759);
        return bool;
      }
      catch (Exception paramg)
      {
        com.tencent.pb.common.c.c.w("service", new Object[] { paramg });
      }
      boolean bool = false;
    }
  }
  
  private static Object c(g paramg)
  {
    AppMethodBeat.i(127760);
    try
    {
      c localc = (c)Class.forName(paramg.ByN.ByV).newInstance();
      paramg.ByP = new a(paramg);
      paramg.mState = 32;
      paramg = localc.dWR();
      AppMethodBeat.o(127760);
      return paramg;
    }
    catch (Exception paramg)
    {
      com.tencent.pb.common.c.c.w("service", new Object[] { paramg });
      AppMethodBeat.o(127760);
    }
    return null;
  }
  
  static f dWW()
  {
    AppMethodBeat.i(127752);
    if (ByE == null) {}
    try
    {
      if (ByE == null) {
        ByE = new f();
      }
      f localf = ByE;
      AppMethodBeat.o(127752);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(127752);
    }
  }
  
  final boolean a(g paramg)
  {
    int j = 0;
    AppMethodBeat.i(127757);
    d locald = paramg.ByN;
    String str = locald.ByW;
    this.ByJ.iT("service_", str);
    try
    {
      int i = paramg.mState;
      if (i == 32) {
        i = 1;
      }
      for (;;)
      {
        this.ByJ.iU("service_", str);
        if (i != 0) {
          break;
        }
        paramg = new com.tencent.h.b.c("startService [" + str + "] failed");
        AppMethodBeat.o(127757);
        throw paramg;
        i = j;
        if (paramg.mState == 4)
        {
          paramg.mState = 8;
          com.tencent.pb.common.c.c.d("service", new Object[] { "service [", str, "] starting..." });
          if (locald.ByX != null) {
            Z(locald.ByX);
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
      AppMethodBeat.o(127757);
    }
    finally
    {
      this.ByJ.iU("service_", str);
      AppMethodBeat.o(127757);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.h.f
 * JD-Core Version:    0.7.0.1
 */