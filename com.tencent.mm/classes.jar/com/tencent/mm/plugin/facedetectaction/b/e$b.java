package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;

final class e$b
  implements g.a
{
  private String fileName;
  private String rpB;
  
  private e$b(e parame, String paramString1, String paramString2)
  {
    this.rpB = paramString2;
    this.fileName = paramString1;
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(104226);
    ad.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      ad.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
      paramString = this.rpQ;
      paramc = this.fileName;
      String str = paramd.field_fileId;
      paramd = paramd.field_aesKey;
      if (paramString.rpM != null) {
        paramString.rpM.a(paramc, str, paramd, paramString.rpN);
      }
    }
    do
    {
      AppMethodBeat.o(104226);
      return 0;
      if (paramd != null)
      {
        ad.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        i.deleteFile(this.fileName);
        g.yhR.idkeyStat(917L, 51L, 1L, false);
        if (this.rpQ.rpM != null) {
          this.rpQ.rpM.onError();
        }
        AppMethodBeat.o(104226);
        return 0;
      }
    } while (paramInt == 0);
    ad.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    g.yhR.idkeyStat(917L, 51L, 1L, false);
    i.deleteFile(this.fileName);
    if (this.rpQ.rpM != null) {
      this.rpQ.rpM.onError();
    }
    AppMethodBeat.o(104226);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.b
 * JD-Core Version:    0.7.0.1
 */