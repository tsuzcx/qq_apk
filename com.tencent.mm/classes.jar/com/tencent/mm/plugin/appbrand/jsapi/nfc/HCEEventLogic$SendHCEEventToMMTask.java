package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ab;

class HCEEventLogic$SendHCEEventToMMTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SendHCEEventToMMTask> CREATOR;
  private String appId;
  private int hUp;
  private Bundle hUq;
  
  static
  {
    AppMethodBeat.i(137854);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(137854);
  }
  
  protected HCEEventLogic$SendHCEEventToMMTask(Parcel paramParcel)
  {
    AppMethodBeat.i(137849);
    f(paramParcel);
    AppMethodBeat.o(137849);
  }
  
  private HCEEventLogic$SendHCEEventToMMTask(String paramString, int paramInt, Bundle paramBundle)
  {
    this.hUp = paramInt;
    this.appId = paramString;
    this.hUq = paramBundle;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(137850);
    ab.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
    b.hVa.a(this.hUp, this.appId, this.hUq);
    aBp();
    AppMethodBeat.o(137850);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(137851);
    super.atb();
    h.ai(this);
    AppMethodBeat.o(137851);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(137852);
    super.f(paramParcel);
    this.hUp = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.hUq = paramParcel.readBundle();
    AppMethodBeat.o(137852);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137853);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.hUp);
    paramParcel.writeString(this.appId);
    paramParcel.writeBundle(this.hUq);
    AppMethodBeat.o(137853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.SendHCEEventToMMTask
 * JD-Core Version:    0.7.0.1
 */