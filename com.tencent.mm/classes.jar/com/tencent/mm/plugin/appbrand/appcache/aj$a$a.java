package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.e;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import javax.net.ssl.SSLException;

abstract class aj$a$a
  implements f.a
{
  private final aj.c fDO;
  
  aj$a$a(aj.c paramc)
  {
    this.fDO = paramc;
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, d paramd, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      b(new m(this.fDO, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.fDO.cls(), Integer.valueOf(paramInt) })), 3));
      y.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.fDO.cls(), Integer.valueOf(paramInt) });
      return 0;
    }
    if (paramc != null)
    {
      paramString = this.fDO.rXJ;
      if (paramString != null)
      {
        paramc = new WxaPkgLoadProgress((int)(paramc.field_finishedLength / paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
        paramString.a(this.fDO.cls(), paramc);
      }
      return 0;
    }
    if (paramd != null)
    {
      y.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s", new Object[] { this.fDO.cls(), Integer.valueOf(paramd.field_retCode), paramd.field_httpResponseHeader });
      if (paramd.field_retCode == 0) {
        break label321;
      }
      if ((paramd.field_fileLength <= 0) || (this.fDO.ct(paramd.field_fileLength))) {
        break label260;
      }
      paramString = new m(this.fDO, new com.tencent.mm.pluginsdk.g.a.b.a(), paramd.field_httpStatusCode, 3);
      b(paramString);
    }
    for (;;)
    {
      return 0;
      label260:
      paramString = new m(this.fDO, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.fDO.cls(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
      break;
      label321:
      b(new m(this.fDO, paramd.field_fileLength, null));
      paramInt = (int)e.aeQ(this.fDO.aca().bjl());
      if (am.a.dVz != null) {
        am.a.dVz.bg(paramInt, 0);
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  abstract void b(m paramm);
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.a.a
 * JD-Core Version:    0.7.0.1
 */