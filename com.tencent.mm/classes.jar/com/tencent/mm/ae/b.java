package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.AssertionFailedError;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/kt/AssertCat;", "Lcom/tencent/mm/kt/IAssert;", "idkeyArray", "", "", "kv", "", "name", "", "generator", "Lcom/tencent/mm/kt/AssertCat$ConfigGenerator;", "([Ljava/lang/Long;ILjava/lang/String;Lcom/tencent/mm/kt/AssertCat$ConfigGenerator;)V", "getGenerator", "()Lcom/tencent/mm/kt/AssertCat$ConfigGenerator;", "[Ljava/lang/Long;", "getKv", "()I", "getName", "()Ljava/lang/String;", "assertEquals", "", "key", "expected", "", "actual", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "fail", "method", "ConfigGenerator", "libktcomm_release"})
public final class b
  implements f
{
  private final Long[] kha;
  private final int khb;
  private final a khc;
  private final String name;
  
  public b(Long[] paramArrayOfLong, String paramString, a parama)
  {
    AppMethodBeat.i(243440);
    this.kha = paramArrayOfLong;
    this.khb = 20889;
    this.name = paramString;
    this.khc = parama;
    AppMethodBeat.o(243440);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(243439);
    int i = this.khc.Na(paramString2);
    Log.e(this.name, paramString1 + ": key=[" + paramString2 + ':' + i + "] message=" + paramString3);
    if (paramBoolean1)
    {
      int j = i / 255;
      if ((i > 0) && (this.kha.length > j))
      {
        long l1 = this.kha[j].longValue();
        long l2 = i;
        paramString1 = com.tencent.mm.compatible.d.a.jnF;
        com.tencent.mm.compatible.d.a.v(l1, l2);
      }
      paramString1 = com.tencent.mm.compatible.d.a.jnF;
      com.tencent.mm.compatible.d.a.b(this.khb, new Object[] { "4", String.valueOf(i), paramString3, paramString2 });
    }
    if (paramBoolean2)
    {
      paramString1 = (Throwable)new AssertionFailedError(paramString3);
      AppMethodBeat.o(243439);
      throw paramString1;
    }
    AppMethodBeat.o(243439);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, kotlin.g.a.a<String> parama)
  {
    AppMethodBeat.i(243437);
    p.k(paramString, "key");
    p.k(parama, "message");
    if (!paramBoolean1) {
      a("assertTrue", paramString, (String)parama.invoke(), paramBoolean2, paramBoolean3);
    }
    AppMethodBeat.o(243437);
  }
  
  public final void b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, kotlin.g.a.a<String> parama)
  {
    AppMethodBeat.i(243438);
    p.k(paramString, "key");
    p.k(parama, "message");
    if (paramBoolean1) {
      a("assertFalse", paramString, (String)parama.invoke(), paramBoolean2, paramBoolean3);
    }
    AppMethodBeat.o(243438);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/kt/AssertCat$ConfigGenerator;", "", "generateIdKeyId", "", "key", "", "getVersion", "libktcomm_release"})
  public static abstract interface a
  {
    public abstract int Na(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ae.b
 * JD-Core Version:    0.7.0.1
 */