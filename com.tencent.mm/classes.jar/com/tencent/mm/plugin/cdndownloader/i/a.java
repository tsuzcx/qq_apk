package com.tencent.mm.plugin.cdndownloader.i;

import com.tencent.mm.j.f;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.xweb.b.a
{
  private static a iAX = null;
  private f.a iAQ = new a.1(this);
  private Map<String, a> iAT = new ConcurrentHashMap();
  
  public static a aDE()
  {
    try
    {
      if (iAX == null) {
        iAX = new a();
      }
      com.tencent.mm.plugin.cdndownloader.c.a.aDv();
      a locala = iAX;
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString1, String paramString2, b paramb)
  {
    y.i("FileDownloaderXWEBProxy", "addDownloadTask: %s filepath:%s", new Object[] { paramString1, paramString2 });
    f localf = new f();
    localf.field_mediaId = paramString1;
    localf.field_fullpath = paramString2;
    localf.dlQ = paramString1;
    localf.field_fileType = com.tencent.mm.j.a.dlA;
    localf.dlP = this.iAQ;
    localf.dlR = 60;
    localf.dlS = 600;
    localf.dlU = false;
    a locala = new a((byte)0);
    locala.iAZ = paramb;
    locala.iAW = paramString2;
    this.iAT.put(paramString1, locala);
    int i = com.tencent.mm.plugin.cdndownloader.c.a.aDv().d(localf);
    y.i("FileDownloaderXWEBProxy", "addDownloadTask: " + i);
    return i;
  }
  
  private final class a
  {
    public String iAW = null;
    public b iAZ = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.i.a
 * JD-Core Version:    0.7.0.1
 */