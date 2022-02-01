package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b;
import com.tencent.mm.sdk.platformtools.ac;

public class HCEEventLogic
{
  private static String kBL;
  private static boolean kBM;
  private static g.c kBN;
  
  static
  {
    AppMethodBeat.i(136093);
    kBL = null;
    kBM = true;
    kBN = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(136081);
        ac.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
        super.a(paramAnonymousd);
        HCEEventLogic.a(HCEEventLogic.kBL, 23, null);
        AppMethodBeat.o(136081);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(136079);
        ac.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
        super.onCreate();
        HCEEventLogic.a(HCEEventLogic.kBL, 21, null);
        AppMethodBeat.o(136079);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(136082);
        ac.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
        super.onDestroy();
        HCEEventLogic.a(HCEEventLogic.kBL, 24, null);
        AppMethodBeat.o(136082);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(136080);
        ac.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
        super.onResume();
        HCEEventLogic.a(HCEEventLogic.kBL, 22, null);
        AppMethodBeat.o(136080);
      }
    };
    AppMethodBeat.o(136093);
  }
  
  public static void MN(String paramString)
  {
    AppMethodBeat.i(136090);
    if ((kBL != null) && (kBN != null))
    {
      ac.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[] { kBL });
      g.b(kBL, kBN);
    }
    kBL = paramString;
    g.a(paramString, kBN);
    AppMethodBeat.o(136090);
  }
  
  public static void MO(String paramString)
  {
    AppMethodBeat.i(136091);
    if (paramString != null) {
      g.b(paramString, kBN);
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
    ac.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new SendHCEEventToMMTask(paramString, paramInt, localBundle, (byte)0);
    paramString.bej();
    AppBrandMainProcessService.a(paramString);
    AppMethodBeat.o(136092);
  }
  
  public static boolean bhT()
  {
    try
    {
      boolean bool = kBM;
      return bool;
    }
    finally {}
  }
  
  public static void gG(boolean paramBoolean)
  {
    try
    {
      kBM = paramBoolean;
      return;
    }
    finally {}
  }
  
  static class SendHCEEventToMMTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SendHCEEventToMMTask> CREATOR;
    private String appId;
    private int kBO;
    private Bundle kBP;
    
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
      this.kBO = paramInt;
      this.appId = paramString;
      this.kBP = paramBundle;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(136085);
      ac.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
      b.kCA.a(this.kBO, this.appId, this.kBP);
      bet();
      AppMethodBeat.o(136085);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(136086);
      super.aLr();
      bek();
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
      this.kBO = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.kBP = paramParcel.readBundle();
      AppMethodBeat.o(136087);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(136088);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.kBO);
      paramParcel.writeString(this.appId);
      paramParcel.writeBundle(this.kBP);
      AppMethodBeat.o(136088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic
 * JD-Core Version:    0.7.0.1
 */