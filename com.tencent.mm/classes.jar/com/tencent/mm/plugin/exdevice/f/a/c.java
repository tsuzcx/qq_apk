package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

public final class c
  implements f.a
{
  String appName = null;
  String jxH = null;
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, d paramd, boolean paramBoolean)
  {
    y.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (paramString.equals(this.jxH))) {
      if ((paramInt == 0) && (paramd.field_retCode == 0))
      {
        y.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
        y.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", new Object[] { paramString, paramd.toString() });
        paramString = new a();
        paramString.field_championUrl = paramd.field_fileUrl;
        paramString.field_username = q.Gj();
        b.Bw(paramString.field_championUrl);
        ad.aLP().a(paramString);
        ad.aLT();
        paramc = paramString.field_championUrl;
        paramString = paramString.field_championMotto;
        au.Dk().a(new m(paramc, paramString), 0);
      }
    }
    while (paramc == null)
    {
      return 0;
      y.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
      return 0;
    }
    y.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.c
 * JD-Core Version:    0.7.0.1
 */