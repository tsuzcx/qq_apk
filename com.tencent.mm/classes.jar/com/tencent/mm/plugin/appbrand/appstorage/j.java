package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.vfs.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j
  implements q
{
  protected static m g(long paramLong1, long paramLong2, long paramLong3)
  {
    m localm = m.kSu;
    if ((paramLong1 < 0L) || (paramLong1 > paramLong3 - 1L)) {
      localm = m.kSF;
    }
    while ((paramLong2 >= 1L) && (paramLong2 <= paramLong3 - paramLong1)) {
      return localm;
    }
    return m.kSG;
  }
  
  public o VV(String paramString)
  {
    return null;
  }
  
  public boolean VW(String paramString)
  {
    return true;
  }
  
  public m VX(String paramString)
  {
    return m.kSy;
  }
  
  public o VY(String paramString)
  {
    AppMethodBeat.i(174620);
    paramString = ag(paramString, false);
    AppMethodBeat.o(174620);
    return paramString;
  }
  
  public boolean VZ(String paramString)
  {
    return false;
  }
  
  public boolean Vi(String paramString)
  {
    return false;
  }
  
  public m Vj(String paramString)
  {
    return m.kSy;
  }
  
  public m Vl(String paramString)
  {
    return m.kSy;
  }
  
  public o Wa(String paramString)
  {
    return null;
  }
  
  public boolean Wb(String paramString)
  {
    return false;
  }
  
  public final InputStream Wc(String paramString)
  {
    AppMethodBeat.i(140587);
    i locali = new i();
    if (b(paramString, locali) == m.kSu)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(140587);
      return paramString;
    }
    AppMethodBeat.o(140587);
    return null;
  }
  
  public m a(i<String> parami)
  {
    return m.kSK;
  }
  
  public m a(o paramo, String paramString, i<String> parami)
  {
    return m.kSK;
  }
  
  public m a(o paramo, String paramString, boolean paramBoolean, i<String> parami)
  {
    return m.kSK;
  }
  
  public m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    return m.kSy;
  }
  
  public m a(String paramString, i<List<k>> parami)
  {
    return m.kSy;
  }
  
  public m a(String paramString, FileStructStat paramFileStructStat)
  {
    return m.kSy;
  }
  
  public m a(String paramString, o paramo)
  {
    return m.kSy;
  }
  
  public m a(String paramString, o paramo, boolean paramBoolean)
  {
    return m.kSy;
  }
  
  public m a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return m.kSy;
  }
  
  public o ag(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public m ai(String paramString, boolean paramBoolean)
  {
    return m.kSy;
  }
  
  public m aj(String paramString, boolean paramBoolean)
  {
    return m.kSy;
  }
  
  public m b(String paramString, i<ByteBuffer> parami)
  {
    return m.kSy;
  }
  
  public void bxq() {}
  
  public List<? extends q.a> bxs()
  {
    return null;
  }
  
  public m h(String paramString, List<x> paramList)
  {
    return m.kSy;
  }
  
  public void initialize() {}
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.j
 * JD-Core Version:    0.7.0.1
 */