package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;

public class HCEEventLogic
{
  private static String skr;
  private static boolean sks;
  private static k.c skt;
  
  static
  {
    AppMethodBeat.i(136093);
    skr = null;
    sks = true;
    skt = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(136081);
        Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
        super.a(paramAnonymousd);
        HCEEventLogic.a(HCEEventLogic.skr, 23, null);
        AppMethodBeat.o(136081);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(136079);
        Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
        super.onCreate();
        HCEEventLogic.a(HCEEventLogic.skr, 21, null);
        AppMethodBeat.o(136079);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(136082);
        Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
        super.onDestroy();
        HCEEventLogic.a(HCEEventLogic.skr, 24, null);
        AppMethodBeat.o(136082);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(136080);
        Log.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
        super.onResume();
        HCEEventLogic.a(HCEEventLogic.skr, 22, null);
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
    new SendHCEEventToMMTask(paramString, paramInt, localBundle, (byte)0).bQt();
    AppMethodBeat.o(136092);
  }
  
  public static void abj(String paramString)
  {
    AppMethodBeat.i(136090);
    if ((skr != null) && (skt != null))
    {
      Log.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[] { skr });
      k.b(skr, skt);
    }
    skr = paramString;
    k.a(paramString, skt);
    AppMethodBeat.o(136090);
  }
  
  public static void abk(String paramString)
  {
    AppMethodBeat.i(136091);
    if (paramString != null) {
      k.b(paramString, skt);
    }
    AppMethodBeat.o(136091);
  }
  
  public static boolean ctw()
  {
    try
    {
      boolean bool = sks;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void jC(boolean paramBoolean)
  {
    try
    {
      sks = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static class SendHCEEventToMMTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SendHCEEventToMMTask> CREATOR;
    private String appId;
    private int sku;
    private Bundle skv;
    
    static
    {
      AppMethodBeat.i(136089);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(136089);
    }
    
    protected SendHCEEventToMMTask(Parcel paramParcel)
    {
      AppMethodBeat.i(136084);
      h(paramParcel);
      AppMethodBeat.o(136084);
    }
    
    private SendHCEEventToMMTask(String paramString, int paramInt, Bundle paramBundle)
    {
      this.sku = paramInt;
      this.appId = paramString;
      this.skv = paramBundle;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(136085);
      Log.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
      b.slg.a(this.sku, this.appId, this.skv);
      cpA();
      AppMethodBeat.o(136085);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(136086);
      super.bQr();
      cpx();
      AppMethodBeat.o(136086);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(136087);
      super.h(paramParcel);
      this.sku = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.skv = paramParcel.readBundle();
      AppMethodBeat.o(136087);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(136088);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.sku);
      paramParcel.writeString(this.appId);
      paramParcel.writeBundle(this.skv);
      AppMethodBeat.o(136088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic
 * JD-Core Version:    0.7.0.1
 */