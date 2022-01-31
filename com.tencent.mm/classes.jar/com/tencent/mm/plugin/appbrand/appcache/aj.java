package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;

public enum aj
{
  public static void a(int paramInt, bor parambor)
  {
    AppMethodBeat.i(129421);
    czn localczn;
    if (parambor != null)
    {
      localczn = new czn();
      localczn.url = parambor.url;
      localczn.cqq = parambor.cqq;
      localczn.version = parambor.version;
      localczn.xCO = parambor.xCO;
      if (!parambor.xCN) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      localczn.ygm = i;
      localczn.cyc = parambor.cyc;
      a(paramInt, localczn, aj.a.gVw);
      AppMethodBeat.o(129421);
      return;
    }
  }
  
  private static void a(int paramInt, czn paramczn, aj.a parama)
  {
    AppMethodBeat.i(129420);
    if (g.auM() != null)
    {
      PInt localPInt = new PInt();
      g.auM().a(paramczn, localPInt);
      boolean bool;
      if (g.auM().av("@LibraryAppId", 0) == paramczn.version) {
        if (as.p(true, true).first == as.a.gWw)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(paramczn.version), Integer.valueOf(paramczn.xCO), paramczn.cqq, paramczn.url });
          if (bool)
          {
            if ((paramInt <= 0) || (bo.isNullOrNil(paramczn.cyc))) {
              break label271;
            }
            t.gUT.H(paramInt, paramczn.cyc);
          }
        }
      }
      for (;;)
      {
        t.gUT.dF(true);
        aa localaa = new aa();
        localaa.field_key = "@LibraryAppId";
        localaa.field_version = paramczn.version;
        if (!g.auR().get(localaa, new String[] { "key", "version" }))
        {
          localaa.field_updateTime = bo.aox();
          localaa.field_scene = (parama.ordinal() + 1);
          g.auR().insert(localaa);
        }
        if ((paramczn.xCO > 0) && (localPInt.value > 0)) {
          h.pA(2);
        }
        AppMethodBeat.o(129420);
        return;
        bool = false;
        break;
        bool = false;
        break;
        label271:
        t.gUT.H(-1, null);
      }
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    AppMethodBeat.o(129420);
  }
  
  public static void a(czn paramczn)
  {
    AppMethodBeat.i(129422);
    a(-1, paramczn, aj.a.gVv);
    AppMethodBeat.o(129422);
  }
  
  public static void dJ(boolean paramBoolean)
  {
    AppMethodBeat.i(129419);
    d.post(new aj.1(paramBoolean), "WxaCommLibVersionChecker");
    AppMethodBeat.o(129419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj
 * JD-Core Version:    0.7.0.1
 */