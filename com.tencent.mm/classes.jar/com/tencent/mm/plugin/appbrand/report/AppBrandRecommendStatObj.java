package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandRecommendStatObj
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandRecommendStatObj> CREATOR;
  public String djj;
  public float dmL;
  public float doB;
  public String lRr;
  public String lRs;
  public String lRt;
  public String lRu;
  public int lRv;
  public String lRw;
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
    this.lRr = paramParcel.readString();
    this.lRs = paramParcel.readString();
    this.djj = paramParcel.readString();
    this.lRt = paramParcel.readString();
    this.lRu = paramParcel.readString();
    this.lRv = paramParcel.readInt();
    this.lRw = paramParcel.readString();
    this.position = paramParcel.readInt();
    this.doB = paramParcel.readFloat();
    this.dmL = paramParcel.readFloat();
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
    String str = "AppBrandRecommendStatObj{username=" + this.username + ", recommend_id='" + this.lRr + '\'' + ", strategy_info=" + this.lRs + ", appid='" + this.djj + '\'' + ", page_path=" + this.lRt + ", page_param=" + this.lRu + ", card_type=" + this.lRv + ", pass_str=" + this.lRw + ", position=" + this.position + ", longitude=" + this.doB + ", latitude=" + this.dmL + ", sessionId=" + this.sessionId + '}';
    AppMethodBeat.o(123529);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123530);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.lRr);
    paramParcel.writeString(this.lRs);
    paramParcel.writeString(this.djj);
    paramParcel.writeString(this.lRt);
    paramParcel.writeString(this.lRu);
    paramParcel.writeInt(this.lRv);
    paramParcel.writeString(this.lRw);
    paramParcel.writeInt(this.position);
    paramParcel.writeFloat(this.doB);
    paramParcel.writeFloat(this.dmL);
    paramParcel.writeLong(this.sessionId);
    AppMethodBeat.o(123530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj
 * JD-Core Version:    0.7.0.1
 */