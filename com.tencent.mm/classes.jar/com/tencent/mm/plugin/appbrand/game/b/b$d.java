package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.luggage.j.a;
import com.tencent.magicbrush.handler.image.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class b$d
  extends a.a
{
  private final n gaS;
  
  private b$d(n paramn)
  {
    this.gaS = paramn;
  }
  
  public final boolean bs(String paramString)
  {
    return true;
  }
  
  public final InputStream bt(String paramString)
  {
    if (this.gaS == null)
    {
      y.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, runtime NULL", new Object[] { paramString });
      return null;
    }
    k localk = new k();
    h localh = this.gaS.fzC.b(paramString, localk);
    if ((localh == h.fGU) && (localk.value != null)) {
      return new a((ByteBuffer)localk.value);
    }
    y.e("MicroMsg.WAGameRuntimeFileSystemDecoder", "fetch %s, ret %s", new Object[] { paramString, localh.name() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b.d
 * JD-Core Version:    0.7.0.1
 */