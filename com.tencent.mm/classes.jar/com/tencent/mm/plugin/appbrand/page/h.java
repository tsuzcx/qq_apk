package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public class h
{
  private static final HashMap<AppBrandRuntime, h> mdB;
  private static final h mdD;
  private AppBrandRuntime jDb;
  private String mdC;
  
  static
  {
    AppMethodBeat.i(47795);
    mdB = new HashMap();
    mdD = new h()
    {
      public final void a(h.a paramAnonymousa) {}
      
      public final String buA()
      {
        return null;
      }
      
      public final String buB()
      {
        return "";
      }
      
      public final String buC()
      {
        return "";
      }
      
      public final boolean buD()
      {
        return false;
      }
      
      public final Runnable c(com.tencent.luggage.sdk.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(47781);
        paramAnonymousc = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47780);
            AppMethodBeat.o(47780);
          }
        };
        AppMethodBeat.o(47781);
        return paramAnonymousc;
      }
      
      public final h.b uQ(int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(47795);
  }
  
  private h(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(175027);
    this.jDb = paramAppBrandRuntime;
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(175027);
      return;
    }
    paramAppBrandRuntime.jzQ.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(175023);
        h.mdB.remove(paramAppBrandRuntime);
        AppMethodBeat.o(175023);
      }
    });
    AppMethodBeat.o(175027);
  }
  
  public static h ac(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47787);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = mdD;
      AppMethodBeat.o(47787);
      return paramAppBrandRuntime;
    }
    h localh2 = (h)mdB.get(paramAppBrandRuntime);
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h(paramAppBrandRuntime);
      mdB.put(paramAppBrandRuntime, localh1);
    }
    AppMethodBeat.o(47787);
    return localh1;
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(47792);
    if (!bu.isNullOrNil(this.mdC))
    {
      parama.TL(this.mdC);
      AppMethodBeat.o(47792);
      return;
    }
    bhc localbhc = new bhc();
    localbhc.username = ((AppBrandInitConfigLU)this.jDb.Fn()).username;
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.funcId = 2921;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
    locala.hQF = localbhc;
    locala.hQG = new bhd();
    IPCRunCgi.a(locala.aDS(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(175025);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hQE.hQJ != null) && ((paramAnonymousb.hQE.hQJ instanceof bhd)))
        {
          ae.i("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request success");
          paramAnonymousString = (bhd)paramAnonymousb.hQE.hQJ;
          if ((paramAnonymousString.GVl == null) || (paramAnonymousString.GVl.IlL == -1.0D)) {
            paramAnonymousString = null;
          }
        }
        for (;;)
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175024);
              h.a(h.this, paramAnonymousString);
              h.3.this.mdG.TL(paramAnonymousString);
              AppMethodBeat.o(175024);
            }
          });
          AppMethodBeat.o(175025);
          return;
          if (paramAnonymousString.GVl.IlL == 0.0D)
          {
            paramAnonymousString = ak.getContext().getString(2131755604);
          }
          else
          {
            paramAnonymousString = ak.getContext().getString(2131756038, new Object[] { String.valueOf(paramAnonymousString.GVl.IlL) });
            continue;
            paramAnonymousString = ak.getContext().getString(2131756005);
            ae.e("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request fail");
          }
        }
      }
    });
    AppMethodBeat.o(47792);
  }
  
  public String buA()
  {
    AppMethodBeat.i(47788);
    String str = this.jDb.Fm().iCT;
    AppMethodBeat.o(47788);
    return str;
  }
  
  public String buB()
  {
    AppMethodBeat.i(47789);
    String str = this.jDb.Fm().dpI;
    AppMethodBeat.o(47789);
    return str;
  }
  
  public String buC()
  {
    AppMethodBeat.i(47790);
    String str = e.rS(this.jDb.Fm().kbw.jLV);
    AppMethodBeat.o(47790);
    return str;
  }
  
  public boolean buD()
  {
    AppMethodBeat.i(47791);
    if (this.jDb.Fn().originalFlag == 1)
    {
      AppMethodBeat.o(47791);
      return true;
    }
    AppMethodBeat.o(47791);
    return false;
  }
  
  public Runnable c(final com.tencent.luggage.sdk.b.a.c paramc)
  {
    AppMethodBeat.i(47794);
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47785);
        AppMethodBeat.o(47785);
      }
    };
    final AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)this.jDb.Fm();
    final AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.jDb.Fn();
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
        if (((d)h.a(h.this)).Fg().cmE != null) {
          str1 = localAppBrandInitConfigLU.Ef();
        }
        new com.tencent.mm.plugin.appbrand.game.e.b.b().a(paramc.Er(), com.tencent.mm.plugin.appbrand.game.e.b.b.a.kpm, 0);
        AppBrandOpReportLogic.a.d(paramc);
        WxaExposedParams.a locala = new WxaExposedParams.a();
        locala.appId = localAppBrandSysConfigLU.appId;
        locala.from = 3;
        if (paramc.mcJ == null) {}
        for (String str2 = "";; str2 = paramc.kxv)
        {
          locala.pageId = str2;
          locala.jLV = localAppBrandSysConfigLU.kbw.jLV;
          locala.pkgVersion = localAppBrandSysConfigLU.kbw.pkgVersion;
          AppBrandProfileUI.a(paramc.getContext(), localAppBrandInitConfigLU.username, 3, str1, locala.bfb(), null, ActivityStarterIpcDelegate.aA(paramc.getContext()));
          com.tencent.mm.plugin.appbrand.report.h.a(paramc.getAppId(), paramc.kxv, 6, "", bu.aRi(), 1, 0);
          AppMethodBeat.o(47786);
          return;
        }
      }
    };
    AppMethodBeat.o(47794);
    return paramc;
  }
  
  public b uQ(int paramInt)
  {
    AppMethodBeat.i(47793);
    if (paramInt == a.b.mks.ordinal())
    {
      AppMethodBeat.o(47793);
      return null;
    }
    b localb = new b();
    Context localContext = ak.getContext();
    if (paramInt == a.b.mkt.ordinal())
    {
      localb.desc = localContext.getString(2131755998);
      localb.mdM = 2131689692;
    }
    for (localb.mdL = 2131230989;; localb.mdL = 2131230990)
    {
      AppMethodBeat.o(47793);
      return localb;
      if (paramInt != a.b.mku.ordinal()) {
        break;
      }
      localb.desc = localContext.getString(2131756000);
      localb.mdM = 2131689694;
    }
    AppMethodBeat.o(47793);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void TL(String paramString);
  }
  
  public static final class b
  {
    public String desc;
    public int mdL;
    public int mdM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h
 * JD-Core Version:    0.7.0.1
 */