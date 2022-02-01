package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.protocal.protobuf.ffj;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.ffz;
import com.tencent.mm.protocal.protobuf.fge;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class o
{
  final Object mLock;
  private int mStatus;
  private int ocA;
  private int ocB;
  fge ocC;
  p ocD;
  AtomicInteger ocE;
  long ocF;
  long ocG;
  long ocH;
  long ocI;
  AtomicInteger ocJ;
  private boolean ocK;
  private boolean ocL;
  private final HashMap<String, Method> ocM;
  private final HashMap<String, ffz> ocN;
  LinkedList<Pair<String, ValueCallback<String>>> ocO;
  final LinkedList<r> ocP;
  final Map<String, n> ocQ;
  final LinkedList<ffs> ocR;
  final HashMap<Integer, c> ocS;
  int ocT;
  long ocU;
  com.tencent.luggage.sdk.b.a.c.d ocx;
  final ffj ocy;
  private String ocz;
  
  public o()
  {
    AppMethodBeat.i(147009);
    this.ocA = 0;
    this.ocB = 0;
    this.mStatus = 0;
    this.ocE = new AtomicInteger(0);
    this.ocF = 0L;
    this.ocG = 0L;
    this.ocI = System.currentTimeMillis();
    this.ocJ = new AtomicInteger(0);
    this.ocM = new HashMap();
    this.ocN = new HashMap();
    this.ocO = new LinkedList();
    this.ocP = new LinkedList();
    this.ocQ = new HashMap();
    this.ocR = new LinkedList();
    this.ocS = new HashMap();
    this.mLock = new Object();
    this.ocT = 0;
    this.ocU = 0L;
    this.ocy = new ffj();
    this.ocy.RGT = BuildInfo.CLIENT_VERSION_INT;
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
  
  public final void a(com.tencent.luggage.sdk.b.a.c.d paramd, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(147010);
    this.ocx = paramd;
    x.setUin(this.ocx.QM().Sk().uin);
    this.ocD = x.afM(paramString);
    paramString = this.ocx.QM().Sj();
    if (paramString != null)
    {
      paramString.cxj = this.ocD.cxj;
      paramString.cwS = true;
      paramd = (a)paramd.QM().au(a.class);
      if (paramd != null) {
        if (paramString.cxj) {
          break label102;
        }
      }
    }
    for (;;)
    {
      paramd.qim = bool;
      AppMethodBeat.o(147010);
      return;
      label102:
      bool = false;
    }
  }
  
  public final void afF(String paramString)
  {
    try
    {
      this.ocz = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String bMa()
  {
    try
    {
      String str = this.ocz;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bMb()
  {
    try
    {
      int i = this.ocA;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bMc()
  {
    try
    {
      int i = this.ocB;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bMd()
  {
    try
    {
      boolean bool = this.ocL;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bMe()
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
  
  public final boolean bMf()
  {
    return this.ocD.ocY == 3;
  }
  
  public final void er(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.ocB >= paramInt1) && (this.ocB <= paramInt2)) {
        this.ocB = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void hN(boolean paramBoolean)
  {
    try
    {
      this.ocK = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void hO(boolean paramBoolean)
  {
    try
    {
      this.ocL = paramBoolean;
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
      boolean bool = this.ocK;
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
    //   8: invokespecial 205	com/tencent/mm/plugin/appbrand/debugger/o:getStatus	()I
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
    //   0	41	0	this	o
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
  
  public final void zv(int paramInt)
  {
    try
    {
      this.ocA = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void zw(int paramInt)
  {
    try
    {
      if (this.ocB < paramInt) {
        this.ocB = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void zx(int paramInt)
  {
    this.ocU += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o
 * JD-Core Version:    0.7.0.1
 */