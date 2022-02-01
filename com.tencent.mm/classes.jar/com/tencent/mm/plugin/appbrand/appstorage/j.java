package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.i;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j
  implements q
{
  protected static m g(long paramLong1, long paramLong2, long paramLong3)
  {
    m localm = m.jPM;
    if ((paramLong1 < 0L) || (paramLong1 > paramLong3 - 1L)) {
      localm = m.jPX;
    }
    while ((paramLong2 >= 1L) && (paramLong2 <= paramLong3 - paramLong1)) {
      return localm;
    }
    return m.jPY;
  }
  
  public boolean LZ(String paramString)
  {
    return false;
  }
  
  public com.tencent.mm.vfs.k MM(String paramString)
  {
    return null;
  }
  
  public boolean MN(String paramString)
  {
    return true;
  }
  
  public m MO(String paramString)
  {
    return m.jPQ;
  }
  
  public com.tencent.mm.vfs.k MP(String paramString)
  {
    AppMethodBeat.i(174620);
    paramString = ae(paramString, false);
    AppMethodBeat.o(174620);
    return paramString;
  }
  
  public boolean MQ(String paramString)
  {
    return false;
  }
  
  public com.tencent.mm.vfs.k MR(String paramString)
  {
    return null;
  }
  
  public boolean MS(String paramString)
  {
    return false;
  }
  
  public final InputStream MT(String paramString)
  {
    AppMethodBeat.i(140587);
    i locali = new i();
    if (b(paramString, locali) == m.jPM)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(140587);
      return paramString;
    }
    AppMethodBeat.o(140587);
    return null;
  }
  
  public m Ma(String paramString)
  {
    return m.jPQ;
  }
  
  public m Mc(String paramString)
  {
    return m.jPQ;
  }
  
  public m a(i<String> parami)
  {
    return m.jQc;
  }
  
  public m a(com.tencent.mm.vfs.k paramk, String paramString, i<String> parami)
  {
    return m.jQc;
  }
  
  public m a(com.tencent.mm.vfs.k paramk, String paramString, boolean paramBoolean, i<String> parami)
  {
    return m.jQc;
  }
  
  public m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    return m.jPQ;
  }
  
  public m a(String paramString, FileStructStat paramFileStructStat)
  {
    return m.jPQ;
  }
  
  public m a(String paramString, i<List<k>> parami)
  {
    return m.jPQ;
  }
  
  public m a(String paramString, com.tencent.mm.vfs.k paramk)
  {
    return m.jPQ;
  }
  
  public m a(String paramString, com.tencent.mm.vfs.k paramk, boolean paramBoolean)
  {
    return m.jPQ;
  }
  
  public m a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return m.jPQ;
  }
  
  public com.tencent.mm.vfs.k ae(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public m ag(String paramString, boolean paramBoolean)
  {
    return m.jPQ;
  }
  
  public m ah(String paramString, boolean paramBoolean)
  {
    return m.jPQ;
  }
  
  public m b(String paramString, i<ByteBuffer> parami)
  {
    return m.jPQ;
  }
  
  public void bcb() {}
  
  public List<? extends q.a> bcd()
  {
    return null;
  }
  
  public m g(String paramString, List<x> paramList)
  {
    return m.jPQ;
  }
  
  public void initialize() {}
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.j
 * JD-Core Version:    0.7.0.1
 */