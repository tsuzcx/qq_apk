package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.u.h;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawImageActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawImageActionArg> CREATOR = new DrawImageActionArg.1();
  public int aoT;
  public int aoU;
  public int fLE;
  public int fLF;
  public int fLG;
  public float height;
  public String url;
  public float width;
  public float x;
  public float y;
  
  public DrawImageActionArg() {}
  
  public DrawImageActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof DrawImageActionArg)) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (DrawImageActionArg)paramObject;
    } while ((this.fLE == paramObject.fLE) && (Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0) && (this.fLF == paramObject.fLF) && (this.fLG == paramObject.fLG) && (this.aoT == paramObject.aoT) && (this.aoU == paramObject.aoU) && (Objects.equals(this.url, paramObject.url)));
    return false;
  }
  
  public final void f(Parcel paramParcel)
  {
    super.f(paramParcel);
    this.fLE = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    this.fLF = paramParcel.readInt();
    this.fLG = paramParcel.readInt();
    this.aoT = paramParcel.readInt();
    this.aoU = paramParcel.readInt();
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.fLE), this.url, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.fLF), Integer.valueOf(this.fLG), Integer.valueOf(this.aoT), Integer.valueOf(this.aoU) });
  }
  
  public final void j(JSONObject paramJSONObject)
  {
    super.j(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      this.fLE = paramJSONObject.length();
      this.url = paramJSONObject.optString(0);
      this.x = h.d(paramJSONObject, 1);
      this.y = h.d(paramJSONObject, 2);
      this.width = h.d(paramJSONObject, 3);
      this.height = h.d(paramJSONObject, 4);
      this.fLF = paramJSONObject.optInt(5);
      this.fLG = paramJSONObject.optInt(6);
      this.aoT = paramJSONObject.optInt(7);
      this.aoU = paramJSONObject.optInt(8);
      return;
    }
    catch (Exception paramJSONObject)
    {
      c.printErrStackTrace("DrawImageActionArg", paramJSONObject, "", new Object[0]);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.fLE);
    paramParcel.writeString(this.url);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    paramParcel.writeInt(this.fLF);
    paramParcel.writeInt(this.fLG);
    paramParcel.writeInt(this.aoT);
    paramParcel.writeInt(this.aoU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg
 * JD-Core Version:    0.7.0.1
 */