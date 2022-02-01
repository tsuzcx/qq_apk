package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent
  extends MainProcessTask
{
  public static final Parcelable.Creator<MMToClientEvent> CREATOR;
  private static final HashMap<String, MMToClientEvent> jVD;
  private static final com.tencent.mm.plugin.appbrand.z.h<String, c> jVE;
  public String appId;
  int cYG;
  String dgg;
  private com.tencent.mm.plugin.appbrand.jsapi.c jOV;
  public int jVA;
  String jVB;
  Object jVC;
  public int type;
  
  static
  {
    AppMethodBeat.i(134851);
    jVD = new HashMap();
    jVE = new com.tencent.mm.plugin.appbrand.z.h();
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
  
  public static void LH(String paramString)
  {
    AppMethodBeat.i(174746);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174746);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    jVD.put(paramString, localMMToClientEvent);
    localMMToClientEvent.jVA = 1;
    localMMToClientEvent.appId = paramString;
    AppBrandMainProcessService.a(localMMToClientEvent);
    AppMethodBeat.o(174746);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(134846);
    if (paramc != null) {
      jVE.h(paramString, paramc);
    }
    AppMethodBeat.o(134846);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(134847);
    if (paramc != null) {
      jVE.B(paramString, paramc);
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
    jVD.put(paramc.getAppId(), localMMToClientEvent);
    localMMToClientEvent.jVA = 1;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.jOV = paramc;
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
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)jVD.remove(paramc.getAppId());
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(134845);
      return;
    }
    jVE.cD(paramc.getAppId());
    localMMToClientEvent.jVA = 2;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.jOV = null;
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
    if (jVD.get(paramString) != null)
    {
      AppMethodBeat.o(174745);
      return true;
    }
    AppMethodBeat.o(174745);
    return false;
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(134843);
    switch (this.jVA)
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
  
  public final void aLr()
  {
    AppMethodBeat.i(134848);
    switch (this.jVA)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134848);
      return;
      if (this.jOV != null)
      {
        Object localObject1 = new a();
        final Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", Integer.valueOf(this.type));
        ((HashMap)localObject2).put("data", this.dgg);
        ((a)localObject1).g(this.jOV).A((Map)localObject2).beN();
        AppMethodBeat.o(134848);
        return;
        localObject1 = new b();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("count", Integer.valueOf(this.cYG));
        ((HashMap)localObject2).put("data", this.dgg);
        ((b)localObject1).g(this.jOV).A((Map)localObject2).beN();
        AppMethodBeat.o(134848);
        return;
        if ((this.appId == null) || (this.jVC == null))
        {
          AppMethodBeat.o(134848);
          return;
        }
        localObject1 = this.appId;
        localObject2 = this.jVC;
        com.tencent.e.h.JZN.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134840);
            Object localObject = MMToClientEvent.bes();
            String str = this.jVF;
            android.support.v4.e.c local1 = new android.support.v4.e.c() {};
            if (str == null)
            {
              AppMethodBeat.o(134840);
              return;
            }
            localObject = ((com.tencent.mm.plugin.appbrand.z.h)localObject).cC(str).iterator();
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
    this.jVA = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.dgg = paramParcel.readString();
    this.cYG = paramParcel.readInt();
    try
    {
      this.jVB = paramParcel.readString();
      if (!bs.isNullOrNil(this.jVB))
      {
        Class localClass = Class.forName(this.jVB);
        if (localClass != null) {
          this.jVC = paramParcel.readParcelable(localClass.getClassLoader());
        }
      }
      AppMethodBeat.o(134849);
      return;
    }
    catch (Exception paramParcel)
    {
      ac.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[] { paramParcel });
      AppMethodBeat.o(134849);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134850);
    paramParcel.writeInt(this.jVA);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.dgg);
    paramParcel.writeInt(this.cYG);
    if ((!bs.isNullOrNil(this.jVB)) && (this.jVC != null))
    {
      paramParcel.writeString(this.jVB);
      paramParcel.writeParcelable((Parcelable)this.jVC, paramInt);
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
    public abstract void cf(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent
 * JD-Core Version:    0.7.0.1
 */