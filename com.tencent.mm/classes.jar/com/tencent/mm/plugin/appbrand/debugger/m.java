package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.sdk.platformtools.i;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class m
{
  com.tencent.luggage.sdk.b.a.c.c kaO;
  final dza kaP;
  private String kaQ;
  private int kaR;
  private int kaS;
  dzu kaT;
  n kaU;
  AtomicInteger kaV;
  long kaW;
  long kaX;
  long kaY;
  long kaZ;
  AtomicInteger kba;
  private boolean kbb;
  private boolean kbc;
  private final HashMap<String, Method> kbd;
  private final HashMap<String, dzp> kbe;
  LinkedList<Pair<String, ValueCallback<String>>> kbf;
  final LinkedList<p> kbg;
  final Map<String, l> kbh;
  final LinkedList<dzi> kbi;
  final HashMap<Integer, c> kbj;
  int kbk;
  long kbl;
  final Object mLock;
  private int mStatus;
  
  public m()
  {
    AppMethodBeat.i(147009);
    this.kaR = 0;
    this.kaS = 0;
    this.mStatus = 0;
    this.kaV = new AtomicInteger(0);
    this.kaW = 0L;
    this.kaX = 0L;
    this.kaZ = System.currentTimeMillis();
    this.kba = new AtomicInteger(0);
    this.kbd = new HashMap();
    this.kbe = new HashMap();
    this.kbf = new LinkedList();
    this.kbg = new LinkedList();
    this.kbh = new HashMap();
    this.kbi = new LinkedList();
    this.kbj = new HashMap();
    this.mLock = new Object();
    this.kbk = 0;
    this.kbl = 0L;
    this.kaP = new dza();
    this.kaP.FtC = i.Ics;
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
  
  public final void Oa(String paramString)
  {
    try
    {
      this.kaQ = paramString;
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
    this.kaO = paramc;
    v.setUin(this.kaO.En().Fb().uin);
    this.kaU = v.Oh(paramString);
    paramString = this.kaO.En().Fa();
    if (paramString != null)
    {
      paramString.cmH = this.kaU.cmH;
      paramString.cms = true;
      paramc = (a)paramc.En().ar(a.class);
      if (paramc != null) {
        if (paramString.cmH) {
          break label102;
        }
      }
    }
    for (;;)
    {
      paramc.lVl = bool;
      AppMethodBeat.o(147010);
      return;
      label102:
      bool = false;
    }
  }
  
  public final String beE()
  {
    try
    {
      String str = this.kaQ;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int beF()
  {
    try
    {
      int i = this.kaR;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int beG()
  {
    try
    {
      int i = this.kaS;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean beH()
  {
    try
    {
      boolean bool = this.kbc;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean beI()
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
  
  public final boolean beJ()
  {
    return this.kaU.kbp == 3;
  }
  
  public final void dH(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.kaS >= paramInt1) && (this.kaS <= paramInt2)) {
        this.kaS = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ga(boolean paramBoolean)
  {
    try
    {
      this.kbb = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void gb(boolean paramBoolean)
  {
    try
    {
      this.kbc = paramBoolean;
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
      boolean bool = this.kbb;
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
  
  public final void sj(int paramInt)
  {
    try
    {
      this.kaR = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void sk(int paramInt)
  {
    try
    {
      if (this.kaS < paramInt) {
        this.kaS = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void sl(int paramInt)
  {
    this.kbl += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.m
 * JD-Core Version:    0.7.0.1
 */