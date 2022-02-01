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
  public int lej;
  public String lek;
  public int lel;
  public String lem;
  public int uin;
  
  static
  {
    AppMethodBeat.i(225280);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(225280);
  }
  
  public AppBrandLaunchFromNotifyReferrer() {}
  
  private AppBrandLaunchFromNotifyReferrer(Parcel paramParcel)
  {
    AppMethodBeat.i(225279);
    this.appId = paramParcel.readString();
    this.uin = paramParcel.readInt();
    this.lej = paramParcel.readInt();
    this.lek = paramParcel.readString();
    this.content = paramParcel.readString();
    this.lel = paramParcel.readInt();
    this.lem = paramParcel.readString();
    AppMethodBeat.o(225279);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225277);
    String str = "AppBrandLaunchFromNotifyReferrer{appId=" + this.appId + ", uin='" + this.uin + '\'' + ", readscene='" + this.lej + '\'' + ", appbrandPushMsgId='" + this.lek + '\'' + ", content='" + this.content + '\'' + ", opLocation='" + this.lel + '\'' + ", reportSessionId='" + this.lem + '\'' + '}';
    AppMethodBeat.o(225277);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(225278);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.uin);
    paramParcel.writeInt(this.lej);
    paramParcel.writeString(this.lek);
    paramParcel.writeString(this.content);
    paramParcel.writeInt(this.lel);
    paramParcel.writeString(this.lem);
    AppMethodBeat.o(225278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer
 * JD-Core Version:    0.7.0.1
 */