package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;

public class Addr
  implements Parcelable
{
  public static final Parcelable.Creator<Addr> CREATOR = new Addr.1();
  public String country;
  public String ekZ;
  public String ela;
  public String elb;
  public String elc;
  public String eld;
  public String ele;
  public String elf;
  public String elg;
  public String elh;
  public String eli;
  public String elj;
  public float elk;
  public float ell;
  public Object tag = "";
  
  public final String NY()
  {
    return bk.aM(this.elc, "") + bk.aM(this.eld, "") + bk.aM(this.ele, "") + bk.aM(this.elf, "") + bk.aM(this.elg, "");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("address='" + this.ekZ + '\'');
    localStringBuilder.append(", country='" + this.country + '\'');
    localStringBuilder.append(", administrative_area_level_1='" + this.ela + '\'');
    localStringBuilder.append(", locality='" + this.elb + '\'');
    localStringBuilder.append(", locality_shi='" + this.elc + '\'');
    localStringBuilder.append(", sublocality='" + this.eld + '\'');
    localStringBuilder.append(", neighborhood='" + this.ele + '\'');
    localStringBuilder.append(", route='" + this.elf + '\'');
    localStringBuilder.append(", streetNum='" + this.elg + '\'');
    localStringBuilder.append(", roughAddr='" + this.elh + '\'');
    localStringBuilder.append(", poi_name='" + this.eli + '\'');
    localStringBuilder.append(", lat=" + this.elk);
    localStringBuilder.append(", lng=" + this.ell);
    localStringBuilder.append(", tag=" + this.tag);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(bk.aM(this.ekZ, ""));
    paramParcel.writeString(bk.aM(this.country, ""));
    paramParcel.writeString(bk.aM(this.ela, ""));
    paramParcel.writeString(bk.aM(this.elb, ""));
    paramParcel.writeString(bk.aM(this.elc, ""));
    paramParcel.writeString(bk.aM(this.eld, ""));
    paramParcel.writeString(bk.aM(this.ele, ""));
    paramParcel.writeString(bk.aM(this.elf, ""));
    paramParcel.writeString(bk.aM(this.elg, ""));
    paramParcel.writeString(bk.aM(this.elh, ""));
    paramParcel.writeString(bk.aM(this.eli, ""));
    paramParcel.writeFloat(this.elk);
    paramParcel.writeFloat(this.ell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.Addr
 * JD-Core Version:    0.7.0.1
 */