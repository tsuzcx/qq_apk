package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundApp;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class WCBluetoothBackgroundApp
  implements Parcelable
{
  public static final Parcelable.Creator<WCBluetoothBackgroundApp> CREATOR;
  final String appId;
  final int euz;
  
  static
  {
    AppMethodBeat.i(329599);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(329599);
  }
  
  public WCBluetoothBackgroundApp(String paramString, int paramInt)
  {
    AppMethodBeat.i(329594);
    this.appId = paramString;
    this.euz = paramInt;
    AppMethodBeat.o(329594);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(329613);
    if (this == paramObject)
    {
      AppMethodBeat.o(329613);
      return true;
    }
    if (!(paramObject instanceof WCBluetoothBackgroundApp))
    {
      AppMethodBeat.o(329613);
      return false;
    }
    paramObject = (WCBluetoothBackgroundApp)paramObject;
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(329613);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(329613);
      return false;
    }
    AppMethodBeat.o(329613);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(329610);
    int i = this.appId.hashCode();
    int j = this.euz;
    AppMethodBeat.o(329610);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(329604);
    String str = "WCBluetoothBackgroundApp(appId=" + this.appId + ", versionType=" + this.euz + ')';
    AppMethodBeat.o(329604);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(329622);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    AppMethodBeat.o(329622);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<WCBluetoothBackgroundApp>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.WCBluetoothBackgroundApp
 * JD-Core Version:    0.7.0.1
 */