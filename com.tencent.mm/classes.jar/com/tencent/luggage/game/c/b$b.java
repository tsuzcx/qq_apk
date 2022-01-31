package com.tencent.luggage.game.c;

import com.tencent.luggage.g.a;
import com.tencent.magicbrush.handler.image.IMBImageHandler;
import com.tencent.magicbrush.handler.image.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.nio.ByteBuffer;

final class b$b
  extends a.d
{
  private final i bAb;
  
  private b$b(i parami, IMBImageHandler paramIMBImageHandler)
  {
    super(paramIMBImageHandler);
    this.bAb = parami;
  }
  
  public final boolean bL(String paramString)
  {
    return true;
  }
  
  public final InputStream bM(String paramString)
  {
    AppMethodBeat.i(140346);
    if (this.bAb == null)
    {
      ab.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, runtime NULL", new Object[] { paramString });
      AppMethodBeat.o(140346);
      return null;
    }
    com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    com.tencent.mm.plugin.appbrand.appstorage.j localj1 = this.bAb.wX().b(paramString, localj);
    if ((localj1 == com.tencent.mm.plugin.appbrand.appstorage.j.gZA) && (localj.value != null))
    {
      paramString = new a((ByteBuffer)localj.value);
      AppMethodBeat.o(140346);
      return paramString;
    }
    ab.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, ret %s", new Object[] { paramString, localj1.name() });
    AppMethodBeat.o(140346);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.c.b.b
 * JD-Core Version:    0.7.0.1
 */