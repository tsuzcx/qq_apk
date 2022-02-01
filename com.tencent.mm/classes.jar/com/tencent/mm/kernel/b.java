package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.al.q.a;
import com.tencent.mm.al.x.b;
import com.tencent.mm.co.a.a;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;

public final class b
{
  private static ao gcB = null;
  public n gcA;
  public final a gcx;
  public final q gcy;
  private HashSet<n> gcz;
  
  public b(q.a parama, a parama1)
  {
    AppMethodBeat.i(132057);
    this.gcz = new HashSet();
    this.gcA = new n.a()
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
        //   14: getfield 12	com/tencent/mm/kernel/b$2:gcC	Lcom/tencent/mm/kernel/b;
        //   17: invokestatic 33	com/tencent/mm/kernel/b:b	(Lcom/tencent/mm/kernel/b;)Ljava/util/HashSet;
        //   20: astore_2
        //   21: aload_2
        //   22: monitorenter
        //   23: aload_3
        //   24: aload_0
        //   25: getfield 12	com/tencent/mm/kernel/b$2:gcC	Lcom/tencent/mm/kernel/b;
        //   28: invokestatic 33	com/tencent/mm/kernel/b:b	(Lcom/tencent/mm/kernel/b;)Ljava/util/HashSet;
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
        //   57: checkcast 53	com/tencent/mm/network/n
        //   60: iload_1
        //   61: invokeinterface 55 2 0
        //   66: goto -24 -> 42
        //   69: astore_2
        //   70: ldc 57
        //   72: aload_2
        //   73: ldc 59
        //   75: iconst_0
        //   76: anewarray 61	java/lang/Object
        //   79: invokestatic 67	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        //   91	98	69	java/lang/Exception
        //   23	37	88	finally
        //   89	91	88	finally
      }
    };
    this.gcy = q.a(parama);
    this.gcy.gVI = g.afE();
    com.tencent.mm.al.x.gWv = new x.b()
    {
      public final q aeT()
      {
        AppMethodBeat.i(132046);
        q localq = b.a(b.this);
        AppMethodBeat.o(132046);
        return localq;
      }
    };
    this.gcx = parama1;
    AppMethodBeat.o(132057);
  }
  
  public static void a(ao paramao)
  {
    gcB = paramao;
  }
  
  public static ao aeQ()
  {
    return gcB;
  }
  
  public static void b(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(132062);
    ma localma = new ma();
    localma.drf.status = paramInt1;
    localma.drf.drg = paramInt2;
    localma.drf.drh = paramBoolean;
    localma.drf.dri = paramString;
    com.tencent.mm.sdk.b.a.ESL.l(localma);
    AppMethodBeat.o(132062);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(132058);
    synchronized (this.gcz)
    {
      this.gcz.add(paramn);
      AppMethodBeat.o(132058);
      return;
    }
  }
  
  public final void aeR()
  {
    AppMethodBeat.i(132060);
    this.gcy.a(new bn(new bn.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(132048);
        if ((paramAnonymouse == null) || (paramAnonymouse.avg() == null))
        {
          AppMethodBeat.o(132048);
          return;
        }
        paramAnonymouse.avg().reset();
        AppMethodBeat.o(132048);
      }
    }, "reset accinfo"), 0);
    AppMethodBeat.o(132060);
  }
  
  public final q aeS()
  {
    return this.gcy;
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(132059);
    synchronized (this.gcz)
    {
      this.gcz.remove(paramn);
      AppMethodBeat.o(132059);
      return;
    }
  }
  
  public final byte[] mq(int paramInt)
  {
    AppMethodBeat.i(132061);
    try
    {
      if ((this.gcy != null) && (this.gcy.gVH != null))
      {
        localObject = this.gcy.gVH.avg();
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(132061);
        return null;
      }
      Object localObject = this.gcy.gVH.avg().mq(paramInt);
      AppMethodBeat.o(132061);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.w("MMKernel.CoreNetwork", "get session key error, %s", new Object[] { localException.getMessage() });
      ad.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132061);
    }
    return null;
  }
  
  public static final class a
    extends com.tencent.mm.co.a<d>
    implements d
  {
    public final void b(final e parame)
    {
      AppMethodBeat.i(132056);
      a(new a.a() {});
      AppMethodBeat.o(132056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b
 * JD-Core Version:    0.7.0.1
 */