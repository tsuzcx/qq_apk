package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b;
import com.tencent.mm.sdk.platformtools.Log;

public class HCEEventLogic
{
  private static String mgS;
  private static boolean mgT;
  private static h.c mgU;
  
  static
  {
    AppMethodBeat.i(136093);
    mgS = null;
    mgT = true;
    mgU = new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(136081);
        Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
        super.a(paramAnonymousd);
        HCEEventLogic.a(HCEEventLogic.mgS, 23, null);
        AppMethodBeat.o(136081);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(136079);
        Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
        super.onCreate();
        HCEEventLogic.a(HCEEventLogic.mgS, 21, null);
        AppMethodBeat.o(136079);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(136082);
        Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
        super.onDestroy();
        HCEEventLogic.a(HCEEventLogic.mgS, 24, null);
        AppMethodBeat.o(136082);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(136080);
        Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
        super.onResume();
        HCEEventLogic.a(HCEEventLogic.mgS, 22, null);
        AppMethodBeat.o(136080);
      }
    };
    AppMethodBeat.o(136093);
  }
  
  public static void a(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(136092);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    Log.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new SendHCEEventToMMTask(paramString, paramInt, localBundle, (byte)0);
    paramString.bDJ();
    AppBrandMainProcessService.a(paramString);
    AppMethodBeat.o(136092);
  }
  
  public static void aau(String paramString)
  {
    AppMethodBeat.i(136090);
    if ((mgS != null) && (mgU != null))
    {
      Log.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[] { mgS });
      h.b(mgS, mgU);
    }
    mgS = paramString;
    h.a(paramString, mgU);
    AppMethodBeat.o(136090);
  }
  
  public static void aav(String paramString)
  {
    AppMethodBeat.i(136091);
    if (paramString != null) {
      h.b(paramString, mgU);
    }
    AppMethodBeat.o(136091);
  }
  
  public static boolean bHI()
  {
    try
    {
      boolean bool = mgT;
      return bool;
    }
    finally {}
  }
  
  public static void hI(boolean paramBoolean)
  {
    try
    {
      mgT = paramBoolean;
      return;
    }
    finally {}
  }
  
  static class SendHCEEventToMMTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SendHCEEventToMMTask> CREATOR;
    private String appId;
    private int mgV;
    private Bundle mgW;
    
    static
    {
      AppMethodBeat.i(136089);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(136089);
    }
    
    protected SendHCEEventToMMTask(Parcel paramParcel)
    {
      AppMethodBeat.i(136084);
      f(paramParcel);
      AppMethodBeat.o(136084);
    }
    
    private SendHCEEventToMMTask(String paramString, int paramInt, Bundle paramBundle)
    {
      this.mgV = paramInt;
      this.appId = paramString;
      this.mgW = paramBundle;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(136085);
      Log.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
      b.mhH.a(this.mgV, this.appId, this.mgW);
      bDU();
      AppMethodBeat.o(136085);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(136086);
      super.bjk();
      bDK();
      AppMethodBeat.o(136086);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(136087);
      super.f(paramParcel);
      this.mgV = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.mgW = paramParcel.readBundle();
      AppMethodBeat.o(136087);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(136088);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mgV);
      paramParcel.writeString(this.appId);
      paramParcel.writeBundle(this.mgW);
      AppMethodBeat.o(136088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic
 * JD-Core Version:    0.7.0.1
 */