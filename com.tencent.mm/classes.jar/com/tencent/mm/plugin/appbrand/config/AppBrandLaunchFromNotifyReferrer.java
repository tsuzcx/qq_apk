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
  public String nYA;
  public int nYx;
  public String nYy;
  public int nYz;
  public int uin;
  
  static
  {
    AppMethodBeat.i(187537);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(187537);
  }
  
  public AppBrandLaunchFromNotifyReferrer() {}
  
  private AppBrandLaunchFromNotifyReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(187533);
    this.appId = paramParcel.readString();
    this.uin = paramParcel.readInt();
    this.nYx = paramParcel.readInt();
    this.nYy = paramParcel.readString();
    this.content = paramParcel.readString();
    this.nYz = paramParcel.readInt();
    this.nYA = paramParcel.readString();
    AppMethodBeat.o(187533);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187528);
    String str = "AppBrandLaunchFromNotifyReferrer{appId=" + this.appId + ", uin='" + this.uin + '\'' + ", readscene='" + this.nYx + '\'' + ", appbrandPushMsgId='" + this.nYy + '\'' + ", content='" + this.content + '\'' + ", opLocation='" + this.nYz + '\'' + ", reportSessionId='" + this.nYA + '\'' + '}';
    AppMethodBeat.o(187528);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(187531);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.uin);
    paramParcel.writeInt(this.nYx);
    paramParcel.writeString(this.nYy);
    paramParcel.writeString(this.content);
    paramParcel.writeInt(this.nYz);
    paramParcel.writeString(this.nYA);
    AppMethodBeat.o(187531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer
 * JD-Core Version:    0.7.0.1
 */