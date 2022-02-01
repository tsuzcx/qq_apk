package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundFetchDataParcel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandBackgroundFetchDataParcel> CREATOR;
  public String data;
  public long fpL;
  public int iXp;
  public String path;
  public String query;
  public int scene;
  public String username;
  
  static
  {
    AppMethodBeat.i(44703);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(44703);
  }
  
  public AppBrandBackgroundFetchDataParcel() {}
  
  protected AppBrandBackgroundFetchDataParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(44702);
    this.username = paramParcel.readString();
    this.iXp = paramParcel.readInt();
    this.path = paramParcel.readString();
    this.query = paramParcel.readString();
    this.data = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.fpL = paramParcel.readLong();
    AppMethodBeat.o(44702);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(44701);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.iXp);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.scene);
    paramParcel.writeLong(this.fpL);
    AppMethodBeat.o(44701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataParcel
 * JD-Core Version:    0.7.0.1
 */