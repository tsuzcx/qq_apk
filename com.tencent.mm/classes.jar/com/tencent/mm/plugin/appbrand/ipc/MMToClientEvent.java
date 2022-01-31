package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static final Parcelable.Creator<MMToClientEvent> CREATOR = new MMToClientEvent.2();
  private static final HashMap<String, MMToClientEvent> gex = new HashMap();
  private static final HashMap<String, Set<MMToClientEvent.c>> gey = new HashMap();
  public String appId;
  int bFo;
  String bMw;
  public int get;
  private com.tencent.mm.plugin.appbrand.jsapi.c geu;
  String gev;
  Object gew;
  public int type;
  
  private MMToClientEvent() {}
  
  private MMToClientEvent(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public static void a(String paramString, MMToClientEvent.c paramc)
  {
    if (paramc != null) {
      synchronized (gey)
      {
        if (!gey.containsKey(paramString)) {
          gey.put(paramString, new HashSet());
        }
        ((Set)gey.get(paramString)).add(paramc);
        return;
      }
    }
  }
  
  public static void b(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    if (paramc == null) {
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    gex.put(paramc.getAppId(), localMMToClientEvent);
    localMMToClientEvent.get = 1;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.geu = paramc;
    AppBrandMainProcessService.a(localMMToClientEvent);
  }
  
  public static void b(String paramString, MMToClientEvent.c paramc)
  {
    if (paramc != null) {
      synchronized (gey)
      {
        if (gey.containsKey(paramString)) {
          ((Set)gey.get(paramString)).remove(paramc);
        }
        return;
      }
    }
  }
  
  public static void c(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    if (paramc == null) {}
    MMToClientEvent localMMToClientEvent;
    do
    {
      return;
      localMMToClientEvent = (MMToClientEvent)gex.get(paramc.getAppId());
    } while (localMMToClientEvent == null);
    gex.remove(paramc.getAppId());
    localMMToClientEvent.get = 2;
    localMMToClientEvent.appId = paramc.getAppId();
    localMMToClientEvent.geu = null;
    AppBrandMainProcessService.b(localMMToClientEvent);
  }
  
  public final void Zu()
  {
    switch (this.get)
    {
    default: 
      return;
    case 1: 
      d.b(this);
      return;
    }
    d.c(this);
  }
  
  public final void Zv()
  {
    switch (this.get)
    {
    }
    do
    {
      return;
      ??? = new MMToClientEvent.a();
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("type", Integer.valueOf(this.type));
      ((HashMap)localObject2).put("data", this.bMw);
      ((MMToClientEvent.a)???).d(this.geu).o((Map)localObject2).dispatch();
      return;
      ??? = new MMToClientEvent.b();
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("count", Integer.valueOf(this.bFo));
      ((HashMap)localObject2).put("data", this.bMw);
      ((MMToClientEvent.b)???).d(this.geu).o((Map)localObject2).dispatch();
      return;
    } while ((this.appId == null) || (this.gew == null) || (gey.get(this.appId) == null));
    Object localObject2 = new LinkedList();
    synchronized (gey)
    {
      ((List)localObject2).addAll((Collection)gey.get(this.appId));
      com.tencent.mm.plugin.appbrand.v.c.DS().O(new MMToClientEvent.1(this, (List)localObject2));
      return;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.get = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.bMw = paramParcel.readString();
    this.bFo = paramParcel.readInt();
    try
    {
      this.gev = paramParcel.readString();
      if (!bk.bl(this.gev))
      {
        Class localClass = Class.forName(this.gev);
        if (localClass != null) {
          this.gew = paramParcel.readParcelable(localClass.getClassLoader());
        }
      }
      return;
    }
    catch (Exception paramParcel)
    {
      y.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[] { paramParcel });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.get);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.bMw);
    paramParcel.writeInt(this.bFo);
    if ((!bk.bl(this.gev)) && (this.gew != null))
    {
      paramParcel.writeString(this.gev);
      paramParcel.writeParcelable((Parcelable)this.gew, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent
 * JD-Core Version:    0.7.0.1
 */