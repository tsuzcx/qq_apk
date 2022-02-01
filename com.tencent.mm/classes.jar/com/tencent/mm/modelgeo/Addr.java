package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class Addr
  implements Parcelable
{
  public static final Parcelable.Creator<Addr> CREATOR;
  public String country;
  public String oDI;
  public String oDJ;
  public String oDK;
  public String oDL;
  public String oDM;
  public String oDN;
  public String oDO;
  public String oDP;
  public String oDQ;
  public String oDR;
  public String oDS;
  public float oDT;
  public float oDU;
  public String request_id;
  public Object tag = "";
  
  static
  {
    AppMethodBeat.i(150459);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(150459);
  }
  
  public final String bJg()
  {
    AppMethodBeat.i(150457);
    Object localObject = new StringBuilder();
    if (!Util.isNullOrNil(this.oDK)) {
      ((StringBuilder)localObject).append(this.oDK);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(Util.nullAs(this.oDM, "")).append(Util.nullAs(this.oDN, "")).append(Util.nullAs(this.oDO, "")).append(Util.nullAs(this.oDP, ""));
      Log.d("MicroMsg.Addr", "little addr res: [%s].", new Object[] { localObject });
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(150457);
      return localObject;
      if (!Util.isNullOrNil(this.oDL)) {
        ((StringBuilder)localObject).append(this.oDL);
      } else {
        Log.e("MicroMsg.Addr", "wtf!!! locality & locality_shi all invalid!!!");
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
    ((StringBuilder)localObject).append("address='" + this.oDI + '\'');
    ((StringBuilder)localObject).append(", country='" + this.country + '\'');
    ((StringBuilder)localObject).append(", administrative_area_level_1='" + this.oDJ + '\'');
    ((StringBuilder)localObject).append(", locality='" + this.oDK + '\'');
    ((StringBuilder)localObject).append(", locality_shi='" + this.oDL + '\'');
    ((StringBuilder)localObject).append(", sublocality='" + this.oDM + '\'');
    ((StringBuilder)localObject).append(", neighborhood='" + this.oDN + '\'');
    ((StringBuilder)localObject).append(", route='" + this.oDO + '\'');
    ((StringBuilder)localObject).append(", streetNum='" + this.oDP + '\'');
    ((StringBuilder)localObject).append(", town='" + this.oDQ + '\'');
    ((StringBuilder)localObject).append(", roughAddr='" + this.oDR + '\'');
    ((StringBuilder)localObject).append(", poi_name='" + this.oDS + '\'');
    ((StringBuilder)localObject).append(", lat=" + this.oDT);
    ((StringBuilder)localObject).append(", lng=" + this.oDU);
    ((StringBuilder)localObject).append(", tag=" + this.tag);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150458);
    paramParcel.writeString(Util.nullAs(this.oDI, ""));
    paramParcel.writeString(Util.nullAs(this.country, ""));
    paramParcel.writeString(Util.nullAs(this.oDJ, ""));
    paramParcel.writeString(Util.nullAs(this.oDK, ""));
    paramParcel.writeString(Util.nullAs(this.oDL, ""));
    paramParcel.writeString(Util.nullAs(this.oDM, ""));
    paramParcel.writeString(Util.nullAs(this.oDN, ""));
    paramParcel.writeString(Util.nullAs(this.oDO, ""));
    paramParcel.writeString(Util.nullAs(this.oDP, ""));
    paramParcel.writeString(Util.nullAs(this.oDQ, ""));
    paramParcel.writeString(Util.nullAs(this.oDR, ""));
    paramParcel.writeString(Util.nullAs(this.oDS, ""));
    paramParcel.writeFloat(this.oDT);
    paramParcel.writeFloat(this.oDU);
    AppMethodBeat.o(150458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */