package com.tencent.mm.plugin.cdndownloader.i;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class a$1
  implements f.a
{
  a$1(a parama) {}
  
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
      y.d("FileDownloaderXWEBProxy", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramString, Integer.valueOf(paramInt), str1, str2 });
      if (paramInt != -21006) {
        break label92;
      }
      y.i("FileDownloaderXWEBProxy", "duplicate request, ignore this request, media id is %s", new Object[] { paramString });
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
        y.e("FileDownloaderXWEBProxy", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramInt), paramString });
        a.a(this.iAY, paramString, 4, paramInt, false);
        return 0;
      }
      if (paramc != null)
      {
        a.a(this.iAY, paramString, paramc.field_finishedLength, paramc.field_toltalLength);
        return 0;
      }
    } while (paramd == null);
    if (paramd.field_retCode != 0)
    {
      y.e("FileDownloaderXWEBProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramString, Integer.valueOf(paramd.field_retCode), paramd });
      a.a(this.iAY, paramString, 4, paramd.field_retCode, paramd.field_isResume);
      return 0;
    }
    y.i("FileDownloaderXWEBProxy", "cdn trans suceess, media id : %s", new Object[] { paramString });
    a.a(this.iAY, paramString, 3, 0, paramd.field_isResume);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.i.a.1
 * JD-Core Version:    0.7.0.1
 */