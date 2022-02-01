package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dfy;
import com.tencent.mm.protocal.protobuf.fcg;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public enum au
{
  public static void a(int paramInt, dfy paramdfy)
  {
    AppMethodBeat.i(44346);
    fch localfch;
    if (paramdfy != null)
    {
      h.CyF.dN(1509, 21);
      localfch = new fch();
      localfch.url = paramdfy.url;
      localfch.md5 = paramdfy.md5;
      localfch.version = paramdfy.version;
      localfch.MKJ = paramdfy.MKJ;
      if (!paramdfy.LXH) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 0)
    {
      localfch.Nyg = i;
      localfch.dPS = paramdfy.dPS;
      a(paramInt, localfch, a.kMr);
      AppMethodBeat.o(44346);
      return;
    }
  }
  
  private static void a(int paramInt, fch paramfch, a parama)
  {
    AppMethodBeat.i(44345);
    PInt localPInt;
    int i;
    label71:
    boolean bool;
    switch (3.kMo[parama.ordinal()])
    {
    default: 
      if (n.buL() == null) {
        break label530;
      }
      localPInt = new PInt();
      n.buL().a(paramfch, localPInt);
      if (localPInt.value > 0)
      {
        i = 1;
        int j = n.buL().aY("@LibraryAppId", 0);
        if (WxaPkgIntegrityChecker.r(true, true).first != WxaPkgIntegrityChecker.a.kNp) {
          break label430;
        }
        bool = true;
        label99:
        if (i != 0) {}
        switch (3.kMo[parama.ordinal()])
        {
        default: 
          Log.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, scene %s, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s, localMaxVersion = %d", new Object[] { Integer.valueOf(paramInt), parama.name(), Boolean.valueOf(bool), Integer.valueOf(paramfch.version), Integer.valueOf(paramfch.MKJ), paramfch.md5, paramfch.url, Integer.valueOf(j) });
          if (bool)
          {
            if ((paramInt <= 0) || (Util.isNullOrNil(paramfch.dPS))) {
              break label519;
            }
            y.kLv.W(paramInt, paramfch.dPS);
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      y.kLv.gB(true);
      Object localObject = new af();
      ((af)localObject).field_key = "@LibraryAppId";
      ((af)localObject).field_version = paramfch.version;
      if (!n.buQ().get((IAutoDBItem)localObject, new String[] { "key", "version" }))
      {
        ((af)localObject).field_updateTime = Util.nowSecond();
        ((af)localObject).field_scene = (parama.ordinal() + 1);
        n.buQ().insert((IAutoDBItem)localObject);
      }
      if ((paramfch.MKJ > 0) && (localPInt.value > 0)) {
        as.bvR();
      }
      AppMethodBeat.o(44345);
      return;
      if (paramfch.Nyg > 0) {
        h.CyF.dN(1509, 3);
      }
      if (paramfch.MKJ <= 0) {
        break;
      }
      h.CyF.dN(1509, 4);
      break;
      if (paramfch.Nyg > 0) {
        h.CyF.dN(1509, 22);
      }
      if (paramfch.MKJ <= 0) {
        break;
      }
      h.CyF.dN(1509, 23);
      break;
      i = 0;
      break label71;
      label430:
      bool = false;
      break label99;
      h.CyF.dN(1509, 5);
      localObject = h.CyF;
      if (bool) {}
      for (i = 7;; i = 6)
      {
        ((h)localObject).dN(1509, i);
        break;
      }
      h.CyF.dN(1509, 24);
      localObject = h.CyF;
      if (bool) {}
      for (i = 26;; i = 25)
      {
        ((h)localObject).dN(1509, i);
        break;
      }
      label519:
      y.kLv.W(-1, null);
    }
    label530:
    Log.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    AppMethodBeat.o(44345);
  }
  
  public static void a(fch paramfch)
  {
    AppMethodBeat.i(44347);
    a(-1, paramfch, a.kMq);
    AppMethodBeat.o(44347);
  }
  
  public static void gH(boolean paramBoolean)
  {
    AppMethodBeat.i(44344);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44337);
        if (this.kMn)
        {
          Log.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
          g.aAh().azQ().set(ar.a.NXI, Long.valueOf(Util.nowSecond() - 1L));
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
      kMp = new a("CGI", 0);
      kMq = new a("NewXml", 1);
      kMr = new a("Launch", 2);
      kMs = new a[] { kMp, kMq, kMr };
      AppMethodBeat.o(44341);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.au
 * JD-Core Version:    0.7.0.1
 */