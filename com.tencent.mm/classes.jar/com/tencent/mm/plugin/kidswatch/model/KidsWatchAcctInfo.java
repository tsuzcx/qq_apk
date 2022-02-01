package com.tencent.mm.plugin.kidswatch.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KidsWatchAcctInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KidsWatchAcctInfo> CREATOR;
  public int JSV;
  public String deviceName;
  public String nVs;
  public String nickName;
  public String userName;
  
  static
  {
    AppMethodBeat.i(262294);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(262294);
  }
  
  protected KidsWatchAcctInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(262287);
    this.JSV = paramParcel.readInt();
    this.userName = paramParcel.readString();
    this.nickName = paramParcel.readString();
    this.deviceName = paramParcel.readString();
    this.nVs = paramParcel.readString();
    AppMethodBeat.o(262287);
  }
  
  public KidsWatchAcctInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.JSV = paramInt;
    this.userName = paramString1;
    this.nickName = paramString2;
    this.deviceName = paramString4;
    this.nVs = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(262308);
    paramParcel.writeInt(this.JSV);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.deviceName);
    paramParcel.writeString(this.nVs);
    AppMethodBeat.o(262308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo
 * JD-Core Version:    0.7.0.1
 */