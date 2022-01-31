package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.protocal.c.cgd;
import com.tencent.mm.protocal.c.cgl;
import com.tencent.mm.protocal.c.cgs;
import com.tencent.mm.protocal.c.cgx;
import com.tencent.mm.protocal.d;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class j
{
  o fRI;
  final cgd fRJ = new cgd();
  private String fRK;
  private int fRL = 0;
  private int fRM = 0;
  cgx fRN;
  k fRO;
  AtomicInteger fRP = new AtomicInteger(0);
  long fRQ = 0L;
  long fRR = 0L;
  long fRS;
  long fRT = System.currentTimeMillis();
  AtomicInteger fRU = new AtomicInteger(0);
  private boolean fRV;
  private boolean fRW;
  private final HashMap<String, Method> fRX = new HashMap();
  private final HashMap<String, cgs> fRY = new HashMap();
  LinkedList<Pair<String, ValueCallback<String>>> fRZ = new LinkedList();
  final LinkedList<m> fSa = new LinkedList();
  final Map<String, i> fSb = new HashMap();
  final LinkedList<cgl> fSc = new LinkedList();
  final HashMap<Integer, a> fSd = new HashMap();
  int fSe = 0;
  long fSf = 0L;
  final Object mLock = new Object();
  private int mStatus = 0;
  
  public j()
  {
    this.fRJ.sGh = d.spa;
  }
  
  public final void a(o paramo, String paramString)
  {
    this.fRI = paramo;
    this.fRO = r.sR(paramString);
    paramo = (AppBrandSysConfigWC)this.fRI.getRuntime().ZB();
    if (paramo != null)
    {
      paramo.fPV = this.fRO.fPV;
      paramo.fPx = true;
    }
  }
  
  public final int aeA()
  {
    try
    {
      int i = this.fRL;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int aeB()
  {
    try
    {
      int i = this.fRM;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean aeC()
  {
    try
    {
      boolean bool = this.fRW;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean aeD()
  {
    return getStatus() == 4;
  }
  
  public final boolean aeE()
  {
    return this.fRO.fSj == 3;
  }
  
  public final String aez()
  {
    try
    {
      String str = this.fRK;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bO(int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.fRM >= paramInt1) && (this.fRM <= paramInt2)) {
        this.fRM = paramInt2;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cN(boolean paramBoolean)
  {
    try
    {
      this.fRV = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cO(boolean paramBoolean)
  {
    try
    {
      this.fRW = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int getStatus()
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
  
  public final boolean isBusy()
  {
    try
    {
      boolean bool = this.fRV;
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
    //   2: aload_0
    //   3: invokevirtual 167	com/tencent/mm/plugin/appbrand/debugger/j:getStatus	()I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_3
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	j
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public final void kD(int paramInt)
  {
    try
    {
      this.fRL = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void kE(int paramInt)
  {
    try
    {
      if (this.fRM < paramInt) {
        this.fRM = paramInt;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void sK(String paramString)
  {
    try
    {
      this.fRK = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.j
 * JD-Core Version:    0.7.0.1
 */