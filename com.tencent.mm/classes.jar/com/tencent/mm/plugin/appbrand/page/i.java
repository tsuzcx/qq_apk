package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.protocal.protobuf.bgn;
import com.tencent.mm.protocal.protobuf.egu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class i
{
  private static final HashMap<AppBrandRuntime, i> lZi;
  private static final i lZk;
  private AppBrandRuntime jzY;
  private String lZj;
  
  static
  {
    AppMethodBeat.i(47795);
    lZi = new HashMap();
    lZk = new i()
    {
      public final void a(i.a paramAnonymousa) {}
      
      public final String btP()
      {
        return null;
      }
      
      public final String btQ()
      {
        return "";
      }
      
      public final String btR()
      {
        return "";
      }
      
      public final boolean btS()
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
      
      public final i.b uL(int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(47795);
  }
  
  private i(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(175027);
    this.jzY = paramAppBrandRuntime;
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(175027);
      return;
    }
    paramAppBrandRuntime.jwS.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(175023);
        i.lZi.remove(paramAppBrandRuntime);
        AppMethodBeat.o(175023);
      }
    });
    AppMethodBeat.o(175027);
  }
  
  public static i ad(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47787);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = lZk;
      AppMethodBeat.o(47787);
      return paramAppBrandRuntime;
    }
    i locali2 = (i)lZi.get(paramAppBrandRuntime);
    i locali1 = locali2;
    if (locali2 == null)
    {
      locali1 = new i(paramAppBrandRuntime);
      lZi.put(paramAppBrandRuntime, locali1);
    }
    AppMethodBeat.o(47787);
    return locali1;
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(47792);
    if (!bt.isNullOrNil(this.lZj))
    {
      parama.Tc(this.lZj);
      AppMethodBeat.o(47792);
      return;
    }
    bgm localbgm = new bgm();
    localbgm.username = ((AppBrandInitConfigLU)this.jzY.Fi()).username;
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.funcId = 2921;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
    locala.hNM = localbgm;
    locala.hNN = new bgn();
    IPCRunCgi.a(locala.aDC(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(175025);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hNL.hNQ != null) && ((paramAnonymousb.hNL.hNQ instanceof bgn)))
        {
          ad.i("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request success");
          paramAnonymousString = (bgn)paramAnonymousb.hNL.hNQ;
          if ((paramAnonymousString.GBL == null) || (paramAnonymousString.GBL.HRE == -1.0D)) {
            paramAnonymousString = null;
          }
        }
        for (;;)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175024);
              i.a(i.this, paramAnonymousString);
              i.3.this.lZn.Tc(paramAnonymousString);
              AppMethodBeat.o(175024);
            }
          });
          AppMethodBeat.o(175025);
          return;
          if (paramAnonymousString.GBL.HRE == 0.0D)
          {
            paramAnonymousString = aj.getContext().getString(2131755604);
          }
          else
          {
            paramAnonymousString = aj.getContext().getString(2131756038, new Object[] { String.valueOf(paramAnonymousString.GBL.HRE) });
            continue;
            paramAnonymousString = aj.getContext().getString(2131756005);
            ad.e("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request fail");
          }
        }
      }
    });
    AppMethodBeat.o(47792);
  }
  
  public String btP()
  {
    AppMethodBeat.i(47788);
    String str = this.jzY.Fh().iAa;
    AppMethodBeat.o(47788);
    return str;
  }
  
  public String btQ()
  {
    AppMethodBeat.i(47789);
    String str = this.jzY.Fh().doD;
    AppMethodBeat.o(47789);
    return str;
  }
  
  public String btR()
  {
    AppMethodBeat.i(47790);
    String str = e.rP(this.jzY.Fh().jYh.jIU);
    AppMethodBeat.o(47790);
    return str;
  }
  
  public boolean btS()
  {
    AppMethodBeat.i(47791);
    if (this.jzY.Fi().originalFlag == 1)
    {
      AppMethodBeat.o(47791);
      return true;
    }
    AppMethodBeat.o(47791);
    return false;
  }
  
  public Runnable c(com.tencent.luggage.sdk.b.a.c paramc)
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
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)this.jzY.Fh();
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.jzY.Fi();
    if ((localAppBrandSysConfigLU == null) || (localAppBrandInitConfigLU == null))
    {
      AppMethodBeat.o(47794);
      return local4;
    }
    paramc = new i.5(this, localAppBrandInitConfigLU, paramc, localAppBrandSysConfigLU);
    AppMethodBeat.o(47794);
    return paramc;
  }
  
  public b uL(int paramInt)
  {
    AppMethodBeat.i(47793);
    if (paramInt == b.a.lYJ.ordinal())
    {
      AppMethodBeat.o(47793);
      return null;
    }
    b localb = new b();
    Context localContext = aj.getContext();
    if (paramInt == b.a.lYK.ordinal())
    {
      localb.desc = localContext.getString(2131755998);
      localb.lZt = 2131689692;
    }
    for (localb.lZs = 2131230989;; localb.lZs = 2131230990)
    {
      AppMethodBeat.o(47793);
      return localb;
      if (paramInt != b.a.lYL.ordinal()) {
        break;
      }
      localb.desc = localContext.getString(2131756000);
      localb.lZt = 2131689694;
    }
    AppMethodBeat.o(47793);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void Tc(String paramString);
  }
  
  public static final class b
  {
    public String desc;
    public int lZs;
    public int lZt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i
 * JD-Core Version:    0.7.0.1
 */