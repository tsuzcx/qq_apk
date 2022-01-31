package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.util.Objects;
import org.json.JSONObject;

public class FillRectActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<FillRectActionArg> CREATOR;
  public float height;
  public float width;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(103359);
    CREATOR = new FillRectActionArg.1();
    AppMethodBeat.o(103359);
  }
  
  public FillRectActionArg() {}
  
  public FillRectActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(103357);
    if (this == paramObject)
    {
      AppMethodBeat.o(103357);
      return true;
    }
    if (!(paramObject instanceof FillRectActionArg))
    {
      AppMethodBeat.o(103357);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(103357);
      return false;
    }
    paramObject = (FillRectActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0))
    {
      AppMethodBeat.o(103357);
      return true;
    }
    AppMethodBeat.o(103357);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(103354);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    AppMethodBeat.o(103354);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(103358);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height) });
    AppMethodBeat.o(103358);
    return i;
  }
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103356);
    super.p(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.d(paramJSONObject, 0);
    this.y = g.d(paramJSONObject, 1);
    this.width = g.d(paramJSONObject, 2);
    this.height = g.d(paramJSONObject, 3);
    AppMethodBeat.o(103356);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(103355);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    AppMethodBeat.o(103355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.FillRectActionArg
 * JD-Core Version:    0.7.0.1
 */