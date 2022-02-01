package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.q;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Modifier;
import java.util.Locale;
import junit.framework.Assert;

public final class IPCRunCgi
{
  private static final b jZv;
  
  static
  {
    AppMethodBeat.i(205224);
    jZv = new b()
    {
      public final com.tencent.mm.an.d a(com.tencent.mm.an.d paramAnonymousd)
      {
        return paramAnonymousd;
      }
    };
    AppMethodBeat.o(205224);
  }
  
  public static q a(com.tencent.mm.an.d paramd, IPCRunCgi.a parama)
  {
    AppMethodBeat.i(174551);
    paramd = a(paramd, null, parama, null);
    AppMethodBeat.o(174551);
    return paramd;
  }
  
  public static q a(com.tencent.mm.an.d paramd, IPCRunCgi.a parama, com.tencent.mm.vending.e.b<? extends com.tencent.mm.vending.e.a> paramb)
  {
    AppMethodBeat.i(205220);
    paramd = a(paramd, null, parama, paramb);
    AppMethodBeat.o(205220);
    return paramd;
  }
  
  public static q a(com.tencent.mm.an.d paramd, b paramb, IPCRunCgi.a parama, com.tencent.mm.vending.e.b<? extends com.tencent.mm.vending.e.a> paramb1)
  {
    AppMethodBeat.i(205222);
    if (MMApplicationContext.isMainProcess())
    {
      b localb = paramb;
      if (paramb == null) {
        localb = jZv;
      }
      paramd = aa.a(localb.a(paramd), new IPCRunCgi.2(parama), true, paramb1);
      AppMethodBeat.o(205222);
      return paramd;
    }
    b(paramd, paramb, parama, paramb1);
    AppMethodBeat.o(205222);
    return null;
  }
  
  private static void b(com.tencent.mm.an.d paramd, b paramb, IPCRunCgi.a parama, com.tencent.mm.vending.e.b<? extends com.tencent.mm.vending.e.a> paramb1)
  {
    Object localObject = null;
    AppMethodBeat.i(205223);
    b localb = paramb;
    if (paramb != null)
    {
      localb = paramb;
      if (!Modifier.isStatic(paramb.getClass().getModifiers()))
      {
        paramb = String.format(Locale.ENGLISH, "remoteCgiImpl in client process, invalid interceptor %s", new Object[] { paramb.getClass().getName() });
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
          Assert.fail(paramb);
        }
        Log.printErrStackTrace("MicroMsg.IPCRunCgi", new Throwable(), paramb, new Object[0]);
        localb = null;
      }
    }
    IPCRunCgiParamsWrapper localIPCRunCgiParamsWrapper = new IPCRunCgiParamsWrapper();
    if (localb == null)
    {
      paramb = null;
      IPCRunCgiParamsWrapper.a(localIPCRunCgiParamsWrapper, paramb);
      IPCRunCgiParamsWrapper.a(localIPCRunCgiParamsWrapper, paramd);
      paramb = MainProcessIPCService.PROCESS_NAME;
      if (parama != null) {
        break label158;
      }
    }
    label158:
    for (paramd = localObject;; paramd = new c(parama, paramb1))
    {
      XIPCInvoker.a(paramb, localIPCRunCgiParamsWrapper, d.class, paramd);
      AppMethodBeat.o(205223);
      return;
      paramb = localb.getClass().getName();
      break;
    }
  }
  
  static final class IPCRunCgiParamsWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCRunCgiParamsWrapper> CREATOR;
    private String jZx;
    private com.tencent.mm.an.d rr;
    
    static
    {
      AppMethodBeat.i(205354);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(205354);
    }
    
    public IPCRunCgiParamsWrapper() {}
    
    IPCRunCgiParamsWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(205350);
      this.jZx = paramParcel.readString();
      this.rr = ((com.tencent.mm.an.d)c.a(a.class.getName(), paramParcel));
      AppMethodBeat.o(205350);
    }
    
    public final IPCRunCgi.b aFG()
    {
      AppMethodBeat.i(205348);
      IPCRunCgi.b localb1;
      if (this.jZx == null)
      {
        localb1 = IPCRunCgi.aFF();
        AppMethodBeat.o(205348);
        return localb1;
      }
      try
      {
        localb1 = (IPCRunCgi.b)org.a.a.ce(org.a.a.bIA(this.jZx)).iVg().object;
        AppMethodBeat.o(205348);
        return localb1;
      }
      catch (org.a.b localb)
      {
        Log.e("MicroMsg.IPCRunCgi", "createInterceptor with name:%s, get exception:%s", new Object[] { this.jZx, localb });
        IPCRunCgi.b localb2 = IPCRunCgi.aFF();
        AppMethodBeat.o(205348);
        return localb2;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(205349);
      paramParcel.writeString(this.jZx);
      c.a(this.rr, paramParcel);
      AppMethodBeat.o(205349);
    }
  }
  
  public static abstract interface b
  {
    public abstract com.tencent.mm.an.d a(com.tencent.mm.an.d paramd);
  }
  
  static final class c
    implements f<IPCRunCgiRespWrapper>, com.tencent.mm.vending.e.a
  {
    private IPCRunCgi.a jZy;
    
    public c(IPCRunCgi.a parama, com.tencent.mm.vending.e.b<? extends com.tencent.mm.vending.e.a> paramb)
    {
      AppMethodBeat.i(205225);
      this.jZy = parama;
      if (paramb != null) {
        paramb.keep(this);
      }
      AppMethodBeat.o(205225);
    }
    
    public final void dead()
    {
      this.jZy = null;
    }
  }
  
  static final class d
    implements com.tencent.mm.ipcinvoker.d<IPCRunCgi.IPCRunCgiParamsWrapper, IPCRunCgiRespWrapper>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi
 * JD-Core Version:    0.7.0.1
 */