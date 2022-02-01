package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandRecommendStatObj
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandRecommendStatObj> CREATOR;
  public String dNI;
  public float dTj;
  public float latitude;
  public String nHd;
  public String nHe;
  public String nHf;
  public String nHg;
  public int nHh;
  public String nHi;
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
    this.nHd = paramParcel.readString();
    this.nHe = paramParcel.readString();
    this.dNI = paramParcel.readString();
    this.nHf = paramParcel.readString();
    this.nHg = paramParcel.readString();
    this.nHh = paramParcel.readInt();
    this.nHi = paramParcel.readString();
    this.position = paramParcel.readInt();
    this.dTj = paramParcel.readFloat();
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
    String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.nHd + '\'' + ", strategy_info=" + this.nHe + ", appid='" + this.dNI + '\'' + ", page_path=" + this.nHf + ", page_param=" + this.nHg + ", card_type=" + this.nHh + ", pass_str=" + this.nHi + ", position=" + this.position + ", longitude=" + this.dTj + ", latitude=" + this.latitude + ", sessionId=" + this.sessionId + '}';
    AppMethodBeat.o(123529);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123530);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nHd);
    paramParcel.writeString(this.nHe);
    paramParcel.writeString(this.dNI);
    paramParcel.writeString(this.nHf);
    paramParcel.writeString(this.nHg);
    paramParcel.writeInt(this.nHh);
    paramParcel.writeString(this.nHi);
    paramParcel.writeInt(this.position);
    paramParcel.writeFloat(this.dTj);
    paramParcel.writeFloat(this.latitude);
    paramParcel.writeLong(this.sessionId);
    AppMethodBeat.o(123530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj
 * JD-Core Version:    0.7.0.1
 */