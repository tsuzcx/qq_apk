package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.vfs.q;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class j
  implements r
{
  protected static m h(long paramLong1, long paramLong2, long paramLong3)
  {
    m localm = m.nMR;
    if ((paramLong1 < 0L) || (paramLong1 > paramLong3 - 1L)) {
      localm = m.nNc;
    }
    while ((paramLong2 >= 1L) && (paramLong2 <= paramLong3 - paramLong1)) {
      return localm;
    }
    return m.nNd;
  }
  
  public m a(i<String> parami)
  {
    return m.nNh;
  }
  
  public m a(q paramq, String paramString, i<String> parami)
  {
    return m.nNh;
  }
  
  public m a(q paramq, String paramString, boolean paramBoolean, i<String> parami)
  {
    return m.nNh;
  }
  
  public m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    return m.nMV;
  }
  
  public m a(String paramString, i<List<k>> parami)
  {
    return m.nMV;
  }
  
  public m a(String paramString1, i<Map<String, ByteBuffer>> parami, String paramString2, long paramLong1, long paramLong2)
  {
    return m.nMV;
  }
  
  public m a(String paramString, FileStructStat paramFileStructStat)
  {
    return m.nMV;
  }
  
  public m a(String paramString, q paramq)
  {
    return m.nMV;
  }
  
  public m a(String paramString, q paramq, boolean paramBoolean)
  {
    return m.nMV;
  }
  
  public m a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return m.nMV;
  }
  
  public boolean acS(String paramString)
  {
    return false;
  }
  
  public m acT(String paramString)
  {
    return m.nMV;
  }
  
  public m acV(String paramString)
  {
    return m.nMV;
  }
  
  public q adI(String paramString)
  {
    return null;
  }
  
  public boolean adJ(String paramString)
  {
    return true;
  }
  
  public m adK(String paramString)
  {
    return m.nMV;
  }
  
  public q adL(String paramString)
  {
    AppMethodBeat.i(174620);
    paramString = ah(paramString, false);
    AppMethodBeat.o(174620);
    return paramString;
  }
  
  public boolean adM(String paramString)
  {
    return false;
  }
  
  public q adN(String paramString)
  {
    return null;
  }
  
  public boolean adO(String paramString)
  {
    return false;
  }
  
  public boolean adP(String paramString)
  {
    return false;
  }
  
  public final InputStream adQ(String paramString)
  {
    AppMethodBeat.i(140587);
    i locali = new i();
    if (b(paramString, locali) == m.nMR)
    {
      paramString = new a((ByteBuffer)locali.value);
      AppMethodBeat.o(140587);
      return paramString;
    }
    AppMethodBeat.o(140587);
    return null;
  }
  
  public q ah(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public m aj(String paramString, boolean paramBoolean)
  {
    return m.nMV;
  }
  
  public m ak(String paramString, boolean paramBoolean)
  {
    return m.nMV;
  }
  
  public m b(String paramString, i<ByteBuffer> parami)
  {
    return m.nMV;
  }
  
  public void bIE() {}
  
  public List<? extends r.a> bIG()
  {
    return null;
  }
  
  public t bIH()
  {
    return null;
  }
  
  public m h(String paramString, List<z> paramList)
  {
    return m.nMV;
  }
  
  public void initialize() {}
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.j
 * JD-Core Version:    0.7.0.1
 */