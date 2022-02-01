package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.List;

public final class ab
  implements s
{
  public final String XA(String paramString)
  {
    AppMethodBeat.i(323331);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(323331);
      return "";
    }
    paramString = ad.XJ(paramString);
    AppMethodBeat.o(323331);
    return paramString;
  }
  
  public final e<WxaAttributes> XB(final String paramString)
  {
    AppMethodBeat.i(44879);
    paramString = g.ha(paramString).b(new a() {});
    AppMethodBeat.o(44879);
    return paramString;
  }
  
  public final WxaAttributes Xy(String paramString)
  {
    AppMethodBeat.i(44876);
    paramString = n.cfc().d(paramString, new String[0]);
    AppMethodBeat.o(44876);
    return paramString;
  }
  
  public final WxaAttributes Xz(String paramString)
  {
    AppMethodBeat.i(44877);
    paramString = n.cfc().e(paramString, new String[0]);
    AppMethodBeat.o(44877);
    return paramString;
  }
  
  public final void a(String paramString, final s.a parama)
  {
    AppMethodBeat.i(44878);
    ag.a(paramString, false, new ag.b() {}, null);
    AppMethodBeat.o(44878);
  }
  
  public final void b(final String paramString, final s.a parama)
  {
    AppMethodBeat.i(323343);
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(323398);
        Pair localPair = ag.a(paramString, false, null, null);
        if (parama != null) {
          parama.onGetWeAppInfo((WxaAttributes)localPair.first);
        }
        AppMethodBeat.o(323398);
      }
    });
    AppMethodBeat.o(323343);
  }
  
  public final void c(String paramString, final s.a parama)
  {
    AppMethodBeat.i(44880);
    ag.a(paramString, true, new ag.b() {}, null);
    AppMethodBeat.o(44880);
  }
  
  public final void cZ(List<String> paramList)
  {
    AppMethodBeat.i(44881);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(44881);
      return;
    }
    Log.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[] { Util.listToString(paramList, ", ") });
    ag.a(paramList, q.a.qZu, null);
    AppMethodBeat.o(44881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ab
 * JD-Core Version:    0.7.0.1
 */