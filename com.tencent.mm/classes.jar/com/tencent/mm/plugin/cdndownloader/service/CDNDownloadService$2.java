package com.tencent.mm.plugin.cdndownloader.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

final class CDNDownloadService$2
  implements g.a
{
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(948);
    String str1;
    if (paramc == null)
    {
      str1 = "null";
      if (paramd != null) {
        break label94;
      }
    }
    label94:
    for (String str2 = "null";; str2 = paramd.toString())
    {
      ab.d("MicroMsg.CDNDownloadService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), str1, str2 });
      if (paramInt != -21006) {
        break label104;
      }
      ab.i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
      AppMethodBeat.o(948);
      return 0;
      str1 = paramc.toString();
      break;
    }
    label104:
    if (paramInt != 0)
    {
      ab.e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      CDNDownloadService.Y(paramString, 4, paramInt);
      AppMethodBeat.o(948);
      return 0;
    }
    if (paramc != null)
    {
      CDNDownloadService.u(paramString, paramc.field_finishedLength, paramc.field_toltalLength);
      AppMethodBeat.o(948);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label232;
      }
      ab.e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
      CDNDownloadService.Y(paramString, 4, paramd.field_retCode);
    }
    for (;;)
    {
      AppMethodBeat.o(948);
      return 0;
      label232:
      ab.i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", new Object[] { paramString });
      CDNDownloadService.Y(paramString, 3, 0);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService.2
 * JD-Core Version:    0.7.0.1
 */