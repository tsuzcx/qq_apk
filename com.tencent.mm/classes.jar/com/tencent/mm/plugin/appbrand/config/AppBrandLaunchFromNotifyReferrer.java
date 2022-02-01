package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandLaunchFromNotifyReferrer
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandLaunchFromNotifyReferrer> CREATOR;
  public String appId;
  public String content;
  public String jdA;
  public int jdB;
  public int jdz;
  public int uin;
  
  static
  {
    AppMethodBeat.i(187824);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(187824);
  }
  
  public AppBrandLaunchFromNotifyReferrer() {}
  
  private AppBrandLaunchFromNotifyReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(187823);
    this.appId = paramParcel.readString();
    this.uin = paramParcel.readInt();
    this.jdz = paramParcel.readInt();
    this.jdA = paramParcel.readString();
    this.content = paramParcel.readString();
    this.jdB = paramParcel.readInt();
    AppMethodBeat.o(187823);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187821);
    String str = "AppBrandLaunchFromNotifyReferrer{appId=" + this.appId + ", uin='" + this.uin + '\'' + ", readscene='" + this.jdz + '\'' + ", appbrandPushMsgId='" + this.jdA + '\'' + ", content='" + this.content + '\'' + ", opLocation='" + this.jdB + '\'' + '}';
    AppMethodBeat.o(187821);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(187822);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.uin);
    paramParcel.writeInt(this.jdz);
    paramParcel.writeString(this.jdA);
    paramParcel.writeString(this.content);
    paramParcel.writeInt(this.jdB);
    AppMethodBeat.o(187822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer
 * JD-Core Version:    0.7.0.1
 */