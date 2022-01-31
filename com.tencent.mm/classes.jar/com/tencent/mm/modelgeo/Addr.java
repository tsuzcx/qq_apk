package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class Addr
  implements Parcelable
{
  public static final Parcelable.Creator<Addr> CREATOR;
  public String country;
  public String fBA;
  public float fBB;
  public float fBC;
  public String fBq;
  public String fBr;
  public String fBs;
  public String fBt;
  public String fBu;
  public String fBv;
  public String fBw;
  public String fBx;
  public String fBy;
  public String fBz;
  public Object tag = "";
  
  static
  {
    AppMethodBeat.i(78102);
    CREATOR = new Addr.1();
    AppMethodBeat.o(78102);
  }
  
  public final String agM()
  {
    AppMethodBeat.i(78100);
    String str = bo.bf(this.fBt, "") + bo.bf(this.fBu, "") + bo.bf(this.fBv, "") + bo.bf(this.fBw, "") + bo.bf(this.fBx, "");
    AppMethodBeat.o(78100);
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(78099);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("address='" + this.fBq + '\'');
    ((StringBuilder)localObject).append(", country='" + this.country + '\'');
    ((StringBuilder)localObject).append(", administrative_area_level_1='" + this.fBr + '\'');
    ((StringBuilder)localObject).append(", locality='" + this.fBs + '\'');
    ((StringBuilder)localObject).append(", locality_shi='" + this.fBt + '\'');
    ((StringBuilder)localObject).append(", sublocality='" + this.fBu + '\'');
    ((StringBuilder)localObject).append(", neighborhood='" + this.fBv + '\'');
    ((StringBuilder)localObject).append(", route='" + this.fBw + '\'');
    ((StringBuilder)localObject).append(", streetNum='" + this.fBx + '\'');
    ((StringBuilder)localObject).append(", roughAddr='" + this.fBy + '\'');
    ((StringBuilder)localObject).append(", poi_name='" + this.fBz + '\'');
    ((StringBuilder)localObject).append(", lat=" + this.fBB);
    ((StringBuilder)localObject).append(", lng=" + this.fBC);
    ((StringBuilder)localObject).append(", tag=" + this.tag);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(78099);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(78101);
    paramParcel.writeString(bo.bf(this.fBq, ""));
    paramParcel.writeString(bo.bf(this.country, ""));
    paramParcel.writeString(bo.bf(this.fBr, ""));
    paramParcel.writeString(bo.bf(this.fBs, ""));
    paramParcel.writeString(bo.bf(this.fBt, ""));
    paramParcel.writeString(bo.bf(this.fBu, ""));
    paramParcel.writeString(bo.bf(this.fBv, ""));
    paramParcel.writeString(bo.bf(this.fBw, ""));
    paramParcel.writeString(bo.bf(this.fBx, ""));
    paramParcel.writeString(bo.bf(this.fBy, ""));
    paramParcel.writeString(bo.bf(this.fBz, ""));
    paramParcel.writeFloat(this.fBB);
    paramParcel.writeFloat(this.fBC);
    AppMethodBeat.o(78101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */