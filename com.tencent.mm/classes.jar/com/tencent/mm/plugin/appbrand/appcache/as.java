package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;

public enum as
{
  public static void a(int paramInt, cij paramcij)
  {
    AppMethodBeat.i(44346);
    dzu localdzu;
    if (paramcij != null)
    {
      localdzu = new dzu();
      localdzu.url = paramcij.url;
      localdzu.md5 = paramcij.md5;
      localdzu.version = paramcij.version;
      localdzu.Fwu = paramcij.Fwu;
      if (!paramcij.EQH) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      localdzu.GfO = i;
      localdzu.dlt = paramcij.dlt;
      a(paramInt, localdzu, a.jnu);
      AppMethodBeat.o(44346);
      return;
    }
  }
  
  private static void a(int paramInt, dzu paramdzu, a parama)
  {
    AppMethodBeat.i(44345);
    if (j.aVC() != null)
    {
      PInt localPInt = new PInt();
      j.aVC().a(paramdzu, localPInt);
      boolean bool;
      if (j.aVC().aO("@LibraryAppId", 0) == paramdzu.version) {
        if (WxaPkgIntegrityChecker.r(true, true).first == WxaPkgIntegrityChecker.a.jot)
        {
          bool = true;
          ac.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(paramdzu.version), Integer.valueOf(paramdzu.Fwu), paramdzu.md5, paramdzu.url });
          if (bool)
          {
            if ((paramInt <= 0) || (bs.isNullOrNil(paramdzu.dlt))) {
              break label270;
            }
            w.jmC.R(paramInt, paramdzu.dlt);
          }
        }
      }
      for (;;)
      {
        w.jmC.fD(true);
        ad localad = new ad();
        localad.field_key = "@LibraryAppId";
        localad.field_version = paramdzu.version;
        if (!j.aVH().get(localad, new String[] { "key", "version" }))
        {
          localad.field_updateTime = bs.aNx();
          localad.field_scene = (parama.ordinal() + 1);
          j.aVH().insert(localad);
        }
        if ((paramdzu.Fwu > 0) && (localPInt.value > 0)) {
          aq.aWH();
        }
        AppMethodBeat.o(44345);
        return;
        bool = false;
        break;
        bool = false;
        break;
        label270:
        w.jmC.R(-1, null);
      }
    }
    ac.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    AppMethodBeat.o(44345);
  }
  
  public static void a(dzu paramdzu)
  {
    AppMethodBeat.i(44347);
    a(-1, paramdzu, a.jnt);
    AppMethodBeat.o(44347);
  }
  
  public static void fI(boolean paramBoolean)
  {
    AppMethodBeat.i(44344);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44337);
        if (this.jnr)
        {
          ac.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
          g.agR().agA().set(ah.a.GIR, Long.valueOf(bs.aNx() - 1L));
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
      jns = new a("CGI", 0);
      jnt = new a("NewXml", 1);
      jnu = new a("Launch", 2);
      jnv = new a[] { jns, jnt, jnu };
      AppMethodBeat.o(44341);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.as
 * JD-Core Version:    0.7.0.1
 */