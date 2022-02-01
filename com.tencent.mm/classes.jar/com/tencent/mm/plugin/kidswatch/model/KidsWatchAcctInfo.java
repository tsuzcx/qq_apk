package com.tencent.mm.plugin.kidswatch.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KidsWatchAcctInfo
  implements Parcelable
{
  public static final Parcelable.Creator<KidsWatchAcctInfo> CREATOR;
  public int EbN;
  public String deviceName;
  public String lqp;
  public String nickName;
  public String userName;
  
  static
  {
    AppMethodBeat.i(251586);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(251586);
  }
  
  protected KidsWatchAcctInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(251585);
    this.EbN = paramParcel.readInt();
    this.userName = paramParcel.readString();
    this.nickName = paramParcel.readString();
    this.deviceName = paramParcel.readString();
    this.lqp = paramParcel.readString();
    AppMethodBeat.o(251585);
  }
  
  public KidsWatchAcctInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.EbN = paramInt;
    this.userName = paramString1;
    this.nickName = paramString2;
    this.deviceName = paramString4;
    this.lqp = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(251584);
    paramParcel.writeInt(this.EbN);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.nickName);
    paramParcel.writeString(this.deviceName);
    paramParcel.writeString(this.lqp);
    AppMethodBeat.o(251584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.KidsWatchAcctInfo
 * JD-Core Version:    0.7.0.1
 */