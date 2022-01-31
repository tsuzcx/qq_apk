package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandRecommendStatObj
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandRecommendStatObj> CREATOR;
  public float cAH;
  public String cwc;
  public float cyV;
  public String iFH;
  public String iFI;
  public String iFJ;
  public String iFK;
  public int iFL;
  public String iFM;
  public int position;
  public long sessionId;
  public String username;
  
  static
  {
    AppMethodBeat.i(96183);
    CREATOR = new AppBrandRecommendStatObj.1();
    AppMethodBeat.o(96183);
  }
  
  public AppBrandRecommendStatObj() {}
  
  public AppBrandRecommendStatObj(Parcel paramParcel)
  {
    AppMethodBeat.i(96180);
    this.username = paramParcel.readString();
    this.iFH = paramParcel.readString();
    this.iFI = paramParcel.readString();
    this.cwc = paramParcel.readString();
    this.iFJ = paramParcel.readString();
    this.iFK = paramParcel.readString();
    this.iFL = paramParcel.readInt();
    this.iFM = paramParcel.readString();
    this.position = paramParcel.readInt();
    this.cAH = paramParcel.readFloat();
    this.cyV = paramParcel.readFloat();
    this.sessionId = paramParcel.readLong();
    AppMethodBeat.o(96180);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(96181);
    String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.iFH + '\'' + ", strategy_info=" + this.iFI + ", appid='" + this.cwc + '\'' + ", page_path=" + this.iFJ + ", page_param=" + this.iFK + ", card_type=" + this.iFL + ", pass_str=" + this.iFM + ", position=" + this.position + ", longitude=" + this.cAH + ", latitude=" + this.cyV + ", sessionId=" + this.sessionId + '}';
    AppMethodBeat.o(96181);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96182);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.iFH);
    paramParcel.writeString(this.iFI);
    paramParcel.writeString(this.cwc);
    paramParcel.writeString(this.iFJ);
    paramParcel.writeString(this.iFK);
    paramParcel.writeInt(this.iFL);
    paramParcel.writeString(this.iFM);
    paramParcel.writeInt(this.position);
    paramParcel.writeFloat(this.cAH);
    paramParcel.writeFloat(this.cyV);
    paramParcel.writeLong(this.sessionId);
    AppMethodBeat.o(96182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj
 * JD-Core Version:    0.7.0.1
 */