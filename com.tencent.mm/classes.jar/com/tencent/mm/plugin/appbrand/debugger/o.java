package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.protocal.protobuf.gbv;
import com.tencent.mm.protocal.protobuf.gce;
import com.tencent.mm.protocal.protobuf.gcl;
import com.tencent.mm.protocal.protobuf.gcq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class o
{
  AtomicInteger cqS;
  public String eoY;
  final Object mLock;
  private int mStatus;
  private boolean rdA;
  private boolean rdB;
  private final HashMap<String, Method> rdC;
  private final HashMap<String, gcl> rdD;
  LinkedList<Pair<String, ValueCallback<String>>> rdE;
  final LinkedList<r> rdF;
  final Map<String, n> rdG;
  final LinkedList<gce> rdH;
  final HashMap<Integer, c> rdI;
  int rdJ;
  long rdK;
  com.tencent.luggage.sdk.b.a.d.d rdo;
  final gbv rdp;
  private String rdq;
  private int rdr;
  private int rds;
  gcq rdt;
  p rdu;
  long rdv;
  long rdw;
  long rdx;
  long rdy;
  AtomicInteger rdz;
  
  public o()
  {
    AppMethodBeat.i(147009);
    this.rdr = 0;
    this.rds = 0;
    this.mStatus = 0;
    this.cqS = new AtomicInteger(0);
    this.rdv = 0L;
    this.rdw = 0L;
    this.rdy = System.currentTimeMillis();
    this.rdz = new AtomicInteger(0);
    this.rdC = new HashMap();
    this.rdD = new HashMap();
    this.rdE = new LinkedList();
    this.rdF = new LinkedList();
    this.rdG = new HashMap();
    this.rdH = new LinkedList();
    this.rdI = new HashMap();
    this.mLock = new Object();
    this.rdJ = 0;
    this.rdK = 0L;
    this.rdp = new gbv();
    this.rdp.YDV = BuildInfo.CLIENT_VERSION_INT;
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
  
  public final void Ye(String paramString)
  {
    try
    {
      this.rdq = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(com.tencent.luggage.sdk.b.a.d.d paramd, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(147010);
    this.rdo = paramd;
    x.setUin(this.rdo.aqZ().asA().uin);
    this.rdu = x.Yl(paramString);
    paramString = this.rdo.aqZ().asz();
    if (paramString != null)
    {
      paramString.epB = this.rdu.epB;
      paramString.eoX = true;
      paramd = (a)paramd.aqZ().aN(a.class);
      if (paramd != null) {
        if (paramString.epB) {
          break label102;
        }
      }
    }
    for (;;)
    {
      paramd.tmY = bool;
      AppMethodBeat.o(147010);
      return;
      label102:
      bool = false;
    }
  }
  
  public final String clA()
  {
    try
    {
      String str = this.rdq;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int clB()
  {
    try
    {
      int i = this.rdr;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int clC()
  {
    try
    {
      int i = this.rds;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean clD()
  {
    try
    {
      boolean bool = this.rdB;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean clE()
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
  
  public final boolean clF()
  {
    return this.rdu.rdO == 3;
  }
  
  public final void fk(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.rds >= paramInt1) && (this.rds <= paramInt2)) {
        this.rds = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void iK(boolean paramBoolean)
  {
    try
    {
      this.rdA = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void iL(boolean paramBoolean)
  {
    try
    {
      this.rdB = paramBoolean;
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
      boolean bool = this.rdA;
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
    //   2: ldc 222
    //   4: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 206	com/tencent/mm/plugin/appbrand/debugger/o:getStatus	()I
    //   11: iconst_3
    //   12: if_icmpne +14 -> 26
    //   15: iconst_1
    //   16: istore_1
    //   17: ldc 222
    //   19: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_1
    //   28: ldc 222
    //   30: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void zK(int paramInt)
  {
    try
    {
      this.rdr = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void zL(int paramInt)
  {
    try
    {
      if (this.rds < paramInt) {
        this.rds = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void zM(int paramInt)
  {
    this.rdK += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.o
 * JD-Core Version:    0.7.0.1
 */