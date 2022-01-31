package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.p.a;
import com.tencent.mm.ai.w.b;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.h.a;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  public static String eHr = "wechatnetwork";
  private static al eHw = null;
  public final a eHs;
  public final p eHt;
  private HashSet<n> eHu;
  public n eHv;
  
  public b(p.a parama, a parama1)
  {
    AppMethodBeat.i(57933);
    this.eHu = new HashSet();
    this.eHv = new n.a()
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
        //   14: getfield 12	com/tencent/mm/kernel/b$2:eHx	Lcom/tencent/mm/kernel/b;
        //   17: invokestatic 33	com/tencent/mm/kernel/b:b	(Lcom/tencent/mm/kernel/b;)Ljava/util/HashSet;
        //   20: astore_2
        //   21: aload_2
        //   22: monitorenter
        //   23: aload_3
        //   24: aload_0
        //   25: getfield 12	com/tencent/mm/kernel/b$2:eHx	Lcom/tencent/mm/kernel/b;
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
        //   79: invokestatic 67	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    this.eHt = p.a(parama);
    this.eHt.ftB = g.RO();
    com.tencent.mm.ai.w.fuq = new w.b()
    {
      public final p Rd()
      {
        AppMethodBeat.i(57922);
        p localp = b.a(b.this);
        AppMethodBeat.o(57922);
        return localp;
      }
    };
    this.eHs = parama1;
    AppMethodBeat.o(57933);
  }
  
  public static al Ra()
  {
    return eHw;
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(57938);
    kv localkv = new kv();
    localkv.cAW.status = paramInt1;
    localkv.cAW.cAX = paramInt2;
    localkv.cAW.cAY = paramBoolean;
    localkv.cAW.cAZ = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localkv);
    AppMethodBeat.o(57938);
  }
  
  public static void a(al paramal)
  {
    eHw = paramal;
  }
  
  public final void Rb()
  {
    AppMethodBeat.i(57936);
    this.eHt.a(new bk(new bk.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        AppMethodBeat.i(57924);
        if ((paramAnonymouse == null) || (paramAnonymouse.adI() == null))
        {
          AppMethodBeat.o(57924);
          return;
        }
        paramAnonymouse.adI().reset();
        AppMethodBeat.o(57924);
      }
    }, "reset accinfo"), 0);
    AppMethodBeat.o(57936);
  }
  
  public final p Rc()
  {
    return this.eHt;
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(57934);
    synchronized (this.eHu)
    {
      this.eHu.add(paramn);
      AppMethodBeat.o(57934);
      return;
    }
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(57935);
    synchronized (this.eHu)
    {
      this.eHu.remove(paramn);
      AppMethodBeat.o(57935);
      return;
    }
  }
  
  public final byte[] jN(int paramInt)
  {
    AppMethodBeat.i(57937);
    try
    {
      if ((this.eHt != null) && (this.eHt.ftA != null))
      {
        localObject = this.eHt.ftA.adI();
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(57937);
        return null;
      }
      Object localObject = this.eHt.ftA.adI().jN(paramInt);
      AppMethodBeat.o(57937);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.w("MMKernel.CoreNetwork", "get session key error, %s", new Object[] { localException.getMessage() });
      ab.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(57937);
    }
    return null;
  }
  
  public static final class a
    extends com.tencent.mm.cm.a<d>
    implements d
  {
    public final void b(final com.tencent.mm.network.e parame)
    {
      AppMethodBeat.i(57932);
      a(new a.a() {});
      AppMethodBeat.o(57932);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b
 * JD-Core Version:    0.7.0.1
 */