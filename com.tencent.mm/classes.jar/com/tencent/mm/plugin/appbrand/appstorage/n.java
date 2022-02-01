package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class n
  extends o
{
  private final String qMG;
  private final String qMH;
  private String qMI;
  private final ab qMJ;
  public volatile long qMK;
  
  public n(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(323255);
    this.qMK = -1L;
    this.qMI = paramString1;
    paramString1 = ah.v(new u(paramString1).jKT());
    this.qMG = paramString2;
    this.qMH = paramString3;
    this.qMJ = new ab(paramString1, this.qMG, this.qMH, parama);
    AppMethodBeat.o(323255);
  }
  
  public final boolean Vq(String paramString)
  {
    AppMethodBeat.i(323258);
    boolean bool = Util.nullAsNil(paramString).startsWith(this.qMH);
    AppMethodBeat.o(323258);
    return bool;
  }
  
  public final r Vr(String paramString)
  {
    AppMethodBeat.i(323264);
    if (this.qMJ.fu(paramString) == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(323264);
      return paramString;
    }
    paramString = r.qML;
    AppMethodBeat.o(323264);
    return paramString;
  }
  
  public final u Wj(String paramString)
  {
    AppMethodBeat.i(323276);
    paramString = this.qMJ.Wx(paramString);
    AppMethodBeat.o(323276);
    return paramString;
  }
  
  public final boolean Wk(String paramString)
  {
    return false;
  }
  
  public final r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(323273);
    if (!Vq(paramString))
    {
      paramString = r.qNb;
      AppMethodBeat.o(323273);
      return paramString;
    }
    paramString = this.qMJ.fu(paramString);
    if (paramString == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(323273);
      return paramString;
    }
    int i = paramString.limit();
    if (paramLong2 > 2147483647L) {
      paramLong2 = i - paramLong1;
    }
    for (;;)
    {
      Object localObject = h(paramLong1, paramLong2, i);
      if (localObject != r.qML)
      {
        AppMethodBeat.o(323273);
        return localObject;
      }
      localObject = new byte[(int)paramLong2];
      paramString.get((byte[])localObject, (int)paramLong1, (int)paramLong2);
      paramString = ByteBuffer.wrap((byte[])localObject);
      paramString.order(ByteOrder.BIG_ENDIAN);
      paramk.value = paramString;
      paramString = r.qML;
      AppMethodBeat.o(323273);
      return paramString;
    }
  }
  
  public final r a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(323279);
    if (!Vq(paramString))
    {
      paramString = r.qNb;
      AppMethodBeat.o(323279);
      return paramString;
    }
    paramString = this.qMJ.fu(paramString);
    if (paramString == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(323279);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = r.qMM;
      AppMethodBeat.o(323279);
      return paramString;
    }
    paramFileStructStat.st_mode = 33152;
    paramFileStructStat.st_size = paramString.limit();
    paramString = r.qML;
    AppMethodBeat.o(323279);
    return paramString;
  }
  
  public final r b(String paramString, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(323268);
    if (!Vq(paramString))
    {
      paramString = r.qNb;
      AppMethodBeat.o(323268);
      return paramString;
    }
    paramString = this.qMJ.fu(paramString);
    if (paramString == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(323268);
      return paramString;
    }
    paramk.value = paramString;
    paramString = r.qML;
    AppMethodBeat.o(323268);
    return paramString;
  }
  
  public final void cij()
  {
    AppMethodBeat.i(323283);
    this.qMJ.clear();
    AppMethodBeat.o(323283);
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(323260);
    if (!y.bDX(this.qMI)) {
      Log.e("MicroMsg.Luggage.BlobFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(323260);
  }
  
  public final void release()
  {
    AppMethodBeat.i(323281);
    this.qMJ.clear();
    AppMethodBeat.o(323281);
  }
  
  public static abstract interface a
  {
    public abstract f cik();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.n
 * JD-Core Version:    0.7.0.1
 */