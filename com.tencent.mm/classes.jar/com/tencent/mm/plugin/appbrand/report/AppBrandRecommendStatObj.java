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
  public long sessionId;
  public String tNS;
  public String tNT;
  public String tNU;
  public String tNV;
  public int tNW;
  public String tNX;
  public String username;
  
  static
  {
    AppMethodBeat.i(123531);
    CREATOR = new AppBrandRecommendStatObj.1();
    AppMethodBeat.o(123531);
  }
  
  public AppBrandRecommendStatObj() {}
  
  public AppBrandRecommendStatObj(Parcel paramParcel)
  {
    AppMethodBeat.i(123528);
    this.username = paramParcel.readString();
    this.tNS = paramParcel.readString();
    this.tNT = paramParcel.readString();
    this.appid = paramParcel.readString();
    this.tNU = paramParcel.readString();
    this.tNV = paramParcel.readString();
    this.tNW = paramParcel.readInt();
    this.tNX = paramParcel.readString();
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
    String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.tNS + '\'' + ", strategy_info=" + this.tNT + ", appid='" + this.appid + '\'' + ", page_path=" + this.tNU + ", page_param=" + this.tNV + ", card_type=" + this.tNW + ", pass_str=" + this.tNX + ", position=" + this.position + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", sessionId=" + this.sessionId + '}';
    AppMethodBeat.o(123529);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123530);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.tNS);
    paramParcel.writeString(this.tNT);
    paramParcel.writeString(this.appid);
    paramParcel.writeString(this.tNU);
    paramParcel.writeString(this.tNV);
    paramParcel.writeInt(this.tNW);
    paramParcel.writeString(this.tNX);
    paramParcel.writeInt(this.position);
    paramParcel.writeFloat(this.longitude);
    paramParcel.writeFloat(this.latitude);
    paramParcel.writeLong(this.sessionId);
    AppMethodBeat.o(123530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj
 * JD-Core Version:    0.7.0.1
 */