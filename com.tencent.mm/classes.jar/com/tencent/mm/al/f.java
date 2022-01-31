package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public class f
  implements at
{
  private long fzA;
  private ak fzB;
  private com.tencent.mm.ai.f fzC;
  private a fzx;
  private b fzy;
  private c fzz;
  
  public f()
  {
    AppMethodBeat.i(78077);
    this.fzx = null;
    this.fzy = null;
    this.fzA = 0L;
    this.fzB = new f.2(this, Looper.getMainLooper());
    this.fzC = new f.3(this);
    AppMethodBeat.o(78077);
  }
  
  public static f afL()
  {
    try
    {
      AppMethodBeat.i(78078);
      f localf = (f)q.S(f.class);
      AppMethodBeat.o(78078);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String afM()
  {
    AppMethodBeat.i(78079);
    g.RJ().QQ();
    String str = g.RL().cachePath + "cdndnsinfo/";
    AppMethodBeat.o(78079);
    return str;
  }
  
  public static c afN()
  {
    AppMethodBeat.i(78080);
    c localc = afL().fzz;
    AppMethodBeat.o(78080);
    return localc;
  }
  
  public static b afO()
  {
    AppMethodBeat.i(78082);
    if (afL().fzy == null) {}
    try
    {
      if (afL().fzy == null) {
        afL().fzy = new b();
      }
      b localb = afL().fzy;
      AppMethodBeat.o(78082);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(78082);
    }
  }
  
  /* Error */
  public static a afP()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 123
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 112	com/tencent/mm/al/f:afL	()Lcom/tencent/mm/al/f;
    //   11: getfield 31	com/tencent/mm/al/f:fzx	Lcom/tencent/mm/al/a;
    //   14: ifnonnull +35 -> 49
    //   17: invokestatic 80	com/tencent/mm/kernel/g:RJ	()Lcom/tencent/mm/kernel/a;
    //   20: pop
    //   21: invokestatic 127	com/tencent/mm/kernel/a:QT	()Z
    //   24: ifeq +42 -> 66
    //   27: invokestatic 112	com/tencent/mm/al/f:afL	()Lcom/tencent/mm/al/f;
    //   30: new 129	com/tencent/mm/al/a
    //   33: dup
    //   34: invokestatic 92	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   37: getfield 98	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   40: invokestatic 131	com/tencent/mm/al/f:afO	()Lcom/tencent/mm/al/b;
    //   43: invokespecial 134	com/tencent/mm/al/a:<init>	(Ljava/lang/String;Lcom/tencent/mm/i/b$a;)V
    //   46: putfield 31	com/tencent/mm/al/f:fzx	Lcom/tencent/mm/al/a;
    //   49: invokestatic 112	com/tencent/mm/al/f:afL	()Lcom/tencent/mm/al/f;
    //   52: getfield 31	com/tencent/mm/al/f:fzx	Lcom/tencent/mm/al/a;
    //   55: astore_0
    //   56: ldc 123
    //   58: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: areturn
    //   66: new 87	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 136
    //   72: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: new 141	java/util/Random
    //   78: dup
    //   79: invokespecial 142	java/util/Random:<init>	()V
    //   82: invokevirtual 146	java/util/Random:nextLong	()J
    //   85: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 155	java/lang/String:getBytes	()[B
    //   94: invokestatic 161	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   97: astore_0
    //   98: new 87	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   105: getstatic 166	com/tencent/mm/storage/ac:eQv	Ljava/lang/String;
    //   108: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 168
    //   117: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore_0
    //   124: ldc 170
    //   126: ldc 172
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_0
    //   135: aastore
    //   136: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: invokestatic 112	com/tencent/mm/al/f:afL	()Lcom/tencent/mm/al/f;
    //   142: new 129	com/tencent/mm/al/a
    //   145: dup
    //   146: aload_0
    //   147: invokestatic 131	com/tencent/mm/al/f:afO	()Lcom/tencent/mm/al/b;
    //   150: invokespecial 134	com/tencent/mm/al/a:<init>	(Ljava/lang/String;Lcom/tencent/mm/i/b$a;)V
    //   153: putfield 31	com/tencent/mm/al/f:fzx	Lcom/tencent/mm/al/a;
    //   156: goto -107 -> 49
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	92	0	localObject1	Object
    //   159	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	49	159	finally
    //   49	61	159	finally
    //   66	156	159	finally
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void le(int paramInt)
  {
    AppMethodBeat.i(78085);
    this.fzA = 0L;
    this.fzB.removeMessages(1);
    g.Rc().a(new d(paramInt), 0);
    AppMethodBeat.o(78085);
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(78081);
    onAccountRelease();
    g.RJ().QQ();
    if (afL().fzy == null)
    {
      afL().fzy = new b();
      ab.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", new Object[] { Integer.valueOf(afL().fzy.hashCode()) });
    }
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(afM());
    if (!localb.exists()) {
      localb.mkdirs();
    }
    this.fzz = new f.1(this);
    g.Rc().a(379, this.fzC);
    ab.i("MicroMsg.SubCoreCdnTransport", "onAccountPostReset, tryToGetCdnDns");
    le(1);
    AppMethodBeat.o(78081);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(78084);
    this.fzz = null;
    Object localObject;
    if (this.fzx != null)
    {
      localObject = this.fzx;
      CdnLogic.UnInitialize();
      ((a)localObject).fyz = null;
      this.fzx = null;
    }
    if (this.fzy != null)
    {
      localObject = this.fzy;
      if (g.RJ().QU()) {
        g.RL().Ru().b((n.b)localObject);
      }
      ((b)localObject).fyH.removeCallbacksAndMessages(null);
      g.RK().b(((b)localObject).fyJ);
      g.RK().eHt.b(379, (com.tencent.mm.ai.f)localObject);
      com.tencent.mm.sdk.b.a.ymk.d(((b)localObject).fyI);
      this.fzy = null;
    }
    this.fzA = 0L;
    this.fzB.removeCallbacksAndMessages(null);
    g.Rc().b(379, this.fzC);
    AppMethodBeat.o(78084);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.al.f
 * JD-Core Version:    0.7.0.1
 */