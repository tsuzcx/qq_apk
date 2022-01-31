package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class j$4
  implements f.a
{
  j$4(j paramj) {}
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    String str1;
    String str2;
    if (paramc == null)
    {
      str1 = "null";
      if (paramd != null) {
        break label82;
      }
      str2 = "null";
      label17:
      y.d("MicroMsg.FileWebNetDownloader", "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), str1, str2 });
      if (paramInt != -21006) {
        break label92;
      }
      y.i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
    }
    label82:
    label92:
    do
    {
      return 0;
      str1 = paramc.toString();
      break;
      str2 = paramd.toString();
      break label17;
      if (paramInt != 0)
      {
        y.e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        j.a(this.iPU, paramString, 4, paramInt);
        return 0;
      }
      if (paramc != null)
      {
        j.a(this.iPU, paramString, paramc.field_finishedLength, paramc.field_toltalLength);
        return 0;
      }
    } while (paramd == null);
    if (paramd.field_retCode != 0)
    {
      y.e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
      j.a(this.iPU, paramString, 4, paramd.field_retCode);
      return 0;
    }
    y.i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", new Object[] { paramString });
    j.a(this.iPU, paramString, 3, 0);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.j.4
 * JD-Core Version:    0.7.0.1
 */