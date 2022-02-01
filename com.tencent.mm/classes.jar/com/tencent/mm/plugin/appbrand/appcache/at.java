package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.efx;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public enum at
{
  public static void a(int paramInt, cnj paramcnj)
  {
    AppMethodBeat.i(44346);
    efy localefy;
    if (paramcnj != null)
    {
      localefy = new efy();
      localefy.url = paramcnj.url;
      localefy.md5 = paramcnj.md5;
      localefy.version = paramcnj.version;
      localefy.HgA = paramcnj.HgA;
      if (!paramcnj.GzY) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      localefy.HQX = i;
      localefy.dxg = paramcnj.dxg;
      a(paramInt, localefy, a.jHr);
      AppMethodBeat.o(44346);
      return;
    }
  }
  
  private static void a(int paramInt, efy paramefy, a parama)
  {
    AppMethodBeat.i(44345);
    if (j.aYX() != null)
    {
      PInt localPInt = new PInt();
      j.aYX().a(paramefy, localPInt);
      boolean bool;
      if (j.aYX().aQ("@LibraryAppId", 0) == paramefy.version) {
        if (WxaPkgIntegrityChecker.r(true, true).first == WxaPkgIntegrityChecker.a.jIp)
        {
          bool = true;
          ad.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(paramefy.version), Integer.valueOf(paramefy.HgA), paramefy.md5, paramefy.url });
          if (bool)
          {
            if ((paramInt <= 0) || (bt.isNullOrNil(paramefy.dxg))) {
              break label270;
            }
            x.jGy.T(paramInt, paramefy.dxg);
          }
        }
      }
      for (;;)
      {
        x.jGy.fH(true);
        ae localae = new ae();
        localae.field_key = "@LibraryAppId";
        localae.field_version = paramefy.version;
        if (!j.aZc().get(localae, new String[] { "key", "version" }))
        {
          localae.field_updateTime = bt.aQJ();
          localae.field_scene = (parama.ordinal() + 1);
          j.aZc().insert(localae);
        }
        if ((paramefy.HgA > 0) && (localPInt.value > 0)) {
          ar.bae();
        }
        AppMethodBeat.o(44345);
        return;
        bool = false;
        break;
        bool = false;
        break;
        label270:
        x.jGy.T(-1, null);
      }
    }
    ad.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    AppMethodBeat.o(44345);
  }
  
  public static void a(efy paramefy)
  {
    AppMethodBeat.i(44347);
    a(-1, paramefy, a.jHq);
    AppMethodBeat.o(44347);
  }
  
  public static void fM(boolean paramBoolean)
  {
    AppMethodBeat.i(44344);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44337);
        if (this.jHo)
        {
          ad.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ivj, Long.valueOf(bt.aQJ() - 1L));
        }
        at.access$000();
        AppMethodBeat.o(44337);
      }
    }, "WxaCommLibVersionChecker");
    AppMethodBeat.o(44344);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44341);
      jHp = new a("CGI", 0);
      jHq = new a("NewXml", 1);
      jHr = new a("Launch", 2);
      jHs = new a[] { jHp, jHq, jHr };
      AppMethodBeat.o(44341);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.at
 * JD-Core Version:    0.7.0.1
 */