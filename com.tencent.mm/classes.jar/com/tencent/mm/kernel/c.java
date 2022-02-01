package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.b;
import com.tencent.mm.an.t;
import com.tencent.mm.an.t.a;
import com.tencent.mm.cw.a;
import com.tencent.mm.cw.a.a;
import com.tencent.mm.f.a.oc;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.cn.a;
import com.tencent.mm.network.d.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.j.a;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.crash.CallbackForReset;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  private static aw kcg = null;
  public final a kcc;
  public final t kcd;
  private HashSet<p> kce;
  public p kcf;
  
  public c(t.a parama, a parama1)
  {
    AppMethodBeat.i(132057);
    this.kce = new HashSet();
    this.kcf = new p.a()
    {
      /* Error */
      public final void onNetworkChange(int paramAnonymousInt)
      {
        // Byte code:
        //   0: ldc 21
        //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 28	java/util/HashSet
        //   8: dup
        //   9: invokespecial 29	java/util/HashSet:<init>	()V
        //   12: astore_3
        //   13: aload_0
        //   14: getfield 12	com/tencent/mm/kernel/c$2:kch	Lcom/tencent/mm/kernel/c;
        //   17: invokestatic 33	com/tencent/mm/kernel/c:b	(Lcom/tencent/mm/kernel/c;)Ljava/util/HashSet;
        //   20: astore_2
        //   21: aload_2
        //   22: monitorenter
        //   23: aload_3
        //   24: aload_0
        //   25: getfield 12	com/tencent/mm/kernel/c$2:kch	Lcom/tencent/mm/kernel/c;
        //   28: invokestatic 33	com/tencent/mm/kernel/c:b	(Lcom/tencent/mm/kernel/c;)Ljava/util/HashSet;
        //   31: invokevirtual 37	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
        //   34: pop
        //   35: aload_2
        //   36: monitorexit
        //   37: aload_3
        //   38: invokevirtual 41	java/util/HashSet:iterator	()Ljava/util/Iterator;
        //   41: astore_2
        //   42: aload_2
        //   43: invokeinterface 47 1 0
        //   48: ifeq +50 -> 98
        //   51: aload_2
        //   52: invokeinterface 51 1 0
        //   57: checkcast 53	com/tencent/mm/network/p
        //   60: iload_1
        //   61: invokeinterface 55 2 0
        //   66: goto -24 -> 42
        //   69: astore_2
        //   70: ldc 57
        //   72: aload_2
        //   73: ldc 59
        //   75: iconst_0
        //   76: anewarray 61	java/lang/Object
        //   79: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   82: ldc 21
        //   84: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   87: return
        //   88: astore_3
        //   89: aload_2
        //   90: monitorexit
        //   91: ldc 21
        //   93: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   96: aload_3
        //   97: athrow
        //   98: ldc 21
        //   100: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   103: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	2
        //   0	104	1	paramAnonymousInt	int
        //   69	21	2	localException	Exception
        //   12	26	3	localHashSet	HashSet
        //   88	9	3	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   5	23	69	java/lang/Exception
        //   37	42	69	java/lang/Exception
        //   42	66	69	java/lang/Exception
        //   89	98	69	java/lang/Exception
        //   23	37	88	finally
      }
    };
    this.kcd = t.a(parama);
    this.kcd.lCE = h.aHJ();
    com.tencent.mm.an.aa.lDv = new aa.b()
    {
      public final t aGZ()
      {
        AppMethodBeat.i(132046);
        t localt = c.a(c.this);
        AppMethodBeat.o(132046);
        return localt;
      }
    };
    this.kcc = parama1;
    AppMethodBeat.o(132057);
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132062);
    oc localoc = new oc();
    localoc.fMT.status = paramInt1;
    localoc.fMT.fMU = paramInt2;
    localoc.fMT.fMV = paramBoolean;
    localoc.fMT.fMW = paramString;
    EventCenter.instance.publish(localoc);
    AppMethodBeat.o(132062);
  }
  
  public static void a(aw paramaw)
  {
    kcg = paramaw;
  }
  
  public static aw aGW()
  {
    return kcg;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(132058);
    synchronized (this.kce)
    {
      this.kce.add(paramp);
      AppMethodBeat.o(132058);
      return;
    }
  }
  
  public final void aGX()
  {
    AppMethodBeat.i(132060);
    this.kcd.a(new bv(new bv.a()
    {
      public final void a(g paramAnonymousg)
      {
        AppMethodBeat.i(132048);
        if ((paramAnonymousg == null) || (paramAnonymousg.biw() == null))
        {
          AppMethodBeat.o(132048);
          return;
        }
        paramAnonymousg.biw().reset();
        AppMethodBeat.o(132048);
      }
    }, "reset accinfo"), 0);
    AppMethodBeat.o(132060);
  }
  
  public final t aGY()
  {
    return this.kcd;
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(132059);
    synchronized (this.kce)
    {
      this.kce.remove(paramp);
      AppMethodBeat.o(132059);
      return;
    }
  }
  
  public final byte[] sE(int paramInt)
  {
    AppMethodBeat.i(132061);
    try
    {
      if ((this.kcd != null) && (this.kcd.lCD != null))
      {
        localObject = this.kcd.lCD.biw();
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(132061);
        return null;
      }
      Object localObject = this.kcd.lCD.biw().sE(paramInt);
      AppMethodBeat.o(132061);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.w("MMKernel.CoreNetwork", "get session key error, %s", new Object[] { localException.getMessage() });
      Log.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132061);
    }
    return null;
  }
  
  public static final class a
    extends a<d>
    implements d
  {
    public final void b(final g paramg)
    {
      AppMethodBeat.i(132056);
      a(new a.a() {});
      AppMethodBeat.o(132056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.c
 * JD-Core Version:    0.7.0.1
 */