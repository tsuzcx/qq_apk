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
  public String iUO;
  public String iUP;
  public String iUQ;
  public String iUR;
  public String iUS;
  public String iUT;
  public String iUU;
  public String iUV;
  public String iUW;
  public String iUX;
  public float iUY;
  public float iUZ;
  public String request_id;
  public Object tag = "";
  
  static
  {
    AppMethodBeat.i(150459);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(150459);
  }
  
  public final String bbW()
  {
    AppMethodBeat.i(150457);
    Object localObject = new StringBuilder();
    if (!Util.isNullOrNil(this.iUQ)) {
      ((StringBuilder)localObject).append(this.iUQ);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(Util.nullAs(this.iUS, "")).append(Util.nullAs(this.iUT, "")).append(Util.nullAs(this.iUU, "")).append(Util.nullAs(this.iUV, ""));
      Log.d("MicroMsg.Addr", "little addr res: [%s].", new Object[] { localObject });
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(150457);
      return localObject;
      if (!Util.isNullOrNil(this.iUR)) {
        ((StringBuilder)localObject).append(this.iUR);
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
    ((StringBuilder)localObject).append("address='" + this.iUO + '\'');
    ((StringBuilder)localObject).append(", country='" + this.country + '\'');
    ((StringBuilder)localObject).append(", administrative_area_level_1='" + this.iUP + '\'');
    ((StringBuilder)localObject).append(", locality='" + this.iUQ + '\'');
    ((StringBuilder)localObject).append(", locality_shi='" + this.iUR + '\'');
    ((StringBuilder)localObject).append(", sublocality='" + this.iUS + '\'');
    ((StringBuilder)localObject).append(", neighborhood='" + this.iUT + '\'');
    ((StringBuilder)localObject).append(", route='" + this.iUU + '\'');
    ((StringBuilder)localObject).append(", streetNum='" + this.iUV + '\'');
    ((StringBuilder)localObject).append(", roughAddr='" + this.iUW + '\'');
    ((StringBuilder)localObject).append(", poi_name='" + this.iUX + '\'');
    ((StringBuilder)localObject).append(", lat=" + this.iUY);
    ((StringBuilder)localObject).append(", lng=" + this.iUZ);
    ((StringBuilder)localObject).append(", tag=" + this.tag);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150458);
    paramParcel.writeString(Util.nullAs(this.iUO, ""));
    paramParcel.writeString(Util.nullAs(this.country, ""));
    paramParcel.writeString(Util.nullAs(this.iUP, ""));
    paramParcel.writeString(Util.nullAs(this.iUQ, ""));
    paramParcel.writeString(Util.nullAs(this.iUR, ""));
    paramParcel.writeString(Util.nullAs(this.iUS, ""));
    paramParcel.writeString(Util.nullAs(this.iUT, ""));
    paramParcel.writeString(Util.nullAs(this.iUU, ""));
    paramParcel.writeString(Util.nullAs(this.iUV, ""));
    paramParcel.writeString(Util.nullAs(this.iUW, ""));
    paramParcel.writeString(Util.nullAs(this.iUX, ""));
    paramParcel.writeFloat(this.iUY);
    paramParcel.writeFloat(this.iUZ);
    AppMethodBeat.o(150458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */