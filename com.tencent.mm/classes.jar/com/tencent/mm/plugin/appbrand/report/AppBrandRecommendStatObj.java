package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandRecommendStatObj
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandRecommendStatObj> CREATOR;
  public float dBu;
  public String dwb;
  public float dzE;
  public String mwf;
  public String mwg;
  public String mwh;
  public String mwi;
  public int mwj;
  public String mwk;
  public int position;
  public long sessionId;
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
    this.mwf = paramParcel.readString();
    this.mwg = paramParcel.readString();
    this.dwb = paramParcel.readString();
    this.mwh = paramParcel.readString();
    this.mwi = paramParcel.readString();
    this.mwj = paramParcel.readInt();
    this.mwk = paramParcel.readString();
    this.position = paramParcel.readInt();
    this.dBu = paramParcel.readFloat();
    this.dzE = paramParcel.readFloat();
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
    String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.mwf + '\'' + ", strategy_info=" + this.mwg + ", appid='" + this.dwb + '\'' + ", page_path=" + this.mwh + ", page_param=" + this.mwi + ", card_type=" + this.mwj + ", pass_str=" + this.mwk + ", position=" + this.position + ", longitude=" + this.dBu + ", latitude=" + this.dzE + ", sessionId=" + this.sessionId + '}';
    AppMethodBeat.o(123529);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123530);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.mwf);
    paramParcel.writeString(this.mwg);
    paramParcel.writeString(this.dwb);
    paramParcel.writeString(this.mwh);
    paramParcel.writeString(this.mwi);
    paramParcel.writeInt(this.mwj);
    paramParcel.writeString(this.mwk);
    paramParcel.writeInt(this.position);
    paramParcel.writeFloat(this.dBu);
    paramParcel.writeFloat(this.dzE);
    paramParcel.writeLong(this.sessionId);
    AppMethodBeat.o(123530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj
 * JD-Core Version:    0.7.0.1
 */