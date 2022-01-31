package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawArcActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawArcActionArg> CREATOR;
  public float heN;
  public float heO;
  public float radius;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(103331);
    CREATOR = new DrawArcActionArg.1();
    AppMethodBeat.o(103331);
  }
  
  public DrawArcActionArg() {}
  
  public DrawArcActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103329);
    if (this == paramObject)
    {
      AppMethodBeat.o(103329);
      return true;
    }
    if (!(paramObject instanceof DrawArcActionArg))
    {
      AppMethodBeat.o(103329);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103329);
      return false;
    }
    paramObject = (DrawArcActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.radius, this.radius) == 0) && (Float.compare(paramObject.heN, this.heN) == 0) && (Float.compare(paramObject.heO, this.heO) == 0))
    {
      AppMethodBeat.o(103329);
      return true;
    }
    AppMethodBeat.o(103329);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103326);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.radius = paramParcel.readFloat();
    this.heN = paramParcel.readFloat();
    this.heO = paramParcel.readFloat();
    AppMethodBeat.o(103326);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103330);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.radius), Float.valueOf(this.heN), Float.valueOf(this.heO) });
    AppMethodBeat.o(103330);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103327);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.d(paramJSONObject, 0);
    this.y = g.d(paramJSONObject, 1);
    this.radius = g.d(paramJSONObject, 2);
    this.heN = ((float)paramJSONObject.optDouble(3));
    this.heO = ((float)paramJSONObject.optDouble(4));
    AppMethodBeat.o(103327);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103328);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.radius);
    paramParcel.writeFloat(this.heN);
    paramParcel.writeFloat(this.heO);
    AppMethodBeat.o(103328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg
 * JD-Core Version:    0.7.0.1
 */