package com.tencent.mm.plugin.cdndownloader.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.b.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.xweb.b.a
{
  private static a kEf = null;
  private g.a kDY;
  private Map<String, a> kEb;
  
  public a()
  {
    AppMethodBeat.i(973);
    this.kEb = new ConcurrentHashMap();
    this.kDY = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(972);
        String str1;
        if (paramAnonymousc == null)
        {
          str1 = "null";
          if (paramAnonymousd != null) {
            break label94;
          }
        }
        label94:
        for (String str2 = "null";; str2 = paramAnonymousd.toString())
        {
          ab.d("FileDownloaderXWEBProxy", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label104;
          }
          ab.i("FileDownloaderXWEBProxy", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(972);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label104:
        if (paramAnonymousInt != 0)
        {
          ab.e("FileDownloaderXWEBProxy", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          a.a(a.this, paramAnonymousString, 4, paramAnonymousInt, false);
          AppMethodBeat.o(972);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          a.a(a.this, paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          AppMethodBeat.o(972);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label250;
          }
          ab.e("FileDownloaderXWEBProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          a.a(a.this, paramAnonymousString, 4, paramAnonymousd.field_retCode, paramAnonymousd.field_isResume);
        }
        for (;;)
        {
          AppMethodBeat.o(972);
          return 0;
          label250:
          ab.i("FileDownloaderXWEBProxy", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          a.a(a.this, paramAnonymousString, 3, 0, paramAnonymousd.field_isResume);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] l(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    AppMethodBeat.o(973);
  }
  
  public static a bgb()
  {
    try
    {
      AppMethodBeat.i(974);
      if (kEf == null) {
        kEf = new a();
      }
      com.tencent.mm.plugin.cdndownloader.c.a.bfS();
      a locala = kEf;
      AppMethodBeat.o(974);
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(975);
    ab.i("FileDownloaderXWEBProxy", "addDownloadTask: %s filepath:%s", new Object[] { paramString1, paramString2 });
    g localg = new g();
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.eds = paramString1;
    localg.field_fileType = com.tencent.mm.i.a.ecV;
    localg.edp = this.kDY;
    localg.edt = 60;
    localg.edu = 600;
    localg.edw = false;
    a locala = new a((byte)0);
    locala.kEh = paramb;
    locala.kEe = paramString2;
    this.kEb.put(paramString1, locala);
    int i = com.tencent.mm.plugin.cdndownloader.c.a.bfS().f(localg);
    ab.i("FileDownloaderXWEBProxy", "addDownloadTask: ".concat(String.valueOf(i)));
    AppMethodBeat.o(975);
    return i;
  }
  
  final class a
  {
    public String kEe = null;
    public b kEh = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.i.a
 * JD-Core Version:    0.7.0.1
 */