package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.j;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

public class MMToClientEvent
  extends MainProcessTask
{
  public static final Parcelable.Creator<MMToClientEvent> CREATOR;
  private static final HashMap<String, MMToClientEvent> rvt;
  private static final j<String, c> rvu;
  public String appId;
  String config;
  int hzj;
  private com.tencent.mm.plugin.appbrand.jsapi.f rot;
  public int rvq;
  String rvr;
  Object rvs;
  public int type;
  
  static
  {
    AppMethodBeat.i(134851);
    rvt = new HashMap();
    rvu = new j();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134851);
  }
  
  private MMToClientEvent() {}
  
  private MMToClientEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(134842);
    h(paramParcel);
    AppMethodBeat.o(134842);
  }
  
  public static boolean ZF(String paramString)
  {
    AppMethodBeat.i(174745);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174745);
      return false;
    }
    if (rvt.get(paramString) != null)
    {
      AppMethodBeat.o(174745);
      return true;
    }
    AppMethodBeat.o(174745);
    return false;
  }
  
  public static void ZG(String paramString)
  {
    AppMethodBeat.i(174746);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174746);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    rvt.put(paramString, localMMToClientEvent);
    localMMToClientEvent.rvq = 1;
    localMMToClientEvent.appId = paramString;
    localMMToClientEvent.bQt();
    AppMethodBeat.o(174746);
  }
  
  public static void ZH(String paramString)
  {
    AppMethodBeat.i(319439);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(319439);
      return;
    }
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)rvt.remove(paramString);
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(319439);
      return;
    }
    rvu.ek(paramString);
    localMMToClientEvent.rvq = 2;
    localMMToClientEvent.appId = paramString;
    localMMToClientEvent.rot = null;
    if (MMApplicationContext.isMMProcessExist()) {
      try
      {
        localMMToClientEvent.cpB();
        AppMethodBeat.o(319439);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        Log.e("MicroMsg.MMToClientEvent", "unregisterToMM(%s) get exception:%s", new Object[] { paramString, localSecurityException });
      }
    }
    AppMethodBeat.o(319439);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(134846);
    if (paramc != null) {
      rvu.v(paramString, paramc);
    }
    AppMethodBeat.o(134846);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(134847);
    if (paramc != null) {
      rvu.O(paramString, paramc);
    }
    AppMethodBeat.o(134847);
  }
  
  public static void f(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(134844);
    if (paramf == null)
    {
      AppMethodBeat.o(134844);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    rvt.put(paramf.getAppId(), localMMToClientEvent);
    localMMToClientEvent.rvq = 1;
    localMMToClientEvent.appId = paramf.getAppId();
    localMMToClientEvent.rot = paramf;
    localMMToClientEvent.bQt();
    AppMethodBeat.o(134844);
  }
  
  public static void g(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(134845);
    if (paramf == null)
    {
      AppMethodBeat.o(134845);
      return;
    }
    ZH(paramf.getAppId());
    AppMethodBeat.o(134845);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(134843);
    switch (this.rvq)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134843);
      return;
      f.a(this);
      AppMethodBeat.o(134843);
      return;
      f.b(this);
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(134848);
    switch (this.rvq)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134848);
      return;
      if (this.rot != null)
      {
        Object localObject1 = new MMToClientEvent.a();
        final Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", Integer.valueOf(this.type));
        ((HashMap)localObject2).put("data", this.config);
        ((MMToClientEvent.a)localObject1).h(this.rot).K((Map)localObject2).cpV();
        AppMethodBeat.o(134848);
        return;
        localObject1 = new MMToClientEvent.b();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("count", Integer.valueOf(this.hzj));
        ((HashMap)localObject2).put("data", this.config);
        ((MMToClientEvent.b)localObject1).h(this.rot).K((Map)localObject2).cpV();
        AppMethodBeat.o(134848);
        return;
        if ((this.appId == null) || (this.rvs == null))
        {
          AppMethodBeat.o(134848);
          return;
        }
        localObject1 = this.appId;
        localObject2 = this.rvs;
        h.ahAA.g(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134840);
            MMToClientEvent.cpz().a(this.rvv, new a() {});
            AppMethodBeat.o(134840);
          }
        }, "MicroMsg.MMToClientEvent");
      }
    }
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(134849);
    this.rvq = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.config = paramParcel.readString();
    this.hzj = paramParcel.readInt();
    try
    {
      this.rvr = paramParcel.readString();
      if (!Util.isNullOrNil(this.rvr))
      {
        Class localClass = Class.forName(this.rvr);
        if (localClass != null) {
          break label108;
        }
        paramParcel.readParcelable(null);
        AppMethodBeat.o(134849);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      for (;;)
      {
        Log.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[] { localClassNotFoundException });
        localObject = null;
      }
      label108:
      this.rvs = paramParcel.readParcelable(localObject.getClassLoader());
      AppMethodBeat.o(134849);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134850);
    paramParcel.writeInt(this.rvq);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.config);
    paramParcel.writeInt(this.hzj);
    paramParcel.writeString(this.rvr);
    paramParcel.writeParcelable((Parcelable)this.rvs, paramInt);
    AppMethodBeat.o(134850);
  }
  
  public static abstract interface c
  {
    public abstract void dL(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent
 * JD-Core Version:    0.7.0.1
 */