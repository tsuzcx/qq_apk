package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import java.lang.reflect.Modifier;
import java.util.Locale;
import junit.framework.Assert;

public final class IPCRunCgi
{
  private static final b gez;
  
  static
  {
    AppMethodBeat.i(192945);
    gez = new b()
    {
      public final com.tencent.mm.ak.b a(com.tencent.mm.ak.b paramAnonymousb)
      {
        return paramAnonymousb;
      }
    };
    AppMethodBeat.o(192945);
  }
  
  public static n a(com.tencent.mm.ak.b paramb, a parama)
  {
    AppMethodBeat.i(174551);
    paramb = a(paramb, null, parama);
    AppMethodBeat.o(174551);
    return paramb;
  }
  
  public static n a(com.tencent.mm.ak.b paramb, b paramb1, a parama)
  {
    AppMethodBeat.i(192943);
    if (ai.ciE())
    {
      b localb = paramb1;
      if (paramb1 == null) {
        localb = gez;
      }
      paramb = x.a(localb.a(paramb), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(192936);
          if (this.geA != null) {
            this.geA.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb);
          }
          AppMethodBeat.o(192936);
          return 0;
        }
      }, true);
      AppMethodBeat.o(192943);
      return paramb;
    }
    b(paramb, paramb1, parama);
    AppMethodBeat.o(192943);
    return null;
  }
  
  private static void b(com.tencent.mm.ak.b paramb, b paramb1, a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(192944);
    b localb = paramb1;
    if (paramb1 != null)
    {
      localb = paramb1;
      if (!Modifier.isStatic(paramb1.getClass().getModifiers()))
      {
        paramb1 = String.format(Locale.ENGLISH, "remoteCgiImpl in client process, invalid interceptor %s", new Object[] { paramb1.getClass().getName() });
        if (h.IS_FLAVOR_RED) {
          Assert.fail(paramb1);
        }
        ac.printErrStackTrace("MicroMsg.IPCRunCgi", new Throwable(), paramb1, new Object[0]);
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
      AppMethodBeat.o(192944);
      return;
    }
  }
  
  static final class IPCRunCgiParamsWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCRunCgiParamsWrapper> CREATOR;
    private String geB;
    private com.tencent.mm.ak.b rr;
    
    static
    {
      AppMethodBeat.i(192942);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(192942);
    }
    
    public IPCRunCgiParamsWrapper() {}
    
    IPCRunCgiParamsWrapper(Parcel paramParcel)
    {
      AppMethodBeat.i(192941);
      this.geB = paramParcel.readString();
      this.rr = ((com.tencent.mm.ak.b)c.a(a.class.getName(), paramParcel));
      AppMethodBeat.o(192941);
    }
    
    public final IPCRunCgi.b aeX()
    {
      AppMethodBeat.i(192939);
      IPCRunCgi.b localb1;
      if (this.geB == null)
      {
        localb1 = IPCRunCgi.aeW();
        AppMethodBeat.o(192939);
        return localb1;
      }
      try
      {
        localb1 = (IPCRunCgi.b)org.a.a.bD(org.a.a.forName(this.geB)).gfN().object;
        AppMethodBeat.o(192939);
        return localb1;
      }
      catch (org.a.b localb)
      {
        ac.e("MicroMsg.IPCRunCgi", "createInterceptor with name:%s, get exception:%s", new Object[] { this.geB, localb });
        IPCRunCgi.b localb2 = IPCRunCgi.aeW();
        AppMethodBeat.o(192939);
        return localb2;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(192940);
      paramParcel.writeString(this.geB);
      c.a(this.rr, paramParcel);
      AppMethodBeat.o(192940);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb);
  }
  
  public static abstract interface b
  {
    public abstract com.tencent.mm.ak.b a(com.tencent.mm.ak.b paramb);
  }
  
  static final class c
    implements com.tencent.mm.ipcinvoker.b<IPCRunCgi.IPCRunCgiParamsWrapper, IPCRunCgiRespWrapper>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi
 * JD-Core Version:    0.7.0.1
 */