package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.protocal.protobuf.fnh;
import com.tencent.mm.protocal.protobuf.fni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public enum aw
{
  public static void a(int paramInt, dps paramdps)
  {
    int i = 0;
    AppMethodBeat.i(44346);
    int j;
    if (paramdps != null)
    {
      j = paramdps.version;
      if (paramdps.TWD <= 0) {
        break label181;
      }
    }
    label181:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WxaCommLibVersionChecker", "updateByLaunchWxaApp, reqVersion:%d, respVersion:%d, force_update:%b, rely_update:%b, need_update:%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), Boolean.valueOf(bool), Boolean.valueOf(paramdps.TWE), Boolean.valueOf(paramdps.TgY) });
      com.tencent.mm.plugin.report.service.h.IzE.el(1509, 21);
      fni localfni = new fni();
      localfni.url = paramdps.url;
      localfni.md5 = paramdps.md5;
      localfni.version = paramdps.version;
      localfni.TWD = paramdps.TWD;
      if ((paramdps.TgY) || (paramdps.TWE)) {
        i = 1;
      }
      localfni.ULJ = i;
      localfni.fJj = paramdps.fJj;
      a(paramInt, localfni, a.nGj);
      AppMethodBeat.o(44346);
      return;
    }
  }
  
  private static void a(int paramInt, fni paramfni, a parama)
  {
    AppMethodBeat.i(44345);
    PInt localPInt;
    int i;
    label71:
    boolean bool;
    switch (3.nGg[parama.ordinal()])
    {
    default: 
      if (m.bFP() == null) {
        break label530;
      }
      localPInt = new PInt();
      m.bFP().a(paramfni, localPInt);
      if (localPInt.value > 0)
      {
        i = 1;
        int j = m.bFP().bp("@LibraryAppId", 0);
        if (WxaPkgIntegrityChecker.hu(true).first != WxaPkgIntegrityChecker.a.nHp) {
          break label430;
        }
        bool = true;
        label98:
        if (i != 0) {}
        switch (3.nGg[parama.ordinal()])
        {
        default: 
          Log.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, scene %s, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s, localMaxVersion = %d", new Object[] { Integer.valueOf(paramInt), parama.name(), Boolean.valueOf(bool), Integer.valueOf(paramfni.version), Integer.valueOf(paramfni.TWD), paramfni.md5, paramfni.url, Integer.valueOf(j) });
          if (bool)
          {
            if ((paramInt <= 0) || (Util.isNullOrNil(paramfni.fJj))) {
              break label519;
            }
            z.nFo.Y(paramInt, paramfni.fJj);
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      z.nFo.hm(true);
      Object localObject = new ag();
      ((ag)localObject).field_key = "@LibraryAppId";
      ((ag)localObject).field_version = paramfni.version;
      if (!m.bFV().get((IAutoDBItem)localObject, new String[] { "key", "version" }))
      {
        ((ag)localObject).field_updateTime = Util.nowSecond();
        ((ag)localObject).field_scene = (parama.ordinal() + 1);
        m.bFV().insert((IAutoDBItem)localObject);
      }
      if ((paramfni.TWD > 0) && (localPInt.value > 0)) {
        at.bGZ();
      }
      AppMethodBeat.o(44345);
      return;
      if (paramfni.ULJ > 0) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1509, 3);
      }
      if (paramfni.TWD <= 0) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(1509, 4);
      break;
      if (paramfni.ULJ > 0) {
        com.tencent.mm.plugin.report.service.h.IzE.el(1509, 22);
      }
      if (paramfni.TWD <= 0) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(1509, 23);
      break;
      i = 0;
      break label71;
      label430:
      bool = false;
      break label98;
      com.tencent.mm.plugin.report.service.h.IzE.el(1509, 5);
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (bool) {}
      for (i = 7;; i = 6)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).el(1509, i);
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(1509, 24);
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      if (bool) {}
      for (i = 26;; i = 25)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).el(1509, i);
        break;
      }
      label519:
      z.nFo.Y(-1, null);
    }
    label530:
    Log.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    AppMethodBeat.o(44345);
  }
  
  public static void a(fni paramfni)
  {
    AppMethodBeat.i(44347);
    a(-1, paramfni, a.nGi);
    AppMethodBeat.o(44347);
  }
  
  public static void hs(boolean paramBoolean)
  {
    AppMethodBeat.i(44344);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44337);
        if (this.nGf)
        {
          Log.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlI, Long.valueOf(Util.nowSecond() - 1L));
        }
        aw.access$000();
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
      nGh = new a("CGI", 0);
      nGi = new a("NewXml", 1);
      nGj = new a("Launch", 2);
      nGk = new a[] { nGh, nGi, nGj };
      AppMethodBeat.o(44341);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aw
 * JD-Core Version:    0.7.0.1
 */