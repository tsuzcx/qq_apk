package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class i
  implements p
{
  protected static l g(long paramLong1, long paramLong2, long paramLong3)
  {
    l locall = l.jMv;
    if ((paramLong1 < 0L) || (paramLong1 > paramLong3 - 1L)) {
      locall = l.jMG;
    }
    while ((paramLong2 >= 1L) && (paramLong2 <= paramLong3 - paramLong1)) {
      return locall;
    }
    return l.jMH;
  }
  
  public boolean Lw(String paramString)
  {
    return false;
  }
  
  public l Lx(String paramString)
  {
    return l.jMz;
  }
  
  public l Lz(String paramString)
  {
    return l.jMz;
  }
  
  public l Mi(String paramString)
  {
    return l.jMz;
  }
  
  public e Mj(String paramString)
  {
    AppMethodBeat.i(174620);
    paramString = ae(paramString, false);
    AppMethodBeat.o(174620);
    return paramString;
  }
  
  public boolean Mk(String paramString)
  {
    return false;
  }
  
  public e Ml(String paramString)
  {
    return null;
  }
  
  public boolean Mm(String paramString)
  {
    return false;
  }
  
  public final InputStream Mn(String paramString)
  {
    AppMethodBeat.i(140587);
    com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    if (b(paramString, locali) == l.jMv)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(140587);
      return paramString;
    }
    AppMethodBeat.o(140587);
    return null;
  }
  
  public l a(com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    return l.jML;
  }
  
  public l a(e parame, String paramString, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    return l.jML;
  }
  
  public l a(e parame, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    return l.jML;
  }
  
  public l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    return l.jMz;
  }
  
  public l a(String paramString, FileStructStat paramFileStructStat)
  {
    return l.jMz;
  }
  
  public l a(String paramString, com.tencent.mm.plugin.appbrand.z.i<List<j>> parami)
  {
    return l.jMz;
  }
  
  public l a(String paramString, e parame)
  {
    return l.jMz;
  }
  
  public l a(String paramString, e parame, boolean paramBoolean)
  {
    return l.jMz;
  }
  
  public l a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return l.jMz;
  }
  
  public e ae(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public l ag(String paramString, boolean paramBoolean)
  {
    return l.jMz;
  }
  
  public l ah(String paramString, boolean paramBoolean)
  {
    return l.jMz;
  }
  
  public l b(String paramString, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    return l.jMz;
  }
  
  public List<? extends p.a> bbA()
  {
    return null;
  }
  
  public void bbz() {}
  
  public l g(String paramString, List<v> paramList)
  {
    return l.jMz;
  }
  
  public void initialize() {}
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */