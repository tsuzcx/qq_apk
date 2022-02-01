package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.eim;
import com.tencent.mm.protocal.protobuf.gkb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.thread.ThreadPool;

public enum ax
{
  public static void a(int paramInt, eim parameim)
  {
    int i = 0;
    AppMethodBeat.i(44346);
    int j;
    if (parameim != null)
    {
      j = parameim.version;
      if (parameim.abns <= 0) {
        break label181;
      }
    }
    label181:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WxaCommLibVersionChecker", "updateByLaunchWxaApp, reqVersion:%d, respVersion:%d, force_update:%b, rely_update:%b, need_update:%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), Boolean.valueOf(bool), Boolean.valueOf(parameim.abnt), Boolean.valueOf(parameim.aauo) });
      h.OAn.kJ(1509, 21);
      gkb localgkb = new gkb();
      localgkb.url = parameim.url;
      localgkb.md5 = parameim.md5;
      localgkb.version = parameim.version;
      localgkb.abns = parameim.abns;
      if ((parameim.aauo) || (parameim.abnt)) {
        i = 1;
      }
      localgkb.acfX = i;
      localgkb.hOQ = parameim.hOQ;
      a(paramInt, localgkb, a.qGc);
      AppMethodBeat.o(44346);
      return;
    }
  }
  
  private static void a(int paramInt, gkb paramgkb, a parama)
  {
    AppMethodBeat.i(44345);
    PInt localPInt;
    int i;
    label71:
    boolean bool;
    switch (3.qFZ[parama.ordinal()])
    {
    default: 
      if (n.cfm() == null) {
        break label530;
      }
      localPInt = new PInt();
      n.cfm().a(paramgkb, localPInt);
      if (localPInt.value > 0)
      {
        i = 1;
        int j = n.cfm().bG("@LibraryAppId", 0);
        if (WxaPkgIntegrityChecker.il(true).first != WxaPkgIntegrityChecker.a.qHc) {
          break label430;
        }
        bool = true;
        label98:
        if (i != 0) {}
        switch (3.qFZ[parama.ordinal()])
        {
        default: 
          Log.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, scene %s, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s, localMaxVersion = %d", new Object[] { Integer.valueOf(paramInt), parama.name(), Boolean.valueOf(bool), Integer.valueOf(paramgkb.version), Integer.valueOf(paramgkb.abns), paramgkb.md5, paramgkb.url, Integer.valueOf(j) });
          if (bool)
          {
            if ((paramInt <= 0) || (Util.isNullOrNil(paramgkb.hOQ))) {
              break label519;
            }
            ab.qFk.ag(paramInt, paramgkb.hOQ);
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      ab.qFk.id(true);
      Object localObject = new ah();
      ((ah)localObject).field_key = "@LibraryAppId";
      ((ah)localObject).field_version = paramgkb.version;
      if (!n.cfs().get((IAutoDBItem)localObject, new String[] { "key", "version" }))
      {
        ((ah)localObject).field_updateTime = Util.nowSecond();
        ((ah)localObject).field_scene = (parama.ordinal() + 1);
        n.cfs().insert((IAutoDBItem)localObject);
      }
      if ((paramgkb.abns > 0) && (localPInt.value > 0)) {
        au.cgv();
      }
      AppMethodBeat.o(44345);
      return;
      if (paramgkb.acfX > 0) {
        h.OAn.kJ(1509, 3);
      }
      if (paramgkb.abns <= 0) {
        break;
      }
      h.OAn.kJ(1509, 4);
      break;
      if (paramgkb.acfX > 0) {
        h.OAn.kJ(1509, 22);
      }
      if (paramgkb.abns <= 0) {
        break;
      }
      h.OAn.kJ(1509, 23);
      break;
      i = 0;
      break label71;
      label430:
      bool = false;
      break label98;
      h.OAn.kJ(1509, 5);
      localObject = h.OAn;
      if (bool) {}
      for (i = 7;; i = 6)
      {
        ((h)localObject).kJ(1509, i);
        break;
      }
      h.OAn.kJ(1509, 24);
      localObject = h.OAn;
      if (bool) {}
      for (i = 26;; i = 25)
      {
        ((h)localObject).kJ(1509, i);
        break;
      }
      label519:
      ab.qFk.ag(-1, null);
    }
    label530:
    Log.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    AppMethodBeat.o(44345);
  }
  
  public static void a(gkb paramgkb)
  {
    AppMethodBeat.i(44347);
    a(-1, paramgkb, a.qGb);
    AppMethodBeat.o(44347);
  }
  
  public static void ij(boolean paramBoolean)
  {
    AppMethodBeat.i(44344);
    ThreadPool.post(new ax.1(paramBoolean), "WxaCommLibVersionChecker");
    AppMethodBeat.o(44344);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44341);
      qGa = new a("CGI", 0);
      qGb = new a("NewXml", 1);
      qGc = new a("Launch", 2);
      qGd = new a[] { qGa, qGb, qGc };
      AppMethodBeat.o(44341);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax
 * JD-Core Version:    0.7.0.1
 */