package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawImageActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawImageActionArg> CREATOR;
  public int aLY;
  public int aLZ;
  public float height;
  public int iYX;
  public int iYY;
  public int iYZ;
  public String url;
  public float width;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145021);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145021);
  }
  
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
    AppMethodBeat.i(145019);
    if (this == paramObject)
    {
      AppMethodBeat.o(145019);
      return true;
    }
    if (!(paramObject instanceof DrawImageActionArg))
    {
      AppMethodBeat.o(145019);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145019);
      return false;
    }
    paramObject = (DrawImageActionArg)paramObject;
    if ((this.iYX == paramObject.iYX) && (Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0) && (this.iYY == paramObject.iYY) && (this.iYZ == paramObject.iYZ) && (this.aLY == paramObject.aLY) && (this.aLZ == paramObject.aLZ) && (Objects.equals(this.url, paramObject.url)))
    {
      AppMethodBeat.o(145019);
      return true;
    }
    AppMethodBeat.o(145019);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145016);
    super.h(paramParcel);
    this.iYX = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    this.iYY = paramParcel.readInt();
    this.iYZ = paramParcel.readInt();
    this.aLY = paramParcel.readInt();
    this.aLZ = paramParcel.readInt();
    AppMethodBeat.o(145016);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145020);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.iYX), this.url, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.iYY), Integer.valueOf(this.iYZ), Integer.valueOf(this.aLY), Integer.valueOf(this.aLZ) });
    AppMethodBeat.o(145020);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145017);
    super.parse(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      this.iYX = paramJSONObject.length();
      this.url = paramJSONObject.optString(0);
      this.x = g.f(paramJSONObject, 1);
      this.y = g.f(paramJSONObject, 2);
      this.width = g.f(paramJSONObject, 3);
      this.height = g.f(paramJSONObject, 4);
      this.iYY = paramJSONObject.optInt(5);
      this.iYZ = paramJSONObject.optInt(6);
      this.aLY = paramJSONObject.optInt(7);
      this.aLZ = paramJSONObject.optInt(8);
      AppMethodBeat.o(145017);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.printErrStackTrace("DrawImageActionArg", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(145017);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145018);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.iYX);
    paramParcel.writeString(this.url);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    paramParcel.writeInt(this.iYY);
    paramParcel.writeInt(this.iYZ);
    paramParcel.writeInt(this.aLY);
    paramParcel.writeInt(this.aLZ);
    AppMethodBeat.o(145018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg
 * JD-Core Version:    0.7.0.1
 */