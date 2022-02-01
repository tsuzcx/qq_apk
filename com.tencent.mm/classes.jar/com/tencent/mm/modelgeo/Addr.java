package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class Addr
  implements Parcelable
{
  public static final Parcelable.Creator<Addr> CREATOR;
  public String country;
  public String hdQ;
  public String hdR;
  public String hdS;
  public String hdT;
  public String hdU;
  public String hdV;
  public String hdW;
  public String hdX;
  public String hdY;
  public String hdZ;
  public String hea;
  public float heb;
  public float hec;
  public Object tag = "";
  
  static
  {
    AppMethodBeat.i(150459);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(150459);
  }
  
  public final String axP()
  {
    AppMethodBeat.i(150457);
    Object localObject = new StringBuilder();
    if (!bt.isNullOrNil(this.hdS)) {
      ((StringBuilder)localObject).append(this.hdS);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(bt.by(this.hdU, "")).append(bt.by(this.hdV, "")).append(bt.by(this.hdW, "")).append(bt.by(this.hdX, ""));
      ad.d("MicroMsg.Addr", "little addr res: [%s].", new Object[] { localObject });
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(150457);
      return localObject;
      if (!bt.isNullOrNil(this.hdT)) {
        ((StringBuilder)localObject).append(this.hdT);
      } else {
        ad.e("MicroMsg.Addr", "wtf!!! locality & locality_shi all invalid!!!");
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(150456);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("address='" + this.hdQ + '\'');
    ((StringBuilder)localObject).append(", country='" + this.country + '\'');
    ((StringBuilder)localObject).append(", administrative_area_level_1='" + this.hdR + '\'');
    ((StringBuilder)localObject).append(", locality='" + this.hdS + '\'');
    ((StringBuilder)localObject).append(", locality_shi='" + this.hdT + '\'');
    ((StringBuilder)localObject).append(", sublocality='" + this.hdU + '\'');
    ((StringBuilder)localObject).append(", neighborhood='" + this.hdV + '\'');
    ((StringBuilder)localObject).append(", route='" + this.hdW + '\'');
    ((StringBuilder)localObject).append(", streetNum='" + this.hdX + '\'');
    ((StringBuilder)localObject).append(", roughAddr='" + this.hdY + '\'');
    ((StringBuilder)localObject).append(", poi_name='" + this.hdZ + '\'');
    ((StringBuilder)localObject).append(", lat=" + this.heb);
    ((StringBuilder)localObject).append(", lng=" + this.hec);
    ((StringBuilder)localObject).append(", tag=" + this.tag);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150458);
    paramParcel.writeString(bt.by(this.hdQ, ""));
    paramParcel.writeString(bt.by(this.country, ""));
    paramParcel.writeString(bt.by(this.hdR, ""));
    paramParcel.writeString(bt.by(this.hdS, ""));
    paramParcel.writeString(bt.by(this.hdT, ""));
    paramParcel.writeString(bt.by(this.hdU, ""));
    paramParcel.writeString(bt.by(this.hdV, ""));
    paramParcel.writeString(bt.by(this.hdW, ""));
    paramParcel.writeString(bt.by(this.hdX, ""));
    paramParcel.writeString(bt.by(this.hdY, ""));
    paramParcel.writeString(bt.by(this.hdZ, ""));
    paramParcel.writeFloat(this.heb);
    paramParcel.writeFloat(this.hec);
    AppMethodBeat.o(150458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */