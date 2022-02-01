package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.AssertionFailedError;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kt/AssertCat;", "Lcom/tencent/mm/kt/IAssert;", "idKeyArray", "", "", "kv", "", "name", "", "generator", "Lcom/tencent/mm/kt/AssertCat$ConfigGenerator;", "([Ljava/lang/Long;ILjava/lang/String;Lcom/tencent/mm/kt/AssertCat$ConfigGenerator;)V", "getGenerator", "()Lcom/tencent/mm/kt/AssertCat$ConfigGenerator;", "[Ljava/lang/Long;", "getKv", "()I", "getName", "()Ljava/lang/String;", "assertEquals", "", "key", "expected", "", "actual", "level", "Lcom/tencent/mm/kt/IAssert$LEVEL;", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "fail", "method", "ConfigGenerator", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements e
{
  private final Long[] mHt;
  private final int mHu;
  private final a mHv;
  private final String name;
  
  public b(Long[] paramArrayOfLong, String paramString, a parama)
  {
    AppMethodBeat.i(233434);
    this.mHt = paramArrayOfLong;
    this.mHu = 20889;
    this.name = paramString;
    this.mHv = parama;
    AppMethodBeat.o(233434);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, e.b paramb)
  {
    AppMethodBeat.i(233441);
    int i = this.mHv.FJ(paramString2);
    if (paramb.value <= e.b.mHM.value) {
      Log.w(this.name, paramString1 + ": key=[" + paramString2 + ':' + i + "] message=" + paramString3);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        int j = i / 255;
        if ((i > 0) && (this.mHt.length > j))
        {
          long l1 = this.mHt[j].longValue();
          long l2 = i;
          paramString1 = com.tencent.mm.compatible.d.a.lQN;
          com.tencent.mm.compatible.d.a.T(l1, l2);
        }
        paramString1 = com.tencent.mm.compatible.d.a.lQN;
        com.tencent.mm.compatible.d.a.c(this.mHu, new Object[] { String.valueOf(this.mHv.getVersion()), String.valueOf(i), paramString3, paramString2, Integer.valueOf(paramb.value) });
      }
      if (!paramBoolean2) {
        break;
      }
      paramString1 = new AssertionFailedError(paramString3);
      AppMethodBeat.o(233441);
      throw paramString1;
      Log.e(this.name, paramString1 + ": key=[" + paramString2 + ':' + i + "] message=" + paramString3);
    }
    AppMethodBeat.o(233441);
  }
  
  public final void a(String paramString, Object paramObject, e.b paramb, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.a<String> parama)
  {
    AppMethodBeat.i(369552);
    s.u(paramString, "key");
    s.u(paramb, "level");
    s.u(parama, "message");
    if (paramObject == null) {
      a("assertNotNull", paramString, (String)parama.invoke(), paramBoolean1, paramBoolean2, paramb);
    }
    AppMethodBeat.o(369552);
  }
  
  public final void a(String paramString, boolean paramBoolean1, e.b paramb, boolean paramBoolean2, boolean paramBoolean3, kotlin.g.a.a<String> parama)
  {
    AppMethodBeat.i(233446);
    s.u(paramString, "key");
    s.u(paramb, "level");
    s.u(parama, "message");
    if (!paramBoolean1) {
      a("assertTrue", paramString, (String)parama.invoke(), paramBoolean2, paramBoolean3, paramb);
    }
    AppMethodBeat.o(233446);
  }
  
  public final void b(String paramString, boolean paramBoolean1, e.b paramb, boolean paramBoolean2, boolean paramBoolean3, kotlin.g.a.a<String> parama)
  {
    AppMethodBeat.i(233450);
    s.u(paramString, "key");
    s.u(paramb, "level");
    s.u(parama, "message");
    if (paramBoolean1) {
      a("assertFalse", paramString, (String)parama.invoke(), paramBoolean2, paramBoolean3, paramb);
    }
    AppMethodBeat.o(233450);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/kt/AssertCat$ConfigGenerator;", "", "generateIdKeyId", "", "key", "", "getVersion", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract int FJ(String paramString);
    
    public abstract int getVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ae.b
 * JD-Core Version:    0.7.0.1
 */