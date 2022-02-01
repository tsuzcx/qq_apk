package com.tencent.mobileqq.troop.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kjd;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarMyBar
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new kjd();
  public static final int a = 1;
  protected static final String a = "sign_info";
  protected static final String b = "sign";
  protected static final String c = "continue";
  protected static final String d = "level";
  protected static final String e = "point";
  protected static final String f = "level";
  protected static final String g = "flag";
  protected static final String h = "pids";
  protected static final String i = "fans";
  protected static final String j = "name";
  protected static final String k = "today_pids";
  protected static final String l = "ifollowed";
  protected static final String m = "pic";
  protected static final String n = "bid";
  protected static final String o = "bar_class";
  protected static final String p = "intro";
  public static final String q = "publish_condition";
  protected static final String r = "can_publish";
  protected static final String s = "message";
  protected static final String t = "optionType";
  protected static final String u = "forbiddenType";
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public TroopBarMyBar(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString1, int paramInt8, int paramInt9, String paramString2, String paramString3, int paramInt10, String paramString4, int paramInt11, String paramString5)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
    this.h = paramInt7;
    this.v = paramString1;
    this.i = paramInt8;
    this.j = paramInt9;
    this.w = paramString2;
    this.x = paramString3;
    this.k = paramInt10;
    this.y = paramString4;
    this.l = paramInt11;
    this.z = paramString5;
  }
  
  public TroopBarMyBar(long paramLong, String paramString)
  {
    this.x = String.valueOf(paramLong);
    this.v = paramString;
  }
  
  public TroopBarMyBar(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("sign_info");
      this.b = localJSONObject.optInt("sign", -1);
      this.c = localJSONObject.optInt("continue", -1);
      try
      {
        label33:
        localJSONObject = paramJSONObject.getJSONObject("level");
        this.d = localJSONObject.optInt("point", -1);
        this.e = localJSONObject.optInt("level", -1);
        label62:
        this.f = paramJSONObject.optInt("flag", -1);
        this.g = paramJSONObject.optInt("pids", -1);
        this.h = paramJSONObject.optInt("fans", -1);
        this.v = paramJSONObject.optString("name", "");
        this.i = paramJSONObject.optInt("today_pids", -1);
        this.j = paramJSONObject.optInt("ifollowed", -1);
        this.w = paramJSONObject.optString("pic", "");
        this.x = paramJSONObject.optString("bid", "");
        this.k = paramJSONObject.optInt("bar_class", -1);
        this.y = paramJSONObject.optString("intro", "");
        try
        {
          paramJSONObject = paramJSONObject.getJSONObject("publish_condition");
          this.l = paramJSONObject.optInt("can_publish", 1);
          this.z = paramJSONObject.optString("message");
          this.m = paramJSONObject.optInt("optionType");
          this.n = paramJSONObject.optInt("forbiddenType");
          return;
        }
        catch (JSONException paramJSONObject) {}
      }
      catch (JSONException localJSONException1)
      {
        break label62;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label33;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopBarMyBar)) {
      return ((TroopBarMyBar)paramObject).x.equals(this.x);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    if (this.v == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeInt(this.i);
      paramParcel.writeInt(this.j);
      if (this.w != null) {
        break label172;
      }
      str = "";
      label97:
      paramParcel.writeString(str);
      if (this.x != null) {
        break label180;
      }
      str = "";
      label112:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.k);
      if (this.y != null) {
        break label188;
      }
      str = "";
      label135:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.l);
      if (this.z != null) {
        break label196;
      }
    }
    label172:
    label180:
    label188:
    label196:
    for (String str = "";; str = this.z)
    {
      paramParcel.writeString(str);
      return;
      str = this.v;
      break;
      str = this.w;
      break label97;
      str = this.x;
      break label112;
      str = this.y;
      break label135;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarMyBar
 * JD-Core Version:    0.7.0.1
 */