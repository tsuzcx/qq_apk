package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.g.b.a.a;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

public final class c
  implements g.a
{
  String appName = null;
  String ytQ = null;
  
  public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(23502);
    Log.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (paramString.equals(this.ytQ))) {
      if ((paramInt == 0) && (paramd.field_retCode == 0))
      {
        Log.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
        Log.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", new Object[] { paramString, paramd.toString() });
        paramString = new a();
        paramString.field_championUrl = paramd.field_fileUrl;
        paramString.field_username = z.bAM();
        b.apy(paramString.field_championUrl);
        ah.dFV().a(paramString);
        ah.dFZ();
        com.tencent.mm.plugin.exdevice.g.b.c.gT(paramString.field_championUrl, paramString.field_championMotto);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23502);
      return 0;
      Log.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
      continue;
      if (paramc != null) {
        Log.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.c
 * JD-Core Version:    0.7.0.1
 */