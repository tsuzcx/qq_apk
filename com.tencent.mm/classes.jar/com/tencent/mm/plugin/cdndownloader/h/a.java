package com.tencent.mm.plugin.cdndownloader.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.t.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.t.a
{
  private static a kEa = null;
  private g.a kDY;
  private Map<String, a> kEb;
  
  public a()
  {
    AppMethodBeat.i(967);
    this.kEb = new ConcurrentHashMap();
    this.kDY = new a.1(this);
    AppMethodBeat.o(967);
  }
  
  public static a bga()
  {
    try
    {
      AppMethodBeat.i(968);
      if (kEa == null) {
        kEa = new a();
      }
      com.tencent.mm.plugin.cdndownloader.c.a.bfS();
      a locala = kEa;
      AppMethodBeat.o(968);
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(969);
    ab.i("FileDownloaderWAGameProxy", "addDownloadTask: %s filepath:%s", new Object[] { paramString1, paramString2 });
    g localg = new g();
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.eds = paramString1;
    localg.field_fileType = com.tencent.mm.i.a.ecY;
    localg.edp = this.kDY;
    localg.edt = 60;
    localg.edu = 600;
    localg.edw = false;
    a locala = new a((byte)0);
    locala.kEd = paramb;
    locala.kEe = paramString2;
    this.kEb.put(paramString1, locala);
    int i = com.tencent.mm.plugin.cdndownloader.c.a.bfS().f(localg);
    ab.i("FileDownloaderWAGameProxy", "addDownloadTask: ".concat(String.valueOf(i)));
    AppMethodBeat.o(969);
    return i;
  }
  
  final class a
  {
    public b kEd = null;
    public String kEe = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.h.a
 * JD-Core Version:    0.7.0.1
 */