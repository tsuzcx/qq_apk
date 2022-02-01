package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class h
{
  private static final HashMap<AppBrandRuntime, h> kYa;
  private static final h kYc;
  private AppBrandRuntime iGV;
  private String kYb;
  
  static
  {
    AppMethodBeat.i(47795);
    kYa = new HashMap();
    kYc = new h()
    {
      public final void a(h.a paramAnonymousa) {}
      
      public final String biX()
      {
        return null;
      }
      
      public final String biY()
      {
        return "";
      }
      
      public final String biZ()
      {
        return "";
      }
      
      public final boolean bja()
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
      
      public final h.b tq(int paramAnonymousInt)
      {
        return null;
      }
    };
    AppMethodBeat.o(47795);
  }
  
  private h(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(175027);
    this.iGV = paramAppBrandRuntime;
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(175027);
      return;
    }
    paramAppBrandRuntime.iDK.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(175023);
        h.biV().remove(paramAppBrandRuntime);
        AppMethodBeat.o(175023);
      }
    });
    AppMethodBeat.o(175027);
  }
  
  public static h aj(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(47787);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = kYc;
      AppMethodBeat.o(47787);
      return paramAppBrandRuntime;
    }
    h localh2 = (h)kYa.get(paramAppBrandRuntime);
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = new h(paramAppBrandRuntime);
      kYa.put(paramAppBrandRuntime, localh1);
    }
    AppMethodBeat.o(47787);
    return localh1;
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(47792);
    if (!bt.isNullOrNil(this.kYb))
    {
      parama.Lr(this.kYb);
      AppMethodBeat.o(47792);
      return;
    }
    ayq localayq = new ayq();
    localayq.username = ((AppBrandInitConfigLU)this.iGV.Eg()).username;
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.funcId = 2921;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
    locala.gUU = localayq;
    locala.gUV = new ayr();
    IPCRunCgi.a(locala.atI(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(175025);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.gUT.gUX != null) && ((paramAnonymousb.gUT.gUX instanceof ayr)))
        {
          ad.i("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request success");
          paramAnonymousString = (ayr)paramAnonymousb.gUT.gUX;
          if ((paramAnonymousString.DwY == null) || (paramAnonymousString.DwY.EJf == -1.0D)) {
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
              h.a(h.this, paramAnonymousString);
              h.3.this.kYf.Lr(paramAnonymousString);
              AppMethodBeat.o(175024);
            }
          });
          AppMethodBeat.o(175025);
          return;
          if (paramAnonymousString.DwY.EJf == 0.0D)
          {
            paramAnonymousString = aj.getContext().getString(2131755604);
          }
          else
          {
            paramAnonymousString = aj.getContext().getString(2131756038, new Object[] { String.valueOf(paramAnonymousString.DwY.EJf) });
            continue;
            paramAnonymousString = aj.getContext().getString(2131756005);
            ad.e("MicroMsg.AppBrandMenuHeaderDataHelper", "queryProfile, request fail");
          }
        }
      }
    });
    AppMethodBeat.o(47792);
  }
  
  public String biX()
  {
    AppMethodBeat.i(47788);
    String str = this.iGV.Ef().hGe;
    AppMethodBeat.o(47788);
    return str;
  }
  
  public String biY()
  {
    AppMethodBeat.i(47789);
    String str = this.iGV.Ef().dfM;
    AppMethodBeat.o(47789);
    return str;
  }
  
  public String biZ()
  {
    AppMethodBeat.i(47790);
    String str = e.qC(this.iGV.Ef().jdS.iOQ);
    AppMethodBeat.o(47790);
    return str;
  }
  
  public boolean bja()
  {
    AppMethodBeat.i(47791);
    if (this.iGV.Eg().originalFlag == 1)
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
    AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)this.iGV.Ef();
    AppBrandInitConfigLU localAppBrandInitConfigLU = (AppBrandInitConfigLU)this.iGV.Eg();
    if ((localAppBrandSysConfigLU == null) || (localAppBrandInitConfigLU == null))
    {
      AppMethodBeat.o(47794);
      return local4;
    }
    paramc = new h.5(this, localAppBrandInitConfigLU, paramc, localAppBrandSysConfigLU);
    AppMethodBeat.o(47794);
    return paramc;
  }
  
  public b tq(int paramInt)
  {
    AppMethodBeat.i(47793);
    if (paramInt == b.a.kXB.ordinal())
    {
      AppMethodBeat.o(47793);
      return null;
    }
    b localb = new b();
    Context localContext = aj.getContext();
    if (paramInt == b.a.kXC.ordinal())
    {
      localb.desc = localContext.getString(2131755998);
      localb.kYl = 2131689692;
    }
    for (localb.kYk = 2131230989;; localb.kYk = 2131230990)
    {
      AppMethodBeat.o(47793);
      return localb;
      if (paramInt != b.a.kXD.ordinal()) {
        break;
      }
      localb.desc = localContext.getString(2131756000);
      localb.kYl = 2131689694;
    }
    AppMethodBeat.o(47793);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void Lr(String paramString);
  }
  
  public static final class b
  {
    public String desc;
    public int kYk;
    public int kYl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h
 * JD-Core Version:    0.7.0.1
 */