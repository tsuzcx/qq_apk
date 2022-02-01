package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.protocal.protobuf.euy;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.evn;
import com.tencent.mm.protocal.protobuf.evs;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class m
{
  com.tencent.luggage.sdk.b.a.c.d lhP;
  final euy lhQ;
  private String lhR;
  private int lhS;
  private int lhT;
  evs lhU;
  n lhV;
  AtomicInteger lhW;
  long lhX;
  long lhY;
  long lhZ;
  long lia;
  AtomicInteger lib;
  private boolean lic;
  private boolean lid;
  private final HashMap<String, Method> lie;
  private final HashMap<String, evn> lif;
  LinkedList<Pair<String, ValueCallback<String>>> lig;
  final LinkedList<p> lih;
  final Map<String, l> lii;
  final LinkedList<evg> lij;
  final HashMap<Integer, c> lik;
  int lil;
  long lim;
  final Object mLock;
  private int mStatus;
  
  public m()
  {
    AppMethodBeat.i(147009);
    this.lhS = 0;
    this.lhT = 0;
    this.mStatus = 0;
    this.lhW = new AtomicInteger(0);
    this.lhX = 0L;
    this.lhY = 0L;
    this.lia = System.currentTimeMillis();
    this.lib = new AtomicInteger(0);
    this.lie = new HashMap();
    this.lif = new HashMap();
    this.lig = new LinkedList();
    this.lih = new LinkedList();
    this.lii = new HashMap();
    this.lij = new LinkedList();
    this.lik = new HashMap();
    this.mLock = new Object();
    this.lil = 0;
    this.lim = 0L;
    this.lhQ = new euy();
    this.lhQ.KFC = BuildInfo.CLIENT_VERSION_INT;
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
  
  public final void XS(String paramString)
  {
    try
    {
      this.lhR = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(com.tencent.luggage.sdk.b.a.c.d paramd, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(147010);
    this.lhP = paramd;
    v.setUin(this.lhP.NP().ON().uin);
    this.lhV = v.XZ(paramString);
    paramString = this.lhP.NP().OM();
    if (paramString != null)
    {
      paramString.cyF = this.lhV.cyF;
      paramString.cyp = true;
      paramd = (a)paramd.NP().av(a.class);
      if (paramd != null) {
        if (paramString.cyF) {
          break label102;
        }
      }
    }
    for (;;)
    {
      paramd.nhD = bool;
      AppMethodBeat.o(147010);
      return;
      label102:
      bool = false;
    }
  }
  
  public final String bAF()
  {
    try
    {
      String str = this.lhR;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bAG()
  {
    try
    {
      int i = this.lhS;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bAH()
  {
    try
    {
      int i = this.lhT;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bAI()
  {
    try
    {
      boolean bool = this.lid;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bAJ()
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
  
  public final boolean bAK()
  {
    return this.lhV.liq == 3;
  }
  
  public final void dS(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.lhT >= paramInt1) && (this.lhT <= paramInt2)) {
        this.lhT = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void gW(boolean paramBoolean)
  {
    try
    {
      this.lic = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void gX(boolean paramBoolean)
  {
    try
    {
      this.lid = paramBoolean;
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
      boolean bool = this.lic;
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
    //   8: invokespecial 205	com/tencent/mm/plugin/appbrand/debugger/m:getStatus	()I
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
    //   0	41	0	this	m
    //   16	12	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	36	finally
    //   17	22	36	finally
    //   28	33	36	finally
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
  
  public final void wi(int paramInt)
  {
    try
    {
      this.lhS = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void wj(int paramInt)
  {
    try
    {
      if (this.lhT < paramInt) {
        this.lhT = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void wk(int paramInt)
  {
    this.lim += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.m
 * JD-Core Version:    0.7.0.1
 */