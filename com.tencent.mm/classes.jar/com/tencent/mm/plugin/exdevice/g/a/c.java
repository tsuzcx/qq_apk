package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.exdevice.g.b.a.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.ByteArrayOutputStream;

public final class c
  implements g.a
{
  String appName = null;
  String pBc = null;
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(23502);
    ac.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (paramString.equals(this.pBc))) {
      if ((paramInt == 0) && (paramd.field_retCode == 0))
      {
        ac.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
        ac.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", new Object[] { paramString, paramd.toString() });
        paramString = new a();
        paramString.field_championUrl = paramd.field_fileUrl;
        paramString.field_username = u.axw();
        b.YT(paramString.field_championUrl);
        ad.cgT().a(paramString);
        ad.cgX();
        paramc = paramString.field_championUrl;
        paramString = paramString.field_championMotto;
        az.agi().a(new m(paramc, paramString), 0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(23502);
      return 0;
      ac.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
      continue;
      if (paramc != null) {
        ac.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.c
 * JD-Core Version:    0.7.0.1
 */