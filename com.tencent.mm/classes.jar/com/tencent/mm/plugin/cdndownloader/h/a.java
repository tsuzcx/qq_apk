package com.tencent.mm.plugin.cdndownloader.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.t.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.t.a
{
  private static a oXW = null;
  private g.a oXT;
  private Map<String, a> oXX;
  
  public a()
  {
    AppMethodBeat.i(120819);
    this.oXX = new ConcurrentHashMap();
    this.oXT = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(120818);
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
          ae.d("FileDownloaderWAGameProxy", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          ae.i("FileDownloaderWAGameProxy", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(120818);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          ae.e("FileDownloaderWAGameProxy", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          a.a(a.this, paramAnonymousString, 4, paramAnonymousInt, false);
          AppMethodBeat.o(120818);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          a.a(a.this, paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          AppMethodBeat.o(120818);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label243;
          }
          ae.e("FileDownloaderWAGameProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          a.a(a.this, paramAnonymousString, 4, paramAnonymousd.field_retCode, paramAnonymousd.field_isResume);
        }
        for (;;)
        {
          AppMethodBeat.o(120818);
          return 0;
          label243:
          ae.i("FileDownloaderWAGameProxy", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          a.a(a.this, paramAnonymousString, 3, 0, paramAnonymousd.field_isResume);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    AppMethodBeat.o(120819);
  }
  
  public static a car()
  {
    try
    {
      AppMethodBeat.i(120820);
      if (oXW == null) {
        oXW = new a();
      }
      com.tencent.mm.plugin.cdndownloader.c.a.cai();
      a locala = oXW;
      AppMethodBeat.o(120820);
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(120821);
    ae.i("FileDownloaderWAGameProxy", "addDownloadTask: %s filepath:%s", new Object[] { paramString1, paramString2 });
    g localg = new g();
    localg.fLl = "task_FileDownloaderWAGameProxy";
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.fLp = paramString1;
    localg.field_fileType = com.tencent.mm.i.a.fKU;
    localg.fLm = this.oXT;
    localg.fLq = 60;
    localg.fLr = 600;
    localg.fLt = false;
    a locala = new a((byte)0);
    locala.oXZ = paramb;
    locala.oYa = paramString2;
    this.oXX.put(paramString1, locala);
    int i = com.tencent.mm.plugin.cdndownloader.c.a.cai().h(localg);
    ae.i("FileDownloaderWAGameProxy", "addDownloadTask: ".concat(String.valueOf(i)));
    AppMethodBeat.o(120821);
    return i;
  }
  
  final class a
  {
    public b oXZ = null;
    public String oYa = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.h.a
 * JD-Core Version:    0.7.0.1
 */