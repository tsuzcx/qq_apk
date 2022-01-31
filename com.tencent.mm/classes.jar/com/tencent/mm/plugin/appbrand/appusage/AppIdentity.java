package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppIdentity
  implements Parcelable
{
  public static final Parcelable.Creator<AppIdentity> CREATOR;
  public final int hcr;
  public final String username;
  
  static
  {
    AppMethodBeat.i(129698);
    CREATOR = new AppIdentity.1();
    AppMethodBeat.o(129698);
  }
  
  protected AppIdentity(Parcel paramParcel)
  {
    AppMethodBeat.i(129697);
    this.username = paramParcel.readString();
    this.hcr = paramParcel.readInt();
    AppMethodBeat.o(129697);
  }
  
  public AppIdentity(String paramString, int paramInt)
  {
    this.username = paramString;
    this.hcr = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(129696);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.hcr);
    AppMethodBeat.o(129696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppIdentity
 * JD-Core Version:    0.7.0.1
 */