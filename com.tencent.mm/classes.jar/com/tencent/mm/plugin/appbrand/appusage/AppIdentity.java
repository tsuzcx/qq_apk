package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppIdentity
  implements Parcelable
{
  public static final Parcelable.Creator<AppIdentity> CREATOR;
  public final int hxM;
  public final String username;
  
  static
  {
    AppMethodBeat.i(44631);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(44631);
  }
  
  protected AppIdentity(Parcel paramParcel)
  {
    AppMethodBeat.i(44630);
    this.username = paramParcel.readString();
    this.hxM = paramParcel.readInt();
    AppMethodBeat.o(44630);
  }
  
  public AppIdentity(String paramString, int paramInt)
  {
    this.username = paramString;
    this.hxM = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(44629);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.hxM);
    AppMethodBeat.o(44629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppIdentity
 * JD-Core Version:    0.7.0.1
 */