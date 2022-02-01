package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kje;
import org.json.JSONObject;

public class TroopBarPOI
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new kje();
  protected static final String a = "uid";
  protected static final String b = "catalog";
  protected static final String c = "name";
  protected static final String d = "longitude";
  protected static final String e = "addr";
  protected static final String f = "latitude";
  protected static final String g = "dist";
  public int a;
  public int b;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public TroopBarPOI(TroopBarPOI paramTroopBarPOI)
  {
    if (paramTroopBarPOI != null)
    {
      this.h = paramTroopBarPOI.h;
      this.i = paramTroopBarPOI.i;
      this.j = paramTroopBarPOI.j;
      this.a = paramTroopBarPOI.a;
      this.k = paramTroopBarPOI.k;
      this.b = paramTroopBarPOI.b;
      this.l = paramTroopBarPOI.l;
    }
  }
  
  public TroopBarPOI(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.a = paramInt1;
    this.k = paramString4;
    this.b = paramInt2;
    this.l = paramString5;
  }
  
  public TroopBarPOI(JSONObject paramJSONObject)
  {
    this.h = paramJSONObject.optString("uid", "");
    this.i = paramJSONObject.optString("catalog", "");
    this.j = paramJSONObject.optString("name", "");
    this.a = ((int)(paramJSONObject.optDouble("longitude", -1.0D) * 1000000.0D));
    this.k = paramJSONObject.optString("addr", "");
    this.b = ((int)(paramJSONObject.optDouble("latitude", -1.0D) * 1000000.0D));
    this.l = paramJSONObject.optString("dist", "");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopBarPOI)) {
      return ((TroopBarPOI)paramObject).h.equals(this.h);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.k);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarPOI
 * JD-Core Version:    0.7.0.1
 */