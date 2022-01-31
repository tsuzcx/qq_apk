package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

final class JsApiUpdateApp$SyncResult
  implements Parcelable
{
  public static final Parcelable.Creator<SyncResult> CREATOR;
  private AppBrandInitConfigWC ibA;
  private boolean ibC;
  
  static
  {
    AppMethodBeat.i(131495);
    CREATOR = new JsApiUpdateApp.SyncResult.1();
    AppMethodBeat.o(131495);
  }
  
  JsApiUpdateApp$SyncResult(Parcel paramParcel)
  {
    AppMethodBeat.i(131494);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ibC = bool;
      this.ibA = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      AppMethodBeat.o(131494);
      return;
    }
  }
  
  JsApiUpdateApp$SyncResult(boolean paramBoolean, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    this.ibC = paramBoolean;
    this.ibA = paramAppBrandInitConfigWC;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131493);
    if (this.ibC) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.ibA, 0);
      AppMethodBeat.o(131493);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.SyncResult
 * JD-Core Version:    0.7.0.1
 */