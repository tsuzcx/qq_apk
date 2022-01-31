package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class e$b
  implements f.a
{
  private String fileName;
  private String jWi;
  
  private e$b(e parame, String paramString1, String paramString2)
  {
    this.jWi = paramString2;
    this.fileName = paramString1;
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    y.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      y.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
      paramString = this.jWx;
      paramc = this.fileName;
      String str = paramd.field_fileId;
      paramd = paramd.field_aesKey;
      if (paramString.jWu != null) {
        paramString.jWu.M(paramc, str, paramd);
      }
    }
    do
    {
      do
      {
        do
        {
          return 0;
          if (paramd == null) {
            break;
          }
          y.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
          com.tencent.mm.a.e.deleteFile(this.fileName);
          h.nFQ.a(917L, 51L, 1L, false);
        } while (this.jWx.jWu == null);
        this.jWx.jWu.onError();
        return 0;
      } while (paramInt == 0);
      y.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      h.nFQ.a(917L, 51L, 1L, false);
      com.tencent.mm.a.e.deleteFile(this.fileName);
    } while (this.jWx.jWu == null);
    this.jWx.jWu.onError();
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.b
 * JD-Core Version:    0.7.0.1
 */