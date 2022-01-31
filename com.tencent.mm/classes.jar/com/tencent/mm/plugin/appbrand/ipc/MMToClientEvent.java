package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent
  extends MainProcessTask
{
  public static final Parcelable.Creator<MMToClientEvent> CREATOR;
  private static final HashMap<String, MMToClientEvent> hww;
  private static final HashMap<String, Set<c>> hwx;
  public String appId;
  int cmy;
  String ctQ;
  private c hrA;
  public int hwt;
  String hwu;
  Object hwv;
  public int type;
  
  static
  {
    AppMethodBeat.i(86947);
    hww = new HashMap();
    hwx = new HashMap();
    CREATOR = new MMToClientEvent.2();
    AppMethodBeat.o(86947);
  }
  
  private MMToClientEvent() {}
  
  private MMToClientEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(86938);
    f(paramParcel);
    AppMethodBeat.o(86938);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(86942);
    if (paramc != null) {
      synchronized (hwx)
      {
        if (!hwx.containsKey(paramString)) {
          hwx.put(paramString, new HashSet());
        }
        ((Set)hwx.get(paramString)).add(paramc);
        AppMethodBeat.o(86942);
        return;
      }
    }
    AppMethodBeat.o(86942);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(86943);
    if (paramc != null) {
      synchronized (hwx)
      {
        if (hwx.containsKey(paramString)) {
          ((Set)hwx.get(paramString)).remove(paramc);
        }
        AppMethodBeat.o(86943);
        return;
      }
    }
    AppMethodBeat.o(86943);
  }
  
  public static void e(c paramc)
  {
    AppMethodBeat.i(86940);
    if (paramc == null)
    {
      AppMethodBeat.o(86940);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    hww.put(paramc.getAppId(), localMMToClientEvent);
    localMMToClientEvent.hwt = 1;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.hrA = paramc;
    AppBrandMainProcessService.a(localMMToClientEvent);
    AppMethodBeat.o(86940);
  }
  
  public static void f(c paramc)
  {
    AppMethodBeat.i(86941);
    if (paramc == null)
    {
      AppMethodBeat.o(86941);
      return;
    }
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)hww.remove(paramc.getAppId());
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(86941);
      return;
    }
    synchronized (hwx)
    {
      hwx.remove(paramc.getAppId());
      localMMToClientEvent.hwt = 2;
      localMMToClientEvent.appId = paramc.getAppId();
      localMMToClientEvent.hrA = null;
      AppBrandMainProcessService.b(localMMToClientEvent);
      AppMethodBeat.o(86941);
      return;
    }
  }
  
  public final void ata()
  {
    AppMethodBeat.i(86939);
    switch (this.hwt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(86939);
      return;
      d.b(this);
      AppMethodBeat.o(86939);
      return;
      d.c(this);
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(86944);
    switch (this.hwt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(86944);
      return;
      ??? = new MMToClientEvent.a();
      Object localObject2 = new HashMap();
      ((HashMap)localObject2).put("type", Integer.valueOf(this.type));
      ((HashMap)localObject2).put("data", this.ctQ);
      ((MMToClientEvent.a)???).i(this.hrA).w((Map)localObject2).aBz();
      AppMethodBeat.o(86944);
      return;
      ??? = new MMToClientEvent.b();
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("count", Integer.valueOf(this.cmy));
      ((HashMap)localObject2).put("data", this.ctQ);
      ((MMToClientEvent.b)???).i(this.hrA).w((Map)localObject2).aBz();
      AppMethodBeat.o(86944);
      return;
      if ((this.appId == null) || (this.hwv == null))
      {
        AppMethodBeat.o(86944);
        return;
      }
      if (hwx.get(this.appId) == null) {
        continue;
      }
      localObject2 = new LinkedList();
      synchronized (hwx)
      {
        ((List)localObject2).addAll((Collection)hwx.get(this.appId));
        e.aNS().ac(new MMToClientEvent.1(this, (List)localObject2));
      }
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(86945);
    this.hwt = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.ctQ = paramParcel.readString();
    this.cmy = paramParcel.readInt();
    try
    {
      this.hwu = paramParcel.readString();
      if (!bo.isNullOrNil(this.hwu))
      {
        Class localClass = Class.forName(this.hwu);
        if (localClass != null) {
          this.hwv = paramParcel.readParcelable(localClass.getClassLoader());
        }
      }
      AppMethodBeat.o(86945);
      return;
    }
    catch (Exception paramParcel)
    {
      ab.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[] { paramParcel });
      AppMethodBeat.o(86945);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(86946);
    paramParcel.writeInt(this.hwt);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.ctQ);
    paramParcel.writeInt(this.cmy);
    if ((!bo.isNullOrNil(this.hwu)) && (this.hwv != null))
    {
      paramParcel.writeString(this.hwu);
      paramParcel.writeParcelable((Parcelable)this.hwv, paramInt);
    }
    AppMethodBeat.o(86946);
  }
  
  public static abstract interface c
  {
    public abstract void aZ(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent
 * JD-Core Version:    0.7.0.1
 */