package com.tencent.mm.plugin.cdndownloader.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g;
import com.tencent.mm.g.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.downloader.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.xweb.downloader.a
{
  private static a wPe = null;
  private g.a wOW;
  private Map<String, a> wPa;
  
  public a()
  {
    AppMethodBeat.i(120825);
    this.wPa = new ConcurrentHashMap();
    this.wOW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(120824);
        String str1;
        if (paramAnonymousc == null)
        {
          str1 = "null";
          if (paramAnonymousd != null) {
            break label92;
          }
        }
        label92:
        for (String str2 = "null";; str2 = paramAnonymousd.toString())
        {
          Log.d("XWeb.MM.FileDownloaderXWEBProxy", "cdnCallback, mediaId:%s, startRet:%d, keep_ProgressInfo:%s, keep_SceneResult:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          Log.i("XWeb.MM.FileDownloaderXWEBProxy", "duplicate request, ignore this request, mediaId:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(120824);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          Log.e("XWeb.MM.FileDownloaderXWEBProxy", "cdnCallback, start failed:%d, mediaId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          a.a(a.this, paramAnonymousString, 4, paramAnonymousInt, false);
          AppMethodBeat.o(120824);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          a.a(a.this, paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          AppMethodBeat.o(120824);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label243;
          }
          Log.e("XWeb.MM.FileDownloaderXWEBProxy", "cdnCallback, download fail, mediaId:%s, retCode:%d, sceneResult:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          a.a(a.this, paramAnonymousString, 4, paramAnonymousd.field_retCode, paramAnonymousd.field_isResume);
        }
        for (;;)
        {
          AppMethodBeat.o(120824);
          return 0;
          label243:
          Log.i("XWeb.MM.FileDownloaderXWEBProxy", "cdnCallback, download success, mediaId:%s", new Object[] { paramAnonymousString });
          a.a(a.this, paramAnonymousString, 3, 0, paramAnonymousd.field_isResume);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    AppMethodBeat.o(120825);
  }
  
  public static a dqi()
  {
    try
    {
      AppMethodBeat.i(120826);
      if (wPe == null) {
        wPe = new a();
      }
      com.tencent.mm.plugin.cdndownloader.c.a.dpY();
      a locala = wPe;
      AppMethodBeat.o(120826);
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString1, String paramString2, int paramInt, b paramb)
  {
    AppMethodBeat.i(261599);
    Log.i("XWeb.MM.FileDownloaderXWEBProxy", "addDownloadTask, url:%s, filepath:%s, bizType:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    g localg = new g();
    localg.taskName = "task_FileDownloaderXWEBProxy";
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.lwO = paramString1;
    localg.field_fileType = com.tencent.mm.g.a.lwq;
    localg.lwL = this.wOW;
    localg.lwP = 60;
    localg.lwQ = 600;
    localg.lwS = false;
    a locala = new a((byte)0);
    locala.wPg = paramb;
    locala.wPd = paramString2;
    this.wPa.put(paramString1, locala);
    paramInt = com.tencent.mm.plugin.cdndownloader.c.a.dpY().i(localg);
    Log.i("XWeb.MM.FileDownloaderXWEBProxy", "addDownloadTask, result:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(261599);
    return paramInt;
  }
  
  final class a
  {
    public String wPd = null;
    public b wPg = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.i.a
 * JD-Core Version:    0.7.0.1
 */