package com.tencent.mm.plugin.facedetect.service;

import com.tencent.mm.a.e;
import com.tencent.mm.ah.p;
import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class FaceUploadVideoService$a
  implements f.a
{
  private long jNI = -1L;
  private String mAppId = null;
  private String mFileName = null;
  
  private FaceUploadVideoService$a(FaceUploadVideoService paramFaceUploadVideoService, long paramLong, String paramString1, String paramString2)
  {
    this.jNI = paramLong;
    this.mAppId = paramString1;
    this.mFileName = paramString2;
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    y.i("MicroMsg.FaceUploadVideoService", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      y.i("MicroMsg.FaceUploadVideoService", "hy: upload video done. now upload");
      h.nFQ.a(917L, 23L, 1L, false);
      FaceDetectReporter.e(this.jNI, 0, 0);
      g.Dk().a(1197, this.jQa);
      g.Dk().a(new r(this.mFileName, this.jNI, this.mAppId, paramd.field_fileId, paramd.field_aesKey), 0);
    }
    do
    {
      return 0;
      if (paramd != null)
      {
        y.w("MicroMsg.FaceUploadVideoService", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        e.deleteFile(this.mFileName);
        h.nFQ.a(917L, 24L, 1L, false);
        FaceDetectReporter.e(this.jNI, 1, paramd.field_retCode);
        return 0;
      }
    } while (paramInt == 0);
    y.w("MicroMsg.FaceUploadVideoService", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    e.deleteFile(this.mFileName);
    h.nFQ.a(917L, 24L, 1L, false);
    FaceDetectReporter.e(this.jNI, 1, paramInt);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.FaceUploadVideoService.a
 * JD-Core Version:    0.7.0.1
 */