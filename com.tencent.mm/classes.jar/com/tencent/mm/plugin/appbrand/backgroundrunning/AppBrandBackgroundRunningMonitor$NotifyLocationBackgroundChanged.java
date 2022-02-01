package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AppBrandBackgroundRunningMonitor$NotifyLocationBackgroundChanged
  implements Parcelable
{
  public static final Parcelable.Creator<NotifyLocationBackgroundChanged> CREATOR;
  public String appId;
  public boolean kYn;
  
  static
  {
    AppMethodBeat.i(44780);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(44780);
  }
  
  protected AppBrandBackgroundRunningMonitor$NotifyLocationBackgroundChanged(Parcel paramParcel)
  {
    AppMethodBeat.i(44778);
    this.appId = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.kYn = bool;
      AppMethodBeat.o(44778);
      return;
    }
  }
  
  public AppBrandBackgroundRunningMonitor$NotifyLocationBackgroundChanged(String paramString)
  {
    this.appId = paramString;
    this.kYn = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(44779);
    paramParcel.writeString(this.appId);
    if (this.kYn) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(44779);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor.NotifyLocationBackgroundChanged
 * JD-Core Version:    0.7.0.1
 */