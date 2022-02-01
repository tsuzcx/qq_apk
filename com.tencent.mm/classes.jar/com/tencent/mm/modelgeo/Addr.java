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
  public String lLg;
  public String lLh;
  public String lLi;
  public String lLj;
  public String lLk;
  public String lLl;
  public String lLm;
  public String lLn;
  public String lLo;
  public String lLp;
  public String lLq;
  public float lLr;
  public float lLs;
  public String request_id;
  public Object tag = "";
  
  static
  {
    AppMethodBeat.i(150459);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(150459);
  }
  
  public final String blm()
  {
    AppMethodBeat.i(150457);
    Object localObject = new StringBuilder();
    if (!Util.isNullOrNil(this.lLi)) {
      ((StringBuilder)localObject).append(this.lLi);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(Util.nullAs(this.lLk, "")).append(Util.nullAs(this.lLl, "")).append(Util.nullAs(this.lLm, "")).append(Util.nullAs(this.lLn, ""));
      Log.d("MicroMsg.Addr", "little addr res: [%s].", new Object[] { localObject });
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(150457);
      return localObject;
      if (!Util.isNullOrNil(this.lLj)) {
        ((StringBuilder)localObject).append(this.lLj);
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
    ((StringBuilder)localObject).append("address='" + this.lLg + '\'');
    ((StringBuilder)localObject).append(", country='" + this.country + '\'');
    ((StringBuilder)localObject).append(", administrative_area_level_1='" + this.lLh + '\'');
    ((StringBuilder)localObject).append(", locality='" + this.lLi + '\'');
    ((StringBuilder)localObject).append(", locality_shi='" + this.lLj + '\'');
    ((StringBuilder)localObject).append(", sublocality='" + this.lLk + '\'');
    ((StringBuilder)localObject).append(", neighborhood='" + this.lLl + '\'');
    ((StringBuilder)localObject).append(", route='" + this.lLm + '\'');
    ((StringBuilder)localObject).append(", streetNum='" + this.lLn + '\'');
    ((StringBuilder)localObject).append(", town='" + this.lLo + '\'');
    ((StringBuilder)localObject).append(", roughAddr='" + this.lLp + '\'');
    ((StringBuilder)localObject).append(", poi_name='" + this.lLq + '\'');
    ((StringBuilder)localObject).append(", lat=" + this.lLr);
    ((StringBuilder)localObject).append(", lng=" + this.lLs);
    ((StringBuilder)localObject).append(", tag=" + this.tag);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(150456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150458);
    paramParcel.writeString(Util.nullAs(this.lLg, ""));
    paramParcel.writeString(Util.nullAs(this.country, ""));
    paramParcel.writeString(Util.nullAs(this.lLh, ""));
    paramParcel.writeString(Util.nullAs(this.lLi, ""));
    paramParcel.writeString(Util.nullAs(this.lLj, ""));
    paramParcel.writeString(Util.nullAs(this.lLk, ""));
    paramParcel.writeString(Util.nullAs(this.lLl, ""));
    paramParcel.writeString(Util.nullAs(this.lLm, ""));
    paramParcel.writeString(Util.nullAs(this.lLn, ""));
    paramParcel.writeString(Util.nullAs(this.lLo, ""));
    paramParcel.writeString(Util.nullAs(this.lLp, ""));
    paramParcel.writeString(Util.nullAs(this.lLq, ""));
    paramParcel.writeFloat(this.lLr);
    paramParcel.writeFloat(this.lLs);
    AppMethodBeat.o(150458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */