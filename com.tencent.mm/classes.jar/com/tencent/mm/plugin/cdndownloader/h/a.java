package com.tencent.mm.plugin.cdndownloader.h;

import com.tencent.mm.j.f;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.t.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.t.a
{
  private static a iAS = null;
  private f.a iAQ = new a.1(this);
  private Map<String, a> iAT = new ConcurrentHashMap();
  
  public static a aDD()
  {
    try
    {
      if (iAS == null) {
        iAS = new a();
      }
      com.tencent.mm.plugin.cdndownloader.c.a.aDv();
      a locala = iAS;
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString1, String paramString2, b paramb)
  {
    y.i("FileDownloaderWAGameProxy", "addDownloadTask: %s filepath:%s", new Object[] { paramString1, paramString2 });
    f localf = new f();
    localf.field_mediaId = paramString1;
    localf.field_fullpath = paramString2;
    localf.dlQ = paramString1;
    localf.field_fileType = com.tencent.mm.j.a.dlD;
    localf.dlP = this.iAQ;
    localf.dlR = 60;
    localf.dlS = 600;
    localf.dlU = false;
    a locala = new a((byte)0);
    locala.iAV = paramb;
    locala.iAW = paramString2;
    this.iAT.put(paramString1, locala);
    int i = com.tencent.mm.plugin.cdndownloader.c.a.aDv().d(localf);
    y.i("FileDownloaderWAGameProxy", "addDownloadTask: " + i);
    return i;
  }
  
  private final class a
  {
    public b iAV = null;
    public String iAW = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.h.a
 * JD-Core Version:    0.7.0.1
 */