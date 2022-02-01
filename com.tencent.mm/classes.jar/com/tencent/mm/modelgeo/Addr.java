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
  public String hWY;
  public String hWZ;
  public String hXa;
  public String hXb;
  public String hXc;
  public String hXd;
  public String hXe;
  public String hXf;
  public String hXg;
  public String hXh;
  public String hXi;
  public float hXj;
  public float hXk;
  public Object tag = "";
  
  static
  {
    AppMethodBeat.i(150459);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(150459);
  }
  
  public final String aHM()
  {
    AppMethodBeat.i(150457);
    Object localObject = new StringBuilder();
    if (!bt.isNullOrNil(this.hXa)) {
      ((StringBuilder)localObject).append(this.hXa);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(bt.bI(this.hXc, "")).append(bt.bI(this.hXd, "")).append(bt.bI(this.hXe, "")).append(bt.bI(this.hXf, ""));
      ad.d("MicroMsg.Addr", "little addr res: [%s].", new Object[] { localObject });
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(150457);
      return localObject;
      if (!bt.isNullOrNil(this.hXb)) {
        ((StringBuilder)localObject).append(this.hXb);
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
    ((StringBuilder)localObject).append("address='" + this.hWY + '\'');
    ((StringBuilder)localObject).append(", country='" + this.country + '\'');
    ((StringBuilder)localObject).append(", administrative_area_level_1='" + this.hWZ + '\'');
    ((StringBuilder)localObject).append(", locality='" + this.hXa + '\'');
    ((StringBuilder)localObject).append(", locality_shi='" + this.hXb + '\'');
    ((StringBuilder)localObject).append(", sublocality='" + this.hXc + '\'');
    ((StringBuilder)localObject).append(", neighborhood='" + this.hXd + '\'');
    ((StringBuilder)localObject).append(", route='" + this.hXe + '\'');
    ((StringBuilder)localObject).append(", streetNum='" + this.hXf + '\'');
    ((StringBuilder)localObject).append(", roughAddr='" + this.hXg + '\'');
    ((StringBuilder)localObject).append(", poi_name='" + this.hXh + '\'');
    ((StringBuilder)localObject).append(", lat=" + this.hXj);
    ((StringBuilder)localObject).append(", lng=" + this.hXk);
    ((StringBuilder)localObject).append(", tag=" + this.tag);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150458);
    paramParcel.writeString(bt.bI(this.hWY, ""));
    paramParcel.writeString(bt.bI(this.country, ""));
    paramParcel.writeString(bt.bI(this.hWZ, ""));
    paramParcel.writeString(bt.bI(this.hXa, ""));
    paramParcel.writeString(bt.bI(this.hXb, ""));
    paramParcel.writeString(bt.bI(this.hXc, ""));
    paramParcel.writeString(bt.bI(this.hXd, ""));
    paramParcel.writeString(bt.bI(this.hXe, ""));
    paramParcel.writeString(bt.bI(this.hXf, ""));
    paramParcel.writeString(bt.bI(this.hXg, ""));
    paramParcel.writeString(bt.bI(this.hXh, ""));
    paramParcel.writeFloat(this.hXj);
    paramParcel.writeFloat(this.hXk);
    AppMethodBeat.o(150458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */