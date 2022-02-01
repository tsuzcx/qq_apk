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
  public int jXN;
  public String jXO;
  public int jXP;
  public String jXQ;
  public int uin;
  
  static
  {
    AppMethodBeat.i(190973);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(190973);
  }
  
  public AppBrandLaunchFromNotifyReferrer() {}
  
  private AppBrandLaunchFromNotifyReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(190972);
    this.appId = paramParcel.readString();
    this.uin = paramParcel.readInt();
    this.jXN = paramParcel.readInt();
    this.jXO = paramParcel.readString();
    this.content = paramParcel.readString();
    this.jXP = paramParcel.readInt();
    this.jXQ = paramParcel.readString();
    AppMethodBeat.o(190972);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190970);
    String str = "AppBrandLaunchFromNotifyReferrer{appId=" + this.appId + ", uin='" + this.uin + '\'' + ", readscene='" + this.jXN + '\'' + ", appbrandPushMsgId='" + this.jXO + '\'' + ", content='" + this.content + '\'' + ", opLocation='" + this.jXP + '\'' + ", reportSessionId='" + this.jXQ + '\'' + '}';
    AppMethodBeat.o(190970);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(190971);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.uin);
    paramParcel.writeInt(this.jXN);
    paramParcel.writeString(this.jXO);
    paramParcel.writeString(this.content);
    paramParcel.writeInt(this.jXP);
    paramParcel.writeString(this.jXQ);
    AppMethodBeat.o(190971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer
 * JD-Core Version:    0.7.0.1
 */