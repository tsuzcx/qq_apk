package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class i
  extends j
{
  private final String jPH;
  private final String jPI;
  private String jPJ;
  private final u jPK;
  public volatile long jPL;
  
  public i(String paramString1, String paramString2, String paramString3, i.a parama)
  {
    AppMethodBeat.i(195067);
    this.jPL = -1L;
    this.jPJ = paramString1;
    paramString1 = w.B(new k(paramString1).fTh());
    this.jPH = paramString2;
    this.jPI = paramString3;
    this.jPK = new u(paramString1, this.jPH, this.jPI, parama);
    AppMethodBeat.o(195067);
  }
  
  public final boolean LZ(String paramString)
  {
    AppMethodBeat.i(195068);
    boolean bool = bu.nullAsNil(paramString).startsWith(this.jPI);
    AppMethodBeat.o(195068);
    return bool;
  }
  
  public final k MM(String paramString)
  {
    AppMethodBeat.i(195073);
    paramString = this.jPK.MZ(paramString);
    AppMethodBeat.o(195073);
    return paramString;
  }
  
  public final boolean MN(String paramString)
  {
    return false;
  }
  
  public final m Ma(String paramString)
  {
    AppMethodBeat.i(195070);
    if (this.jPK.cK(paramString) == null)
    {
      paramString = m.jPS;
      AppMethodBeat.o(195070);
      return paramString;
    }
    paramString = m.jPM;
    AppMethodBeat.o(195070);
    return paramString;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.y.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(195072);
    if (!LZ(paramString))
    {
      paramString = m.jQc;
      AppMethodBeat.o(195072);
      return paramString;
    }
    paramString = this.jPK.cK(paramString);
    if (paramString == null)
    {
      paramString = m.jPS;
      AppMethodBeat.o(195072);
      return paramString;
    }
    int i = paramString.limit();
    Object localObject = g(paramLong1, paramLong2, i);
    if (localObject != m.jPM)
    {
      AppMethodBeat.o(195072);
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
    paramString = m.jPM;
    AppMethodBeat.o(195072);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(195074);
    if (!LZ(paramString))
    {
      paramString = m.jQc;
      AppMethodBeat.o(195074);
      return paramString;
    }
    paramString = this.jPK.cK(paramString);
    if (paramString == null)
    {
      paramString = m.jPS;
      AppMethodBeat.o(195074);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = m.jPN;
      AppMethodBeat.o(195074);
      return paramString;
    }
    paramFileStructStat.st_mode = 33152;
    paramFileStructStat.st_size = paramString.limit();
    paramString = m.jPM;
    AppMethodBeat.o(195074);
    return paramString;
  }
  
  public final m b(String paramString, com.tencent.mm.plugin.appbrand.y.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(195071);
    if (!LZ(paramString))
    {
      paramString = m.jQc;
      AppMethodBeat.o(195071);
      return paramString;
    }
    paramString = this.jPK.cK(paramString);
    if (paramString == null)
    {
      paramString = m.jPS;
      AppMethodBeat.o(195071);
      return paramString;
    }
    parami.value = paramString;
    paramString = m.jPM;
    AppMethodBeat.o(195071);
    return paramString;
  }
  
  public final void bcb()
  {
    AppMethodBeat.i(195076);
    this.jPK.clear();
    AppMethodBeat.o(195076);
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(195069);
    if (!o.aZI(this.jPJ)) {
      ae.e("MicroMsg.Luggage.BlobFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(195069);
  }
  
  public final void release()
  {
    AppMethodBeat.i(195075);
    this.jPK.clear();
    AppMethodBeat.o(195075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */