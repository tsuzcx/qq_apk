package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.core.f.a;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent
  extends MainProcessTask
{
  public static final Parcelable.Creator<MMToClientEvent> CREATOR;
  private static final com.tencent.mm.plugin.appbrand.ac.h<String, c> orA;
  private static final HashMap<String, MMToClientEvent> orz;
  public String appId;
  String config;
  int fuP;
  private com.tencent.mm.plugin.appbrand.jsapi.e okQ;
  public int orw;
  String orx;
  Object ory;
  public int type;
  
  static
  {
    AppMethodBeat.i(134851);
    orz = new HashMap();
    orA = new com.tencent.mm.plugin.appbrand.ac.h();
    CREATOR = new MMToClientEvent.2();
    AppMethodBeat.o(134851);
  }
  
  private MMToClientEvent() {}
  
  private MMToClientEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(134842);
    f(paramParcel);
    AppMethodBeat.o(134842);
  }
  
  public static void a(String paramString, c paramc)
  {
    AppMethodBeat.i(134846);
    if (paramc != null) {
      orA.k(paramString, paramc);
    }
    AppMethodBeat.o(134846);
  }
  
  public static boolean agJ(String paramString)
  {
    AppMethodBeat.i(174745);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174745);
      return false;
    }
    if (orz.get(paramString) != null)
    {
      AppMethodBeat.o(174745);
      return true;
    }
    AppMethodBeat.o(174745);
    return false;
  }
  
  public static void agK(String paramString)
  {
    AppMethodBeat.i(174746);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(174746);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    orz.put(paramString, localMMToClientEvent);
    localMMToClientEvent.orw = 1;
    localMMToClientEvent.appId = paramString;
    localMMToClientEvent.bsM();
    AppMethodBeat.o(174746);
  }
  
  public static void agL(String paramString)
  {
    AppMethodBeat.i(275882);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(275882);
      return;
    }
    MMToClientEvent localMMToClientEvent = (MMToClientEvent)orz.remove(paramString);
    if (localMMToClientEvent == null)
    {
      AppMethodBeat.o(275882);
      return;
    }
    orA.cO(paramString);
    localMMToClientEvent.orw = 2;
    localMMToClientEvent.appId = paramString;
    localMMToClientEvent.okQ = null;
    if (MMApplicationContext.isMMProcessExist()) {
      try
      {
        localMMToClientEvent.bPu();
        AppMethodBeat.o(275882);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        Log.e("MicroMsg.MMToClientEvent", "unregisterToMM(%s) get exception:%s", new Object[] { paramString, localSecurityException });
      }
    }
    AppMethodBeat.o(275882);
  }
  
  public static void b(String paramString, c paramc)
  {
    AppMethodBeat.i(134847);
    if (paramc != null) {
      orA.D(paramString, paramc);
    }
    AppMethodBeat.o(134847);
  }
  
  public static void g(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(134844);
    if (parame == null)
    {
      AppMethodBeat.o(134844);
      return;
    }
    MMToClientEvent localMMToClientEvent = new MMToClientEvent();
    orz.put(parame.getAppId(), localMMToClientEvent);
    localMMToClientEvent.orw = 1;
    localMMToClientEvent.appId = parame.getAppId();
    localMMToClientEvent.okQ = parame;
    localMMToClientEvent.bsM();
    AppMethodBeat.o(134844);
  }
  
  public static void h(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(134845);
    if (parame == null)
    {
      AppMethodBeat.o(134845);
      return;
    }
    agL(parame.getAppId());
    AppMethodBeat.o(134845);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(134843);
    switch (this.orw)
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
  
  public final void bsK()
  {
    AppMethodBeat.i(134848);
    switch (this.orw)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134848);
      return;
      if (this.okQ != null)
      {
        Object localObject1 = new a();
        final Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("type", Integer.valueOf(this.type));
        ((HashMap)localObject2).put("data", this.config);
        ((a)localObject1).i(this.okQ).D((Map)localObject2).bPO();
        AppMethodBeat.o(134848);
        return;
        localObject1 = new b();
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("count", Integer.valueOf(this.fuP));
        ((HashMap)localObject2).put("data", this.config);
        ((b)localObject1).i(this.okQ).D((Map)localObject2).bPO();
        AppMethodBeat.o(134848);
        return;
        if ((this.appId == null) || (this.ory == null))
        {
          AppMethodBeat.o(134848);
          return;
        }
        localObject1 = this.appId;
        localObject2 = this.ory;
        com.tencent.e.h.ZvG.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(134840);
            Object localObject = MMToClientEvent.bPs();
            String str = this.orB;
            a local1 = new a() {};
            if (str == null)
            {
              AppMethodBeat.o(134840);
              return;
            }
            localObject = ((com.tencent.mm.plugin.appbrand.ac.h)localObject).cN(str).iterator();
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
    this.orw = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.config = paramParcel.readString();
    this.fuP = paramParcel.readInt();
    try
    {
      this.orx = paramParcel.readString();
      if (!Util.isNullOrNil(this.orx))
      {
        Class localClass = Class.forName(this.orx);
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
      this.ory = paramParcel.readParcelable(localObject.getClassLoader());
      AppMethodBeat.o(134849);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134850);
    paramParcel.writeInt(this.orw);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.config);
    paramParcel.writeInt(this.fuP);
    paramParcel.writeString(this.orx);
    paramParcel.writeParcelable((Parcelable)this.ory, paramInt);
    AppMethodBeat.o(134850);
  }
  
  public static final class a
    extends r
  {
    private static final int CTRL_INDEX = 109;
    private static final String NAME = "onAppConfig";
  }
  
  public static final class b
    extends r
  {
    private static final int CTRL_INDEX = 152;
    private static final String NAME = "onContactMessageCountChange";
  }
  
  public static abstract interface c
  {
    public abstract void cq(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent
 * JD-Core Version:    0.7.0.1
 */