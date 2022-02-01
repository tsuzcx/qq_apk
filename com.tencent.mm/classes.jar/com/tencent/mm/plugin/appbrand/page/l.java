package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class l
{
  private static final HashMap<AppBrandRuntime, l> qpC;
  private static final l qpE;
  private AppBrandRuntime nxs;
  private String qpD;
  
  static
  {
    AppMethodBeat.i(47795);
    qpC = new HashMap();
    qpE = new l.1();
    AppMethodBeat.o(47795);
  }
  
  private l(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(175027);
    this.nxs = paramAppBrandRuntime;
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(175027);
      return;
    }
    paramAppBrandRuntime.ntR.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(175023);
        l.qpC.remove(paramAppBrandRuntime);
        AppMethodBeat.o(175023);
      }
    });
    AppMethodBeat.o(175027);
  }
  
  public static l ad(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47787);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.ntU.get()))
    {
      paramAppBrandRuntime = qpE;
      AppMethodBeat.o(47787);
      return paramAppBrandRuntime;
    }
    l locall2 = (l)qpC.get(paramAppBrandRuntime);
    l locall1 = locall2;
    if (locall2 == null)
    {
      locall1 = new l(paramAppBrandRuntime);
      qpC.put(paramAppBrandRuntime, locall1);
    }
    AppMethodBeat.o(47787);
    return locall1;
  }
  
  public b Cn(int paramInt)
  {
    AppMethodBeat.i(47793);
    if (paramInt == a.b.qwK.ordinal())
    {
      AppMethodBeat.o(47793);
      return null;
    }
    b localb = new b();
    Context localContext = MMApplicationContext.getContext();
    if (paramInt == a.b.qwL.ordinal())
    {
      localb.desc = localContext.getString(au.i.appbrand_menu_status_lbs);
      localb.qpN = au.h.appbrand_menu_header_lbs;
    }
    for (localb.qpM = au.e.app_brand_menu_header_status_bg_blue;; localb.qpM = au.e.app_brand_menu_header_status_bg_red)
    {
      AppMethodBeat.o(47793);
      return localb;
      if (paramInt != a.b.qwM.ordinal()) {
        break;
      }
      localb.desc = localContext.getString(au.i.appbrand_menu_status_record_voice);
      localb.qpN = au.h.appbrand_menu_header_record_voice;
    }
    AppMethodBeat.o(47793);
    return null;
  }
  
  public void a(final a parama, com.tencent.mm.vending.e.b<? extends a> paramb)
  {
    AppMethodBeat.i(259865);
    if (!Util.isNullOrNil(this.qpD))
    {
      parama.alt(this.qpD);
      AppMethodBeat.o(259865);
      return;
    }
    cas localcas = new cas();
    localcas.username = ((AppBrandInitConfigLU)this.nxs.Sq()).username;
    d.a locala = new d.a();
    locala.funcId = 2921;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
    locala.lBU = localcas;
    locala.lBV = new cat();
    IPCRunCgi.a(locala.bgN(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd)
      {
        AppMethodBeat.i(175025);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousd != null) && (d.c.b(paramAnonymousd.lBS) != null) && ((d.c.b(paramAnonymousd.lBS) instanceof cat)))
        {
          Log.i("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request success");
          paramAnonymousString = (cat)d.c.b(paramAnonymousd.lBS);
          if ((paramAnonymousString.TiX == null) || (paramAnonymousString.TiX.UMs == -1.0D)) {
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
              l.3.this.qpH.alt(paramAnonymousString);
              AppMethodBeat.o(175024);
            }
          });
          AppMethodBeat.o(175025);
          return;
          if (paramAnonymousString.TiX.UMs == 0.0D)
          {
            paramAnonymousString = MMApplicationContext.getContext().getString(au.i.app_brand_profile_star_not_enough);
          }
          else
          {
            paramAnonymousString = MMApplicationContext.getContext().getString(au.i.appbrand_score_text, new Object[] { String.valueOf(paramAnonymousString.TiX.UMs) });
            continue;
            paramAnonymousString = MMApplicationContext.getContext().getString(au.i.appbrand_no_score);
            Log.e("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request fail");
          }
        }
      }
    }, paramb);
    AppMethodBeat.o(259865);
  }
  
  public Runnable c(final com.tencent.luggage.sdk.b.a.c paramc)
  {
    AppMethodBeat.i(47794);
    l.4 local4 = new l.4(this);
    final AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)this.nxs.Sp();
    final AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.nxs.Sq();
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
        if (((com.tencent.luggage.sdk.e.d)l.a(l.this)).Sk().cxf != null) {
          str1 = localAppBrandInitConfigLU.cwP;
        }
        new com.tencent.mm.plugin.appbrand.game.e.b.b().a(paramc.QN(), b.a.onS, 0);
        AppBrandOpReportLogic.a.d(paramc);
        WxaExposedParams.a locala = new WxaExposedParams.a();
        locala.appId = localAppBrandSysConfigLU.appId;
        locala.from = 3;
        if (paramc.qoF == null) {}
        for (String str2 = "";; str2 = paramc.oxe)
        {
          locala.pageId = str2;
          locala.nHY = localAppBrandSysConfigLU.nYR.nHY;
          locala.pkgVersion = localAppBrandSysConfigLU.nYR.pkgVersion;
          AppBrandProfileUI.a(paramc.getContext(), localAppBrandInitConfigLU.username, 3, str1, locala.bLN(), null, ActivityStarterIpcDelegate.aH(paramc.getContext()));
          j.a(paramc.getAppId(), paramc.oxe, 6, "", Util.nowSecond(), 1, 0);
          AppMethodBeat.o(47786);
          return;
        }
      }
    };
    AppMethodBeat.o(47794);
    return paramc;
  }
  
  public String cdq()
  {
    AppMethodBeat.i(47788);
    String str = this.nxs.Sp().mnM;
    AppMethodBeat.o(47788);
    return str;
  }
  
  public String cdr()
  {
    AppMethodBeat.i(47789);
    String str = this.nxs.Sp().fzM;
    AppMethodBeat.o(47789);
    return str;
  }
  
  public String cds()
  {
    AppMethodBeat.i(47790);
    String str = e.yZ(this.nxs.Sp().nYR.nHY);
    AppMethodBeat.o(47790);
    return str;
  }
  
  public boolean cdt()
  {
    AppMethodBeat.i(47791);
    if (this.nxs.Sq().originalFlag == 1)
    {
      AppMethodBeat.o(47791);
      return true;
    }
    AppMethodBeat.o(47791);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void alt(String paramString);
  }
  
  public static final class b
  {
    public String desc;
    public int qpM;
    public int qpN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.l
 * JD-Core Version:    0.7.0.1
 */