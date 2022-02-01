package com.tencent.mm.plugin.cdndownloader.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.s.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements com.tencent.mm.s.a
{
  private static a qmT = null;
  private g.a qmQ;
  private Map<String, a> qmU;
  
  public a()
  {
    AppMethodBeat.i(120819);
    this.qmU = new ConcurrentHashMap();
    this.qmQ = new g.a()
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
          Log.d("FileDownloaderWAGameProxy", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          Log.i("FileDownloaderWAGameProxy", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(120818);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          Log.e("FileDownloaderWAGameProxy", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
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
          Log.e("FileDownloaderWAGameProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          a.a(a.this, paramAnonymousString, 4, paramAnonymousd.field_retCode, paramAnonymousd.field_isResume);
        }
        for (;;)
        {
          AppMethodBeat.o(120818);
          return 0;
          label243:
          Log.i("FileDownloaderWAGameProxy", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
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
  
  public static a cyi()
  {
    try
    {
      AppMethodBeat.i(120820);
      if (qmT == null) {
        qmT = new a();
      }
      com.tencent.mm.plugin.cdndownloader.c.a.cxZ();
      a locala = qmT;
      AppMethodBeat.o(120820);
      return locala;
    }
    finally {}
  }
  
  public final int a(String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(120821);
    Log.i("FileDownloaderWAGameProxy", "addDownloadTask: %s filepath:%s", new Object[] { paramString1, paramString2 });
    g localg = new g();
    localg.taskName = "task_FileDownloaderWAGameProxy";
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.gqB = paramString1;
    localg.field_fileType = com.tencent.mm.i.a.gqh;
    localg.gqy = this.qmQ;
    localg.gqC = 60;
    localg.gqD = 600;
    localg.gqF = false;
    a locala = new a((byte)0);
    locala.qmW = paramb;
    locala.qmX = paramString2;
    this.qmU.put(paramString1, locala);
    int i = com.tencent.mm.plugin.cdndownloader.c.a.cxZ().h(localg);
    Log.i("FileDownloaderWAGameProxy", "addDownloadTask: ".concat(String.valueOf(i)));
    AppMethodBeat.o(120821);
    return i;
  }
  
  final class a
  {
    public b qmW = null;
    public String qmX = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.h.a
 * JD-Core Version:    0.7.0.1
 */