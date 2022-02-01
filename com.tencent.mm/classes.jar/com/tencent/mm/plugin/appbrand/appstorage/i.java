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
    l locall = l.jsB;
    if ((paramLong1 < 0L) || (paramLong1 > paramLong3 - 1L)) {
      locall = l.jsM;
    }
    while ((paramLong2 >= 1L) && (paramLong2 <= paramLong3 - paramLong1)) {
      return locall;
    }
    return l.jsN;
  }
  
  public l IR(String paramString)
  {
    return l.jsF;
  }
  
  public e IS(String paramString)
  {
    AppMethodBeat.i(174620);
    paramString = ae(paramString, false);
    AppMethodBeat.o(174620);
    return paramString;
  }
  
  public boolean IT(String paramString)
  {
    return false;
  }
  
  public e IU(String paramString)
  {
    return null;
  }
  
  public boolean IV(String paramString)
  {
    return false;
  }
  
  public final InputStream IW(String paramString)
  {
    AppMethodBeat.i(140587);
    com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    if (b(paramString, locali) == l.jsB)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(140587);
      return paramString;
    }
    AppMethodBeat.o(140587);
    return null;
  }
  
  public boolean Ie(String paramString)
  {
    return false;
  }
  
  public l If(String paramString)
  {
    return l.jsF;
  }
  
  public l Ih(String paramString)
  {
    return l.jsF;
  }
  
  public l a(com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    return l.jsR;
  }
  
  public l a(e parame, String paramString, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    return l.jsR;
  }
  
  public l a(e parame, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    return l.jsR;
  }
  
  public l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    return l.jsF;
  }
  
  public l a(String paramString, FileStructStat paramFileStructStat)
  {
    return l.jsF;
  }
  
  public l a(String paramString, com.tencent.mm.plugin.appbrand.z.i<List<j>> parami)
  {
    return l.jsF;
  }
  
  public l a(String paramString, e parame)
  {
    return l.jsF;
  }
  
  public l a(String paramString, e parame, boolean paramBoolean)
  {
    return l.jsF;
  }
  
  public l a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return l.jsF;
  }
  
  public void aYb() {}
  
  public List<? extends p.a> aYc()
  {
    return null;
  }
  
  public e ae(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public l ag(String paramString, boolean paramBoolean)
  {
    return l.jsF;
  }
  
  public l ah(String paramString, boolean paramBoolean)
  {
    return l.jsF;
  }
  
  public l b(String paramString, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    return l.jsF;
  }
  
  public l h(String paramString, List<v> paramList)
  {
    return l.jsF;
  }
  
  public void initialize() {}
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */