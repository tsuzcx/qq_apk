package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import java.util.List;

public final class w
  implements q
{
  public final WxaAttributes Xk(String paramString)
  {
    AppMethodBeat.i(44876);
    paramString = n.buC().d(paramString, new String[0]);
    AppMethodBeat.o(44876);
    return paramString;
  }
  
  public final WxaAttributes Xl(String paramString)
  {
    AppMethodBeat.i(44877);
    paramString = n.buC().e(paramString, new String[0]);
    AppMethodBeat.o(44877);
    return paramString;
  }
  
  public final String Xm(String paramString)
  {
    AppMethodBeat.i(226472);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(226472);
      return "";
    }
    paramString = y.Xw(paramString);
    AppMethodBeat.o(226472);
    return paramString;
  }
  
  public final e<WxaAttributes> Xn(final String paramString)
  {
    AppMethodBeat.i(44879);
    paramString = g.ey(paramString).b(new a() {});
    AppMethodBeat.o(44879);
    return paramString;
  }
  
  public final void a(String paramString, final q.a parama)
  {
    AppMethodBeat.i(44878);
    aa.a(paramString, false, new aa.b() {});
    AppMethodBeat.o(44878);
  }
  
  public final void b(final String paramString, final q.a parama)
  {
    AppMethodBeat.i(226473);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226468);
        Pair localPair = aa.a(paramString, false, null, null);
        if (parama != null) {
          parama.b((WxaAttributes)localPair.first);
        }
        AppMethodBeat.o(226468);
      }
    });
    AppMethodBeat.o(226473);
  }
  
  public final void bq(List<String> paramList)
  {
    AppMethodBeat.i(44881);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(44881);
      return;
    }
    Log.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[] { Util.listToString(paramList, ", ") });
    aa.a(paramList, o.a.leZ, null);
    AppMethodBeat.o(44881);
  }
  
  public final void c(String paramString, final q.a parama)
  {
    AppMethodBeat.i(44880);
    aa.a(paramString, true, new aa.b() {});
    AppMethodBeat.o(44880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.w
 * JD-Core Version:    0.7.0.1
 */