package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.a;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.sdk.platformtools.f;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  LinkedList<Pair<String, ValueCallback<String>>> hlA;
  final LinkedList<o> hlB;
  final Map<String, k> hlC;
  final LinkedList<ctw> hlD;
  final HashMap<Integer, b> hlE;
  int hlF;
  long hlG;
  c hlj;
  final cto hlk;
  private String hll;
  private int hlm;
  private int hln;
  cui hlo;
  m hlp;
  AtomicInteger hlq;
  long hlr;
  long hls;
  long hlt;
  long hlu;
  AtomicInteger hlv;
  private boolean hlw;
  private boolean hlx;
  private final HashMap<String, Method> hly;
  private final HashMap<String, cud> hlz;
  final Object mLock;
  private int mStatus;
  
  public l()
  {
    AppMethodBeat.i(101823);
    this.hlm = 0;
    this.hln = 0;
    this.mStatus = 0;
    this.hlq = new AtomicInteger(0);
    this.hlr = 0L;
    this.hls = 0L;
    this.hlu = System.currentTimeMillis();
    this.hlv = new AtomicInteger(0);
    this.hly = new HashMap();
    this.hlz = new HashMap();
    this.hlA = new LinkedList();
    this.hlB = new LinkedList();
    this.hlC = new HashMap();
    this.hlD = new LinkedList();
    this.hlE = new HashMap();
    this.mLock = new Object();
    this.hlF = 0;
    this.hlG = 0L;
    this.hlk = new cto();
    this.hlk.wCA = f.ymG;
    AppMethodBeat.o(101823);
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
  
  public final void AL(String paramString)
  {
    try
    {
      this.hll = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(c paramc, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(140824);
    this.hlj = paramc;
    t.setUin(this.hlj.wj().wS().uin);
    this.hlp = t.AS(paramString);
    paramString = this.hlj.wj().wR();
    if (paramString != null)
    {
      paramString.bDm = this.hlp.bDm;
      paramString.bCW = true;
      paramc = (a)paramc.wj().U(a.class);
      if (paramc != null) {
        if (paramString.bDm) {
          break label102;
        }
      }
    }
    for (;;)
    {
      paramc.ism = bool;
      AppMethodBeat.o(140824);
      return;
      label102:
      bool = false;
    }
  }
  
  public final String ayU()
  {
    try
    {
      String str = this.hll;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int ayV()
  {
    try
    {
      int i = this.hlm;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int ayW()
  {
    try
    {
      int i = this.hln;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean ayX()
  {
    try
    {
      boolean bool = this.hlx;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean ayY()
  {
    AppMethodBeat.i(101826);
    if (getStatus() == 4)
    {
      AppMethodBeat.o(101826);
      return true;
    }
    AppMethodBeat.o(101826);
    return false;
  }
  
  public final boolean ayZ()
  {
    AppMethodBeat.i(101827);
    if (getStatus() == 5)
    {
      AppMethodBeat.o(101827);
      return true;
    }
    AppMethodBeat.o(101827);
    return false;
  }
  
  public final boolean aza()
  {
    return this.hlp.hlK == 3;
  }
  
  public final void cZ(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.hln >= paramInt1) && (this.hln <= paramInt2)) {
        this.hln = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dR(boolean paramBoolean)
  {
    try
    {
      this.hlw = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dS(boolean paramBoolean)
  {
    try
    {
      this.hlx = paramBoolean;
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
      boolean bool = this.hlw;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
  
  public final void nA(int paramInt)
  {
    try
    {
      this.hlm = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void nB(int paramInt)
  {
    try
    {
      if (this.hln < paramInt) {
        this.hln = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void nC(int paramInt)
  {
    this.hlG += paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.l
 * JD-Core Version:    0.7.0.1
 */