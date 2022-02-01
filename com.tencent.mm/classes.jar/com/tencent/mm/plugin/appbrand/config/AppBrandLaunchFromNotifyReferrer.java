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
  public int jDM;
  public String jDN;
  public int jDO;
  public String jDP;
  public int uin;
  
  static
  {
    AppMethodBeat.i(194851);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(194851);
  }
  
  public AppBrandLaunchFromNotifyReferrer() {}
  
  private AppBrandLaunchFromNotifyReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(194850);
    this.appId = paramParcel.readString();
    this.uin = paramParcel.readInt();
    this.jDM = paramParcel.readInt();
    this.jDN = paramParcel.readString();
    this.content = paramParcel.readString();
    this.jDO = paramParcel.readInt();
    this.jDP = paramParcel.readString();
    AppMethodBeat.o(194850);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194848);
    String str = "AppBrandLaunchFromNotifyReferrer{appId=" + this.appId + ", uin='" + this.uin + '\'' + ", readscene='" + this.jDM + '\'' + ", appbrandPushMsgId='" + this.jDN + '\'' + ", content='" + this.content + '\'' + ", opLocation='" + this.jDO + '\'' + ", reportSessionId='" + this.jDP + '\'' + '}';
    AppMethodBeat.o(194848);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(194849);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.uin);
    paramParcel.writeInt(this.jDM);
    paramParcel.writeString(this.jDN);
    paramParcel.writeString(this.content);
    paramParcel.writeInt(this.jDO);
    paramParcel.writeString(this.jDP);
    AppMethodBeat.o(194849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer
 * JD-Core Version:    0.7.0.1
 */