package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.c;
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
  private static final b hnF;
  
  static
  {
    AppMethodBeat.i(225230);
    hnF = new b()
    {
      public final com.tencent.mm.ak.d a(com.tencent.mm.ak.d paramAnonymousd)
      {
        return paramAnonymousd;
      }
    };
    AppMethodBeat.o(225230);
  }
  
  public static q a(com.tencent.mm.ak.d paramd, a parama)
  {
    AppMethodBeat.i(174551);
    paramd = a(paramd, null, parama);
    AppMethodBeat.o(174551);
    return paramd;
  }
  
  public static q a(com.tencent.mm.ak.d paramd, b paramb, a parama)
  {
    AppMethodBeat.i(225228);
    if (MMApplicationContext.isMMProcess())
    {
      b localb = paramb;
      if (paramb == null) {
        localb = hnF;
      }
      paramd = aa.a(localb.a(paramd), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(225221);
          if (this.hnG != null) {
            this.hnG.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd);
          }
          AppMethodBeat.o(225221);
          return 0;
        }
      }, true);
      AppMethodBeat.o(225228);
      return paramd;
    }
    b(paramd, paramb, parama);
    AppMethodBeat.o(225228);
    return null;
  }
  
  private static void b(com.tencent.mm.ak.d paramd, b paramb, a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(225229);
    b localb = paramb;
    if (paramb != null)
    {
      localb = paramb;
      if (!Modifier.isStatic(paramb.getClass().getModifiers()))
      {
        paramb = String.format(Locale.ENGLISH, "remoteCgiImpl in client process, invalid interceptor %s", new Object[] { paramb.getClass().getName() });
        if (BuildInfo.IS_FLAVOR_RED) {
          Assert.fail(paramb);
        }
        Log.printErrStackTrace("MicroMsg.IPCRunCgi", new Throwable(), paramb, new Object[0]);
        localb = null;
      }
    }
    IPCRunCgiParamsWrapper localIPCRunCgiParamsWrapper = new IPCRunCgiParamsWrapper();
    if (localb == null) {}
    for (paramb = localObject;; paramb = localb.getClass().getName())
    {
      IPCRunCgiParamsWrapper.a(localIPCRunCgiParamsWrapper, paramb);
      IPCRunCgiParamsWrapper.a(localIPCRunCgiParamsWrapper, paramd);
      XIPCInvoker.a(MainProcessIPCService.dkO, localIPCRunCgiParamsWrapper, c.class, new com.tencent.mm.ipcinvoker.d() {});
      AppMethodBeat.o(225229);
      return;
    }
  }
  
  static final class IPCRunCgiParamsWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCRunCgiParamsWrapper> CREATOR;
    private String hnH;
    private com.tencent.mm.ak.d rr;
    
    static
    {
      AppMethodBeat.i(225227);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(225227);
    }
    
    public IPCRunCgiParamsWrapper() {}
    
    IPCRunCgiParamsWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(225226);
      this.hnH = paramParcel.readString();
      this.rr = ((com.tencent.mm.ak.d)c.a(a.class.getName(), paramParcel));
      AppMethodBeat.o(225226);
    }
    
    public final IPCRunCgi.b ayn()
    {
      AppMethodBeat.i(225224);
      IPCRunCgi.b localb1;
      if (this.hnH == null)
      {
        localb1 = IPCRunCgi.aym();
        AppMethodBeat.o(225224);
        return localb1;
      }
      try
      {
        localb1 = (IPCRunCgi.b)org.a.a.bF(org.a.a.forName(this.hnH)).hPX().object;
        AppMethodBeat.o(225224);
        return localb1;
      }
      catch (org.a.b localb)
      {
        Log.e("MicroMsg.IPCRunCgi", "createInterceptor with name:%s, get exception:%s", new Object[] { this.hnH, localb });
        IPCRunCgi.b localb2 = IPCRunCgi.aym();
        AppMethodBeat.o(225224);
        return localb2;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(225225);
      paramParcel.writeString(this.hnH);
      c.a(this.rr, paramParcel);
      AppMethodBeat.o(225225);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd);
  }
  
  public static abstract interface b
  {
    public abstract com.tencent.mm.ak.d a(com.tencent.mm.ak.d paramd);
  }
  
  static final class c
    implements com.tencent.mm.ipcinvoker.b<IPCRunCgi.IPCRunCgiParamsWrapper, IPCRunCgiRespWrapper>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi
 * JD-Core Version:    0.7.0.1
 */