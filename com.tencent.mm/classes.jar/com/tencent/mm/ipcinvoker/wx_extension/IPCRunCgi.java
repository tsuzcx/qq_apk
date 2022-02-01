package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import java.lang.reflect.Modifier;
import java.util.Locale;
import junit.framework.Assert;

public final class IPCRunCgi
{
  private static final b gyj;
  
  static
  {
    AppMethodBeat.i(189802);
    gyj = new b()
    {
      public final com.tencent.mm.al.b a(com.tencent.mm.al.b paramAnonymousb)
      {
        return paramAnonymousb;
      }
    };
    AppMethodBeat.o(189802);
  }
  
  public static n a(com.tencent.mm.al.b paramb, IPCRunCgi.a parama)
  {
    AppMethodBeat.i(174551);
    paramb = a(paramb, null, parama);
    AppMethodBeat.o(174551);
    return paramb;
  }
  
  public static n a(com.tencent.mm.al.b paramb, b paramb1, IPCRunCgi.a parama)
  {
    AppMethodBeat.i(189800);
    if (aj.cnC())
    {
      b localb = paramb1;
      if (paramb1 == null) {
        localb = gyj;
      }
      paramb = x.a(localb.a(paramb), new IPCRunCgi.2(parama), true);
      AppMethodBeat.o(189800);
      return paramb;
    }
    b(paramb, paramb1, parama);
    AppMethodBeat.o(189800);
    return null;
  }
  
  private static void b(com.tencent.mm.al.b paramb, b paramb1, IPCRunCgi.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(189801);
    b localb = paramb1;
    if (paramb1 != null)
    {
      localb = paramb1;
      if (!Modifier.isStatic(paramb1.getClass().getModifiers()))
      {
        paramb1 = String.format(Locale.ENGLISH, "remoteCgiImpl in client process, invalid interceptor %s", new Object[] { paramb1.getClass().getName() });
        if (i.IS_FLAVOR_RED) {
          Assert.fail(paramb1);
        }
        ad.printErrStackTrace("MicroMsg.IPCRunCgi", new Throwable(), paramb1, new Object[0]);
        localb = null;
      }
    }
    IPCRunCgiParamsWrapper localIPCRunCgiParamsWrapper = new IPCRunCgiParamsWrapper();
    if (localb == null) {}
    for (paramb1 = localObject;; paramb1 = localb.getClass().getName())
    {
      IPCRunCgiParamsWrapper.a(localIPCRunCgiParamsWrapper, paramb1);
      IPCRunCgiParamsWrapper.a(localIPCRunCgiParamsWrapper, paramb);
      XIPCInvoker.a("com.tencent.mm", localIPCRunCgiParamsWrapper, c.class, new d() {});
      AppMethodBeat.o(189801);
      return;
    }
  }
  
  static final class IPCRunCgiParamsWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCRunCgiParamsWrapper> CREATOR;
    private String gyl;
    private com.tencent.mm.al.b rr;
    
    static
    {
      AppMethodBeat.i(189799);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(189799);
    }
    
    public IPCRunCgiParamsWrapper() {}
    
    IPCRunCgiParamsWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(189798);
      this.gyl = paramParcel.readString();
      this.rr = ((com.tencent.mm.al.b)c.a(a.class.getName(), paramParcel));
      AppMethodBeat.o(189798);
    }
    
    public final IPCRunCgi.b ahJ()
    {
      AppMethodBeat.i(189796);
      IPCRunCgi.b localb1;
      if (this.gyl == null)
      {
        localb1 = IPCRunCgi.ahI();
        AppMethodBeat.o(189796);
        return localb1;
      }
      try
      {
        localb1 = (IPCRunCgi.b)org.a.a.bF(org.a.a.forName(this.gyl)).gyr().object;
        AppMethodBeat.o(189796);
        return localb1;
      }
      catch (org.a.b localb)
      {
        ad.e("MicroMsg.IPCRunCgi", "createInterceptor with name:%s, get exception:%s", new Object[] { this.gyl, localb });
        IPCRunCgi.b localb2 = IPCRunCgi.ahI();
        AppMethodBeat.o(189796);
        return localb2;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(189797);
      paramParcel.writeString(this.gyl);
      c.a(this.rr, paramParcel);
      AppMethodBeat.o(189797);
    }
  }
  
  public static abstract interface b
  {
    public abstract com.tencent.mm.al.b a(com.tencent.mm.al.b paramb);
  }
  
  static final class c
    implements com.tencent.mm.ipcinvoker.b<IPCRunCgi.IPCRunCgiParamsWrapper, IPCRunCgiRespWrapper>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi
 * JD-Core Version:    0.7.0.1
 */