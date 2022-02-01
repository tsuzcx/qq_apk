package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawArcActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawArcActionArg> CREATOR;
  public float dxm;
  public float dxn;
  public float radius;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145014);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145014);
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
    AppMethodBeat.i(145012);
    if (this == paramObject)
    {
      AppMethodBeat.o(145012);
      return true;
    }
    if (!(paramObject instanceof DrawArcActionArg))
    {
      AppMethodBeat.o(145012);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145012);
      return false;
    }
    paramObject = (DrawArcActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.radius, this.radius) == 0) && (Float.compare(paramObject.dxm, this.dxm) == 0) && (Float.compare(paramObject.dxn, this.dxn) == 0))
    {
      AppMethodBeat.o(145012);
      return true;
    }
    AppMethodBeat.o(145012);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145013);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.radius), Float.valueOf(this.dxm), Float.valueOf(this.dxn) });
    AppMethodBeat.o(145013);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145009);
    super.k(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.radius = paramParcel.readFloat();
    this.dxm = paramParcel.readFloat();
    this.dxn = paramParcel.readFloat();
    AppMethodBeat.o(145009);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145010);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = i.f(paramJSONObject, 0);
    this.y = i.f(paramJSONObject, 1);
    this.radius = i.f(paramJSONObject, 2);
    this.dxm = ((float)paramJSONObject.optDouble(3));
    this.dxn = ((float)paramJSONObject.optDouble(4));
    AppMethodBeat.o(145010);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145011);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.radius);
    paramParcel.writeFloat(this.dxm);
    paramParcel.writeFloat(this.dxn);
    AppMethodBeat.o(145011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg
 * JD-Core Version:    0.7.0.1
 */