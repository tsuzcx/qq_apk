package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.AssertionFailedError;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/kt/AssertCat;", "Lcom/tencent/mm/kt/IAssert;", "idkeyArray", "", "", "kv", "", "name", "", "generator", "Lcom/tencent/mm/kt/AssertCat$IdsGenerator;", "([Ljava/lang/Long;ILjava/lang/String;Lcom/tencent/mm/kt/AssertCat$IdsGenerator;)V", "getGenerator", "()Lcom/tencent/mm/kt/AssertCat$IdsGenerator;", "[Ljava/lang/Long;", "getKv", "()I", "getName", "()Ljava/lang/String;", "assertEquals", "", "key", "expected", "", "actual", "isReport", "", "isThrow", "message", "Lkotlin/Function0;", "assertFalse", "condition", "assertNotNull", "assertNotSame", "assertNull", "assertSame", "assertTrue", "fail", "method", "IdsGenerator", "libktcomm_release"})
public final class b
  implements f
{
  private final Long[] hve;
  private final int hvf;
  private final a hvg;
  private final String name;
  
  public b(Long[] paramArrayOfLong, String paramString, a parama)
  {
    AppMethodBeat.i(204374);
    this.hve = paramArrayOfLong;
    this.hvf = 20889;
    this.name = paramString;
    this.hvg = parama;
    AppMethodBeat.o(204374);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(204373);
    int i = this.hvg.getId(paramString2);
    int j = i / 255;
    if (this.hve.length <= j)
    {
      AppMethodBeat.o(204373);
      return;
    }
    long l1 = this.hve[j].longValue();
    Log.e(this.name, paramString1 + ": key=[" + paramString2 + ':' + i + "] idKey=" + l1 + " message=" + paramString3);
    if (paramBoolean1)
    {
      long l2 = this.hvg.getId(paramString2);
      paramString1 = com.tencent.mm.compatible.d.a.gDv;
      com.tencent.mm.compatible.d.a.v(l1, l2);
      paramString1 = com.tencent.mm.compatible.d.a.gDv;
      com.tencent.mm.compatible.d.a.b(this.hvf, new Object[] { "3", String.valueOf(l2), paramString3 });
    }
    if (paramBoolean2)
    {
      paramString1 = (Throwable)new AssertionFailedError(paramString3);
      AppMethodBeat.o(204373);
      throw paramString1;
    }
    AppMethodBeat.o(204373);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, kotlin.g.a.a<String> parama)
  {
    AppMethodBeat.i(204371);
    p.h(paramString, "key");
    p.h(parama, "message");
    if (!paramBoolean1) {
      a("assertTrue", paramString, (String)parama.invoke(), paramBoolean2, paramBoolean3);
    }
    AppMethodBeat.o(204371);
  }
  
  public final void b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, kotlin.g.a.a<String> parama)
  {
    AppMethodBeat.i(204372);
    p.h(paramString, "key");
    p.h(parama, "message");
    if (paramBoolean1) {
      a("assertFalse", paramString, (String)parama.invoke(), paramBoolean2, paramBoolean3);
    }
    AppMethodBeat.o(204372);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/kt/AssertCat$IdsGenerator;", "", "getId", "", "key", "", "getVersion", "libktcomm_release"})
  public static abstract interface a
  {
    public abstract int getId(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ac.b
 * JD-Core Version:    0.7.0.1
 */