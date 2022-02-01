package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.br.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public class i
{
  private static final HashMap<AppBrandRuntime, i> lzK;
  private static final i lzM;
  private AppBrandRuntime jgY;
  private String lzL;
  
  static
  {
    AppMethodBeat.i(47795);
    lzK = new HashMap();
    lzM = new i()
    {
      public final void a(i.a paramAnonymousa) {}
      
      public final String bpP()
      {
        return null;
      }
      
      public final String bpQ()
      {
        return "";
      }
      
      public final String bpR()
      {
        return "";
      }
      
      public final boolean bpS()
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
      
      public final i.b uh(int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(47795);
  }
  
  private i(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(175027);
    this.jgY = paramAppBrandRuntime;
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(175027);
      return;
    }
    paramAppBrandRuntime.jdK.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(175023);
        i.lzK.remove(paramAppBrandRuntime);
        AppMethodBeat.o(175023);
      }
    });
    AppMethodBeat.o(175027);
  }
  
  public static i aj(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47787);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = lzM;
      AppMethodBeat.o(47787);
      return paramAppBrandRuntime;
    }
    i locali2 = (i)lzK.get(paramAppBrandRuntime);
    i locali1 = locali2;
    if (locali2 == null)
    {
      locali1 = new i(paramAppBrandRuntime);
      lzK.put(paramAppBrandRuntime, locali1);
    }
    AppMethodBeat.o(47787);
    return locali1;
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(47792);
    if (!bs.isNullOrNil(this.lzL))
    {
      parama.Pz(this.lzL);
      AppMethodBeat.o(47792);
      return;
    }
    bci localbci = new bci();
    localbci.username = ((AppBrandInitConfigLU)this.jgY.DJ()).username;
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.funcId = 2921;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
    locala.hvt = localbci;
    locala.hvu = new bcj();
    IPCRunCgi.a(locala.aAz(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(175025);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hvs.hvw != null) && ((paramAnonymousb.hvs.hvw instanceof bcj)))
        {
          ac.i("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request success");
          paramAnonymousString = (bcj)paramAnonymousb.hvs.hvw;
          if ((paramAnonymousString.ESt == null) || (paramAnonymousString.ESt.Ggr == -1.0D)) {
            paramAnonymousString = null;
          }
        }
        for (;;)
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175024);
              i.a(i.this, paramAnonymousString);
              i.3.this.lzP.Pz(paramAnonymousString);
              AppMethodBeat.o(175024);
            }
          });
          AppMethodBeat.o(175025);
          return;
          if (paramAnonymousString.ESt.Ggr == 0.0D)
          {
            paramAnonymousString = ai.getContext().getString(2131755604);
          }
          else
          {
            paramAnonymousString = ai.getContext().getString(2131756038, new Object[] { String.valueOf(paramAnonymousString.ESt.Ggr) });
            continue;
            paramAnonymousString = ai.getContext().getString(2131756005);
            ac.e("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request fail");
          }
        }
      }
    });
    AppMethodBeat.o(47792);
  }
  
  public String bpP()
  {
    AppMethodBeat.i(47788);
    String str = this.jgY.DI().igG;
    AppMethodBeat.o(47788);
    return str;
  }
  
  public String bpQ()
  {
    AppMethodBeat.i(47789);
    String str = this.jgY.DI().ddh;
    AppMethodBeat.o(47789);
    return str;
  }
  
  public String bpR()
  {
    AppMethodBeat.i(47790);
    String str = e.rp(this.jgY.DI().jEg.jpa);
    AppMethodBeat.o(47790);
    return str;
  }
  
  public boolean bpS()
  {
    AppMethodBeat.i(47791);
    if (this.jgY.DJ().originalFlag == 1)
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
    final AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)this.jgY.DI();
    final AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.jgY.DJ();
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
        if (((com.tencent.luggage.sdk.d.c)i.a(i.this)).DC().ccl != null) {
          str1 = localAppBrandInitConfigLU.CD();
        }
        new com.tencent.mm.plugin.appbrand.game.e.b.b().a(paramc.CP(), com.tencent.mm.plugin.appbrand.game.e.b.b.a.jRI, 0);
        AppBrandOpReportLogic.a.e(paramc);
        WxaExposedParams.a locala = new WxaExposedParams.a();
        locala.appId = localAppBrandSysConfigLU.appId;
        locala.from = 3;
        if (paramc.lyE == null) {}
        for (String str2 = "";; str2 = paramc.jZJ)
        {
          locala.pageId = str2;
          locala.jpa = localAppBrandSysConfigLU.jEg.jpa;
          locala.pkgVersion = localAppBrandSysConfigLU.jEg.pkgVersion;
          AppBrandProfileUI.a(paramc.getContext(), localAppBrandInitConfigLU.username, 3, str1, locala.baT(), null, ActivityStarterIpcDelegate.az(paramc.getContext()));
          g.a(paramc.getAppId(), paramc.jZJ, 6, "", bs.aNx(), 1, 0);
          AppMethodBeat.o(47786);
          return;
        }
      }
    };
    AppMethodBeat.o(47794);
    return paramc;
  }
  
  public b uh(int paramInt)
  {
    AppMethodBeat.i(47793);
    if (paramInt == b.a.lzl.ordinal())
    {
      AppMethodBeat.o(47793);
      return null;
    }
    b localb = new b();
    Context localContext = ai.getContext();
    if (paramInt == b.a.lzm.ordinal())
    {
      localb.desc = localContext.getString(2131755998);
      localb.lzV = 2131689692;
    }
    for (localb.lzU = 2131230989;; localb.lzU = 2131230990)
    {
      AppMethodBeat.o(47793);
      return localb;
      if (paramInt != b.a.lzn.ordinal()) {
        break;
      }
      localb.desc = localContext.getString(2131756000);
      localb.lzV = 2131689694;
    }
    AppMethodBeat.o(47793);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void Pz(String paramString);
  }
  
  public static final class b
  {
    public String desc;
    public int lzU;
    public int lzV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i
 * JD-Core Version:    0.7.0.1
 */