package com.tencent.mm.plugin.kidswatch.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KidsWatchAcctInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KidsWatchAcctInfo> CREATOR;
  public String deviceName;
  public String iAR;
  public String nickName;
  public String userName;
  public int yAy;
  
  static
  {
    AppMethodBeat.i(256397);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(256397);
  }
  
  protected KidsWatchAcctInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(256396);
    this.yAy = paramParcel.readInt();
    this.userName = paramParcel.readString();
    this.nickName = paramParcel.readString();
    this.deviceName = paramParcel.readString();
    this.iAR = paramParcel.readString();
    AppMethodBeat.o(256396);
  }
  
  public KidsWatchAcctInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.yAy = paramInt;
    this.userName = paramString1;
    this.nickName = paramString2;
    this.deviceName = paramString4;
    this.iAR = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(256395);
    paramParcel.writeInt(this.yAy);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.deviceName);
    paramParcel.writeString(this.iAR);
    AppMethodBeat.o(256395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo
 * JD-Core Version:    0.7.0.1
 */