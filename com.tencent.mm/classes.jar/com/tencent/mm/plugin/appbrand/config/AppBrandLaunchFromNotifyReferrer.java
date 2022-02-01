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
  public String qYA;
  public int qYB;
  public String qYC;
  public int qYz;
  public int uin;
  
  static
  {
    AppMethodBeat.i(323336);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(323336);
  }
  
  public AppBrandLaunchFromNotifyReferrer() {}
  
  private AppBrandLaunchFromNotifyReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(323329);
    this.appId = paramParcel.readString();
    this.uin = paramParcel.readInt();
    this.qYz = paramParcel.readInt();
    this.qYA = paramParcel.readString();
    this.content = paramParcel.readString();
    this.qYB = paramParcel.readInt();
    this.qYC = paramParcel.readString();
    AppMethodBeat.o(323329);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(323339);
    String str = "AppBrandLaunchFromNotifyReferrer{appId=" + this.appId + ", uin='" + this.uin + '\'' + ", readscene='" + this.qYz + '\'' + ", appbrandPushMsgId='" + this.qYA + '\'' + ", content='" + this.content + '\'' + ", opLocation='" + this.qYB + '\'' + ", reportSessionId='" + this.qYC + '\'' + '}';
    AppMethodBeat.o(323339);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(323345);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.uin);
    paramParcel.writeInt(this.qYz);
    paramParcel.writeString(this.qYA);
    paramParcel.writeString(this.content);
    paramParcel.writeInt(this.qYB);
    paramParcel.writeString(this.qYC);
    AppMethodBeat.o(323345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer
 * JD-Core Version:    0.7.0.1
 */