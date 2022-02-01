package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

final class e$b
  implements g.a
{
  private String fileName;
  private String personId;
  
  private e$b(e parame, String paramString1, String paramString2)
  {
    this.personId = paramString2;
    this.fileName = paramString1;
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(104226);
    Log.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    int i;
    if (paramd == null)
    {
      i = -1;
      b.dLj().eqU = i;
      b.dLj().eqW = (System.currentTimeMillis() - this.sXS.sXP);
      b.s("rspCdn", Integer.valueOf(i));
      if ((paramd == null) || (paramd.field_retCode != 0)) {
        break label165;
      }
      Log.i("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video done. now upload");
      paramString = this.sXS;
      paramc = this.fileName;
      String str = paramd.field_fileId;
      paramd = paramd.field_aesKey;
      if (paramString.sXM != null) {
        paramString.sXM.a(paramc, str, paramd, paramString.sXN);
      }
    }
    label165:
    do
    {
      AppMethodBeat.o(104226);
      return 0;
      i = paramd.field_retCode;
      break;
      if (paramd != null)
      {
        Log.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
        s.deleteFile(this.fileName);
        h.CyF.idkeyStat(917L, 51L, 1L, false);
        if (this.sXS.sXM != null) {
          this.sXS.sXM.onError();
        }
        AppMethodBeat.o(104226);
        return 0;
      }
    } while (paramInt == 0);
    Log.w("MicroMsg.FaceCheckVideoRecordMgr", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    h.CyF.idkeyStat(917L, 51L, 1L, false);
    s.deleteFile(this.fileName);
    if (this.sXS.sXM != null) {
      this.sXS.sXM.onError();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.e.b
 * JD-Core Version:    0.7.0.1
 */