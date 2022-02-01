package com.tencent.mm.plugin.appbrand.canvas.action.arg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class RotateActionArg
  extends BaseDrawActionArg
{
  public static final Parcelable.Creator<RotateActionArg> CREATOR;
  public float degrees;
  
  static
  {
    AppMethodBeat.i(145116);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(145116);
  }
  
  public RotateActionArg() {}
  
  public RotateActionArg(Parcel paramParcel)
  {
    super(paramParcel, (byte)0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(145114);
    if (this == paramObject)
    {
      AppMethodBeat.o(145114);
      return true;
    }
    if (!(paramObject instanceof RotateActionArg))
    {
      AppMethodBeat.o(145114);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(145114);
      return false;
    }
    if (Float.compare(((RotateActionArg)paramObject).degrees, this.degrees) == 0)
    {
      AppMethodBeat.o(145114);
      return true;
    }
    AppMethodBeat.o(145114);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(145115);
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.degrees) });
    AppMethodBeat.o(145115);
    return i;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(145111);
    super.k(paramParcel);
    this.degrees = paramParcel.readFloat();
    AppMethodBeat.o(145111);
  }
  
  public final void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145112);
    super.parse(paramJSONObject);
    this.degrees = ((float)paramJSONObject.optJSONArray("data").optDouble(0));
    AppMethodBeat.o(145112);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145113);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeFloat(this.degrees);
    AppMethodBeat.o(145113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.action.arg.RotateActionArg
 * JD-Core Version:    0.7.0.1
 */