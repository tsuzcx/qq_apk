package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.protocal.protobuf.ebg;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.sdk.platformtools.j;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class m
{
  final HashMap<Integer, c> keA;
  int keB;
  long keC;
  com.tencent.luggage.sdk.b.a.c.c kee;
  final ear kef;
  private String keg;
  private int keh;
  private int kei;
  ebl kej;
  n kek;
  AtomicInteger kel;
  long kem;
  long ken;
  long keo;
  long kep;
  AtomicInteger keq;
  private boolean ker;
  private boolean kes;
  private final HashMap<String, Method> ket;
  private final HashMap<String, ebg> keu;
  LinkedList<Pair<String, ValueCallback<String>>> kev;
  final LinkedList<p> kew;
  final Map<String, l> kex;
  final LinkedList<eaz> kez;
  final Object mLock;
  private int mStatus;
  
  public m()
  {
    AppMethodBeat.i(147009);
    this.keh = 0;
    this.kei = 0;
    this.mStatus = 0;
    this.kel = new AtomicInteger(0);
    this.kem = 0L;
    this.ken = 0L;
    this.kep = System.currentTimeMillis();
    this.keq = new AtomicInteger(0);
    this.ket = new HashMap();
    this.keu = new HashMap();
    this.kev = new LinkedList();
    this.kew = new LinkedList();
    this.kex = new HashMap();
    this.kez = new LinkedList();
    this.keA = new HashMap();
    this.mLock = new Object();
    this.keB = 0;
    this.keC = 0L;
    this.kef = new ear();
    this.kef.FMa = j.IwD;
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
  
  public final void OH(String paramString)
  {
    try
    {
      this.keg = paramString;
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
    this.kee = paramc;
    v.setUin(this.kee.Eq().Fg().uin);
    this.kek = v.OO(paramString);
    paramString = this.kee.Eq().Ff();
    if (paramString != null)
    {
      paramString.cmJ = this.kek.cmJ;
      paramString.cmu = true;
      paramc = (a)paramc.Eq().ar(a.class);
      if (paramc != null) {
        if (paramString.cmJ) {
          break label102;
        }
      }
    }
    for (;;)
    {
      paramc.lZO = bool;
      AppMethodBeat.o(147010);
      return;
      label102:
      bool = false;
    }
  }
  
  public final String bfm()
  {
    try
    {
      String str = this.keg;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bfn()
  {
    try
    {
      int i = this.keh;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bfo()
  {
    try
    {
      int i = this.kei;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bfp()
  {
    try
    {
      boolean bool = this.kes;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bfq()
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
  
  public final boolean bfr()
  {
    return this.kek.keG == 3;
  }
  
  public final void dH(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.kei >= paramInt1) && (this.kei <= paramInt2)) {
        this.kei = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void fZ(boolean paramBoolean)
  {
    try
    {
      this.ker = paramBoolean;
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
      this.kes = paramBoolean;
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
      boolean bool = this.ker;
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
  
  public final void sm(int paramInt)
  {
    try
    {
      this.keh = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void sn(int paramInt)
  {
    try
    {
      if (this.kei < paramInt) {
        this.kei = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void so(int paramInt)
  {
    this.keC += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.m
 * JD-Core Version:    0.7.0.1
 */