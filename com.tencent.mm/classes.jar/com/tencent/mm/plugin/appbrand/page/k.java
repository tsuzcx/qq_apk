package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.fdd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class k
{
  private static final HashMap<AppBrandRuntime, k> nnT;
  private static final k nnV;
  private AppBrandRuntime kEc;
  private String nnU;
  
  static
  {
    AppMethodBeat.i(47795);
    nnT = new HashMap();
    nnV = new k()
    {
      public final void a(k.a paramAnonymousa) {}
      
      public final String bQA()
      {
        return null;
      }
      
      public final String bQB()
      {
        return "";
      }
      
      public final String bQC()
      {
        return "";
      }
      
      public final boolean bQD()
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
      
      public final k.b yI(int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(47795);
  }
  
  private k(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(175027);
    this.kEc = paramAppBrandRuntime;
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(175027);
      return;
    }
    paramAppBrandRuntime.kAH.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(175023);
        k.nnT.remove(paramAppBrandRuntime);
        AppMethodBeat.o(175023);
      }
    });
    AppMethodBeat.o(175027);
  }
  
  public static k ad(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47787);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = nnV;
      AppMethodBeat.o(47787);
      return paramAppBrandRuntime;
    }
    k localk2 = (k)nnT.get(paramAppBrandRuntime);
    k localk1 = localk2;
    if (localk2 == null)
    {
      localk1 = new k(paramAppBrandRuntime);
      nnT.put(paramAppBrandRuntime, localk1);
    }
    AppMethodBeat.o(47787);
    return localk1;
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(47792);
    if (!Util.isNullOrNil(this.nnU))
    {
      parama.ady(this.nnU);
      AppMethodBeat.o(47792);
      return;
    }
    bta localbta = new bta();
    localbta.username = ((AppBrandInitConfigLU)this.kEc.OU()).username;
    d.a locala = new d.a();
    locala.funcId = 2921;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
    locala.iLN = localbta;
    locala.iLO = new btb();
    IPCRunCgi.a(locala.aXF(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd)
      {
        AppMethodBeat.i(175025);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousd != null) && (paramAnonymousd.iLL.iLR != null) && ((paramAnonymousd.iLL.iLR instanceof btb)))
        {
          Log.i("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request success");
          paramAnonymousString = (btb)paramAnonymousd.iLL.iLR;
          if ((paramAnonymousString.LZE == null) || (paramAnonymousString.LZE.NyO == -1.0D)) {
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
              k.a(k.this, paramAnonymousString);
              k.3.this.nnY.ady(paramAnonymousString);
              AppMethodBeat.o(175024);
            }
          });
          AppMethodBeat.o(175025);
          return;
          if (paramAnonymousString.LZE.NyO == 0.0D)
          {
            paramAnonymousString = MMApplicationContext.getContext().getString(2131755649);
          }
          else
          {
            paramAnonymousString = MMApplicationContext.getContext().getString(2131756153, new Object[] { String.valueOf(paramAnonymousString.LZE.NyO) });
            continue;
            paramAnonymousString = MMApplicationContext.getContext().getString(2131756120);
            Log.e("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request fail");
          }
        }
      }
    });
    AppMethodBeat.o(47792);
  }
  
  public String bQA()
  {
    AppMethodBeat.i(47788);
    String str = this.kEc.OT().jyi;
    AppMethodBeat.o(47788);
    return str;
  }
  
  public String bQB()
  {
    AppMethodBeat.i(47789);
    String str = this.kEc.OT().brandName;
    AppMethodBeat.o(47789);
    return str;
  }
  
  public String bQC()
  {
    AppMethodBeat.i(47790);
    String str = e.vO(this.kEc.OT().leE.kNW);
    AppMethodBeat.o(47790);
    return str;
  }
  
  public boolean bQD()
  {
    AppMethodBeat.i(47791);
    if (this.kEc.OU().originalFlag == 1)
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
    final AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)this.kEc.OT();
    final AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.kEc.OU();
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
        if (((com.tencent.luggage.sdk.d.d)k.a(k.this)).ON().cyA != null) {
          str1 = localAppBrandInitConfigLU.cym;
        }
        new com.tencent.mm.plugin.appbrand.game.e.b.b().a(paramc.NQ(), b.a.lsV, 0);
        AppBrandOpReportLogic.a.d(paramc);
        WxaExposedParams.a locala = new WxaExposedParams.a();
        locala.appId = localAppBrandSysConfigLU.appId;
        locala.from = 3;
        if (paramc.nmX == null) {}
        for (String str2 = "";; str2 = paramc.lBI)
        {
          locala.pageId = str2;
          locala.kNW = localAppBrandSysConfigLU.leE.kNW;
          locala.pkgVersion = localAppBrandSysConfigLU.leE.pkgVersion;
          AppBrandProfileUI.a(paramc.getContext(), localAppBrandInitConfigLU.username, 3, str1, locala.bAv(), null, ActivityStarterIpcDelegate.aJ(paramc.getContext()));
          i.a(paramc.getAppId(), paramc.lBI, 6, "", Util.nowSecond(), 1, 0);
          AppMethodBeat.o(47786);
          return;
        }
      }
    };
    AppMethodBeat.o(47794);
    return paramc;
  }
  
  public b yI(int paramInt)
  {
    AppMethodBeat.i(47793);
    if (paramInt == a.b.nuP.ordinal())
    {
      AppMethodBeat.o(47793);
      return null;
    }
    b localb = new b();
    Context localContext = MMApplicationContext.getContext();
    if (paramInt == a.b.nuQ.ordinal())
    {
      localb.desc = localContext.getString(2131756113);
      localb.noe = 2131689697;
    }
    for (localb.nod = 2131231018;; localb.nod = 2131231019)
    {
      AppMethodBeat.o(47793);
      return localb;
      if (paramInt != a.b.nuR.ordinal()) {
        break;
      }
      localb.desc = localContext.getString(2131756115);
      localb.noe = 2131689699;
    }
    AppMethodBeat.o(47793);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void ady(String paramString);
  }
  
  public static final class b
  {
    public String desc;
    public int nod;
    public int noe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.k
 * JD-Core Version:    0.7.0.1
 */