package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;

public final class c
  implements g.a
{
  String appName = null;
  String lHg = null;
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(19435);
    ab.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (paramString.equals(this.lHg))) {
      if ((paramInt == 0) && (paramd.field_retCode == 0))
      {
        ab.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
        ab.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", new Object[] { paramString, paramd.toString() });
        paramString = new a();
        paramString.field_championUrl = paramd.field_fileUrl;
        paramString.field_username = r.Zn();
        b.Ly(paramString.field_championUrl);
        ad.bqc().a(paramString);
        ad.bqg();
        paramc = paramString.field_championUrl;
        paramString = paramString.field_championMotto;
        aw.Rc().a(new m(paramc, paramString), 0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(19435);
      return 0;
      ab.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
      continue;
      if (paramc != null) {
        ab.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.c
 * JD-Core Version:    0.7.0.1
 */