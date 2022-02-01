package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class o
  implements w
{
  protected static r h(long paramLong1, long paramLong2, long paramLong3)
  {
    r localr = r.qML;
    if ((paramLong1 < 0L) || (paramLong1 > paramLong3 - 1L)) {
      localr = r.qMW;
    }
    while ((paramLong2 >= 1L) && (paramLong2 <= paramLong3 - paramLong1)) {
      return localr;
    }
    return r.qMX;
  }
  
  public boolean Vq(String paramString)
  {
    return false;
  }
  
  public r Vr(String paramString)
  {
    return r.qMP;
  }
  
  public r Vt(String paramString)
  {
    return r.qMP;
  }
  
  public u Wj(String paramString)
  {
    return null;
  }
  
  public boolean Wk(String paramString)
  {
    return true;
  }
  
  public r Wl(String paramString)
  {
    return r.qMP;
  }
  
  public u Wm(String paramString)
  {
    AppMethodBeat.i(174620);
    paramString = ao(paramString, false);
    AppMethodBeat.o(174620);
    return paramString;
  }
  
  public boolean Wn(String paramString)
  {
    return false;
  }
  
  public u Wo(String paramString)
  {
    return null;
  }
  
  public boolean Wp(String paramString)
  {
    return false;
  }
  
  public boolean Wq(String paramString)
  {
    return false;
  }
  
  public InputStream Wr(String paramString)
  {
    AppMethodBeat.i(140587);
    k localk = new k();
    if (b(paramString, localk) == r.qML)
    {
      paramString = new a((ByteBuffer)localk.value);
      AppMethodBeat.o(140587);
      return paramString;
    }
    AppMethodBeat.o(140587);
    return null;
  }
  
  public r a(k<String> paramk)
  {
    return r.qNb;
  }
  
  public r a(u paramu, String paramString, k<String> paramk)
  {
    return r.qNb;
  }
  
  public r a(u paramu, String paramString, boolean paramBoolean, k<String> paramk)
  {
    return r.qNb;
  }
  
  public r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    return r.qMP;
  }
  
  public r a(String paramString, k<List<p>> paramk)
  {
    return r.qMP;
  }
  
  public r a(String paramString1, k<Map<String, ByteBuffer>> paramk, String paramString2, long paramLong1, long paramLong2)
  {
    return r.qMP;
  }
  
  public r a(String paramString, FileStructStat paramFileStructStat)
  {
    return r.qMP;
  }
  
  public r a(String paramString, u paramu)
  {
    return r.qMP;
  }
  
  public r a(String paramString, u paramu, boolean paramBoolean)
  {
    return r.qMP;
  }
  
  public r a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return r.qMP;
  }
  
  public u ao(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public r aq(String paramString, boolean paramBoolean)
  {
    return r.qMP;
  }
  
  public r ar(String paramString, boolean paramBoolean)
  {
    return r.qMP;
  }
  
  public r b(String paramString, k<ByteBuffer> paramk)
  {
    return r.qMP;
  }
  
  public void cij() {}
  
  public List<? extends w.a> cil()
  {
    return null;
  }
  
  public y cim()
  {
    return null;
  }
  
  public void initialize() {}
  
  public r j(String paramString, List<ad> paramList)
  {
    return r.qMP;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */