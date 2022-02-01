package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
{
  private static void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(46635);
    long l = Util.nowMilliSecond();
    String str1 = ConnectivityCompat.Companion.getFormattedWiFiSsid();
    String str2 = ConnectivityCompat.Companion.getFormattedWiFiBssid();
    paramString1 = paramString3 + "," + paramString2 + "," + paramString1 + "," + l + "," + paramLong + "," + paramInt + "," + ctm() + "," + str1 + "," + str2 + ",,";
    Log.v("MicroMsg.MiniProgramNavigatorAdReportHelper", "closeType:%d stayTime:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AdReportCgiHelper.a(16004, paramString1, null);
    AppMethodBeat.o(46635);
  }
  
  public static void a(String paramString1, final String paramString2, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(46633);
    if (paramAppBrandStatObject == null)
    {
      AppMethodBeat.o(46633);
      return;
    }
    final String str = paramAppBrandStatObject.shW;
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(46633);
      return;
    }
    com.tencent.mm.plugin.appbrand.k.a(paramString1, new k.c()
    {
      private void a(k.d paramAnonymousd, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(46631);
        k.a(paramAnonymousd, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Util.nowMilliSecond() - this.val$startTime);
        this.siz.shW = null;
        com.tencent.mm.plugin.appbrand.k.b(paramAnonymousString1, this);
        AppMethodBeat.o(46631);
      }
      
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(46629);
        a(paramAnonymousd, k.this, paramString2, str);
        AppMethodBeat.o(46629);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(46630);
        a(com.tencent.mm.plugin.appbrand.k.Uo(k.this), k.this, paramString2, str);
        AppMethodBeat.o(46630);
      }
    });
    AppMethodBeat.o(46633);
  }
  
  public static void b(String paramString1, String paramString2, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(46634);
    if (paramAppBrandStatObject == null)
    {
      AppMethodBeat.o(46634);
      return;
    }
    if (Util.isNullOrNil(paramAppBrandStatObject.shW))
    {
      AppMethodBeat.o(46634);
      return;
    }
    a(4, paramString1, paramString2, paramAppBrandStatObject.shW, 0L);
    AppMethodBeat.o(46634);
  }
  
  private static int ctm()
  {
    AppMethodBeat.i(46636);
    switch (NetStatusUtil.getNetType(MMApplicationContext.getContext()))
    {
    case 9: 
    default: 
      AppMethodBeat.o(46636);
      return 6;
    case -1: 
      AppMethodBeat.o(46636);
      return 255;
    case 0: 
      AppMethodBeat.o(46636);
      return 1;
    case 3: 
    case 4: 
      AppMethodBeat.o(46636);
      return 4;
    case 2: 
    case 5: 
    case 7: 
      AppMethodBeat.o(46636);
      return 2;
    case 1: 
    case 6: 
    case 8: 
      AppMethodBeat.o(46636);
      return 3;
    }
    AppMethodBeat.o(46636);
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k
 * JD-Core Version:    0.7.0.1
 */