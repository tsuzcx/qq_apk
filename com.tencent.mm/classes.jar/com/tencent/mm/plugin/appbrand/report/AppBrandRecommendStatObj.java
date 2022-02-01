package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandRecommendStatObj
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandRecommendStatObj> CREATOR;
  public String dlB;
  public float dpb;
  public float dqQ;
  public String lpA;
  public String lpv;
  public String lpw;
  public String lpx;
  public String lpy;
  public int lpz;
  public int position;
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
    this.lpv = paramParcel.readString();
    this.lpw = paramParcel.readString();
    this.dlB = paramParcel.readString();
    this.lpx = paramParcel.readString();
    this.lpy = paramParcel.readString();
    this.lpz = paramParcel.readInt();
    this.lpA = paramParcel.readString();
    this.position = paramParcel.readInt();
    this.dqQ = paramParcel.readFloat();
    this.dpb = paramParcel.readFloat();
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
    String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.lpv + '\'' + ", strategy_info=" + this.lpw + ", appid='" + this.dlB + '\'' + ", page_path=" + this.lpx + ", page_param=" + this.lpy + ", card_type=" + this.lpz + ", pass_str=" + this.lpA + ", position=" + this.position + ", longitude=" + this.dqQ + ", latitude=" + this.dpb + ", sessionId=" + this.sessionId + '}';
    AppMethodBeat.o(123529);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123530);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.lpv);
    paramParcel.writeString(this.lpw);
    paramParcel.writeString(this.dlB);
    paramParcel.writeString(this.lpx);
    paramParcel.writeString(this.lpy);
    paramParcel.writeInt(this.lpz);
    paramParcel.writeString(this.lpA);
    paramParcel.writeInt(this.position);
    paramParcel.writeFloat(this.dqQ);
    paramParcel.writeFloat(this.dpb);
    paramParcel.writeLong(this.sessionId);
    AppMethodBeat.o(123530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj
 * JD-Core Version:    0.7.0.1
 */