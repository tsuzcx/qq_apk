package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class g
  implements o
{
  public j Y(String paramString, boolean paramBoolean)
  {
    return j.gZE;
  }
  
  public j Z(String paramString, boolean paramBoolean)
  {
    return j.gZE;
  }
  
  public j a(com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    return j.gZO;
  }
  
  public j a(File paramFile, String paramString, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    return j.gZO;
  }
  
  public j a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    return j.gZO;
  }
  
  public j a(String paramString, FileStructStat paramFileStructStat)
  {
    return j.gZE;
  }
  
  public j a(String paramString, com.tencent.mm.plugin.appbrand.s.j<List<h>> paramj)
  {
    return j.gZE;
  }
  
  public j a(String paramString, File paramFile, boolean paramBoolean)
  {
    return j.gZE;
  }
  
  public j a(String paramString, InputStream paramInputStream, boolean paramBoolean)
  {
    return j.gZE;
  }
  
  public File aa(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public void awI() {}
  
  public List<? extends o.a> awJ()
  {
    return null;
  }
  
  public j b(String paramString, com.tencent.mm.plugin.appbrand.s.j<ByteBuffer> paramj)
  {
    return j.gZE;
  }
  
  public j b(String paramString, File paramFile)
  {
    return j.gZE;
  }
  
  public boolean bL(String paramString)
  {
    return false;
  }
  
  public j h(String paramString, List<u> paramList)
  {
    return j.gZE;
  }
  
  public void initialize() {}
  
  public void release() {}
  
  public j zd(String paramString)
  {
    return j.gZE;
  }
  
  public j ze(String paramString)
  {
    return j.gZE;
  }
  
  public j zf(String paramString)
  {
    return j.gZE;
  }
  
  public File zg(String paramString)
  {
    AppMethodBeat.i(90975);
    paramString = aa(paramString, false);
    AppMethodBeat.o(90975);
    return paramString;
  }
  
  public b zh(String paramString)
  {
    return null;
  }
  
  public boolean zi(String paramString)
  {
    return false;
  }
  
  public final InputStream zj(String paramString)
  {
    AppMethodBeat.i(90976);
    com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    if (b(paramString, localj) == j.gZA)
    {
      paramString = new a((ByteBuffer)localj.value);
      AppMethodBeat.o(90976);
      return paramString;
    }
    AppMethodBeat.o(90976);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.g
 * JD-Core Version:    0.7.0.1
 */