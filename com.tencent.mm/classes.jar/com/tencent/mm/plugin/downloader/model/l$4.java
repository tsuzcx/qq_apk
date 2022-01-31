package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

final class l$4
  implements g.a
{
  l$4(l paraml) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(2468);
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
      ab.d("MicroMsg.FileWebNetDownloader", "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), str1, str2 });
      if (paramInt != -21006) {
        break label104;
      }
      ab.i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
      AppMethodBeat.o(2468);
      return 0;
      str1 = paramc.toString();
      break;
    }
    label104:
    if (paramInt != 0)
    {
      ab.e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
      l.a(this.kZg, paramString, 4, paramInt);
      AppMethodBeat.o(2468);
      return 0;
    }
    if (paramc != null)
    {
      l.a(this.kZg, paramString, paramc.field_finishedLength, paramc.field_toltalLength);
      AppMethodBeat.o(2468);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label244;
      }
      ab.e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
      l.a(this.kZg, paramString, 4, paramd.field_retCode);
    }
    for (;;)
    {
      AppMethodBeat.o(2468);
      return 0;
      label244:
      ab.i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", new Object[] { paramString });
      l.a(this.kZg, paramString, 3, 0);
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.l.4
 * JD-Core Version:    0.7.0.1
 */