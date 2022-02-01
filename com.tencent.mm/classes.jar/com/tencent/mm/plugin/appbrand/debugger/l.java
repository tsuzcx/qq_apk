package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dtv;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.sdk.platformtools.h;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  com.tencent.luggage.sdk.b.a.c.c jGC;
  final dtg jGD;
  private String jGE;
  private int jGF;
  private int jGG;
  dua jGH;
  m jGI;
  AtomicInteger jGJ;
  long jGK;
  long jGL;
  long jGM;
  long jGN;
  AtomicInteger jGO;
  private boolean jGP;
  private boolean jGQ;
  private final HashMap<String, Method> jGR;
  private final HashMap<String, dtv> jGS;
  LinkedList<Pair<String, ValueCallback<String>>> jGT;
  final LinkedList<o> jGU;
  final Map<String, k> jGV;
  final LinkedList<dto> jGW;
  final HashMap<Integer, b> jGX;
  int jGY;
  long jGZ;
  final Object mLock;
  private int mStatus;
  
  public l()
  {
    AppMethodBeat.i(147009);
    this.jGF = 0;
    this.jGG = 0;
    this.mStatus = 0;
    this.jGJ = new AtomicInteger(0);
    this.jGK = 0L;
    this.jGL = 0L;
    this.jGN = System.currentTimeMillis();
    this.jGO = new AtomicInteger(0);
    this.jGR = new HashMap();
    this.jGS = new HashMap();
    this.jGT = new LinkedList();
    this.jGU = new LinkedList();
    this.jGV = new HashMap();
    this.jGW = new LinkedList();
    this.jGX = new HashMap();
    this.mLock = new Object();
    this.jGY = 0;
    this.jGZ = 0L;
    this.jGD = new dtg();
    this.jGD.DOv = h.GqE;
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
  
  public final void KG(String paramString)
  {
    try
    {
      this.jGE = paramString;
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
    this.jGC = paramc;
    u.setUin(this.jGC.CO().DC().uin);
    this.jGI = u.KN(paramString);
    paramString = this.jGC.CO().DB();
    if (paramString != null)
    {
      paramString.ccq = this.jGI.ccq;
      paramString.ccb = true;
      paramc = (a)paramc.CO().ar(a.class);
      if (paramc != null) {
        if (paramString.ccq) {
          break label102;
        }
      }
    }
    for (;;)
    {
      paramc.lvY = bool;
      AppMethodBeat.o(147010);
      return;
      label102:
      bool = false;
    }
  }
  
  public final String bba()
  {
    try
    {
      String str = this.jGE;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bbb()
  {
    try
    {
      int i = this.jGF;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bbc()
  {
    try
    {
      int i = this.jGG;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bbd()
  {
    try
    {
      boolean bool = this.jGQ;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bbe()
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
  
  public final boolean bbf()
  {
    return this.jGI.jHd == 3;
  }
  
  public final void dF(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.jGG >= paramInt1) && (this.jGG <= paramInt2)) {
        this.jGG = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void fV(boolean paramBoolean)
  {
    try
    {
      this.jGP = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void fW(boolean paramBoolean)
  {
    try
    {
      this.jGQ = paramBoolean;
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
      boolean bool = this.jGP;
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
  
  public final void rH(int paramInt)
  {
    try
    {
      this.jGF = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void rI(int paramInt)
  {
    try
    {
      if (this.jGG < paramInt) {
        this.jGG = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void rJ(int paramInt)
  {
    this.jGZ += paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.l
 * JD-Core Version:    0.7.0.1
 */