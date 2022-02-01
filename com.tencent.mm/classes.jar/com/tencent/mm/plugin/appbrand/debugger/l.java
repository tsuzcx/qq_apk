package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.a;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.doj;
import com.tencent.mm.sdk.platformtools.h;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private boolean jgA;
  private boolean jgB;
  private final HashMap<String, Method> jgC;
  private final HashMap<String, doe> jgD;
  LinkedList<Pair<String, ValueCallback<String>>> jgE;
  final LinkedList<o> jgF;
  final Map<String, k> jgG;
  final LinkedList<dnx> jgH;
  final HashMap<Integer, b> jgI;
  int jgJ;
  long jgK;
  com.tencent.luggage.sdk.b.a.c.c jgn;
  final dnp jgo;
  private String jgp;
  private int jgq;
  private int jgr;
  doj jgs;
  m jgt;
  AtomicInteger jgu;
  long jgv;
  long jgw;
  long jgx;
  long jgy;
  AtomicInteger jgz;
  final Object mLock;
  private int mStatus;
  
  public l()
  {
    AppMethodBeat.i(147009);
    this.jgq = 0;
    this.jgr = 0;
    this.mStatus = 0;
    this.jgu = new AtomicInteger(0);
    this.jgv = 0L;
    this.jgw = 0L;
    this.jgy = System.currentTimeMillis();
    this.jgz = new AtomicInteger(0);
    this.jgC = new HashMap();
    this.jgD = new HashMap();
    this.jgE = new LinkedList();
    this.jgF = new LinkedList();
    this.jgG = new HashMap();
    this.jgH = new LinkedList();
    this.jgI = new HashMap();
    this.mLock = new Object();
    this.jgJ = 0;
    this.jgK = 0L;
    this.jgo = new dnp();
    this.jgo.Cwa = h.ETr;
    AppMethodBeat.o(147009);
  }
  
  private int getStatus()
  {
    try
    {
      int i = this.mStatus;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void GC(String paramString)
  {
    try
    {
      this.jgp = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(com.tencent.luggage.sdk.b.a.c.c paramc, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(147010);
    this.jgn = paramc;
    u.setUin(this.jgn.Dl().DZ().uin);
    this.jgt = u.GJ(paramString);
    paramString = this.jgn.Dl().DY();
    if (paramString != null)
    {
      paramString.cft = this.jgt.cft;
      paramString.cfe = true;
      paramc = (a)paramc.Dl().ar(a.class);
      if (paramc != null) {
        if (paramString.cft) {
          break label102;
        }
      }
    }
    for (;;)
    {
      paramc.kUo = bool;
      AppMethodBeat.o(147010);
      return;
      label102:
      bool = false;
    }
  }
  
  public final String aUc()
  {
    try
    {
      String str = this.jgp;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int aUd()
  {
    try
    {
      int i = this.jgq;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int aUe()
  {
    try
    {
      int i = this.jgr;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean aUf()
  {
    try
    {
      boolean bool = this.jgB;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean aUg()
  {
    AppMethodBeat.i(147013);
    if (getStatus() == 5)
    {
      AppMethodBeat.o(147013);
      return true;
    }
    AppMethodBeat.o(147013);
    return false;
  }
  
  public final boolean aUh()
  {
    return this.jgt.jgO == 3;
  }
  
  public final void dF(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.jgr >= paramInt1) && (this.jgr <= paramInt2)) {
        this.jgr = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void fA(boolean paramBoolean)
  {
    try
    {
      this.jgB = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void fz(boolean paramBoolean)
  {
    try
    {
      this.jgA = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean isBusy()
  {
    try
    {
      boolean bool = this.jgA;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean isQuit()
  {
    AppMethodBeat.i(147012);
    if (getStatus() == 4)
    {
      AppMethodBeat.o(147012);
      return true;
    }
    AppMethodBeat.o(147012);
    return false;
  }
  
  /* Error */
  public final boolean isReady()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 221
    //   4: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 205	com/tencent/mm/plugin/appbrand/debugger/l:getStatus	()I
    //   11: iconst_3
    //   12: if_icmpne +14 -> 26
    //   15: iconst_1
    //   16: istore_1
    //   17: ldc 221
    //   19: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: ldc 221
    //   30: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: goto -11 -> 22
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	l
    //   16	12	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	36	finally
    //   17	22	36	finally
    //   28	33	36	finally
  }
  
  public final void qU(int paramInt)
  {
    try
    {
      this.jgq = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void qV(int paramInt)
  {
    try
    {
      if (this.jgr < paramInt) {
        this.jgr = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void qW(int paramInt)
  {
    this.jgK += paramInt;
  }
  
  public final void setStatus(int paramInt)
  {
    try
    {
      this.mStatus = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.l
 * JD-Core Version:    0.7.0.1
 */