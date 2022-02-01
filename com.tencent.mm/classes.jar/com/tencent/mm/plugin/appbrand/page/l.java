package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.protocal.protobuf.gld;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class l
{
  private static final HashMap<AppBrandRuntime, l> tuh;
  private static final l tuj;
  private AppBrandRuntime qwG;
  private String tui;
  
  static
  {
    AppMethodBeat.i(47795);
    tuh = new HashMap();
    tuj = new l.1();
    AppMethodBeat.o(47795);
  }
  
  private l(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(175027);
    this.qwG = paramAppBrandRuntime;
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(175027);
      return;
    }
    paramAppBrandRuntime.qsB.a(new com.tencent.mm.plugin.appbrand.b.c.a()
    {
      public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(175023);
        l.tuh.remove(paramAppBrandRuntime);
        AppMethodBeat.o(175023);
      }
    });
    AppMethodBeat.o(175027);
  }
  
  public static l ar(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47787);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.qsE.get()))
    {
      paramAppBrandRuntime = tuj;
      AppMethodBeat.o(47787);
      return paramAppBrandRuntime;
    }
    l locall2 = (l)tuh.get(paramAppBrandRuntime);
    l locall1 = locall2;
    if (locall2 == null)
    {
      locall1 = new l(paramAppBrandRuntime);
      tuh.put(paramAppBrandRuntime, locall1);
    }
    AppMethodBeat.o(47787);
    return locall1;
  }
  
  public b CC(int paramInt)
  {
    AppMethodBeat.i(47793);
    if (paramInt == a.b.tBJ.ordinal())
    {
      AppMethodBeat.o(47793);
      return null;
    }
    b localb = new b();
    Context localContext = MMApplicationContext.getContext();
    if (paramInt == a.b.tBK.ordinal())
    {
      localb.desc = localContext.getString(ba.i.appbrand_menu_status_lbs);
      localb.tus = ba.h.appbrand_menu_header_lbs;
    }
    for (localb.tur = ba.e.app_brand_menu_header_status_bg_blue;; localb.tur = ba.e.app_brand_menu_header_status_bg_red)
    {
      AppMethodBeat.o(47793);
      return localb;
      if (paramInt != a.b.tBL.ordinal()) {
        break;
      }
      localb.desc = localContext.getString(ba.i.appbrand_menu_status_record_voice);
      localb.tus = ba.h.appbrand_menu_header_record_voice;
    }
    AppMethodBeat.o(47793);
    return null;
  }
  
  public void a(final l.a parama, com.tencent.mm.vending.e.b<? extends a> paramb)
  {
    AppMethodBeat.i(324942);
    if (!Util.isNullOrNil(this.tui))
    {
      parama.aex(this.tui);
      AppMethodBeat.o(324942);
      return;
    }
    cqb localcqb = new cqb();
    localcqb.username = ((AppBrandInitConfigLU)this.qwG.asH()).username;
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.funcId = 2921;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
    locala.otE = localcqb;
    locala.otF = new cqc();
    IPCRunCgi.a(locala.bEF(), new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(175025);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousc != null) && (c.c.b(paramAnonymousc.otC) != null) && ((c.c.b(paramAnonymousc.otC) instanceof cqc)))
        {
          Log.i("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request success");
          paramAnonymousString = (cqc)c.c.b(paramAnonymousc.otC);
          if ((paramAnonymousString.aawy == null) || (paramAnonymousString.aawy.acgM == -1.0D)) {
            paramAnonymousString = null;
          }
        }
        for (;;)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175024);
              l.a(l.this, paramAnonymousString);
              l.3.this.tum.aex(paramAnonymousString);
              AppMethodBeat.o(175024);
            }
          });
          AppMethodBeat.o(175025);
          return;
          if (paramAnonymousString.aawy.acgM == 0.0D)
          {
            paramAnonymousString = MMApplicationContext.getContext().getString(ba.i.app_brand_profile_star_not_enough);
          }
          else
          {
            paramAnonymousString = MMApplicationContext.getContext().getString(ba.i.appbrand_score_text, new Object[] { String.valueOf(paramAnonymousString.aawy.acgM) });
            continue;
            paramAnonymousString = MMApplicationContext.getContext().getString(ba.i.appbrand_no_score);
            Log.e("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request fail");
          }
        }
      }
    }, paramb);
    AppMethodBeat.o(324942);
  }
  
  public Runnable c(final com.tencent.luggage.sdk.b.a.c paramc)
  {
    AppMethodBeat.i(47794);
    l.4 local4 = new l.4(this);
    final AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)this.qwG.asG();
    final AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.qwG.asH();
    if ((localAppBrandSysConfigLU == null) || (localAppBrandInitConfigLU == null))
    {
      AppMethodBeat.o(47794);
      return local4;
    }
    paramc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47786);
        String str1 = "";
        if (((d)l.a(l.this)).asA().epn != null) {
          str1 = localAppBrandInitConfigLU.eoP;
        }
        new com.tencent.mm.plugin.appbrand.game.e.b.b().a(paramc.ara(), b.a.rrB, 0);
        AppBrandOpReportLogic.a.b(paramc);
        WxaExposedParams.a locala = new WxaExposedParams.a();
        locala.appId = localAppBrandSysConfigLU.appId;
        locala.from = 3;
        if (paramc.tti == null) {}
        for (String str2 = "";; str2 = paramc.cgR())
        {
          locala.hUf = str2;
          locala.qHO = localAppBrandSysConfigLU.qYY.qHO;
          locala.pkgVersion = localAppBrandSysConfigLU.qYY.pkgVersion;
          AppBrandProfileUI.a(paramc.getContext(), localAppBrandInitConfigLU.username, 3, str1, true, locala.cll(), null, ActivityStarterIpcDelegate.bq(paramc.getContext()));
          j.a(paramc.getAppId(), paramc.cgR(), 6, "", Util.nowSecond(), 1, 0);
          AppMethodBeat.o(47786);
          return;
        }
      }
    };
    AppMethodBeat.o(47794);
    return paramc;
  }
  
  public String cDR()
  {
    AppMethodBeat.i(47788);
    String str = this.qwG.asG().phA;
    AppMethodBeat.o(47788);
    return str;
  }
  
  public String cDS()
  {
    AppMethodBeat.i(47789);
    String str = this.qwG.asG().hEy;
    AppMethodBeat.o(47789);
    return str;
  }
  
  public String cDT()
  {
    AppMethodBeat.i(47790);
    String str = e.zm(this.qwG.asG().qYY.qHO);
    AppMethodBeat.o(47790);
    return str;
  }
  
  public boolean cDU()
  {
    AppMethodBeat.i(47791);
    if (this.qwG.asH().originalFlag == 1)
    {
      AppMethodBeat.o(47791);
      return true;
    }
    AppMethodBeat.o(47791);
    return false;
  }
  
  public static final class b
  {
    public String desc;
    public int tur;
    public int tus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.l
 * JD-Core Version:    0.7.0.1
 */