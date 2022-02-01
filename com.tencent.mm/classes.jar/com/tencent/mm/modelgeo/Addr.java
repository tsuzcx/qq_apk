package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class Addr
  implements Parcelable
{
  public static final Parcelable.Creator<Addr> CREATOR;
  public String country;
  public String hEA;
  public String hEB;
  public String hEC;
  public String hED;
  public float hEE;
  public float hEF;
  public String hEt;
  public String hEu;
  public String hEv;
  public String hEw;
  public String hEx;
  public String hEy;
  public String hEz;
  public Object tag = "";
  
  static
  {
    AppMethodBeat.i(150459);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(150459);
  }
  
  public final String aEH()
  {
    AppMethodBeat.i(150457);
    Object localObject = new StringBuilder();
    if (!bs.isNullOrNil(this.hEv)) {
      ((StringBuilder)localObject).append(this.hEv);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(bs.bG(this.hEx, "")).append(bs.bG(this.hEy, "")).append(bs.bG(this.hEz, "")).append(bs.bG(this.hEA, ""));
      ac.d("MicroMsg.Addr", "little addr res: [%s].", new Object[] { localObject });
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(150457);
      return localObject;
      if (!bs.isNullOrNil(this.hEw)) {
        ((StringBuilder)localObject).append(this.hEw);
      } else {
        ac.e("MicroMsg.Addr", "wtf!!! locality & locality_shi all invalid!!!");
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
    ((StringBuilder)localObject).append("address='" + this.hEt + '\'');
    ((StringBuilder)localObject).append(", country='" + this.country + '\'');
    ((StringBuilder)localObject).append(", administrative_area_level_1='" + this.hEu + '\'');
    ((StringBuilder)localObject).append(", locality='" + this.hEv + '\'');
    ((StringBuilder)localObject).append(", locality_shi='" + this.hEw + '\'');
    ((StringBuilder)localObject).append(", sublocality='" + this.hEx + '\'');
    ((StringBuilder)localObject).append(", neighborhood='" + this.hEy + '\'');
    ((StringBuilder)localObject).append(", route='" + this.hEz + '\'');
    ((StringBuilder)localObject).append(", streetNum='" + this.hEA + '\'');
    ((StringBuilder)localObject).append(", roughAddr='" + this.hEB + '\'');
    ((StringBuilder)localObject).append(", poi_name='" + this.hEC + '\'');
    ((StringBuilder)localObject).append(", lat=" + this.hEE);
    ((StringBuilder)localObject).append(", lng=" + this.hEF);
    ((StringBuilder)localObject).append(", tag=" + this.tag);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150458);
    paramParcel.writeString(bs.bG(this.hEt, ""));
    paramParcel.writeString(bs.bG(this.country, ""));
    paramParcel.writeString(bs.bG(this.hEu, ""));
    paramParcel.writeString(bs.bG(this.hEv, ""));
    paramParcel.writeString(bs.bG(this.hEw, ""));
    paramParcel.writeString(bs.bG(this.hEx, ""));
    paramParcel.writeString(bs.bG(this.hEy, ""));
    paramParcel.writeString(bs.bG(this.hEz, ""));
    paramParcel.writeString(bs.bG(this.hEA, ""));
    paramParcel.writeString(bs.bG(this.hEB, ""));
    paramParcel.writeString(bs.bG(this.hEC, ""));
    paramParcel.writeFloat(this.hEE);
    paramParcel.writeFloat(this.hEF);
    AppMethodBeat.o(150458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */