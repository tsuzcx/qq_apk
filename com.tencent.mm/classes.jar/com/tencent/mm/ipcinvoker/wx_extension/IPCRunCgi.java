package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.am.z.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Locale;
import junit.framework.Assert;

public final class IPCRunCgi
{
  private static final int[] mzw;
  private static final b mzx;
  
  static
  {
    AppMethodBeat.i(235716);
    mzw = new int[] { 1157, 1158, 1133, 4602, 1912 };
    mzx = new b()
    {
      public final com.tencent.mm.am.c a(com.tencent.mm.am.c paramAnonymousc)
      {
        return paramAnonymousc;
      }
    };
    AppMethodBeat.o(235716);
  }
  
  public static p a(com.tencent.mm.am.c paramc, IPCRunCgi.a parama)
  {
    AppMethodBeat.i(174551);
    paramc = a(paramc, null, parama, null);
    AppMethodBeat.o(174551);
    return paramc;
  }
  
  public static p a(com.tencent.mm.am.c paramc, IPCRunCgi.a parama, com.tencent.mm.vending.e.b<? extends com.tencent.mm.vending.e.a> paramb)
  {
    AppMethodBeat.i(235707);
    paramc = a(paramc, null, parama, paramb);
    AppMethodBeat.o(235707);
    return paramc;
  }
  
  public static p a(final com.tencent.mm.am.c paramc, final b paramb, IPCRunCgi.a parama, com.tencent.mm.vending.e.b<? extends com.tencent.mm.vending.e.a> paramb1)
  {
    IPCRunCgiParamsWrapper localIPCRunCgiParamsWrapper = null;
    AppMethodBeat.i(235711);
    b localb;
    if (MMApplicationContext.isMainProcess())
    {
      localb = paramb;
      if (paramb == null) {
        localb = mzx;
      }
      int i = paramc.getType();
      paramb = localIPCRunCgiParamsWrapper;
      if (org.apache.commons.c.a.contains(mzw, i)) {
        paramb = new h()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(235697);
            if ((3 == paramAnonymousInt1) && (!paramAnonymousp.hasCallBackToQueue()) && (IPCRunCgi.this != null)) {
              IPCRunCgi.this.callback(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramc);
            }
            try
            {
              z.ovg.aZX().b(paramAnonymousp.getType(), this);
              AppMethodBeat.o(235697);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              AppMethodBeat.o(235697);
            }
          }
        };
      }
      paramc = z.a(localb.a(paramc), new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
        {
          AppMethodBeat.i(235698);
          if (IPCRunCgi.this != null) {
            IPCRunCgi.this.callback(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousc);
          }
          try
          {
            if (paramb != null) {
              z.ovg.aZX().b(paramAnonymousp.getType(), paramb);
            }
            label53:
            AppMethodBeat.o(235698);
            return 0;
          }
          catch (Exception paramAnonymousString)
          {
            break label53;
          }
        }
      }, true, paramb1);
      if ((paramc == null) || (paramb == null)) {}
    }
    try
    {
      z.ovg.aZX().a(paramc.getType(), paramb);
      label103:
      AppMethodBeat.o(235711);
      return paramc;
      localb = paramb;
      if (paramb != null)
      {
        localb = paramb;
        if (!com.tencent.mm.ipcinvoker.g.b.au(paramb.getClass()))
        {
          paramb = String.format(Locale.ENGLISH, "remoteCgiImpl in client process, invalid interceptor %s", new Object[] { paramb.getClass().getName() });
          if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
            Assert.fail(paramb);
          }
          Log.printErrStackTrace("MicroMsg.IPCRunCgi", new Throwable(), paramb, new Object[0]);
          localb = null;
        }
      }
      localIPCRunCgiParamsWrapper = new IPCRunCgiParamsWrapper();
      if (localb == null)
      {
        paramb = null;
        IPCRunCgiParamsWrapper.a(localIPCRunCgiParamsWrapper, paramb);
        IPCRunCgiParamsWrapper.a(localIPCRunCgiParamsWrapper, paramc);
        paramb = MainProcessIPCService.PROCESS_NAME;
        if (parama != null) {
          break label257;
        }
      }
      label257:
      for (paramc = null;; paramc = new c(parama, paramb1))
      {
        XIPCInvoker.a(paramb, localIPCRunCgiParamsWrapper, d.class, paramc);
        AppMethodBeat.o(235711);
        return null;
        paramb = localb.getClass().getName();
        break;
      }
    }
    catch (Exception paramb)
    {
      break label103;
    }
  }
  
  static final class IPCRunCgiParamsWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCRunCgiParamsWrapper> CREATOR;
    private String mzB;
    private com.tencent.mm.am.c rr;
    
    static
    {
      AppMethodBeat.i(235701);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(235701);
    }
    
    public IPCRunCgiParamsWrapper() {}
    
    IPCRunCgiParamsWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(235699);
      this.mzB = paramParcel.readString();
      this.rr = ((com.tencent.mm.am.c)com.tencent.mm.ipcinvoker.extension.c.a(a.class.getName(), paramParcel));
      AppMethodBeat.o(235699);
    }
    
    public final IPCRunCgi.b aYG()
    {
      AppMethodBeat.i(235703);
      IPCRunCgi.b localb1;
      if (this.mzB == null)
      {
        localb1 = IPCRunCgi.aYF();
        AppMethodBeat.o(235703);
        return localb1;
      }
      try
      {
        localb1 = (IPCRunCgi.b)org.a.a.cQ(org.a.a.bLw(this.mzB)).kJE().object;
        AppMethodBeat.o(235703);
        return localb1;
      }
      catch (org.a.b localb)
      {
        Log.e("MicroMsg.IPCRunCgi", "createInterceptor with name:%s, get exception:%s", new Object[] { this.mzB, localb });
        IPCRunCgi.b localb2 = IPCRunCgi.aYF();
        AppMethodBeat.o(235703);
        return localb2;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(235708);
      paramParcel.writeString(this.mzB);
      com.tencent.mm.ipcinvoker.extension.c.a(this.rr, paramParcel);
      AppMethodBeat.o(235708);
    }
  }
  
  public static abstract interface b
  {
    public abstract com.tencent.mm.am.c a(com.tencent.mm.am.c paramc);
  }
  
  static final class c
    implements f<IPCRunCgiRespWrapper>, com.tencent.mm.vending.e.a
  {
    private IPCRunCgi.a mzC;
    
    public c(IPCRunCgi.a parama, com.tencent.mm.vending.e.b<? extends com.tencent.mm.vending.e.a> paramb)
    {
      AppMethodBeat.i(235709);
      this.mzC = parama;
      if (paramb != null) {
        paramb.keep(this);
      }
      AppMethodBeat.o(235709);
    }
    
    public final void dead()
    {
      this.mzC = null;
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static final class d
    implements com.tencent.mm.ipcinvoker.c<IPCRunCgi.IPCRunCgiParamsWrapper, IPCRunCgiRespWrapper>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi
 * JD-Core Version:    0.7.0.1
 */