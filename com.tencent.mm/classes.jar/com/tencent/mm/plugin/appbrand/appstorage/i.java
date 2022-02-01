package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class i
  extends j
{
  private final String kSp;
  private final String kSq;
  private String kSr;
  private final u kSs;
  public volatile long kSt;
  
  public i(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(196156);
    this.kSt = -1L;
    this.kSr = paramString1;
    paramString1 = aa.z(new o(paramString1).her());
    this.kSp = paramString2;
    this.kSq = paramString3;
    this.kSs = new u(paramString1, this.kSp, this.kSq, parama);
    AppMethodBeat.o(196156);
  }
  
  public final o VV(String paramString)
  {
    AppMethodBeat.i(196162);
    paramString = this.kSs.Wi(paramString);
    AppMethodBeat.o(196162);
    return paramString;
  }
  
  public final boolean VW(String paramString)
  {
    return false;
  }
  
  public final boolean Vi(String paramString)
  {
    AppMethodBeat.i(196157);
    boolean bool = Util.nullAsNil(paramString).startsWith(this.kSq);
    AppMethodBeat.o(196157);
    return bool;
  }
  
  public final m Vj(String paramString)
  {
    AppMethodBeat.i(196159);
    if (this.kSs.dI(paramString) == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(196159);
      return paramString;
    }
    paramString = m.kSu;
    AppMethodBeat.o(196159);
    return paramString;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(196161);
    if (!Vi(paramString))
    {
      paramString = m.kSK;
      AppMethodBeat.o(196161);
      return paramString;
    }
    paramString = this.kSs.dI(paramString);
    if (paramString == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(196161);
      return paramString;
    }
    int i = paramString.limit();
    Object localObject = g(paramLong1, paramLong2, i);
    if (localObject != m.kSu)
    {
      AppMethodBeat.o(196161);
      return localObject;
    }
    long l = paramLong2;
    if (paramLong2 > 2147483647L) {
      l = i - paramLong1;
    }
    localObject = new byte[(int)l];
    paramString.get((byte[])localObject, (int)paramLong1, (int)l);
    paramString = ByteBuffer.wrap((byte[])localObject);
    paramString.order(ByteOrder.BIG_ENDIAN);
    parami.value = paramString;
    paramString = m.kSu;
    AppMethodBeat.o(196161);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(196163);
    if (!Vi(paramString))
    {
      paramString = m.kSK;
      AppMethodBeat.o(196163);
      return paramString;
    }
    paramString = this.kSs.dI(paramString);
    if (paramString == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(196163);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = m.kSv;
      AppMethodBeat.o(196163);
      return paramString;
    }
    paramFileStructStat.st_mode = 33152;
    paramFileStructStat.st_size = paramString.limit();
    paramString = m.kSu;
    AppMethodBeat.o(196163);
    return paramString;
  }
  
  public final m b(String paramString, com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(196160);
    if (!Vi(paramString))
    {
      paramString = m.kSK;
      AppMethodBeat.o(196160);
      return paramString;
    }
    paramString = this.kSs.dI(paramString);
    if (paramString == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(196160);
      return paramString;
    }
    parami.value = paramString;
    paramString = m.kSu;
    AppMethodBeat.o(196160);
    return paramString;
  }
  
  public final void bxq()
  {
    AppMethodBeat.i(196165);
    this.kSs.clear();
    AppMethodBeat.o(196165);
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(196158);
    if (!s.boN(this.kSr)) {
      Log.e("MicroMsg.Luggage.BlobFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(196158);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196164);
    this.kSs.clear();
    AppMethodBeat.o(196164);
  }
  
  public static abstract interface a
  {
    public abstract f bxr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */