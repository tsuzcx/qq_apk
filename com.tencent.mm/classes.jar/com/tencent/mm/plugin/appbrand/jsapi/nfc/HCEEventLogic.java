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
import com.tencent.mm.sdk.platformtools.ad;

public class HCEEventLogic
{
  private static String kaY;
  private static boolean kaZ;
  private static g.c kba;
  
  static
  {
    AppMethodBeat.i(136093);
    kaY = null;
    kaZ = true;
    kba = new g.c()
    {
      public final void a(g.d paramAnonymousd)
      {
        AppMethodBeat.i(136081);
        ad.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
        super.a(paramAnonymousd);
        HCEEventLogic.a(HCEEventLogic.kaY, 23, null);
        AppMethodBeat.o(136081);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(136079);
        ad.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
        super.onCreate();
        HCEEventLogic.a(HCEEventLogic.kaY, 21, null);
        AppMethodBeat.o(136079);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(136082);
        ad.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
        super.onDestroy();
        HCEEventLogic.a(HCEEventLogic.kaY, 24, null);
        AppMethodBeat.o(136082);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(136080);
        ad.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
        super.onResume();
        HCEEventLogic.a(HCEEventLogic.kaY, 22, null);
        AppMethodBeat.o(136080);
      }
    };
    AppMethodBeat.o(136093);
  }
  
  public static void IM(String paramString)
  {
    AppMethodBeat.i(136090);
    if ((kaY != null) && (kba != null))
    {
      ad.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[] { kaY });
      g.b(kaY, kba);
    }
    kaY = paramString;
    g.a(paramString, kba);
    AppMethodBeat.o(136090);
  }
  
  public static void IN(String paramString)
  {
    AppMethodBeat.i(136091);
    if (paramString != null) {
      g.b(paramString, kba);
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
    ad.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = new SendHCEEventToMMTask(paramString, paramInt, localBundle, (byte)0);
    paramString.aXm();
    AppBrandMainProcessService.a(paramString);
    AppMethodBeat.o(136092);
  }
  
  public static boolean bbb()
  {
    try
    {
      boolean bool = kaZ;
      return bool;
    }
    finally {}
  }
  
  public static void gk(boolean paramBoolean)
  {
    try
    {
      kaZ = paramBoolean;
      return;
    }
    finally {}
  }
  
  static class SendHCEEventToMMTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SendHCEEventToMMTask> CREATOR;
    private String appId;
    private int kbb;
    private Bundle kbc;
    
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
      this.kbb = paramInt;
      this.appId = paramString;
      this.kbc = paramBundle;
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(136086);
      super.aEA();
      aXn();
      AppMethodBeat.o(136086);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(136085);
      ad.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
      b.kbN.a(this.kbb, this.appId, this.kbc);
      aXw();
      AppMethodBeat.o(136085);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(136087);
      super.e(paramParcel);
      this.kbb = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.kbc = paramParcel.readBundle();
      AppMethodBeat.o(136087);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(136088);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.kbb);
      paramParcel.writeString(this.appId);
      paramParcel.writeBundle(this.kbc);
      AppMethodBeat.o(136088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic
 * JD-Core Version:    0.7.0.1
 */