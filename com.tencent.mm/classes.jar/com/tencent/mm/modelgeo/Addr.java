package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class Addr
  implements Parcelable
{
  public static final Parcelable.Creator<Addr> CREATOR;
  public String country;
  public String hZQ;
  public String hZR;
  public String hZS;
  public String hZT;
  public String hZU;
  public String hZV;
  public String hZW;
  public String hZX;
  public String hZY;
  public String hZZ;
  public String iaa;
  public float iab;
  public float iac;
  public Object tag = "";
  
  static
  {
    AppMethodBeat.i(150459);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(150459);
  }
  
  public final String aId()
  {
    AppMethodBeat.i(150457);
    Object localObject = new StringBuilder();
    if (!bu.isNullOrNil(this.hZS)) {
      ((StringBuilder)localObject).append(this.hZS);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(bu.bI(this.hZU, "")).append(bu.bI(this.hZV, "")).append(bu.bI(this.hZW, "")).append(bu.bI(this.hZX, ""));
      ae.d("MicroMsg.Addr", "little addr res: [%s].", new Object[] { localObject });
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(150457);
      return localObject;
      if (!bu.isNullOrNil(this.hZT)) {
        ((StringBuilder)localObject).append(this.hZT);
      } else {
        ae.e("MicroMsg.Addr", "wtf!!! locality & locality_shi all invalid!!!");
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
    ((StringBuilder)localObject).append("address='" + this.hZQ + '\'');
    ((StringBuilder)localObject).append(", country='" + this.country + '\'');
    ((StringBuilder)localObject).append(", administrative_area_level_1='" + this.hZR + '\'');
    ((StringBuilder)localObject).append(", locality='" + this.hZS + '\'');
    ((StringBuilder)localObject).append(", locality_shi='" + this.hZT + '\'');
    ((StringBuilder)localObject).append(", sublocality='" + this.hZU + '\'');
    ((StringBuilder)localObject).append(", neighborhood='" + this.hZV + '\'');
    ((StringBuilder)localObject).append(", route='" + this.hZW + '\'');
    ((StringBuilder)localObject).append(", streetNum='" + this.hZX + '\'');
    ((StringBuilder)localObject).append(", roughAddr='" + this.hZY + '\'');
    ((StringBuilder)localObject).append(", poi_name='" + this.hZZ + '\'');
    ((StringBuilder)localObject).append(", lat=" + this.iab);
    ((StringBuilder)localObject).append(", lng=" + this.iac);
    ((StringBuilder)localObject).append(", tag=" + this.tag);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150458);
    paramParcel.writeString(bu.bI(this.hZQ, ""));
    paramParcel.writeString(bu.bI(this.country, ""));
    paramParcel.writeString(bu.bI(this.hZR, ""));
    paramParcel.writeString(bu.bI(this.hZS, ""));
    paramParcel.writeString(bu.bI(this.hZT, ""));
    paramParcel.writeString(bu.bI(this.hZU, ""));
    paramParcel.writeString(bu.bI(this.hZV, ""));
    paramParcel.writeString(bu.bI(this.hZW, ""));
    paramParcel.writeString(bu.bI(this.hZX, ""));
    paramParcel.writeString(bu.bI(this.hZY, ""));
    paramParcel.writeString(bu.bI(this.hZZ, ""));
    paramParcel.writeFloat(this.iab);
    paramParcel.writeFloat(this.iac);
    AppMethodBeat.o(150458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */