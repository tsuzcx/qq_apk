package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
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
    AppMethodBeat.i(145042);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145042);
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
    AppMethodBeat.i(145040);
    if (this == paramObject)
    {
      AppMethodBeat.o(145040);
      return true;
    }
    if (!(paramObject instanceof FillRectActionArg))
    {
      AppMethodBeat.o(145040);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145040);
      return false;
    }
    paramObject = (FillRectActionArg)paramObject;
    if ((Float.compare(paramObject.x, this.x) == 0) && (Float.compare(paramObject.y, this.y) == 0) && (Float.compare(paramObject.width, this.width) == 0) && (Float.compare(paramObject.height, this.height) == 0))
    {
      AppMethodBeat.o(145040);
      return true;
    }
    AppMethodBeat.o(145040);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145041);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height) });
    AppMethodBeat.o(145041);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145037);
    super.k(paramParcel);
    this.x = paramParcel.readFloat();
    this.y = paramParcel.readFloat();
    this.width = paramParcel.readFloat();
    this.height = paramParcel.readFloat();
    AppMethodBeat.o(145037);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145039);
    super.parse(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("data");
    this.x = i.f(paramJSONObject, 0);
    this.y = i.f(paramJSONObject, 1);
    this.width = i.f(paramJSONObject, 2);
    this.height = i.f(paramJSONObject, 3);
    AppMethodBeat.o(145039);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145038);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(this.y);
    paramParcel.writeFloat(this.width);
    paramParcel.writeFloat(this.height);
    AppMethodBeat.o(145038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.FillRectActionArg
 * JD-Core Version:    0.7.0.1
 */