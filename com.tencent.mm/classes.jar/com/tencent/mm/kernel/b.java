package com.tencent.mm.kernel;

import com.tencent.mm.ah.p;
import com.tencent.mm.ah.p.a;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.h.a.ki;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.ca.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.h.a;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  public static String dJR = "wechatnetwork";
  private static aj dJW = null;
  public final a dJS;
  public final p dJT;
  private HashSet<n> dJU = new HashSet();
  public n dJV = new n.a()
  {
    /* Error */
    public final void et(int paramAnonymousInt)
    {
      // Byte code:
      //   0: new 24	java/util/HashSet
      //   3: dup
      //   4: invokespecial 25	java/util/HashSet:<init>	()V
      //   7: astore_3
      //   8: aload_0
      //   9: getfield 14	com/tencent/mm/kernel/b$2:dJX	Lcom/tencent/mm/kernel/b;
      //   12: invokestatic 29	com/tencent/mm/kernel/b:b	(Lcom/tencent/mm/kernel/b;)Ljava/util/HashSet;
      //   15: astore_2
      //   16: aload_2
      //   17: monitorenter
      //   18: aload_3
      //   19: aload_0
      //   20: getfield 14	com/tencent/mm/kernel/b$2:dJX	Lcom/tencent/mm/kernel/b;
      //   23: invokestatic 29	com/tencent/mm/kernel/b:b	(Lcom/tencent/mm/kernel/b;)Ljava/util/HashSet;
      //   26: invokevirtual 33	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
      //   29: pop
      //   30: aload_2
      //   31: monitorexit
      //   32: aload_3
      //   33: invokevirtual 37	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   36: astore_2
      //   37: aload_2
      //   38: invokeinterface 43 1 0
      //   43: ifeq +54 -> 97
      //   46: aload_2
      //   47: invokeinterface 47 1 0
      //   52: checkcast 49	com/tencent/mm/network/n
      //   55: iload_1
      //   56: invokeinterface 51 2 0
      //   61: goto -24 -> 37
      //   64: astore_2
      //   65: ldc 53
      //   67: aload_2
      //   68: ldc 55
      //   70: iconst_0
      //   71: anewarray 57	java/lang/Object
      //   74: invokestatic 63	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   77: new 65	com/tencent/mm/sdk/platformtools/ah
      //   80: dup
      //   81: invokespecial 66	com/tencent/mm/sdk/platformtools/ah:<init>	()V
      //   84: new 8	com/tencent/mm/kernel/b$2$1
      //   87: dup
      //   88: aload_0
      //   89: aload_2
      //   90: invokespecial 69	com/tencent/mm/kernel/b$2$1:<init>	(Lcom/tencent/mm/kernel/b$2;Ljava/lang/Exception;)V
      //   93: invokevirtual 73	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
      //   96: pop
      //   97: return
      //   98: astore_3
      //   99: aload_2
      //   100: monitorexit
      //   101: aload_3
      //   102: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	2
      //   0	103	1	paramAnonymousInt	int
      //   64	36	2	localException	Exception
      //   7	26	3	localHashSet	HashSet
      //   98	4	3	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   0	18	64	java/lang/Exception
      //   32	37	64	java/lang/Exception
      //   37	61	64	java/lang/Exception
      //   101	103	64	java/lang/Exception
      //   18	32	98	finally
      //   99	101	98	finally
    }
  };
  
  public b(p.a parama, a parama1)
  {
    this.dJT = p.a(parama);
    this.dJT.edy = g.DS();
    com.tencent.mm.ah.w.een = new com.tencent.mm.ah.w.b()
    {
      public final p Dl()
      {
        return b.a(b.this);
      }
    };
    this.dJS = parama1;
  }
  
  public static aj Di()
  {
    return dJW;
  }
  
  public static void a(aj paramaj)
  {
    dJW = paramaj;
  }
  
  public static void b(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    ki localki = new ki();
    localki.bTr.status = paramInt1;
    localki.bTr.bTs = paramInt2;
    localki.bTr.bTt = paramBoolean;
    localki.bTr.bTu = paramString;
    com.tencent.mm.sdk.b.a.udP.m(localki);
  }
  
  public final byte[] Dj()
  {
    try
    {
      if ((this.dJT != null) && (this.dJT.edx != null))
      {
        if (this.dJT.edx.KR() == null) {
          return null;
        }
        byte[] arrayOfByte = this.dJT.edx.KR().Dj();
        return arrayOfByte;
      }
    }
    catch (Exception localException)
    {
      y.w("MMKernel.CoreNetwork", "get session key error, %s", new Object[] { localException.getMessage() });
      y.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final p Dk()
  {
    return this.dJT;
  }
  
  public final void a(n paramn)
  {
    synchronized (this.dJU)
    {
      this.dJU.add(paramn);
      return;
    }
  }
  
  public final void b(n paramn)
  {
    synchronized (this.dJU)
    {
      this.dJU.remove(paramn);
      return;
    }
  }
  
  public static final class a
    extends com.tencent.mm.ck.a<d>
    implements d
  {
    public final void b(final com.tencent.mm.network.e parame)
    {
      a(new a.a() {});
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b
 * JD-Core Version:    0.7.0.1
 */