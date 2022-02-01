package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.eho;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public enum au
{
  public static void a(int paramInt, cod paramcod)
  {
    AppMethodBeat.i(44346);
    ehp localehp;
    if (paramcod != null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(1509, 21);
      localehp = new ehp();
      localehp.url = paramcod.url;
      localehp.md5 = paramcod.md5;
      localehp.version = paramcod.version;
      localehp.HAa = paramcod.HAa;
      if (!paramcod.GTy) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 0)
    {
      localehp.Ile = i;
      localehp.dyl = paramcod.dyl;
      a(paramInt, localehp, a.jKs);
      AppMethodBeat.o(44346);
      return;
    }
  }
  
  private static void a(int paramInt, ehp paramehp, a parama)
  {
    AppMethodBeat.i(44345);
    PInt localPInt;
    int i;
    label71:
    boolean bool;
    switch (3.jKp[parama.ordinal()])
    {
    default: 
      if (j.aZu() == null) {
        break label530;
      }
      localPInt = new PInt();
      j.aZu().a(paramehp, localPInt);
      if (localPInt.value > 0)
      {
        i = 1;
        int j = j.aZu().aT("@LibraryAppId", 0);
        if (WxaPkgIntegrityChecker.r(true, true).first != WxaPkgIntegrityChecker.a.jLq) {
          break label430;
        }
        bool = true;
        label99:
        if (i != 0) {}
        switch (3.jKp[parama.ordinal()])
        {
        default: 
          ae.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, scene %s, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s, localMaxVersion = %d", new Object[] { Integer.valueOf(paramInt), parama.name(), Boolean.valueOf(bool), Integer.valueOf(paramehp.version), Integer.valueOf(paramehp.HAa), paramehp.md5, paramehp.url, Integer.valueOf(j) });
          if (bool)
          {
            if ((paramInt <= 0) || (bu.isNullOrNil(paramehp.dyl))) {
              break label519;
            }
            y.jJy.T(paramInt, paramehp.dyl);
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      y.jJy.fG(true);
      Object localObject = new af();
      ((af)localObject).field_key = "@LibraryAppId";
      ((af)localObject).field_version = paramehp.version;
      if (!j.aZz().get((c)localObject, new String[] { "key", "version" }))
      {
        ((af)localObject).field_updateTime = bu.aRi();
        ((af)localObject).field_scene = (parama.ordinal() + 1);
        j.aZz().insert((c)localObject);
      }
      if ((paramehp.HAa > 0) && (localPInt.value > 0)) {
        as.baD();
      }
      AppMethodBeat.o(44345);
      return;
      if (paramehp.Ile > 0) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1509, 3);
      }
      if (paramehp.HAa <= 0) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(1509, 4);
      break;
      if (paramehp.Ile > 0) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1509, 22);
      }
      if (paramehp.HAa <= 0) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(1509, 23);
      break;
      i = 0;
      break label71;
      label430:
      bool = false;
      break label99;
      com.tencent.mm.plugin.report.service.g.yxI.dD(1509, 5);
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      if (bool) {}
      for (i = 7;; i = 6)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).dD(1509, i);
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(1509, 24);
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      if (bool) {}
      for (i = 26;; i = 25)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).dD(1509, i);
        break;
      }
      label519:
      y.jJy.T(-1, null);
    }
    label530:
    ae.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    AppMethodBeat.o(44345);
  }
  
  public static void a(ehp paramehp)
  {
    AppMethodBeat.i(44347);
    a(-1, paramehp, a.jKr);
    AppMethodBeat.o(44347);
  }
  
  public static void fL(boolean paramBoolean)
  {
    AppMethodBeat.i(44344);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44337);
        if (this.jKo)
        {
          ae.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPH, Long.valueOf(bu.aRi() - 1L));
        }
        au.access$000();
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
      jKq = new a("CGI", 0);
      jKr = new a("NewXml", 1);
      jKs = new a("Launch", 2);
      jKt = new a[] { jKq, jKr, jKs };
      AppMethodBeat.o(44341);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au
 * JD-Core Version:    0.7.0.1
 */