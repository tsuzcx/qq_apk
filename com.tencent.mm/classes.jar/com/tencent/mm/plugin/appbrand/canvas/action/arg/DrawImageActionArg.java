package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawImageActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawImageActionArg> CREATOR;
  public int arn;
  public int aro;
  public int heP;
  public int heQ;
  public int heR;
  public float height;
  public String url;
  public float width;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(103338);
    CREATOR = new DrawImageActionArg.1();
    AppMethodBeat.o(103338);
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
    AppMethodBeat.i(103336);
    if (this == paramObject)
    {
      AppMethodBeat.o(103336);
      return true;
    }
    if (!(paramObject instanceof DrawImageActionArg))
    {
      AppMethodBeat.o(103336);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103336);
      return false;
    }
    paramObject = (DrawImageActionArg)paramObject;
    if ((this.heP == paramObject.heP) && (Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0) && (this.heQ == paramObject.heQ) && (this.heR == paramObject.heR) && (this.arn == paramObject.arn) && (this.aro == paramObject.aro) && (Objects.equals(this.url, paramObject.url)))
    {
      AppMethodBeat.o(103336);
      return true;
    }
    AppMethodBeat.o(103336);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103333);
    super.h(paramParcel);
    this.heP = paramParcel.readInt();
    this.url = paramParcel.readString();
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    this.heQ = paramParcel.readInt();
    this.heR = paramParcel.readInt();
    this.arn = paramParcel.readInt();
    this.aro = paramParcel.readInt();
    AppMethodBeat.o(103333);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103337);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Integer.valueOf(this.heP), this.url, Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.heQ), Integer.valueOf(this.heR), Integer.valueOf(this.arn), Integer.valueOf(this.aro) });
    AppMethodBeat.o(103337);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103334);
    super.p(paramJSONObject);
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray("data");
      this.heP = paramJSONObject.length();
      this.url = paramJSONObject.optString(0);
      this.x = g.d(paramJSONObject, 1);
      this.y = g.d(paramJSONObject, 2);
      this.width = g.d(paramJSONObject, 3);
      this.height = g.d(paramJSONObject, 4);
      this.heQ = paramJSONObject.optInt(5);
      this.heR = paramJSONObject.optInt(6);
      this.arn = paramJSONObject.optInt(7);
      this.aro = paramJSONObject.optInt(8);
      AppMethodBeat.o(103334);
      return;
    }
    catch (Exception paramJSONObject)
    {
      d.printErrStackTrace("DrawImageActionArg", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(103334);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103335);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.heP);
    paramParcel.writeString(this.url);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    paramParcel.writeInt(this.heQ);
    paramParcel.writeInt(this.heR);
    paramParcel.writeInt(this.arn);
    paramParcel.writeInt(this.aro);
    AppMethodBeat.o(103335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg
 * JD-Core Version:    0.7.0.1
 */