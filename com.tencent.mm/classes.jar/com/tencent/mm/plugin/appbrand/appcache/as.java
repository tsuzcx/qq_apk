package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.duc;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public enum as
{
  public static void a(int paramInt, cdg paramcdg)
  {
    AppMethodBeat.i(44346);
    dud localdud;
    if (paramcdg != null)
    {
      localdud = new dud();
      localdud.url = paramcdg.url;
      localdud.md5 = paramcdg.md5;
      localdud.version = paramcdg.version;
      localdud.DZz = paramcdg.DZz;
      if (!paramcdg.DZy) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      localdud.EIC = i;
      localdud.dnK = paramcdg.dnK;
      a(paramInt, localdud, a.iNm);
      AppMethodBeat.o(44346);
      return;
    }
  }
  
  private static void a(int paramInt, dud paramdud, a parama)
  {
    AppMethodBeat.i(44345);
    if (j.aOK() != null)
    {
      PInt localPInt = new PInt();
      j.aOK().a(paramdud, localPInt);
      boolean bool;
      if (j.aOK().aK("@LibraryAppId", 0) == paramdud.version) {
        if (WxaPkgIntegrityChecker.q(true, true).first == WxaPkgIntegrityChecker.a.iOk)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(paramdud.version), Integer.valueOf(paramdud.DZz), paramdud.md5, paramdud.url });
          if (bool)
          {
            if ((paramInt <= 0) || (bt.isNullOrNil(paramdud.dnK))) {
              break label270;
            }
            w.iMv.Q(paramInt, paramdud.dnK);
          }
        }
      }
      for (;;)
      {
        w.iMv.fh(true);
        ad localad = new ad();
        localad.field_key = "@LibraryAppId";
        localad.field_version = paramdud.version;
        if (!j.aOP().get(localad, new String[] { "key", "version" }))
        {
          localad.field_updateTime = bt.aGK();
          localad.field_scene = (parama.ordinal() + 1);
          j.aOP().insert(localad);
        }
        if ((paramdud.DZz > 0) && (localPInt.value > 0)) {
          aq.aPP();
        }
        AppMethodBeat.o(44345);
        return;
        bool = false;
        break;
        bool = false;
        break;
        label270:
        w.iMv.Q(-1, null);
      }
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    AppMethodBeat.o(44345);
  }
  
  public static void a(dud paramdud)
  {
    AppMethodBeat.i(44347);
    a(-1, paramdud, a.iNl);
    AppMethodBeat.o(44347);
  }
  
  public static void fm(boolean paramBoolean)
  {
    AppMethodBeat.i(44344);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44337);
        if (this.iNj)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
          g.afB().afk().set(ae.a.Flc, Long.valueOf(bt.aGK() - 1L));
        }
        as.access$000();
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
      iNk = new a("CGI", 0);
      iNl = new a("NewXml", 1);
      iNm = new a("Launch", 2);
      iNn = new a[] { iNk, iNl, iNm };
      AppMethodBeat.o(44341);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.as
 * JD-Core Version:    0.7.0.1
 */