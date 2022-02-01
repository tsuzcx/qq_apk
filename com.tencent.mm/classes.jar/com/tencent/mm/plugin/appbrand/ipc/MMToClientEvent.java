package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent
  extends MainProcessTask
{
  public static final Parcelable.Creator<MMToClientEvent> CREATOR;
  private static final HashMap<String, MMToClientEvent> ktg;
  private static final com.tencent.mm.plugin.appbrand.y.h<String, c> kth;
  public String appId;
  int dla;
  String dsI;
  private com.tencent.mm.plugin.appbrand.jsapi.c kmw;
  public int ktd;
  String kte;
  Object ktf;
  public int type;
  
  static
  {
    AppMethodBeat.i(134851);
    ktg = new HashMap();
    kth = new com.tencent.mm.plugin.appbrand.y.h();
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
  
  public static void PJ(String paramString)
  {
    AppMethodBeat.i(174746);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174746);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    ktg.put(paramString, localMMToClientEvent);
    localMMToClientEvent.ktd = 1;
    localMMToClientEvent.appId = paramString;
    AppBrandMainProcessService.a(localMMToClientEvent);
    AppMethodBeat.o(174746);
  }
  
  public static void YS(String paramString)
  {
    AppMethodBeat.i(224364);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(224364);
      return;
    }
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)ktg.remove(paramString);
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(224364);
      return;
    }
    kth.cG(paramString);
    localMMToClientEvent.ktd = 2;
    localMMToClientEvent.appId = paramString;
    AppBrandMainProcessService.b(localMMToClientEvent);
    AppMethodBeat.o(224364);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(134846);
    if (paramc != null) {
      kth.j(paramString, paramc);
    }
    AppMethodBeat.o(134846);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(134847);
    if (paramc != null) {
      kth.D(paramString, paramc);
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
    ktg.put(paramc.getAppId(), localMMToClientEvent);
    localMMToClientEvent.ktd = 1;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.kmw = paramc;
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
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)ktg.remove(paramc.getAppId());
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(134845);
      return;
    }
    kth.cG(paramc.getAppId());
    localMMToClientEvent.ktd = 2;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.kmw = null;
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
    if (ktg.get(paramString) != null)
    {
      AppMethodBeat.o(174745);
      return true;
    }
    AppMethodBeat.o(174745);
    return false;
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(134843);
    switch (this.ktd)
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
  
  public final void aOY()
  {
    AppMethodBeat.i(134848);
    switch (this.ktd)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134848);
      return;
      if (this.kmw != null)
      {
        Object localObject1 = new a();
        final Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", Integer.valueOf(this.type));
        ((HashMap)localObject2).put("data", this.dsI);
        ((a)localObject1).g(this.kmw).H((Map)localObject2).bja();
        AppMethodBeat.o(134848);
        return;
        localObject1 = new b();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("count", Integer.valueOf(this.dla));
        ((HashMap)localObject2).put("data", this.dsI);
        ((b)localObject1).g(this.kmw).H((Map)localObject2).bja();
        AppMethodBeat.o(134848);
        return;
        if ((this.appId == null) || (this.ktf == null))
        {
          AppMethodBeat.o(134848);
          return;
        }
        localObject1 = this.appId;
        localObject2 = this.ktf;
        com.tencent.e.h.MqF.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134840);
            Object localObject = MMToClientEvent.biF();
            String str = this.kti;
            android.support.v4.e.c local1 = new android.support.v4.e.c() {};
            if (str == null)
            {
              AppMethodBeat.o(134840);
              return;
            }
            localObject = ((com.tencent.mm.plugin.appbrand.y.h)localObject).cF(str).iterator();
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
    this.ktd = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.dsI = paramParcel.readString();
    this.dla = paramParcel.readInt();
    try
    {
      this.kte = paramParcel.readString();
      if (!bu.isNullOrNil(this.kte))
      {
        Class localClass = Class.forName(this.kte);
        if (localClass != null) {
          this.ktf = paramParcel.readParcelable(localClass.getClassLoader());
        }
      }
      AppMethodBeat.o(134849);
      return;
    }
    catch (Exception paramParcel)
    {
      ae.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[] { paramParcel });
      AppMethodBeat.o(134849);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134850);
    paramParcel.writeInt(this.ktd);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.dsI);
    paramParcel.writeInt(this.dla);
    if ((!bu.isNullOrNil(this.kte)) && (this.ktf != null))
    {
      paramParcel.writeString(this.kte);
      paramParcel.writeParcelable((Parcelable)this.ktf, paramInt);
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