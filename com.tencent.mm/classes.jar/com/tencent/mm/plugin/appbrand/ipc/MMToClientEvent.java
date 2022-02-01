package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent
  extends MainProcessTask
{
  public static final Parcelable.Creator<MMToClientEvent> CREATOR;
  private static final HashMap<String, MMToClientEvent> kpR;
  private static final com.tencent.mm.plugin.appbrand.z.h<String, c> kpS;
  public String appId;
  int djY;
  String drC;
  private com.tencent.mm.plugin.appbrand.jsapi.c kjg;
  public int kpO;
  String kpP;
  Object kpQ;
  public int type;
  
  static
  {
    AppMethodBeat.i(134851);
    kpR = new HashMap();
    kpS = new com.tencent.mm.plugin.appbrand.z.h();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134851);
  }
  
  private MMToClientEvent() {}
  
  private MMToClientEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(134842);
    e(paramParcel);
    AppMethodBeat.o(134842);
  }
  
  public static void Pb(String paramString)
  {
    AppMethodBeat.i(174746);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174746);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    kpR.put(paramString, localMMToClientEvent);
    localMMToClientEvent.kpO = 1;
    localMMToClientEvent.appId = paramString;
    AppBrandMainProcessService.a(localMMToClientEvent);
    AppMethodBeat.o(174746);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(134846);
    if (paramc != null) {
      kpS.j(paramString, paramc);
    }
    AppMethodBeat.o(134846);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(134847);
    if (paramc != null) {
      kpS.D(paramString, paramc);
    }
    AppMethodBeat.o(134847);
  }
  
  public static void e(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(134844);
    if (paramc == null)
    {
      AppMethodBeat.o(134844);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    kpR.put(paramc.getAppId(), localMMToClientEvent);
    localMMToClientEvent.kpO = 1;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.kjg = paramc;
    AppBrandMainProcessService.a(localMMToClientEvent);
    AppMethodBeat.o(134844);
  }
  
  public static void f(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(134845);
    if (paramc == null)
    {
      AppMethodBeat.o(134845);
      return;
    }
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)kpR.remove(paramc.getAppId());
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(134845);
      return;
    }
    kpS.cF(paramc.getAppId());
    localMMToClientEvent.kpO = 2;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.kjg = null;
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
    if (kpR.get(paramString) != null)
    {
      AppMethodBeat.o(174745);
      return true;
    }
    AppMethodBeat.o(174745);
    return false;
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(134843);
    switch (this.kpO)
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
  
  public final void aOB()
  {
    AppMethodBeat.i(134848);
    switch (this.kpO)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134848);
      return;
      if (this.kjg != null)
      {
        Object localObject1 = new a();
        final Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", Integer.valueOf(this.type));
        ((HashMap)localObject2).put("data", this.drC);
        ((a)localObject1).g(this.kjg).A((Map)localObject2).bir();
        AppMethodBeat.o(134848);
        return;
        localObject1 = new b();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("count", Integer.valueOf(this.djY));
        ((HashMap)localObject2).put("data", this.drC);
        ((b)localObject1).g(this.kjg).A((Map)localObject2).bir();
        AppMethodBeat.o(134848);
        return;
        if ((this.appId == null) || (this.kpQ == null))
        {
          AppMethodBeat.o(134848);
          return;
        }
        localObject1 = this.appId;
        localObject2 = this.kpQ;
        com.tencent.e.h.LTJ.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134840);
            Object localObject = MMToClientEvent.bhW();
            String str = this.kpT;
            android.support.v4.e.c local1 = new android.support.v4.e.c() {};
            if (str == null)
            {
              AppMethodBeat.o(134840);
              return;
            }
            localObject = ((com.tencent.mm.plugin.appbrand.z.h)localObject).cE(str).iterator();
            while (((Iterator)localObject).hasNext()) {
              local1.accept(((Iterator)localObject).next());
            }
            AppMethodBeat.o(134840);
          }
        }, "MicroMsg.MMToClientEvent");
      }
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(134849);
    this.kpO = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.drC = paramParcel.readString();
    this.djY = paramParcel.readInt();
    try
    {
      this.kpP = paramParcel.readString();
      if (!bt.isNullOrNil(this.kpP))
      {
        Class localClass = Class.forName(this.kpP);
        if (localClass != null) {
          this.kpQ = paramParcel.readParcelable(localClass.getClassLoader());
        }
      }
      AppMethodBeat.o(134849);
      return;
    }
    catch (Exception paramParcel)
    {
      ad.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[] { paramParcel });
      AppMethodBeat.o(134849);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134850);
    paramParcel.writeInt(this.kpO);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.drC);
    paramParcel.writeInt(this.djY);
    if ((!bt.isNullOrNil(this.kpP)) && (this.kpQ != null))
    {
      paramParcel.writeString(this.kpP);
      paramParcel.writeParcelable((Parcelable)this.kpQ, paramInt);
    }
    AppMethodBeat.o(134850);
  }
  
  public static final class a
    extends p
  {
    private static final int CTRL_INDEX = 109;
    private static final String NAME = "onAppConfig";
  }
  
  public static final class b
    extends p
  {
    private static final int CTRL_INDEX = 152;
    private static final String NAME = "onContactMessageCountChange";
  }
  
  public static abstract interface c
  {
    public abstract void ch(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent
 * JD-Core Version:    0.7.0.1
 */