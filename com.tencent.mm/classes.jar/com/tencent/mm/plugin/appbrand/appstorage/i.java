package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class i
  extends j
{
  private final String nMM;
  private final String nMN;
  private String nMO;
  private final w nMP;
  public volatile long nMQ;
  
  public i(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(225221);
    this.nMQ = -1L;
    this.nMO = paramString1;
    paramString1 = new q(paramString1).bOF();
    this.nMM = paramString2;
    this.nMN = paramString3;
    this.nMP = new w(paramString1, this.nMM, this.nMN, parama);
    AppMethodBeat.o(225221);
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(225236);
    if (!acS(paramString))
    {
      paramString = m.nNh;
      AppMethodBeat.o(225236);
      return paramString;
    }
    paramString = this.nMP.eb(paramString);
    if (paramString == null)
    {
      paramString = m.nMX;
      AppMethodBeat.o(225236);
      return paramString;
    }
    int i = paramString.limit();
    if (paramLong2 > 2147483647L) {
      paramLong2 = i - paramLong1;
    }
    for (;;)
    {
      Object localObject = h(paramLong1, paramLong2, i);
      if (localObject != m.nMR)
      {
        AppMethodBeat.o(225236);
        return localObject;
      }
      localObject = new byte[(int)paramLong2];
      paramString.get((byte[])localObject, (int)paramLong1, (int)paramLong2);
      paramString = ByteBuffer.wrap((byte[])localObject);
      paramString.order(ByteOrder.BIG_ENDIAN);
      parami.value = paramString;
      paramString = m.nMR;
      AppMethodBeat.o(225236);
      return paramString;
    }
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(225246);
    if (!acS(paramString))
    {
      paramString = m.nNh;
      AppMethodBeat.o(225246);
      return paramString;
    }
    paramString = this.nMP.eb(paramString);
    if (paramString == null)
    {
      paramString = m.nMX;
      AppMethodBeat.o(225246);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = m.nMS;
      AppMethodBeat.o(225246);
      return paramString;
    }
    paramFileStructStat.st_mode = 33152;
    paramFileStructStat.st_size = paramString.limit();
    paramString = m.nMR;
    AppMethodBeat.o(225246);
    return paramString;
  }
  
  public final boolean acS(String paramString)
  {
    AppMethodBeat.i(225223);
    boolean bool = Util.nullAsNil(paramString).startsWith(this.nMN);
    AppMethodBeat.o(225223);
    return bool;
  }
  
  public final m acT(String paramString)
  {
    AppMethodBeat.i(225227);
    if (this.nMP.eb(paramString) == null)
    {
      paramString = m.nMX;
      AppMethodBeat.o(225227);
      return paramString;
    }
    paramString = m.nMR;
    AppMethodBeat.o(225227);
    return paramString;
  }
  
  public final q adI(String paramString)
  {
    AppMethodBeat.i(225238);
    paramString = this.nMP.adX(paramString);
    AppMethodBeat.o(225238);
    return paramString;
  }
  
  public final boolean adJ(String paramString)
  {
    return false;
  }
  
  public final m b(String paramString, com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(225230);
    if (!acS(paramString))
    {
      paramString = m.nNh;
      AppMethodBeat.o(225230);
      return paramString;
    }
    paramString = this.nMP.eb(paramString);
    if (paramString == null)
    {
      paramString = m.nMX;
      AppMethodBeat.o(225230);
      return paramString;
    }
    parami.value = paramString;
    paramString = m.nMR;
    AppMethodBeat.o(225230);
    return paramString;
  }
  
  public final void bIE()
  {
    AppMethodBeat.i(225250);
    this.nMP.clear();
    AppMethodBeat.o(225250);
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(225226);
    if (!u.bBD(this.nMO)) {
      Log.e("MicroMsg.Luggage.BlobFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(225226);
  }
  
  public final void release()
  {
    AppMethodBeat.i(225249);
    this.nMP.clear();
    AppMethodBeat.o(225249);
  }
  
  public static abstract interface a
  {
    public abstract e bIF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */