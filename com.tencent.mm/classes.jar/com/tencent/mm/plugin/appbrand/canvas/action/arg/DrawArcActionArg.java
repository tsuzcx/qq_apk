package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.g;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawArcActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawArcActionArg> CREATOR;
  public float mh;
  public float mi;
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
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.radius, this.radius) == 0) && (Float.compare(paramObject.mh, this.mh) == 0) && (Float.compare(paramObject.mi, this.mi) == 0))
    {
      AppMethodBeat.o(145012);
      return true;
    }
    AppMethodBeat.o(145012);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145009);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.radius = paramParcel.readFloat();
    this.mh = paramParcel.readFloat();
    this.mi = paramParcel.readFloat();
    AppMethodBeat.o(145009);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145013);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.radius), Float.valueOf(this.mh), Float.valueOf(this.mi) });
    AppMethodBeat.o(145013);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145010);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.f(paramJSONObject, 0);
    this.y = g.f(paramJSONObject, 1);
    this.radius = g.f(paramJSONObject, 2);
    this.mh = ((float)paramJSONObject.optDouble(3));
    this.mi = ((float)paramJSONObject.optDouble(4));
    AppMethodBeat.o(145010);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145011);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.radius);
    paramParcel.writeFloat(this.mh);
    paramParcel.writeFloat(this.mi);
    AppMethodBeat.o(145011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawArcActionArg
 * JD-Core Version:    0.7.0.1
 */