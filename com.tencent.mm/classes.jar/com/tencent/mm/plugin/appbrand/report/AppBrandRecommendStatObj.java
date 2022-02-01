package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandRecommendStatObj
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandRecommendStatObj> CREATOR;
  public String appid;
  public float latitude;
  public float longitude;
  public int position;
  public String qJp;
  public String qJq;
  public String qJr;
  public String qJs;
  public int qJt;
  public String qJu;
  public long sessionId;
  public String username;
  
  static
  {
    AppMethodBeat.i(123531);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(123531);
  }
  
  public AppBrandRecommendStatObj() {}
  
  public AppBrandRecommendStatObj(Parcel paramParcel)
  {
    AppMethodBeat.i(123528);
    this.username = paramParcel.readString();
    this.qJp = paramParcel.readString();
    this.qJq = paramParcel.readString();
    this.appid = paramParcel.readString();
    this.qJr = paramParcel.readString();
    this.qJs = paramParcel.readString();
    this.qJt = paramParcel.readInt();
    this.qJu = paramParcel.readString();
    this.position = paramParcel.readInt();
    this.longitude = paramParcel.readFloat();
    this.latitude = paramParcel.readFloat();
    this.sessionId = paramParcel.readLong();
    AppMethodBeat.o(123528);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(123529);
    String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.qJp + '\'' + ", strategy_info=" + this.qJq + ", appid='" + this.appid + '\'' + ", page_path=" + this.qJr + ", page_param=" + this.qJs + ", card_type=" + this.qJt + ", pass_str=" + this.qJu + ", position=" + this.position + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", sessionId=" + this.sessionId + '}';
    AppMethodBeat.o(123529);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123530);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.qJp);
    paramParcel.writeString(this.qJq);
    paramParcel.writeString(this.appid);
    paramParcel.writeString(this.qJr);
    paramParcel.writeString(this.qJs);
    paramParcel.writeInt(this.qJt);
    paramParcel.writeString(this.qJu);
    paramParcel.writeInt(this.position);
    paramParcel.writeFloat(this.longitude);
    paramParcel.writeFloat(this.latitude);
    paramParcel.writeLong(this.sessionId);
    AppMethodBeat.o(123530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj
 * JD-Core Version:    0.7.0.1
 */