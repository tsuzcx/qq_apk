package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.mm.j.c;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class a$1
  implements f.a
{
  a$1(a parama) {}
  
  public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if (paramInt == -21005) {
      y.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    }
    double d;
    do
    {
      do
      {
        return 0;
        if ((paramd != null) && (paramd.field_retCode == 0))
        {
          y.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
          paramc = paramd.field_fileId;
          paramString = new Bundle();
          paramString.putString("key_pic_cdn_id", paramc);
          paramString.putString("key_cdn_aes_key", paramd.field_aesKey);
          paramc = this.jMz;
          if (paramc.jMn != null) {
            paramc.jMn.i("ok", paramString);
          }
          h.nFQ.a(917L, 13L, 1L, false);
          return 0;
        }
        if (paramd != null)
        {
          y.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
          h.nFQ.a(917L, 14L, 1L, false);
          this.jMz.l(3, 90020, "cdn ret error");
          return 0;
        }
        if (paramInt != 0)
        {
          y.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
          h.nFQ.a(917L, 14L, 1L, false);
          this.jMz.l(3, 90021, "cdn start error");
          return 0;
        }
        y.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      } while (paramc == null);
      d = paramc.field_finishedLength / paramc.field_toltalLength;
      y.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[] { Double.valueOf(d) });
      paramString = this.jMz;
    } while (paramString.jMn == null);
    paramString.jMn.s(d);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.a.1
 * JD-Core Version:    0.7.0.1
 */