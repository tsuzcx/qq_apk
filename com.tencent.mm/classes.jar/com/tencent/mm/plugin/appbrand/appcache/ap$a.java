package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

final class ap$a
{
  public final m a(ap.c paramc)
  {
    AppMethodBeat.i(59485);
    str1 = paramc.dlZ();
    ab.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", new Object[] { paramc.getURL() });
    try
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      j localj = new j();
      com.tencent.mm.plugin.appbrand.appcache.a.a locala = paramc.avR();
      String str2 = locala.vMK;
      Object localObject1 = paramc.gWi;
      if (paramc.avR().gXk) {
        localObject1 = new ap(com.tencent.mm.ipcinvoker.l.PP().getLooper(), new ap.a.1(this, str2, (z.a)localObject1, locala, localj, localCountDownLatch), false);
      }
      for (;;)
      {
        Object localObject2 = new ap.a.2(this, paramc, (ap)localObject1, localj, localCountDownLatch);
        paramc = new com.tencent.mm.i.g();
        paramc.field_mediaId = str2;
        paramc.field_fullpath = locala.getFilePath();
        paramc.eds = locala.url;
        paramc.cMU = false;
        paramc.edp = ((g.a)localObject2);
        paramc.edt = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getConnectTimeout()));
        paramc.edu = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getReadTimeout()));
        paramc.field_fileType = com.tencent.mm.i.a.ecS;
        if ((locala instanceof l)) {
          paramc.edw = false;
        }
        str2 = Uri.parse(paramc.eds).getHost();
        if (!bo.isNullOrNil(str2)) {
          localObject2 = new ArrayList();
        }
        try
        {
          com.tencent.mm.kernel.g.RK().eHt.ftA.getHostByName(str2, (List)localObject2);
          paramc.edv = new String[((ArrayList)localObject2).size()];
          ((ArrayList)localObject2).toArray(paramc.edv);
          f.afO().b(paramc, -1);
          if (localObject1 != null)
          {
            long l = locala.getReadTimeout();
            ((ap)localObject1).ag(l, l);
          }
          try
          {
            localCountDownLatch.await();
            paramc = (m)localj.value;
            AppMethodBeat.o(59485);
            return paramc;
          }
          catch (Exception paramc)
          {
            ab.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[] { str1, paramc });
            AppMethodBeat.o(59485);
          }
          localObject1 = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https getHostByName e = %s", new Object[] { localException });
          }
        }
      }
      return null;
    }
    catch (Exception paramc)
    {
      ab.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[] { str1, paramc });
      AppMethodBeat.o(59485);
      return null;
    }
  }
  
  static abstract class a
    implements g.a
  {
    private final ap.c gWe;
    
    a(ap.c paramc)
    {
      this.gWe = paramc;
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      if (paramInt != 0)
      {
        b(new m(this.gWe, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.gWe.dlZ(), Integer.valueOf(paramInt) })), 3));
        ab.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.gWe.dlZ(), Integer.valueOf(paramInt) });
        return 0;
      }
      if (paramc != null)
      {
        paramString = this.gWe.vOA;
        if (paramString != null)
        {
          paramc = new WxaPkgLoadProgress((int)(paramc.field_finishedLength / paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
          paramString.a(this.gWe.dlZ(), paramc);
        }
        return 0;
      }
      if (paramd != null)
      {
        ab.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s", new Object[] { this.gWe.dlZ(), Integer.valueOf(paramd.field_retCode), paramd.field_httpResponseHeader });
        if (paramd.field_retCode == 0) {
          break label321;
        }
        if ((paramd.field_fileLength <= 0) || (this.gWe.hq(paramd.field_fileLength))) {
          break label260;
        }
        paramString = new m(this.gWe, new com.tencent.mm.pluginsdk.g.a.b.a(), paramd.field_httpStatusCode, 3);
        b(paramString);
      }
      for (;;)
      {
        return 0;
        label260:
        paramString = new m(this.gWe, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.gWe.dlZ(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
        break;
        label321:
        b(new m(this.gWe, paramd.field_fileLength, null));
        paramInt = (int)com.tencent.mm.vfs.e.avI(this.gWe.avR().getFilePath());
        if (ao.a.flJ != null) {
          ao.a.flJ.cq(paramInt, 0);
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    abstract void b(m paramm);
    
    public final byte[] l(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.a
 * JD-Core Version:    0.7.0.1
 */