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
import com.tencent.mm.sdk.platformtools.ae;

public class HCEEventLogic
{
  private static String lbB;
  private static boolean lbC;
  private static h.c lbD;
  
  static
  {
    AppMethodBeat.i(136093);
    lbB = null;
    lbC = true;
    lbD = new h.c()
    {
      public final void a(h.d paramAnonymousd)
      {
        AppMethodBeat.i(136081);
        ae.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
        super.a(paramAnonymousd);
        HCEEventLogic.a(HCEEventLogic.lbB, 23, null);
        AppMethodBeat.o(136081);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(136079);
        ae.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
        super.onCreate();
        HCEEventLogic.a(HCEEventLogic.lbB, 21, null);
        AppMethodBeat.o(136079);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(136082);
        ae.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
        super.onDestroy();
        HCEEventLogic.a(HCEEventLogic.lbB, 24, null);
        AppMethodBeat.o(136082);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(136080);
        ae.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
        super.onResume();
        HCEEventLogic.a(HCEEventLogic.lbB, 22, null);
        AppMethodBeat.o(136080);
      }
    };
    AppMethodBeat.o(136093);
  }
  
  public static void QT(String paramString)
  {
    AppMethodBeat.i(136090);
    if ((lbB != null) && (lbD != null))
    {
      ae.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[] { lbB });
      h.b(lbB, lbD);
    }
    lbB = paramString;
    h.a(paramString, lbD);
    AppMethodBeat.o(136090);
  }
  
  public static void QU(String paramString)
  {
    AppMethodBeat.i(136091);
    if (paramString != null) {
      h.b(paramString, lbD);
    }
    AppMethodBeat.o(136091);
  }
  
  public static void a(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(136092);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    ae.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new SendHCEEventToMMTask(paramString, paramInt, localBundle, (byte)0);
    paramString.biw();
    AppBrandMainProcessService.a(paramString);
    AppMethodBeat.o(136092);
  }
  
  public static boolean bmj()
  {
    try
    {
      boolean bool = lbC;
      return bool;
    }
    finally {}
  }
  
  public static void gL(boolean paramBoolean)
  {
    try
    {
      lbC = paramBoolean;
      return;
    }
    finally {}
  }
  
  static class SendHCEEventToMMTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SendHCEEventToMMTask> CREATOR;
    private String appId;
    private int lbE;
    private Bundle lbF;
    
    static
    {
      AppMethodBeat.i(136089);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(136089);
    }
    
    protected SendHCEEventToMMTask(Parcel paramParcel)
    {
      AppMethodBeat.i(136084);
      e(paramParcel);
      AppMethodBeat.o(136084);
    }
    
    private SendHCEEventToMMTask(String paramString, int paramInt, Bundle paramBundle)
    {
      this.lbE = paramInt;
      this.appId = paramString;
      this.lbF = paramBundle;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(136085);
      ae.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
      b.lcq.a(this.lbE, this.appId, this.lbF);
      biG();
      AppMethodBeat.o(136085);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(136086);
      super.aOY();
      bix();
      AppMethodBeat.o(136086);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(136087);
      super.e(paramParcel);
      this.lbE = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.lbF = paramParcel.readBundle();
      AppMethodBeat.o(136087);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(136088);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.lbE);
      paramParcel.writeString(this.appId);
      paramParcel.writeBundle(this.lbF);
      AppMethodBeat.o(136088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic
 * JD-Core Version:    0.7.0.1
 */