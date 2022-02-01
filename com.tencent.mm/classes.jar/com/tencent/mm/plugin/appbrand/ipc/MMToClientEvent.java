package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.e.c;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent
  extends MainProcessTask
{
  public static final Parcelable.Creator<MMToClientEvent> CREATOR;
  private static final HashMap<String, MMToClientEvent> lwS;
  private static final com.tencent.mm.plugin.appbrand.ac.h<String, c> lwT;
  public String appId;
  String config;
  int dCm;
  private f lqg;
  public int lwP;
  String lwQ;
  Object lwR;
  public int type;
  
  static
  {
    AppMethodBeat.i(134851);
    lwS = new HashMap();
    lwT = new com.tencent.mm.plugin.appbrand.ac.h();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134851);
  }
  
  private MMToClientEvent() {}
  
  private MMToClientEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(134842);
    f(paramParcel);
    AppMethodBeat.o(134842);
  }
  
  public static void YY(String paramString)
  {
    AppMethodBeat.i(174746);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174746);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    lwS.put(paramString, localMMToClientEvent);
    localMMToClientEvent.lwP = 1;
    localMMToClientEvent.appId = paramString;
    AppBrandMainProcessService.a(localMMToClientEvent);
    AppMethodBeat.o(174746);
  }
  
  public static void YZ(String paramString)
  {
    AppMethodBeat.i(226649);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(226649);
      return;
    }
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)lwS.remove(paramString);
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(226649);
      return;
    }
    lwT.cN(paramString);
    localMMToClientEvent.lwP = 2;
    localMMToClientEvent.appId = paramString;
    AppBrandMainProcessService.b(localMMToClientEvent);
    AppMethodBeat.o(226649);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(134846);
    if (paramc != null) {
      lwT.r(paramString, paramc);
    }
    AppMethodBeat.o(134846);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(134847);
    if (paramc != null) {
      lwT.J(paramString, paramc);
    }
    AppMethodBeat.o(134847);
  }
  
  public static void e(f paramf)
  {
    AppMethodBeat.i(134844);
    if (paramf == null)
    {
      AppMethodBeat.o(134844);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    lwS.put(paramf.getAppId(), localMMToClientEvent);
    localMMToClientEvent.lwP = 1;
    localMMToClientEvent.appId = paramf.getAppId();
    localMMToClientEvent.lqg = paramf;
    AppBrandMainProcessService.a(localMMToClientEvent);
    AppMethodBeat.o(134844);
  }
  
  public static void f(f paramf)
  {
    AppMethodBeat.i(134845);
    if (paramf == null)
    {
      AppMethodBeat.o(134845);
      return;
    }
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)lwS.remove(paramf.getAppId());
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(134845);
      return;
    }
    lwT.cN(paramf.getAppId());
    localMMToClientEvent.lwP = 2;
    localMMToClientEvent.appId = paramf.getAppId();
    localMMToClientEvent.lqg = null;
    AppBrandMainProcessService.b(localMMToClientEvent);
    AppMethodBeat.o(134845);
  }
  
  public static boolean isRegistered(String paramString)
  {
    AppMethodBeat.i(174745);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174745);
      return false;
    }
    if (lwS.get(paramString) != null)
    {
      AppMethodBeat.o(174745);
      return true;
    }
    AppMethodBeat.o(174745);
    return false;
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(134843);
    switch (this.lwP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134843);
      return;
      e.a(this);
      AppMethodBeat.o(134843);
      return;
      e.b(this);
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(134848);
    switch (this.lwP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134848);
      return;
      if (this.lqg != null)
      {
        Object localObject1 = new a();
        final Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", Integer.valueOf(this.type));
        ((HashMap)localObject2).put("data", this.config);
        ((a)localObject1).g(this.lqg).K((Map)localObject2).bEo();
        AppMethodBeat.o(134848);
        return;
        localObject1 = new b();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("count", Integer.valueOf(this.dCm));
        ((HashMap)localObject2).put("data", this.config);
        ((b)localObject1).g(this.lqg).K((Map)localObject2).bEo();
        AppMethodBeat.o(134848);
        return;
        if ((this.appId == null) || (this.lwR == null))
        {
          AppMethodBeat.o(134848);
          return;
        }
        localObject1 = this.appId;
        localObject2 = this.lwR;
        com.tencent.f.h.RTc.b(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134840);
            Object localObject = MMToClientEvent.bDT();
            String str = this.lwU;
            c local1 = new c() {};
            if (str == null)
            {
              AppMethodBeat.o(134840);
              return;
            }
            localObject = ((com.tencent.mm.plugin.appbrand.ac.h)localObject).cM(str).iterator();
            while (((Iterator)localObject).hasNext()) {
              local1.accept(((Iterator)localObject).next());
            }
            AppMethodBeat.o(134840);
          }
        }, "MicroMsg.MMToClientEvent");
      }
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(134849);
    this.lwP = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.config = paramParcel.readString();
    this.dCm = paramParcel.readInt();
    try
    {
      this.lwQ = paramParcel.readString();
      if (!Util.isNullOrNil(this.lwQ))
      {
        Class localClass = Class.forName(this.lwQ);
        if (localClass != null) {
          this.lwR = paramParcel.readParcelable(localClass.getClassLoader());
        }
      }
      AppMethodBeat.o(134849);
      return;
    }
    catch (Exception paramParcel)
    {
      Log.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[] { paramParcel });
      AppMethodBeat.o(134849);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134850);
    paramParcel.writeInt(this.lwP);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.config);
    paramParcel.writeInt(this.dCm);
    if ((!Util.isNullOrNil(this.lwQ)) && (this.lwR != null))
    {
      paramParcel.writeString(this.lwQ);
      paramParcel.writeParcelable((Parcelable)this.lwR, paramInt);
    }
    AppMethodBeat.o(134850);
  }
  
  public static final class a
    extends s
  {
    private static final int CTRL_INDEX = 109;
    private static final String NAME = "onAppConfig";
  }
  
  public static final class b
    extends s
  {
    private static final int CTRL_INDEX = 152;
    private static final String NAME = "onContactMessageCountChange";
  }
  
  public static abstract interface c
  {
    public abstract void cq(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent
 * JD-Core Version:    0.7.0.1
 */