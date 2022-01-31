package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

final class JsApiUpdateApp$SyncRequest
  implements Parcelable
{
  public static final Parcelable.Creator<SyncRequest> CREATOR;
  private AppBrandInitConfigWC ibA;
  private AppBrandStatObject ibB;
  
  static
  {
    AppMethodBeat.i(138133);
    CREATOR = new JsApiUpdateApp.SyncRequest.1();
    AppMethodBeat.o(138133);
  }
  
  protected JsApiUpdateApp$SyncRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(138132);
    this.ibA = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.ibB = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    AppMethodBeat.o(138132);
  }
  
  public JsApiUpdateApp$SyncRequest(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this.ibA = paramAppBrandInitConfigWC;
    this.ibB = paramAppBrandStatObject;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(138131);
    paramParcel.writeParcelable(this.ibA, paramInt);
    paramParcel.writeParcelable(this.ibB, paramInt);
    AppMethodBeat.o(138131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.SyncRequest
 * JD-Core Version:    0.7.0.1
 */