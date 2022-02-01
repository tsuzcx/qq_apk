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
  public int kbc;
  public String kbd;
  public int kbe;
  public String kbf;
  public int uin;
  
  static
  {
    AppMethodBeat.i(200324);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(200324);
  }
  
  public AppBrandLaunchFromNotifyReferrer() {}
  
  private AppBrandLaunchFromNotifyReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(200323);
    this.appId = paramParcel.readString();
    this.uin = paramParcel.readInt();
    this.kbc = paramParcel.readInt();
    this.kbd = paramParcel.readString();
    this.content = paramParcel.readString();
    this.kbe = paramParcel.readInt();
    this.kbf = paramParcel.readString();
    AppMethodBeat.o(200323);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200321);
    String str = "AppBrandLaunchFromNotifyReferrer{appId=" + this.appId + ", uin='" + this.uin + '\'' + ", readscene='" + this.kbc + '\'' + ", appbrandPushMsgId='" + this.kbd + '\'' + ", content='" + this.content + '\'' + ", opLocation='" + this.kbe + '\'' + ", reportSessionId='" + this.kbf + '\'' + '}';
    AppMethodBeat.o(200321);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(200322);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.uin);
    paramParcel.writeInt(this.kbc);
    paramParcel.writeString(this.kbd);
    paramParcel.writeString(this.content);
    paramParcel.writeInt(this.kbe);
    paramParcel.writeString(this.kbf);
    AppMethodBeat.o(200322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer
 * JD-Core Version:    0.7.0.1
 */