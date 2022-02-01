package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.g;
import java.util.Objects;
import org.json.JSONObject;

public class DrawRectActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<DrawRectActionArg> CREATOR;
  public float height;
  public float width;
  public float x;
  public float y;
  
  static
  {
    AppMethodBeat.i(145028);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145028);
  }
  
  public DrawRectActionArg() {}
  
  public DrawRectActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145026);
    if (this == paramObject)
    {
      AppMethodBeat.o(145026);
      return true;
    }
    if (!(paramObject instanceof DrawRectActionArg))
    {
      AppMethodBeat.o(145026);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145026);
      return false;
    }
    paramObject = (DrawRectActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0))
    {
      AppMethodBeat.o(145026);
      return true;
    }
    AppMethodBeat.o(145026);
    return false;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(145023);
    super.h(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    AppMethodBeat.o(145023);
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145027);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height) });
    AppMethodBeat.o(145027);
    return i;
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145025);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = g.f(paramJSONObject, 0);
    this.y = g.f(paramJSONObject, 1);
    this.width = g.f(paramJSONObject, 2);
    this.height = g.f(paramJSONObject, 3);
    AppMethodBeat.o(145025);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145024);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    AppMethodBeat.o(145024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawRectActionArg
 * JD-Core Version:    0.7.0.1
 */