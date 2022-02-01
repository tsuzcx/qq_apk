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
  protected static l f(long paramLong1, long paramLong2, long paramLong3)
  {
    l locall = l.iSq;
    if ((paramLong1 < 0L) || (paramLong1 > paramLong3 - 1L)) {
      locall = l.iSB;
    }
    while ((paramLong2 >= 1L) && (paramLong2 <= paramLong3 - paramLong1)) {
      return locall;
    }
    return l.iSC;
  }
  
  public l EO(String paramString)
  {
    return l.iSu;
  }
  
  public e EP(String paramString)
  {
    AppMethodBeat.i(174620);
    paramString = ad(paramString, false);
    AppMethodBeat.o(174620);
    return paramString;
  }
  
  public boolean EQ(String paramString)
  {
    return false;
  }
  
  public e ER(String paramString)
  {
    return null;
  }
  
  public boolean ES(String paramString)
  {
    return false;
  }
  
  public final InputStream ET(String paramString)
  {
    AppMethodBeat.i(140587);
    com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
    if (b(paramString, locali) == l.iSq)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(140587);
      return paramString;
    }
    AppMethodBeat.o(140587);
    return null;
  }
  
  public boolean Eb(String paramString)
  {
    return false;
  }
  
  public l Ec(String paramString)
  {
    return l.iSu;
  }
  
  public l Ee(String paramString)
  {
    return l.iSu;
  }
  
  public l a(com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    return l.iSG;
  }
  
  public l a(e parame, String paramString, com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    return l.iSG;
  }
  
  public l a(e parame, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    return l.iSG;
  }
  
  public l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    return l.iSu;
  }
  
  public l a(String paramString, com.tencent.mm.plugin.appbrand.aa.i<List<j>> parami)
  {
    return l.iSu;
  }
  
  public l a(String paramString, FileStructStat paramFileStructStat)
  {
    return l.iSu;
  }
  
  public l a(String paramString, e parame)
  {
    return l.iSu;
  }
  
  public l a(String paramString, e parame, boolean paramBoolean)
  {
    return l.iSu;
  }
  
  public l a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return l.iSu;
  }
  
  public void aRg() {}
  
  public List<? extends p.a> aRh()
  {
    return null;
  }
  
  public e ad(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public l af(String paramString, boolean paramBoolean)
  {
    return l.iSu;
  }
  
  public l ag(String paramString, boolean paramBoolean)
  {
    return l.iSu;
  }
  
  public l b(String paramString, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    return l.iSu;
  }
  
  public void initialize() {}
  
  public l j(String paramString, List<v> paramList)
  {
    return l.iSu;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */