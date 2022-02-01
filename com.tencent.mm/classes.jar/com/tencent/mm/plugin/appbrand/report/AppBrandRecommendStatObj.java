package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandRecommendStatObj
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandRecommendStatObj> CREATOR;
  public float dAp;
  public String duW;
  public float dyz;
  public String mrh;
  public String mri;
  public String mrj;
  public String mrk;
  public int mrl;
  public String mrm;
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
    this.mrh = paramParcel.readString();
    this.mri = paramParcel.readString();
    this.duW = paramParcel.readString();
    this.mrj = paramParcel.readString();
    this.mrk = paramParcel.readString();
    this.mrl = paramParcel.readInt();
    this.mrm = paramParcel.readString();
    this.position = paramParcel.readInt();
    this.dAp = paramParcel.readFloat();
    this.dyz = paramParcel.readFloat();
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
    String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.mrh + '\'' + ", strategy_info=" + this.mri + ", appid='" + this.duW + '\'' + ", page_path=" + this.mrj + ", page_param=" + this.mrk + ", card_type=" + this.mrl + ", pass_str=" + this.mrm + ", position=" + this.position + ", longitude=" + this.dAp + ", latitude=" + this.dyz + ", sessionId=" + this.sessionId + '}';
    AppMethodBeat.o(123529);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123530);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.mrh);
    paramParcel.writeString(this.mri);
    paramParcel.writeString(this.duW);
    paramParcel.writeString(this.mrj);
    paramParcel.writeString(this.mrk);
    paramParcel.writeInt(this.mrl);
    paramParcel.writeString(this.mrm);
    paramParcel.writeInt(this.position);
    paramParcel.writeFloat(this.dAp);
    paramParcel.writeFloat(this.dyz);
    paramParcel.writeLong(this.sessionId);
    AppMethodBeat.o(123530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj
 * JD-Core Version:    0.7.0.1
 */